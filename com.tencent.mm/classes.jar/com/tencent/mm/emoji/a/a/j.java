package com.tencent.mm.emoji.a.a;

import android.support.v7.h.c.a;
import android.support.v7.h.c.b;
import android.support.v7.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.a.a;
import d.g.b.k;
import d.y;
import java.util.HashSet;
import java.util.LinkedList;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "groupDiffResult", "Landroid/support/v7/util/DiffUtil$DiffResult;", "queueUpdate", "tempData", "addGroup", "", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"})
public final class j
{
  l fRC;
  l fRD;
  c.b fRE;
  private HashSet<String> fRF;
  boolean fRG;
  boolean fRH;
  final v fRI;
  final i fRn;
  
  public j(i parami, v paramv)
  {
    AppMethodBeat.i(105556);
    this.fRn = parami;
    this.fRI = paramv;
    this.fRC = new l();
    this.fRD = new l();
    this.fRF = new HashSet();
    AppMethodBeat.o(105556);
  }
  
  final void a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105555);
    int i = this.fRD.fRN.size();
    this.fRD.fRN.add(paramEmojiGroupInfo);
    this.fRD.fRO.add(new ac(0, paramEmojiGroupInfo, i));
    AppMethodBeat.o(105555);
  }
  
  /* Error */
  public final void acO()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 131
    //   4: invokestatic 84	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 133	com/tencent/mm/emoji/a/a/j:fRG	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 135	com/tencent/mm/emoji/a/a/j:fRH	Z
    //   19: ldc 131
    //   21: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 141	com/tencent/mm/emoji/a/a/k:abZ	()Ljava/lang/String;
    //   30: ldc 143
    //   32: invokestatic 148	com/tencent/mm/sdk/platformtools/ac:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   35: aload_0
    //   36: iconst_1
    //   37: putfield 133	com/tencent/mm/emoji/a/a/j:fRG	Z
    //   40: ldc 150
    //   42: new 12	com/tencent/mm/emoji/a/a/j$c
    //   45: dup
    //   46: aload_0
    //   47: invokespecial 153	com/tencent/mm/emoji/a/a/j$c:<init>	(Lcom/tencent/mm/emoji/a/a/j;)V
    //   50: checkcast 155	d/g/a/a
    //   53: invokestatic 161	com/tencent/mm/ac/c:b	(Ljava/lang/String;Ld/g/a/a;)V
    //   56: ldc 131
    //   58: invokestatic 103	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroid/support/v7/util/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class a
    extends c.a
  {
    public final boolean H(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105547);
      Object localObject1 = this.fRJ.fRC.fRN.get(paramInt1);
      k.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = ((EmojiGroupInfo)localObject1).fdm();
      Object localObject2 = this.fRJ.fRD.fRN.get(paramInt2);
      k.g(localObject2, "tempData.groupList[newItemPosition]");
      boolean bool = k.g(localObject1, ((EmojiGroupInfo)localObject2).fdm());
      AppMethodBeat.o(105547);
      return bool;
    }
    
    public final boolean I(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105548);
      Object localObject1 = this.fRJ.fRC.fRN.get(paramInt1);
      k.g(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = (EmojiGroupInfo)localObject1;
      Object localObject2 = this.fRJ.fRD.fRN.get(paramInt2);
      k.g(localObject2, "tempData.groupList[newItemPosition]");
      localObject2 = (EmojiGroupInfo)localObject2;
      if ((k.g(((EmojiGroupInfo)localObject1).fdm(), ((EmojiGroupInfo)localObject2).fdm())) && (k.g(((EmojiGroupInfo)localObject1).aGJ(), ((EmojiGroupInfo)localObject2).aGJ())) && (k.g(((EmojiGroupInfo)localObject1).fdn(), ((EmojiGroupInfo)localObject2).fdn())))
      {
        AppMethodBeat.o(105548);
        return true;
      }
      AppMethodBeat.o(105548);
      return false;
    }
    
    public final int gZ()
    {
      AppMethodBeat.i(105545);
      int i = this.fRJ.fRC.fRN.size();
      AppMethodBeat.o(105545);
      return i;
    }
    
    public final int ha()
    {
      AppMethodBeat.i(105546);
      int i = this.fRJ.fRD.fRN.size();
      AppMethodBeat.o(105546);
      return i;
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class b
    extends d.g.b.l
    implements a<y>
  {
    b(j paramj, l paraml)
    {
      super();
    }
  }
  
  @d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "invoke"})
  static final class c
    extends d.g.b.l
    implements a<y>
  {
    c(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.j
 * JD-Core Version:    0.7.0.1
 */