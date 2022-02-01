package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public boolean gDA;
  public int gDB;
  public int gDC;
  public int gDD;
  public int gDE;
  public int gDF;
  public int gDG;
  public int gDH;
  public int gDI;
  public int gDJ;
  public int gDK;
  public int gDL;
  public int gDM;
  public int gDN;
  public int gDO;
  public int gDP;
  public int gDQ;
  public int gDR;
  public int gDS;
  public int gDT;
  public int gDU;
  public int gDV;
  public int gDW;
  public int gDX;
  public int gDY;
  public int gDZ;
  public int gEA;
  public int gEB;
  public int gEC;
  public int gED;
  public int gEE;
  public int gEF;
  public int gEG;
  public int gEH;
  public int gEI;
  public int gEJ;
  public int gEK;
  public int gEL;
  public int gEM;
  public int gEN;
  public short[] gEO;
  public short[] gEP;
  public boolean gEQ;
  public int gER;
  public boolean gES;
  public int gET;
  public int gEU;
  public int gEV;
  public int gEW;
  public int gEX;
  public int gEY;
  public int gEZ;
  public int gEa;
  public int gEb;
  public int gEc;
  public int gEd;
  public int gEe;
  public int gEf;
  public int gEg;
  public int gEh;
  public int gEi;
  public boolean gEj;
  public int gEk;
  public int gEl;
  public int gEm;
  public int gEn;
  public int gEo;
  public int gEp;
  public int gEq;
  public int gEr;
  public int gEs;
  public int gEt;
  public int gEu;
  public int gEv;
  public int gEw;
  public int gEx;
  public int gEy;
  public int gEz;
  public int gFa;
  public int gFb;
  public int gFc;
  public int gFd;
  public int gFe;
  public int gFf;
  public int gFg;
  public int gFh;
  public int gFi;
  public int gFj;
  public int gFk;
  public int gFl;
  public int gFm;
  public int gFn;
  public int gFo;
  public int gFp;
  public int gFq;
  public int gFr;
  public int gFs;
  public int gFt;
  public int gFu;
  public int gFv;
  public int gFw;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.gDA = false;
    this.gDT = -1;
    this.gDU = -1;
    this.gDV = -1;
    this.gDW = -1;
    this.gEO = new short[15];
    this.gEP = new short[2];
    this.gES = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final boolean anV()
  {
    return ((this.gDC >= 0) && (this.gDD < 0)) || ((this.gDC < 0) && (this.gDD >= 0)) || (this.gDE > 0);
  }
  
  public final boolean anW()
  {
    return this.gDF >= 0;
  }
  
  public final boolean anX()
  {
    return this.gDG >= 0;
  }
  
  public final int anY()
  {
    AppMethodBeat.i(155633);
    if (anW())
    {
      int i = (this.gDF & 0xE0) >> 5;
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
  
  public final boolean anZ()
  {
    AppMethodBeat.i(155634);
    if (anW())
    {
      int i = this.gDF & 0x10;
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
  
  public final int aoa()
  {
    AppMethodBeat.i(155635);
    if (anW())
    {
      int i = (this.gDF & 0xE) >> 1;
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
  
  public final boolean aob()
  {
    AppMethodBeat.i(155636);
    if (anW())
    {
      int i = this.gDF & 0x1;
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
  
  public final int aoc()
  {
    AppMethodBeat.i(155637);
    if (anX())
    {
      int i = (this.gDG & 0xE0) >> 5;
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
  
  public final boolean aod()
  {
    AppMethodBeat.i(155638);
    if (anX())
    {
      int i = this.gDG & 0x10;
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
  
  public final int aoe()
  {
    AppMethodBeat.i(155639);
    if (anX())
    {
      int i = (this.gDG & 0xE) >> 1;
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
  
  public final boolean aof()
  {
    AppMethodBeat.i(155640);
    if (anX())
    {
      int i = this.gDG & 0x1;
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
  
  public final void dump()
  {
    AppMethodBeat.i(155641);
    Log.d("VoipAudioInfo", "streamtype " + this.gDB);
    Log.d("VoipAudioInfo", "smode " + this.gDC);
    Log.d("VoipAudioInfo", "omode " + this.gDD);
    Log.d("VoipAudioInfo", "ospeaker " + this.gDE);
    Log.d("VoipAudioInfo", "operating" + this.gDF);
    Log.d("VoipAudioInfo", "moperating" + this.gDG);
    Log.d("VoipAudioInfo", "mstreamtype" + this.gDH);
    Log.d("VoipAudioInfo", "mVoiceRecordMode" + this.gDI);
    Log.d("VoipAudioInfo", "agcMode :" + this.gEt);
    Log.d("VoipAudioInfo", "nsMode:" + this.gDL);
    Log.d("VoipAudioInfo", "aecMode:" + this.gDK);
    Log.d("VoipAudioInfo", "volumMode:" + this.gDM);
    Log.d("VoipAudioInfo", "micMode:" + this.gEc);
    Log.d("VoipAudioInfo", "sourceMode:" + this.gEd);
    Log.d("VoipAudioInfo", "speakerMode:" + this.gEe);
    Log.d("VoipAudioInfo", "phoneMode:" + this.gEf);
    Log.d("VoipAudioInfo", "voipstreamType:" + this.gEg);
    Log.d("VoipAudioInfo", "speakerstreamtype:" + this.gEh);
    Log.d("VoipAudioInfo", "phonestreamtype:" + this.gEi);
    Log.d("VoipAudioInfo", "ringphonestream:" + this.gEk);
    Log.d("VoipAudioInfo", "ringphonemode:" + this.gEl);
    Log.d("VoipAudioInfo", "ringspeakerstream:" + this.gEm);
    Log.d("VoipAudioInfo", "ringspeakermode:" + this.gEn);
    Log.d("VoipAudioInfo", "agcModeNew :" + this.gEs);
    Log.d("VoipAudioInfo", "nsModeNew:" + this.gEp);
    Log.d("VoipAudioInfo", "nsModeNewMulti:" + this.gEq);
    Log.d("VoipAudioInfo", "voipfullbandcfg:" + this.gEr);
    Log.d("VoipAudioInfo", "aecModeNew:" + this.gEo);
    Log.d("VoipAudioInfo", "agctargetdb:" + this.gEu);
    Log.d("VoipAudioInfo", "agcgaindb:" + this.gEv);
    Log.d("VoipAudioInfo", "agcflag:" + this.gEw);
    Log.d("VoipAudioInfo", "agclimiter:" + this.gEx);
    Log.d("VoipAudioInfo", "agcCompRatio:" + this.gEy);
    Log.d("VoipAudioInfo", "agcDnGainThr:" + this.gEz);
    Log.d("VoipAudioInfo", "inputVolumeScale:" + this.gDN);
    Log.d("VoipAudioInfo", "outputVolumeScale:" + this.gDO);
    Log.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.gDP);
    Log.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.gDQ);
    Log.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.gDX);
    Log.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.gDY);
    Log.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.gDZ);
    Log.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.gEa);
    Log.d("VoipAudioInfo", "enableRecTimer:" + this.gEL);
    Log.d("VoipAudioInfo", "enablePlayTimer:" + this.gEM);
    Log.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.gEN);
    Log.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.gDR);
    Log.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.gDS);
    Log.d("VoipAudioInfo", "noisegateon" + this.gEQ);
    Log.d("VoipAudioInfo", "noisegatestrength[0]" + this.gEP[0]);
    Log.d("VoipAudioInfo", "noisegatestrength[1]" + this.gEP[1]);
    Log.d("VoipAudioInfo", "spkecenable:" + this.gER);
    Log.d("VoipAudioInfo", "agcRxFlag:" + this.gEZ);
    Log.d("VoipAudioInfo", "agcRxTargetdb:" + this.gFa);
    Log.d("VoipAudioInfo", "agcRxGaindb:" + this.gFb);
    Log.d("VoipAudioInfo", "agcRxLimiter:" + this.gFc);
    Log.d("VoipAudioInfo", "enableXnoiseSup:" + this.gEb);
    Log.d("VoipAudioInfo", "mt3dFlag:" + this.gFd);
    Log.d("VoipAudioInfo", "mt3dAzim1:" + this.gFe);
    Log.d("VoipAudioInfo", "mt3dAzim2:" + this.gFf);
    Log.d("VoipAudioInfo", "mt3dAzim3:" + this.gFg);
    Log.d("VoipAudioInfo", "mt3dAzim4:" + this.gFh);
    Log.d("VoipAudioInfo", "mt3dAzim5:" + this.gFi);
    Log.d("VoipAudioInfo", "mt3dAzim6:" + this.gFj);
    Log.d("VoipAudioInfo", "mt3dAzim7:" + this.gFk);
    Log.d("VoipAudioInfo", "mt3dAzim8:" + this.gFl);
    Log.d("VoipAudioInfo", "mt3dElvl1:" + this.gFm);
    Log.d("VoipAudioInfo", "mt3dElvl2:" + this.gFn);
    Log.d("VoipAudioInfo", "mt3dElvl3:" + this.gFo);
    Log.d("VoipAudioInfo", "mt3dElvl4:" + this.gFp);
    Log.d("VoipAudioInfo", "mt3dElvl5:" + this.gFq);
    Log.d("VoipAudioInfo", "mt3dElvl6:" + this.gFr);
    Log.d("VoipAudioInfo", "mt3dElvl7:" + this.gFs);
    Log.d("VoipAudioInfo", "mt3dElvl8:" + this.gFt);
    Log.d("VoipAudioInfo", "mt3dPhi:" + this.gFu);
    Log.d("VoipAudioInfo", "mt3dtheta1:" + this.gFv);
    Log.d("VoipAudioInfo", "mt3dTheta2:" + this.gFw);
    Log.d("VoipAudioInfo", "waveAgcMode" + this.gEA);
    Log.d("VoipAudioInfo", "waveAgcSpkGain" + this.gEB);
    Log.d("VoipAudioInfo", "waveAgcPhnGain" + this.gEC);
    Log.d("VoipAudioInfo", "waveAgcHeadsetGain" + this.gED);
    Log.d("VoipAudioInfo", "waveAgcTarget" + this.gEE);
    Log.d("VoipAudioInfo", "waveAgcCRatio" + this.gEF);
    Log.d("VoipAudioInfo", "waveAgcDnTHR" + this.gEG);
    Log.d("VoipAudioInfo", "waveAgcBase" + this.gEH);
    Log.d("VoipAudioInfo", "waveAgcGainTHR" + this.gEI);
    Log.d("VoipAudioInfo", "waveAgcDampTHR" + this.gEJ);
    Log.d("VoipAudioInfo", "waveAgcDamper" + this.gEK);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.gDA = false;
    this.gDB = -1;
    this.gDC = -1;
    this.gDD = -1;
    this.gDE = -1;
    this.gDF = -1;
    this.gDG = -1;
    this.gDH = -1;
    this.gDJ = -1;
    this.gDI = -1;
    this.gEt = -1;
    this.gDK = -1;
    this.gDL = -1;
    this.gDM = -1;
    this.gEc = -1;
    this.gEd = -1;
    this.gEe = -1;
    this.gEf = -1;
    this.gEg = -1;
    this.gEh = -1;
    this.gEi = -1;
    this.gEj = false;
    this.gEk = -1;
    this.gEl = -1;
    this.gEn = -1;
    this.gEm = -1;
    this.gEs = -1;
    this.gEo = -1;
    this.gEp = -1;
    this.gEq = -1;
    this.gEr = -1;
    this.gEu = -1;
    this.gEv = -1;
    this.gEw = -1;
    this.gEx = -1;
    this.gEy = -1;
    this.gEz = -1;
    this.gEA = -1;
    this.gEB = -1;
    this.gEC = -1;
    this.gED = -1;
    this.gEE = -1;
    this.gEF = -1;
    this.gEG = -1;
    this.gEH = -1;
    this.gEI = -1;
    this.gEJ = -1;
    this.gEK = -1;
    this.gDN = -1;
    this.gDO = -1;
    this.gDP = -1;
    this.gDQ = -1;
    this.gDX = -1;
    this.gDY = -1;
    this.gDZ = -1;
    this.gEa = -1;
    this.gEL = 0;
    this.gEM = 0;
    this.gEN = -1;
    this.gDS = -1;
    this.gDR = -1;
    this.gEQ = false;
    this.gEP[0] = -1;
    this.gEP[1] = -1;
    this.gER = -1;
    this.gEZ = -1;
    this.gFa = -1;
    this.gFb = -1;
    this.gFc = -1;
    this.gEb = -1;
    this.gFd = -1;
    this.gFe = -1;
    this.gFf = -1;
    this.gFg = -1;
    this.gFh = -1;
    this.gFi = -1;
    this.gFj = -1;
    this.gFk = -1;
    this.gFl = -1;
    this.gFm = -1;
    this.gFn = -1;
    this.gFo = -1;
    this.gFp = -1;
    this.gFq = -1;
    this.gFr = -1;
    this.gFs = -1;
    this.gFt = -1;
    this.gFu = -1;
    this.gFv = -1;
    this.gFw = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */