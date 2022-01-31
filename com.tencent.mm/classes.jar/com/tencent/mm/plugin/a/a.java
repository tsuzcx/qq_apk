package com.tencent.mm.plugin.a;

public class a
{
  public static final int aAA = c.aG("elst");
  public static final int aAB = c.aG("mdhd");
  public static final int aAC = c.aG("hdlr");
  public static final int aAD = c.aG("stsd");
  public static final int aAE = c.aG("pssh");
  public static final int aAF = c.aG("sinf");
  public static final int aAG = c.aG("schm");
  public static final int aAH = c.aG("schi");
  public static final int aAI = c.aG("tenc");
  public static final int aAJ = c.aG("encv");
  public static final int aAK = c.aG("enca");
  public static final int aAL = c.aG("frma");
  public static final int aAM = c.aG("saiz");
  public static final int aAN = c.aG("saio");
  public static final int aAQ = c.aG("uuid");
  public static final int aAR = c.aG("senc");
  public static final int aAS = c.aG("pasp");
  public static final int aAT = c.aG("TTML");
  public static final int aAU = c.aG("vmhd");
  public static final int aAV = c.aG("mp4v");
  public static final int aAW = c.aG("stts");
  public static final int aAX = c.aG("stss");
  public static final int aAY = c.aG("ctts");
  public static final int aAZ = c.aG("stsc");
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
  public static final int aAy;
  public static final int aAz;
  public static final int aBa = c.aG("stsz");
  public static final int aBc = c.aG("stco");
  public static final int aBd = c.aG("co64");
  public static final int aBe = c.aG("tx3g");
  public static final int aBf = c.aG("wvtt");
  public static final int aBg = c.aG("stpp");
  public static final int aBi = c.aG("samr");
  public static final int aBj = c.aG("sawb");
  public static final int aBk = c.aG("udta");
  public static final int aBl = c.aG("meta");
  public static final int aBm = c.aG("ilst");
  public static final int aBn = c.aG("mean");
  public static final int aBo = c.aG("name");
  public static final int aBp = c.aG("data");
  public static final int azK = c.aG("ftyp");
  public static final int azL = c.aG("avc1");
  public static final int azM = c.aG("avc3");
  public static final int azN = c.aG("hvc1");
  public static final int azO = c.aG("hev1");
  public static final int azP = c.aG("s263");
  public static final int azQ = c.aG("d263");
  public static final int azR = c.aG("mdat");
  public static final int azS = c.aG("mp4a");
  public static final int azU = c.aG("wave");
  public static final int azX = c.aG("ac-3");
  public static final int azY = c.aG("dac3");
  public static final int azZ = c.aG("ec-3");
  public static final int eTX = c.aG("----");
  private int eTY;
  private long eTZ;
  public long eUa;
  private int type;
  
  static
  {
    aAa = c.aG("dec3");
    aAb = c.aG("dtsc");
    aAc = c.aG("dtsh");
    aAd = c.aG("dtsl");
    aAe = c.aG("dtse");
    aAf = c.aG("ddts");
    aAg = c.aG("tfdt");
    aAh = c.aG("tfhd");
    aAi = c.aG("trex");
    aAj = c.aG("trun");
    aAk = c.aG("sidx");
    aAl = c.aG("moov");
    aAm = c.aG("mvhd");
    aAn = c.aG("trak");
    aAo = c.aG("mdia");
    aAp = c.aG("minf");
    aAq = c.aG("stbl");
    aAr = c.aG("avcC");
    aAs = c.aG("hvcC");
    aAt = c.aG("esds");
    aAu = c.aG("moof");
    aAv = c.aG("traf");
    aAw = c.aG("mvex");
    aAy = c.aG("tkhd");
    aAz = c.aG("edts");
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.eTY = paramInt1;
    this.eUa = paramLong1;
    this.type = paramInt2;
    this.eTZ = paramLong2;
  }
  
  public final boolean Vc()
  {
    return this.type == aAl;
  }
  
  public final boolean Vd()
  {
    return this.eTY == 0;
  }
  
  public final long Ve()
  {
    return this.eUa + getSize();
  }
  
  public final long getSize()
  {
    if (this.eTZ > 0L) {
      return this.eTZ;
    }
    return this.eTY;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("Atom{atomSize=").append(this.eTY).append(", atomLargeSize=").append(this.eTZ).append(", type=");
    int i = this.type;
    return new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.eUa + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */