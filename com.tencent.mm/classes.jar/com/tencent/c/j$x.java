package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class j$x
{
  public static void a(BinaryMessenger paramBinaryMessenger, x paramx)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.accept", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda32(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.hangUp", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda16(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.cancel", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda9(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.reject", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda30(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.minimize", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda18(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.switchCamera", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda15(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.switchToVoiceMode", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda1(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setMuted", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda22(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setSpeakerEnabled", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda40(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getTextureId", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda23(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.updateTextureSize", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda5(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.releaseTexture", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda0(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.prepareTextures", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda13(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getSmallStreamAspectRatio", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda24(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isCameraFloatable", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda26(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isFrontCamera", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda42(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getUserInfo", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda37(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getConnectedTime", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda14(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isCaller", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda4(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isVideoMode", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda3(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isMuted", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda17(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getAudioOutputDevice", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda41(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getStatus", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda6(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isScreenInteractive", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda11(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.onRendered", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda25(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.requestRingtoneInfo", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda33(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setRingtoneSelf", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda20(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.getRingStreamType", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda31(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.requestRingtoneMute", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda39(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.pauseRing", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda28(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.resumeRing", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda38(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.restartRing", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda2(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.reportFps", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda12(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.onBooted", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda34(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isSplitScreenSupported", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda27(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.toggleSplitScreen", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda7(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.isScreenSplited", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda35(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.queryGPURating", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda8(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setVideoVirtualBackground", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda36(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setImageVirtualBackground", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda19(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setSegmentVirtualBackground", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda10(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.setFinderVirtualBackground", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda21(paramx));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.VoIPPluginApi.clearVirtualBackground", j.y.ahiz).setMessageHandler(new j.x..ExternalSyntheticLambda29(paramx));
  }
  
  public abstract j.c a(j.a parama);
  
  public abstract j.e a(j.e parame);
  
  public abstract j.s a(j.g paramg);
  
  public abstract void a(j.c paramc);
  
  public abstract void a(j.g paramg, j.m<j.c> paramm);
  
  public abstract void a(j.j paramj);
  
  public abstract void a(j.k paramk);
  
  public abstract void a(j.l paraml, j.m<j.c> paramm);
  
  public abstract void a(j.m<j.c> paramm);
  
  public abstract void a(j.r paramr);
  
  public abstract void aDF(String paramString);
  
  public abstract void aDG(String paramString);
  
  public abstract void b(j.c paramc);
  
  public abstract void b(j.e parame);
  
  public abstract void b(j.g paramg);
  
  public abstract void c(j.c paramc);
  
  public abstract j.d d(j.c paramc);
  
  public abstract j.c fvA();
  
  public abstract void fvB();
  
  public abstract void fvC();
  
  public abstract j.e fvD();
  
  public abstract void fvE();
  
  public abstract void fvF();
  
  public abstract void fvG();
  
  public abstract j.c fvH();
  
  public abstract j.e fvI();
  
  public abstract j.c fvJ();
  
  public abstract j.c fvK();
  
  public abstract j.e fvL();
  
  public abstract j.e fvM();
  
  public abstract j.c fvN();
  
  public abstract void fvO();
  
  public abstract j.c fvP();
  
  public abstract j.c fvQ();
  
  public abstract Long fvR();
  
  public abstract void fvS();
  
  public abstract void fvo();
  
  public abstract void fvp();
  
  public abstract j.c fvw();
  
  public abstract j.c fvx();
  
  public abstract j.c fvy();
  
  public abstract j.c fvz();
  
  public abstract void j(Long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.j.x
 * JD-Core Version:    0.7.0.1
 */