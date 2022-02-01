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
  private static final int bcD;
  private static final int bcE;
  private static final int bcF;
  private static final int bcG;
  private static final int bcH;
  private static final int bcI;
  private static final int bcJ;
  private static final int bcK;
  private static final int bcL;
  private static final int bcM;
  private static final int bcN;
  private static final int bcO;
  private static final int bcP;
  private static final int bcQ;
  private static final int bcR;
  private static final int bcS;
  private static final int bcT;
  private static final int bcU;
  private static final int bcV;
  private static final int bcW;
  private static final int bcX;
  private static final int bcY;
  private static final int bcZ;
  private static final int bda;
  private static final int bdb;
  private static final int bdc;
  private static final int bdd;
  private static final int bde;
  private static final int bdf;
  private static final String[] bdg;
  
  static
  {
    AppMethodBeat.i(92111);
    bcD = x.aY("nam");
    bcE = x.aY("trk");
    bcF = x.aY("cmt");
    bcG = x.aY("day");
    bcH = x.aY("ART");
    bcI = x.aY("too");
    bcJ = x.aY("alb");
    bcK = x.aY("com");
    bcL = x.aY("wrt");
    bcM = x.aY("lyr");
    bcN = x.aY("gen");
    bcO = x.aY("covr");
    bcP = x.aY("gnre");
    bcQ = x.aY("grp");
    bcR = x.aY("disk");
    bcS = x.aY("trkn");
    bcT = x.aY("tmpo");
    bcU = x.aY("cpil");
    bcV = x.aY("aART");
    bcW = x.aY("sonm");
    bcX = x.aY("soal");
    bcY = x.aY("soar");
    bcZ = x.aY("soaa");
    bda = x.aY("soco");
    bdb = x.aY("rtng");
    bdc = x.aY("pgap");
    bdd = x.aY("sosn");
    bde = x.aY("tvsh");
    bdf = x.aY("----");
    bdg = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
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
      new StringBuilder("Failed to parse uint8 attribute: ").append(a.eg(paramInt));
      AppMethodBeat.o(92107);
      return null;
    }
  }
  
  private static TextInformationFrame a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92106);
    int i = paramm.readInt();
    if (paramm.readInt() == a.bbm)
    {
      paramm.fl(8);
      paramString = new TextInformationFrame(paramString, null, paramm.fm(i - 16));
      AppMethodBeat.o(92106);
      return paramString;
    }
    new StringBuilder("Failed to parse text attribute: ").append(a.eg(paramInt));
    AppMethodBeat.o(92106);
    return null;
  }
  
  private static TextInformationFrame b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92108);
    int i = paramm.readInt();
    if ((paramm.readInt() == a.bbm) && (i >= 22))
    {
      paramm.fl(10);
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
    new StringBuilder("Failed to parse index/count attribute: ").append(a.eg(paramInt));
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
      paramm.fl(4);
      if (n == a.bbk)
      {
        str1 = paramm.fm(k - 12);
      }
      else if (n == a.bbl)
      {
        str2 = paramm.fm(k - 12);
      }
      else
      {
        if (n == a.bbm)
        {
          j = k;
          i = m;
        }
        paramm.fl(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(92109);
      return null;
    }
    paramm.setPosition(i);
    paramm.fl(16);
    paramm = new CommentFrame("und", str2, paramm.fm(j - 16));
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
        if (k == bcF)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.bbm)
          {
            paramm.fl(8);
            localObject1 = paramm.fm(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.eg(j));
          }
        }
        if (k == bcD) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
      }
      if (k == bcE)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if ((k == bcK) || (k == bcL))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcG)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcH)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcI)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcJ)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcM)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcN)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bcQ)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
    }
    else
    {
      if (j == bcP)
      {
        j = p(paramm);
        if ((j > 0) && (j <= bdg.length)) {}
        for (localObject3 = bdg[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject4;
        }
      }
      if (j == bcR)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bcS)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bcT)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bcU)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bcO)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.bbm)
        {
          k = a.ef(paramm.readInt());
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
        paramm.fl(4);
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
        if (j == bcV)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bcW)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bcX)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bcY)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bcZ)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bda)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdb)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdc)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdd)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bde)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdf)
        {
          localObject3 = d(paramm, i);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.eg(j));
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
    paramm.fl(4);
    if (paramm.readInt() == a.bbm)
    {
      paramm.fl(8);
      int i = paramm.readUnsignedByte();
      AppMethodBeat.o(92110);
      return i;
    }
    AppMethodBeat.o(92110);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.f
 * JD-Core Version:    0.7.0.1
 */