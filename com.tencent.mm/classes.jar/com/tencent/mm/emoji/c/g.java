package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.d;
import com.tencent.mm.modelpackage.q;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EggGameParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "gameInfo", "Lcom/tencent/mm/modelpackage/EggGame;", "getGameInfo", "()Lcom/tencent/mm/modelpackage/EggGame;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class g
  extends a
{
  final d mhD;
  
  public g()
  {
    AppMethodBeat.i(242649);
    this.mhD = new d();
    AppMethodBeat.o(242649);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(242653);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
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
            AppMethodBeat.o(242653);
            return;
          } while (!paramString.equals("AppId"));
          this.mhD.appId = f(paramXmlPullParser);
          AppMethodBeat.o(242653);
          return;
        } while (!paramString.equals("AndroidURL"));
        this.mhD.oQn = f(paramXmlPullParser);
        AppMethodBeat.o(242653);
        return;
      } while (!paramString.equals("iOSURL"));
      this.mhD.oQm = f(paramXmlPullParser);
      AppMethodBeat.o(242653);
      return;
    } while (!paramString.equals("EntryAnimType"));
    paramString = new q();
    paramString.oQX = 1;
    int i = f(paramXmlPullParser, "size");
    paramString.oQY = i;
    paramString.maxSize = i;
    paramString.fileName = e(paramXmlPullParser, "fileName");
    paramString.oQU = g(paramXmlPullParser);
    this.mhD.oQo = paramString;
    AppMethodBeat.o(242653);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.c.g
 * JD-Core Version:    0.7.0.1
 */