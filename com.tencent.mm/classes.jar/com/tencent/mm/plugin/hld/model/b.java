package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/model/IMESwitchCmdId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SwitchOpenOpen", "SwitchOpenClose", "SwitchT9Open", "SwitchT9Close", "SwitchKeyVoiceOpen", "SwitchKeyVoiceClose", "SwitchAgreeJoinPlanOpen", "SwitchAgreeJoinPlanClose", "SwitchAgreePrivacyItemOpen", "SwitchAgreePrivacyItemClose", "SwitchSetKeyboardMode", "SwitchSetKeyboardInputWay", "plugin-hld_release"})
public enum b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(211387);
    b localb1 = new b("SwitchOpenOpen", 0, 1);
    DBk = localb1;
    b localb2 = new b("SwitchOpenClose", 1, 2);
    DBl = localb2;
    b localb3 = new b("SwitchT9Open", 2, 3);
    DBm = localb3;
    b localb4 = new b("SwitchT9Close", 3, 4);
    DBn = localb4;
    b localb5 = new b("SwitchKeyVoiceOpen", 4, 5);
    DBo = localb5;
    b localb6 = new b("SwitchKeyVoiceClose", 5, 6);
    DBp = localb6;
    b localb7 = new b("SwitchAgreeJoinPlanOpen", 6, 7);
    DBq = localb7;
    b localb8 = new b("SwitchAgreeJoinPlanClose", 7, 8);
    DBr = localb8;
    b localb9 = new b("SwitchAgreePrivacyItemOpen", 8, 9);
    DBs = localb9;
    b localb10 = new b("SwitchAgreePrivacyItemClose", 9, 10);
    DBt = localb10;
    b localb11 = new b("SwitchSetKeyboardMode", 10, 11);
    DBu = localb11;
    b localb12 = new b("SwitchSetKeyboardInputWay", 11, 12);
    DBv = localb12;
    DBw = new b[] { localb1, localb2, localb3, localb4, localb5, localb6, localb7, localb8, localb9, localb10, localb11, localb12 };
    AppMethodBeat.o(211387);
  }
  
  private b(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.model.b
 * JD-Core Version:    0.7.0.1
 */