package com.tencent.mm.emoji.b.b;

import androidx.recyclerview.widget.h.a;
import androidx.recyclerview.widget.h.b;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.g.a.a;
import kotlin.g.b.p;
import kotlin.g.b.q;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "externalPanelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "groupDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "queueUpdate", "tempData", "addExternalGroup", "", "externalPanelProvider", "addGroup", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"})
public final class j
{
  final i jJa;
  l jJs;
  l jJt;
  h.b jJu;
  public final LinkedList<n> jJv;
  private HashSet<String> jJw;
  boolean jJx;
  boolean jJy;
  final ab jJz;
  
  public j(i parami, ab paramab)
  {
    AppMethodBeat.i(105556);
    this.jJa = parami;
    this.jJz = paramab;
    this.jJs = new l();
    this.jJt = new l();
    this.jJv = new LinkedList();
    this.jJw = new HashSet();
    AppMethodBeat.o(105556);
  }
  
  final void a(EmojiGroupInfo paramEmojiGroupInfo)
  {
    AppMethodBeat.i(105555);
    int i = this.jJt.jJE.size();
    this.jJt.jJE.add(paramEmojiGroupInfo);
    this.jJt.jJF.add(new ai(0, paramEmojiGroupInfo, i));
    AppMethodBeat.o(105555);
  }
  
  /* Error */
  public final void aCp()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 138
    //   4: invokestatic 89	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 140	com/tencent/mm/emoji/b/b/j:jJx	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 142	com/tencent/mm/emoji/b/b/j:jJy	Z
    //   19: ldc 138
    //   21: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 148	com/tencent/mm/emoji/b/b/k:aBy	()Ljava/lang/String;
    //   30: new 150	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 152
    //   36: invokespecial 155	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 91	com/tencent/mm/emoji/b/b/j:jJa	Lcom/tencent/mm/emoji/b/b/i;
    //   43: getfield 160	com/tencent/mm/emoji/b/b/i:jJg	Z
    //   46: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 166
    //   51: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 91	com/tencent/mm/emoji/b/b/j:jJa	Lcom/tencent/mm/emoji/b/b/i;
    //   58: getfield 172	com/tencent/mm/emoji/b/b/i:jJh	Z
    //   61: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: ldc 166
    //   66: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: getfield 91	com/tencent/mm/emoji/b/b/j:jJa	Lcom/tencent/mm/emoji/b/b/i;
    //   73: getfield 175	com/tencent/mm/emoji/b/b/i:jJk	Z
    //   76: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: ldc 166
    //   81: invokevirtual 169	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 91	com/tencent/mm/emoji/b/b/j:jJa	Lcom/tencent/mm/emoji/b/b/i;
    //   88: getfield 178	com/tencent/mm/emoji/b/b/i:jJm	Z
    //   91: invokevirtual 164	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: invokevirtual 181	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 186	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 140	com/tencent/mm/emoji/b/b/j:jJx	Z
    //   105: ldc 188
    //   107: new 10	com/tencent/mm/emoji/b/b/j$c
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 191	com/tencent/mm/emoji/b/b/j$c:<init>	(Lcom/tencent/mm/emoji/b/b/j;)V
    //   115: checkcast 193	kotlin/g/a/a
    //   118: invokestatic 199	com/tencent/mm/ae/d:b	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   121: ldc 138
    //   123: invokestatic 113	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   126: goto -102 -> 24
    //   129: astore_1
    //   130: aload_0
    //   131: monitorexit
    //   132: aload_1
    //   133: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	this	j
    //   129	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	24	129	finally
    //   27	126	129	finally
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"})
  public static final class a
    extends h.a
  {
    public final boolean Z(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105547);
      Object localObject1 = this.jJA.jJs.jJE.get(paramInt1);
      p.j(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = ((EmojiGroupInfo)localObject1).hBl();
      Object localObject2 = this.jJA.jJt.jJE.get(paramInt2);
      p.j(localObject2, "tempData.groupList[newItemPosition]");
      boolean bool = p.h(localObject1, ((EmojiGroupInfo)localObject2).hBl());
      AppMethodBeat.o(105547);
      return bool;
    }
    
    public final boolean ab(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105548);
      Object localObject1 = this.jJA.jJs.jJE.get(paramInt1);
      p.j(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = (EmojiGroupInfo)localObject1;
      Object localObject2 = this.jJA.jJt.jJE.get(paramInt2);
      p.j(localObject2, "tempData.groupList[newItemPosition]");
      localObject2 = (EmojiGroupInfo)localObject2;
      if ((p.h(((EmojiGroupInfo)localObject1).hBl(), ((EmojiGroupInfo)localObject2).hBl())) && (p.h(((EmojiGroupInfo)localObject1).bnP(), ((EmojiGroupInfo)localObject2).bnP())) && (p.h(((EmojiGroupInfo)localObject1).hBm(), ((EmojiGroupInfo)localObject2).hBm())))
      {
        AppMethodBeat.o(105548);
        return true;
      }
      AppMethodBeat.o(105548);
      return false;
    }
    
    public final int jL()
    {
      AppMethodBeat.i(105545);
      int i = this.jJA.jJs.jJE.size();
      AppMethodBeat.o(105545);
      return i;
    }
    
    public final int jM()
    {
      AppMethodBeat.i(105546);
      int i = this.jJA.jJt.jJE.size();
      AppMethodBeat.o(105546);
      return i;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends q
    implements a<x>
  {
    b(j paramj, l paraml)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.j
 * JD-Core Version:    0.7.0.1
 */