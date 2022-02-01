package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.s;
import com.tencent.mm.modelsimple.s.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.bxt;
import com.tencent.mm.protocal.protobuf.bxu;
import com.tencent.mm.protocal.protobuf.deh;
import com.tencent.mm.protocal.protobuf.dkj;
import com.tencent.mm.protocal.protobuf.dqs;
import com.tencent.mm.protocal.protobuf.gx;
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
    if (((j.g)params.hON.getRespObj()).FnN.HEF == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)params.hON.getRespObj()).FnN.HEF.Fze;
    if ((localObject != null) && (((deh)localObject).HsI != null) && (((deh)localObject).HsI.size() > 0))
    {
      s.a locala = new s.a();
      localObject = ((deh)localObject).HsI.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dkj localdkj = (dkj)((Iterator)localObject).next();
        if (localdkj.yhn == 19) {
          locala.dpf = localdkj.Hza;
        } else if (localdkj.yhn == 20) {
          locala.imd = localdkj.Hza;
        } else if (localdkj.yhn == 21) {
          locala.dxD = localdkj.Hza;
        }
      }
      locala.ime = paramBundle;
      locala.type = 0;
      if (!bt.isNullOrNil(locala.dpf))
      {
        locala.username = ((j.f)params.hON.getReqObj()).FnP.GRN.nDo;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */