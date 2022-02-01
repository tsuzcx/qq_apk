package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
{
  public static final int aUA;
  public static final int aUB;
  public static final int aUC;
  public static final int aUD;
  public static final int aUE;
  public static final int aUF;
  public static final int aUG;
  public static final int aUH;
  public static final int aUI;
  public static final int aUJ;
  public static final int aUK;
  public static final int aUL;
  public static final int aUM;
  public static final int aUN;
  public static final int aUO;
  public static final int aUP;
  public static final int aUQ;
  public static final int aUR;
  public static final int aUS;
  public static final int aUT;
  public static final int aUU;
  public static final int aUV;
  public static final int aUW;
  public static final int aUX;
  public static final int aUY;
  public static final int aUZ;
  public static final int aUl = x.bU("ftyp");
  public static final int aUm = x.bU("avc1");
  public static final int aUn = x.bU("avc3");
  public static final int aUo = x.bU("hvc1");
  public static final int aUp = x.bU("hev1");
  public static final int aUq = x.bU("s263");
  public static final int aUr = x.bU("d263");
  public static final int aUs = x.bU("mdat");
  public static final int aUt = x.bU("mp4a");
  public static final int aUu = x.bU(".mp3");
  public static final int aUv = x.bU("wave");
  public static final int aUw = x.bU("lpcm");
  public static final int aUx = x.bU("sowt");
  public static final int aUy = x.bU("ac-3");
  public static final int aUz = x.bU("dac3");
  public static final int aVA = x.bU("stsc");
  public static final int aVB = x.bU("stsz");
  public static final int aVC = x.bU("stz2");
  public static final int aVD = x.bU("stco");
  public static final int aVE = x.bU("co64");
  public static final int aVF = x.bU("tx3g");
  public static final int aVG = x.bU("wvtt");
  public static final int aVH = x.bU("stpp");
  public static final int aVI = x.bU("c608");
  public static final int aVJ = x.bU("samr");
  public static final int aVK = x.bU("sawb");
  public static final int aVL = x.bU("udta");
  public static final int aVM = x.bU("meta");
  public static final int aVN = x.bU("ilst");
  public static final int aVO = x.bU("mean");
  public static final int aVP = x.bU("name");
  public static final int aVQ = x.bU("data");
  public static final int aVR = x.bU("emsg");
  public static final int aVS = x.bU("st3d");
  public static final int aVT = x.bU("sv3d");
  public static final int aVU = x.bU("proj");
  public static final int aVV = x.bU("vp08");
  public static final int aVW = x.bU("vp09");
  public static final int aVX = x.bU("vpcC");
  public static final int aVY = x.bU("camm");
  public static final int aVZ = x.bU("alac");
  public static final int aVa;
  public static final int aVb;
  public static final int aVc;
  public static final int aVd;
  public static final int aVe;
  public static final int aVf;
  public static final int aVg;
  public static final int aVh;
  public static final int aVi;
  public static final int aVj;
  public static final int aVk;
  public static final int aVl;
  public static final int aVm;
  public static final int aVn;
  public static final int aVo;
  public static final int aVp;
  public static final int aVq;
  public static final int aVr;
  public static final int aVs;
  public static final int aVt;
  public static final int aVu;
  public static final int aVv;
  public static final int aVw;
  public static final int aVx;
  public static final int aVy;
  public static final int aVz;
  public final int type;
  
  static
  {
    aUA = x.bU("ec-3");
    aUB = x.bU("dec3");
    aUC = x.bU("dtsc");
    aUD = x.bU("dtsh");
    aUE = x.bU("dtsl");
    aUF = x.bU("dtse");
    aUG = x.bU("ddts");
    aUH = x.bU("tfdt");
    aUI = x.bU("tfhd");
    aUJ = x.bU("trex");
    aUK = x.bU("trun");
    aUL = x.bU("sidx");
    aUM = x.bU("moov");
    aUN = x.bU("mvhd");
    aUO = x.bU("trak");
    aUP = x.bU("mdia");
    aUQ = x.bU("minf");
    aUR = x.bU("stbl");
    aUS = x.bU("avcC");
    aUT = x.bU("hvcC");
    aUU = x.bU("esds");
    aUV = x.bU("moof");
    aUW = x.bU("traf");
    aUX = x.bU("mvex");
    aUY = x.bU("mehd");
    aUZ = x.bU("tkhd");
    aVa = x.bU("edts");
    aVb = x.bU("elst");
    aVc = x.bU("mdhd");
    aVd = x.bU("hdlr");
    aVe = x.bU("stsd");
    aVf = x.bU("pssh");
    aVg = x.bU("sinf");
    aVh = x.bU("schm");
    aVi = x.bU("schi");
    aVj = x.bU("tenc");
    aVk = x.bU("encv");
    aVl = x.bU("enca");
    aVm = x.bU("frma");
    aVn = x.bU("saiz");
    aVo = x.bU("saio");
    aVp = x.bU("sbgp");
    aVq = x.bU("sgpd");
    aVr = x.bU("uuid");
    aVs = x.bU("senc");
    aVt = x.bU("pasp");
    aVu = x.bU("TTML");
    aVv = x.bU("vmhd");
    aVw = x.bU("mp4v");
    aVx = x.bU("stts");
    aVy = x.bU("stss");
    aVz = x.bU("ctts");
  }
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int eq(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int er(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String es(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return es(this.type);
  }
  
  static final class a
    extends a
  {
    public final long aWa;
    public final List<a.b> aWb;
    public final List<a> aWc;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(92050);
      this.aWa = paramLong;
      this.aWb = new ArrayList();
      this.aWc = new ArrayList();
      AppMethodBeat.o(92050);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(92052);
      this.aWc.add(parama);
      AppMethodBeat.o(92052);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(92051);
      this.aWb.add(paramb);
      AppMethodBeat.o(92051);
    }
    
    public final a.b et(int paramInt)
    {
      AppMethodBeat.i(92053);
      int j = this.aWb.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.aWb.get(i);
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
    
    public final a eu(int paramInt)
    {
      AppMethodBeat.i(92054);
      int j = this.aWc.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.aWc.get(i);
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
      String str = es(this.type) + " leaves: " + Arrays.toString(this.aWb.toArray()) + " containers: " + Arrays.toString(this.aWc.toArray());
      AppMethodBeat.o(92055);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m aWd;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.aWd = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */