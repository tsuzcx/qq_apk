package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.mm.br.d;
import com.tencent.mm.h.a.ku;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a.h;
import com.tencent.mm.protocal.c.xv;
import com.tencent.mm.protocal.c.xw;
import com.tencent.mm.protocal.c.yd;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class i$2
  implements n.d
{
  i$2(i parami) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    long l;
    switch (paramMenuItem.getItemId())
    {
    default: 
      return;
    case 0: 
      this.lKF.bfd();
      return;
    case 1: 
      if (this.lKF.type == 2) {
        com.tencent.mm.plugin.fav.a.h.f(this.lKF.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.lKF.lHZ));
      paramMenuItem.putExtra("Retr_Msg_Type", 9);
      d.e(this.lKF.activity, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      return;
    case 2: 
      this.lKF.bMJ = 0;
      this.lKF.bff();
      return;
    case 3: 
      this.lKF.bfe();
      return;
    case 4: 
      com.tencent.mm.ui.base.h.a(this.lKF.activity, this.lKF.activity.getString(a.h.app_delete_tips), "", new i.2.1(this), null);
      return;
    case 5: 
      l = this.lKF.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_item_id", l);
      paramMenuItem.putExtra("key_fav_scene", 2);
      com.tencent.mm.plugin.fav.a.b.a(this.lKF.activity, ".ui.FavTagEditUI", paramMenuItem);
      return;
    case 6: 
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.lKF.lHZ));
      paramMenuItem.putExtra("Retr_Msg_Id", this.lKF.bIt);
      d.e(this.lKF.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      return;
    }
    try
    {
      l = this.lKF.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      paramMenuItem = ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().eE(l);
      com.tencent.mm.plugin.report.service.h.nFQ.f(15378, new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
      y.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
      paramMenuItem.field_flag = 0;
      paramMenuItem.field_updateTime = System.currentTimeMillis();
      paramMenuItem.field_localId = -1L;
      paramMenuItem.field_sourceType = 6;
      if (paramMenuItem.field_favProto.sXa != null)
      {
        paramMenuItem.field_favProto.sXa.Ys("");
        paramMenuItem.field_favProto.sXa.EQ(6);
        paramMenuItem.field_favProto.sXa.Yq(q.Gj());
      }
      paramMenuItem.field_fromUser = q.Gj();
      Object localObject1 = new LinkedList();
      Object localObject2 = new xv();
      Object localObject3 = new xw();
      ((xw)localObject3).a(paramMenuItem.field_favProto.sWf);
      ((xv)localObject2).a((xw)localObject3);
      ((xv)localObject2).XR("WeNote_0");
      ((xv)localObject2).EH(6);
      ((LinkedList)localObject1).add(0, localObject2);
      paramMenuItem.field_favProto.az((LinkedList)localObject1);
      paramMenuItem.field_type = 18;
      paramMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.s(paramMenuItem);
      localObject1 = new yl();
      localObject3 = this.lKF.activity;
      localObject2 = new ku();
      ((ku)localObject2).bTL.field_localId = paramMenuItem.field_localId;
      ((ku)localObject2).bTL.bTR = 5;
      ((ku)localObject2).bTL.bTN = paramMenuItem.field_xml;
      ((ku)localObject2).bTL.context = ((Context)localObject3);
      localObject3 = new Bundle();
      yd localyd = paramMenuItem.field_favProto.sro;
      if (localyd != null)
      {
        ((Bundle)localObject3).putString("noteauthor", localyd.sWT);
        ((Bundle)localObject3).putString("noteeditor", localyd.sWU);
      }
      ((Bundle)localObject3).putLong("edittime", paramMenuItem.field_updateTime);
      ((ku)localObject2).bTL.bTQ = ((Bundle)localObject3);
      ((ku)localObject2).bTL.field_favProto = paramMenuItem.field_favProto;
      ((ku)localObject2).bTL.type = 2;
      ((ku)localObject2).bTL.bTT = true;
      ((ku)localObject2).bTL.bTU = ((yl)localObject1);
      com.tencent.mm.sdk.b.a.udP.m((com.tencent.mm.sdk.b.b)localObject2);
      this.lKF.activity.finish();
      return;
    }
    catch (Throwable paramMenuItem)
    {
      Toast.makeText(this.lKF.activity, a.h.favorite_save_as_note_failed_1, 0).show();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.2
 * JD-Core Version:    0.7.0.1
 */