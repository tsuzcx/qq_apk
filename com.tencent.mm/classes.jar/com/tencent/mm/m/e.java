package com.tencent.mm.m;

import com.tencent.mm.h.a.co;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.bn;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private HashMap<String, String> dAo = new HashMap();
  public boolean dAp = false;
  
  private void b(Map<String, String> paramMap, boolean paramBoolean)
  {
    if (paramMap == null) {
      return;
    }
    if (!paramBoolean) {
      this.dAo.clear();
    }
    int i = 0;
    if (i < 10000)
    {
      Object localObject2;
      label48:
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
          if ((str1 == null) || (bk.bl(str1.trim()))) {
            break label246;
          }
          localHashMap = this.dAo;
          str2 = str1.trim();
          if (localObject2 == null) {
            break label239;
          }
        }
      }
      label239:
      for (Object localObject1 = localObject2;; localObject1 = "")
      {
        localHashMap.put(str2, localObject1);
        y.d("MicroMsg.DynamicConfig", "put %s %s", new Object[] { str1.trim(), localObject2 });
        i += 1;
        break;
        localObject1 = Integer.valueOf(i);
        break label48;
        localObject2 = new StringBuilder(".sysmsg.dynacfg.Item");
        if (i == 0) {}
        for (localObject1 = "";; localObject1 = Integer.valueOf(i))
        {
          localObject1 = localObject1;
          break;
        }
      }
    }
    label246:
    y.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.dAo.toString() });
  }
  
  public final void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool = bk.bl(paramString);
        if (bool) {
          return;
        }
        y.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), com.tencent.mm.a.g.bQ(paramString) });
        if (paramBoolean)
        {
          com.tencent.mm.kernel.g.DQ();
          com.tencent.mm.kernel.g.DP().Dz().o(278530, paramString);
          if (paramMap == null) {
            break label131;
          }
          b(paramMap, paramBoolean);
          paramString = new co();
          a.udP.m(paramString);
          continue;
        }
        com.tencent.mm.kernel.g.DQ();
      }
      finally {}
      com.tencent.mm.kernel.g.DP().Dz().o(278529, paramString);
      com.tencent.mm.kernel.g.DQ();
      com.tencent.mm.kernel.g.DP().Dz().o(278530, "");
      continue;
      label131:
      n(paramString, paramBoolean);
    }
  }
  
  /* Error */
  public final java.util.List<String> fi(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 20	com/tencent/mm/m/e:dAp	Z
    //   6: ifne +14 -> 20
    //   9: ldc 72
    //   11: ldc 159
    //   13: invokestatic 163	com/tencent/mm/sdk/platformtools/y:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   16: aload_0
    //   17: invokevirtual 166	com/tencent/mm/m/e:mT	()V
    //   20: new 168	java/util/ArrayList
    //   23: dup
    //   24: invokespecial 169	java/util/ArrayList:<init>	()V
    //   27: astore_2
    //   28: aload_1
    //   29: invokestatic 66	com/tencent/mm/sdk/platformtools/bk:bl	(Ljava/lang/String;)Z
    //   32: ifne +69 -> 101
    //   35: aload_0
    //   36: getfield 18	com/tencent/mm/m/e:dAo	Ljava/util/HashMap;
    //   39: invokevirtual 173	java/util/HashMap:keySet	()Ljava/util/Set;
    //   42: invokeinterface 179 1 0
    //   47: astore_3
    //   48: aload_3
    //   49: invokeinterface 185 1 0
    //   54: ifeq +47 -> 101
    //   57: aload_3
    //   58: invokeinterface 189 1 0
    //   63: checkcast 57	java/lang/String
    //   66: astore 4
    //   68: aload 4
    //   70: aload_1
    //   71: invokevirtual 192	java/lang/String:matches	(Ljava/lang/String;)Z
    //   74: ifeq -26 -> 48
    //   77: aload_2
    //   78: aload_0
    //   79: getfield 18	com/tencent/mm/m/e:dAo	Ljava/util/HashMap;
    //   82: aload 4
    //   84: invokevirtual 193	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   87: invokeinterface 199 2 0
    //   92: pop
    //   93: goto -45 -> 48
    //   96: astore_1
    //   97: aload_0
    //   98: monitorexit
    //   99: aload_1
    //   100: athrow
    //   101: ldc 72
    //   103: ldc 201
    //   105: iconst_2
    //   106: anewarray 4	java/lang/Object
    //   109: dup
    //   110: iconst_0
    //   111: aload_1
    //   112: aastore
    //   113: dup
    //   114: iconst_1
    //   115: aload_2
    //   116: invokeinterface 205 1 0
    //   121: invokestatic 86	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   124: aastore
    //   125: invokestatic 80	com/tencent/mm/sdk/platformtools/y:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   128: aload_0
    //   129: monitorexit
    //   130: aload_2
    //   131: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	132	0	this	e
    //   0	132	1	paramString	String
    //   27	104	2	localArrayList	java.util.ArrayList
    //   47	11	3	localIterator	java.util.Iterator
    //   66	17	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	20	96	finally
    //   20	48	96	finally
    //   48	93	96	finally
    //   101	128	96	finally
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    try
    {
      int i = Integer.parseInt(getValue(paramString));
      return i;
    }
    catch (Exception localException)
    {
      y.e("MicroMsg.DynamicConfig", "parseInt failed, val: " + paramString);
    }
    return paramInt;
  }
  
  public final String getValue(String paramString)
  {
    try
    {
      if (!this.dAp)
      {
        y.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        mT();
      }
      y.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.dAo.get(paramString) });
      paramString = (String)this.dAo.get(paramString);
      return paramString;
    }
    finally {}
  }
  
  public void mT()
  {
    try
    {
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DP() != null)
      {
        com.tencent.mm.kernel.g.DQ();
        if (com.tencent.mm.kernel.g.DP().Dz() != null)
        {
          this.dAp = true;
          com.tencent.mm.kernel.g.DQ();
          n((String)com.tencent.mm.kernel.g.DP().Dz().get(278529, null), false);
        }
      }
      com.tencent.mm.kernel.g.DQ();
      if (com.tencent.mm.kernel.g.DP() != null)
      {
        com.tencent.mm.kernel.g.DQ();
        if (com.tencent.mm.kernel.g.DP().Dz() != null)
        {
          this.dAp = true;
          com.tencent.mm.kernel.g.DQ();
          n((String)com.tencent.mm.kernel.g.DP().Dz().get(278530, null), true);
        }
      }
      return;
    }
    finally {}
  }
  
  public final void n(String paramString, boolean paramBoolean)
  {
    b(bn.s(paramString, "sysmsg"), paramBoolean);
  }
  
  @Deprecated
  public final void put(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null)) {}
    try
    {
      y.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", new Object[] { paramString1.trim(), paramString2 });
      this.dAo.put(paramString1, paramString2);
      return;
    }
    finally
    {
      paramString1 = finally;
      throw paramString1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.e
 * JD-Core Version:    0.7.0.1
 */