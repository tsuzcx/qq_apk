package com.tencent.mm.emoji.a;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"})
public class a
{
  private static final String TAG = "MicroMsg.BaseXmlContent";
  public static final a.a ewm;
  
  static
  {
    AppMethodBeat.i(151768);
    ewm = new a.a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(151768);
  }
  
  protected static void a(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151765);
    j.q(paramXmlPullParser, "parser");
    if (paramXmlPullParser.getEventType() != 2)
    {
      paramXmlPullParser = (Throwable)new IllegalStateException();
      AppMethodBeat.o(151765);
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
    AppMethodBeat.o(151765);
  }
  
  protected static String d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151761);
    j.q(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      j.p(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    AppMethodBeat.o(151761);
    return str;
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(151763);
    j.q(paramXmlPullParser, "parser");
    j.q(paramString, "name");
    paramString = paramXmlPullParser.getAttributeValue(null, paramString);
    paramXmlPullParser = paramString;
    if (paramString == null) {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(151763);
    return paramXmlPullParser;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151762);
    j.q(paramXmlPullParser, "parser");
    paramXmlPullParser = d(paramXmlPullParser);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(151762);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(151762);
    return i;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(151764);
    j.q(paramXmlPullParser, "parser");
    j.q(paramString, "name");
    paramXmlPullParser = d(paramXmlPullParser, paramString);
    if (((CharSequence)paramXmlPullParser).length() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(151764);
      return 0;
    }
    i = Integer.parseInt(paramXmlPullParser);
    AppMethodBeat.o(151764);
    return i;
  }
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151767);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    AppMethodBeat.o(151767);
  }
  
  public void f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(151766);
    j.q(paramXmlPullParser, "parser");
    while (paramXmlPullParser.next() != 3) {
      if (paramXmlPullParser.getEventType() == 2)
      {
        String str = paramXmlPullParser.getName();
        if (str != null) {
          a(str, paramXmlPullParser);
        }
      }
    }
    AppMethodBeat.o(151766);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */