package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static final int bkJ;
  public static final int bkK;
  public static final int bkL;
  public static final int bkM;
  public static final int bkN;
  public static final int bkO;
  public static final int bkP;
  public static final int bkQ;
  public static final int bkR;
  public static final int bkT;
  public static final int bkW;
  public static final int bkX;
  public static final int bkY;
  public static final int bkZ;
  public static final int blA;
  public static final int blB;
  public static final int blC;
  public static final int blD;
  public static final int blE;
  public static final int blF;
  public static final int blG;
  public static final int blH;
  public static final int blI;
  public static final int blJ;
  public static final int blK;
  public static final int blL;
  public static final int blM;
  public static final int blP;
  public static final int blQ;
  public static final int blR;
  public static final int blS;
  public static final int blT;
  public static final int blU;
  public static final int blV;
  public static final int blW;
  public static final int blX;
  public static final int blY;
  public static final int blZ;
  public static final int bla;
  public static final int blb;
  public static final int blc;
  public static final int bld;
  public static final int ble;
  public static final int blf;
  public static final int blg;
  public static final int blh;
  public static final int bli;
  public static final int blj;
  public static final int blk;
  public static final int bll;
  public static final int blm;
  public static final int bln;
  public static final int blo;
  public static final int blp;
  public static final int blq;
  public static final int blr;
  public static final int bls;
  public static final int blt;
  public static final int blu;
  public static final int blv;
  public static final int blx;
  public static final int bly;
  public static final int blz;
  public static final int bmb;
  public static final int bmc;
  public static final int bmd;
  public static final int bme;
  public static final int bmf;
  public static final int bmh;
  public static final int bmi;
  public static final int bmj;
  public static final int bmk;
  public static final int bml;
  public static final int bmm;
  public static final int bmn;
  public static final int bmo;
  public static final int jPS;
  private int jPT;
  private long jPU;
  public long jPV;
  private int type;
  
  static
  {
    AppMethodBeat.i(133849);
    bkJ = c.bJ("ftyp");
    bkK = c.bJ("avc1");
    bkL = c.bJ("avc3");
    bkM = c.bJ("hvc1");
    bkN = c.bJ("hev1");
    bkO = c.bJ("s263");
    bkP = c.bJ("d263");
    bkQ = c.bJ("mdat");
    bkR = c.bJ("mp4a");
    bkT = c.bJ("wave");
    bkW = c.bJ("ac-3");
    bkX = c.bJ("dac3");
    bkY = c.bJ("ec-3");
    bkZ = c.bJ("dec3");
    bla = c.bJ("dtsc");
    blb = c.bJ("dtsh");
    blc = c.bJ("dtsl");
    bld = c.bJ("dtse");
    ble = c.bJ("ddts");
    blf = c.bJ("tfdt");
    blg = c.bJ("tfhd");
    blh = c.bJ("trex");
    bli = c.bJ("trun");
    blj = c.bJ("sidx");
    blk = c.bJ("moov");
    bll = c.bJ("mvhd");
    blm = c.bJ("trak");
    bln = c.bJ("mdia");
    blo = c.bJ("minf");
    blp = c.bJ("stbl");
    blq = c.bJ("avcC");
    blr = c.bJ("hvcC");
    bls = c.bJ("esds");
    blt = c.bJ("moof");
    blu = c.bJ("traf");
    blv = c.bJ("mvex");
    blx = c.bJ("tkhd");
    bly = c.bJ("edts");
    blz = c.bJ("elst");
    blA = c.bJ("mdhd");
    blB = c.bJ("hdlr");
    blC = c.bJ("stsd");
    blD = c.bJ("pssh");
    blE = c.bJ("sinf");
    blF = c.bJ("schm");
    blG = c.bJ("schi");
    blH = c.bJ("tenc");
    blI = c.bJ("encv");
    blJ = c.bJ("enca");
    blK = c.bJ("frma");
    blL = c.bJ("saiz");
    blM = c.bJ("saio");
    blP = c.bJ("uuid");
    blQ = c.bJ("senc");
    blR = c.bJ("pasp");
    blS = c.bJ("TTML");
    blT = c.bJ("vmhd");
    blU = c.bJ("mp4v");
    blV = c.bJ("stts");
    blW = c.bJ("stss");
    blX = c.bJ("ctts");
    blY = c.bJ("stsc");
    blZ = c.bJ("stsz");
    bmb = c.bJ("stco");
    bmc = c.bJ("co64");
    bmd = c.bJ("tx3g");
    bme = c.bJ("wvtt");
    bmf = c.bJ("stpp");
    bmh = c.bJ("samr");
    bmi = c.bJ("sawb");
    bmj = c.bJ("udta");
    bmk = c.bJ("meta");
    bml = c.bJ("ilst");
    bmm = c.bJ("mean");
    bmn = c.bJ("name");
    bmo = c.bJ("data");
    jPS = c.bJ("----");
    AppMethodBeat.o(133849);
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.jPT = paramInt1;
    this.jPV = paramLong1;
    this.type = paramInt2;
    this.jPU = paramLong2;
  }
  
  public final boolean blO()
  {
    return this.type == blk;
  }
  
  public final boolean blP()
  {
    return this.jPT == 0;
  }
  
  public final long blQ()
  {
    return this.jPV;
  }
  
  public final long getEndPos()
  {
    AppMethodBeat.i(133847);
    long l1 = this.jPV;
    long l2 = getSize();
    AppMethodBeat.o(133847);
    return l1 + l2;
  }
  
  public final long getSize()
  {
    if (this.jPU > 0L) {
      return this.jPU;
    }
    return this.jPT;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133848);
    Object localObject = new StringBuilder("Atom{atomSize=").append(this.jPT).append(", atomLargeSize=").append(this.jPU).append(", type=");
    int i = this.type;
    localObject = new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.jPV + '}';
    AppMethodBeat.o(133848);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */