package com.google.android.exoplayer2.f.e;

import android.text.Layout.Alignment;
import com.google.android.exoplayer2.f.f;
import com.google.android.exoplayer2.i.t;
import com.google.android.exoplayer2.i.u;
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
  private static final Pattern aOQ = Pattern.compile("^([0-9][0-9]+):([0-9][0-9]):([0-9][0-9])(?:(\\.[0-9]+)|:([0-9][0-9])(?:\\.([0-9]+))?)?$");
  private static final Pattern aOR = Pattern.compile("^([0-9]+(?:\\.[0-9]+)?)(h|m|s|ms|f|t)$");
  private static final Pattern aOS = Pattern.compile("^(([0-9]*.)?[0-9]+)(px|em|%)$");
  private static final Pattern aOT = Pattern.compile("^(\\d+\\.?\\d*?)% (\\d+\\.?\\d*?)%$");
  private static final a.a aOU = new a.a(30.0F, 1, 1);
  private final XmlPullParserFactory aOV;
  
  public a()
  {
    super("TtmlDecoder");
    try
    {
      this.aOV = XmlPullParserFactory.newInstance();
      this.aOV.setNamespaceAware(true);
      return;
    }
    catch (XmlPullParserException localXmlPullParserException)
    {
      throw new RuntimeException("Couldn't create XmlPullParserFactory instance", localXmlPullParserException);
    }
  }
  
  private static long a(String paramString, a.a parama)
  {
    double d3 = 0.0D;
    Matcher localMatcher = aOQ.matcher(paramString);
    double d1;
    double d2;
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
          break label162;
        }
      }
      label162:
      for (d2 = (float)Long.parseLong(paramString) / parama.aOW;; d2 = 0.0D)
      {
        paramString = localMatcher.group(6);
        if (paramString != null) {
          d3 = Long.parseLong(paramString) / parama.aOX / parama.aOW;
        }
        return ((d2 + (d6 + (d4 + d5) + d1) + d3) * 1000000.0D);
        d1 = 0.0D;
        break;
      }
    }
    localMatcher = aOR.matcher(paramString);
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
        return (d1 * 1000000.0D);
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
        d1 = d2 / parama.aOW;
        continue;
        d1 = d2 / parama.aOY;
      }
    }
    throw new f("Malformed time expression: " + paramString);
  }
  
  private static b a(XmlPullParser paramXmlPullParser, b paramb, Map<String, c> paramMap, a.a parama)
  {
    long l5 = -9223372036854775807L;
    long l1 = -9223372036854775807L;
    long l3 = -9223372036854775807L;
    Object localObject1 = "";
    Object localObject2 = null;
    int k = paramXmlPullParser.getAttributeCount();
    d locald = a(paramXmlPullParser, null);
    int j = 0;
    label124:
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
          break label124;
        }
        i = 0;
        break label124;
        if (!((String)localObject3).equals("end")) {
          break label124;
        }
        i = 1;
        break label124;
        if (!((String)localObject3).equals("dur")) {
          break label124;
        }
        i = 2;
        break label124;
        if (!((String)localObject3).equals("style")) {
          break label124;
        }
        i = 3;
        break label124;
        if (!((String)localObject3).equals("region")) {
          break label124;
        }
        i = 4;
        break label124;
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
      if (paramb.aJe != -9223372036854775807L)
      {
        l2 = l1;
        if (l1 != -9223372036854775807L) {
          l2 = l1 + paramb.aJe;
        }
        l4 = l2;
        if (l3 != -9223372036854775807L) {
          l1 = l3 + paramb.aJe;
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
        return new b(paramXmlPullParser.getName(), null, l2, l1, locald, localObject2, (String)localObject1);
        if ((paramb != null) && (paramb.aJf != -9223372036854775807L)) {
          l1 = paramb.aJf;
        }
      }
      l1 = l3;
      l2 = l4;
    }
  }
  
  private static d a(d paramd)
  {
    d locald = paramd;
    if (paramd == null) {
      locald = new d();
    }
    return locald;
  }
  
  private static d a(XmlPullParser paramXmlPullParser, d paramd)
  {
    int k = paramXmlPullParser.getAttributeCount();
    int j = 0;
    d locald1 = paramd;
    String str;
    label124:
    int i;
    if (j < k)
    {
      str = paramXmlPullParser.getAttributeValue(j);
      paramd = paramXmlPullParser.getAttributeName(j);
      switch (paramd.hashCode())
      {
      default: 
        i = -1;
        switch (i)
        {
        default: 
          label126:
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
        break label124;
      }
      i = 0;
      break label126;
      if (!paramd.equals("backgroundColor")) {
        break label124;
      }
      i = 1;
      break label126;
      if (!paramd.equals("color")) {
        break label124;
      }
      i = 2;
      break label126;
      if (!paramd.equals("fontFamily")) {
        break label124;
      }
      i = 3;
      break label126;
      if (!paramd.equals("fontSize")) {
        break label124;
      }
      i = 4;
      break label126;
      if (!paramd.equals("fontWeight")) {
        break label124;
      }
      i = 5;
      break label126;
      if (!paramd.equals("fontStyle")) {
        break label124;
      }
      i = 6;
      break label126;
      if (!paramd.equals("textAlign")) {
        break label124;
      }
      i = 7;
      break label126;
      if (!paramd.equals("textDecoration")) {
        break label124;
      }
      i = 8;
      break label126;
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
        paramd.ds(com.google.android.exoplayer2.i.d.at(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException1) {}
      continue;
      paramd = a(localIllegalArgumentException1);
      try
      {
        paramd.dr(com.google.android.exoplayer2.i.d.at(str));
      }
      catch (IllegalArgumentException localIllegalArgumentException2) {}
      continue;
      paramd = a(localIllegalArgumentException2);
      if (paramd.aPo == null) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        com.google.android.exoplayer2.i.a.aC(bool1);
        paramd.aPg = str;
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
          localObject = aOS.matcher(str);
          label479:
          paramd = locald2;
          if (!((Matcher)localObject).matches()) {
            break label759;
          }
          paramd = locald2;
          str = ((Matcher)localObject).group(3);
          paramd = locald2;
          switch (str.hashCode())
          {
          }
        }
        for (;;)
        {
          paramd = locald2;
          throw new f("Invalid unit for fontSize: '" + str + "'.");
          paramd = locald2;
          if (localObject.length == 2)
          {
            paramd = locald2;
            localObject = aOS.matcher(localObject[1]);
            break label479;
          }
          paramd = locald2;
          throw new f("Invalid number of entries for fontSize: " + localObject.length + ".");
          paramd = locald2;
          if (str.equals("px"))
          {
            i = 0;
            break label1371;
            paramd = locald2;
            if (str.equals("em"))
            {
              i = 1;
              break label1371;
              paramd = locald2;
              if (str.equals("%"))
              {
                i = 2;
                break label1371;
                paramd = locald2;
                locald2.aPn = 1;
                for (;;)
                {
                  paramd = locald2;
                  locald2.fontSize = Float.valueOf(((Matcher)localObject).group(1)).floatValue();
                  paramd = locald2;
                  break;
                  paramd = locald2;
                  locald2.aPn = 2;
                  continue;
                  paramd = locald2;
                  locald2.aPn = 3;
                }
                label759:
                paramd = locald2;
                throw new f("Invalid expression for fontSize: '" + str + "'.");
                paramd = a(locald2);
                boolean bool2 = "bold".equalsIgnoreCase(str);
                if (paramd.aPo == null)
                {
                  bool1 = true;
                  label820:
                  com.google.android.exoplayer2.i.a.aC(bool1);
                  if (!bool2) {
                    break label846;
                  }
                }
                label846:
                for (i = 1;; i = 0)
                {
                  paramd.aPm = i;
                  break;
                  bool1 = false;
                  break label820;
                }
                paramd = a(locald2);
                bool2 = "italic".equalsIgnoreCase(str);
                if (paramd.aPo == null)
                {
                  bool1 = true;
                  label877:
                  com.google.android.exoplayer2.i.a.aC(bool1);
                  if (!bool2) {
                    break label903;
                  }
                }
                label903:
                for (i = 1;; i = 0)
                {
                  paramd.italic = i;
                  break;
                  bool1 = false;
                  break label877;
                }
                paramd = t.aE(str);
                switch (paramd.hashCode())
                {
                default: 
                  label968:
                  i = -1;
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
                    paramd.aPp = Layout.Alignment.ALIGN_NORMAL;
                    break;
                    if (!paramd.equals("left")) {
                      break label968;
                    }
                    i = 0;
                    continue;
                    if (!paramd.equals("start")) {
                      break label968;
                    }
                    i = 1;
                    continue;
                    if (!paramd.equals("right")) {
                      break label968;
                    }
                    i = 2;
                    continue;
                    if (!paramd.equals("end")) {
                      break label968;
                    }
                    i = 3;
                    continue;
                    if (!paramd.equals("center")) {
                      break label968;
                    }
                    i = 4;
                  }
                }
                paramd = a(locald2);
                paramd.aPp = Layout.Alignment.ALIGN_NORMAL;
                break;
                paramd = a(locald2);
                paramd.aPp = Layout.Alignment.ALIGN_OPPOSITE;
                break;
                paramd = a(locald2);
                paramd.aPp = Layout.Alignment.ALIGN_OPPOSITE;
                break;
                paramd = a(locald2);
                paramd.aPp = Layout.Alignment.ALIGN_CENTER;
                break;
                paramd = t.aE(str);
                switch (paramd.hashCode())
                {
                default: 
                  label1216:
                  i = -1;
                }
                for (;;)
                {
                  switch (i)
                  {
                  default: 
                    paramd = locald2;
                    break;
                  case 0: 
                    paramd = a(locald2).az(true);
                    break;
                    if (!paramd.equals("linethrough")) {
                      break label1216;
                    }
                    i = 0;
                    continue;
                    if (!paramd.equals("nolinethrough")) {
                      break label1216;
                    }
                    i = 1;
                    continue;
                    if (!paramd.equals("underline")) {
                      break label1216;
                    }
                    i = 2;
                    continue;
                    if (!paramd.equals("nounderline")) {
                      break label1216;
                    }
                    i = 3;
                  }
                }
                paramd = a(locald2).az(false);
                break;
                paramd = a(locald2).aA(true);
                break;
                paramd = a(locald2).aA(false);
                break;
                return locald2;
              }
            }
          }
          i = -1;
          label1371:
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
    paramXmlPullParser.next();
    Object localObject1;
    if (u.b(paramXmlPullParser, "style"))
    {
      Object localObject2 = u.c(paramXmlPullParser, "style");
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
      label112:
      if (paramXmlPullParser.getEventType() != 3) {
        break label188;
      }
      i = 1;
      label124:
      if ((i == 0) || (!paramXmlPullParser.getName().equals("head"))) {
        break label193;
      }
    }
    label188:
    label193:
    for (int i = 1; i != 0; i = 0)
    {
      return paramMap;
      if (!u.b(paramXmlPullParser, "region")) {
        break label112;
      }
      localObject1 = b(paramXmlPullParser);
      if (localObject1 == null) {
        break label112;
      }
      paramMap1.put(((c)localObject1).id, localObject1);
      break label112;
      i = 0;
      break label124;
    }
  }
  
  private static c b(XmlPullParser paramXmlPullParser)
  {
    int j = 1;
    String str = u.c(paramXmlPullParser, "id");
    if (str == null) {
      return null;
    }
    Object localObject = u.c(paramXmlPullParser, "origin");
    if (localObject != null)
    {
      localObject = aOT.matcher((CharSequence)localObject);
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
        localObject = u.c(paramXmlPullParser, "extent");
        if (localObject == null) {
          break label251;
        }
        localObject = aOT.matcher((CharSequence)localObject);
        if (!((Matcher)localObject).matches()) {
          break label249;
        }
        float f3;
        return null;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        try
        {
          f3 = Float.parseFloat(((Matcher)localObject).group(1)) / 100.0F;
          f4 = Float.parseFloat(((Matcher)localObject).group(2));
          f4 /= 100.0F;
          paramXmlPullParser = u.c(paramXmlPullParser, "displayAlign");
          if (paramXmlPullParser != null)
          {
            paramXmlPullParser = t.aE(paramXmlPullParser);
            i = -1;
          }
          switch (paramXmlPullParser.hashCode())
          {
          default: 
            switch (i)
            {
            default: 
              i = 0;
              return new c(str, f2, f1, 0, i, f3);
            }
            break;
          }
        }
        catch (NumberFormatException paramXmlPullParser)
        {
          return null;
        }
        paramXmlPullParser = paramXmlPullParser;
        return null;
      }
      return null;
      label249:
      return null;
      label251:
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
          f1 += f4;
          i = 2;
        }
      }
    }
  }
  
  private e h(byte[] paramArrayOfByte, int paramInt)
  {
    e locale;
    int i;
    try
    {
      localXmlPullParser = this.aOV.newPullParser();
      localHashMap1 = new HashMap();
      localHashMap2 = new HashMap();
      localHashMap2.put("", new c());
      localXmlPullParser.setInput(new ByteArrayInputStream(paramArrayOfByte, 0, paramInt), null);
      locale = null;
      localLinkedList = new LinkedList();
      i = localXmlPullParser.getEventType();
      paramArrayOfByte = aOU;
      paramInt = 0;
    }
    catch (XmlPullParserException paramArrayOfByte)
    {
      XmlPullParser localXmlPullParser;
      HashMap localHashMap1;
      HashMap localHashMap2;
      LinkedList localLinkedList;
      b localb;
      Object localObject;
      throw new f("Unable to decode source", paramArrayOfByte);
      f = Integer.parseInt(paramArrayOfByte[0]) / Integer.parseInt(paramArrayOfByte[1]);
      j = aOU.aOX;
      paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "subFrameRate");
      if (paramArrayOfByte == null) {
        break label776;
      }
      j = Integer.parseInt(paramArrayOfByte);
      k = aOU.aOY;
      paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "tickRate");
      if (paramArrayOfByte == null) {
        break label773;
      }
      k = Integer.parseInt(paramArrayOfByte);
      paramArrayOfByte = new a.a(f * i, j, k);
      if ((((String)localObject).equals("tt")) || (((String)localObject).equals("head")) || (((String)localObject).equals("body")) || (((String)localObject).equals("div")) || (((String)localObject).equals("p")) || (((String)localObject).equals("span")) || (((String)localObject).equals("br")) || (((String)localObject).equals("style")) || (((String)localObject).equals("styling")) || (((String)localObject).equals("layout")) || (((String)localObject).equals("region")) || (((String)localObject).equals("metadata")) || (((String)localObject).equals("smpte:image")) || (((String)localObject).equals("smpte:data"))) {
        break label794;
      }
      if (!((String)localObject).equals("smpte:information")) {
        break label800;
      }
      break label794;
      if (i != 0) {
        break label528;
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
              break label770;
            }
            if (!localXmlPullParser.getName().equals("tt")) {
              break label767;
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
                break label764;
              }
              paramInt -= 1;
            }
          }
        }
      }
    }
    catch (IOException paramArrayOfByte)
    {
      label528:
      throw new IllegalStateException("Unexpected error when reading input.", paramArrayOfByte);
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
            break label791;
          }
          paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRate");
          if (paramArrayOfByte == null) {
            break label784;
          }
          i = Integer.parseInt(paramArrayOfByte);
          paramArrayOfByte = localXmlPullParser.getAttributeValue("http://www.w3.org/ns/ttml#parameter", "frameRateMultiplier");
          if (paramArrayOfByte == null) {
            break label779;
          }
          paramArrayOfByte = paramArrayOfByte.split(" ");
          if (paramArrayOfByte.length != 2) {
            throw new f("frameRateMultiplier doesn't have 2 parts");
          }
        }
      }
    }
    for (;;)
    {
      int j;
      int k;
      return locale;
      label764:
      continue;
      label767:
      continue;
      label770:
      continue;
      label773:
      continue;
      label776:
      continue;
      label779:
      float f = 1.0F;
      continue;
      label784:
      i = 30;
      break;
      label791:
      continue;
      label794:
      i = 1;
      continue;
      label800:
      i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.google.android.exoplayer2.f.e.a
 * JD-Core Version:    0.7.0.1
 */