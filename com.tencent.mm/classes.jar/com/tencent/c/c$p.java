package com.tencent.c;

import com.tencent.matrix.trace.core.AppMethodBeat;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BasicMessageChannel.Reply;
import io.flutter.plugin.common.BinaryMessenger;
import java.util.Map;

public abstract class c$p
{
  public static void a(BinaryMessenger paramBinaryMessenger, p paramp)
  {
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.TextStatusDataSource.getTextStatus", c.q.ahhC).setMessageHandler(new c.p..ExternalSyntheticLambda0(paramp));
    new BasicMessageChannel(paramBinaryMessenger, "dev.flutter.pigeon.TextStatusDataSource.getImageFile", c.q.ahhC).setMessageHandler(new c.p..ExternalSyntheticLambda1(paramp));
  }
  
  public abstract void a(c.i parami, c.m<c.j> paramm);
  
  public abstract void a(c.k paramk, c.m<c.l> paramm);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.c.c.p
 * JD-Core Version:    0.7.0.1
 */