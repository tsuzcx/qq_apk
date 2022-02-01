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
  private static b rkg;
  private RelativeLayout rjV;
  private Button rjW;
  private ImageView rjX;
  private TextView rjY;
  private TextView rjZ;
  private Button rka;
  private Button rkb;
  private TextView rkc;
  private Animation rkd;
  private Animation rke;
  protected WeakReference<FaceDetectPrepareUI> rkf;
  
  static
  {
    AppMethodBeat.i(103917);
    rkg = new b();
    AppMethodBeat.o(103917);
  }
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(103905);
    this.rjV = null;
    this.rjW = null;
    this.rjX = null;
    this.rjY = null;
    this.rjZ = null;
    this.rka = null;
    this.rkb = null;
    this.rkc = null;
    this.rkd = null;
    this.rke = null;
    this.rkf = null;
    this.rkf = new WeakReference(paramFaceDetectPrepareUI);
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
    paramOnClickListener.rlV = true;
    paramOnClickListener.rlX = (paramContext.getString(2131758724).length() - 3);
    AppMethodBeat.o(103916);
    return paramOnClickListener;
  }
  
  public static c a(c paramc, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.rlW = bool;
      paramc.rmd = paramString;
      paramc.rmh = paramOnClickListener;
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
    localc.rmc = paramInt;
    localc.rlZ = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      localc.rlQ = bool1;
      localc.rma = paramString2;
      localc.rlU = false;
      localc.rmb = null;
      if (paramString3 == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.rlT = bool1;
      localc.iDs = paramString3;
      localc.rlW = false;
      localc.rmd = null;
      localc.rmf = paramOnClickListener1;
      localc.rmg = null;
      localc.rmi = paramOnClickListener2;
      localc.rmh = null;
      AppMethodBeat.o(103915);
      return localc;
      bool1 = false;
      break;
    }
  }
  
  public static c ctH()
  {
    AppMethodBeat.i(103912);
    c localc = b(2131232168, null, null, null, null, null);
    AppMethodBeat.o(103912);
    return localc;
  }
  
  public void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(103908);
    this.rjV.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    AppMethodBeat.o(103908);
  }
  
  public void a(final c paramc)
  {
    AppMethodBeat.i(103910);
    if (rkg != null) {
      rkg.cancel();
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
    if (paramc.rlT)
    {
      ad.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.rka.setVisibility(0);
      this.rka.setText(paramc.iDs);
      this.rka.setOnClickListener(paramc.rmi);
      if (!paramc.rlQ) {
        break label484;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.rjW.setVisibility(0);
      this.rjW.setText(paramc.rma);
      this.rjW.setOnClickListener(paramc.rmf);
      if (!paramc.rlU) {
        break label495;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.rkb.setVisibility(0);
      this.rkb.setText(paramc.rmb);
      this.rkb.setOnClickListener(paramc.rmg);
      if (!paramc.rlR) {
        break label609;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.rjY.setVisibility(0);
      if (!paramc.rlV) {
        break label579;
      }
      ad.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.rjZ.setVisibility(0);
      i = paramc.rlX;
      str = paramc.rlZ;
      if ((!bt.isNullOrNil(str)) && (i < str.length()) && (i >= 0)) {
        break label506;
      }
      ad.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.rjY.setText(str);
      this.rjZ.setText("");
      label274:
      if (!paramc.rlS) {
        break label636;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.rjX.setVisibility(0);
      this.rjX.setImageResource(paramc.rmc);
      label308:
      if (!paramc.rlW) {
        break label647;
      }
      ad.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.rkc.setVisibility(0);
      this.rkc.setText(paramc.rmd);
      this.rkc.setOnClickListener(paramc.rmh);
    }
    for (;;)
    {
      if (paramc.rlY != null)
      {
        ad.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramc.rlY });
        this.rjV.setBackgroundDrawable(new BitmapDrawable(paramc.rlY));
      }
      ad.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.rjV.getVisibility()) });
      if (this.rjV.getVisibility() != 0)
      {
        this.rjV.setVisibility(0);
        this.rjV.startAnimation(this.rkd);
        this.rkd.setAnimationListener(new Animation.AnimationListener()
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
      this.rka.setVisibility(4);
      break;
      label484:
      this.rjW.setVisibility(4);
      break label133;
      label495:
      this.rkb.setVisibility(4);
      break label177;
      label506:
      rkg.cancel();
      b localb = rkg;
      WeakReference localWeakReference1 = new WeakReference(this.rjY);
      WeakReference localWeakReference2 = new WeakReference(this.rjZ);
      localb.rkm = str;
      localb.rkn = i;
      localb.rkk = localWeakReference1;
      localb.rkl = localWeakReference2;
      rkg.start();
      break label274;
      label579:
      ad.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.rjZ.setVisibility(4);
      this.rjY.setText(paramc.rlZ);
      break label274;
      label609:
      ad.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.rjY.setVisibility(4);
      this.rjZ.setVisibility(4);
      break label274;
      label636:
      this.rjX.setVisibility(4);
      break label308;
      label647:
      this.rkc.setVisibility(4);
    }
  }
  
  public boolean bni()
  {
    AppMethodBeat.i(103911);
    if (this.rjV.getVisibility() != 8)
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
    synchronized ((FaceDetectPrepareUI)this.rkf.get())
    {
      if (this.rkf.get() != null)
      {
        this.rjV = ((RelativeLayout)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131301246));
        this.rjW = ((Button)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131302852));
        this.rjX = ((ImageView)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131305894));
        this.rjY = ((TextView)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131305896));
        this.rkd = AnimationUtils.loadAnimation((Context)this.rkf.get(), 2130771981);
        this.rke = AnimationUtils.loadAnimation((Context)this.rkf.get(), 2130771982);
        this.rka = ((Button)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131301244));
        this.rkb = ((Button)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131305511));
        this.rjZ = ((TextView)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131306168));
        this.rkc = ((TextView)((FaceDetectPrepareUI)this.rkf.get()).findViewById(2131299898));
        this.rkd.setDuration(500L);
        this.rke.setDuration(500L);
      }
      AppMethodBeat.o(103906);
      return;
    }
  }
  
  public void ctG()
  {
    AppMethodBeat.i(103909);
    if (rkg != null) {
      rkg.cancel();
    }
    this.rka.setVisibility(4);
    this.rjW.setVisibility(4);
    this.rkb.setVisibility(4);
    this.rjZ.setVisibility(4);
    this.rjY.setVisibility(4);
    AppMethodBeat.o(103909);
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(103907);
    ad.m("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    rkg.cancel();
    if (this.rjV.getVisibility() == 0) {
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
    WeakReference<TextView> rkk = null;
    WeakReference<TextView> rkl = null;
    String rkm = null;
    int rkn = 0;
    int rko = 0;
    
    public b()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.rkk != null) && (this.rkk.get() != null) && (this.rkl != null) && (this.rkl.get() != null))
      {
        TextView localTextView1 = (TextView)this.rkk.get();
        TextView localTextView2 = (TextView)this.rkl.get();
        localTextView1.setText(this.rkm.substring(0, this.rkn));
        localTextView2.setText(this.rkm.substring(this.rkn, this.rkn + this.rko % (this.rkm.length() - this.rkn + 1)));
      }
      for (;;)
      {
        this.rko += 1;
        AppMethodBeat.o(103904);
        return;
        ad.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */