package com.tencent.mm.plugin.location.ui;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;

public final class e
  extends ImageView
{
  private static int ocv;
  private final String TAG;
  private double bnp;
  public b.a dZA;
  private boolean isRunning;
  private Activity mActivity;
  private b.a ocm;
  private Bitmap ocn;
  private boolean oco;
  private double ocp;
  private double ocq;
  public com.tencent.mm.modelgeo.d ocr;
  private com.tencent.mm.plugin.k.d ocs;
  private boolean oct;
  private final int ocu;
  private boolean ocw;
  
  public e(Activity paramActivity, com.tencent.mm.plugin.k.d paramd)
  {
    super(paramActivity);
    AppMethodBeat.i(113457);
    this.TAG = "MicroMsg.MyPoiPoint";
    this.oct = false;
    this.ocu = 689208551;
    this.ocw = false;
    this.dZA = new e.1(this);
    this.ocs = paramd;
    this.ocm = null;
    this.mActivity = paramActivity;
    this.ocn = com.tencent.mm.sdk.platformtools.d.Na(2130839958);
    this.isRunning = false;
    this.oco = false;
    this.ocr = com.tencent.mm.modelgeo.d.agQ();
    ocv = BackwardSupportUtil.b.b(paramActivity, 80.0F);
    setImageResource(2130839958);
    setScaleType(ImageView.ScaleType.FIT_CENTER);
    ab.d("MicroMsg.MyPoiPoint", "enableLocation");
    this.isRunning = true;
    this.ocr.a(this.dZA);
    AppMethodBeat.o(113457);
  }
  
  protected final void onDraw(Canvas paramCanvas)
  {
    AppMethodBeat.i(113458);
    super.onDraw(paramCanvas);
    ab.d("MicroMsg.MyPoiPoint", "onDraw");
    AppMethodBeat.o(113458);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.e
 * JD-Core Version:    0.7.0.1
 */