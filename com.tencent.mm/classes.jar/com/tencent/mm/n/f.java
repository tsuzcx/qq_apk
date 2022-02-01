package com.tencent.mm.n;

import androidx.lifecycle.r;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.a.co;
import com.tencent.mm.f.a.dk;
import com.tencent.mm.kernel.h;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.event.IEvent;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.platformtools.XmlParser;
import com.tencent.mm.storage.ao;
import com.tencent.mm.vfs.u;
import java.util.HashMap;
import java.util.Map;

public final class f
{
  private final HashMap<String, r> jwA;
  protected boolean jwB;
  private HashMap<String, String> jwz;
  
  public f()
  {
    AppMethodBeat.i(131992);
    this.jwz = new HashMap();
    this.jwA = new HashMap();
    this.jwB = false;
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
      this.jwz.clear();
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
            break label287;
          }
          localHashMap = this.jwz;
          str2 = str1.trim();
          if (localObject2 == null) {
            break label280;
          }
        }
      }
      label280:
      for (Object localObject1 = localObject2;; localObject1 = "")
      {
        localHashMap.put(str2, localObject1);
        localObject1 = new co();
        ((co)localObject1).fym.fyn = str1.trim();
        EventCenter.instance.publish((IEvent)localObject1);
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
    label287:
    Log.d("MicroMsg.DynamicConfig", "All dynamicConfig:%s", new Object[] { this.jwz.toString() });
    AppMethodBeat.o(132000);
  }
  
  private void u(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(131999);
    a(XmlParser.parseXml(paramString, "sysmsg", null), paramBoolean);
    AppMethodBeat.o(131999);
  }
  
  /* Error */
  public final java.util.List<String> Le(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 147
    //   4: invokestatic 22	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 31	com/tencent/mm/n/f:jwB	Z
    //   11: ifne +14 -> 25
    //   14: ldc 110
    //   16: ldc 149
    //   18: invokestatic 153	com/tencent/mm/sdk/platformtools/Log:e	(Ljava/lang/String;Ljava/lang/String;)V
    //   21: aload_0
    //   22: invokevirtual 156	com/tencent/mm/n/f:tA	()V
    //   25: new 158	java/util/ArrayList
    //   28: dup
    //   29: invokespecial 159	java/util/ArrayList:<init>	()V
    //   32: astore_2
    //   33: aload_1
    //   34: invokestatic 81	com/tencent/mm/sdk/platformtools/Util:isNullOrNil	(Ljava/lang/String;)Z
    //   37: ifne +69 -> 106
    //   40: aload_0
    //   41: getfield 27	com/tencent/mm/n/f:jwz	Ljava/util/HashMap;
    //   44: invokevirtual 163	java/util/HashMap:keySet	()Ljava/util/Set;
    //   47: invokeinterface 169 1 0
    //   52: astore_3
    //   53: aload_3
    //   54: invokeinterface 175 1 0
    //   59: ifeq +47 -> 106
    //   62: aload_3
    //   63: invokeinterface 179 1 0
    //   68: checkcast 72	java/lang/String
    //   71: astore 4
    //   73: aload 4
    //   75: aload_1
    //   76: invokevirtual 182	java/lang/String:matches	(Ljava/lang/String;)Z
    //   79: ifeq -26 -> 53
    //   82: aload_2
    //   83: aload_0
    //   84: getfield 27	com/tencent/mm/n/f:jwz	Ljava/util/HashMap;
    //   87: aload 4
    //   89: invokevirtual 183	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   92: invokeinterface 189 2 0
    //   97: pop
    //   98: goto -45 -> 53
    //   101: astore_1
    //   102: aload_0
    //   103: monitorexit
    //   104: aload_1
    //   105: athrow
    //   106: ldc 110
    //   108: ldc 191
    //   110: iconst_2
    //   111: anewarray 4	java/lang/Object
    //   114: dup
    //   115: iconst_0
    //   116: aload_1
    //   117: aastore
    //   118: dup
    //   119: iconst_1
    //   120: aload_2
    //   121: invokeinterface 195 1 0
    //   126: invokestatic 124	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   129: aastore
    //   130: invokestatic 118	com/tencent/mm/sdk/platformtools/Log:d	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    //   133: ldc 147
    //   135: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   138: aload_0
    //   139: monitorexit
    //   140: aload_2
    //   141: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	142	0	this	f
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
        Log.i("MicroMsg.DynamicConfig", "update dynacfg. increment:%b, md5:%s", new Object[] { Boolean.valueOf(paramBoolean), u.buc(paramString) });
        if (paramBoolean)
        {
          h.aHH();
          h.aHG().aHp().i(278530, paramString);
          if (paramMap == null) {
            break label142;
          }
          a(paramMap, paramBoolean);
          paramString = new dk();
          EventCenter.instance.publish(paramString);
          AppMethodBeat.o(131998);
          continue;
        }
        h.aHH();
      }
      finally {}
      h.aHG().aHp().i(278529, paramString);
      h.aHH();
      h.aHG().aHp().i(278530, "");
      continue;
      label142:
      u(paramString, paramBoolean);
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
      if (!this.jwB)
      {
        Log.e("MicroMsg.DynamicConfig", "DynamicConfig hadnot load");
        tA();
      }
      Log.d("MicroMsg.DynamicConfig", "get configs.get(config) %s %s", new Object[] { paramString.trim(), this.jwz.get(paramString) });
      paramString = (String)this.jwz.get(paramString);
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
        this.jwz.put(paramString1, paramString2);
        paramString2 = new co();
        paramString2.fym.fyn = paramString1.trim();
        EventCenter.instance.publish(paramString2);
      }
      AppMethodBeat.o(131996);
      return;
    }
    finally {}
  }
  
  public final void tA()
  {
    try
    {
      AppMethodBeat.i(131997);
      h.aHH();
      if (h.aHG() != null)
      {
        h.aHH();
        if (h.aHG().aHp() != null)
        {
          this.jwB = true;
          h.aHH();
          u((String)h.aHG().aHp().b(278529, null), false);
        }
      }
      h.aHH();
      if (h.aHG() != null)
      {
        h.aHH();
        if (h.aHG().aHp() != null)
        {
          this.jwB = true;
          h.aHH();
          u((String)h.aHG().aHp().b(278530, null), true);
        }
      }
      AppMethodBeat.o(131997);
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.n.f
 * JD-Core Version:    0.7.0.1
 */