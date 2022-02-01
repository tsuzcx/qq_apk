package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.ArrayList;
import java.util.Arrays;

public final class f$c
{
  private final BinaryMessenger binaryMessenger;
  
  public f$c(BinaryMessenger paramBinaryMessenger)
  {
    this.binaryMessenger = paramBinaryMessenger;
  }
  
  public final void a(f.b paramb, a<Void> parama)
  {
    AppMethodBeat.i(229116);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.MusicCallbackApi.onPausePlay", f.d.ahhI).send(new ArrayList(Arrays.asList(new f.b[] { paramb })), new f.c..ExternalSyntheticLambda1(parama));
    AppMethodBeat.o(229116);
  }
  
  public final void a(a<Void> parama)
  {
    AppMethodBeat.i(229112);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.MusicCallbackApi.onStopPlay", f.d.ahhI).send(null, new f.c..ExternalSyntheticLambda0(parama));
    AppMethodBeat.o(229112);
  }
  
  public final void b(f.b paramb, a<Void> parama)
  {
    AppMethodBeat.i(229122);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.MusicCallbackApi.onStartPlay", f.d.ahhI).send(new ArrayList(Arrays.asList(new f.b[] { paramb })), new f.c..ExternalSyntheticLambda2(parama));
    AppMethodBeat.o(229122);
  }
  
  public final void c(f.b paramb, a<Void> parama)
  {
    AppMethodBeat.i(229126);
    new BasicMessageChannel(this.binaryMessenger, "dev.flutter.pigeon.MusicCallbackApi.onResumePlay", f.d.ahhI).send(new ArrayList(Arrays.asList(new f.b[] { paramb })), new f.c..ExternalSyntheticLambda3(parama));
    AppMethodBeat.o(229126);
  }
  
  public static abstract interface a<T>
  {
    public abstract void reply(T paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.f.c
 * JD-Core Version:    0.7.0.1
 */