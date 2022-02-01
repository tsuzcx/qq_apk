package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrLong", "", "readAttrString", "readInt", "readString", "skip", "Companion", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  public static final a.a Jls;
  private static final String TAG;
  
  static
  {
    AppMethodBeat.i(266272);
    Jls = new a.a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(266272);
  }
  
  protected static String e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(266264);
    s.u(paramXmlPullParser, "parser");
    s.u(paramString, "name");
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(266264);
      return "";
    }
    paramXmlPullParser = n.bq((CharSequence)paramXmlPullParser).toString();
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(266264);
      return "";
    }
    AppMethodBeat.o(266264);
    return paramXmlPullParser;
  }
  
  protected static int f(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(266266);
    s.u(paramXmlPullParser, "parser");
    s.u(paramString, "name");
    paramXmlPullParser = e(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266266);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(266266);
    return i;
  }
  
  protected static String f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266258);
    s.u(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      s.s(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    paramXmlPullParser = n.bq((CharSequence)str).toString();
    AppMethodBeat.o(266258);
    return paramXmlPullParser;
  }
  
  protected static int g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266260);
    s.u(paramXmlPullParser, "parser");
    paramXmlPullParser = f(paramXmlPullParser);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266260);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(266260);
    return i;
  }
  
  protected static long g(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(266269);
    s.u(paramXmlPullParser, "parser");
    s.u(paramString, "name");
    paramXmlPullParser = e(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(266269);
      return 0L;
    }
    long l = Long.parseLong(paramXmlPullParser);
    AppMethodBeat.o(266269);
    return l;
  }
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266279);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    AppMethodBeat.o(266279);
  }
  
  public void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266275);
    s.u(paramXmlPullParser, "parser");
    while ((paramXmlPullParser.next() != 3) && (paramXmlPullParser.getEventType() != 1)) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str != null) {
          a(str, paramXmlPullParser);
        }
      }
    }
    AppMethodBeat.o(266275);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.a
 * JD-Core Version:    0.7.0.1
 */