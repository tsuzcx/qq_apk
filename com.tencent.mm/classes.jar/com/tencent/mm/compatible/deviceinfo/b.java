package com.tencent.mm.compatible.deviceinfo;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;

public final class b
{
  public int fYA;
  public int fYB;
  public int fYC;
  public int fYD;
  public int fYE;
  public int fYF;
  public int fYG;
  public int fYH;
  public int fYI;
  public int fYJ;
  public int fYK;
  public int fYL;
  public int fYM;
  public int fYN;
  public int fYO;
  public int fYP;
  public int fYQ;
  public int fYR;
  public boolean fYS;
  public int fYT;
  public int fYU;
  public int fYV;
  public int fYW;
  public int fYX;
  public int fYY;
  public int fYZ;
  public boolean fYn;
  public int fYo;
  public int fYp;
  public int fYq;
  public int fYr;
  public int fYs;
  public int fYt;
  public int fYu;
  public int fYv;
  public int fYw;
  public int fYx;
  public int fYy;
  public int fYz;
  public int fZA;
  public boolean fZB;
  public int fZC;
  public int fZD;
  public int fZE;
  public int fZF;
  public int fZG;
  public int fZH;
  public int fZI;
  public int fZJ;
  public int fZK;
  public int fZL;
  public int fZM;
  public int fZN;
  public int fZO;
  public int fZP;
  public int fZQ;
  public int fZR;
  public int fZS;
  public int fZT;
  public int fZU;
  public int fZV;
  public int fZW;
  public int fZX;
  public int fZY;
  public int fZZ;
  public int fZa;
  public int fZb;
  public int fZc;
  public int fZd;
  public int fZe;
  public int fZf;
  public int fZg;
  public int fZh;
  public int fZi;
  public int fZj;
  public int fZk;
  public int fZl;
  public int fZm;
  public int fZn;
  public int fZo;
  public int fZp;
  public int fZq;
  public int fZr;
  public int fZs;
  public int fZt;
  public int fZu;
  public int fZv;
  public int fZw;
  public short[] fZx;
  public short[] fZy;
  public boolean fZz;
  public int gaa;
  public int gab;
  public int gac;
  public int gad;
  public int gae;
  public int gaf;
  
  public b()
  {
    AppMethodBeat.i(155632);
    this.fYn = false;
    this.fZx = new short[15];
    this.fZy = new short[2];
    this.fZB = false;
    reset();
    AppMethodBeat.o(155632);
  }
  
  public final boolean ZW()
  {
    return ((this.fYp >= 0) && (this.fYq < 0)) || ((this.fYp < 0) && (this.fYq >= 0)) || (this.fYr > 0);
  }
  
  public final boolean ZX()
  {
    return this.fYs >= 0;
  }
  
  public final boolean ZY()
  {
    return this.fYt >= 0;
  }
  
