package com.tencent.mm.platformtools;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelsimple.u;
import com.tencent.mm.modelsimple.u.a;
import com.tencent.mm.network.s;
import com.tencent.mm.protocal.j.f;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.protobuf.dmh;
import com.tencent.mm.protocal.protobuf.dmi;
import com.tencent.mm.protocal.protobuf.fck;
import com.tencent.mm.protocal.protobuf.fjq;
import com.tencent.mm.protocal.protobuf.frg;
import com.tencent.mm.protocal.protobuf.hw;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Iterator;
import java.util.LinkedList;

public final class e
{
  private static u.a a(u paramu, Bundle paramBundle)
  {
    AppMethodBeat.i(151376);
    if (paramu == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    if (((j.g)paramu.ouH.getRespObj()).YxP.abQQ == null)
    {
      AppMethodBeat.o(151376);
      return null;
    }
    Object localObject = ((j.g)paramu.ouH.getRespObj()).YxP.abQQ.YJt;
    if ((localObject != null) && (((fck)localObject).abBZ != null) && (((fck)localObject).abBZ.size() > 0))
    {
      u.a locala = new u.a();
      localObject = ((fck)localObject).abBZ.iterator();
      while (((Iterator)localObject).hasNext())
      {
        fjq localfjq = (fjq)((Iterator)localObject).next();
        if (localfjq.OzG == 19) {
          locala.hFb = localfjq.abKm;
        } else if (localfjq.OzG == 20) {
          locala.oSR = localfjq.abKm;
        } else if (localfjq.OzG == 21) {
          locala.wording = localfjq.abKm;
        }
      }
      locala.oSS = paramBundle;
      locala.type = 0;
      if (!Util.isNullOrNil(locala.hFb))
      {
        locala.username = ((j.f)paramu.ouH.getReqObj()).YxR.aaSr.UserName;
        AppMethodBeat.o(151376);
        return locala;
      }
    }
    AppMethodBeat.o(151376);
    return null;
  }
  
  public static u.a d(u paramu)
  {
    AppMethodBeat.i(151375);
    Bundle localBundle = new Bundle();
    localBundle.putInt("kscene_type", 73);
    paramu = a(paramu, localBundle);
    AppMethodBeat.o(151375);
    return paramu;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.platformtools.e
 * JD-Core Version:    0.7.0.1
 */