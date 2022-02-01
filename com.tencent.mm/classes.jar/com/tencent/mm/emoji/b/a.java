package com.tencent.mm.emoji.b;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.u;
import java.io.InputStream;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"})
public class a
{
  private static final String TAG = "MicroMsg.BaseXmlContent";
  public static final a jHS;
  
  static
  {
    AppMethodBeat.i(105500);
    jHS = new a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(105500);
  }
  
  protected static String d(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105493);
    p.k(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      p.j(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    AppMethodBeat.o(105493);
    return str;
  }
  
  protected static String d(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105495);
    p.k(paramXmlPullParser, "parser");
    p.k(paramString, "name");
    paramString = paramXmlPullParser.getAttributeValue(null, paramString);
    paramXmlPullParser = paramString;
    if (paramString == null) {
      paramXmlPullParser = "";
    }
    AppMethodBeat.o(105495);
    return paramXmlPullParser;
  }
  
  protected static int e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105494);
    p.k(paramXmlPullParser, "parser");
    paramXmlPullParser = d(paramXmlPullParser);
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
  
  protected static int e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105496);
    p.k(paramXmlPullParser, "parser");
    p.k(paramString, "name");
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
    p.k(paramXmlPullParser, "parser");
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
    p.k(paramString, "tag");
    p.k(paramXmlPullParser, "parser");
    AppMethodBeat.o(105499);
  }
  
  public void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105498);
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
    AppMethodBeat.o(105498);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "plugin-emojisdk_release"})
  public static final class a
  {
    public static void a(String paramString, a parama)
    {
      Object localObject = null;
      String str = null;
      AppMethodBeat.i(227727);
      p.k(paramString, "filePath");
      p.k(parama, "xmlContent");
      try
      {
        paramString = u.Tf(paramString);
        str = paramString;
        localObject = paramString;
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        str = paramString;
        localObject = paramString;
        p.j(localXmlPullParser, "Xml.newPullParser()");
        str = paramString;
        localObject = paramString;
        localXmlPullParser.setFeature("http://xmlpull.org/v1/doc/features.html#process-namespaces", false);
        str = paramString;
        localObject = paramString;
        localXmlPullParser.setInput(paramString, null);
        str = paramString;
        localObject = paramString;
        localXmlPullParser.nextTag();
        str = paramString;
        localObject = paramString;
        parama.c(localXmlPullParser);
        if (paramString != null)
        {
          paramString.close();
          AppMethodBeat.o(227727);
          return;
        }
        AppMethodBeat.o(227727);
        return;
      }
      catch (Exception paramString)
      {
        localObject = str;
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "safeParse error", new Object[0]);
        if (str != null)
        {
          str.close();
          AppMethodBeat.o(227727);
          return;
        }
        AppMethodBeat.o(227727);
        return;
      }
      finally
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        AppMethodBeat.o(227727);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.a
 * JD-Core Version:    0.7.0.1
 */