package com.tencent.luggage.sdk.launching;

import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.event.IEvent;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultLocalEvent;", "Lcom/tencent/mm/sdk/event/IEvent;", "()V", "action", "", "getAction", "()I", "setAction", "(I)V", "data", "Landroid/os/Parcelable;", "getData", "()Landroid/os/Parcelable;", "setData", "(Landroid/os/Parcelable;)V", "instance", "getInstance", "setInstance", "Companion", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
  extends IEvent
{
  public static final a etz;
  int action;
  Parcelable etA;
  int etw;
  
  static
  {
    AppMethodBeat.i(220543);
    etz = new a((byte)0);
    AppMethodBeat.o(220543);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/luggage/sdk/launching/OnWXAppResultLocalEvent$Companion;", "", "()V", "CALL", "", "RELEASE", "luggage-wechat-full-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.luggage.sdk.launching.c
 * JD-Core Version:    0.7.0.1
 */