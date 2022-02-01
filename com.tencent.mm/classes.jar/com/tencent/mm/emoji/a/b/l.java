package com.tencent.mm.emoji.a.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@d.l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l
  implements v
{
  final LinkedList<ab<?>> gnI;
  final LinkedList<EmojiGroupInfo> gnJ;
  final LinkedList<ag> gnK;
  int gnL;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.gnI = new LinkedList();
    this.gnJ = new LinkedList();
    this.gnK = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> afH()
  {
    return (List)this.gnJ;
  }
  
  public final List<ab<?>> afI()
  {
    return (List)this.gnI;
  }
  
  public final List<ag> afJ()
  {
    return (List)this.gnK;
  }
  
  public final int ma(int paramInt)
  {
    return this.gnL + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.a.b.l
 * JD-Core Version:    0.7.0.1
 */