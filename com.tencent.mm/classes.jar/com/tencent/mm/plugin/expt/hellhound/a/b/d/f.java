package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.cif;
import com.tencent.mm.protocal.protobuf.cig;
import com.tencent.mm.protocal.protobuf.cih;
import com.tencent.mm.sdk.platformtools.ae;
import d.g.b.p;
import d.l;
import java.util.Iterator;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a rfS;
  
  static
  {
    AppMethodBeat.i(196590);
    rfS = new a((byte)0);
    AppMethodBeat.o(196590);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"})
  public static final class a
  {
    private static void a(cih paramcih)
    {
      AppMethodBeat.i(196581);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", paramcih.toByteArray());
        AppMethodBeat.o(196581);
        return;
      }
      catch (Exception paramcih)
      {
        ae.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramcih, "_write, exception: " + paramcih.getMessage(), new Object[0]);
        AppMethodBeat.o(196581);
      }
    }
    
    private static void b(cih paramcih)
    {
      AppMethodBeat.i(196589);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", paramcih.toByteArray());
        AppMethodBeat.o(196589);
        return;
      }
      catch (Exception paramcih)
      {
        ae.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramcih, "_writeWith78Event, exception: " + paramcih.getMessage(), new Object[0]);
        AppMethodBeat.o(196589);
      }
    }
    
    private static cih cqI()
    {
      AppMethodBeat.i(196580);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_1");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(196580);
        return null;
      }
      cih localcih = new cih();
      try
      {
        localcih.parseFrom(arrayOfByte);
        AppMethodBeat.o(196580);
        return localcih;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_read, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    private static cih cqL()
    {
      AppMethodBeat.i(196588);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.getBytes("hell_pge_sttics_d_3");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(196588);
        return null;
      }
      cih localcih = new cih();
      try
      {
        localcih.parseFrom(arrayOfByte);
        AppMethodBeat.o(196588);
        return localcih;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          ae.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, "_readWith78Event, exception: " + localException.getMessage(), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    public final void a(cif paramcif)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196574);
          p.h(paramcif, "statics");
          cih localcih = cqI();
          if (localcih != null) {
            break label171;
          }
          localcih = new cih();
          String str = paramcif.duQ + paramcif.aHQ;
          Object localObject = localcih.Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.i(str, ((cig)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new cig();
              ((cig)localObject).key = str;
              ((cig)localObject).Huy = paramcif;
              localcih.Hgm.add(localObject);
              a(localcih);
            }
            AppMethodBeat.o(196574);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void b(cif paramcif)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196575);
          p.h(paramcif, "statics");
          cih localcih = cqI();
          if (localcih != null) {
            break label181;
          }
          localcih = new cih();
          String str = paramcif.duQ + paramcif.aHQ;
          Object localObject = localcih.Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cig localcig = (cig)((Iterator)localObject).next();
            if (!p.i(str, localcig.key)) {
              continue;
            }
            localcig.Huy = paramcif;
            i = 1;
            if (i == 0)
            {
              localObject = new cig();
              ((cig)localObject).key = str;
              ((cig)localObject).Huy = paramcif;
              localcih.Hgm.add(localObject);
            }
            a(localcih);
            AppMethodBeat.o(196575);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void c(cif paramcif)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196582);
          p.h(paramcif, "statics");
          cih localcih = cqL();
          if (localcih != null) {
            break label171;
          }
          localcih = new cih();
          String str = paramcif.duQ + paramcif.aHQ;
          Object localObject = localcih.Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.i(str, ((cig)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new cig();
              ((cig)localObject).key = str;
              ((cig)localObject).Huy = paramcif;
              localcih.Hgm.add(localObject);
              b(localcih);
            }
            AppMethodBeat.o(196582);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final cif cqH()
    {
      cif localcif = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196578);
          cih localcih = cqI();
          if (localcih == null)
          {
            AppMethodBeat.o(196578);
            return localcif;
          }
          if (localcih.Hgm.isEmpty())
          {
            AppMethodBeat.o(196578);
            continue;
          }
          localObject2 = localcih.Hgm;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((cig)((LinkedList)localObject2).getLast()).Huy;
        AppMethodBeat.o(196578);
      }
    }
    
    public final cif cqJ()
    {
      cif localcif = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196586);
          cih localcih = cqL();
          if (localcih == null)
          {
            AppMethodBeat.o(196586);
            return localcif;
          }
          if (localcih.Hgm.isEmpty())
          {
            AppMethodBeat.o(196586);
            continue;
          }
          localObject2 = localcih.Hgm;
        }
        finally {}
        p.g(localObject2, "pageMap.map");
        Object localObject2 = ((cig)((LinkedList)localObject2).getLast()).Huy;
        AppMethodBeat.o(196586);
      }
    }
    
    public final void cqK()
    {
      try
      {
        AppMethodBeat.i(196587);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.cpe())
        {
          ae.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", new byte[0]);
        }
        AppMethodBeat.o(196587);
        return;
      }
      finally {}
    }
    
    public final void d(cif paramcif)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196583);
          p.h(paramcif, "statics");
          cih localcih = cqL();
          if (localcih != null) {
            break label181;
          }
          localcih = new cih();
          String str = paramcif.duQ + paramcif.aHQ;
          Object localObject = localcih.Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cig localcig = (cig)((Iterator)localObject).next();
            if (!p.i(str, localcig.key)) {
              continue;
            }
            localcig.Huy = paramcif;
            i = 1;
            if (i == 0)
            {
              localObject = new cig();
              ((cig)localObject).key = str;
              ((cig)localObject).Huy = paramcif;
              localcih.Hgm.add(localObject);
            }
            b(localcih);
            AppMethodBeat.o(196583);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final cif de(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196576);
          if (paramString == null)
          {
            AppMethodBeat.o(196576);
            paramString = null;
            return paramString;
          }
          Object localObject = cqI();
          if (localObject == null)
          {
            AppMethodBeat.o(196576);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((cih)localObject).Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cig localcig = (cig)((Iterator)localObject).next();
            if (!p.i(paramString, localcig.key)) {
              continue;
            }
            paramString = localcig.Huy;
            AppMethodBeat.o(196576);
            continue;
          }
          AppMethodBeat.o(196576);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void df(String paramString, int paramInt)
    {
      cih localcih;
      try
      {
        AppMethodBeat.i(196577);
        if (paramString == null) {
          AppMethodBeat.o(196577);
        }
        for (;;)
        {
          return;
          localcih = cqI();
          if (localcih != null) {
            break;
          }
          AppMethodBeat.o(196577);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localcih.Hgm;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cig localcig = (cig)((Iterator)localObject).next();
        if (p.i(paramString, localcig.key)) {
          localcih.Hgm.remove(localcig);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localcih.Hgm.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", new byte[0]);
            AppMethodBeat.o(196577);
            break;
          }
          a(localcih);
        }
        AppMethodBeat.o(196577);
        break;
      }
    }
    
    public final cif dg(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(196584);
          if (paramString == null)
          {
            AppMethodBeat.o(196584);
            paramString = null;
            return paramString;
          }
          Object localObject = cqL();
          if (localObject == null)
          {
            AppMethodBeat.o(196584);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((cih)localObject).Hgm;
          p.g(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            cig localcig = (cig)((Iterator)localObject).next();
            if (!p.i(paramString, localcig.key)) {
              continue;
            }
            paramString = localcig.Huy;
            AppMethodBeat.o(196584);
            continue;
          }
          AppMethodBeat.o(196584);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dh(String paramString, int paramInt)
    {
      cih localcih;
      try
      {
        AppMethodBeat.i(196585);
        if (paramString == null) {
          AppMethodBeat.o(196585);
        }
        for (;;)
        {
          return;
          localcih = cqL();
          if (localcih != null) {
            break;
          }
          AppMethodBeat.o(196585);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localcih.Hgm;
      p.g(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        cig localcig = (cig)((Iterator)localObject).next();
        if (p.i(paramString, localcig.key)) {
          localcih.Hgm.remove(localcig);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localcih.Hgm.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_3", new byte[0]);
            AppMethodBeat.o(196585);
            break;
          }
          b(localcih);
        }
        AppMethodBeat.o(196585);
        break;
      }
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(196579);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.cpe())
        {
          ae.i("HABBYGE-MALI.PageStatisticsDao", "reset");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.p("hell_pge_sttics_d_1", new byte[0]);
        }
        AppMethodBeat.o(196579);
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