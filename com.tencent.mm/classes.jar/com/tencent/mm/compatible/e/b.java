package com.tencent.mm.compatible.e;

import com.tencent.mm.sdk.platformtools.y;

public final class b
{
  public boolean duN = false;
  public int duO;
  public int duP;
  public int duQ;
  public int duR;
  public int duS;
  public int duT;
  public int duU;
  public int duV;
  public int duW;
  public int duX;
  public int duY;
  public int duZ;
  public int dvA;
  public int dvB;
  public int dvC;
  public int dvD;
  public int dvE;
  public int dvF;
  public int dvG;
  public int dvH;
  public short[] dvI = new short[15];
  public short[] dvJ = new short[2];
  public boolean dvK;
  public int dvL;
  public boolean dvM = false;
  public int dvN;
  public int dvO;
  public int dvP;
  public int dvQ;
  public int dvR;
  public int dvS;
  public int dvT;
  public int dvU;
  public int dvV;
  public int dvW;
  public int dva;
  public int dvb;
  public int dvc;
  public int dvd;
  public int dve;
  public int dvf;
  public int dvg;
  public int dvh;
  public int dvi;
  public int dvj;
  public int dvk;
  public int dvl;
  public int dvm;
  public int dvn;
  public int dvo;
  public int dvp;
  public int dvq;
  public int dvr;
  public boolean dvs;
  public int dvt;
  public int dvu;
  public int dvv;
  public int dvw;
  public int dvx;
  public int dvy;
  public int dvz;
  
  public b()
  {
    reset();
  }
  
