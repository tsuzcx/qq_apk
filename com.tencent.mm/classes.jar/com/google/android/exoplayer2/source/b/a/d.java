package com.google.android.exoplayer2.source.b.a;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.h.s.a;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.o;
import com.google.android.exoplayer2.source.n;
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
  implements s.a<c>
{
  private static final Pattern aLA = Pattern.compile("METHOD=(NONE|AES-128)");
  private static final Pattern aLB = Pattern.compile("URI=\"(.+?)\"");
  private static final Pattern aLC = Pattern.compile("IV=([^,.*]+)");
  private static final Pattern aLD = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
  private static final Pattern aLE = Pattern.compile("LANGUAGE=\"(.+?)\"");
  private static final Pattern aLF = Pattern.compile("NAME=\"(.+?)\"");
  private static final Pattern aLG = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
  private static final Pattern aLH = an("AUTOSELECT");
  private static final Pattern aLI = an("DEFAULT");
  private static final Pattern aLJ = an("FORCED");
  private static final Pattern aLo = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
  private static final Pattern aLp = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
  private static final Pattern aLq = Pattern.compile("CODECS=\"(.+?)\"");
  private static final Pattern aLr = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
  private static final Pattern aLs = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
  private static final Pattern aLt = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
  private static final Pattern aLu = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
  private static final Pattern aLv = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
  private static final Pattern aLw = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
  private static final Pattern aLx = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
  private static final Pattern aLy = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
  private static final Pattern aLz = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
  
  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!t.dE(paramInt)))) {
      paramInt = paramBufferedReader.read();
    }
    return paramInt;
  }
  
  private static a a(d.a parama, String paramString)
  {
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
      label118:
      int k;
      label132:
      int m;
      label146:
      Object localObject4;
      String str1;
      if (((String)localObject3).startsWith("#EXT-X-MEDIA"))
      {
        String str2;
        String str3;
        if (f((String)localObject3, aLI))
        {
          i = 1;
          if (!f((String)localObject3, aLJ)) {
            break label297;
          }
          k = 2;
          if (!f((String)localObject3, aLH)) {
            break label303;
          }
          m = 4;
          k = k | i | m;
          localObject4 = d((String)localObject3, aLB);
          str1 = e((String)localObject3, aLF);
          str2 = d((String)localObject3, aLE);
          str3 = e((String)localObject3, aLD);
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
            localObject3 = Format.b(str1, "application/x-mpegURL", k, str2);
            if (localObject4 != null) {
              break label354;
            }
            localObject2 = localObject3;
            break;
            i = 0;
            break label118;
            label297:
            k = 0;
            break label132;
            label303:
            m = 0;
            break label146;
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
        label354:
        localArrayList2.add(new a.a((String)localObject4, (Format)localObject3));
        continue;
        localArrayList3.add(new a.a((String)localObject4, Format.a(str1, "application/x-mpegURL", "text/vtt", k, str2)));
        continue;
        localObject4 = e((String)localObject3, aLG);
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
        k = b((String)localObject3, aLp);
        localObject4 = d((String)localObject3, aLo);
        if (localObject4 != null) {
          k = Integer.parseInt((String)localObject4);
        }
        localObject4 = d((String)localObject3, aLq);
        str1 = d((String)localObject3, aLr);
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
    return new a(paramString, localArrayList4, localArrayList1, localArrayList2, localArrayList3, localObject2, (List)localObject1);
  }
  
  private static c a(Uri paramUri, InputStream paramInputStream)
  {
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (!a(paramInputStream))
      {
        com.google.android.exoplayer2.d.b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[] { paramUri.toString(), paramInputStream.readLine() });
        throw new n("Input does not start with the #EXTM3U header.", paramUri);
      }
    }
    finally
    {
      t.closeQuietly(paramInputStream);
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
        t.closeQuietly(paramInputStream);
        return paramUri;
      }
    } while ((!((String)localObject).startsWith("#EXT-X-TARGETDURATION")) && (!((String)localObject).startsWith("#EXT-X-MEDIA-SEQUENCE")) && (!((String)localObject).startsWith("#EXTINF")) && (!((String)localObject).startsWith("#EXT-X-KEY")) && (!((String)localObject).startsWith("#EXT-X-BYTERANGE")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY")) && (!((String)localObject).equals("#EXT-X-DISCONTINUITY-SEQUENCE")) && (!((String)localObject).equals("#EXT-X-ENDLIST")));
    localLinkedList.add(localObject);
    paramUri = b(new d.a(localLinkedList, paramInputStream), paramUri.toString());
    t.closeQuietly(paramInputStream);
    return paramUri;
    t.closeQuietly(paramInputStream);
    throw new o("Failed to parse the playlist, could not identify any tags.");
  }
  
  private static boolean a(BufferedReader paramBufferedReader)
  {
    int j = paramBufferedReader.read();
    int i = j;
    if (j == 239)
    {
      if ((paramBufferedReader.read() != 187) || (paramBufferedReader.read() != 191)) {
        return false;
      }
      i = paramBufferedReader.read();
    }
    j = a(paramBufferedReader, true, i);
    i = 0;
    while (i < 7)
    {
      if (j != "#EXTM3U".charAt(i)) {
        return false;
      }
      j = paramBufferedReader.read();
      i += 1;
    }
    return t.dE(a(paramBufferedReader, false, j));
  }
  
  private static Pattern an(String paramString)
  {
    return Pattern.compile(paramString + "=(NO|YES)");
  }
  
  private static int b(String paramString, Pattern paramPattern)
  {
    return Integer.parseInt(e(paramString, paramPattern));
  }
  
  private static b b(d.a parama, String paramString)
  {
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
        break label873;
      }
      str3 = parama.next();
      com.google.android.exoplayer2.d.b.i("ExoPlayer", str3, new Object[0]);
      if (str3.startsWith("#EXT")) {
        localArrayList2.add(str3);
      }
      if (!str3.startsWith("#EXT-X-PLAYLIST-TYPE")) {
        break label192;
      }
      localObject1 = e(str3, aLu);
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
      label192:
      if (str3.startsWith("#EXT-X-START"))
      {
        l4 = (c(str3, aLx) * 1000000.0D);
        l3 = l8;
        break;
      }
      if (str3.startsWith("#EXT-X-MAP"))
      {
        localObject1 = e(str3, aLB);
        localObject2 = d(str3, aLz);
        if (localObject2 == null) {
          break label934;
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
      label928:
      label931:
      label934:
      for (;;)
      {
        localObject2 = new b.a((String)localObject1, l1, l2);
        l1 = 0L;
        l2 = -1L;
        l3 = l8;
        break;
        if (str3.startsWith("#EXT-X-TARGETDURATION"))
        {
          l5 = b(str3, aLs) * 1000000L;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          n = b(str3, aLv);
          j = n;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-VERSION"))
        {
          k = b(str3, aLt);
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXTINF"))
        {
          l3 = (c(str3, aLw) * 1000000.0D);
          break;
        }
        if (str3.startsWith("#EXT-X-KEY"))
        {
          bool4 = "AES-128".equals(e(str3, aLA));
          if (bool4)
          {
            str2 = e(str3, aLB);
            str1 = d(str3, aLC);
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
          localObject1 = e(str3, aLy).split("@");
          l2 = Long.parseLong(localObject1[0]);
          if (localObject1.length <= 1) {
            break label931;
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
            l6 = com.google.android.exoplayer2.b.r(t.aF(str3.substring(str3.indexOf(':') + 1))) - l7;
            l3 = l8;
            break;
          }
          if (!str3.startsWith("#")) {
            if (!bool4)
            {
              localObject1 = null;
              label723:
              if (l2 != -1L) {
                break label928;
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
                break label723;
              }
              localObject1 = Integer.toHexString(j);
              break label723;
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
              label873:
              if (l6 != 0L) {}
              for (bool4 = true;; bool4 = false) {
                return new b(i, paramString, localArrayList2, l4, l6, bool1, m, n, k, l5, bool3, bool2, bool4, (b.a)localObject2, localArrayList1);
              }
            }
          }
        }
      }
    }
  }
  
  private static double c(String paramString, Pattern paramPattern)
  {
    return Double.parseDouble(e(paramString, paramPattern));
  }
  
  private static String d(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1);
    }
    return null;
  }
  
  private static String e(String paramString, Pattern paramPattern)
  {
    Matcher localMatcher = paramPattern.matcher(paramString);
    if ((localMatcher.find()) && (localMatcher.groupCount() == 1)) {
      return localMatcher.group(1);
    }
    throw new o("Couldn't match " + paramPattern.pattern() + " in " + paramString);
  }
  
  private static boolean f(String paramString, Pattern paramPattern)
  {
    paramString = paramPattern.matcher(paramString);
    if (paramString.find()) {
      return paramString.group(1).equals("YES");
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.google.android.exoplayer2.source.b.a.d
 * JD-Core Version:    0.7.0.1
 */