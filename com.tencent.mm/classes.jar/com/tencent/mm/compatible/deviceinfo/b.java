package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;

public final class b
{
  public boolean fCT;
  public int fCU;
  public int fCV;
  public int fCW;
  public int fCX;
  public int fCY;
  public int fCZ;
  public int fDA;
  public int fDB;
  public int fDC;
  public int fDD;
  public int fDE;
  public int fDF;
  public int fDG;
  public int fDH;
  public int fDI;
  public int fDJ;
  public int fDK;
  public int fDL;
  public int fDM;
  public int fDN;
  public int fDO;
  public int fDP;
  public int fDQ;
  public int fDR;
  public short[] fDS;
  public short[] fDT;
  public boolean fDU;
  public int fDV;
  public boolean fDW;
  public int fDX;
  public int fDY;
  public int fDZ;
  public int fDa;
  public int fDb;
  public int fDc;
  public int fDd;
  public int fDe;
  public int fDf;
  public int fDg;
  public int fDh;
  public int fDi;
  public int fDj;
  public int fDk;
  public int fDl;
  public int fDm;
  public int fDn;
  public int fDo;
  public int fDp;
  public int fDq;
  public int fDr;
  public int fDs;
  public int fDt;
  public int fDu;
  public int fDv;
  public int fDw;
  public int fDx;
  public boolean fDy;
  public int fDz;
  public int fEA;
  public int fEa;
  public int fEb;
  public int fEc;
  public int fEd;
  public int fEe;
  public int fEf;
  public int fEg;
  public int fEh;
  public int fEi;
  public int fEj;
  public int fEk;
  public int fEl;
  public int fEm;
  public int fEn;
  public int fEo;
  public int fEp;
  public int fEq;
  public int fEr;
  public int fEs;
  public int fEt;
  public int fEu;
  public int fEv;
  public int fEw;
  public int fEx;
  public int fEy;
  public int fEz;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.fCT = false;
    this.fDS = new short[15];
    this.fDT = new short[2];
    this.fDW = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final boolean Xm()
  {
    return ((this.fCV >= 0) && (this.fCW < 0)) || ((this.fCV < 0) && (this.fCW >= 0)) || (this.fCX > 0);
  }
  
  public final boolean Xn()
  {
    return this.fCY >= 0;
  }
  
  public final boolean Xo()
  {
    return this.fCZ >= 0;
  }
  
  public final int Xp()
  {
    AppMethodBeat.i(155633);
    if (Xn())
    {
      int i = (this.fCY & 0xE0) >> 5;
      ac.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean Xq()
  {
    AppMethodBeat.i(155634);
    if (Xn())
    {
      int i = this.fCY & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("VoipAudioInfo", bool);
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
  
  public final int Xr()
  {
    AppMethodBeat.i(155635);
    if (Xn())
    {
      int i = (this.fCY & 0xE) >> 1;
      ac.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean Xs()
  {
    AppMethodBeat.i(155636);
    if (Xn())
    {
      int i = this.fCY & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("VoipAudioInfo", bool);
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
  
  public final int Xt()
  {
    AppMethodBeat.i(155637);
    if (Xo())
    {
      int i = (this.fCZ & 0xE0) >> 5;
      ac.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean Xu()
  {
    AppMethodBeat.i(155638);
    if (Xo())
    {
      int i = this.fCZ & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("VoipAudioInfo", bool);
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
  
  public final int Xv()
  {
    AppMethodBeat.i(155639);
    if (Xo())
    {
      int i = (this.fCZ & 0xE) >> 1;
      ac.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean Xw()
  {
    AppMethodBeat.i(155640);
    if (Xo())
    {
      int i = this.fCZ & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ac.d("VoipAudioInfo", bool);
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
    ac.d("VoipAudioInfo", "streamtype " + this.fCU);
    ac.d("VoipAudioInfo", "smode " + this.fCV);
    ac.d("VoipAudioInfo", "omode " + this.fCW);
    ac.d("VoipAudioInfo", "ospeaker " + this.fCX);
    ac.d("VoipAudioInfo", "operating" + this.fCY);
    ac.d("VoipAudioInfo", "moperating" + this.fCZ);
    ac.d("VoipAudioInfo", "mstreamtype" + this.fDa);
    ac.d("VoipAudioInfo", "mVoiceRecordMode" + this.fDb);
    ac.d("VoipAudioInfo", "agcMode :" + this.fDI);
    ac.d("VoipAudioInfo", "nsMode:" + this.fDe);
    ac.d("VoipAudioInfo", "aecMode:" + this.fDd);
    ac.d("VoipAudioInfo", "volumMode:" + this.fDf);
    ac.d("VoipAudioInfo", "micMode:" + this.fDr);
    ac.d("VoipAudioInfo", "sourceMode:" + this.fDs);
    ac.d("VoipAudioInfo", "speakerMode:" + this.fDt);
    ac.d("VoipAudioInfo", "phoneMode:" + this.fDu);
    ac.d("VoipAudioInfo", "voipstreamType:" + this.fDv);
    ac.d("VoipAudioInfo", "speakerstreamtype:" + this.fDw);
    ac.d("VoipAudioInfo", "phonestreamtype:" + this.fDx);
    ac.d("VoipAudioInfo", "ringphonestream:" + this.fDz);
    ac.d("VoipAudioInfo", "ringphonemode:" + this.fDA);
    ac.d("VoipAudioInfo", "ringspeakerstream:" + this.fDB);
    ac.d("VoipAudioInfo", "ringspeakermode:" + this.fDC);
    ac.d("VoipAudioInfo", "agcModeNew :" + this.fDH);
    ac.d("VoipAudioInfo", "nsModeNew:" + this.fDE);
    ac.d("VoipAudioInfo", "nsModeNewMulti:" + this.fDF);
    ac.d("VoipAudioInfo", "voipfullbandcfg:" + this.fDG);
    ac.d("VoipAudioInfo", "aecModeNew:" + this.fDD);
    ac.d("VoipAudioInfo", "agctargetdb:" + this.fDJ);
    ac.d("VoipAudioInfo", "agcgaindb:" + this.fDK);
    ac.d("VoipAudioInfo", "agcflag:" + this.fDL);
    ac.d("VoipAudioInfo", "agclimiter:" + this.fDM);
    ac.d("VoipAudioInfo", "agcCompRatio:" + this.fDN);
    ac.d("VoipAudioInfo", "agcDnGainThr:" + this.fDO);
    ac.d("VoipAudioInfo", "inputVolumeScale:" + this.fDg);
    ac.d("VoipAudioInfo", "outputVolumeScale:" + this.fDh);
    ac.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.fDi);
    ac.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.fDj);
    ac.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.fDm);
    ac.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.fDn);
    ac.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.fDo);
    ac.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.fDp);
    ac.d("VoipAudioInfo", "enableRecTimer:" + this.fDP);
    ac.d("VoipAudioInfo", "enablePlayTimer:" + this.fDQ);
    ac.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.fDR);
    ac.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.fDk);
    ac.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.fDl);
    ac.d("VoipAudioInfo", "noisegateon" + this.fDU);
    ac.d("VoipAudioInfo", "noisegatestrength[0]" + this.fDT[0]);
    ac.d("VoipAudioInfo", "noisegatestrength[1]" + this.fDT[1]);
    ac.d("VoipAudioInfo", "spkecenable:" + this.fDV);
    ac.d("VoipAudioInfo", "agcRxFlag:" + this.fEd);
    ac.d("VoipAudioInfo", "agcRxTargetdb:" + this.fEe);
    ac.d("VoipAudioInfo", "agcRxGaindb:" + this.fEf);
    ac.d("VoipAudioInfo", "agcRxLimiter:" + this.fEg);
    ac.d("VoipAudioInfo", "enableXnoiseSup:" + this.fDq);
    ac.d("VoipAudioInfo", "mt3dFlag:" + this.fEh);
    ac.d("VoipAudioInfo", "mt3dAzim1:" + this.fEi);
    ac.d("VoipAudioInfo", "mt3dAzim2:" + this.fEj);
    ac.d("VoipAudioInfo", "mt3dAzim3:" + this.fEk);
    ac.d("VoipAudioInfo", "mt3dAzim4:" + this.fEl);
    ac.d("VoipAudioInfo", "mt3dAzim5:" + this.fEm);
    ac.d("VoipAudioInfo", "mt3dAzim6:" + this.fEn);
    ac.d("VoipAudioInfo", "mt3dAzim7:" + this.fEo);
    ac.d("VoipAudioInfo", "mt3dAzim8:" + this.fEp);
    ac.d("VoipAudioInfo", "mt3dElvl1:" + this.fEq);
    ac.d("VoipAudioInfo", "mt3dElvl2:" + this.fEr);
    ac.d("VoipAudioInfo", "mt3dElvl3:" + this.fEs);
    ac.d("VoipAudioInfo", "mt3dElvl4:" + this.fEt);
    ac.d("VoipAudioInfo", "mt3dElvl5:" + this.fEu);
    ac.d("VoipAudioInfo", "mt3dElvl6:" + this.fEv);
    ac.d("VoipAudioInfo", "mt3dElvl7:" + this.fEw);
    ac.d("VoipAudioInfo", "mt3dElvl8:" + this.fEx);
    ac.d("VoipAudioInfo", "mt3dPhi:" + this.fEy);
    ac.d("VoipAudioInfo", "mt3dtheta1:" + this.fEz);
    ac.d("VoipAudioInfo", "mt3dTheta2:" + this.fEA);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.fCT = false;
    this.fCU = -1;
    this.fCV = -1;
    this.fCW = -1;
    this.fCX = -1;
    this.fCY = -1;
    this.fCZ = -1;
    this.fDa = -1;
    this.fDc = -1;
    this.fDb = -1;
    this.fDI = -1;
    this.fDd = -1;
    this.fDe = -1;
    this.fDf = -1;
    this.fDr = -1;
    this.fDs = -1;
    this.fDt = -1;
    this.fDu = -1;
    this.fDv = -1;
    this.fDw = -1;
    this.fDx = -1;
    this.fDy = false;
    this.fDz = -1;
    this.fDA = -1;
    this.fDC = -1;
    this.fDB = -1;
    this.fDH = -1;
    this.fDD = -1;
    this.fDE = -1;
    this.fDF = -1;
    this.fDG = -1;
    this.fDJ = -1;
    this.fDK = -1;
    this.fDL = -1;
    this.fDM = -1;
    this.fDN = -1;
    this.fDO = -1;
    this.fDg = -1;
    this.fDh = -1;
    this.fDi = -1;
    this.fDj = -1;
    this.fDm = -1;
    this.fDn = -1;
    this.fDo = -1;
    this.fDp = -1;
    this.fDP = 0;
    this.fDQ = 0;
    this.fDR = -1;
    this.fDl = -1;
    this.fDk = -1;
    this.fDU = false;
    this.fDT[0] = -1;
    this.fDT[1] = -1;
    this.fDV = -1;
    this.fEd = -1;
    this.fEe = -1;
    this.fEf = -1;
    this.fEg = -1;
    this.fDq = -1;
    this.fEh = -1;
    this.fEi = -1;
    this.fEj = -1;
    this.fEk = -1;
    this.fEl = -1;
    this.fEm = -1;
    this.fEn = -1;
    this.fEo = -1;
    this.fEp = -1;
    this.fEq = -1;
    this.fEr = -1;
    this.fEs = -1;
    this.fEt = -1;
    this.fEu = -1;
    this.fEv = -1;
    this.fEw = -1;
    this.fEx = -1;
    this.fEy = -1;
    this.fEz = -1;
    this.fEA = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */