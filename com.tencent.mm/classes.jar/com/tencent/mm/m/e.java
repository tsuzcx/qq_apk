package com.tencent.mm.m;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.cr;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.br;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Map;

public class e
{
  private HashMap<String, String> etQ;
  protected boolean etR;
  
  public e()
  {
    AppMethodBeat.i(57871);
    this.etQ = new HashMap();
    this.etR = false;
    AppMethodBeat.o(57871);
  }
  
  private void b(Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(57879);
    if (paramMap == null)
    {
      AppMethodBeat.o(57879);
      return;
    }
    if (!paramBoolean) {
      this.etQ.clear();
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
          if ((str1 == null) || (bo.isNullOrNil(str1.trim()))) {
            break label256;
          }
          localHashMap = this.etQ;
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
        ab.d("MicroMsg.DynamicConfig", "put %s %s", new Object[] { str1.trim(), localObject2 });
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
    ab.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.etQ.toString() });
    AppMethodBeat.o(57879);
  }
  
  public final void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(57877);
        if (bo.isNullOrNil(paramString))
        {
          AppMethodBeat.o(57877);
          return;
        }
        ab.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), com.tencent.mm.a.g.getMD5(paramString) });
        if (paramBoolean)
        {
          com.tencent.mm.kernel.g.RM();
          com.tencent.mm.kernel.g.RL().Ru().set(278530, paramString);
          if (paramMap == null) {
            break label142;
          }
          b(paramMap, paramBoolean);
          paramString = new cr();
          a.ymk.l(paramString);
          AppMethodBeat.o(57877);
          continue;
        }
        com.tencent.mm.kernel.g.RM();
      }
      finally {}
      com.tencent.mm.kernel.g.RL().Ru().set(278529, paramString);
      com.tencent.mm.kernel.g.RM();
      com.tencent.mm.kernel.g.RL().Ru().set(278530, "");
      continue;
      label142:
      q(paramString, paramBoolean);
    }
  }
  
  public final int getInt(String paramString, int paramInt)
  {
    AppMethodBeat.i(57873);
    try
    {
      int i = Integer.parseInt(getValue(paramString));
      paramInt = i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(paramString)));
      }
    }
    AppMethodBeat.o(57873);
    return paramInt;
  }
  
  public final String getValue(String paramString)
  {
    try
    {
      AppMethodBeat.i(57872);
      if (!this.etR)
      {
        ab.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        ph();
      }
      ab.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.etQ.get(paramString) });
      paramString = (String)this.etQ.get(paramString);
      AppMethodBeat.o(57872);
      return paramString;
    }
    finally {}
  }
  
  /* Error */
  public final java.util.List<String> lv(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 202
    //   4: invokestatic 20	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 27	com/tencent/mm/m/e:etR	Z
    //   11: ifne +14 -> 25
    //   14: ldc 83
    //   16: ldc 193
    //   18: invokestatic 190	com/tencent/mm/sdk/platformtools/ab:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 196	com/tencent/mm/m/e:ph	()V
    //   25: new 204	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 205	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 77	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +69 -> 106
    //   40: aload_0
    //   41: getfield 25	com/tencent/mm/m/e:etQ	Ljava/util/HashMap;
    //   44: invokevirtual 209	java/util/HashMap:keySet	()Ljava/util/Set;
    //   47: invokeinterface 215 1 0
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 221 1 0
    //   59: ifeq +47 -> 106
    //   62: aload_3
    //   63: invokeinterface 225 1 0
    //   68: checkcast 68	java/lang/String
    //   71: astore 4
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 228	java/lang/String:matches	(Ljava/lang/String;)Z
    //   79: ifeq -26 -> 53
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 25	com/tencent/mm/m/e:etQ	Ljava/util/HashMap;
    //   87: aload 4
    //   89: invokevirtual 199	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: invokeinterface 234 2 0
    //   97: pop
    //   98: goto -45 -> 53
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: ldc 83
    //   108: ldc 236
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: invokeinterface 240 1 0
    //   126: invokestatic 97	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: invokestatic 91	com/tencent/mm/sdk/platformtools/ab:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 202
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
  
  public void ph()
  {
    try
    {
      AppMethodBeat.i(57876);
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RL() != null)
      {
        com.tencent.mm.kernel.g.RM();
        if (com.tencent.mm.kernel.g.RL().Ru() != null)
        {
          this.etR = true;
          com.tencent.mm.kernel.g.RM();
          q((String)com.tencent.mm.kernel.g.RL().Ru().get(278529, null), false);
        }
      }
      com.tencent.mm.kernel.g.RM();
      if (com.tencent.mm.kernel.g.RL() != null)
      {
        com.tencent.mm.kernel.g.RM();
        if (com.tencent.mm.kernel.g.RL().Ru() != null)
        {
          this.etR = true;
          com.tencent.mm.kernel.g.RM();
          q((String)com.tencent.mm.kernel.g.RL().Ru().get(278530, null), true);
        }
      }
      AppMethodBeat.o(57876);
      return;
    }
    finally {}
  }
  
  @Deprecated
  public final void put(String paramString1, String paramString2)
  {
    try
    {
      AppMethodBeat.i(57875);
      if ((paramString1 != null) && (paramString2 != null))
      {
        ab.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", new Object[] { paramString1.trim(), paramString2 });
        this.etQ.put(paramString1, paramString2);
      }
      AppMethodBeat.o(57875);
      return;
    }
    finally {}
  }
  
  protected final void q(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(57878);
    b(br.F(paramString, "sysmsg"), paramBoolean);
    AppMethodBeat.o(57878);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.m.e
 * JD-Core Version:    0.7.0.1
 */