package com.tencent.mm.plugin.appbrand.jsapi.s;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ipcinvoker.m;
import com.tencent.mm.ipcinvoker.type.IPCString;
import com.tencent.mm.ipcinvoker.type.IPCVoid;
import com.tencent.mm.plugin.appbrand.jsapi.c;
import com.tencent.mm.plugin.appbrand.page.ad;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicReference;

public final class d
  extends c<ad>
{
  private static final int CTRL_INDEX = 280;
  private static final String NAME = "getRegionData";
  private static final AtomicReference<String> pkY;
  
  static
  {
    AppMethodBeat.i(46749);
    pkY = new AtomicReference();
    AppMethodBeat.o(46749);
  }
  
  static final class a
    implements m<IPCVoid, IPCString>
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.s.d
 * JD-Core Version:    0.7.0.1
 */