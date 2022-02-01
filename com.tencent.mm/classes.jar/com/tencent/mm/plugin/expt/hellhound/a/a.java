package com.tencent.mm.plugin.expt.hellhound.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.h;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.expt.hellhound.a.a.b.a;
import com.tencent.mm.protocal.protobuf.aft;
import com.tencent.mm.protocal.protobuf.ckz;
import com.tencent.mm.protocal.protobuf.dez;
import com.tencent.mm.protocal.protobuf.etl;
import com.tencent.mm.protocal.protobuf.kd;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a.a zLG;
  public static int zLH;
  private static int zLI;
  public static final h zLJ;
  
  static
  {
    AppMethodBeat.i(299909);
    zLG = new a.a((byte)0);
    zLJ = a..ExternalSyntheticLambda0.INSTANCE;
    AppMethodBeat.o(299909);
  }
  
  public static final void a(ckz paramckz)
  {
    int i = 1;
    AppMethodBeat.i(299904);
    s.u(paramckz, "resp");
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.a.a.b.zLM;
    Object localObject3;
    if (paramckz != null)
    {
      Log.i("HABBYGE-MALI.HellResponseDao", "setResp...");
      localObject1 = b.a.dMJ();
      if (localObject1 != null) {
        break label276;
      }
      localObject1 = new ckz();
      ((ckz)localObject1).aasY = paramckz.aasY;
      ((ckz)localObject1).aasZ = paramckz.aasZ;
      paramckz = paramckz.aata.iterator();
      while (paramckz.hasNext())
      {
        localObject2 = (dez)paramckz.next();
        if ((localObject2 != null) && (((dez)localObject2).eQp != 1))
        {
          ((ckz)localObject1).aata.add(localObject2);
          localObject3 = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
          com.tencent.mm.plugin.expt.hellhound.a.a.a.a.a(((dez)localObject2).aaKU.id, ((dez)localObject2).aaKU.type, ((dez)localObject2).aaKU.lAr, ((dez)localObject2).hMi, (List)((dez)localObject2).aaKV);
        }
      }
      paramckz = ((ckz)localObject1).aata;
      s.s(paramckz, "respOld.jsonPackages");
      if (((Collection)paramckz).isEmpty()) {
        break label271;
      }
    }
    for (;;)
    {
      if (i != 0) {
        paramckz = (ckz)localObject1;
      }
      try
      {
        if (paramckz.BaseResponse == null)
        {
          paramckz.BaseResponse = new kd();
          paramckz.BaseResponse.Idd = 0;
          paramckz.BaseResponse.akjO = new etl();
          localObject1 = paramckz.BaseResponse.akjO;
          if (localObject1 != null) {
            ((etl)localObject1).btH("");
          }
        }
        paramckz = paramckz.toByteArray();
        s.s(paramckz, "resp.toByteArray()");
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_resp_mkv_key", paramckz);
        AppMethodBeat.o(299904);
        return;
      }
      catch (Exception paramckz)
      {
        label271:
        Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)paramckz, s.X("HellResponseDao, write: ", paramckz.getMessage()), new Object[0]);
        AppMethodBeat.o(299904);
        return;
      }
      i = 0;
    }
    label276:
    ((ckz)localObject1).aasY = paramckz.aasY;
    ((ckz)localObject1).aasZ = paramckz.aasZ;
    Object localObject2 = (List)new ArrayList();
    paramckz = paramckz.aata.iterator();
    for (;;)
    {
      if (paramckz.hasNext())
      {
        localObject3 = (dez)paramckz.next();
        if (localObject3 != null)
        {
          i = ((ckz)localObject1).aata.size() - 1;
          if (i < 0) {
            break;
          }
        }
      }
    }
    for (;;)
    {
      int j = i - 1;
      Object localObject4 = ((ckz)localObject1).aata.get(i);
      s.s(localObject4, "respOld.jsonPackages[index]");
      localObject4 = (dez)localObject4;
      Object localObject5;
      if (s.p(((dez)localObject3).aaKU.id, ((dez)localObject4).aaKU.id)) {
        if (((dez)localObject3).eQp == 1)
        {
          ((ckz)localObject1).aata.remove(i);
          localObject5 = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
          localObject5 = ((dez)localObject4).aaKU.id;
          i = ((dez)localObject4).aaKU.type;
          if (localObject5 != null)
          {
            com.tencent.mm.plugin.expt.hellhound.a.a.a.a.atk((String)localObject5);
            switch (i)
            {
            }
          }
        }
      }
      label480:
      for (i = 0; i != 0; i = 1)
      {
        s.s(localObject3, "jp");
        ((List)localObject2).add(localObject3);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
        com.tencent.mm.plugin.expt.hellhound.a.a.a.a.a(((dez)localObject3).aaKU.id, ((dez)localObject3).aaKU.type, ((dez)localObject3).aaKU.lAr, ((dez)localObject3).hMi, (List)((dez)localObject3).aaKV);
        break;
        com.tencent.mm.plugin.expt.hellhound.a.a.a.a.a((String)localObject5, "", null, true, false);
        break label480;
        ((ckz)localObject1).aata.set(i, localObject3);
        localObject4 = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
        com.tencent.mm.plugin.expt.hellhound.a.a.a.a.a(((dez)localObject3).aaKU.id, ((dez)localObject3).aaKU.type, ((dez)localObject3).aaKU.lAr, ((dez)localObject3).hMi, (List)((dez)localObject3).aaKV);
        break label480;
        if (j >= 0) {
          break label751;
        }
      }
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((ckz)localObject1).aata.addAll((Collection)localObject2);
        }
        if (!((ckz)localObject1).aata.isEmpty()) {
          break;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_resp_mkv_key", new byte[0]);
        paramckz = com.tencent.mm.plugin.expt.hellhound.a.a.a.zLL;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_cgi_cc_dat", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.a.a.a.a.a("-100", "", null, true, false);
        AppMethodBeat.o(299904);
        return;
      }
      paramckz = (ckz)localObject1;
      break;
      label751:
      i = j;
    }
  }
  
  private static final void e(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(299887);
    Log.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + paramInt1 + "] errCode[" + paramInt2 + "] errMsg[" + paramString + ']');
    if ((paramp instanceof b))
    {
      zLH = 0;
      zLI = 0;
    }
    AppMethodBeat.o(299887);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a
 * JD-Core Version:    0.7.0.1
 */