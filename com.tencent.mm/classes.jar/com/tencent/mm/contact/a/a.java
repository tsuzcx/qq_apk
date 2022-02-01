package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.am;
import com.tencent.mm.model.x;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import junit.framework.Assert;

public final class a
{
  public static am h(an paraman)
  {
    AppMethodBeat.i(221691);
    if (paraman != null) {}
    an localan1;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      an localan2 = ((l)g.ab(l.class)).azF().BH(paraman.field_username);
      if (localan2 != null)
      {
        localan1 = localan2;
        if (!bu.isNullOrNil(localan2.field_username)) {}
      }
      else
      {
        localan1 = paraman;
      }
      localan1.acU();
      if (!an.aUq(paraman.field_username)) {
        break;
      }
      paraman = ((r)g.ab(r.class)).wl(paraman.field_username);
      AppMethodBeat.o(221691);
      return paraman;
    }
    paraman = j(localan1);
    AppMethodBeat.o(221691);
    return paraman;
  }
  
  public static am i(an paraman)
  {
    AppMethodBeat.i(221692);
    boolean bool;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      an localan = ((l)g.ab(l.class)).azF().BH(paraman.field_username);
      if (localan != null)
      {
        localObject = localan;
        if (!bu.isNullOrNil(localan.field_username)) {}
      }
      else
      {
        localObject = paraman;
      }
      ((an)localObject).acV();
      if (!an.aUq(paraman.field_username)) {
        break label119;
      }
    }
    label119:
    for (Object localObject = ((r)g.ab(r.class)).wm(paraman.field_username);; localObject = j((an)localObject))
    {
      if (localObject != null) {
        ((am)localObject).a(new b() {});
      }
      AppMethodBeat.o(221692);
      return localObject;
      bool = false;
      break;
    }
  }
  
  private static am j(an paraman)
  {
    AppMethodBeat.i(221693);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (an.aUq(paraman.field_username)) {
        break;
      }
      paraman = k(paraman);
      AppMethodBeat.o(221693);
      return paraman;
    }
    AppMethodBeat.o(221693);
    return null;
  }
  
  private static am k(an paraman)
  {
    AppMethodBeat.i(221694);
    com.tencent.mm.contact.a.a.b localb = com.tencent.mm.contact.a.a.a.adK();
    localb.a(new k.a(2, x.H(paraman)));
    AppMethodBeat.o(221694);
    return localb;
  }
  
  public static void l(an paraman)
  {
    AppMethodBeat.i(221695);
    boolean bool;
    an localan2;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localan2 = ((l)g.ab(l.class)).azF().BH(paraman.field_username);
      localan1 = paraman;
      if (localan2 != null) {
        if (!bu.isNullOrNil(localan2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (an localan1 = paraman;; localan1 = localan2)
    {
      localan1.acU();
      n(localan1);
      AppMethodBeat.o(221695);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(an paraman)
  {
    AppMethodBeat.i(221696);
    boolean bool;
    an localan2;
    if (paraman != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localan2 = ((l)g.ab(l.class)).azF().BH(paraman.field_username);
      localan1 = paraman;
      if (localan2 != null) {
        if (!bu.isNullOrNil(localan2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (an localan1 = paraman;; localan1 = localan2)
    {
      localan1.acV();
      n(localan1);
      AppMethodBeat.o(221696);
      return;
      bool = false;
      break;
    }
  }
  
  private static void n(an paraman)
  {
    AppMethodBeat.i(221697);
    if (paraman != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paraman.ght == 0)
      {
        ((l)g.ab(l.class)).azF().ao(paraman);
        ((l)g.ab(l.class)).azF().BH(paraman.field_username);
      }
      ((l)g.ab(l.class)).azF().c(paraman.field_username, paraman);
      AppMethodBeat.o(221697);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.contact.a.a
 * JD-Core Version:    0.7.0.1
 */