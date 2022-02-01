package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ar;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import junit.framework.Assert;

public final class a
{
  public static ar h(as paramas)
  {
    AppMethodBeat.i(188802);
    if (paramas != null) {}
    as localas1;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      as localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      if (localas2 != null)
      {
        localas1 = localas2;
        if (!Util.isNullOrNil(localas2.field_username)) {}
      }
      else
      {
        localas1 = paramas;
      }
      localas1.axm();
      if (!as.bvK(paramas.field_username)) {
        break;
      }
      paramas = ((u)h.ae(u.class)).Lt(paramas.field_username);
      AppMethodBeat.o(188802);
      return paramas;
    }
    paramas = j(localas1);
    AppMethodBeat.o(188802);
    return paramas;
  }
  
  public static ar i(as paramas)
  {
    AppMethodBeat.i(188805);
    boolean bool;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      as localas = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      if (localas != null)
      {
        localObject = localas;
        if (!Util.isNullOrNil(localas.field_username)) {}
      }
      else
      {
        localObject = paramas;
      }
      ((as)localObject).axn();
      if (!as.bvK(paramas.field_username)) {
        break label119;
      }
    }
    label119:
    for (Object localObject = ((u)h.ae(u.class)).Lu(paramas.field_username);; localObject = j((as)localObject))
    {
      if (localObject != null) {
        ((ar)localObject).a(new b() {});
      }
      AppMethodBeat.o(188805);
      return localObject;
      bool = false;
      break;
    }
  }
  
  private static ar j(as paramas)
  {
    AppMethodBeat.i(188807);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (as.bvK(paramas.field_username)) {
        break;
      }
      paramas = k(paramas);
      AppMethodBeat.o(188807);
      return paramas;
    }
    AppMethodBeat.o(188807);
    return null;
  }
  
  private static ar k(as paramas)
  {
    AppMethodBeat.i(188809);
    com.tencent.mm.contact.a.a.b localb = com.tencent.mm.contact.a.a.a.ayw();
    localb.a(new k.a(2, ab.O(paramas)));
    AppMethodBeat.o(188809);
    return localb;
  }
  
  public static void l(as paramas)
  {
    AppMethodBeat.i(188814);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
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
      localas1.axm();
      n(localas1);
      AppMethodBeat.o(188814);
      return;
      bool = false;
      break;
    }
  }
  
  public static void m(as paramas)
  {
    AppMethodBeat.i(188816);
    boolean bool;
    as localas2;
    if (paramas != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localas2 = ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
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
      localas1.axn();
      n(localas1);
      AppMethodBeat.o(188816);
      return;
      bool = false;
      break;
    }
  }
  
  private static void n(as paramas)
  {
    AppMethodBeat.i(188819);
    if (paramas != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramas.jxt == 0)
      {
        ((n)h.ae(n.class)).bbL().aw(paramas);
        ((n)h.ae(n.class)).bbL().RG(paramas.field_username);
      }
      ((n)h.ae(n.class)).bbL().c(paramas.field_username, paramas);
      AppMethodBeat.o(188819);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.contact.a.a
 * JD-Core Version:    0.7.0.1
 */