package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import java.util.LinkedList;
import java.util.List;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/EmojiPanelGroupData;", "Lcom/tencent/mm/emoji/model/panel/IEmojiPanelData;", "()V", "groupList", "Ljava/util/LinkedList;", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "getGroupList$plugin_emojisdk_release", "()Ljava/util/LinkedList;", "groupModels", "Lcom/tencent/mm/emoji/model/panel/PanelGroupModel;", "getGroupModels$plugin_emojisdk_release", "groupToTabOffset", "", "getGroupToTabOffset$plugin_emojisdk_release", "()I", "setGroupToTabOffset$plugin_emojisdk_release", "(I)V", "tabList", "Lcom/tencent/mm/emoji/model/panel/PanelTab;", "getTabList$plugin_emojisdk_release", "getGroupList", "", "getGroupModels", "getGroupTabList", "groupToTab", "groupIndex", "plugin-emojisdk_release"})
public final class l
  implements v
{
  final LinkedList<ab<?>> gYD;
  final LinkedList<EmojiGroupInfo> gYE;
  final LinkedList<ag> gYF;
  int gYG;
  
  public l()
  {
    AppMethodBeat.i(105557);
    this.gYD = new LinkedList();
    this.gYE = new LinkedList();
    this.gYF = new LinkedList();
    AppMethodBeat.o(105557);
  }
  
  public final List<EmojiGroupInfo> avv()
  {
    return (List)this.gYE;
  }
  
  public final List<ab<?>> avw()
  {
    return (List)this.gYD;
  }
  
  public final List<ag> avx()
  {
    return (List)this.gYF;
  }
  
  public final int pi(int paramInt)
  {
    return this.gYG + paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.l
 * JD-Core Version:    0.7.0.1
 */