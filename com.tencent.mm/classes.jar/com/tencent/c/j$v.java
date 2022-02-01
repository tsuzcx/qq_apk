package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.Arrays;

public final class j$v
{
  private final BinaryMessenger binaryMessenger;
  
  public j$v(BinaryMessenger paramBinaryMessenger)
  {
    this.binaryMessenger = paramBinaryMessenger;
  }
  
  public final void a(j.b paramb, a<Void> parama)
  {
    AppMethodBeat.i(229325);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onEvent", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.b[] { paramb })), new j.v..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(229325);
  }
  
  public final void a(j.c paramc, a<Void> parama)
  {
    AppMethodBeat.i(229321);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onModeChanged", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.c[] { paramc })), new j.v..ExternalSyntheticLambda7(parama));
    AppMethodBeat.o(229321);
  }
  
  public final void a(j.e parame, a<Void> parama)
  {
    AppMethodBeat.i(229318);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onConnected", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.e[] { parame })), new j.v..ExternalSyntheticLambda5(parama));
    AppMethodBeat.o(229318);
  }
  
  public final void a(j.f paramf, a<Void> parama)
  {
    AppMethodBeat.i(229315);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onRoomReady", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.f[] { paramf })), new j.v..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(229315);
  }
  
  public final void a(j.h paramh, a<Void> parama)
  {
    AppMethodBeat.i(229329);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onTextureInfoChanged", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.h[] { paramh })), new j.v..ExternalSyntheticLambda4(parama));
    AppMethodBeat.o(229329);
  }
  
  public final void a(j.n paramn, a<Void> parama)
  {
    AppMethodBeat.i(229327);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.responseRingtoneInfo", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.n[] { paramn })), new j.v..ExternalSyntheticLambda10(parama));
    AppMethodBeat.o(229327);
  }
  
  public final void a(a<Void> parama)
  {
    AppMethodBeat.i(229316);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onRespond", j.w.ahiy).send(null, new j.v..ExternalSyntheticLambda11(parama));
    AppMethodBeat.o(229316);
  }
  
  public final void b(j.c paramc, a<Void> parama)
  {
    AppMethodBeat.i(229323);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onScreenStateChanged", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.c[] { paramc })), new j.v..ExternalSyntheticLambda6(parama));
    AppMethodBeat.o(229323);
  }
  
  public final void b(j.e parame, a<Void> parama)
  {
    AppMethodBeat.i(229319);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onCompleted", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.e[] { parame })), new j.v..ExternalSyntheticLambda9(parama));
    AppMethodBeat.o(229319);
  }
  
  public final void b(a<Void> parama)
  {
    AppMethodBeat.i(229317);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onAccepted", j.w.ahiy).send(null, new j.v..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(229317);
  }
  
  public final void c(j.e parame, a<Void> parama)
  {
    AppMethodBeat.i(229320);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onError", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.e[] { parame })), new j.v..ExternalSyntheticLambda8(parama));
    AppMethodBeat.o(229320);
  }
  
  public final void d(j.e parame, a<Void> parama)
  {
    AppMethodBeat.i(229322);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.VoIPFlutterApi.onAudioOutputDeviceChanged", j.w.ahiy).send(new ArrayList(Arrays.asList(new j.e[] { parame })), new j.v..ExternalSyntheticLambda3(parama));
    AppMethodBeat.o(229322);
  }
  
  public static abstract interface a<T>
  {
    public abstract void reply(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.j.v
 * JD-Core Version:    0.7.0.1
 */