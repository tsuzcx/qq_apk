package com.tencent.mm.plugin.brandservice.ui.timeline.item;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import android.view.MenuItem;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.af;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.m;
import com.tencent.mm.model.ad;
import com.tencent.mm.model.ad.b;
import com.tencent.mm.model.br;
import com.tencent.mm.plugin.brandservice.d.b;
import com.tencent.mm.plugin.brandservice.d.i;
import com.tencent.mm.plugin.brandservice.ui.timeline.offenread.BizTimeLineHotView;
import com.tencent.mm.plugin.messenger.foundation.a.a.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.secinforeport.a.a;
import com.tencent.mm.protocal.protobuf.apx;
import com.tencent.mm.protocal.protobuf.flj;
import com.tencent.mm.protocal.protobuf.qn;
import com.tencent.mm.protocal.protobuf.qo;
import com.tencent.mm.sdk.platformtools.ClipboardHelper;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.base.u.i;
import java.util.LinkedList;

public final class ak
  implements u.i
{
  private Context mContext;
  private com.tencent.mm.plugin.brandservice.ui.timeline.b vMC;
  private long vMW;
  private boolean vMX = false;
  
  public ak(com.tencent.mm.plugin.brandservice.ui.timeline.b paramb, Context paramContext)
  {
    this.vMC = paramb;
    this.mContext = paramContext;
  }
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(6036);
    if (this.vMC.vFJ == null)
    {
      Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "onMMMenuItemSelected mInfo == null");
      AppMethodBeat.o(6036);
      return;
    }
    final com.tencent.mm.storage.ab localab = this.vMC.vFJ;
    this.vMW = Util.nowSecond();
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localab.field_talker);
      if (paramMenuItem == null)
      {
        Log.e("MicroMsg.BizTimeLineMMMenuItemListener", "changed biz stick status failed, contact is null, talker = " + localab.field_talker);
        AppMethodBeat.o(6036);
        return;
      }
      if (paramMenuItem.aSQ())
      {
        com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(2), Integer.valueOf(3) });
        com.tencent.mm.model.ab.L(localab.field_talker, true);
        com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getString(d.i.biz_time_line_unplacedtop_tips));
        this.vMC.vFK.b(localab, false);
        AppMethodBeat.o(6036);
        return;
      }
      com.tencent.mm.plugin.report.service.h.OAn.b(13307, new Object[] { paramMenuItem.field_username, Integer.valueOf(1), Integer.valueOf(1), Integer.valueOf(3) });
      com.tencent.mm.model.ab.K(localab.field_talker, true);
      com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getString(d.i.biz_time_line_placedtop_tips));
      this.vMC.vFK.b(localab, true);
      AppMethodBeat.o(6036);
      return;
      paramMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(localab.field_talker);
      Object localObject1 = af.bHf().Mn(localab.field_talker);
      ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).b((com.tencent.mm.api.c)localObject1, (Activity)this.mContext, paramMenuItem);
      this.vMC.vFK.d(localab, 2);
      AppMethodBeat.o(6036);
      return;
      if (localab.iYf()) {}
      for (paramMenuItem = this.mContext.getString(d.i.biz_time_line_un_delete_recommend_msg_tips);; paramMenuItem = this.mContext.getString(d.i.biz_time_line_un_delete_msg_tips))
      {
        com.tencent.mm.ui.base.k.a(this.mContext, paramMenuItem, "", this.mContext.getString(d.i.app_ok), this.mContext.getString(d.i.app_cancel), true, new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(6035);
            Object localObject1;
            apx localapx;
            qn localqn;
            Object localObject2;
            int i;
            if (localab.iYf())
            {
              af.bHl().yQ(localab.field_msgId);
              k.a(3, localab.iYp(), null, localab);
              paramAnonymousDialogInterface = ak.a(ak.this).vFK;
              localObject1 = localab;
              if (!((com.tencent.mm.storage.ab)localObject1).iYf()) {
                break label527;
              }
              localObject1 = ((com.tencent.mm.storage.ab)localObject1).iYp();
              if ((localObject1 == null) || (((flj)localObject1).style != 101)) {
                break label288;
              }
              localapx = ((flj)localObject1).abLM;
              localqn = (qn)((qo)localapx.YSB.get(0)).YVI.get(0);
              localObject2 = localqn.YQK;
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
            paramAnonymousDialogInterface.a(((qo)localapx.YSB.get(0)).UserName, l1, paramAnonymousInt, 3, ((flj)localObject1).abry, "", 0, localapx.YSJ, ((flj)localObject1).event, localapx.YSF, localqn.YVE, ((flj)localObject1).style, localqn.YVF);
            for (;;)
            {
              ak.a(ak.this).vFM.o(localab);
              AppMethodBeat.o(6035);
              return;
              br.iu(localab.field_msgId);
              break;
              if ((localObject1 != null) && ((((flj)localObject1).style == 102) || (((flj)localObject1).style == 103)))
              {
                i = 0;
                for (;;)
                {
                  if (i >= ((flj)localObject1).abLM.YSB.size()) {
                    break label525;
                  }
                  localapx = ((flj)localObject1).abLM;
                  int j;
                  if (((qo)localapx.YSB.get(i)).YFu == 0)
                  {
                    localqn = (qn)((qo)localapx.YSB.get(i)).YVI.get(0);
                    if (localqn != null)
                    {
                      localObject2 = localqn.YQK;
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
                  paramAnonymousDialogInterface.a(((qo)localapx.YSB.get(i)).UserName, l1, paramAnonymousInt, 3, ((flj)localObject1).abry, "", 0, localapx.YSJ, ((flj)localObject1).event, localapx.YSF, localqn.YVE, ((flj)localObject1).style, localqn.YVF);
                  break;
                  i += 1;
                }
                continue;
                paramAnonymousDialogInterface.d((com.tencent.mm.storage.ab)localObject1, 3);
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
      paramMenuItem.putExtra("Contact_User", localab.field_talker);
      paramMenuItem.putExtra("Contact_Scene", 90);
      com.tencent.mm.br.c.b(this.mContext, "profile", ".ui.ContactInfoUI", paramMenuItem);
      this.vMC.vFK.d(localab, 1);
      AppMethodBeat.o(6036);
      return;
      if (this.vMX)
      {
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(this.vMC.vFL, this.mContext, localab.field_content, localab.field_talker, localab.field_msgId, localab.field_msgSvrId);
        AppMethodBeat.o(6036);
        return;
      }
      localObject1 = m.a(this.mContext, this.vMC.vFL, localab.field_content, localab.field_talker, localab.field_msgId);
      if (!Util.isNullOrNil((String)localObject1))
      {
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", (String)localObject1);
        paramMenuItem.putExtra("Retr_Msg_Type", 2);
        paramMenuItem.putExtra("Retr_Biz_Msg_Selected_Msg_Index", this.vMC.vFL);
        paramMenuItem.putExtra("Retr_Msg_Id", localab.field_msgId);
        paramMenuItem.putExtra("Retr_MsgFromScene", 1);
        localObject1 = localab.field_talker;
        Object localObject2 = ad.Jo(localab.field_msgSvrId);
        paramMenuItem.putExtra("reportSessionId", (String)localObject2);
        localObject2 = ad.bCb().M((String)localObject2, true);
        ((ad.b)localObject2).q("prePublishId", "msg_" + localab.field_msgSvrId);
        ((ad.b)localObject2).q("preUsername", localObject1);
        ((ad.b)localObject2).q("preChatName", localObject1);
        ((ad.b)localObject2).q("preMsgIndex", Integer.valueOf(this.vMC.vFL));
        ((ad.b)localObject2).q("sendAppMsgScene", Integer.valueOf(1));
        com.tencent.mm.br.c.g(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localab.field_msgId);
        if ((paramMenuItem == null) || (paramMenuItem.field_msgId == 0L))
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(this.vMW, this.vMC.vFL, this.mContext, (Activity)this.mContext, paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localab.field_msgId);
        if ((paramMenuItem == null) || (paramMenuItem.field_msgId == 0L))
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(paramMenuItem, (Activity)this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(localab.field_msgId);
        if ((paramMenuItem == null) || (paramMenuItem.field_msgId == 0L))
        {
          Log.w("MicroMsg.BizTimeLineMMMenuItemListener", "favAppBrandMsg msg is null");
          AppMethodBeat.o(6036);
          return;
        }
        ((com.tencent.mm.plugin.brandservice.api.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.brandservice.api.b.class)).a(paramMenuItem, this.mContext);
        AppMethodBeat.o(6036);
        return;
        paramMenuItem = new Intent();
        paramMenuItem.putExtra("Retr_Msg_content", localab.field_content);
        paramMenuItem.putExtra("Retr_Msg_Type", 4);
        com.tencent.mm.br.c.g(this.mContext, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
        AppMethodBeat.o(6036);
        return;
        ClipboardHelper.setText(MMApplicationContext.getContext(), localab.field_content);
        com.tencent.mm.ui.base.k.cZ(this.mContext, this.mContext.getString(d.i.app_copy_ok));
        paramMenuItem = a.PlY;
        a.x(1, localab.field_msgSvrId, Util.getUTF8ByteLength(localab.field_content));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.timeline.item.ak
 * JD-Core Version:    0.7.0.1
 */