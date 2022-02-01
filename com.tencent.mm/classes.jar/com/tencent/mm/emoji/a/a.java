package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"})
public class a
{
  private static final String TAG = "MicroMsg.BaseXmlContent";
  public static final a.a gjL;
  
  static
  {
    AppMethodBeat.i(105500);
    gjL = new a.a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(105500);
  }
  
  protected static String c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105493);
    p.h(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      p.g(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    AppMethodBeat.o(105493);
    return str;
  }
  
  protected static int d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105494);
    p.h(paramXmlPullParser, "parser");
    paramXmlPullParser = c(paramXmlPullParser);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105494);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(105494);
    return i;
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105495);
    p.h(paramXmlPullParser, "parser");
    p.h(paramString, "name");
    paramString = paramXmlPullParser.getAttributeValue(null, paramString);
    paramXmlPullParser = paramString;
    if (paramString == null) {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(105495);
    return paramXmlPullParser;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105496);
    p.h(paramXmlPullParser, "parser");
    p.h(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(105496);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(105496);
    return i;
  }
  
  protected static void skip(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105497);
    p.h(paramXmlPullParser, "parser");
    if (paramXmlPullParser.getEventType() != 2)
    {
      paramXmlPullParser = (Throwable)new IllegalStateException();
      AppMethodBeat.o(105497);
      throw paramXmlPullParser;
    }
    int i = 1;
    while (i != 0) {
      switch (paramXmlPullParser.next())
      {
      default: 
        break;
      case 2: 
        i += 1;
        break;
      case 3: 
        i -= 1;
      }
    }
    AppMethodBeat.o(105497);
  }
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105499);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    AppMethodBeat.o(105499);
  }
  
  public void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105498);
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
    AppMethodBeat.o(105498);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */