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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.lang.ref.WeakReference;

public class a
{
  private static a.b mkY;
  private RelativeLayout mkN;
  private Button mkO;
  private ImageView mkP;
  private TextView mkQ;
  private TextView mkR;
  private Button mkS;
  private Button mkT;
  private TextView mkU;
  private Animation mkV;
  private Animation mkW;
  protected WeakReference<FaceDetectPrepareUI> mkX;
  
  static
  {
    AppMethodBeat.i(398);
    mkY = new a.b();
    AppMethodBeat.o(398);
  }
  
  a(FaceDetectPrepareUI paramFaceDetectPrepareUI)
  {
    AppMethodBeat.i(386);
    this.mkN = null;
    this.mkO = null;
    this.mkP = null;
    this.mkQ = null;
    this.mkR = null;
    this.mkS = null;
    this.mkT = null;
    this.mkU = null;
    this.mkV = null;
    this.mkW = null;
    this.mkX = null;
    this.mkX = new WeakReference(paramFaceDetectPrepareUI);
    AppMethodBeat.o(386);
  }
  
  public static c a(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(394);
    paramString1 = b(paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(394);
    return paramString1;
  }
  
  public static c a(Context paramContext, View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(397);
    paramOnClickListener = a(2130838678, paramContext.getString(2131299567), null, paramContext.getString(2131296888), null, paramOnClickListener);
    paramOnClickListener.mmO = true;
    paramOnClickListener.mmQ = (paramContext.getString(2131299567).length() - 3);
    AppMethodBeat.o(397);
    return paramOnClickListener;
  }
  
  public static c a(c paramc, String paramString, View.OnClickListener paramOnClickListener)
  {
    if (paramString != null) {}
    for (boolean bool = true;; bool = false)
    {
      paramc.mmP = bool;
      paramc.mmX = paramString;
      paramc.mnb = paramOnClickListener;
      return paramc;
    }
  }
  
  public static c b(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    AppMethodBeat.i(395);
    paramString1 = c(paramInt, paramString1, paramString2, paramString3, paramOnClickListener1, paramOnClickListener2);
    AppMethodBeat.o(395);
    return paramString1;
  }
  
  public static c bva()
  {
    AppMethodBeat.i(393);
    c localc = b(2130838727, null, null, null, null, null);
    AppMethodBeat.o(393);
    return localc;
  }
  
  private static c c(int paramInt, String paramString1, String paramString2, String paramString3, View.OnClickListener paramOnClickListener1, View.OnClickListener paramOnClickListener2)
  {
    boolean bool2 = true;
    AppMethodBeat.i(396);
    c localc = new c();
    localc.mmW = paramInt;
    localc.mmS = paramString1;
    if (paramString2 != null)
    {
      bool1 = true;
      localc.mmJ = bool1;
      localc.mmT = paramString2;
      localc.mmN = false;
      localc.mmU = null;
      if (paramString3 == null) {
        break label136;
      }
    }
    label136:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localc.mmM = bool1;
      localc.mmV = paramString3;
      localc.mmP = false;
      localc.mmX = null;
      localc.mmZ = paramOnClickListener1;
      localc.mna = null;
      localc.mnc = paramOnClickListener2;
      localc.mnb = null;
      AppMethodBeat.o(396);
      return localc;
      bool1 = false;
      break;
    }
  }
  
  public void K(Bitmap paramBitmap)
  {
    AppMethodBeat.i(389);
    this.mkN.setBackgroundDrawable(new BitmapDrawable(paramBitmap));
    AppMethodBeat.o(389);
  }
  
  public boolean Pk()
  {
    AppMethodBeat.i(392);
    if (this.mkN.getVisibility() != 8)
    {
      AppMethodBeat.o(392);
      return true;
    }
    AppMethodBeat.o(392);
    return false;
  }
  
