package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static final int aZH;
  public static final int aZI;
  public static final int aZJ;
  public static final int aZK;
  public static final int aZL;
  public static final int aZM;
  public static final int aZN;
  public static final int aZO;
  public static final int aZP;
  public static final int aZR;
  public static final int aZU;
  public static final int aZV;
  public static final int aZW;
  public static final int aZX;
  public static final int aZY;
  public static final int aZZ;
  public static final int baA;
  public static final int baB;
  public static final int baC;
  public static final int baD;
  public static final int baE;
  public static final int baF;
  public static final int baG;
  public static final int baH;
  public static final int baI;
  public static final int baJ;
  public static final int baK;
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
  public static final int baZ;
  public static final int baa;
  public static final int bab;
  public static final int bac;
  public static final int bad;
  public static final int bae;
  public static final int baf;
  public static final int bag;
  public static final int bah;
  public static final int bai;
  public static final int baj;
  public static final int bak;
  public static final int bal;
  public static final int bam;
  public static final int ban;
  public static final int bao;
  public static final int bap;
  public static final int baq;
  public static final int bar;
  public static final int bas;
  public static final int bat;
  public static final int bav;
  public static final int baw;
  public static final int bax;
  public static final int bay;
  public static final int baz;
  public static final int bba;
  public static final int bbb;
  public static final int bbc;
  public static final int bbd;
  public static final int bbf;
  public static final int bbg;
  public static final int bbh;
  public static final int bbi;
  public static final int bbj;
  public static final int bbk;
  public static final int bbl;
  public static final int bbm;
  public static final int hWS;
  private int hWT;
  private long hWU;
  public long hWV;
  private int type;
  
  static
  {
    AppMethodBeat.i(133849);
    aZH = c.aY("ftyp");
    aZI = c.aY("avc1");
    aZJ = c.aY("avc3");
    aZK = c.aY("hvc1");
    aZL = c.aY("hev1");
    aZM = c.aY("s263");
    aZN = c.aY("d263");
    aZO = c.aY("mdat");
    aZP = c.aY("mp4a");
    aZR = c.aY("wave");
    aZU = c.aY("ac-3");
    aZV = c.aY("dac3");
    aZW = c.aY("ec-3");
    aZX = c.aY("dec3");
    aZY = c.aY("dtsc");
    aZZ = c.aY("dtsh");
    baa = c.aY("dtsl");
    bab = c.aY("dtse");
    bac = c.aY("ddts");
    bad = c.aY("tfdt");
    bae = c.aY("tfhd");
    baf = c.aY("trex");
    bag = c.aY("trun");
    bah = c.aY("sidx");
    bai = c.aY("moov");
    baj = c.aY("mvhd");
    bak = c.aY("trak");
    bal = c.aY("mdia");
    bam = c.aY("minf");
    ban = c.aY("stbl");
    bao = c.aY("avcC");
    bap = c.aY("hvcC");
    baq = c.aY("esds");
    bar = c.aY("moof");
    bas = c.aY("traf");
    bat = c.aY("mvex");
    bav = c.aY("tkhd");
    baw = c.aY("edts");
    bax = c.aY("elst");
    bay = c.aY("mdhd");
    baz = c.aY("hdlr");
    baA = c.aY("stsd");
    baB = c.aY("pssh");
    baC = c.aY("sinf");
    baD = c.aY("schm");
    baE = c.aY("schi");
    baF = c.aY("tenc");
    baG = c.aY("encv");
    baH = c.aY("enca");
    baI = c.aY("frma");
    baJ = c.aY("saiz");
    baK = c.aY("saio");
    baN = c.aY("uuid");
    baO = c.aY("senc");
    baP = c.aY("pasp");
    baQ = c.aY("TTML");
    baR = c.aY("vmhd");
    baS = c.aY("mp4v");
    baT = c.aY("stts");
    baU = c.aY("stss");
    baV = c.aY("ctts");
    baW = c.aY("stsc");
    baX = c.aY("stsz");
    baZ = c.aY("stco");
    bba = c.aY("co64");
    bbb = c.aY("tx3g");
    bbc = c.aY("wvtt");
    bbd = c.aY("stpp");
    bbf = c.aY("samr");
    bbg = c.aY("sawb");
    bbh = c.aY("udta");
    bbi = c.aY("meta");
    bbj = c.aY("ilst");
    bbk = c.aY("mean");
    bbl = c.aY("name");
    bbm = c.aY("data");
    hWS = c.aY("----");
    AppMethodBeat.o(133849);
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.hWT = paramInt1;
    this.hWV = paramLong1;
    this.type = paramInt2;
    this.hWU = paramLong2;
  }
  
  public final boolean aGN()
  {
    return this.type == bai;
  }
  
  public final boolean aGO()
  {
    return this.hWT == 0;
  }
  
  public final long getEndPos()
  {
    AppMethodBeat.i(133847);
    long l1 = this.hWV;
    long l2 = getSize();
    AppMethodBeat.o(133847);
    return l1 + l2;
  }
  
  public final long getSize()
  {
    if (this.hWU > 0L) {
      return this.hWU;
    }
    return this.hWT;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133848);
    Object localObject = new StringBuilder("Atom{atomSize=").append(this.hWT).append(", atomLargeSize=").append(this.hWU).append(", type=");
    int i = this.type;
    localObject = new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.hWV + '}';
    AppMethodBeat.o(133848);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */