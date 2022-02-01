package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.b.a.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.aaw;
import com.tencent.mm.protocal.protobuf.bch;
import com.tencent.mm.protocal.protobuf.bru;
import com.tencent.mm.protocal.protobuf.cwt;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.al.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static int qZT;
  private static int qZU;
  public static final f qZV;
  public static final a qZW;
  
  static
  {
    AppMethodBeat.i(210983);
    qZW = new a((byte)0);
    qZV = (f)b.qZX;
    AppMethodBeat.o(210983);
  }
  
  public static final void a(bch parambch)
  {
    int i = 1;
    AppMethodBeat.i(210987);
    p.h(parambch, "resp");
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.b.a.b.rac;
    if (parambch == null)
    {
      AppMethodBeat.o(210987);
      return;
    }
    ad.i("HABBYGE-MALI.HellResponseDao", "setResp...");
    localObject1 = b.a.cqT();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new bch();
      ((bch)localObject1).GyU = parambch.GyU;
      ((bch)localObject1).GyV = parambch.GyV;
      parambch = parambch.GyW.iterator();
      while (parambch.hasNext())
      {
        localObject2 = (bru)parambch.next();
        if ((localObject2 != null) && (((bru)localObject2).dDp != 1))
        {
          ((bch)localObject1).GyW.add(localObject2);
          localObject3 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
          com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bru)localObject2).GMK.id, ((bru)localObject2).GMK.type, ((bru)localObject2).GMK.ssW, ((bru)localObject2).duO, (List)((bru)localObject2).GML);
        }
      }
      parambch = ((bch)localObject1).GyW;
      p.g(parambch, "respOld.jsonPackages");
      if (!((Collection)parambch).isEmpty()) {}
      for (;;)
      {
        if (i != 0) {
          parambch = (bch)localObject1;
        }
        try
        {
          if (parambch.BaseResponse == null)
          {
            parambch.BaseResponse = new BaseResponse();
            parambch.BaseResponse.Ret = 0;
            parambch.BaseResponse.ErrMsg = new cwt();
            localObject1 = parambch.BaseResponse.ErrMsg;
            p.g(localObject1, "resp.BaseResponse.ErrMsg");
            ((cwt)localObject1).aPy("");
          }
          parambch = parambch.toByteArray();
          p.g(parambch, "resp.toByteArray()");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_resp_mkv_key", parambch);
          AppMethodBeat.o(210987);
          return;
        }
        catch (Exception parambch)
        {
          Object localObject4;
          Object localObject5;
          ad.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)parambch, "HellResponseDao, write: " + parambch.getMessage(), new Object[0]);
          AppMethodBeat.o(210987);
          return;
        }
        i = 0;
      }
    }
    ((bch)localObject1).GyU = parambch.GyU;
    ((bch)localObject1).GyV = parambch.GyV;
    Object localObject2 = (List)new ArrayList();
    parambch = parambch.GyW.iterator();
    for (;;)
    {
      label310:
      if (parambch.hasNext())
      {
        localObject3 = (bru)parambch.next();
        if (localObject3 != null)
        {
          i = ((bch)localObject1).GyW.size() - 1;
          label345:
          if (i < 0) {
            break label744;
          }
          localObject4 = ((bch)localObject1).GyW.get(i);
          p.g(localObject4, "respOld.jsonPackages[index]");
          localObject4 = (bru)localObject4;
          if (p.i(((bru)localObject3).GMK.id, ((bru)localObject4).GMK.id)) {
            if (((bru)localObject3).dDp == 1)
            {
              ((bch)localObject1).GyW.remove(i);
              localObject5 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
              localObject5 = ((bru)localObject4).GMK.id;
              i = ((bru)localObject4).GMK.type;
              if (localObject5 != null)
              {
                com.tencent.mm.plugin.expt.hellhound.b.a.a.a.afx((String)localObject5);
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
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bru)localObject3).GMK.id, ((bru)localObject3).GMK.type, ((bru)localObject3).GMK.ssW, ((bru)localObject3).duO, (List)((bru)localObject3).GML);
      break label310;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a((String)localObject5, "", null, true, false);
      break label476;
      ((bch)localObject1).GyW.set(i, localObject3);
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bru)localObject3).GMK.id, ((bru)localObject3).GMK.type, ((bru)localObject3).GMK.ssW, ((bru)localObject3).duO, (List)((bru)localObject3).GML);
      break label476;
      i -= 1;
      break label345;
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((bch)localObject1).GyW.addAll((Collection)localObject2);
        }
        if (!((bch)localObject1).GyW.isEmpty()) {
          break;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_resp_mkv_key", new byte[0]);
        parambch = com.tencent.mm.plugin.expt.hellhound.b.a.a.rab;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_cgi_cc_dat", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a("-100", "", null, true, false);
        AppMethodBeat.o(210987);
        return;
      }
      parambch = (bch)localObject1;
      break;
    }
  }
  
  public static final void cqP()
  {
    AppMethodBeat.i(210984);
    qZT = 0;
    e locale = g.ajC();
    p.g(locale, "MMKernel.storage()");
    locale.ajl().set(al.a.IJz, Integer.valueOf(0));
    AppMethodBeat.o(210984);
  }
  
  public static final void cqQ()
  {
    AppMethodBeat.i(210985);
    if (!g.ajx())
    {
      ad.w("HABBYGE-MALI.HellCgi", "account is not ready, don't get expt config");
      AppMethodBeat.o(210985);
      return;
    }
    if (!aj.cmR())
    {
      ad.w("HABBYGE-MALI.HellCgi", "it is not mm process, why you call update expt?");
      AppMethodBeat.o(210985);
      return;
    }
    Object localObject;
    if (qZT <= 0)
    {
      localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajl().get(al.a.IJz, Integer.valueOf(0));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(210985);
        throw ((Throwable)localObject);
      }
      qZT = ((Integer)localObject).intValue();
    }
    if (qZU <= 0)
    {
      localObject = g.ajC();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajl().get(al.a.IJy, Integer.valueOf(86400));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(210985);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      qZU = i;
      if (i > 3600) {
        break label285;
      }
      ad.w("HABBYGE-MALI.HellCgi", "interval is less than 1 hour, something warn here: " + qZU);
      qZU = 3600;
    }
    for (;;)
    {
      long l = bt.rM(qZT);
      ad.i("HABBYGE-MALI.HellCgi", "checkNeedUpdateHell: interval=" + qZU + ", secondsToNow=" + l);
      if (l >= qZU) {
        a.Dt(1);
      }
      AppMethodBeat.o(210985);
      return;
      label285:
      if (qZU >= 604800)
      {
        ad.w("HABBYGE-MALI.HellCgi", "interval is too big than 24 hours, something warn here: " + qZU);
        qZU = 86400;
      }
    }
  }
  
  public static final void cqR()
  {
    AppMethodBeat.i(210986);
    a.Dt(2);
    AppMethodBeat.o(210986);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi$Companion;", "", "()V", "SCENE_GET_HELL_MANUAL_AUTH", "", "SCENE_GET_HELL_TIME_OUT", "TAG", "", "getHellEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "intervalHell", "lastUpdateTimeHell", "checkNeedUpdateHell", "", "scene", "resetCacheTimeHell", "resetLastUpdateTime", "updateConfig", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "updateHell", "plugin-expt_release"})
  public static final class a
  {
    public static void Dt(int paramInt)
    {
      AppMethodBeat.i(210982);
      if (!com.tencent.mm.plugin.expt.hellhound.a.cnz())
      {
        AppMethodBeat.o(210982);
        return;
      }
      ad.i("HABBYGE-MALI.HellCgi", "updateHell: ".concat(String.valueOf(paramInt)));
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.cnJ();
      String str1 = com.tencent.mm.loader.j.a.BUILD_TAG;
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        q localq = g.aiU();
        p.g(str2, "rversion");
        localq.b((n)new b(paramInt, str2, str1));
        AppMethodBeat.o(210982);
        return;
      }
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements f
  {
    public static final b qZX;
    
    static
    {
      AppMethodBeat.i(210981);
      qZX = new b();
      AppMethodBeat.o(210981);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(210980);
      ad.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + paramInt1 + "] errCode[" + paramInt2 + "] errMsg[" + paramString + ']');
      if ((paramn instanceof b))
      {
        paramString = a.qZW;
        a.qZT = 0;
        a.cqO();
      }
      AppMethodBeat.o(210980);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a
 * JD-Core Version:    0.7.0.1
 */