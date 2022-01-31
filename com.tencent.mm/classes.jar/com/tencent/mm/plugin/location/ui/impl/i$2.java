package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.g.a.li;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acb;
import com.tencent.mm.protocal.protobuf.ack;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.base.n.d;
import java.util.LinkedList;

final class i$2
  implements n.d
{
  i$2(i parami) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(113740);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(113740);
      return;
      this.ohX.bMB();
      AppMethodBeat.o(113740);
      return;
      if (this.ohX.type == 2) {
        com.tencent.mm.plugin.fav.a.h.i(this.ohX.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1, 0);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.ohX.ofm));
      paramMenuItem.putExtra("Retr_Msg_Type", 9);
      d.f(this.ohX.activity, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(113740);
      return;
      this.ohX.cud = 0;
      this.ohX.bMD();
      AppMethodBeat.o(113740);
      return;
      this.ohX.bMC();
      AppMethodBeat.o(113740);
      return;
      com.tencent.mm.ui.base.h.a(this.ohX.activity, this.ohX.activity.getString(2131296902), "", new i.2.1(this), null);
      AppMethodBeat.o(113740);
      return;
      long l = this.ohX.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_item_id", l);
      paramMenuItem.putExtra("key_fav_scene", 2);
      com.tencent.mm.plugin.fav.a.b.b(this.ohX.activity, ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(113740);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.ohX.ofm));
      paramMenuItem.putExtra("Retr_Msg_Id", this.ohX.cpO);
      d.f(this.ohX.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      AppMethodBeat.o(113740);
      return;
      try
      {
        l = this.ohX.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
        paramMenuItem = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(l);
        com.tencent.mm.plugin.report.service.h.qsU.e(15378, new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        ab.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        paramMenuItem.field_flag = 0;
        paramMenuItem.field_updateTime = System.currentTimeMillis();
        paramMenuItem.field_localId = -1L;
        paramMenuItem.field_sourceType = 6;
        if (paramMenuItem.field_favProto.wVa != null)
        {
          paramMenuItem.field_favProto.wVa.aop("");
          paramMenuItem.field_favProto.wVa.MR(6);
          paramMenuItem.field_favProto.wVa.aon(r.Zn());
        }
        paramMenuItem.field_fromUser = r.Zn();
        Object localObject1 = new LinkedList();
        Object localObject2 = new aca();
        Object localObject3 = new acb();
        ((acb)localObject3).a(paramMenuItem.field_favProto.wUd);
        ((aca)localObject2).a((acb)localObject3);
        ((aca)localObject2).anN("WeNote_0");
        ((aca)localObject2).MI(6);
        ((LinkedList)localObject1).add(0, localObject2);
        paramMenuItem.field_favProto.aJ((LinkedList)localObject1);
        paramMenuItem.field_type = 18;
        paramMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.s(paramMenuItem);
        localObject1 = new acs();
        localObject3 = this.ohX.activity;
        localObject2 = new li();
        ((li)localObject2).cBr.field_localId = paramMenuItem.field_localId;
        ((li)localObject2).cBr.cBx = 5;
        ((li)localObject2).cBr.cBt = paramMenuItem.field_xml;
        ((li)localObject2).cBr.context = ((Context)localObject3);
        localObject3 = new Bundle();
        ack localack = paramMenuItem.field_favProto.wjV;
        if (localack != null)
        {
          ((Bundle)localObject3).putString("noteauthor", localack.wUT);
          ((Bundle)localObject3).putString("noteeditor", localack.wUU);
        }
        ((Bundle)localObject3).putLong("edittime", paramMenuItem.field_updateTime);
        ((li)localObject2).cBr.cBw = ((Bundle)localObject3);
        ((li)localObject2).cBr.field_favProto = paramMenuItem.field_favProto;
        ((li)localObject2).cBr.type = 2;
        ((li)localObject2).cBr.cBz = true;
        ((li)localObject2).cBr.cBA = ((acs)localObject1);
        com.tencent.mm.sdk.b.a.ymk.l((com.tencent.mm.sdk.b.b)localObject2);
        this.ohX.activity.finish();
        AppMethodBeat.o(113740);
        return;
      }
      catch (Throwable paramMenuItem)
      {
        Toast.makeText(this.ohX.activity, 2131299817, 0).show();
        AppMethodBeat.o(113740);
        return;
      }
      i.a(this.ohX);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.i.2
 * JD-Core Version:    0.7.0.1
 */