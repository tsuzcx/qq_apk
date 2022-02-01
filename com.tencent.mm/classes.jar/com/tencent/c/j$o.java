package com.tencent.c;

import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;

public abstract class j$o
{
  public static void a(BinaryMessenger paramBinaryMessenger, o paramo)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchDoubleLinkSettings", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda5(paramo));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchSnsPost", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda2(paramo));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchUserProfile", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda0(paramo));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchFinderFeed", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda4(paramo));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchFileSelector", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda3(paramo));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.RouterPluginApi.launchFinderSelector", j.p.ahis).setMessageHandler(new j.o..ExternalSyntheticLambda1(paramo));
  }
  
  public abstract void a(j.i parami);
  
  public abstract void a(j.q paramq);
  
  public abstract void a(j.t paramt);
  
  public abstract void fvl();
  
  public abstract void fvm();
  
  public abstract void fvn();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.j.o
 * JD-Core Version:    0.7.0.1
 */