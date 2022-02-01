package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;
import kotlin.t;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrLong", "", "readAttrString", "readInt", "readString", "skip", "Companion", "api-handoff_release"})
public class a
{
  private static final String TAG = "MicroMsg.BaseXmlContent";
  public static final a.a yhK;
  
  static
  {
    AppMethodBeat.i(238074);
    yhK = new a.a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(238074);
  }
  
  protected static String d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238067);
    p.h(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      p.g(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    if (str == null)
    {
      paramXmlPullParser = new t("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(238067);
      throw paramXmlPullParser;
    }
    paramXmlPullParser = n.trim((CharSequence)str).toString();
    AppMethodBeat.o(238067);
    return paramXmlPullParser;
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(238069);
    p.h(paramXmlPullParser, "parser");
    p.h(paramString, "name");
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser != null)
    {
      if (paramXmlPullParser == null)
      {
        paramXmlPullParser = new t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(238069);
        throw paramXmlPullParser;
      }
      paramString = n.trim((CharSequence)paramXmlPullParser).toString();
      paramXmlPullParser = paramString;
      if (paramString != null) {}
    }
    else
    {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(238069);
    return paramXmlPullParser;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238068);
    p.h(paramXmlPullParser, "parser");
    paramXmlPullParser = d(paramXmlPullParser);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238068);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(238068);
    return i;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(238070);
    p.h(paramXmlPullParser, "parser");
    p.h(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238070);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(238070);
    return i;
  }
  
  protected static long f(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(238071);
    p.h(paramXmlPullParser, "parser");
    p.h(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(238071);
      return 0L;
    }
    long l = Long.parseLong(paramXmlPullParser);
    AppMethodBeat.o(238071);
    return l;
  }
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238073);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    AppMethodBeat.o(238073);
  }
  
  public void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238072);
    p.h(paramXmlPullParser, "parser");
    while ((paramXmlPullParser.next() != 3) && (paramXmlPullParser.getEventType() != 1)) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str != null) {
          a(str, paramXmlPullParser);
        }
      }
    }
    AppMethodBeat.o(238072);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */