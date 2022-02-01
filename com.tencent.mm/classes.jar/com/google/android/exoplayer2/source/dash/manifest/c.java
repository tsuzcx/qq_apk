package com.google.android.exoplayer2.source.dash.manifest;

import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmInitData.SchemeData;
import com.google.android.exoplayer2.h.v.a;
import com.google.android.exoplayer2.i.w;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.i.y;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xml.sax.helpers.DefaultHandler;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class c
  extends DefaultHandler
  implements v.a<b>
{
  private static final Pattern bnW;
  private static final Pattern bnX;
  private static final Pattern bnY;
  private final String bnZ;
  private final XmlPullParserFactory boa;
  
  static
  {
    AppMethodBeat.i(10550);
    bnW = Pattern.compile("(\\d+)(?:/(\\d+))?");
    bnX = Pattern.compile("CC([1-4])=.*");
    bnY = Pattern.compile("([1-9]|[1-5][0-9]|6[0-3])=.*");
    AppMethodBeat.o(10550);
  }
  
  public c()
  {
    this((byte)0);
  }
  
  private c(byte paramByte)
  {
    AppMethodBeat.i(10520);
    this.bnZ = null;
    try
    {
      this.boa = XmlPullParserFactory.newInstance();
      AppMethodBeat.o(10520);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
      AppMethodBeat.o(10520);
      throw localRuntimeException;
    }
  }
  
  private static float a(XmlPullParser paramXmlPullParser, float paramFloat)
  {
    AppMethodBeat.i(10543);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "frameRate");
    float f = paramFloat;
    int i;
    if (paramXmlPullParser != null)
    {
      paramXmlPullParser = bnW.matcher(paramXmlPullParser);
      f = paramFloat;
      if (paramXmlPullParser.matches())
      {
        i = Integer.parseInt(paramXmlPullParser.group(1));
        paramXmlPullParser = paramXmlPullParser.group(2);
        if (TextUtils.isEmpty(paramXmlPullParser)) {
          break label78;
        }
      }
    }
    label78:
    for (f = i / Integer.parseInt(paramXmlPullParser);; f = i)
    {
      AppMethodBeat.o(10543);
      return f;
    }
  }
  
  private static int a(XmlPullParser paramXmlPullParser, String paramString, int paramInt)
  {
    AppMethodBeat.i(10546);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(10546);
      return paramInt;
    }
    paramInt = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(10546);
    return paramInt;
  }
  
  private Pair<e, Long> a(XmlPullParser paramXmlPullParser, String paramString, long paramLong)
  {
    AppMethodBeat.i(10522);
    String str2 = paramXmlPullParser.getAttributeValue(null, "id");
    paramLong = b(paramXmlPullParser, "start", paramLong);
    long l = b(paramXmlPullParser, "duration", -9223372036854775807L);
    String str1 = null;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    Object localObject1 = paramString;
    paramXmlPullParser.next();
    int j;
    Object localObject2;
    if (y.i(paramXmlPullParser, "BaseURL"))
    {
      j = i;
      paramString = str1;
      localObject2 = localObject1;
      if (i == 0)
      {
        localObject2 = c(paramXmlPullParser, (String)localObject1);
        j = 1;
        paramString = str1;
      }
    }
    for (;;)
    {
      i = j;
      str1 = paramString;
      localObject1 = localObject2;
      if (!y.h(paramXmlPullParser, "Period")) {
        break;
      }
      paramXmlPullParser = Pair.create(new e(str2, paramLong, localArrayList), Long.valueOf(l));
      AppMethodBeat.o(10522);
      return paramXmlPullParser;
      if (y.i(paramXmlPullParser, "AdaptationSet"))
      {
        localArrayList.add(a(paramXmlPullParser, (String)localObject1, str1));
        j = i;
        paramString = str1;
        localObject2 = localObject1;
      }
      else if (y.i(paramXmlPullParser, "SegmentBase"))
      {
        paramString = a(paramXmlPullParser, null);
        j = i;
        localObject2 = localObject1;
      }
      else if (y.i(paramXmlPullParser, "SegmentList"))
      {
        paramString = a(paramXmlPullParser, null);
        j = i;
        localObject2 = localObject1;
      }
      else
      {
        j = i;
        paramString = str1;
        localObject2 = localObject1;
        if (y.i(paramXmlPullParser, "SegmentTemplate"))
        {
          paramString = a(paramXmlPullParser, null);
          j = i;
          localObject2 = localObject1;
        }
      }
    }
  }
  
  private a a(XmlPullParser paramXmlPullParser, String paramString, h paramh)
  {
    AppMethodBeat.i(10523);
    int i1 = a(paramXmlPullParser, "id", -1);
    int n = b(paramXmlPullParser);
    String str2 = paramXmlPullParser.getAttributeValue(null, "mimeType");
    String str3 = paramXmlPullParser.getAttributeValue(null, "codecs");
    int i2 = a(paramXmlPullParser, "width", -1);
    int i3 = a(paramXmlPullParser, "height", -1);
    float f = a(paramXmlPullParser, -1.0F);
    int m = -1;
    int i4 = a(paramXmlPullParser, "audioSamplingRate", -1);
    String str1 = paramXmlPullParser.getAttributeValue(null, "lang");
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    ArrayList localArrayList3 = new ArrayList();
    ArrayList localArrayList4 = new ArrayList();
    ArrayList localArrayList5 = new ArrayList();
    int k = 0;
    int i = 0;
    Object localObject1 = paramh;
    paramh = str1;
    str1 = paramString;
    for (;;)
    {
      paramXmlPullParser.next();
      int j;
      label218:
      Object localObject2;
      if (y.i(paramXmlPullParser, "BaseURL"))
      {
        if (i != 0) {
          break label831;
        }
        str1 = c(paramXmlPullParser, str1);
        i = 1;
        j = n;
        paramString = (String)localObject1;
        if (!y.h(paramXmlPullParser, "AdaptationSet")) {
          break label915;
        }
        paramh = new ArrayList(localArrayList5.size());
        i = 0;
        if (i >= localArrayList5.size()) {
          break label890;
        }
        localObject1 = (a)localArrayList5.get(i);
        str1 = this.bnZ;
        paramString = ((a)localObject1).aSv;
        localObject2 = ((a)localObject1).bod;
        ((ArrayList)localObject2).addAll(localArrayList1);
        paramXmlPullParser = paramString;
        if (!((ArrayList)localObject2).isEmpty()) {
          paramXmlPullParser = paramString.a(new DrmInitData((List)localObject2));
        }
        paramString = ((a)localObject1).boe;
        paramString.addAll(localArrayList2);
        localObject2 = ((a)localObject1).bob;
        localObject1 = ((a)localObject1).boc;
        if (!(localObject1 instanceof h.e)) {
          break label841;
        }
      }
      for (paramXmlPullParser = new g.b(str1, paramXmlPullParser, (String)localObject2, (h.e)localObject1, paramString);; paramXmlPullParser = new g.a(str1, paramXmlPullParser, (String)localObject2, (h.a)localObject1, paramString))
      {
        paramh.add(paramXmlPullParser);
        i += 1;
        break label218;
        if (y.i(paramXmlPullParser, "ContentProtection"))
        {
          paramString = c(paramXmlPullParser);
          if (paramString != null) {
            localArrayList1.add(paramString);
          }
          paramString = (String)localObject1;
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "ContentComponent"))
        {
          localObject2 = paramXmlPullParser.getAttributeValue(null, "lang");
          if (paramh == null) {
            paramString = (String)localObject2;
          }
          for (;;)
          {
            j = bj(n, b(paramXmlPullParser));
            paramh = paramString;
            paramString = (String)localObject1;
            break;
            paramString = paramh;
            if (localObject2 != null)
            {
              com.google.android.exoplayer2.i.a.checkState(paramh.equals(localObject2));
              paramString = paramh;
            }
          }
        }
        if (y.i(paramXmlPullParser, "Role"))
        {
          k |= d(paramXmlPullParser);
          paramString = (String)localObject1;
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "AudioChannelConfiguration"))
        {
          m = g(paramXmlPullParser);
          paramString = (String)localObject1;
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "Accessibility"))
        {
          localArrayList3.add(b(paramXmlPullParser, "Accessibility"));
          paramString = (String)localObject1;
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "SupplementalProperty"))
        {
          localArrayList4.add(b(paramXmlPullParser, "SupplementalProperty"));
          paramString = (String)localObject1;
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "Representation"))
        {
          paramString = a(paramXmlPullParser, str1, str2, str3, i2, i3, f, m, i4, paramh, k, localArrayList3, (h)localObject1);
          localObject2 = paramString.aSv.aSd;
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            if (com.google.android.exoplayer2.i.j.aK((String)localObject2)) {
              j = 2;
            }
          }
          for (;;)
          {
            j = bj(n, j);
            localArrayList5.add(paramString);
            paramString = (String)localObject1;
            break;
            if (com.google.android.exoplayer2.i.j.aJ((String)localObject2)) {
              j = 1;
            } else if (ao((String)localObject2)) {
              j = 3;
            } else {
              j = -1;
            }
          }
        }
        if (y.i(paramXmlPullParser, "SegmentBase"))
        {
          paramString = a(paramXmlPullParser, (h.e)localObject1);
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "SegmentList"))
        {
          paramString = a(paramXmlPullParser, (h.b)localObject1);
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "SegmentTemplate"))
        {
          paramString = a(paramXmlPullParser, (h.c)localObject1);
          j = n;
          break;
        }
        if (y.i(paramXmlPullParser, "InbandEventStream"))
        {
          localArrayList2.add(b(paramXmlPullParser, "InbandEventStream"));
          paramString = (String)localObject1;
          j = n;
          break;
        }
        y.n(paramXmlPullParser);
        label831:
        paramString = (String)localObject1;
        j = n;
        break;
        label841:
        if (!(localObject1 instanceof h.a)) {
          break label871;
        }
      }
      label871:
      paramXmlPullParser = new IllegalArgumentException("segmentBase must be of type SingleSegmentBase or MultiSegmentBase");
      AppMethodBeat.o(10523);
      throw paramXmlPullParser;
      label890:
      paramXmlPullParser = new a(i1, j, paramh, localArrayList3, localArrayList4);
      AppMethodBeat.o(10523);
      return paramXmlPullParser;
      label915:
      localObject1 = paramString;
      n = j;
    }
  }
  
  private static a a(XmlPullParser paramXmlPullParser, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2, float paramFloat, int paramInt3, int paramInt4, String paramString4, int paramInt5, List<d> paramList, h paramh)
  {
    AppMethodBeat.i(10527);
    String str2 = paramXmlPullParser.getAttributeValue(null, "id");
    int i = a(paramXmlPullParser, "bandwidth", -1);
    String str1 = b(paramXmlPullParser, "mimeType", paramString2);
    String str3 = b(paramXmlPullParser, "codecs", paramString3);
    int j = a(paramXmlPullParser, "width", paramInt1);
    int k = a(paramXmlPullParser, "height", paramInt2);
    paramFloat = a(paramXmlPullParser, paramFloat);
    paramInt4 = a(paramXmlPullParser, "audioSamplingRate", paramInt4);
    paramString3 = new ArrayList();
    ArrayList localArrayList = new ArrayList();
    paramInt2 = 0;
    paramInt1 = paramInt3;
    paramString2 = paramString1;
    paramString1 = paramh;
    label515:
    label650:
    for (;;)
    {
      paramXmlPullParser.next();
      if (y.i(paramXmlPullParser, "BaseURL"))
      {
        if (paramInt2 != 0) {
          break label361;
        }
        paramString2 = c(paramXmlPullParser, paramString2);
        paramInt2 = 1;
        if (!y.h(paramXmlPullParser, "Representation")) {
          break label650;
        }
        if (!com.google.android.exoplayer2.i.j.aJ(str1)) {
          break label364;
        }
        paramXmlPullParser = com.google.android.exoplayer2.i.j.aN(str3);
        label166:
        if (paramXmlPullParser == null) {
          break label619;
        }
        if (!com.google.android.exoplayer2.i.j.aK(paramXmlPullParser)) {
          break label515;
        }
        paramXmlPullParser = Format.a(str2, str1, paramXmlPullParser, str3, i, j, k, paramFloat, null, paramInt5);
        label199:
        if (paramString1 == null) {
          break label639;
        }
      }
      for (;;)
      {
        paramXmlPullParser = new a(paramXmlPullParser, paramString2, paramString1, paramString3, localArrayList);
        AppMethodBeat.o(10527);
        return paramXmlPullParser;
        if (y.i(paramXmlPullParser, "AudioChannelConfiguration"))
        {
          paramInt1 = g(paramXmlPullParser);
          break;
        }
        if (y.i(paramXmlPullParser, "SegmentBase"))
        {
          paramString1 = a(paramXmlPullParser, (h.e)paramString1);
          break;
        }
        if (y.i(paramXmlPullParser, "SegmentList"))
        {
          paramString1 = a(paramXmlPullParser, (h.b)paramString1);
          break;
        }
        if (y.i(paramXmlPullParser, "SegmentTemplate"))
        {
          paramString1 = a(paramXmlPullParser, (h.c)paramString1);
          break;
        }
        if (y.i(paramXmlPullParser, "ContentProtection"))
        {
          paramh = c(paramXmlPullParser);
          if (paramh != null) {
            paramString3.add(paramh);
          }
          break;
        }
        if (y.i(paramXmlPullParser, "InbandEventStream")) {
          localArrayList.add(b(paramXmlPullParser, "InbandEventStream"));
        }
        label361:
        break;
        label364:
        if (com.google.android.exoplayer2.i.j.aK(str1))
        {
          paramXmlPullParser = com.google.android.exoplayer2.i.j.aM(str3);
          break label166;
        }
        if (ao(str1))
        {
          paramXmlPullParser = str1;
          break label166;
        }
        if ("application/mp4".equals(str1))
        {
          if ("stpp".equals(str3))
          {
            paramXmlPullParser = "application/ttml+xml";
            break label166;
          }
          if (!"wvtt".equals(str3)) {
            break label510;
          }
          paramXmlPullParser = "application/x-mp4-vtt";
          break label166;
        }
        if ("application/x-rawcc".equals(str1))
        {
          if (str3 != null)
          {
            if (str3.contains("cea708"))
            {
              paramXmlPullParser = "application/cea-708";
              break label166;
            }
            if ((str3.contains("eia608")) || (str3.contains("cea608")))
            {
              paramXmlPullParser = "application/cea-608";
              break label166;
            }
          }
          paramXmlPullParser = null;
          break label166;
        }
        label510:
        paramXmlPullParser = null;
        break label166;
        if (com.google.android.exoplayer2.i.j.aJ(paramXmlPullParser))
        {
          paramXmlPullParser = Format.a(str2, str1, paramXmlPullParser, str3, i, paramInt1, paramInt4, null, paramInt5, paramString4);
          break label199;
        }
        if (ao(paramXmlPullParser))
        {
          if ("application/cea-608".equals(paramXmlPullParser)) {
            paramInt1 = y(paramList);
          }
          for (;;)
          {
            paramXmlPullParser = Format.a(str2, str1, paramXmlPullParser, str3, i, paramInt5, paramString4, paramInt1);
            break;
            if ("application/cea-708".equals(paramXmlPullParser)) {
              paramInt1 = z(paramList);
            } else {
              paramInt1 = -1;
            }
          }
        }
        label619:
        paramXmlPullParser = Format.a(str2, str1, paramXmlPullParser, str3, i, paramInt5, paramString4);
        break label199;
        label639:
        paramString1 = new h.e();
      }
    }
  }
  
  private static f a(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10535);
    paramString1 = paramXmlPullParser.getAttributeValue(null, paramString1);
    long l2 = 0L;
    long l3 = -1L;
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString2);
    long l1 = l3;
    if (paramXmlPullParser != null)
    {
      paramXmlPullParser = paramXmlPullParser.split("-");
      long l4 = Long.parseLong(paramXmlPullParser[0]);
      l1 = l3;
      l2 = l4;
      if (paramXmlPullParser.length == 2)
      {
        l1 = Long.parseLong(paramXmlPullParser[1]) - l4 + 1L;
        l2 = l4;
      }
    }
    paramXmlPullParser = e(paramString1, l2, l1);
    AppMethodBeat.o(10535);
    return paramXmlPullParser;
  }
  
  private static h.b a(XmlPullParser paramXmlPullParser, h.b paramb)
  {
    AppMethodBeat.i(10529);
    long l1;
    long l2;
    label34:
    long l3;
    label53:
    int i;
    label70:
    Object localObject3;
    Object localObject2;
    if (paramb != null)
    {
      l1 = paramb.bdm;
      l2 = c(paramXmlPullParser, "timescale", l1);
      if (paramb == null) {
        break label182;
      }
      l1 = paramb.bor;
      l3 = c(paramXmlPullParser, "presentationTimeOffset", l1);
      if (paramb == null) {
        break label187;
      }
      l1 = paramb.duration;
      l1 = c(paramXmlPullParser, "duration", l1);
      if (paramb == null) {
        break label194;
      }
      i = paramb.bos;
      i = a(paramXmlPullParser, "startNumber", i);
      localObject3 = null;
      localObject2 = null;
    }
    Object localObject4;
    for (Object localObject1 = null;; localObject1 = localObject4)
    {
      paramXmlPullParser.next();
      if (y.i(paramXmlPullParser, "Initialization"))
      {
        localObject4 = f(paramXmlPullParser);
        localObject1 = localObject2;
        localObject2 = localObject4;
        label119:
        if (!y.h(paramXmlPullParser, "SegmentList")) {
          break label327;
        }
        if (paramb == null) {
          break label321;
        }
        if (localObject2 == null) {
          break label295;
        }
        paramXmlPullParser = localObject2;
        label140:
        if (localObject1 == null) {
          break label303;
        }
        label145:
        if (localObject3 == null) {
          break label312;
        }
      }
      for (;;)
      {
        paramXmlPullParser = new h.b(paramXmlPullParser, l2, l3, i, l1, (List)localObject1, (List)localObject3);
        AppMethodBeat.o(10529);
        return paramXmlPullParser;
        l1 = 1L;
        break;
        label182:
        l1 = 0L;
        break label34;
        label187:
        l1 = -9223372036854775807L;
        break label53;
        label194:
        i = 1;
        break label70;
        if (y.i(paramXmlPullParser, "SegmentTimeline"))
        {
          localObject4 = e(paramXmlPullParser);
          localObject2 = localObject1;
          localObject1 = localObject4;
          break label119;
        }
        localObject4 = localObject3;
        if (y.i(paramXmlPullParser, "SegmentURL"))
        {
          localObject4 = localObject3;
          if (localObject3 == null) {
            localObject4 = new ArrayList();
          }
          ((List)localObject4).add(a(paramXmlPullParser, "media", "mediaRange"));
        }
        Object localObject5 = localObject1;
        localObject3 = localObject4;
        localObject1 = localObject2;
        localObject2 = localObject5;
        break label119;
        label295:
        paramXmlPullParser = paramb.boq;
        break label140;
        label303:
        localObject1 = paramb.bot;
        break label145;
        label312:
        localObject3 = paramb.bou;
        continue;
        label321:
        paramXmlPullParser = localObject2;
      }
      label327:
      localObject4 = localObject2;
      localObject2 = localObject1;
    }
  }
  
  private static h.c a(XmlPullParser paramXmlPullParser, h.c paramc)
  {
    AppMethodBeat.i(10530);
    long l1;
    long l2;
    label34:
    long l3;
    label53:
    int i;
    label70:
    Object localObject1;
    label89:
    j localj1;
    label110:
    j localj2;
    Object localObject4;
    Object localObject3;
    Object localObject2;
    if (paramc != null)
    {
      l1 = paramc.bdm;
      l2 = c(paramXmlPullParser, "timescale", l1);
      if (paramc == null) {
        break label222;
      }
      l1 = paramc.bor;
      l3 = c(paramXmlPullParser, "presentationTimeOffset", l1);
      if (paramc == null) {
        break label227;
      }
      l1 = paramc.duration;
      l1 = c(paramXmlPullParser, "duration", l1);
      if (paramc == null) {
        break label234;
      }
      i = paramc.bos;
      i = a(paramXmlPullParser, "startNumber", i);
      if (paramc == null) {
        break label239;
      }
      localObject1 = paramc.bow;
      localj1 = a(paramXmlPullParser, "media", (j)localObject1);
      if (paramc == null) {
        break label245;
      }
      localObject1 = paramc.bov;
      localj2 = a(paramXmlPullParser, "initialization", (j)localObject1);
      localObject4 = null;
      localObject3 = null;
      label154:
      do
      {
        paramXmlPullParser.next();
        if (!y.i(paramXmlPullParser, "Initialization")) {
          break;
        }
        localObject2 = f(paramXmlPullParser);
        localObject1 = localObject4;
        localObject4 = localObject1;
        localObject3 = localObject2;
      } while (!y.h(paramXmlPullParser, "SegmentTemplate"));
      if (paramc == null) {
        break label300;
      }
      if (localObject2 == null) {
        break label282;
      }
      label180:
      if (localObject1 == null) {
        break label291;
      }
    }
    label185:
    for (paramXmlPullParser = (XmlPullParser)localObject1;; paramXmlPullParser = (XmlPullParser)localObject1)
    {
      paramXmlPullParser = new h.c((f)localObject2, l2, l3, i, l1, paramXmlPullParser, localj2, localj1);
      AppMethodBeat.o(10530);
      return paramXmlPullParser;
      l1 = 1L;
      break;
      label222:
      l1 = 0L;
      break label34;
      label227:
      l1 = -9223372036854775807L;
      break label53;
      label234:
      i = 1;
      break label70;
      label239:
      localObject1 = null;
      break label89;
      label245:
      localObject1 = null;
      break label110;
      localObject1 = localObject4;
      localObject2 = localObject3;
      if (!y.i(paramXmlPullParser, "SegmentTimeline")) {
        break label154;
      }
      localObject1 = e(paramXmlPullParser);
      localObject2 = localObject3;
      break label154;
      localObject2 = paramc.boq;
      break label180;
      localObject1 = paramc.bot;
      break label185;
    }
  }
  
  private static h.e a(XmlPullParser paramXmlPullParser, h.e parame)
  {
    long l2 = 0L;
    AppMethodBeat.i(10528);
    long l1;
    long l3;
    label37:
    long l4;
    if (parame != null)
    {
      l1 = parame.bdm;
      l3 = c(paramXmlPullParser, "timescale", l1);
      if (parame == null) {
        break label183;
      }
      l1 = parame.bor;
      l4 = c(paramXmlPullParser, "presentationTimeOffset", l1);
      if (parame == null) {
        break label188;
      }
      l1 = parame.box;
      label56:
      if (parame != null) {
        l2 = parame.boy;
      }
      Object localObject = paramXmlPullParser.getAttributeValue(null, "indexRange");
      if (localObject == null) {
        break label204;
      }
      localObject = ((String)localObject).split("-");
      l1 = Long.parseLong(localObject[0]);
      l2 = Long.parseLong(localObject[1]) - l1 + 1L;
    }
    label183:
    label188:
    label201:
    label204:
    for (;;)
    {
      if (parame != null)
      {
        parame = parame.boq;
        label123:
        paramXmlPullParser.next();
        if (!y.i(paramXmlPullParser, "Initialization")) {
          break label201;
        }
        parame = f(paramXmlPullParser);
      }
      for (;;)
      {
        if (y.h(paramXmlPullParser, "SegmentBase"))
        {
          paramXmlPullParser = new h.e(parame, l3, l4, l1, l2);
          AppMethodBeat.o(10528);
          return paramXmlPullParser;
          l1 = 1L;
          break;
          l1 = 0L;
          break label37;
          l1 = 0L;
          break label56;
          parame = null;
          break label123;
        }
        break label123;
      }
    }
  }
  
  private static j a(XmlPullParser paramXmlPullParser, String paramString, j paramj)
  {
    AppMethodBeat.i(10533);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null)
    {
      paramXmlPullParser = j.ar(paramXmlPullParser);
      AppMethodBeat.o(10533);
      return paramXmlPullParser;
    }
    AppMethodBeat.o(10533);
    return paramj;
  }
  
  private static boolean ao(String paramString)
  {
    AppMethodBeat.i(10538);
    if ((com.google.android.exoplayer2.i.j.aL(paramString)) || ("application/ttml+xml".equals(paramString)) || ("application/x-mp4-vtt".equals(paramString)) || ("application/cea-708".equals(paramString)) || ("application/cea-608".equals(paramString)))
    {
      AppMethodBeat.o(10538);
      return true;
    }
    AppMethodBeat.o(10538);
    return false;
  }
  
  private static int b(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(10524);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, "contentType");
    if (!TextUtils.isEmpty(paramXmlPullParser))
    {
      if ("audio".equals(paramXmlPullParser))
      {
        AppMethodBeat.o(10524);
        return 1;
      }
      if ("video".equals(paramXmlPullParser))
      {
        AppMethodBeat.o(10524);
        return 2;
      }
      if ("text".equals(paramXmlPullParser))
      {
        AppMethodBeat.o(10524);
        return 3;
      }
    }
    AppMethodBeat.o(10524);
    return -1;
  }
  
  private static long b(XmlPullParser paramXmlPullParser, String paramString, long paramLong)
  {
    AppMethodBeat.i(10544);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(10544);
      return paramLong;
    }
    paramLong = x.aW(paramXmlPullParser);
    AppMethodBeat.o(10544);
    return paramLong;
  }
  
  private b b(Uri paramUri, InputStream paramInputStream)
  {
    AppMethodBeat.i(10521);
    XmlPullParser localXmlPullParser;
    try
    {
      localXmlPullParser = this.boa.newPullParser();
      localXmlPullParser.setInput(paramInputStream, null);
      if ((localXmlPullParser.next() != 2) || (!"MPD".equals(localXmlPullParser.getName())))
      {
        paramUri = new o("inputStream does not contain a valid media presentation description");
        AppMethodBeat.o(10521);
        throw paramUri;
      }
    }
    catch (XmlPullParserException paramUri)
    {
      paramUri = new o(paramUri);
      AppMethodBeat.o(10521);
      throw paramUri;
    }
    String str = paramUri.toString();
    paramUri = localXmlPullParser.getAttributeValue(null, "availabilityStartTime");
    long l3;
    long l7;
    long l8;
    boolean bool;
    long l4;
    label188:
    long l5;
    label206:
    long l6;
    label224:
    ArrayList localArrayList;
    long l1;
    label248:
    long l2;
    int i;
    if (paramUri == null)
    {
      l3 = -9223372036854775807L;
      l7 = b(localXmlPullParser, "mediaPresentationDuration", -9223372036854775807L);
      l8 = b(localXmlPullParser, "minBufferTime", -9223372036854775807L);
      paramUri = localXmlPullParser.getAttributeValue(null, "type");
      if ((paramUri == null) || (!paramUri.equals("dynamic"))) {
        break label659;
      }
      bool = true;
      if (!bool) {
        break label665;
      }
      l4 = b(localXmlPullParser, "minimumUpdatePeriod", -9223372036854775807L);
      if (!bool) {
        break label673;
      }
      l5 = b(localXmlPullParser, "timeShiftBufferDepth", -9223372036854775807L);
      if (!bool) {
        break label681;
      }
      l6 = b(localXmlPullParser, "suggestedPresentationDelay", -9223372036854775807L);
      paramUri = null;
      localArrayList = new ArrayList();
      if (!bool) {
        break label689;
      }
      l1 = -9223372036854775807L;
      break label649;
      localXmlPullParser.next();
      if (!y.i(localXmlPullParser, "BaseURL")) {
        break label352;
      }
      l2 = l1;
      if (i != 0) {
        break label695;
      }
      str = c(localXmlPullParser, str);
      i = 1;
    }
    for (;;)
    {
      label285:
      label352:
      int j;
      if (y.h(localXmlPullParser, "MPD"))
      {
        if (l7 == -9223372036854775807L) {
          if (l1 == -9223372036854775807L) {}
        }
        for (;;)
        {
          if (localArrayList.isEmpty())
          {
            paramUri = new o("No periods found.");
            AppMethodBeat.o(10521);
            throw paramUri;
            l3 = x.aX(paramUri);
            break;
            if (y.i(localXmlPullParser, "UTCTiming"))
            {
              paramUri = new k(localXmlPullParser.getAttributeValue(null, "schemeIdUri"), localXmlPullParser.getAttributeValue(null, "value"));
              break label285;
            }
            if (y.i(localXmlPullParser, "Location"))
            {
              paramInputStream = Uri.parse(localXmlPullParser.nextText());
              break label285;
            }
            l2 = l1;
            if (!y.i(localXmlPullParser, "Period")) {
              break label695;
            }
            l2 = l1;
            if (j != 0) {
              break label695;
            }
            Pair localPair = a(localXmlPullParser, str, l1);
            e locale = (e)localPair.first;
            if (locale.bof == -9223372036854775807L)
            {
              if (bool)
              {
                j = 1;
                break label285;
              }
              paramUri = new o("Unable to determine start of period " + localArrayList.size());
              AppMethodBeat.o(10521);
              throw paramUri;
            }
            l1 = ((Long)localPair.second).longValue();
            if (l1 == -9223372036854775807L) {}
            for (l2 = -9223372036854775807L;; l2 = l1 + locale.bof)
            {
              localArrayList.add(locale);
              break;
            }
            if (bool) {
              break label639;
            }
            paramUri = new o("Unable to determine duration of static manifest.");
            AppMethodBeat.o(10521);
            throw paramUri;
          }
          paramUri = new b(l3, l1, l8, bool, l4, l5, l6, paramUri, paramInputStream, localArrayList);
          AppMethodBeat.o(10521);
          return paramUri;
          label639:
          l1 = l7;
        }
      }
      break label248;
      for (;;)
      {
        label649:
        i = 0;
        j = 0;
        paramInputStream = null;
        break label248;
        label659:
        bool = false;
        break;
        label665:
        l4 = -9223372036854775807L;
        break label188;
        label673:
        l5 = -9223372036854775807L;
        break label206;
        label681:
        l6 = -9223372036854775807L;
        break label224;
        label689:
        l1 = 0L;
      }
      label695:
      l1 = l2;
    }
  }
  
  private static d b(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(10540);
    String str1 = b(paramXmlPullParser, "schemeIdUri", "");
    String str2 = b(paramXmlPullParser, "value", null);
    String str3 = b(paramXmlPullParser, "id", null);
    do
    {
      paramXmlPullParser.next();
    } while (!y.h(paramXmlPullParser, paramString));
    paramXmlPullParser = new d(str1, str2, str3);
    AppMethodBeat.o(10540);
    return paramXmlPullParser;
  }
  
  private static String b(XmlPullParser paramXmlPullParser, String paramString1, String paramString2)
  {
    AppMethodBeat.i(10548);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString1);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(10548);
      return paramString2;
    }
    AppMethodBeat.o(10548);
    return paramXmlPullParser;
  }
  
  private static int bj(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(10539);
    if (paramInt1 == -1)
    {
      AppMethodBeat.o(10539);
      return paramInt2;
    }
    if (paramInt2 == -1)
    {
      AppMethodBeat.o(10539);
      return paramInt1;
    }
    if (paramInt1 == paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      com.google.android.exoplayer2.i.a.checkState(bool);
      AppMethodBeat.o(10539);
      return paramInt1;
    }
  }
  
  private static long c(XmlPullParser paramXmlPullParser, String paramString, long paramLong)
  {
    AppMethodBeat.i(10547);
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(10547);
      return paramLong;
    }
    paramLong = Long.parseLong(paramXmlPullParser);
    AppMethodBeat.o(10547);
    return paramLong;
  }
  
  private static DrmInitData.SchemeData c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(10525);
    boolean bool3 = "urn:uuid:9a04f079-9840-4286-ab92-e65be0885f95".equals(paramXmlPullParser.getAttributeValue(null, "schemeIdUri"));
    String str = paramXmlPullParser.getAttributeValue(null, "value");
    boolean bool2 = false;
    Object localObject4 = null;
    Object localObject3 = null;
    paramXmlPullParser.next();
    Object localObject1;
    Object localObject2;
    boolean bool1;
    if ((localObject3 == null) && (y.i(paramXmlPullParser, "cenc:pssh")) && (paramXmlPullParser.next() == 4))
    {
      localObject1 = Base64.decode(paramXmlPullParser.getText(), 0);
      localObject3 = com.google.android.exoplayer2.c.d.h.r((byte[])localObject1);
      localObject2 = localObject3;
      bool1 = bool2;
      if (localObject3 == null)
      {
        localObject1 = null;
        bool1 = bool2;
        localObject2 = localObject3;
      }
    }
    for (;;)
    {
      localObject4 = localObject2;
      localObject3 = localObject1;
      bool2 = bool1;
      if (!y.h(paramXmlPullParser, "ContentProtection")) {
        break;
      }
      if (localObject1 == null) {
        break label296;
      }
      paramXmlPullParser = new DrmInitData.SchemeData((UUID)localObject2, str, "video/mp4", (byte[])localObject1, bool1);
      AppMethodBeat.o(10525);
      return paramXmlPullParser;
      if ((localObject3 == null) && (bool3) && (y.i(paramXmlPullParser, "mspr:pro")) && (paramXmlPullParser.next() == 4))
      {
        localObject1 = com.google.android.exoplayer2.c.d.h.a(com.google.android.exoplayer2.b.aQz, Base64.decode(paramXmlPullParser.getText(), 0));
        localObject2 = com.google.android.exoplayer2.b.aQz;
        bool1 = bool2;
      }
      else
      {
        localObject2 = localObject4;
        localObject1 = localObject3;
        bool1 = bool2;
        if (y.i(paramXmlPullParser, "widevine:license"))
        {
          localObject1 = paramXmlPullParser.getAttributeValue(null, "robustness_level");
          if ((localObject1 != null) && (((String)localObject1).startsWith("HW")))
          {
            bool1 = true;
            localObject2 = localObject4;
            localObject1 = localObject3;
          }
          else
          {
            bool1 = false;
            localObject2 = localObject4;
            localObject1 = localObject3;
          }
        }
      }
    }
    label296:
    AppMethodBeat.o(10525);
    return null;
  }
  
  private static String c(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(10545);
    paramXmlPullParser.next();
    paramXmlPullParser = w.m(paramString, paramXmlPullParser.getText());
    AppMethodBeat.o(10545);
    return paramXmlPullParser;
  }
  
  private static int d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(10526);
    String str1 = b(paramXmlPullParser, "schemeIdUri", null);
    String str2 = b(paramXmlPullParser, "value", null);
    do
    {
      paramXmlPullParser.next();
    } while (!y.h(paramXmlPullParser, "Role"));
    if (("urn:mpeg:dash:role:2011".equals(str1)) && ("main".equals(str2)))
    {
      AppMethodBeat.o(10526);
      return 1;
    }
    AppMethodBeat.o(10526);
    return 0;
  }
  
  private static f e(String paramString, long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(10536);
    paramString = new f(paramString, paramLong1, paramLong2);
    AppMethodBeat.o(10536);
    return paramString;
  }
  
  private static List<h.d> e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(10531);
    ArrayList localArrayList = new ArrayList();
    long l1 = 0L;
    do
    {
      paramXmlPullParser.next();
      long l2 = l1;
      if (y.i(paramXmlPullParser, "S"))
      {
        l1 = c(paramXmlPullParser, "t", l1);
        long l3 = c(paramXmlPullParser, "d", -9223372036854775807L);
        int j = a(paramXmlPullParser, "r", 0);
        int i = 0;
        for (;;)
        {
          l2 = l1;
          if (i >= j + 1) {
            break;
          }
          localArrayList.add(k(l1, l3));
          l1 += l3;
          i += 1;
        }
      }
      l1 = l2;
    } while (!y.h(paramXmlPullParser, "SegmentTimeline"));
    AppMethodBeat.o(10531);
    return localArrayList;
  }
  
  private static f f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(10534);
    paramXmlPullParser = a(paramXmlPullParser, "sourceURL", "range");
    AppMethodBeat.o(10534);
    return paramXmlPullParser;
  }
  
  private static int g(XmlPullParser paramXmlPullParser)
  {
    int i = -1;
    AppMethodBeat.i(10537);
    if ("urn:mpeg:dash:23003:3:audio_channel_configuration:2011".equals(b(paramXmlPullParser, "schemeIdUri", null))) {
      i = a(paramXmlPullParser, "value", -1);
    }
    do
    {
      paramXmlPullParser.next();
    } while (!y.h(paramXmlPullParser, "AudioChannelConfiguration"));
    AppMethodBeat.o(10537);
    return i;
  }
  
  private static h.d k(long paramLong1, long paramLong2)
  {
    AppMethodBeat.i(10532);
    h.d locald = new h.d(paramLong1, paramLong2);
    AppMethodBeat.o(10532);
    return locald;
  }
  
  private static int y(List<d> paramList)
  {
    AppMethodBeat.i(10541);
    int i = 0;
    while (i < paramList.size())
    {
      d locald = (d)paramList.get(i);
      if (("urn:scte:dash:cc:cea-608:2015".equals(locald.bjo)) && (locald.value != null))
      {
        Matcher localMatcher = bnX.matcher(locald.value);
        if (localMatcher.matches())
        {
          i = Integer.parseInt(localMatcher.group(1));
          AppMethodBeat.o(10541);
          return i;
        }
        new StringBuilder("Unable to parse CEA-608 channel number from: ").append(locald.value);
      }
      i += 1;
    }
    AppMethodBeat.o(10541);
    return -1;
  }
  
  private static int z(List<d> paramList)
  {
    AppMethodBeat.i(10542);
    int i = 0;
    while (i < paramList.size())
    {
      d locald = (d)paramList.get(i);
      if (("urn:scte:dash:cc:cea-708:2015".equals(locald.bjo)) && (locald.value != null))
      {
        Matcher localMatcher = bnY.matcher(locald.value);
        if (localMatcher.matches())
        {
          i = Integer.parseInt(localMatcher.group(1));
          AppMethodBeat.o(10542);
          return i;
        }
        new StringBuilder("Unable to parse CEA-708 service block number from: ").append(locald.value);
      }
      i += 1;
    }
    AppMethodBeat.o(10542);
    return -1;
  }
  
  static final class a
  {
    public final Format aSv;
    public final String bob;
    public final h boc;
    public final ArrayList<DrmInitData.SchemeData> bod;
    public final ArrayList<d> boe;
    
    public a(Format paramFormat, String paramString, h paramh, ArrayList<DrmInitData.SchemeData> paramArrayList, ArrayList<d> paramArrayList1)
    {
      this.aSv = paramFormat;
      this.bob = paramString;
      this.boc = paramh;
      this.bod = paramArrayList;
      this.boe = paramArrayList1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.dash.manifest.c
 * JD-Core Version:    0.7.0.1
 */