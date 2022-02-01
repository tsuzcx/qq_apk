package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
{
  public static final int bkO = x.bJ("ftyp");
  public static final int bkP = x.bJ("avc1");
  public static final int bkQ = x.bJ("avc3");
  public static final int bkR = x.bJ("hvc1");
  public static final int bkS = x.bJ("hev1");
  public static final int bkT = x.bJ("s263");
  public static final int bkU = x.bJ("d263");
  public static final int bkV = x.bJ("mdat");
  public static final int bkW = x.bJ("mp4a");
  public static final int bkX = x.bJ(".mp3");
  public static final int bkY = x.bJ("wave");
  public static final int bkZ = x.bJ("lpcm");
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
  public static final int blN;
  public static final int blO;
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
  public static final int bla = x.bJ("sowt");
  public static final int blb = x.bJ("ac-3");
  public static final int blc = x.bJ("dac3");
  public static final int bld = x.bJ("ec-3");
  public static final int ble = x.bJ("dec3");
  public static final int blf = x.bJ("dtsc");
  public static final int blg = x.bJ("dtsh");
  public static final int blh = x.bJ("dtsl");
  public static final int bli = x.bJ("dtse");
  public static final int blj = x.bJ("ddts");
  public static final int blk = x.bJ("tfdt");
  public static final int bll = x.bJ("tfhd");
  public static final int blm = x.bJ("trex");
  public static final int bln = x.bJ("trun");
  public static final int blo = x.bJ("sidx");
  public static final int blp = x.bJ("moov");
  public static final int blq = x.bJ("mvhd");
  public static final int blr = x.bJ("trak");
  public static final int bls = x.bJ("mdia");
  public static final int blt = x.bJ("minf");
  public static final int blu = x.bJ("stbl");
  public static final int blv = x.bJ("avcC");
  public static final int blw = x.bJ("hvcC");
  public static final int blx = x.bJ("esds");
  public static final int bly = x.bJ("moof");
  public static final int blz = x.bJ("traf");
  public static final int bmA = x.bJ("vpcC");
  public static final int bmB = x.bJ("camm");
  public static final int bmC = x.bJ("alac");
  public static final int bma;
  public static final int bmb;
  public static final int bmc;
  public static final int bmd;
  public static final int bme;
  public static final int bmf;
  public static final int bmg;
  public static final int bmh;
  public static final int bmi;
  public static final int bmj;
  public static final int bmk;
  public static final int bml;
  public static final int bmm;
  public static final int bmn;
  public static final int bmo;
  public static final int bmp;
  public static final int bmq;
  public static final int bmr;
  public static final int bms;
  public static final int bmt;
  public static final int bmu;
  public static final int bmv;
  public static final int bmw;
  public static final int bmx;
  public static final int bmy;
  public static final int bmz;
  public final int type;
  
  static
  {
    blA = x.bJ("mvex");
    blB = x.bJ("mehd");
    blC = x.bJ("tkhd");
    blD = x.bJ("edts");
    blE = x.bJ("elst");
    blF = x.bJ("mdhd");
    blG = x.bJ("hdlr");
    blH = x.bJ("stsd");
    blI = x.bJ("pssh");
    blJ = x.bJ("sinf");
    blK = x.bJ("schm");
    blL = x.bJ("schi");
    blM = x.bJ("tenc");
    blN = x.bJ("encv");
    blO = x.bJ("enca");
    blP = x.bJ("frma");
    blQ = x.bJ("saiz");
    blR = x.bJ("saio");
    blS = x.bJ("sbgp");
    blT = x.bJ("sgpd");
    blU = x.bJ("uuid");
    blV = x.bJ("senc");
    blW = x.bJ("pasp");
    blX = x.bJ("TTML");
    blY = x.bJ("vmhd");
    blZ = x.bJ("mp4v");
    bma = x.bJ("stts");
    bmb = x.bJ("stss");
    bmc = x.bJ("ctts");
    bmd = x.bJ("stsc");
    bme = x.bJ("stsz");
    bmf = x.bJ("stz2");
    bmg = x.bJ("stco");
    bmh = x.bJ("co64");
    bmi = x.bJ("tx3g");
    bmj = x.bJ("wvtt");
    bmk = x.bJ("stpp");
    bml = x.bJ("c608");
    bmm = x.bJ("samr");
    bmn = x.bJ("sawb");
    bmo = x.bJ("udta");
    bmp = x.bJ("meta");
    bmq = x.bJ("ilst");
    bmr = x.bJ("mean");
    bms = x.bJ("name");
    bmt = x.bJ("data");
    bmu = x.bJ("emsg");
    bmv = x.bJ("st3d");
    bmw = x.bJ("sv3d");
    bmx = x.bJ("proj");
    bmy = x.bJ("vp08");
    bmz = x.bJ("vp09");
  }
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int ei(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int ej(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String ek(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return ek(this.type);
  }
  
  static final class a
    extends a
  {
    public final long bmD;
    public final List<a.b> bmE;
    public final List<a> bmF;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(92050);
      this.bmD = paramLong;
      this.bmE = new ArrayList();
      this.bmF = new ArrayList();
      AppMethodBeat.o(92050);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(92052);
      this.bmF.add(parama);
      AppMethodBeat.o(92052);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(92051);
      this.bmE.add(paramb);
      AppMethodBeat.o(92051);
    }
    
    public final a.b el(int paramInt)
    {
      AppMethodBeat.i(92053);
      int j = this.bmE.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.bmE.get(i);
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
    
    public final a em(int paramInt)
    {
      AppMethodBeat.i(92054);
      int j = this.bmF.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.bmF.get(i);
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
      String str = ek(this.type) + " leaves: " + Arrays.toString(this.bmE.toArray()) + " containers: " + Arrays.toString(this.bmF.toArray());
      AppMethodBeat.o(92055);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m bmG;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.bmG = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */