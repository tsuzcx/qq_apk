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
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.thread.ThreadPool;

public class FaceDetectView
  extends RelativeLayout
{
  public static long sWf = 100L;
  public static int sWg = 1;
  public volatile boolean idt;
  public boolean isPaused;
  public long sQX;
  private TextView sTK;
  public String sTT;
  public FaceDetectCameraView sVP;
  public FaceDetectDecorView sVQ;
  public ViewGroup sVR;
  public ViewGroup sVS;
  private a sVT;
  public com.tencent.mm.plugin.facedetect.d.b sVU;
  public boolean sVV;
  public boolean sVW;
  public String sVX;
  public boolean sVY;
  public boolean sVZ;
  public long sWa;
  private long sWb;
  private final int sWc;
  private Animation sWd;
  private View sWe;
  
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
    this.sVP = null;
    this.sVQ = null;
    this.sTK = null;
    this.sVR = null;
    this.sVS = null;
    this.sVT = null;
    this.sVV = false;
    this.idt = false;
    this.isPaused = false;
    this.sVW = false;
    this.sVX = MMApplicationContext.getContext().getString(2131766326);
    this.sVY = true;
    this.sVZ = false;
    this.sQX = -1L;
    this.sWa = -1L;
    this.sWb = -1L;
    this.sWc = 1500;
    this.sWe = null;
    paramContext = LayoutInflater.from(paramContext).inflate(2131496535, null, false);
    addView(paramContext);
    this.sVP = ((FaceDetectCameraView)paramContext.findViewById(2131297957));
    this.sVQ = ((FaceDetectDecorView)paramContext.findViewById(2131302323));
    this.sWe = paramContext.findViewById(2131302106);
    this.sVP.sVg = new b()
    {
      public final void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104137);
        Log.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          Log.w("MicroMsg.FaceDetectView", "hy: already end or paused");
          AppMethodBeat.o(104137);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cTr()))
        {
          Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cTu());
          AppMethodBeat.o(104137);
          return;
        }
        FaceDetectView.this.mv(false);
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
        for (paramAnonymousCharSequence = paramAnonymousCharSequence.toString();; paramAnonymousCharSequence = FaceDetectView.this.getContext().getString(2131759001))
        {
          ((a)localObject).A(paramAnonymousInt, paramAnonymousCharSequence);
          AppMethodBeat.o(104137);
          return;
          localObject = FaceDetectView.this.getContext().getString(2131759001);
          break;
        }
      }
      
      public final void c(FaceCharacteristicsResult paramAnonymousFaceCharacteristicsResult)
      {
        AppMethodBeat.i(104138);
        int i = paramAnonymousFaceCharacteristicsResult.errCode;
        String str = paramAnonymousFaceCharacteristicsResult.errMsg;
        Log.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          Log.w("MicroMsg.FaceDetectView", "hy: already end");
          AppMethodBeat.o(104138);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).a(paramAnonymousFaceCharacteristicsResult)))
        {
          Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cTu());
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
        FaceDetectView.a(FaceDetectView.this, FaceCharacteristicsResult.HG(i));
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
        Log.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramAnonymousFaceCharacteristicsResult.toString() });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          Log.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
          AppMethodBeat.o(104139);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).b(paramAnonymousFaceCharacteristicsResult)))
        {
          Log.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cTu());
          AppMethodBeat.o(104139);
          return;
        }
        FaceDetectView.a(FaceDetectView.this, false);
        if (((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cTq())) || (FaceDetectView.f(FaceDetectView.this)))
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
      Log.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.sWd = paramContext;
      AppMethodBeat.o(104145);
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130771993);
      paramContext.setInterpolator(new com.tencent.mm.ui.c.b.c());
    }
  }
  
  private void arE(String paramString)
  {
    AppMethodBeat.i(104148);
    if (Util.nullAsNil(paramString).equals(this.sTK.getText().toString()))
    {
      Log.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      AppMethodBeat.o(104148);
      return;
    }
    this.sTK.setText(paramString);
    this.sTK.setVisibility(0);
    this.sTK.setAnimation(this.sWd);
    AppMethodBeat.o(104148);
  }
  
  private void cTR()
  {
    AppMethodBeat.i(104147);
    this.sTK.setText("");
    this.sTK.setVisibility(4);
    AppMethodBeat.o(104147);
  }
  
  public int getCameraBestHeight()
  {
    AppMethodBeat.i(104153);
    int i = this.sVP.getEncodeVideoBestSize().y;
    AppMethodBeat.o(104153);
    return i;
  }
  
  public int getCameraBestWidth()
  {
    AppMethodBeat.i(104152);
    int i = this.sVP.getEncodeVideoBestSize().x;
    AppMethodBeat.o(104152);
    return i;
  }
  
  public int getCameraPreivewWidth()
  {
    AppMethodBeat.i(104150);
    int i = this.sVP.sVv.getPreviewWidth();
    AppMethodBeat.o(104150);
    return i;
  }
  
  public int getCameraPreviewHeight()
  {
    AppMethodBeat.i(104151);
    int i = this.sVP.sVv.getPreviewHeight();
    AppMethodBeat.o(104151);
    return i;
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(104149);
    int i = this.sVP.sVv.getRotation();
    AppMethodBeat.o(104149);
    return i;
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    AppMethodBeat.i(104154);
    if (this.sVU != null)
    {
      localb = this.sVU.cTt();
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
    Bitmap localBitmap = this.sVP.getBitmap();
    AppMethodBeat.o(104156);
    return localBitmap;
  }
  
  public final void mv(boolean paramBoolean)
  {
    AppMethodBeat.i(104155);
    if (this.sVU != null) {
      this.sVU.cTs();
    }
    if (!this.idt)
    {
      this.idt = true;
      if (paramBoolean) {
        if (this.sVP != null) {
          f.ao(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104144);
              FaceDetectView.this.sVP.cTL();
              if (this.sSU != null)
              {
                FaceProNative.FaceResult localFaceResult = FaceDetectView.j(FaceDetectView.this).cTN();
                this.sSU.b(localFaceResult);
              }
              AppMethodBeat.o(104144);
            }
          });
        }
      }
      for (;;)
      {
        Log.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.sVW = false;
        cTR();
        AppMethodBeat.o(104155);
        return;
        if (this.sVP != null) {
          this.sVP.cTK();
        }
      }
    }
    Log.w("MicroMsg.FaceDetectView", "hy: already end");
    AppMethodBeat.o(104155);
  }
  
  public void setBusinessTip(String paramString)
  {
    this.sTT = paramString;
  }
  
  public void setCallback(a parama)
  {
    this.sVT = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.sTK = paramTextView;
  }
  
  public final void u(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(104146);
    if (paramBoolean)
    {
      ThreadPool.post(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104141);
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104140);
              FaceDetectView.i(FaceDetectView.this).setVisibility(0);
              FaceDetectView.i(FaceDetectView.this).setBackgroundDrawable(new BitmapDrawable(this.sWi));
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
    this.sWe.startAnimation(paramString);
    AppMethodBeat.o(104146);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */