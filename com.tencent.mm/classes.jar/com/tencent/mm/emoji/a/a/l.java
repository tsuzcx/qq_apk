package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l
  implements r
{
  final LinkedList<x<?>> fOb;
  final LinkedList<EmojiGroupInfo> fOc;
  final LinkedList<ac> fOd;
  int fOe;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.fOb = new LinkedList();
    this.fOc = new LinkedList();
    this.fOd = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> abP()
  {
    return (List)this.fOc;
  }
  
  public final List<x<?>> abQ()
  {
    return (List)this.fOb;
  }
  
  public final List<ac> abR()
  {
    return (List)this.fOd;
  }
  
  public final int lD(int paramInt)
  {
    return this.fOe + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.l
 * JD-Core Version:    0.7.0.1
 */