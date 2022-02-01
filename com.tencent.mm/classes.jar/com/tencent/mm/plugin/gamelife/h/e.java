package com.tencent.mm.plugin.gamelife.h;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.gamelife.b.c;
import com.tencent.mm.plugin.gamelife.b.m;
import com.tencent.mm.plugin.gamelife.k.a;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler;", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder;", "Lcom/tencent/mm/plugin/gamelife/session/GameLifeSessionInfo;", "()V", "getBypBizSyncKeyType", "", "getLocalSeesionInfo", "sessionId", "", "getRoleType", "saveSession", "", "session", "updateSession", "", "localSesionInfo", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "Companion", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class e
  extends com.tencent.mm.plugin.byp.c.b<a>
{
  public static final a JbJ;
  
  static
  {
    AppMethodBeat.i(267777);
    JbJ = new a((byte)0);
    AppMethodBeat.o(267777);
  }
  
  private boolean a(a parama, cy paramcy)
  {
    AppMethodBeat.i(267772);
    s.u(parama, "localSesionInfo");
    s.u(paramcy, "rawBypMsg");
    Object localObject1 = paramcy.YFg;
    boolean bool = paramcy.YFj;
    String str1 = paramcy.YFh;
    String str2 = w.a(((dl)localObject1).YFF);
    localObject1 = w.a(((dl)localObject1).YFE);
    String str3 = c(paramcy);
    String str4 = b(paramcy);
    Object localObject2 = new c().parseFrom(paramcy.YFi.Op);
    if (localObject2 == null)
    {
      parama = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.gamelife.autogen.GameLifeMsgExtInfo");
      AppMethodBeat.o(267772);
      throw parama;
    }
    localObject2 = (c)localObject2;
    if ((((c)localObject2).JaF != null) && (((c)localObject2).JaF.extern_info != null))
    {
      String str5 = ((c)localObject2).JaF.extern_info;
      s.s(str5, "msgExtInfo.msg_report.extern_info");
      if (!n.i((CharSequence)str5, (CharSequence)"20008"))
      {
        h.baE().ban().set(at.a.acSP, Integer.valueOf(((c)localObject2).JaF.msg_type));
        h.baE().ban().set(at.a.acSQ, ((c)localObject2).JaF.extern_info);
      }
    }
    parama.field_sessionId = str1;
    parama.field_selfUserName = str4;
    parama.field_talker = str3;
    parama.field_extInfo = ((c)localObject2);
    Log.i(getTAG(), "[beforeProcessAddMsg] svrMsgId=" + paramcy.YFg.Njv + " isSender=" + bool + " msgType=" + paramcy.YFg.IIs + " createTime=" + paramcy.YFg.CreateTime + " fromUser=" + localObject1 + " toUser=" + str2 + " sessionId=" + paramcy.YFh + ' ');
    AppMethodBeat.o(267772);
    return true;
  }
  
  public final int dij()
  {
    return 5;
  }
  
  public final int dik()
  {
    return 3;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/gamelife/message/GameLifeMsgSyncHandler$Companion;", "", "()V", "MSG_REPORT_EXP", "", "TAG", "plugin-gamelife_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.gamelife.h.e
 * JD-Core Version:    0.7.0.1
 */