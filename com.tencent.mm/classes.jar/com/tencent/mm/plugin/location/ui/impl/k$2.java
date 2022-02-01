package com.tencent.mm.plugin.location.ui.impl;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.di;
import com.tencent.mm.autogen.a.di.b;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.location.model.e;
import com.tencent.mm.plugin.map.a.i;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.u.i;

final class k$2
  implements u.i
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
      this.KkT.fVW();
      AppMethodBeat.o(56202);
      return;
      if (this.KkT.type == 2) {
        com.tencent.mm.plugin.fav.a.h.I(this.KkT.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L), 1);
      }
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.KkT.sai));
      paramMenuItem.putExtra("Retr_Msg_Type", 9);
      c.g(this.KkT.activity, ".ui.transmit.MsgRetransmitUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      this.KkT.hHJ = 0;
      this.KkT.fVY();
      AppMethodBeat.o(56202);
      return;
      this.KkT.fVX();
      AppMethodBeat.o(56202);
      return;
      com.tencent.mm.ui.base.k.a(this.KkT.activity, this.KkT.activity.getString(a.i.app_delete_tips), "", new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(56201);
          long l = k.2.this.KkT.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
          paramAnonymousDialogInterface = new di();
          paramAnonymousDialogInterface.hDl.hDn = l;
          paramAnonymousDialogInterface.publish();
          boolean bool = Util.nullAs(Boolean.valueOf(paramAnonymousDialogInterface.hDm.hCQ), false);
          Log.d("MicroMsg.ViewMapUI", "do del fav voice, local id %d, result %B", new Object[] { Long.valueOf(l), Boolean.valueOf(bool) });
          if (bool) {
            k.2.this.KkT.activity.finish();
          }
          AppMethodBeat.o(56201);
        }
      }, null);
      AppMethodBeat.o(56202);
      return;
      long l = this.KkT.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("key_fav_item_id", l);
      paramMenuItem.putExtra("key_fav_scene", 2);
      b.b(this.KkT.activity, ".ui.FavTagEditUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      paramMenuItem = new Intent();
      paramMenuItem.putExtra("Retr_Msg_content", e.a(this.KkT.sai));
      paramMenuItem.putExtra("Retr_Msg_Id", this.KkT.msgId);
      c.g(this.KkT.activity, ".ui.chatting.ChattingSendDataToDeviceUI", paramMenuItem);
      AppMethodBeat.o(56202);
      return;
      try
      {
        l = this.KkT.activity.getIntent().getLongExtra("kFavInfoLocalId", -1L);
        paramMenuItem = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(l);
        com.tencent.mm.plugin.report.service.h.OAn.b(15378, new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        Log.d("MicroMsg.ViewMapUI", "report 15378, id:%s, type:%s", new Object[] { Integer.valueOf(paramMenuItem.field_id), Integer.valueOf(paramMenuItem.field_type) });
        k.M(paramMenuItem);
        arx localarx = new arx();
        k.j(this.KkT.activity, paramMenuItem, localarx);
        this.KkT.activity.finish();
        AppMethodBeat.o(56202);
        return;
      }
      finally
      {
        Toast.makeText(this.KkT.activity, a.i.favorite_save_as_note_failed_1, 0).show();
        AppMethodBeat.o(56202);
        return;
      }
      k.a(this.KkT);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.impl.k.2
 * JD-Core Version:    0.7.0.1
 */