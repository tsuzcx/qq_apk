package com.google.android.exoplayer2.source.c.a;

import android.util.Pair;
import com.google.android.exoplayer2.o;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

abstract class b$a
{
  private final String bqj;
  private final a brw;
  private final List<Pair<String, Object>> brx;
  private final String tag;
  
  public b$a(a parama, String paramString1, String paramString2)
  {
    this.brw = parama;
    this.bqj = paramString1;
    this.tag = paramString2;
    this.brx = new LinkedList();
  }
  
  protected static long c(XmlPullParser paramXmlPullParser, String paramString, long paramLong)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null) {}
    try
    {
      paramLong = Long.parseLong(paramXmlPullParser);
      return paramLong;
    }
    catch (NumberFormatException paramXmlPullParser)
    {
      throw new o(paramXmlPullParser);
    }
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null) {
      return paramXmlPullParser;
    }
    throw new b.b(paramString);
  }
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null) {
      try
      {
        int i = Integer.parseInt(paramXmlPullParser);
        return i;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        throw new o(paramXmlPullParser);
      }
    }
    return -1;
  }
  
  protected static int f(XmlPullParser paramXmlPullParser, String paramString)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null) {
      try
      {
        int i = Integer.parseInt(paramXmlPullParser);
        return i;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        throw new o(paramXmlPullParser);
      }
    }
    throw new b.b(paramString);
  }
  
  protected static long g(XmlPullParser paramXmlPullParser, String paramString)
  {
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null) {
      try
      {
        long l = Long.parseLong(paramXmlPullParser);
        return l;
      }
      catch (NumberFormatException paramXmlPullParser)
      {
        throw new o(paramXmlPullParser);
      }
    }
    throw new b.b(paramString);
  }
  
  protected void ac(Object paramObject) {}
  
  protected final Object at(String paramString)
  {
    for (a locala = this;; locala = locala.brw)
    {
      int i = 0;
      while (i < locala.brx.size())
      {
        Pair localPair = (Pair)locala.brx.get(i);
        if (((String)localPair.first).equals(paramString)) {
          return localPair.second;
        }
        i += 1;
      }
      if (locala.brw == null) {
        return null;
      }
    }
  }
  
  protected boolean au(String paramString)
  {
    return false;
  }
  
  protected abstract Object build();
  
  protected final void c(String paramString, Object paramObject)
  {
    this.brx.add(Pair.create(paramString, paramObject));
  }
  
  public final Object h(XmlPullParser paramXmlPullParser)
  {
    int j = 0;
    int i = 0;
    switch (paramXmlPullParser.getEventType())
    {
    default: 
    case 2: 
    case 4: 
    case 3: 
      Object localObject;
      label206:
      label250:
      do
      {
        for (;;)
        {
          paramXmlPullParser.next();
          break;
          localObject = paramXmlPullParser.getName();
          if (this.tag.equals(localObject))
          {
            i(paramXmlPullParser);
            i = 1;
          }
          else if (i != 0)
          {
            if (j > 0)
            {
              j += 1;
            }
            else if (au((String)localObject))
            {
              i(paramXmlPullParser);
            }
            else
            {
              String str = this.bqj;
              if ("QualityLevel".equals(localObject)) {
                localObject = new b.d(this, str);
              }
              for (;;)
              {
                if (localObject != null) {
                  break label206;
                }
                j = 1;
                break;
                if ("Protection".equals(localObject)) {
                  localObject = new b.c(this, str);
                } else if ("StreamIndex".equals(localObject)) {
                  localObject = new b.f(this, str);
                } else {
                  localObject = null;
                }
              }
              ac(((a)localObject).h(paramXmlPullParser));
              continue;
              if ((i != 0) && (j == 0))
              {
                j(paramXmlPullParser);
                continue;
                if (i != 0)
                {
                  if (j <= 0) {
                    break label250;
                  }
                  j -= 1;
                }
              }
            }
          }
        }
        localObject = paramXmlPullParser.getName();
        k(paramXmlPullParser);
      } while (au((String)localObject));
      return build();
    }
    return null;
  }
  
  protected void i(XmlPullParser paramXmlPullParser) {}
  
  protected void j(XmlPullParser paramXmlPullParser) {}
  
  protected void k(XmlPullParser paramXmlPullParser) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b.a
 * JD-Core Version:    0.7.0.1
 */