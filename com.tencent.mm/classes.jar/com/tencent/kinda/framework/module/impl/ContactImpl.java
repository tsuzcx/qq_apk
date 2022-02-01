package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KContact;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.k;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;

public class ContactImpl
  implements KContact
{
  private af contact;
  
  public ContactImpl(String paramString)
  {
    AppMethodBeat.i(18620);
    g.afC();
    this.contact = ((k)g.ab(k.class)).apM().aHY(paramString);
    AppMethodBeat.o(18620);
  }
  
  public String displayName()
  {
    AppMethodBeat.i(18621);
    String str = this.contact.ZX();
    AppMethodBeat.o(18621);
    return str;
  }
  
  public String userName()
  {
    return this.contact.field_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ContactImpl
 * JD-Core Version:    0.7.0.1
 */