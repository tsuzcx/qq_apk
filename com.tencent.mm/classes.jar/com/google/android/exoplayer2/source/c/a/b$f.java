package com.google.android.exoplayer2.source.c.a;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.o;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

final class b$f
  extends b.a
{
  private String aSt;
  private int aYQ;
  private int aYR;
  private long bdm;
  private final String bqj;
  private final List<Format> brC;
  private ArrayList<Long> brD;
  private long brE;
  private String brr;
  private int maxHeight;
  private int maxWidth;
  private String name;
  private int type;
  private String url;
  
  public b$f(b.a parama, String paramString)
  {
    super(parama, paramString, "StreamIndex");
    AppMethodBeat.i(89997);
    this.bqj = paramString;
    this.brC = new LinkedList();
    AppMethodBeat.o(89997);
  }
  
  public final void ac(Object paramObject)
  {
    AppMethodBeat.i(90000);
    if ((paramObject instanceof Format)) {
      this.brC.add((Format)paramObject);
    }
    AppMethodBeat.o(90000);
  }
  
  public final boolean au(String paramString)
  {
    AppMethodBeat.i(89998);
    boolean bool = "c".equals(paramString);
    AppMethodBeat.o(89998);
    return bool;
  }
  
  public final Object build()
  {
    AppMethodBeat.i(90001);
    Object localObject = new Format[this.brC.size()];
    this.brC.toArray((Object[])localObject);
    localObject = new a.b(this.bqj, this.url, this.type, this.brr, this.bdm, this.name, this.maxWidth, this.maxHeight, this.aYQ, this.aYR, this.aSt, (Format[])localObject, this.brD, this.brE);
    AppMethodBeat.o(90001);
    return localObject;
  }
  
  public final void i(XmlPullParser paramXmlPullParser)
  {
    int j = 1;
    AppMethodBeat.i(89999);
    int i;
    if ("c".equals(paramXmlPullParser.getName()))
    {
      i = this.brD.size();
      long l2 = c(paramXmlPullParser, "t", -9223372036854775807L);
      long l1 = l2;
      if (l2 == -9223372036854775807L) {
        if (i != 0) {
          break label134;
        }
      }
      for (l1 = 0L;; l1 = ((Long)this.brD.get(i - 1)).longValue() + this.brE)
      {
        this.brD.add(Long.valueOf(l1));
        this.brE = c(paramXmlPullParser, "d", -9223372036854775807L);
        l2 = c(paramXmlPullParser, "r", 1L);
        i = j;
        if (l2 <= 1L) {
          break label188;
        }
        i = j;
        if (this.brE != -9223372036854775807L) {
          break label188;
        }
        paramXmlPullParser = new o("Repeated chunk with unspecified duration");
        AppMethodBeat.o(89999);
        throw paramXmlPullParser;
        label134:
        if (this.brE == -1L) {
          break;
        }
      }
      paramXmlPullParser = new o("Unable to infer start time");
      AppMethodBeat.o(89999);
      throw paramXmlPullParser;
      label188:
      while (i < l2)
      {
        this.brD.add(Long.valueOf(this.brE * i + l1));
        i += 1;
      }
      AppMethodBeat.o(89999);
      return;
    }
    String str = paramXmlPullParser.getAttributeValue(null, "Type");
    if (str != null) {
      if ("audio".equalsIgnoreCase(str))
      {
        i = 1;
        this.type = i;
        c("Type", Integer.valueOf(this.type));
        if (this.type != 3) {
          break label519;
        }
      }
    }
    label519:
    for (this.brr = d(paramXmlPullParser, "Subtype");; this.brr = paramXmlPullParser.getAttributeValue(null, "Subtype"))
    {
      this.name = paramXmlPullParser.getAttributeValue(null, "Name");
      this.url = d(paramXmlPullParser, "Url");
      this.maxWidth = e(paramXmlPullParser, "MaxWidth");
      this.maxHeight = e(paramXmlPullParser, "MaxHeight");
      this.aYQ = e(paramXmlPullParser, "DisplayWidth");
      this.aYR = e(paramXmlPullParser, "DisplayHeight");
      this.aSt = paramXmlPullParser.getAttributeValue(null, "Language");
      c("Language", this.aSt);
      this.bdm = e(paramXmlPullParser, "TimeScale");
      if (this.bdm == -1L) {
        this.bdm = ((Long)at("TimeScale")).longValue();
      }
      this.brD = new ArrayList();
      AppMethodBeat.o(89999);
      return;
      if ("video".equalsIgnoreCase(str))
      {
        i = 2;
        break;
      }
      if ("text".equalsIgnoreCase(str))
      {
        i = 3;
        break;
      }
      paramXmlPullParser = new o("Invalid key value[" + str + "]");
      AppMethodBeat.o(89999);
      throw paramXmlPullParser;
      paramXmlPullParser = new b.b("Type");
      AppMethodBeat.o(89999);
      throw paramXmlPullParser;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.google.android.exoplayer2.source.c.a.b.f
 * JD-Core Version:    0.7.0.1
 */