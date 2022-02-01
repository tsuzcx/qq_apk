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
  private static final int bnF;
  private static final int bnG;
  private static final int bnH;
  private static final int bnI;
  private static final int bnJ;
  private static final int bnK;
  private static final int bnL;
  private static final int bnM;
  private static final int bnN;
  private static final int bnO;
  private static final int bnP;
  private static final int bnQ;
  private static final int bnR;
  private static final int bnS;
  private static final int bnT;
  private static final int bnU;
  private static final int bnV;
  private static final int bnW;
  private static final int bnX;
  private static final int bnY;
  private static final int bnZ;
  private static final int boa;
  private static final int bob;
  private static final int boc;
  private static final int bod;
  private static final int boe;
  private static final int bof;
  private static final int bog;
  private static final int boh;
  private static final String[] boi;
  
  static
  {
    AppMethodBeat.i(92111);
    bnF = x.bJ("nam");
    bnG = x.bJ("trk");
    bnH = x.bJ("cmt");
    bnI = x.bJ("day");
    bnJ = x.bJ("ART");
    bnK = x.bJ("too");
    bnL = x.bJ("alb");
    bnM = x.bJ("com");
    bnN = x.bJ("wrt");
    bnO = x.bJ("lyr");
    bnP = x.bJ("gen");
    bnQ = x.bJ("covr");
    bnR = x.bJ("gnre");
    bnS = x.bJ("grp");
    bnT = x.bJ("disk");
    bnU = x.bJ("trkn");
    bnV = x.bJ("tmpo");
    bnW = x.bJ("cpil");
    bnX = x.bJ("aART");
    bnY = x.bJ("sonm");
    bnZ = x.bJ("soal");
    boa = x.bJ("soar");
    bob = x.bJ("soaa");
    boc = x.bJ("soco");
    bod = x.bJ("rtng");
    boe = x.bJ("pgap");
    bof = x.bJ("sosn");
    bog = x.bJ("tvsh");
    boh = x.bJ("----");
    boi = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
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
      new StringBuilder("Failed to parse uint8 attribute: ").append(a.ee(paramInt));
      AppMethodBeat.o(92107);
      return null;
    }
  }
  
  private static TextInformationFrame a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92106);
    int i = paramm.readInt();
    if (paramm.readInt() == a.bmo)
    {
      paramm.eZ(8);
      paramString = new TextInformationFrame(paramString, null, paramm.fa(i - 16));
      AppMethodBeat.o(92106);
      return paramString;
    }
    new StringBuilder("Failed to parse text attribute: ").append(a.ee(paramInt));
    AppMethodBeat.o(92106);
    return null;
  }
  
  private static TextInformationFrame b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(92108);
    int i = paramm.readInt();
    if ((paramm.readInt() == a.bmo) && (i >= 22))
    {
      paramm.eZ(10);
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
    new StringBuilder("Failed to parse index/count attribute: ").append(a.ee(paramInt));
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
      paramm.eZ(4);
      if (n == a.bmm)
      {
        str1 = paramm.fa(k - 12);
      }
      else if (n == a.bmn)
      {
        str2 = paramm.fa(k - 12);
      }
      else
      {
        if (n == a.bmo)
        {
          j = k;
          i = m;
        }
        paramm.eZ(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(92109);
      return null;
    }
    paramm.setPosition(i);
    paramm.eZ(16);
    paramm = new CommentFrame("und", str2, paramm.fa(j - 16));
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
        if (k == bnH)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.bmo)
          {
            paramm.eZ(8);
            localObject1 = paramm.fa(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.ee(j));
          }
        }
        if (k == bnF) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
      }
      if (k == bnG)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if ((k == bnM) || (k == bnN))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnI)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnJ)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnK)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnL)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnO)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnP)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bnS)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
    }
    else
    {
      if (j == bnR)
      {
        j = p(paramm);
        if ((j > 0) && (j <= boi.length)) {}
        for (localObject3 = boi[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject4;
        }
      }
      if (j == bnT)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bnU)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bnV)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bnW)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bnQ)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.bmo)
        {
          k = a.ed(paramm.readInt());
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
        paramm.eZ(4);
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
        if (j == bnX)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bnY)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bnZ)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == boa)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bob)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == boc)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bod)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == boe)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bof)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bog)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == boh)
        {
          localObject3 = d(paramm, i);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.ee(j));
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
    paramm.eZ(4);
    if (paramm.readInt() == a.bmo)
    {
      paramm.eZ(8);
      int i = paramm.readUnsignedByte();
      AppMethodBeat.o(92110);
      return i;
    }
    AppMethodBeat.o(92110);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.f
 * JD-Core Version:    0.7.0.1
 */