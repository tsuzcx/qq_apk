package com.tencent.mm.emoji.c.b;

import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "", "()V", "TAG", "", "data", "getData", "()Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;", "setData", "(Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;)V", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;", "setDataListener", "(Lcom/tencent/mm/emoji/model/panel/PanelGroupDataListener;)V", "isUpdating", "", "()Z", "setUpdating", "(Z)V", "needUpdate", "getNeedUpdate", "setNeedUpdate", "createData", "getDiff", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "oldItemList", "", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "newItemList", "notifyDiff", "", "newData", "diff", "postUpdate", "setListener", "listener", "updateData", "Companion", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class ad<T extends y>
{
  public static final ad.a mji = new ad.a((byte)0);
  private final String TAG = "MicroMsg.PanelGroupModel";
  boolean mjj;
  ac mjk;
  boolean needUpdate = true;
  
  public final void a(ac paramac)
  {
    if (s.p(this.mjk, paramac)) {}
    do
    {
      return;
      this.mjk = paramac;
    } while (this.mjk == null);
    aVl();
  }
  
  public abstract void a(T paramT);
  
  public abstract T aVh();
  
  public abstract T aVi();
  
  /* Error */
  public final void aVl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 104	com/tencent/mm/emoji/c/b/ad:mjj	Z
    //   6: ifeq +11 -> 17
    //   9: aload_0
    //   10: iconst_1
    //   11: putfield 85	com/tencent/mm/emoji/c/b/ad:needUpdate	Z
    //   14: aload_0
    //   15: monitorexit
    //   16: return
    //   17: aload_0
    //   18: getfield 89	com/tencent/mm/emoji/c/b/ad:mjk	Lcom/tencent/mm/emoji/c/b/ac;
    //   21: ifnull -7 -> 14
    //   24: aload_0
    //   25: iconst_1
    //   26: putfield 104	com/tencent/mm/emoji/c/b/ad:mjj	Z
    //   29: ldc 106
    //   31: new 13	com/tencent/mm/emoji/c/b/ad$d
    //   34: dup
    //   35: aload_0
    //   36: invokespecial 109	com/tencent/mm/emoji/c/b/ad$d:<init>	(Lcom/tencent/mm/emoji/c/b/ad;)V
    //   39: checkcast 111	kotlin/g/a/a
    //   42: invokestatic 117	com/tencent/mm/ae/d:d	(Ljava/lang/String;Lkotlin/g/a/a;)V
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
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(ad<T> paramad, y paramy, g.b paramb)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "T", "Lcom/tencent/mm/emoji/model/panel/IPanelItemGroup;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(ad<T> paramad)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.ad
 * JD-Core Version:    0.7.0.1
 */