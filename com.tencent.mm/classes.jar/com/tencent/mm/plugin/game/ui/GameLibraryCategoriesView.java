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
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.modelimage.loader.a.c.a;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.b;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public class GameLibraryCategoriesView
  extends LinearLayout
  implements View.OnClickListener
{
  private int ALs;
  private LinearLayout Api;
  private int IFc;
  private int iconSize;
  private Context mContext;
  
  public GameLibraryCategoriesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42200);
    Object localObject1 = new b();
    ((b)localObject1).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject1).aYj());
    if (!(paramView.getTag() instanceof a))
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42200);
      return;
    }
    paramView = (a)paramView.getTag();
    int i = 7;
    if (!Util.isNullOrNil(paramView.ISb)) {
      c.ba(this.mContext, paramView.ISb);
    }
    for (;;)
    {
      g.a(this.mContext, 11, paramView.ISa + 100, paramView.position, i, this.IFc, null);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(42200);
      return;
      Object localObject2 = new Intent(this.mContext, GameCategoryUI.class);
      ((Intent)localObject2).putExtra("extra_type", 1);
      ((Intent)localObject2).putExtra("extra_category_id", paramView.ISa);
      ((Intent)localObject2).putExtra("extra_category_name", paramView.HIH);
      ((Intent)localObject2).putExtra("game_report_from_scene", paramView.ISa + 100);
      localObject1 = this.mContext;
      localObject2 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject2);
      com.tencent.mm.hellhoundlib.a.a.b(localObject1, ((com.tencent.mm.hellhoundlib.b.a)localObject2).aYi(), "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Context)localObject1).startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject2).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(localObject1, "com/tencent/mm/plugin/game/ui/GameLibraryCategoriesView", "onClick", "(Landroid/view/View;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      i = 6;
    }
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42198);
    super.onFinishInflate();
    this.Api = ((LinearLayout)findViewById(h.e.HVR));
    int i = ((WindowManager)this.mContext.getSystemService("window")).getDefaultDisplay().getWidth();
    this.iconSize = (i * 100 / 750);
    this.ALs = ((i - this.iconSize * 6) / 14);
    this.Api.setPadding(this.ALs, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12), this.ALs, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 12));
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
    this.Api.removeAllViews();
    paramLinkedList = paramLinkedList.iterator();
    while (paramLinkedList.hasNext())
    {
      Object localObject1 = (a)paramLinkedList.next();
      LinearLayout localLinearLayout = new LinearLayout(this.mContext);
      localLinearLayout.setOrientation(1);
      Object localObject2 = new ImageView(this.mContext);
      Object localObject3 = ImageView.ScaleType.MATRIX;
      ((ImageView)localObject2).setScaleType(ImageView.ScaleType.FIT_XY);
      localObject3 = r.bKe();
      String str = ((a)localObject1).qQb;
      c.a locala = new c.a();
      locala.oKo = true;
      ((com.tencent.mm.modelimage.loader.a)localObject3).a(str, (ImageView)localObject2, locala.bKx());
      localLinearLayout.addView((View)localObject2, this.iconSize, this.iconSize);
      localObject2 = new TextView(this.mContext);
      ((TextView)localObject2).setText(((a)localObject1).HIH);
      ((TextView)localObject2).setTextSize(1, 14.0F);
      ((TextView)localObject2).setTextColor(getResources().getColor(h.b.hint_text_color));
      ((TextView)localObject2).setSingleLine(true);
      ((TextView)localObject2).setEllipsize(TextUtils.TruncateAt.END);
      ((TextView)localObject2).setGravity(17);
      ((TextView)localObject2).setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      ((TextView)localObject2).setPadding(0, com.tencent.mm.cd.a.fromDPToPix(this.mContext, 6), 0, 0);
      localLinearLayout.addView((View)localObject2);
      localLinearLayout.setTag(localObject1);
      localLinearLayout.setOnClickListener(this);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      ((LinearLayout.LayoutParams)localObject1).setMargins(this.ALs, 0, this.ALs, 0);
      this.Api.addView(localLinearLayout, (ViewGroup.LayoutParams)localObject1);
    }
    AppMethodBeat.o(42199);
  }
  
  public void setSourceScene(int paramInt)
  {
    this.IFc = paramInt;
  }
  
  public static final class a
  {
    public String HIH;
    public int ISa;
    public String ISb;
    public int position;
    public String qQb;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameLibraryCategoriesView
 * JD-Core Version:    0.7.0.1
 */