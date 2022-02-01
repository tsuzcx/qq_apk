package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.m;
import com.tencent.mm.al.af;
import com.tencent.mm.al.e;
import com.tencent.mm.br.d;
import com.tencent.mm.g.c.av;
import com.tencent.mm.g.c.dy;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.t;
import com.tencent.mm.ui.base.n.d;

public final class p
  implements n.d
{
  private Context mContext;
  com.tencent.mm.plugin.brandservice.ui.timeline.c nCM;
  private long nDh;
  private boolean nDi = false;
  
  public p(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    this.nCM = paramc;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.nCM.nzk == null)
    {
      ac.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    final t localt = this.nCM.nzk;
    this.nDh = bs.aNx();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).awB().aNt(localt.field_talker);
      if (paramMenuItem == null)
      {
        ac.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localt.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.aaN())
      {
        com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        w.E(localt.field_talker, true);
        com.tencent.mm.ui.base.h.cg(this.mContext, this.mContext.getString(2131756644));
        this.nCM.nzw.a(localt, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.h.wUl.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      w.D(localt.field_talker, true);
      com.tencent.mm.ui.base.h.cg(this.mContext, this.mContext.getString(2131756637));
      this.nCM.nzw.a(localt, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).awB().aNt(localt.field_talker);
      Object localObject1 = af.aCW().AE(localt.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).b((com.tencent.mm.api.c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.nCM.nzw.d(localt, 2);
      AppMethodBeat.o(6036);
      return;
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131756643), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(6035);
          bi.pK(localt.field_msgId);
          p.this.nCM.nzw.d(localt, 3);
          p.this.nCM.nzm.e(localt);
          AppMethodBeat.o(6035);
        }
      }, null, 2131100798);
      AppMethodBeat.o(6036);
      return;
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", localt.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      d.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.nCM.nzw.d(localt, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.nDi)
      {
        ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.nCM.nzl, this.mContext, localt.field_content, localt.field_talker, localt.field_msgId, localt.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.nCM.nzl, localt.field_content, localt.field_talker, localt.field_msgId);
      if (bs.isNullOrNil((String)localObject1)) {
        continue;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.nCM.nzl);
      paramMenuItem.putExtra("Retr_Msg_Id", localt.field_msgId);
      paramMenuItem.putExtra("Retr_MsgFromScene", 1);
      localObject1 = localt.field_talker;
      Object localObject2 = y.xJ(localt.field_msgSvrId);
      paramMenuItem.putExtra("reportSessionId", (String)localObject2);
      localObject2 = y.ayq().F((String)localObject2, true);
      ((y.b)localObject2).l("prePublishId", "msg_" + localt.field_msgSvrId);
      ((y.b)localObject2).l("preUsername", localObject1);
      ((y.b)localObject2).l("preChatName", localObject1);
      ((y.b)localObject2).l("preMsgIndex", Integer.valueOf(this.nCM.nzl));
      ((y.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
      d.e(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).dcr().vP(localt.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ac.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.nDh, this.nCM.nzl, this.mContext, (Activity)this.mContext, paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).dcr().vP(localt.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ac.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, (Activity)this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).dcr().vP(localt.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ac.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", localt.field_content);
      paramMenuItem.putExtra("Retr_Msg_Type", 4);
      d.e(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = (ClipboardManager)com.tencent.mm.sdk.platformtools.ai.getContext().getSystemService("clipboard");
      try
      {
        paramMenuItem.setText(localt.field_content);
        com.tencent.mm.ui.base.h.cg(this.mContext, this.mContext.getString(2131755702));
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.xnM;
        com.tencent.mm.plugin.secinforeport.a.a.o(1, localt.field_msgSvrId, bs.aLq(localt.field_content));
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          ac.e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.p
 * JD-Core Version:    0.7.0.1
 */