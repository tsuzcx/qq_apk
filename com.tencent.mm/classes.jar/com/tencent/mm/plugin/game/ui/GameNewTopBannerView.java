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
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public class GameNewTopBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  String hyG = null;
  Context mContext;
  int nCb;
  int nCc;
  String nCd = "";
  private String nCe = "";
  int nok;
  ImageView nwo;
  ImageView nwp;
  
  public GameNewTopBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  static void bHv()
  {
    AppMethodBeat.i(112124);
    GameIndexListView.setDefaultPadding(0);
    GameIndexListView.setInitPadding(0);
    GameIndexListView.setCanPulldown(false);
    AppMethodBeat.o(112124);
  }
  
  final int b(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(112122);
    int i = com.tencent.mm.plugin.game.f.c.getScreenWidth(this.mContext);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (localLayoutParams == null)
    {
      ab.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
      AppMethodBeat.o(112122);
      return 0;
    }
    float f = paramInt1 / paramInt2;
    localLayoutParams.height = ((int)(i * f));
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    paramInt1 = localLayoutParams.height;
    AppMethodBeat.o(112122);
    return paramInt1;
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(112123);
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!bo.isNullOrNil(paramView))
      {
        int i = com.tencent.mm.plugin.game.f.c.t(this.mContext, paramView, "game_center_top_banner");
        com.tencent.mm.game.report.c.a(this.mContext, 10, 1017, 1, i, 0, null, this.nok, 0, null, null, this.hyG);
      }
    }
    AppMethodBeat.o(112123);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(112121);
    super.onFinishInflate();
    this.nwo = ((ImageView)findViewById(2131824614));
    this.nwp = ((ImageView)findViewById(2131824663));
    ab.i("MicroMsg.GameTopBannerView", "initView finished");
    AppMethodBeat.o(112121);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewTopBannerView
 * JD-Core Version:    0.7.0.1
 */