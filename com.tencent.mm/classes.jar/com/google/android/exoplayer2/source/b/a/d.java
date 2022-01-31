package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.u.a;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.q;
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
  implements u.a<c>
{
  private static final Pattern aSI;
  private static final Pattern aSJ;
  private static final Pattern aSK;
  private static final Pattern aSL;
  private static final Pattern aSM;
  private static final Pattern aSN;
  private static final Pattern aSO;
  private static final Pattern aSP;
  private static final Pattern aSQ;
  private static final Pattern aSR;
  private static final Pattern aSS;
  private static final Pattern aST;
  private static final Pattern aSU;
  private static final Pattern aSV;
  private static final Pattern aSW;
  private static final Pattern aSX;
  private static final Pattern aSY;
  private static final Pattern aSZ;
  private static final Pattern aTa;
  private static final Pattern aTb;
  private static final Pattern aTc;
  private static final Pattern aTd;
  
  static
  {
    AppMethodBeat.i(125979);
    aSI = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    aSJ = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    aSK = Pattern.compile("CODECS=\"(.+?)\"");
    aSL = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    aSM = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    aSN = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    aSO = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    aSP = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    aSQ = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    aSR = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    aSS = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    aST = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    aSU = Pattern.compile("METHOD=(NONE|AES-128)");
    aSV = Pattern.compile("URI=\"(.+?)\"");
    aSW = Pattern.compile("IV=([^,.*]+)");
    aSX = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    aSY = Pattern.compile("LANGUAGE=\"(.+?)\"");
    aSZ = Pattern.compile("NAME=\"(.+?)\"");
    aTa = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    aTb = as("AUTOSELECT");
    aTc = as("DEFAULT");
    aTd = as("FORCED");
    AppMethodBeat.o(125979);
  }
  
  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(125969);
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!x.er(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    AppMethodBeat.o(125969);
    return paramInt;
  }
  
  private static int a(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(125972);
    int i = Integer.parseInt(d(paramString, paramPattern));
    AppMethodBeat.o(125972);
    return i;
  }
  
  private static a a(d.a parama, String paramString)
  {
    AppMethodBeat.i(125970);
    HashSet localHashSet = new HashSet();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    Object localObject2 = null;
    Object localObject1 = null;
    int j = 0;
    while (parama.hasNext())
    {
      Object localObject3 = parama.next();
      com.google.android.exoplayer2.d.b.i("master ExoPlayer", (String)localObject3, new Object[0]);
      if (((String)localObject3).startsWith("#EXT")) {
        localArrayList4.add(localObject3);
      }
      int i;
      label123:
      int k;
      label137:
      int m;
      label151:
      Object localObject4;
      String str1;
      if (((String)localObject3).startsWith("#EXT-X-MEDIA"))
      {
        String str2;
        String str3;
        if (e((String)localObject3, aTc))
        {
          i = 1;
          if (!e((String)localObject3, aTd)) {
            break label301;
          }
          k = 2;
          if (!e((String)localObject3, aTb)) {
            break label307;
          }
          m = 4;
          k = k | i | m;
          localObject4 = c((String)localObject3, aSV);
          str1 = d((String)localObject3, aSZ);
          str2 = c((String)localObject3, aSY);
          str3 = d((String)localObject3, aSX);
          i = -1;
          switch (str3.hashCode())
          {
          }
        }
        for (;;)
        {
          switch (i)
          {
          default: 
            break;
          case 0: 
            localObject3 = Format.a(str1, "application/x-mpegURL", k, str2);
            if (localObject4 != null) {
              break label358;
            }
            localObject2 = localObject3;
            break;
            i = 0;
            break label123;
            label301:
            k = 0;
            break label137;
            label307:
            m = 0;
            break label151;
            if (str3.equals("AUDIO"))
            {
              i = 0;
              continue;
              if (str3.equals("SUBTITLES"))
              {
                i = 1;
                continue;
                if (str3.equals("CLOSED-CAPTIONS")) {
                  i = 2;
                }
              }
            }
            break;
          }
        }
        label358:
        localArrayList2.add(new a.a((String)localObject4, (Format)localObject3));
        continue;
        localArrayList3.add(new a.a((String)localObject4, Format.a(str1, "application/x-mpegURL", "text/vtt", k, str2)));
        continue;
        localObject4 = d((String)localObject3, aTa);
        if (((String)localObject4).startsWith("CC")) {
          localObject3 = "application/cea-608";
        }
        for (i = Integer.parseInt(((String)localObject4).substring(2));; i = Integer.parseInt(((String)localObject4).substring(7)))
        {
          localObject4 = localObject1;
          if (localObject1 == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(Format.a(str1, null, (String)localObject3, k, str2, i));
          localObject1 = localObject4;
          break;
          localObject3 = "application/cea-708";
        }
      }
      else if (((String)localObject3).startsWith("#EXT-X-STREAM-INF"))
      {
        k = a((String)localObject3, aSJ);
        localObject4 = c((String)localObject3, aSI);
        if (localObject4 != null) {
          k = Integer.parseInt((String)localObject4);
        }
        localObject4 = c((String)localObject3, aSK);
        str1 = c((String)localObject3, aSL);
        int n = j | ((String)localObject3).contains("CLOSED-CAPTIONS=NONE");
        if (str1 != null)
        {
          localObject3 = str1.split("x");
          i = Integer.parseInt(localObject3[0]);
          m = Integer.parseInt(localObject3[1]);
          if (i > 0)
          {
            j = m;
            if (m > 0) {}
          }
          else
          {
            i = -1;
            j = -1;
          }
        }
        for (m = j;; m = -1)
        {
          localObject3 = parama.next();
          j = n;
          if (!localHashSet.add(localObject3)) {
            break;
          }
          localArrayList1.add(new a.a((String)localObject3, Format.a(Integer.toString(localArrayList1.size()), "application/x-mpegURL", (String)localObject4, k, i, m)));
          j = n;
          break;
          i = -1;
        }
      }
    }
    if (j != 0) {
      localObject1 = Collections.emptyList();
    }
    parama = new a(paramString, localArrayList4, localArrayList1, localArrayList2, localArrayList3, localObject2, (List)localObject1);
    AppMethodBeat.o(125970);
    return parama;
  }
  
  private static c a(Uri paramUri, InputStream paramInputStream)
  {
    AppMethodBeat.i(125967);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (!a(paramInputStream))
      {
        com.google.android.exoplayer2.d.b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[] { paramUri.toString(), paramInputStream.readLine() });
        paramUri = new q("Input does not start with the #EXTM3U header.", paramUri);
        AppMethodBeat.o(125967);
        throw paramUri;
      }
    }
    finally
    {
      x.closeQuietly(paramInputStream);
      AppMethodBeat.o(125967);
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
        paramUri = a(new d.a(localLinkedList, paramInputStream), paramUri.toString());
        x.closeQuietly(paramInputStream);
        AppMethodBeat.o(125967);
        return paramUri;
      }
    } while ((!((String)localObject).startsWith("#EXT-X-TARGETDURATION")) && (!((String)localObject).startsWith("#EXT-X-MEDIA-SEQUENCE")) && (!((String)localObject).startsWith("#EXTINF")) && (!((String)localObject).startsWith("#EXT-X-KEY")) && (!((String)localObject).startsWith("#EXT-X-BYTERANGE")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY-SEQUENCE")) && (!((String)localObject).equals("#EXT-X-ENDLIST")));
    localLinkedList.add(localObject);
    paramUri = b(new d.a(localLinkedList, paramInputStream), paramUri.toString());
    x.closeQuietly(paramInputStream);
    AppMethodBeat.o(125967);
    return paramUri;
    x.closeQuietly(paramInputStream);
    paramUri = new o("Failed to parse the playlist, could not identify any tags.");
    AppMethodBeat.o(125967);
    throw paramUri;
  }
  
  private static boolean a(BufferedReader paramBufferedReader)
  {
    AppMethodBeat.i(125968);
    int j = paramBufferedReader.read();
    int i = j;
    if (j == 239)
    {
      if ((paramBufferedReader.read() != 187) || (paramBufferedReader.read() != 191))
      {
        AppMethodBeat.o(125968);
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
        AppMethodBeat.o(125968);
        return false;
      }
      j = paramBufferedReader.read();
      i += 1;
    }
    boolean bool = x.er(a(paramBufferedReader, false, j));
    AppMethodBeat.o(125968);
    return bool;
  }
  
  private static Pattern as(String paramString)
  {
    AppMethodBeat.i(125977);
    paramString = Pattern.compile(paramString + "=(NO|YES)");
    AppMethodBeat.o(125977);
    return paramString;
  }
  
  private static double b(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(125973);
    double d = Double.parseDouble(d(paramString, paramPattern));
    AppMethodBeat.o(125973);
    return d;
  }
  
  private static b b(d.a parama, String paramString)
  {
    AppMethodBeat.i(125971);
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
      localObject1 = d(str3, aSO);
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
        l4 = (b(str3, aSR) * 1000000.0D);
        l3 = l8;
        break;
      }
      if (str3.startsWith("#EXT-X-MAP"))
      {
        localObject1 = d(str3, aSV);
        localObject2 = c(str3, aST);
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
          l5 = a(str3, aSM) * 1000000L;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          n = a(str3, aSP);
          j = n;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-VERSION"))
        {
          k = a(str3, aSN);
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXTINF"))
        {
          l3 = (b(str3, aSQ) * 1000000.0D);
          break;
        }
        if (str3.startsWith("#EXT-X-KEY"))
        {
          bool4 = "AES-128".equals(d(str3, aSU));
          if (bool4)
          {
            str2 = d(str3, aSV);
            str1 = c(str3, aSW);
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
          localObject1 = d(str3, aSS).split("@");
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
            l6 = com.google.android.exoplayer2.b.p(x.aR(str3.substring(str3.indexOf(':') + 1))) - l7;
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
                AppMethodBeat.o(125971);
                return parama;
              }
            }
          }
        }
      }
    }
  }
  
  private static String c(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(125974);
    paramString = paramPattern.matcher(paramString);
    if (paramString.find())
    {
      paramString = paramString.group(1);
      AppMethodBeat.o(125974);
      return paramString;
    }
    AppMethodBeat.o(125974);
    return null;
  }
  
  private static String d(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(125975);
    Matcher localMatcher = paramPattern.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.groupCount() == 1))
    {
      paramString = localMatcher.group(1);
      AppMethodBeat.o(125975);
      return paramString;
    }
    paramString = new o("Couldn't match " + paramPattern.pattern() + " in " + paramString);
    AppMethodBeat.o(125975);
    throw paramString;
  }
  
  private static boolean e(String paramString, Pattern paramPattern)
  {
    AppMethodBeat.i(125976);
    paramString = paramPattern.matcher(paramString);
    if (paramString.find())
    {
      boolean bool = paramString.group(1).equals("YES");
      AppMethodBeat.o(125976);
      return bool;
    }
    AppMethodBeat.o(125976);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d
 * JD-Core Version:    0.7.0.1
 */