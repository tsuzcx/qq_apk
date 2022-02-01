package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelsimple/PushLoginUrlAutoLoginSetting;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "kPushLoginUrlAutoLoginSettingDisabled", "kPushLoginUrlAutoLoginSettingEnabled", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum ak
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(236705);
    oTG = new ak("kPushLoginUrlAutoLoginSettingDisabled", 0, 0);
    oTH = new ak("kPushLoginUrlAutoLoginSettingEnabled", 1, 1);
    oTI = new ak[] { oTG, oTH };
    AppMethodBeat.o(236705);
  }
  
  private ak(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.modelsimple.ak
 * JD-Core Version:    0.7.0.1
 */