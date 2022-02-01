package com.tencent.mm.k;

import androidx.lifecycle.x;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.cx;
import com.tencent.mm.autogen.a.du;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.aq;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private HashMap<String, String> lZR;
  private final HashMap<String, x> lZS;
  protected boolean lZT;
  
  public f()
  {
    AppMethodBeat.i(131992);
    this.lZR = new HashMap();
    this.lZS = new HashMap();
    this.lZT = false;
    AppMethodBeat.o(131992);
  }
  
  private void b(Map<String, String> paramMap, boolean paramBoolean)
  {
    AppMethodBeat.i(132000);
    if (paramMap == null)
    {
      AppMethodBeat.o(132000);
      return;
    }
    if (!paramBoolean) {
      this.lZR.clear();
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
          if ((str1 == null) || (Util.isNullOrNil(str1.trim()))) {
            break label284;
          }
          localHashMap = this.lZR;
          str2 = str1.trim();
          if (localObject2 == null) {
            break label277;
          }
        }
      }
      label277:
      for (Object localObject1 = localObject2;; localObject1 = "")
      {
        localHashMap.put(str2, localObject1);
        localObject1 = new cx();
        ((cx)localObject1).hCR.hCS = str1.trim();
        ((cx)localObject1).publish();
        Log.d("MicroMsg.DynamicConfig", "put %s %s", new Object[] { str1.trim(), localObject2 });
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
    label284:
    Log.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.lZR.toString() });
    AppMethodBeat.o(132000);
  }
  
  private void v(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131999);
    b(XmlParser.parseXml(paramString, "sysmsg", null), paramBoolean);
    AppMethodBeat.o(131999);
  }
  
  /* Error */
  public final java.util.List<String> DL(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 141
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 31	com/tencent/mm/k/f:lZT	Z
    //   11: ifne +14 -> 25
    //   14: ldc 104
    //   16: ldc 143
    //   18: invokestatic 147	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 150	com/tencent/mm/k/f:Td	()V
    //   25: new 152	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 153	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 81	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +72 -> 109
    //   40: aload_0
    //   41: getfield 27	com/tencent/mm/k/f:lZR	Ljava/util/HashMap;
    //   44: invokevirtual 157	java/util/HashMap:keySet	()Ljava/util/Set;
    //   47: invokeinterface 163 1 0
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 168 1 0
    //   59: ifeq +50 -> 109
    //   62: aload_3
    //   63: invokeinterface 172 1 0
    //   68: checkcast 72	java/lang/String
    //   71: astore 4
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 175	java/lang/String:matches	(Ljava/lang/String;)Z
    //   79: ifeq -26 -> 53
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 27	com/tencent/mm/k/f:lZR	Ljava/util/HashMap;
    //   87: aload 4
    //   89: invokevirtual 176	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: checkcast 72	java/lang/String
    //   95: invokeinterface 182 2 0
    //   100: pop
    //   101: goto -48 -> 53
    //   104: astore_1
    //   105: aload_0
    //   106: monitorexit
    //   107: aload_1
    //   108: athrow
    //   109: ldc 104
    //   111: ldc 184
    //   113: iconst_2
    //   114: anewarray 4	java/lang/Object
    //   117: dup
    //   118: iconst_0
    //   119: aload_1
    //   120: aastore
    //   121: dup
    //   122: iconst_1
    //   123: aload_2
    //   124: invokeinterface 188 1 0
    //   129: invokestatic 118	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   132: aastore
    //   133: invokestatic 112	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   136: ldc 141
    //   138: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   141: aload_0
    //   142: monitorexit
    //   143: aload_2
    //   144: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	145	0	this	f
    //   0	145	1	paramString	String
    //   32	112	2	localArrayList	java.util.ArrayList
    //   52	11	3	localIterator	java.util.Iterator
    //   71	17	4	str	String
    // Exception table:
    //   from	to	target	type
    //   2	25	104	finally
    //   25	53	104	finally
    //   53	101	104	finally
    //   109	141	104	finally
  }
  
  public final void Td()
  {
    try
    {
      AppMethodBeat.i(131997);
      h.baF();
      if (h.baE() != null)
      {
        h.baF();
        if (h.baE().ban() != null)
        {
          this.lZT = true;
          h.baF();
          v((String)h.baE().ban().d(278529, null), false);
        }
      }
      h.baF();
      if (h.baE() != null)
      {
        h.baF();
        if (h.baE().ban() != null)
        {
          this.lZT = true;
          h.baF();
          v((String)h.baE().ban().d(278530, null), true);
        }
      }
      AppMethodBeat.o(131997);
      return;
    }
    finally {}
  }
  
  public final void a(String paramString, Map<String, String> paramMap, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        AppMethodBeat.i(131998);
        if (Util.isNullOrNil(paramString))
        {
          AppMethodBeat.o(131998);
          return;
        }
        Log.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), y.bub(paramString) });
        if (paramBoolean)
        {
          h.baF();
          h.baE().ban().B(278530, paramString);
          if (paramMap == null) {
            break label137;
          }
          b(paramMap, paramBoolean);
          new du().publish();
          AppMethodBeat.o(131998);
          continue;
        }
        h.baF();
      }
      finally {}
      h.baE().ban().B(278529, paramString);
      h.baF();
      h.baE().ban().B(278530, "");
      continue;
      label137:
      v(paramString, paramBoolean);
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
        Log.e("MicroMsg.DynamicConfig", "parseInt failed, val: ".concat(String.valueOf(paramString)));
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
      if (!this.lZT)
      {
        Log.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        Td();
      }
      Log.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.lZR.get(paramString) });
      paramString = (String)this.lZR.get(paramString);
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
        Log.d("MicroMsg.DynamicConfig", "put configs.put(key,value) %s %s", new Object[] { paramString1.trim(), paramString2 });
        this.lZR.put(paramString1, paramString2);
        paramString2 = new cx();
        paramString2.hCR.hCS = paramString1.trim();
        paramString2.publish();
      }
      AppMethodBeat.o(131996);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.k.f
 * JD-Core Version:    0.7.0.1
 */