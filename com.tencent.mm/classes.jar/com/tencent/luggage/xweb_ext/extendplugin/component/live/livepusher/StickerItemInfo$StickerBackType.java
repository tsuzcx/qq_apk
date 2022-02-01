package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "BACKGROUND", "HUMAN_REGION", "Companion", "luggage-xweb-ext_release"})
@Keep
public enum StickerItemInfo$StickerBackType
{
  public static final a Companion;
  private final int jsonVal;
  
  static
  {
    AppMethodBeat.i(224661);
    StickerBackType localStickerBackType1 = new StickerBackType("BACKGROUND", 0, 0);
    BACKGROUND = localStickerBackType1;
    StickerBackType localStickerBackType2 = new StickerBackType("HUMAN_REGION", 1, 1);
    HUMAN_REGION = localStickerBackType2;
    $VALUES = new StickerBackType[] { localStickerBackType1, localStickerBackType2 };
    Companion = new a((byte)0);
    AppMethodBeat.o(224661);
  }
  
  private StickerItemInfo$StickerBackType(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final StickerBackType from(int paramInt)
  {
    AppMethodBeat.i(224665);
    StickerBackType localStickerBackType = a.from(paramInt);
    AppMethodBeat.o(224665);
    return localStickerBackType;
  }
  
  public final int getJsonVal()
  {
    return this.jsonVal;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "typeInt", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public static StickerItemInfo.StickerBackType from(int paramInt)
    {
      AppMethodBeat.i(225991);
      StickerItemInfo.StickerBackType[] arrayOfStickerBackType = StickerItemInfo.StickerBackType.values();
      int k = arrayOfStickerBackType.length;
      int i = 0;
      while (i < k)
      {
        StickerItemInfo.StickerBackType localStickerBackType = arrayOfStickerBackType[i];
        if (paramInt == localStickerBackType.getJsonVal()) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(225991);
          return localStickerBackType;
        }
        i += 1;
      }
      AppMethodBeat.o(225991);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType
 * JD-Core Version:    0.7.0.1
 */