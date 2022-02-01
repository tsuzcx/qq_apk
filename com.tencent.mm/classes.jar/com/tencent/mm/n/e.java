package com.tencent.mm.n;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.db;
import com.tencent.mm.kernel.g;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.bw;
import com.tencent.mm.storage.ai;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private HashMap<String, String> gex;
  protected boolean gey;
  
  public e()
  {
    AppMethodBeat.i(131992);
    this.gex = new HashMap();
    this.gey = false;
    AppMethodBeat.o(131992);
  }
  
  private void a(Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(132000);
    if (paramMap == null)
    {
      AppMethodBeat.o(132000);
      return;
    }
    if (!paramBoolean) {
      this.gex.clear();
    }
    int i = 0;
    if (i < 10000)
    {
      Object localObject2;
      label58:
      String str1;
      HashMap localHashMap;
      String str2;
      if (paramBoolean)
      {
        localObject2 = new StringBuilder(".sysmsg.dynacfg_split.Item");
        if (i == 0)
        {
          localObject1 = "";
          localObject1 = localObject1;
          str1 = (String)localObject1 + ".$key";
          localObject2 = (String)paramMap.get(localObject1);
          str1 = (String)paramMap.get(str1);
          if ((str1 == null) || (bt.isNullOrNil(str1.trim()))) {
            break label256;
          }
          localHashMap = this.gex;
          str2 = str1.trim();
          if (localObject2 == null) {
            break label249;
          }
        }
      }
      label249:
      for (Object localObject1 = localObject2;; localObject1 = "")
      {
        localHashMap.put(str2, localObject1);
        ad.d("MicroMsg.DynamicConfig", "put %s %s", new Object[] { str1.trim(), localObject2 });
        i += 1;
        break;
        localObject1 = Integer.valueOf(i);
        break label58;
        localObject2 = new StringBuilder(".sysmsg.dynacfg.Item");
        if (i == 0) {}
        for (localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = localObject1;
          break;
        }
      }
    }
    label256:
    ad.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.gex.toString() });
    AppMethodBeat.o(132000);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(131998);
        if (bt.isNullOrNil(paramString))
        {
          AppMethodBeat.o(131998);
          return;
        }
        ad.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), i.aPK(paramString) });
        if (paramBoolean)
        {
          g.ajD();
          g.ajC().ajl().set(278530, paramString);
          if (paramMap == null) {
            break label142;
          }
          a(paramMap, paramBoolean);
          paramString = new db();
          a.IbL.l(paramString);
          AppMethodBeat.o(131998);
          continue;
        }
        g.ajD();
      }
      finally {}
      g.ajC().ajl().set(278529, paramString);
      g.ajD();
      g.ajC().ajl().set(278530, "");
      continue;
      label142:
      r(paramString, paramBoolean);
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(131994);
    try
    {
      int i = Integer.parseInt(getValue(paramString));
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ad.e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(131994);
    return paramInt;
  }
  
  public final String getValue(String paramString)
  {
    try
    {
      AppMethodBeat.i(131993);
      if (!this.gey)
      {
        ad.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        vw();
      }
      ad.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.gex.get(paramString) });
      paramString = (String)this.gex.get(paramString);
      AppMethodBeat.o(131993);
      return paramString;
    }
    finally {}
  }
  
  @Deprecated
  public final void put(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(131996);
      if ((paramString1 != null) && (paramString2 != null))
      {
        ad.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", new Object[] { paramString1.trim(), paramString2 });
        this.gex.put(paramString1, paramString2);
      }
      AppMethodBeat.o(131996);
      return;
    }
    finally {}
  }
  
  protected final void r(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131999);
    a(bw.M(paramString, "sysmsg"), paramBoolean);
    AppMethodBeat.o(131999);
  }
  
  /* Error */
  public final java.util.List<String> vA(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 215
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/mm/n/e:gey	Z
    //   11: ifne +14 -> 25
    //   14: ldc 83
    //   16: ldc 192
    //   18: invokestatic 189	com/tencent/mm/sdk/platformtools/ad:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 195	com/tencent/mm/n/e:vw	()V
    //   25: new 217	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 218	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 77	com/tencent/mm/sdk/platformtools/bt:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +69 -> 106
    //   40: aload_0
    //   41: getfield 25	com/tencent/mm/n/e:gex	Ljava/util/HashMap;
    //   44: invokevirtual 222	java/util/HashMap:keySet	()Ljava/util/Set;
    //   47: invokeinterface 228 1 0
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 234 1 0
    //   59: ifeq +47 -> 106
    //   62: aload_3
    //   63: invokeinterface 238 1 0
    //   68: checkcast 68	java/lang/String
    //   71: astore 4
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 241	java/lang/String:matches	(Ljava/lang/String;)Z
    //   79: ifeq -26 -> 53
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 25	com/tencent/mm/n/e:gex	Ljava/util/HashMap;
    //   87: aload 4
    //   89: invokevirtual 198	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: invokeinterface 247 2 0
    //   97: pop
    //   98: goto -45 -> 53
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: ldc 83
    //   108: ldc 249
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: invokeinterface 253 1 0
    //   126: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: invokestatic 91	com/tencent/mm/sdk/platformtools/ad:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 215
    //   135: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	e
    //   0	142	1	paramString	String
    //   32	109	2	localArrayList	java.util.ArrayList
    //   52	11	3	localIterator	java.util.Iterator
    //   71	17	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	101	finally
    //   25	53	101	finally
    //   53	98	101	finally
    //   106	138	101	finally
  }
  
  public void vw()
  {
    try
    {
      AppMethodBeat.i(131997);
      g.ajD();
      if (g.ajC() != null)
      {
        g.ajD();
        if (g.ajC().ajl() != null)
        {
          this.gey = true;
          g.ajD();
          r((String)g.ajC().ajl().get(278529, null), false);
        }
      }
      g.ajD();
      if (g.ajC() != null)
      {
        g.ajD();
        if (g.ajC().ajl() != null)
        {
          this.gey = true;
          g.ajD();
          r((String)g.ajC().ajl().get(278530, null), true);
        }
      }
      AppMethodBeat.o(131997);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.e
 * JD-Core Version:    0.7.0.1
 */