package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class g$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    BasicMessageChannel localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterSendMusicToChatAction.sendMusicToChat", g.b.ahhK);
    if (parama != null) {
      localBasicMessageChannel.setMessageHandler(new g.a..ExternalSyntheticLambda0(parama));
    }
    for (;;)
    {
      paramBinaryMessenger = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FlutterSendMusicToChatAction.getChatUserName", g.b.ahhK);
      if (parama == null) {
        break;
      }
      paramBinaryMessenger.setMessageHandler(new g.a..ExternalSyntheticLambda1(parama));
      return;
      localBasicMessageChannel.setMessageHandler(null);
    }
    paramBinaryMessenger.setMessageHandler(null);
  }
  
  public abstract void a(g.c paramc);
  
  public abstract g.d gph();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.g.a
 * JD-Core Version:    0.7.0.1
 */