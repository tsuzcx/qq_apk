package com.google.android.exoplayer2.c.b;

import com.google.android.exoplayer2.i.t;

abstract class a
{
  public static final int aAA = t.aG("elst");
  public static final int aAB = t.aG("mdhd");
  public static final int aAC = t.aG("hdlr");
  public static final int aAD = t.aG("stsd");
  public static final int aAE = t.aG("pssh");
  public static final int aAF = t.aG("sinf");
  public static final int aAG = t.aG("schm");
  public static final int aAH = t.aG("schi");
  public static final int aAI = t.aG("tenc");
  public static final int aAJ = t.aG("encv");
  public static final int aAK = t.aG("enca");
  public static final int aAL = t.aG("frma");
  public static final int aAM = t.aG("saiz");
  public static final int aAN = t.aG("saio");
  public static final int aAO = t.aG("sbgp");
  public static final int aAP = t.aG("sgpd");
  public static final int aAQ = t.aG("uuid");
  public static final int aAR = t.aG("senc");
  public static final int aAS = t.aG("pasp");
  public static final int aAT = t.aG("TTML");
  public static final int aAU = t.aG("vmhd");
  public static final int aAV = t.aG("mp4v");
  public static final int aAW = t.aG("stts");
  public static final int aAX = t.aG("stss");
  public static final int aAY = t.aG("ctts");
  public static final int aAZ = t.aG("stsc");
  public static final int aAa;
  public static final int aAb;
  public static final int aAc;
  public static final int aAd;
  public static final int aAe;
  public static final int aAf;
  public static final int aAg;
  public static final int aAh;
  public static final int aAi;
  public static final int aAj;
  public static final int aAk;
  public static final int aAl;
  public static final int aAm;
  public static final int aAn;
  public static final int aAo;
  public static final int aAp;
  public static final int aAq;
  public static final int aAr;
  public static final int aAs;
  public static final int aAt;
  public static final int aAu;
  public static final int aAv;
  public static final int aAw;
  public static final int aAx;
  public static final int aAy;
  public static final int aAz;
  public static final int aBa = t.aG("stsz");
  public static final int aBb = t.aG("stz2");
  public static final int aBc = t.aG("stco");
  public static final int aBd = t.aG("co64");
  public static final int aBe = t.aG("tx3g");
  public static final int aBf = t.aG("wvtt");
  public static final int aBg = t.aG("stpp");
  public static final int aBh = t.aG("c608");
  public static final int aBi = t.aG("samr");
  public static final int aBj = t.aG("sawb");
  public static final int aBk = t.aG("udta");
  public static final int aBl = t.aG("meta");
  public static final int aBm = t.aG("ilst");
  public static final int aBn = t.aG("mean");
  public static final int aBo = t.aG("name");
  public static final int aBp = t.aG("data");
  public static final int aBq = t.aG("emsg");
  public static final int aBr = t.aG("st3d");
  public static final int aBs = t.aG("sv3d");
  public static final int aBt = t.aG("proj");
  public static final int aBu = t.aG("vp08");
  public static final int aBv = t.aG("vp09");
  public static final int aBw = t.aG("vpcC");
  public static final int aBx = t.aG("camm");
  public static final int aBy = t.aG("alac");
  public static final int azK = t.aG("ftyp");
  public static final int azL = t.aG("avc1");
  public static final int azM = t.aG("avc3");
  public static final int azN = t.aG("hvc1");
  public static final int azO = t.aG("hev1");
  public static final int azP = t.aG("s263");
  public static final int azQ = t.aG("d263");
  public static final int azR = t.aG("mdat");
  public static final int azS = t.aG("mp4a");
  public static final int azT = t.aG(".mp3");
  public static final int azU = t.aG("wave");
  public static final int azV = t.aG("lpcm");
  public static final int azW = t.aG("sowt");
  public static final int azX = t.aG("ac-3");
  public static final int azY = t.aG("dac3");
  public static final int azZ = t.aG("ec-3");
  public final int type;
  
  static
  {
    aAa = t.aG("dec3");
    aAb = t.aG("dtsc");
    aAc = t.aG("dtsh");
    aAd = t.aG("dtsl");
    aAe = t.aG("dtse");
    aAf = t.aG("ddts");
    aAg = t.aG("tfdt");
    aAh = t.aG("tfhd");
    aAi = t.aG("trex");
    aAj = t.aG("trun");
    aAk = t.aG("sidx");
    aAl = t.aG("moov");
    aAm = t.aG("mvhd");
    aAn = t.aG("trak");
    aAo = t.aG("mdia");
    aAp = t.aG("minf");
    aAq = t.aG("stbl");
    aAr = t.aG("avcC");
    aAs = t.aG("hvcC");
    aAt = t.aG("esds");
    aAu = t.aG("moof");
    aAv = t.aG("traf");
    aAw = t.aG("mvex");
    aAx = t.aG("mehd");
    aAy = t.aG("tkhd");
    aAz = t.aG("edts");
  }
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int cT(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int cU(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String cV(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return cV(this.type);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.google.android.exoplayer2.c.b.a
 * JD-Core Version:    0.7.0.1
 */