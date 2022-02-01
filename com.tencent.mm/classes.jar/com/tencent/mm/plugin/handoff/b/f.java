package com.tencent.mm.plugin.handoff.b;

import com.tencent.mm.plugin.handoff.model.HandOff;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;
import org.xmlpull.v1.XmlPullParser;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/handoff/parser/HandOffParser;", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;", "Lcom/tencent/mm/plugin/handoff/parser/BaseXmlContent;", "Lcom/tencent/mm/plugin/handoff/parser/IHandOffParser;", "()V", "handOff", "getHandOff", "()Lcom/tencent/mm/plugin/handoff/model/HandOff;", "handOff$delegate", "Lkotlin/Lazy;", "newHandOff", "parse", "", "parser", "Lorg/xmlpull/v1/XmlPullParser;", "parseHandOff", "api-handoff_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f<T extends HandOff>
  extends a
  implements i
{
  private final j Jlu = k.cm((kotlin.g.a.a)new a(this));
  
  public final void e(XmlPullParser paramXmlPullParser)
  {
    s.u(paramXmlPullParser, "parser");
    String str = e(paramXmlPullParser, "id");
    long l = g(paramXmlPullParser, "createtime");
    fJO().setId(str);
    fJO().setCreateTime(l);
    super.e(paramXmlPullParser);
  }
  
  protected abstract T fJN();
  
  protected final T fJO()
  {
    return (HandOff)this.Jlu.getValue();
  }
  
  public final HandOff h(XmlPullParser paramXmlPullParser)
  {
    s.u(paramXmlPullParser, "parser");
    e(paramXmlPullParser);
    return fJO();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "T", "Lcom/tencent/mm/plugin/handoff/model/HandOff;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<T>
  {
    a(f<? extends T> paramf)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.handoff.b.f
 * JD-Core Version:    0.7.0.1
 */