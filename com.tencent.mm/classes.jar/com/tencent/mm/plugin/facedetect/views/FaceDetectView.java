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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;

public class FaceDetectView
  extends RelativeLayout
{
  public static long qEn = 100L;
  public static int qEo = 1;
  public volatile boolean gNN;
  public boolean isPaused;
  public String qAJ;
  private TextView qBn;
  public FaceDetectCameraView qDX;
  public FaceDetectDecorView qDY;
  public ViewGroup qDZ;
  public ViewGroup qEa;
  private a qEb;
  public com.tencent.mm.plugin.facedetect.d.b qEc;
  public boolean qEd;
  public boolean qEe;
  public String qEf;
  public boolean qEg;
  public boolean qEh;
  public long qEi;
  private long qEj;
  private final int qEk;
  private Animation qEl;
  private View qEm;
  public long qxF;
  
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
    this.qDX = null;
    this.qDY = null;
    this.qBn = null;
    this.qDZ = null;
    this.qEa = null;
    this.qEb = null;
    this.qEd = false;
    this.gNN = false;
    this.isPaused = false;
    this.qEe = false;
    this.qEf = ai.getContext().getString(2131764084);
    this.qEg = true;
    this.qEh = false;
    this.qxF = -1L;
    this.qEi = -1L;
    this.qEj = -1L;
    this.qEk = 1500;
    this.qEm = null;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495634, null, false);
    addView(paramContext);
    this.qDX = ((FaceDetectCameraView)paramContext.findViewById(2131297685));
    this.qDY = ((FaceDetectDecorView)paramContext.findViewById(2131300738));
    this.qEm = paramContext.findViewById(2131300571);
    this.qDX.qDo = new b()
    {
      public final void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104137);
        ac.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ac.w("MicroMsg.FaceDetectView", "hy: already end or paused");
          AppMethodBeat.o(104137);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cnP()))
        {
          ac.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cnS());
          AppMethodBeat.o(104137);
          return;
        }
        FaceDetectView.this.la(false);
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
        ac.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ac.w("MicroMsg.FaceDetectView", "hy: already end");
          AppMethodBeat.o(104138);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).a(paramAnonymousFaceCharacteristicsResult)))
        {
          ac.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cnS());
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
        FaceDetectView.a(FaceDetectView.this, FaceCharacteristicsResult.CP(i));
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
        ac.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramAnonymousFaceCharacteristicsResult.toString() });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ac.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
          AppMethodBeat.o(104139);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).b(paramAnonymousFaceCharacteristicsResult)))
        {
          ac.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cnS());
          AppMethodBeat.o(104139);
          return;
        }
        FaceDetectView.a(FaceDetectView.this, false);
        if (((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cnO())) || (FaceDetectView.f(FaceDetectView.this)))
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
      ac.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.qEl = paramContext;
      AppMethodBeat.o(104145);
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130771989);
      paramContext.setInterpolator(new com.tencent.mm.ui.c.a.c());
    }
  }
  
  private void ack(String paramString)
  {
    AppMethodBeat.i(104148);
    if (bs.nullAsNil(paramString).equals(this.qBn.getText().toString()))
    {
      ac.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      AppMethodBeat.o(104148);
      return;
    }
    this.qBn.setText(paramString);
    this.qBn.setVisibility(0);
    this.qBn.setAnimation(this.qEl);
    AppMethodBeat.o(104148);
  }
  
  private void coB()
  {
    AppMethodBeat.i(104147);
    this.qBn.setText("");
    this.qBn.setVisibility(4);
    AppMethodBeat.o(104147);
  }
  
  public int getCameraBestHeight()
  {
    AppMethodBeat.i(104153);
    int i = this.qDX.getEncodeVideoBestSize().y;
    AppMethodBeat.o(104153);
    return i;
  }
  
  public int getCameraBestWidth()
  {
    AppMethodBeat.i(104152);
    int i = this.qDX.getEncodeVideoBestSize().x;
    AppMethodBeat.o(104152);
    return i;
  }
  
  public int getCameraPreivewWidth()
  {
    AppMethodBeat.i(104150);
    int i = this.qDX.qDD.getPreviewWidth();
    AppMethodBeat.o(104150);
    return i;
  }
  
  public int getCameraPreviewHeight()
  {
    AppMethodBeat.i(104151);
    int i = this.qDX.qDD.getPreviewHeight();
    AppMethodBeat.o(104151);
    return i;
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(104149);
    int i = this.qDX.qDD.getRotation();
    AppMethodBeat.o(104149);
    return i;
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    AppMethodBeat.i(104154);
    if (this.qEc != null)
    {
      localb = this.qEc.cnR();
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
    Bitmap localBitmap = this.qDX.getBitmap();
    AppMethodBeat.o(104156);
    return localBitmap;
  }
  
  public final void la(boolean paramBoolean)
  {
    AppMethodBeat.i(104155);
    if (this.qEc != null) {
      this.qEc.cnQ();
    }
    if (!this.gNN)
    {
      this.gNN = true;
      if (paramBoolean) {
        if (this.qDX != null) {
          f.al(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104144);
              FaceDetectView.this.qDX.cow();
              if (this.qzE != null)
              {
                FaceProNative.FaceResult localFaceResult = FaceDetectView.j(FaceDetectView.this).coy();
                this.qzE.b(localFaceResult);
              }
              AppMethodBeat.o(104144);
            }
          });
        }
      }
      for (;;)
      {
        ac.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.qEe = false;
        coB();
        AppMethodBeat.o(104155);
        return;
        if (this.qDX != null) {
          this.qDX.cov();
        }
      }
    }
    ac.w("MicroMsg.FaceDetectView", "hy: already end");
    AppMethodBeat.o(104155);
  }
  
  public final void q(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(104146);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104141);
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104140);
              FaceDetectView.i(FaceDetectView.this).setVisibility(0);
              FaceDetectView.i(FaceDetectView.this).setBackgroundDrawable(new BitmapDrawable(this.qEq));
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
    this.qEm.startAnimation(paramString);
    AppMethodBeat.o(104146);
  }
  
  public void setBusinessTip(String paramString)
  {
    this.qAJ = paramString;
  }
  
  public void setCallback(a parama)
  {
    this.qEb = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.qBn = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */