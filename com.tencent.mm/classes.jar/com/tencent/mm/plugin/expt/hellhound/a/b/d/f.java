package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.chl;
import com.tencent.mm.protocal.protobuf.chm;
import com.tencent.mm.protocal.protobuf.chn;
import com.tencent.mm.sdk.platformtools.ad;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a qXM;
  
  static
  {
    AppMethodBeat.i(210919);
    qXM = new a((byte)0);
    AppMethodBeat.o(210919);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"})
  public static final class a
  {
    private static void a(chn paramchn)
    {
      AppMethodBeat.i(210910);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", paramchn.toByteArray());
        AppMethodBeat.o(210910);
        return;
      }
      catch (Exception paramchn)
      {
        ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramchn, "_write, exception: " + paramchn.getMessage(), new Object[0]);
        AppMethodBeat.o(210910);
      }
    }
    
    private static void b(chn paramchn)
    {
      AppMethodBeat.i(210918);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", paramchn.toByteArray());
        AppMethodBeat.o(210918);
        return;
      }
      catch (Exception paramchn)
      {
        ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramchn, "_writeWith78Event, exception: " + paramchn.getMessage(), new Object[0]);
        AppMethodBeat.o(210918);
      }
    }
    
    private static chn cpg()
    {
      AppMethodBeat.i(210909);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_1");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210909);
        return null;
      }
      chn localchn = new chn();
      try
      {
        localchn.parseFrom(arrayOfByte);
        AppMethodBeat.o(210909);
        return localchn;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_read, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    private static chn cpj()
    {
      AppMethodBeat.i(210917);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_3");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(210917);
        return null;
      }
      chn localchn = new chn();
      try
      {
        localchn.parseFrom(arrayOfByte);
        AppMethodBeat.o(210917);
        return localchn;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ad.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_readWith78Event, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    public final void a(chl paramchl)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210903);
          p.h(paramchl, "statics");
          chn localchn = cpg();
          if (localchn != null) {
            break label171;
          }
          localchn = new chn();
          String str = paramchl.dtL + paramchl.aHQ;
          Object localObject = localchn.GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.i(str, ((chm)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new chm();
              ((chm)localObject).key = str;
              ((chm)localObject).HaY = paramchl;
              localchn.GML.add(localObject);
              a(localchn);
            }
            AppMethodBeat.o(210903);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void b(chl paramchl)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210904);
          p.h(paramchl, "statics");
          chn localchn = cpg();
          if (localchn != null) {
            break label181;
          }
          localchn = new chn();
          String str = paramchl.dtL + paramchl.aHQ;
          Object localObject = localchn.GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            chm localchm = (chm)((Iterator)localObject).next();
            if (!p.i(str, localchm.key)) {
              continue;
            }
            localchm.HaY = paramchl;
            i = 1;
            if (i == 0)
            {
              localObject = new chm();
              ((chm)localObject).key = str;
              ((chm)localObject).HaY = paramchl;
              localchn.GML.add(localObject);
            }
            a(localchn);
            AppMethodBeat.o(210904);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void c(chl paramchl)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210911);
          p.h(paramchl, "statics");
          chn localchn = cpj();
          if (localchn != null) {
            break label171;
          }
          localchn = new chn();
          String str = paramchl.dtL + paramchl.aHQ;
          Object localObject = localchn.GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.i(str, ((chm)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new chm();
              ((chm)localObject).key = str;
              ((chm)localObject).HaY = paramchl;
              localchn.GML.add(localObject);
              b(localchn);
            }
            AppMethodBeat.o(210911);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final chl cpf()
    {
      chl localchl = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210907);
          chn localchn = cpg();
          if (localchn == null)
          {
            AppMethodBeat.o(210907);
            return localchl;
          }
          if (localchn.GML.isEmpty())
          {
            AppMethodBeat.o(210907);
            continue;
          }
          localObject2 = localchn.GML;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((chm)((LinkedList)localObject2).getLast()).HaY;
        AppMethodBeat.o(210907);
      }
    }
    
    public final chl cph()
    {
      chl localchl = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210915);
          chn localchn = cpj();
          if (localchn == null)
          {
            AppMethodBeat.o(210915);
            return localchl;
          }
          if (localchn.GML.isEmpty())
          {
            AppMethodBeat.o(210915);
            continue;
          }
          localObject2 = localchn.GML;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((chm)((LinkedList)localObject2).getLast()).HaY;
        AppMethodBeat.o(210915);
      }
    }
    
    public final void cpi()
    {
      try
      {
        AppMethodBeat.i(210916);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
        {
          ad.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", new byte[0]);
        }
        AppMethodBeat.o(210916);
        return;
      }
      finally {}
    }
    
    public final void d(chl paramchl)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210912);
          p.h(paramchl, "statics");
          chn localchn = cpj();
          if (localchn != null) {
            break label181;
          }
          localchn = new chn();
          String str = paramchl.dtL + paramchl.aHQ;
          Object localObject = localchn.GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            chm localchm = (chm)((Iterator)localObject).next();
            if (!p.i(str, localchm.key)) {
              continue;
            }
            localchm.HaY = paramchl;
            i = 1;
            if (i == 0)
            {
              localObject = new chm();
              ((chm)localObject).key = str;
              ((chm)localObject).HaY = paramchl;
              localchn.GML.add(localObject);
            }
            b(localchn);
            AppMethodBeat.o(210912);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final chl da(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210905);
          if (paramString == null)
          {
            AppMethodBeat.o(210905);
            paramString = null;
            return paramString;
          }
          Object localObject = cpg();
          if (localObject == null)
          {
            AppMethodBeat.o(210905);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((chn)localObject).GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            chm localchm = (chm)((Iterator)localObject).next();
            if (!p.i(paramString, localchm.key)) {
              continue;
            }
            paramString = localchm.HaY;
            AppMethodBeat.o(210905);
            continue;
          }
          AppMethodBeat.o(210905);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void db(String paramString, int paramInt)
    {
      chn localchn;
      try
      {
        AppMethodBeat.i(210906);
        if (paramString == null) {
          AppMethodBeat.o(210906);
        }
        for (;;)
        {
          return;
          localchn = cpg();
          if (localchn != null) {
            break;
          }
          AppMethodBeat.o(210906);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localchn.GML;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        chm localchm = (chm)((Iterator)localObject).next();
        if (p.i(paramString, localchm.key)) {
          localchn.GML.remove(localchm);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localchn.GML.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", new byte[0]);
            AppMethodBeat.o(210906);
            break;
          }
          a(localchn);
        }
        AppMethodBeat.o(210906);
        break;
      }
    }
    
    public final chl dc(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(210913);
          if (paramString == null)
          {
            AppMethodBeat.o(210913);
            paramString = null;
            return paramString;
          }
          Object localObject = cpj();
          if (localObject == null)
          {
            AppMethodBeat.o(210913);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((chn)localObject).GML;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            chm localchm = (chm)((Iterator)localObject).next();
            if (!p.i(paramString, localchm.key)) {
              continue;
            }
            paramString = localchm.HaY;
            AppMethodBeat.o(210913);
            continue;
          }
          AppMethodBeat.o(210913);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dd(String paramString, int paramInt)
    {
      chn localchn;
      try
      {
        AppMethodBeat.i(210914);
        if (paramString == null) {
          AppMethodBeat.o(210914);
        }
        for (;;)
        {
          return;
          localchn = cpj();
          if (localchn != null) {
            break;
          }
          AppMethodBeat.o(210914);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localchn.GML;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        chm localchm = (chm)((Iterator)localObject).next();
        if (p.i(paramString, localchm.key)) {
          localchn.GML.remove(localchm);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localchn.GML.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", new byte[0]);
            AppMethodBeat.o(210914);
            break;
          }
          b(localchn);
        }
        AppMethodBeat.o(210914);
        break;
      }
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(210908);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.cnC())
        {
          ad.i("HABBYGE-MALI.PageStatisticsDao", "reset");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", new byte[0]);
        }
        AppMethodBeat.o(210908);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.f
 * JD-Core Version:    0.7.0.1
 */