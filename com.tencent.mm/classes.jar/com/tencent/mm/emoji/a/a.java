package com.tencent.mm.emoji.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.k;
import d.l;
import org.xmlpull.v1.XmlPullParser;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"})
public class a
{
  private static final String TAG = "MicroMsg.BaseXmlContent";
  public static final a fMz;
  
  static
  {
    AppMethodBeat.i(105500);
    fMz = new a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(105500);
  }
  
  protected static void a(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105497);
    k.h(paramXmlPullParser, "parser");
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
  
  protected static String k(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105495);
    k.h(paramXmlPullParser, "parser");
    k.h(paramString, "name");
    paramString = paramXmlPullParser.getAttributeValue(null, paramString);
    paramXmlPullParser = paramString;
    if (paramString == null) {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(105495);
    return paramXmlPullParser;
  }
  
  protected static int l(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105496);
    k.h(paramXmlPullParser, "parser");
    k.h(paramString, "name");
    paramXmlPullParser = k(paramXmlPullParser, paramString);
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
  
  protected static String o(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105493);
    k.h(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      k.g(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    AppMethodBeat.o(105493);
    return str;
  }
  
  protected static int p(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105494);
    k.h(paramXmlPullParser, "parser");
    paramXmlPullParser = o(paramXmlPullParser);
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
  
  protected void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105499);
    k.h(paramString, "tag");
    k.h(paramXmlPullParser, "parser");
    AppMethodBeat.o(105499);
  }
  
  public void q(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105498);
    k.h(paramXmlPullParser, "parser");
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
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "plugin-emojisdk_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a
 * JD-Core Version:    0.7.0.1
 */