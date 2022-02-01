package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.btf;
import com.tencent.mm.protocal.protobuf.btg;
import com.tencent.mm.protocal.protobuf.cyu;
import com.tencent.mm.protocal.protobuf.dew;
import com.tencent.mm.protocal.protobuf.dlb;
import com.tencent.mm.protocal.protobuf.gq;
import com.tencent.mm.sdk.platformtools.bs;
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
    if (((j.g)params.hwy.getRespObj()).DIG.FTR == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)params.hwy.getRespObj()).DIG.FTR.DTK;
    if ((localObject != null) && (((cyu)localObject).FIa != null) && (((cyu)localObject).FIa.size() > 0))
    {
      s.a locala = new s.a();
      localObject = ((cyu)localObject).FIa.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dew localdew = (dew)((Iterator)localObject).next();
        if (localdew.wTD == 19) {
          locala.ddJ = localdew.FOp;
        } else if (localdew.wTD == 20) {
          locala.hSM = localdew.FOp;
        } else if (localdew.wTD == 21) {
          locala.dlQ = localdew.FOp;
        }
      }
      locala.hSN = paramBundle;
      locala.type = 0;
      if (!bs.isNullOrNil(locala.ddJ))
      {
        locala.username = ((j.f)params.hwy.getReqObj()).DII.Fim.ncR;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */