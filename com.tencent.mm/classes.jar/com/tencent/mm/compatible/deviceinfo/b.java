package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public final class b
{
  public boolean jnK;
  public int jnL;
  public int jnM;
  public int jnN;
  public int jnO;
  public int jnP;
  public int jnQ;
  public int jnR;
  public int jnS;
  public int jnT;
  public int jnU;
  public int jnV;
  public int jnW;
  public int jnX;
  public int jnY;
  public int jnZ;
  public int joA;
  public int joB;
  public int joC;
  public int joD;
  public int joE;
  public int joF;
  public int joG;
  public int joH;
  public int joI;
  public int joJ;
  public int joK;
  public int joL;
  public int joM;
  public int joN;
  public int joO;
  public int joP;
  public int joQ;
  public int joR;
  public int joS;
  public int joT;
  public int joU;
  public int joV;
  public int joW;
  public int joX;
  public short[] joY;
  public short[] joZ;
  public int joa;
  public int job;
  public int joc;
  public int jod;
  public int joe;
  public int jof;
  public int jog;
  public int joh;
  public int joi;
  public int joj;
  public int jok;
  public int jol;
  public int jom;
  public int jon;
  public int joo;
  public int jop;
  public int joq;
  public int jor;
  public int jos;
  public boolean jot;
  public int jou;
  public int jov;
  public int jow;
  public int jox;
  public int joy;
  public int joz;
  public int jpA;
  public int jpB;
  public int jpC;
  public int jpD;
  public int jpE;
  public int jpF;
  public int jpG;
  public boolean jpa;
  public int jpb;
  public boolean jpc;
  public int jpd;
  public int jpe;
  public int jpf;
  public int jpg;
  public int jph;
  public int jpi;
  public int jpj;
  public int jpk;
  public int jpl;
  public int jpm;
  public int jpn;
  public int jpo;
  public int jpp;
  public int jpq;
  public int jpr;
  public int jps;
  public int jpt;
  public int jpu;
  public int jpv;
  public int jpw;
  public int jpx;
  public int jpy;
  public int jpz;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.jnK = false;
    this.jod = -1;
    this.joe = -1;
    this.jof = -1;
    this.jog = -1;
    this.joY = new short[15];
    this.joZ = new short[2];
    this.jpc = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final void Y()
  {
    AppMethodBeat.i(155641);
    Log.d("VoipAudioInfo", "streamtype " + this.jnL);
    Log.d("VoipAudioInfo", "smode " + this.jnM);
    Log.d("VoipAudioInfo", "omode " + this.jnN);
    Log.d("VoipAudioInfo", "ospeaker " + this.jnO);
    Log.d("VoipAudioInfo", "operating" + this.jnP);
    Log.d("VoipAudioInfo", "moperating" + this.jnQ);
    Log.d("VoipAudioInfo", "mstreamtype" + this.jnR);
    Log.d("VoipAudioInfo", "mVoiceRecordMode" + this.jnS);
    Log.d("VoipAudioInfo", "agcMode :" + this.joD);
    Log.d("VoipAudioInfo", "nsMode:" + this.jnV);
    Log.d("VoipAudioInfo", "aecMode:" + this.jnU);
    Log.d("VoipAudioInfo", "volumMode:" + this.jnW);
    Log.d("VoipAudioInfo", "micMode:" + this.jom);
    Log.d("VoipAudioInfo", "sourceMode:" + this.jon);
    Log.d("VoipAudioInfo", "speakerMode:" + this.joo);
    Log.d("VoipAudioInfo", "phoneMode:" + this.jop);
    Log.d("VoipAudioInfo", "voipstreamType:" + this.joq);
    Log.d("VoipAudioInfo", "speakerstreamtype:" + this.jor);
    Log.d("VoipAudioInfo", "phonestreamtype:" + this.jos);
    Log.d("VoipAudioInfo", "ringphonestream:" + this.jou);
    Log.d("VoipAudioInfo", "ringphonemode:" + this.jov);
    Log.d("VoipAudioInfo", "ringspeakerstream:" + this.jow);
    Log.d("VoipAudioInfo", "ringspeakermode:" + this.jox);
    Log.d("VoipAudioInfo", "agcModeNew :" + this.joC);
    Log.d("VoipAudioInfo", "nsModeNew:" + this.joz);
    Log.d("VoipAudioInfo", "nsModeNewMulti:" + this.joA);
    Log.d("VoipAudioInfo", "voipfullbandcfg:" + this.joB);
    Log.d("VoipAudioInfo", "aecModeNew:" + this.joy);
    Log.d("VoipAudioInfo", "agctargetdb:" + this.joE);
    Log.d("VoipAudioInfo", "agcgaindb:" + this.joF);
    Log.d("VoipAudioInfo", "agcflag:" + this.joG);
    Log.d("VoipAudioInfo", "agclimiter:" + this.joH);
    Log.d("VoipAudioInfo", "agcCompRatio:" + this.joI);
    Log.d("VoipAudioInfo", "agcDnGainThr:" + this.joJ);
    Log.d("VoipAudioInfo", "inputVolumeScale:" + this.jnX);
    Log.d("VoipAudioInfo", "outputVolumeScale:" + this.jnY);
    Log.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.jnZ);
    Log.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.joa);
    Log.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.joh);
    Log.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.joi);
    Log.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.joj);
    Log.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.jok);
    Log.d("VoipAudioInfo", "enableRecTimer:" + this.joV);
    Log.d("VoipAudioInfo", "enablePlayTimer:" + this.joW);
    Log.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.joX);
    Log.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.job);
    Log.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.joc);
    Log.d("VoipAudioInfo", "noisegateon" + this.jpa);
    Log.d("VoipAudioInfo", "noisegatestrength[0]" + this.joZ[0]);
    Log.d("VoipAudioInfo", "noisegatestrength[1]" + this.joZ[1]);
    Log.d("VoipAudioInfo", "spkecenable:" + this.jpb);
    Log.d("VoipAudioInfo", "agcRxFlag:" + this.jpj);
    Log.d("VoipAudioInfo", "agcRxTargetdb:" + this.jpk);
    Log.d("VoipAudioInfo", "agcRxGaindb:" + this.jpl);
    Log.d("VoipAudioInfo", "agcRxLimiter:" + this.jpm);
    Log.d("VoipAudioInfo", "enableXnoiseSup:" + this.jol);
    Log.d("VoipAudioInfo", "mt3dFlag:" + this.jpn);
    Log.d("VoipAudioInfo", "mt3dAzim1:" + this.jpo);
    Log.d("VoipAudioInfo", "mt3dAzim2:" + this.jpp);
    Log.d("VoipAudioInfo", "mt3dAzim3:" + this.jpq);
    Log.d("VoipAudioInfo", "mt3dAzim4:" + this.jpr);
    Log.d("VoipAudioInfo", "mt3dAzim5:" + this.jps);
    Log.d("VoipAudioInfo", "mt3dAzim6:" + this.jpt);
    Log.d("VoipAudioInfo", "mt3dAzim7:" + this.jpu);
    Log.d("VoipAudioInfo", "mt3dAzim8:" + this.jpv);
    Log.d("VoipAudioInfo", "mt3dElvl1:" + this.jpw);
    Log.d("VoipAudioInfo", "mt3dElvl2:" + this.jpx);
    Log.d("VoipAudioInfo", "mt3dElvl3:" + this.jpy);
    Log.d("VoipAudioInfo", "mt3dElvl4:" + this.jpz);
    Log.d("VoipAudioInfo", "mt3dElvl5:" + this.jpA);
    Log.d("VoipAudioInfo", "mt3dElvl6:" + this.jpB);
    Log.d("VoipAudioInfo", "mt3dElvl7:" + this.jpC);
    Log.d("VoipAudioInfo", "mt3dElvl8:" + this.jpD);
    Log.d("VoipAudioInfo", "mt3dPhi:" + this.jpE);
    Log.d("VoipAudioInfo", "mt3dtheta1:" + this.jpF);
    Log.d("VoipAudioInfo", "mt3dTheta2:" + this.jpG);
    Log.d("VoipAudioInfo", "waveAgcMode" + this.joK);
    Log.d("VoipAudioInfo", "waveAgcSpkGain" + this.joL);
    Log.d("VoipAudioInfo", "waveAgcPhnGain" + this.joM);
    Log.d("VoipAudioInfo", "waveAgcHeadsetGain" + this.joN);
    Log.d("VoipAudioInfo", "waveAgcTarget" + this.joO);
    Log.d("VoipAudioInfo", "waveAgcCRatio" + this.joP);
    Log.d("VoipAudioInfo", "waveAgcDnTHR" + this.joQ);
    Log.d("VoipAudioInfo", "waveAgcBase" + this.joR);
    Log.d("VoipAudioInfo", "waveAgcGainTHR" + this.joS);
    Log.d("VoipAudioInfo", "waveAgcDampTHR" + this.joT);
    Log.d("VoipAudioInfo", "waveAgcDamper" + this.joU);
    AppMethodBeat.o(155641);
  }
  
  public final boolean atY()
  {
    return ((this.jnM >= 0) && (this.jnN < 0)) || ((this.jnM < 0) && (this.jnN >= 0)) || (this.jnO > 0);
  }
  
  public final boolean atZ()
  {
    return this.jnP >= 0;
  }
  
  public final boolean aua()
  {
    return this.jnQ >= 0;
  }
  
  public final int aub()
  {
    AppMethodBeat.i(155633);
    if (atZ())
    {
      int i = (this.jnP & 0xE0) >> 5;
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
  
  public final boolean auc()
  {
    AppMethodBeat.i(155634);
    if (atZ())
    {
      int i = this.jnP & 0x10;
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
  
  public final int aud()
  {
    AppMethodBeat.i(155635);
    if (atZ())
    {
      int i = (this.jnP & 0xE) >> 1;
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
  
  public final boolean aue()
  {
    AppMethodBeat.i(155636);
    if (atZ())
    {
      int i = this.jnP & 0x1;
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
  
  public final int auf()
  {
    AppMethodBeat.i(155637);
    if (aua())
    {
      int i = (this.jnQ & 0xE0) >> 5;
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
  
  public final boolean aug()
  {
    AppMethodBeat.i(155638);
    if (aua())
    {
      int i = this.jnQ & 0x10;
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
  
  public final int auh()
  {
    AppMethodBeat.i(155639);
    if (aua())
    {
      int i = (this.jnQ & 0xE) >> 1;
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
  
  public final boolean aui()
  {
    AppMethodBeat.i(155640);
    if (aua())
    {
      int i = this.jnQ & 0x1;
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
  
  public final void reset()
  {
    this.jnK = false;
    this.jnL = -1;
    this.jnM = -1;
    this.jnN = -1;
    this.jnO = -1;
    this.jnP = -1;
    this.jnQ = -1;
    this.jnR = -1;
    this.jnT = -1;
    this.jnS = -1;
    this.joD = -1;
    this.jnU = -1;
    this.jnV = -1;
    this.jnW = -1;
    this.jom = -1;
    this.jon = -1;
    this.joo = -1;
    this.jop = -1;
    this.joq = -1;
    this.jor = -1;
    this.jos = -1;
    this.jot = false;
    this.jou = -1;
    this.jov = -1;
    this.jox = -1;
    this.jow = -1;
    this.joC = -1;
    this.joy = -1;
    this.joz = -1;
    this.joA = -1;
    this.joB = -1;
    this.joE = -1;
    this.joF = -1;
    this.joG = -1;
    this.joH = -1;
    this.joI = -1;
    this.joJ = -1;
    this.joK = -1;
    this.joL = -1;
    this.joM = -1;
    this.joN = -1;
    this.joO = -1;
    this.joP = -1;
    this.joQ = -1;
    this.joR = -1;
    this.joS = -1;
    this.joT = -1;
    this.joU = -1;
    this.jnX = -1;
    this.jnY = -1;
    this.jnZ = -1;
    this.joa = -1;
    this.joh = -1;
    this.joi = -1;
    this.joj = -1;
    this.jok = -1;
    this.joV = 0;
    this.joW = 0;
    this.joX = -1;
    this.joc = -1;
    this.job = -1;
    this.jpa = false;
    this.joZ[0] = -1;
    this.joZ[1] = -1;
    this.jpb = -1;
    this.jpj = -1;
    this.jpk = -1;
    this.jpl = -1;
    this.jpm = -1;
    this.jol = -1;
    this.jpn = -1;
    this.jpo = -1;
    this.jpp = -1;
    this.jpq = -1;
    this.jpr = -1;
    this.jps = -1;
    this.jpt = -1;
    this.jpu = -1;
    this.jpv = -1;
    this.jpw = -1;
    this.jpx = -1;
    this.jpy = -1;
    this.jpz = -1;
    this.jpA = -1;
    this.jpB = -1;
    this.jpC = -1;
    this.jpD = -1;
    this.jpE = -1;
    this.jpF = -1;
    this.jpG = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */