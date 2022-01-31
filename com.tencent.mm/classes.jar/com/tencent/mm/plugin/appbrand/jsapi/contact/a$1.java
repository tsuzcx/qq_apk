package com.tencent.mm.plugin.appbrand.jsapi.contact;

import android.content.Intent;
import android.provider.ContactsContract.Contacts;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h.c;

final class a$1
  implements h.c
{
  a$1(a parama, MMActivity paramMMActivity, c paramc) {}
  
  public final void gl(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      localIntent = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
      a.a(this.gpF, localIntent, this.gpD, this.gpE);
      this.gpD.startActivity(localIntent);
      this.gpD.startActivityForResult(localIntent, hashCode() & 0xFFFF);
      return;
    }
    Intent localIntent = new Intent("android.intent.action.INSERT_OR_EDIT", ContactsContract.Contacts.CONTENT_URI);
    localIntent.setType("vnd.android.cursor.item/person");
    a.a(this.gpF, localIntent, this.gpD, this.gpE);
    this.gpD.startActivityForResult(localIntent, hashCode() & 0xFFFF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.contact.a.1
 * JD-Core Version:    0.7.0.1
 */