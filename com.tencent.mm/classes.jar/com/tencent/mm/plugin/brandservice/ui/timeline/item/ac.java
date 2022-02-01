package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.al.f;
import com.tencent.mm.api.c;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.g.c.ei;
import com.tencent.mm.model.x;
import com.tencent.mm.model.z;
import com.tencent.mm.model.z.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.e;

public final class ac
  implements n.e
{
  private Context mContext;
  private long olE;
  private boolean olF = false;
  b oll;
  
  public ac(b paramb, Context paramContext)
  {
    this.oll = paramb;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.oll.ogf == null)
    {
      ae.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    w localw = this.oll.ogf;
    this.olE = bu.aRi();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localw.field_talker);
      if (paramMenuItem == null)
      {
        ae.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localw.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.adB())
      {
        com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        x.E(localw.field_talker, true);
        h.cm(this.mContext, this.mContext.getString(2131756644));
        this.oll.ogr.a(localw, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.g.yxI.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      x.D(localw.field_talker, true);
      h.cm(this.mContext, this.mContext.getString(2131756637));
      this.oll.ogr.a(localw, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().BH(localw.field_talker);
      Object localObject1 = ag.aGp().Ef(localw.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).b((c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.oll.ogr.d(localw, 2);
      AppMethodBeat.o(6036);
      return;
      if (localw.ftb()) {}
      for (paramMenuItem = this.mContext.getString(2131762088);; paramMenuItem = this.mContext.getString(2131756643))
      {
        h.a(this.mContext, paramMenuItem, "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), true, new ac.1(this, localw), null, 2131100798);
        AppMethodBeat.o(6036);
        return;
      }
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", localw.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      d.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.oll.ogr.d(localw, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.olF)
      {
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.oll.ogg, this.mContext, localw.field_content, localw.field_talker, localw.field_msgId, localw.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.oll.ogg, localw.field_content, localw.field_talker, localw.field_msgId);
      if (bu.isNullOrNil((String)localObject1)) {
        continue;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.oll.ogg);
      paramMenuItem.putExtra("Retr_Msg_Id", localw.field_msgId);
      paramMenuItem.putExtra("Retr_MsgFromScene", 1);
      localObject1 = localw.field_talker;
      Object localObject2 = z.Br(localw.field_msgSvrId);
      paramMenuItem.putExtra("reportSessionId", (String)localObject2);
      localObject2 = z.aBG().F((String)localObject2, true);
      ((z.b)localObject2).k("prePublishId", "msg_" + localw.field_msgSvrId);
      ((z.b)localObject2).k("preUsername", localObject1);
      ((z.b)localObject2).k("preChatName", localObject1);
      ((z.b)localObject2).k("preMsgIndex", Integer.valueOf(this.oll.ogg));
      ((z.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
      d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localw.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ae.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.olE, this.oll.ogg, this.mContext, (Activity)this.mContext, paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localw.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ae.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, (Activity)this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((l)com.tencent.mm.kernel.g.ab(l.class)).doJ().ys(localw.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ae.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", localw.field_content);
      paramMenuItem.putExtra("Retr_Msg_Type", 4);
      d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = (ClipboardManager)ak.getContext().getSystemService("clipboard");
      try
      {
        paramMenuItem.setText(localw.field_content);
        h.cm(this.mContext, this.mContext.getString(2131755702));
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.yRN;
        com.tencent.mm.plugin.secinforeport.a.a.o(1, localw.field_msgSvrId, bu.aSt(localw.field_content));
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          ae.e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ac
 * JD-Core Version:    0.7.0.1
 */