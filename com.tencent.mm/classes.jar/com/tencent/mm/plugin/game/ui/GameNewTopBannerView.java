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
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;

public class GameNewTopBannerView
  extends FrameLayout
  implements View.OnClickListener
{
  String jYy = null;
  Context mContext;
  int tfA;
  ImageView tnI;
  ImageView tnJ;
  int ttu;
  int ttv;
  String ttw = "";
  private String ttx = "";
  
  public GameNewTopBannerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.mContext = paramContext;
  }
  
  static void cRB()
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
      ac.e("MicroMsg.GameTopBannerView", "resizeGameThemePic, params is null");
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
    if ((paramView.getTag() != null) && ((paramView.getTag() instanceof String)))
    {
      paramView = (String)paramView.getTag();
      if (!bs.isNullOrNil(paramView))
      {
        int i = c.z(this.mContext, paramView, "game_center_top_banner");
        e.a(this.mContext, 10, 1017, 1, i, 0, null, this.tfA, 0, null, null, this.jYy);
      }
    }
    AppMethodBeat.o(42320);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(42318);
    super.onFinishInflate();
    this.tnI = ((ImageView)findViewById(2131297217));
    this.tnJ = ((ImageView)findViewById(2131304853));
    ac.i("MicroMsg.GameTopBannerView", "initView finished");
    AppMethodBeat.o(42318);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameNewTopBannerView
 * JD-Core Version:    0.7.0.1
 */