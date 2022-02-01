package com.tencent.mm.plugin.handoff.b;

import com.tencent.mm.plugin.handoff.model.HandOff;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "()V", "handOff", "getHandOff", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;", "handOff$delegate", "Lkotlin/Lazy;", "newHandOff", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseHandOff", "api-handoff_release"})
public abstract class f<T extends HandOff>
  extends a
  implements i
{
  private final kotlin.f DrO = g.ar((kotlin.g.a.a)new a(this));
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    p.k(paramXmlPullParser, "parser");
    String str = d(paramXmlPullParser, "id");
    long l = f(paramXmlPullParser, "createtime");
    eBM().setId(str);
    eBM().setCreateTime(l);
    super.c(paramXmlPullParser);
  }
  
  protected abstract T eBL();
  
  protected final T eBM()
  {
    return (HandOff)this.DrO.getValue();
  }
  
  public final HandOff f(XmlPullParser paramXmlPullParser)
  {
    p.k(paramXmlPullParser, "parser");
    c(paramXmlPullParser);
    return eBM();
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "invoke", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;"})
  static final class a
    extends q
    implements kotlin.g.a.a<T>
  {
    a(f paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.f
 * JD-Core Version:    0.7.0.1
 */