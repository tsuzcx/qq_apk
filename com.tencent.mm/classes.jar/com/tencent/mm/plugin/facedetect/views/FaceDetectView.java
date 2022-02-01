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
import com.tencent.mm.plugin.facedetect.d.b.b;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.p;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.c.a.c;

public class FaceDetectView
  extends RelativeLayout
{
  public static long pVI = 100L;
  public static int pVJ = 1;
  public volatile boolean gna;
  public boolean isPaused;
  public long pOX;
  private TextView pSF;
  public String pSb;
  public String pVA;
  public boolean pVB;
  public boolean pVC;
  public long pVD;
  private long pVE;
  private final int pVF;
  private Animation pVG;
  private View pVH;
  public FaceDetectCameraView pVs;
  public FaceDetectDecorView pVt;
  public ViewGroup pVu;
  public ViewGroup pVv;
  private a pVw;
  public com.tencent.mm.plugin.facedetect.d.b pVx;
  public boolean pVy;
  public boolean pVz;
  
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
    this.pVs = null;
    this.pVt = null;
    this.pSF = null;
    this.pVu = null;
    this.pVv = null;
    this.pVw = null;
    this.pVy = false;
    this.gna = false;
    this.isPaused = false;
    this.pVz = false;
    this.pVA = aj.getContext().getString(2131764084);
    this.pVB = true;
    this.pVC = false;
    this.pOX = -1L;
    this.pVD = -1L;
    this.pVE = -1L;
    this.pVF = 1500;
    this.pVH = null;
    paramContext = LayoutInflater.from(paramContext).inflate(2131495634, null, false);
    addView(paramContext);
    this.pVs = ((FaceDetectCameraView)paramContext.findViewById(2131297685));
    this.pVt = ((FaceDetectDecorView)paramContext.findViewById(2131300738));
    this.pVH = paramContext.findViewById(2131300571);
    this.pVs.pUJ = new b()
    {
      public final void a(int paramAnonymousInt, CharSequence paramAnonymousCharSequence)
      {
        AppMethodBeat.i(104137);
        ad.e("MicroMsg.FaceDetectView", "hy: onDetectError: %d, %s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousCharSequence });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ad.w("MicroMsg.FaceDetectView", "hy: already end or paused");
          AppMethodBeat.o(104137);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cgi()))
        {
          ad.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cgl());
          AppMethodBeat.o(104137);
          return;
        }
        FaceDetectView.this.kw(false);
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
        ad.v("MicroMsg.FaceDetectView", "hy: onDetectHelp: %d, %s", new Object[] { Integer.valueOf(i), str });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ad.w("MicroMsg.FaceDetectView", "hy: already end");
          AppMethodBeat.o(104138);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).a(paramAnonymousFaceCharacteristicsResult)))
        {
          ad.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cgl());
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
        FaceDetectView.a(FaceDetectView.this, FaceCharacteristicsResult.BU(i));
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
        ad.d("MicroMsg.FaceDetectView", "hy: onDetectSucceed: %s", new Object[] { paramAnonymousFaceCharacteristicsResult.toString() });
        if ((FaceDetectView.a(FaceDetectView.this)) || (FaceDetectView.b(FaceDetectView.this)))
        {
          ad.w("MicroMsg.FaceDetectView", "hy: already end pr paused");
          AppMethodBeat.o(104139);
          return;
        }
        if ((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).b(paramAnonymousFaceCharacteristicsResult)))
        {
          ad.e("MicroMsg.FaceDetectView", "hy: motion eat result");
          FaceDetectView.a(FaceDetectView.this, FaceDetectView.c(FaceDetectView.this).cgl());
          AppMethodBeat.o(104139);
          return;
        }
        FaceDetectView.a(FaceDetectView.this, false);
        if (((FaceDetectView.c(FaceDetectView.this) != null) && (FaceDetectView.c(FaceDetectView.this).cgh())) || (FaceDetectView.f(FaceDetectView.this)))
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
      ad.e("MicroMsg.MMAnimationEffectLoader", "hy: context is null.");
      paramContext = null;
    }
    for (;;)
    {
      this.pVG = paramContext;
      AppMethodBeat.o(104145);
      return;
      paramContext = AnimationUtils.loadAnimation(paramContext, 2130771989);
      paramContext.setInterpolator(new c());
    }
  }
  
  private void XN(String paramString)
  {
    AppMethodBeat.i(104148);
    if (bt.nullAsNil(paramString).equals(this.pSF.getText().toString()))
    {
      ad.v("MicroMsg.FaceDetectView", "hy: same error. ignore");
      AppMethodBeat.o(104148);
      return;
    }
    this.pSF.setText(paramString);
    this.pSF.setVisibility(0);
    this.pSF.setAnimation(this.pVG);
    AppMethodBeat.o(104148);
  }
  
  private void cgU()
  {
    AppMethodBeat.i(104147);
    this.pSF.setText("");
    this.pSF.setVisibility(4);
    AppMethodBeat.o(104147);
  }
  
  public int getCameraBestHeight()
  {
    AppMethodBeat.i(104153);
    int i = this.pVs.getEncodeVideoBestSize().y;
    AppMethodBeat.o(104153);
    return i;
  }
  
  public int getCameraBestWidth()
  {
    AppMethodBeat.i(104152);
    int i = this.pVs.getEncodeVideoBestSize().x;
    AppMethodBeat.o(104152);
    return i;
  }
  
  public int getCameraPreivewWidth()
  {
    AppMethodBeat.i(104150);
    int i = this.pVs.pUY.getPreviewWidth();
    AppMethodBeat.o(104150);
    return i;
  }
  
  public int getCameraPreviewHeight()
  {
    AppMethodBeat.i(104151);
    int i = this.pVs.pUY.getPreviewHeight();
    AppMethodBeat.o(104151);
    return i;
  }
  
  public int getCameraRotation()
  {
    AppMethodBeat.i(104149);
    int i = this.pVs.pUY.getRotation();
    AppMethodBeat.o(104149);
    return i;
  }
  
  public b.b getCurrentMotionCancelInfo()
  {
    AppMethodBeat.i(104154);
    if (this.pVx != null)
    {
      localb = this.pVx.cgk();
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
    Bitmap localBitmap = this.pVs.getBitmap();
    AppMethodBeat.o(104156);
    return localBitmap;
  }
  
  public final void kw(boolean paramBoolean)
  {
    AppMethodBeat.i(104155);
    if (this.pVx != null) {
      this.pVx.cgj();
    }
    if (!this.gna)
    {
      this.gna = true;
      if (paramBoolean) {
        if (this.pVs != null) {
          f.aj(new FaceDetectView.5(this));
        }
      }
      for (;;)
      {
        ad.i("MicroMsg.FaceDetectView", "hy: stopped capture face");
        this.pVz = false;
        cgU();
        AppMethodBeat.o(104155);
        return;
        if (this.pVs != null) {
          this.pVs.cgO();
        }
      }
    }
    ad.w("MicroMsg.FaceDetectView", "hy: already end");
    AppMethodBeat.o(104155);
  }
  
  public final void p(boolean paramBoolean, final String paramString)
  {
    AppMethodBeat.i(104146);
    if (paramBoolean)
    {
      com.tencent.mm.sdk.g.b.c(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(104141);
          aq.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(104140);
              FaceDetectView.i(FaceDetectView.this).setVisibility(0);
              FaceDetectView.i(FaceDetectView.this).setBackgroundDrawable(new BitmapDrawable(this.pVL));
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
    this.pVH.startAnimation(paramString);
    AppMethodBeat.o(104146);
  }
  
  public void setBusinessTip(String paramString)
  {
    this.pSb = paramString;
  }
  
  public void setCallback(a parama)
  {
    this.pVw = parama;
  }
  
  public void setErrTextView(TextView paramTextView)
  {
    this.pSF = paramTextView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.views.FaceDetectView
 * JD-Core Version:    0.7.0.1
 */