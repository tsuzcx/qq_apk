package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bs;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, GameRegionPreference.a> ttR;
  public boolean twa;
  private Map<String, Boolean> twb;
  
  private a()
  {
    AppMethodBeat.i(42483);
    this.twa = false;
    this.twb = new ConcurrentHashMap();
    AppMethodBeat.o(42483);
  }
  
  /* Error */
  public final boolean ahN(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 41
    //   4: invokestatic 25	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 46	com/tencent/mm/sdk/platformtools/bs:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifeq +14 -> 25
    //   14: ldc 41
    //   16: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 32	com/tencent/mm/plugin/game/f/a:twb	Ljava/util/Map;
    //   29: aload_1
    //   30: invokeinterface 52 2 0
    //   35: ifeq +22 -> 57
    //   38: aload_0
    //   39: getfield 32	com/tencent/mm/plugin/game/f/a:twb	Ljava/util/Map;
    //   42: aload_1
    //   43: invokeinterface 56 2 0
    //   48: checkcast 58	java/lang/Boolean
    //   51: invokevirtual 62	java/lang/Boolean:booleanValue	()Z
    //   54: ifne +42 -> 96
    //   57: ldc 64
    //   59: ldc 66
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 71	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 32	com/tencent/mm/plugin/game/f/a:twb	Ljava/util/Map;
    //   76: aload_1
    //   77: getstatic 75	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   80: invokeinterface 79 3 0
    //   85: pop
    //   86: ldc 41
    //   88: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_1
    //   92: istore_2
    //   93: goto -72 -> 21
    //   96: ldc 41
    //   98: invokestatic 35	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void ahO(String paramString)
  {
    try
    {
      AppMethodBeat.i(42489);
      if ((!bs.isNullOrNil(paramString)) && (this.twb.containsKey(paramString)))
      {
        ac.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", new Object[] { paramString });
        this.twb.remove(paramString);
      }
      AppMethodBeat.o(42489);
      return;
    }
    finally {}
  }
  
  public final void cRF()
  {
    try
    {
      AppMethodBeat.i(42485);
      if (this.ttR != null)
      {
        Iterator localIterator = this.ttR.values().iterator();
        while (localIterator.hasNext()) {
          ((GameRegionPreference.a)localIterator.next()).isSelected = false;
        }
      }
      AppMethodBeat.o(42485);
    }
    finally {}
  }
  
  public final void cRG()
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
        if (this.ttR == null) {
          this.ttR = new LinkedHashMap();
        }
        if (this.ttR.size() > 0) {
          break label423;
        }
        localObject6 = null;
        localObject1 = null;
      }
      finally {}
      try
      {
        localInputStream = ai.getContext().getAssets().open("game_region_data.txt");
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
        ac.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bs.m(localIOException4) });
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
          ac.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bs.m(localIOException2) });
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
            ac.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bs.m(localIOException3) });
          }
        }
        locala = new GameRegionPreference.a();
        locala.ttO = localIOException3[0];
        locala.ttP = localIOException3[1];
        locala.ttQ = localIOException3[2];
        locala.eyb = localIOException3[3];
        locala.isSelected = false;
        locala.isDefault = false;
        this.ttR.put(locala.eyb, locala);
        break label437;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject7;
      }
      catch (IOException localIOException1)
      {
        ac.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bs.m(localIOException1) });
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
          ac.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[] { localObject1[i] });
          break label437;
        }
      }
      Object localObject2;
      String str1;
      String str2;
      label273:
      GameRegionPreference.a locala;
      Object localObject5 = e.cPW();
      localObject5 = (GameRegionPreference.a)this.ttR.get(localObject5);
      if (localObject5 != null)
      {
        ((GameRegionPreference.a)localObject5).ttO = e.cPX();
        ((GameRegionPreference.a)localObject5).ttP = e.cPY();
        ((GameRegionPreference.a)localObject5).ttQ = e.cPZ();
        ((GameRegionPreference.a)localObject5).isDefault = true;
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
  
  public final Map<String, GameRegionPreference.a> cRH()
  {
    try
    {
      AppMethodBeat.i(42487);
      cRG();
      Map localMap = this.ttR;
      AppMethodBeat.o(42487);
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void clearCache()
  {
    try
    {
      AppMethodBeat.i(42484);
      if (this.ttR != null) {
        this.ttR.clear();
      }
      this.twa = false;
      AppMethodBeat.o(42484);
      return;
    }
    finally {}
  }
  
  public static final class a
  {
    private static a twc;
    
    static
    {
      AppMethodBeat.i(42482);
      twc = new a((byte)0);
      AppMethodBeat.o(42482);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.a
 * JD-Core Version:    0.7.0.1
 */