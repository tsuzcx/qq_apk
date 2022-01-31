package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/MultiLangString;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "scene", "", "getScene", "()I", "setScene", "(I)V", "textCn", "", "getTextCn", "()Ljava/lang/String;", "setTextCn", "(Ljava/lang/String;)V", "textEn", "getTextEn", "setTextEn", "textHk", "getTextHk", "setTextHk", "textTw", "getTextTw", "setTextTw", "get", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "toString", "plugin-emojicapture_release"})
public final class d
  extends a
{
  private String lvA = "";
  private String lvx = "";
  private String lvy = "";
  private String lvz = "";
  private int scene;
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2724);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      for (;;)
      {
        AppMethodBeat.o(2724);
        return;
        if (paramString.equals("zh_TW"))
        {
          this.lvy = d(paramXmlPullParser);
          AppMethodBeat.o(2724);
          return;
          if (paramString.equals("zh_HK"))
          {
            this.lvz = d(paramXmlPullParser);
            AppMethodBeat.o(2724);
            return;
            if (paramString.equals("EmoticonLensScenes"))
            {
              this.scene = e(paramXmlPullParser);
              AppMethodBeat.o(2724);
              return;
              if (paramString.equals("en")) {
                this.lvA = d(paramXmlPullParser);
              }
            }
          }
        }
      }
    } while (!paramString.equals("zh_CN"));
    this.lvx = d(paramXmlPullParser);
    AppMethodBeat.o(2724);
  }
  
  public final String toString()
  {
    AppMethodBeat.i(2725);
    String str = "MultiLangString(textCn='" + this.lvx + "', textTw='" + this.lvy + "', textHk='" + this.lvz + "', textEn='" + this.lvA + "')";
    AppMethodBeat.o(2725);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.d
 * JD-Core Version:    0.7.0.1
 */