  public final void dump()
  {
    y.d("VoipAudioInfo", "streamtype " + this.duO);
    y.d("VoipAudioInfo", "smode " + this.duP);
    y.d("VoipAudioInfo", "omode " + this.duQ);
    y.d("VoipAudioInfo", "ospeaker " + this.duR);
    y.d("VoipAudioInfo", "operating" + this.duS);
    y.d("VoipAudioInfo", "moperating" + this.duT);
    y.d("VoipAudioInfo", "mstreamtype" + this.duU);
    y.d("VoipAudioInfo", "mVoiceRecordMode" + this.duV);
    y.d("VoipAudioInfo", "agcMode :" + this.dvA);
    y.d("VoipAudioInfo", "nsMode:" + this.duY);
    y.d("VoipAudioInfo", "aecMode:" + this.duX);
    y.d("VoipAudioInfo", "volumMode:" + this.duZ);
    y.d("VoipAudioInfo", "micMode:" + this.dvl);
    y.d("VoipAudioInfo", "sourceMode:" + this.dvm);
    y.d("VoipAudioInfo", "speakerMode:" + this.dvn);
    y.d("VoipAudioInfo", "phoneMode:" + this.dvo);
    y.d("VoipAudioInfo", "voipstreamType:" + this.dvp);
    y.d("VoipAudioInfo", "speakerstreamtype:" + this.dvq);
    y.d("VoipAudioInfo", "phonestreamtype:" + this.dvr);
    y.d("VoipAudioInfo", "ringphonestream:" + this.dvt);
    y.d("VoipAudioInfo", "ringphonemode:" + this.dvu);
    y.d("VoipAudioInfo", "ringspeakerstream:" + this.dvv);
    y.d("VoipAudioInfo", "ringspeakermode:" + this.dvw);
    y.d("VoipAudioInfo", "agcModeNew :" + this.dvz);
    y.d("VoipAudioInfo", "nsModeNew:" + this.dvy);
    y.d("VoipAudioInfo", "aecModeNew:" + this.dvx);
    y.d("VoipAudioInfo", "agctargetdb:" + this.dvB);
    y.d("VoipAudioInfo", "agcgaindb:" + this.dvC);
    y.d("VoipAudioInfo", "agcflag:" + this.dvD);
    y.d("VoipAudioInfo", "agclimiter:" + this.dvE);
    y.d("VoipAudioInfo", "inputVolumeScale:" + this.dva);
    y.d("VoipAudioInfo", "outputVolumeScale:" + this.dvb);
    y.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.dvc);
    y.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.dvd);
    y.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.dvg);
    y.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.dvh);
    y.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.dvi);
    y.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.dvj);
    y.d("VoipAudioInfo", "enableRecTimer:" + this.dvF);
    y.d("VoipAudioInfo", "enablePlayTimer:" + this.dvG);
    y.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.dvH);
    y.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.dve);
    y.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.dvf);
    y.d("VoipAudioInfo", "noisegateon" + this.dvK);
    y.d("VoipAudioInfo", "noisegatestrength[0]" + this.dvJ[0]);
    y.d("VoipAudioInfo", "noisegatestrength[1]" + this.dvJ[1]);
    y.d("VoipAudioInfo", "spkecenable:" + this.dvL);
    y.d("VoipAudioInfo", "agcRxFlag:" + this.dvT);
    y.d("VoipAudioInfo", "agcRxTargetdb:" + this.dvU);
    y.d("VoipAudioInfo", "agcRxGaindb:" + this.dvV);
    y.d("VoipAudioInfo", "agcRxLimiter:" + this.dvW);
    y.d("VoipAudioInfo", "enableXnoiseSup:" + this.dvk);
  }
  
  public final void reset()
  {
    this.duN = false;
    this.duO = -1;
    this.duP = -1;
    this.duQ = -1;
    this.duR = -1;
    this.duS = -1;
    this.duT = -1;
    this.duU = -1;
    this.duW = -1;
    this.duV = -1;
    this.dvA = -1;
    this.duX = -1;
    this.duY = -1;
    this.duZ = -1;
    this.dvl = -1;
    this.dvm = -1;
    this.dvn = -1;
    this.dvo = -1;
    this.dvp = -1;
    this.dvq = -1;
    this.dvr = -1;
    this.dvs = false;
    this.dvt = -1;
    this.dvu = -1;
    this.dvw = -1;
    this.dvv = -1;
    this.dvz = -1;
    this.dvx = -1;
    this.dvy = -1;
    this.dvB = -1;
    this.dvC = -1;
    this.dvD = -1;
    this.dvE = -1;
    this.dva = -1;
    this.dvb = -1;
    this.dvc = -1;
    this.dvd = -1;
    this.dvg = -1;
    this.dvh = -1;
    this.dvi = -1;
    this.dvj = -1;
    this.dvF = 0;
    this.dvG = 0;
    this.dvH = -1;
    this.dvf = -1;
    this.dve = -1;
    this.dvK = false;
    this.dvJ[0] = -1;
    this.dvJ[1] = -1;
    this.dvL = -1;
    this.dvT = -1;
    this.dvU = -1;
    this.dvV = -1;
    this.dvW = -1;
    this.dvk = -1;
  }
  
  public final boolean yD()
  {
    return ((this.duP >= 0) && (this.duQ < 0)) || ((this.duP < 0) && (this.duQ >= 0)) || (this.duR > 0);
  }
  
  public final boolean yE()
  {
    return this.duS >= 0;
  }
  
  public final boolean yF()
  {
    return this.duT >= 0;
  }
  
  public final int yG()
  {
    int i;
    if (yE())
    {
      i = (this.duS & 0xE0) >> 5;
      y.d("VoipAudioInfo", "getEnableMode " + i);
      if (i != 7) {}
    }
    else
    {
      return -1;
    }
    return i;
  }
  
  public final boolean yH()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    StringBuilder localStringBuilder;
    if (yE())
    {
      i = this.duS & 0x10;
      localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i <= 0) {
        break label61;
      }
    }
    label61:
    for (bool1 = true;; bool1 = false)
    {
      y.d("VoipAudioInfo", bool1);
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final int yI()
  {
    int i;
    if (yE())
    {
      i = (this.duS & 0xE) >> 1;
      y.d("VoipAudioInfo", "getDisableMode " + i);
      if (i != 7) {}
    }
    else
    {
      return -1;
    }
    return i;
  }
  
  public final boolean yJ()
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    int i;
    StringBuilder localStringBuilder;
    if (yE())
    {
      i = this.duS & 0x1;
      localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i <= 0) {
        break label60;
      }
    }
    label60:
    for (bool1 = true;; bool1 = false)
    {
      y.d("VoipAudioInfo", bool1);
      bool1 = bool2;
      if (i > 0) {
        bool1 = true;
      }
      return bool1;
    }
  }
  
  public final int yK()
  {
    int i;
    if (yF())
    {
      i = (this.duT & 0xE0) >> 5;
      y.d("VoipAudioInfo", "getEnableMode " + i);
      if (i != 7) {}
    }
    else
    {
      return -1;
    }
    return i;
  }
  
  public final int yL()
  {
    int i;
    if (yF())
    {
      i = (this.duT & 0xE) >> 1;
      y.d("VoipAudioInfo", "getDisableMode " + i);
      if (i != 7) {}
    }
    else
    {
      return -1;
    }
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.e.b
 * JD-Core Version:    0.7.0.1
 */