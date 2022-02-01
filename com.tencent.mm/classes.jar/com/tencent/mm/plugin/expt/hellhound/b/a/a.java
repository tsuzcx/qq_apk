package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cft;
import com.tencent.mm.protocal.protobuf.dfa;
import com.tencent.mm.protocal.protobuf.dvg;
import com.tencent.mm.protocal.protobuf.ere;
import com.tencent.mm.protocal.protobuf.vl;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a sJL;
  
  static
  {
    AppMethodBeat.i(221171);
    sJL = new a((byte)0);
    AppMethodBeat.o(221171);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "default", "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"})
  public static final class a
  {
    private static void a(vl paramvl)
    {
      AppMethodBeat.i(221169);
      try
      {
        paramvl = paramvl.toByteArray();
        p.g(paramvl, "parguard.toByteArray()");
        b.o("hell_cgi_cc_dat", paramvl);
        AppMethodBeat.o(221169);
        return;
      }
      catch (Exception paramvl)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)paramvl, "HellCloudData, write: " + paramvl.getMessage(), new Object[0]);
        AppMethodBeat.o(221169);
      }
    }
    
    public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<? extends cft> paramList)
    {
      AppMethodBeat.i(221164);
      if ((paramString1 == null) || (paramString2 == null) || (paramList == null) || (paramList.isEmpty()))
      {
        AppMethodBeat.o(221164);
        return;
      }
      r(paramString1, paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(221164);
        return;
        AppMethodBeat.o(221164);
        return;
        a(paramString1, paramString2, paramList, false, paramBoolean);
      }
    }
    
    public static void a(String paramString1, String paramString2, List<? extends cft> paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(221168);
      Log.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + paramString1 + ", " + paramBoolean2 + ", " + paramBoolean1);
      ug localug = new ug();
      localug.eaD.eaB = Long.parseLong(paramString1);
      localug.eaD.dNA = paramString2;
      localug.eaD.eaz = Boolean.valueOf(paramBoolean1);
      localug.eaD.eaF = Boolean.valueOf(paramBoolean2);
      localug.eaD.eaE = paramList;
      localug.eaD.version = 2;
      EventCenter.instance.publish((IEvent)localug);
      AppMethodBeat.o(221168);
    }
    
    public static void are(String paramString)
    {
      AppMethodBeat.i(221166);
      vl localvl = cRd();
      if (localvl == null)
      {
        AppMethodBeat.o(221166);
        return;
      }
      Iterator localIterator = localvl.LgA.iterator();
      while (localIterator.hasNext())
      {
        dfa localdfa = (dfa)localIterator.next();
        if (p.j(paramString, localdfa.id))
        {
          localvl.LgA.remove(localdfa);
          a(localvl);
          AppMethodBeat.o(221166);
          return;
        }
      }
      AppMethodBeat.o(221166);
    }
    
    public static String b(String paramString1, List<? extends dvg> paramList, String paramString2)
    {
      AppMethodBeat.i(221167);
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
          localIterator2 = ((dvg)localIterator1.next()).MWm.iterator();
        }
        paramList = (ere)localIterator2.next();
      } while (!p.j(paramString1, paramList.viewId));
      if (paramList.NoL != null)
      {
        paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
        l.a.Bt(130L);
        paramString1 = paramList.NoL;
        p.g(paramString1, "viewOp.resName");
        AppMethodBeat.o(221167);
        return paramString1;
      }
      Log.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + paramString1 + ", viewOp.viewId=" + paramList.viewId + ", viewOp.resName=" + paramList.NoL);
      paramList = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.sIR;
      l.a.Bt(159L);
      if (paramString2 == null) {}
      for (;;)
      {
        AppMethodBeat.o(221167);
        return paramString1;
        if (paramString2 == null) {}
        for (;;)
        {
          AppMethodBeat.o(221167);
          return paramString1;
          paramString1 = paramString2;
        }
        paramString1 = paramString2;
      }
    }
    
    private static vl cRd()
    {
      AppMethodBeat.i(221170);
      byte[] arrayOfByte = b.getBytes("hell_cgi_cc_dat");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label35;
        }
      }
      label35:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(221170);
        return null;
      }
      vl localvl = new vl();
      try
      {
        localvl.parseFrom(arrayOfByte);
        AppMethodBeat.o(221170);
        return localvl;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)localException, "HellCloudData, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(221170);
      }
      return null;
    }
    
    private static void r(String paramString, List<? extends cft> paramList)
    {
      AppMethodBeat.i(221165);
      vl localvl = cRd();
      if (localvl == null)
      {
        localvl = new vl();
        localObject = new dfa();
        ((dfa)localObject).id = paramString;
        ((dfa)localObject).MKb.addAll((Collection)paramList);
        localvl.LgA.add(localObject);
        a(localvl);
        AppMethodBeat.o(221165);
        return;
      }
      Object localObject = localvl.LgA.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dfa localdfa = (dfa)((Iterator)localObject).next();
        if (p.j(paramString, localdfa.id))
        {
          localdfa.MKb.clear();
          localdfa.MKb.addAll((Collection)paramList);
          a(localvl);
          AppMethodBeat.o(221165);
          return;
        }
      }
      localObject = new dfa();
      ((dfa)localObject).id = paramString;
      ((dfa)localObject).MKb.addAll((Collection)paramList);
      localvl.LgA.add(localObject);
      a(localvl);
      AppMethodBeat.o(221165);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.a
 * JD-Core Version:    0.7.0.1
 */