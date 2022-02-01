package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

abstract class a
{
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
  public static final int bat = x.aQ("ftyp");
  public static final int bau = x.aQ("avc1");
  public static final int bav = x.aQ("avc3");
  public static final int baw = x.aQ("hvc1");
  public static final int bax = x.aQ("hev1");
  public static final int bay = x.aQ("s263");
  public static final int baz = x.aQ("d263");
  public static final int bbA = x.aQ("senc");
  public static final int bbB = x.aQ("pasp");
  public static final int bbC = x.aQ("TTML");
  public static final int bbD = x.aQ("vmhd");
  public static final int bbE = x.aQ("mp4v");
  public static final int bbF = x.aQ("stts");
  public static final int bbG = x.aQ("stss");
  public static final int bbH = x.aQ("ctts");
  public static final int bbI = x.aQ("stsc");
  public static final int bbJ = x.aQ("stsz");
  public static final int bbK = x.aQ("stz2");
  public static final int bbL = x.aQ("stco");
  public static final int bbM = x.aQ("co64");
  public static final int bbN = x.aQ("tx3g");
  public static final int bbO = x.aQ("wvtt");
  public static final int bbP = x.aQ("stpp");
  public static final int bbQ = x.aQ("c608");
  public static final int bbR = x.aQ("samr");
  public static final int bbS = x.aQ("sawb");
  public static final int bbT = x.aQ("udta");
  public static final int bbU = x.aQ("meta");
  public static final int bbV = x.aQ("ilst");
  public static final int bbW = x.aQ("mean");
  public static final int bbX = x.aQ("name");
  public static final int bbY = x.aQ("data");
  public static final int bbZ = x.aQ("emsg");
  public static final int bba;
  public static final int bbb;
  public static final int bbc;
  public static final int bbd;
  public static final int bbe;
  public static final int bbf;
  public static final int bbg;
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
  public static final int bbx;
  public static final int bby;
  public static final int bbz;
  public static final int bca = x.aQ("st3d");
  public static final int bcb = x.aQ("sv3d");
  public static final int bcc = x.aQ("proj");
  public static final int bcd = x.aQ("vp08");
  public static final int bce = x.aQ("vp09");
  public static final int bcf = x.aQ("vpcC");
  public static final int bcg = x.aQ("camm");
  public static final int bch = x.aQ("alac");
  public final int type;
  
  static
  {
    baA = x.aQ("mdat");
    baB = x.aQ("mp4a");
    baC = x.aQ(".mp3");
    baD = x.aQ("wave");
    baE = x.aQ("lpcm");
    baF = x.aQ("sowt");
    baG = x.aQ("ac-3");
    baH = x.aQ("dac3");
    baI = x.aQ("ec-3");
    baJ = x.aQ("dec3");
    baK = x.aQ("dtsc");
    baL = x.aQ("dtsh");
    baM = x.aQ("dtsl");
    baN = x.aQ("dtse");
    baO = x.aQ("ddts");
    baP = x.aQ("tfdt");
    baQ = x.aQ("tfhd");
    baR = x.aQ("trex");
    baS = x.aQ("trun");
    baT = x.aQ("sidx");
    baU = x.aQ("moov");
    baV = x.aQ("mvhd");
    baW = x.aQ("trak");
    baX = x.aQ("mdia");
    baY = x.aQ("minf");
    baZ = x.aQ("stbl");
    bba = x.aQ("avcC");
    bbb = x.aQ("hvcC");
    bbc = x.aQ("esds");
    bbd = x.aQ("moof");
    bbe = x.aQ("traf");
    bbf = x.aQ("mvex");
    bbg = x.aQ("mehd");
    bbh = x.aQ("tkhd");
    bbi = x.aQ("edts");
    bbj = x.aQ("elst");
    bbk = x.aQ("mdhd");
    bbl = x.aQ("hdlr");
    bbm = x.aQ("stsd");
    bbn = x.aQ("pssh");
    bbo = x.aQ("sinf");
    bbp = x.aQ("schm");
    bbq = x.aQ("schi");
    bbr = x.aQ("tenc");
    bbs = x.aQ("encv");
    bbt = x.aQ("enca");
    bbu = x.aQ("frma");
    bbv = x.aQ("saiz");
    bbw = x.aQ("saio");
    bbx = x.aQ("sbgp");
    bby = x.aQ("sgpd");
    bbz = x.aQ("uuid");
  }
  
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
    public final long bci;
    public final List<a.b> bcj;
    public final List<a> bck;
    
    public a(int paramInt, long paramLong)
    {
      super();
      AppMethodBeat.i(92050);
      this.bci = paramLong;
      this.bcj = new ArrayList();
      this.bck = new ArrayList();
      AppMethodBeat.o(92050);
    }
    
    public final void a(a parama)
    {
      AppMethodBeat.i(92052);
      this.bck.add(parama);
      AppMethodBeat.o(92052);
    }
    
    public final void a(a.b paramb)
    {
      AppMethodBeat.i(92051);
      this.bcj.add(paramb);
      AppMethodBeat.o(92051);
    }
    
    public final a.b eh(int paramInt)
    {
      AppMethodBeat.i(92053);
      int j = this.bcj.size();
      int i = 0;
      while (i < j)
      {
        a.b localb = (a.b)this.bcj.get(i);
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
      int j = this.bck.size();
      int i = 0;
      while (i < j)
      {
        a locala = (a)this.bck.get(i);
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
      String str = eg(this.type) + " leaves: " + Arrays.toString(this.bcj.toArray()) + " containers: " + Arrays.toString(this.bck.toArray());
      AppMethodBeat.o(92055);
      return str;
    }
  }
  
  static final class b
    extends a
  {
    public final m bcl;
    
    public b(int paramInt, m paramm)
    {
      super();
      this.bcl = paramm;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.a
 * JD-Core Version:    0.7.0.1
 */