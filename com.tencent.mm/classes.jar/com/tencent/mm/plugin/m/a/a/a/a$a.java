package com.tencent.mm.plugin.m.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ae;
import d.l;
import io.flutter.plugin.a.k.d;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$ChannelCallback;", "Lio/flutter/plugin/common/MethodChannel$Result;", "methodName", "", "(Ljava/lang/String;)V", "error", "", "errorCode", "errorMessage", "p2", "", "notImplemented", "success", "p0", "luggage-native-view_release"})
final class a$a
  implements k.d
{
  private final String gtE;
  
  public a$a(String paramString)
  {
    AppMethodBeat.i(123812);
    this.gtE = paramString;
    AppMethodBeat.o(123812);
  }
  
  public final void df(Object paramObject)
  {
    AppMethodBeat.i(123811);
    ae.i("ChannelService", "ChannelCallback success method:" + this.gtE);
    AppMethodBeat.o(123811);
  }
  
  public final void dmQ()
  {
    AppMethodBeat.i(123809);
    ae.e("ChannelService", "!!!!NOTE:ChannelCallback notImplemented method:" + this.gtE);
    AppMethodBeat.o(123809);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123810);
    ae.i("ChannelService", "ChannelCallback method:" + this.gtE + " error %s  %s %s", new Object[] { paramString1, paramString2, String.valueOf(paramObject) });
    AppMethodBeat.o(123810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */