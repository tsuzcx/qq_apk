package com.tencent.mm.plugin.appbrand.jsapi.ac;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.e.h;
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.j;
import com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService.Stub;
import org.json.JSONObject;

public final class a$a
  implements ServiceConnection
{
  private int cqA;
  private Context mContext;
  private j psu;
  private boolean psv;
  private JSONObject psw;
  
  public a$a(a parama, Context paramContext, j paramj, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.mContext = paramContext;
    this.psu = paramj;
    this.cqA = paramInt;
    this.psv = paramBoolean;
    this.psw = paramJSONObject;
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(277689);
    paramComponentName = null;
    if (this.psv) {
      paramComponentName = com.huawei.b.a.a.a.a.j(paramIBinder);
    }
    while (paramComponentName == null)
    {
      AppMethodBeat.o(277689);
      return;
      if (!TextUtils.isEmpty(a.access$000())) {
        paramComponentName = ITencentSmartcardOpenService.Stub.asInterface(paramIBinder);
      }
    }
    h.ZvG.be(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(269056);
        a.a.this.psx.a(a.a.a(a.a.this), a.a.b(a.a.this), paramComponentName, a.a.c(a.a.this));
        a.a.d(a.a.this).unbindService(a.a.this);
        AppMethodBeat.o(269056);
      }
    });
    AppMethodBeat.o(277689);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.ac.a.a
 * JD-Core Version:    0.7.0.1
 */