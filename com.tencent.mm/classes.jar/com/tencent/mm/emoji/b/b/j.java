package com.tencent.mm.emoji.b.b;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "externalPanelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "groupDiffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "queueUpdate", "tempData", "addExternalGroup", "", "externalPanelProvider", "addGroup", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"})
public final class j
{
  final i gYa;
  l gYs;
  l gYt;
  c.b gYu;
  public final LinkedList<n> gYv;
  private HashSet<String> gYw;
  boolean gYx;
  boolean gYy;
  final z gYz;
  
  public j(i parami, z paramz)
  {
    AppMethodBeat.i(105556);
    this.gYa = parami;
    this.gYz = paramz;
    this.gYs = new l();
    this.gYt = new l();
    this.gYv = new LinkedList();
    this.gYw = new HashSet();
    AppMethodBeat.o(105556);
  }
  
  final void a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105555);
    int i = this.gYt.gYE.size();
    this.gYt.gYE.add(paramEmojiGroupInfo);
    this.gYt.gYF.add(new ag(0, paramEmojiGroupInfo, i));
    AppMethodBeat.o(105555);
  }
  
  /* Error */
  public final void avu()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 140
    //   4: invokestatic 91	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 142	com/tencent/mm/emoji/b/b/j:gYx	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 144	com/tencent/mm/emoji/b/b/j:gYy	Z
    //   19: ldc 140
    //   21: invokestatic 115	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 150	com/tencent/mm/emoji/b/b/k:auD	()Ljava/lang/String;
    //   30: ldc 152
    //   32: invokestatic 157	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 142	com/tencent/mm/emoji/b/b/j:gYx	Z
    //   40: ldc 159
    //   42: new 12	com/tencent/mm/emoji/b/b/j$c
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 162	com/tencent/mm/emoji/b/b/j$c:<init>	(Lcom/tencent/mm/emoji/b/b/j;)V
    //   50: checkcast 164	kotlin/g/a/a
    //   53: invokestatic 170	com/tencent/mm/ac/d:b	(Ljava/lang/String;Lkotlin/g/a/a;)V
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class a
    extends c.a
  {
    public final int aB()
    {
      AppMethodBeat.i(105545);
      int i = this.gYA.gYs.gYE.size();
      AppMethodBeat.o(105545);
      return i;
    }
    
    public final int aC()
    {
      AppMethodBeat.i(105546);
      int i = this.gYA.gYt.gYE.size();
      AppMethodBeat.o(105546);
      return i;
    }
    
    public final boolean i(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105547);
      Object localObject1 = this.gYA.gYs.gYE.get(paramInt1);
      p.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = ((EmojiGroupInfo)localObject1).hRu();
      Object localObject2 = this.gYA.gYt.gYE.get(paramInt2);
      p.g(localObject2, "tempData.groupList[newItemPosition]");
      boolean bool = p.j(localObject1, ((EmojiGroupInfo)localObject2).hRu());
      AppMethodBeat.o(105547);
      return bool;
    }
    
    public final boolean j(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105548);
      Object localObject1 = this.gYA.gYs.gYE.get(paramInt1);
      p.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = (EmojiGroupInfo)localObject1;
      Object localObject2 = this.gYA.gYt.gYE.get(paramInt2);
      p.g(localObject2, "tempData.groupList[newItemPosition]");
      localObject2 = (EmojiGroupInfo)localObject2;
      if ((p.j(((EmojiGroupInfo)localObject1).hRu(), ((EmojiGroupInfo)localObject2).hRu())) && (p.j(((EmojiGroupInfo)localObject1).beq(), ((EmojiGroupInfo)localObject2).beq())) && (p.j(((EmojiGroupInfo)localObject1).hRv(), ((EmojiGroupInfo)localObject2).hRv())))
      {
        AppMethodBeat.o(105548);
        return true;
      }
      AppMethodBeat.o(105548);
      return false;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(j paramj, l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "invoke"})
  static final class c
    extends q
    implements a<x>
  {
    c(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.j
 * JD-Core Version:    0.7.0.1
 */