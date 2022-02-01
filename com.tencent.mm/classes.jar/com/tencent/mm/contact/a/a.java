package com.tencent.mm.contact.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.contact.d;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.as;
import com.tencent.mm.plugin.messenger.foundation.a.a.k.a;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.plugin.messenger.foundation.a.u;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import junit.framework.Assert;

public final class a
{
  public static as i(au paramau)
  {
    AppMethodBeat.i(233772);
    if (paramau != null) {}
    au localau1;
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      au localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      if (localau2 != null)
      {
        localau1 = localau2;
        if (!Util.isNullOrNil(localau2.field_username)) {}
      }
      else
      {
        localau1 = paramau;
      }
      localau1.aRM();
      if (!au.bwO(paramau.field_username)) {
        break;
      }
      paramau = ((u)h.ax(u.class)).Ea(paramau.field_username);
      AppMethodBeat.o(233772);
      return paramau;
    }
    paramau = k(localau1);
    AppMethodBeat.o(233772);
    return paramau;
  }
  
  public static as j(au paramau)
  {
    AppMethodBeat.i(233773);
    boolean bool;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      au localau = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      if (localau != null)
      {
        localObject = localau;
        if (!Util.isNullOrNil(localau.field_username)) {}
      }
      else
      {
        localObject = paramau;
      }
      ((au)localObject).aRN();
      if (!au.bwO(paramau.field_username)) {
        break label119;
      }
    }
    label119:
    for (Object localObject = ((u)h.ax(u.class)).Eb(paramau.field_username);; localObject = k((au)localObject))
    {
      if (localObject != null) {
        ((as)localObject).a(new b() {});
      }
      AppMethodBeat.o(233773);
      return localObject;
      bool = false;
      break;
    }
  }
  
  private static as k(au paramau)
  {
    AppMethodBeat.i(233778);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if (au.bwO(paramau.field_username)) {
        break;
      }
      paramau = l(paramau);
      AppMethodBeat.o(233778);
      return paramau;
    }
    AppMethodBeat.o(233778);
    return null;
  }
  
  private static as l(au paramau)
  {
    AppMethodBeat.i(233783);
    com.tencent.mm.contact.a.a.b localb = com.tencent.mm.contact.a.a.a.aSZ();
    localb.a(new k.a(2, ab.P(paramau)));
    AppMethodBeat.o(233783);
    return localb;
  }
  
  public static void m(au paramau)
  {
    AppMethodBeat.i(233787);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRM();
      o(localau1);
      AppMethodBeat.o(233787);
      return;
      bool = false;
      break;
    }
  }
  
  public static void n(au paramau)
  {
    AppMethodBeat.i(233791);
    boolean bool;
    au localau2;
    if (paramau != null)
    {
      bool = true;
      Assert.assertTrue(bool);
      localau2 = ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      localau1 = paramau;
      if (localau2 != null) {
        if (!Util.isNullOrNil(localau2.field_username)) {
          break label75;
        }
      }
    }
    label75:
    for (au localau1 = paramau;; localau1 = localau2)
    {
      localau1.aRN();
      o(localau1);
      AppMethodBeat.o(233791);
      return;
      bool = false;
      break;
    }
  }
  
  private static void o(au paramau)
  {
    AppMethodBeat.i(233794);
    if (paramau != null) {}
    for (boolean bool = true;; bool = false)
    {
      Assert.assertTrue(bool);
      if ((int)paramau.maN == 0)
      {
        ((n)h.ax(n.class)).bzA().aC(paramau);
        ((n)h.ax(n.class)).bzA().JE(paramau.field_username);
      }
      ((n)h.ax(n.class)).bzA().d(paramau.field_username, paramau);
      AppMethodBeat.o(233794);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.contact.a.a
 * JD-Core Version:    0.7.0.1
 */