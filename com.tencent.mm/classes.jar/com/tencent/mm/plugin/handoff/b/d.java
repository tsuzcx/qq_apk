package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffMG;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffMGParser;", "Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMG;", "()V", "newHandOff", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"})
public final class d
  extends f<HandOffMG>
{
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238081);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    super.a(paramString, paramXmlPullParser);
    AppMethodBeat.o(238081);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.d
 * JD-Core Version:    0.7.0.1
 */