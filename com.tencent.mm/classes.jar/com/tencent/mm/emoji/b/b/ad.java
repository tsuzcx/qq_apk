package com.tencent.mm.emoji.b.b;

import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import androidx.recyclerview.widget.s;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.List;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.l;
import kotlin.x;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", "listener", "updateData", "Companion", "plugin-emojisdk_release"})
public abstract class ad<T extends y>
{
  public static final a jJS = new a((byte)0);
  private final String TAG = "MicroMsg.PanelGroupModel";
  boolean jJQ;
  ac jJR;
  boolean needUpdate = true;
  
  public final void a(ac paramac)
  {
    if (p.h(this.jJR, paramac)) {}
    do
    {
      return;
      this.jJR = paramac;
    } while (this.jJR == null);
    aCp();
  }
  
  public abstract void a(T paramT);
  
  public abstract T aCk();
  
  public abstract T aCm();
  
  /* Error */
  public final void aCp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 103	com/tencent/mm/emoji/b/b/ad:jJQ	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 85	com/tencent/mm/emoji/b/b/ad:needUpdate	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 88	com/tencent/mm/emoji/b/b/ad:jJR	Lcom/tencent/mm/emoji/b/b/ac;
    //   21: ifnull -7 -> 14
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 103	com/tencent/mm/emoji/b/b/ad:jJQ	Z
    //   29: ldc 105
    //   31: new 16	com/tencent/mm/emoji/b/b/ad$d
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 108	com/tencent/mm/emoji/b/b/ad$d:<init>	(Lcom/tencent/mm/emoji/b/b/ad;)V
    //   39: checkcast 110	kotlin/g/a/a
    //   42: invokestatic 116	com/tencent/mm/ae/d:b	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   45: goto -31 -> 14
    //   48: astore_1
    //   49: aload_0
    //   50: monitorexit
    //   51: aload_1
    //   52: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	53	0	this	ad
    //   48	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	14	48	finally
    //   17	45	48	finally
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel$Companion;", "", "()V", "createGroupModel", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "plugin-emojisdk_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/model/panel/PanelGroupModel$getDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class b
    extends h.a
  {
    b(List paramList1, List paramList2) {}
    
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105565);
      boolean bool = p.h((ae)this.jJT.get(paramInt1), (ae)this.jJU.get(paramInt2));
      AppMethodBeat.o(105565);
      return bool;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105566);
      boolean bool = ((ae)this.jJT.get(paramInt1)).ba(this.jJU.get(paramInt2));
      AppMethodBeat.o(105566);
      return bool;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(105563);
      int i = this.jJT.size();
      AppMethodBeat.o(105563);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(105564);
      int i = this.jJU.size();
      AppMethodBeat.o(105564);
      return i;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(ad paramad, y paramy, h.b paramb)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "invoke"})
  static final class d
    extends q
    implements a<x>
  {
    d(ad paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.ad
 * JD-Core Version:    0.7.0.1
 */