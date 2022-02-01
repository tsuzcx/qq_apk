package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cym;
import com.tencent.mm.protocal.protobuf.cyn;
import com.tencent.mm.protocal.protobuf.cyo;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a sHi;
  
  static
  {
    AppMethodBeat.i(221082);
    sHi = new a((byte)0);
    AppMethodBeat.o(221082);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"})
  public static final class a
  {
    private static void a(cyo paramcyo)
    {
      AppMethodBeat.i(221073);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_1", paramcyo.toByteArray());
        AppMethodBeat.o(221073);
        return;
      }
      catch (Exception paramcyo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramcyo, "_write, exception: " + paramcyo.getMessage(), new Object[0]);
        AppMethodBeat.o(221073);
      }
    }
    
    private static void b(cyo paramcyo)
    {
      AppMethodBeat.i(221081);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_3", paramcyo.toByteArray());
        AppMethodBeat.o(221081);
        return;
      }
      catch (Exception paramcyo)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramcyo, "_writeWith78Event, exception: " + paramcyo.getMessage(), new Object[0]);
        AppMethodBeat.o(221081);
      }
    }
    
    private static cyo cPp()
    {
      AppMethodBeat.i(221072);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_1");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(221072);
        return null;
      }
      cyo localcyo = new cyo();
      try
      {
        localcyo.parseFrom(arrayOfByte);
        AppMethodBeat.o(221072);
        return localcyo;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_read, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    private static cyo cPs()
    {
      AppMethodBeat.i(221080);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_3");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(221080);
        return null;
      }
      cyo localcyo = new cyo();
      try
      {
        localcyo.parseFrom(arrayOfByte);
        AppMethodBeat.o(221080);
        return localcyo;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_readWith78Event, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    public final void a(cym paramcym)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221066);
          p.h(paramcym, "statics");
          cyo localcyo = cPp();
          if (localcyo != null) {
            break label171;
          }
          localcyo = new cyo();
          String str = paramcym.dMl + paramcym.aHK;
          Object localObject = localcyo.Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.j(str, ((cyn)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new cyn();
              ((cyn)localObject).key = str;
              ((cyn)localObject).MDw = paramcym;
              localcyo.Mlv.add(localObject);
              a(localcyo);
            }
            AppMethodBeat.o(221066);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void b(cym paramcym)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221067);
          p.h(paramcym, "statics");
          cyo localcyo = cPp();
          if (localcyo != null) {
            break label181;
          }
          localcyo = new cyo();
          String str = paramcym.dMl + paramcym.aHK;
          Object localObject = localcyo.Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cyn localcyn = (cyn)((Iterator)localObject).next();
            if (!p.j(str, localcyn.key)) {
              continue;
            }
            localcyn.MDw = paramcym;
            i = 1;
            if (i == 0)
            {
              localObject = new cyn();
              ((cyn)localObject).key = str;
              ((cyn)localObject).MDw = paramcym;
              localcyo.Mlv.add(localObject);
            }
            a(localcyo);
            AppMethodBeat.o(221067);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void c(cym paramcym)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221074);
          p.h(paramcym, "statics");
          cyo localcyo = cPs();
          if (localcyo != null) {
            break label171;
          }
          localcyo = new cyo();
          String str = paramcym.dMl + paramcym.aHK;
          Object localObject = localcyo.Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.j(str, ((cyn)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new cyn();
              ((cyn)localObject).key = str;
              ((cyn)localObject).MDw = paramcym;
              localcyo.Mlv.add(localObject);
              b(localcyo);
            }
            AppMethodBeat.o(221074);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final cym cPo()
    {
      cym localcym = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221070);
          cyo localcyo = cPp();
          if (localcyo == null)
          {
            AppMethodBeat.o(221070);
            return localcym;
          }
          if (localcyo.Mlv.isEmpty())
          {
            AppMethodBeat.o(221070);
            continue;
          }
          localObject2 = localcyo.Mlv;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((cyn)((LinkedList)localObject2).getLast()).MDw;
        AppMethodBeat.o(221070);
      }
    }
    
    public final cym cPq()
    {
      cym localcym = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221078);
          cyo localcyo = cPs();
          if (localcyo == null)
          {
            AppMethodBeat.o(221078);
            return localcym;
          }
          if (localcyo.Mlv.isEmpty())
          {
            AppMethodBeat.o(221078);
            continue;
          }
          localObject2 = localcyo.Mlv;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((cyn)((LinkedList)localObject2).getLast()).MDw;
        AppMethodBeat.o(221078);
      }
    }
    
    public final void cPr()
    {
      try
      {
        AppMethodBeat.i(221079);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_3", new byte[0]);
        }
        AppMethodBeat.o(221079);
        return;
      }
      finally {}
    }
    
    public final void d(cym paramcym)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221075);
          p.h(paramcym, "statics");
          cyo localcyo = cPs();
          if (localcyo != null) {
            break label181;
          }
          localcyo = new cyo();
          String str = paramcym.dMl + paramcym.aHK;
          Object localObject = localcyo.Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cyn localcyn = (cyn)((Iterator)localObject).next();
            if (!p.j(str, localcyn.key)) {
              continue;
            }
            localcyn.MDw = paramcym;
            i = 1;
            if (i == 0)
            {
              localObject = new cyn();
              ((cyn)localObject).key = str;
              ((cyn)localObject).MDw = paramcym;
              localcyo.Mlv.add(localObject);
            }
            b(localcyo);
            AppMethodBeat.o(221075);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final cym dk(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221068);
          if (paramString == null)
          {
            AppMethodBeat.o(221068);
            paramString = null;
            return paramString;
          }
          Object localObject = cPp();
          if (localObject == null)
          {
            AppMethodBeat.o(221068);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((cyo)localObject).Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cyn localcyn = (cyn)((Iterator)localObject).next();
            if (!p.j(paramString, localcyn.key)) {
              continue;
            }
            paramString = localcyn.MDw;
            AppMethodBeat.o(221068);
            continue;
          }
          AppMethodBeat.o(221068);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dl(String paramString, int paramInt)
    {
      cyo localcyo;
      try
      {
        AppMethodBeat.i(221069);
        if (paramString == null) {
          AppMethodBeat.o(221069);
        }
        for (;;)
        {
          return;
          localcyo = cPp();
          if (localcyo != null) {
            break;
          }
          AppMethodBeat.o(221069);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localcyo.Mlv;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cyn localcyn = (cyn)((Iterator)localObject).next();
        if (p.j(paramString, localcyn.key)) {
          localcyo.Mlv.remove(localcyn);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localcyo.Mlv.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_1", new byte[0]);
            AppMethodBeat.o(221069);
            break;
          }
          a(localcyo);
        }
        AppMethodBeat.o(221069);
        break;
      }
    }
    
    public final cym dm(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(221076);
          if (paramString == null)
          {
            AppMethodBeat.o(221076);
            paramString = null;
            return paramString;
          }
          Object localObject = cPs();
          if (localObject == null)
          {
            AppMethodBeat.o(221076);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((cyo)localObject).Mlv;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cyn localcyn = (cyn)((Iterator)localObject).next();
            if (!p.j(paramString, localcyn.key)) {
              continue;
            }
            paramString = localcyn.MDw;
            AppMethodBeat.o(221076);
            continue;
          }
          AppMethodBeat.o(221076);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dn(String paramString, int paramInt)
    {
      cyo localcyo;
      try
      {
        AppMethodBeat.i(221077);
        if (paramString == null) {
          AppMethodBeat.o(221077);
        }
        for (;;)
        {
          return;
          localcyo = cPs();
          if (localcyo != null) {
            break;
          }
          AppMethodBeat.o(221077);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localcyo.Mlv;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cyn localcyn = (cyn)((Iterator)localObject).next();
        if (p.j(paramString, localcyn.key)) {
          localcyo.Mlv.remove(localcyn);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localcyo.Mlv.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_3", new byte[0]);
            AppMethodBeat.o(221077);
            break;
          }
          b(localcyo);
        }
        AppMethodBeat.o(221077);
        break;
      }
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(221071);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "reset");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.o("hell_pge_sttics_d_1", new byte[0]);
        }
        AppMethodBeat.o(221071);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.f
 * JD-Core Version:    0.7.0.1
 */