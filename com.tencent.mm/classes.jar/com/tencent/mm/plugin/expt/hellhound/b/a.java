package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.expt.hellhound.b.a.b.a;
import com.tencent.mm.protocal.protobuf.adl;
import com.tencent.mm.protocal.protobuf.bvy;
import com.tencent.mm.protocal.protobuf.cof;
import com.tencent.mm.protocal.protobuf.eaf;
import com.tencent.mm.protocal.protobuf.jh;
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

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static int wpB;
  private static int wpC;
  public static final i wpD;
  public static final a wpE;
  
  static
  {
    AppMethodBeat.i(254782);
    wpE = new a((byte)0);
    wpD = (i)b.wpF;
    AppMethodBeat.o(254782);
  }
  
  public static final void a(bvy parambvy)
  {
    int i = 1;
    AppMethodBeat.i(254802);
    p.k(parambvy, "resp");
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.b.a.b.wpK;
    if (parambvy == null)
    {
      AppMethodBeat.o(254802);
      return;
    }
    Log.i("HABBYGE-MALI.HellResponseDao", "setResp...");
    localObject1 = b.a.dfZ();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new bvy();
      ((bvy)localObject1).TfG = parambvy.TfG;
      ((bvy)localObject1).TfH = parambvy.TfH;
      parambvy = parambvy.TfI.iterator();
      while (parambvy.hasNext())
      {
        localObject2 = (cof)parambvy.next();
        if ((localObject2 != null) && (((cof)localObject2).cUP != 1))
        {
          ((bvy)localObject1).TfI.add(localObject2);
          localObject3 = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
          com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cof)localObject2).Twn.id, ((cof)localObject2).Twn.type, ((cof)localObject2).Twn.Aaj, ((cof)localObject2).fGM, (List)((cof)localObject2).Two);
        }
      }
      parambvy = ((bvy)localObject1).TfI;
      p.j(parambvy, "respOld.jsonPackages");
      if (!((Collection)parambvy).isEmpty()) {}
      for (;;)
      {
        if (i != 0) {
          parambvy = (bvy)localObject1;
        }
        try
        {
          if (parambvy.BaseResponse == null)
          {
            parambvy.BaseResponse = new jh();
            parambvy.BaseResponse.CqV = 0;
            parambvy.BaseResponse.Tef = new eaf();
            localObject1 = parambvy.BaseResponse.Tef;
            p.j(localObject1, "resp.BaseResponse.ErrMsg");
            ((eaf)localObject1).btQ("");
          }
          parambvy = parambvy.toByteArray();
          p.j(parambvy, "resp.toByteArray()");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_resp_mkv_key", parambvy);
          AppMethodBeat.o(254802);
          return;
        }
        catch (Exception parambvy)
        {
          Object localObject4;
          Object localObject5;
          Log.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)parambvy, "HellResponseDao, write: " + parambvy.getMessage(), new Object[0]);
          AppMethodBeat.o(254802);
          return;
        }
        i = 0;
      }
    }
    ((bvy)localObject1).TfG = parambvy.TfG;
    ((bvy)localObject1).TfH = parambvy.TfH;
    Object localObject2 = (List)new ArrayList();
    parambvy = parambvy.TfI.iterator();
    for (;;)
    {
      label310:
      if (parambvy.hasNext())
      {
        localObject3 = (cof)parambvy.next();
        if (localObject3 != null)
        {
          i = ((bvy)localObject1).TfI.size() - 1;
          label345:
          if (i < 0) {
            break label744;
          }
          localObject4 = ((bvy)localObject1).TfI.get(i);
          p.j(localObject4, "respOld.jsonPackages[index]");
          localObject4 = (cof)localObject4;
          if (p.h(((cof)localObject3).Twn.id, ((cof)localObject4).Twn.id)) {
            if (((cof)localObject3).cUP == 1)
            {
              ((bvy)localObject1).TfI.remove(i);
              localObject5 = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
              localObject5 = ((cof)localObject4).Twn.id;
              i = ((cof)localObject4).Twn.type;
              if (localObject5 != null)
              {
                com.tencent.mm.plugin.expt.hellhound.b.a.a.a.azf((String)localObject5);
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
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cof)localObject3).Twn.id, ((cof)localObject3).Twn.type, ((cof)localObject3).Twn.Aaj, ((cof)localObject3).fGM, (List)((cof)localObject3).Two);
      break label310;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a((String)localObject5, "", null, true, false);
      break label476;
      ((bvy)localObject1).TfI.set(i, localObject3);
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((cof)localObject3).Twn.id, ((cof)localObject3).Twn.type, ((cof)localObject3).Twn.Aaj, ((cof)localObject3).fGM, (List)((cof)localObject3).Two);
      break label476;
      i -= 1;
      break label345;
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((bvy)localObject1).TfI.addAll((Collection)localObject2);
        }
        if (!((bvy)localObject1).TfI.isEmpty()) {
          break;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_resp_mkv_key", new byte[0]);
        parambvy = com.tencent.mm.plugin.expt.hellhound.b.a.a.wpJ;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_cgi_cc_dat", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a("-100", "", null, true, false);
        AppMethodBeat.o(254802);
        return;
      }
      parambvy = (bvy)localObject1;
      break;
    }
  }
  
  public static final void dfV()
  {
    AppMethodBeat.i(254786);
    wpB = 0;
    f localf = h.aHG();
    p.j(localf, "MMKernel.storage()");
    localf.aHp().set(ar.a.VCZ, Integer.valueOf(0));
    AppMethodBeat.o(254786);
  }
  
  public static final void dfW()
  {
    AppMethodBeat.i(254793);
    if (!h.aHB())
    {
      Log.w("HABBYGE-MALI.HellCgi", "account is not ready, don't get expt config");
      AppMethodBeat.o(254793);
      return;
    }
    if (!MMApplicationContext.isMainProcess())
    {
      Log.w("HABBYGE-MALI.HellCgi", "it is not mm process, why you call update expt?");
      AppMethodBeat.o(254793);
      return;
    }
    Object localObject;
    if (wpB <= 0)
    {
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((f)localObject).aHp().get(ar.a.VCZ, Integer.valueOf(0));
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(254793);
        throw ((Throwable)localObject);
      }
      wpB = ((Integer)localObject).intValue();
    }
    if (wpC <= 0)
    {
      localObject = h.aHG();
      p.j(localObject, "MMKernel.storage()");
      localObject = ((f)localObject).aHp().get(ar.a.VCY, Integer.valueOf(86400));
      if (localObject == null)
      {
        localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(254793);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      wpC = i;
      if (i > 3600) {
        break label285;
      }
      Log.w("HABBYGE-MALI.HellCgi", "interval is less than 1 hour, something warn here: " + wpC);
      wpC = 3600;
    }
    for (;;)
    {
      long l = Util.secondsToNow(wpB);
      Log.i("HABBYGE-MALI.HellCgi", "checkNeedUpdateHell: interval=" + wpC + ", secondsToNow=" + l);
      if (l >= wpC) {
        a.Ld(1);
      }
      AppMethodBeat.o(254793);
      return;
      label285:
      if (wpC >= 604800)
      {
        Log.w("HABBYGE-MALI.HellCgi", "interval is too big than 24 hours, something warn here: " + wpC);
        wpC = 86400;
      }
    }
  }
  
  public static final void dfX()
  {
    AppMethodBeat.i(254795);
    a.Ld(2);
    AppMethodBeat.o(254795);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi$Companion;", "", "()V", "SCENE_GET_HELL_MANUAL_AUTH", "", "SCENE_GET_HELL_TIME_OUT", "TAG", "", "getHellEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "intervalHell", "lastUpdateTimeHell", "checkNeedUpdateHell", "", "scene", "resetCacheTimeHell", "resetLastUpdateTime", "updateConfig", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "updateHell", "plugin-expt_release"})
  public static final class a
  {
    public static void Ld(int paramInt)
    {
      AppMethodBeat.i(253658);
      if (!com.tencent.mm.plugin.expt.hellhound.a.dcm())
      {
        AppMethodBeat.o(253658);
        return;
      }
      Log.i("HABBYGE-MALI.HellCgi", "updateHell: ".concat(String.valueOf(paramInt)));
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.dcw();
      String str1 = com.tencent.mm.loader.j.a.BUILD_TAG;
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        com.tencent.mm.an.t localt = h.aGY();
        p.j(str2, "rversion");
        localt.b((q)new b(paramInt, str2, str1));
        AppMethodBeat.o(253658);
        return;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements i
  {
    public static final b wpF;
    
    static
    {
      AppMethodBeat.i(256494);
      wpF = new b();
      AppMethodBeat.o(256494);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
    {
      AppMethodBeat.i(256493);
      Log.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + paramInt1 + "] errCode[" + paramInt2 + "] errMsg[" + paramString + ']');
      if ((paramq instanceof b))
      {
        paramString = a.wpE;
        a.wpB = 0;
        a.dfU();
      }
      AppMethodBeat.o(256493);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a
 * JD-Core Version:    0.7.0.1
 */