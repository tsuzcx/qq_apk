package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KContact;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;

public class ContactImpl
  implements KContact
{
  private ad contact;
  
  public ContactImpl(String paramString)
  {
    AppMethodBeat.i(144507);
    g.RM();
    this.contact = ((j)g.E(j.class)).YA().arw(paramString);
    AppMethodBeat.o(144507);
  }
  
  public String displayName()
  {
    AppMethodBeat.i(144508);
    String str = this.contact.Of();
    AppMethodBeat.o(144508);
    return str;
  }
  
  public String userName()
  {
    return this.contact.field_username;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.ContactImpl
 * JD-Core Version:    0.7.0.1
 */