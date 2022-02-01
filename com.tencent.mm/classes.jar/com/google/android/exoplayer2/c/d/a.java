package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
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
  public static final int cOU;
  public static final int cOV;
  public static final int cOW;
  public static final int cOX;
  public static final int cOY;
  public static final int cOZ;
  public static final int cOh = x.du("ftyp");
  public static final int cOi = x.du("avc1");
  public static final int cOj = x.du("avc3");
  public static final int cOk = x.du("hvc1");
  public static final int cOl = x.du("hev1");
  public static final int cOm = x.du("s263");
  public static final int cOn = x.du("d263");
  public static final int cOo = x.du("mdat");
  public static final int cOp = x.du("mp4a");
  public static final int cOq = x.du(".mp3");
  public static final int cOr = x.du("wave");
  public static final int cOs = x.du("lpcm");
  public static final int cOt = x.du("sowt");
  public static final int cOu = x.du("ac-3");
  public static final int cOv = x.du("dac3");
  public static final int cOw = x.du("ec-3");
  public static final int cOx = x.du("dec3");
  public static final int cOy = x.du("dtsc");
  public static final int cOz = x.du("dtsh");
  public static final int cPA = x.du("co64");
  public static final int cPB = x.du("tx3g");
  public static final int cPC = x.du("wvtt");
  public static final int cPD = x.du("stpp");
  public static final int cPE = x.du("c608");
  public static final int cPF = x.du("samr");
  public static final int cPG = x.du("sawb");
  public static final int cPH = x.du("udta");
  public static final int cPI = x.du("meta");
  public static final int cPJ = x.du("ilst");
  public static final int cPK = x.du("mean");
  public static final int cPL = x.du("name");
  public static final int cPM = x.du("data");
  public static final int cPN = x.du("emsg");
  public static final int cPO = x.du("st3d");
  public static final int cPP = x.du("sv3d");
  public static final int cPQ = x.du("proj");
  public static final int cPR = x.du("vp08");
  public static final int cPS = x.du("vp09");
  public static final int cPT = x.du("vpcC");
  public static final int cPU = x.du("camm");
  public static final int cPV = x.du("alac");
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
  public static final int cPl;
  public static final int cPm;
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
  public static final int cPy;
  public static final int cPz;
  public final int type;
  
  static
  {
    cOA = x.du("dtsl");
    cOB = x.du("dtse");
    cOC = x.du("ddts");
    cOD = x.du("tfdt");
    cOE = x.du("tfhd");
    cOF = x.du("trex");
    cOG = x.du("trun");
    cOH = x.du("sidx");
    cOI = x.du("moov");
    cOJ = x.du("mvhd");
    cOK = x.du("trak");
    cOL = x.du("mdia");
    cOM = x.du("minf");
    cON = x.du("stbl");
    cOO = x.du("avcC");
    cOP = x.du("hvcC");
    cOQ = x.du("esds");
    cOR = x.du("moof");
    cOS = x.du("traf");
    cOT = x.du("mvex");
    cOU = x.du("mehd");
    cOV = x.du("tkhd");
    cOW = x.du("edts");
    cOX = x.du("elst");
    cOY = x.du("mdhd");
    cOZ = x.du("hdlr");
    cPa = x.du("stsd");
    cPb = x.du("pssh");
    cPc = x.du("sinf");
    cPd = x.du("schm");
    cPe = x.du("schi");
    cPf = x.du("tenc");
    cPg = x.du("encv");
    cPh = x.du("enca");
    cPi = x.du("frma");
    cPj = x.du("saiz");
    cPk = x.du("saio");
    cPl = x.du("sbgp");
    cPm = x.du("sgpd");
    cPn = x.du("uuid");
    cPo = x.du("senc");
    cPp = x.du("pasp");
    cPq = x.du("TTML");
    cPr = x.du("vmhd");
    cPs = x.du("mp4v");
    cPt = x.du("stts");
    cPu = x.du("stss");
    cPv = x.du("ctts");
    cPw = x.du("stsc");
    cPx = x.du("stsz");
    cPy = x.du("stz2");
    cPz = x.du("stco");
  }
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int hG(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int hH(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String hI(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return hI(this.type);
  }
  
  static final class a
    extends a
  {
    public final long cPW;
    public final List<a.b> cPX;
    public final List<a> cPY;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(92050);
      this.cPW = paramLong;
      this.cPX = new ArrayList();
      this.cPY = new ArrayList();
      AppMethodBeat.o(92050);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(92052);
      this.cPY.add(parama);
      AppMethodBeat.o(92052);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(92051);
      this.cPX.add(paramb);
      AppMethodBeat.o(92051);
    }
    
    public final a.b hJ(int paramInt)
    {
      AppMethodBeat.i(92053);
      int j = this.cPX.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.cPX.get(i);
        if (localb.type == paramInt)
        {
          AppMethodBeat.o(92053);
          return localb;
        }
        i += 1;
      }
      AppMethodBeat.o(92053);
      return null;
    }
    
    public final a hK(int paramInt)
    {
      AppMethodBeat.i(92054);
      int j = this.cPY.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.cPY.get(i);
        if (locala.type == paramInt)
        {
          AppMethodBeat.o(92054);
          return locala;
        }
        i += 1;
      }
      AppMethodBeat.o(92054);
      return null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(92055);
      String str = hI(this.type) + " leaves: " + Arrays.toString(this.cPX.toArray()) + " containers: " + Arrays.toString(this.cPY.toArray());
      AppMethodBeat.o(92055);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m cPZ;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.cPZ = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */