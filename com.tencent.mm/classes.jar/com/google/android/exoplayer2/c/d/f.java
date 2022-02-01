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
  private static final int aXA;
  private static final int aXB;
  private static final int aXC;
  private static final int aXD;
  private static final int aXE;
  private static final int aXF;
  private static final int aXG;
  private static final int aXH;
  private static final int aXI;
  private static final int aXJ;
  private static final String[] aXK;
  private static final int aXh;
  private static final int aXi;
  private static final int aXj;
  private static final int aXk;
  private static final int aXl;
  private static final int aXm;
  private static final int aXn;
  private static final int aXo;
  private static final int aXp;
  private static final int aXq;
  private static final int aXr;
  private static final int aXs;
  private static final int aXt;
  private static final int aXu;
  private static final int aXv;
  private static final int aXw;
  private static final int aXx;
  private static final int aXy;
  private static final int aXz;
  
  static
  {
    AppMethodBeat.i(92111);
    aXh = x.bU("nam");
    aXi = x.bU("trk");
    aXj = x.bU("cmt");
    aXk = x.bU("day");
    aXl = x.bU("ART");
    aXm = x.bU("too");
    aXn = x.bU("alb");
    aXo = x.bU("com");
    aXp = x.bU("wrt");
    aXq = x.bU("lyr");
    aXr = x.bU("gen");
    aXs = x.bU("covr");
    aXt = x.bU("gnre");
    aXu = x.bU("grp");
    aXv = x.bU("disk");
    aXw = x.bU("trkn");
    aXx = x.bU("tmpo");
    aXy = x.bU("cpil");
    aXz = x.bU("aART");
    aXA = x.bU("sonm");
    aXB = x.bU("soal");
    aXC = x.bU("soar");
    aXD = x.bU("soaa");
    aXE = x.bU("soco");
    aXF = x.bU("rtng");
    aXG = x.bU("pgap");
    aXH = x.bU("sosn");
    aXI = x.bU("tvsh");
    aXJ = x.bU("----");
    aXK = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
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
      new StringBuilder("Failed to parse uint8 attribute: ").append(a.es(paramInt));
      AppMethodBeat.o(92107);
      return null;
    }
  }
  
  private static TextInformationFrame a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92106);
    int i = paramm.readInt();
    if (paramm.readInt() == a.aVQ)
    {
      paramm.fu(8);
      paramString = new TextInformationFrame(paramString, null, paramm.fv(i - 16));
      AppMethodBeat.o(92106);
      return paramString;
    }
    new StringBuilder("Failed to parse text attribute: ").append(a.es(paramInt));
    AppMethodBeat.o(92106);
    return null;
  }
  
  private static TextInformationFrame b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92108);
    int i = paramm.readInt();
    if ((paramm.readInt() == a.aVQ) && (i >= 22))
    {
      paramm.fu(10);
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
    new StringBuilder("Failed to parse index/count attribute: ").append(a.es(paramInt));
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
      paramm.fu(4);
      if (n == a.aVO)
      {
        str1 = paramm.fv(k - 12);
      }
      else if (n == a.aVP)
      {
        str2 = paramm.fv(k - 12);
      }
      else
      {
        if (n == a.aVQ)
        {
          j = k;
          i = m;
        }
        paramm.fu(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(92109);
      return null;
    }
    paramm.setPosition(i);
    paramm.fu(16);
    paramm = new CommentFrame("und", str2, paramm.fv(j - 16));
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
        if (k == aXj)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.aVQ)
          {
            paramm.fu(8);
            localObject1 = paramm.fv(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.es(j));
          }
        }
        if (k == aXh) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
      }
      if (k == aXi)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if ((k == aXo) || (k == aXp))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXk)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXl)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXm)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXn)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXq)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXr)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == aXu)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
    }
    else
    {
      if (j == aXt)
      {
        j = p(paramm);
        if ((j > 0) && (j <= aXK.length)) {}
        for (localObject3 = aXK[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject4;
        }
      }
      if (j == aXv)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == aXw)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == aXx)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == aXy)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == aXs)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.aVQ)
        {
          k = a.er(paramm.readInt());
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
        paramm.fu(4);
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
        if (j == aXz)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXA)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXB)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXC)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXD)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXE)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXF)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXG)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXH)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXI)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == aXJ)
        {
          localObject3 = d(paramm, i);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.es(j));
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
    paramm.fu(4);
    if (paramm.readInt() == a.aVQ)
    {
      paramm.fu(8);
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