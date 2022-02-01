package com.tencent.mm.plugin.m.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ad;
import d.l;
import io.flutter.plugin.a.k.d;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$ChannelCallback;", "Lio/flutter/plugin/common/MethodChannel$Result;", "methodName", "", "(Ljava/lang/String;)V", "error", "", "errorCode", "errorMessage", "p2", "", "notImplemented", "success", "p0", "luggage-native-view_release"})
final class a$a
  implements k.d
{
  private final String gre;
  
  public a$a(String paramString)
  {
    AppMethodBeat.i(123812);
    this.gre = paramString;
    AppMethodBeat.o(123812);
  }
  
  public final void de(Object paramObject)
  {
    AppMethodBeat.i(123811);
    ad.i("ChannelService", "ChannelCallback success method:" + this.gre);
    AppMethodBeat.o(123811);
  }
  
  public final void djR()
  {
    AppMethodBeat.i(123809);
    ad.e("ChannelService", "!!!!NOTE:ChannelCallback notImplemented method:" + this.gre);
    AppMethodBeat.o(123809);
  }
  
  public final void f(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123810);
    ad.i("ChannelService", "ChannelCallback method:" + this.gre + " error %s  %s %s", new Object[] { paramString1, paramString2, String.valueOf(paramObject) });
    AppMethodBeat.o(123810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */