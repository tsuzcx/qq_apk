package com.tencent.mm.plugin.expt.hellhound.ext.b.d;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.eai;
import com.tencent.mm.protocal.protobuf.eaj;
import com.tencent.mm.protocal.protobuf.eak;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao;", "", "()V", "Companion", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
{
  public static final a zJg;
  
  static
  {
    AppMethodBeat.i(300308);
    zJg = new a((byte)0);
    AppMethodBeat.o(300308);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/expt/hellhound/ext/finder/statistics/PageStatisticsDao$Companion;", "", "()V", "MMKV_KEY", "", "MMKV_KEY_WITHOUT_78EVENT", "TAG", "_read", "Lcom/tencent/mm/protocal/protobuf/PageStatisticsMap;", "_readWith78Event", "_write", "", "pageMap", "_writeWith78Event", "getLastStatics", "Lcom/tencent/mm/protocal/protobuf/PageStatistics;", "getLastStaticsWith78Event", "read", "sPageName", "hashCode", "", "readWith78Event", "remove", "removeWith78Event", "reset", "resetWith78Event", "update", "statics", "updateWith78Event", "write", "writeWith78Event", "plugin-expt_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    private static void a(eak parameak)
    {
      AppMethodBeat.i(300293);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_1", parameak.toByteArray());
        AppMethodBeat.o(300293);
        return;
      }
      catch (Exception parameak)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)parameak, s.X("_write, exception: ", parameak.getMessage()), new Object[0]);
        AppMethodBeat.o(300293);
      }
    }
    
    private static void b(eak parameak)
    {
      AppMethodBeat.i(300301);
      try
      {
        com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_3", parameak.toByteArray());
        AppMethodBeat.o(300301);
        return;
      }
      catch (Exception parameak)
      {
        Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)parameak, s.X("_writeWith78Event, exception: ", parameak.getMessage()), new Object[0]);
        AppMethodBeat.o(300301);
      }
    }
    
    private static eak dKY()
    {
      AppMethodBeat.i(300289);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("hell_pge_sttics_d_1");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300289);
        return null;
      }
      eak localeak = new eak();
      try
      {
        localeak.parseFrom(arrayOfByte);
        AppMethodBeat.o(300289);
        return localeak;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, s.X("_read, exception: ", localException.getMessage()), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    private static eak dLb()
    {
      AppMethodBeat.i(300296);
      byte[] arrayOfByte = com.tencent.mm.plugin.expt.hellhound.core.a.b.ard("hell_pge_sttics_d_3");
      if (arrayOfByte != null) {
        if (arrayOfByte.length != 0) {
          break label33;
        }
      }
      label33:
      for (int i = 1; i != 0; i = 0)
      {
        AppMethodBeat.o(300296);
        return null;
      }
      eak localeak = new eak();
      try
      {
        localeak.parseFrom(arrayOfByte);
        AppMethodBeat.o(300296);
        return localeak;
      }
      catch (Exception localException)
      {
        for (;;)
        {
          Log.printErrStackTrace("HABBYGE-MALI.PageStatisticsDao", (Throwable)localException, s.X("_readWith78Event, exception: ", localException.getMessage()), new Object[0]);
          Object localObject = null;
        }
      }
    }
    
    public final void a(eai parameai)
    {
      label161:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300312);
          s.u(parameai, "statics");
          eak localeak = dKY();
          if (localeak != null) {
            break label161;
          }
          localeak = new eak();
          String str = s.X(parameai.hJW, Integer.valueOf(parameai.cHb));
          Object localObject = localeak.aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!s.p(str, ((eaj)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new eaj();
              ((eaj)localObject).key = str;
              ((eaj)localObject).abfB = parameai;
              localeak.aaKV.add(localObject);
              a(localeak);
            }
            AppMethodBeat.o(300312);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void b(eai parameai)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300316);
          s.u(parameai, "statics");
          eak localeak = dKY();
          if (localeak != null) {
            break label171;
          }
          localeak = new eak();
          String str = s.X(parameai.hJW, Integer.valueOf(parameai.cHb));
          Object localObject = localeak.aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            eaj localeaj = (eaj)((Iterator)localObject).next();
            if (!s.p(str, localeaj.key)) {
              continue;
            }
            localeaj.abfB = parameai;
            i = 1;
            if (i == 0)
            {
              localObject = new eaj();
              ((eaj)localObject).key = str;
              ((eaj)localObject).abfB = parameai;
              localeak.aaKV.add(localObject);
            }
            a(localeak);
            AppMethodBeat.o(300316);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void c(eai parameai)
    {
      label161:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300349);
          s.u(parameai, "statics");
          eak localeak = dLb();
          if (localeak != null) {
            break label161;
          }
          localeak = new eak();
          String str = s.X(parameai.hJW, Integer.valueOf(parameai.cHb));
          Object localObject = localeak.aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            if (!s.p(str, ((eaj)((Iterator)localObject).next()).key)) {
              continue;
            }
            i = 1;
            if (i == 0)
            {
              localObject = new eaj();
              ((eaj)localObject).key = str;
              ((eaj)localObject).abfB = parameai;
              localeak.aaKV.add(localObject);
              b(localeak);
            }
            AppMethodBeat.o(300349);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final void d(eai parameai)
    {
      label171:
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300355);
          s.u(parameai, "statics");
          eak localeak = dLb();
          if (localeak != null) {
            break label171;
          }
          localeak = new eak();
          String str = s.X(parameai.hJW, Integer.valueOf(parameai.cHb));
          Object localObject = localeak.aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            eaj localeaj = (eaj)((Iterator)localObject).next();
            if (!s.p(str, localeaj.key)) {
              continue;
            }
            localeaj.abfB = parameai;
            i = 1;
            if (i == 0)
            {
              localObject = new eaj();
              ((eaj)localObject).key = str;
              ((eaj)localObject).abfB = parameai;
              localeak.aaKV.add(localObject);
            }
            b(localeak);
            AppMethodBeat.o(300355);
            return;
          }
        }
        finally {}
        int i = 0;
      }
    }
    
    public final eai dKX()
    {
      eai localeai1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300333);
          eak localeak = dKY();
          if (localeak == null)
          {
            AppMethodBeat.o(300333);
            return localeai1;
          }
          if (localeak.aaKV.isEmpty())
          {
            AppMethodBeat.o(300333);
            continue;
          }
          eai localeai2 = ((eaj)localeak.aaKV.getLast()).abfB;
        }
        finally {}
        AppMethodBeat.o(300333);
      }
    }
    
    public final eai dKZ()
    {
      eai localeai1 = null;
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300376);
          eak localeak = dLb();
          if (localeak == null)
          {
            AppMethodBeat.o(300376);
            return localeai1;
          }
          if (localeak.aaKV.isEmpty())
          {
            AppMethodBeat.o(300376);
            continue;
          }
          eai localeai2 = ((eaj)localeak.aaKV.getLast()).abfB;
        }
        finally {}
        AppMethodBeat.o(300376);
      }
    }
    
    public final void dLa()
    {
      try
      {
        AppMethodBeat.i(300385);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "resetWith78Event");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_3", new byte[0]);
        }
        AppMethodBeat.o(300385);
        return;
      }
      finally {}
    }
    
    public final eai ei(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300324);
          if (paramString == null)
          {
            AppMethodBeat.o(300324);
            paramString = null;
            return paramString;
          }
          Object localObject = dKY();
          if (localObject == null)
          {
            AppMethodBeat.o(300324);
            paramString = null;
            continue;
          }
          paramString = s.X(paramString, Integer.valueOf(paramInt));
          localObject = ((eak)localObject).aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            eaj localeaj = (eaj)((Iterator)localObject).next();
            if (!s.p(paramString, localeaj.key)) {
              continue;
            }
            paramString = localeaj.abfB;
            AppMethodBeat.o(300324);
            continue;
          }
          AppMethodBeat.o(300324);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void ej(String paramString, int paramInt)
    {
      eak localeak;
      try
      {
        AppMethodBeat.i(300328);
        if (paramString == null) {
          AppMethodBeat.o(300328);
        }
        for (;;)
        {
          return;
          localeak = dKY();
          if (localeak != null) {
            break;
          }
          AppMethodBeat.o(300328);
        }
        paramString = s.X(paramString, Integer.valueOf(paramInt));
      }
      finally {}
      Object localObject = localeak.aaKV;
      s.s(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        eaj localeaj = (eaj)((Iterator)localObject).next();
        if (s.p(paramString, localeaj.key)) {
          localeak.aaKV.remove(localeaj);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localeak.aaKV.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_1", new byte[0]);
            AppMethodBeat.o(300328);
            break;
          }
          a(localeak);
        }
        AppMethodBeat.o(300328);
        break;
      }
    }
    
    public final eai ek(String paramString, int paramInt)
    {
      for (;;)
      {
        try
        {
          AppMethodBeat.i(300364);
          if (paramString == null)
          {
            AppMethodBeat.o(300364);
            paramString = null;
            return paramString;
          }
          Object localObject = dLb();
          if (localObject == null)
          {
            AppMethodBeat.o(300364);
            paramString = null;
            continue;
          }
          paramString = s.X(paramString, Integer.valueOf(paramInt));
          localObject = ((eak)localObject).aaKV;
          s.s(localObject, "pageMap.map");
          localObject = ((Iterable)localObject).iterator();
          if (((Iterator)localObject).hasNext())
          {
            eaj localeaj = (eaj)((Iterator)localObject).next();
            if (!s.p(paramString, localeaj.key)) {
              continue;
            }
            paramString = localeaj.abfB;
            AppMethodBeat.o(300364);
            continue;
          }
          AppMethodBeat.o(300364);
        }
        finally {}
        paramString = null;
      }
    }
    
    public final void el(String paramString, int paramInt)
    {
      eak localeak;
      try
      {
        AppMethodBeat.i(300372);
        if (paramString == null) {
          AppMethodBeat.o(300372);
        }
        for (;;)
        {
          return;
          localeak = dLb();
          if (localeak != null) {
            break;
          }
          AppMethodBeat.o(300372);
        }
        paramString = s.X(paramString, Integer.valueOf(paramInt));
      }
      finally {}
      Object localObject = localeak.aaKV;
      s.s(localObject, "pageMap.map");
      localObject = ((Iterable)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        eaj localeaj = (eaj)((Iterator)localObject).next();
        if (s.p(paramString, localeaj.key)) {
          localeak.aaKV.remove(localeaj);
        }
      }
      for (paramInt = 1;; paramInt = 0)
      {
        if (paramInt != 0)
        {
          if (localeak.aaKV.isEmpty())
          {
            com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_3", new byte[0]);
            AppMethodBeat.o(300372);
            break;
          }
          b(localeak);
        }
        AppMethodBeat.o(300372);
        break;
      }
    }
    
    public final void reset()
    {
      try
      {
        AppMethodBeat.i(300341);
        if (com.tencent.mm.plugin.expt.hellhound.core.b.isMMProcess())
        {
          Log.i("HABBYGE-MALI.PageStatisticsDao", "reset");
          com.tencent.mm.plugin.expt.hellhound.core.a.b.u("hell_pge_sttics_d_1", new byte[0]);
        }
        AppMethodBeat.o(300341);
        return;
      }
      finally {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.ext.b.d.f
 * JD-Core Version:    0.7.0.1
 */