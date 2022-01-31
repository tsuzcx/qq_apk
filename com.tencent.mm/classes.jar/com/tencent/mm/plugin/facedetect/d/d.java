package com.tencent.mm.plugin.facedetect.d;

import android.content.Context;
import android.content.res.Resources;
import android.os.CountDownTimer;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import com.tencent.mm.plugin.facedetect.FaceProNative;
import com.tencent.mm.plugin.facedetect.a.a;
import com.tencent.mm.plugin.facedetect.a.c;
import com.tencent.mm.plugin.facedetect.a.e;
import com.tencent.mm.plugin.facedetect.a.f;
import com.tencent.mm.plugin.facedetect.a.g;
import com.tencent.mm.plugin.facedetect.a.i;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.model.g;
import com.tencent.mm.plugin.facedetect.service.FaceDetectProcessService;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;

public final class d
  implements b
{
  private View iVb = null;
  boolean inQ = false;
  private a.b jOQ = new d.9(this);
  boolean jPA = false;
  boolean jPB = false;
  private Animation jPC;
  private Animation jPD;
  private AnimationSet jPE;
  private Animation jPF;
  final Object jPG = new Object();
  boolean jPH = false;
  b.a jPI = null;
  ah jPJ = new d.1(this, Looper.getMainLooper());
  private CountDownTimer jPK = new d.2(this);
  Runnable jPL = new d.3(this);
  boolean jPb = false;
  private String jPp = null;
  private int jPq = 0;
  a jPr = null;
  String[] jPs = null;
  int jPt = 0;
  int jPu = 0;
  private FaceNumberView jPv = null;
  private long jPw = -1L;
  private long jPx = -1L;
  boolean jPy = false;
  boolean jPz = false;
  
  public d(String paramString)
  {
    this.jPr.jOQ = this.jOQ;
    this.jPC = AnimationUtils.loadAnimation(ae.getContext(), a.a.slide_right_in);
    this.jPD = AnimationUtils.loadAnimation(ae.getContext(), a.a.face_slide_left_out);
    this.jPF = AnimationUtils.loadAnimation(ae.getContext(), a.a.fast_faded_in);
    this.jPF.setDuration(250L);
    this.jPF.setFillAfter(true);
    this.jPp = paramString;
    int i;
    if (this.jPp == null)
    {
      i = 0;
      this.jPq = i;
      aOQ();
      if (!aOP()) {
        break label361;
      }
    }
    label361:
    for (this.jPE = ((AnimationSet)AnimationUtils.loadAnimation(ae.getContext(), a.a.face_title_scale_multi));; this.jPE = ((AnimationSet)AnimationUtils.loadAnimation(ae.getContext(), a.a.face_title_scale_single)))
    {
      paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, ae.getResources().getDimensionPixelSize(a.c.face_hint_msg_tv_anim_distance));
      paramString.setDuration(ae.getContext().getResources().getInteger(a.f.scaleAnimDuration));
      this.jPE.addAnimation(paramString);
      y.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", new Object[] { this.jPp });
      return;
      i = this.jPp.length();
      break;
    }
  }
  
  private TextView aOO()
  {
    if (this.iVb != null) {
      return (TextView)this.iVb.findViewById(a.e.hint_msg_tv);
    }
    return null;
  }
  
  private boolean aOP()
  {
    return this.jPq >= 6;
  }
  
  private void aOQ()
  {
    int i = 0;
    int j;
    if ((!bk.bl(this.jPp)) && (aOP()))
    {
      y.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", new Object[] { Integer.valueOf(2) });
      this.jPs = new String[2];
      j = this.jPq / 2;
    }
    while (i < 2)
    {
      this.jPs[i] = this.jPp.substring(j * i, (i + 1) * j);
      i += 1;
      continue;
      this.jPs = new String[1];
      this.jPs[0] = this.jPp;
    }
  }
  
  private void cN(int paramInt1, int paramInt2)
  {
    y.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    if (aOO() != null)
    {
      if (paramInt1 == 1) {
        aOO().setText(ae.getContext().getString(a.i.face_number_msg_single));
      }
    }
    else {
      return;
    }
    TextView localTextView = aOO();
    Context localContext;
    int i;
    if (paramInt2 == -1)
    {
      localContext = ae.getContext();
      i = a.i.face_number_msg_first;
      switch (paramInt1)
      {
      default: 
        localObject = qP(paramInt1);
      }
    }
    label102:
    for (Object localObject = localContext.getString(i, new Object[] { localObject });; localObject = ae.getContext().getString(a.i.face_number_msg, new Object[] { qP(this.jPt + 1) }))
    {
      localTextView.setText((CharSequence)localObject);
      if (paramInt2 <= 0) {
        break;
      }
      y.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", new Object[] { Integer.valueOf(paramInt2 + 1) });
      localObject = f.jNM.jNN.jPP;
      if (((g)localObject).jNQ != null) {
        break label224;
      }
      y.e("MicroMsg.FaceDetectNativeManager", "hy: startRecord not init");
      return;
      localObject = ae.getContext().getString(a.i.face_number_hint_2nd);
      break label102;
    }
    label224:
    ((g)localObject).jNQ.engineGroupChange();
  }
  
  private static String qP(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
      return "";
    case 1: 
      return ae.getContext().getString(a.i.face_number_hint_1);
    case 2: 
      return ae.getContext().getString(a.i.face_number_hint_2);
    case 3: 
      return ae.getContext().getString(a.i.face_number_hint_3);
    }
    return ae.getContext().getString(a.i.face_number_hint_4);
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    y.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
    this.iVb = LayoutInflater.from(paramContext).inflate(a.g.face_hint_number, paramViewGroup2);
    this.jPv = ((FaceNumberView)this.iVb.findViewById(a.e.face_text_number));
    cN(this.jPs.length, -1);
    aOO().startAnimation(this.jPC);
    if (this.jPv != null)
    {
      this.jPv.setVisibility(0);
      this.jPv.startAnimation(this.jPC);
      this.jPt = 0;
      fP(false);
      this.jPu = -1;
      aOR();
      this.jPw = bk.UZ();
      this.jPx = bk.UZ();
      this.inQ = false;
    }
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    this.jPz = true;
    return this.jPH;
  }
  
  public final boolean aOJ()
  {
    return this.jPb;
  }
  
  public final boolean aOK()
  {
    this.jPz = true;
    return this.jPH;
  }
  
  public final void aOL()
  {
    this.inQ = true;
    this.jPH = false;
    Object localObject1 = this.jPr;
    ((a)localObject1).jOR = true;
    y.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
    for (;;)
    {
      try
      {
        if (((a)localObject1).bCc != null)
        {
          ((a)localObject1).bCc.uh();
          ((a)localObject1).bCc = null;
        }
        if (((a)localObject1).eLP != null)
        {
          ((a)localObject1).eLP.uE();
          ((a)localObject1).eLP = null;
        }
        Object localObject2 = ((a)localObject1).eLY;
        if (localObject2 != null) {}
        try
        {
          ((a)localObject1).eLY.release();
          ((a)localObject1).eLY = null;
          ((a)localObject1).eMz = true;
          ((a)localObject1).eLK = 0;
          localObject1 = this.jPr;
          y.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
          ((a)localObject1).jOQ = null;
          this.jPr.aOH();
          if ((com.tencent.mm.plugin.facedetect.e.a.aPj().jST) && (com.tencent.mm.plugin.facedetect.e.a.aPj().isStarted()))
          {
            localObject1 = this.jPr;
            localObject2 = com.tencent.mm.plugin.facedetect.e.a.aPj().aPk();
            ((a)localObject1).jOT.remove(localObject2);
            if (this.jPb) {
              com.tencent.mm.plugin.facedetect.e.a.aPj().a(null);
            }
          }
          else
          {
            this.jPK.cancel();
            this.jPJ.removeCallbacksAndMessages(null);
            if (this.jPv != null)
            {
              localObject1 = this.jPv;
              if ((((FaceNumberView)localObject1).jVa != null) && (((FaceNumberView)localObject1).jVa.length > 0)) {
                break label285;
              }
            }
            if (this.iVb != null)
            {
              this.jPb = false;
              this.jPw = -1L;
              this.iVb = null;
              this.jPv = null;
            }
            return;
          }
        }
        catch (Exception localException)
        {
          y.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "mVoiceSilentDetectAPI.release error", new Object[0]);
          continue;
        }
        com.tencent.mm.plugin.facedetect.e.a.aPj().aPl();
      }
      finally {}
      continue;
      label285:
      int i = 0;
      while (i < ((FaceNumberView)localObject1).jVa.length)
      {
        localObject1.jVa[i].aPv();
        i += 1;
      }
    }
  }
  
  public final b.b aOM()
  {
    return new b.b(90004, "user cancelled in processing");
  }
  
  public final b.a aON()
  {
    return this.jPI;
  }
  
  final void aOR()
  {
    if (this.jPv != null)
    {
      if (this.jPt >= 0) {
        this.jPv.Ct(this.jPs[this.jPt].substring(0, this.jPu + 1));
      }
    }
    else {
      return;
    }
    this.jPv.Ct(null);
  }
  
  final void aOS()
  {
    this.jPK.start();
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    this.jPz = false;
    return this.jPH;
  }
  
  final void fP(boolean paramBoolean)
  {
    if (this.jPv != null)
    {
      cN(this.jPs.length, this.jPt);
      this.jPv.setNumberLengthAndInflate(this.jPs[this.jPt].length());
      this.jPB = false;
      if (!paramBoolean) {
        break label82;
      }
      this.jPC.setAnimationListener(new d.4(this));
      if (this.iVb != null) {
        this.iVb.startAnimation(this.jPC);
      }
    }
    return;
    label82:
    ai.l(new d.5(this), 500L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d
 * JD-Core Version:    0.7.0.1
 */