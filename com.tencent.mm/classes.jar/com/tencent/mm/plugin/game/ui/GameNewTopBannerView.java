package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.g;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.d.c;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;

public class GameNewTopBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  int IFc;
  ImageView IOd;
  ImageView IOe;
  int ITL;
  int ITM;
  String ITN = "";
  private String ITO = "";
  Context mContext;
  String ryZ = null;
  
  public GameNewTopBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  static void fHC()
  {
    AppMethodBeat.i(42321);
    GameIndexListView.setDefaultPadding(0);
    GameIndexListView.setInitPadding(0);
    GameIndexListView.setCanPulldown(false);
    AppMethodBeat.o(42321);
  }
  
  final int c(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(42319);
    int i = c.getScreenWidth(this.mContext);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (localLayoutParams == null)
    {
      Log.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
      AppMethodBeat.o(42319);
      return 0;
    }
    float f = paramInt1 / paramInt2;
    localLayoutParams.height = ((int)(i * f));
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramInt1 = localLayoutParams.height;
    AppMethodBeat.o(42319);
    return paramInt1;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(42320);
    b localb = new b();
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/game/ui/GameNewTopBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!Util.isNullOrNil(paramView))
      {
        int i = c.I(this.mContext, paramView, "game_center_top_banner");
        g.a(this.mContext, 10, 1017, 1, i, 0, null, this.IFc, 0, null, null, this.ryZ);
      }
    }
    a.a(this, "com/tencent/mm/plugin/game/ui/GameNewTopBannerView", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(42320);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42318);
    super.onFinishInflate();
    this.IOd = ((ImageView)findViewById(h.e.HTA));
    this.IOe = ((ImageView)findViewById(h.e.HXN));
    Log.i("MicroMsg.GameTopBannerView", "initView finished");
    AppMethodBeat.o(42318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewTopBannerView
 * JD-Core Version:    0.7.0.1
 */