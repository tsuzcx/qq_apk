package com.tencent.mm.plugin.game.commlib;

import android.content.Context;
import com.tencent.mm.loader.a.b;
import com.tencent.mm.m.e;
import com.tencent.mm.m.g;
import com.tencent.mm.plugin.game.d.ab;
import com.tencent.mm.plugin.game.d.aj;
import com.tencent.mm.plugin.game.d.ax;
import com.tencent.mm.plugin.game.d.ct;
import com.tencent.mm.plugin.game.d.dc;
import com.tencent.mm.plugin.game.d.dm;
import com.tencent.mm.plugin.game.d.m;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class a
{
  private static final String kLX = b.dOP + "game/";
  private static final String kLY = kLX + "globalconfig";
  private static ax kLZ;
  
  /* Error */
  public static void a(ax paramax)
  {
    // Byte code:
    //   0: aload_0
    //   1: putstatic 44	com/tencent/mm/plugin/game/commlib/a:kLZ	Lcom/tencent/mm/plugin/game/d/ax;
    //   4: aload_0
    //   5: getfield 50	com/tencent/mm/plugin/game/d/ax:kUl	Lcom/tencent/mm/plugin/game/d/r;
    //   8: ifnull +27 -> 35
    //   11: invokestatic 56	com/tencent/mm/kernel/g:DP	()Lcom/tencent/mm/kernel/e;
    //   14: invokevirtual 62	com/tencent/mm/kernel/e:Dz	()Lcom/tencent/mm/storage/z;
    //   17: getstatic 68	com/tencent/mm/storage/ac$a:uzR	Lcom/tencent/mm/storage/ac$a;
    //   20: getstatic 44	com/tencent/mm/plugin/game/commlib/a:kLZ	Lcom/tencent/mm/plugin/game/d/ax;
    //   23: getfield 50	com/tencent/mm/plugin/game/d/ax:kUl	Lcom/tencent/mm/plugin/game/d/r;
    //   26: getfield 74	com/tencent/mm/plugin/game/d/r:kST	Z
    //   29: invokestatic 80	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   32: invokevirtual 86	com/tencent/mm/storage/z:c	(Lcom/tencent/mm/storage/ac$a;Ljava/lang/Object;)V
    //   35: new 88	java/io/File
    //   38: dup
    //   39: getstatic 33	com/tencent/mm/plugin/game/commlib/a:kLX	Ljava/lang/String;
    //   42: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   45: astore_1
    //   46: aload_1
    //   47: invokevirtual 95	java/io/File:exists	()Z
    //   50: ifeq +10 -> 60
    //   53: aload_1
    //   54: invokevirtual 98	java/io/File:isDirectory	()Z
    //   57: ifne +8 -> 65
    //   60: aload_1
    //   61: invokevirtual 101	java/io/File:mkdirs	()Z
    //   64: pop
    //   65: aload_0
    //   66: invokevirtual 105	com/tencent/mm/plugin/game/d/ax:toByteArray	()[B
    //   69: astore_1
    //   70: new 107	java/io/FileOutputStream
    //   73: dup
    //   74: getstatic 37	com/tencent/mm/plugin/game/commlib/a:kLY	Ljava/lang/String;
    //   77: invokespecial 108	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   80: astore_0
    //   81: aload_0
    //   82: aload_1
    //   83: invokevirtual 112	java/io/FileOutputStream:write	([B)V
    //   86: aload_0
    //   87: ifnull +7 -> 94
    //   90: aload_0
    //   91: invokevirtual 115	java/io/FileOutputStream:close	()V
    //   94: invokestatic 120	com/tencent/mm/plugin/game/commlib/e:aYs	()V
    //   97: return
    //   98: astore_1
    //   99: aconst_null
    //   100: astore_0
    //   101: ldc 122
    //   103: new 13	java/lang/StringBuilder
    //   106: dup
    //   107: ldc 124
    //   109: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   112: aload_1
    //   113: invokevirtual 128	java/io/IOException:getMessage	()Ljava/lang/String;
    //   116: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: goto -39 -> 86
    //   128: astore_0
    //   129: goto -35 -> 94
    //   132: astore_1
    //   133: goto -32 -> 101
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	paramax	ax
    //   45	38	1	localObject	Object
    //   98	15	1	localIOException1	java.io.IOException
    //   132	1	1	localIOException2	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   65	81	98	java/io/IOException
    //   90	94	128	java/io/IOException
    //   81	86	132	java/io/IOException
  }
  
  /* Error */
  public static void aYj()
  {
    // Byte code:
    //   0: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   3: lstore_0
    //   4: new 88	java/io/File
    //   7: dup
    //   8: getstatic 37	com/tencent/mm/plugin/game/commlib/a:kLY	Ljava/lang/String;
    //   11: invokespecial 91	java/io/File:<init>	(Ljava/lang/String;)V
    //   14: astore_3
    //   15: new 145	java/io/FileInputStream
    //   18: dup
    //   19: aload_3
    //   20: invokespecial 148	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   23: astore_2
    //   24: aload_3
    //   25: invokevirtual 151	java/io/File:length	()J
    //   28: l2i
    //   29: newarray byte
    //   31: astore_3
    //   32: aload_2
    //   33: aload_3
    //   34: invokevirtual 155	java/io/FileInputStream:read	([B)I
    //   37: pop
    //   38: new 46	com/tencent/mm/plugin/game/d/ax
    //   41: dup
    //   42: invokespecial 156	com/tencent/mm/plugin/game/d/ax:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: putstatic 44	com/tencent/mm/plugin/game/commlib/a:kLZ	Lcom/tencent/mm/plugin/game/d/ax;
    //   52: aload 4
    //   54: aload_3
    //   55: invokevirtual 160	com/tencent/mm/plugin/game/d/ax:aH	([B)Lcom/tencent/mm/bv/a;
    //   58: pop
    //   59: aload_2
    //   60: ifnull +7 -> 67
    //   63: aload_2
    //   64: invokevirtual 161	java/io/FileInputStream:close	()V
    //   67: ldc 122
    //   69: new 13	java/lang/StringBuilder
    //   72: dup
    //   73: ldc 163
    //   75: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   78: invokestatic 143	java/lang/System:currentTimeMillis	()J
    //   81: lload_0
    //   82: lsub
    //   83: invokevirtual 166	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   86: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   89: invokestatic 169	com/tencent/mm/sdk/platformtools/y:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   92: return
    //   93: astore_3
    //   94: aconst_null
    //   95: astore_2
    //   96: ldc 122
    //   98: new 13	java/lang/StringBuilder
    //   101: dup
    //   102: ldc 171
    //   104: invokespecial 125	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   107: aload_3
    //   108: invokevirtual 172	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   111: invokevirtual 25	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   114: invokevirtual 31	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   117: invokestatic 134	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   120: goto -61 -> 59
    //   123: astore_2
    //   124: goto -57 -> 67
    //   127: astore_3
    //   128: goto -32 -> 96
    // Local variable table:
    //   start	length	slot	name	signature
    //   3	79	0	l	long
    //   23	73	2	localFileInputStream	java.io.FileInputStream
    //   123	1	2	localIOException	java.io.IOException
    //   14	41	3	localObject	Object
    //   93	15	3	localException1	java.lang.Exception
    //   127	1	3	localException2	java.lang.Exception
    //   45	8	4	localax	ax
    // Exception table:
    //   from	to	target	type
    //   4	24	93	java/lang/Exception
    //   63	67	123	java/io/IOException
    //   24	59	127	java/lang/Exception
  }
  
  public static boolean aYk()
  {
    boolean bool;
    if (kLZ != null)
    {
      bool = kLZ.kUd;
      y.i("MicroMsg.GameConfigManager", "getShowEntrance : " + bool);
      return bool;
    }
    aYj();
    String str = x.d(ae.getContext().getSharedPreferences(ae.cqR(), 0));
    y.i("MicroMsg.GameConfigManager", "getShowEntrance, lang = %s", new Object[] { str });
    if ("zh_CN".equals(str)) {}
    for (str = "0";; str = "1")
    {
      str = bk.aM(g.AA().getValue("HideGameCenter"), str);
      y.i("MicroMsg.GameConfigManager", "hide game center:[%s]", new Object[] { str });
      bool = str.equalsIgnoreCase("0");
      break;
    }
  }
  
  public static aj aYl()
  {
    if (kLZ != null)
    {
      aj localaj = kLZ.kUe;
      if (localaj != null) {
        y.i("MicroMsg.GameConfigManager", "getGameIndexSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localaj.kTh), localaj.kRP });
      }
      return localaj;
    }
    aYj();
    return null;
  }
  
  public static ab aYm()
  {
    if (kLZ != null)
    {
      ab localab = kLZ.kUg;
      if (localab != null) {
        y.i("MicroMsg.GameConfigManager", "getGameDetailSettingControl jumpType:%d, jumpUrl:%s", new Object[] { Integer.valueOf(localab.kTh), localab.kRP });
      }
      return localab;
    }
    aYj();
    return null;
  }
  
  public static dc aYn()
  {
    if (kLZ != null) {
      return kLZ.kUi;
    }
    aYj();
    return null;
  }
  
  public static boolean aYo()
  {
    if (kLZ != null)
    {
      if (kLZ.kUk != null) {
        return kLZ.kUk.kWp;
      }
    }
    else {
      aYj();
    }
    return false;
  }
  
  public static String aYp()
  {
    if (kLZ != null)
    {
      if (kLZ.kUj != null) {
        return kLZ.kUj.kSE;
      }
    }
    else {
      aYj();
    }
    return null;
  }
  
  public static List<String> aYq()
  {
    if (kLZ != null)
    {
      if (kLZ.kUk != null)
      {
        Object localObject = kLZ.kUk.kWq;
        if (!bk.dk((List)localObject))
        {
          ArrayList localArrayList = new ArrayList();
          localObject = ((List)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            ct localct = (ct)((Iterator)localObject).next();
            if ((localct != null) && (!bk.bl(localct.kSE))) {
              localArrayList.add(localct.kSE);
            }
          }
          return localArrayList;
        }
      }
    }
    else {
      aYj();
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.commlib.a
 * JD-Core Version:    0.7.0.1
 */