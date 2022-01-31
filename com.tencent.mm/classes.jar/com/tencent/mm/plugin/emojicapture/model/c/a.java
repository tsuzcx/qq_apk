package com.tencent.mm.plugin.emojicapture.model.c;

import a.f.b.j;
import a.l;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;
import org.xmlpull.v1.XmlPullParser;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensConfig;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "itemList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/plugin/emojicapture/model/xml/EmoticonLensItem;", "getItemList", "()Ljava/util/LinkedList;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojicapture_release"})
public final class a
  extends com.tencent.mm.emoji.a.a
{
  public final LinkedList<c> euO;
  
  public a()
  {
    AppMethodBeat.i(2720);
    this.euO = new LinkedList();
    AppMethodBeat.o(2720);
  }
  
  public final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(2719);
    j.q(paramString, "tag");
    j.q(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          a(paramXmlPullParser);
          AppMethodBeat.o(2719);
          return;
        } while (!paramString.equals("EmoticonLensList"));
        AppMethodBeat.o(2719);
        return;
      } while (!paramString.equals("EmoticonLensItem"));
      paramString = new c();
      paramString.f(paramXmlPullParser);
      this.euO.add(paramString);
      ab.i(b.Ot(), String.valueOf(paramString));
      AppMethodBeat.o(2719);
      return;
    } while (!paramString.equals("EmoticonLensConfig"));
    AppMethodBeat.o(2719);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.c.a
 * JD-Core Version:    0.7.0.1
 */