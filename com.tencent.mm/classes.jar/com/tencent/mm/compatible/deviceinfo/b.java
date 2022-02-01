package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public int fAA;
  public int fAB;
  public int fAC;
  public int fAD;
  public int fAE;
  public int fAF;
  public int fAG;
  public int fAH;
  public int fAI;
  public int fAJ;
  public int fAK;
  public int fAL;
  public int fAM;
  public int fAN;
  public int fAO;
  public int fAP;
  public int fAQ;
  public int fAR;
  public int fAS;
  public int fAT;
  public int fAa;
  public int fAb;
  public int fAc;
  public int fAd;
  public int fAe;
  public int fAf;
  public int fAg;
  public int fAh;
  public int fAi;
  public int fAj;
  public int fAk;
  public short[] fAl;
  public short[] fAm;
  public boolean fAn;
  public int fAo;
  public boolean fAp;
  public int fAq;
  public int fAr;
  public int fAs;
  public int fAt;
  public int fAu;
  public int fAv;
  public int fAw;
  public int fAx;
  public int fAy;
  public int fAz;
  public int fzA;
  public int fzB;
  public int fzC;
  public int fzD;
  public int fzE;
  public int fzF;
  public int fzG;
  public int fzH;
  public int fzI;
  public int fzJ;
  public int fzK;
  public int fzL;
  public int fzM;
  public int fzN;
  public int fzO;
  public int fzP;
  public int fzQ;
  public boolean fzR;
  public int fzS;
  public int fzT;
  public int fzU;
  public int fzV;
  public int fzW;
  public int fzX;
  public int fzY;
  public int fzZ;
  public boolean fzm;
  public int fzn;
  public int fzo;
  public int fzp;
  public int fzq;
  public int fzr;
  public int fzs;
  public int fzt;
  public int fzu;
  public int fzv;
  public int fzw;
  public int fzx;
  public int fzy;
  public int fzz;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.fzm = false;
    this.fAl = new short[15];
    this.fAm = new short[2];
    this.fAp = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final boolean Wo()
  {
    return ((this.fzo >= 0) && (this.fzp < 0)) || ((this.fzo < 0) && (this.fzp >= 0)) || (this.fzq > 0);
  }
  
  public final boolean Wp()
  {
    return this.fzr >= 0;
  }
  
  public final boolean Wq()
  {
    return this.fzs >= 0;
  }
  
  public final int Wr()
  {
    AppMethodBeat.i(155633);
    if (Wp())
    {
      int i = (this.fzr & 0xE0) >> 5;
      ad.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(155633);
        return -1;
      }
      AppMethodBeat.o(155633);
      return i;
    }
    AppMethodBeat.o(155633);
    return -1;
  }
  
  public final boolean Ws()
  {
    AppMethodBeat.i(155634);
    if (Wp())
    {
      int i = this.fzr & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(155634);
        return true;
      }
      AppMethodBeat.o(155634);
      return false;
    }
    AppMethodBeat.o(155634);
    return false;
  }
  
  public final int Wt()
  {
    AppMethodBeat.i(155635);
    if (Wp())
    {
      int i = (this.fzr & 0xE) >> 1;
      ad.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(155635);
        return -1;
      }
      AppMethodBeat.o(155635);
      return i;
    }
    AppMethodBeat.o(155635);
    return -1;
  }
  
  public final boolean Wu()
  {
    AppMethodBeat.i(155636);
    if (Wp())
    {
      int i = this.fzr & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(155636);
        return true;
      }
      AppMethodBeat.o(155636);
      return false;
    }
    AppMethodBeat.o(155636);
    return false;
  }
  
  public final int Wv()
  {
    AppMethodBeat.i(155637);
    if (Wq())
    {
      int i = (this.fzs & 0xE0) >> 5;
      ad.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(155637);
        return -1;
      }
      AppMethodBeat.o(155637);
      return i;
    }
    AppMethodBeat.o(155637);
    return -1;
  }
  
  public final boolean Ww()
  {
    AppMethodBeat.i(155638);
    if (Wq())
    {
      int i = this.fzs & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(155638);
        return true;
      }
      AppMethodBeat.o(155638);
      return false;
    }
    AppMethodBeat.o(155638);
    return false;
  }
  
  public final int Wx()
  {
    AppMethodBeat.i(155639);
    if (Wq())
    {
      int i = (this.fzs & 0xE) >> 1;
      ad.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(155639);
        return -1;
      }
      AppMethodBeat.o(155639);
      return i;
    }
    AppMethodBeat.o(155639);
    return -1;
  }
  
  public final boolean Wy()
  {
    AppMethodBeat.i(155640);
    if (Wq())
    {
      int i = this.fzs & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ad.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(155640);
        return true;
      }
      AppMethodBeat.o(155640);
      return false;
    }
    AppMethodBeat.o(155640);
    return false;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(155641);
    ad.d("VoipAudioInfo", "streamtype " + this.fzn);
    ad.d("VoipAudioInfo", "smode " + this.fzo);
    ad.d("VoipAudioInfo", "omode " + this.fzp);
    ad.d("VoipAudioInfo", "ospeaker " + this.fzq);
    ad.d("VoipAudioInfo", "operating" + this.fzr);
    ad.d("VoipAudioInfo", "moperating" + this.fzs);
    ad.d("VoipAudioInfo", "mstreamtype" + this.fzt);
    ad.d("VoipAudioInfo", "mVoiceRecordMode" + this.fzu);
    ad.d("VoipAudioInfo", "agcMode :" + this.fAb);
    ad.d("VoipAudioInfo", "nsMode:" + this.fzx);
    ad.d("VoipAudioInfo", "aecMode:" + this.fzw);
    ad.d("VoipAudioInfo", "volumMode:" + this.fzy);
    ad.d("VoipAudioInfo", "micMode:" + this.fzK);
    ad.d("VoipAudioInfo", "sourceMode:" + this.fzL);
    ad.d("VoipAudioInfo", "speakerMode:" + this.fzM);
    ad.d("VoipAudioInfo", "phoneMode:" + this.fzN);
    ad.d("VoipAudioInfo", "voipstreamType:" + this.fzO);
    ad.d("VoipAudioInfo", "speakerstreamtype:" + this.fzP);
    ad.d("VoipAudioInfo", "phonestreamtype:" + this.fzQ);
    ad.d("VoipAudioInfo", "ringphonestream:" + this.fzS);
    ad.d("VoipAudioInfo", "ringphonemode:" + this.fzT);
    ad.d("VoipAudioInfo", "ringspeakerstream:" + this.fzU);
    ad.d("VoipAudioInfo", "ringspeakermode:" + this.fzV);
    ad.d("VoipAudioInfo", "agcModeNew :" + this.fAa);
    ad.d("VoipAudioInfo", "nsModeNew:" + this.fzX);
    ad.d("VoipAudioInfo", "nsModeNewMulti:" + this.fzY);
    ad.d("VoipAudioInfo", "voipfullbandcfg:" + this.fzZ);
    ad.d("VoipAudioInfo", "aecModeNew:" + this.fzW);
    ad.d("VoipAudioInfo", "agctargetdb:" + this.fAc);
    ad.d("VoipAudioInfo", "agcgaindb:" + this.fAd);
    ad.d("VoipAudioInfo", "agcflag:" + this.fAe);
    ad.d("VoipAudioInfo", "agclimiter:" + this.fAf);
    ad.d("VoipAudioInfo", "agcCompRatio:" + this.fAg);
    ad.d("VoipAudioInfo", "agcDnGainThr:" + this.fAh);
    ad.d("VoipAudioInfo", "inputVolumeScale:" + this.fzz);
    ad.d("VoipAudioInfo", "outputVolumeScale:" + this.fzA);
    ad.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.fzB);
    ad.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.fzC);
    ad.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.fzF);
    ad.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.fzG);
    ad.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.fzH);
    ad.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.fzI);
    ad.d("VoipAudioInfo", "enableRecTimer:" + this.fAi);
    ad.d("VoipAudioInfo", "enablePlayTimer:" + this.fAj);
    ad.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.fAk);
    ad.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.fzD);
    ad.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.fzE);
    ad.d("VoipAudioInfo", "noisegateon" + this.fAn);
    ad.d("VoipAudioInfo", "noisegatestrength[0]" + this.fAm[0]);
    ad.d("VoipAudioInfo", "noisegatestrength[1]" + this.fAm[1]);
    ad.d("VoipAudioInfo", "spkecenable:" + this.fAo);
    ad.d("VoipAudioInfo", "agcRxFlag:" + this.fAw);
    ad.d("VoipAudioInfo", "agcRxTargetdb:" + this.fAx);
    ad.d("VoipAudioInfo", "agcRxGaindb:" + this.fAy);
    ad.d("VoipAudioInfo", "agcRxLimiter:" + this.fAz);
    ad.d("VoipAudioInfo", "enableXnoiseSup:" + this.fzJ);
    ad.d("VoipAudioInfo", "mt3dFlag:" + this.fAA);
    ad.d("VoipAudioInfo", "mt3dAzim1:" + this.fAB);
    ad.d("VoipAudioInfo", "mt3dAzim2:" + this.fAC);
    ad.d("VoipAudioInfo", "mt3dAzim3:" + this.fAD);
    ad.d("VoipAudioInfo", "mt3dAzim4:" + this.fAE);
    ad.d("VoipAudioInfo", "mt3dAzim5:" + this.fAF);
    ad.d("VoipAudioInfo", "mt3dAzim6:" + this.fAG);
    ad.d("VoipAudioInfo", "mt3dAzim7:" + this.fAH);
    ad.d("VoipAudioInfo", "mt3dAzim8:" + this.fAI);
    ad.d("VoipAudioInfo", "mt3dElvl1:" + this.fAJ);
    ad.d("VoipAudioInfo", "mt3dElvl2:" + this.fAK);
    ad.d("VoipAudioInfo", "mt3dElvl3:" + this.fAL);
    ad.d("VoipAudioInfo", "mt3dElvl4:" + this.fAM);
    ad.d("VoipAudioInfo", "mt3dElvl5:" + this.fAN);
    ad.d("VoipAudioInfo", "mt3dElvl6:" + this.fAO);
    ad.d("VoipAudioInfo", "mt3dElvl7:" + this.fAP);
    ad.d("VoipAudioInfo", "mt3dElvl8:" + this.fAQ);
    ad.d("VoipAudioInfo", "mt3dPhi:" + this.fAR);
    ad.d("VoipAudioInfo", "mt3dtheta1:" + this.fAS);
    ad.d("VoipAudioInfo", "mt3dTheta2:" + this.fAT);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.fzm = false;
    this.fzn = -1;
    this.fzo = -1;
    this.fzp = -1;
    this.fzq = -1;
    this.fzr = -1;
    this.fzs = -1;
    this.fzt = -1;
    this.fzv = -1;
    this.fzu = -1;
    this.fAb = -1;
    this.fzw = -1;
    this.fzx = -1;
    this.fzy = -1;
    this.fzK = -1;
    this.fzL = -1;
    this.fzM = -1;
    this.fzN = -1;
    this.fzO = -1;
    this.fzP = -1;
    this.fzQ = -1;
    this.fzR = false;
    this.fzS = -1;
    this.fzT = -1;
    this.fzV = -1;
    this.fzU = -1;
    this.fAa = -1;
    this.fzW = -1;
    this.fzX = -1;
    this.fzY = -1;
    this.fzZ = -1;
    this.fAc = -1;
    this.fAd = -1;
    this.fAe = -1;
    this.fAf = -1;
    this.fAg = -1;
    this.fAh = -1;
    this.fzz = -1;
    this.fzA = -1;
    this.fzB = -1;
    this.fzC = -1;
    this.fzF = -1;
    this.fzG = -1;
    this.fzH = -1;
    this.fzI = -1;
    this.fAi = 0;
    this.fAj = 0;
    this.fAk = -1;
    this.fzE = -1;
    this.fzD = -1;
    this.fAn = false;
    this.fAm[0] = -1;
    this.fAm[1] = -1;
    this.fAo = -1;
    this.fAw = -1;
    this.fAx = -1;
    this.fAy = -1;
    this.fAz = -1;
    this.fzJ = -1;
    this.fAA = -1;
    this.fAB = -1;
    this.fAC = -1;
    this.fAD = -1;
    this.fAE = -1;
    this.fAF = -1;
    this.fAG = -1;
    this.fAH = -1;
    this.fAI = -1;
    this.fAJ = -1;
    this.fAK = -1;
    this.fAL = -1;
    this.fAM = -1;
    this.fAN = -1;
    this.fAO = -1;
    this.fAP = -1;
    this.fAQ = -1;
    this.fAR = -1;
    this.fAS = -1;
    this.fAT = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */