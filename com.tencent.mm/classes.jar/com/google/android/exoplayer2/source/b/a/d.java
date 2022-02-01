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
  private static final Pattern bzA;
  private static final Pattern bzB;
  private static final Pattern bzg;
  private static final Pattern bzh;
  private static final Pattern bzi;
  private static final Pattern bzj;
  private static final Pattern bzk;
  private static final Pattern bzl;
  private static final Pattern bzm;
  private static final Pattern bzn;
  private static final Pattern bzo;
  private static final Pattern bzp;
  private static final Pattern bzq;
  private static final Pattern bzr;
  private static final Pattern bzs;
  private static final Pattern bzt;
  private static final Pattern bzu;
  private static final Pattern bzv;
  private static final Pattern bzw;
  private static final Pattern bzx;
  private static final Pattern bzy;
  private static final Pattern bzz;
  
  static
  {
    AppMethodBeat.i(62903);
    bzg = Pattern.compile("AVERAGE-BANDWIDTH=(\\d+)\\b");
    bzh = Pattern.compile("[^-]BANDWIDTH=(\\d+)\\b");
    bzi = Pattern.compile("CODECS=\"(.+?)\"");
    bzj = Pattern.compile("RESOLUTION=(\\d+x\\d+)");
    bzk = Pattern.compile("#EXT-X-TARGETDURATION:(\\d+)\\b");
    bzl = Pattern.compile("#EXT-X-VERSION:(\\d+)\\b");
    bzm = Pattern.compile("#EXT-X-PLAYLIST-TYPE:(.+)\\b");
    bzn = Pattern.compile("#EXT-X-MEDIA-SEQUENCE:(\\d+)\\b");
    bzo = Pattern.compile("#EXTINF:([\\d\\.]+)\\b");
    bzp = Pattern.compile("TIME-OFFSET=(-?[\\d\\.]+)\\b");
    bzq = Pattern.compile("#EXT-X-BYTERANGE:(\\d+(?:@\\d+)?)\\b");
    bzr = Pattern.compile("BYTERANGE=\"(\\d+(?:@\\d+)?)\\b\"");
    bzs = Pattern.compile("METHOD=(NONE|AES-128)");
    bzt = Pattern.compile("URI=\"(.+?)\"");
    bzu = Pattern.compile("IV=([^,.*]+)");
    bzv = Pattern.compile("TYPE=(AUDIO|VIDEO|SUBTITLES|CLOSED-CAPTIONS)");
    bzw = Pattern.compile("LANGUAGE=\"(.+?)\"");
    bzx = Pattern.compile("NAME=\"(.+?)\"");
    bzy = Pattern.compile("INSTREAM-ID=\"((?:CC|SERVICE)\\d+)\"");
    bzz = bj("AUTOSELECT");
    bzA = bj("DEFAULT");
    bzB = bj("FORCED");
    AppMethodBeat.o(62903);
  }
  
  private static int a(BufferedReader paramBufferedReader, boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(62893);
    while ((paramInt != -1) && (Character.isWhitespace(paramInt)) && ((paramBoolean) || (!x.fe(paramInt)))) {
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
        if (e((String)localObject3, bzA))
        {
          i = 1;
          if (!e((String)localObject3, bzB)) {
            break label301;
          }
          k = 2;
          if (!e((String)localObject3, bzz)) {
            break label307;
          }
          m = 4;
          k = k | i | m;
          localObject4 = c((String)localObject3, bzt);
          str1 = d((String)localObject3, bzx);
          str2 = c((String)localObject3, bzw);
          str3 = d((String)localObject3, bzv);
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
        localObject4 = d((String)localObject3, bzy);
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
        k = a((String)localObject3, bzh);
        localObject4 = c((String)localObject3, bzg);
        if (localObject4 != null) {
          k = Integer.parseInt((String)localObject4);
        }
        localObject4 = c((String)localObject3, bzi);
        str1 = c((String)localObject3, bzj);
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
    AppMethodBeat.o(62894);
    return parama;
  }
  
  private static c a(Uri paramUri, InputStream paramInputStream)
  {
    AppMethodBeat.i(62891);
    paramInputStream = new BufferedReader(new InputStreamReader(paramInputStream));
    LinkedList localLinkedList = new LinkedList();
    try
    {
      if (!a(paramInputStream))
      {
        com.google.android.exoplayer2.d.b.e("ExoPlayer", "parse, not the #EXTM3U header, uri:%s, reader:%s", new Object[] { paramUri.toString(), paramInputStream.readLine() });
        paramUri = new q("Input does not start with the #EXTM3U header.", paramUri);
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
    boolean bool = x.fe(a(paramBufferedReader, false, j));
    AppMethodBeat.o(62892);
    return bool;
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
      localObject1 = d(str3, bzm);
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
        l4 = (b(str3, bzp) * 1000000.0D);
        l3 = l8;
        break;
      }
      if (str3.startsWith("#EXT-X-MAP"))
      {
        localObject1 = d(str3, bzt);
        localObject2 = c(str3, bzr);
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
          l5 = a(str3, bzk) * 1000000L;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-MEDIA-SEQUENCE"))
        {
          n = a(str3, bzn);
          j = n;
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXT-X-VERSION"))
        {
          k = a(str3, bzl);
          l3 = l8;
          break;
        }
        if (str3.startsWith("#EXTINF"))
        {
          l3 = (b(str3, bzo) * 1000000.0D);
          break;
        }
        if (str3.startsWith("#EXT-X-KEY"))
        {
          bool4 = "AES-128".equals(d(str3, bzs));
          if (bool4)
          {
            str2 = d(str3, bzt);
            str1 = c(str3, bzu);
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
          localObject1 = d(str3, bzq).split("@");
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
            l6 = com.google.android.exoplayer2.b.w(x.bI(str3.substring(str3.indexOf(':') + 1))) - l7;
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
  
  private static Pattern bj(String paramString)
  {
    AppMethodBeat.i(62901);
    paramString = Pattern.compile(paramString + "=(NO|YES)");
    AppMethodBeat.o(62901);
    return paramString;
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
    private final BufferedReader bzC;
    private final Queue<String> bzD;
    private String bzE;
    
    public a(Queue<String> paramQueue, BufferedReader paramBufferedReader)
    {
      this.bzD = paramQueue;
      this.bzC = paramBufferedReader;
    }
    
    public final boolean hasNext()
    {
      AppMethodBeat.i(62889);
      if (this.bzE != null)
      {
        AppMethodBeat.o(62889);
        return true;
      }
      if (!this.bzD.isEmpty())
      {
        this.bzE = ((String)this.bzD.poll());
        AppMethodBeat.o(62889);
        return true;
      }
      do
      {
        String str = this.bzC.readLine();
        this.bzE = str;
        if (str == null) {
          break;
        }
        this.bzE = this.bzE.trim();
      } while (this.bzE.isEmpty());
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
        str = this.bzE;
        this.bzE = null;
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