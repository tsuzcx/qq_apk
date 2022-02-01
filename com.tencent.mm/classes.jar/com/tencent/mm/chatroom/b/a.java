package com.tencent.mm.chatroom.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.plugin.messenger.foundation.a.e;
import com.tencent.mm.plugin.messenger.foundation.a.e.a;
import com.tencent.mm.plugin.messenger.foundation.a.e.b;
import com.tencent.mm.plugin.messenger.foundation.a.e.c;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.fc;
import com.tencent.mm.protocal.protobuf.fd;
import com.tencent.mm.protocal.protobuf.fe;
import com.tencent.mm.protocal.protobuf.gs;
import com.tencent.mm.protocal.protobuf.gt;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.protocal.protobuf.ml;
import com.tencent.mm.protocal.protobuf.zo;
import com.tencent.mm.protocal.protobuf.zp;
import com.tencent.mm.protocal.protobuf.zs;
import com.tencent.mm.protocal.protobuf.zt;
import com.tencent.mm.roomsdk.model.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity.a;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.ah.f;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/chatroom/api/ChatRoomOpenService;", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService;", "Lcom/tencent/mm/ui/MMActivity$IMMOnActivityResult;", "()V", "doAppBindChatRoom", "", "context", "Landroid/content/Context;", "param", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$ChatRoomOpenParam;", "callback", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$AppBindCallback;", "doAppCreateChatRoom", "usernameListStr", "", "Lcom/tencent/mm/plugin/messenger/foundation/api/IChatRoomOpenService$HandleCallback;", "doAppUnbindChatRoom", "doCheckAppBindChatRoom", "doCheckAppJoinChatRoom", "handleGroupContactSelected", "mmOnActivityResult", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "mockTest", "registerAppBindCallback", "sessionId", "Companion", "ui-chatroom_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements e, MMActivity.a
{
  public static final a.a lxL;
  
  static
  {
    AppMethodBeat.i(241368);
    lxL = new a.a((byte)0);
    AppMethodBeat.o(241368);
  }
  
  private static final void a(e.a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(241349);
    s.u(paramIntent, "bindData");
    if ((paramInt1 == 15002) && (paramInt2 == -1))
    {
      paramIntent = paramIntent.getStringExtra("key_chat_room_open_id");
      if (parama != null) {
        parama.onDealEnd(true, null, paramIntent);
      }
    }
    AppMethodBeat.o(241349);
  }
  
  private static final void a(e.b paramb, a parama, Context paramContext, e.a parama1, int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject = null;
    AppMethodBeat.i(241329);
    s.u(paramb, "$param");
    s.u(parama, "this$0");
    s.u(paramContext, "$context");
    if ((paramInt1 != 15001) || (paramInt2 != -1))
    {
      AppMethodBeat.o(241329);
      return;
    }
    if (paramIntent == null)
    {
      parama = null;
      Log.i("MicroMsg.ChatRoomOpenService", s.X("on select contact return:", parama));
      paramb.KRa = parama;
      if (paramIntent != null) {
        break label126;
      }
    }
    label126:
    for (paramInt1 = 0;; paramInt1 = paramIntent.getIntExtra("key_has_create_new_group", 0))
    {
      paramb.mIJ = paramInt1;
      parama = localObject;
      if ((paramContext instanceof MMFragmentActivity)) {
        parama = (MMFragmentActivity)paramContext;
      }
      if (parama != null) {
        break label139;
      }
      Log.e("MicroMsg.ChatRoomOpenService", "context is not MMActivity");
      AppMethodBeat.o(241329);
      return;
      parama = paramIntent.getStringExtra("Select_Conv_User");
      break;
    }
    label139:
    paramContext = new Intent();
    paramContext.setClassName((Context)parama, "com.tencent.mm.chatroom.ui.ChatRoomBindAppUI");
    paramContext.putExtra("key_bind_param", (Serializable)paramb);
    parama.setMMOnFragmentActivityResult(new a..ExternalSyntheticLambda4(parama1));
    parama.startActivityForResult(paramContext, 15002);
    AppMethodBeat.o(241329);
  }
  
  private static final void a(e.b paramb, MMFragmentActivity paramMMFragmentActivity, Context paramContext, e.a parama, ah.f paramf, a parama1, int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(241347);
    s.u(paramb, "$param");
    s.u(paramContext, "$context");
    s.u(paramf, "$dialog");
    s.u(parama1, "this$0");
    Log.i("MicroMsg.ChatRoomOpenService", "GetCheckAppBindResp: errType:" + paramInt1 + ", errCode:" + paramInt2 + ", errMsg:" + paramString);
    d.uiThread((kotlin.g.a.a)new a.i(paramf));
    if (paramc == null)
    {
      paramf = null;
      if (!(paramf instanceof zp)) {
        break label293;
      }
      paramString = (zp)paramf;
      label111:
      if ((paramInt1 != 0) || (paramInt2 != 0) || (paramString == null)) {
        break label323;
      }
      Log.i("MicroMsg.ChatRoomOpenService", "GetCheckAppBindResp Success");
      paramb.KQZ = paramString.YGP;
      paramf = paramString.Zij;
      if (paramf != null) {
        break label299;
      }
      paramf = "";
    }
    for (;;)
    {
      paramb.appName = paramf;
      paramf = new Intent();
      paramf.setClassName((Context)paramMMFragmentActivity, "com.tencent.mm.ui.contact.GroupCardSelectUI");
      paramf.putExtra("group_select_type", true);
      paramf.putExtra("group_select_only_need_self_owner", true);
      paramf.putExtra("group_select_need_result", true);
      paramf.putExtra("group_select_show_create_new_group", true);
      paramf.putExtra("group_select_should_intercept", true);
      paramf.putExtra("key_bind_param", (Serializable)paramb);
      paramMMFragmentActivity.setMMOnFragmentActivityResult(new a..ExternalSyntheticLambda5(paramb, parama1, paramContext, parama));
      paramMMFragmentActivity.startActivityForResult(paramf, 15001);
      AppMethodBeat.o(241347);
      return;
      paramf = c.c.b(paramc.otC);
      break;
      label293:
      paramString = null;
      break label111;
      label299:
      paramString = paramf.nickname;
      paramf = paramString;
      if (paramString == null) {
        paramf = "";
      }
    }
    label323:
    if (paramString == null)
    {
      paramb = null;
      paramb = (CharSequence)paramb;
      if ((paramb != null) && (paramb.length() != 0)) {
        break label448;
      }
      paramInt1 = 1;
      label351:
      if (paramInt1 == 0) {
        break label454;
      }
      paramb = paramContext.getString(com.tencent.mm.chatroom.ui.a.i.gwl);
      label364:
      if (paramString != null) {
        break label487;
      }
      paramf = null;
      label372:
      paramContext = paramf;
      if (paramf == null)
      {
        if (paramString != null) {
          break label512;
        }
        paramContext = paramb;
      }
    }
    for (;;)
    {
      if (parama != null) {
        parama.onDealEnd(false, paramContext, null);
      }
      h.ahAA.bk(new a..ExternalSyntheticLambda6(paramMMFragmentActivity, paramb, paramContext));
      AppMethodBeat.o(241347);
      return;
      paramb = paramString.Zik;
      if (paramb == null)
      {
        paramb = null;
        break;
      }
      paramb = paramb.title;
      break;
      label448:
      paramInt1 = 0;
      break label351;
      label454:
      if (paramString == null)
      {
        paramb = null;
        break label364;
      }
      paramb = paramString.Zik;
      if (paramb == null)
      {
        paramb = null;
        break label364;
      }
      paramb = paramb.title;
      break label364;
      label487:
      paramContext = paramString.Zik;
      if (paramContext == null)
      {
        paramf = null;
        break label372;
      }
      paramf = paramContext.desc;
      break label372;
      label512:
      paramContext = paramString.getBaseResponse();
      if (paramContext == null)
      {
        paramContext = paramb;
      }
      else
      {
        paramContext = paramContext.akjO;
        if (paramContext == null)
        {
          paramContext = paramb;
        }
        else
        {
          paramf = paramContext.abwM;
          paramContext = paramf;
          if (paramf == null) {
            paramContext = paramb;
          }
        }
      }
    }
  }
  
  private static final void a(MMFragmentActivity paramMMFragmentActivity, String paramString1, String paramString2)
  {
    AppMethodBeat.i(241334);
    Intent localIntent = new Intent();
    localIntent.setClassName((Context)paramMMFragmentActivity, "com.tencent.mm.chatroom.ui.ChatRoomOpenErrorInfoUI");
    localIntent.putExtra("key_error_title", paramString1);
    localIntent.putExtra("key_error_content", paramString2);
    paramString1 = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
    com.tencent.mm.hellhoundlib.a.a.b(paramMMFragmentActivity, paramString1.aYi(), "com/tencent/mm/chatroom/api/ChatRoomOpenService", "doCheckAppBindChatRoom$lambda-8$lambda-7", "(Lcom/tencent/mm/ui/MMFragmentActivity;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    paramMMFragmentActivity.startActivity((Intent)paramString1.sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(paramMMFragmentActivity, "com/tencent/mm/chatroom/api/ChatRoomOpenService", "doCheckAppBindChatRoom$lambda-8$lambda-7", "(Lcom/tencent/mm/ui/MMFragmentActivity;Ljava/lang/String;Ljava/lang/String;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(241334);
  }
  
  private static final void a(ah.f paramf, Context paramContext, int paramInt1, int paramInt2, String paramString, c paramc)
  {
    AppMethodBeat.i(241360);
    s.u(paramf, "$dialog");
    s.u(paramContext, "$context");
    d.uiThread((kotlin.g.a.a)new a.k(paramf, paramc, paramInt1, paramInt2, paramContext));
    AppMethodBeat.o(241360);
  }
  
  private static final void a(ah.f paramf, final e.b paramb, final Context paramContext, final e.c paramc, final int paramInt1, final int paramInt2, String paramString, final c paramc1)
  {
    AppMethodBeat.i(241364);
    s.u(paramf, "$dialog");
    s.u(paramb, "$param");
    s.u(paramContext, "$context");
    d.uiThread((kotlin.g.a.a)new g(paramf, paramc1, paramInt1, paramInt2, paramb, paramContext, paramc));
    AppMethodBeat.o(241364);
  }
  
  private static final void a(ah.f paramf, final e.b paramb, final e.a parama, final Context paramContext, final int paramInt1, final int paramInt2, String paramString, final c paramc)
  {
    AppMethodBeat.i(241353);
    s.u(paramf, "$dialog");
    s.u(paramb, "$param");
    s.u(paramContext, "$context");
    d.uiThread((kotlin.g.a.a)new c(paramf, paramc, paramInt1, paramInt2, paramb, parama, paramContext));
    AppMethodBeat.o(241353);
  }
  
  public final void a(Context paramContext, e.b paramb)
  {
    AppMethodBeat.i(241403);
    s.u(paramContext, "context");
    s.u(paramb, "param");
    Object localObject = new zs();
    ((zs)localObject).appid = paramb.appId;
    ((zs)localObject).signature = paramb.signature;
    ((zs)localObject).YzM = paramb.KQX;
    ((zs)localObject).wDg = paramb.KQY;
    paramb = new c.a();
    paramb.funcId = 1969;
    paramb.uri = "/cgi-bin/mmbiz-bin/wxabusiness/checkappjoinchatroom";
    paramb.otE = ((com.tencent.mm.bx.a)localObject);
    paramb.otF = ((com.tencent.mm.bx.a)new zt());
    localObject = new ah.f();
    d.uiThread((kotlin.g.a.a)new a.j((ah.f)localObject, paramContext));
    IPCRunCgi.a(paramb.bEF(), new a..ExternalSyntheticLambda1((ah.f)localObject, paramContext));
    AppMethodBeat.o(241403);
  }
  
  public final void a(Context paramContext, e.b paramb, e.a parama)
  {
    AppMethodBeat.i(241393);
    s.u(paramContext, "context");
    s.u(paramb, "param");
    if ((paramContext instanceof MMFragmentActivity)) {}
    for (MMFragmentActivity localMMFragmentActivity = (MMFragmentActivity)paramContext; localMMFragmentActivity == null; localMMFragmentActivity = null)
    {
      Log.e("MicroMsg.ChatRoomOpenService", "context is not MMActivity");
      AppMethodBeat.o(241393);
      return;
    }
    Object localObject = new zo();
    ((zo)localObject).appid = paramb.appId;
    ((zo)localObject).signature = paramb.signature;
    ((zo)localObject).YzM = paramb.KQX;
    ((zo)localObject).wDg = paramb.KQY;
    c.a locala = new c.a();
    locala.funcId = 1023;
    locala.uri = "/cgi-bin/mmbiz-bin/wxabusiness/checkappbindchatroom";
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = ((com.tencent.mm.bx.a)new zp());
    localObject = new ah.f();
    d.uiThread((kotlin.g.a.a)new a.h((ah.f)localObject, paramContext));
    IPCRunCgi.a(locala.bEF(), new a..ExternalSyntheticLambda0(paramb, localMMFragmentActivity, paramContext, parama, (ah.f)localObject, this));
    AppMethodBeat.o(241393);
  }
  
  public final void a(Context paramContext, e.b paramb, e.c paramc)
  {
    AppMethodBeat.i(241405);
    s.u(paramContext, "context");
    s.u(paramb, "param");
    Object localObject = new gs();
    ((gs)localObject).appid = paramb.appId;
    ((gs)localObject).hMM = paramb.KRa;
    ((gs)localObject).scene = paramb.KRb;
    c.a locala = new c.a();
    locala.funcId = 6892;
    locala.uri = "/cgi-bin/micromsg-bin/appunbindchatroom";
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = ((com.tencent.mm.bx.a)new gt());
    localObject = new ah.f();
    d.uiThread((kotlin.g.a.a)new a.f((ah.f)localObject, paramContext));
    IPCRunCgi.a(locala.bEF(), new a..ExternalSyntheticLambda2((ah.f)localObject, paramb, paramContext, paramc));
    AppMethodBeat.o(241405);
  }
  
  public final void a(Context paramContext, e.b paramb, String paramString, e.c paramc)
  {
    AppMethodBeat.i(241389);
    s.u(paramContext, "context");
    s.u(paramb, "param");
    List localList = (List)new ArrayList();
    int i;
    label60:
    Object localObject1;
    if (paramString != null) {
      if (((CharSequence)paramString).length() > 0)
      {
        i = 1;
        if (i != 1) {
          break label168;
        }
        i = 1;
        if (i == 0) {
          break label222;
        }
        localObject1 = (Iterable)n.b((CharSequence)paramString, new String[] { "," });
        paramString = (Collection)new ArrayList();
        localObject1 = ((Iterable)localObject1).iterator();
      }
    }
    label168:
    label178:
    for (;;)
    {
      label107:
      if (!((Iterator)localObject1).hasNext()) {
        break label180;
      }
      Object localObject2 = ((Iterator)localObject1).next();
      if (((CharSequence)localObject2).length() > 0) {}
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label178;
        }
        paramString.add(localObject2);
        break label107;
        i = 0;
        break;
        i = 0;
        break label60;
      }
    }
    label180:
    paramString = ((Iterable)paramString).iterator();
    while (paramString.hasNext()) {
      localList.add((String)paramString.next());
    }
    label222:
    paramString = new ah.f();
    d.uiThread((kotlin.g.a.a)new a.d(paramString, paramContext));
    b.btW("@chatroom").a("", localList, paramb.appId, paramb.KQZ).d((com.tencent.mm.roomsdk.model.b.a)new a.e(paramString, paramc, paramContext)).blj();
    AppMethodBeat.o(241389);
  }
  
  public final void b(Context paramContext, e.b paramb, e.a parama)
  {
    AppMethodBeat.i(241396);
    s.u(paramContext, "context");
    s.u(paramb, "param");
    Object localObject = new fc();
    ((fc)localObject).appid = paramb.appId;
    ((fc)localObject).signature = paramb.signature;
    ((fc)localObject).YzM = paramb.KQX;
    ((fc)localObject).wDg = paramb.KQY;
    ((fc)localObject).hMM = paramb.KRa;
    ((fc)localObject).YGP = paramb.KQZ;
    ((fc)localObject).YGQ = paramb.mIJ;
    c.a locala = new c.a();
    locala.funcId = 5285;
    locala.uri = "/cgi-bin/micromsg-bin/appbindchatroom";
    locala.otE = ((com.tencent.mm.bx.a)localObject);
    locala.otF = ((com.tencent.mm.bx.a)new fd());
    localObject = new ah.f();
    d.uiThread((kotlin.g.a.a)new a.b((ah.f)localObject, paramContext));
    IPCRunCgi.a(locala.bEF(), new a..ExternalSyntheticLambda3((ah.f)localObject, paramb, parama, paramContext));
    AppMethodBeat.o(241396);
  }
  
  public final void mmOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ah>
  {
    c(ah.f<w> paramf, c paramc, int paramInt1, int paramInt2, e.b paramb, e.a parama, Context paramContext)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<ah>
  {
    g(ah.f<w> paramf, c paramc, int paramInt1, int paramInt2, e.b paramb, Context paramContext, e.c paramc1)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.b.a
 * JD-Core Version:    0.7.0.1
 */