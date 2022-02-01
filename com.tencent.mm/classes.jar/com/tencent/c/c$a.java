package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract class c$a
{
  public static void a(BinaryMessenger paramBinaryMessenger, a parama)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FinderDataSource.getLatestFinders", c.b.ahhy).setMessageHandler(new c.a..ExternalSyntheticLambda1(parama));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.FinderDataSource.getImageFile", c.b.ahhy).setMessageHandler(new c.a..ExternalSyntheticLambda0(parama));
  }
  
  public abstract void a(c.c paramc, c.m<c.d> paramm);
  
  public abstract void a(c.e parame, c.m<c.l> paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.c.a
 * JD-Core Version:    0.7.0.1
 */