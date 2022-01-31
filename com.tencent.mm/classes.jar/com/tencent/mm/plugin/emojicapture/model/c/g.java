package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.emoji.a.a;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/ResourceCompressItem;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "fromPath", "", "getFromPath", "()Ljava/lang/String;", "setFromPath", "(Ljava/lang/String;)V", "toPath", "getToPath", "setToPath", "parseTag", "", "tag", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class g
  extends a
{
  public String lvC = "";
  public String lvD = "";
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2731);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        a(paramXmlPullParser);
        AppMethodBeat.o(2731);
        return;
      } while (!paramString.equals("CopyFromImagePath"));
      this.lvC = d(paramXmlPullParser);
      AppMethodBeat.o(2731);
      return;
    } while (!paramString.equals("CopyToImagePath"));
    this.lvD = d(paramXmlPullParser);
    AppMethodBeat.o(2731);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.g
 * JD-Core Version:    0.7.0.1
 */