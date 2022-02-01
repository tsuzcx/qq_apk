package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.d.a;
import com.tencent.mm.an.d.b;
import com.tencent.mm.an.d.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.l;
import com.tencent.mm.plugin.appbrand.t;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.protocal.protobuf.cgx;
import com.tencent.mm.protocal.protobuf.cgy;
import com.tencent.mm.protocal.protobuf.foi;
import com.tencent.mm.protocal.protobuf.foj;
import com.tencent.mm.protocal.protobuf.fok;
import com.tencent.mm.protocal.protobuf.fol;
import com.tencent.mm.protocal.protobuf.fon;
import com.tencent.mm.protocal.protobuf.foo;
import com.tencent.mm.protocal.protobuf.fqd;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;

public final class b
{
  public MMHandler opL;
  public foj qIn;
  public foi qIo;
  public fon qIp;
  public foo qIq;
  public fol qIr;
  public fqd qIs;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.qIn = null;
    this.qIo = null;
    this.qIp = null;
    this.qIq = null;
    this.qIr = null;
    this.qIs = null;
    this.opL = new MMHandler(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void ev(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */