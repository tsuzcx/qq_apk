package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.CountDownTimer;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import java.lang.ref.WeakReference;

public class a
{
  private static b pRJ;
  private ImageView pRA;
  private TextView pRB;
  private TextView pRC;
  private Button pRD;
  private Button pRE;
  private TextView pRF;
  private Animation pRG;
  private Animation pRH;
  protected WeakReference<FaceDetectPrepareUI> pRI;
  private RelativeLayout pRy;
  private Button pRz;
  
  static
  {
    AppMethodBeat.i(103917);
    pRJ = new b();
    AppMethodBeat.o(103917);
  }
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(103905);
    this.pRy = null;
    this.pRz = null;
    this.pRA = null;
    this.pRB = null;
    this.pRC = null;
    this.pRD = null;
    this.pRE = null;
    this.pRF = null;
    this.pRG = null;
    this.pRH = null;
    this.pRI = null;
    this.pRI = new WeakReference(paramFaceDetectPrepareUI);
    AppMethodBeat.o(103905);
  }
  
  public static c a(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(103913);
    paramString1 = b(paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(103913);
    return paramString1;
  }
  
  public static c a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(103916);
    paramOnClickListener = a(2131232119, paramContext.getString(2131758724), null, paramContext.getString(2131755691), null, paramOnClickListener);
    paramOnClickListener.pTA = true;
    paramOnClickListener.pTC = (paramContext.getString(2131758724).length() - 3);
    AppMethodBeat.o(103916);
    return paramOnClickListener;
  }
  
  public static c a(c paramc, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.pTB = bool;
      paramc.pTI = paramString;
      paramc.pTM = paramOnClickListener;
      return paramc;
    }
  }
  
  public static c b(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(103914);
    paramString1 = c(paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(103914);
    return paramString1;
  }
  
  private static c c(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(103915);
    c localc = new c();
    localc.pTH = paramInt;
    localc.pTE = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      localc.pTv = bool1;
      localc.pTF = paramString2;
      localc.pTz = false;
      localc.pTG = null;
      if (paramString3 == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.pTy = bool1;
      localc.hJD = paramString3;
      localc.pTB = false;
      localc.pTI = null;
      localc.pTK = paramOnClickListener1;
      localc.pTL = null;
      localc.pTN = paramOnClickListener2;
      localc.pTM = null;
      AppMethodBeat.o(103915);
      return localc;
      bool1 = false;
      break;
    }
  }
  
  public static c cgv()
  {
    AppMethodBeat.i(103912);
    c localc = b(2131232168, null, null, null, null, null);
    AppMethodBeat.o(103912);
    return localc;
  }
  
  public void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(103908);
    this.pRy.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    AppMethodBeat.o(103908);
  }
  
  public void a(final c paramc)
  {
    AppMethodBeat.i(103910);
    if (pRJ != null) {
      pRJ.cancel();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(103910);
      return;
    }
    ad.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[] { paramc.toString() });
    label133:
    label177:
    int i;
    String str;
    if (paramc.pTy)
    {
      ad.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.pRD.setVisibility(0);
      this.pRD.setText(paramc.hJD);
      this.pRD.setOnClickListener(paramc.pTN);
      if (!paramc.pTv) {
        break label484;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.pRz.setVisibility(0);
      this.pRz.setText(paramc.pTF);
      this.pRz.setOnClickListener(paramc.pTK);
      if (!paramc.pTz) {
        break label495;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.pRE.setVisibility(0);
      this.pRE.setText(paramc.pTG);
      this.pRE.setOnClickListener(paramc.pTL);
      if (!paramc.pTw) {
        break label609;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.pRB.setVisibility(0);
      if (!paramc.pTA) {
        break label579;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.pRC.setVisibility(0);
      i = paramc.pTC;
      str = paramc.pTE;
      if ((!bt.isNullOrNil(str)) && (i < str.length()) && (i >= 0)) {
        break label506;
      }
      ad.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.pRB.setText(str);
      this.pRC.setText("");
      label274:
      if (!paramc.pTx) {
        break label636;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.pRA.setVisibility(0);
      this.pRA.setImageResource(paramc.pTH);
      label308:
      if (!paramc.pTB) {
        break label647;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.pRF.setVisibility(0);
      this.pRF.setText(paramc.pTI);
      this.pRF.setOnClickListener(paramc.pTM);
    }
    for (;;)
    {
      if (paramc.pTD != null)
      {
        ad.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramc.pTD });
        this.pRy.setBackgroundDrawable(new BitmapDrawable(paramc.pTD));
      }
      ad.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.pRy.getVisibility()) });
      if (this.pRy.getVisibility() != 0)
      {
        this.pRy.setVisibility(0);
        this.pRy.startAnimation(this.pRG);
        this.pRG.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(103903);
            ad.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            AppMethodBeat.o(103903);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      AppMethodBeat.o(103910);
      return;
      this.pRD.setVisibility(4);
      break;
      label484:
      this.pRz.setVisibility(4);
      break label133;
      label495:
      this.pRE.setVisibility(4);
      break label177;
      label506:
      pRJ.cancel();
      b localb = pRJ;
      WeakReference localWeakReference1 = new WeakReference(this.pRB);
      WeakReference localWeakReference2 = new WeakReference(this.pRC);
      localb.pRP = str;
      localb.pRQ = i;
      localb.pRN = localWeakReference1;
      localb.pRO = localWeakReference2;
      pRJ.start();
      break label274;
      label579:
      ad.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.pRC.setVisibility(4);
      this.pRB.setText(paramc.pTE);
      break label274;
      label609:
      ad.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.pRB.setVisibility(4);
      this.pRC.setVisibility(4);
      break label274;
      label636:
      this.pRA.setVisibility(4);
      break label308;
      label647:
      this.pRF.setVisibility(4);
    }
  }
  
  public boolean bcB()
  {
    AppMethodBeat.i(103911);
    if (this.pRy.getVisibility() != 8)
    {
      AppMethodBeat.o(103911);
      return true;
    }
    AppMethodBeat.o(103911);
    return false;
  }
  
  public void cgu()
  {
    AppMethodBeat.i(103909);
    if (pRJ != null) {
      pRJ.cancel();
    }
    this.pRD.setVisibility(4);
    this.pRz.setVisibility(4);
    this.pRE.setVisibility(4);
    this.pRC.setVisibility(4);
    this.pRB.setVisibility(4);
    AppMethodBeat.o(103909);
  }
  
  public void create()
  {
    AppMethodBeat.i(103906);
    synchronized ((FaceDetectPrepareUI)this.pRI.get())
    {
      if (this.pRI.get() != null)
      {
        this.pRy = ((RelativeLayout)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131301246));
        this.pRz = ((Button)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131302852));
        this.pRA = ((ImageView)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131305894));
        this.pRB = ((TextView)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131305896));
        this.pRG = AnimationUtils.loadAnimation((Context)this.pRI.get(), 2130771981);
        this.pRH = AnimationUtils.loadAnimation((Context)this.pRI.get(), 2130771982);
        this.pRD = ((Button)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131301244));
        this.pRE = ((Button)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131305511));
        this.pRC = ((TextView)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131306168));
        this.pRF = ((TextView)((FaceDetectPrepareUI)this.pRI.get()).findViewById(2131299898));
        this.pRG.setDuration(500L);
        this.pRH.setDuration(500L);
      }
      AppMethodBeat.o(103906);
      return;
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(103907);
    ad.m("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    pRJ.cancel();
    if (this.pRy.getVisibility() == 0) {
      aq.f(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(103902);
          a.b(a.this).setAnimationListener(new Animation.AnimationListener()
          {
            public final void onAnimationEnd(Animation paramAnonymous2Animation)
            {
              AppMethodBeat.i(103901);
              a.a(a.this).setVisibility(8);
              AppMethodBeat.o(103901);
            }
            
            public final void onAnimationRepeat(Animation paramAnonymous2Animation) {}
            
            public final void onAnimationStart(Animation paramAnonymous2Animation) {}
          });
          a.a(a.this).startAnimation(a.b(a.this));
          AppMethodBeat.o(103902);
        }
      });
    }
    AppMethodBeat.o(103907);
  }
  
  static abstract interface a {}
  
  public static final class b
    extends CountDownTimer
  {
    int goS = 0;
    WeakReference<TextView> pRN = null;
    WeakReference<TextView> pRO = null;
    String pRP = null;
    int pRQ = 0;
    
    public b()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.pRN != null) && (this.pRN.get() != null) && (this.pRO != null) && (this.pRO.get() != null))
      {
        TextView localTextView1 = (TextView)this.pRN.get();
        TextView localTextView2 = (TextView)this.pRO.get();
        localTextView1.setText(this.pRP.substring(0, this.pRQ));
        localTextView2.setText(this.pRP.substring(this.pRQ, this.pRQ + this.goS % (this.pRP.length() - this.pRQ + 1)));
      }
      for (;;)
      {
        this.goS += 1;
        AppMethodBeat.o(103904);
        return;
        ad.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */