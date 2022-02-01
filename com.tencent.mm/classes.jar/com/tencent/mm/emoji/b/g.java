package com.tencent.mm.emoji.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bb.d;
import com.tencent.mm.bb.o;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/EggGameParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "gameInfo", "Lcom/tencent/mm/modelpackage/EggGame;", "getGameInfo", "()Lcom/tencent/mm/modelpackage/EggGame;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"})
public final class g
  extends a
{
  final d gWY;
  
  public g()
  {
    AppMethodBeat.i(199912);
    this.gWY = new d();
    AppMethodBeat.o(199912);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(199911);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(199911);
      return;
      if (paramString.equals("AppId"))
      {
        this.gWY.appId = d(paramXmlPullParser);
        AppMethodBeat.o(199911);
        return;
        if (paramString.equals("AndroidURL"))
        {
          this.gWY.jgI = d(paramXmlPullParser);
          AppMethodBeat.o(199911);
          return;
          if (paramString.equals("iOSURL"))
          {
            this.gWY.jgH = d(paramXmlPullParser);
            AppMethodBeat.o(199911);
            return;
            if (paramString.equals("EntryAnimType"))
            {
              paramString = new o();
              paramString.jhq = 1;
              int i = e(paramXmlPullParser, "size");
              paramString.jhr = i;
              paramString.maxSize = i;
              paramString.fileName = d(paramXmlPullParser, "fileName");
              paramString.jhn = e(paramXmlPullParser);
              this.gWY.jgJ = paramString;
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.emoji.b.g
 * JD-Core Version:    0.7.0.1
 */