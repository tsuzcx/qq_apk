package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.x;
import com.google.android.exoplayer2.i.y;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

public final class a
  extends com.google.android.exoplayer2.f.b
{
  private static final Pattern dge;
  private static final Pattern dgf;
  private static final Pattern dgg;
  private static final Pattern dgh;
  private static final a dgi;
  private final XmlPullParserFactory dgj;
  
  static
  {
    AppMethodBeat.i(92847);
    dge = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
    dgf = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
    dgg = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
    dgh = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
    dgi = new a(30.0F, 1, 1);
    AppMethodBeat.o(92847);
  }
  
  public a()
  {
    super("TtmlDecoder");
    AppMethodBeat.i(92838);
    try
    {
      this.dgj = XmlPullParserFactory.newInstance();
      this.dgj.setNamespaceAware(true);
      AppMethodBeat.o(92838);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      RuntimeException localRuntimeException = new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
      AppMethodBeat.o(92838);
      throw localRuntimeException;
    }
  }
  
  private static long a(String paramString, a parama)
  {
    double d3 = 0.0D;
    AppMethodBeat.i(92845);
    Matcher localMatcher = dge.matcher(paramString);
    double d1;
    double d2;
    long l;
    if (localMatcher.matches())
    {
      double d4 = Long.parseLong(localMatcher.group(1)) * 3600L;
      double d5 = Long.parseLong(localMatcher.group(2)) * 60L;
      double d6 = Long.parseLong(localMatcher.group(3));
      paramString = localMatcher.group(4);
      if (paramString != null)
      {
        d1 = Double.parseDouble(paramString);
        paramString = localMatcher.group(5);
        if (paramString == null) {
          break label176;
        }
      }
      label176:
      for (d2 = (float)Long.parseLong(paramString) / parama.dgk;; d2 = 0.0D)
      {
        paramString = localMatcher.group(6);
        if (paramString != null) {
          d3 = Long.parseLong(paramString) / parama.dgl / parama.dgk;
        }
        l = ((d2 + (d6 + (d4 + d5) + d1) + d3) * 1000000.0D);
        AppMethodBeat.o(92845);
        return l;
        d1 = 0.0D;
        break;
      }
    }
    localMatcher = dgf.matcher(paramString);
    if (localMatcher.matches())
    {
      d2 = Double.parseDouble(localMatcher.group(1));
      paramString = localMatcher.group(2);
      int i = -1;
      switch (paramString.hashCode())
      {
      default: 
        d1 = d2;
        switch (i)
        {
        default: 
          d1 = d2;
        }
        break;
      }
      for (;;)
      {
        l = (d1 * 1000000.0D);
        AppMethodBeat.o(92845);
        return l;
        if (!paramString.equals("h")) {
          break;
        }
        i = 0;
        break;
        if (!paramString.equals("m")) {
          break;
        }
        i = 1;
        break;
        if (!paramString.equals("s")) {
          break;
        }
        i = 2;
        break;
        if (!paramString.equals("ms")) {
          break;
        }
        i = 3;
        break;
        if (!paramString.equals("f")) {
          break;
        }
        i = 4;
        break;
        if (!paramString.equals("t")) {
          break;
        }
        i = 5;
        break;
        d1 = d2 * 3600.0D;
        continue;
        d1 = d2 * 60.0D;
        continue;
        d1 = d2 / 1000.0D;
        continue;
        d1 = d2 / parama.dgk;
        continue;
        d1 = d2 / parama.tickRate;
      }
    }
    paramString = new f("Malformed time expression: ".concat(String.valueOf(paramString)));
    AppMethodBeat.o(92845);
    throw paramString;
  }
  
  private static b a(XmlPullParser paramXmlPullParser, b paramb, Map<String, c> paramMap, a parama)
  {
    AppMethodBeat.i(92844);
    long l5 = -9223372036854775807L;
    long l1 = -9223372036854775807L;
    long l3 = -9223372036854775807L;
    Object localObject1 = "";
    Object localObject2 = null;
    int k = paramXmlPullParser.getAttributeCount();
    d locald = a(paramXmlPullParser, null);
    int j = 0;
    label132:
    long l2;
    if (j < k)
    {
      Object localObject3 = paramXmlPullParser.getAttributeName(j);
      Object localObject5 = paramXmlPullParser.getAttributeValue(j);
      int i = -1;
      Object localObject4;
      long l6;
      switch (((String)localObject3).hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          localObject4 = localObject1;
          localObject3 = localObject2;
          l6 = l5;
          l4 = l1;
          l2 = l3;
        }
        break;
      }
      for (;;)
      {
        j += 1;
        l3 = l2;
        l1 = l4;
        l5 = l6;
        localObject2 = localObject3;
        localObject1 = localObject4;
        break;
        if (!((String)localObject3).equals("begin")) {
          break label132;
        }
        i = 0;
        break label132;
        if (!((String)localObject3).equals("end")) {
          break label132;
        }
        i = 1;
        break label132;
        if (!((String)localObject3).equals("dur")) {
          break label132;
        }
        i = 2;
        break label132;
        if (!((String)localObject3).equals("style")) {
          break label132;
        }
        i = 3;
        break label132;
        if (!((String)localObject3).equals("region")) {
          break label132;
        }
        i = 4;
        break label132;
        l4 = a((String)localObject5, parama);
        l2 = l3;
        l6 = l5;
        localObject3 = localObject2;
        localObject4 = localObject1;
        continue;
        l2 = a((String)localObject5, parama);
        l4 = l1;
        l6 = l5;
        localObject3 = localObject2;
        localObject4 = localObject1;
        continue;
        l6 = a((String)localObject5, parama);
        l2 = l3;
        l4 = l1;
        localObject3 = localObject2;
        localObject4 = localObject1;
        continue;
        localObject5 = ((String)localObject5).split("\\s+");
        l2 = l3;
        l4 = l1;
        l6 = l5;
        localObject3 = localObject2;
        localObject4 = localObject1;
        if (localObject5.length > 0)
        {
          localObject3 = localObject5;
          l2 = l3;
          l4 = l1;
          l6 = l5;
          localObject4 = localObject1;
          continue;
          l2 = l3;
          l4 = l1;
          l6 = l5;
          localObject3 = localObject2;
          localObject4 = localObject1;
          if (paramMap.containsKey(localObject5))
          {
            localObject4 = localObject5;
            l2 = l3;
            l4 = l1;
            l6 = l5;
            localObject3 = localObject2;
          }
        }
      }
    }
    long l4 = l1;
    if (paramb != null)
    {
      l4 = l1;
      if (paramb.daJ != -9223372036854775807L)
      {
        l2 = l1;
        if (l1 != -9223372036854775807L) {
          l2 = l1 + paramb.daJ;
        }
        l4 = l2;
        if (l3 != -9223372036854775807L) {
          l1 = l3 + paramb.daJ;
        }
      }
    }
    for (;;)
    {
      if (l1 == -9223372036854775807L) {
        if (l5 != -9223372036854775807L) {
          l1 = l5 + l2;
        }
      }
      for (;;)
      {
        paramXmlPullParser = new b(paramXmlPullParser.getName(), null, l2, l1, locald, localObject2, (String)localObject1);
        AppMethodBeat.o(92844);
        return paramXmlPullParser;
        if ((paramb != null) && (paramb.daK != -9223372036854775807L)) {
          l1 = paramb.daK;
        }
      }
      l1 = l3;
      l2 = l4;
    }
  }
  
  private static d a(d paramd)
  {
    AppMethodBeat.i(92843);
    if (paramd == null)
    {
      paramd = new d();
      AppMethodBeat.o(92843);
      return paramd;
    }
    AppMethodBeat.o(92843);
    return paramd;
  }
  
  private static d a(XmlPullParser paramXmlPullParser, d paramd)
  {
    AppMethodBeat.i(92842);
    int k = paramXmlPullParser.getAttributeCount();
    int j = 0;
    d locald1 = paramd;
    String str;
    int i;
    if (j < k)
    {
      str = paramXmlPullParser.getAttributeValue(j);
      paramd = paramXmlPullParser.getAttributeName(j);
      i = -1;
      switch (paramd.hashCode())
      {
      default: 
        switch (i)
        {
        default: 
          label128:
          paramd = locald1;
        }
        break;
      }
    }
    for (;;)
    {
      j += 1;
      locald1 = paramd;
      break;
      if (!paramd.equals("id")) {
        break label128;
      }
      i = 0;
      break label128;
      if (!paramd.equals("backgroundColor")) {
        break label128;
      }
      i = 1;
      break label128;
      if (!paramd.equals("color")) {
        break label128;
      }
      i = 2;
      break label128;
      if (!paramd.equals("fontFamily")) {
        break label128;
      }
      i = 3;
      break label128;
      if (!paramd.equals("fontSize")) {
        break label128;
      }
      i = 4;
      break label128;
      if (!paramd.equals("fontWeight")) {
        break label128;
      }
      i = 5;
      break label128;
      if (!paramd.equals("fontStyle")) {
        break label128;
      }
      i = 6;
      break label128;
      if (!paramd.equals("textAlign")) {
        break label128;
      }
      i = 7;
      break label128;
      if (!paramd.equals("textDecoration")) {
        break label128;
      }
      i = 8;
      break label128;
      paramd = locald1;
      if (!"style".equals(paramXmlPullParser.getName())) {
        continue;
      }
      paramd = a(locald1);
      paramd.id = str;
      continue;
      paramd = a(locald1);
      try
      {
        paramd.iA(com.google.android.exoplayer2.i.e.cY(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
      continue;
      paramd = a(localIllegalArgumentException1);
      try
      {
        paramd.iz(com.google.android.exoplayer2.i.e.cY(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException2) {}
      continue;
      paramd = a(localIllegalArgumentException2);
      if (paramd.dgz == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.checkState(bool1);
        paramd.fontFamily = str;
        break;
      }
      paramd = localIllegalArgumentException2;
      try
      {
        d locald2 = a(localIllegalArgumentException2);
        paramd = locald2;
        Object localObject = str.split("\\s+");
        paramd = locald2;
        if (localObject.length == 1)
        {
          paramd = locald2;
          localObject = dgg.matcher(str);
          label485:
          paramd = locald2;
          if (!((Matcher)localObject).matches()) {
            break label797;
          }
          paramd = locald2;
          str = ((Matcher)localObject).group(3);
          i = -1;
          paramd = locald2;
          switch (str.hashCode())
          {
          }
        }
        for (;;)
        {
          paramd = locald2;
          localObject = new f("Invalid unit for fontSize: '" + str + "'.");
          paramd = locald2;
          AppMethodBeat.o(92842);
          paramd = locald2;
          throw ((Throwable)localObject);
          paramd = locald2;
          if (localObject.length == 2)
          {
            paramd = locald2;
            localObject = dgg.matcher(localObject[1]);
            break label485;
          }
          paramd = locald2;
          localObject = new f("Invalid number of entries for fontSize: " + localObject.length + ".");
          paramd = locald2;
          AppMethodBeat.o(92842);
          paramd = locald2;
          throw ((Throwable)localObject);
          paramd = locald2;
          if (str.equals("px"))
          {
            i = 0;
            break label1434;
            paramd = locald2;
            if (str.equals("em"))
            {
              i = 1;
              break label1434;
              paramd = locald2;
              if (str.equals("%"))
              {
                i = 2;
                break label1434;
                paramd = locald2;
                locald2.dgy = 1;
                for (;;)
                {
                  paramd = locald2;
                  locald2.fontSize = Float.valueOf(((Matcher)localObject).group(1)).floatValue();
                  paramd = locald2;
                  break;
                  paramd = locald2;
                  locald2.dgy = 2;
                  continue;
                  paramd = locald2;
                  locald2.dgy = 3;
                }
                label797:
                paramd = locald2;
                localObject = new f("Invalid expression for fontSize: '" + str + "'.");
                paramd = locald2;
                AppMethodBeat.o(92842);
                paramd = locald2;
                throw ((Throwable)localObject);
                paramd = a(locald2);
                boolean bool2 = "bold".equalsIgnoreCase(str);
                if (paramd.dgz == null)
                {
                  bool1 = true;
                  label873:
                  com.google.android.exoplayer2.i.a.checkState(bool1);
                  if (!bool2) {
                    break label899;
                  }
                }
                label899:
                for (i = 1;; i = 0)
                {
                  paramd.dgx = i;
                  break;
                  bool1 = false;
                  break label873;
                }
                paramd = a(locald2);
                bool2 = "italic".equalsIgnoreCase(str);
                if (paramd.dgz == null)
                {
                  bool1 = true;
                  label930:
                  com.google.android.exoplayer2.i.a.checkState(bool1);
                  if (!bool2) {
                    break label956;
                  }
                }
                label956:
                for (i = 1;; i = 0)
                {
                  paramd.italic = i;
                  break;
                  bool1 = false;
                  break label930;
                }
                paramd = x.ds(str);
                i = -1;
                switch (paramd.hashCode())
                {
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    paramd = locald2;
                    break;
                  case 0: 
                    paramd = a(locald2);
                    paramd.dgA = Layout.Alignment.ALIGN_NORMAL;
                    break;
                    if (paramd.equals("left"))
                    {
                      i = 0;
                      continue;
                      if (paramd.equals("start"))
                      {
                        i = 1;
                        continue;
                        if (paramd.equals("right"))
                        {
                          i = 2;
                          continue;
                          if (paramd.equals("end"))
                          {
                            i = 3;
                            continue;
                            if (paramd.equals("center")) {
                              i = 4;
                            }
                          }
                        }
                      }
                    }
                    break;
                  }
                }
                paramd = a(locald2);
                paramd.dgA = Layout.Alignment.ALIGN_NORMAL;
                break;
                paramd = a(locald2);
                paramd.dgA = Layout.Alignment.ALIGN_OPPOSITE;
                break;
                paramd = a(locald2);
                paramd.dgA = Layout.Alignment.ALIGN_OPPOSITE;
                break;
                paramd = a(locald2);
                paramd.dgA = Layout.Alignment.ALIGN_CENTER;
                break;
                paramd = x.ds(str);
                i = -1;
                switch (paramd.hashCode())
                {
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    paramd = locald2;
                    break;
                  case 0: 
                    paramd = a(locald2).bA(true);
                    break;
                    if (paramd.equals("linethrough"))
                    {
                      i = 0;
                      continue;
                      if (paramd.equals("nolinethrough"))
                      {
                        i = 1;
                        continue;
                        if (paramd.equals("underline"))
                        {
                          i = 2;
                          continue;
                          if (paramd.equals("nounderline")) {
                            i = 3;
                          }
                        }
                      }
                    }
                    break;
                  }
                }
                paramd = a(locald2).bA(false);
                break;
                paramd = a(locald2).bB(true);
                break;
                paramd = a(locald2).bB(false);
                break;
                AppMethodBeat.o(92842);
                return locald2;
              }
            }
          }
          label1434:
          switch (i)
          {
          }
        }
      }
      catch (f localf) {}
    }
  }
  
  private static Map<String, d> a(XmlPullParser paramXmlPullParser, Map<String, d> paramMap, Map<String, c> paramMap1)
  {
    AppMethodBeat.i(92840);
    label130:
    label200:
    label205:
    label208:
    for (;;)
    {
      paramXmlPullParser.next();
      Object localObject1;
      if (y.b(paramXmlPullParser, "style"))
      {
        Object localObject2 = y.c(paramXmlPullParser, "style");
        localObject1 = a(paramXmlPullParser, new d());
        if (localObject2 != null)
        {
          localObject2 = ((String)localObject2).split("\\s+");
          int j = localObject2.length;
          i = 0;
          while (i < j)
          {
            ((d)localObject1).b((d)paramMap.get(localObject2[i]));
            i += 1;
          }
        }
        if (((d)localObject1).id != null) {
          paramMap.put(((d)localObject1).id, localObject1);
        }
        if (paramXmlPullParser.getEventType() != 3) {
          break label200;
        }
        i = 1;
        if ((i == 0) || (!paramXmlPullParser.getName().equals("head"))) {
          break label205;
        }
      }
      for (int i = 1;; i = 0)
      {
        if (i == 0) {
          break label208;
        }
        AppMethodBeat.o(92840);
        return paramMap;
        if (!y.b(paramXmlPullParser, "region")) {
          break;
        }
        localObject1 = b(paramXmlPullParser);
        if (localObject1 == null) {
          break;
        }
        paramMap1.put(((c)localObject1).id, localObject1);
        break;
        i = 0;
        break label130;
      }
    }
  }
  
  private static c b(XmlPullParser paramXmlPullParser)
  {
    int j = 1;
    AppMethodBeat.i(92841);
    String str = y.c(paramXmlPullParser, "id");
    if (str == null)
    {
      AppMethodBeat.o(92841);
      return null;
    }
    Object localObject = y.c(paramXmlPullParser, "origin");
    if (localObject != null)
    {
      localObject = dgh.matcher((CharSequence)localObject);
      if (!((Matcher)localObject).matches()) {}
    }
    for (;;)
    {
      float f1;
      float f4;
      int i;
      try
      {
        float f2 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
        f1 = Float.parseFloat(((Matcher)localObject).group(2));
        f1 /= 100.0F;
        localObject = y.c(paramXmlPullParser, "extent");
        if (localObject == null) {
          break label301;
        }
        localObject = dgh.matcher((CharSequence)localObject);
        if (!((Matcher)localObject).matches()) {
          break label293;
        }
        float f3;
        AppMethodBeat.o(92841);
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        try
        {
          f3 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
          f4 = Float.parseFloat(((Matcher)localObject).group(2));
          f4 /= 100.0F;
          paramXmlPullParser = y.c(paramXmlPullParser, "displayAlign");
          if (paramXmlPullParser != null)
          {
            paramXmlPullParser = x.ds(paramXmlPullParser);
            i = -1;
          }
          switch (paramXmlPullParser.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              i = 0;
              paramXmlPullParser = new c(str, f2, f1, 0, i, f3);
              AppMethodBeat.o(92841);
              return paramXmlPullParser;
            }
            break;
          }
        }
        catch (NumberFormatException paramXmlPullParser)
        {
          AppMethodBeat.o(92841);
          return null;
        }
        paramXmlPullParser = paramXmlPullParser;
        AppMethodBeat.o(92841);
        return null;
      }
      return null;
      AppMethodBeat.o(92841);
      return null;
      label293:
      AppMethodBeat.o(92841);
      return null;
      label301:
      AppMethodBeat.o(92841);
      return null;
      if (paramXmlPullParser.equals("center"))
      {
        i = 0;
        continue;
        if (paramXmlPullParser.equals("after"))
        {
          i = 1;
          continue;
          f1 += f4 / 2.0F;
          i = j;
          continue;
          i = 2;
          f1 += f4;
        }
      }
    }
  }
  
  private e i(byte[] paramArrayOfByte, int paramInt)
  {
    AppMethodBeat.i(92839);
    int i;
    try
    {
      localXmlPullParser = this.dgj.newPullParser();
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap2.put("", new c());
      localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
      locale = null;
      localLinkedList = new LinkedList();
      i = localXmlPullParser.getEventType();
      paramArrayOfByte = dgi;
      paramInt = 0;
    }
    catch (XmlPullParserException paramArrayOfByte)
    {
      XmlPullParser localXmlPullParser;
      HashMap localHashMap1;
      HashMap localHashMap2;
      e locale;
      LinkedList localLinkedList;
      b localb;
      Object localObject;
      paramArrayOfByte = new f("Unable to decode source", paramArrayOfByte);
      AppMethodBeat.o(92839);
      throw paramArrayOfByte;
      f = Integer.parseInt(paramArrayOfByte[0]) / Integer.parseInt(paramArrayOfByte[1]);
      j = dgi.dgl;
      paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
      if (paramArrayOfByte == null) {
        break label812;
      }
      j = Integer.parseInt(paramArrayOfByte);
      k = dgi.tickRate;
      paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
      if (paramArrayOfByte == null) {
        break label809;
      }
      k = Integer.parseInt(paramArrayOfByte);
      paramArrayOfByte = new a(f * i, j, k);
      if ((((String)localObject).equals("tt")) || (((String)localObject).equals("head")) || (((String)localObject).equals("body")) || (((String)localObject).equals("div")) || (((String)localObject).equals("p")) || (((String)localObject).equals("span")) || (((String)localObject).equals("br")) || (((String)localObject).equals("style")) || (((String)localObject).equals("styling")) || (((String)localObject).equals("layout")) || (((String)localObject).equals("region")) || (((String)localObject).equals("metadata")) || (((String)localObject).equals("smpte:image")) || (((String)localObject).equals("smpte:data"))) {
        break label830;
      }
      if (!((String)localObject).equals("smpte:information")) {
        break label836;
      }
      break label830;
      if (i != 0) {
        break label550;
      }
      new StringBuilder("Ignoring unsupported tag: ").append(localXmlPullParser.getName());
      paramInt += 1;
      for (;;)
      {
        localXmlPullParser.next();
        i = localXmlPullParser.getEventType();
        break;
        if ("head".equals(localObject))
        {
          a(localXmlPullParser, localHashMap1, localHashMap2);
        }
        else
        {
          try
          {
            localObject = a(localXmlPullParser, localb, localHashMap2, paramArrayOfByte);
            localLinkedList.addLast(localObject);
            if (localb != null) {
              localb.a((b)localObject);
            }
          }
          catch (f localf)
          {
            paramInt += 1;
          }
          continue;
          if (i == 4)
          {
            localf.a(new b(null, localXmlPullParser.getText().replaceAll("\r\n", "\n").replaceAll(" *\n *", "\n").replaceAll("\n", " ").replaceAll("[ \t\\x0B\f\r]+", " "), -9223372036854775807L, -9223372036854775807L, null, null, ""));
          }
          else
          {
            if (i != 3) {
              break label806;
            }
            if (!localXmlPullParser.getName().equals("tt")) {
              break label803;
            }
            locale = new e((b)localLinkedList.getLast(), localHashMap1, localHashMap2);
            localLinkedList.removeLast();
            continue;
            if (i == 2)
            {
              paramInt += 1;
            }
            else
            {
              if (i != 3) {
                break label800;
              }
              paramInt -= 1;
            }
          }
        }
      }
      AppMethodBeat.o(92839);
      return locale;
    }
    catch (IOException paramArrayOfByte)
    {
      label550:
      paramArrayOfByte = new IllegalStateException("Unexpected error when reading input.", paramArrayOfByte);
      AppMethodBeat.o(92839);
      throw paramArrayOfByte;
    }
    if (i != 1)
    {
      localb = (b)localLinkedList.peekLast();
      if (paramInt == 0)
      {
        localObject = localXmlPullParser.getName();
        if (i == 2)
        {
          if (!"tt".equals(localObject)) {
            break label827;
          }
          paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
          if (paramArrayOfByte == null) {
            break label820;
          }
          i = Integer.parseInt(paramArrayOfByte);
          paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
          if (paramArrayOfByte == null) {
            break label815;
          }
          paramArrayOfByte = paramArrayOfByte.split(" ");
          if (paramArrayOfByte.length != 2)
          {
            paramArrayOfByte = new f("frameRateMultiplier doesn't have 2 parts");
            AppMethodBeat.o(92839);
            throw paramArrayOfByte;
          }
        }
      }
    }
    for (;;)
    {
      int j;
      int k;
      label800:
      continue;
      label803:
      continue;
      label806:
      continue;
      label809:
      continue;
      label812:
      continue;
      label815:
      float f = 1.0F;
      continue;
      label820:
      i = 30;
      break;
      label827:
      continue;
      label830:
      i = 1;
      continue;
      label836:
      i = 0;
    }
  }
  
  static final class a
  {
    final float dgk;
    final int dgl;
    final int tickRate;
    
    a(float paramFloat, int paramInt1, int paramInt2)
    {
      this.dgk = paramFloat;
      this.dgl = paramInt1;
      this.tickRate = paramInt2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.a
 * JD-Core Version:    0.7.0.1
 */