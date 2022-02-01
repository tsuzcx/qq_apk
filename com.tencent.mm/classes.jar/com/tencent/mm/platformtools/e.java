package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.t;
import com.tencent.mm.modelsimple.t.a;
import com.tencent.mm.network.q;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.byn;
import com.tencent.mm.protocal.protobuf.byo;
import com.tencent.mm.protocal.protobuf.dfb;
import com.tencent.mm.protocal.protobuf.dle;
import com.tencent.mm.protocal.protobuf.drp;
import com.tencent.mm.protocal.protobuf.gx;
import com.tencent.mm.sdk.platformtools.bu;
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
    if (((j.g)paramt.hRG.getRespObj()).FGl.HYs == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)paramt.hRG.getRespObj()).FGl.HYs.FRC;
    if ((localObject != null) && (((dfb)localObject).HMl != null) && (((dfb)localObject).HMl.size() > 0))
    {
      t.a locala = new t.a();
      localObject = ((dfb)localObject).HMl.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dle localdle = (dle)((Iterator)localObject).next();
        if (localdle.yxe == 19) {
          locala.dqk = localdle.HSL;
        } else if (localdle.yxe == 20) {
          locala.ioX = localdle.HSL;
        } else if (localdle.yxe == 21) {
          locala.dyI = localdle.HSL;
        }
      }
      locala.ioY = paramBundle;
      locala.type = 0;
      if (!bu.isNullOrNil(locala.dqk))
      {
        locala.username = ((j.f)paramt.hRG.getReqObj()).FGn.Hlo.nIJ;
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