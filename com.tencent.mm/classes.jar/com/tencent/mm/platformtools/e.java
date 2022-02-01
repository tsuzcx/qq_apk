package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bop;
import com.tencent.mm.protocal.protobuf.boq;
import com.tencent.mm.protocal.protobuf.ctj;
import com.tencent.mm.protocal.protobuf.czk;
import com.tencent.mm.protocal.protobuf.dfm;
import com.tencent.mm.protocal.protobuf.gm;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static s.a a(s params)
  {
    AppMethodBeat.i(151375);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    params = a(params, localBundle);
    AppMethodBeat.o(151375);
    return params;
  }
  
  private static s.a a(s params, Bundle paramBundle)
  {
    AppMethodBeat.i(151376);
    if (params == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    if (((j.g)params.gVZ.getRespObj()).Cqo.EwP == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)params.gVZ.getRespObj()).Cqo.EwP.CBm;
    if ((localObject != null) && (((ctj)localObject).Elc != null) && (((ctj)localObject).Elc.size() > 0))
    {
      s.a locala = new s.a();
      localObject = ((ctj)localObject).Elc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        czk localczk = (czk)((Iterator)localObject).next();
        if (localczk.vJz == 19) {
          locala.dgo = localczk.Ern;
        } else if (localczk.vJz == 20) {
          locala.hsk = localczk.Ern;
        } else if (localczk.vJz == 21) {
          locala.doh = localczk.Ern;
        }
      }
      locala.hsl = paramBundle;
      locala.type = 0;
      if (!bt.isNullOrNil(locala.dgo))
      {
        locala.username = ((j.f)params.gVZ.getReqObj()).Cqq.DLX.mAQ;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */