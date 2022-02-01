package com.tencent.mm.plugin.m.a.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ac;
import d.l;
import io.flutter.plugin.a.k.d;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/luggage/natives/flutter/channel/ChannelService$ChannelCallback;", "Lio/flutter/plugin/common/MethodChannel$Result;", "methodName", "", "(Ljava/lang/String;)V", "error", "", "errorCode", "errorMessage", "p2", "", "notImplemented", "success", "p0", "luggage-native-view_release"})
final class a$a
  implements k.d
{
  private final String fXI;
  
  public a$a(String paramString)
  {
    AppMethodBeat.i(123812);
    this.fXI = paramString;
    AppMethodBeat.o(123812);
  }
  
  public final void daE()
  {
    AppMethodBeat.i(123809);
    ac.e("ChannelService", "!!!!NOTE:ChannelCallback notImplemented method:" + this.fXI);
    AppMethodBeat.o(123809);
  }
  
  public final void db(Object paramObject)
  {
    AppMethodBeat.i(123811);
    ac.i("ChannelService", "ChannelCallback success method:" + this.fXI);
    AppMethodBeat.o(123811);
  }
  
  public final void e(String paramString1, String paramString2, Object paramObject)
  {
    AppMethodBeat.i(123810);
    ac.i("ChannelService", "ChannelCallback method:" + this.fXI + " error %s  %s %s", new Object[] { paramString1, paramString2, String.valueOf(paramObject) });
    AppMethodBeat.o(123810);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.m.a.a.a.a.a
 * JD-Core Version:    0.7.0.1
 */