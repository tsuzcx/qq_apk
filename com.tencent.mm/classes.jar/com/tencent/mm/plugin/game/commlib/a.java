package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import android.content.SharedPreferences;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.loader.j.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.game.d.ac;
import com.tencent.mm.plugin.game.d.ak;
import com.tencent.mm.plugin.game.d.ay;
import com.tencent.mm.plugin.game.d.cu;
import com.tencent.mm.plugin.game.d.dd;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.game.d.do;
import com.tencent.mm.plugin.game.d.dp;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.plugin.game.d.r;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static final String niR;
  public static final String niS;
  private static ay niT;
  
  static
  {
    AppMethodBeat.i(116984);
    niR = b.eQv + "game/";
    niS = niR + "globalconfig";
    AppMethodBeat.o(116984);
  }
  
  /* Error */
  public static void a(ay paramay)
  {
    // Byte code:
    //   0: ldc 53
    //   2: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_0
    //   6: putstatic 55	com/tencent/mm/plugin/game/commlib/a:niT	Lcom/tencent/mm/plugin/game/d/ay;
    //   9: aload_0
    //   10: getfield 61	com/tencent/mm/plugin/game/d/ay:nsl	Lcom/tencent/mm/plugin/game/d/s;
    //   13: ifnull +27 -> 40
    //   16: invokestatic 67	com/tencent/mm/kernel/g:RL	()Lcom/tencent/mm/kernel/e;
    //   19: invokevirtual 73	com/tencent/mm/kernel/e:Ru	()Lcom/tencent/mm/storage/z;
    //   22: getstatic 79	com/tencent/mm/storage/ac$a:yKJ	Lcom/tencent/mm/storage/ac$a;
    //   25: getstatic 55	com/tencent/mm/plugin/game/commlib/a:niT	Lcom/tencent/mm/plugin/game/d/ay;
    //   28: getfield 61	com/tencent/mm/plugin/game/d/ay:nsl	Lcom/tencent/mm/plugin/game/d/s;
    //   31: getfield 85	com/tencent/mm/plugin/game/d/s:nqT	Z
    //   34: invokestatic 91	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   37: invokevirtual 97	com/tencent/mm/storage/z:set	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   40: new 99	java/io/File
    //   43: dup
    //   44: getstatic 40	com/tencent/mm/plugin/game/commlib/a:niR	Ljava/lang/String;
    //   47: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   50: astore_1
    //   51: aload_1
    //   52: invokevirtual 106	java/io/File:exists	()Z
    //   55: ifeq +10 -> 65
    //   58: aload_1
    //   59: invokevirtual 109	java/io/File:isDirectory	()Z
    //   62: ifne +8 -> 70
    //   65: aload_1
    //   66: invokevirtual 112	java/io/File:mkdirs	()Z
    //   69: pop
    //   70: aload_0
    //   71: invokevirtual 116	com/tencent/mm/plugin/game/d/ay:toByteArray	()[B
    //   74: astore_1
    //   75: new 118	java/io/FileOutputStream
    //   78: dup
    //   79: getstatic 44	com/tencent/mm/plugin/game/commlib/a:niS	Ljava/lang/String;
    //   82: invokespecial 119	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   85: astore_0
    //   86: aload_0
    //   87: aload_1
    //   88: invokevirtual 123	java/io/FileOutputStream:write	([B)V
    //   91: aload_0
    //   92: ifnull +7 -> 99
    //   95: aload_0
    //   96: invokevirtual 126	java/io/FileOutputStream:close	()V
    //   99: invokestatic 131	com/tencent/mm/plugin/game/commlib/e:bFk	()V
    //   102: ldc 53
    //   104: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   107: return
    //   108: astore_1
    //   109: aconst_null
    //   110: astore_0
    //   111: ldc 133
    //   113: new 20	java/lang/StringBuilder
    //   116: dup
    //   117: ldc 135
    //   119: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   122: aload_1
    //   123: invokevirtual 139	java/io/IOException:getMessage	()Ljava/lang/String;
    //   126: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   129: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: goto -44 -> 91
    //   138: astore_0
    //   139: goto -40 -> 99
    //   142: astore_1
    //   143: goto -32 -> 111
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	146	0	paramay	ay
    //   50	38	1	localObject	Object
    //   108	15	1	localIOException1	java.io.IOException
    //   142	1	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   70	86	108	java/io/IOException
    //   95	99	138	java/io/IOException
    //   86	91	142	java/io/IOException
  }
  
  /* Error */
  public static void bEY()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: ldc 149
    //   5: invokestatic 18	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   8: getstatic 55	com/tencent/mm/plugin/game/commlib/a:niT	Lcom/tencent/mm/plugin/game/d/ay;
    //   11: ifnull +12 -> 23
    //   14: ldc 149
    //   16: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: ldc 2
    //   21: monitorexit
    //   22: return
    //   23: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   26: lstore_0
    //   27: new 99	java/io/File
    //   30: dup
    //   31: getstatic 44	com/tencent/mm/plugin/game/commlib/a:niS	Ljava/lang/String;
    //   34: invokespecial 102	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_3
    //   38: new 157	java/io/FileInputStream
    //   41: dup
    //   42: aload_3
    //   43: invokespecial 160	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   46: astore_2
    //   47: aload_3
    //   48: invokevirtual 163	java/io/File:length	()J
    //   51: l2i
    //   52: newarray byte
    //   54: astore_3
    //   55: aload_2
    //   56: aload_3
    //   57: invokevirtual 167	java/io/FileInputStream:read	([B)I
    //   60: pop
    //   61: new 57	com/tencent/mm/plugin/game/d/ay
    //   64: dup
    //   65: invokespecial 168	com/tencent/mm/plugin/game/d/ay:<init>	()V
    //   68: astore 4
    //   70: aload 4
    //   72: putstatic 55	com/tencent/mm/plugin/game/commlib/a:niT	Lcom/tencent/mm/plugin/game/d/ay;
    //   75: aload 4
    //   77: aload_3
    //   78: invokevirtual 172	com/tencent/mm/plugin/game/d/ay:parseFrom	([B)Lcom/tencent/mm/bv/a;
    //   81: pop
    //   82: aload_2
    //   83: ifnull +7 -> 90
    //   86: aload_2
    //   87: invokevirtual 173	java/io/FileInputStream:close	()V
    //   90: ldc 133
    //   92: new 20	java/lang/StringBuilder
    //   95: dup
    //   96: ldc 175
    //   98: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   101: invokestatic 155	java/lang/System:currentTimeMillis	()J
    //   104: lload_0
    //   105: lsub
    //   106: invokevirtual 178	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   109: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 180	com/tencent/mm/sdk/platformtools/ab:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: ldc 149
    //   117: invokestatic 47	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   120: goto -101 -> 19
    //   123: astore_2
    //   124: ldc 2
    //   126: monitorexit
    //   127: aload_2
    //   128: athrow
    //   129: astore_3
    //   130: aconst_null
    //   131: astore_2
    //   132: ldc 133
    //   134: new 20	java/lang/StringBuilder
    //   137: dup
    //   138: ldc 182
    //   140: invokespecial 136	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   143: aload_3
    //   144: invokevirtual 183	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   147: invokevirtual 32	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: invokevirtual 38	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   153: invokestatic 145	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   156: goto -74 -> 82
    //   159: astore_2
    //   160: goto -70 -> 90
    //   163: astore_3
    //   164: goto -32 -> 132
    // Local variable table:
    //   start	length	slot	name	signature
    //   26	79	0	l	long
    //   46	41	2	localFileInputStream	java.io.FileInputStream
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
  
  public static boolean bEZ()
  {
    AppMethodBeat.i(116974);
    boolean bool;
    if (niT != null)
    {
      bool = niT.nsd;
      ab.i("MicroMsg.GameConfigManager", "getShowEntrance : ".concat(String.valueOf(bool)));
      AppMethodBeat.o(116974);
      return bool;
    }
    bEY();
    Object localObject = ah.getContext().getSharedPreferences(ah.dsP(), 0);
    ah.getContext();
    localObject = aa.f((SharedPreferences)localObject);
    ab.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { localObject });
    if ("zh_CN".equals(localObject)) {}
    for (localObject = "0";; localObject = "1")
    {
      localObject = bo.bf(g.Nq().getValue("HideGameCenter"), (String)localObject);
      ab.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { localObject });
      bool = ((String)localObject).equalsIgnoreCase("0");
      break;
    }
  }
  
  public static ak bFa()
  {
    AppMethodBeat.i(116975);
    Object localObject = null;
    if (niT != null)
    {
      ak localak = niT.nse;
      localObject = localak;
      if (localak != null)
      {
        ab.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localak.nrh), localak.npR });
        localObject = localak;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(116975);
      return localObject;
      bEY();
    }
  }
  
  public static ac bFb()
  {
    AppMethodBeat.i(116976);
    Object localObject = null;
    if (niT != null)
    {
      ac localac = niT.nsg;
      localObject = localac;
      if (localac != null)
      {
        ab.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localac.nrh), localac.npR });
        localObject = localac;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(116976);
      return localObject;
      bEY();
    }
  }
  
  public static dd bFc()
  {
    AppMethodBeat.i(116977);
    if (niT != null)
    {
      dd localdd = niT.nsi;
      AppMethodBeat.o(116977);
      return localdd;
    }
    bEY();
    AppMethodBeat.o(116977);
    return null;
  }
  
  public static boolean bFd()
  {
    AppMethodBeat.i(116978);
    if (niT != null)
    {
      if (niT.nsk != null)
      {
        boolean bool = niT.nsk.nuq;
        AppMethodBeat.o(116978);
        return bool;
      }
    }
    else {
      bEY();
    }
    AppMethodBeat.o(116978);
    return false;
  }
  
  public static String bFe()
  {
    AppMethodBeat.i(116979);
    if (niT != null)
    {
      if (niT.nsj != null)
      {
        String str = niT.nsj.nqD;
        AppMethodBeat.o(116979);
        return str;
      }
    }
    else {
      bEY();
    }
    AppMethodBeat.o(116979);
    return null;
  }
  
  public static List<String> bFf()
  {
    AppMethodBeat.i(116980);
    if (niT != null)
    {
      if (niT.nsk != null)
      {
        Object localObject = niT.nsk.nur;
        if (!bo.es((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            cu localcu = (cu)((Iterator)localObject).next();
            if ((localcu != null) && (!bo.isNullOrNil(localcu.nqD))) {
              localArrayList.add(localcu.nqD);
            }
          }
          AppMethodBeat.o(116980);
          return localArrayList;
        }
      }
    }
    else {
      bEY();
    }
    AppMethodBeat.o(116980);
    return null;
  }
  
  public static List<String> bFg()
  {
    AppMethodBeat.i(116981);
    if (niT != null)
    {
      if (niT.nsk != null)
      {
        Object localObject = niT.nsk.nus;
        if (!bo.es((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            cu localcu = (cu)((Iterator)localObject).next();
            if ((localcu != null) && (!bo.isNullOrNil(localcu.nqD))) {
              localArrayList.add(localcu.nqD);
            }
          }
          AppMethodBeat.o(116981);
          return localArrayList;
        }
      }
    }
    else {
      bEY();
    }
    AppMethodBeat.o(116981);
    return null;
  }
  
  public static int bFh()
  {
    AppMethodBeat.i(116982);
    if (niT != null)
    {
      if (niT.nsm != null)
      {
        int i = niT.nsm.nup;
        AppMethodBeat.o(116982);
        return i;
      }
      AppMethodBeat.o(116982);
      return 0;
    }
    bEY();
    AppMethodBeat.o(116982);
    return 0;
  }
  
  public static List<String> bFi()
  {
    AppMethodBeat.i(116983);
    if (niT != null)
    {
      if (niT.nsn != null)
      {
        Object localObject = niT.nsn.nqS;
        if (!bo.es((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            dm localdm = (dm)((Iterator)localObject).next();
            if ((localdm != null) && (!bo.isNullOrNil(localdm.nuo))) {
              localArrayList.add(localdm.nuo);
            }
          }
          AppMethodBeat.o(116983);
          return localArrayList;
        }
      }
    }
    else {
      bEY();
    }
    AppMethodBeat.o(116983);
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.a
 * JD-Core Version:    0.7.0.1
 */