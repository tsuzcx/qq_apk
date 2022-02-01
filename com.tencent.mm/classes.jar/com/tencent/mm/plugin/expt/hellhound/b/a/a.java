package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.th;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.protocal.protobuf.bsg;
import com.tencent.mm.protocal.protobuf.cmm;
import com.tencent.mm.protocal.protobuf.dbi;
import com.tencent.mm.protocal.protobuf.dwd;
import com.tencent.mm.protocal.protobuf.uc;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a rab;
  
  static
  {
    AppMethodBeat.i(211001);
    rab = new a((byte)0);
    AppMethodBeat.o(211001);
  }
  
  @d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "default", "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"})
  public static final class a
  {
    private static void a(uc paramuc)
    {
      AppMethodBeat.i(210999);
      try
      {
        paramuc = paramuc.toByteArray();
        p.g(paramuc, "parguard.toByteArray()");
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_cgi_cc_dat", paramuc);
        AppMethodBeat.o(210999);
        return;
      }
      catch (Exception paramuc)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)paramuc, "HellCloudData, write: " + paramuc.getMessage(), new Object[0]);
        AppMethodBeat.o(210999);
      }
    }
    
    public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<? extends bsg> paramList)
    {
      AppMethodBeat.i(210994);
      if ((paramString1 == null) || (paramString2 == null) || (paramList == null) || (paramList.isEmpty()))
      {
        AppMethodBeat.o(210994);
        return;
      }
      q(paramString1, paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(210994);
        return;
        AppMethodBeat.o(210994);
        return;
        a(paramString1, paramString2, paramList, false, paramBoolean);
      }
    }
    
    public static void a(String paramString1, String paramString2, List<? extends bsg> paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(210998);
      ad.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + paramString1 + ", " + paramBoolean2 + ", " + paramBoolean1);
      th localth = new th();
      localth.dHM.dHK = Long.parseLong(paramString1);
      localth.dHM.duO = paramString2;
      localth.dHM.dHI = Boolean.valueOf(paramBoolean1);
      localth.dHM.dHO = Boolean.valueOf(paramBoolean2);
      localth.dHM.dHN = paramList;
      localth.dHM.version = 2;
      com.tencent.mm.sdk.b.a.IbL.l((com.tencent.mm.sdk.b.b)localth);
      AppMethodBeat.o(210998);
    }
    
    public static void afx(String paramString)
    {
      AppMethodBeat.i(210996);
      uc localuc = cqS();
      if (localuc == null)
      {
        AppMethodBeat.o(210996);
        return;
      }
      Iterator localIterator = localuc.FTx.iterator();
      while (localIterator.hasNext())
      {
        cmm localcmm = (cmm)localIterator.next();
        if (p.i(paramString, localcmm.id))
        {
          localuc.FTx.remove(localcmm);
          a(localuc);
          AppMethodBeat.o(210996);
          return;
        }
      }
      AppMethodBeat.o(210996);
    }
    
    public static String b(String paramString1, List<? extends dbi> paramList, String paramString2)
    {
      AppMethodBeat.i(210997);
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
          localIterator2 = ((dbi)localIterator1.next()).Hrb.iterator();
        }
        paramList = (dwd)localIterator2.next();
      } while (!p.i(paramString1, paramList.aQj));
      if (paramList.HIB != null)
      {
        paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
        l.a.vc(130L);
        paramString1 = paramList.HIB;
        p.g(paramString1, "viewOp.resName");
        AppMethodBeat.o(210997);
        return paramString1;
      }
      ad.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + paramString1 + ", viewOp.viewId=" + paramList.aQj + ", viewOp.resName=" + paramList.HIB);
      paramList = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.qZp;
      l.a.vc(159L);
      if (paramString2 == null) {}
      for (;;)
      {
        AppMethodBeat.o(210997);
        return paramString1;
        if (paramString2 == null) {}
        for (;;)
        {
          AppMethodBeat.o(210997);
          return paramString1;
          paramString1 = paramString2;
        }
        paramString1 = paramString2;
      }
    }
    
    private static uc cqS()
    {
      AppMethodBeat.i(211000);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_cgi_cc_dat");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label35;
        }
      }
      label35:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(211000);
        return null;
      }
      uc localuc = new uc();
      try
      {
        localuc.parseFrom(arrayOfByte);
        AppMethodBeat.o(211000);
        return localuc;
      }
      catch (Exception localException)
      {
        ad.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)localException, "HellCloudData, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(211000);
      }
      return null;
    }
    
    private static void q(String paramString, List<? extends bsg> paramList)
    {
      AppMethodBeat.i(210995);
      uc localuc = cqS();
      if (localuc == null)
      {
        localuc = new uc();
        localObject = new cmm();
        ((cmm)localObject).id = paramString;
        ((cmm)localObject).HfP.addAll((Collection)paramList);
        localuc.FTx.add(localObject);
        a(localuc);
        AppMethodBeat.o(210995);
        return;
      }
      Object localObject = localuc.FTx.iterator();
      while (((Iterator)localObject).hasNext())
      {
        cmm localcmm = (cmm)((Iterator)localObject).next();
        if (p.i(paramString, localcmm.id))
        {
          localcmm.HfP.clear();
          localcmm.HfP.addAll((Collection)paramList);
          a(localuc);
          AppMethodBeat.o(210995);
          return;
        }
      }
      localObject = new cmm();
      ((cmm)localObject).id = paramString;
      ((cmm)localObject).HfP.addAll((Collection)paramList);
      localuc.FTx.add(localObject);
      a(localuc);
      AppMethodBeat.o(210995);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.a
 * JD-Core Version:    0.7.0.1
 */