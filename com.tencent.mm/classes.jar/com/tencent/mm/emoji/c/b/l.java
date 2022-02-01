package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class l
  implements x
{
  final LinkedList<ad<?>> miV;
  final LinkedList<EmojiGroupInfo> miW;
  final LinkedList<ai> miX;
  int miY;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.miV = new LinkedList();
    this.miW = new LinkedList();
    this.miX = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> aVm()
  {
    return (List)this.miW;
  }
  
  public final List<ad<?>> aVn()
  {
    return (List)this.miV;
  }
  
  public final List<ai> aVo()
  {
    return (List)this.miX;
  }
  
  public final int rD(int paramInt)
  {
    return this.miY + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.l
 * JD-Core Version:    0.7.0.1
 */