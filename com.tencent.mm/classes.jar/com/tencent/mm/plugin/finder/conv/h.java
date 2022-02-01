package com.tencent.mm.plugin.finder.conv;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.plugin.finder.storage.g;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.by;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater;", "Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "Lcom/tencent/mm/plugin/finder/conv/FinderConversation;", "()V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "storage", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "getStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;", "storage$delegate", "afterConvUpdate", "", "conv", "insertCount", "", "latestMsg", "Lcom/tencent/mm/storage/MsgInfo;", "beforeConvUpdate", "conversation", "notifyInfo", "Lcom/tencent/mm/plugin/messenger/foundation/api/storage/IMsgInfoStorage$NotifyInfo;", "checkInsertAliasHoder", "checkInsertHolder", "checkInsertHolderInternal", "getConversation", "sessionId", "", "getSessionInfo", "onConversationMsgEmpty", "saveConversationAndNotify", "support", "", "updateConversation", "sessionInfo", "lastMsgInfo", "digestData", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgConvUpdater$DigestData;", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class h
  extends com.tencent.mm.plugin.byp.c.a<o, b>
{
  public static final a AFT;
  private final j AFU;
  private final j sZg;
  
  static
  {
    AppMethodBeat.i(336087);
    AFT = new a((byte)0);
    AppMethodBeat.o(336087);
  }
  
  public h()
  {
    AppMethodBeat.i(336020);
    this.AFU = k.cm((kotlin.g.a.a)c.AFW);
    this.sZg = k.cm((kotlin.g.a.a)d.AFX);
    AppMethodBeat.o(336020);
  }
  
  private b avi(String paramString)
  {
    AppMethodBeat.i(336069);
    s.u(paramString, "sessionId");
    paramString = dWR().aAz(paramString);
    AppMethodBeat.o(336069);
    return paramString;
  }
  
  private final void dWP()
  {
    AppMethodBeat.i(336031);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add("finderaliassessionholder");
    ah localah = ah.aiuX;
    ((by)localObject1).cv((LinkedList)localObject2);
    localObject1 = dWR().aAz("finderaliassessionholder");
    if (((b)localObject1).systemRowid < 0L)
    {
      localObject2 = new b();
      ((b)localObject2).field_sessionId = "finderaliassessionholder";
      ((b)localObject2).field_talker = "finderaliassessionholder";
      ((b)localObject2).field_type = 200;
      ((b)localObject2).field_scene = 1;
      ((b)localObject2).field_unReadCount = dWR().im(2, 3);
      dWR().insert((IAutoDBItem)localObject2);
    }
    Log.i("Finder.ConversationUpdater", s.X("[checkInsertHolder] ", com.tencent.mm.plugin.finder.storage.h.a((b)localObject1)));
    AppMethodBeat.o(336031);
  }
  
  private final void dWQ()
  {
    AppMethodBeat.i(336042);
    Object localObject1 = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzG();
    Object localObject2 = new LinkedList();
    ((LinkedList)localObject2).add("findersessionholder");
    ah localah = ah.aiuX;
    ((by)localObject1).cv((LinkedList)localObject2);
    localObject1 = dWR().aAz("findersayhisessionholder");
    if (((b)localObject1).systemRowid < 0L)
    {
      localObject2 = new b();
      ((b)localObject2).field_sessionId = "findersayhisessionholder";
      ((b)localObject2).field_talker = "findersayhisessionholder";
      ((b)localObject2).field_placedFlag = 1000L;
      ((b)localObject2).field_type = 100;
      ((b)localObject2).field_scene = 2;
      ((b)localObject2).field_unReadCount = dWR().im(2, 1);
      dWR().insert((IAutoDBItem)localObject2);
    }
    Log.i("Finder.ConversationUpdater", s.X("[checkInsertHolder] ", com.tencent.mm.plugin.finder.storage.h.a((b)localObject1)));
    AppMethodBeat.o(336042);
  }
  
  private final g dWR()
  {
    AppMethodBeat.i(336064);
    g localg = (g)this.sZg.getValue();
    AppMethodBeat.o(336064);
    return localg;
  }
  
  private final ak getSessionInfoStorage()
  {
    AppMethodBeat.i(336052);
    ak localak = (ak)this.AFU.getValue();
    AppMethodBeat.o(336052);
    return localak;
  }
  
  public final boolean akf(String paramString)
  {
    AppMethodBeat.i(336099);
    s.u(paramString, "sessionId");
    boolean bool = au.aAy(paramString);
    AppMethodBeat.o(336099);
    return bool;
  }
  
  public final void aki(String paramString)
  {
    AppMethodBeat.i(336106);
    s.u(paramString, "sessionId");
    paramString = avi(paramString);
    Log.i("Finder.ConversationUpdater", s.X("[onConversationMsgEmpty] ", Long.valueOf(paramString.systemRowid)));
    if (paramString.systemRowid > 0L)
    {
      paramString.field_digest = "";
      dWR().update(paramString.systemRowid, (IAutoDBItem)paramString, false);
      dWR().doNotify(paramString.field_sessionId, 1, paramString);
    }
    AppMethodBeat.o(336106);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/conv/FinderConversationUpdater$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ah>
  {
    b(h paramh)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ak>
  {
    public static final c AFW;
    
    static
    {
      AppMethodBeat.i(336157);
      AFW = new c();
      AppMethodBeat.o(336157);
    }
    
    c()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderConversationStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<g>
  {
    public static final d AFX;
    
    static
    {
      AppMethodBeat.i(336159);
      AFX = new d();
      AppMethodBeat.o(336159);
    }
    
    d()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.conv.h
 * JD-Core Version:    0.7.0.1
 */