package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ti;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.bta;
import com.tencent.mm.protocal.protobuf.cng;
import com.tencent.mm.protocal.protobuf.dcc;
import com.tencent.mm.protocal.protobuf.dwy;
import com.tencent.mm.protocal.protobuf.ue;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a rih;
  
  static
  {
    AppMethodBeat.i(196672);
    rih = new a((byte)0);
    AppMethodBeat.o(196672);
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "default", "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"})
  public static final class a
  {
    private static void a(ue paramue)
    {
      AppMethodBeat.i(196670);
      try
      {
        paramue = paramue.toByteArray();
        p.g(paramue, "parguard.toByteArray()");
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_cgi_cc_dat", paramue);
        AppMethodBeat.o(196670);
        return;
      }
      catch (Exception paramue)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)paramue, "HellCloudData, write: " + paramue.getMessage(), new Object[0]);
        AppMethodBeat.o(196670);
      }
    }
    
    public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<? extends bta> paramList)
    {
      AppMethodBeat.i(196665);
      if ((paramString1 == null) || (paramString2 == null) || (paramList == null) || (paramList.isEmpty()))
      {
        AppMethodBeat.o(196665);
        return;
      }
      q(paramString1, paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(196665);
        return;
        AppMethodBeat.o(196665);
        return;
        a(paramString1, paramString2, paramList, false, paramBoolean);
      }
    }
    
    public static void a(String paramString1, String paramString2, List<? extends bta> paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(196669);
      ae.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + paramString1 + ", " + paramBoolean2 + ", " + paramBoolean1);
      ti localti = new ti();
      localti.dIQ.dIO = Long.parseLong(paramString1);
      localti.dIQ.dvT = paramString2;
      localti.dIQ.dIM = Boolean.valueOf(paramBoolean1);
      localti.dIQ.dIS = Boolean.valueOf(paramBoolean2);
      localti.dIQ.dIR = paramList;
      localti.dIQ.version = 2;
      com.tencent.mm.sdk.b.a.IvT.l((com.tencent.mm.sdk.b.b)localti);
      AppMethodBeat.o(196669);
    }
    
    public static void agt(String paramString)
    {
      AppMethodBeat.i(196667);
      ue localue = csu();
      if (localue == null)
      {
        AppMethodBeat.o(196667);
        return;
      }
      Iterator localIterator = localue.GlW.iterator();
      while (localIterator.hasNext())
      {
        cng localcng = (cng)localIterator.next();
        if (p.i(paramString, localcng.id))
        {
          localue.GlW.remove(localcng);
          a(localue);
          AppMethodBeat.o(196667);
          return;
        }
      }
      AppMethodBeat.o(196667);
    }
    
    public static String b(String paramString1, List<? extends dcc> paramList, String paramString2)
    {
      AppMethodBeat.i(196668);
      p.h(paramString1, "viewId");
      p.h(paramList, "pageList");
      do
      {
        Iterator localIterator1 = paramList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((dcc)localIterator1.next()).HKD.iterator();
        }
        paramList = (dwy)localIterator2.next();
      } while (!p.i(paramString1, paramList.aQj));
      if (paramList.Icn != null)
      {
        paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
        l.a.tn(130L);
        paramString1 = paramList.Icn;
        p.g(paramString1, "viewOp.resName");
        AppMethodBeat.o(196668);
        return paramString1;
      }
      ae.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + paramString1 + ", viewOp.viewId=" + paramList.aQj + ", viewOp.resName=" + paramList.Icn);
      paramList = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.rhv;
      l.a.tn(159L);
      if (paramString2 == null) {}
      for (;;)
      {
        AppMethodBeat.o(196668);
        return paramString1;
        if (paramString2 == null) {}
        for (;;)
        {
          AppMethodBeat.o(196668);
          return paramString1;
          paramString1 = paramString2;
        }
        paramString1 = paramString2;
      }
    }
    
    private static ue csu()
    {
      AppMethodBeat.i(196671);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_cgi_cc_dat");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label35;
        }
      }
      label35:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(196671);
        return null;
      }
      ue localue = new ue();
      try
      {
        localue.parseFrom(arrayOfByte);
        AppMethodBeat.o(196671);
        return localue;
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)localException, "HellCloudData, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(196671);
      }
      return null;
    }
    
    private static void q(String paramString, List<? extends bta> paramList)
    {
      AppMethodBeat.i(196666);
      ue localue = csu();
      if (localue == null)
      {
        localue = new ue();
        localObject = new cng();
        ((cng)localObject).id = paramString;
        ((cng)localObject).Hzp.addAll((Collection)paramList);
        localue.GlW.add(localObject);
        a(localue);
        AppMethodBeat.o(196666);
        return;
      }
      Object localObject = localue.GlW.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cng localcng = (cng)((Iterator)localObject).next();
        if (p.i(paramString, localcng.id))
        {
          localcng.Hzp.clear();
          localcng.Hzp.addAll((Collection)paramList);
          a(localue);
          AppMethodBeat.o(196666);
          return;
        }
      }
      localObject = new cng();
      ((cng)localObject).id = paramString;
      ((cng)localObject).Hzp.addAll((Collection)paramList);
      localue.GlW.add(localObject);
      a(localue);
      AppMethodBeat.o(196666);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.a
 * JD-Core Version:    0.7.0.1
 */