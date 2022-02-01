package com.tencent.mm.plugin.expt.edge.a.b;

import android.database.Cursor;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.platformtools.o;
import com.tencent.mm.platformtools.o.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.storage.IAutoDBItem.MAutoDBInfo;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sdk.storage.MAutoStorage;
import com.tencent.mm.storagebase.h.b;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.commons.c.i;

public final class b
  implements c
{
  private static HashMap<Integer, h.b> qkO;
  public static final String[] zyq;
  public static final String[] zyr;
  private int type;
  private o.a zys;
  private a zyt;
  
  static
  {
    AppMethodBeat.i(299685);
    zyq = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.expt.edge.e.a.info, "EdgeComputingCacheDataModel_Instance") };
    zyr = new String[] { MAutoStorage.getCreateSQLs(com.tencent.mm.plugin.expt.edge.e.a.info, "EdgeComputingCacheDataModel_Normal") };
    HashMap localHashMap = new HashMap();
    qkO = localHashMap;
    localHashMap.put(Integer.valueOf("EDGE_NORMAL_CACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.zyr;
      }
    });
    qkO.put(Integer.valueOf("EDGE_INSTANCE_CACHE_TABLE".hashCode()), new h.b()
    {
      public final String[] getSQLs()
      {
        return b.zyq;
      }
    });
    AppMethodBeat.o(299685);
  }
  
  public b(int paramInt)
  {
    this.type = paramInt;
  }
  
  private o.a dIe()
  {
    AppMethodBeat.i(299680);
    Object localObject = null;
    try
    {
      o.a locala = o.a(hashCode(), com.tencent.mm.kernel.h.baE().cachePath + "Edge.db", qkO, true);
      localObject = locala;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("EdgeComputingCacheStrategyWCDB", "[EdgeComputingCacheStrategyWCDB] createDataBase throw Exception : " + localException.getMessage());
      }
    }
    AppMethodBeat.o(299680);
    return localObject;
  }
  
  public final List<com.tencent.mm.plugin.expt.edge.e.a> SV(String paramString)
  {
    AppMethodBeat.i(299740);
    if ((i.hm(paramString)) || (this.zyt == null))
    {
      AppMethodBeat.o(299740);
      return null;
    }
    paramString = this.zyt.aql(paramString);
    AppMethodBeat.o(299740);
    return paramString;
  }
  
  public final void a(com.tencent.mm.plugin.expt.edge.e.a parama)
  {
    long l = -1L;
    AppMethodBeat.i(299708);
    if ((parama == null) || (this.zyt == null))
    {
      AppMethodBeat.o(299708);
      return;
    }
    a locala = this.zyt;
    com.tencent.mm.storagebase.h localh;
    if (parama != null)
    {
      if (!(locala.qFJ instanceof com.tencent.mm.storagebase.h)) {
        break label211;
      }
      localh = (com.tencent.mm.storagebase.h)locala.qFJ;
      l = localh.beginTransaction(-1L);
    }
    for (;;)
    {
      try
      {
        parama.field_configID = parama.zzS;
        parama.field_reportTimeEC = parama.zzT;
        parama.field_data = parama.data;
        if (!locala.insertNotify(parama, false)) {
          Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] saveCache fail, configID : " + parama.zzS);
        }
        return;
      }
      catch (Exception parama)
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] saveCache throw Exception : " + parama.getMessage());
        return;
      }
      finally
      {
        if (localh != null) {
          localh.endTransaction(l);
        }
        AppMethodBeat.o(299708);
      }
      AppMethodBeat.o(299708);
      return;
      label211:
      localh = null;
    }
  }
  
  public final void clear()
  {
    long l = -1L;
    AppMethodBeat.i(299724);
    if (this.zyt == null)
    {
      AppMethodBeat.o(299724);
      return;
    }
    a locala = this.zyt;
    com.tencent.mm.storagebase.h localh;
    if ((locala.qFJ instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)locala.qFJ;
      l = localh.beginTransaction(-1L);
    }
    for (;;)
    {
      try
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] clearCaches ret : ".concat(String.valueOf(locala.qFJ.delete(locala.zyu, null, null))));
        return;
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] clearCaches throw Exception : " + localException.getMessage());
        return;
      }
      finally
      {
        if (localh != null) {
          localh.endTransaction(l);
        }
        AppMethodBeat.o(299724);
      }
      AppMethodBeat.o(299724);
      return;
      localh = null;
    }
  }
  
  public final void close()
  {
    AppMethodBeat.i(299699);
    this.zyt = null;
    if (this.zys != null) {
      this.zys.yb(hashCode());
    }
    this.zys = null;
    AppMethodBeat.o(299699);
  }
  
  public final long count()
  {
    AppMethodBeat.i(299746);
    if (this.zyt == null)
    {
      AppMethodBeat.o(299746);
      return 0L;
    }
    long l = this.zyt.dIf();
    AppMethodBeat.o(299746);
    return l;
  }
  
  public final void dId()
  {
    AppMethodBeat.i(299756);
    a locala;
    for (;;)
    {
      try
      {
        MultiProcessMMKV localMultiProcessMMKV = com.tencent.mm.plugin.expt.edge.b.dHW();
        if ((localMultiProcessMMKV == null) || (localMultiProcessMMKV.getBoolean("isMigrateCache_" + this.type, false))) {
          break label244;
        }
        Object localObject1 = com.tencent.mm.plugin.expt.edge.config.b.dIg().dIh();
        if ((localObject1 == null) || (((List)localObject1).size() <= 0)) {
          break label244;
        }
        locala = new a(this.type);
        localObject1 = ((List)localObject1).iterator();
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        com.tencent.mm.plugin.expt.edge.e.a.b localb = (com.tencent.mm.plugin.expt.edge.e.a.b)((Iterator)localObject1).next();
        Object localObject2 = locala.SV(localb.zzS);
        if ((localObject2 != null) && (((List)localObject2).size() > 0))
        {
          localObject2 = ((List)localObject2).iterator();
          if (((Iterator)localObject2).hasNext()) {
            a((com.tencent.mm.plugin.expt.edge.e.a)((Iterator)localObject2).next());
          } else {
            locala.remove(localb.zzS);
          }
        }
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingCacheStrategyWCDB", "[EdgeComputingCacheStrategyWCDB] migrate type : %d, throw Exception : %s", new Object[] { Integer.valueOf(this.type), localException.getMessage() });
        AppMethodBeat.o(299756);
        return;
      }
    }
    locala.clear();
    localException.putBoolean("isMigrateCache_" + this.type, true);
    label244:
    AppMethodBeat.o(299756);
  }
  
  public final void lS(long paramLong)
  {
    long l = -1L;
    AppMethodBeat.i(299732);
    if (this.zyt == null)
    {
      AppMethodBeat.o(299732);
      return;
    }
    a locala = this.zyt;
    com.tencent.mm.storagebase.h localh;
    if ((locala.qFJ instanceof com.tencent.mm.storagebase.h))
    {
      localh = (com.tencent.mm.storagebase.h)locala.qFJ;
      l = localh.beginTransaction(-1L);
    }
    for (;;)
    {
      try
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] removeExpireCaches ret : ".concat(String.valueOf(locala.qFJ.delete(locala.zyu, "reportTimeEC<?", new String[] { String.valueOf(paramLong) }))));
        return;
      }
      catch (Exception localException)
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] removeExpireCaches throw Exception : " + localException.getMessage());
        return;
      }
      finally
      {
        if (localh != null) {
          localh.endTransaction(l);
        }
        AppMethodBeat.o(299732);
      }
      AppMethodBeat.o(299732);
      return;
      localh = null;
    }
  }
  
  public final void remove(String paramString)
  {
    long l = -1L;
    AppMethodBeat.i(299718);
    if ((i.hm(paramString)) || (this.zyt == null))
    {
      AppMethodBeat.o(299718);
      return;
    }
    a locala = this.zyt;
    com.tencent.mm.storagebase.h localh;
    if (!i.hm(paramString))
    {
      if (!(locala.qFJ instanceof com.tencent.mm.storagebase.h)) {
        break label206;
      }
      localh = (com.tencent.mm.storagebase.h)locala.qFJ;
      l = localh.beginTransaction(-1L);
    }
    for (;;)
    {
      try
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] removeCaches ret : ".concat(String.valueOf(locala.qFJ.delete(locala.zyu, "configID=?", new String[] { paramString }))));
        return;
      }
      catch (Exception paramString)
      {
        Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] removeCaches throw Exception : " + paramString.getMessage());
        return;
      }
      finally
      {
        if (localh != null) {
          localh.endTransaction(l);
        }
        AppMethodBeat.o(299718);
      }
      AppMethodBeat.o(299718);
      return;
      label206:
      localh = null;
    }
  }
  
  public final void reset()
  {
    String str = null;
    AppMethodBeat.i(299692);
    this.zyt = null;
    if (this.zys != null) {
      this.zys.yb(hashCode());
    }
    this.zys = null;
    o.a locala = dIe();
    if (locala == null)
    {
      Log.e("EdgeComputingCacheStrategyWCDB", "[EdgeComputingCacheStrategyWCDB] reset dataDB is null");
      AppMethodBeat.o(299692);
      return;
    }
    this.zys = locala;
    locala = this.zys;
    int i = this.type;
    if (i == 2) {
      str = "EdgeComputingCacheDataModel_Instance";
    }
    for (;;)
    {
      this.zyt = new a(locala, str, new String[0]);
      AppMethodBeat.o(299692);
      return;
      if (i == 1) {
        str = "EdgeComputingCacheDataModel_Normal";
      }
    }
  }
  
  final class a
    extends MAutoStorage<com.tencent.mm.plugin.expt.edge.e.a>
  {
    ISQLiteDatabase qFJ;
    String zyu;
    
    public a(ISQLiteDatabase paramISQLiteDatabase, String paramString, String[] paramArrayOfString)
    {
      super(com.tencent.mm.plugin.expt.edge.e.a.info, paramString, paramArrayOfString);
      this.qFJ = paramISQLiteDatabase;
      this.zyu = paramString;
    }
    
    public final List<com.tencent.mm.plugin.expt.edge.e.a> aql(String paramString)
    {
      Object localObject4 = null;
      com.tencent.mm.plugin.expt.edge.e.a locala = null;
      AppMethodBeat.i(299701);
      if (i.hm(paramString))
      {
        AppMethodBeat.o(299701);
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      Object localObject2 = locala;
      Object localObject1 = localObject4;
      for (;;)
      {
        try
        {
          if (com.tencent.mm.plugin.expt.edge.a.dHT().zyf == null) {
            break label521;
          }
          localObject2 = locala;
          localObject1 = localObject4;
          i = com.tencent.mm.plugin.expt.edge.config.c.a.dIq();
          localObject2 = locala;
          localObject1 = localObject4;
          l1 = System.currentTimeMillis();
          localObject2 = locala;
          localObject1 = localObject4;
          long l2 = com.tencent.mm.plugin.expt.edge.config.c.a.dIr();
          l1 -= l2 * 86400000L;
          localObject2 = locala;
          localObject1 = localObject4;
          ISQLiteDatabase localISQLiteDatabase = this.qFJ;
          localObject2 = locala;
          localObject1 = localObject4;
          String str = this.zyu;
          localObject2 = locala;
          localObject1 = localObject4;
          String[] arrayOfString = com.tencent.mm.plugin.expt.edge.e.a.info.columns;
          localObject2 = locala;
          localObject1 = localObject4;
          StringBuilder localStringBuilder = new StringBuilder("reportTimeEC");
          if (i <= 0) {
            continue;
          }
          localObject2 = locala;
          localObject1 = localObject4;
          localObject3 = " limit ".concat(String.valueOf(i));
          localObject2 = locala;
          localObject1 = localObject4;
          localObject3 = (String)localObject3;
          localObject2 = locala;
          localObject1 = localObject4;
          localObject3 = localISQLiteDatabase.query(str, arrayOfString, "configID = ? and reportTimeEC >= ? ", new String[] { paramString, String.valueOf(l1) }, null, null, (String)localObject3);
          if (localObject3 != null)
          {
            localObject2 = localObject3;
            localObject1 = localObject3;
            if (((Cursor)localObject3).moveToFirst())
            {
              localObject2 = localObject3;
              localObject1 = localObject3;
              locala = new com.tencent.mm.plugin.expt.edge.e.a();
              localObject2 = localObject3;
              localObject1 = localObject3;
              locala.convertFrom((Cursor)localObject3);
              localObject2 = localObject3;
              localObject1 = localObject3;
              locala.zzS = locala.field_configID;
              localObject2 = localObject3;
              localObject1 = localObject3;
              locala.zzT = locala.field_reportTimeEC;
              localObject2 = localObject3;
              localObject1 = localObject3;
              locala.data = locala.field_data;
              localObject2 = localObject3;
              localObject1 = localObject3;
              localArrayList.add(locala);
              localObject2 = localObject3;
              localObject1 = localObject3;
              if (((Cursor)localObject3).moveToNext()) {
                continue;
              }
            }
          }
          localObject2 = localObject3;
          localObject1 = localObject3;
          if (localArrayList.size() >= i)
          {
            localObject2 = localObject3;
            localObject1 = localObject3;
            com.tencent.mm.plugin.expt.edge.f.a.an(paramString, localArrayList.size());
          }
          if (localObject3 != null) {
            ((Cursor)localObject3).close();
          }
        }
        catch (Exception paramString)
        {
          Object localObject3;
          localObject1 = localObject2;
          Log.e("EdgeComputingCacheWCDBDao", "[EdgeComputingCacheWCDBDao] queryCaches throw Exception : " + paramString.getMessage());
          if (localObject2 == null) {
            continue;
          }
          ((Cursor)localObject2).close();
          continue;
        }
        finally
        {
          if (localObject1 == null) {
            continue;
          }
          localObject1.close();
          AppMethodBeat.o(299701);
        }
        AppMethodBeat.o(299701);
        return localArrayList;
        localObject3 = "";
        continue;
        label521:
        int i = 0;
        long l1 = 0L;
      }
    }
    
    /* Error */
    public final long dIf()
    {
      // Byte code:
      //   0: ldc 198
      //   2: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
      //   5: aload_0
      //   6: getfield 29	com/tencent/mm/plugin/expt/edge/a/b/b$a:qFJ	Lcom/tencent/mm/sdk/storage/ISQLiteDatabase;
      //   9: aload_0
      //   10: getfield 31	com/tencent/mm/plugin/expt/edge/a/b/b$a:zyu	Ljava/lang/String;
      //   13: aconst_null
      //   14: aconst_null
      //   15: aconst_null
      //   16: aconst_null
      //   17: aconst_null
      //   18: aconst_null
      //   19: invokeinterface 128 8 0
      //   24: astore 6
      //   26: aload 6
      //   28: ifnull +127 -> 155
      //   31: aload 6
      //   33: astore 5
      //   35: aload 6
      //   37: invokeinterface 201 1 0
      //   42: istore_1
      //   43: iload_1
      //   44: istore_2
      //   45: aload 6
      //   47: ifnull +12 -> 59
      //   50: aload 6
      //   52: invokeinterface 179 1 0
      //   57: iload_1
      //   58: istore_2
      //   59: iload_2
      //   60: i2l
      //   61: lstore_3
      //   62: ldc 198
      //   64: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   67: lload_3
      //   68: lreturn
      //   69: astore 7
      //   71: aconst_null
      //   72: astore 6
      //   74: aload 6
      //   76: astore 5
      //   78: ldc 183
      //   80: new 92	java/lang/StringBuilder
      //   83: dup
      //   84: ldc 203
      //   86: invokespecial 97	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
      //   89: aload 7
      //   91: invokevirtual 188	java/lang/Exception:getMessage	()Ljava/lang/String;
      //   94: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   97: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   100: invokestatic 194	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
      //   103: aload 6
      //   105: ifnull +10 -> 115
      //   108: aload 6
      //   110: invokeinterface 179 1 0
      //   115: iconst_0
      //   116: istore_2
      //   117: goto -58 -> 59
      //   120: astore 6
      //   122: aconst_null
      //   123: astore 5
      //   125: aload 5
      //   127: ifnull +10 -> 137
      //   130: aload 5
      //   132: invokeinterface 179 1 0
      //   137: ldc 198
      //   139: invokestatic 52	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
      //   142: aload 6
      //   144: athrow
      //   145: astore 6
      //   147: goto -22 -> 125
      //   150: astore 7
      //   152: goto -78 -> 74
      //   155: iconst_0
      //   156: istore_1
      //   157: goto -114 -> 43
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	160	0	this	a
      //   42	115	1	i	int
      //   44	73	2	j	int
      //   61	7	3	l	long
      //   33	98	5	localCursor1	Cursor
      //   24	85	6	localCursor2	Cursor
      //   120	23	6	localObject1	Object
      //   145	1	6	localObject2	Object
      //   69	21	7	localException1	Exception
      //   150	1	7	localException2	Exception
      // Exception table:
      //   from	to	target	type
      //   5	26	69	java/lang/Exception
      //   5	26	120	finally
      //   35	43	145	finally
      //   78	103	145	finally
      //   35	43	150	java/lang/Exception
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.edge.a.b.b
 * JD-Core Version:    0.7.0.1
 */