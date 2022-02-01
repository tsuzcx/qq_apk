package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import android.support.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "BACKGROUND", "HUMAN_REGION", "Companion", "luggage-xweb-ext_release"})
@Keep
public enum StickerItemInfo$StickerBackType
{
  public static final a Companion;
  private final int jsonVal;
  
  static
  {
    AppMethodBeat.i(215973);
    StickerBackType localStickerBackType1 = new StickerBackType("BACKGROUND", 0, 0);
    BACKGROUND = localStickerBackType1;
    StickerBackType localStickerBackType2 = new StickerBackType("HUMAN_REGION", 1, 1);
    HUMAN_REGION = localStickerBackType2;
    $VALUES = new StickerBackType[] { localStickerBackType1, localStickerBackType2 };
    Companion = new a((byte)0);
    AppMethodBeat.o(215973);
  }
  
  private StickerItemInfo$StickerBackType(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final StickerBackType from(int paramInt)
  {
    AppMethodBeat.i(215976);
    StickerBackType[] arrayOfStickerBackType = values();
    int k = arrayOfStickerBackType.length;
    int i = 0;
    while (i < k)
    {
      StickerBackType localStickerBackType = arrayOfStickerBackType[i];
      if (paramInt == localStickerBackType.getJsonVal()) {}
      for (int j = 1; j != 0; j = 0)
      {
        AppMethodBeat.o(215976);
        return localStickerBackType;
      }
      i += 1;
    }
    AppMethodBeat.o(215976);
    return null;
  }
  
  public final int getJsonVal()
  {
    return this.jsonVal;
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$StickerBackType;", "typeInt", "", "luggage-xweb-ext_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.StickerBackType
 * JD-Core Version:    0.7.0.1
 */