  public void a(c paramc)
  {
    AppMethodBeat.i(391);
    if (mkY != null) {
      mkY.cancel();
    }
    if (paramc == null)
    {
      AppMethodBeat.o(391);
      return;
    }
    ab.i("MicroMsg.FaceDetectJumper", "hy: request show conf: %s", new Object[] { paramc.toString() });
    label135:
    label179:
    int i;
    String str;
    if (paramc.mmM)
    {
      ab.i("MicroMsg.FaceDetectJumper", " mCancelBtn VISIBLE");
      this.mkS.setVisibility(0);
      this.mkS.setText(paramc.mmV);
      this.mkS.setOnClickListener(paramc.mnc);
      if (!paramc.mmJ) {
        break label485;
      }
      ab.i("MicroMsg.FaceDetectJumper", " isShowMainButton VISIBLE");
      this.mkO.setVisibility(0);
      this.mkO.setText(paramc.mmT);
      this.mkO.setOnClickListener(paramc.mmZ);
      if (!paramc.mmN) {
        break label496;
      }
      ab.i("MicroMsg.FaceDetectJumper", " mSubBtn VISIBLE");
      this.mkT.setVisibility(0);
      this.mkT.setText(paramc.mmU);
      this.mkT.setOnClickListener(paramc.mna);
      if (!paramc.mmK) {
        break label610;
      }
      ab.i("MicroMsg.FaceDetectJumper", " isShowStatusWordingTv VISIBLE");
      this.mkQ.setVisibility(0);
      if (!paramc.mmO) {
        break label580;
      }
      ab.i("MicroMsg.FaceDetectJumper", " isShowOneByOne VISIBLE");
      this.mkR.setVisibility(0);
      i = paramc.mmQ;
      str = paramc.mmS;
      if ((!bo.isNullOrNil(str)) && (i < str.length()) && (i >= 0)) {
        break label507;
      }
      ab.e("MicroMsg.FaceDetectJumper", "hy: invalid showing one by one");
      this.mkQ.setText(str);
      this.mkR.setText("");
      label276:
      if (!paramc.mmL) {
        break label637;
      }
      ab.i("MicroMsg.FaceDetectJumper", " mStatusIv VISIBLE");
      this.mkP.setVisibility(0);
      this.mkP.setImageResource(paramc.mmW);
      label309:
      if (!paramc.mmP) {
        break label648;
      }
      ab.i("MicroMsg.FaceDetectJumper", " mFeedbackTv VISIBLE");
      this.mkU.setVisibility(0);
      this.mkU.setText(paramc.mmX);
      this.mkU.setOnClickListener(paramc.mnb);
    }
    for (;;)
    {
      if (paramc.mmR != null)
      {
        ab.i("MicroMsg.FaceDetectJumper", "bgBm：：%s ", new Object[] { paramc.mmR });
        this.mkN.setBackgroundDrawable(new BitmapDrawable(paramc.mmR));
      }
      ab.i("MicroMsg.FaceDetectJumper", "show jumper, visible: %s", new Object[] { Integer.valueOf(this.mkN.getVisibility()) });
      if (this.mkN.getVisibility() != 0)
      {
        this.mkN.setVisibility(0);
        this.mkN.startAnimation(this.mkV);
        this.mkV.setAnimationListener(new a.2(this, paramc));
      }
      AppMethodBeat.o(391);
      return;
      this.mkS.setVisibility(4);
      break;
      label485:
      this.mkO.setVisibility(4);
      break label135;
      label496:
      this.mkT.setVisibility(4);
      break label179;
      label507:
      mkY.cancel();
      a.b localb = mkY;
      WeakReference localWeakReference1 = new WeakReference(this.mkQ);
      WeakReference localWeakReference2 = new WeakReference(this.mkR);
      localb.mle = str;
      localb.mlf = i;
      localb.mlc = localWeakReference1;
      localb.mld = localWeakReference2;
      mkY.start();
      break label276;
      label580:
      ab.i("MicroMsg.FaceDetectJumper", " imTweekyTv VISIBLE");
      this.mkR.setVisibility(4);
      this.mkQ.setText(paramc.mmS);
      break label276;
      label610:
      ab.i("MicroMsg.FaceDetectJumper", " mStatusWordingTV VISIBLE");
      this.mkQ.setVisibility(4);
      this.mkR.setVisibility(4);
      break label276;
      label637:
      this.mkP.setVisibility(4);
      break label309;
      label648:
      this.mkU.setVisibility(4);
    }
  }
  
  public void create()
  {
    AppMethodBeat.i(387);
    synchronized ((FaceDetectPrepareUI)this.mkX.get())
    {
      if (this.mkX.get() != null)
      {
        this.mkN = ((RelativeLayout)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823913));
        this.mkO = ((Button)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131822914));
        this.mkP = ((ImageView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823915));
        this.mkQ = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823916));
        this.mkV = AnimationUtils.loadAnimation((Context)this.mkX.get(), 2131034125);
        this.mkW = AnimationUtils.loadAnimation((Context)this.mkX.get(), 2131034126);
        this.mkS = ((Button)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823920));
        this.mkT = ((Button)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823918));
        this.mkR = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823917));
        this.mkU = ((TextView)((FaceDetectPrepareUI)this.mkX.get()).findViewById(2131823919));
        this.mkV.setDuration(500L);
        this.mkW.setDuration(500L);
      }
      AppMethodBeat.o(387);
      return;
    }
  }
  
  public void dismiss()
  {
    AppMethodBeat.i(388);
    ab.b("MicroMsg.FaceDetectJumper", "dismiss jumper", new Object[0]);
    mkY.cancel();
    if (this.mkN.getVisibility() == 0) {
      al.d(new a.1(this));
    }
    AppMethodBeat.o(388);
  }
  
  public void resetAll()
  {
    AppMethodBeat.i(390);
    if (mkY != null) {
      mkY.cancel();
    }
    this.mkS.setVisibility(4);
    this.mkO.setVisibility(4);
    this.mkT.setVisibility(4);
    this.mkR.setVisibility(4);
    this.mkQ.setVisibility(4);
    AppMethodBeat.o(390);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.ui.a
 * JD-Core Version:    0.7.0.1
 */