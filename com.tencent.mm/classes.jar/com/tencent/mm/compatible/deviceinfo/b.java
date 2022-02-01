package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;

public final class b
{
  public int fWA;
  public int fWB;
  public int fWC;
  public int fWD;
  public int fWE;
  public int fWF;
  public int fWG;
  public int fWH;
  public int fWI;
  public int fWJ;
  public int fWK;
  public int fWL;
  public boolean fWM;
  public int fWN;
  public int fWO;
  public int fWP;
  public int fWQ;
  public int fWR;
  public int fWS;
  public int fWT;
  public int fWU;
  public int fWV;
  public int fWW;
  public int fWX;
  public int fWY;
  public int fWZ;
  public boolean fWh;
  public int fWi;
  public int fWj;
  public int fWk;
  public int fWl;
  public int fWm;
  public int fWn;
  public int fWo;
  public int fWp;
  public int fWq;
  public int fWr;
  public int fWs;
  public int fWt;
  public int fWu;
  public int fWv;
  public int fWw;
  public int fWx;
  public int fWy;
  public int fWz;
  public int fXA;
  public int fXB;
  public int fXC;
  public int fXD;
  public int fXE;
  public int fXF;
  public int fXG;
  public int fXH;
  public int fXI;
  public int fXJ;
  public int fXK;
  public int fXL;
  public int fXM;
  public int fXN;
  public int fXO;
  public int fXP;
  public int fXQ;
  public int fXR;
  public int fXS;
  public int fXT;
  public int fXU;
  public int fXV;
  public int fXW;
  public int fXX;
  public int fXY;
  public int fXZ;
  public int fXa;
  public int fXb;
  public int fXc;
  public int fXd;
  public int fXe;
  public int fXf;
  public int fXg;
  public int fXh;
  public int fXi;
  public int fXj;
  public int fXk;
  public int fXl;
  public int fXm;
  public int fXn;
  public int fXo;
  public int fXp;
  public int fXq;
  public short[] fXr;
  public short[] fXs;
  public boolean fXt;
  public int fXu;
  public boolean fXv;
  public int fXw;
  public int fXx;
  public int fXy;
  public int fXz;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.fWh = false;
    this.fXr = new short[15];
    this.fXs = new short[2];
    this.fXv = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final boolean ZN()
  {
    return ((this.fWj >= 0) && (this.fWk < 0)) || ((this.fWj < 0) && (this.fWk >= 0)) || (this.fWl > 0);
  }
  
  public final boolean ZO()
  {
    return this.fWm >= 0;
  }
  
  public final boolean ZP()
  {
    return this.fWn >= 0;
  }
  
