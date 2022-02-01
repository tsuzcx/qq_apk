package com.tencent.mm.emoji.b.b;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroid/support/v7/util/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", "listener", "updateData", "Companion", "plugin-emojisdk_release"})
public abstract class ab<T extends w>
{
  public static final ab.a gYS = new ab.a((byte)0);
  private final String TAG = "MicroMsg.PanelGroupModel";
  boolean gYQ;
  aa gYR;
  boolean needUpdate = true;
  
  public final void a(aa paramaa)
  {
    if (p.j(this.gYR, paramaa)) {}
    do
    {
      return;
      this.gYR = paramaa;
    } while (this.gYR == null);
    avu();
  }
  
  public abstract void a(T paramT);
  
  public abstract T avp();
  
  public abstract T avr();
  
  /* Error */
  public final void avu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	com/tencent/mm/emoji/b/b/ab:gYQ	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 84	com/tencent/mm/emoji/b/b/ab:needUpdate	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 88	com/tencent/mm/emoji/b/b/ab:gYR	Lcom/tencent/mm/emoji/b/b/aa;
    //   21: ifnull -7 -> 14
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 103	com/tencent/mm/emoji/b/b/ab:gYQ	Z
    //   29: ldc 105
    //   31: new 15	com/tencent/mm/emoji/b/b/ab$d
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 108	com/tencent/mm/emoji/b/b/ab$d:<init>	(Lcom/tencent/mm/emoji/b/b/ab;)V
    //   39: checkcast 110	kotlin/g/a/a
    //   42: invokestatic 116	com/tencent/mm/ac/d:b	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   45: goto -31 -> 14
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ab
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	48	finally
    //   17	45	48	finally
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class b
    extends c.a
  {
    b(List paramList1, List paramList2) {}
    
    public final int aB()
    {
      AppMethodBeat.i(105563);
      int i = this.gYT.size();
      AppMethodBeat.o(105563);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(105564);
      int i = this.gYU.size();
      AppMethodBeat.o(105564);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105565);
      boolean bool = p.j((ac)this.gYT.get(paramInt1), (ac)this.gYU.get(paramInt2));
      AppMethodBeat.o(105565);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105566);
      boolean bool = ((ac)this.gYT.get(paramInt1)).aZ(this.gYU.get(paramInt2));
      AppMethodBeat.o(105566);
      return bool;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ab paramab, w paramw, c.b paramb)
    {
      super();
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(ab paramab)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ab
 * JD-Core Version:    0.7.0.1
 */