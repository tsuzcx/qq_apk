package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.m;
import com.tencent.mm.al.ag;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.g.c.eo;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bp;
import com.tencent.mm.plugin.brandservice.ui.timeline.b;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.protocal.protobuf.ale;
import com.tencent.mm.protocal.protobuf.ege;
import com.tencent.mm.protocal.protobuf.pi;
import com.tencent.mm.protocal.protobuf.pj;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.o.g;
import java.util.LinkedList;

public final class al
  implements o.g
{
  private Context mContext;
  b pxE;
  private long pxY;
  private boolean pxZ = false;
  
  public al(b paramb, Context paramContext)
  {
    this.pxE = paramb;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.pxE.pqY == null)
    {
      Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    final z localz = this.pxE.pqY;
    this.pxY = Util.nowSecond();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localz.field_talker);
      if (paramMenuItem == null)
      {
        Log.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localz.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.arE())
      {
        com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        ab.F(localz.field_talker, true);
        com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(2131756793));
        this.pxE.pqZ.a(localz, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.h.CyF.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      ab.E(localz.field_talker, true);
      com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(2131756785));
      this.pxE.pqZ.a(localz, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(localz.field_talker);
      Object localObject1 = ag.bah().MT(localz.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).b((com.tencent.mm.api.c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.pxE.pqZ.f(localz, 2);
      AppMethodBeat.o(6036);
      return;
      if (localz.gAu()) {}
      for (paramMenuItem = this.mContext.getString(2131756792);; paramMenuItem = this.mContext.getString(2131756791))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramMenuItem, "", this.mContext.getString(2131755921), this.mContext.getString(2131755761), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(6035);
            Object localObject1;
            ale localale;
            pi localpi;
            Object localObject2;
            int i;
            if (localz.gAu())
            {
              ag.ban().MX(localz.field_msgId);
              l.a(3, localz.gAD(), null, localz);
              paramAnonymousDialogInterface = al.this.pxE.pqZ;
              localObject1 = localz;
              if (!((z)localObject1).gAu()) {
                break label527;
              }
              localObject1 = ((z)localObject1).gAD();
              if ((localObject1 == null) || (((ege)localObject1).style != 101)) {
                break label288;
              }
              localale = ((ege)localObject1).Nga;
              localpi = (pi)((pj)localale.KUf.get(0)).KWy.get(0);
              localObject2 = localpi.KSj;
              i = 0;
              paramAnonymousInt = 0;
              l2 = 0L;
              l1 = l2;
              if (!Util.isNullOrNil((String)localObject2)) {
                paramAnonymousInt = i;
              }
            }
            try
            {
              localObject2 = Uri.parse((String)localObject2);
              paramAnonymousInt = i;
              i = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
              paramAnonymousInt = i;
              l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
              paramAnonymousInt = i;
            }
            catch (Exception localException2)
            {
              label525:
              label527:
              for (;;)
              {
                label288:
                l1 = l2;
              }
            }
            paramAnonymousDialogInterface.a(((pj)localale.KUf.get(0)).UserName, l1, paramAnonymousInt, 3, ((ege)localObject1).MOC, "", 0, localale.KUo, ((ege)localObject1).event, localale.KUk, localpi.KWv, ((ege)localObject1).style, localpi.KWw);
            for (;;)
            {
              al.this.pxE.prb.p(localz);
              AppMethodBeat.o(6035);
              return;
              bp.Ad(localz.field_msgId);
              break;
              if ((localObject1 != null) && ((((ege)localObject1).style == 102) || (((ege)localObject1).style == 103)))
              {
                i = 0;
                for (;;)
                {
                  if (i >= ((ege)localObject1).Nga.KUf.size()) {
                    break label525;
                  }
                  localale = ((ege)localObject1).Nga;
                  int j;
                  if (((pj)localale.KUf.get(i)).KHa == 0)
                  {
                    localpi = (pi)((pj)localale.KUf.get(i)).KWy.get(0);
                    if (localpi != null)
                    {
                      localObject2 = localpi.KSj;
                      j = 0;
                      paramAnonymousInt = 0;
                      l2 = 0L;
                      l1 = l2;
                      if (!Util.isNullOrNil((String)localObject2)) {
                        paramAnonymousInt = j;
                      }
                    }
                  }
                  try
                  {
                    localObject2 = Uri.parse((String)localObject2);
                    paramAnonymousInt = j;
                    j = Util.getInt(((Uri)localObject2).getQueryParameter("idx"), 0);
                    paramAnonymousInt = j;
                    l1 = Util.getLong(((Uri)localObject2).getQueryParameter("mid"), 0L);
                    paramAnonymousInt = j;
                  }
                  catch (Exception localException1)
                  {
                    for (;;)
                    {
                      l1 = l2;
                    }
                  }
                  paramAnonymousDialogInterface.a(((pj)localale.KUf.get(i)).UserName, l1, paramAnonymousInt, 3, ((ege)localObject1).MOC, "", 0, localale.KUo, ((ege)localObject1).event, localale.KUk, localpi.KWv, ((ege)localObject1).style, localpi.KWw);
                  break;
                  i += 1;
                }
                continue;
                paramAnonymousDialogInterface.f((z)localObject1, 3);
              }
            }
          }
        }, null, 2131100994);
        AppMethodBeat.o(6036);
        return;
      }
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", localz.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.pxE.pqZ.f(localz, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.pxZ)
      {
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.pxE.pra, this.mContext, localz.field_content, localz.field_talker, localz.field_msgId, localz.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.pxE.pra, localz.field_content, localz.field_talker, localz.field_msgId);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.pxE.pra);
        paramMenuItem.putExtra("Retr_Msg_Id", localz.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        localObject1 = localz.field_talker;
        Object localObject2 = ad.JX(localz.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject2);
        localObject2 = ad.aVe().G((String)localObject2, true);
        ((ad.b)localObject2).l("prePublishId", "msg_" + localz.field_msgSvrId);
        ((ad.b)localObject2).l("preUsername", localObject1);
        ((ad.b)localObject2).l("preChatName", localObject1);
        ((ad.b)localObject2).l("preMsgIndex", Integer.valueOf(this.pxE.pra));
        ((ad.b)localObject2).l("sendAppMsgScene", Integer.valueOf(1));
        com.tencent.mm.br.c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(this.pxY, this.pxE.pra, this.mContext, (Activity)this.mContext, paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, (Activity)this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).eiy().Hb(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.a)g.af(com.tencent.mm.plugin.brandservice.a.a.class)).a(paramMenuItem, this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", localz.field_content);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
        com.tencent.mm.br.c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        ClipboardHelper.setText(MMApplicationContext.getContext(), localz.field_content);
        com.tencent.mm.ui.base.h.cD(this.mContext, this.mContext.getString(2131755773));
        paramMenuItem = com.tencent.mm.plugin.secinforeport.a.a.CWD;
        com.tencent.mm.plugin.secinforeport.a.a.q(1, localz.field_msgSvrId, Util.getUTF8ByteLength(localz.field_content));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.al
 * JD-Core Version:    0.7.0.1
 */