  public final int ZQ()
  {
    AppMethodBeat.i(155633);
    if (ZO())
    {
      int i = (this.fWm & 0xE0) >> 5;
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
  
  public final boolean ZR()
  {
    AppMethodBeat.i(155634);
    if (ZO())
    {
      int i = this.fWm & 0x10;
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
  
  public final int ZS()
  {
    AppMethodBeat.i(155635);
    if (ZO())
    {
      int i = (this.fWm & 0xE) >> 1;
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
  
  public final boolean ZT()
  {
    AppMethodBeat.i(155636);
    if (ZO())
    {
      int i = this.fWm & 0x1;
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
  
  public final int ZU()
  {
    AppMethodBeat.i(155637);
    if (ZP())
    {
      int i = (this.fWn & 0xE0) >> 5;
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
  
  public final boolean ZV()
  {
    AppMethodBeat.i(155638);
    if (ZP())
    {
      int i = this.fWn & 0x10;
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
  
  public final int ZW()
  {
    AppMethodBeat.i(155639);
    if (ZP())
    {
      int i = (this.fWn & 0xE) >> 1;
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
  
  public final boolean ZX()
  {
    AppMethodBeat.i(155640);
    if (ZP())
    {
      int i = this.fWn & 0x1;
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
    ad.d("VoipAudioInfo", "streamtype " + this.fWi);
    ad.d("VoipAudioInfo", "smode " + this.fWj);
    ad.d("VoipAudioInfo", "omode " + this.fWk);
    ad.d("VoipAudioInfo", "ospeaker " + this.fWl);
    ad.d("VoipAudioInfo", "operating" + this.fWm);
    ad.d("VoipAudioInfo", "moperating" + this.fWn);
    ad.d("VoipAudioInfo", "mstreamtype" + this.fWo);
    ad.d("VoipAudioInfo", "mVoiceRecordMode" + this.fWp);
    ad.d("VoipAudioInfo", "agcMode :" + this.fWW);
    ad.d("VoipAudioInfo", "nsMode:" + this.fWs);
    ad.d("VoipAudioInfo", "aecMode:" + this.fWr);
    ad.d("VoipAudioInfo", "volumMode:" + this.fWt);
    ad.d("VoipAudioInfo", "micMode:" + this.fWF);
    ad.d("VoipAudioInfo", "sourceMode:" + this.fWG);
    ad.d("VoipAudioInfo", "speakerMode:" + this.fWH);
    ad.d("VoipAudioInfo", "phoneMode:" + this.fWI);
    ad.d("VoipAudioInfo", "voipstreamType:" + this.fWJ);
    ad.d("VoipAudioInfo", "speakerstreamtype:" + this.fWK);
    ad.d("VoipAudioInfo", "phonestreamtype:" + this.fWL);
    ad.d("VoipAudioInfo", "ringphonestream:" + this.fWN);
    ad.d("VoipAudioInfo", "ringphonemode:" + this.fWO);
    ad.d("VoipAudioInfo", "ringspeakerstream:" + this.fWP);
    ad.d("VoipAudioInfo", "ringspeakermode:" + this.fWQ);
    ad.d("VoipAudioInfo", "agcModeNew :" + this.fWV);
    ad.d("VoipAudioInfo", "nsModeNew:" + this.fWS);
    ad.d("VoipAudioInfo", "nsModeNewMulti:" + this.fWT);
    ad.d("VoipAudioInfo", "voipfullbandcfg:" + this.fWU);
    ad.d("VoipAudioInfo", "aecModeNew:" + this.fWR);
    ad.d("VoipAudioInfo", "agctargetdb:" + this.fWX);
    ad.d("VoipAudioInfo", "agcgaindb:" + this.fWY);
    ad.d("VoipAudioInfo", "agcflag:" + this.fWZ);
    ad.d("VoipAudioInfo", "agclimiter:" + this.fXa);
    ad.d("VoipAudioInfo", "agcCompRatio:" + this.fXb);
    ad.d("VoipAudioInfo", "agcDnGainThr:" + this.fXc);
    ad.d("VoipAudioInfo", "inputVolumeScale:" + this.fWu);
    ad.d("VoipAudioInfo", "outputVolumeScale:" + this.fWv);
    ad.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.fWw);
    ad.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.fWx);
    ad.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.fWA);
    ad.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.fWB);
    ad.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.fWC);
    ad.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.fWD);
    ad.d("VoipAudioInfo", "enableRecTimer:" + this.fXo);
    ad.d("VoipAudioInfo", "enablePlayTimer:" + this.fXp);
    ad.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.fXq);
    ad.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.fWy);
    ad.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.fWz);
    ad.d("VoipAudioInfo", "noisegateon" + this.fXt);
    ad.d("VoipAudioInfo", "noisegatestrength[0]" + this.fXs[0]);
    ad.d("VoipAudioInfo", "noisegatestrength[1]" + this.fXs[1]);
    ad.d("VoipAudioInfo", "spkecenable:" + this.fXu);
    ad.d("VoipAudioInfo", "agcRxFlag:" + this.fXC);
    ad.d("VoipAudioInfo", "agcRxTargetdb:" + this.fXD);
    ad.d("VoipAudioInfo", "agcRxGaindb:" + this.fXE);
    ad.d("VoipAudioInfo", "agcRxLimiter:" + this.fXF);
    ad.d("VoipAudioInfo", "enableXnoiseSup:" + this.fWE);
    ad.d("VoipAudioInfo", "mt3dFlag:" + this.fXG);
    ad.d("VoipAudioInfo", "mt3dAzim1:" + this.fXH);
    ad.d("VoipAudioInfo", "mt3dAzim2:" + this.fXI);
    ad.d("VoipAudioInfo", "mt3dAzim3:" + this.fXJ);
    ad.d("VoipAudioInfo", "mt3dAzim4:" + this.fXK);
    ad.d("VoipAudioInfo", "mt3dAzim5:" + this.fXL);
    ad.d("VoipAudioInfo", "mt3dAzim6:" + this.fXM);
    ad.d("VoipAudioInfo", "mt3dAzim7:" + this.fXN);
    ad.d("VoipAudioInfo", "mt3dAzim8:" + this.fXO);
    ad.d("VoipAudioInfo", "mt3dElvl1:" + this.fXP);
    ad.d("VoipAudioInfo", "mt3dElvl2:" + this.fXQ);
    ad.d("VoipAudioInfo", "mt3dElvl3:" + this.fXR);
    ad.d("VoipAudioInfo", "mt3dElvl4:" + this.fXS);
    ad.d("VoipAudioInfo", "mt3dElvl5:" + this.fXT);
    ad.d("VoipAudioInfo", "mt3dElvl6:" + this.fXU);
    ad.d("VoipAudioInfo", "mt3dElvl7:" + this.fXV);
    ad.d("VoipAudioInfo", "mt3dElvl8:" + this.fXW);
    ad.d("VoipAudioInfo", "mt3dPhi:" + this.fXX);
    ad.d("VoipAudioInfo", "mt3dtheta1:" + this.fXY);
    ad.d("VoipAudioInfo", "mt3dTheta2:" + this.fXZ);
    ad.d("VoipAudioInfo", "waveAgcMode" + this.fXd);
    ad.d("VoipAudioInfo", "waveAgcSpkGain" + this.fXe);
    ad.d("VoipAudioInfo", "waveAgcPhnGain" + this.fXf);
    ad.d("VoipAudioInfo", "waveAgcHeadsetGain" + this.fXg);
    ad.d("VoipAudioInfo", "waveAgcTarget" + this.fXh);
    ad.d("VoipAudioInfo", "waveAgcCRatio" + this.fXi);
    ad.d("VoipAudioInfo", "waveAgcDnTHR" + this.fXj);
    ad.d("VoipAudioInfo", "waveAgcBase" + this.fXk);
    ad.d("VoipAudioInfo", "waveAgcGainTHR" + this.fXl);
    ad.d("VoipAudioInfo", "waveAgcDampTHR" + this.fXm);
    ad.d("VoipAudioInfo", "waveAgcDamper" + this.fXn);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.fWh = false;
    this.fWi = -1;
    this.fWj = -1;
    this.fWk = -1;
    this.fWl = -1;
    this.fWm = -1;
    this.fWn = -1;
    this.fWo = -1;
    this.fWq = -1;
    this.fWp = -1;
    this.fWW = -1;
    this.fWr = -1;
    this.fWs = -1;
    this.fWt = -1;
    this.fWF = -1;
    this.fWG = -1;
    this.fWH = -1;
    this.fWI = -1;
    this.fWJ = -1;
    this.fWK = -1;
    this.fWL = -1;
    this.fWM = false;
    this.fWN = -1;
    this.fWO = -1;
    this.fWQ = -1;
    this.fWP = -1;
    this.fWV = -1;
    this.fWR = -1;
    this.fWS = -1;
    this.fWT = -1;
    this.fWU = -1;
    this.fWX = -1;
    this.fWY = -1;
    this.fWZ = -1;
    this.fXa = -1;
    this.fXb = -1;
    this.fXc = -1;
    this.fXd = -1;
    this.fXe = -1;
    this.fXf = -1;
    this.fXg = -1;
    this.fXh = -1;
    this.fXi = -1;
    this.fXj = -1;
    this.fXk = -1;
    this.fXl = -1;
    this.fXm = -1;
    this.fXn = -1;
    this.fWu = -1;
    this.fWv = -1;
    this.fWw = -1;
    this.fWx = -1;
    this.fWA = -1;
    this.fWB = -1;
    this.fWC = -1;
    this.fWD = -1;
    this.fXo = 0;
    this.fXp = 0;
    this.fXq = -1;
    this.fWz = -1;
    this.fWy = -1;
    this.fXt = false;
    this.fXs[0] = -1;
    this.fXs[1] = -1;
    this.fXu = -1;
    this.fXC = -1;
    this.fXD = -1;
    this.fXE = -1;
    this.fXF = -1;
    this.fWE = -1;
    this.fXG = -1;
    this.fXH = -1;
    this.fXI = -1;
    this.fXJ = -1;
    this.fXK = -1;
    this.fXL = -1;
    this.fXM = -1;
    this.fXN = -1;
    this.fXO = -1;
    this.fXP = -1;
    this.fXQ = -1;
    this.fXR = -1;
    this.fXS = -1;
    this.fXT = -1;
    this.fXU = -1;
    this.fXV = -1;
    this.fXW = -1;
    this.fXX = -1;
    this.fXY = -1;
    this.fXZ = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */