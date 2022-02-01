package com.tencent.mm.plugin.hld.model;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/model/IMESwitchCmdId;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "SwitchOpenOpen", "SwitchOpenClose", "SwitchT9Open", "SwitchT9Close", "SwitchKeyVoiceOpen", "SwitchKeyVoiceClose", "SwitchAgreeJoinPlanOpen", "SwitchAgreeJoinPlanClose", "SwitchAgreePrivacyItemOpen", "SwitchAgreePrivacyItemClose", "SwitchSetKeyboardMode", "SwitchSetKeyboardInputWay", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum b
{
  public final int value;
  
  static
  {
    AppMethodBeat.i(311894);
    Juj = new b("SwitchOpenOpen", 0, 1);
    Juk = new b("SwitchOpenClose", 1, 2);
    Jul = new b("SwitchT9Open", 2, 3);
    Jum = new b("SwitchT9Close", 3, 4);
    Jun = new b("SwitchKeyVoiceOpen", 4, 5);
    Juo = new b("SwitchKeyVoiceClose", 5, 6);
    Jup = new b("SwitchAgreeJoinPlanOpen", 6, 7);
    Juq = new b("SwitchAgreeJoinPlanClose", 7, 8);
    Jur = new b("SwitchAgreePrivacyItemOpen", 8, 9);
    Jus = new b("SwitchAgreePrivacyItemClose", 9, 10);
    Jut = new b("SwitchSetKeyboardMode", 10, 11);
    Juu = new b("SwitchSetKeyboardInputWay", 11, 12);
    Juv = new b[] { Juj, Juk, Jul, Jum, Jun, Juo, Jup, Juq, Jur, Jus, Jut, Juu };
    AppMethodBeat.o(311894);
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