package com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher;

import androidx.annotation.Keep;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "", "jsonVal", "", "(Ljava/lang/String;II)V", "getJsonVal", "()I", "DEFAULT_ACTION_LOOP", "FACE_ACTION_MOUTH_OPEN", "FACE_ACTION_MOUTH_KISS", "FACE_ACTION_LEFT_EYE_BLINK", "FACE_ACTION_RIGHT_EYE_BLINK", "FACE_ACTION_EYE_BLINK", "FACE_ACTION_EYEBROW_UP", "FACE_ACTION_HEAD_SHAKE", "FACE_ACTION_HEAD_NOD", "HAND_ACTION_HEART", "HAND_ACTION_PAPER", "HAND_ACTION_SCISSOR", "HAND_ACTION_FIST", "HAND_ACTION_ONE", "HAND_ACTION_LOVE", "HAND_ACTION_LIKE", "HAND_ACTION_OK", "HAND_ACTION_ROCK", "HAND_ACTION_SIX", "HAND_ACTION_EIGHT", "HAND_ACTION_LIFT", "HAND_ACTION_GOOD_FORTUNE", "Companion", "luggage-xweb-ext_release"})
@Keep
public enum StickerItemInfo$TriggerAction
{
  public static final a Companion;
  private final int jsonVal;
  
  static
  {
    AppMethodBeat.i(222688);
    TriggerAction localTriggerAction1 = new TriggerAction("DEFAULT_ACTION_LOOP", 0, -1);
    DEFAULT_ACTION_LOOP = localTriggerAction1;
    TriggerAction localTriggerAction2 = new TriggerAction("FACE_ACTION_MOUTH_OPEN", 1, 10);
    FACE_ACTION_MOUTH_OPEN = localTriggerAction2;
    TriggerAction localTriggerAction3 = new TriggerAction("FACE_ACTION_MOUTH_KISS", 2, 11);
    FACE_ACTION_MOUTH_KISS = localTriggerAction3;
    TriggerAction localTriggerAction4 = new TriggerAction("FACE_ACTION_LEFT_EYE_BLINK", 3, 12);
    FACE_ACTION_LEFT_EYE_BLINK = localTriggerAction4;
    TriggerAction localTriggerAction5 = new TriggerAction("FACE_ACTION_RIGHT_EYE_BLINK", 4, 13);
    FACE_ACTION_RIGHT_EYE_BLINK = localTriggerAction5;
    TriggerAction localTriggerAction6 = new TriggerAction("FACE_ACTION_EYE_BLINK", 5, 14);
    FACE_ACTION_EYE_BLINK = localTriggerAction6;
    TriggerAction localTriggerAction7 = new TriggerAction("FACE_ACTION_EYEBROW_UP", 6, 15);
    FACE_ACTION_EYEBROW_UP = localTriggerAction7;
    TriggerAction localTriggerAction8 = new TriggerAction("FACE_ACTION_HEAD_SHAKE", 7, 16);
    FACE_ACTION_HEAD_SHAKE = localTriggerAction8;
    TriggerAction localTriggerAction9 = new TriggerAction("FACE_ACTION_HEAD_NOD", 8, 17);
    FACE_ACTION_HEAD_NOD = localTriggerAction9;
    TriggerAction localTriggerAction10 = new TriggerAction("HAND_ACTION_HEART", 9, 100);
    HAND_ACTION_HEART = localTriggerAction10;
    TriggerAction localTriggerAction11 = new TriggerAction("HAND_ACTION_PAPER", 10, 101);
    HAND_ACTION_PAPER = localTriggerAction11;
    TriggerAction localTriggerAction12 = new TriggerAction("HAND_ACTION_SCISSOR", 11, 102);
    HAND_ACTION_SCISSOR = localTriggerAction12;
    TriggerAction localTriggerAction13 = new TriggerAction("HAND_ACTION_FIST", 12, 103);
    HAND_ACTION_FIST = localTriggerAction13;
    TriggerAction localTriggerAction14 = new TriggerAction("HAND_ACTION_ONE", 13, 104);
    HAND_ACTION_ONE = localTriggerAction14;
    TriggerAction localTriggerAction15 = new TriggerAction("HAND_ACTION_LOVE", 14, 105);
    HAND_ACTION_LOVE = localTriggerAction15;
    TriggerAction localTriggerAction16 = new TriggerAction("HAND_ACTION_LIKE", 15, 106);
    HAND_ACTION_LIKE = localTriggerAction16;
    TriggerAction localTriggerAction17 = new TriggerAction("HAND_ACTION_OK", 16, 107);
    HAND_ACTION_OK = localTriggerAction17;
    TriggerAction localTriggerAction18 = new TriggerAction("HAND_ACTION_ROCK", 17, 108);
    HAND_ACTION_ROCK = localTriggerAction18;
    TriggerAction localTriggerAction19 = new TriggerAction("HAND_ACTION_SIX", 18, 109);
    HAND_ACTION_SIX = localTriggerAction19;
    TriggerAction localTriggerAction20 = new TriggerAction("HAND_ACTION_EIGHT", 19, 110);
    HAND_ACTION_EIGHT = localTriggerAction20;
    TriggerAction localTriggerAction21 = new TriggerAction("HAND_ACTION_LIFT", 20, 111);
    HAND_ACTION_LIFT = localTriggerAction21;
    TriggerAction localTriggerAction22 = new TriggerAction("HAND_ACTION_GOOD_FORTUNE", 21, 112);
    HAND_ACTION_GOOD_FORTUNE = localTriggerAction22;
    $VALUES = new TriggerAction[] { localTriggerAction1, localTriggerAction2, localTriggerAction3, localTriggerAction4, localTriggerAction5, localTriggerAction6, localTriggerAction7, localTriggerAction8, localTriggerAction9, localTriggerAction10, localTriggerAction11, localTriggerAction12, localTriggerAction13, localTriggerAction14, localTriggerAction15, localTriggerAction16, localTriggerAction17, localTriggerAction18, localTriggerAction19, localTriggerAction20, localTriggerAction21, localTriggerAction22 };
    Companion = new a((byte)0);
    AppMethodBeat.o(222688);
  }
  
