package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.g.a.oc;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.amm;
import com.tencent.mm.protocal.protobuf.amv;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.base.o.g;
import java.util.LinkedList;

final class k$2
  implements o.g
{
  k$2(k paramk) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(56202);
    switch (paramMenuItem.getItemId())
    {
    }
    for (;;)
    {
      AppMethodBeat.o(56202);
      return;
      this.yOp.eej();
      AppMethodBeat.o(56202);
      return;
      if (this.yOp.type == 2) {
        com.tencent.mm.plugin.fav.a.h.w(this.yOp.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.yOp.lXk));
      paramMenuItem.putExtra("Retr_Msg_Type", 9);
      c.f(this.yOp.activity, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      this.yOp.dKf = 0;
      this.yOp.eel();
      AppMethodBeat.o(56202);
      return;
      this.yOp.eek();
      AppMethodBeat.o(56202);
      return;
      com.tencent.mm.ui.base.h.a(this.yOp.activity, this.yOp.activity.getString(2131755780), "", new k.2.1(this), null);
      AppMethodBeat.o(56202);
      return;
      long l = this.yOp.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_item_id", l);
      paramMenuItem.putExtra("key_fav_scene", 2);
      b.b(this.yOp.activity, ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.yOp.lXk));
      paramMenuItem.putExtra("Retr_Msg_Id", this.yOp.msgId);
      c.f(this.yOp.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      try
      {
        l = this.yOp.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
        paramMenuItem = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(l);
        com.tencent.mm.plugin.report.service.h.CyF.a(15378, new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        Log.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        paramMenuItem.field_flag = 0;
        paramMenuItem.field_updateTime = System.currentTimeMillis();
        paramMenuItem.field_localId = -1L;
        paramMenuItem.field_sourceType = 6;
        if (paramMenuItem.field_favProto.Lya != null)
        {
          paramMenuItem.field_favProto.Lya.bhh("");
          paramMenuItem.field_favProto.Lya.ajm(6);
          paramMenuItem.field_favProto.Lya.bhf(z.aTY());
        }
        paramMenuItem.field_fromUser = z.aTY();
        Object localObject1 = new LinkedList();
        Object localObject2 = new aml();
        Object localObject3 = new amm();
        ((amm)localObject3).c(paramMenuItem.field_favProto.LwQ);
        ((aml)localObject2).a((amm)localObject3);
        ((aml)localObject2).bgC("WeNote_0");
        ((aml)localObject2).ajd(6);
        ((LinkedList)localObject1).add(0, localObject2);
        paramMenuItem.field_favProto.bH((LinkedList)localObject1);
        paramMenuItem.field_type = 18;
        paramMenuItem.field_xml = com.tencent.mm.plugin.fav.a.g.t(paramMenuItem);
        localObject1 = new and();
        localObject3 = this.yOp.activity;
        localObject2 = new oc();
        ((oc)localObject2).dUe.field_localId = paramMenuItem.field_localId;
        ((oc)localObject2).dUe.dUn = 5;
        ((oc)localObject2).dUe.dUg = paramMenuItem.field_xml;
        ((oc)localObject2).dUe.context = ((Context)localObject3);
        localObject3 = new Bundle();
        amv localamv = paramMenuItem.field_favProto.KBr;
        if (localamv != null)
        {
          ((Bundle)localObject3).putString("noteauthor", localamv.LxT);
          ((Bundle)localObject3).putString("noteeditor", localamv.LxU);
        }
        ((Bundle)localObject3).putLong("edittime", paramMenuItem.field_updateTime);
        ((oc)localObject2).dUe.dUl = ((Bundle)localObject3);
        ((oc)localObject2).dUe.field_favProto = paramMenuItem.field_favProto;
        ((oc)localObject2).dUe.type = 2;
        ((oc)localObject2).dUe.dUo = true;
        ((oc)localObject2).dUe.dUp = ((and)localObject1);
        EventCenter.instance.publish((IEvent)localObject2);
        this.yOp.activity.finish();
        AppMethodBeat.o(56202);
        return;
      }
      catch (Throwable paramMenuItem)
      {
        Toast.makeText(this.yOp.activity, 2131759316, 0).show();
        AppMethodBeat.o(56202);
        return;
      }
      k.a(this.yOp);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k.2
 * JD-Core Version:    0.7.0.1
 */