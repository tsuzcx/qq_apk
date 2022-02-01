package com.tencent.mm.modelsimple;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/modelsimple/ExtDeviceOpLogOpCode;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "kExtDeviceOpLogDefault", "kExtDeviceOpLogPushLoginUrlAutoLogin", "plugin-messenger_release"}, k=1, mv={1, 5, 1}, xi=48)
public enum c
{
  final int value;
  
  static
  {
    AppMethodBeat.i(236730);
    oRZ = new c("kExtDeviceOpLogDefault", 0, 0);
    oSa = new c("kExtDeviceOpLogPushLoginUrlAutoLogin", 1, 1);
    oSb = new c[] { oRZ, oSa };
    AppMethodBeat.o(236730);
  }
  
  private c(int paramInt)
  {
    this.value = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.modelsimple.c
 * JD-Core Version:    0.7.0.1
 */