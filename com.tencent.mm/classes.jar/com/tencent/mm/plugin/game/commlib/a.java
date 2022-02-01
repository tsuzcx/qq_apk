package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.d.ai;
import com.tencent.mm.plugin.game.d.am;
import com.tencent.mm.plugin.game.d.ba;
import com.tencent.mm.plugin.game.d.bg;
import com.tencent.mm.plugin.game.d.bi;
import com.tencent.mm.plugin.game.d.d;
import com.tencent.mm.plugin.game.d.dj;
import com.tencent.mm.plugin.game.d.dv;
import com.tencent.mm.plugin.game.d.em;
import com.tencent.mm.plugin.game.d.en;
import com.tencent.mm.plugin.game.d.k;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class a
{
  public static bi udz;
  
  public static bg cZA()
  {
    AppMethodBeat.i(221861);
    if (udz != null)
    {
      bg localbg = udz.utk;
      AppMethodBeat.o(221861);
      return localbg;
    }
    cZs();
    AppMethodBeat.o(221861);
    return null;
  }
  
  public static JSONArray cZB()
  {
    AppMethodBeat.i(221862);
    JSONArray localJSONArray = new JSONArray();
    Object localObject;
    if (udz != null) {
      localObject = udz.utl;
    }
    for (;;)
    {
      label45:
      d locald;
      JSONObject localJSONObject;
      if ((localObject != null) && (((ai)localObject).urQ != null))
      {
        localObject = ((ai)localObject).urQ.iterator();
        if (((Iterator)localObject).hasNext())
        {
          locald = (d)((Iterator)localObject).next();
          localJSONObject = new JSONObject();
        }
      }
      try
      {
        localJSONObject.put("appId", locald.ikm);
        localJSONObject.put("gameName", locald.uqj);
        localJSONObject.put("albumName", locald.uqk);
        localJSONObject.put("defaultTitle", locald.uql);
        label116:
        localJSONArray.put(localJSONObject);
        break label45;
        cZs();
        localObject = null;
        continue;
        AppMethodBeat.o(221862);
        return localJSONArray;
      }
      catch (JSONException localJSONException)
      {
        break label116;
      }
    }
  }
  
  public static String cZr()
  {
    AppMethodBeat.i(221858);
    String str = b.cZG() + "globalconfig";
    AppMethodBeat.o(221858);
    return str;
  }
  
  /* Error */
  public static void cZs()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 125
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 17	com/tencent/mm/plugin/game/commlib/a:udz	Lcom/tencent/mm/plugin/game/d/bi;
    //   11: ifnull +12 -> 23
    //   14: ldc 125
    //   16: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   26: lstore_0
    //   27: new 133	com/tencent/mm/vfs/k
    //   30: dup
    //   31: invokestatic 135	com/tencent/mm/plugin/game/commlib/a:cZr	()Ljava/lang/String;
    //   34: invokespecial 138	com/tencent/mm/vfs/k:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: new 140	com/tencent/mm/vfs/n
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 143	com/tencent/mm/vfs/n:<init>	(Lcom/tencent/mm/vfs/k;)V
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 146	com/tencent/mm/vfs/k:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 150	com/tencent/mm/vfs/n:read	([B)I
    //   60: pop
    //   61: new 19	com/tencent/mm/plugin/game/d/bi
    //   64: dup
    //   65: invokespecial 151	com/tencent/mm/plugin/game/d/bi:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: putstatic 17	com/tencent/mm/plugin/game/commlib/a:udz	Lcom/tencent/mm/plugin/game/d/bi;
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 155	com/tencent/mm/plugin/game/d/bi:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 158	com/tencent/mm/vfs/n:close	()V
    //   90: ldc 160
    //   92: new 105	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 162
    //   98: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 131	java/lang/System:currentTimeMillis	()J
    //   104: lload_0
    //   105: lsub
    //   106: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 171	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 125
    //   117: invokestatic 26	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -101 -> 19
    //   123: astore_2
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: ldc 160
    //   134: new 105	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 173
    //   140: invokespecial 163	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokevirtual 176	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 115	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 120	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 179	com/tencent/mm/sdk/platformtools/ae:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -74 -> 82
    //   159: astore_2
    //   160: goto -70 -> 90
    //   163: astore_3
    //   164: goto -32 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	79	0	l	long
    //   46	41	2	localn	com.tencent.mm.vfs.n
    //   123	5	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   159	1	2	localIOException	java.io.IOException
    //   37	41	3	localObject3	Object
    //   129	15	3	localException1	java.lang.Exception
    //   163	1	3	localException2	java.lang.Exception
    //   68	8	4	localbi	bi
    // Exception table:
    //   from	to	target	type
    //   3	19	123	finally
    //   23	27	123	finally
    //   27	47	123	finally
    //   47	82	123	finally
    //   86	90	123	finally
    //   90	120	123	finally
    //   132	156	123	finally
    //   27	47	129	java/lang/Exception
    //   86	90	159	java/io/IOException
    //   47	82	163	java/lang/Exception
  }
  
  public static am cZt()
  {
    AppMethodBeat.i(149392);
    Object localObject = null;
    if (udz != null)
    {
      am localam = udz.usY;
      localObject = localam;
      if (localam != null)
      {
        ae.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localam.uqI), localam.uqf });
        localObject = localam;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149392);
      return localObject;
      cZs();
    }
  }
  
  public static dv cZu()
  {
    AppMethodBeat.i(149393);
    if (udz != null)
    {
      if (udz.uta != null) {
        ae.i("MicroMsg.GameConfigManager", "getStatusBarStyle color:%s, darkModeColor:%s, style:%s", new Object[] { udz.uta.hDr, udz.uta.uvn, udz.uta.uph });
      }
      dv localdv = udz.uta;
      AppMethodBeat.o(149393);
      return localdv;
    }
    cZs();
    AppMethodBeat.o(149393);
    return null;
  }
  
  public static boolean cZv()
  {
    AppMethodBeat.i(149394);
    if (udz != null)
    {
      if (udz.utc != null)
      {
        boolean bool = udz.utc.uvK;
        AppMethodBeat.o(149394);
        return bool;
      }
    }
    else {
      cZs();
    }
    AppMethodBeat.o(149394);
    return false;
  }
  
  public static List<String> cZw()
  {
    AppMethodBeat.i(149397);
    if (udz != null)
    {
      if (udz.utc != null)
      {
        Object localObject = udz.utc.uvM;
        if (!bu.ht((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            dj localdj = (dj)((Iterator)localObject).next();
            if ((localdj != null) && (!bu.isNullOrNil(localdj.urm))) {
              localArrayList.add(localdj.urm);
            }
          }
          AppMethodBeat.o(149397);
          return localArrayList;
        }
      }
    }
    else {
      cZs();
    }
    AppMethodBeat.o(149397);
    return null;
  }
  
  public static int cZx()
  {
    AppMethodBeat.i(149398);
    if (udz != null)
    {
      if (udz.ute != null)
      {
        int i = udz.ute.uvJ;
        AppMethodBeat.o(149398);
        return i;
      }
      AppMethodBeat.o(149398);
      return 0;
    }
    cZs();
    AppMethodBeat.o(149398);
    return 0;
  }
  
  public static ba cZy()
  {
    AppMethodBeat.i(221859);
    if (udz != null)
    {
      if (udz.utj != null)
      {
        ba localba = udz.utj;
        AppMethodBeat.o(221859);
        return localba;
      }
    }
    else {
      cZs();
    }
    AppMethodBeat.o(221859);
    return null;
  }
  
  public static k cZz()
  {
    AppMethodBeat.i(221860);
    if (udz != null)
    {
      if (udz.utj != null)
      {
        k localk = udz.utj.usK;
        AppMethodBeat.o(221860);
        return localk;
      }
    }
    else {
      cZs();
    }
    AppMethodBeat.o(221860);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.a
 * JD-Core Version:    0.7.0.1
 */