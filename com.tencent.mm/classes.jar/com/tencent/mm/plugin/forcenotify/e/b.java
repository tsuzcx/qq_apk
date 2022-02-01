package com.tencent.mm.plugin.forcenotify.e;

import android.content.Context;
import android.content.Intent;
import com.tencent.d.a.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ae.d;
import com.tencent.mm.autogen.a.pw;
import com.tencent.mm.br.c;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.findersdk.a.cn;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.c.j;
import com.tencent.mm.plugin.forcenotify.c.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyUtil;", "", "()V", "TAG", "", "jumpChattingUI", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "jumpLiveVistorUI", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "jumpUI", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "originCount", "", "transformMsgItem", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "result", "Lkotlin/Function1;", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b HpK;
  
  static
  {
    AppMethodBeat.i(274866);
    HpK = new b();
    AppMethodBeat.o(274866);
  }
  
  public static void a(Context paramContext, com.tencent.mm.plugin.forcenotify.c.a parama, int paramInt)
  {
    AppMethodBeat.i(274858);
    kotlin.g.b.s.u(paramContext, "context");
    kotlin.g.b.s.u(parama, "item");
    Object localObject1;
    Object localObject2;
    if ((parama instanceof k))
    {
      localObject1 = (k)parama;
      localObject2 = new pw();
      ((pw)localObject2).hTb.username = ((k)localObject1).username;
      if (!((pw)localObject2).publish())
      {
        Log.i("ForceNotifyUtil", kotlin.g.b.s.X("jumpChattingUI LauncherUI background, jump chatting username:", ((k)localObject1).username));
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Chat_Self", z.bAM());
        ((Intent)localObject2).putExtra("Chat_User", ((k)localObject1).username);
        ((Intent)localObject2).putExtra("finish_direct", true);
        c.g(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
      }
      for (;;)
      {
        ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).d(1, ((k)parama).username, paramInt, parama.id);
        AppMethodBeat.o(274858);
        return;
        Log.i("ForceNotifyUtil", kotlin.g.b.s.X("jumpChattingUI LauncherUI running, jump chatting username:", ((k)localObject1).username));
      }
    }
    if ((parama instanceof j))
    {
      localObject2 = (j)parama;
      long l1 = d.FK(((j)localObject2).feedId);
      long l2 = d.FK(((j)localObject2).liveId);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).report21053OnClick(l1, l2, "", -1, -1, 7L, "temp_7", -1, -1, "", "", System.currentTimeMillis(), -1);
      ((cn)com.tencent.mm.kernel.h.az(cn.class)).set21084CommentScene("temp_7");
      localObject1 = com.tencent.mm.kernel.h.az(com.tencent.d.a.a.a.b.class);
      kotlin.g.b.s.s(localObject1, "plugin(IPluginFinderLive::class.java)");
      localObject1 = (com.tencent.d.a.a.a.b)localObject1;
      localObject2 = ((j)localObject2).nonceId;
      String str = ((cn)com.tencent.mm.kernel.h.az(cn.class)).genContextId(25, 14, 65);
      kotlin.g.b.s.s(str, "plugin(IPluginFinder::cl….genContextId(25, 14, 65)");
      b.b.a((com.tencent.d.a.a.a.b)localObject1, null, paramContext, l1, Long.valueOf(l2), "", (String)localObject2, "", str, "", "", "", 1);
      ((com.tencent.mm.plugin.forcenotify.a.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.forcenotify.a.a.class)).d(2, ((j)parama).feedId, paramInt, parama.id);
    }
    AppMethodBeat.o(274858);
  }
  
  public static void a(com.tencent.mm.plugin.forcenotify.c.h paramh, kotlin.g.a.b<? super k, ah> paramb)
  {
    AppMethodBeat.i(274850);
    kotlin.g.b.s.u(paramh, "info");
    kotlin.g.b.s.u(paramb, "result");
    Object localObject1 = paramh.field_ForcePushId;
    kotlin.g.b.s.s(localObject1, "info.field_ForcePushId");
    if (kotlin.n.n.rs((String)localObject1, "@miniapp"))
    {
      ((com.tencent.mm.plugin.appbrand.service.s)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.appbrand.service.s.class)).a(paramh.field_UserName, new b..ExternalSyntheticLambda0(paramh, paramb));
      AppMethodBeat.o(274850);
      return;
    }
    au localau = ((com.tencent.mm.plugin.messenger.foundation.a.n)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.messenger.foundation.a.n.class)).bzA().JE(paramh.field_UserName);
    Object localObject2 = new StringBuilder("transformMsgItem, forcePushId:").append(paramh.field_ForcePushId).append(" username:").append(paramh.field_UserName).append(" nickname:");
    String str2;
    if (localau == null)
    {
      localObject1 = "";
      Log.i("ForceNotifyUtil", (String)localObject1);
      localObject2 = paramh.field_ForcePushId;
      str2 = paramh.field_UserName;
      if (localau != null) {
        break label268;
      }
      localObject1 = "";
    }
    for (;;)
    {
      long l = paramh.field_CreateTime;
      paramh = MMApplicationContext.getContext().getString(a.h.force_notify_receive_a_msg);
      kotlin.g.b.s.s(localObject2, "field_ForcePushId");
      kotlin.g.b.s.s(str2, "field_UserName");
      kotlin.g.b.s.s(paramh, "getString(R.string.force_notify_receive_a_msg)");
      paramb.invoke(new k((String)localObject2, str2, (String)localObject1, paramh, l));
      AppMethodBeat.o(274850);
      return;
      String str1 = localau.aSV();
      localObject1 = str1;
      if (str1 != null) {
        break;
      }
      localObject1 = "";
      break;
      label268:
      str1 = localau.aSV();
      localObject1 = str1;
      if (str1 == null) {
        localObject1 = "";
      }
    }
  }
  
  private static final void a(com.tencent.mm.plugin.forcenotify.c.h paramh, kotlin.g.a.b paramb, WxaAttributes paramWxaAttributes)
  {
    AppMethodBeat.i(274862);
    kotlin.g.b.s.u(paramh, "$info");
    kotlin.g.b.s.u(paramb, "$result");
    if (paramWxaAttributes == null)
    {
      AppMethodBeat.o(274862);
      return;
    }
    Log.i("ForceNotifyUtil", "transformMsgItem, forcePushId:" + paramh.field_ForcePushId + " username:" + paramh.field_UserName + " nickname:" + paramh.field_Description + " avatarUrl:" + paramWxaAttributes.field_brandIconURL);
    String str1 = paramh.field_ForcePushId;
    String str2 = paramh.field_UserName;
    String str3 = paramh.field_Description;
    long l = paramh.field_CreateTime;
    paramh = MMApplicationContext.getContext().getString(a.h.force_notify_receive_a_msg);
    paramWxaAttributes = paramWxaAttributes.field_brandIconURL;
    kotlin.g.b.s.s(str1, "field_ForcePushId");
    kotlin.g.b.s.s(str2, "field_UserName");
    kotlin.g.b.s.s(str3, "field_Description");
    kotlin.g.b.s.s(paramh, "getString(R.string.force_notify_receive_a_msg)");
    paramb.invoke(new k(str1, str2, str3, paramh, l, paramWxaAttributes));
    AppMethodBeat.o(274862);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.e.b
 * JD-Core Version:    0.7.0.1
 */