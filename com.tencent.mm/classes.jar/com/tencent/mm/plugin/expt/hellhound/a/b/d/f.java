package com.tencent.mm.plugin.expt.hellhound.a.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dhy;
import com.tencent.mm.protocal.protobuf.dhz;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"})
public final class f
{
  public static final a wnd;
  
  static
  {
    AppMethodBeat.i(252332);
    wnd = new a((byte)0);
    AppMethodBeat.o(252332);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"})
  public static final class a
  {
    private static void a(dia paramdia)
    {
      AppMethodBeat.i(255145);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_1", paramdia.toByteArray());
        AppMethodBeat.o(255145);
        return;
      }
      catch (Exception paramdia)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramdia, "_write, exception: " + paramdia.getMessage(), new Object[0]);
        AppMethodBeat.o(255145);
      }
    }
    
    private static void b(dia paramdia)
    {
      AppMethodBeat.i(255160);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_3", paramdia.toByteArray());
        AppMethodBeat.o(255160);
        return;
      }
      catch (Exception paramdia)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)paramdia, "_writeWith78Event, exception: " + paramdia.getMessage(), new Object[0]);
        AppMethodBeat.o(255160);
      }
    }
    
    private static dia dej()
    {
      AppMethodBeat.i(255144);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("hell_pge_sttics_d_1");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(255144);
        return null;
      }
      dia localdia = new dia();
      try
      {
        localdia.parseFrom(arrayOfByte);
        AppMethodBeat.o(255144);
        return localdia;
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
    
    private static dia dem()
    {
      AppMethodBeat.i(255158);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.awZ("hell_pge_sttics_d_3");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(255158);
        return null;
      }
      dia localdia = new dia();
      try
      {
        localdia.parseFrom(arrayOfByte);
        AppMethodBeat.o(255158);
        return localdia;
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
    
    public final void a(dhy paramdhy)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255129);
          p.k(paramdhy, "statics");
          dia localdia = dej();
          if (localdia != null) {
            break label171;
          }
          localdia = new dia();
          String str = paramdhy.fFe + paramdhy.aNf;
          Object localObject = localdia.Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.h(str, ((dhz)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new dhz();
              ((dhz)localObject).key = str;
              ((dhz)localObject).TPf = paramdhy;
              localdia.Two.add(localObject);
              a(localdia);
            }
            AppMethodBeat.o(255129);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void b(dhy paramdhy)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255131);
          p.k(paramdhy, "statics");
          dia localdia = dej();
          if (localdia != null) {
            break label181;
          }
          localdia = new dia();
          String str = paramdhy.fFe + paramdhy.aNf;
          Object localObject = localdia.Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            dhz localdhz = (dhz)((Iterator)localObject).next();
            if (!p.h(str, localdhz.key)) {
              continue;
            }
            localdhz.TPf = paramdhy;
            i = 1;
            if (i == 0)
            {
              localObject = new dhz();
              ((dhz)localObject).key = str;
              ((dhz)localObject).TPf = paramdhy;
              localdia.Two.add(localObject);
            }
            a(localdia);
            AppMethodBeat.o(255131);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void c(dhy paramdhy)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255146);
          p.k(paramdhy, "statics");
          dia localdia = dem();
          if (localdia != null) {
            break label171;
          }
          localdia = new dia();
          String str = paramdhy.fFe + paramdhy.aNf;
          Object localObject = localdia.Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!p.h(str, ((dhz)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new dhz();
              ((dhz)localObject).key = str;
              ((dhz)localObject).TPf = paramdhy;
              localdia.Two.add(localObject);
              b(localdia);
            }
            AppMethodBeat.o(255146);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void d(dhy paramdhy)
    {
      label181:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255149);
          p.k(paramdhy, "statics");
          dia localdia = dem();
          if (localdia != null) {
            break label181;
          }
          localdia = new dia();
          String str = paramdhy.fFe + paramdhy.aNf;
          Object localObject = localdia.Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            dhz localdhz = (dhz)((Iterator)localObject).next();
            if (!p.h(str, localdhz.key)) {
              continue;
            }
            localdhz.TPf = paramdhy;
            i = 1;
            if (i == 0)
            {
              localObject = new dhz();
              ((dhz)localObject).key = str;
              ((dhz)localObject).TPf = paramdhy;
              localdia.Two.add(localObject);
            }
            b(localdia);
            AppMethodBeat.o(255149);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final dhy dF(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255134);
          if (paramString == null)
          {
            AppMethodBeat.o(255134);
            paramString = null;
            return paramString;
          }
          Object localObject = dej();
          if (localObject == null)
          {
            AppMethodBeat.o(255134);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((dia)localObject).Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            dhz localdhz = (dhz)((Iterator)localObject).next();
            if (!p.h(paramString, localdhz.key)) {
              continue;
            }
            paramString = localdhz.TPf;
            AppMethodBeat.o(255134);
            continue;
          }
          AppMethodBeat.o(255134);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dG(String paramString, int paramInt)
    {
      dia localdia;
      try
      {
        AppMethodBeat.i(255137);
        if (paramString == null) {
          AppMethodBeat.o(255137);
        }
        for (;;)
        {
          return;
          localdia = dej();
          if (localdia != null) {
            break;
          }
          AppMethodBeat.o(255137);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localdia.Two;
      p.j(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dhz localdhz = (dhz)((Iterator)localObject).next();
        if (p.h(paramString, localdhz.key)) {
          localdia.Two.remove(localdhz);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localdia.Two.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_1", new byte[0]);
            AppMethodBeat.o(255137);
            break;
          }
          a(localdia);
        }
        AppMethodBeat.o(255137);
        break;
      }
    }
    
    public final dhy dH(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255151);
          if (paramString == null)
          {
            AppMethodBeat.o(255151);
            paramString = null;
            return paramString;
          }
          Object localObject = dem();
          if (localObject == null)
          {
            AppMethodBeat.o(255151);
            paramString = null;
            continue;
          }
          paramString = paramString + String.valueOf(paramInt);
          localObject = ((dia)localObject).Two;
          p.j(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            dhz localdhz = (dhz)((Iterator)localObject).next();
            if (!p.h(paramString, localdhz.key)) {
              continue;
            }
            paramString = localdhz.TPf;
            AppMethodBeat.o(255151);
            continue;
          }
          AppMethodBeat.o(255151);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void dI(String paramString, int paramInt)
    {
      dia localdia;
      try
      {
        AppMethodBeat.i(255153);
        if (paramString == null) {
          AppMethodBeat.o(255153);
        }
        for (;;)
        {
          return;
          localdia = dem();
          if (localdia != null) {
            break;
          }
          AppMethodBeat.o(255153);
        }
        paramString = paramString + paramInt;
      }
      finally {}
      Object localObject = localdia.Two;
      p.j(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        dhz localdhz = (dhz)((Iterator)localObject).next();
        if (p.h(paramString, localdhz.key)) {
          localdia.Two.remove(localdhz);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localdia.Two.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_3", new byte[0]);
            AppMethodBeat.o(255153);
            break;
          }
          b(localdia);
        }
        AppMethodBeat.o(255153);
        break;
      }
    }
    
    public final dhy dei()
    {
      dhy localdhy = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255140);
          dia localdia = dej();
          if (localdia == null)
          {
            AppMethodBeat.o(255140);
            return localdhy;
          }
          if (localdia.Two.isEmpty())
          {
            AppMethodBeat.o(255140);
            continue;
          }
          localObject2 = localdia.Two;
        }
        finally {}
        p.j(localObject2, "pageMap.map");
        Object localObject2 = ((dhz)((LinkedList)localObject2).getLast()).TPf;
        AppMethodBeat.o(255140);
      }
    }
    
    public final dhy dek()
    {
      dhy localdhy = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(255154);
          dia localdia = dem();
          if (localdia == null)
          {
            AppMethodBeat.o(255154);
            return localdhy;
          }
          if (localdia.Two.isEmpty())
          {
            AppMethodBeat.o(255154);
            continue;
          }
          localObject2 = localdia.Two;
        }
        finally {}
        p.j(localObject2, "pageMap.map");
        Object localObject2 = ((dhz)((LinkedList)localObject2).getLast()).TPf;
        AppMethodBeat.o(255154);
      }
    }
    
    public final void del()
    {
      try
      {
        AppMethodBeat.i(255156);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_3", new byte[0]);
        }
        AppMethodBeat.o(255156);
        return;
      }
      finally {}
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(255143);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "reset");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.r("hell_pge_sttics_d_1", new byte[0]);
        }
        AppMethodBeat.o(255143);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.b.d.f
 * JD-Core Version:    0.7.0.1
 */