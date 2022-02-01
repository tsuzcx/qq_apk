package com.tencent.mm.plugin.appbrand.report;

import android.content.Context;
import android.media.AudioManager;
import android.os.Looper;
import com.tencent.luggage.sdk.config.AppBrandInitConfigLU;
import com.tencent.luggage.sdk.d.c;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.b.b;
import com.tencent.mm.ak.b.c;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi;
import com.tencent.mm.ipcinvoker.wx_extension.IPCRunCgi.a;
import com.tencent.mm.plugin.appbrand.AppBrandRuntime;
import com.tencent.mm.plugin.appbrand.appcache.IPkgInfo;
import com.tencent.mm.plugin.appbrand.appcache.WxaPkgWrappingInfo;
import com.tencent.mm.plugin.appbrand.appstorage.ICommLibReader;
import com.tencent.mm.plugin.appbrand.config.k;
import com.tencent.mm.plugin.appbrand.o;
import com.tencent.mm.plugin.appbrand.q;
import com.tencent.mm.protocal.protobuf.bhm;
import com.tencent.mm.protocal.protobuf.bhn;
import com.tencent.mm.protocal.protobuf.eau;
import com.tencent.mm.protocal.protobuf.eav;
import com.tencent.mm.protocal.protobuf.eaw;
import com.tencent.mm.protocal.protobuf.eax;
import com.tencent.mm.protocal.protobuf.eaz;
import com.tencent.mm.protocal.protobuf.eba;
import com.tencent.mm.protocal.protobuf.ecm;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;

public final class b
{
  public ao jTB;
  public eau lQA;
  public eaz lQB;
  public eba lQC;
  public eax lQD;
  public ecm lQE;
  public eav lQz;
  
  public b()
  {
    AppMethodBeat.i(48014);
    this.lQz = null;
    this.lQA = null;
    this.lQB = null;
    this.lQC = null;
    this.lQD = null;
    this.lQE = null;
    this.jTB = new ao(Looper.getMainLooper());
    AppMethodBeat.o(48014);
  }
  
  public static abstract interface a
  {
    public abstract void dJ(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.report.b
 * JD-Core Version:    0.7.0.1
 */