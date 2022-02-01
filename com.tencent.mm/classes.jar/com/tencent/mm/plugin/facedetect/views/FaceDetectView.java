package com.tencent.mm.plugin.facedetect.views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.FaceProNative.FaceResult;
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.plugin.facedetect.model.q;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;

public class FaceDetectView
  extends RelativeLayout
{
  public static long rwi = 100L;
  public static int rwj = 1;
  public volatile boolean hkx;
  public boolean isPaused;
  public long rpz;
  public String rsD;
  private TextView rth;
  public FaceDetectCameraView rvS;
  public FaceDetectDecorView rvT;
  public ViewGroup rvU;
  public ViewGroup rvV;
  private a rvW;
  public com.tencent.mm.plugin.facedetect.d.b rvX;
  public boolean rvY;
  public boolean rvZ;
  public String rwa;
  public boolean rwb;
  public boolean rwc;
  public long rwd;
  private long rwe;
  private final int rwf;
  private Animation rwg;
  private View rwh;
  
  public FaceDetectView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public FaceDetectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private FaceDetectView(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(104145);
    this.rvS = null;
    this.rvT = null;
    this.rth = null;
    this.rvU = null;
    this.rvV = null;
    this.rvW = null;
    this.rvY = false;
    this.hkx = false;
    this.isPaused = false;
    this.rvZ = false;
    this.rwa = ak.getContext().getString(2131764084);
    this.rwb = true;
    this.rwc = false;
    this.rpz = -1L;
    this.rwd = -1L;
    this.rwe = -1L;
    this.rwf = 1500;
    this.rwh = null;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495634, null, false);
    addView(paramContext);
    this.rvS = ((FaceDetectCameraView)paramContext.findViewById(2131297685));
    this.rvT = ((FaceDetectDecorView)paramContext.findViewById(2131300738));
    this.rwh = paramContext.findViewById(2131300571);
    this.rvS.rvj = new b()
    {
      public final void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104137);
        ae.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ae.w("MicroMsg.FaceDetectView", "hy: already end or paused");
          AppMethodBeat.o(104137);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cuV()))
        {
          ae.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cuY());
          AppMethodBeat.o(104137);
          return;
        }
        FaceDetectView.this.lt(false);
        FaceDetectView.a(FaceDetectView.this, true);
        FaceDetectView localFaceDetectView = FaceDetectView.this;
        Object localObject;
        if (paramAnonymousCharSequence != null)
        {
          localObject = paramAnonymousCharSequence.toString();
          FaceDetectView.a(localFaceDetectView, (String)localObject);
          if (FaceDetectView.d(FaceDetectView.this) != null)
          {
            localObject = FaceDetectView.d(FaceDetectView.this);
            if (paramAnonymousCharSequence == null) {
              break label216;
            }
          }
        }
        label216:
        for (paramAnonymousCharSequence = paramAnonymousCharSequence.toString();; paramAnonymousCharSequence = FaceDetectView.this.getContext().getString(2131758686))
        {
          ((a)localObject).y(paramAnonymousInt, paramAnonymousCharSequence);
          AppMethodBeat.o(104137);
          return;
          localObject = FaceDetectView.this.getContext().getString(2131758686);
          break;
        }
      }
      
      public final void c(FaceCharacteristicsResult paramAnonymousFaceCharacteristicsResult)
      {
        AppMethodBeat.i(104138);
        int i = paramAnonymousFaceCharacteristicsResult.errCode;
        String str = paramAnonymousFaceCharacteristicsResult.errMsg;
        ae.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ae.w("MicroMsg.FaceDetectView", "hy: already end");
          AppMethodBeat.o(104138);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).a(paramAnonymousFaceCharacteristicsResult)))
        {
          ae.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cuY());
          AppMethodBeat.o(104138);
          return;
        }
        FaceDetectView.e(FaceDetectView.this);
        if (!FaceDetectView.f(FaceDetectView.this))
        {
          AppMethodBeat.o(104138);
          return;
        }
        if ((!FaceDetectView.g(FaceDetectView.this)) && ((paramAnonymousFaceCharacteristicsResult.errCode == 10) || (paramAnonymousFaceCharacteristicsResult.errCode == 11)))
        {
          AppMethodBeat.o(104138);
          return;
        }
        FaceDetectView.a(FaceDetectView.this, FaceCharacteristicsResult.DU(i));
        FaceDetectView localFaceDetectView = FaceDetectView.this;
        if (str != null) {}
        for (paramAnonymousFaceCharacteristicsResult = str;; paramAnonymousFaceCharacteristicsResult = "")
        {
          FaceDetectView.a(localFaceDetectView, paramAnonymousFaceCharacteristicsResult);
          AppMethodBeat.o(104138);
          return;
        }
      }
      
      public final void d(FaceCharacteristicsResult paramAnonymousFaceCharacteristicsResult)
      {
        AppMethodBeat.i(104139);
        ae.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramAnonymousFaceCharacteristicsResult.toString() });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ae.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
          AppMethodBeat.o(104139);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).b(paramAnonymousFaceCharacteristicsResult)))
        {
          ae.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cuY());
          AppMethodBeat.o(104139);
          return;
        }
        FaceDetectView.a(FaceDetectView.this, false);
        if (((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cuU())) || (FaceDetectView.f(FaceDetectView.this)))
        {
          FaceDetectView.h(FaceDetectView.this);
          FaceDetectView.e(FaceDetectView.this);
        }
        AppMethodBeat.o(104139);
      }
    };
    paramContext = getContext();
    if (paramContext == null)
    {
      ae.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.rwg = paramContext;
      AppMethodBeat.o(104145);
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130771989);
      paramContext.setInterpolator(new com.tencent.mm.ui.c.a.c());
    }
  }
  
  private void agV(String paramString)
  {
    AppMethodBeat.i(104148);
    if (bu.nullAsNil(paramString).equals(this.rth.getText().toString()))
    {
      ae.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      AppMethodBeat.o(104148);
      return;
    }
    this.rth.setText(paramString);
    this.rth.setVisibility(0);
    this.rth.setAnimation(this.rwg);
    AppMethodBeat.o(104148);
  }
  
  private void cvH()
  {
    AppMethodBeat.i(104147);
    this.rth.setText("");
    this.rth.setVisibility(4);
    AppMethodBeat.o(104147);
  }
  
  public int getCameraBestHeight()
  {
    AppMethodBeat.i(104153);
    int i = this.rvS.getEncodeVideoBestSize().y;
    AppMethodBeat.o(104153);
    return i;
  }
  
  public int getCameraBestWidth()
  {
    AppMethodBeat.i(104152);
    int i = this.rvS.getEncodeVideoBestSize().x;
    AppMethodBeat.o(104152);
    return i;
  }
  
  public int getCameraPreivewWidth()
  {
    AppMethodBeat.i(104150);
    int i = this.rvS.rvy.getPreviewWidth();
    AppMethodBeat.o(104150);
    return i;
  }
  
  public int getCameraPreviewHeight()
  {
    AppMethodBeat.i(104151);
    int i = this.rvS.rvy.getPreviewHeight();
    AppMethodBeat.o(104151);
    return i;
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(104149);
    int i = this.rvS.rvy.getRotation();
    AppMethodBeat.o(104149);
    return i;
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    AppMethodBeat.i(104154);
    if (this.rvX != null)
    {
      localb = this.rvX.cuX();
      AppMethodBeat.o(104154);
      return localb;
    }
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(104154);
    return localb;
  }
  
  public Bitmap getPreviewBm()
  {
    AppMethodBeat.i(104156);
    Bitmap localBitmap = this.rvS.getBitmap();
    AppMethodBeat.o(104156);
    return localBitmap;
  }
  
  public final void lt(boolean paramBoolean)
  {
    AppMethodBeat.i(104155);
    if (this.rvX != null) {
      this.rvX.cuW();
    }
    if (!this.hkx)
    {
      this.hkx = true;
      if (paramBoolean) {
        if (this.rvS != null) {
          f.ai(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104144);
              FaceDetectView.this.rvS.cvC();
              if (this.rrx != null)
              {
                FaceProNative.FaceResult localFaceResult = FaceDetectView.j(FaceDetectView.this).cvE();
                this.rrx.b(localFaceResult);
              }
              AppMethodBeat.o(104144);
            }
          });
        }
      }
      for (;;)
      {
        ae.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.rvZ = false;
        cvH();
        AppMethodBeat.o(104155);
        return;
        if (this.rvS != null) {
          this.rvS.cvB();
        }
      }
    }
    ae.w("MicroMsg.FaceDetectView", "hy: already end");
    AppMethodBeat.o(104155);
  }
  
  public void setBusinessTip(String paramString)
  {
    this.rsD = paramString;
  }
  
  public void setCallback(a parama)
  {
    this.rvW = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.rth = paramTextView;
  }
  
  public final void u(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(104146);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104141);
          ar.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104140);
              FaceDetectView.i(FaceDetectView.this).setVisibility(0);
              FaceDetectView.i(FaceDetectView.this).setBackgroundDrawable(new BitmapDrawable(this.rwl));
              AppMethodBeat.o(104140);
            }
          });
          AppMethodBeat.o(104141);
        }
      }, "face_detect_set_backgroud");
      AppMethodBeat.o(104146);
      return;
    }
    paramString = new AlphaAnimation(1.0F, 0.0F);
    paramString.setInterpolator(new LinearInterpolator());
    paramString.setDuration(500L);
    paramString.setFillAfter(true);
    this.rwh.startAnimation(paramString);
    AppMethodBeat.o(104146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */