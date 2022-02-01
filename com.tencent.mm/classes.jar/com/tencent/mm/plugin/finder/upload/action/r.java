package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.cp.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.ak;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "wordingItem", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "op", "", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;I)V", "feedId", "", "getFeedId", "()J", "getOp", "()I", "getWordingItem", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "doOpWording", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "", "uniqueId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class r
  extends e
{
  public static final a GdE;
  public final n GdD;
  public final long feedId;
  public final int op;
  
  static
  {
    AppMethodBeat.i(343418);
    GdE = new a((byte)0);
    AppMethodBeat.o(343418);
  }
  
  public r(n paramn)
  {
    super(null);
    AppMethodBeat.i(343401);
    this.GdD = paramn;
    this.op = 1;
    this.feedId = this.GdD.feedId;
    AppMethodBeat.o(343401);
  }
  
  private static final Object a(r paramr, m.b paramb, b.a parama)
  {
    AppMethodBeat.i(343413);
    s.u(paramr, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.WordingOpAction", "doOpWording callback op = " + paramr.op + ' ' + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    if ((parama.errType == 0) && (parama.errCode == 0))
    {
      parama = o.Gds;
      o.fel().a(paramr);
      paramb.a(i.nrG, false);
      paramb = new if();
      paramb.hJB.id = paramr.GdD.feedId;
      paramb.hJB.hJI = paramr.GdD.YZe;
      paramb.hJB.type = 26;
      boolean bool = paramb.publish();
      AppMethodBeat.o(343413);
      return Boolean.valueOf(bool);
    }
    if (parama.errType == 4)
    {
      parama = o.Gds;
      o.fel().a(paramr);
      parama = new if();
      parama.hJB.id = paramr.GdD.feedId;
      parama.hJB.hJI = paramr.GdD.YZe;
      parama.hJB.type = 26;
      parama.publish();
      paramb.a(i.nrH, false);
    }
    for (;;)
    {
      paramr = ah.aiuX;
      AppMethodBeat.o(343413);
      return paramr;
      paramb.a(i.nrH, true);
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(343444);
    s.u(paramb, "callback");
    super.a(paramb);
    new ak(this).bFJ().g(new r..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(343444);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343438);
    String str = "id_" + this.feedId + '_' + this.GdD;
    AppMethodBeat.o(343438);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343433);
    String str = "action_" + this.feedId + '_' + this.GdD.YZe + '_' + this.Gae;
    AppMethodBeat.o(343433);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingOpAction$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.r
 * JD-Core Version:    0.7.0.1
 */