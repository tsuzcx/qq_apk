package com.tencent.mm.plugin.appbrand.permission;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashMap;
import java.util.HashSet;

final class d$a
{
  final HashMap<String, HashSet<String>> iBI;
  
  private d$a()
  {
    AppMethodBeat.i(102255);
    this.iBI = new HashMap();
    AppMethodBeat.o(102255);
  }
  
  final void N(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102258);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(102258);
      return;
    }
    try
    {
      paramString1 = (HashSet)this.iBI.get(paramString1);
      if (paramString1 != null) {
        paramString1.remove(paramString2);
      }
      return;
    }
    finally
    {
      AppMethodBeat.o(102258);
    }
  }
  
  /* Error */
  final boolean cQ(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: ldc 54
    //   2: invokestatic 21	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   5: aload_1
    //   6: invokestatic 41	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   9: ifne +10 -> 19
    //   12: aload_2
    //   13: invokestatic 41	com/tencent/mm/sdk/platformtools/bo:isNullOrNil	(Ljava/lang/String;)Z
    //   16: ifeq +10 -> 26
    //   19: ldc 54
    //   21: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: iconst_0
    //   25: ireturn
    //   26: aload_0
    //   27: monitorenter
    //   28: aload_0
    //   29: getfield 26	com/tencent/mm/plugin/appbrand/permission/d$a:iBI	Ljava/util/HashMap;
    //   32: aload_1
    //   33: invokevirtual 45	java/util/HashMap:get	(Ljava/lang/Object;)Ljava/lang/Object;
    //   36: checkcast 47	java/util/HashSet
    //   39: astore_1
    //   40: aload_1
    //   41: ifnull +22 -> 63
    //   44: aload_1
    //   45: aload_2
    //   46: invokevirtual 57	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   49: ifeq +14 -> 63
    //   52: iconst_1
    //   53: istore_3
    //   54: aload_0
    //   55: monitorexit
    //   56: ldc 54
    //   58: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: iload_3
    //   62: ireturn
    //   63: iconst_0
    //   64: istore_3
    //   65: goto -11 -> 54
    //   68: astore_1
    //   69: aload_0
    //   70: monitorexit
    //   71: ldc 54
    //   73: invokestatic 29	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   76: aload_1
    //   77: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	78	0	this	a
    //   0	78	1	paramString1	String
    //   0	78	2	paramString2	String
    //   53	12	3	bool	boolean
    // Exception table:
    //   from	to	target	type
    //   28	40	68	finally
    //   44	52	68	finally
    //   54	56	68	finally
    //   69	71	68	finally
  }
  
  final void put(String paramString1, String paramString2)
  {
    AppMethodBeat.i(102257);
    if ((bo.isNullOrNil(paramString1)) || (bo.isNullOrNil(paramString2)))
    {
      AppMethodBeat.o(102257);
      return;
    }
    try
    {
      HashSet localHashSet2 = (HashSet)this.iBI.get(paramString1);
      HashSet localHashSet1 = localHashSet2;
      if (localHashSet2 == null)
      {
        localHashSet1 = new HashSet();
        this.iBI.put(paramString1, localHashSet1);
      }
      localHashSet1.add(paramString2);
      return;
    }
    finally
    {
      AppMethodBeat.o(102257);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.permission.d.a
 * JD-Core Version:    0.7.0.1
 */