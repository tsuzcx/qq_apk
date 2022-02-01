package com.tencent.mm.plugin.game.commlib;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.commlib.e.b;
import com.tencent.mm.plugin.game.d.ae;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.d.de;
import com.tencent.mm.plugin.game.d.dp;
import com.tencent.mm.plugin.game.d.dq;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  public static ay sWd;
  
  public static String cOs()
  {
    AppMethodBeat.i(190948);
    String str = b.cOD() + "globalconfig";
    AppMethodBeat.o(190948);
    return str;
  }
  
  /* Error */
  public static void cOt()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 45
    //   5: invokestatic 15	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 47	com/tencent/mm/plugin/game/commlib/a:sWd	Lcom/tencent/mm/plugin/game/d/ay;
    //   11: ifnull +12 -> 23
    //   14: ldc 45
    //   16: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   26: lstore_0
    //   27: new 55	com/tencent/mm/vfs/e
    //   30: dup
    //   31: invokestatic 57	com/tencent/mm/plugin/game/commlib/a:cOs	()Ljava/lang/String;
    //   34: invokespecial 60	com/tencent/mm/vfs/e:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: new 62	com/tencent/mm/vfs/h
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 65	com/tencent/mm/vfs/h:<init>	(Lcom/tencent/mm/vfs/e;)V
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 68	com/tencent/mm/vfs/e:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 72	com/tencent/mm/vfs/h:read	([B)I
    //   60: pop
    //   61: new 74	com/tencent/mm/plugin/game/d/ay
    //   64: dup
    //   65: invokespecial 75	com/tencent/mm/plugin/game/d/ay:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: putstatic 47	com/tencent/mm/plugin/game/commlib/a:sWd	Lcom/tencent/mm/plugin/game/d/ay;
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 79	com/tencent/mm/plugin/game/d/ay:parseFrom	([B)Lcom/tencent/mm/bw/a;
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 82	com/tencent/mm/vfs/h:close	()V
    //   90: ldc 84
    //   92: new 17	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 86
    //   98: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 53	java/lang/System:currentTimeMillis	()J
    //   104: lload_0
    //   105: lsub
    //   106: invokevirtual 90	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 95	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 45
    //   117: invokestatic 38	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -101 -> 19
    //   123: astore_2
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: ldc 84
    //   134: new 17	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 97
    //   140: invokespecial 87	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokevirtual 100	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 30	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 35	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 103	com/tencent/mm/sdk/platformtools/ac:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -74 -> 82
    //   159: astore_2
    //   160: goto -70 -> 90
    //   163: astore_3
    //   164: goto -32 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	79	0	l	long
    //   46	41	2	localh	com.tencent.mm.vfs.h
    //   123	5	2	localObject1	Object
    //   131	1	2	localObject2	Object
    //   159	1	2	localIOException	java.io.IOException
    //   37	41	3	localObject3	Object
    //   129	15	3	localException1	java.lang.Exception
    //   163	1	3	localException2	java.lang.Exception
    //   68	8	4	localay	ay
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
  
  public static ae cOu()
  {
    AppMethodBeat.i(149392);
    Object localObject = null;
    if (sWd != null)
    {
      ae localae = sWd.tjA;
      localObject = localae;
      if (localae != null)
      {
        ac.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localae.tiE), localae.thh });
        localObject = localae;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(149392);
      return localObject;
      cOt();
    }
  }
  
  public static de cOv()
  {
    AppMethodBeat.i(149393);
    if (sWd != null)
    {
      de localde = sWd.tjC;
      AppMethodBeat.o(149393);
      return localde;
    }
    cOt();
    AppMethodBeat.o(149393);
    return null;
  }
  
  public static boolean cOw()
  {
    AppMethodBeat.i(149394);
    if (sWd != null)
    {
      if (sWd.tjE != null)
      {
        boolean bool = sWd.tjE.tlO;
        AppMethodBeat.o(149394);
        return bool;
      }
    }
    else {
      cOt();
    }
    AppMethodBeat.o(149394);
    return false;
  }
  
  public static List<String> cOx()
  {
    AppMethodBeat.i(149397);
    if (sWd != null)
    {
      if (sWd.tjE != null)
      {
        Object localObject = sWd.tjE.tlQ;
        if (!bs.gY((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            cu localcu = (cu)((Iterator)localObject).next();
            if ((localcu != null) && (!bs.isNullOrNil(localcu.thZ))) {
              localArrayList.add(localcu.thZ);
            }
          }
          AppMethodBeat.o(149397);
          return localArrayList;
        }
      }
    }
    else {
      cOt();
    }
    AppMethodBeat.o(149397);
    return null;
  }
  
  public static int cOy()
  {
    AppMethodBeat.i(149398);
    if (sWd != null)
    {
      if (sWd.tjG != null)
      {
        int i = sWd.tjG.tlN;
        AppMethodBeat.o(149398);
        return i;
      }
      AppMethodBeat.o(149398);
      return 0;
    }
    cOt();
    AppMethodBeat.o(149398);
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.a
 * JD-Core Version:    0.7.0.1
 */