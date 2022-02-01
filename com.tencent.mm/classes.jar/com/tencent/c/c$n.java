package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract class c$n
{
  public static void a(BinaryMessenger paramBinaryMessenger, n paramn)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.SnsDataSource.getLatestSns", c.o.ahhB).setMessageHandler(new c.n..ExternalSyntheticLambda1(paramn));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.SnsDataSource.getImageFile", c.o.ahhB).setMessageHandler(new c.n..ExternalSyntheticLambda0(paramn));
  }
  
  public abstract void a(c.f paramf, c.m<c.g> paramm);
  
  public abstract void a(c.h paramh, c.m<c.l> paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.c.n
 * JD-Core Version:    0.7.0.1
 */