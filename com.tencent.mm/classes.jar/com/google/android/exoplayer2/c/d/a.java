package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
{
  public static final int aEA;
  public static final int aEB;
  public static final int aEC;
  public static final int aED;
  public static final int aEE;
  public static final int aEF;
  public static final int aEG;
  public static final int aEH;
  public static final int aEI;
  public static final int aEJ;
  public static final int aEK;
  public static final int aEL;
  public static final int aEM;
  public static final int aEN;
  public static final int aEO;
  public static final int aEP;
  public static final int aEQ;
  public static final int aER;
  public static final int aES;
  public static final int aET;
  public static final int aEU;
  public static final int aEV;
  public static final int aEW;
  public static final int aEX;
  public static final int aEY;
  public static final int aEZ;
  public static final int aEp = x.aS("ftyp");
  public static final int aEq = x.aS("avc1");
  public static final int aEr = x.aS("avc3");
  public static final int aEs = x.aS("hvc1");
  public static final int aEt = x.aS("hev1");
  public static final int aEu = x.aS("s263");
  public static final int aEv = x.aS("d263");
  public static final int aEw = x.aS("mdat");
  public static final int aEx = x.aS("mp4a");
  public static final int aEy = x.aS(".mp3");
  public static final int aEz = x.aS("wave");
  public static final int aFA = x.aS("mp4v");
  public static final int aFB = x.aS("stts");
  public static final int aFC = x.aS("stss");
  public static final int aFD = x.aS("ctts");
  public static final int aFE = x.aS("stsc");
  public static final int aFF = x.aS("stsz");
  public static final int aFG = x.aS("stz2");
  public static final int aFH = x.aS("stco");
  public static final int aFI = x.aS("co64");
  public static final int aFJ = x.aS("tx3g");
  public static final int aFK = x.aS("wvtt");
  public static final int aFL = x.aS("stpp");
  public static final int aFM = x.aS("c608");
  public static final int aFN = x.aS("samr");
  public static final int aFO = x.aS("sawb");
  public static final int aFP = x.aS("udta");
  public static final int aFQ = x.aS("meta");
  public static final int aFR = x.aS("ilst");
  public static final int aFS = x.aS("mean");
  public static final int aFT = x.aS("name");
  public static final int aFU = x.aS("data");
  public static final int aFV = x.aS("emsg");
  public static final int aFW = x.aS("st3d");
  public static final int aFX = x.aS("sv3d");
  public static final int aFY = x.aS("proj");
  public static final int aFZ = x.aS("vp08");
  public static final int aFa;
  public static final int aFb;
  public static final int aFc;
  public static final int aFd;
  public static final int aFe;
  public static final int aFf;
  public static final int aFg;
  public static final int aFh;
  public static final int aFi;
  public static final int aFj;
  public static final int aFk;
  public static final int aFl;
  public static final int aFm;
  public static final int aFn;
  public static final int aFo;
  public static final int aFp;
  public static final int aFq;
  public static final int aFr;
  public static final int aFs;
  public static final int aFt;
  public static final int aFu;
  public static final int aFv;
  public static final int aFw;
  public static final int aFx;
  public static final int aFy;
  public static final int aFz;
  public static final int aGa = x.aS("vp09");
  public static final int aGb = x.aS("vpcC");
  public static final int aGc = x.aS("camm");
  public static final int aGd = x.aS("alac");
  public final int type;
  
  static
  {
    aEA = x.aS("lpcm");
    aEB = x.aS("sowt");
    aEC = x.aS("ac-3");
    aED = x.aS("dac3");
    aEE = x.aS("ec-3");
    aEF = x.aS("dec3");
    aEG = x.aS("dtsc");
    aEH = x.aS("dtsh");
    aEI = x.aS("dtsl");
    aEJ = x.aS("dtse");
    aEK = x.aS("ddts");
    aEL = x.aS("tfdt");
    aEM = x.aS("tfhd");
    aEN = x.aS("trex");
    aEO = x.aS("trun");
    aEP = x.aS("sidx");
    aEQ = x.aS("moov");
    aER = x.aS("mvhd");
    aES = x.aS("trak");
    aET = x.aS("mdia");
    aEU = x.aS("minf");
    aEV = x.aS("stbl");
    aEW = x.aS("avcC");
    aEX = x.aS("hvcC");
    aEY = x.aS("esds");
    aEZ = x.aS("moof");
    aFa = x.aS("traf");
    aFb = x.aS("mvex");
    aFc = x.aS("mehd");
    aFd = x.aS("tkhd");
    aFe = x.aS("edts");
    aFf = x.aS("elst");
    aFg = x.aS("mdhd");
    aFh = x.aS("hdlr");
    aFi = x.aS("stsd");
    aFj = x.aS("pssh");
    aFk = x.aS("sinf");
    aFl = x.aS("schm");
    aFm = x.aS("schi");
    aFn = x.aS("tenc");
    aFo = x.aS("encv");
    aFp = x.aS("enca");
    aFq = x.aS("frma");
    aFr = x.aS("saiz");
    aFs = x.aS("saio");
    aFt = x.aS("sbgp");
    aFu = x.aS("sgpd");
    aFv = x.aS("uuid");
    aFw = x.aS("senc");
    aFx = x.aS("pasp");
    aFy = x.aS("TTML");
    aFz = x.aS("vmhd");
  }
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int dt(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int du(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String dv(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return dv(this.type);
  }
  
  static final class a
    extends a
  {
    public final long aGe;
    public final List<a.b> aGf;
    public final List<a> aGg;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(94935);
      this.aGe = paramLong;
      this.aGf = new ArrayList();
      this.aGg = new ArrayList();
      AppMethodBeat.o(94935);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(94937);
      this.aGg.add(parama);
      AppMethodBeat.o(94937);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(94936);
      this.aGf.add(paramb);
      AppMethodBeat.o(94936);
    }
    
    public final a.b dw(int paramInt)
    {
      AppMethodBeat.i(94938);
      int j = this.aGf.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.aGf.get(i);
        if (localb.type == paramInt)
        {
          AppMethodBeat.o(94938);
          return localb;
        }
        i += 1;
      }
      AppMethodBeat.o(94938);
      return null;
    }
    
    public final a dx(int paramInt)
    {
      AppMethodBeat.i(94939);
      int j = this.aGg.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.aGg.get(i);
        if (locala.type == paramInt)
        {
          AppMethodBeat.o(94939);
          return locala;
        }
        i += 1;
      }
      AppMethodBeat.o(94939);
      return null;
    }
    
    public final String toString()
    {
      AppMethodBeat.i(94940);
      String str = dv(this.type) + " leaves: " + Arrays.toString(this.aGf.toArray()) + " containers: " + Arrays.toString(this.aGg.toArray());
      AppMethodBeat.o(94940);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m aGh;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.aGh = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */