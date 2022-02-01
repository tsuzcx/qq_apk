package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.Display;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aw.a.a.c.a;
import com.tencent.mm.aw.o;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView
  extends LinearLayout
  implements View.OnClickListener
{
  private int eI;
  private Context mContext;
  private int qSX;
  private LinearLayout qlu;
  private int rXI;
  
  public GameLibraryCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42200);
    if (!(paramView.getTag() instanceof a))
    {
      AppMethodBeat.o(42200);
      return;
    }
    paramView = (a)paramView.getTag();
    int i = 7;
    if (!bt.isNullOrNil(paramView.sjQ)) {
      c.ax(this.mContext, paramView.sjQ);
    }
    for (;;)
    {
      e.a(this.mContext, 11, paramView.sjP + 100, paramView.position, i, this.rXI, null);
      AppMethodBeat.o(42200);
      return;
      Object localObject = new Intent(this.mContext, GameCategoryUI.class);
      ((Intent)localObject).putExtra("extra_type", 1);
      ((Intent)localObject).putExtra("extra_category_id", paramView.sjP);
      ((Intent)localObject).putExtra("extra_category_name", paramView.rCn);
      ((Intent)localObject).putExtra("game_report_from_scene", paramView.sjP + 100);
      Context localContext = this.mContext;
      localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
      com.tencent.mm.hellhoundlib.a.a.a(localContext, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localContext.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(localContext, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 6;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42198);
    super.onFinishInflate();
    this.qlu = ((LinearLayout)findViewById(2131300489));
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.eI = (i * 100 / 750);
    this.qSX = ((i - this.eI * 6) / 14);
    this.qlu.setPadding(this.qSX, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12), this.qSX, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12));
    AppMethodBeat.o(42198);
  }
  
  public void setData(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(42199);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      ad.e("MicroMsg.GameLibraryCategoriesView", "No categories");
      setVisibility(8);
      AppMethodBeat.o(42199);
      return;
    }
    setVisibility(0);
    this.qlu.removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (a)paramLinkedList.next();
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      Object localObject2 = new ImageView(this.mContext);
      Object localObject3 = ImageView.ScaleType.MATRIX;
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = o.ayJ();
      String str = ((a)localObject1).iVP;
      c.a locala = new c.a();
      locala.hjT = true;
      ((com.tencent.mm.aw.a.a)localObject3).a(str, (ImageView)localObject2, locala.azc());
      localLinearLayout.addView((View)localObject2, this.eI, this.eI);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setText(((a)localObject1).rCn);
      ((TextView)localObject2).setTextSize(1, 14.0F);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131100490));
      ((TextView)localObject2).setSingleLine(true);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject2).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 6), 0, 0);
      localLinearLayout.addView((View)localObject2);
      localLinearLayout.setTag(localObject1);
      localLinearLayout.setOnClickListener(this);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.qSX, 0, this.qSX, 0);
      this.qlu.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(42199);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.rXI = paramInt;
  }
  
  public static final class a
  {
    public String iVP;
    public int position;
    public String rCn;
    public int sjP;
    public String sjQ;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView
 * JD-Core Version:    0.7.0.1
 */