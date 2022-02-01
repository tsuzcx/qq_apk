package com.tencent.mm.emoji.a.b;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import d.l;
import d.z;
import java.util.List;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", "listener", "updateData", "Companion", "plugin-emojisdk_release"})
public abstract class ab<T extends w>
{
  public static final ab.a gnY = new ab.a((byte)0);
  private final String TAG = "MicroMsg.PanelGroupModel";
  boolean gnV = true;
  boolean gnW;
  aa gnX;
  
  public final void a(aa paramaa)
  {
    if (p.i(this.gnX, paramaa)) {}
    do
    {
      return;
      this.gnX = paramaa;
    } while (this.gnX == null);
    afG();
  }
  
  public abstract void a(T paramT);
  
  public abstract T afB();
  
  public abstract T afD();
  
  /* Error */
  public final void afG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 83	com/tencent/mm/emoji/a/b/ab:TAG	Ljava/lang/String;
    //   6: new 104	java/lang/StringBuilder
    //   9: dup
    //   10: ldc 106
    //   12: invokespecial 109	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   15: aload_0
    //   16: getfield 85	com/tencent/mm/emoji/a/b/ab:gnV	Z
    //   19: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   22: ldc 115
    //   24: invokevirtual 118	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: aload_0
    //   28: getfield 120	com/tencent/mm/emoji/a/b/ab:gnW	Z
    //   31: invokevirtual 113	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   34: invokevirtual 124	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   37: invokestatic 129	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   40: aload_0
    //   41: getfield 120	com/tencent/mm/emoji/a/b/ab:gnW	Z
    //   44: ifeq +11 -> 55
    //   47: aload_0
    //   48: iconst_1
    //   49: putfield 85	com/tencent/mm/emoji/a/b/ab:gnV	Z
    //   52: aload_0
    //   53: monitorexit
    //   54: return
    //   55: aload_0
    //   56: iconst_1
    //   57: putfield 120	com/tencent/mm/emoji/a/b/ab:gnW	Z
    //   60: ldc 131
    //   62: new 15	com/tencent/mm/emoji/a/b/ab$d
    //   65: dup
    //   66: aload_0
    //   67: invokespecial 134	com/tencent/mm/emoji/a/b/ab$d:<init>	(Lcom/tencent/mm/emoji/a/b/ab;)V
    //   70: checkcast 136	d/g/a/a
    //   73: invokestatic 142	com/tencent/mm/ac/c:b	(Ljava/lang/String;Ld/g/a/a;)V
    //   76: goto -24 -> 52
    //   79: astore_1
    //   80: aload_0
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	84	0	this	ab
    //   79	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	52	79	finally
    //   55	76	79	finally
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class b
    extends c.a
  {
    b(List paramList1, List paramList2) {}
    
    public final int aA()
    {
      AppMethodBeat.i(105564);
      int i = this.goa.size();
      AppMethodBeat.o(105564);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(105563);
      int i = this.gnZ.size();
      AppMethodBeat.o(105563);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105565);
      boolean bool = p.i((ac)this.gnZ.get(paramInt1), (ac)this.goa.get(paramInt2));
      AppMethodBeat.o(105565);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105566);
      boolean bool = ((ac)this.gnZ.get(paramInt1)).aS(this.goa.get(paramInt2));
      AppMethodBeat.o(105566);
      return bool;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class c
    extends q
    implements a<z>
  {
    c(ab paramab, w paramw, c.b paramb)
    {
      super();
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class d
    extends q
    implements a<z>
  {
    d(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.ab
 * JD-Core Version:    0.7.0.1
 */