package com.google.android.exoplayer2.i;

import com.tencent.matrix.trace.core.AppMethodBeat;
import org.xmlpull.v1.XmlPullParser;

public final class y
{
  public static boolean b(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(93247);
    if ((c(paramXmlPullParser)) && (paramXmlPullParser.getName().equals(paramString)))
    {
      AppMethodBeat.o(93247);
      return true;
    }
    AppMethodBeat.o(93247);
    return false;
  }
  
  public static String c(XmlPullParser paramXmlPullParser, String paramString)
  {
    AppMethodBeat.i(93249);
    int j = paramXmlPullParser.getAttributeCount();
    int i = 0;
    while (i < j)
    {
      if (paramString.equals(paramXmlPullParser.getAttributeName(i)))
      {
        paramXmlPullParser = paramXmlPullParser.getAttributeValue(i);
        AppMethodBeat.o(93249);
        return paramXmlPullParser;
      }
      i += 1;
    }
    AppMethodBeat.o(93249);
    return null;
  }
  
  private static boolean c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(93248);
    if (paramXmlPullParser.getEventType() == 2)
    {
      AppMethodBeat.o(93248);
      return true;
    }
    AppMethodBeat.o(93248);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.google.android.exoplayer2.i.y
 * JD-Core Version:    0.7.0.1
 */