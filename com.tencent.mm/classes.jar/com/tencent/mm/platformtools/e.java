package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bce;
import com.tencent.mm.protocal.protobuf.bcf;
import com.tencent.mm.protocal.protobuf.cco;
import com.tencent.mm.protocal.protobuf.cij;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.ft;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  public static s.a a(s params)
  {
    AppMethodBeat.i(79001);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    params = a(params, localBundle);
    AppMethodBeat.o(79001);
    return params;
  }
  
  private static s.a a(s params, Bundle paramBundle)
  {
    AppMethodBeat.i(79002);
    if (params == null)
    {
      AppMethodBeat.o(79002);
      return null;
    }
    if (((j.g)params.ftU.getRespObj()).wil.xWm == null)
    {
      AppMethodBeat.o(79002);
      return null;
    }
    Object localObject = ((j.g)params.ftU.getRespObj()).wil.xWm.wrV;
    if ((localObject != null) && (((cco)localObject).xNc != null) && (((cco)localObject).xNc.size() > 0))
    {
      s.a locala = new s.a();
      localObject = ((cco)localObject).xNc.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cij localcij = (cij)((Iterator)localObject).next();
        if (localcij.qsk == 19) {
          locala.crs = localcij.xSX;
        } else if (localcij.qsk == 20) {
          locala.fPF = localcij.xSX;
        } else if (localcij.qsk == 21) {
          locala.cyA = localcij.xSX;
        }
      }
      locala.fPG = paramBundle;
      locala.type = 0;
      if (!bo.isNullOrNil(locala.crs))
      {
        locala.username = ((j.f)params.ftU.getReqObj()).win.xrm.jJA;
        AppMethodBeat.o(79002);
        return locala;
      }
    }
    AppMethodBeat.o(79002);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */