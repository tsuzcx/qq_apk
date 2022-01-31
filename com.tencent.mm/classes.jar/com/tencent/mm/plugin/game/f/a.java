package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.model.e;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, GameRegionPreference.a> nCy;
  public boolean nDX;
  private Map<String, Boolean> nDY;
  
  private a()
  {
    AppMethodBeat.i(112284);
    this.nDX = false;
    this.nDY = new ConcurrentHashMap();
    AppMethodBeat.o(112284);
  }
  
  /* Error */
  public final boolean Qw(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 40
    //   4: invokestatic 24	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_1
    //   8: invokestatic 45	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   11: ifeq +14 -> 25
    //   14: ldc 40
    //   16: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: iconst_0
    //   20: istore_2
    //   21: aload_0
    //   22: monitorexit
    //   23: iload_2
    //   24: ireturn
    //   25: aload_0
    //   26: getfield 31	com/tencent/mm/plugin/game/f/a:nDY	Ljava/util/Map;
    //   29: aload_1
    //   30: invokeinterface 51 2 0
    //   35: ifeq +22 -> 57
    //   38: aload_0
    //   39: getfield 31	com/tencent/mm/plugin/game/f/a:nDY	Ljava/util/Map;
    //   42: aload_1
    //   43: invokeinterface 55 2 0
    //   48: checkcast 57	java/lang/Boolean
    //   51: invokevirtual 61	java/lang/Boolean:booleanValue	()Z
    //   54: ifne +42 -> 96
    //   57: ldc 63
    //   59: ldc 65
    //   61: iconst_1
    //   62: anewarray 4	java/lang/Object
    //   65: dup
    //   66: iconst_0
    //   67: aload_1
    //   68: aastore
    //   69: invokestatic 70	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   72: aload_0
    //   73: getfield 31	com/tencent/mm/plugin/game/f/a:nDY	Ljava/util/Map;
    //   76: aload_1
    //   77: getstatic 74	java/lang/Boolean:TRUE	Ljava/lang/Boolean;
    //   80: invokeinterface 78 3 0
    //   85: pop
    //   86: ldc 40
    //   88: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   91: iconst_1
    //   92: istore_2
    //   93: goto -72 -> 21
    //   96: ldc 40
    //   98: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  public final void Qx(String paramString)
  {
    try
    {
      AppMethodBeat.i(112290);
      if ((!bo.isNullOrNil(paramString)) && (this.nDY.containsKey(paramString)))
      {
        ab.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", new Object[] { paramString });
        this.nDY.remove(paramString);
      }
      AppMethodBeat.o(112290);
      return;
    }
    finally {}
  }
  
  public final Map<String, GameRegionPreference.a> bHA()
  {
    try
    {
      AppMethodBeat.i(112288);
      bHz();
      Map localMap = this.nCy;
      AppMethodBeat.o(112288);
      return localMap;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void bHy()
  {
    try
    {
      AppMethodBeat.i(112286);
      if (this.nCy != null)
      {
        Iterator localIterator = this.nCy.values().iterator();
        while (localIterator.hasNext()) {
          ((GameRegionPreference.a)localIterator.next()).gDG = false;
        }
      }
      AppMethodBeat.o(112286);
    }
    finally {}
  }
  
  public final void bHz()
  {
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      InputStream localInputStream;
      Object localObject7;
      try
      {
        AppMethodBeat.i(112287);
        if (this.nCy == null) {
          this.nCy = new LinkedHashMap();
        }
        if (this.nCy.size() > 0) {
          break label423;
        }
        localObject6 = null;
        localObject1 = null;
      }
      finally {}
      try
      {
        localInputStream = ah.getContext().getAssets().open("game_region_data.txt");
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
        ab.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bo.l(localIOException4) });
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
          ab.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bo.l(localIOException2) });
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
          AppMethodBeat.o(112287);
          throw localObject4;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            ab.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bo.l(localIOException3) });
          }
        }
        locala = new GameRegionPreference.a();
        locala.nCv = localIOException3[0];
        locala.nCw = localIOException3[1];
        locala.nCx = localIOException3[2];
        locala.dqQ = localIOException3[3];
        locala.gDG = false;
        locala.isDefault = false;
        this.nCy.put(locala.dqQ, locala);
        break label437;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject7;
      }
      catch (IOException localIOException1)
      {
        ab.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bo.l(localIOException1) });
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
          ab.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[] { localObject1[i] });
          break label437;
        }
      }
      Object localObject2;
      String str1;
      String str2;
      label273:
      GameRegionPreference.a locala;
      Object localObject5 = e.bFT();
      localObject5 = (GameRegionPreference.a)this.nCy.get(localObject5);
      if (localObject5 != null)
      {
        ((GameRegionPreference.a)localObject5).nCv = e.bFU();
        ((GameRegionPreference.a)localObject5).nCw = e.bFV();
        ((GameRegionPreference.a)localObject5).nCx = e.bFW();
        ((GameRegionPreference.a)localObject5).isDefault = true;
      }
      label423:
      AppMethodBeat.o(112287);
      return;
      label431:
      localObject5 = "";
      break;
      label437:
      i += 1;
    }
  }
  
  public final void clearCache()
  {
    try
    {
      AppMethodBeat.i(112285);
      if (this.nCy != null) {
        this.nCy.clear();
      }
      this.nDX = false;
      AppMethodBeat.o(112285);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.a
 * JD-Core Version:    0.7.0.1
 */