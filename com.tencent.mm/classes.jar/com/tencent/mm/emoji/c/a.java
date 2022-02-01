package com.tencent.mm.emoji.c;

import android.util.Xml;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.vfs.y;
import java.io.InputStream;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/BaseXmlContent;", "", "()V", "ns", "", "getNs", "()Ljava/lang/String;", "next", "", "parse", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "readAttrInt", "", "name", "readAttrString", "readInt", "readString", "skip", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public class a
{
  private static final String TAG;
  public static final a mhz;
  
  static
  {
    AppMethodBeat.i(105500);
    mhz = new a((byte)0);
    TAG = "MicroMsg.BaseXmlContent";
    AppMethodBeat.o(105500);
  }
  
  protected static String e(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105495);
    s.u(paramXmlPullParser, "parser");
    s.u(paramString, "name");
    paramXmlPullParser = paramXmlPullParser.getAttributeValue(null, paramString);
    if (paramXmlPullParser == null)
    {
      AppMethodBeat.o(105495);
      return "";
    }
    AppMethodBeat.o(105495);
    return paramXmlPullParser;
  }
  
  protected static int f(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(105496);
    s.u(paramXmlPullParser, "parser");
    s.u(paramString, "name");
    paramXmlPullParser = e(paramXmlPullParser, paramString);
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
  
  protected static String f(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105493);
    s.u(paramXmlPullParser, "parser");
    String str = "";
    if (paramXmlPullParser.next() == 4)
    {
      str = paramXmlPullParser.getText();
      s.s(str, "parser.text");
      paramXmlPullParser.nextTag();
    }
    AppMethodBeat.o(105493);
    return str;
  }
  
  protected static int g(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105494);
    s.u(paramXmlPullParser, "parser");
    paramXmlPullParser = f(paramXmlPullParser);
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
  
  protected static void skip(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105497);
    s.u(paramXmlPullParser, "parser");
    if (paramXmlPullParser.getEventType() != 2)
    {
      paramXmlPullParser = new IllegalStateException();
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
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    AppMethodBeat.o(105499);
  }
  
  public void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(105498);
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
    AppMethodBeat.o(105498);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/BaseXmlContent$Companion;", "", "()V", "TAG", "", "safeParse", "", "filePath", "xmlContent", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(String paramString, a parama)
    {
      Object localObject = null;
      String str = null;
      AppMethodBeat.i(242657);
      s.u(paramString, "filePath");
      s.u(parama, "xmlContent");
      try
      {
        paramString = y.Lh(paramString);
        str = paramString;
        localObject = paramString;
        XmlPullParser localXmlPullParser = Xml.newPullParser();
        str = paramString;
        localObject = paramString;
        s.s(localXmlPullParser, "newPullParser()");
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
        parama.e(localXmlPullParser);
        if (paramString != null) {
          paramString.close();
        }
        AppMethodBeat.o(242657);
        return;
      }
      catch (Exception paramString)
      {
        localObject = str;
        Log.printErrStackTrace(a.access$getTAG$cp(), (Throwable)paramString, "safeParse error", new Object[0]);
        if (str != null) {
          str.close();
        }
        AppMethodBeat.o(242657);
        return;
      }
      finally
      {
        if (localObject != null) {
          ((InputStream)localObject).close();
        }
        AppMethodBeat.o(242657);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.a
 * JD-Core Version:    0.7.0.1
 */