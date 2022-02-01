package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrLong", "", "readAttrString", "readInt", "readString", "skip", "Companion", "api-handoff_release"})
public class a
{
  public static final a.a DrM;
  private static final String TAG = "MicroMsg.BaseXmlContent";
  
  static
  {
    AppMethodBeat.i(192957);
    DrM = new a.a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(192957);
  }
  
  protected static String d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192922);
    p.k(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      p.j(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    if (str == null)
    {
      paramXmlPullParser = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(192922);
      throw paramXmlPullParser;
    }
    paramXmlPullParser = n.bb((CharSequence)str).toString();
    AppMethodBeat.o(192922);
    return paramXmlPullParser;
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(192931);
    p.k(paramXmlPullParser, "parser");
    p.k(paramString, "name");
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null)
    {
      if (paramXmlPullParser == null)
      {
        paramXmlPullParser = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(192931);
        throw paramXmlPullParser;
      }
      paramString = n.bb((CharSequence)paramXmlPullParser).toString();
      paramXmlPullParser = paramString;
      if (paramString != null) {}
    }
    else
    {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(192931);
    return paramXmlPullParser;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192925);
    p.k(paramXmlPullParser, "parser");
    paramXmlPullParser = d(paramXmlPullParser);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192925);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(192925);
    return i;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(192937);
    p.k(paramXmlPullParser, "parser");
    p.k(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192937);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(192937);
    return i;
  }
  
  protected static long f(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(192941);
    p.k(paramXmlPullParser, "parser");
    p.k(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(192941);
      return 0L;
    }
    long l = Long.parseLong(paramXmlPullParser);
    AppMethodBeat.o(192941);
    return l;
  }
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192951);
    p.k(paramString, "tag");
    p.k(paramXmlPullParser, "parser");
    AppMethodBeat.o(192951);
  }
  
  public void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192946);
    p.k(paramXmlPullParser, "parser");
    while ((paramXmlPullParser.next() != 3) && (paramXmlPullParser.getEventType() != 1)) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str != null) {
          a(str, paramXmlPullParser);
        }
      }
    }
    AppMethodBeat.o(192946);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */