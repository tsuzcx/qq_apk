package com.tencent.mm.plugin.expt.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.h.a;
import com.tencent.mm.plugin.expt.h.d;
import com.tencent.mm.protocal.protobuf.ahm;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bt;
import java.util.LinkedList;
import java.util.List;

public final class b
{
  static String TAG = "MicroMsg.ExptIdMMKV";
  private static b qpw;
  ax cBy = null;
  private String name = null;
  
  public static ax bNe()
  {
    AppMethodBeat.i(210194);
    d.crP();
    int i = d.getUin();
    if (i == 0)
    {
      ad.e(TAG, "uin err [%d]", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(210194);
      return null;
    }
    ax localax = ax.aQz(i + "_WxExptIdmmkv");
    AppMethodBeat.o(210194);
    return localax;
  }
  
  public static b cmY()
  {
    AppMethodBeat.i(210193);
    if (qpw == null) {
      qpw = new b();
    }
    b localb = qpw;
    AppMethodBeat.o(210193);
    return localb;
  }
  
  public final List<ahm> cmZ()
  {
    AppMethodBeat.i(210195);
    LinkedList localLinkedList = new LinkedList();
    if (this.cBy != null)
    {
      String[] arrayOfString = this.cBy.allKeys();
      ad.i(TAG, "mmkv keys is [%s] ,length is [%d] ", new Object[] { arrayOfString.toString(), Integer.valueOf(arrayOfString.length) });
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        int i = 0;
        while (i < arrayOfString.length)
        {
          ahm localahm = new ahm();
          a locala = com.tencent.mm.plugin.expt.h.b.crz().DA(bt.getInt(arrayOfString[i], 0));
          if (locala != null)
          {
            localahm.GeZ = locala.rbx;
            localahm.Gfa = locala.adG;
            localahm.Gfb = locala.rby;
            localahm.count = this.cBy.decodeInt(arrayOfString[i]);
            localLinkedList.add(localahm);
          }
          i += 1;
        }
      }
    }
    AppMethodBeat.o(210195);
    return localLinkedList;
  }
  
  /* Error */
  final void cna()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 161
    //   4: invokestatic 34	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 25	com/tencent/mm/plugin/expt/a/b:cBy	Lcom/tencent/mm/sdk/platformtools/ax;
    //   11: ifnonnull +11 -> 22
    //   14: ldc 161
    //   16: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   19: aload_0
    //   20: monitorexit
    //   21: return
    //   22: aload_0
    //   23: getfield 25	com/tencent/mm/plugin/expt/a/b:cBy	Lcom/tencent/mm/sdk/platformtools/ax;
    //   26: invokevirtual 165	com/tencent/mm/sdk/platformtools/ax:clear	()Landroid/content/SharedPreferences$Editor;
    //   29: invokeinterface 171 1 0
    //   34: pop
    //   35: ldc 161
    //   37: invokestatic 61	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   40: goto -21 -> 19
    //   43: astore_1
    //   44: aload_0
    //   45: monitorexit
    //   46: aload_1
    //   47: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	this	b
    //   43	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	19	43	finally
    //   22	40	43	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.a.b
 * JD-Core Version:    0.7.0.1
 */