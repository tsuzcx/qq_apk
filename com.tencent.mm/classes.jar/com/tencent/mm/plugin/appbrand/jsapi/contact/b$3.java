package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import android.provider.ContactsContract.Contacts;
import android.view.MenuItem;
import com.tencent.luggage.h.e;
import com.tencent.luggage.h.e.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.jsapi.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.ui.base.n.e;

final class b$3
  implements n.e
{
  b$3(b paramb, a parama, Activity paramActivity, c paramc, int paramInt) {}
  
  public final void onMMMenuItemSelected(MenuItem paramMenuItem, int paramInt)
  {
    AppMethodBeat.i(186008);
    switch (paramInt)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(186008);
      return;
      paramMenuItem = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      b.a(paramMenuItem, this.kNa, this.val$activity, this.cnL);
      Object localObject = this.val$activity;
      com.tencent.mm.hellhoundlib.b.a locala = new com.tencent.mm.hellhoundlib.b.a().bc(paramMenuItem);
      com.tencent.mm.hellhoundlib.a.a.a(localObject, locala.ahE(), "com/tencent/mm/plugin/appbrand/jsapi/contact/JsApiAddPhoneContact$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      ((Activity)localObject).startActivity((Intent)locala.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(localObject, "com/tencent/mm/plugin/appbrand/jsapi/contact/JsApiAddPhoneContact$3", "onMMMenuItemSelected", "(Landroid/view/MenuItem;I)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      localObject = new e.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(186006);
          b.3.this.cnL.h(b.3.this.cjS, b.3.this.kNb.e("ok", null));
          AppMethodBeat.o(186006);
        }
      };
      try
      {
        e.aB(this.val$activity).b(paramMenuItem, (e.b)localObject);
        AppMethodBeat.o(186008);
        return;
      }
      catch (RemoteException localRemoteException1)
      {
        ae.e("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case0, get RemoteException[%s] retry", new Object[] { localRemoteException1 });
        b.D(paramMenuItem);
        e.aB(this.val$activity).a(paramMenuItem, (e.b)localObject);
        AppMethodBeat.o(186008);
        return;
      }
      paramMenuItem = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
      paramMenuItem.setType("vnd.android.cursor.item/person");
      b.a(paramMenuItem, this.kNa, this.val$activity, this.cnL);
      localObject = new e.b()
      {
        public final void a(int paramAnonymousInt, Intent paramAnonymousIntent)
        {
          AppMethodBeat.i(186007);
          b.3.this.cnL.h(b.3.this.cjS, b.3.this.kNb.e("ok", null));
          AppMethodBeat.o(186007);
        }
      };
      try
      {
        e.aB(this.val$activity).b(paramMenuItem, (e.b)localObject);
        AppMethodBeat.o(186008);
        return;
      }
      catch (RemoteException localRemoteException2)
      {
        ae.e("MicroMsg.JsApiAddPhoneContact", "showAddContactMenu case1, get RemoteException[%s] retry", new Object[] { localRemoteException2 });
        e.aB(this.val$activity).a(paramMenuItem, (e.b)localObject);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.b.3
 * JD-Core Version:    0.7.0.1
 */