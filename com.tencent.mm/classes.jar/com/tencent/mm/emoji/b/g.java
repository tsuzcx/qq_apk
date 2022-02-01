package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.be.d;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/EggGameParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "gameInfo", "Lcom/tencent/mm/modelpackage/EggGame;", "getGameInfo", "()Lcom/tencent/mm/modelpackage/EggGame;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class g
  extends a
{
  final d jHW;
  
  public g()
  {
    AppMethodBeat.i(229236);
    this.jHW = new d();
    AppMethodBeat.o(229236);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(229235);
    kotlin.g.b.p.k(paramString, "tag");
    kotlin.g.b.p.k(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          do
          {
            skip(paramXmlPullParser);
            AppMethodBeat.o(229235);
            return;
          } while (!paramString.equals("AppId"));
          this.jHW.appId = d(paramXmlPullParser);
          AppMethodBeat.o(229235);
          return;
        } while (!paramString.equals("AndroidURL"));
        this.jHW.lXl = d(paramXmlPullParser);
        AppMethodBeat.o(229235);
        return;
      } while (!paramString.equals("iOSURL"));
      this.jHW.lXk = d(paramXmlPullParser);
      AppMethodBeat.o(229235);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new com.tencent.mm.be.p();
    paramString.lXT = 1;
    int i = e(paramXmlPullParser, "size");
    paramString.lXU = i;
    paramString.maxSize = i;
    paramString.fileName = d(paramXmlPullParser, "fileName");
    paramString.lXQ = e(paramXmlPullParser);
    this.jHW.lXm = paramString;
    AppMethodBeat.o(229235);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.b.g
 * JD-Core Version:    0.7.0.1
 */