  private StickerItemInfo$TriggerAction(int paramInt)
  {
    this.jsonVal = paramInt;
  }
  
  public static final TriggerAction from(int paramInt)
  {
    AppMethodBeat.i(222695);
    TriggerAction localTriggerAction = a.from(paramInt);
    AppMethodBeat.o(222695);
    return localTriggerAction;
  }
  
  public final int getJsonVal()
  {
    return this.jsonVal;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction$Companion;", "", "()V", "from", "Lcom/tencent/luggage/xweb_ext/extendplugin/component/live/livepusher/StickerItemInfo$TriggerAction;", "actionInt", "", "luggage-xweb-ext_release"})
  public static final class a
  {
    public static StickerItemInfo.TriggerAction from(int paramInt)
    {
      AppMethodBeat.i(226801);
      StickerItemInfo.TriggerAction[] arrayOfTriggerAction = StickerItemInfo.TriggerAction.values();
      int k = arrayOfTriggerAction.length;
      int i = 0;
      while (i < k)
      {
        StickerItemInfo.TriggerAction localTriggerAction = arrayOfTriggerAction[i];
        if (paramInt == localTriggerAction.getJsonVal()) {}
        for (int j = 1; j != 0; j = 0)
        {
          AppMethodBeat.o(226801);
          return localTriggerAction;
        }
        i += 1;
      }
      AppMethodBeat.o(226801);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.luggage.xweb_ext.extendplugin.component.live.livepusher.StickerItemInfo.TriggerAction
 * JD-Core Version:    0.7.0.1
 */