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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import java.lang.ref.WeakReference;

public class a
{
  private static b qAr;
  private RelativeLayout qAg;
  private Button qAh;
  private ImageView qAi;
  private TextView qAj;
  private TextView qAk;
  private Button qAl;
  private Button qAm;
  private TextView qAn;
  private Animation qAo;
  private Animation qAp;
  protected WeakReference<FaceDetectPrepareUI> qAq;
  
  static
  {
    AppMethodBeat.i(103917);
    qAr = new b();
    AppMethodBeat.o(103917);
  }
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(103905);
    this.qAg = null;
    this.qAh = null;
    this.qAi = null;
    this.qAj = null;
    this.qAk = null;
    this.qAl = null;
    this.qAm = null;
    this.qAn = null;
    this.qAo = null;
    this.qAp = null;
    this.qAq = null;
    this.qAq = new WeakReference(paramFaceDetectPrepareUI);
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
    paramOnClickListener.qCf = true;
    paramOnClickListener.qCh = (paramContext.getString(2131758724).length() - 3);
    AppMethodBeat.o(103916);
    return paramOnClickListener;
  }
  
  public static c a(c paramc, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.qCg = bool;
      paramc.qCn = paramString;
      paramc.qCr = paramOnClickListener;
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
    localc.qCm = paramInt;
    localc.qCj = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      localc.qCa = bool1;
      localc.qCk = paramString2;
      localc.qCe = false;
      localc.qCl = null;
      if (paramString3 == null) {
        break label134;
      }
    }
    label134:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.qCd = bool1;
      localc.ikb = paramString3;
      localc.qCg = false;
      localc.qCn = null;
      localc.qCp = paramOnClickListener1;
      localc.qCq = null;
      localc.qCs = paramOnClickListener2;
      localc.qCr = null;
      AppMethodBeat.o(103915);
      return localc;
      bool1 = false;
      break;
    }
  }
  
  public static c coc()
  {
    AppMethodBeat.i(103912);
    c localc = b(2131232168, null, null, null, null, null);
    AppMethodBeat.o(103912);
    return localc;
  }
  
  public void V(Bitmap paramBitmap)
  {
    AppMethodBeat.i(103908);
    this.qAg.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    AppMethodBeat.o(103908);
  }
  
  public void a(final c paramc)
  {
    AppMethodBeat.i(103910);
    if (qAr != null) {
      qAr.cancel();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(103910);
      return;
    }
    ac.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[] { paramc.toString() });
    label133:
    label177:
    int i;
    String str;
    if (paramc.qCd)
    {
      ac.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.qAl.setVisibility(0);
      this.qAl.setText(paramc.ikb);
      this.qAl.setOnClickListener(paramc.qCs);
      if (!paramc.qCa) {
        break label484;
      }
      ac.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.qAh.setVisibility(0);
      this.qAh.setText(paramc.qCk);
      this.qAh.setOnClickListener(paramc.qCp);
      if (!paramc.qCe) {
        break label495;
      }
      ac.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.qAm.setVisibility(0);
      this.qAm.setText(paramc.qCl);
      this.qAm.setOnClickListener(paramc.qCq);
      if (!paramc.qCb) {
        break label609;
      }
      ac.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.qAj.setVisibility(0);
      if (!paramc.qCf) {
        break label579;
      }
      ac.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.qAk.setVisibility(0);
      i = paramc.qCh;
      str = paramc.qCj;
      if ((!bs.isNullOrNil(str)) && (i < str.length()) && (i >= 0)) {
        break label506;
      }
      ac.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.qAj.setText(str);
      this.qAk.setText("");
      label274:
      if (!paramc.qCc) {
        break label636;
      }
      ac.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.qAi.setVisibility(0);
      this.qAi.setImageResource(paramc.qCm);
      label308:
      if (!paramc.qCg) {
        break label647;
      }
      ac.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.qAn.setVisibility(0);
      this.qAn.setText(paramc.qCn);
      this.qAn.setOnClickListener(paramc.qCr);
    }
    for (;;)
    {
      if (paramc.qCi != null)
      {
        ac.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramc.qCi });
        this.qAg.setBackgroundDrawable(new BitmapDrawable(paramc.qCi));
      }
      ac.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.qAg.getVisibility()) });
      if (this.qAg.getVisibility() != 0)
      {
        this.qAg.setVisibility(0);
        this.qAg.startAnimation(this.qAo);
        this.qAo.setAnimationListener(new Animation.AnimationListener()
        {
          public final void onAnimationEnd(Animation paramAnonymousAnimation)
          {
            AppMethodBeat.i(103903);
            ac.i("MicroMsg.FaceDetectJumper", "showJumperEnd: %d", new Object[] { Long.valueOf(System.currentTimeMillis()) });
            AppMethodBeat.o(103903);
          }
          
          public final void onAnimationRepeat(Animation paramAnonymousAnimation) {}
          
          public final void onAnimationStart(Animation paramAnonymousAnimation) {}
        });
      }
      AppMethodBeat.o(103910);
      return;
      this.qAl.setVisibility(4);
      break;
      label484:
      this.qAh.setVisibility(4);
      break label133;
      label495:
      this.qAm.setVisibility(4);
      break label177;
      label506:
      qAr.cancel();
      b localb = qAr;
      WeakReference localWeakReference1 = new WeakReference(this.qAj);
      WeakReference localWeakReference2 = new WeakReference(this.qAk);
      localb.qAx = str;
      localb.qAy = i;
      localb.qAv = localWeakReference1;
      localb.qAw = localWeakReference2;
      qAr.start();
      break label274;
      label579:
      ac.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.qAk.setVisibility(4);
      this.qAj.setText(paramc.qCj);
      break label274;
      label609:
      ac.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.qAj.setVisibility(4);
      this.qAk.setVisibility(4);
      break label274;
      label636:
      this.qAi.setVisibility(4);
      break label308;
      label647:
      this.qAn.setVisibility(4);
    }
  }
  
  public boolean bjw()
  {
    AppMethodBeat.i(103911);
    if (this.qAg.getVisibility() != 8)
    {
      AppMethodBeat.o(103911);
      return true;
    }
    AppMethodBeat.o(103911);
    return false;
  }
  
  public void cob()
  {
    AppMethodBeat.i(103909);
    if (qAr != null) {
      qAr.cancel();
    }
    this.qAl.setVisibility(4);
    this.qAh.setVisibility(4);
    this.qAm.setVisibility(4);
    this.qAk.setVisibility(4);
    this.qAj.setVisibility(4);
    AppMethodBeat.o(103909);
  }
  
  public void create()
  {
    AppMethodBeat.i(103906);
    synchronized ((FaceDetectPrepareUI)this.qAq.get())
    {
      if (this.qAq.get() != null)
      {
        this.qAg = ((RelativeLayout)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131301246));
        this.qAh = ((Button)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131302852));
        this.qAi = ((ImageView)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131305894));
        this.qAj = ((TextView)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131305896));
        this.qAo = AnimationUtils.loadAnimation((Context)this.qAq.get(), 2130771981);
        this.qAp = AnimationUtils.loadAnimation((Context)this.qAq.get(), 2130771982);
        this.qAl = ((Button)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131301244));
        this.qAm = ((Button)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131305511));
        this.qAk = ((TextView)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131306168));
        this.qAn = ((TextView)((FaceDetectPrepareUI)this.qAq.get()).findViewById(2131299898));
        this.qAo.setDuration(500L);
        this.qAp.setDuration(500L);
      }
      AppMethodBeat.o(103906);
      return;
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(103907);
    ac.m("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    qAr.cancel();
    if (this.qAg.getVisibility() == 0) {
      ap.f(new Runnable()
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
    int gPA = 0;
    WeakReference<TextView> qAv = null;
    WeakReference<TextView> qAw = null;
    String qAx = null;
    int qAy = 0;
    
    public b()
    {
      super(500L);
    }
    
    public final void onFinish() {}
    
    public final void onTick(long paramLong)
    {
      AppMethodBeat.i(103904);
      if ((this.qAv != null) && (this.qAv.get() != null) && (this.qAw != null) && (this.qAw.get() != null))
      {
        TextView localTextView1 = (TextView)this.qAv.get();
        TextView localTextView2 = (TextView)this.qAw.get();
        localTextView1.setText(this.qAx.substring(0, this.qAy));
        localTextView2.setText(this.qAx.substring(this.qAy, this.qAy + this.gPA % (this.qAx.length() - this.qAy + 1)));
      }
      for (;;)
      {
        this.gPA += 1;
        AppMethodBeat.o(103904);
        return;
        ac.w("MicroMsg.FaceDetectJumper", "hy: tv ref released");
        cancel();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */