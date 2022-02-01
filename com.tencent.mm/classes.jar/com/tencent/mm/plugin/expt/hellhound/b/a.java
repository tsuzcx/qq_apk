package com.tencent.mm.plugin.expt.hellhound.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.expt.hellhound.b.a.b.a;
import com.tencent.mm.protocal.protobuf.BaseResponse;
import com.tencent.mm.protocal.protobuf.abf;
import com.tencent.mm.protocal.protobuf.bcx;
import com.tencent.mm.protocal.protobuf.bso;
import com.tencent.mm.protocal.protobuf.cxn;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import d.g.b.p;
import d.l;
import d.v;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static int rhZ;
  private static int ria;
  public static final f rib;
  public static final a ric;
  
  static
  {
    AppMethodBeat.i(196654);
    ric = new a((byte)0);
    rib = (f)b.rid;
    AppMethodBeat.o(196654);
  }
  
  public static final void a(bcx parambcx)
  {
    int i = 1;
    AppMethodBeat.i(196658);
    p.h(parambcx, "resp");
    Object localObject1 = com.tencent.mm.plugin.expt.hellhound.b.a.b.rii;
    if (parambcx == null)
    {
      AppMethodBeat.o(196658);
      return;
    }
    ae.i("HABBYGE-MALI.HellResponseDao", "setResp...");
    localObject1 = b.a.csv();
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new bcx();
      ((bcx)localObject1).GSu = parambcx.GSu;
      ((bcx)localObject1).GSv = parambcx.GSv;
      parambcx = parambcx.GSw.iterator();
      while (parambcx.hasNext())
      {
        localObject2 = (bso)parambcx.next();
        if ((localObject2 != null) && (((bso)localObject2).dEu != 1))
        {
          ((bcx)localObject1).GSw.add(localObject2);
          localObject3 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
          com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bso)localObject2).Hgl.id, ((bso)localObject2).Hgl.type, ((bso)localObject2).Hgl.sDg, ((bso)localObject2).dvT, (List)((bso)localObject2).Hgm);
        }
      }
      parambcx = ((bcx)localObject1).GSw;
      p.g(parambcx, "respOld.jsonPackages");
      if (!((Collection)parambcx).isEmpty()) {}
      for (;;)
      {
        if (i != 0) {
          parambcx = (bcx)localObject1;
        }
        try
        {
          if (parambcx.BaseResponse == null)
          {
            parambcx.BaseResponse = new BaseResponse();
            parambcx.BaseResponse.Ret = 0;
            parambcx.BaseResponse.ErrMsg = new cxn();
            localObject1 = parambcx.BaseResponse.ErrMsg;
            p.g(localObject1, "resp.BaseResponse.ErrMsg");
            ((cxn)localObject1).aQV("");
          }
          parambcx = parambcx.toByteArray();
          p.g(parambcx, "resp.toByteArray()");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_resp_mkv_key", parambcx);
          AppMethodBeat.o(196658);
          return;
        }
        catch (Exception parambcx)
        {
          Object localObject4;
          Object localObject5;
          ae.printErrStackTrace("HABBYGE-MALI.HellResponseDao", (Throwable)parambcx, "HellResponseDao, write: " + parambcx.getMessage(), new Object[0]);
          AppMethodBeat.o(196658);
          return;
        }
        i = 0;
      }
    }
    ((bcx)localObject1).GSu = parambcx.GSu;
    ((bcx)localObject1).GSv = parambcx.GSv;
    Object localObject2 = (List)new ArrayList();
    parambcx = parambcx.GSw.iterator();
    for (;;)
    {
      label310:
      if (parambcx.hasNext())
      {
        localObject3 = (bso)parambcx.next();
        if (localObject3 != null)
        {
          i = ((bcx)localObject1).GSw.size() - 1;
          label345:
          if (i < 0) {
            break label744;
          }
          localObject4 = ((bcx)localObject1).GSw.get(i);
          p.g(localObject4, "respOld.jsonPackages[index]");
          localObject4 = (bso)localObject4;
          if (p.i(((bso)localObject3).Hgl.id, ((bso)localObject4).Hgl.id)) {
            if (((bso)localObject3).dEu == 1)
            {
              ((bcx)localObject1).GSw.remove(i);
              localObject5 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
              localObject5 = ((bso)localObject4).Hgl.id;
              i = ((bso)localObject4).Hgl.type;
              if (localObject5 != null)
              {
                com.tencent.mm.plugin.expt.hellhound.b.a.a.a.agt((String)localObject5);
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
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bso)localObject3).Hgl.id, ((bso)localObject3).Hgl.type, ((bso)localObject3).Hgl.sDg, ((bso)localObject3).dvT, (List)((bso)localObject3).Hgm);
      break label310;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a((String)localObject5, "", null, true, false);
      break label476;
      ((bcx)localObject1).GSw.set(i, localObject3);
      localObject4 = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
      com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a(((bso)localObject3).Hgl.id, ((bso)localObject3).Hgl.type, ((bso)localObject3).Hgl.sDg, ((bso)localObject3).dvT, (List)((bso)localObject3).Hgm);
      break label476;
      i -= 1;
      break label345;
      if (!((Collection)localObject2).isEmpty()) {}
      for (i = 1;; i = 0)
      {
        if (i != 0) {
          ((bcx)localObject1).GSw.addAll((Collection)localObject2);
        }
        if (!((bcx)localObject1).GSw.isEmpty()) {
          break;
        }
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_resp_mkv_key", new byte[0]);
        parambcx = com.tencent.mm.plugin.expt.hellhound.b.a.a.rih;
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_cgi_cc_dat", new byte[0]);
        com.tencent.mm.plugin.expt.hellhound.b.a.a.a.a("-100", "", null, true, false);
        AppMethodBeat.o(196658);
        return;
      }
      parambcx = (bcx)localObject1;
      break;
    }
  }
  
  public static final void csr()
  {
    AppMethodBeat.i(196655);
    rhZ = 0;
    e locale = g.ajR();
    p.g(locale, "MMKernel.storage()");
    locale.ajA().set(am.a.Jef, Integer.valueOf(0));
    AppMethodBeat.o(196655);
  }
  
  public static final void css()
  {
    AppMethodBeat.i(196656);
    if (!g.ajM())
    {
      ae.w("HABBYGE-MALI.HellCgi", "account is not ready, don't get expt config");
      AppMethodBeat.o(196656);
      return;
    }
    if (!ak.coh())
    {
      ae.w("HABBYGE-MALI.HellCgi", "it is not mm process, why you call update expt?");
      AppMethodBeat.o(196656);
      return;
    }
    Object localObject;
    if (rhZ <= 0)
    {
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajA().get(am.a.Jef, Integer.valueOf(0));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(196656);
        throw ((Throwable)localObject);
      }
      rhZ = ((Integer)localObject).intValue();
    }
    if (ria <= 0)
    {
      localObject = g.ajR();
      p.g(localObject, "MMKernel.storage()");
      localObject = ((e)localObject).ajA().get(am.a.Jee, Integer.valueOf(86400));
      if (localObject == null)
      {
        localObject = new v("null cannot be cast to non-null type kotlin.Int");
        AppMethodBeat.o(196656);
        throw ((Throwable)localObject);
      }
      int i = ((Integer)localObject).intValue();
      ria = i;
      if (i > 3600) {
        break label285;
      }
      ae.w("HABBYGE-MALI.HellCgi", "interval is less than 1 hour, something warn here: " + ria);
      ria = 3600;
    }
    for (;;)
    {
      long l = bu.rZ(rhZ);
      ae.i("HABBYGE-MALI.HellCgi", "checkNeedUpdateHell: interval=" + ria + ", secondsToNow=" + l);
      if (l >= ria) {
        a.DG(1);
      }
      AppMethodBeat.o(196656);
      return;
      label285:
      if (ria >= 604800)
      {
        ae.w("HABBYGE-MALI.HellCgi", "interval is too big than 24 hours, something warn here: " + ria);
        ria = 86400;
      }
    }
  }
  
  public static final void cst()
  {
    AppMethodBeat.i(196657);
    a.DG(2);
    AppMethodBeat.o(196657);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/HellCgi$Companion;", "", "()V", "SCENE_GET_HELL_MANUAL_AUTH", "", "SCENE_GET_HELL_TIME_OUT", "TAG", "", "getHellEnd", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "intervalHell", "lastUpdateTimeHell", "checkNeedUpdateHell", "", "scene", "resetCacheTimeHell", "resetLastUpdateTime", "updateConfig", "resp", "Lcom/tencent/mm/protocal/protobuf/GetHellResponse;", "updateHell", "plugin-expt_release"})
  public static final class a
  {
    public static void DG(int paramInt)
    {
      AppMethodBeat.i(196653);
      if (!com.tencent.mm.plugin.expt.hellhound.a.cpb())
      {
        AppMethodBeat.o(196653);
        return;
      }
      ae.i("HABBYGE-MALI.HellCgi", "updateHell: ".concat(String.valueOf(paramInt)));
      String str2 = com.tencent.mm.plugin.expt.hellhound.core.b.cpl();
      String str1 = com.tencent.mm.loader.j.a.BUILD_TAG;
      if (str1 == null) {
        str1 = "";
      }
      for (;;)
      {
        q localq = g.ajj();
        p.g(str2, "rversion");
        localq.b((n)new b(paramInt, str2, str1));
        AppMethodBeat.o(196653);
        return;
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "errType", "", "errCode", "errMsg", "", "kotlin.jvm.PlatformType", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "onSceneEnd"})
  static final class b
    implements f
  {
    public static final b rid;
    
    static
    {
      AppMethodBeat.i(196652);
      rid = new b();
      AppMethodBeat.o(196652);
    }
    
    public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
    {
      AppMethodBeat.i(196651);
      ae.i("HABBYGE-MALI.HellCgi", "getHellEnd: errType[" + paramInt1 + "] errCode[" + paramInt2 + "] errMsg[" + paramString + ']');
      if ((paramn instanceof b))
      {
        paramString = a.ric;
        a.rhZ = 0;
        a.csq();
      }
      AppMethodBeat.o(196651);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a
 * JD-Core Version:    0.7.0.1
 */