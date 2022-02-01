package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class d
  implements v.a<c>
{
  private static final Pattern bqA;
  private static final Pattern bqB;
  private static final Pattern bqC;
  private static final Pattern bqD;
  private static final Pattern bqE;
  private static final Pattern bqF;
  private static final Pattern bqG;
  private static final Pattern bql;
  private static final Pattern bqm;
  private static final Pattern bqn;
  private static final Pattern bqo;
  private static final Pattern bqp;
  private static final Pattern bqq;
  private static final Pattern bqr;
  private static final Pattern bqs;
  private static final Pattern bqt;
  private static final Pattern bqu;
  private static final Pattern bqv;
  private static final Pattern bqw;
  private static final Pattern bqx;
  private static final Pattern bqy;
  private static final Pattern bqz;
  
  static
  {
    AppMethodBeat.i(62903);
    bql = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    bqm = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    bqn = Pattern.compile("CODECS=\"(.+?)\"");
    bqo = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    bqp = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    bqq = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    bqr = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    bqs = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    bqt = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    bqu = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    bqv = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    bqw = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    bqx = Pattern.compile("METHOD=(NONE|AES-128)");
    bqy = Pattern.compile("URI=\"(.+?)\"");
    bqz = Pattern.compile("IV=([^,.*]+)");
    bqA = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    bqB = Pattern.compile("LANGUAGE=\"(.+?)\"");
    bqC = Pattern.compile("NAME=\"(.+?)\"");
    bqD = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    bqE = as("AUTOSELECT");
    bqF = as("DEFAULT");
    bqG = as("FORCED");
    AppMethodBeat.o(62903);
  }
  
  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(62893);
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!x.fp(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    AppMethodBeat.o(62893);
    return paramInt;
  }
  
  private static int a(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(62896);
    int i = Integer.parseInt(d(paramString, paramPattern));
    AppMethodBeat.o(62896);
    return i;
  }
  
  private static a a(a parama, String paramString)
  {
    AppMethodBeat.i(62894);
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    ArrayList localArrayList1 = null;
    boolean bool1 = false;
    Object localObject1 = null;
    label59:
    Object localObject2;
    int i;
    label124:
    int j;
    label137:
    int k;
    label151:
    String str3;
    String str1;
    String str2;
    for (;;)
    {
      if (parama.hasNext())
      {
        localObject2 = parama.next();
        com.google.android.exoplayer2.d.b.i("master ExoPlayer", (String)localObject2, new Object[0]);
        if (((String)localObject2).startsWith("#EXT")) {
          localArrayList5.add(localObject2);
        }
        if (((String)localObject2).startsWith("#EXT-X-MEDIA"))
        {
          String str4;
          if (e((String)localObject2, bqF))
          {
            i = 1;
            if (!e((String)localObject2, bqG)) {
              break label276;
            }
            j = 2;
            if (!e((String)localObject2, bqE)) {
              break label281;
            }
            k = 4;
            j = j | i | k;
            str3 = c((String)localObject2, bqy);
            str1 = d((String)localObject2, bqC);
            str2 = c((String)localObject2, bqB);
            str4 = d((String)localObject2, bqA);
            i = -1;
            switch (str4.hashCode())
            {
            }
          }
          for (;;)
          {
            switch (i)
            {
            default: 
              label268:
              break label59;
              i = 0;
              break label124;
              label276:
              j = 0;
              break label137;
              label281:
              k = 0;
              break label151;
              if (str4.equals("AUDIO"))
              {
                i = 0;
                continue;
                if (str4.equals("SUBTITLES"))
                {
                  i = 1;
                  continue;
                  if (str4.equals("CLOSED-CAPTIONS")) {
                    i = 2;
                  }
                }
              }
              break;
            }
          }
          localObject2 = Format.a(str1, "application/x-mpegURL", null, null, -1, -1, -1, null, j, str2);
          if (str3 == null)
          {
            localObject1 = localObject2;
            continue;
          }
          localArrayList3.add(new a.a(str3, (Format)localObject2));
          continue;
          localArrayList4.add(new a.a(str3, Format.a(str1, "application/x-mpegURL", "text/vtt", -1, j, str2)));
          continue;
          str3 = d((String)localObject2, bqD);
          if (str3.startsWith("CC"))
          {
            localObject2 = "application/cea-608";
            i = Integer.parseInt(str3.substring(2));
            label447:
            if (localArrayList1 != null) {
              break label741;
            }
            localArrayList1 = new ArrayList();
          }
        }
      }
    }
    label741:
    for (;;)
    {
      localArrayList1.add(Format.a(str1, null, (String)localObject2, null, -1, j, str2, i));
      break label268;
      localObject2 = "application/cea-708";
      i = Integer.parseInt(str3.substring(7));
      break label447;
      if (!((String)localObject2).startsWith("#EXT-X-STREAM-INF")) {
        break;
      }
      k = a((String)localObject2, bqm);
      str1 = c((String)localObject2, bql);
      if (str1 != null) {
        k = Integer.parseInt(str1);
      }
      str1 = c((String)localObject2, bqn);
      str2 = c((String)localObject2, bqo);
      boolean bool2 = ((String)localObject2).contains("CLOSED-CAPTIONS=NONE");
      if (str2 != null)
      {
        localObject2 = str2.split("x");
        i = Integer.parseInt(localObject2[0]);
        int m = Integer.parseInt(localObject2[1]);
        if (i > 0)
        {
          j = m;
          if (m > 0) {}
        }
        else
        {
          i = -1;
        }
      }
      for (j = -1;; j = -1)
      {
        localObject2 = parama.next();
        if (localHashSet.add(localObject2)) {
          localArrayList2.add(new a.a((String)localObject2, Format.a(Integer.toString(localArrayList2.size()), "application/x-mpegURL", null, str1, k, i, j, -1.0F, null, 0)));
        }
        bool1 |= bool2;
        break;
        i = -1;
      }
      if (bool1) {}
      for (parama = Collections.emptyList();; parama = localArrayList1)
      {
        parama = new a(paramString, localArrayList5, localArrayList2, localArrayList3, localArrayList4, localObject1, parama);
        AppMethodBeat.o(62894);
        return parama;
      }
    }
  }
  
  private static boolean a(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(62892);
    int j = paramBufferedReader.read();
    int i = j;
    if (j == 239)
    {
      if ((paramBufferedReader.read() != 187) || (paramBufferedReader.read() != 191))
      {
        AppMethodBeat.o(62892);
        return false;
      }
      i = paramBufferedReader.read();
    }
    j = a(paramBufferedReader, true, i);
    i = 0;
    while (i < 7)
    {
      if (j != "#EXTM3U".charAt(i))
      {
        AppMethodBeat.o(62892);
        return false;
      }
      j = paramBufferedReader.read();
      i += 1;
    }
    boolean bool = x.fp(a(paramBufferedReader, false, j));
    AppMethodBeat.o(62892);
    return bool;
  }
  
  private static Pattern as(String paramString)
  {
    AppMethodBeat.i(62901);
    paramString = Pattern.compile(paramString + "=(NO|YES)");
    AppMethodBeat.o(62901);
    return paramString;
  }
  
  private static double b(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(62897);
    double d = Double.parseDouble(d(paramString, paramPattern));
    AppMethodBeat.o(62897);
    return d;
  }
  
  private static b b(a parama, String paramString)
  {
    AppMethodBeat.i(62895);
    int i = 0;
    long l4 = -9223372036854775807L;
    int n = 0;
    int k = 1;
    long l5 = -9223372036854775807L;
    boolean bool3 = false;
    boolean bool2 = false;
    Object localObject2 = null;
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    long l3 = 0L;
    boolean bool1 = false;
    long l1 = 0L;
    long l2 = -1L;
    boolean bool4 = false;
    String str2 = null;
    String str1 = null;
    int j = 0;
    long l7 = 0L;
    long l6 = 0L;
    int i1 = 0;
    int m = 0;
    long l8;
    String str3;
    Object localObject1;
    for (;;)
    {
      l8 = l3;
      if (!parama.hasNext()) {
        break label879;
      }
      str3 = parama.next();
      com.google.android.exoplayer2.d.b.i("ExoPlayer", str3, new Object[0]);
      if (str3.startsWith("#EXT")) {
        localArrayList2.add(str3);
      }
      if (!str3.startsWith("#EXT-X-PLAYLIST-TYPE")) {
        break label198;
      }
      localObject1 = d(str3, bqr);
      if (!"VOD".equals(localObject1)) {
        break;
      }
      i = 1;
      l3 = l8;
    }
    if ("EVENT".equals(localObject1)) {
      i = 2;
    }
    for (;;)
    {
      l3 = l8;
      break;
      label198:
      if (str3.startsWith("#EXT-X-START"))
      {
        l4 = (b(str3, bqu) * 1000000.0D);
        l3 = l8;
        break;
      }
      if (str3.startsWith("#EXT-X-MAP"))
      {
        localObject1 = d(str3, bqy);
        localObject2 = c(str3, bqw);
        if (localObject2 == null) {
          break label948;
        }
        localObject2 = ((String)localObject2).split("@");
        l3 = Long.parseLong(localObject2[0]);
        l2 = l3;
        if (localObject2.length > 1)
        {
          l1 = Long.parseLong(localObject2[1]);
          l2 = l3;
        }
      }
      label942:
      label945:
      label948:
      for (;;)
      {
        localObject2 = new b.a((String)localObject1, l1, l2);
        l1 = 0L;
        l2 = -1L;
        l3 = l8;
        break;
        if (str3.startsWith("#EXT-X-TARGETDURATION"))
        {
          l5 = a(str3, bqp) * 1000000L;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          n = a(str3, bqs);
          j = n;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-VERSION"))
        {
          k = a(str3, bqq);
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXTINF"))
        {
          l3 = (b(str3, bqt) * 1000000.0D);
          break;
        }
        if (str3.startsWith("#EXT-X-KEY"))
        {
          bool4 = "AES-128".equals(d(str3, bqx));
          if (bool4)
          {
            str2 = d(str3, bqy);
            str1 = c(str3, bqz);
            l3 = l8;
            break;
          }
          str2 = null;
          str1 = null;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-BYTERANGE"))
        {
          localObject1 = d(str3, bqv).split("@");
          l2 = Long.parseLong(localObject1[0]);
          if (localObject1.length <= 1) {
            break label945;
          }
          l1 = Long.parseLong(localObject1[1]);
        }
        for (;;)
        {
          l3 = l8;
          break;
          if (str3.startsWith("#EXT-X-DISCONTINUITY-SEQUENCE"))
          {
            m = Integer.parseInt(str3.substring(str3.indexOf(':') + 1));
            bool1 = true;
            l3 = l8;
            break;
          }
          if (str3.equals("#EXT-X-DISCONTINUITY"))
          {
            i1 += 1;
            l3 = l8;
            break;
          }
          if (str3.startsWith("#EXT-X-PROGRAM-DATE-TIME"))
          {
            l3 = l8;
            if (l6 != 0L) {
              break;
            }
            l6 = com.google.android.exoplayer2.b.u(x.aX(str3.substring(str3.indexOf(':') + 1))) - l7;
            l3 = l8;
            break;
          }
          if (!str3.startsWith("#")) {
            if (!bool4)
            {
              localObject1 = null;
              label729:
              if (l2 != -1L) {
                break label942;
              }
              l1 = 0L;
            }
          }
          for (;;)
          {
            localArrayList1.add(new b.a(str3, l8, i1, l7, bool4, str2, (String)localObject1, l1, l2));
            l3 = 0L;
            if (l2 != -1L) {
              l1 += l2;
            }
            for (;;)
            {
              l2 = -1L;
              j += 1;
              l7 += l8;
              break;
              if (str1 != null)
              {
                localObject1 = str1;
                break label729;
              }
              localObject1 = Integer.toHexString(j);
              break label729;
              if (str3.equals("#EXT-X-INDEPENDENT-SEGMENTS"))
              {
                bool3 = true;
                l3 = l8;
                break;
              }
              l3 = l8;
              if (!str3.equals("#EXT-X-ENDLIST")) {
                break;
              }
              bool2 = true;
              l3 = l8;
              break;
              label879:
              if (l6 != 0L) {}
              for (bool4 = true;; bool4 = false)
              {
                parama = new b(i, paramString, localArrayList2, l4, l6, bool1, m, n, k, l5, bool3, bool2, bool4, (b.a)localObject2, localArrayList1);
                AppMethodBeat.o(62895);
                return parama;
              }
            }
          }
        }
      }
    }
  }
  
  private static c c(Uri paramUri, InputStream paramInputStream)
  {
    AppMethodBeat.i(62891);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (!a(paramInputStream))
      {
        com.google.android.exoplayer2.d.b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[] { paramUri.toString(), paramInputStream.readLine() });
        paramUri = new r("Input does not start with the #EXTM3U header.", paramUri);
        AppMethodBeat.o(62891);
        throw paramUri;
      }
    }
    finally
    {
      x.closeQuietly(paramInputStream);
      AppMethodBeat.o(62891);
    }
    Object localObject;
    do
    {
      localLinkedList.add(localObject);
      do
      {
        localObject = paramInputStream.readLine();
        if (localObject == null) {
          break;
        }
        localObject = ((String)localObject).trim();
      } while (((String)localObject).isEmpty());
      if (((String)localObject).startsWith("#EXT-X-STREAM-INF"))
      {
        localLinkedList.add(localObject);
        paramUri = a(new a(localLinkedList, paramInputStream), paramUri.toString());
        x.closeQuietly(paramInputStream);
        AppMethodBeat.o(62891);
        return paramUri;
      }
    } while ((!((String)localObject).startsWith("#EXT-X-TARGETDURATION")) && (!((String)localObject).startsWith("#EXT-X-MEDIA-SEQUENCE")) && (!((String)localObject).startsWith("#EXTINF")) && (!((String)localObject).startsWith("#EXT-X-KEY")) && (!((String)localObject).startsWith("#EXT-X-BYTERANGE")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY-SEQUENCE")) && (!((String)localObject).equals("#EXT-X-ENDLIST")));
    localLinkedList.add(localObject);
    paramUri = b(new a(localLinkedList, paramInputStream), paramUri.toString());
    x.closeQuietly(paramInputStream);
    AppMethodBeat.o(62891);
    return paramUri;
    x.closeQuietly(paramInputStream);
    paramUri = new o("Failed to parse the playlist, could not identify any tags.");
    AppMethodBeat.o(62891);
    throw paramUri;
  }
  
  private static String c(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(62898);
    paramString = paramPattern.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(62898);
      return paramString;
    }
    AppMethodBeat.o(62898);
    return null;
  }
  
  private static String d(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(62899);
    Matcher localMatcher = paramPattern.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.groupCount() == 1))
    {
      paramString = localMatcher.group(1);
      AppMethodBeat.o(62899);
      return paramString;
    }
    paramString = new o("Couldn't match " + paramPattern.pattern() + " in " + paramString);
    AppMethodBeat.o(62899);
    throw paramString;
  }
  
  private static boolean e(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(62900);
    paramString = paramPattern.matcher(paramString);
    if (paramString.find())
    {
      boolean bool = paramString.group(1).equals("YES");
      AppMethodBeat.o(62900);
      return bool;
    }
    AppMethodBeat.o(62900);
    return false;
  }
  
  static final class a
  {
    private final BufferedReader bqH;
    private final Queue<String> bqI;
    private String bqJ;
    
    public a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
    {
      this.bqI = paramQueue;
      this.bqH = paramBufferedReader;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(62889);
      if (this.bqJ != null)
      {
        AppMethodBeat.o(62889);
        return true;
      }
      if (!this.bqI.isEmpty())
      {
        this.bqJ = ((String)this.bqI.poll());
        AppMethodBeat.o(62889);
        return true;
      }
      do
      {
        String str = this.bqH.readLine();
        this.bqJ = str;
        if (str == null) {
          break;
        }
        this.bqJ = this.bqJ.trim();
      } while (this.bqJ.isEmpty());
      AppMethodBeat.o(62889);
      return true;
      AppMethodBeat.o(62889);
      return false;
    }
    
    public final String next()
    {
      AppMethodBeat.i(62890);
      String str;
      if (hasNext())
      {
        str = this.bqJ;
        this.bqJ = null;
      }
      for (;;)
      {
        AppMethodBeat.o(62890);
        return str;
        str = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d
 * JD-Core Version:    0.7.0.1
 */