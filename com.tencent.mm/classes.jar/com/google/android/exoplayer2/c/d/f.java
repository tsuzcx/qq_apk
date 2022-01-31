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
  private static final int aHA;
  private static final int aHB;
  private static final int aHC;
  private static final int aHD;
  private static final int aHE;
  private static final int aHF;
  private static final int aHG;
  private static final int aHH;
  private static final int aHI;
  private static final int aHJ;
  private static final int aHK;
  private static final int aHL;
  private static final int aHM;
  private static final int aHN;
  private static final String[] aHO;
  private static final int aHl;
  private static final int aHm;
  private static final int aHn;
  private static final int aHo;
  private static final int aHp;
  private static final int aHq;
  private static final int aHr;
  private static final int aHs;
  private static final int aHt;
  private static final int aHu;
  private static final int aHv;
  private static final int aHw;
  private static final int aHx;
  private static final int aHy;
  private static final int aHz;
  
  static
  {
    AppMethodBeat.i(94996);
    aHl = x.aS("nam");
    aHm = x.aS("trk");
    aHn = x.aS("cmt");
    aHo = x.aS("day");
    aHp = x.aS("ART");
    aHq = x.aS("too");
    aHr = x.aS("alb");
    aHs = x.aS("com");
    aHt = x.aS("wrt");
    aHu = x.aS("lyr");
    aHv = x.aS("gen");
    aHw = x.aS("covr");
    aHx = x.aS("gnre");
    aHy = x.aS("grp");
    aHz = x.aS("disk");
    aHA = x.aS("trkn");
    aHB = x.aS("tmpo");
    aHC = x.aS("cpil");
    aHD = x.aS("aART");
    aHE = x.aS("sonm");
    aHF = x.aS("soal");
    aHG = x.aS("soar");
    aHH = x.aS("soaa");
    aHI = x.aS("soco");
    aHJ = x.aS("rtng");
    aHK = x.aS("pgap");
    aHL = x.aS("sosn");
    aHM = x.aS("tvsh");
    aHN = x.aS("----");
    aHO = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
    AppMethodBeat.o(94996);
  }
  
  private static Id3Frame a(int paramInt, String paramString, m paramm, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(94992);
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
          AppMethodBeat.o(94992);
          return paramString;
        }
        paramString = new CommentFrame("und", paramString, Integer.toString(i));
        AppMethodBeat.o(94992);
        return paramString;
      }
      new StringBuilder("Failed to parse uint8 attribute: ").append(a.dv(paramInt));
      AppMethodBeat.o(94992);
      return null;
    }
  }
  
  private static TextInformationFrame a(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(94991);
    int i = paramm.readInt();
    if (paramm.readInt() == a.aFU)
    {
      paramm.en(8);
      paramString = new TextInformationFrame(paramString, null, paramm.eo(i - 16));
      AppMethodBeat.o(94991);
      return paramString;
    }
    new StringBuilder("Failed to parse text attribute: ").append(a.dv(paramInt));
    AppMethodBeat.o(94991);
    return null;
  }
  
  private static TextInformationFrame b(int paramInt, String paramString, m paramm)
  {
    AppMethodBeat.i(94993);
    int i = paramm.readInt();
    if ((paramm.readInt() == a.aFU) && (i >= 22))
    {
      paramm.en(10);
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
        AppMethodBeat.o(94993);
        return paramString;
      }
    }
    new StringBuilder("Failed to parse index/count attribute: ").append(a.dv(paramInt));
    AppMethodBeat.o(94993);
    return null;
  }
  
  private static Id3Frame d(m paramm, int paramInt)
  {
    AppMethodBeat.i(94994);
    int j = -1;
    int i = -1;
    String str2 = null;
    String str1 = null;
    while (paramm.position < paramInt)
    {
      int m = paramm.position;
      int k = paramm.readInt();
      int n = paramm.readInt();
      paramm.en(4);
      if (n == a.aFS)
      {
        str1 = paramm.eo(k - 12);
      }
      else if (n == a.aFT)
      {
        str2 = paramm.eo(k - 12);
      }
      else
      {
        if (n == a.aFU)
        {
          j = k;
          i = m;
        }
        paramm.en(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(94994);
      return null;
    }
    paramm.setPosition(i);
    paramm.en(16);
    paramm = new CommentFrame("und", str2, paramm.eo(j - 16));
    AppMethodBeat.o(94994);
    return paramm;
  }
  
  public static Metadata.Entry o(m paramm)
  {
    Object localObject4 = null;
    Object localObject5 = null;
    Object localObject1 = null;
    AppMethodBeat.i(94990);
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
        if (k == aHn)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.aFU)
          {
            paramm.en(8);
            localObject1 = paramm.eo(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.dv(j));
          }
        }
        if (k == aHl) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
      }
      if (k == aHm)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if ((k == aHs) || (k == aHt))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHo)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHp)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHq)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHr)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHu)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHv)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (k == aHy)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
    }
    else
    {
      if (j == aHx)
      {
        j = p(paramm);
        if ((j > 0) && (j <= aHO.length)) {}
        for (localObject3 = aHO[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject4;
        }
      }
      if (j == aHz)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (j == aHA)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (j == aHB)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (j == aHC)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
        return localObject3;
      }
      if (j == aHw)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.aFU)
        {
          k = a.du(paramm.readInt());
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
        paramm.en(4);
        localObject4 = new byte[j - 16];
        paramm.readBytes((byte[])localObject4, 0, localObject4.length);
        localObject4 = new ApicFrame((String)localObject3, null, 3, (byte[])localObject4);
      }
      paramm.setPosition(i);
      AppMethodBeat.o(94990);
      return localObject4;
      label766:
      if (k == 14)
      {
        localObject3 = "image/png";
        continue;
        if (j == aHD)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHE)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHF)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHG)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHH)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHI)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHJ)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHK)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHL)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHM)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        if (j == aHN)
        {
          localObject3 = d(paramm, i);
          paramm.setPosition(i);
          AppMethodBeat.o(94990);
          return localObject3;
        }
        new StringBuilder("Skipped unknown metadata entry: ").append(a.dv(j));
        paramm.setPosition(i);
        AppMethodBeat.o(94990);
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
    AppMethodBeat.i(94995);
    paramm.en(4);
    if (paramm.readInt() == a.aFU)
    {
      paramm.en(8);
      int i = paramm.readUnsignedByte();
      AppMethodBeat.o(94995);
      return i;
    }
    AppMethodBeat.o(94995);
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.google.android.exoplayer2.c.d.f
 * JD-Core Version:    0.7.0.1
 */