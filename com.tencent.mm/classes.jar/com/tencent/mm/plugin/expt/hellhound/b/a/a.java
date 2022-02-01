package com.tencent.mm.plugin.expt.hellhound.b.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.vj;
import com.tencent.mm.plugin.expt.hellhound.a.f.f.l.a;
import com.tencent.mm.plugin.expt.hellhound.core.a.b;
import com.tencent.mm.protocal.protobuf.cop;
import com.tencent.mm.protocal.protobuf.dot;
import com.tencent.mm.protocal.protobuf.efi;
import com.tencent.mm.protocal.protobuf.fbp;
import com.tencent.mm.protocal.protobuf.vn;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import kotlin.g.b.p;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData;", "", "()V", "Companion", "plugin-expt_release"})
public final class a
{
  public static final a wpJ;
  
  static
  {
    AppMethodBeat.i(252497);
    wpJ = new a((byte)0);
    AppMethodBeat.o(252497);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/model/dao/HellCloudData$Companion;", "", "()V", "CONFIG_TYPE_SESSION", "", "CONFIG_TYPE_SESSION_PAGE", "CONFIG_TYPE_UBA", "CONFIG_TYPE_VIEW_BLACK_LIST", "MMKV_KEY", "", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/CgiConfigProguard;", "_write", "", "parguard", "addJson", "id", "type", "isReport", "", "json", "kvMap", "", "Lcom/tencent/mm/protocal/protobuf/KV;", "addKv", "delKv", "geViewResName", "viewId", "pageList", "Lcom/tencent/mm/protocal/protobuf/SessionPage;", "default", "notifySessionPageConfigChange", "isDel", "removeJson", "reset", "resetJson", "updateJson", "plugin-expt_release"})
  public static final class a
  {
    private static void a(vn paramvn)
    {
      AppMethodBeat.i(252720);
      try
      {
        paramvn = paramvn.toByteArray();
        p.j(paramvn, "parguard.toByteArray()");
        b.r("hell_cgi_cc_dat", paramvn);
        AppMethodBeat.o(252720);
        return;
      }
      catch (Exception paramvn)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)paramvn, "HellCloudData, write: " + paramvn.getMessage(), new Object[0]);
        AppMethodBeat.o(252720);
      }
    }
    
    public static void a(String paramString1, int paramInt, boolean paramBoolean, String paramString2, List<? extends cop> paramList)
    {
      AppMethodBeat.i(252709);
      if ((paramString1 == null) || (paramString2 == null) || (paramList == null) || (paramList.isEmpty()))
      {
        AppMethodBeat.o(252709);
        return;
      }
      r(paramString1, paramList);
      switch (paramInt)
      {
      }
      for (;;)
      {
        AppMethodBeat.o(252709);
        return;
        AppMethodBeat.o(252709);
        return;
        a(paramString1, paramString2, paramList, false, paramBoolean);
      }
    }
    
    public static void a(String paramString1, String paramString2, List<? extends cop> paramList, boolean paramBoolean1, boolean paramBoolean2)
    {
      AppMethodBeat.i(252718);
      Log.i("HABBYGE-MALI.HellCloudData", "notifySessionPageConfigChange: " + paramString1 + ", " + paramBoolean2 + ", " + paramBoolean1);
      vj localvj = new vj();
      localvj.fUA.fUy = Long.parseLong(paramString1);
      localvj.fUA.fGM = paramString2;
      localvj.fUA.fUw = Boolean.valueOf(paramBoolean1);
      localvj.fUA.fUC = Boolean.valueOf(paramBoolean2);
      localvj.fUA.fUB = paramList;
      localvj.fUA.version = 2;
      EventCenter.instance.publish((IEvent)localvj);
      AppMethodBeat.o(252718);
    }
    
    public static void azf(String paramString)
    {
      AppMethodBeat.i(252714);
      vn localvn = dfY();
      if (localvn == null)
      {
        AppMethodBeat.o(252714);
        return;
      }
      Iterator localIterator = localvn.ShO.iterator();
      while (localIterator.hasNext())
      {
        dot localdot = (dot)localIterator.next();
        if (p.h(paramString, localdot.id))
        {
          localvn.ShO.remove(localdot);
          a(localvn);
          AppMethodBeat.o(252714);
          return;
        }
      }
      AppMethodBeat.o(252714);
    }
    
    public static String b(String paramString1, List<? extends efi> paramList, String paramString2)
    {
      AppMethodBeat.i(252716);
      p.k(paramString1, "viewId");
      p.k(paramList, "pageList");
      do
      {
        Iterator localIterator1 = paramList.iterator();
        Iterator localIterator2;
        while (!localIterator2.hasNext())
        {
          if (!localIterator1.hasNext()) {
            break;
          }
          localIterator2 = ((efi)localIterator1.next()).UiH.iterator();
        }
        paramList = (fbp)localIterator2.next();
      } while (!p.h(paramString1, paramList.viewId));
      if (paramList.UBI != null)
      {
        paramString1 = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
        l.a.HG(130L);
        paramString1 = paramList.UBI;
        p.j(paramString1, "viewOp.resName");
        AppMethodBeat.o(252716);
        return paramString1;
      }
      Log.i("HABBYGE-MALI.HellCloudData", "geViewResName, viewId=" + paramString1 + ", viewOp.viewId=" + paramList.viewId + ", viewOp.resName=" + paramList.UBI);
      paramList = com.tencent.mm.plugin.expt.hellhound.a.f.f.l.woO;
      l.a.HG(159L);
      if (paramString2 == null) {}
      for (;;)
      {
        AppMethodBeat.o(252716);
        return paramString1;
        if (paramString2 == null) {}
        for (;;)
        {
          AppMethodBeat.o(252716);
          return paramString1;
          paramString1 = paramString2;
        }
        paramString1 = paramString2;
      }
    }
    
    private static vn dfY()
    {
      AppMethodBeat.i(252723);
      byte[] arrayOfByte = b.awZ("hell_cgi_cc_dat");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label35;
        }
      }
      label35:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(252723);
        return null;
      }
      vn localvn = new vn();
      try
      {
        localvn.parseFrom(arrayOfByte);
        AppMethodBeat.o(252723);
        return localvn;
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("HABBYGE-MALI.HellCloudData", (Throwable)localException, "HellCloudData, read: " + localException.getMessage(), new Object[0]);
        AppMethodBeat.o(252723);
      }
      return null;
    }
    
    private static void r(String paramString, List<? extends cop> paramList)
    {
      AppMethodBeat.i(252712);
      vn localvn = dfY();
      if (localvn == null)
      {
        localvn = new vn();
        localObject = new dot();
        ((dot)localObject).id = paramString;
        ((dot)localObject).TVU.addAll((Collection)paramList);
        localvn.ShO.add(localObject);
        a(localvn);
        AppMethodBeat.o(252712);
        return;
      }
      Object localObject = localvn.ShO.iterator();
      while (((Iterator)localObject).hasNext())
      {
        dot localdot = (dot)((Iterator)localObject).next();
        if (p.h(paramString, localdot.id))
        {
          localdot.TVU.clear();
          localdot.TVU.addAll((Collection)paramList);
          a(localvn);
          AppMethodBeat.o(252712);
          return;
        }
      }
      localObject = new dot();
      ((dot)localObject).id = paramString;
      ((dot)localObject).TVU.addAll((Collection)paramList);
      localvn.ShO.add(localObject);
      a(localvn);
      AppMethodBeat.o(252712);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.b.a.a
 * JD-Core Version:    0.7.0.1
 */