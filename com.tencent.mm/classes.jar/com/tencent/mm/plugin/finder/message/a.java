package com.tencent.mm.plugin.finder.message;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.e.a;
import com.tencent.mm.model.z;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.finder.conv.o;
import com.tencent.mm.plugin.finder.storage.ak;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.storage.au;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder;", "Lcom/tencent/mm/plugin/finder/conv/FinderSessionInfo;", "syncKeyType", "", "(I)V", "sessionInfoStorage", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "getSessionInfoStorage", "()Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;", "sessionInfoStorage$delegate", "Lkotlin/Lazy;", "getSyncKeyType", "()I", "setSyncKeyType", "getBypBizSyncKeyType", "getLocalSeesionInfo", "sessionId", "", "getRoleType", "getSessionSelfUserName", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "saveSession", "", "session", "throwException", "", "e", "Ljava/lang/Exception;", "Lkotlin/Exception;", "updateSession", "localSesionInfo", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends com.tencent.mm.plugin.byp.c.b<o>
{
  public static final a EBX;
  private final j AFU;
  private int EBY;
  
  static
  {
    AppMethodBeat.i(329810);
    EBX = new a((byte)0);
    AppMethodBeat.o(329810);
  }
  
  public a(int paramInt)
  {
    AppMethodBeat.i(329803);
    this.EBY = paramInt;
    this.AFU = k.cm((kotlin.g.a.a)b.EBZ);
    AppMethodBeat.o(329803);
  }
  
  private ak getSessionInfoStorage()
  {
    AppMethodBeat.i(329807);
    ak localak = (ak)this.AFU.getValue();
    AppMethodBeat.o(329807);
    return localak;
  }
  
  public final String b(cy paramcy)
  {
    AppMethodBeat.i(329819);
    s.u(paramcy, "rawBypMsg");
    String str1 = w.a(paramcy.YFg.YFE);
    String str2 = w.a(paramcy.YFg.YFF);
    if (paramcy.YFj) {}
    for (paramcy = str1; au.bwT(paramcy); paramcy = str2)
    {
      paramcy = z.bAM();
      s.s(paramcy, "{\n            //该消息是发给我的…eFromUserInfo()\n        }");
      AppMethodBeat.o(329819);
      return paramcy;
    }
    s.s(paramcy, "{\n            //该消息是发给我的…     myUserName\n        }");
    AppMethodBeat.o(329819);
    return paramcy;
  }
  
  public final int dij()
  {
    return 4;
  }
  
  public final int dik()
  {
    return this.EBY;
  }
  
  public final boolean l(Exception paramException)
  {
    AppMethodBeat.i(329814);
    s.u(paramException, "e");
    e.a.a((e)com.tencent.mm.plugin.findersdk.b.HbT, getTAG(), false, null, false, (kotlin.g.a.a)new c(paramException), 28);
    AppMethodBeat.o(329814);
    return false;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/message/FinderMsgSyncHandler$Companion;", "", "()V", "TAG", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/finder/storage/FinderSessionInfoStorage;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<ak>
  {
    public static final b EBZ;
    
    static
    {
      AppMethodBeat.i(329809);
      EBZ = new b();
      AppMethodBeat.o(329809);
    }
    
    b()
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<String>
  {
    c(Exception paramException)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.message.a
 * JD-Core Version:    0.7.0.1
 */