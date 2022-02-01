package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.autogen.a.if;
import com.tencent.mm.autogen.a.if.a;
import com.tencent.mm.cp.f;
import com.tencent.mm.loader.f.i;
import com.tencent.mm.plugin.finder.cgi.ab;
import com.tencent.mm.plugin.finder.feed.model.n;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction;", "Lcom/tencent/mm/plugin/finder/upload/action/FinderAction;", "wordingItem", "Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "like", "", "(Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;Z)V", "feedId", "", "getFeedId", "()J", "getLike", "()Z", "getWordingItem", "()Lcom/tencent/mm/plugin/finder/feed/model/FinderWordingItem;", "doLikeWording", "", "callback", "Lcom/tencent/mm/plugin/finder/upload/action/LikeActionTask$ICallback;", "doSomething", "toString", "", "uniqueId", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class q
  extends e
{
  public static final a GdC;
  public final boolean GaB;
  public final n GdD;
  public final long feedId;
  
  static
  {
    AppMethodBeat.i(343415);
    GdC = new a((byte)0);
    AppMethodBeat.o(343415);
  }
  
  public q(n paramn, boolean paramBoolean)
  {
    super(null);
    AppMethodBeat.i(343394);
    this.GdD = paramn;
    this.GaB = paramBoolean;
    this.feedId = this.GdD.feedId;
    AppMethodBeat.o(343394);
  }
  
  private static final ah a(q paramq, m.b paramb, b.a parama)
  {
    int j = 1;
    AppMethodBeat.i(343406);
    s.u(paramq, "this$0");
    s.u(paramb, "$callback");
    Log.i("Finder.WordingLikeAction", "doLikeWording callback " + parama.errType + ' ' + parama.errCode + ' ' + parama.errMsg);
    long l;
    int i;
    if ((parama.errType == 0) && (parama.errCode == 0)) {
      if (paramq.GaB)
      {
        parama = paramq.GdD;
        l = paramq.GdD.YZf;
        if (paramq.GdD.hJr == 1)
        {
          i = 0;
          parama.YZf = (l + i);
          parama = paramq.GdD;
          if (!paramq.GaB) {
            break label305;
          }
          i = 1;
          label139:
          parama.hJr = i;
          parama = new if();
          parama.hJB.id = paramq.GdD.feedId;
          parama.hJB.hJF = 1;
          parama.hJB.hJI = paramq.GdD.YZe;
          if.a locala = parama.hJB;
          if (!paramq.GaB) {
            break label310;
          }
          i = j;
          label204:
          locala.hJE = i;
          parama.hJB.type = 25;
          parama.publish();
          parama = o.Gds;
          o.fel().a(paramq);
          paramb.a(i.nrG, false);
        }
      }
    }
    for (;;)
    {
      paramq = ah.aiuX;
      AppMethodBeat.o(343406);
      return paramq;
      i = 1;
      break;
      parama = paramq.GdD;
      l = paramq.GdD.YZf;
      if (paramq.GdD.hJr == 1) {}
      for (i = -1;; i = 0)
      {
        parama.YZf = (l + i);
        break;
      }
      label305:
      i = 2;
      break label139;
      label310:
      i = 2;
      break label204;
      if (parama.errType == 4)
      {
        parama = o.Gds;
        o.fel().a(paramq);
        parama = new if();
        parama.hJB.id = paramq.GdD.feedId;
        parama.hJB.hJI = paramq.GdD.YZe;
        parama.hJB.type = 25;
        parama.publish();
        paramb.a(i.nrH, false);
      }
      else
      {
        paramb.a(i.nrH, true);
      }
    }
  }
  
  public final void a(m.b paramb)
  {
    AppMethodBeat.i(343442);
    s.u(paramb, "callback");
    super.a(paramb);
    new ab(this).bFJ().g(new q..ExternalSyntheticLambda0(this, paramb));
    AppMethodBeat.o(343442);
  }
  
  public final String aUE()
  {
    AppMethodBeat.i(343436);
    String str = "id_" + this.feedId + '_' + this.GdD;
    AppMethodBeat.o(343436);
    return str;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343430);
    String str = "action_" + this.feedId + '_' + this.GdD.YZe + '_' + this.GaB + '_' + this.Gae;
    AppMethodBeat.o(343430);
    return str;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/WordingLikeAction$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.q
 * JD-Core Version:    0.7.0.1
 */