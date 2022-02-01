package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.b.a.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.ade;
import com.tencent.mm.protocal.protobuf.boj;
import com.tencent.mm.protocal.protobuf.cfi;
import com.tencent.mm.protocal.protobuf.dqi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static int sJD;
  private static int sJE;
  public static final i sJF;
  public static final a sJG;
  
  static
  {
    AppMethodBeat.i(221153);
    sJG = new a((byte)0);
    sJF = (i)b.sJH;
    AppMethodBeat.o(221153);
  }
  
  public static final void a(boj paramboj)
  {
    int i = 1;
    AppMethodBeat.i(221157);
    p.h(paramboj, "resp");
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.b.a.b.sJM;
    if (paramboj == null)
    {
      AppMethodBeat.o(221157);
      return;
    }
    Log.i("HABBYGE-MALI.HellResponseDao", "setResp...");
    localObject1 = b.a.cRe();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new boj();
      ((boj)localObject1).LWz = paramboj.LWz;
      ((boj)localObject1).LWA = paramboj.LWA;
      paramboj = paramboj.LWB.iterator();
      while (paramboj.hasNext())
      {
        localObject2 = (cfi)paramboj.next();
        if ((localObject2 != null) && (((cfi)localObject2).cSx != 1))
        {
          ((boj)localObject1).LWB.add(localObject2);
          localObject3 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
          com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cfi)localObject2).Mlu.id, ((cfi)localObject2).Mlu.type, ((cfi)localObject2).Mlu.vtY, ((cfi)localObject2).dNA, (List)((cfi)localObject2).Mlv);
        }
      }
      paramboj = ((boj)localObject1).LWB;
      p.g(paramboj, "respOld.jsonPackages");
      if (!((Collection)paramboj).isEmpty()) {}
      for (;;)
      {
        if (i != 0) {
          paramboj = (boj)localObject1;
        }
        try
        {
          if (paramboj.BaseResponse == null)
          {
            paramboj.BaseResponse = new BaseResponse();
            paramboj.BaseResponse.Ret = 0;
            paramboj.BaseResponse.ErrMsg = new dqi();
            localObject1 = paramboj.BaseResponse.ErrMsg;
            p.g(localObject1, "resp.BaseResponse.ErrMsg");
            ((dqi)localObject1).bhy("");
          }
          paramboj = paramboj.toByteArray();
          p.g(paramboj, "resp.toByteArray()");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_resp_mkv_key", paramboj);
          AppMethodBeat.o(221157);
          return;
        }
        catch (Exception paramboj)
        {
          Object localObject4;
          Object localObject5;
          Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)paramboj, "HellResponseDao, write: " + paramboj.getMessage(), new Object[0]);
          AppMethodBeat.o(221157);
          return;
        }
        i = 0;
      }
    }
    ((boj)localObject1).LWz = paramboj.LWz;
    ((boj)localObject1).LWA = paramboj.LWA;
    Object localObject2 = (List)new ArrayList();
    paramboj = paramboj.LWB.iterator();
    for (;;)
    {
      label310:
      if (paramboj.hasNext())
      {
        localObject3 = (cfi)paramboj.next();
        if (localObject3 != null)
        {
          i = ((boj)localObject1).LWB.size() - 1;
          label345:
          if (i < 0) {
            break label744;
          }
          localObject4 = ((boj)localObject1).LWB.get(i);
          p.g(localObject4, "respOld.jsonPackages[index]");
          localObject4 = (cfi)localObject4;
          if (p.j(((cfi)localObject3).Mlu.id, ((cfi)localObject4).Mlu.id)) {
            if (((cfi)localObject3).cSx == 1)
            {
              ((boj)localObject1).LWB.remove(i);
              localObject5 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
              localObject5 = ((cfi)localObject4).Mlu.id;
              i = ((cfi)localObject4).Mlu.type;
              if (localObject5 != null)
              {
                com.tencent.mm.plugin.expt.hellhound.b.a.a.a.are((String)localObject5);
                switch (i)
                {
                }
              }
            }
          }
        }
      }
    }
    label476:
    label744:
    for (i = 0;; i = 1)
    {
      if (i == 0) {
        break label310;
      }
      ((List)localObject2).add(localObject3);
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cfi)localObject3).Mlu.id, ((cfi)localObject3).Mlu.type, ((cfi)localObject3).Mlu.vtY, ((cfi)localObject3).dNA, (List)((cfi)localObject3).Mlv);
      break label310;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a((String)localObject5, "", null, true, false);
      break label476;
      ((boj)localObject1).LWB.set(i, localObject3);
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cfi)localObject3).Mlu.id, ((cfi)localObject3).Mlu.type, ((cfi)localObject3).Mlu.vtY, ((cfi)localObject3).dNA, (List)((cfi)localObject3).Mlv);
      break label476;
      i -= 1;
      break label345;
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((boj)localObject1).LWB.addAll((Collection)localObject2);
        }
        if (!((boj)localObject1).LWB.isEmpty()) {
          break;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_resp_mkv_key", new byte[0]);
        paramboj = com.tencent.mm.plugin.expt.hellhound.b.a.a.sJL;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_cgi_cc_dat", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a("-100", "", null, true, false);
        AppMethodBeat.o(221157);
        return;
      }
      paramboj = (boj)localObject1;
      break;
    }
  }
  
  public static final void cRa()
  {
    AppMethodBeat.i(221154);
    sJD = 0;
    e locale = g.aAh();
    p.g(locale, "MMKernel.storage()");
    locale.azQ().set(ar.a.OnL, Integer.valueOf(0));
    AppMethodBeat.o(221154);
  }
  
  public static final void cRb()
  {
    AppMethodBeat.i(221155);
    if (!g.aAc())
    {
      Log.w("HABBYGE-MALI.HellCgi", "account is not ready, don't get expt config");
      AppMethodBeat.o(221155);
      return;
    }
    if (!MMApplicationContext.isMainProcess())
    {
      Log.w("HABBYGE-MALI.HellCgi", "it is not mm process, why you call update expt?");
      AppMethodBeat.o(221155);
      return;
    }
    Object localObject;
    if (sJD <= 0)
    {
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).azQ().get(ar.a.OnL, Integer.valueOf(0));
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(221155);
        throw ((Throwable)localObject);
      }
      sJD = ((Integer)localObject).intValue();
    }
    if (sJE <= 0)
    {
      localObject = g.aAh();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).azQ().get(ar.a.OnK, Integer.valueOf(86400));
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(221155);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      sJE = i;
      if (i > 3600) {
        break label285;
      }
      Log.w("HABBYGE-MALI.HellCgi", "interval is less than 1 hour, something warn here: " + sJE);
      sJE = 3600;
    }
    for (;;)
    {
      long l = Util.secondsToNow(sJD);
      Log.i("HABBYGE-MALI.HellCgi", "checkNeedUpdateHell: interval=" + sJE + ", secondsToNow=" + l);
      if (l >= sJE) {
        a.Ht(1);
      }
      AppMethodBeat.o(221155);
      return;
      label285:
      if (sJE >= 604800)
      {
        Log.w("HABBYGE-MALI.HellCgi", "interval is too big than 24 hours, something warn here: " + sJE);
        sJE = 86400;
      }
    }
  }
  
  public static final void cRc()
  {
    AppMethodBeat.i(221156);
    a.Ht(2);
    AppMethodBeat.o(221156);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi$Companion;", "", "()V", "SCENE_GET_HELL_MANUAL_AUTH", "", "SCENE_GET_HELL_TIME_OUT", "TAG", "", "getHellEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "intervalHell", "lastUpdateTimeHell", "checkNeedUpdateHell", "", "scene", "resetCacheTimeHell", "resetLastUpdateTime", "updateConfig", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "updateHell", "plugin-expt_release"})
  public static final class a
  {
    public static void Ht(int paramInt)
    {
      AppMethodBeat.i(221152);
      if (!com.tencent.mm.plugin.expt.hellhound.a.cNu())
      {
        AppMethodBeat.o(221152);
        return;
      }
      Log.i("HABBYGE-MALI.HellCgi", "updateHell: ".concat(String.valueOf(paramInt)));
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.cNE();
      String str1 = com.tencent.mm.loader.j.a.BUILD_TAG;
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        com.tencent.mm.ak.t localt = g.azz();
        p.g(str2, "rversion");
        localt.b((q)new b(paramInt, str2, str1));
        AppMethodBeat.o(221152);
        return;
      }
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements i
  {
    public static final b sJH;
    
    static
    {
      AppMethodBeat.i(221151);
      sJH = new b();
      AppMethodBeat.o(221151);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(221150);
      Log.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + paramInt1 + "] errCode[" + paramInt2 + "] errMsg[" + paramString + ']');
      if ((paramq instanceof b))
      {
        paramString = a.sJG;
        a.sJD = 0;
        a.cQZ();
      }
      AppMethodBeat.o(221150);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a
 * JD-Core Version:    0.7.0.1
 */