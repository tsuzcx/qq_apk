package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static final int baA;
  public static final int baB;
  public static final int baD;
  public static final int baG;
  public static final int baH;
  public static final int baI;
  public static final int baJ;
  public static final int baK;
  public static final int baL;
  public static final int baM;
  public static final int baN;
  public static final int baO;
  public static final int baP;
  public static final int baQ;
  public static final int baR;
  public static final int baS;
  public static final int baT;
  public static final int baU;
  public static final int baV;
  public static final int baW;
  public static final int baX;
  public static final int baY;
  public static final int baZ;
  public static final int bat;
  public static final int bau;
  public static final int bav;
  public static final int baw;
  public static final int bax;
  public static final int bay;
  public static final int baz;
  public static final int bbA;
  public static final int bbB;
  public static final int bbC;
  public static final int bbD;
  public static final int bbE;
  public static final int bbF;
  public static final int bbG;
  public static final int bbH;
  public static final int bbI;
  public static final int bbJ;
  public static final int bbL;
  public static final int bbM;
  public static final int bbN;
  public static final int bbO;
  public static final int bbP;
  public static final int bbR;
  public static final int bbS;
  public static final int bbT;
  public static final int bbU;
  public static final int bbV;
  public static final int bbW;
  public static final int bbX;
  public static final int bbY;
  public static final int bba;
  public static final int bbb;
  public static final int bbc;
  public static final int bbd;
  public static final int bbe;
  public static final int bbf;
  public static final int bbh;
  public static final int bbi;
  public static final int bbj;
  public static final int bbk;
  public static final int bbl;
  public static final int bbm;
  public static final int bbn;
  public static final int bbo;
  public static final int bbp;
  public static final int bbq;
  public static final int bbr;
  public static final int bbs;
  public static final int bbt;
  public static final int bbu;
  public static final int bbv;
  public static final int bbw;
  public static final int bbz;
  public static final int iwW;
  private int iwX;
  private long iwY;
  public long iwZ;
  private int type;
  
  static
  {
    AppMethodBeat.i(133849);
    bat = c.aQ("ftyp");
    bau = c.aQ("avc1");
    bav = c.aQ("avc3");
    baw = c.aQ("hvc1");
    bax = c.aQ("hev1");
    bay = c.aQ("s263");
    baz = c.aQ("d263");
    baA = c.aQ("mdat");
    baB = c.aQ("mp4a");
    baD = c.aQ("wave");
    baG = c.aQ("ac-3");
    baH = c.aQ("dac3");
    baI = c.aQ("ec-3");
    baJ = c.aQ("dec3");
    baK = c.aQ("dtsc");
    baL = c.aQ("dtsh");
    baM = c.aQ("dtsl");
    baN = c.aQ("dtse");
    baO = c.aQ("ddts");
    baP = c.aQ("tfdt");
    baQ = c.aQ("tfhd");
    baR = c.aQ("trex");
    baS = c.aQ("trun");
    baT = c.aQ("sidx");
    baU = c.aQ("moov");
    baV = c.aQ("mvhd");
    baW = c.aQ("trak");
    baX = c.aQ("mdia");
    baY = c.aQ("minf");
    baZ = c.aQ("stbl");
    bba = c.aQ("avcC");
    bbb = c.aQ("hvcC");
    bbc = c.aQ("esds");
    bbd = c.aQ("moof");
    bbe = c.aQ("traf");
    bbf = c.aQ("mvex");
    bbh = c.aQ("tkhd");
    bbi = c.aQ("edts");
    bbj = c.aQ("elst");
    bbk = c.aQ("mdhd");
    bbl = c.aQ("hdlr");
    bbm = c.aQ("stsd");
    bbn = c.aQ("pssh");
    bbo = c.aQ("sinf");
    bbp = c.aQ("schm");
    bbq = c.aQ("schi");
    bbr = c.aQ("tenc");
    bbs = c.aQ("encv");
    bbt = c.aQ("enca");
    bbu = c.aQ("frma");
    bbv = c.aQ("saiz");
    bbw = c.aQ("saio");
    bbz = c.aQ("uuid");
    bbA = c.aQ("senc");
    bbB = c.aQ("pasp");
    bbC = c.aQ("TTML");
    bbD = c.aQ("vmhd");
    bbE = c.aQ("mp4v");
    bbF = c.aQ("stts");
    bbG = c.aQ("stss");
    bbH = c.aQ("ctts");
    bbI = c.aQ("stsc");
    bbJ = c.aQ("stsz");
    bbL = c.aQ("stco");
    bbM = c.aQ("co64");
    bbN = c.aQ("tx3g");
    bbO = c.aQ("wvtt");
    bbP = c.aQ("stpp");
    bbR = c.aQ("samr");
    bbS = c.aQ("sawb");
    bbT = c.aQ("udta");
    bbU = c.aQ("meta");
    bbV = c.aQ("ilst");
    bbW = c.aQ("mean");
    bbX = c.aQ("name");
    bbY = c.aQ("data");
    iwW = c.aQ("----");
    AppMethodBeat.o(133849);
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.iwX = paramInt1;
    this.iwZ = paramLong1;
    this.type = paramInt2;
    this.iwY = paramLong2;
  }
  
  public final boolean aNA()
  {
    return this.type == baU;
  }
  
  public final boolean aNB()
  {
    return this.iwX == 0;
  }
  
  public final long getEndPos()
  {
    AppMethodBeat.i(133847);
    long l1 = this.iwZ;
    long l2 = getSize();
    AppMethodBeat.o(133847);
    return l1 + l2;
  }
  
  public final long getSize()
  {
    if (this.iwY > 0L) {
      return this.iwY;
    }
    return this.iwX;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133848);
    Object localObject = new StringBuilder("Atom{atomSize=").append(this.iwX).append(", atomLargeSize=").append(this.iwY).append(", type=");
    int i = this.type;
    localObject = new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.iwZ + '}';
    AppMethodBeat.o(133848);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */