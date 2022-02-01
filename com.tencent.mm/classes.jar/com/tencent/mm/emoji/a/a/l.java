package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@d.l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l
  implements v
{
  final LinkedList<ab<?>> gln;
  final LinkedList<EmojiGroupInfo> glo;
  final LinkedList<ag> glp;
  int glq;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.gln = new LinkedList();
    this.glo = new LinkedList();
    this.glp = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> aft()
  {
    return (List)this.glo;
  }
  
  public final List<ab<?>> afu()
  {
    return (List)this.gln;
  }
  
  public final List<ag> afv()
  {
    return (List)this.glp;
  }
  
  public final int lY(int paramInt)
  {
    return this.glq + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.l
 * JD-Core Version:    0.7.0.1
 */