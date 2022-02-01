package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class a$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    paramBinaryMessenger = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterAccountHost.getUin", a.b.ahhr);
    if (parama != null)
    {
      paramBinaryMessenger.setMessageHandler(new a.a..ExternalSyntheticLambda0(parama));
      return;
    }
    paramBinaryMessenger.setMessageHandler(null);
  }
  
  public abstract String getUin();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.c.a.a
 * JD-Core Version:    0.7.0.1
 */