package com.tencent.mm.plugin.game.d;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, GameRegionPreference.a> IUi;
  public boolean IXT;
  public b IXU;
  private Map<String, Boolean> IXV;
  
  private a()
  {
    AppMethodBeat.i(42483);
    this.IXT = false;
    this.IXU = new b();
    this.IXV = new ConcurrentHashMap();
    AppMethodBeat.o(42483);
  }
  
  /* Error */
  public final boolean aHh(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 49
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 54	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifeq +14 -> 25
    //   14: ldc 49
    //   16: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 40	com/tencent/mm/plugin/game/d/a:IXV	Ljava/util/Map;
    //   29: aload_1
    //   30: invokeinterface 60 2 0
    //   35: ifeq +22 -> 57
    //   38: aload_0
    //   39: getfield 40	com/tencent/mm/plugin/game/d/a:IXV	Ljava/util/Map;
    //   42: aload_1
    //   43: invokeinterface 64 2 0
    //   48: checkcast 66	java/lang/Boolean
    //   51: invokevirtual 70	java/lang/Boolean:booleanValue	()Z
    //   54: ifne +42 -> 96
    //   57: ldc 72
    //   59: ldc 74
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 79	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 40	com/tencent/mm/plugin/game/d/a:IXV	Ljava/util/Map;
    //   76: aload_1
    //   77: getstatic 83	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   80: invokeinterface 87 3 0
    //   85: pop
    //   86: ldc 49
    //   88: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_1
    //   92: istore_2
    //   93: goto -72 -> 21
    //   96: ldc 49
    //   98: invokestatic 43	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   101: iconst_0
    //   102: istore_2
    //   103: goto -82 -> 21
    //   106: astore_1
    //   107: aload_0
    //   108: monitorexit
    //   109: aload_1
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	a
    //   0	111	1	paramString	String
    //   20	83	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	19	106	finally
    //   25	57	106	finally
    //   57	91	106	finally
    //   96	101	106	finally
  }
  
  public final void aHi(String paramString)
  {
    try
    {
      AppMethodBeat.i(42489);
      if ((!Util.isNullOrNil(paramString)) && (this.IXV.containsKey(paramString)))
      {
        Log.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", new Object[] { paramString });
        this.IXV.remove(paramString);
      }
      AppMethodBeat.o(42489);
      return;
    }
    finally {}
  }
  
  public final void clearCache()
  {
    try
    {
      AppMethodBeat.i(42484);
      if (this.IUi != null) {
        this.IUi.clear();
      }
      this.IXT = false;
      AppMethodBeat.o(42484);
      return;
    }
    finally {}
  }
  
  public final void fHU()
  {
    try
    {
      AppMethodBeat.i(42485);
      if (this.IUi != null)
      {
        Iterator localIterator = this.IUi.values().iterator();
        while (localIterator.hasNext()) {
          ((GameRegionPreference.a)localIterator.next()).isSelected = false;
        }
      }
      AppMethodBeat.o(42485);
    }
    finally {}
  }
  
  public final void fHV()
  {
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      InputStream localInputStream;
      Object localObject7;
      try
      {
        AppMethodBeat.i(42486);
        if (this.IUi == null) {
          this.IUi = new LinkedHashMap();
        }
        if (this.IUi.size() > 0) {
          break label423;
        }
        localObject6 = null;
        localObject1 = null;
      }
      finally {}
      try
      {
        localInputStream = MMApplicationContext.getContext().getAssets().open("game_region_data.txt");
        localObject1 = localInputStream;
        localObject6 = localInputStream;
        localObject7 = new byte[localInputStream.available()];
        localObject1 = localInputStream;
        localObject6 = localInputStream;
        localInputStream.read((byte[])localObject7);
        localObject1 = localInputStream;
        localObject6 = localInputStream;
        localObject7 = new String((byte[])localObject7);
        localObject1 = localObject7;
        if (localInputStream == null) {}
      }
      catch (IOException localIOException4)
      {
        localObject6 = localObject3;
        Log.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException4) });
        if (localObject3 == null) {
          break label431;
        }
        try
        {
          localObject3.close();
          str1 = "";
        }
        catch (IOException localIOException2)
        {
          Log.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException2) });
          str2 = "";
        }
        continue;
      }
      finally
      {
        if (localObject6 == null) {
          break label273;
        }
        try
        {
          ((InputStream)localObject6).close();
          AppMethodBeat.o(42486);
          throw localObject4;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            Log.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException3) });
          }
        }
        locala = new GameRegionPreference.a();
        locala.IUf = localIOException3[0];
        locala.IUg = localIOException3[1];
        locala.IUh = localIOException3[2];
        locala.kaj = localIOException3[3];
        locala.isSelected = false;
        locala.oBZ = false;
        this.IUi.put(locala.kaj, locala);
        break label437;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject7;
      }
      catch (IOException localIOException1)
      {
        Log.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { Util.stackTraceToString(localIOException1) });
        localObject2 = localObject7;
      }
    }
    localObject1 = ((String)localObject1).trim().split("\n|\r\n|\r");
    int i = 0;
    for (;;)
    {
      if (i < localObject1.length)
      {
        localObject6 = localObject1[i].trim().split("\\|");
        if (localObject6.length < 4)
        {
          Log.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[] { localObject1[i] });
          break label437;
        }
      }
      Object localObject2;
      String str1;
      String str2;
      label273:
      GameRegionPreference.a locala;
      Object localObject5 = e.fFV();
      localObject5 = (GameRegionPreference.a)this.IUi.get(localObject5);
      if (localObject5 != null)
      {
        ((GameRegionPreference.a)localObject5).IUf = e.fFW();
        ((GameRegionPreference.a)localObject5).IUg = e.fFX();
        ((GameRegionPreference.a)localObject5).IUh = e.fFY();
        ((GameRegionPreference.a)localObject5).oBZ = true;
      }
      label423:
      AppMethodBeat.o(42486);
      return;
      label431:
      localObject5 = "";
      break;
      label437:
      i += 1;
    }
  }
  
  public final Map<String, GameRegionPreference.a> fHW()
  {
    try
    {
      AppMethodBeat.i(42487);
      fHV();
      Map localMap = this.IUi;
      AppMethodBeat.o(42487);
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static final class a
  {
    private static a IXW;
    
    static
    {
      AppMethodBeat.i(42482);
      IXW = new a((byte)0);
      AppMethodBeat.o(42482);
    }
  }
  
  public static final class b
  {
    public long IXX;
    public long endTimeMs;
    public long startTimeMs;
    public long zIy;
    
    public final void fHY()
    {
      this.startTimeMs = 0L;
      this.endTimeMs = 0L;
      this.zIy = 0L;
      this.IXX = 0L;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.game.d.a
 * JD-Core Version:    0.7.0.1
 */