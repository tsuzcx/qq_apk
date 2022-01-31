package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.plugin.game.g.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

public class GameNewTopBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  String ghS = null;
  int kQh;
  ImageView kYq;
  ImageView kYr;
  int leg;
  int leh;
  String lei = "";
  private String lej = "";
  Context mContext;
  
  public GameNewTopBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  static void bap()
  {
    GameIndexListView.setDefaultPadding(0);
    GameIndexListView.setInitPadding(0);
    GameIndexListView.setCanPulldown(false);
  }
  
  final int b(ImageView paramImageView, int paramInt1, int paramInt2)
  {
    int i = c.getScreenWidth(this.mContext);
    ViewGroup.LayoutParams localLayoutParams = paramImageView.getLayoutParams();
    if (localLayoutParams == null)
    {
      y.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
      return 0;
    }
    float f = paramInt1 / paramInt2;
    localLayoutParams.height = ((int)(i * f));
    paramImageView.setLayoutParams(localLayoutParams);
    paramImageView.setScaleType(ImageView.ScaleType.FIT_XY);
    return localLayoutParams.height;
  }
  
  public void onClick(View paramView)
  {
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!bk.bl(paramView))
      {
        int i = c.o(this.mContext, paramView, "game_center_top_banner");
        b.a(this.mContext, 10, 1017, 1, i, 0, null, this.kQh, 0, null, null, this.ghS);
      }
    }
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    this.kYq = ((ImageView)findViewById(g.e.big_image));
    this.kYr = ((ImageView)findViewById(g.e.small_image));
    y.i("MicroMsg.GameTopBannerView", "initView finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewTopBannerView
 * JD-Core Version:    0.7.0.1
 */