  public final int ZZ()
  {
    AppMethodBeat.i(155633);
    if (ZX())
    {
      int i = (this.fYs & 0xE0) >> 5;
      ae.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aaa()
  {
    AppMethodBeat.i(155634);
    if (ZX())
    {
      int i = this.fYs & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("VoipAudioInfo", bool);
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
  
  public final int aab()
  {
    AppMethodBeat.i(155635);
    if (ZX())
    {
      int i = (this.fYs & 0xE) >> 1;
      ae.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aac()
  {
    AppMethodBeat.i(155636);
    if (ZX())
    {
      int i = this.fYs & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("VoipAudioInfo", bool);
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
  
  public final int aad()
  {
    AppMethodBeat.i(155637);
    if (ZY())
    {
      int i = (this.fYt & 0xE0) >> 5;
      ae.d("VoipAudioInfo", "getEnableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aae()
  {
    AppMethodBeat.i(155638);
    if (ZY())
    {
      int i = this.fYt & 0x10;
      StringBuilder localStringBuilder = new StringBuilder("enableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("VoipAudioInfo", bool);
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
  
  public final int aaf()
  {
    AppMethodBeat.i(155639);
    if (ZY())
    {
      int i = (this.fYt & 0xE) >> 1;
      ae.d("VoipAudioInfo", "getDisableMode ".concat(String.valueOf(i)));
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
  
  public final boolean aag()
  {
    AppMethodBeat.i(155640);
    if (ZY())
    {
      int i = this.fYt & 0x1;
      StringBuilder localStringBuilder = new StringBuilder("disableSpeaker ");
      if (i > 0) {}
      for (boolean bool = true;; bool = false)
      {
        ae.d("VoipAudioInfo", bool);
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
    ae.d("VoipAudioInfo", "streamtype " + this.fYo);
    ae.d("VoipAudioInfo", "smode " + this.fYp);
    ae.d("VoipAudioInfo", "omode " + this.fYq);
    ae.d("VoipAudioInfo", "ospeaker " + this.fYr);
    ae.d("VoipAudioInfo", "operating" + this.fYs);
    ae.d("VoipAudioInfo", "moperating" + this.fYt);
    ae.d("VoipAudioInfo", "mstreamtype" + this.fYu);
    ae.d("VoipAudioInfo", "mVoiceRecordMode" + this.fYv);
    ae.d("VoipAudioInfo", "agcMode :" + this.fZc);
    ae.d("VoipAudioInfo", "nsMode:" + this.fYy);
    ae.d("VoipAudioInfo", "aecMode:" + this.fYx);
    ae.d("VoipAudioInfo", "volumMode:" + this.fYz);
    ae.d("VoipAudioInfo", "micMode:" + this.fYL);
    ae.d("VoipAudioInfo", "sourceMode:" + this.fYM);
    ae.d("VoipAudioInfo", "speakerMode:" + this.fYN);
    ae.d("VoipAudioInfo", "phoneMode:" + this.fYO);
    ae.d("VoipAudioInfo", "voipstreamType:" + this.fYP);
    ae.d("VoipAudioInfo", "speakerstreamtype:" + this.fYQ);
    ae.d("VoipAudioInfo", "phonestreamtype:" + this.fYR);
    ae.d("VoipAudioInfo", "ringphonestream:" + this.fYT);
    ae.d("VoipAudioInfo", "ringphonemode:" + this.fYU);
    ae.d("VoipAudioInfo", "ringspeakerstream:" + this.fYV);
    ae.d("VoipAudioInfo", "ringspeakermode:" + this.fYW);
    ae.d("VoipAudioInfo", "agcModeNew :" + this.fZb);
    ae.d("VoipAudioInfo", "nsModeNew:" + this.fYY);
    ae.d("VoipAudioInfo", "nsModeNewMulti:" + this.fYZ);
    ae.d("VoipAudioInfo", "voipfullbandcfg:" + this.fZa);
    ae.d("VoipAudioInfo", "aecModeNew:" + this.fYX);
    ae.d("VoipAudioInfo", "agctargetdb:" + this.fZd);
    ae.d("VoipAudioInfo", "agcgaindb:" + this.fZe);
    ae.d("VoipAudioInfo", "agcflag:" + this.fZf);
    ae.d("VoipAudioInfo", "agclimiter:" + this.fZg);
    ae.d("VoipAudioInfo", "agcCompRatio:" + this.fZh);
    ae.d("VoipAudioInfo", "agcDnGainThr:" + this.fZi);
    ae.d("VoipAudioInfo", "inputVolumeScale:" + this.fYA);
    ae.d("VoipAudioInfo", "outputVolumeScale:" + this.fYB);
    ae.d("VoipAudioInfo", "inputVolumeScaleForSpeaker:" + this.fYC);
    ae.d("VoipAudioInfo", "outputVolumeScaleForSpeaker:" + this.fYD);
    ae.d("VoipAudioInfo", "ehanceHeadsetEC:" + this.fYG);
    ae.d("VoipAudioInfo", "setECModeLevelForHeadSet:" + this.fYH);
    ae.d("VoipAudioInfo", "setECModeLevelForSpeaker:" + this.fYI);
    ae.d("VoipAudioInfo", "enableSpeakerEnhanceEC:" + this.fYJ);
    ae.d("VoipAudioInfo", "enableRecTimer:" + this.fZu);
    ae.d("VoipAudioInfo", "enablePlayTimer:" + this.fZv);
    ae.d("VoipAudioInfo", "setPlayerPrecorrectCofOnOrOff:" + this.fZw);
    ae.d("VoipAudioInfo", "outputVolumeGainForPhone:" + this.fYE);
    ae.d("VoipAudioInfo", "outputVolumeGainForSpeaker:" + this.fYF);
    ae.d("VoipAudioInfo", "noisegateon" + this.fZz);
    ae.d("VoipAudioInfo", "noisegatestrength[0]" + this.fZy[0]);
    ae.d("VoipAudioInfo", "noisegatestrength[1]" + this.fZy[1]);
    ae.d("VoipAudioInfo", "spkecenable:" + this.fZA);
    ae.d("VoipAudioInfo", "agcRxFlag:" + this.fZI);
    ae.d("VoipAudioInfo", "agcRxTargetdb:" + this.fZJ);
    ae.d("VoipAudioInfo", "agcRxGaindb:" + this.fZK);
    ae.d("VoipAudioInfo", "agcRxLimiter:" + this.fZL);
    ae.d("VoipAudioInfo", "enableXnoiseSup:" + this.fYK);
    ae.d("VoipAudioInfo", "mt3dFlag:" + this.fZM);
    ae.d("VoipAudioInfo", "mt3dAzim1:" + this.fZN);
    ae.d("VoipAudioInfo", "mt3dAzim2:" + this.fZO);
    ae.d("VoipAudioInfo", "mt3dAzim3:" + this.fZP);
    ae.d("VoipAudioInfo", "mt3dAzim4:" + this.fZQ);
    ae.d("VoipAudioInfo", "mt3dAzim5:" + this.fZR);
    ae.d("VoipAudioInfo", "mt3dAzim6:" + this.fZS);
    ae.d("VoipAudioInfo", "mt3dAzim7:" + this.fZT);
    ae.d("VoipAudioInfo", "mt3dAzim8:" + this.fZU);
    ae.d("VoipAudioInfo", "mt3dElvl1:" + this.fZV);
    ae.d("VoipAudioInfo", "mt3dElvl2:" + this.fZW);
    ae.d("VoipAudioInfo", "mt3dElvl3:" + this.fZX);
    ae.d("VoipAudioInfo", "mt3dElvl4:" + this.fZY);
    ae.d("VoipAudioInfo", "mt3dElvl5:" + this.fZZ);
    ae.d("VoipAudioInfo", "mt3dElvl6:" + this.gaa);
    ae.d("VoipAudioInfo", "mt3dElvl7:" + this.gab);
    ae.d("VoipAudioInfo", "mt3dElvl8:" + this.gac);
    ae.d("VoipAudioInfo", "mt3dPhi:" + this.gad);
    ae.d("VoipAudioInfo", "mt3dtheta1:" + this.gae);
    ae.d("VoipAudioInfo", "mt3dTheta2:" + this.gaf);
    ae.d("VoipAudioInfo", "waveAgcMode" + this.fZj);
    ae.d("VoipAudioInfo", "waveAgcSpkGain" + this.fZk);
    ae.d("VoipAudioInfo", "waveAgcPhnGain" + this.fZl);
    ae.d("VoipAudioInfo", "waveAgcHeadsetGain" + this.fZm);
    ae.d("VoipAudioInfo", "waveAgcTarget" + this.fZn);
    ae.d("VoipAudioInfo", "waveAgcCRatio" + this.fZo);
    ae.d("VoipAudioInfo", "waveAgcDnTHR" + this.fZp);
    ae.d("VoipAudioInfo", "waveAgcBase" + this.fZq);
    ae.d("VoipAudioInfo", "waveAgcGainTHR" + this.fZr);
    ae.d("VoipAudioInfo", "waveAgcDampTHR" + this.fZs);
    ae.d("VoipAudioInfo", "waveAgcDamper" + this.fZt);
    AppMethodBeat.o(155641);
  }
  
  public final void reset()
  {
    this.fYn = false;
    this.fYo = -1;
    this.fYp = -1;
    this.fYq = -1;
    this.fYr = -1;
    this.fYs = -1;
    this.fYt = -1;
    this.fYu = -1;
    this.fYw = -1;
    this.fYv = -1;
    this.fZc = -1;
    this.fYx = -1;
    this.fYy = -1;
    this.fYz = -1;
    this.fYL = -1;
    this.fYM = -1;
    this.fYN = -1;
    this.fYO = -1;
    this.fYP = -1;
    this.fYQ = -1;
    this.fYR = -1;
    this.fYS = false;
    this.fYT = -1;
    this.fYU = -1;
    this.fYW = -1;
    this.fYV = -1;
    this.fZb = -1;
    this.fYX = -1;
    this.fYY = -1;
    this.fYZ = -1;
    this.fZa = -1;
    this.fZd = -1;
    this.fZe = -1;
    this.fZf = -1;
    this.fZg = -1;
    this.fZh = -1;
    this.fZi = -1;
    this.fZj = -1;
    this.fZk = -1;
    this.fZl = -1;
    this.fZm = -1;
    this.fZn = -1;
    this.fZo = -1;
    this.fZp = -1;
    this.fZq = -1;
    this.fZr = -1;
    this.fZs = -1;
    this.fZt = -1;
    this.fYA = -1;
    this.fYB = -1;
    this.fYC = -1;
    this.fYD = -1;
    this.fYG = -1;
    this.fYH = -1;
    this.fYI = -1;
    this.fYJ = -1;
    this.fZu = 0;
    this.fZv = 0;
    this.fZw = -1;
    this.fYF = -1;
    this.fYE = -1;
    this.fZz = false;
    this.fZy[0] = -1;
    this.fZy[1] = -1;
    this.fZA = -1;
    this.fZI = -1;
    this.fZJ = -1;
    this.fZK = -1;
    this.fZL = -1;
    this.fYK = -1;
    this.fZM = -1;
    this.fZN = -1;
    this.fZO = -1;
    this.fZP = -1;
    this.fZQ = -1;
    this.fZR = -1;
    this.fZS = -1;
    this.fZT = -1;
    this.fZU = -1;
    this.fZV = -1;
    this.fZW = -1;
    this.fZX = -1;
    this.fZY = -1;
    this.fZZ = -1;
    this.gaa = -1;
    this.gab = -1;
    this.gac = -1;
    this.gad = -1;
    this.gae = -1;
    this.gaf = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.compatible.deviceinfo.b
 * JD-Core Version:    0.7.0.1
 */