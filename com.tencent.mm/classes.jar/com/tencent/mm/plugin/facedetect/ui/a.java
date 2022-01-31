package com.tencent.mm.plugin.facedetect.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.d;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.lang.ref.WeakReference;

public class a
{
  private static a.b jQD = new a.b();
  private Animation jQA = null;
  private Animation jQB = null;
  protected WeakReference<FaceDetectPrepareUI> jQC = null;
  private RelativeLayout jQs = null;
  private Button jQt = null;
  private ImageView jQu = null;
  private TextView jQv = null;
  private TextView jQw = null;
  private Button jQx = null;
  private Button jQy = null;
  private TextView jQz = null;
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    this.jQC = new WeakReference(paramFaceDetectPrepareUI);
  }
  
  public static d a(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    return b(paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
  }
  
  public static d a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    paramOnClickListener = a(a.d.face_confirm_icon, paramContext.getString(a.i.face_detect_preparing), null, paramContext.getString(a.i.app_cancel), null, paramOnClickListener);
    paramOnClickListener.jSs = true;
    paramOnClickListener.jSu = (paramContext.getString(a.i.face_detect_preparing).length() - 3);
    return paramOnClickListener;
  }
  
  public static d a(d paramd, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramd.jSt = bool;
      paramd.jSB = paramString;
      paramd.jSF = paramOnClickListener;
      return paramd;
    }
  }
  
  public static d b(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = true;
    d locald = new d();
    locald.jSA = paramInt;
    locald.jSw = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      locald.jSn = bool1;
      locald.jSx = paramString2;
      locald.jSr = false;
      locald.jSy = null;
      if (paramString3 == null) {
        break label124;
      }
    }
    label124:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      locald.jSq = bool1;
      locald.jSz = paramString3;
      locald.jSt = false;
      locald.jSB = null;
      locald.jSD = paramOnClickListener1;
      locald.jSE = null;
      locald.jSG = paramOnClickListener2;
      locald.jSF = null;
      return locald;
      bool1 = false;
      break;
    }
  }
  
  public static d qQ(int paramInt)
  {
    return b(paramInt, null, null, null, null, null);
  }
  
  public void a(d paramd)
  {
    if (jQD != null) {
      jQD.cancel();
    }
    if (paramd == null) {
      return;
    }
    y.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[] { paramd.toString() });
    label79:
    label123:
    int i;
    label167:
    String str;
    if (paramd.jSq)
    {
      y.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.jQx.setVisibility(0);
      this.jQx.setText(paramd.jSz);
      this.jQx.setOnClickListener(paramd.jSG);
      if (!paramd.jSn) {
        break label466;
      }
      y.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.jQt.setVisibility(0);
      this.jQt.setText(paramd.jSx);
      this.jQt.setOnClickListener(paramd.jSD);
      if (!paramd.jSr) {
        break label477;
      }
      y.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.jQy.setVisibility(0);
      this.jQy.setText(paramd.jSy);
      this.jQy.setOnClickListener(paramd.jSE);
      if (!paramd.jSo) {
        break label591;
      }
      y.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.jQv.setVisibility(0);
      if (!paramd.jSs) {
        break label561;
      }
      y.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.jQw.setVisibility(0);
      i = paramd.jSu;
      str = paramd.jSw;
      if ((!bk.bl(str)) && (i < str.length()) && (i >= 0)) {
        break label488;
      }
      y.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.jQv.setText(str);
      this.jQw.setText("");
      label264:
      if (!paramd.jSp) {
        break label618;
      }
      y.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.jQu.setVisibility(0);
      this.jQu.setImageResource(paramd.jSA);
      label297:
      if (!paramd.jSt) {
        break label629;
      }
      y.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.jQz.setVisibility(0);
      this.jQz.setText(paramd.jSB);
      this.jQz.setOnClickListener(paramd.jSF);
    }
    for (;;)
    {
      if (paramd.jSv != null)
      {
        y.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramd.jSv });
        this.jQs.setBackgroundDrawable(new BitmapDrawable(paramd.jSv));
      }
      y.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.jQs.getVisibility()) });
      if (this.jQs.getVisibility() == 0) {
        break;
      }
      this.jQs.setVisibility(0);
      this.jQs.startAnimation(this.jQA);
      this.jQA.setAnimationListener(new a.2(this, paramd));
      return;
      this.jQx.setVisibility(4);
      break label79;
      label466:
      this.jQt.setVisibility(4);
      break label123;
      label477:
      this.jQy.setVisibility(4);
      break label167;
      label488:
      jQD.cancel();
      a.b localb = jQD;
      WeakReference localWeakReference1 = new WeakReference(this.jQv);
      WeakReference localWeakReference2 = new WeakReference(this.jQw);
      localb.jQJ = str;
      localb.jQK = i;
      localb.jQH = localWeakReference1;
      localb.jQI = localWeakReference2;
      jQD.start();
      break label264;
      label561:
      y.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.jQw.setVisibility(4);
      this.jQv.setText(paramd.jSw);
      break label264;
      label591:
      y.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.jQv.setVisibility(4);
      this.jQw.setVisibility(4);
      break label264;
      label618:
      this.jQu.setVisibility(4);
      break label297;
      label629:
      this.jQz.setVisibility(4);
    }
  }
  
  public void aOW()
  {
    if (jQD != null) {
      jQD.cancel();
    }
    this.jQx.setVisibility(4);
    this.jQt.setVisibility(4);
    this.jQy.setVisibility(4);
    this.jQw.setVisibility(4);
    this.jQv.setVisibility(4);
  }
  
  public boolean akH()
  {
    return this.jQs.getVisibility() != 8;
  }
  
  public void create()
  {
    synchronized ((FaceDetectPrepareUI)this.jQC.get())
    {
      if (this.jQC.get() != null)
      {
        this.jQs = ((RelativeLayout)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.jumper_root));
        this.jQt = ((Button)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.next_btn));
        this.jQu = ((ImageView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.tips_icon));
        this.jQv = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.tips_tv));
        this.jQA = AnimationUtils.loadAnimation((Context)this.jQC.get(), a.a.alpha_in);
        this.jQB = AnimationUtils.loadAnimation((Context)this.jQC.get(), a.a.alpha_out);
        this.jQx = ((Button)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.jumper_left_btn));
        this.jQy = ((Button)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.subbutton));
        this.jQw = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.tweeky_Tv));
        this.jQz = ((TextView)((FaceDetectPrepareUI)this.jQC.get()).findViewById(a.e.feedback_tv));
        this.jQA.setDuration(500L);
        this.jQB.setDuration(500L);
      }
      return;
    }
  }
  
  public void dismiss()
  {
    y.l("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    jQD.cancel();
    if (this.jQs.getVisibility() == 0) {
      ai.d(new a.1(this));
    }
  }
  
  public void z(Bitmap paramBitmap)
  {
    this.jQs.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */