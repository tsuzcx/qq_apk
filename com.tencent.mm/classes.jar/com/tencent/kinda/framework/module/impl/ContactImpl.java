package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KContact;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;

public class ContactImpl
  implements KContact
{
  private as contact;
  
  public ContactImpl(String paramString)
  {
    AppMethodBeat.i(18620);
    h.aHH();
    this.contact = ((n)h.ae(n.class)).bbL().RG(paramString);
    AppMethodBeat.o(18620);
  }
  
  public String displayName()
  {
    AppMethodBeat.i(18621);
    String str = this.contact.ays();
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