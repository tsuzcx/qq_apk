package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/parser/HandOffListParser;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "()V", "handOffList", "Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "getHandOffList", "()Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getItems", "()Ljava/util/List;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "api-handoff_release"})
public final class c
  extends a
{
  public final b DrN;
  private final List<HandOff> lxh;
  
  public c()
  {
    AppMethodBeat.i(192916);
    this.DrN = new b(0, null, 0L, 7);
    this.lxh = ((List)new ArrayList());
    AppMethodBeat.o(192916);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192912);
    p.k(paramString, "tag");
    p.k(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(192912);
          return;
        } while (!paramString.equals("handoff"));
        int i = e(paramXmlPullParser, "type");
        paramString = g.DrQ;
        paramString = g.Uj(i);
      } while (paramString == null);
      paramString = paramString.f(paramXmlPullParser);
    } while (paramString == null);
    this.lxh.add(paramString);
    AppMethodBeat.o(192912);
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(192910);
    p.k(paramXmlPullParser, "parser");
    this.DrN.fCN = e(paramXmlPullParser, "opcode");
    this.DrN.seq = f(paramXmlPullParser, "seq");
    super.c(paramXmlPullParser);
    paramXmlPullParser = this.DrN;
    Collection localCollection = (Collection)this.lxh;
    p.k(localCollection, "<set-?>");
    paramXmlPullParser.DrJ = localCollection;
    AppMethodBeat.o(192910);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */