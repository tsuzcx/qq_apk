package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.e.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.c;
import com.tencent.mm.am.c.a;
import com.tencent.mm.am.c.b;
import com.tencent.mm.am.c.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.n;
import com.tencent.mm.plugin.appbrand.w;
import com.tencent.mm.plugin.appbrand.y;
import com.tencent.mm.protocal.protobuf.cwy;
import com.tencent.mm.protocal.protobuf.cwz;
import com.tencent.mm.protocal.protobuf.glh;
import com.tencent.mm.protocal.protobuf.gli;
import com.tencent.mm.protocal.protobuf.glj;
import com.tencent.mm.protocal.protobuf.glk;
import com.tencent.mm.protocal.protobuf.gln;
import com.tencent.mm.protocal.protobuf.glo;
import com.tencent.mm.protocal.protobuf.gnm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  public MMHandler rtv;
  public gli tMT;
  public glh tMU;
  public gln tMV;
  public glo tMW;
  public glk tMX;
  public gnm tMY;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.tMT = null;
    this.tMU = null;
    this.tMV = null;
    this.tMW = null;
    this.tMX = null;
    this.tMY = null;
    this.rtv = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void fo(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */