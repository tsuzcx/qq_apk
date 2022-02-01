package com.tencent.mm.plugin.emoji.ui.v3.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.anj;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductAlbumTypeItem;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/IEmojiStoreTypeItem;", "()V", "data", "", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/SingleProductTypeItem;", "getData", "()Ljava/util/List;", "setData", "(Ljava/util/List;)V", "id", "", "getId", "()I", "setId", "(I)V", "setInfo", "Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;", "getSetInfo", "()Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;", "setSetInfo", "(Lcom/tencent/mm/protocal/protobuf/EmotionBannerSet;)V", "snapCount", "getSnapCount", "setSnapCount", "getType", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class aa
  implements t
{
  public List<ac> bMf;
  public int id;
  public anj ycR;
  int ycS;
  
  public aa()
  {
    AppMethodBeat.i(270606);
    this.bMf = ((List)new ArrayList());
    this.ycS = 4;
    this.id = -1;
    AppMethodBeat.o(270606);
  }
  
  public final int getType()
  {
    return 3;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.aa
 * JD-Core Version:    0.7.0.1
 */