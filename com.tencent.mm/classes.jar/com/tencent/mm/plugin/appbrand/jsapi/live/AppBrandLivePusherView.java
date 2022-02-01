package com.tencent.mm.plugin.appbrand.jsapi.live;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.Display;
import android.view.WindowManager;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.appbrand.utils.z;
import com.tencent.mm.plugin.appbrand.utils.z.a;
import com.tencent.mm.plugin.appbrand.utils.z.b;
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
  public String clO;
  public String clP;
  public int clU;
  z jSL;
  private a jSM;
  m jSN;
  private ITXLivePushListener jSO;
  private c jSP;
  private AppBrandLivePusherView.b jSQ;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.clU = 0;
    this.jSM = new a();
    this.clO = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.clU = 0;
    this.jSM = new a();
    this.clO = "";
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
    this.jSN = new m(paramContext);
    setBackgroundColor(-16777216);
    this.jSL = new z(getContext(), new z.b()
    {
      public final void a(z.a paramAnonymousa1, z.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.cmb[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.jSR).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).cmd = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.jSR).postDelayed(paramAnonymousa1, 250L);
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
    this.jSL.enable();
    rN(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  private boolean rN(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.clU)
    {
      this.clU = paramInt;
      ad.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.jSN.gV(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
  }
  
  public final void H(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    m localm = this.jSN;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      ad.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.cko });
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
        String str = paramBundle.getString("pushUrl", localm.cmi);
        if ((str != null) && (!str.isEmpty()) && (localm.cmi != null) && (!localm.cmi.equalsIgnoreCase(str)) && (localm.cmg.isPushing()))
        {
          ad.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          localm.stopPreview();
          localm.cmg.stopAudioRecord();
          localm.cmg.stopPusher();
        }
        localm.cmi = str;
        localm.cmg.setPusherUrl(localm.cmi);
        localm.cms = paramBundle.getBoolean("autopush", localm.cms);
        if ((localm.cms) && (localm.cmi != null) && (!localm.cmi.isEmpty()) && (!localm.cmg.isPushing()))
        {
          ad.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          localm.bC(localm.cmy);
          localm.bD(localm.cmz);
          localm.cmg.startPusher(localm.cmi);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    ad.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.jSQ != null) {
      this.jSQ.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.jSN.i(paramString, paramJSONObject);
    ad.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.cko });
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
    rN(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    Object localObject = this.jSN;
    if (!((m)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      ad.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).cko });
      if (this.jSP != null) {
        this.jSP.baj();
      }
      AppMethodBeat.o(145840);
      return;
      ((m)localObject).cmg.stopBGM();
      ((m)localObject).stopPreview();
      ((m)localObject).cmg.stopAudioRecord();
      ((m)localObject).cmg.stopPusher();
      ((m)localObject).cmg.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.jSN.cmp = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.jSN.cmo = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(AppBrandLivePusherView.b paramb)
  {
    this.jSQ = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.jSP = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.jSO = paramITXLivePushListener;
    this.jSN.cmh = this.jSO;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.jSN.cmn = paramITXSnapshotListener;
  }
  
  final class a
    implements Runnable
  {
    int cmd;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      ad.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.cmd);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.cmd)
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
    public abstract void baj();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */