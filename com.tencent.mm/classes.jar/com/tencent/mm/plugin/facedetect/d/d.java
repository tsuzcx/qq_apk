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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceCharacteristicsResult;
import com.tencent.mm.plugin.facedetect.model.f;
import com.tencent.mm.plugin.facedetect.views.FaceNumberItemView;
import com.tencent.mm.plugin.facedetect.views.FaceNumberView;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;

public final class d
  implements b
{
  boolean eRq;
  private View lef;
  private String mjF;
  private int mjG;
  a mjH;
  String[] mjI;
  int mjJ;
  int mjK;
  private FaceNumberView mjL;
  private long mjM;
  private long mjN;
  boolean mjO;
  boolean mjP;
  boolean mjQ;
  boolean mjR;
  private Animation mjS;
  private Animation mjT;
  private AnimationSet mjU;
  private Animation mjV;
  final Object mjW;
  boolean mjX;
  b.a mjY;
  ak mjZ;
  private a.b mjg;
  boolean mjr;
  private View mjt;
  private CountDownTimer mka;
  Runnable mkb;
  
  public d(String paramString)
  {
    AppMethodBeat.i(321);
    this.mjF = null;
    this.mjG = 0;
    this.mjH = null;
    this.mjI = null;
    this.mjJ = 0;
    this.mjK = 0;
    this.lef = null;
    this.mjL = null;
    this.mjr = false;
    this.mjM = -1L;
    this.mjN = -1L;
    this.mjO = false;
    this.mjP = false;
    this.mjQ = false;
    this.mjR = false;
    this.mjW = new Object();
    this.eRq = false;
    this.mjX = false;
    this.mjY = null;
    this.mjZ = new d.1(this, Looper.getMainLooper());
    this.mka = new d.2(this);
    this.mkb = new d.3(this);
    this.mjg = new d.9(this);
    this.mjH = new a();
    this.mjH.mjg = this.mjg;
    this.mjS = AnimationUtils.loadAnimation(ah.getContext(), 2131034266);
    this.mjT = AnimationUtils.loadAnimation(ah.getContext(), 2131034168);
    this.mjV = AnimationUtils.loadAnimation(ah.getContext(), 2131034181);
    this.mjV.setDuration(250L);
    this.mjV.setFillAfter(true);
    this.mjF = paramString;
    int i;
    if (this.mjF == null)
    {
      i = 0;
      this.mjG = i;
      buU();
      if (!buT()) {
        break label367;
      }
    }
    label367:
    for (this.mjU = ((AnimationSet)AnimationUtils.loadAnimation(ah.getContext(), 2131034169));; this.mjU = ((AnimationSet)AnimationUtils.loadAnimation(ah.getContext(), 2131034170)))
    {
      paramString = new TranslateAnimation(0.0F, 0.0F, 0.0F, ah.getResources().getDimensionPixelSize(2131428407));
      paramString.setDuration(ah.getContext().getResources().getInteger(2131623945));
      this.mjU.addAnimation(paramString);
      ab.i("MicroMsg.NumberFaceMotion", "hy: starting read number: %s", new Object[] { this.mjF });
      AppMethodBeat.o(321);
      return;
      i = this.mjF.length();
      break;
    }
  }
  
  private TextView buS()
  {
    AppMethodBeat.i(323);
    if (this.lef != null)
    {
      TextView localTextView = (TextView)this.lef.findViewById(2131823891);
      AppMethodBeat.o(323);
      return localTextView;
    }
    AppMethodBeat.o(323);
    return null;
  }
  
  private boolean buT()
  {
    return this.mjG >= 6;
  }
  
  private void buU()
  {
    int i = 0;
    AppMethodBeat.i(322);
    if ((!bo.isNullOrNil(this.mjF)) && (buT()))
    {
      ab.i("MicroMsg.NumberFaceMotion", "hy: data too long. need to split into %d rounds", new Object[] { Integer.valueOf(2) });
      this.mjI = new String[2];
      int j = this.mjG / 2;
      while (i < 2)
      {
        this.mjI[i] = this.mjF.substring(j * i, (i + 1) * j);
        i += 1;
      }
      AppMethodBeat.o(322);
      return;
    }
    this.mjI = new String[1];
    this.mjI[0] = this.mjF;
    AppMethodBeat.o(322);
  }
  
  private void el(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(327);
    ab.i("MicroMsg.NumberFaceMotion", "alvinluo groupIndex: %d, itemDataLength: %d", new Object[] { Integer.valueOf(paramInt2), Integer.valueOf(paramInt1) });
    TextView localTextView;
    if (buS() != null)
    {
      if (paramInt1 == 1)
      {
        buS().setText(ah.getContext().getString(2131299591));
        AppMethodBeat.o(327);
        return;
      }
      localTextView = buS();
      if (paramInt2 != -1) {
        break label144;
      }
    }
    label144:
    for (String str = ah.getContext().getString(2131299590, new Object[] { vL(paramInt1) });; str = ah.getContext().getString(2131299589, new Object[] { vK(this.mjJ + 1) }))
    {
      localTextView.setText(str);
      if (paramInt2 > 0)
      {
        ab.i("MicroMsg.NumberFaceMotion", "alvinluo start %d group number", new Object[] { Integer.valueOf(paramInt2 + 1) });
        f.mhY.bux();
      }
      AppMethodBeat.o(327);
      return;
    }
  }
  
  private static String vK(int paramInt)
  {
    AppMethodBeat.i(326);
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.NumberFaceMotion", "hy: unknown length!!");
      AppMethodBeat.o(326);
      return "";
    case 1: 
      str = ah.getContext().getString(2131299584);
      AppMethodBeat.o(326);
      return str;
    case 2: 
      str = ah.getContext().getString(2131299585);
      AppMethodBeat.o(326);
      return str;
    case 3: 
      str = ah.getContext().getString(2131299587);
      AppMethodBeat.o(326);
      return str;
    }
    String str = ah.getContext().getString(2131299588);
    AppMethodBeat.o(326);
    return str;
  }
  
  private static String vL(int paramInt)
  {
    AppMethodBeat.i(330);
    switch (paramInt)
    {
    default: 
      str = vK(paramInt);
      AppMethodBeat.o(330);
      return str;
    }
    String str = ah.getContext().getString(2131299586);
    AppMethodBeat.o(330);
    return str;
  }
  
  public final void a(Context paramContext, ViewGroup paramViewGroup1, ViewGroup paramViewGroup2)
  {
    AppMethodBeat.i(325);
    ab.d("MicroMsg.NumberFaceMotion", "hy: on number init motion");
    this.lef = LayoutInflater.from(paramContext).inflate(2130969496, paramViewGroup2);
    this.mjL = ((FaceNumberView)this.lef.findViewById(2131823893));
    this.mjt = LayoutInflater.from(paramContext).inflate(2130969494, paramViewGroup1);
    el(this.mjI.length, -1);
    buS().startAnimation(this.mjS);
    if (this.mjL != null)
    {
      this.mjL.setVisibility(0);
      this.mjL.startAnimation(this.mjS);
      this.mjJ = 0;
      hs(false);
      this.mjK = -1;
      buV();
      this.mjM = bo.yB();
      this.mjN = bo.yB();
      this.eRq = false;
    }
    AppMethodBeat.o(325);
  }
  
  public final boolean a(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    this.mjP = true;
    return this.mjX;
  }
  
  public final boolean b(FaceCharacteristicsResult paramFaceCharacteristicsResult)
  {
    this.mjP = false;
    return this.mjX;
  }
  
  public final boolean buN()
  {
    return this.mjr;
  }
  
  public final boolean buO()
  {
    this.mjP = true;
    return this.mjX;
  }
  
  public final void buP()
  {
    AppMethodBeat.i(331);
    this.eRq = true;
    this.mjX = false;
    Object localObject1 = this.mjH;
    ((a)localObject1).mjh = true;
    ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: face start reset");
    for (;;)
    {
      try
      {
        if (((a)localObject1).ciR != null)
        {
          ((a)localObject1).ciR.Et();
          ((a)localObject1).ciR = null;
        }
        if (((a)localObject1).gbw != null)
        {
          ((a)localObject1).gbw.Fb();
          ((a)localObject1).gbw = null;
        }
        Object localObject2 = ((a)localObject1).gbF;
        if (localObject2 != null) {}
        try
        {
          ((a)localObject1).gbF.release();
          ((a)localObject1).gbF = null;
          ((a)localObject1).gcf = true;
          ((a)localObject1).gbr = 0;
          localObject1 = this.mjH;
          ab.i("MicroMsg.FaceVoiceRecordLogic", "hy: recycling voice.");
          ((a)localObject1).mjg = null;
          this.mjH.buL();
          if ((com.tencent.mm.plugin.facedetect.e.a.bvo().mnp) && (com.tencent.mm.plugin.facedetect.e.a.bvo().isStarted()))
          {
            localObject1 = this.mjH;
            localObject2 = com.tencent.mm.plugin.facedetect.e.a.bvo().bvp();
            ((a)localObject1).mjj.remove(localObject2);
            if (this.mjr) {
              com.tencent.mm.plugin.facedetect.e.a.bvo().a(null);
            }
          }
          else
          {
            this.mka.cancel();
            this.mjZ.removeCallbacksAndMessages(null);
            if (this.mjL != null)
            {
              localObject1 = this.mjL;
              if ((((FaceNumberView)localObject1).mpt != null) && (((FaceNumberView)localObject1).mpt.length > 0)) {
                break label303;
              }
            }
            if (this.lef != null)
            {
              this.mjr = false;
              this.mjM = -1L;
              this.lef = null;
              this.mjL = null;
            }
            AppMethodBeat.o(331);
            return;
          }
        }
        catch (Exception localException)
        {
          ab.printErrStackTrace("MicroMsg.FaceVoiceRecordLogic", localException, "mVoiceSilentDetectAPI.release error", new Object[0]);
          continue;
        }
        com.tencent.mm.plugin.facedetect.e.a.bvo().bvq();
      }
      finally
      {
        AppMethodBeat.o(331);
      }
      continue;
      label303:
      int i = 0;
      while (i < ((FaceNumberView)localObject1).mpt.length)
      {
        localObject1.mpt[i].bvB();
        i += 1;
      }
    }
  }
  
  public final b.b buQ()
  {
    AppMethodBeat.i(332);
    b.b localb = new b.b(90004, "user cancelled in processing");
    AppMethodBeat.o(332);
    return localb;
  }
  
  public final b.a buR()
  {
    return this.mjY;
  }
  
  final void buV()
  {
    AppMethodBeat.i(329);
    if (this.mjL != null)
    {
      if (this.mjJ >= 0)
      {
        this.mjL.Nu(this.mjI[this.mjJ].substring(0, this.mjK + 1));
        AppMethodBeat.o(329);
        return;
      }
      this.mjL.Nu(null);
    }
    AppMethodBeat.o(329);
  }
  
  final void buW()
  {
    AppMethodBeat.i(333);
    this.mka.start();
    AppMethodBeat.o(333);
  }
  
  final void hs(boolean paramBoolean)
  {
    AppMethodBeat.i(328);
    if (this.mjL != null)
    {
      el(this.mjI.length, this.mjJ);
      this.mjL.setNumberLengthAndInflate(this.mjI[this.mjJ].length());
      this.mjR = false;
      if (paramBoolean)
      {
        this.mjS.setAnimationListener(new d.4(this));
        if (this.lef != null)
        {
          this.lef.startAnimation(this.mjS);
          AppMethodBeat.o(328);
        }
      }
      else
      {
        al.p(new d.5(this), 500L);
      }
    }
    AppMethodBeat.o(328);
  }
  
  public final void setBusinessTip(String paramString)
  {
    AppMethodBeat.i(324);
    ((TextView)this.mjt.findViewById(2131823891)).setText(paramString);
    AppMethodBeat.o(324);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.d.d
 * JD-Core Version:    0.7.0.1
 */