package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.ahw;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ay;
import com.tencent.mm.sdk.platformtools.bu;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  static String TAG = "MicroMsg.ExptIdMMKV";
  private static b qwc;
  private String name = null;
  
  public static b coo()
  {
    AppMethodBeat.i(195833);
    if (qwc == null) {
      qwc = new b();
    }
    b localb = qwc;
    AppMethodBeat.o(195833);
    return localb;
  }
  
  private String info()
  {
    AppMethodBeat.i(195837);
    String str = hashCode();
    AppMethodBeat.o(195837);
    return str;
  }
  
  public final ay bOc()
  {
    AppMethodBeat.i(195834);
    d.ctr();
    int i = d.getUin();
    if (i == 0)
    {
      ae.e(TAG, "uin err [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(195834);
      return null;
    }
    Object localObject = i + "_WxExptIdmmkv";
    if (!bu.lX(this.name, (String)localObject))
    {
      ae.i(TAG, "%s get mmkv change uin old[%s] new[%s]", new Object[] { info(), this.name, localObject });
      this.name = ((String)localObject);
    }
    localObject = ay.aRW(this.name);
    AppMethodBeat.o(195834);
    return localObject;
  }
  
  public final List<ahw> cop()
  {
    AppMethodBeat.i(195835);
    LinkedList localLinkedList = new LinkedList();
    ay localay = bOc();
    if (localay != null)
    {
      String[] arrayOfString = localay.allKeys();
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        ae.i(TAG, "mmkv keys length is [%d] ", new Object[] { Integer.valueOf(arrayOfString.length) });
        int i = 0;
        while (i < arrayOfString.length)
        {
          ahw localahw = new ahw();
          a locala = com.tencent.mm.plugin.expt.h.b.ctb().DN(bu.getInt(arrayOfString[i], 0));
          if (locala != null)
          {
            localahw.GxH = locala.rjD;
            localahw.GxI = locala.adG;
            localahw.GxJ = locala.rjE;
            localahw.count = localay.decodeInt(arrayOfString[i]);
            localLinkedList.add(localahw);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(195835);
    return localLinkedList;
  }
  
  /* Error */
  final void coq()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 171
    //   4: invokestatic 30	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: invokevirtual 110	com/tencent/mm/plugin/expt/a/b:bOc	()Lcom/tencent/mm/sdk/platformtools/ay;
    //   11: astore_1
    //   12: aload_1
    //   13: ifnonnull +11 -> 24
    //   16: ldc 171
    //   18: invokestatic 36	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   21: aload_0
    //   22: monitorexit
    //   23: return
    //   24: aload_1
    //   25: invokevirtual 175	com/tencent/mm/sdk/platformtools/ay:clear	()Landroid/content/SharedPreferences$Editor;
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
    //   11	14	1	localay	ay
    //   42	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	12	42	finally
    //   16	21	42	finally
    //   24	39	42	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.b
 * JD-Core Version:    0.7.0.1
 */