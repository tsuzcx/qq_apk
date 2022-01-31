package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.t.t;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView
  extends TXCloudVideoView
{
  public int bGH;
  private AppBrandLivePusherView.b hNA;
  t hNv;
  private AppBrandLivePusherView.a hNw;
  l hNx;
  private ITXLivePushListener hNy;
  private AppBrandLivePusherView.c hNz;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(96059);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.bGH = 0;
    this.hNw = new AppBrandLivePusherView.a(this);
    init(paramContext);
    AppMethodBeat.o(96059);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(96060);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.bGH = 0;
    this.hNw = new AppBrandLivePusherView.a(this);
    init(paramContext);
    AppMethodBeat.o(96060);
  }
  
  private int getRotationAngle()
  {
    AppMethodBeat.i(96062);
    int i = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    AppMethodBeat.o(96062);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(96061);
    this.hNx = new l(paramContext);
    setBackgroundColor(-16777216);
    this.hNv = new t(getContext(), new AppBrandLivePusherView.1(this));
    this.hNv.enable();
    od(getRotationAngle());
    AppMethodBeat.o(96061);
  }
  
  private boolean od(int paramInt)
  {
    AppMethodBeat.i(96063);
    if (paramInt != this.bGH)
    {
      this.bGH = paramInt;
      ab.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.hNx.fA(paramInt);
      AppMethodBeat.o(96063);
      return true;
    }
    AppMethodBeat.o(96063);
    return false;
  }
  
  public final void D(Bundle paramBundle)
  {
    AppMethodBeat.i(96064);
    l locall = this.hNx;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      ab.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.bFT });
      AppMethodBeat.o(96064);
      return;
      l.k("updateLivePusher", paramBundle);
      if (!locall.mInited)
      {
        paramBundle = new i(-3, "uninited livePusher");
      }
      else
      {
        locall.a(paramBundle, false);
        String str = paramBundle.getString("pushUrl", locall.bGS);
        if ((str != null) && (!str.isEmpty()) && (locall.bGS != null) && (!locall.bGS.equalsIgnoreCase(str)) && (locall.bGQ.isPushing()))
        {
          ab.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          locall.stopPreview();
          locall.bGQ.stopPusher();
        }
        locall.bGS = str;
        locall.bHb = paramBundle.getBoolean("autopush", locall.bHb);
        if ((locall.bHb) && (locall.bGS != null) && (!locall.bGS.isEmpty()) && (!locall.bGQ.isPushing()))
        {
          ab.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          locall.bg(locall.bHg);
          locall.bGQ.startPusher(locall.bGS);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(96067);
    ab.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.hNA != null) {
      this.hNA.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(96067);
  }
  
  public final boolean d(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(96065);
    paramString = this.hNx.e(paramString, paramJSONObject);
    ab.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.bFT });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(96065);
      return true;
    }
    AppMethodBeat.o(96065);
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(96058);
    super.onConfigurationChanged(paramConfiguration);
    od(getRotationAngle());
    AppMethodBeat.o(96058);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(96066);
    Object localObject = this.hNx;
    if (!((l)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      ab.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).bFT });
      if (this.hNz != null) {
        this.hNz.aDj();
      }
      AppMethodBeat.o(96066);
      return;
      ((l)localObject).bGQ.stopBGM();
      ((l)localObject).stopPreview();
      ((l)localObject).bGQ.stopPusher();
      ((l)localObject).bGQ.setPushListener(null);
      ((l)localObject).mInited = false;
    }
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.hNx.bGY = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.hNA = paramb;
  }
  
  public void setOnExitListener(AppBrandLivePusherView.c paramc)
  {
    this.hNz = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.hNy = paramITXLivePushListener;
    this.hNx.bGR = this.hNy;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.hNx.bGX = paramITXSnapshotListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */