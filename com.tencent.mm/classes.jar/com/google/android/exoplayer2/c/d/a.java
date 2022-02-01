package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
{
  public static final int aZH = x.aY("ftyp");
  public static final int aZI = x.aY("avc1");
  public static final int aZJ = x.aY("avc3");
  public static final int aZK = x.aY("hvc1");
  public static final int aZL = x.aY("hev1");
  public static final int aZM = x.aY("s263");
  public static final int aZN = x.aY("d263");
  public static final int aZO = x.aY("mdat");
  public static final int aZP = x.aY("mp4a");
  public static final int aZQ = x.aY(".mp3");
  public static final int aZR = x.aY("wave");
  public static final int aZS = x.aY("lpcm");
  public static final int aZT = x.aY("sowt");
  public static final int aZU = x.aY("ac-3");
  public static final int aZV = x.aY("dac3");
  public static final int aZW = x.aY("ec-3");
  public static final int aZX = x.aY("dec3");
  public static final int aZY = x.aY("dtsc");
  public static final int aZZ = x.aY("dtsh");
  public static final int baA = x.aY("stsd");
  public static final int baB = x.aY("pssh");
  public static final int baC = x.aY("sinf");
  public static final int baD = x.aY("schm");
  public static final int baE = x.aY("schi");
  public static final int baF = x.aY("tenc");
  public static final int baG = x.aY("encv");
  public static final int baH = x.aY("enca");
  public static final int baI = x.aY("frma");
  public static final int baJ = x.aY("saiz");
  public static final int baK = x.aY("saio");
  public static final int baL = x.aY("sbgp");
  public static final int baM = x.aY("sgpd");
  public static final int baN = x.aY("uuid");
  public static final int baO = x.aY("senc");
  public static final int baP = x.aY("pasp");
  public static final int baQ = x.aY("TTML");
  public static final int baR = x.aY("vmhd");
  public static final int baS = x.aY("mp4v");
  public static final int baT = x.aY("stts");
  public static final int baU = x.aY("stss");
  public static final int baV = x.aY("ctts");
  public static final int baW = x.aY("stsc");
  public static final int baX = x.aY("stsz");
  public static final int baY = x.aY("stz2");
  public static final int baZ = x.aY("stco");
  public static final int baa = x.aY("dtsl");
  public static final int bab = x.aY("dtse");
  public static final int bac = x.aY("ddts");
  public static final int bad = x.aY("tfdt");
  public static final int bae = x.aY("tfhd");
  public static final int baf = x.aY("trex");
  public static final int bag = x.aY("trun");
  public static final int bah = x.aY("sidx");
  public static final int bai = x.aY("moov");
  public static final int baj = x.aY("mvhd");
  public static final int bak = x.aY("trak");
  public static final int bal = x.aY("mdia");
  public static final int bam = x.aY("minf");
  public static final int ban = x.aY("stbl");
  public static final int bao = x.aY("avcC");
  public static final int bap = x.aY("hvcC");
  public static final int baq = x.aY("esds");
  public static final int bar = x.aY("moof");
  public static final int bas = x.aY("traf");
  public static final int bat = x.aY("mvex");
  public static final int bau = x.aY("mehd");
  public static final int bav = x.aY("tkhd");
  public static final int baw = x.aY("edts");
  public static final int bax = x.aY("elst");
  public static final int bay = x.aY("mdhd");
  public static final int baz = x.aY("hdlr");
  public static final int bba = x.aY("co64");
  public static final int bbb = x.aY("tx3g");
  public static final int bbc = x.aY("wvtt");
  public static final int bbd = x.aY("stpp");
  public static final int bbe = x.aY("c608");
  public static final int bbf = x.aY("samr");
  public static final int bbg = x.aY("sawb");
  public static final int bbh = x.aY("udta");
  public static final int bbi = x.aY("meta");
  public static final int bbj = x.aY("ilst");
  public static final int bbk = x.aY("mean");
  public static final int bbl = x.aY("name");
  public static final int bbm = x.aY("data");
  public static final int bbn = x.aY("emsg");
  public static final int bbo = x.aY("st3d");
  public static final int bbp = x.aY("sv3d");
  public static final int bbq = x.aY("proj");
  public static final int bbr = x.aY("vp08");
  public static final int bbs = x.aY("vp09");
  public static final int bbt = x.aY("vpcC");
  public static final int bbu = x.aY("camm");
  public static final int bbv = x.aY("alac");
  public final int type;
  
  public a(int paramInt)
  {
    this.type = paramInt;
  }
  
  public static int ee(int paramInt)
  {
    return paramInt >> 24 & 0xFF;
  }
  
  public static int ef(int paramInt)
  {
    return 0xFFFFFF & paramInt;
  }
  
  public static String eg(int paramInt)
  {
    return (char)(paramInt >> 24 & 0xFF) + (char)(paramInt >> 16 & 0xFF) + (char)(paramInt >> 8 & 0xFF) + (char)(paramInt & 0xFF);
  }
  
  public String toString()
  {
    return eg(this.type);
  }
  
  static final class a
    extends a
  {
    public final long bbw;
    public final List<a.b> bbx;
    public final List<a> bby;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(92050);
      this.bbw = paramLong;
      this.bbx = new ArrayList();
      this.bby = new ArrayList();
      AppMethodBeat.o(92050);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(92052);
      this.bby.add(parama);
      AppMethodBeat.o(92052);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(92051);
      this.bbx.add(paramb);
      AppMethodBeat.o(92051);
    }
    
    public final a.b eh(int paramInt)
    {
      AppMethodBeat.i(92053);
      int j = this.bbx.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.bbx.get(i);
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
    
    public final a ei(int paramInt)
    {
      AppMethodBeat.i(92054);
      int j = this.bby.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.bby.get(i);
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
      String str = eg(this.type) + " leaves: " + Arrays.toString(this.bbx.toArray()) + " containers: " + Arrays.toString(this.bby.toArray());
      AppMethodBeat.o(92055);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m bbz;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.bbz = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */