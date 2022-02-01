package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract class b$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterCgiHost.send", b.b.ahhu).setMessageHandler(new b.a..ExternalSyntheticLambda0(parama));
  }
  
  public abstract void a(b.c paramc, b.e<b.d> parame);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.b.a
 * JD-Core Version:    0.7.0.1
 */