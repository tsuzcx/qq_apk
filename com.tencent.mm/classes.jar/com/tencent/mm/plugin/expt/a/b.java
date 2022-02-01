package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.e.a;
import com.tencent.mm.plugin.expt.e.d;
import com.tencent.mm.protocal.protobuf.aow;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MultiProcessMMKV;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  static String TAG = "MicroMsg.ExptIdMMKV";
  private static b yFR;
  private String name = null;
  
  public static b dHJ()
  {
    AppMethodBeat.i(299823);
    if (yFR == null) {
      yFR = new b();
    }
    b localb = yFR;
    AppMethodBeat.o(299823);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(299835);
    String str = hashCode();
    AppMethodBeat.o(299835);
    return str;
  }
  
  public final MultiProcessMMKV atj()
  {
    AppMethodBeat.i(299848);
    d.dNI();
    int i = d.getUin();
    if (i == 0)
    {
      Log.e(TAG, "uin err [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(299848);
      return null;
    }
    Object localObject = i + "_WxExptIdmmkv";
    if (!Util.isEqual(this.name, (String)localObject))
    {
      Log.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = MultiProcessMMKV.getMMKV(this.name);
    AppMethodBeat.o(299848);
    return localObject;
  }
  
  public final List<aow> dHK()
  {
    AppMethodBeat.i(299857);
    LinkedList localLinkedList = new LinkedList();
    MultiProcessMMKV localMultiProcessMMKV = atj();
    if (localMultiProcessMMKV != null)
    {
      String[] arrayOfString = localMultiProcessMMKV.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        Log.i(TAG, "mmkv keys length is [%d] ", new Object[] { Integer.valueOf(arrayOfString.length) });
        int i = 0;
        while (i < arrayOfString.length)
        {
          aow localaow = new aow();
          a locala = com.tencent.mm.plugin.expt.e.b.dNr().Mh(Util.getInt(arrayOfString[i], 0));
          if (locala != null)
          {
            localaow.ZvX = locala.zNd;
            localaow.ZvY = locala.kW;
            localaow.ZvZ = locala.zNe;
            localaow.count = localMultiProcessMMKV.decodeInt(arrayOfString[i]);
            localLinkedList.add(localaow);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(299857);
    return localLinkedList;
  }
  
  /* Error */
  final void dHL()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 171
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 110	com/tencent/mm/plugin/expt/a/b:atj	()Lcom/tencent/mm/sdk/platformtools/MultiProcessMMKV;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.b
 * JD-Core Version:    0.7.0.1
 */