package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static final int bkO;
  public static final int bkP;
  public static final int bkQ;
  public static final int bkR;
  public static final int bkS;
  public static final int bkT;
  public static final int bkU;
  public static final int bkV;
  public static final int bkW;
  public static final int bkY;
  public static final int blA;
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
  public static final int blN;
  public static final int blO;
  public static final int blP;
  public static final int blQ;
  public static final int blR;
  public static final int blU;
  public static final int blV;
  public static final int blW;
  public static final int blX;
  public static final int blY;
  public static final int blZ;
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
  public static final int blw;
  public static final int blx;
  public static final int bly;
  public static final int blz;
  public static final int bma;
  public static final int bmb;
  public static final int bmc;
  public static final int bmd;
  public static final int bme;
  public static final int bmg;
  public static final int bmh;
  public static final int bmi;
  public static final int bmj;
  public static final int bmk;
  public static final int bmm;
  public static final int bmn;
  public static final int bmo;
  public static final int bmp;
  public static final int bmq;
  public static final int bmr;
  public static final int bms;
  public static final int bmt;
  public static final int iSY;
  private int iSZ;
  private long iTa;
  public long iTb;
  private int type;
  
  static
  {
    AppMethodBeat.i(133849);
    bkO = c.bJ("ftyp");
    bkP = c.bJ("avc1");
    bkQ = c.bJ("avc3");
    bkR = c.bJ("hvc1");
    bkS = c.bJ("hev1");
    bkT = c.bJ("s263");
    bkU = c.bJ("d263");
    bkV = c.bJ("mdat");
    bkW = c.bJ("mp4a");
    bkY = c.bJ("wave");
    blb = c.bJ("ac-3");
    blc = c.bJ("dac3");
    bld = c.bJ("ec-3");
    ble = c.bJ("dec3");
    blf = c.bJ("dtsc");
    blg = c.bJ("dtsh");
    blh = c.bJ("dtsl");
    bli = c.bJ("dtse");
    blj = c.bJ("ddts");
    blk = c.bJ("tfdt");
    bll = c.bJ("tfhd");
    blm = c.bJ("trex");
    bln = c.bJ("trun");
    blo = c.bJ("sidx");
    blp = c.bJ("moov");
    blq = c.bJ("mvhd");
    blr = c.bJ("trak");
    bls = c.bJ("mdia");
    blt = c.bJ("minf");
    blu = c.bJ("stbl");
    blv = c.bJ("avcC");
    blw = c.bJ("hvcC");
    blx = c.bJ("esds");
    bly = c.bJ("moof");
    blz = c.bJ("traf");
    blA = c.bJ("mvex");
    blC = c.bJ("tkhd");
    blD = c.bJ("edts");
    blE = c.bJ("elst");
    blF = c.bJ("mdhd");
    blG = c.bJ("hdlr");
    blH = c.bJ("stsd");
    blI = c.bJ("pssh");
    blJ = c.bJ("sinf");
    blK = c.bJ("schm");
    blL = c.bJ("schi");
    blM = c.bJ("tenc");
    blN = c.bJ("encv");
    blO = c.bJ("enca");
    blP = c.bJ("frma");
    blQ = c.bJ("saiz");
    blR = c.bJ("saio");
    blU = c.bJ("uuid");
    blV = c.bJ("senc");
    blW = c.bJ("pasp");
    blX = c.bJ("TTML");
    blY = c.bJ("vmhd");
    blZ = c.bJ("mp4v");
    bma = c.bJ("stts");
    bmb = c.bJ("stss");
    bmc = c.bJ("ctts");
    bmd = c.bJ("stsc");
    bme = c.bJ("stsz");
    bmg = c.bJ("stco");
    bmh = c.bJ("co64");
    bmi = c.bJ("tx3g");
    bmj = c.bJ("wvtt");
    bmk = c.bJ("stpp");
    bmm = c.bJ("samr");
    bmn = c.bJ("sawb");
    bmo = c.bJ("udta");
    bmp = c.bJ("meta");
    bmq = c.bJ("ilst");
    bmr = c.bJ("mean");
    bms = c.bJ("name");
    bmt = c.bJ("data");
    iSY = c.bJ("----");
    AppMethodBeat.o(133849);
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.iSZ = paramInt1;
    this.iTb = paramLong1;
    this.type = paramInt2;
    this.iTa = paramLong2;
  }
  
  public final boolean aRl()
  {
    return this.type == blp;
  }
  
  public final boolean aRm()
  {
    return this.iSZ == 0;
  }
  
  public final long getEndPos()
  {
    AppMethodBeat.i(133847);
    long l1 = this.iTb;
    long l2 = getSize();
    AppMethodBeat.o(133847);
    return l1 + l2;
  }
  
  public final long getSize()
  {
    if (this.iTa > 0L) {
      return this.iTa;
    }
    return this.iSZ;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133848);
    Object localObject = new StringBuilder("Atom{atomSize=").append(this.iSZ).append(", atomLargeSize=").append(this.iTa).append(", type=");
    int i = this.type;
    localObject = new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.iTb + '}';
    AppMethodBeat.o(133848);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */