package com.tencent.mm.plugin.emoji.ui.v3.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent;", "", "productId", "", "(Ljava/lang/String;)V", "getProductId", "()Ljava/lang/String;", "UpdateProgress", "UpdateRightView", "UpdateStatus", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent$UpdateProgress;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent$UpdateStatus;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent$UpdateRightView;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class f
{
  private final String productId;
  
  private f(String paramString)
  {
    this.productId = paramString;
  }
  
  public String getProductId()
  {
    return this.productId;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent$UpdateProgress;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent;", "productId", "", "progress", "", "(Ljava/lang/String;I)V", "getProductId", "()Ljava/lang/String;", "getProgress", "()I", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends f
  {
    private final String productId;
    final int progress;
    
    public a(String paramString, int paramInt)
    {
      super((byte)0);
      AppMethodBeat.i(270724);
      this.productId = paramString;
      this.progress = paramInt;
      AppMethodBeat.o(270724);
    }
    
    public final String getProductId()
    {
      return this.productId;
    }
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent$UpdateStatus;", "Lcom/tencent/mm/plugin/emoji/ui/v3/model/EmojiStoreV3EmotionHolderUpdateEvent;", "productId", "", "status", "", "(Ljava/lang/String;I)V", "getProductId", "()Ljava/lang/String;", "getStatus", "()I", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    extends f
  {
    private final String productId;
    final int status;
    
    public b(String paramString, int paramInt)
    {
      super((byte)0);
      AppMethodBeat.i(270725);
      this.productId = paramString;
      this.status = paramInt;
      AppMethodBeat.o(270725);
    }
    
    public final String getProductId()
    {
      return this.productId;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.a.f
 * JD-Core Version:    0.7.0.1
 */