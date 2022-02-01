package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class d$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterExptHost.get", d.b.ahhD).setMessageHandler(new d.a..ExternalSyntheticLambda0(parama));
  }
  
  public abstract d.d a(d.c paramc);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.d.a
 * JD-Core Version:    0.7.0.1
 */