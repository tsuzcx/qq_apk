package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.StringReader;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;

final class a
{
  public static BindWordingContent GM(String paramString)
  {
    AppMethodBeat.i(134148);
    BindWordingContent localBindWordingContent = new BindWordingContent("", "");
    Object localObject = XmlPullParserFactory.newInstance();
    ((XmlPullParserFactory)localObject).setNamespaceAware(true);
    XmlPullParser localXmlPullParser = ((XmlPullParserFactory)localObject).newPullParser();
    localXmlPullParser.setInput(new StringReader(paramString));
    int i = localXmlPullParser.getEventType();
    paramString = "";
    if (i != 1)
    {
      localObject = paramString;
      switch (i)
      {
      default: 
        localObject = paramString;
      }
      for (;;)
      {
        i = localXmlPullParser.next();
        paramString = (String)localObject;
        break;
        localObject = localXmlPullParser.getName();
        continue;
        String str2 = localXmlPullParser.getText();
        localObject = paramString;
        if (str2 != null)
        {
          localObject = paramString;
          if (str2.trim().length() > 0)
          {
            str2 = str2.trim();
            if (paramString.equalsIgnoreCase("title"))
            {
              localBindWordingContent.title = str2;
              localObject = paramString;
            }
            else if (paramString.equalsIgnoreCase("text"))
            {
              localBindWordingContent.content = str2;
              localObject = paramString;
            }
            else
            {
              localObject = paramString;
              if (paramString.equalsIgnoreCase("type")) {
                try
                {
                  localBindWordingContent.inO = Integer.valueOf(str2);
                  localObject = paramString;
                }
                catch (Exception localException)
                {
                  localBindWordingContent.inO = Integer.valueOf(0);
                  String str1 = paramString;
                }
              }
            }
          }
        }
      }
    }
    AppMethodBeat.o(134148);
    return localBindWordingContent;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.modelsimple.a
 * JD-Core Version:    0.7.0.1
 */