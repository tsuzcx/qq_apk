package com.tencent.mm.plugin.handoff.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.handoff.model.HandOff;
import com.tencent.mm.plugin.handoff.model.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/HandOffListParser;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "()V", "handOffList", "Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "getHandOffList", "()Lcom/tencent/mm/plugin/handoff/model/HandOffList;", "items", "", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "getItems", "()Ljava/util/List;", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseTag", "tag", "", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends a
{
  public final b Jlt;
  private final List<HandOff> bMQ;
  
  public c()
  {
    AppMethodBeat.i(266234);
    this.Jlt = new b(0, null, 0L, 7);
    this.bMQ = ((List)new ArrayList());
    AppMethodBeat.o(266234);
  }
  
  protected final void a(String paramString, XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266251);
    s.u(paramString, "tag");
    s.u(paramXmlPullParser, "parser");
    if (s.p(paramString, "handoff"))
    {
      int i = f(paramXmlPullParser, "type");
      paramString = g.Jlw;
      paramString = g.Yf(i);
      if (paramString != null)
      {
        paramString = paramString.h(paramXmlPullParser);
        this.bMQ.add(paramString);
      }
    }
    AppMethodBeat.o(266251);
  }
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    AppMethodBeat.i(266244);
    s.u(paramXmlPullParser, "parser");
    this.Jlt.hHC = f(paramXmlPullParser, "opcode");
    this.Jlt.seq = g(paramXmlPullParser, "seq");
    super.e(paramXmlPullParser);
    paramXmlPullParser = this.Jlt;
    Collection localCollection = (Collection)this.bMQ;
    s.u(localCollection, "<set-?>");
    paramXmlPullParser.Jlr = localCollection;
    AppMethodBeat.o(266244);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.c
 * JD-Core Version:    0.7.0.1
 */