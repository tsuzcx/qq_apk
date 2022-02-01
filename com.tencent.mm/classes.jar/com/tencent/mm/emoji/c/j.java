package com.tencent.mm.emoji.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelpackage.h;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/EggMiniAppParser;", "Lcom/tencent/mm/emoji/model/BaseXmlContent;", "()V", "miniAppInfo", "Lcom/tencent/mm/modelpackage/EggMiniApp;", "getMiniAppInfo", "()Lcom/tencent/mm/modelpackage/EggMiniApp;", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
  extends a
{
  final h mhJ;
  
  public j()
  {
    AppMethodBeat.i(242641);
    this.mhJ = new h();
    AppMethodBeat.o(242641);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(242645);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    if (s.p(paramString, "AppId"))
    {
      this.mhJ.appId = f(paramXmlPullParser);
      AppMethodBeat.o(242645);
      return;
    }
    if (s.p(paramString, "UserName"))
    {
      this.mhJ.userName = f(paramXmlPullParser);
      AppMethodBeat.o(242645);
      return;
    }
    skip(paramXmlPullParser);
    AppMethodBeat.o(242645);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.emoji.c.j
 * JD-Core Version:    0.7.0.1
 */