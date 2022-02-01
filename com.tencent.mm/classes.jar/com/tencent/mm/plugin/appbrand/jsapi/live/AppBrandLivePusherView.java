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
import com.tencent.mm.sdk.platformtools.ae;
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
  public String ctJ;
  public String ctK;
  public int ctP;
  ad kSB;
  private a kSC;
  m kSD;
  private ITXLivePushListener kSE;
  private c kSF;
  private AppBrandLivePusherView.b kSG;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ctP = 0;
    this.kSC = new a();
    this.ctJ = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ctP = 0;
    this.kSC = new a();
    this.ctJ = "";
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
    this.kSD = new m(paramContext);
    setBackgroundColor(-16777216);
    this.kSB = new ad(getContext(), new ad.b()
    {
      public final void a(ad.a paramAnonymousa1, ad.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.ctW[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.kSH).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).ctY = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.kSH).postDelayed(paramAnonymousa1, 250L);
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
    this.kSB.enable();
    ti(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  private boolean ti(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.ctP)
    {
      this.ctP = paramInt;
      ae.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.kSD.gL(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
  }
  
  public final void J(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    m localm = this.kSD;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      ae.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.csi });
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
        String str = paramBundle.getString("pushUrl", localm.cud);
        if ((str != null) && (!str.isEmpty()) && (localm.cud != null) && (!localm.cud.equalsIgnoreCase(str)) && (localm.cub.isPushing()))
        {
          ae.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          localm.stopPreview();
          localm.cub.stopAudioRecord();
          localm.cub.stopPusher();
        }
        localm.cud = str;
        localm.cub.setPusherUrl(localm.cud);
        localm.cun = paramBundle.getBoolean("autopush", localm.cun);
        if ((localm.cun) && (localm.cud != null) && (!localm.cud.isEmpty()) && (!localm.cub.isPushing()))
        {
          ae.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          localm.bB(localm.cut);
          localm.bC(localm.cuu);
          localm.cub.startPusher(localm.cud);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    ae.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.kSG != null) {
      this.kSG.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.kSD.i(paramString, paramJSONObject);
    ae.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.csi });
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
    ti(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    Object localObject = this.kSD;
    if (!((m)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      ae.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).csi });
      if (this.kSF != null) {
        this.kSF.blr();
      }
      AppMethodBeat.o(145840);
      return;
      ((m)localObject).cub.stopBGM();
      ((m)localObject).stopPreview();
      ((m)localObject).cub.stopAudioRecord();
      ((m)localObject).cub.stopPusher();
      ((m)localObject).cub.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.kSD.cuk = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.kSD.cuj = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.kSG = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.kSF = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.kSE = paramITXLivePushListener;
    this.kSD.cuc = this.kSE;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.kSD.cui = paramITXSnapshotListener;
  }
  
  final class a
    implements Runnable
  {
    int ctY;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      ae.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.ctY);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.ctY)
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
    public abstract void blr();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */