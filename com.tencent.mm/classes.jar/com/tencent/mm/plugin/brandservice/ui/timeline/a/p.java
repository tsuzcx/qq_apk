package com.tencent.mm.plugin.brandservice.ui.timeline.a;

import android.app.Activity;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.am.e;
import com.tencent.mm.bs.d;
import com.tencent.mm.g.c.au;
import com.tencent.mm.g.c.du;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.bi;
import com.tencent.mm.model.w;
import com.tencent.mm.model.y;
import com.tencent.mm.model.y.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.s;
import com.tencent.mm.ui.base.n.d;

public final class p
  implements n.d
{
  private Context mContext;
  private long naJ;
  private boolean naK = false;
  com.tencent.mm.plugin.brandservice.ui.timeline.c nao;
  
  public p(com.tencent.mm.plugin.brandservice.ui.timeline.c paramc, Context paramContext)
  {
    this.nao = paramc;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.nao.mWL == null)
    {
      ad.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    final s locals = this.nao.mWL;
    this.naJ = bt.aGK();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).apM().aHY(locals.field_talker);
      if (paramMenuItem == null)
      {
        ad.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + locals.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.ZS())
      {
        com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        w.D(locals.field_talker, true);
        com.tencent.mm.ui.base.h.cf(this.mContext, this.mContext.getString(2131756644));
        this.nao.mWX.a(locals, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.h.vKh.f(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      w.C(locals.field_talker, true);
      com.tencent.mm.ui.base.h.cf(this.mContext, this.mContext.getString(2131756637));
      this.nao.mWX.a(locals, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).apM().aHY(locals.field_talker);
      Object localObject1 = com.tencent.mm.am.af.awe().wy(locals.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).b((com.tencent.mm.api.c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.nao.mWX.c(locals, 2);
      AppMethodBeat.o(6036);
      return;
      com.tencent.mm.ui.base.h.a(this.mContext, this.mContext.getString(2131756643), "", this.mContext.getString(2131755835), this.mContext.getString(2131755691), true, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(6035);
          bi.lW(locals.field_msgId);
          p.this.nao.mWX.c(locals, 3);
          p.this.nao.mWN.e(locals);
          AppMethodBeat.o(6035);
        }
      }, null, 2131100798);
      AppMethodBeat.o(6036);
      return;
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", locals.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      d.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.nao.mWX.c(locals, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.naK)
      {
        ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.nao.mWM, this.mContext, locals.field_content, locals.field_talker, locals.field_msgId, locals.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.nao.mWM, locals.field_content, locals.field_talker, locals.field_msgId);
      if (bt.isNullOrNil((String)localObject1)) {
        continue;
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
      paramMenuItem.putExtra("Retr_Msg_Type", 2);
      paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.nao.mWM);
      paramMenuItem.putExtra("Retr_Msg_Id", locals.field_msgId);
      paramMenuItem.putExtra("Retr_MsgFromScene", 1);
      localObject1 = locals.field_talker;
      Object localObject2 = y.tD(locals.field_msgSvrId);
      paramMenuItem.putExtra("reportSessionId", (String)localObject2);
      localObject2 = y.arz().E((String)localObject2, true);
      ((y.b)localObject2).m("prePublishId", "msg_" + locals.field_msgSvrId);
      ((y.b)localObject2).m("preUsername", localObject1);
      ((y.b)localObject2).m("preChatName", localObject1);
      ((y.b)localObject2).m("preMsgIndex", Integer.valueOf(this.nao.mWM));
      ((y.b)localObject2).m("sendAppMsgScene", Integer.valueOf(1));
      d.e(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).cOI().rm(locals.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ad.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.naJ, this.nao.mWM, this.mContext, (Activity)this.mContext, paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).cOI().rm(locals.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ad.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, (Activity)this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((k)g.ab(k.class)).cOI().rm(locals.field_msgId);
      if (paramMenuItem.field_msgId == 0L)
      {
        ad.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
        AppMethodBeat.o(6036);
        return;
      }
      ((com.tencent.mm.plugin.brandservice.a.a)g.ab(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, this.mContext);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", locals.field_content);
      paramMenuItem.putExtra("Retr_Msg_Type", 4);
      d.e(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = (ClipboardManager)aj.getContext().getSystemService("clipboard");
      try
      {
        paramMenuItem.setText(locals.field_content);
        com.tencent.mm.ui.base.h.cf(this.mContext, this.mContext.getString(2131755702));
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.wcB;
        com.tencent.mm.plugin.secinforeport.a.a.m(1, locals.field_msgSvrId, bt.aFZ(locals.field_content));
      }
      catch (Exception paramMenuItem)
      {
        for (;;)
        {
          ad.e("MicroMsg.BizTimeLineMMMenuItemListener", "clip.setText error ");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.a.p
 * JD-Core Version:    0.7.0.1
 */