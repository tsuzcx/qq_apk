package com.tencent.mm.plugin.brandservice.ui.timeline;

import android.content.ClipboardManager;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.mm.ae.i;
import com.tencent.mm.ai.e;
import com.tencent.mm.ai.z;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.h.c.cs;
import com.tencent.mm.model.s;
import com.tencent.mm.model.u;
import com.tencent.mm.model.u.b;
import com.tencent.mm.plugin.brandservice.a.c;
import com.tencent.mm.plugin.brandservice.b.a;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.n.d;

final class a$16
  implements n.d
{
  a$16(a parama) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    if (a.m(this.ifl) == null) {
      y.w("MicroMsg.BizTimeLineAdapter", "onMMMenuItemSelected mInfo == null");
    }
    Object localObject1;
    do
    {
      return;
      localObject1 = a.m(this.ifl);
      a.a(this.ifl, bk.UX());
      switch (paramMenuItem.getItemId())
      {
      default: 
        return;
      case 1: 
        paramMenuItem = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(((q)localObject1).field_talker);
        if (paramMenuItem == null)
        {
          y.e("MicroMsg.BizTimeLineAdapter", "changed biz stick status failed, contact is null, talker = " + ((q)localObject1).field_talker);
          return;
        }
        if (paramMenuItem.Bl())
        {
          com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
          s.u(((q)localObject1).field_talker, true);
          com.tencent.mm.ui.base.h.bC(a.a(this.ifl), a.a(this.ifl).getString(b.h.biz_time_line_unplacedtop_tips));
          a.d(this.ifl).a(a.m(this.ifl), false);
          return;
        }
        com.tencent.mm.plugin.report.service.h.nFQ.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
        s.t(((q)localObject1).field_talker, true);
        com.tencent.mm.ui.base.h.bC(a.a(this.ifl), a.a(this.ifl).getString(b.h.biz_time_line_placedtop_tips));
        a.d(this.ifl).a(a.m(this.ifl), true);
        return;
      case 2: 
        paramMenuItem = ((j)com.tencent.mm.kernel.g.r(j.class)).Fw().abl(((q)localObject1).field_talker);
        localObject1 = z.My().kQ(((q)localObject1).field_talker);
        ((c)com.tencent.mm.kernel.g.r(c.class)).b((com.tencent.mm.ai.d)localObject1, a.a(this.ifl), paramMenuItem);
        a.d(this.ifl).c(a.m(this.ifl), 2);
        return;
      case 10: 
        com.tencent.mm.ui.base.h.a(a.a(this.ifl), a.a(this.ifl).getString(b.h.biz_time_line_un_delete_msg_tips), "", a.a(this.ifl).getString(b.h.app_ok), a.a(this.ifl).getString(b.h.app_cancel), true, new a.16.1(this), null, b.a.red);
        return;
      case 11: 
        com.tencent.mm.ui.base.h.bC(a.a(this.ifl), a.a(this.ifl).getString(b.h.biz_time_line_egg_tips));
        return;
      case 3: 
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Contact_User", ((q)localObject1).field_talker);
        paramMenuItem.putExtra("Contact_Scene", 90);
        com.tencent.mm.br.d.b(a.a(this.ifl), "profile", ".ui.ContactInfoUI", paramMenuItem);
        a.d(this.ifl).c(a.m(this.ifl), 1);
        return;
      case 4: 
        if (a.n(this.ifl))
        {
          ((c)com.tencent.mm.kernel.g.r(c.class)).a(a.o(this.ifl), a.a(this.ifl), ((q)localObject1).field_content, ((q)localObject1).field_talker, ((q)localObject1).field_msgId, ((q)localObject1).field_msgSvrId);
          return;
        }
        str = i.a(a.a(this.ifl), a.o(this.ifl), ((q)localObject1).field_content, ((q)localObject1).field_talker, ((q)localObject1).field_msgId);
      }
    } while (bk.bl(str));
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Retr_Msg_content", str);
    paramMenuItem.putExtra("Retr_Msg_Type", 2);
    paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", a.o(this.ifl));
    paramMenuItem.putExtra("Retr_Msg_Id", ((q)localObject1).field_msgId);
    paramMenuItem.putExtra("Retr_MsgFromScene", 1);
    String str = ((q)localObject1).field_talker;
    Object localObject2 = u.ij(((q)localObject1).field_msgSvrId);
    paramMenuItem.putExtra("reportSessionId", (String)localObject2);
    localObject2 = u.Hc().v((String)localObject2, true);
    ((u.b)localObject2).h("prePublishId", "msg_" + ((q)localObject1).field_msgSvrId);
    ((u.b)localObject2).h("preUsername", str);
    ((u.b)localObject2).h("preChatName", str);
    ((u.b)localObject2).h("preMsgIndex", Integer.valueOf(a.o(this.ifl)));
    ((u.b)localObject2).h("sendAppMsgScene", Integer.valueOf(1));
    com.tencent.mm.br.d.e(a.a(this.ifl), ".ui.transmit.MsgRetransmitUI", paramMenuItem);
    return;
    paramMenuItem = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((q)localObject1).field_msgId);
    if (paramMenuItem.field_msgId == 0L)
    {
      y.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
      return;
    }
    ((c)com.tencent.mm.kernel.g.r(c.class)).a(a.p(this.ifl), a.o(this.ifl), a.a(this.ifl), a.a(this.ifl), paramMenuItem);
    return;
    paramMenuItem = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((q)localObject1).field_msgId);
    if (paramMenuItem.field_msgId == 0L)
    {
      y.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
      return;
    }
    ((c)com.tencent.mm.kernel.g.r(c.class)).a(paramMenuItem, a.a(this.ifl));
    return;
    paramMenuItem = ((j)com.tencent.mm.kernel.g.r(j.class)).bhO().fd(((q)localObject1).field_msgId);
    if (paramMenuItem.field_msgId == 0L)
    {
      y.w("MicroMsg.BizTimeLineAdapter", "favAppBrandMsg msg is null");
      return;
    }
    ((c)com.tencent.mm.kernel.g.r(c.class)).a(paramMenuItem, a.a(this.ifl));
    return;
    paramMenuItem = new Intent();
    paramMenuItem.putExtra("Retr_Msg_content", a.m(this.ifl).field_content);
    paramMenuItem.putExtra("Retr_Msg_Type", 4);
    com.tencent.mm.br.d.e(a.a(this.ifl), ".ui.transmit.MsgRetransmitUI", paramMenuItem);
    return;
    paramMenuItem = (ClipboardManager)a.a(this.ifl).getSystemService("clipboard");
    try
    {
      paramMenuItem.setText(a.m(this.ifl).field_content);
      com.tencent.mm.ui.base.h.bC(a.a(this.ifl), a.a(this.ifl).getString(b.h.app_copy_ok));
      paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.nQo;
      com.tencent.mm.plugin.secinforeport.a.a.f(1, a.m(this.ifl).field_msgSvrId, bk.ZH(a.m(this.ifl).field_content));
      return;
    }
    catch (Exception paramMenuItem)
    {
      for (;;)
      {
        y.e("MicroMsg.BizTimeLineAdapter", "clip.setText error ");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.16
 * JD-Core Version:    0.7.0.1
 */