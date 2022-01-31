package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.l;
import com.tencent.mm.aj.e;
import com.tencent.mm.aj.z;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.g.c.dd;
import com.tencent.mm.model.t;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.f;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.q;
import com.tencent.mm.ui.base.n.d;

public final class g
  implements n.d
{
  com.tencent.mm.plugin.brandservice.ui.timeline.a jXV;
  private long jYq;
  private boolean jYr = false;
  private Context mContext;
  
  public g(com.tencent.mm.plugin.brandservice.ui.timeline.a parama, Context paramContext)
  {
    this.jXV = parama;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(14265);
    if (this.jXV.jVF == null)
    {
      ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(14265);
      return;
    }
    q localq = this.jXV.jVF;
    this.jYq = bo.aox();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(localq.field_talker);
      if (paramMenuItem == null)
      {
        ab.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localq.field_talker);
        AppMethodBeat.o(14265);
        return;
      }
      if (paramMenuItem.Oa())
      {
        com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        t.y(localq.field_talker, true);
        com.tencent.mm.ui.base.h.bO(this.mContext, this.mContext.getString(2131297726));
        this.jXV.jVS.a(localq, false);
        AppMethodBeat.o(14265);
        return;
      }
      com.tencent.mm.plugin.report.service.h.qsU.e(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      t.x(localq.field_talker, true);
      com.tencent.mm.ui.base.h.bO(this.mContext, this.mContext.getString(2131297721));
      this.jXV.jVS.a(localq, true);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).YA().arw(localq.field_talker);
      Object localObject1 = z.afi().rK(localq.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).b((com.tencent.mm.aj.d)localObject1, (Activity)this.mContext, paramMenuItem);
      this.jXV.jVS.d(localq, 2);
      AppMethodBeat.o(14265);
      return;
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131297725), "", this.mContext.getString(2131297018), this.mContext.getString(2131296888), true, new g.1(this, localq), null, 2131690391);
      AppMethodBeat.o(14265);
      return;
      com.tencent.mm.ui.base.h.bO(this.mContext, this.mContext.getString(2131297689));
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", localq.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      com.tencent.mm.bq.d.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.jXV.jVS.d(localq, 1);
      AppMethodBeat.o(14265);
      return;
      if (this.jYr)
      {
        ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.jXV.jVG, this.mContext, localq.field_content, localq.field_talker, localq.field_msgId, localq.field_msgSvrId);
        AppMethodBeat.o(14265);
        return;
      }
      localObject1 = l.a(this.mContext, this.jXV.jVG, localq.field_content, localq.field_talker, localq.field_msgId);
      if (bo.isNullOrNil((String)localObject1)) {
        continue;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.jXV.jVG);
      paramMenuItem.putExtra("Retr_Msg_Id", localq.field_msgId);
      paramMenuItem.putExtra("Retr_MsgFromScene", 1);
      localObject1 = localq.field_talker;
      Object localObject2 = v.oQ(localq.field_msgSvrId);
      paramMenuItem.putExtra("reportSessionId", (String)localObject2);
      localObject2 = v.aae().z((String)localObject2, true);
      ((v.b)localObject2).i("prePublishId", "msg_" + localq.field_msgSvrId);
      ((v.b)localObject2).i("preUsername", localObject1);
      ((v.b)localObject2).i("preChatName", localObject1);
      ((v.b)localObject2).i("preMsgIndex", Integer.valueOf(this.jXV.jVG));
      ((v.b)localObject2).i("sendAppMsgScene", Integer.valueOf(1));
      com.tencent.mm.bq.d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(localq.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(14265);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.jYq, this.jXV.jVG, this.mContext, (Activity)this.mContext, paramMenuItem);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(localq.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(14265);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, (Activity)this.mContext);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = ((j)com.tencent.mm.kernel.g.E(j.class)).bPQ().kB(localq.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ab.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(14265);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, this.mContext);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", localq.field_content);
      paramMenuItem.putExtra("Retr_Msg_Type", 4);
      com.tencent.mm.bq.d.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(14265);
      return;
      paramMenuItem = (ClipboardManager)ah.getContext().getSystemService("clipboard");
      try
      {
        paramMenuItem.setText(localq.field_content);
        com.tencent.mm.ui.base.h.bO(this.mContext, this.mContext.getString(2131296896));
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.qEl;
        com.tencent.mm.plugin.secinforeport.a.a.i(1, localq.field_msgSvrId, bo.apL(localq.field_content));
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          ab.e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.g
 * JD-Core Version:    0.7.0.1
 */