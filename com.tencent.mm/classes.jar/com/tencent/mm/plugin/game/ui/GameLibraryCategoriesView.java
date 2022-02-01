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
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView
  extends LinearLayout
  implements View.OnClickListener
{
  private int hC;
  private Context mContext;
  private LinearLayout tmh;
  private int vXu;
  private int xGR;
  
  public GameLibraryCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42200);
    Object localObject1 = new b();
    ((b)localObject1).bm(paramView);
    com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).axR());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42200);
      return;
    }
    paramView = (a)paramView.getTag();
    int i = 7;
    if (!Util.isNullOrNil(paramView.xTA)) {
      c.aQ(this.mContext, paramView.xTA);
    }
    for (;;)
    {
      f.a(this.mContext, 11, paramView.xTz + 100, paramView.position, i, this.xGR, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42200);
      return;
      Object localObject2 = new Intent(this.mContext, GameCategoryUI.class);
      ((Intent)localObject2).putExtra("extra_type", 1);
      ((Intent)localObject2).putExtra("extra_category_id", paramView.xTz);
      ((Intent)localObject2).putExtra("extra_category_name", paramView.xjU);
      ((Intent)localObject2).putExtra("game_report_from_scene", paramView.xTz + 100);
      localObject1 = this.mContext;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().bl(localObject2);
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).axQ(), "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject1, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 6;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42198);
    super.onFinishInflate();
    this.tmh = ((LinearLayout)findViewById(2131302012));
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.hC = (i * 100 / 750);
    this.vXu = ((i - this.hC * 6) / 14);
    this.tmh.setPadding(this.vXu, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12), this.vXu, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 12));
    AppMethodBeat.o(42198);
  }
  
  public void setData(LinkedList<a> paramLinkedList)
  {
    AppMethodBeat.i(42199);
    if ((paramLinkedList == null) || (paramLinkedList.size() == 0))
    {
      Log.e("MicroMsg.GameLibraryCategoriesView", "No categories");
      setVisibility(8);
      AppMethodBeat.o(42199);
      return;
    }
    setVisibility(0);
    this.tmh.removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (a)paramLinkedList.next();
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      Object localObject2 = new ImageView(this.mContext);
      Object localObject3 = ImageView.ScaleType.MATRIX;
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = q.bcV();
      String str = ((a)localObject1).kVZ;
      c.a locala = new c.a();
      locala.jbe = true;
      ((com.tencent.mm.av.a.a)localObject3).a(str, (ImageView)localObject2, locala.bdv());
      localLinearLayout.addView((View)localObject2, this.hC, this.hC);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setText(((a)localObject1).xjU);
      ((TextView)localObject2).setTextSize(1, 14.0F);
      ((TextView)localObject2).setTextColor(getResources().getColor(2131100594));
      ((TextView)localObject2).setSingleLine(true);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject2).setPadding(0, com.tencent.mm.cb.a.fromDPToPix(this.mContext, 6), 0, 0);
      localLinearLayout.addView((View)localObject2);
      localLinearLayout.setTag(localObject1);
      localLinearLayout.setOnClickListener(this);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.vXu, 0, this.vXu, 0);
      this.tmh.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(42199);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.xGR = paramInt;
  }
  
  public static final class a
  {
    public String kVZ;
    public int position;
    public String xTA;
    public int xTz;
    public String xjU;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView
 * JD-Core Version:    0.7.0.1
 */