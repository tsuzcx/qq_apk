package com.tencent.mm.plugin.handoff.b;

import com.tencent.mm.plugin.handoff.model.HandOff;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import org.xmlpull.v1.XmlPullParser;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "()V", "handOff", "getHandOff", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;", "handOff$delegate", "Lkotlin/Lazy;", "newHandOff", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseHandOff", "api-handoff_release"})
public abstract class f<T extends HandOff>
  extends a
  implements i
{
  private final kotlin.f yhM = g.ah((kotlin.g.a.a)new a(this));
  
  public final void c(XmlPullParser paramXmlPullParser)
  {
    p.h(paramXmlPullParser, "parser");
    String str = d(paramXmlPullParser, "id");
    long l = f(paramXmlPullParser, "createtime");
    dYo().setId(str);
    dYo().setCreateTime(l);
    super.c(paramXmlPullParser);
  }
  
  protected abstract T dYn();
  
  protected final T dYo()
  {
    return (HandOff)this.yhM.getValue();
  }
  
  public final HandOff f(XmlPullParser paramXmlPullParser)
  {
    p.h(paramXmlPullParser, "parser");
    c(paramXmlPullParser);
    return dYo();
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "invoke", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.f
 * JD-Core Version:    0.7.0.1
 */