package com.tencent.mm.plugin.expt.hellhound.a.b.b;

import a.f.b.j;
import a.l;
import a.m;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.ava;
import com.tencent.mm.protocal.protobuf.bke;
import com.tencent.mm.protocal.protobuf.bki;
import com.tencent.mm.sdk.platformtools.ab;
import java.util.LinkedList;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/expt/hellhound/ext/session/dao/HellKSessionDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a.a maZ;
  
  static
  {
    AppMethodBeat.i(152525);
    maZ = new a.a((byte)0);
    AppMethodBeat.o(152525);
  }
  
  public static final void MG(String paramString)
  {
    AppMethodBeat.i(152537);
    if (!TextUtils.isEmpty((CharSequence)paramString))
    {
      ava localava = a.a.bsm();
      if ((localava == null) || (localava.xkk.isEmpty()))
      {
        AppMethodBeat.o(152537);
        return;
      }
      int i = localava.xkk.size();
      ab.d("HellSessionDao", "habbyge-mali, clearCurSession, length: " + paramString + ", " + i);
      i -= 1;
      while (i >= 0)
      {
        bki localbki = (bki)localava.xkk.get(i);
        if (localbki != null)
        {
          ab.d("HellSessionDao", "habbyge-mali, clearCurSession, length: " + localbki.czq);
          if (j.e(paramString, localbki.czq))
          {
            localava.xkk.remove(i);
            localava.xkl = (localava.xkk.size() - 1);
            a.a.c(localava);
            AppMethodBeat.o(152537);
            return;
          }
        }
        i -= 1;
      }
    }
    AppMethodBeat.o(152537);
  }
  
  public static final void a(bke parambke)
  {
    AppMethodBeat.i(152534);
    ava localava2 = a.a.bsm();
    ava localava1 = localava2;
    if (localava2 == null) {
      localava1 = new ava();
    }
    localava1.xkm.addLast(parambke);
    localava1.xkn = (localava1.xkm.size() - 1);
    ab.i("HellSessionDao", "HABBYGE-MALI, addUnknownPage, page: " + localava1.xkn + ", " + localava1.xkm.size());
    a.a.c(localava1);
    AppMethodBeat.o(152534);
  }
  
  public static final void b(ava paramava)
  {
    AppMethodBeat.i(152532);
    if (paramava != null) {
      a.a.c(paramava);
    }
    AppMethodBeat.o(152532);
  }
  
  public static final void b(bke parambke)
  {
    AppMethodBeat.i(152536);
    if (parambke != null)
    {
      ava localava = a.a.bsm();
      if (localava == null)
      {
        AppMethodBeat.o(152536);
        return;
      }
      if (a.a.e(localava))
      {
        bke localbke = (bke)localava.xkm.set(localava.xkn, parambke);
        if (localbke != null) {
          ab.d("HellSessionDao", "habbyge-mali, updateCurUnknownPage, oldPage: " + localbke.xkf + "/" + localbke.startTime + "/" + localbke.endTime);
        }
        ab.d("HellSessionDao", "habbyge-mali, updateCurUnknownPage, newPage: " + parambke.xkf + "/" + parambke.startTime + "/" + parambke.endTime);
        a.a.c(localava);
      }
    }
    AppMethodBeat.o(152536);
  }
  
  public static final long bsh()
  {
    AppMethodBeat.i(152526);
    ava localava2 = a.a.bsm();
    ava localava1 = localava2;
    if (localava2 == null) {
      localava1 = new ava();
    }
    long l = localava1.xkp;
    localava1.xkp = (1L + l);
    a.a.c(localava1);
    AppMethodBeat.o(152526);
    return l;
  }
  
  public static final void bsi()
  {
    AppMethodBeat.i(152527);
    ava localava = a.a.bsm();
    if (localava == null)
    {
      AppMethodBeat.o(152527);
      return;
    }
    localava.xkp = 0L;
    a.a.c(localava);
    AppMethodBeat.o(152527);
  }
  
  public static final bki bsj()
  {
    AppMethodBeat.i(152530);
    Object localObject = a.a.bsm();
    if (localObject == null)
    {
      AppMethodBeat.o(152530);
      return null;
    }
    boolean bool = a.a.d((ava)localObject);
    if (bool == true)
    {
      localObject = (bki)((ava)localObject).xkk.get(((ava)localObject).xkl);
      AppMethodBeat.o(152530);
      return localObject;
    }
    if (!bool)
    {
      AppMethodBeat.o(152530);
      return null;
    }
    localObject = new m();
    AppMethodBeat.o(152530);
    throw ((Throwable)localObject);
  }
  
  public static final ava bsk()
  {
    AppMethodBeat.i(152531);
    ava localava = a.a.bsm();
    AppMethodBeat.o(152531);
    return localava;
  }
  
  public static final bke bsl()
  {
    AppMethodBeat.i(152535);
    Object localObject = a.a.bsm();
    if (localObject == null)
    {
      AppMethodBeat.o(152535);
      return null;
    }
    boolean bool = a.a.e((ava)localObject);
    if (bool == true)
    {
      localObject = (bke)((ava)localObject).xkm.get(((ava)localObject).xkn);
      AppMethodBeat.o(152535);
      return localObject;
    }
    if (!bool)
    {
      AppMethodBeat.o(152535);
      return null;
    }
    localObject = new m();
    AppMethodBeat.o(152535);
    throw ((Throwable)localObject);
  }
  
  public static final void e(bki parambki)
  {
    AppMethodBeat.i(152528);
    j.q(parambki, "session");
    ava localava2 = a.a.bsm();
    ava localava1 = localava2;
    if (localava2 == null) {
      localava1 = new ava();
    }
    localava1.xkk.addLast(parambki);
    localava1.xkl = (localava1.xkk.size() - 1);
    ab.i("HellSessionDao", "habbyge-mali, addSession: " + parambki.czq);
    a.a.c(localava1);
    AppMethodBeat.o(152528);
  }
  
  public static final void f(bki parambki)
  {
    AppMethodBeat.i(152529);
    j.q(parambki, "newSession");
    ava localava = a.a.bsm();
    if (localava == null)
    {
      AppMethodBeat.o(152529);
      return;
    }
    if (a.a.d(localava))
    {
      ab.d("HellSessionDao", "habbyge-mali, updateCurSession, " + localava.xkl);
      bki localbki = (bki)localava.xkk.set(localava.xkl, parambki);
      if (localbki != null) {
        ab.d("HellSessionDao", "habbyge-mali, updateCurSession, oldSession: " + localbki.czq + "/" + localbki.xyK + "/" + localbki.xyL);
      }
      ab.d("HellSessionDao", "habbyge-mali, updateCurSession, newSession: " + parambki.czq + "/" + parambki.xyK + "/" + parambki.xyL);
      a.a.c(localava);
    }
    AppMethodBeat.o(152529);
  }
  
  public static final void g(bki parambki)
  {
    AppMethodBeat.i(152533);
    if (parambki != null)
    {
      ava localava = a.a.bsm();
      if (localava == null)
      {
        AppMethodBeat.o(152533);
        return;
      }
      if (a.a.d(localava))
      {
        localava.xkk.set(localava.xkl, parambki);
        localava.xkl = -1;
        a.a.c(localava);
      }
    }
    AppMethodBeat.o(152533);
  }
  
  public static final void reset()
  {
    AppMethodBeat.i(152538);
    b.v("mmkv_key_hell_sessions", new byte[0]);
    AppMethodBeat.o(152538);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.b.a
 * JD-Core Version:    0.7.0.1
 */