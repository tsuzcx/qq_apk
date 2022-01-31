package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.mm.modelgeo.a.a;
import com.tencent.mm.plugin.p.d;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.y;

public final class e
  extends ImageView
{
  private static int lFh;
  private final String TAG = "MicroMsg.MyPoiPoint";
  private double aWI;
  public a.a dig = new e.1(this);
  private boolean isRunning;
  private a.a lEY;
  private Bitmap lEZ;
  private boolean lFa;
  private double lFb;
  private double lFc;
  public com.tencent.mm.modelgeo.c lFd;
  private d lFe;
  private boolean lFf = false;
  private final int lFg = 689208551;
  private boolean lFi = false;
  private Activity mActivity;
  
  public e(Activity paramActivity, int paramInt, d paramd)
  {
    super(paramActivity);
    this.lFe = paramd;
    this.lEY = null;
    this.mActivity = paramActivity;
    this.lEZ = com.tencent.mm.sdk.platformtools.c.EX(paramInt);
    this.isRunning = false;
    this.lFa = false;
    this.lFd = com.tencent.mm.modelgeo.c.Ob();
    lFh = BackwardSupportUtil.b.b(paramActivity, 80.0F);
    setImageResource(paramInt);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
    y.d("MicroMsg.MyPoiPoint", "enableLocation");
    this.isRunning = true;
    this.lFd.a(this.dig);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    y.d("MicroMsg.MyPoiPoint", "onDraw");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */