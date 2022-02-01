package com.tencent.mm.plugin.byp.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.kernel.h;
import com.tencent.mm.platformtools.w;
import com.tencent.mm.plugin.byp.a.a;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.ae;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.protocal.protobuf.cy;
import com.tencent.mm.protocal.protobuf.dl;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.cc;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder;", "SESSION", "Lcom/tencent/mm/plugin/byp/api/BaseBypSyncHandler;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "notifier", "com/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder$notifier$1", "Lcom/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder$notifier$1;", "beforeProcessAddMsg", "", "rawBypMsg", "Lcom/tencent/mm/protocal/protobuf/AddBypMsg;", "getLocalSeesionInfo", "sessionId", "(Ljava/lang/String;)Ljava/lang/Object;", "getSessionSelfUserName", "getSessionTalkerUserName", "getSyncMessageNotifier", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "ifIgnore", "saveSession", "", "session", "(Ljava/lang/Object;Ljava/lang/String;)V", "updateSession", "localSesionInfo", "(Ljava/lang/Object;Lcom/tencent/mm/protocal/protobuf/AddBypMsg;)Z", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class b<SESSION>
  extends a
{
  private final String TAG = "BasePrivateMsgReceiveHanlder";
  private final a waW = new a(this);
  
  public static String c(cy paramcy)
  {
    s.u(paramcy, "rawBypMsg");
    String str1 = w.a(paramcy.YFg.YFE);
    String str2 = w.a(paramcy.YFg.YFF);
    if (paramcy.YFj)
    {
      s.s(str2, "toUser");
      return str2;
    }
    s.s(str1, "fromUser");
    return str1;
  }
  
  public final boolean a(cy paramcy)
  {
    s.u(paramcy, "rawBypMsg");
    if (d(paramcy)) {
      return false;
    }
    Object localObject = paramcy.YFh;
    s.s(localObject, "sessionId");
    localObject = akj((String)localObject);
    if (a(localObject, paramcy))
    {
      paramcy = paramcy.YFh;
      s.s(paramcy, "rawBypMsg.msg_session_id");
      f(localObject, paramcy);
    }
    return true;
  }
  
  public abstract boolean a(SESSION paramSESSION, cy paramcy);
  
  public abstract SESSION akj(String paramString);
  
  public String b(cy paramcy)
  {
    s.u(paramcy, "rawBypMsg");
    String str1 = w.a(paramcy.YFg.YFE);
    String str2 = w.a(paramcy.YFg.YFF);
    if (paramcy.YFj)
    {
      s.s(str1, "fromUser");
      return str1;
    }
    s.s(str2, "toUser");
    return str2;
  }
  
  public boolean d(cy paramcy)
  {
    s.u(paramcy, "rawBypMsg");
    String str = paramcy.YFh;
    paramcy = ((n)h.ax(n.class)).gaZ().aU(str, paramcy.YFg.Njv);
    s.s(paramcy, "service(IMessengerStorag…, rawBypMsg.msg.NewMsgId)");
    if (paramcy.field_msgId != 0L)
    {
      Log.i(getTAG(), "msg already exist");
      return true;
    }
    return false;
  }
  
  public final ae dil()
  {
    return (ae)this.waW;
  }
  
  public abstract void f(SESSION paramSESSION, String paramString);
  
  protected String getTAG()
  {
    return this.TAG;
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/byp/config/BasePrivateMsgReceiveHanlder$notifier$1", "Lcom/tencent/mm/plugin/messenger/foundation/api/ISyncMessageNotifier;", "flushNotifyAllMsg", "", "notifyNewMsg", "msg", "Lcom/tencent/mm/storage/MsgInfo;", "addMsg", "Lcom/tencent/mm/protocal/protobuf/AddMsg;", "plugin-byp_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements ae
  {
    a(b<SESSION> paramb) {}
    
    public final void a(cc paramcc, dl paramdl)
    {
      AppMethodBeat.i(271973);
      Log.i(this.waX.getTAG(), "[notifyNewMsg] msg=" + paramcc + " addMsg=" + paramdl);
      AppMethodBeat.o(271973);
    }
    
    public final void dir()
    {
      AppMethodBeat.i(271976);
      Log.i(this.waX.getTAG(), "flushNotifyAllMsg");
      AppMethodBeat.o(271976);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.byp.c.b
 * JD-Core Version:    0.7.0.1
 */