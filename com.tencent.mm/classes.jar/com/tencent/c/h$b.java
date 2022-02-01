package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract class h$b
{
  public static void a(BinaryMessenger paramBinaryMessenger, b paramb)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.HostPageLaunch.launchAlbum", h.c.ahhM).setMessageHandler(new h.b..ExternalSyntheticLambda4(paramb));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.HostPageLaunch.getWeVisionVersion", h.c.ahhM).setMessageHandler(new h.b..ExternalSyntheticLambda3(paramb));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.HostPageLaunch.getMaasVersion", h.c.ahhM).setMessageHandler(new h.b..ExternalSyntheticLambda0(paramb));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.HostPageLaunch.reportTemplateListItemClicked", h.c.ahhM).setMessageHandler(new h.b..ExternalSyntheticLambda2(paramb));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.HostPageLaunch.reportTemplateListItemExposed", h.c.ahhM).setMessageHandler(new h.b..ExternalSyntheticLambda1(paramb));
  }
  
  public abstract void HT(String paramString);
  
  public abstract void HU(String paramString);
  
  public abstract void a(h.a parama, h.d<Boolean> paramd);
  
  public abstract Long byS();
  
  public abstract Long byT();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.h.b
 * JD-Core Version:    0.7.0.1
 */