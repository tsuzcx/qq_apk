package com.tencent.mm.bw;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.api.j;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/processor/FinderLiveNoticeMsgItemProcessor;", "Lcom/tencent/mm/processor/BaseFunctionMsgItemProcessor;", "()V", "INTERVAL", "", "TAG", "", "itemList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lcom/tencent/mm/api/FunctionMsgItem;", "Lcom/tencent/mm/processor/OnNetSceneBackListener;", "Lkotlin/collections/ArrayList;", "fetchInternal", "", "item", "plugin-functionmsg_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  extends a
{
  private final long INTERVAL;
  final String TAG;
  final ArrayList<r<j, e>> mfy;
  
  public b()
  {
    AppMethodBeat.i(236127);
    this.TAG = "FinderLiveNoticeMsgItemProcessor";
    this.INTERVAL = 1000L;
    this.mfy = new ArrayList();
    AppMethodBeat.o(236127);
  }
  
  public final void k(r<? extends j, ? extends e> paramr)
  {
    AppMethodBeat.i(236136);
    s.u(paramr, "item");
    synchronized (this.mfy)
    {
      Log.d(this.TAG, "add item: cmdid = " + ((j)paramr.bsC).field_cmdid + ", funcId = " + ((j)paramr.bsC).field_functionmsgid);
      if (this.mfy.isEmpty())
      {
        Log.d(this.TAG, "start timer");
        d.a(this.TAG, false, (kotlin.g.a.a)new a(this), this.INTERVAL);
      }
      this.mfy.add(paramr);
      AppMethodBeat.o(236136);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(b paramb)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.bw.b
 * JD-Core Version:    0.7.0.1
 */