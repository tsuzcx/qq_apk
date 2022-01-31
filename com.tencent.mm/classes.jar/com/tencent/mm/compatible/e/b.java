package com.tencent.mm.compatible.e;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public final class b
{
  public boolean emD;
  public int emE;
  public int emF;
  public int emG;
  public int emH;
  public int emI;
  public int emJ;
  public int emK;
  public int emL;
  public int emM;
  public int emN;
  public int emO;
  public int emP;
  public int emQ;
  public int emR;
  public int emS;
  public int emT;
  public int emU;
  public int emV;
  public int emW;
  public int emX;
  public int emY;
  public int emZ;
  public short[] enA;
  public boolean enB;
  public int enC;
  public boolean enD;
  public int enE;
  public int enF;
  public int enG;
  public int enH;
  public int enI;
  public int enJ;
  public int enK;
  public int enL;
  public int enM;
  public int enN;
  public int ena;
  public int enb;
  public int enc;
  public int ene;
  public int enf;
  public int eng;
  public int enh;
  public int eni;
  public boolean enj;
  public int enk;
  public int enl;
  public int enm;
  public int enn;
  public int eno;
  public int enp;
  public int enq;
  public int enr;
  public int ens;
  public int ent;
  public int enu;
  public int env;
  public int enw;
  public int enx;
  public int eny;
  public short[] enz;
  
  public b()
  {
    AppMethodBeat.i(92910);
    this.emD = false;
    this.enz = new short[15];
    this.enA = new short[2];
    this.enD = false;
    reset();
    AppMethodBeat.o(92910);
  }
  
  public final boolean KY()
  {
    return ((this.emF >= 0) && (this.emG < 0)) || ((this.emF < 0) && (this.emG >= 0)) || (this.emH > 0);
  }
  
  public final boolean KZ()
  {
    return this.emI >= 0;
  }
  
  public final boolean La()
  {
    return this.emJ >= 0;
  }
  
  public final int Lb()
  {
    AppMethodBeat.i(92911);
    if (KZ())
    {
      int i = (this.emI & 0xE0) >> 5;
      ab.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(92911);
        return -1;
      }
      AppMethodBeat.o(92911);
      return i;
    }
    AppMethodBeat.o(92911);
    return -1;
  }
  
  public final boolean Lc()
  {
    AppMethodBeat.i(92912);
    if (KZ())
    {
      int i = this.emI & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(92912);
        return true;
      }
      AppMethodBeat.o(92912);
      return false;
    }
    AppMethodBeat.o(92912);
    return false;
  }
  
  public final int Ld()
  {
    AppMethodBeat.i(92913);
    if (KZ())
    {
      int i = (this.emI & 0xE) >> 1;
      ab.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(92913);
        return -1;
      }
      AppMethodBeat.o(92913);
      return i;
    }
    AppMethodBeat.o(92913);
    return -1;
  }
  
  public final boolean Le()
  {
    AppMethodBeat.i(92914);
    if (KZ())
    {
      int i = this.emI & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(92914);
        return true;
      }
      AppMethodBeat.o(92914);
      return false;
    }
    AppMethodBeat.o(92914);
    return false;
  }
  
  public final int Lf()
  {
    AppMethodBeat.i(92915);
    if (La())
    {
      int i = (this.emJ & 0xE0) >> 5;
      ab.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(92915);
        return -1;
      }
      AppMethodBeat.o(92915);
      return i;
    }
    AppMethodBeat.o(92915);
    return -1;
  }
  
  public final boolean Lg()
  {
    AppMethodBeat.i(92916);
    if (La())
    {
      int i = this.emJ & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(92916);
        return true;
      }
      AppMethodBeat.o(92916);
      return false;
    }
    AppMethodBeat.o(92916);
    return false;
  }
  
  public final int Lh()
  {
    AppMethodBeat.i(92917);
    if (La())
    {
      int i = (this.emJ & 0xE) >> 1;
      ab.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
      if (i == 7)
      {
        AppMethodBeat.o(92917);
        return -1;
      }
      AppMethodBeat.o(92917);
      return i;
    }
    AppMethodBeat.o(92917);
    return -1;
  }
  
  public final boolean Li()
  {
    AppMethodBeat.i(92918);
    if (La())
    {
      int i = this.emJ & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ab.d("VoipAudioInfo", bool);
        if (i <= 0) {
          break;
        }
        AppMethodBeat.o(92918);
        return true;
      }
      AppMethodBeat.o(92918);
      return false;
    }
    AppMethodBeat.o(92918);
    return false;
  }
  
  public final void dump()
  {
    AppMethodBeat.i(92919);
    ab.d("VoipAudioInfo", "streamtype " + this.emE);
    ab.d("VoipAudioInfo", "smode " + this.emF);
    ab.d("VoipAudioInfo", "omode " + this.emG);
    ab.d("VoipAudioInfo", "ospeaker " + this.emH);
    ab.d("VoipAudioInfo", "operating" + this.emI);
    ab.d("VoipAudioInfo", "moperating" + this.emJ);
    ab.d("VoipAudioInfo", "mstreamtype" + this.emK);
    ab.d("VoipAudioInfo", "mVoiceRecordMode" + this.emL);
    ab.d("VoipAudioInfo", "agcMode :" + this.enr);
    ab.d("VoipAudioInfo", "nsMode:" + this.emO);
    ab.d("VoipAudioInfo", "aecMode:" + this.emN);
    ab.d("VoipAudioInfo", "volumMode:" + this.emP);
    ab.d("VoipAudioInfo", "micMode:" + this.enb);
    ab.d("VoipAudioInfo", "sourceMode:" + this.enc);
    ab.d("VoipAudioInfo", "speakerMode:" + this.ene);
    ab.d("VoipAudioInfo", "phoneMode:" + this.enf);
    ab.d("VoipAudioInfo", "voipstreamType:" + this.eng);
    ab.d("VoipAudioInfo", "speakerstreamtype:" + this.enh);
    ab.d("VoipAudioInfo", "phonestreamtype:" + this.eni);
    ab.d("VoipAudioInfo", "ringphonestream:" + this.enk);
    ab.d("VoipAudioInfo", "ringphonemode:" + this.enl);
    ab.d("VoipAudioInfo", "ringspeakerstream:" + this.enm);
    ab.d("VoipAudioInfo", "ringspeakermode:" + this.enn);
    ab.d("VoipAudioInfo", "agcModeNew :" + this.enq);
    ab.d("VoipAudioInfo", "nsModeNew:" + this.enp);
    ab.d("VoipAudioInfo", "aecModeNew:" + this.eno);
    ab.d("VoipAudioInfo", "agctargetdb:" + this.ens);
    ab.d("VoipAudioInfo", "agcgaindb:" + this.ent);
    ab.d("VoipAudioInfo", "agcflag:" + this.enu);
    ab.d("VoipAudioInfo", "agclimiter:" + this.env);
    ab.d("VoipAudioInfo", "inputVolumeScale:" + this.emQ);
    ab.d("VoipAudioInfo", "outputVolumeScale:" + this.emR);
    ab.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.emS);
    ab.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.emT);
    ab.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.emW);
    ab.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.emX);
    ab.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.emY);
    ab.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.emZ);
    ab.d("VoipAudioInfo", "enableRecTimer:" + this.enw);
    ab.d("VoipAudioInfo", "enablePlayTimer:" + this.enx);
    ab.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.eny);
    ab.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.emU);
    ab.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.emV);
    ab.d("VoipAudioInfo", "noisegateon" + this.enB);
    ab.d("VoipAudioInfo", "noisegatestrength[0]" + this.enA[0]);
    ab.d("VoipAudioInfo", "noisegatestrength[1]" + this.enA[1]);
    ab.d("VoipAudioInfo", "spkecenable:" + this.enC);
    ab.d("VoipAudioInfo", "agcRxFlag:" + this.enK);
    ab.d("VoipAudioInfo", "agcRxTargetdb:" + this.enL);
    ab.d("VoipAudioInfo", "agcRxGaindb:" + this.enM);
    ab.d("VoipAudioInfo", "agcRxLimiter:" + this.enN);
    ab.d("VoipAudioInfo", "enableXnoiseSup:" + this.ena);
    AppMethodBeat.o(92919);
  }
  
  public final void reset()
  {
    this.emD = false;
    this.emE = -1;
    this.emF = -1;
    this.emG = -1;
    this.emH = -1;
    this.emI = -1;
    this.emJ = -1;
    this.emK = -1;
    this.emM = -1;
    this.emL = -1;
    this.enr = -1;
    this.emN = -1;
    this.emO = -1;
    this.emP = -1;
    this.enb = -1;
    this.enc = -1;
    this.ene = -1;
    this.enf = -1;
    this.eng = -1;
    this.enh = -1;
    this.eni = -1;
    this.enj = false;
    this.enk = -1;
    this.enl = -1;
    this.enn = -1;
    this.enm = -1;
    this.enq = -1;
    this.eno = -1;
    this.enp = -1;
    this.ens = -1;
    this.ent = -1;
    this.enu = -1;
    this.env = -1;
    this.emQ = -1;
    this.emR = -1;
    this.emS = -1;
    this.emT = -1;
    this.emW = -1;
    this.emX = -1;
    this.emY = -1;
    this.emZ = -1;
    this.enw = 0;
    this.enx = 0;
    this.eny = -1;
    this.emV = -1;
    this.emU = -1;
    this.enB = false;
    this.enA[0] = -1;
    this.enA[1] = -1;
    this.enC = -1;
    this.enK = -1;
    this.enL = -1;
    this.enM = -1;
    this.enN = -1;
    this.ena = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.b
 * JD-Core Version:    0.7.0.1
 */