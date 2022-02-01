package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.t.a;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.cmf;
import com.tencent.mm.protocal.protobuf.cmg;
import com.tencent.mm.protocal.protobuf.dyh;
import com.tencent.mm.protocal.protobuf.eer;
import com.tencent.mm.protocal.protobuf.ell;
import com.tencent.mm.protocal.protobuf.hk;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static t.a a(t paramt)
  {
    AppMethodBeat.i(151375);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    paramt = a(paramt, localBundle);
    AppMethodBeat.o(151375);
    return paramt;
  }
  
  private static t.a a(t paramt, Bundle paramBundle)
  {
    AppMethodBeat.i(151376);
    if (paramt == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    if (((j.g)paramt.iMO.getRespObj()).Kzw.Nky == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)paramt.iMO.getRespObj()).Kzw.Nky.KLj;
    if ((localObject != null) && (((dyh)localObject).MXV != null) && (((dyh)localObject).MXV.size() > 0))
    {
      t.a locala = new t.a();
      localObject = ((dyh)localObject).MXV.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eer localeer = (eer)((Iterator)localObject).next();
        if (localeer.Cya == 19) {
          locala.dHx = localeer.NeO;
        } else if (localeer.Cya == 20) {
          locala.jke = localeer.NeO;
        } else if (localeer.Cya == 21) {
          locala.dQx = localeer.NeO;
        }
      }
      locala.jkf = paramBundle;
      locala.type = 0;
      if (!Util.isNullOrNil(locala.dHx))
      {
        locala.username = ((j.f)paramt.iMO.getReqObj()).Kzy.MrA.UserName;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */