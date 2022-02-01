package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.m;
import com.tencent.mm.ao.af;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.bq;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.protocal.protobuf.amf;
import com.tencent.mm.protocal.protobuf.eqg;
import com.tencent.mm.protocal.protobuf.pe;
import com.tencent.mm.protocal.protobuf.pf;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aa;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.base.q.g;
import java.util.LinkedList;

public final class an
  implements q.g
{
  private Context mContext;
  private long sHA;
  private boolean sHB = false;
  com.tencent.mm.plugin.brandservice.ui.timeline.b sHf;
  
  public an(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    this.sHf = paramb;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.sHf.szY == null)
    {
      Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    final z localz = this.sHf.szY;
    this.sHA = Util.nowSecond();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localz.field_talker);
      if (paramMenuItem == null)
      {
        Log.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localz.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.ayn())
      {
        com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        ab.H(localz.field_talker, true);
        com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getString(d.i.esU));
        this.sHf.szZ.b(localz, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.h.IzE.a(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      ab.G(localz.field_talker, true);
      com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getString(d.i.suW));
      this.sHf.szZ.b(localz, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(localz.field_talker);
      Object localObject1 = af.bjv().Uo(localz.field_talker);
      ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).b((com.tencent.mm.api.c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.sHf.szZ.g(localz, 2);
      AppMethodBeat.o(6036);
      return;
      if (localz.hwB()) {}
      for (paramMenuItem = this.mContext.getString(d.i.sva);; paramMenuItem = this.mContext.getString(d.i.suZ))
      {
        com.tencent.mm.ui.base.h.a(this.mContext, paramMenuItem, "", this.mContext.getString(d.i.app_ok), this.mContext.getString(d.i.app_cancel), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(6035);
            Object localObject1;
            amf localamf;
            pe localpe;
            Object localObject2;
            int i;
            if (localz.hwB())
            {
              af.bjB().UI(localz.field_msgId);
              l.a(3, localz.hwL(), null, localz);
              paramAnonymousDialogInterface = an.this.sHf.szZ;
              localObject1 = localz;
              if (!((z)localObject1).hwB()) {
                break label527;
              }
              localObject1 = ((z)localObject1).hwL();
              if ((localObject1 == null) || (((eqg)localObject1).style != 101)) {
                break label288;
              }
              localamf = ((eqg)localObject1).UsF;
              localpe = (pe)((pf)localamf.RVd.get(0)).RXM.get(0);
              localObject2 = localpe.RTk;
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
            paramAnonymousDialogInterface.a(((pf)localamf.RVd.get(0)).UserName, l1, paramAnonymousInt, 3, ((eqg)localObject1).Uaw, "", 0, localamf.RVm, ((eqg)localObject1).event, localamf.RVi, localpe.RXJ, ((eqg)localObject1).style, localpe.RXK);
            for (;;)
            {
              an.this.sHf.sAb.p(localz);
              AppMethodBeat.o(6035);
              return;
              bq.Gk(localz.field_msgId);
              break;
              if ((localObject1 != null) && ((((eqg)localObject1).style == 102) || (((eqg)localObject1).style == 103)))
              {
                i = 0;
                for (;;)
                {
                  if (i >= ((eqg)localObject1).UsF.RVd.size()) {
                    break label525;
                  }
                  localamf = ((eqg)localObject1).UsF;
                  int j;
                  if (((pf)localamf.RVd.get(i)).RIs == 0)
                  {
                    localpe = (pe)((pf)localamf.RVd.get(i)).RXM.get(0);
                    if (localpe != null)
                    {
                      localObject2 = localpe.RTk;
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
                  paramAnonymousDialogInterface.a(((pf)localamf.RVd.get(i)).UserName, l1, paramAnonymousInt, 3, ((eqg)localObject1).Uaw, "", 0, localamf.RVm, ((eqg)localObject1).event, localamf.RVi, localpe.RXJ, ((eqg)localObject1).style, localpe.RXK);
                  break;
                  i += 1;
                }
                continue;
                paramAnonymousDialogInterface.g((z)localObject1, 3);
              }
            }
          }
        }, null, d.b.red);
        AppMethodBeat.o(6036);
        return;
      }
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Contact_User", localz.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      com.tencent.mm.by.c.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.sHf.szZ.g(localz, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.sHB)
      {
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.sHf.sAa, this.mContext, localz.field_content, localz.field_talker, localz.field_msgId, localz.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.sHf.sAa, localz.field_content, localz.field_talker, localz.field_msgId);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.sHf.sAa);
        paramMenuItem.putExtra("Retr_Msg_Id", localz.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        localObject1 = localz.field_talker;
        Object localObject2 = ad.Rp(localz.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject2);
        localObject2 = ad.beh().I((String)localObject2, true);
        ((ad.b)localObject2).k("prePublishId", "msg_" + localz.field_msgSvrId);
        ((ad.b)localObject2).k("preUsername", localObject1);
        ((ad.b)localObject2).k("preChatName", localObject1);
        ((ad.b)localObject2).k("preMsgIndex", Integer.valueOf(this.sHf.sAa));
        ((ad.b)localObject2).k("sendAppMsgScene", Integer.valueOf(1));
        com.tencent.mm.by.c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(this.sHA, this.sHf.sAa, this.mContext, (Activity)this.mContext, paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramMenuItem, (Activity)this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(localz.field_msgId);
        if (paramMenuItem.field_msgId == 0L)
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.brandservice.a.b.class)).a(paramMenuItem, this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", localz.field_content);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
        com.tencent.mm.by.c.f(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        ClipboardHelper.setText(MMApplicationContext.getContext(), localz.field_content);
        com.tencent.mm.ui.base.h.cO(this.mContext, this.mContext.getString(d.i.app_copy_ok));
        paramMenuItem = a.Jcj;
        a.s(1, localz.field_msgSvrId, Util.getUTF8ByteLength(localz.field_content));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.an
 * JD-Core Version:    0.7.0.1
 */