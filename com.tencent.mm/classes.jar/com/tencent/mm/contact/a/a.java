package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.c;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.aq;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.plugin.messenger.foundation.a.r;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class a
{
  public static aq h(as paramas)
  {
    AppMethodBeat.i(257873);
    if (paramas != null) {}
    as localas1;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((l)g.af(l.class)).aSN().Kn(paramas.field_username);
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.aqS();
      if (!as.bjp(paramas.field_username)) {
        break;
      }
      paramas = ((r)g.af(r.class)).EA(paramas.field_username);
      AppMethodBeat.o(257873);
      return paramas;
    }
    paramas = j(localas1);
    AppMethodBeat.o(257873);
    return paramas;
  }
  
  public static aq i(as paramas)
  {
    AppMethodBeat.i(257874);
    boolean bool;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      as localas = ((l)g.af(l.class)).aSN().Kn(paramas.field_username);
      if (localas != null)
      {
        localObject = localas;
        if (!Util.isNullOrNil(localas.field_username)) {}
      }
      else
      {
        localObject = paramas;
      }
      ((as)localObject).aqT();
      if (!as.bjp(paramas.field_username)) {
        break label119;
      }
    }
    label119:
    for (Object localObject = ((r)g.af(r.class)).EB(paramas.field_username);; localObject = j((as)localObject))
    {
      if (localObject != null) {
        ((aq)localObject).a(new b() {});
      }
      AppMethodBeat.o(257874);
      return localObject;
      bool = false;
      break;
    }
  }
  
  private static aq j(as paramas)
  {
    AppMethodBeat.i(257875);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (as.bjp(paramas.field_username)) {
        break;
      }
      paramas = k(paramas);
      AppMethodBeat.o(257875);
      return paramas;
    }
    AppMethodBeat.o(257875);
    return null;
  }
  
  private static aq k(as paramas)
  {
    AppMethodBeat.i(257876);
    com.tencent.mm.contact.a.a.b localb = com.tencent.mm.contact.a.a.a.arN();
    localb.a(new k.a(2, ab.H(paramas)));
    AppMethodBeat.o(257876);
    return localb;
  }
  
  public static void l(as paramas)
  {
    AppMethodBeat.i(257877);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((l)g.af(l.class)).aSN().Kn(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (as localas1 = paramas;; localas1 = localas2)
    {
      localas1.aqS();
      n(localas1);
      AppMethodBeat.o(257877);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(as paramas)
  {
    AppMethodBeat.i(257878);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((l)g.af(l.class)).aSN().Kn(paramas.field_username);
      localas1 = paramas;
      if (localas2 != null) {
        if (!Util.isNullOrNil(localas2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (as localas1 = paramas;; localas1 = localas2)
    {
      localas1.aqT();
      n(localas1);
      AppMethodBeat.o(257878);
      return;
      bool = false;
      break;
    }
  }
  
  private static void n(as paramas)
  {
    AppMethodBeat.i(257879);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramas.gMZ == 0)
      {
        ((l)g.af(l.class)).aSN().aq(paramas);
        ((l)g.af(l.class)).aSN().Kn(paramas.field_username);
      }
      ((l)g.af(l.class)).aSN().c(paramas.field_username, paramas);
      AppMethodBeat.o(257879);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a.a
 * JD-Core Version:    0.7.0.1
 */