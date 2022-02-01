package com.tencent.mm.emoji.c.b;

import androidx.recyclerview.widget.g.a;
import androidx.recyclerview.widget.g.b;
import androidx.recyclerview.widget.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.HashSet;
import java.util.LinkedList;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.a;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelDataFactory;", "", "config", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "dataListener", "Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "(Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;Lcom/tencent/mm/emoji/model/panel/PanelDataListener;)V", "getConfig", "()Lcom/tencent/mm/emoji/model/panel/EmojiPanelConfig;", "data", "Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "getDataListener", "()Lcom/tencent/mm/emoji/model/panel/PanelDataListener;", "dataUpdating", "", "expandGroupList", "Ljava/util/HashSet;", "", "externalPanelList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/emoji/model/panel/ExternalPanelDataProvider;", "groupDiffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", "queueUpdate", "tabDiffResult", "tempData", "addExternalGroup", "", "externalPanelProvider", "addGroup", "group", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "isSvgIcon", "getDiff", "getTabDiff", "notifyDataDiff", "postUpdate", "resetTempData", "toggleExpandGroup", "groupId", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class j
{
  final ab miK;
  l miL;
  l miM;
  g.b miN;
  g.b miO;
  public final LinkedList<n> miP;
  private HashSet<String> miQ;
  boolean miR;
  boolean miS;
  final i mir;
  
  public j(i parami, ab paramab)
  {
    AppMethodBeat.i(105556);
    this.mir = parami;
    this.miK = paramab;
    this.miL = new l();
    this.miM = new l();
    this.miP = new LinkedList();
    this.miQ = new HashSet();
    AppMethodBeat.o(105556);
  }
  
  final void a(EmojiGroupInfo paramEmojiGroupInfo, boolean paramBoolean)
  {
    AppMethodBeat.i(242726);
    int j = this.miM.miW.size();
    this.miM.miW.add(paramEmojiGroupInfo);
    if (paramBoolean) {}
    for (int i = 1;; i = 0)
    {
      this.miM.miX.add(new ai(i, paramEmojiGroupInfo, j));
      AppMethodBeat.o(242726);
      return;
    }
  }
  
  /* Error */
  public final void aVl()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: ldc 150
    //   4: invokestatic 101	com/tencent/matrix/trace/core/AppMethodBeat:i	(I)V
    //   7: aload_0
    //   8: getfield 152	com/tencent/mm/emoji/c/b/j:miR	Z
    //   11: ifeq +16 -> 27
    //   14: aload_0
    //   15: iconst_1
    //   16: putfield 154	com/tencent/mm/emoji/c/b/j:miS	Z
    //   19: ldc 150
    //   21: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
    //   24: aload_0
    //   25: monitorexit
    //   26: return
    //   27: invokestatic 160	com/tencent/mm/emoji/c/b/k:aUw	()Ljava/lang/String;
    //   30: new 162	java/lang/StringBuilder
    //   33: dup
    //   34: ldc 164
    //   36: invokespecial 167	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   39: aload_0
    //   40: getfield 103	com/tencent/mm/emoji/c/b/j:mir	Lcom/tencent/mm/emoji/c/b/i;
    //   43: getfield 172	com/tencent/mm/emoji/c/b/i:miz	Z
    //   46: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   49: ldc 178
    //   51: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: aload_0
    //   55: getfield 103	com/tencent/mm/emoji/c/b/j:mir	Lcom/tencent/mm/emoji/c/b/i;
    //   58: getfield 184	com/tencent/mm/emoji/c/b/i:miA	Z
    //   61: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   64: ldc 178
    //   66: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   69: aload_0
    //   70: getfield 103	com/tencent/mm/emoji/c/b/j:mir	Lcom/tencent/mm/emoji/c/b/i;
    //   73: getfield 187	com/tencent/mm/emoji/c/b/i:miD	Z
    //   76: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   79: ldc 178
    //   81: invokevirtual 181	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: aload_0
    //   85: getfield 103	com/tencent/mm/emoji/c/b/j:mir	Lcom/tencent/mm/emoji/c/b/i;
    //   88: getfield 190	com/tencent/mm/emoji/c/b/i:miF	Z
    //   91: invokevirtual 176	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   94: invokevirtual 193	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   97: invokestatic 198	com/tencent/mm/sdk/platformtools/Log:i	(Ljava/lang/String;Ljava/lang/String;)V
    //   100: aload_0
    //   101: iconst_1
    //   102: putfield 152	com/tencent/mm/emoji/c/b/j:miR	Z
    //   105: ldc 200
    //   107: new 16	com/tencent/mm/emoji/c/b/j$d
    //   110: dup
    //   111: aload_0
    //   112: invokespecial 203	com/tencent/mm/emoji/c/b/j$d:<init>	(Lcom/tencent/mm/emoji/c/b/j;)V
    //   115: checkcast 205	kotlin/g/a/a
    //   118: invokestatic 211	com/tencent/mm/ae/d:d	(Ljava/lang/String;Lkotlin/g/a/a;)V
    //   121: ldc 150
    //   123: invokestatic 125	com/tencent/matrix/trace/core/AppMethodBeat:o	(I)V
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getDiff$groupDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends g.a
  {
    a(j paramj) {}
    
    public final int If()
    {
      AppMethodBeat.i(105545);
      int i = this.miT.miL.miW.size();
      AppMethodBeat.o(105545);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(105546);
      int i = this.miT.miM.miW.size();
      AppMethodBeat.o(105546);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105547);
      boolean bool = s.p(((EmojiGroupInfo)this.miT.miL.miW.get(paramInt1)).field_productID, ((EmojiGroupInfo)this.miT.miM.miW.get(paramInt2)).field_productID);
      AppMethodBeat.o(105547);
      return bool;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(105548);
      Object localObject1 = this.miT.miL.miW.get(paramInt1);
      s.s(localObject1, "data.groupList[oldItemPosition]");
      localObject1 = (EmojiGroupInfo)localObject1;
      Object localObject2 = this.miT.miM.miW.get(paramInt2);
      s.s(localObject2, "tempData.groupList[newItemPosition]");
      localObject2 = (EmojiGroupInfo)localObject2;
      if ((s.p(((EmojiGroupInfo)localObject1).field_productID, ((EmojiGroupInfo)localObject2).field_productID)) && (s.p(((EmojiGroupInfo)localObject1).field_packName, ((EmojiGroupInfo)localObject2).field_packName)) && (s.p(((EmojiGroupInfo)localObject1).field_packGrayIconUrl, ((EmojiGroupInfo)localObject2).field_packGrayIconUrl)))
      {
        AppMethodBeat.o(105548);
        return true;
      }
      AppMethodBeat.o(105548);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/emoji/model/panel/EmojiPanelDataFactory$getTabDiff$tabDiff$1", "Landroidx/recyclerview/widget/DiffUtil$Callback;", "areContentsTheSame", "", "oldItemPosition", "", "newItemPosition", "areItemsTheSame", "getNewListSize", "getOldListSize", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends g.a
  {
    b(j paramj) {}
    
    public final int If()
    {
      AppMethodBeat.i(242710);
      int i = this.miT.miL.miX.size();
      AppMethodBeat.o(242710);
      return i;
    }
    
    public final int Ig()
    {
      AppMethodBeat.i(242711);
      int i = this.miT.miM.miX.size();
      AppMethodBeat.o(242711);
      return i;
    }
    
    public final boolean aU(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242712);
      Object localObject1 = this.miT.miL.miX.get(paramInt1);
      s.s(localObject1, "data.tabList[oldItemPosition]");
      localObject1 = (ai)localObject1;
      Object localObject2 = this.miT.miM.miX.get(paramInt2);
      s.s(localObject2, "tempData.tabList[newItemPosition]");
      localObject2 = (ai)localObject2;
      if ((((ai)localObject1).type == ((ai)localObject2).type) && (s.p(((ai)localObject1).mgd.field_productID, ((ai)localObject2).mgd.field_productID)))
      {
        AppMethodBeat.o(242712);
        return true;
      }
      AppMethodBeat.o(242712);
      return false;
    }
    
    public final boolean aV(int paramInt1, int paramInt2)
    {
      AppMethodBeat.i(242713);
      Object localObject1 = this.miT.miL.miX.get(paramInt1);
      s.s(localObject1, "data.tabList[oldItemPosition]");
      localObject1 = (ai)localObject1;
      Object localObject2 = this.miT.miM.miX.get(paramInt2);
      s.s(localObject2, "tempData.tabList[newItemPosition]");
      localObject2 = (ai)localObject2;
      if ((aU(paramInt1, paramInt2)) && (s.p(((ai)localObject1).mgd.field_packGrayIconUrl, ((ai)localObject2).mgd.field_packGrayIconUrl)) && (((ai)localObject1).aoB == ((ai)localObject2).aoB))
      {
        AppMethodBeat.o(242713);
        return true;
      }
      AppMethodBeat.o(242713);
      return false;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements a<ah>
  {
    c(j paramj, l paraml)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements a<ah>
  {
    d(j paramj)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.j
 * JD-Core Version:    0.7.0.1
 */