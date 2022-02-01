package com.google.android.exoplayer2.c.d;

import com.google.android.exoplayer2.i.m;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.metadata.Metadata.Entry;
import com.google.android.exoplayer2.metadata.id3.ApicFrame;
import com.google.android.exoplayer2.metadata.id3.CommentFrame;
import com.google.android.exoplayer2.metadata.id3.Id3Frame;
import com.google.android.exoplayer2.metadata.id3.TextInformationFrame;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class f
{
  private static final int cRA;
  private static final int cRB;
  private static final int cRC;
  private static final int cRD;
  private static final int cRE;
  private static final int cRF;
  private static final String[] cRG;
  private static final int cRd;
  private static final int cRe;
  private static final int cRf;
  private static final int cRg;
  private static final int cRh;
  private static final int cRi;
  private static final int cRj;
  private static final int cRk;
  private static final int cRl;
  private static final int cRm;
  private static final int cRn;
  private static final int cRo;
  private static final int cRp;
  private static final int cRq;
  private static final int cRr;
  private static final int cRs;
  private static final int cRt;
  private static final int cRu;
  private static final int cRv;
  private static final int cRw;
  private static final int cRx;
  private static final int cRy;
  private static final int cRz;
  
  static
  {
    AppMethodBeat.i(92111);
    cRd = x.du("nam");
    cRe = x.du("trk");
    cRf = x.du("cmt");
    cRg = x.du("day");
    cRh = x.du("ART");
    cRi = x.du("too");
    cRj = x.du("alb");
    cRk = x.du("com");
    cRl = x.du("wrt");
    cRm = x.du("lyr");
    cRn = x.du("gen");
    cRo = x.du("covr");
    cRp = x.du("gnre");
    cRq = x.du("grp");
    cRr = x.du("disk");
    cRs = x.du("trkn");
    cRt = x.du("tmpo");
    cRu = x.du("cpil");
    cRv = x.du("aART");
    cRw = x.du("sonm");
    cRx = x.du("soal");
    cRy = x.du("soar");
    cRz = x.du("soaa");
    cRA = x.du("soco");
    cRB = x.du("rtng");
    cRC = x.du("pgap");
    cRD = x.du("sosn");
    cRE = x.du("tvsh");
    cRF = x.du("----");
    cRG = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
    AppMethodBeat.o(92111);
  }
  
  private static Id3Frame a(int paramInt, String paramString, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(92107);
    int i = p(paramm);
    if (paramBoolean2) {
      i = Math.min(1, i);
    }
    for (;;)
    {
      if (i >= 0)
      {
        if (paramBoolean1)
        {
          paramString = new TextInformationFrame(paramString, null, Integer.toString(i));
          AppMethodBeat.o(92107);
          return paramString;
        }
        paramString = new CommentFrame("und", paramString, Integer.toString(i));
        AppMethodBeat.o(92107);
        return paramString;
      }
      new StringBuilder("Failed to parse uint8 attribute: ").append(a.hI(paramInt));
      AppMethodBeat.o(92107);
      return null;
    }
  }
  
  private static TextInformationFrame a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92106);
    int i = paramm.readInt();
    if (paramm.readInt() == a.cPM)
    {
      paramm.iH(8);
      paramString = new TextInformationFrame(paramString, null, paramm.iI(i - 16));
      AppMethodBeat.o(92106);
      return paramString;
    }
    new StringBuilder("Failed to parse text attribute: ").append(a.hI(paramInt));
    AppMethodBeat.o(92106);
    return null;
  }
  
  private static TextInformationFrame b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92108);
    int i = paramm.readInt();
    if ((paramm.readInt() == a.cPM) && (i >= 22))
    {
      paramm.iH(10);
      i = paramm.readUnsignedShort();
      if (i > 0)
      {
        String str = String.valueOf(i);
        paramInt = paramm.readUnsignedShort();
        paramm = str;
        if (paramInt > 0) {
          paramm = str + "/" + paramInt;
        }
        paramString = new TextInformationFrame(paramString, null, paramm);
        AppMethodBeat.o(92108);
        return paramString;
      }
    }
    new StringBuilder("Failed to parse index/count attribute: ").append(a.hI(paramInt));
    AppMethodBeat.o(92108);
    return null;
  }
  
  private static Id3Frame d(m paramm, int paramInt)
  {
    AppMethodBeat.i(92109);
    int j = -1;
    int i = -1;
    String str2 = null;
    String str1 = null;
    while (paramm.position < paramInt)
    {
      int m = paramm.position;
      int k = paramm.readInt();
      int n = paramm.readInt();
      paramm.iH(4);
      if (n == a.cPK)
      {
        str1 = paramm.iI(k - 12);
      }
      else if (n == a.cPL)
      {
        str2 = paramm.iI(k - 12);
      }
      else
      {
        if (n == a.cPM)
        {
          j = k;
          i = m;
        }
        paramm.iH(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(92109);
      return null;
    }
    paramm.setPosition(i);
    paramm.iH(16);
    paramm = new CommentFrame("und", str2, paramm.iI(j - 16));
    AppMethodBeat.o(92109);
    return paramm;
  }
  
  public static Metadata.Entry o(m paramm)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    AppMethodBeat.i(92105);
    int i = paramm.position;
    i = paramm.readInt() + i;
    int j = paramm.readInt();
    int k = j >> 24 & 0xFF;
    label180:
    Object localObject3;
    if ((k == 169) || (k == 65533))
    {
      k = 0xFFFFFF & j;
      try
      {
        if (k == cRf)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.cPM)
          {
            paramm.iH(8);
            localObject1 = paramm.iI(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.hI(j));
          }
        }
        if (k == cRd) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
      }
      if (k == cRe)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if ((k == cRk) || (k == cRl))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRg)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRh)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRi)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRj)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRm)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRn)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == cRq)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
    }
    else
    {
      if (j == cRp)
      {
        j = p(paramm);
        if ((j > 0) && (j <= cRG.length)) {}
        for (localObject3 = cRG[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject4;
        }
      }
      if (j == cRr)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == cRs)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == cRt)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == cRu)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == cRo)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.cPM)
        {
          k = a.hH(paramm.readInt());
          if (k != 13) {
            break label766;
          }
          localObject3 = "image/jpeg";
        }
      }
    }
    for (;;)
    {
      localObject4 = localObject5;
      if (localObject3 != null)
      {
        paramm.iH(4);
        localObject4 = new byte[j - 16];
        paramm.readBytes((byte[])localObject4, 0, localObject4.length);
        localObject4 = new ApicFrame((String)localObject3, null, 3, (byte[])localObject4);
      }
      paramm.setPosition(i);
      AppMethodBeat.o(92105);
      return localObject4;
      label766:
      if (k == 14)
      {
        localObject3 = "image/png";
        continue;
        if (j == cRv)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRw)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRx)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRy)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRz)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRA)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRB)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRC)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRD)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRE)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == cRF)
        {
          localObject3 = d(paramm, i);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.hI(j));
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return null;
      }
      else
      {
        localObject3 = null;
      }
    }
  }
  
  private static int p(m paramm)
  {
    AppMethodBeat.i(92110);
    paramm.iH(4);
    if (paramm.readInt() == a.cPM)
    {
      paramm.iH(8);
      int i = paramm.readUnsignedByte();
      AppMethodBeat.o(92110);
      return i;
    }
    AppMethodBeat.o(92110);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.f
 * JD-Core Version:    0.7.0.1
 */