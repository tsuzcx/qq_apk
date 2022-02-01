package com.tencent.mm.plugin.a;

import com.tencent.matrix.trace.core.AppMethodBeat;

public class a
{
  public static final int cOA;
  public static final int cOB;
  public static final int cOC;
  public static final int cOD;
  public static final int cOE;
  public static final int cOF;
  public static final int cOG;
  public static final int cOH;
  public static final int cOI;
  public static final int cOJ;
  public static final int cOK;
  public static final int cOL;
  public static final int cOM;
  public static final int cON;
  public static final int cOO;
  public static final int cOP;
  public static final int cOQ;
  public static final int cOR;
  public static final int cOS;
  public static final int cOT;
  public static final int cOV;
  public static final int cOW;
  public static final int cOX;
  public static final int cOY;
  public static final int cOZ;
  public static final int cOh;
  public static final int cOi;
  public static final int cOj;
  public static final int cOk;
  public static final int cOl;
  public static final int cOm;
  public static final int cOn;
  public static final int cOo;
  public static final int cOp;
  public static final int cOr;
  public static final int cOu;
  public static final int cOv;
  public static final int cOw;
  public static final int cOx;
  public static final int cOy;
  public static final int cOz;
  public static final int cPA;
  public static final int cPB;
  public static final int cPC;
  public static final int cPD;
  public static final int cPF;
  public static final int cPG;
  public static final int cPH;
  public static final int cPI;
  public static final int cPJ;
  public static final int cPK;
  public static final int cPL;
  public static final int cPM;
  public static final int cPa;
  public static final int cPb;
  public static final int cPc;
  public static final int cPd;
  public static final int cPe;
  public static final int cPf;
  public static final int cPg;
  public static final int cPh;
  public static final int cPi;
  public static final int cPj;
  public static final int cPk;
  public static final int cPn;
  public static final int cPo;
  public static final int cPp;
  public static final int cPq;
  public static final int cPr;
  public static final int cPs;
  public static final int cPt;
  public static final int cPu;
  public static final int cPv;
  public static final int cPw;
  public static final int cPx;
  public static final int cPz;
  public static final int pDD;
  private int pDE;
  private long pDF;
  public long pDG;
  private int type;
  
  static
  {
    AppMethodBeat.i(133849);
    cOh = c.du("ftyp");
    cOi = c.du("avc1");
    cOj = c.du("avc3");
    cOk = c.du("hvc1");
    cOl = c.du("hev1");
    cOm = c.du("s263");
    cOn = c.du("d263");
    cOo = c.du("mdat");
    cOp = c.du("mp4a");
    cOr = c.du("wave");
    cOu = c.du("ac-3");
    cOv = c.du("dac3");
    cOw = c.du("ec-3");
    cOx = c.du("dec3");
    cOy = c.du("dtsc");
    cOz = c.du("dtsh");
    cOA = c.du("dtsl");
    cOB = c.du("dtse");
    cOC = c.du("ddts");
    cOD = c.du("tfdt");
    cOE = c.du("tfhd");
    cOF = c.du("trex");
    cOG = c.du("trun");
    cOH = c.du("sidx");
    cOI = c.du("moov");
    cOJ = c.du("mvhd");
    cOK = c.du("trak");
    cOL = c.du("mdia");
    cOM = c.du("minf");
    cON = c.du("stbl");
    cOO = c.du("avcC");
    cOP = c.du("hvcC");
    cOQ = c.du("esds");
    cOR = c.du("moof");
    cOS = c.du("traf");
    cOT = c.du("mvex");
    cOV = c.du("tkhd");
    cOW = c.du("edts");
    cOX = c.du("elst");
    cOY = c.du("mdhd");
    cOZ = c.du("hdlr");
    cPa = c.du("stsd");
    cPb = c.du("pssh");
    cPc = c.du("sinf");
    cPd = c.du("schm");
    cPe = c.du("schi");
    cPf = c.du("tenc");
    cPg = c.du("encv");
    cPh = c.du("enca");
    cPi = c.du("frma");
    cPj = c.du("saiz");
    cPk = c.du("saio");
    cPn = c.du("uuid");
    cPo = c.du("senc");
    cPp = c.du("pasp");
    cPq = c.du("TTML");
    cPr = c.du("vmhd");
    cPs = c.du("mp4v");
    cPt = c.du("stts");
    cPu = c.du("stss");
    cPv = c.du("ctts");
    cPw = c.du("stsc");
    cPx = c.du("stsz");
    cPz = c.du("stco");
    cPA = c.du("co64");
    cPB = c.du("tx3g");
    cPC = c.du("wvtt");
    cPD = c.du("stpp");
    cPF = c.du("samr");
    cPG = c.du("sawb");
    cPH = c.du("udta");
    cPI = c.du("meta");
    cPJ = c.du("ilst");
    cPK = c.du("mean");
    cPL = c.du("name");
    cPM = c.du("data");
    pDD = c.du("----");
    AppMethodBeat.o(133849);
  }
  
  public a(int paramInt1, long paramLong1, int paramInt2, long paramLong2)
  {
    this.pDE = paramInt1;
    this.pDG = paramLong1;
    this.type = paramInt2;
    this.pDF = paramLong2;
  }
  
  public final boolean bTR()
  {
    return this.type == cOI;
  }
  
  public final boolean bTS()
  {
    return this.pDE == 0;
  }
  
  public final long getEndPos()
  {
    AppMethodBeat.i(133847);
    long l1 = this.pDG;
    long l2 = getSize();
    AppMethodBeat.o(133847);
    return l1 + l2;
  }
  
  public final long getSize()
  {
    if (this.pDF > 0L) {
      return this.pDF;
    }
    return this.pDE;
  }
  
  public String toString()
  {
    AppMethodBeat.i(133848);
    Object localObject = new StringBuilder("Atom{atomSize=").append(this.pDE).append(", atomLargeSize=").append(this.pDF).append(", type=");
    int i = this.type;
    localObject = new String(new byte[] { (byte)(i >> 24 & 0xFF), (byte)(i >> 16 & 0xFF), (byte)(i >> 8 & 0xFF), (byte)(i & 0xFF) }) + ", beginPos=" + this.pDG + '}';
    AppMethodBeat.o(133848);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.a.a
 * JD-Core Version:    0.7.0.1
 */