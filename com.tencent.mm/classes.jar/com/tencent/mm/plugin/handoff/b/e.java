package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOffMP;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffMPParser;", "Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "Lcom/tencent/mm/plugin/handoff/model/HandOffMP;", "()V", "newHandOff", "parseTag", "", "tag", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "api-handoff_release"})
public final class e
  extends f<HandOffMP>
{
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238083);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    super.a(paramString, paramXmlPullParser);
    AppMethodBeat.o(238083);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.e
 * JD-Core Version:    0.7.0.1
 */