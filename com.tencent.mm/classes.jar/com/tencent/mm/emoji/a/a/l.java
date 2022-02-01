package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@d.l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l
  implements r
{
  final LinkedList<x<?>> fRM;
  final LinkedList<EmojiGroupInfo> fRN;
  final LinkedList<ac> fRO;
  int fRP;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.fRM = new LinkedList();
    this.fRN = new LinkedList();
    this.fRO = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> acP()
  {
    return (List)this.fRN;
  }
  
  public final List<x<?>> acQ()
  {
    return (List)this.fRM;
  }
  
  public final List<ac> acR()
  {
    return (List)this.fRO;
  }
  
  public final int lz(int paramInt)
  {
    return this.fRP + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.l
 * JD-Core Version:    0.7.0.1
 */