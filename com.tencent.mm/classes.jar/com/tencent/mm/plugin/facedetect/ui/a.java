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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import java.lang.ref.WeakReference;

public class a
{
  private static b rsk;
  private RelativeLayout rrZ;
  private Button rsa;
  private ImageView rsb;
  private TextView rsc;
  private TextView rsd;
  private Button rse;
  private Button rsf;
  private TextView rsg;
  private Animation rsh;
  private Animation rsi;
  protected WeakReference<FaceDetectPrepareUI> rsj;
  
  static
  {
    AppMethodBeat.i(103917);
    rsk = new b();
    AppMethodBeat.o(103917);
  }
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(103905);
    this.rrZ = null;
    this.rsa = null;
    this.rsb = null;
    this.rsc = null;
    this.rsd = null;
    this.rse = null;
    this.rsf = null;
    this.rsg = null;
    this.rsh = null;
    this.rsi = null;
    this.rsj = null;
    this.rsj = new WeakReference(paramFaceDetectPrepareUI);
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
    paramOnClickListener.rua = true;
    paramOnClickListener.ruc = (paramContext.getString(2131758724).length() - 3);
    AppMethodBeat.o(103916);
    return paramOnClickListener;
  }
  
  public static c a(c paramc, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.rub = bool;
      paramc.rui = paramString;
      paramc.rum = paramOnClickListener;
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
    localc.ruh = paramInt;
    localc.rue = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      localc.rtV = bool1;
      localc.ruf = paramString2;
      localc.rtZ = false;
      localc.rug = null;
      if (paramString3 == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.rtY = bool1;
      localc.iGl = paramString3;
      localc.rub = false;
      localc.rui = null;
      localc.ruk = paramOnClickListener1;
      localc.rul = null;
      localc.run = paramOnClickListener2;
      localc.rum = null;
      AppMethodBeat.o(103915);
      return localc;
      bool1 = false;
      break;
    }
  }
  
  public static c cvi()
  {
    AppMethodBeat.i(103912);
    c localc = b(2131232168, null, null, null, null, null);
    AppMethodBeat.o(103912);
    return localc;
  }
  
  public void W(Bitmap paramBitmap)
  {
    AppMethodBeat.i(103908);
    this.rrZ.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    AppMethodBeat.o(103908);
  }
  
  public void a(final c paramc)
  {
    AppMethodBeat.i(103910);
    if (rsk != null) {
      rsk.cancel();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(103910);
      return;
    }
    ae.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[] { paramc.toString() });
    label133:
    label177:
    int i;
    String str;
    if (paramc.rtY)
    {
      ae.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.rse.setVisibility(0);
      this.rse.setText(paramc.iGl);
      this.rse.setOnClickListener(paramc.run);
      if (!paramc.rtV) {
        break label484;
      }
      ae.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.rsa.setVisibility(0);
      this.rsa.setText(paramc.ruf);
      this.rsa.setOnClickListener(paramc.ruk);
      if (!paramc.rtZ) {
        break label495;
      }
      ae.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.rsf.setVisibility(0);
      this.rsf.setText(paramc.rug);
      this.rsf.setOnClickListener(paramc.rul);
      if (!paramc.rtW) {
        break label609;
      }
      ae.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.rsc.setVisibility(0);
      if (!paramc.rua) {
        break label579;
      }
      ae.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.rsd.setVisibility(0);
      i = paramc.ruc;
      str = paramc.rue;
      if ((!bu.isNullOrNil(str)) && (i < str.length()) && (i >= 0)) {
        break label506;
      }
      ae.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.rsc.setText(str);
      this.rsd.setText("");
      label274:
      if (!paramc.rtX) {
        break label636;
      }
      ae.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.rsb.setVisibility(0);
      this.rsb.setImageResource(paramc.ruh);
      label308:
      if (!paramc.rub) {
        break label647;
      }
      ae.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.rsg.setVisibility(0);
      this.rsg.setText(paramc.rui);
      this.rsg.setOnClickListener(paramc.rum);
    }
    for (;;)
    {
      if (paramc.rud != null)
      {
        ae.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramc.rud });
        this.rrZ.setBackgroundDrawable(new BitmapDrawable(paramc.rud));
      }
      ae.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.rrZ.getVisibility()) });
      if (this.rrZ.getVisibility() != 0)
      {
        this.rrZ.setVisibility(0);
        this.rrZ.startAnimation(this.rsh);
        this.rsh.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(103903);
            ae.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            AppMethodBeat.o(103903);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      AppMethodBeat.o(103910);
      return;
      this.rse.setVisibility(4);
      break;
      label484:
      this.rsa.setVisibility(4);
      break label133;
      label495:
      this.rsf.setVisibility(4);
      break label177;
      label506:
      rsk.cancel();
      b localb = rsk;
      WeakReference localWeakReference1 = new WeakReference(this.rsc);
      WeakReference localWeakReference2 = new WeakReference(this.rsd);
      localb.rsq = str;
      localb.rsr = i;
      localb.rso = localWeakReference1;
      localb.rsp = localWeakReference2;
      rsk.start();
      break label274;
      label579:
      ae.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.rsd.setVisibility(4);
      this.rsc.setText(paramc.rue);
      break label274;
      label609:
      ae.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.rsc.setVisibility(4);
      this.rsd.setVisibility(4);
      break label274;
      label636:
      this.rsb.setVisibility(4);
      break label308;
      label647:
      this.rsg.setVisibility(4);
    }
  }
  
  public boolean bnS()
  {
    AppMethodBeat.i(103911);
    if (this.rrZ.getVisibility() != 8)
    {
      AppMethodBeat.o(103911);
      return true;
    }
    AppMethodBeat.o(103911);
    return false;
  }
  
  public void create()
  {
    AppMethodBeat.i(103906);
    synchronized ((FaceDetectPrepareUI)this.rsj.get())
    {
      if (this.rsj.get() != null)
      {
        this.rrZ = ((RelativeLayout)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131301246));
        this.rsa = ((Button)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131302852));
        this.rsb = ((ImageView)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131305894));
        this.rsc = ((TextView)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131305896));
        this.rsh = AnimationUtils.loadAnimation((Context)this.rsj.get(), 2130771981);
        this.rsi = AnimationUtils.loadAnimation((Context)this.rsj.get(), 2130771982);
        this.rse = ((Button)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131301244));
        this.rsf = ((Button)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131305511));
        this.rsd = ((TextView)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131306168));
        this.rsg = ((TextView)((FaceDetectPrepareUI)this.rsj.get()).findViewById(2131299898));
        this.rsh.setDuration(500L);
        this.rsi.setDuration(500L);
      }
      AppMethodBeat.o(103906);
      return;
    }
  }
  
  public void cvh()
  {
    AppMethodBeat.i(103909);
    if (rsk != null) {
      rsk.cancel();
    }
    this.rse.setVisibility(4);
    this.rsa.setVisibility(4);
    this.rsf.setVisibility(4);
    this.rsd.setVisibility(4);
    this.rsc.setVisibility(4);
    AppMethodBeat.o(103909);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(103907);
    ae.m("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    rsk.cancel();
    if (this.rrZ.getVisibility() == 0) {
      ar.f(new Runnable()
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
    WeakReference<TextView> rso = null;
    WeakReference<TextView> rsp = null;
    String rsq = null;
    int rsr = 0;
    int rss = 0;
    
    public b()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.rso != null) && (this.rso.get() != null) && (this.rsp != null) && (this.rsp.get() != null))
      {
        TextView localTextView1 = (TextView)this.rso.get();
        TextView localTextView2 = (TextView)this.rsp.get();
        localTextView1.setText(this.rsq.substring(0, this.rsr));
        localTextView2.setText(this.rsq.substring(this.rsr, this.rsr + this.rss % (this.rsq.length() - this.rsr + 1)));
      }
      for (;;)
      {
        this.rss += 1;
        AppMethodBeat.o(103904);
        return;
        ae.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */