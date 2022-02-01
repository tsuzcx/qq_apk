package com.tencent.mm.emoji.a.b;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.a.a;
import d.g.b.p;
import d.g.b.q;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "externalPanelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "groupDiffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "queueUpdate", "tempData", "addExternalGroup", "", "externalPanelProvider", "addGroup", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"})
public final class j
{
  public final LinkedList<n> gnA;
  private HashSet<String> gnB;
  boolean gnC;
  boolean gnD;
  final z gnE;
  final i gni;
  l gnx;
  l gny;
  c.b gnz;
  
  public j(i parami, z paramz)
  {
    AppMethodBeat.i(105556);
    this.gni = parami;
    this.gnE = paramz;
    this.gnx = new l();
    this.gny = new l();
    this.gnA = new LinkedList();
    this.gnB = new HashSet();
    AppMethodBeat.o(105556);
  }
  
  final void a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105555);
    int i = this.gny.gnJ.size();
    this.gny.gnJ.add(paramEmojiGroupInfo);
    this.gny.gnK.add(new ag(0, paramEmojiGroupInfo, i));
    AppMethodBeat.o(105555);
  }
  
  /* Error */
  public final void afG()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 140
    //   4: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 142	com/tencent/mm/emoji/a/b/j:gnC	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 144	com/tencent/mm/emoji/a/b/j:gnD	Z
    //   19: ldc 140
    //   21: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 150	com/tencent/mm/emoji/a/b/k:aeP	()Ljava/lang/String;
    //   30: ldc 152
    //   32: invokestatic 157	com/tencent/mm/sdk/platformtools/ae:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 142	com/tencent/mm/emoji/a/b/j:gnC	Z
    //   40: ldc 159
    //   42: new 12	com/tencent/mm/emoji/a/b/j$c
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 162	com/tencent/mm/emoji/a/b/j$c:<init>	(Lcom/tencent/mm/emoji/a/b/j;)V
    //   50: checkcast 164	d/g/a/a
    //   53: invokestatic 170	com/tencent/mm/ac/c:b	(Ljava/lang/String;Ld/g/a/a;)V
    //   56: ldc 140
    //   58: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   61: goto -37 -> 24
    //   64: astore_1
    //   65: aload_0
    //   66: monitorexit
    //   67: aload_1
    //   68: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	69	0	this	j
    //   64	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	64	finally
    //   27	61	64	finally
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class a
    extends c.a
  {
    public final int aA()
    {
      AppMethodBeat.i(105546);
      int i = this.gnF.gny.gnJ.size();
      AppMethodBeat.o(105546);
      return i;
    }
    
    public final int az()
    {
      AppMethodBeat.i(105545);
      int i = this.gnF.gnx.gnJ.size();
      AppMethodBeat.o(105545);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105547);
      Object localObject1 = this.gnF.gnx.gnJ.get(paramInt1);
      p.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = ((EmojiGroupInfo)localObject1).fxk();
      Object localObject2 = this.gnF.gny.gnJ.get(paramInt2);
      p.g(localObject2, "tempData.groupList[newItemPosition]");
      boolean bool = p.i(localObject1, ((EmojiGroupInfo)localObject2).fxk());
      AppMethodBeat.o(105547);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105548);
      Object localObject1 = this.gnF.gnx.gnJ.get(paramInt1);
      p.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = (EmojiGroupInfo)localObject1;
      Object localObject2 = this.gnF.gny.gnJ.get(paramInt2);
      p.g(localObject2, "tempData.groupList[newItemPosition]");
      localObject2 = (EmojiGroupInfo)localObject2;
      if ((p.i(((EmojiGroupInfo)localObject1).fxk(), ((EmojiGroupInfo)localObject2).fxk())) && (p.i(((EmojiGroupInfo)localObject1).aKn(), ((EmojiGroupInfo)localObject2).aKn())) && (p.i(((EmojiGroupInfo)localObject1).fxl(), ((EmojiGroupInfo)localObject2).fxl())))
      {
        AppMethodBeat.o(105548);
        return true;
      }
      AppMethodBeat.o(105548);
      return false;
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<d.z>
  {
    b(j paramj, l paraml)
    {
      super();
    }
  }
  
  @d.l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<d.z>
  {
    c(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.j
 * JD-Core Version:    0.7.0.1
 */