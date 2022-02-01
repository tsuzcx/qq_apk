package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.ak;
import com.tencent.mm.plugin.appbrand.utils.ak.a;
import com.tencent.mm.plugin.appbrand.utils.ak.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.rtmp.ITXLivePushListener;
import com.tencent.rtmp.TXLivePusher.ITXAudioVolumeEvaluationListener;
import com.tencent.rtmp.TXLivePusher.ITXSnapshotListener;
import com.tencent.rtmp.TXLivePusher.OnBGMNotify;
import com.tencent.rtmp.ui.TXCloudVideoView;
import java.util.HashMap;
import org.json.JSONObject;

public class AppBrandLivePusherView
  extends TXCloudVideoView
{
  public String eBs;
  public String eBt;
  private Handler mHandler;
  public int mLastAngle;
  ak rPZ;
  private a saR;
  b saS;
  private ITXLivePushListener saT;
  private c saU;
  private AppBrandLivePusherView.b saV;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.mLastAngle = 0;
    this.saR = new a();
    this.eBs = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.mLastAngle = 0;
    this.saR = new a();
    this.eBs = "";
    init(paramContext);
    AppMethodBeat.o(145834);
  }
  
  private boolean AN(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.mLastAngle)
    {
      this.mLastAngle = paramInt;
      Log.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.saS.notifyOrientationChanged(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
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
    this.saS = new r(paramContext, (byte)0);
    setBackgroundColor(-16777216);
    this.rPZ = new ak(getContext(), new ak.b()
    {
      public final void onFourOrientationsChange(ak.a paramAnonymousa1, ak.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.eBS[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.saW).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).eBU = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.saW).postDelayed(paramAnonymousa1, 250L);
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
    this.rPZ.enable();
    AN(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    Log.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.saV != null) {
      this.saV.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final void ab(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    paramBundle = this.saS.z(paramBundle);
    Log.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.errorInfo });
    AppMethodBeat.o(145838);
  }
  
  public final boolean k(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.saS.e(paramString, paramJSONObject);
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
    AN(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    k localk = this.saS.aup();
    Log.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(localk.errorCode), localk.errorInfo });
    if (this.saU != null) {
      this.saU.csB();
    }
    AppMethodBeat.o(145840);
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    AppMethodBeat.i(326236);
    this.saS.setAudioVolumeListener(paramITXAudioVolumeEvaluationListener);
    AppMethodBeat.o(326236);
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    AppMethodBeat.i(326233);
    this.saS.setBGMNotifyListener(paramOnBGMNotify);
    AppMethodBeat.o(326233);
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.saV = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.saU = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    AppMethodBeat.i(326226);
    this.saT = paramITXLivePushListener;
    this.saS.setPushListener(this.saT);
    AppMethodBeat.o(326226);
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    AppMethodBeat.i(326230);
    this.saS.setSnapshotListener(paramITXSnapshotListener);
    AppMethodBeat.o(326230);
  }
  
  final class a
    implements Runnable
  {
    int eBU;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      Log.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.eBU);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.eBU)
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
    public abstract void csB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */