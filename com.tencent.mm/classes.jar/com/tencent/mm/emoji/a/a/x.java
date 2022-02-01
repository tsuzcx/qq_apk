package com.tencent.mm.emoji.a.a;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.k;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", "listener", "updateData", "Companion", "plugin-emojisdk_release"})
public abstract class x<T extends s>
{
  public static final x.a fRZ = new x.a((byte)0);
  private final String TAG = "MicroMsg.PanelGroupModel";
  boolean fRW = true;
  boolean fRX;
  w fRY;
  
  public abstract void a(T paramT);
  
  public final void a(w paramw)
  {
    if (k.g(this.fRY, paramw)) {}
    do
    {
      return;
      this.fRY = paramw;
    } while (this.fRY == null);
    acO();
  }
  
  public abstract T acJ();
  
  public abstract T acL();
  
  /* Error */
  public final void acO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/mm/emoji/a/a/x:TAG	Ljava/lang/String;
    //   6: new 104	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 106
    //   12: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 85	com/tencent/mm/emoji/a/a/x:fRW	Z
    //   19: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: ldc 115
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 120	com/tencent/mm/emoji/a/a/x:fRX	Z
    //   31: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 130	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 120	com/tencent/mm/emoji/a/a/x:fRX	Z
    //   44: ifeq +11 -> 55
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 85	com/tencent/mm/emoji/a/a/x:fRW	Z
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 120	com/tencent/mm/emoji/a/a/x:fRX	Z
    //   60: ldc 132
    //   62: new 15	com/tencent/mm/emoji/a/a/x$d
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 135	com/tencent/mm/emoji/a/a/x$d:<init>	(Lcom/tencent/mm/emoji/a/a/x;)V
    //   70: checkcast 137	d/g/a/a
    //   73: invokestatic 143	com/tencent/mm/ac/c:b	(Ljava/lang/String;Ld/g/a/a;)V
    //   76: goto -24 -> 52
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	x
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	79	finally
    //   55	76	79	finally
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class b
    extends c.a
  {
    b(List paramList1, List paramList2) {}
    
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105565);
      boolean bool = k.g((y)this.fSa.get(paramInt1), (y)this.fSb.get(paramInt2));
      AppMethodBeat.o(105565);
      return bool;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105566);
      boolean bool = ((y)this.fSa.get(paramInt1)).aQ(this.fSb.get(paramInt2));
      AppMethodBeat.o(105566);
      return bool;
    }
    
    public final int gZ()
    {
      AppMethodBeat.i(105563);
      int i = this.fSa.size();
      AppMethodBeat.o(105563);
      return i;
    }
    
    public final int ha()
    {
      AppMethodBeat.i(105564);
      int i = this.fSb.size();
      AppMethodBeat.o(105564);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<d.y>
  {
    c(x paramx, s params, c.b paramb)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class d
    extends d.g.b.l
    implements a<d.y>
  {
    d(x paramx)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.x
 * JD-Core Version:    0.7.0.1
 */