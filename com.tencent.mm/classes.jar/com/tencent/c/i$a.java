package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class i$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerCreate", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda8(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerInit", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda23(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetLoop", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda7(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpUpdateDisplaySize", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda17(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetMediaInfo", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda9(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetMediaProto", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda12(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlaySetScaleType", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda4(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetMute", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda16(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetStreamType", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda5(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerPrepare", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda19(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerPlay", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda0(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerPause", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda14(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSeek", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda15(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerSetPlayRange", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda11(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpPlayerGetPlayRange", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda6(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpStop", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda18(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpRelease", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda1(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpAddEffect", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda13(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpUpdateEffect", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda20(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpRemoveEffect", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda3(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpClearEffect", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda10(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpSetProgressListener", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda22(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpSetOnPreparedListener", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda2(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpSetOnFirstFrameRenderedListener", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda21(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.Api.tpGetVideoSize", i.b.ahhN).setMessageHandler(new i.a..ExternalSyntheticLambda24(parama));
  }
  
  public abstract i.c a(i.d paramd);
  
  public abstract i.c a(i.h paramh);
  
  public abstract i.c a(i.i parami);
  
  public abstract i.c a(i.j paramj);
  
  public abstract i.c a(i.k paramk);
  
  public abstract i.c a(i.l paraml);
  
  public abstract i.c a(i.m paramm);
  
  public abstract i.c a(i.n paramn);
  
  public abstract i.c a(i.o paramo);
  
  public abstract i.c a(i.p paramp);
  
  public abstract i.d a(i.e parame);
  
  public abstract i.c b(i.d paramd);
  
  public abstract i.c b(i.g paramg);
  
  public abstract i.c c(i.d paramd);
  
  public abstract i.c c(i.g paramg);
  
  public abstract i.c d(i.g paramg);
  
  public abstract i.f d(i.d paramd);
  
  public abstract i.c e(i.d paramd);
  
  public abstract i.c f(i.d paramd);
  
  public abstract i.d fvf();
  
  public abstract i.c g(i.d paramd);
  
  public abstract i.c h(i.d paramd);
  
  public abstract i.c i(i.d paramd);
  
  public abstract i.c j(i.d paramd);
  
  public abstract i.q k(i.d paramd);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.i.a
 * JD-Core Version:    0.7.0.1
 */