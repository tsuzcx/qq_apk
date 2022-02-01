package com.tencent.mm.plugin.forcenotify.f;

import android.content.Context;
import android.content.Intent;
import com.tencent.c.a.a.a.b.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.f.a.om;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.service.q;
import com.tencent.mm.plugin.appbrand.service.q.a;
import com.tencent.mm.plugin.findersdk.a.ak;
import com.tencent.mm.plugin.forcenotify.a.h;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.g;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/util/ForceNotifyUtil;", "", "()V", "TAG", "", "jumpChattingUI", "", "context", "Landroid/content/Context;", "item", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyMsgItem;", "jumpLiveVistorUI", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyLiveItem;", "jumpUI", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "originCount", "", "transformMsgItem", "info", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyInfo;", "result", "Lkotlin/Function1;", "plugin-force-notify_release"})
public final class b
{
  public static final b BFh;
  
  static
  {
    AppMethodBeat.i(252499);
    BFh = new b();
    AppMethodBeat.o(252499);
  }
  
  public static void a(Context paramContext, e parame, int paramInt)
  {
    AppMethodBeat.i(252496);
    p.k(paramContext, "context");
    p.k(parame, "item");
    Object localObject1;
    Object localObject2;
    if ((parame instanceof com.tencent.mm.plugin.forcenotify.d.h))
    {
      localObject1 = (com.tencent.mm.plugin.forcenotify.d.h)parame;
      localObject2 = new om();
      ((om)localObject2).fNo.username = ((com.tencent.mm.plugin.forcenotify.d.h)localObject1).username;
      if (!EventCenter.instance.publish((IEvent)localObject2))
      {
        Log.i("ForceNotifyWindow", "jumpChattingUI LauncherUI background, jump chatting username:" + ((com.tencent.mm.plugin.forcenotify.d.h)localObject1).username);
        localObject2 = new Intent();
        ((Intent)localObject2).putExtra("Chat_Self", z.bcZ());
        ((Intent)localObject2).putExtra("Chat_User", ((com.tencent.mm.plugin.forcenotify.d.h)localObject1).username);
        ((Intent)localObject2).putExtra("finish_direct", true);
        c.f(paramContext, ".ui.chatting.ChattingUI", (Intent)localObject2);
      }
      for (;;)
      {
        ((a)com.tencent.mm.kernel.h.ae(a.class)).a(1, 1, ((com.tencent.mm.plugin.forcenotify.d.h)parame).username, paramInt, parame.BDR);
        AppMethodBeat.o(252496);
        return;
        Log.i("ForceNotifyWindow", "jumpChattingUI LauncherUI running, jump chatting username:" + ((com.tencent.mm.plugin.forcenotify.d.h)localObject1).username);
      }
    }
    if ((parame instanceof g))
    {
      localObject2 = (g)parame;
      long l1 = com.tencent.mm.ae.d.Nb(((g)localObject2).feedId);
      long l2 = com.tencent.mm.ae.d.Nb(((g)localObject2).kwM);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).report21053OnClick(l1, l2, "", -1, -1, 7L, "temp_7", -1, -1, "", "", System.currentTimeMillis(), -1);
      ((ak)com.tencent.mm.kernel.h.ag(ak.class)).set21084CommentScene("temp_7");
      localObject1 = (com.tencent.c.a.a.a.b)com.tencent.mm.kernel.h.ag(com.tencent.c.a.a.a.b.class);
      localObject2 = ((g)localObject2).nonceId;
      String str = ((ak)com.tencent.mm.kernel.h.ag(ak.class)).genContextId(25, 14, 65);
      p.j(str, "MMKernel.plugin(IPluginF….genContextId(25, 14, 65)");
      b.b.a((com.tencent.c.a.a.a.b)localObject1, null, paramContext, l1, Long.valueOf(l2), "", (String)localObject2, "", str, "", "", "", 1);
      ((a)com.tencent.mm.kernel.h.ae(a.class)).a(1, 2, ((g)parame).feedId, paramInt, parame.BDR);
    }
    AppMethodBeat.o(252496);
  }
  
  public static void a(com.tencent.mm.plugin.forcenotify.d.d paramd, final kotlin.g.a.b<? super com.tencent.mm.plugin.forcenotify.d.h, x> paramb)
  {
    AppMethodBeat.i(252492);
    p.k(paramd, "info");
    p.k(paramb, "result");
    Object localObject1 = paramd.field_ForcePushId;
    p.j(localObject1, "info.field_ForcePushId");
    if (kotlin.n.n.pu((String)localObject1, "@miniapp"))
    {
      ((q)com.tencent.mm.kernel.h.ae(q.class)).a(paramd.field_UserName, (q.a)new a(paramd, paramb));
      AppMethodBeat.o(252492);
      return;
    }
    localObject1 = com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.messenger.foundation.a.n.class);
    p.j(localObject1, "MMKernel.service(IMessengerStorage::class.java)");
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.n)localObject1).bbL().RG(paramd.field_UserName);
    Object localObject2 = new StringBuilder("transformMsgItem, forcePushId:").append(paramd.field_ForcePushId).append(" username:").append(paramd.field_UserName).append(" nickname:");
    String str1;
    if (localas != null)
    {
      str1 = localas.ays();
      localObject1 = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    Log.i("ForceNotifyUtil", (String)localObject1);
    localObject2 = paramd.field_ForcePushId;
    p.j(localObject2, "info.field_ForcePushId");
    String str2 = paramd.field_UserName;
    p.j(str2, "info.field_UserName");
    if (localas != null)
    {
      str1 = localas.ays();
      localObject1 = str1;
      if (str1 != null) {}
    }
    else
    {
      localObject1 = "";
    }
    long l = paramd.field_CreateTime;
    paramd = MMApplicationContext.getContext().getString(a.h.force_notify_receive_a_msg);
    p.j(paramd, "MMApplicationContext.get…rce_notify_receive_a_msg)");
    paramb.invoke(new com.tencent.mm.plugin.forcenotify.d.h((String)localObject2, str2, (String)localObject1, paramd, l));
    AppMethodBeat.o(252492);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Lcom/tencent/mm/plugin/appbrand/config/WxaAttributes;", "kotlin.jvm.PlatformType", "onGetWeAppInfo"})
  static final class a
    implements q.a
  {
    a(com.tencent.mm.plugin.forcenotify.d.d paramd, kotlin.g.a.b paramb) {}
    
    public final void b(WxaAttributes paramWxaAttributes)
    {
      AppMethodBeat.i(252954);
      if (paramWxaAttributes == null)
      {
        AppMethodBeat.o(252954);
        return;
      }
      Log.i("ForceNotifyUtil", "transformMsgItem, forcePushId:" + this.BDJ.field_ForcePushId + " username:" + this.BDJ.field_UserName + " nickname:" + this.BDJ.field_Description + " avatarUrl:" + paramWxaAttributes.field_brandIconURL);
      kotlin.g.a.b localb = paramb;
      String str1 = this.BDJ.field_ForcePushId;
      p.j(str1, "info.field_ForcePushId");
      String str2 = this.BDJ.field_UserName;
      p.j(str2, "info.field_UserName");
      String str3 = this.BDJ.field_Description;
      p.j(str3, "info.field_Description");
      long l = this.BDJ.field_CreateTime;
      String str4 = MMApplicationContext.getContext().getString(a.h.force_notify_receive_a_msg);
      p.j(str4, "MMApplicationContext.get…rce_notify_receive_a_msg)");
      localb.invoke(new com.tencent.mm.plugin.forcenotify.d.h(str1, str2, str3, str4, l, paramWxaAttributes.field_brandIconURL));
      AppMethodBeat.o(252954);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.f.b
 * JD-Core Version:    0.7.0.1
 */