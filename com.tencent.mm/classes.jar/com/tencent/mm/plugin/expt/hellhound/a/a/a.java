package com.tencent.mm.plugin.expt.hellhound.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.wz;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l;
import com.tencent.mm.plugin.expt.hellhound.ext.session.e.l.a;
import com.tencent.mm.protocal.protobuf.dfj;
import com.tencent.mm.protocal.protobuf.ehm;
import com.tencent.mm.protocal.protobuf.ezb;
import com.tencent.mm.protocal.protobuf.fya;
import com.tencent.mm.protocal.protobuf.xf;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a zLL;
  
  static
  {
    AppMethodBeat.i(299898);
    zLL = new a((byte)0);
    AppMethodBeat.o(299898);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "default", "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static void a(xf paramxf)
    {
      AppMethodBeat.i(299943);
      try
      {
        paramxf = paramxf.toByteArray();
        s.s(paramxf, "parguard.toByteArray()");
        b.u("hell_cgi_cc_dat", paramxf);
        AppMethodBeat.o(299943);
        return;
      }
      catch (Exception paramxf)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)paramxf, s.X("HellCloudData, write: ", paramxf.getMessage()), new Object[0]);
        AppMethodBeat.o(299943);
      }
    }
    
    public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<? extends dfj> paramList)
    {
      AppMethodBeat.i(299918);
      if ((paramString1 == null) || (paramString2 == null) || (paramList == null) || (paramList.isEmpty()))
      {
        AppMethodBeat.o(299918);
        return;
      }
      x(paramString1, paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(299918);
        return;
        AppMethodBeat.o(299918);
        return;
        a(paramString1, paramString2, paramList, false, paramBoolean);
      }
    }
    
    public static void a(String paramString1, String paramString2, List<? extends dfj> paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(299939);
      Log.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + paramString1 + ", " + paramBoolean2 + ", " + paramBoolean1);
      wz localwz = new wz();
      localwz.iax.iav = Long.parseLong(paramString1);
      localwz.iax.hMi = paramString2;
      localwz.iax.iat = Boolean.valueOf(paramBoolean1);
      localwz.iax.iaz = Boolean.valueOf(paramBoolean2);
      localwz.iax.iay = paramList;
      localwz.iax.version = 2;
      localwz.publish();
      AppMethodBeat.o(299939);
    }
    
    public static void atk(String paramString)
    {
      AppMethodBeat.i(299930);
      xf localxf = dMI();
      if (localxf == null)
      {
        AppMethodBeat.o(299930);
        return;
      }
      Iterator localIterator = localxf.ZfU.iterator();
      while (localIterator.hasNext())
      {
        ehm localehm = (ehm)localIterator.next();
        if (s.p(paramString, localehm.id))
        {
          localxf.ZfU.remove(localehm);
          a(localxf);
          AppMethodBeat.o(299930);
          return;
        }
      }
      AppMethodBeat.o(299930);
    }
    
    public static String b(String paramString1, List<? extends ezb> paramList, String paramString2)
    {
      AppMethodBeat.i(299936);
      s.u(paramString1, "viewId");
      s.u(paramList, "pageList");
      do
      {
        Iterator localIterator1 = paramList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((ezb)localIterator1.next()).abAg.iterator();
        }
        paramList = (fya)localIterator2.next();
      } while (!s.p(paramString1, paramList.viewId));
      if (paramList.abVR != null)
      {
        paramString1 = l.zKT;
        l.a.jX(130L);
        paramString1 = paramList.abVR;
        s.s(paramString1, "viewOp.resName");
        AppMethodBeat.o(299936);
        return paramString1;
      }
      Log.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + paramString1 + ", viewOp.viewId=" + paramList.viewId + ", viewOp.resName=" + paramList.abVR);
      paramList = l.zKT;
      l.a.jX(159L);
      if (paramString2 == null)
      {
        AppMethodBeat.o(299936);
        return paramString1;
      }
      AppMethodBeat.o(299936);
      return paramString2;
      if (paramString2 == null)
      {
        AppMethodBeat.o(299936);
        return paramString1;
      }
      AppMethodBeat.o(299936);
      return paramString2;
    }
    
    private static xf dMI()
    {
      AppMethodBeat.i(299946);
      byte[] arrayOfByte = b.ard("hell_cgi_cc_dat");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label35;
        }
      }
      label35:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(299946);
        return null;
      }
      xf localxf = new xf();
      try
      {
        localxf.parseFrom(arrayOfByte);
        AppMethodBeat.o(299946);
        return localxf;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)localException, s.X("HellCloudData, read: ", localException.getMessage()), new Object[0]);
        AppMethodBeat.o(299946);
      }
      return null;
    }
    
    private static void x(String paramString, List<? extends dfj> paramList)
    {
      AppMethodBeat.i(299925);
      xf localxf = dMI();
      if (localxf == null)
      {
        localxf = new xf();
        localObject = new ehm();
        ((ehm)localObject).id = paramString;
        ((ehm)localObject).abmI.addAll((Collection)paramList);
        localxf.ZfU.add(localObject);
        a(localxf);
        AppMethodBeat.o(299925);
        return;
      }
      Object localObject = localxf.ZfU.iterator();
      while (((Iterator)localObject).hasNext())
      {
        ehm localehm = (ehm)((Iterator)localObject).next();
        if (s.p(paramString, localehm.id))
        {
          localehm.abmI.clear();
          localehm.abmI.addAll((Collection)paramList);
          a(localxf);
          AppMethodBeat.o(299925);
          return;
        }
      }
      localObject = new ehm();
      ((ehm)localObject).id = paramString;
      ((ehm)localObject).abmI.addAll((Collection)paramList);
      localxf.ZfU.add(localObject);
      a(localxf);
      AppMethodBeat.o(299925);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.a.a
 * JD-Core Version:    0.7.0.1
 */