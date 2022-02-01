package com.tencent.mm.plugin.appbrand.jsapi.af;

import android.content.ComponentName;
import android.content.Context;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.IInterface;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.jsapi.k;
import com.tencent.mm.sdk.trafficcard.ITencentSmartcardOpenService.Stub;
import com.tencent.threadpool.h;
import com.tencent.threadpool.i;
import org.json.JSONObject;

public final class a$a
  implements ServiceConnection
{
  private int eit;
  private Context mContext;
  private k sxG;
  private boolean sxH;
  private JSONObject sxI;
  
  public a$a(a parama, Context paramContext, k paramk, int paramInt, boolean paramBoolean, JSONObject paramJSONObject)
  {
    this.mContext = paramContext;
    this.sxG = paramk;
    this.eit = paramInt;
    this.sxH = paramBoolean;
    this.sxI = paramJSONObject;
  }
  
  public final void onServiceConnected(final ComponentName paramComponentName, IBinder paramIBinder)
  {
    AppMethodBeat.i(325912);
    paramComponentName = null;
    if (this.sxH) {
      paramComponentName = com.huawei.b.a.a.a.a.k(paramIBinder);
    }
    while (paramComponentName == null)
    {
      AppMethodBeat.o(325912);
      return;
      if (!TextUtils.isEmpty(a.access$000())) {
        paramComponentName = ITencentSmartcardOpenService.Stub.asInterface(paramIBinder);
      }
    }
    h.ahAA.bm(new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(325902);
        a.a.this.sxJ.a(a.a.a(a.a.this), a.a.b(a.a.this), paramComponentName, a.a.c(a.a.this));
        a.a.d(a.a.this).unbindService(a.a.this);
        AppMethodBeat.o(325902);
      }
    });
    AppMethodBeat.o(325912);
  }
  
  public final void onServiceDisconnected(ComponentName paramComponentName) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.af.a.a
 * JD-Core Version:    0.7.0.1
 */