package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public boolean lQS;
  public int lQT;
  public int lQU;
  public int lQV;
  public int lQW;
  public int lQX;
  public int lQY;
  public int lQZ;
  public int lRA;
  public boolean lRB;
  public int lRC;
  public int lRD;
  public int lRE;
  public int lRF;
  public int lRG;
  public int lRH;
  public int lRI;
  public int lRJ;
  public int lRK;
  public int lRL;
  public int lRM;
  public int lRN;
  public int lRO;
  public int lRP;
  public int lRQ;
  public int lRR;
  public int lRS;
  public int lRT;
  public int lRU;
  public int lRV;
  public int lRW;
  public int lRX;
  public int lRY;
  public int lRZ;
  public int lRa;
  public int lRb;
  public int lRc;
  public int lRd;
  public int lRe;
  public int lRf;
  public int lRg;
  public int lRh;
  public int lRi;
  public int lRj;
  public int lRk;
  public int lRl;
  public int lRm;
  public int lRn;
  public int lRo;
  public int lRp;
  public int lRq;
  public int lRr;
  public int lRs;
  public int lRt;
  public int lRu;
  public int lRv;
  public int lRw;
  public int lRx;
  public int lRy;
  public int lRz;
  public int lSA;
  public int lSB;
  public int lSC;
  public int lSD;
  public int lSE;
  public int lSF;
  public int lSG;
  public int lSH;
  public int lSI;
  public int lSJ;
  public int lSK;
  public int lSL;
  public int lSM;
  public int lSN;
  public int lSO;
  public int lSa;
  public int lSb;
  public int lSc;
  public int lSd;
  public int lSe;
  public int lSf;
  public short[] lSg;
  public short[] lSh;
  public boolean lSi;
  public int lSj;
  public boolean lSk;
  public int lSl;
  public int lSm;
  public int lSn;
  public int lSo;
  public int lSp;
  public int lSq;
  public int lSr;
  public int lSs;
  public int lSt;
  public int lSu;
  public int lSv;
  public int lSw;
  public int lSx;
  public int lSy;
  public int lSz;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.lQS = false;
    this.lRl = -1;
    this.lRm = -1;
    this.lRn = -1;
    this.lRo = -1;
    this.lSg = new short[15];
    this.lSh = new short[2];
    this.lSk = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final int aOA()
  {
    AppMethodBeat.i(155635);
    if (aOw())
    {
      int i = (this.lQX & 0xE) >> 1;
      Log.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aOB()
  {
    AppMethodBeat.i(155636);
    if (aOw())
    {
      int i = this.lQX & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("VoipAudioInfo", bool);
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
  
  public final int aOC()
  {
    AppMethodBeat.i(155637);
    if (aOx())
    {
      int i = (this.lQY & 0xE0) >> 5;
      Log.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aOD()
  {
    AppMethodBeat.i(155638);
    if (aOx())
    {
      int i = this.lQY & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("VoipAudioInfo", bool);
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
  
  public final int aOE()
  {
    AppMethodBeat.i(155639);
    if (aOx())
    {
      int i = (this.lQY & 0xE) >> 1;
      Log.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aOF()
  {
    AppMethodBeat.i(155640);
    if (aOx())
    {
      int i = this.lQY & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("VoipAudioInfo", bool);
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
  
  public final boolean aOv()
  {
    return ((this.lQU >= 0) && (this.lQV < 0)) || ((this.lQU < 0) && (this.lQV >= 0)) || (this.lQW > 0);
  }
  
  public final boolean aOw()
  {
    return this.lQX >= 0;
  }
  
  public final boolean aOx()
  {
    return this.lQY >= 0;
  }
  
  public final int aOy()
  {
    AppMethodBeat.i(155633);
    if (aOw())
    {
      int i = (this.lQX & 0xE0) >> 5;
      Log.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aOz()
  {
    AppMethodBeat.i(155634);
    if (aOw())
    {
      int i = this.lQX & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        Log.d("VoipAudioInfo", bool);
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
  
  public final void aQ()
  {
    AppMethodBeat.i(155641);
    Log.d("VoipAudioInfo", "streamtype " + this.lQT);
    Log.d("VoipAudioInfo", "smode " + this.lQU);
    Log.d("VoipAudioInfo", "omode " + this.lQV);
    Log.d("VoipAudioInfo", "ospeaker " + this.lQW);
    Log.d("VoipAudioInfo", "operating" + this.lQX);
    Log.d("VoipAudioInfo", "moperating" + this.lQY);
    Log.d("VoipAudioInfo", "mstreamtype" + this.lQZ);
    Log.d("VoipAudioInfo", "mVoiceRecordMode" + this.lRa);
    Log.d("VoipAudioInfo", "agcMode :" + this.lRL);
    Log.d("VoipAudioInfo", "nsMode:" + this.lRd);
    Log.d("VoipAudioInfo", "aecMode:" + this.lRc);
    Log.d("VoipAudioInfo", "volumMode:" + this.lRe);
    Log.d("VoipAudioInfo", "micMode:" + this.lRu);
    Log.d("VoipAudioInfo", "sourceMode:" + this.lRv);
    Log.d("VoipAudioInfo", "speakerMode:" + this.lRw);
    Log.d("VoipAudioInfo", "phoneMode:" + this.lRx);
    Log.d("VoipAudioInfo", "voipstreamType:" + this.lRy);
    Log.d("VoipAudioInfo", "speakerstreamtype:" + this.lRz);
    Log.d("VoipAudioInfo", "phonestreamtype:" + this.lRA);
    Log.d("VoipAudioInfo", "ringphonestream:" + this.lRC);
    Log.d("VoipAudioInfo", "ringphonemode:" + this.lRD);
    Log.d("VoipAudioInfo", "ringspeakerstream:" + this.lRE);
    Log.d("VoipAudioInfo", "ringspeakermode:" + this.lRF);
    Log.d("VoipAudioInfo", "agcModeNew :" + this.lRK);
    Log.d("VoipAudioInfo", "nsModeNew:" + this.lRH);
    Log.d("VoipAudioInfo", "nsModeNewMulti:" + this.lRI);
    Log.d("VoipAudioInfo", "voipfullbandcfg:" + this.lRJ);
    Log.d("VoipAudioInfo", "aecModeNew:" + this.lRG);
    Log.d("VoipAudioInfo", "agctargetdb:" + this.lRM);
    Log.d("VoipAudioInfo", "agcgaindb:" + this.lRN);
    Log.d("VoipAudioInfo", "agcflag:" + this.lRO);
    Log.d("VoipAudioInfo", "agclimiter:" + this.lRP);
    Log.d("VoipAudioInfo", "agcCompRatio:" + this.lRQ);
    Log.d("VoipAudioInfo", "agcDnGainThr:" + this.lRR);
    Log.d("VoipAudioInfo", "inputVolumeScale:" + this.lRf);
    Log.d("VoipAudioInfo", "outputVolumeScale:" + this.lRg);
    Log.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.lRh);
    Log.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.lRi);
    Log.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.lRp);
    Log.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.lRq);
    Log.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.lRr);
    Log.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.lRs);
    Log.d("VoipAudioInfo", "enableRecTimer:" + this.lSd);
    Log.d("VoipAudioInfo", "enablePlayTimer:" + this.lSe);
    Log.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.lSf);
    Log.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.lRj);
    Log.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.lRk);
    Log.d("VoipAudioInfo", "noisegateon" + this.lSi);
    Log.d("VoipAudioInfo", "noisegatestrength[0]" + this.lSh[0]);
    Log.d("VoipAudioInfo", "noisegatestrength[1]" + this.lSh[1]);
    Log.d("VoipAudioInfo", "spkecenable:" + this.lSj);
    Log.d("VoipAudioInfo", "agcRxFlag:" + this.lSr);
    Log.d("VoipAudioInfo", "agcRxTargetdb:" + this.lSs);
    Log.d("VoipAudioInfo", "agcRxGaindb:" + this.lSt);
    Log.d("VoipAudioInfo", "agcRxLimiter:" + this.lSu);
    Log.d("VoipAudioInfo", "enableXnoiseSup:" + this.lRt);
    Log.d("VoipAudioInfo", "mt3dFlag:" + this.lSv);
    Log.d("VoipAudioInfo", "mt3dAzim1:" + this.lSw);
    Log.d("VoipAudioInfo", "mt3dAzim2:" + this.lSx);
    Log.d("VoipAudioInfo", "mt3dAzim3:" + this.lSy);
    Log.d("VoipAudioInfo", "mt3dAzim4:" + this.lSz);
    Log.d("VoipAudioInfo", "mt3dAzim5:" + this.lSA);
    Log.d("VoipAudioInfo", "mt3dAzim6:" + this.lSB);
    Log.d("VoipAudioInfo", "mt3dAzim7:" + this.lSC);
    Log.d("VoipAudioInfo", "mt3dAzim8:" + this.lSD);
    Log.d("VoipAudioInfo", "mt3dElvl1:" + this.lSE);
    Log.d("VoipAudioInfo", "mt3dElvl2:" + this.lSF);
    Log.d("VoipAudioInfo", "mt3dElvl3:" + this.lSG);
    Log.d("VoipAudioInfo", "mt3dElvl4:" + this.lSH);
    Log.d("VoipAudioInfo", "mt3dElvl5:" + this.lSI);
    Log.d("VoipAudioInfo", "mt3dElvl6:" + this.lSJ);
    Log.d("VoipAudioInfo", "mt3dElvl7:" + this.lSK);
    Log.d("VoipAudioInfo", "mt3dElvl8:" + this.lSL);
    Log.d("VoipAudioInfo", "mt3dPhi:" + this.lSM);
    Log.d("VoipAudioInfo", "mt3dtheta1:" + this.lSN);
    Log.d("VoipAudioInfo", "mt3dTheta2:" + this.lSO);
    Log.d("VoipAudioInfo", "waveAgcMode" + this.lRS);
    Log.d("VoipAudioInfo", "waveAgcSpkGain" + this.lRT);
    Log.d("VoipAudioInfo", "waveAgcPhnGain" + this.lRU);
    Log.d("VoipAudioInfo", "waveAgcHeadsetGain" + this.lRV);
    Log.d("VoipAudioInfo", "waveAgcTarget" + this.lRW);
    Log.d("VoipAudioInfo", "waveAgcCRatio" + this.lRX);
    Log.d("VoipAudioInfo", "waveAgcDnTHR" + this.lRY);
    Log.d("VoipAudioInfo", "waveAgcBase" + this.lRZ);
    Log.d("VoipAudioInfo", "waveAgcGainTHR" + this.lSa);
    Log.d("VoipAudioInfo", "waveAgcDampTHR" + this.lSb);
    Log.d("VoipAudioInfo", "waveAgcDamper" + this.lSc);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.lQS = false;
    this.lQT = -1;
    this.lQU = -1;
    this.lQV = -1;
    this.lQW = -1;
    this.lQX = -1;
    this.lQY = -1;
    this.lQZ = -1;
    this.lRb = -1;
    this.lRa = -1;
    this.lRL = -1;
    this.lRc = -1;
    this.lRd = -1;
    this.lRe = -1;
    this.lRu = -1;
    this.lRv = -1;
    this.lRw = -1;
    this.lRx = -1;
    this.lRy = -1;
    this.lRz = -1;
    this.lRA = -1;
    this.lRB = false;
    this.lRC = -1;
    this.lRD = -1;
    this.lRF = -1;
    this.lRE = -1;
    this.lRK = -1;
    this.lRG = -1;
    this.lRH = -1;
    this.lRI = -1;
    this.lRJ = -1;
    this.lRM = -1;
    this.lRN = -1;
    this.lRO = -1;
    this.lRP = -1;
    this.lRQ = -1;
    this.lRR = -1;
    this.lRS = -1;
    this.lRT = -1;
    this.lRU = -1;
    this.lRV = -1;
    this.lRW = -1;
    this.lRX = -1;
    this.lRY = -1;
    this.lRZ = -1;
    this.lSa = -1;
    this.lSb = -1;
    this.lSc = -1;
    this.lRf = -1;
    this.lRg = -1;
    this.lRh = -1;
    this.lRi = -1;
    this.lRp = -1;
    this.lRq = -1;
    this.lRr = -1;
    this.lRs = -1;
    this.lSd = 0;
    this.lSe = 0;
    this.lSf = -1;
    this.lRk = -1;
    this.lRj = -1;
    this.lSi = false;
    this.lSh[0] = -1;
    this.lSh[1] = -1;
    this.lSj = -1;
    this.lSr = -1;
    this.lSs = -1;
    this.lSt = -1;
    this.lSu = -1;
    this.lRt = -1;
    this.lSv = -1;
    this.lSw = -1;
    this.lSx = -1;
    this.lSy = -1;
    this.lSz = -1;
    this.lSA = -1;
    this.lSB = -1;
    this.lSC = -1;
    this.lSD = -1;
    this.lSE = -1;
    this.lSF = -1;
    this.lSG = -1;
    this.lSH = -1;
    this.lSI = -1;
    this.lSJ = -1;
    this.lSK = -1;
    this.lSL = -1;
    this.lSM = -1;
    this.lSN = -1;
    this.lSO = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */