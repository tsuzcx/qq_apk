package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.aki;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  static String TAG = "MicroMsg.ExptIdMMKV";
  private static b rNJ;
  private String name = null;
  
  public static b cMz()
  {
    AppMethodBeat.i(220253);
    if (rNJ == null) {
      rNJ = new b();
    }
    b localb = rNJ;
    AppMethodBeat.o(220253);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(220257);
    String str = hashCode();
    AppMethodBeat.o(220257);
    return str;
  }
  
  public final MultiProcessMMKV aTI()
  {
    AppMethodBeat.i(220254);
    d.cRY();
    int i = d.getUin();
    if (i == 0)
    {
      Log.e(TAG, "uin err [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(220254);
      return null;
    }
    Object localObject = i + "_WxExptIdmmkv";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(220254);
    return localObject;
  }
  
  public final List<aki> cMA()
  {
    AppMethodBeat.i(220255);
    LinkedList localLinkedList = new LinkedList();
    MultiProcessMMKV localMultiProcessMMKV = aTI();
    if (localMultiProcessMMKV != null)
    {
      String[] arrayOfString = localMultiProcessMMKV.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        Log.i(TAG, "mmkv keys length is [%d] ", new Object[] { Integer.valueOf(arrayOfString.length) });
        int i = 0;
        while (i < arrayOfString.length)
        {
          aki localaki = new aki();
          a locala = com.tencent.mm.plugin.expt.h.b.cRI().HA(Util.getInt(arrayOfString[i], 0));
          if (locala != null)
          {
            localaki.Ltq = locala.sLf;
            localaki.Ltr = locala.adT;
            localaki.Lts = locala.sLg;
            localaki.count = localMultiProcessMMKV.decodeInt(arrayOfString[i]);
            localLinkedList.add(localaki);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(220255);
    return localLinkedList;
  }
  
  /* Error */
  final void cMB()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 171
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 110	com/tencent/mm/plugin/expt/a/b:aTI	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: ldc 171
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: invokevirtual 175	com/tencent/mm/sdk/platformtools/MultiProcessMMKV:clear	()Landroid/content/SharedPreferences$Editor;
    //   28: invokeinterface 181 1 0
    //   33: pop
    //   34: ldc 171
    //   36: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   39: goto -18 -> 21
    //   42: astore_1
    //   43: aload_0
    //   44: monitorexit
    //   45: aload_1
    //   46: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	47	0	this	b
    //   11	14	1	localMultiProcessMMKV	MultiProcessMMKV
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	42	finally
    //   16	21	42	finally
    //   24	39	42	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.b
 * JD-Core Version:    0.7.0.1
 */