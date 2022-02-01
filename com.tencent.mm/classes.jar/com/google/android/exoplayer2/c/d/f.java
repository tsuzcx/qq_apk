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
  private static final int bdA;
  private static final int bdB;
  private static final int bdC;
  private static final int bdD;
  private static final int bdE;
  private static final int bdF;
  private static final int bdG;
  private static final int bdH;
  private static final int bdI;
  private static final int bdJ;
  private static final int bdK;
  private static final int bdL;
  private static final int bdM;
  private static final int bdN;
  private static final int bdO;
  private static final int bdP;
  private static final int bdQ;
  private static final int bdR;
  private static final String[] bdS;
  private static final int bdp;
  private static final int bdq;
  private static final int bdr;
  private static final int bds;
  private static final int bdt;
  private static final int bdu;
  private static final int bdv;
  private static final int bdw;
  private static final int bdx;
  private static final int bdy;
  private static final int bdz;
  
  static
  {
    AppMethodBeat.i(92111);
    bdp = x.aQ("nam");
    bdq = x.aQ("trk");
    bdr = x.aQ("cmt");
    bds = x.aQ("day");
    bdt = x.aQ("ART");
    bdu = x.aQ("too");
    bdv = x.aQ("alb");
    bdw = x.aQ("com");
    bdx = x.aQ("wrt");
    bdy = x.aQ("lyr");
    bdz = x.aQ("gen");
    bdA = x.aQ("covr");
    bdB = x.aQ("gnre");
    bdC = x.aQ("grp");
    bdD = x.aQ("disk");
    bdE = x.aQ("trkn");
    bdF = x.aQ("tmpo");
    bdG = x.aQ("cpil");
    bdH = x.aQ("aART");
    bdI = x.aQ("sonm");
    bdJ = x.aQ("soal");
    bdK = x.aQ("soar");
    bdL = x.aQ("soaa");
    bdM = x.aQ("soco");
    bdN = x.aQ("rtng");
    bdO = x.aQ("pgap");
    bdP = x.aQ("sosn");
    bdQ = x.aQ("tvsh");
    bdR = x.aQ("----");
    bdS = new String[] { "Blues", "Classic Rock", "Country", "Dance", "Disco", "Funk", "Grunge", "Hip-Hop", "Jazz", "Metal", "New Age", "Oldies", "Other", "Pop", "R&B", "Rap", "Reggae", "Rock", "Techno", "Industrial", "Alternative", "Ska", "Death Metal", "Pranks", "Soundtrack", "Euro-Techno", "Ambient", "Trip-Hop", "Vocal", "Jazz+Funk", "Fusion", "Trance", "Classical", "Instrumental", "Acid", "House", "Game", "Sound Clip", "Gospel", "Noise", "AlternRock", "Bass", "Soul", "Punk", "Space", "Meditative", "Instrumental Pop", "Instrumental Rock", "Ethnic", "Gothic", "Darkwave", "Techno-Industrial", "Electronic", "Pop-Folk", "Eurodance", "Dream", "Southern Rock", "Comedy", "Cult", "Gangsta", "Top 40", "Christian Rap", "Pop/Funk", "Jungle", "Native American", "Cabaret", "New Wave", "Psychadelic", "Rave", "Showtunes", "Trailer", "Lo-Fi", "Tribal", "Acid Punk", "Acid Jazz", "Polka", "Retro", "Musical", "Rock & Roll", "Hard Rock", "Folk", "Folk-Rock", "National Folk", "Swing", "Fast Fusion", "Bebob", "Latin", "Revival", "Celtic", "Bluegrass", "Avantgarde", "Gothic Rock", "Progressive Rock", "Psychedelic Rock", "Symphonic Rock", "Slow Rock", "Big Band", "Chorus", "Easy Listening", "Acoustic", "Humour", "Speech", "Chanson", "Opera", "Chamber Music", "Sonata", "Symphony", "Booty Bass", "Primus", "Porn Groove", "Satire", "Slow Jam", "Club", "Tango", "Samba", "Folklore", "Ballad", "Power Ballad", "Rhythmic Soul", "Freestyle", "Duet", "Punk Rock", "Drum Solo", "A capella", "Euro-House", "Dance Hall", "Goa", "Drum & Bass", "Club-House", "Hardcore", "Terror", "Indie", "BritPop", "Negerpunk", "Polsk Punk", "Beat", "Christian Gangsta Rap", "Heavy Metal", "Black Metal", "Crossover", "Contemporary Christian", "Christian Rock", "Merengue", "Salsa", "Thrash Metal", "Anime", "Jpop", "Synthpop" };
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
    if (paramm.readInt() == a.bbY)
    {
      paramm.eX(8);
      paramString = new TextInformationFrame(paramString, null, paramm.eY(i - 16));
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
    if ((paramm.readInt() == a.bbY) && (i >= 22))
    {
      paramm.eX(10);
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
      paramm.eX(4);
      if (n == a.bbW)
      {
        str1 = paramm.eY(k - 12);
      }
      else if (n == a.bbX)
      {
        str2 = paramm.eY(k - 12);
      }
      else
      {
        if (n == a.bbY)
        {
          j = k;
          i = m;
        }
        paramm.eX(k - 12);
      }
    }
    if ((!"com.apple.iTunes".equals(str1)) || (!"iTunSMPB".equals(str2)) || (i == -1))
    {
      AppMethodBeat.o(92109);
      return null;
    }
    paramm.setPosition(i);
    paramm.eX(16);
    paramm = new CommentFrame("und", str2, paramm.eY(j - 16));
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
        if (k == bdr)
        {
          k = paramm.readInt();
          if (paramm.readInt() == a.bbY)
          {
            paramm.eX(8);
            localObject1 = paramm.eY(k - 16);
            localObject1 = new CommentFrame("und", (String)localObject1, (String)localObject1);
          }
          for (;;)
          {
            return localObject1;
            new StringBuilder("Failed to parse comment attribute: ").append(a.eg(j));
          }
        }
        if (k == bdp) {
          break label180;
        }
      }
      finally
      {
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
      }
      if (k == bdq)
      {
        localObject3 = a(j, "TIT2", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if ((k == bdw) || (k == bdx))
      {
        localObject3 = a(j, "TCOM", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bds)
      {
        localObject3 = a(j, "TDRC", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdt)
      {
        localObject3 = a(j, "TPE1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdu)
      {
        localObject3 = a(j, "TSSE", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdv)
      {
        localObject3 = a(j, "TALB", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdy)
      {
        localObject3 = a(j, "USLT", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdz)
      {
        localObject3 = a(j, "TCON", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (k == bdC)
      {
        localObject3 = a(j, "TIT1", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
    }
    else
    {
      if (j == bdB)
      {
        j = p(paramm);
        if ((j > 0) && (j <= bdS.length)) {}
        for (localObject3 = bdS[(j - 1)];; localObject3 = null)
        {
          if (localObject3 != null) {
            localObject4 = new TextInformationFrame("TCON", null, (String)localObject3);
          }
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject4;
        }
      }
      if (j == bdD)
      {
        localObject3 = b(j, "TPOS", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bdE)
      {
        localObject3 = b(j, "TRCK", paramm);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bdF)
      {
        localObject3 = a(j, "TBPM", paramm, true, false);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bdG)
      {
        localObject3 = a(j, "TCMP", paramm, true, true);
        paramm.setPosition(i);
        AppMethodBeat.o(92105);
        return localObject3;
      }
      if (j == bdA)
      {
        j = paramm.readInt();
        localObject4 = localObject5;
        if (paramm.readInt() == a.bbY)
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
        paramm.eX(4);
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
        if (j == bdH)
        {
          localObject3 = a(j, "TPE2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdI)
        {
          localObject3 = a(j, "TSOT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdJ)
        {
          localObject3 = a(j, "TSO2", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdK)
        {
          localObject3 = a(j, "TSOA", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdL)
        {
          localObject3 = a(j, "TSOP", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdM)
        {
          localObject3 = a(j, "TSOC", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdN)
        {
          localObject3 = a(j, "ITUNESADVISORY", paramm, false, false);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdO)
        {
          localObject3 = a(j, "ITUNESGAPLESS", paramm, false, true);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdP)
        {
          localObject3 = a(j, "TVSHOWSORT", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdQ)
        {
          localObject3 = a(j, "TVSHOW", paramm);
          paramm.setPosition(i);
          AppMethodBeat.o(92105);
          return localObject3;
        }
        if (j == bdR)
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
    paramm.eX(4);
    if (paramm.readInt() == a.bbY)
    {
      paramm.eX(8);
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