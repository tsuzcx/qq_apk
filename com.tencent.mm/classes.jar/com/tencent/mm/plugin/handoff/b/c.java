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

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffListParser;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "()V", "handOffList", "Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "getHandOffList", "()Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getItems", "()Ljava/util/List;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "api-handoff_release"})
public final class c
  extends a
{
  private final List<HandOff> iHf;
  public final b yhL;
  
  public c()
  {
    AppMethodBeat.i(238079);
    this.yhL = new b(0, null, 0L, 7);
    this.iHf = ((List)new ArrayList());
    AppMethodBeat.o(238079);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238078);
    p.h(paramString, "tag");
    p.h(paramXmlPullParser, "parser");
    switch (paramString.hashCode())
    {
    }
    do
    {
      do
      {
        do
        {
          AppMethodBeat.o(238078);
          return;
        } while (!paramString.equals("handoff"));
        int i = e(paramXmlPullParser, "type");
        paramString = g.yhO;
        paramString = g.OJ(i);
      } while (paramString == null);
      paramString = paramString.f(paramXmlPullParser);
    } while (paramString == null);
    this.iHf.add(paramString);
    AppMethodBeat.o(238078);
  }
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(238077);
    p.h(paramXmlPullParser, "parser");
    this.yhL.dJY = e(paramXmlPullParser, "opcode");
    this.yhL.seq = f(paramXmlPullParser, "seq");
    super.c(paramXmlPullParser);
    paramXmlPullParser = this.yhL;
    Collection localCollection = (Collection)this.iHf;
    p.h(localCollection, "<set-?>");
    paramXmlPullParser.yhH = localCollection;
    AppMethodBeat.o(238077);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */