package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.protocal.protobuf.ei;
import com.tencent.mm.protocal.protobuf.ej;
import com.tencent.mm.protocal.protobuf.fz;
import com.tencent.mm.protocal.protobuf.ga;
import com.tencent.mm.protocal.protobuf.xt;
import com.tencent.mm.protocal.protobuf.xu;
import com.tencent.mm.protocal.protobuf.xv;
import com.tencent.mm.protocal.protobuf.xw;
import com.tencent.mm.roomsdk.a.b;
import com.tencent.mm.roomsdk.a.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.n.n;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/api/ChatRoomOpenService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "doAppBindChatRoom", "", "context", "Landroid/content/Context;", "param", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "callback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$AppBindCallback;", "doAppCreateChatRoom", "usernameListStr", "", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$HandleCallback;", "doAppUnbindChatRoom", "doCheckAppBindChatRoom", "doCheckAppJoinChatRoom", "handleGroupContactSelected", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "mockTest", "registerAppBindCallback", "sessionId", "Companion", "ui-chatroom_release"})
public final class a
  implements e, MMActivity.a
{
  public static final a iVG;
  
  static
  {
    AppMethodBeat.i(186656);
    iVG = new a((byte)0);
    AppMethodBeat.o(186656);
  }
  
  public final void a(final Context paramContext, e.b paramb)
  {
    AppMethodBeat.i(186642);
    p.k(paramContext, "context");
    p.k(paramb, "param");
    Object localObject = new xv();
    ((xv)localObject).appid = paramb.appId;
    ((xv)localObject).signature = paramb.signature;
    ((xv)localObject).RDj = paramb.EVw;
    ((xv)localObject).tyJ = paramb.EVx;
    paramb = new d.a();
    paramb.vD(1969);
    paramb.TW("/cgi-bin/mmbiz-bin/wxabusiness/checkappjoinchatroom");
    paramb.c((com.tencent.mm.cd.a)localObject);
    paramb.d((com.tencent.mm.cd.a)new xw());
    localObject = new aa.f();
    ((aa.f)localObject).aaBC = null;
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new j((aa.f)localObject, paramContext));
    IPCRunCgi.a(paramb.bgN(), (IPCRunCgi.a)new a.k((aa.f)localObject, paramContext));
    AppMethodBeat.o(186642);
  }
  
  public final void a(final Context paramContext, e.b paramb, e.a parama)
  {
    AppMethodBeat.i(186635);
    p.k(paramContext, "context");
    p.k(paramb, "param");
    if (!(paramContext instanceof MMFragmentActivity)) {}
    for (Object localObject1 = null;; localObject1 = paramContext)
    {
      localObject1 = (MMFragmentActivity)localObject1;
      if (localObject1 == null)
      {
        Log.e("MicroMsg.ChatRoomOpenService", "context is not MMActivity");
        AppMethodBeat.o(186635);
        return;
      }
      Object localObject2 = new xt();
      ((xt)localObject2).appid = paramb.appId;
      ((xt)localObject2).signature = paramb.signature;
      ((xt)localObject2).RDj = paramb.EVw;
      ((xt)localObject2).tyJ = paramb.EVx;
      d.a locala = new d.a();
      locala.vD(1023);
      locala.TW("/cgi-bin/mmbiz-bin/wxabusiness/checkappbindchatroom");
      locala.c((com.tencent.mm.cd.a)localObject2);
      locala.d((com.tencent.mm.cd.a)new xu());
      localObject2 = new aa.f();
      ((aa.f)localObject2).aaBC = null;
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new h((aa.f)localObject2, paramContext));
      IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new a.i(this, (aa.f)localObject2, paramb, (MMFragmentActivity)localObject1, paramContext, parama));
      AppMethodBeat.o(186635);
      return;
    }
  }
  
  public final void a(final Context paramContext, final e.b paramb, final e.c paramc)
  {
    AppMethodBeat.i(186649);
    p.k(paramContext, "context");
    p.k(paramb, "param");
    Object localObject = new fz();
    ((fz)localObject).appid = paramb.appId;
    ((fz)localObject).fHp = paramb.EVz;
    ((fz)localObject).scene = paramb.EVB;
    d.a locala = new d.a();
    locala.vD(6892);
    locala.TW("/cgi-bin/micromsg-bin/appunbindchatroom");
    locala.c((com.tencent.mm.cd.a)localObject);
    locala.d((com.tencent.mm.cd.a)new ga());
    localObject = new aa.f();
    ((aa.f)localObject).aaBC = null;
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new f((aa.f)localObject, paramContext));
    IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new g((aa.f)localObject, paramb, paramContext, paramc));
    AppMethodBeat.o(186649);
  }
  
  public final void a(final Context paramContext, e.b paramb, String paramString, final e.c paramc)
  {
    AppMethodBeat.i(186634);
    p.k(paramContext, "context");
    p.k(paramb, "param");
    List localList = (List)new ArrayList();
    if (paramString != null)
    {
      int i;
      Object localObject1;
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i == 1)
        {
          localObject1 = (Iterable)n.b((CharSequence)paramString, new String[] { "," });
          paramString = (Collection)new ArrayList();
          localObject1 = ((Iterable)localObject1).iterator();
        }
      }
      else
      {
        label162:
        for (;;)
        {
          label97:
          if (!((Iterator)localObject1).hasNext()) {
            break label164;
          }
          Object localObject2 = ((Iterator)localObject1).next();
          if (((CharSequence)localObject2).length() > 0) {}
          for (i = 1;; i = 0)
          {
            if (i == 0) {
              break label162;
            }
            paramString.add(localObject2);
            break label97;
            i = 0;
            break;
          }
        }
        label164:
        paramString = ((Iterable)paramString).iterator();
        while (paramString.hasNext()) {
          localList.add((String)paramString.next());
        }
      }
    }
    paramString = new aa.f();
    paramString.aaBC = null;
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new d(paramString, paramContext));
    b.btX("@chatroom").a("", localList, paramb.appId, paramb.EVy).d((com.tencent.mm.roomsdk.a.b.a)new e(paramString, paramc, paramContext)).aRu();
    AppMethodBeat.o(186634);
  }
  
  public final void b(final Context paramContext, final e.b paramb, final e.a parama)
  {
    AppMethodBeat.i(186637);
    p.k(paramContext, "context");
    p.k(paramb, "param");
    Object localObject = new ei();
    ((ei)localObject).appid = paramb.appId;
    ((ei)localObject).signature = paramb.signature;
    ((ei)localObject).RDj = paramb.EVw;
    ((ei)localObject).tyJ = paramb.EVx;
    ((ei)localObject).fHp = paramb.EVz;
    ((ei)localObject).RJv = paramb.EVy;
    ((ei)localObject).RJw = paramb.EVA;
    d.a locala = new d.a();
    locala.vD(5285);
    locala.TW("/cgi-bin/micromsg-bin/appbindchatroom");
    locala.c((com.tencent.mm.cd.a)localObject);
    locala.d((com.tencent.mm.cd.a)new ej());
    localObject = new aa.f();
    ((aa.f)localObject).aaBC = null;
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b((aa.f)localObject, paramContext));
    IPCRunCgi.a(locala.bgN(), (IPCRunCgi.a)new c((aa.f)localObject, paramb, parama, paramContext));
    AppMethodBeat.o(186637);
  }
  
  public final void d(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/chatroom/api/ChatRoomOpenService$Companion;", "", "()V", "KEY_BIND_PARAM", "", "KEY_ERROR_CONTENT", "KEY_ERROR_TITLE", "TAG", "ui-chatroom_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<x>
  {
    b(aa.f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class c
    implements IPCRunCgi.a
  {
    c(aa.f paramf, e.b paramb, e.a parama, Context paramContext) {}
    
    public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(190904);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramd) {});
      AppMethodBeat.o(190904);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<x>
  {
    d(aa.f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/chatroom/api/ChatRoomOpenService$doAppCreateChatRoom$4", "Lcom/tencent/mm/roomsdk/model/callback/RoomDetailResult;", "onResult", "", "errType", "", "errCode", "errMsg", "", "detailResult", "ui-chatroom_release"})
  public static final class e
    extends c
  {
    e(aa.f paramf, e.c paramc, Context paramContext) {}
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends q
      implements kotlin.g.a.a<x>
    {
      a(a.e parame, int paramInt1, int paramInt2)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<x>
  {
    f(aa.f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "reqResp", "Lcom/tencent/mm/modelbase/CommReqResp;", "kotlin.jvm.PlatformType", "callback"})
  static final class g
    implements IPCRunCgi.a
  {
    g(aa.f paramf, e.b paramb, Context paramContext, e.c paramc) {}
    
    public final void a(final int paramInt1, final int paramInt2, String paramString, final com.tencent.mm.an.d paramd)
    {
      AppMethodBeat.i(187854);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new q(paramd) {});
      AppMethodBeat.o(187854);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<x>
  {
    h(aa.f paramf, Context paramContext)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<x>
  {
    j(aa.f paramf, Context paramContext)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */