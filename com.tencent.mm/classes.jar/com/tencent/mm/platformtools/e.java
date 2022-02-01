package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.t.a;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.cvb;
import com.tencent.mm.protocal.protobuf.cvc;
import com.tencent.mm.protocal.protobuf.eii;
import com.tencent.mm.protocal.protobuf.eos;
import com.tencent.mm.protocal.protobuf.evr;
import com.tencent.mm.protocal.protobuf.ha;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static t.a a(t paramt, Bundle paramBundle)
  {
    AppMethodBeat.i(151376);
    if (paramt == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    if (((j.g)paramt.lCW.getRespObj()).RBm.Uxi == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)paramt.lCW.getRespObj()).RBm.Uxi.RMf;
    if ((localObject != null) && (((eii)localObject).Ukq != null) && (((eii)localObject).Ukq.size() > 0))
    {
      t.a locala = new t.a();
      localObject = ((eii)localObject).Ukq.iterator();
      while (((Iterator)localObject).hasNext())
      {
        eos localeos = (eos)((Iterator)localObject).next();
        if (localeos.IyZ == 19) {
          locala.fAo = localeos.Uro;
        } else if (localeos.IyZ == 20) {
          locala.maa = localeos.Uro;
        } else if (localeos.IyZ == 21) {
          locala.wording = localeos.Uro;
        }
      }
      locala.mab = paramBundle;
      locala.type = 0;
      if (!Util.isNullOrNil(locala.fAo))
      {
        locala.username = ((j.f)paramt.lCW.getReqObj()).RBo.TCK.UserName;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
  
  public static t.a d(t paramt)
  {
    AppMethodBeat.i(151375);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    paramt = a(paramt, localBundle);
    AppMethodBeat.o(151375);
    return paramt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */