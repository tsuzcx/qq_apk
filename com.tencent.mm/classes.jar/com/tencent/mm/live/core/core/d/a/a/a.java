package com.tencent.mm.live.core.core.d.a.a;

import android.content.Context;
import android.content.res.Resources;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.opengl.Matrix;
import android.util.DisplayMetrics;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;

public final class a
{
  private static final float eLo;
  public float hbX;
  public float hbY;
  public float[] mMVPMatrix;
  private float mQA;
  private float mQB;
  private float mQC;
  private float mQD;
  private int mQE;
  public float mQF;
  public float mQG;
  public boolean mQH;
  public float mQI;
  public float mQJ;
  public float mQK;
  public float[] mQa;
  public float[] mQb;
  public float[] mQc;
  public float[] mQd;
  public float[] mQe;
  private float[] mQf;
  private float[] mQg;
  public boolean mQh;
  private boolean mQi;
  public GestureDetector mQj;
  private boolean mQk;
  public float mQl;
  public float mQm;
  private final float mQn;
  private final float mQo;
  private final float mQp;
  private final float mQq;
  public boolean mQr;
  private float[] mQs;
  private int mQt;
  public SensorEventListener mQu;
  public boolean mQv;
  public float mQw;
  public int mQx;
  public int mQy;
  private final int mQz;
  public int mViewHeight;
  public int mViewWidth;
  public float pitch;
  public WindowManager windowManager;
  public float yaw;
  
  static
  {
    AppMethodBeat.i(248168);
    eLo = Resources.getSystem().getDisplayMetrics().density;
    AppMethodBeat.o(248168);
  }
  
  public a(Context paramContext)
  {
    AppMethodBeat.i(248106);
    this.mMVPMatrix = new float[16];
    this.mQa = new float[16];
    this.mQb = new float[16];
    this.mQc = new float[16];
    this.mQd = new float[16];
    this.mQe = new float[16];
    this.mQf = new float[4];
    this.mQg = new float[3];
    this.mQh = false;
    this.mQi = true;
    this.mQj = null;
    this.mQk = true;
    this.mQl = 35.0F;
    this.mQm = 35.0F;
    this.mQn = 65.0F;
    this.mQo = 20.0F;
    this.mQp = 65.0F;
    this.mQq = 20.0F;
    this.mQr = false;
    this.mQs = new float[16];
    this.mQt = 11;
    this.mQv = false;
    this.mQw = 0.0F;
    this.mQx = 0;
    this.mQy = 0;
    this.mQz = 10;
    this.hbX = 0.0F;
    this.hbY = 0.0F;
    this.mQA = 90.0F;
    this.mQB = -90.0F;
    this.mQC = 1.0F;
    this.mQD = 1.0F;
    this.mQE = 0;
    this.mQF = 2.0F;
    this.mQG = 0.5F;
    this.mQH = true;
    this.mQI = 1.0F;
    this.mQJ = -1.0F;
    this.mQK = 1.0F;
    this.pitch = 0.0F;
    this.yaw = 0.0F;
    Matrix.setIdentityM(this.mQe, 0);
    Matrix.setIdentityM(this.mQb, 0);
    Matrix.setLookAtM(this.mQc, 0, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    Matrix.frustumM(this.mQd, 0, -1.0F, 1.0F, -1.0F, 1.0F, 1.4F, 500.0F);
    this.mQj = new GestureDetector(paramContext, new GestureDetector.SimpleOnGestureListener()
    {
      public final boolean onContextClick(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(248132);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onContextClick(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onContextClick", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(248132);
        return bool;
      }
      
      public final boolean onDoubleTap(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(248123);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onDoubleTap(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onDoubleTap", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(248123);
        return bool;
      }
      
      public final void onLongPress(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(248117);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V", this, localb.aYj());
        super.onLongPress(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onLongPress", "(Landroid/view/MotionEvent;)V");
        AppMethodBeat.o(248117);
      }
      
      public final boolean onScroll(MotionEvent paramAnonymousMotionEvent1, MotionEvent paramAnonymousMotionEvent2, float paramAnonymousFloat1, float paramAnonymousFloat2)
      {
        AppMethodBeat.i(248102);
        if (!a.a(a.this))
        {
          AppMethodBeat.o(248102);
          return false;
        }
        float f1 = a.a(a.this, paramAnonymousFloat1);
        paramAnonymousFloat2 = a.a(a.this, paramAnonymousFloat2);
        paramAnonymousMotionEvent1 = a.this;
        paramAnonymousFloat1 = a.this.hbX;
        f1 /= a.beI();
        float f2 = a.this.hbY;
        paramAnonymousFloat2 /= a.beI();
        if (paramAnonymousMotionEvent1.mQh)
        {
          paramAnonymousMotionEvent1.hbX = (paramAnonymousFloat1 - f1 * 0.2F);
          paramAnonymousMotionEvent1.hbY = (f2 - paramAnonymousFloat2 * 0.2F);
        }
        AppMethodBeat.o(248102);
        return true;
      }
      
      public final boolean onSingleTapUp(MotionEvent paramAnonymousMotionEvent)
      {
        AppMethodBeat.i(248110);
        b localb = new b();
        localb.cH(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", this, localb.aYj());
        boolean bool = super.onSingleTapUp(paramAnonymousMotionEvent);
        com.tencent.mm.hellhoundlib.a.a.a(bool, this, "com/tencent/mm/live/core/core/postprocessor/customrender/vrrendertool/RotationControl$1", "android/view/GestureDetector$SimpleOnGestureListener", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(248110);
        return bool;
      }
    });
    AppMethodBeat.o(248106);
  }
  
  public static float p(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(248111);
    paramFloat1 = (float)Math.sqrt(Math.pow(paramFloat1 - paramFloat3, 2.0D) + Math.pow(paramFloat2 - paramFloat4, 2.0D));
    AppMethodBeat.o(248111);
    return paramFloat1;
  }
  
  public final void o(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    AppMethodBeat.i(248172);
    Matrix.frustumM(this.mQd, 0, paramFloat1, paramFloat2, paramFloat3, paramFloat4, 1.0F, 500.0F);
    AppMethodBeat.o(248172);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.live.core.core.d.a.a.a
 * JD-Core Version:    0.7.0.1
 */