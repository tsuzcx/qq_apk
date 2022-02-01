package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class f$e
{
  public static void a(BinaryMessenger paramBinaryMessenger, e parame)
  {
    BasicMessageChannel localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.getCurrentMusic", f.f.ahhJ);
    if (parame != null)
    {
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda7(parame));
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.play", f.f.ahhJ);
      if (parame == null) {
        break label249;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda6(parame));
      label60:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.pause", f.f.ahhJ);
      if (parame == null) {
        break label257;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda1(parame));
      label90:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.resume", f.f.ahhJ);
      if (parame == null) {
        break label265;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda0(parame));
      label120:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.stop", f.f.ahhJ);
      if (parame == null) {
        break label273;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda2(parame));
      label150:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.seek", f.f.ahhJ);
      if (parame == null) {
        break label281;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda4(parame));
      label180:
      localBasicMessageChannel = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.getCurrentPosition", f.f.ahhJ);
      if (parame == null) {
        break label289;
      }
      localBasicMessageChannel.setMessageHandler(new f.e..ExternalSyntheticLambda5(parame));
    }
    for (;;)
    {
      paramBinaryMessenger = new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.MusicPlayerApi.getDuration", f.f.ahhJ);
      if (parame == null) {
        break label297;
      }
      paramBinaryMessenger.setMessageHandler(new f.e..ExternalSyntheticLambda3(parame));
      return;
      localBasicMessageChannel.setMessageHandler(null);
      break;
      label249:
      localBasicMessageChannel.setMessageHandler(null);
      break label60;
      label257:
      localBasicMessageChannel.setMessageHandler(null);
      break label90;
      label265:
      localBasicMessageChannel.setMessageHandler(null);
      break label120;
      label273:
      localBasicMessageChannel.setMessageHandler(null);
      break label150;
      label281:
      localBasicMessageChannel.setMessageHandler(null);
      break label180;
      label289:
      localBasicMessageChannel.setMessageHandler(null);
    }
    label297:
    paramBinaryMessenger.setMessageHandler(null);
  }
  
  public abstract void a(f.a parama);
  
  public abstract void a(f.b paramb);
  
  public abstract f.b gpd();
  
  public abstract f.a gpe();
  
  public abstract f.a gpf();
  
  public abstract void pause();
  
  public abstract void resume();
  
  public abstract void stop();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.f.e
 * JD-Core Version:    0.7.0.1
 */