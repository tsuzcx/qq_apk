package com.tencent.mm.plugin.game.f;

import android.content.Context;
import android.content.res.AssetManager;
import com.tencent.mm.plugin.game.model.f;
import com.tencent.mm.plugin.game.ui.GameRegionPreference.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class a
{
  private Map<String, GameRegionPreference.a> leD;
  public boolean lgc = false;
  private Map<String, Boolean> lgd = new ConcurrentHashMap();
  
  /* Error */
  public final boolean Fc(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: invokestatic 34	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   6: istore_2
    //   7: iload_2
    //   8: ifeq +9 -> 17
    //   11: iconst_0
    //   12: istore_2
    //   13: aload_0
    //   14: monitorexit
    //   15: iload_2
    //   16: ireturn
    //   17: aload_0
    //   18: getfield 24	com/tencent/mm/plugin/game/f/a:lgd	Ljava/util/Map;
    //   21: aload_1
    //   22: invokeinterface 40 2 0
    //   27: ifeq +22 -> 49
    //   30: aload_0
    //   31: getfield 24	com/tencent/mm/plugin/game/f/a:lgd	Ljava/util/Map;
    //   34: aload_1
    //   35: invokeinterface 44 2 0
    //   40: checkcast 46	java/lang/Boolean
    //   43: invokevirtual 50	java/lang/Boolean:booleanValue	()Z
    //   46: ifne +38 -> 84
    //   49: ldc 52
    //   51: ldc 54
    //   53: iconst_1
    //   54: anewarray 4	java/lang/Object
    //   57: dup
    //   58: iconst_0
    //   59: aload_1
    //   60: aastore
    //   61: invokestatic 60	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   64: aload_0
    //   65: getfield 24	com/tencent/mm/plugin/game/f/a:lgd	Ljava/util/Map;
    //   68: aload_1
    //   69: iconst_1
    //   70: invokestatic 64	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   73: invokeinterface 68 3 0
    //   78: pop
    //   79: iconst_1
    //   80: istore_2
    //   81: goto -68 -> 13
    //   84: iconst_0
    //   85: istore_2
    //   86: goto -73 -> 13
    //   89: astore_1
    //   90: aload_0
    //   91: monitorexit
    //   92: aload_1
    //   93: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	94	0	this	a
    //   0	94	1	paramString	String
    //   6	80	2	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   2	7	89	finally
    //   17	49	89	finally
    //   49	79	89	finally
  }
  
  public final void Fd(String paramString)
  {
    try
    {
      if ((!bk.bl(paramString)) && (this.lgd.containsKey(paramString)))
      {
        y.i("MicroMsg.GameCacheUtil", "download entrance image finish : %s", new Object[] { paramString });
        this.lgd.remove(paramString);
      }
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final void bar()
  {
    try
    {
      if (this.leD != null)
      {
        Iterator localIterator = this.leD.values().iterator();
        while (localIterator.hasNext()) {
          ((GameRegionPreference.a)localIterator.next()).fmm = false;
        }
      }
    }
    finally {}
  }
  
  public final void bas()
  {
    Object localObject6;
    for (;;)
    {
      Object localObject1;
      InputStream localInputStream;
      Object localObject7;
      try
      {
        if (this.leD == null) {
          this.leD = new LinkedHashMap();
        }
        if (this.leD.size() > 0) {
          break label413;
        }
        localObject6 = null;
        localObject1 = null;
      }
      finally {}
      try
      {
        localInputStream = ae.getContext().getAssets().open("game_region_data.txt");
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
        y.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bk.j(localIOException4) });
        if (localObject3 == null) {
          break label416;
        }
        try
        {
          localObject3.close();
          str1 = "";
        }
        catch (IOException localIOException2)
        {
          y.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bk.j(localIOException2) });
          str2 = "";
        }
        continue;
      }
      finally
      {
        if (localObject6 == null) {
          break label268;
        }
        try
        {
          ((InputStream)localObject6).close();
          throw localObject4;
        }
        catch (IOException localIOException3)
        {
          for (;;)
          {
            y.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bk.j(localIOException3) });
          }
        }
        locala = new GameRegionPreference.a();
        locala.leA = localIOException3[0];
        locala.leB = localIOException3[1];
        locala.leC = localIOException3[2];
        locala.cCG = localIOException3[3];
        locala.fmm = false;
        locala.isDefault = false;
        this.leD.put(locala.cCG, locala);
        break label422;
      }
      try
      {
        localInputStream.close();
        localObject1 = localObject7;
      }
      catch (IOException localIOException1)
      {
        y.e("MicroMsg.GameCacheUtil", "exception:%s", new Object[] { bk.j(localIOException1) });
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
          y.e("MicroMsg.GameCacheUtil", "this GameRegion item has problem %s", new Object[] { localObject1[i] });
          break label422;
        }
      }
      Object localObject2;
      String str1;
      String str2;
      label268:
      GameRegionPreference.a locala;
      Object localObject5 = f.aYU();
      localObject5 = (GameRegionPreference.a)this.leD.get(localObject5);
      if (localObject5 != null)
      {
        ((GameRegionPreference.a)localObject5).leA = f.aYV();
        ((GameRegionPreference.a)localObject5).leB = f.aYW();
        ((GameRegionPreference.a)localObject5).leC = f.aYX();
        ((GameRegionPreference.a)localObject5).isDefault = true;
      }
      label413:
      return;
      label416:
      localObject5 = "";
      break;
      label422:
      i += 1;
    }
  }
  
  public final Map<String, GameRegionPreference.a> bat()
  {
    try
    {
      bas();
      Map localMap = this.leD;
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
      if (this.leD != null) {
        this.leD.clear();
      }
      this.lgc = false;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.f.a
 * JD-Core Version:    0.7.0.1
 */