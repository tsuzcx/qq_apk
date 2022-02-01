package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ad;
import com.tencent.mm.plugin.appbrand.utils.ad.a;
import com.tencent.mm.plugin.appbrand.utils.ad.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.WXLivePusher;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView
  extends TXCloudVideoView
{
  public String cHp;
  public String cHq;
  public int cHv;
  ad lPK;
  private a lXH;
  m lXI;
  private ITXLivePushListener lXJ;
  private c lXK;
  private AppBrandLivePusherView.b lXL;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.cHv = 0;
    this.lXH = new a();
    this.cHp = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.cHv = 0;
    this.lXH = new a();
    this.cHp = "";
    init(paramContext);
    AppMethodBeat.o(145834);
  }
  
  private int getRotationAngle()
  {
    AppMethodBeat.i(145836);
    int i = ((WindowManager)getContext().getSystemService("window")).getDefaultDisplay().getRotation();
    AppMethodBeat.o(145836);
    return i;
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(145835);
    this.lXI = new m(paramContext);
    setBackgroundColor(-16777216);
    this.lPK = new ad(getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.cHH[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.lXM).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).cHJ = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.lXM).postDelayed(paramAnonymousa1, 250L);
          AppMethodBeat.o(145829);
          return;
          i = 1;
          continue;
          i = 0;
          continue;
          i = 2;
          continue;
          i = 3;
        }
      }
    });
    this.lPK.enable();
    xe(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  private boolean xe(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.cHv)
    {
      this.cHv = paramInt;
      Log.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.lXI.ib(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
  }
  
  public final void P(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    m localm = this.lXI;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      Log.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.errorInfo });
      AppMethodBeat.o(145838);
      return;
      m.l("updateLivePusher", paramBundle);
      if (!localm.mInited)
      {
        paramBundle = new i(-3, "uninited livePusher");
      }
      else
      {
        localm.a(paramBundle, false);
        String str = paramBundle.getString("pushUrl", localm.cHX);
        if ((str != null) && (!str.isEmpty()) && (localm.cHX != null) && (!localm.cHX.equalsIgnoreCase(str)) && (localm.cHV.isPushing()))
        {
          Log.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          localm.stopPreview();
          localm.cHV.stopAudioRecord();
          localm.cHV.stopPusher();
        }
        localm.cHX = str;
        localm.cHV.setPusherUrl(localm.cHX);
        localm.cIh = paramBundle.getBoolean("autopush", localm.cIh);
        if ((localm.cIh) && (localm.cHX != null) && (!localm.cHX.isEmpty()) && (!localm.cHV.isPushing()))
        {
          Log.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          localm.ca(localm.cIm);
          localm.cb(localm.cIn);
          localm.cHV.startPusher(localm.cHX);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    Log.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.lXL != null) {
      this.lXL.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final boolean j(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.lXI.l(paramString, paramJSONObject);
    Log.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.errorInfo });
    if (paramString.errorCode == 0)
    {
      AppMethodBeat.o(145839);
      return true;
    }
    AppMethodBeat.o(145839);
    return false;
  }
  
  protected void onConfigurationChanged(Configuration paramConfiguration)
  {
    AppMethodBeat.i(145832);
    super.onConfigurationChanged(paramConfiguration);
    xe(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    Object localObject = this.lXI;
    if (!((m)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      Log.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).errorInfo });
      if (this.lXK != null) {
        this.lXK.bGN();
      }
      AppMethodBeat.o(145840);
      return;
      ((m)localObject).cHV.stopBGM();
      ((m)localObject).stopPreview();
      ((m)localObject).cHV.stopAudioRecord();
      ((m)localObject).cHV.stopPusher();
      ((m)localObject).cHV.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.lXI.cIe = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.lXI.cId = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.lXL = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.lXK = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.lXJ = paramITXLivePushListener;
    this.lXI.cHW = this.lXJ;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.lXI.cIc = paramITXSnapshotListener;
  }
  
  final class a
    implements Runnable
  {
    int cHJ;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      Log.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.cHJ);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.cHJ)
      {
        AppBrandLivePusherView.a(AppBrandLivePusherView.this, i);
        AppMethodBeat.o(145831);
        return;
      }
      if (this.number < 8) {
        AppBrandLivePusherView.b(AppBrandLivePusherView.this).postDelayed(this, 250L);
      }
      AppMethodBeat.o(145831);
    }
  }
  
  public static abstract interface c
  {
    public abstract void bGN();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */