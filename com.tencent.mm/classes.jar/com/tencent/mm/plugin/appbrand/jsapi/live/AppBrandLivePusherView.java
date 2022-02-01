package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.aa;
import com.tencent.mm.plugin.appbrand.utils.aa.a;
import com.tencent.mm.plugin.appbrand.utils.aa.b;
import com.tencent.mm.sdk.platformtools.ad;
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
  public String ctf;
  public String ctg;
  public int ctl;
  aa kOT;
  private a kOU;
  m kOV;
  private ITXLivePushListener kOW;
  private c kOX;
  private AppBrandLivePusherView.b kOY;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ctl = 0;
    this.kOU = new a();
    this.ctf = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ctl = 0;
    this.kOU = new a();
    this.ctf = "";
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
    this.kOV = new m(paramContext);
    setBackgroundColor(-16777216);
    this.kOT = new aa(getContext(), new aa.b()
    {
      public final void a(aa.a paramAnonymousa1, aa.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.cts[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.kOZ).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).ctu = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.kOZ).postDelayed(paramAnonymousa1, 250L);
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
    this.kOT.enable();
    tf(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  private boolean tf(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.ctl)
    {
      this.ctl = paramInt;
      ad.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.kOV.gK(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
  }
  
  public final void I(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    m localm = this.kOV;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.crF });
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
        String str = paramBundle.getString("pushUrl", localm.ctA);
        if ((str != null) && (!str.isEmpty()) && (localm.ctA != null) && (!localm.ctA.equalsIgnoreCase(str)) && (localm.cty.isPushing()))
        {
          ad.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          localm.stopPreview();
          localm.cty.stopAudioRecord();
          localm.cty.stopPusher();
        }
        localm.ctA = str;
        localm.cty.setPusherUrl(localm.ctA);
        localm.ctK = paramBundle.getBoolean("autopush", localm.ctK);
        if ((localm.ctK) && (localm.ctA != null) && (!localm.ctA.isEmpty()) && (!localm.cty.isPushing()))
        {
          ad.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          localm.bB(localm.ctQ);
          localm.bC(localm.ctR);
          localm.cty.startPusher(localm.ctA);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    ad.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.kOY != null) {
      this.kOY.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.kOV.i(paramString, paramJSONObject);
    ad.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.crF });
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
    tf(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    Object localObject = this.kOV;
    if (!((m)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      ad.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).crF });
      if (this.kOX != null) {
        this.kOX.bkH();
      }
      AppMethodBeat.o(145840);
      return;
      ((m)localObject).cty.stopBGM();
      ((m)localObject).stopPreview();
      ((m)localObject).cty.stopAudioRecord();
      ((m)localObject).cty.stopPusher();
      ((m)localObject).cty.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.kOV.ctH = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.kOV.ctG = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.kOY = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.kOX = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.kOW = paramITXLivePushListener;
    this.kOV.ctz = this.kOW;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.kOV.ctF = paramITXSnapshotListener;
  }
  
  final class a
    implements Runnable
  {
    int ctu;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      ad.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.ctu);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.ctu)
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
    public abstract void bkH();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */