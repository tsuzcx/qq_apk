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
import com.tencent.mm.sdk.platformtools.ac;
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
  public String ciQ;
  public String ciR;
  public int ciW;
  private ITXLivePushListener ktA;
  private c ktB;
  private b ktC;
  aa ktx;
  private a kty;
  m ktz;
  private Handler mHandler;
  
  public AppBrandLivePusherView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(145833);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ciW = 0;
    this.kty = new a();
    this.ciQ = "";
    init(paramContext);
    AppMethodBeat.o(145833);
  }
  
  public AppBrandLivePusherView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(145834);
    this.mHandler = new Handler(getContext().getMainLooper());
    this.ciW = 0;
    this.kty = new a();
    this.ciQ = "";
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
    this.ktz = new m(paramContext);
    setBackgroundColor(-16777216);
    this.ktx = new aa(getContext(), new aa.b()
    {
      public final void a(aa.a paramAnonymousa1, aa.a paramAnonymousa2)
      {
        AppMethodBeat.i(145829);
        int i;
        switch (AppBrandLivePusherView.2.cjd[paramAnonymousa2.ordinal()])
        {
        default: 
          i = 0;
        }
        for (;;)
        {
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          paramAnonymousa1.number = 0;
          AppBrandLivePusherView.b(paramAnonymousa1.ktD).removeCallbacks(paramAnonymousa1);
          AppBrandLivePusherView.a(AppBrandLivePusherView.this).cjf = i;
          paramAnonymousa1 = AppBrandLivePusherView.a(AppBrandLivePusherView.this);
          AppBrandLivePusherView.b(paramAnonymousa1.ktD).postDelayed(paramAnonymousa1, 250L);
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
    this.ktx.enable();
    sD(getRotationAngle());
    AppMethodBeat.o(145835);
  }
  
  private boolean sD(int paramInt)
  {
    AppMethodBeat.i(145837);
    if (paramInt != this.ciW)
    {
      this.ciW = paramInt;
      ac.i("MicroMsg.AppBrandLivePusherView", "orientation changed senorAngle = ".concat(String.valueOf(paramInt)));
      this.ktz.gF(paramInt);
      AppMethodBeat.o(145837);
      return true;
    }
    AppMethodBeat.o(145837);
    return false;
  }
  
  public final void H(Bundle paramBundle)
  {
    AppMethodBeat.i(145838);
    m localm = this.ktz;
    if (paramBundle == null) {
      paramBundle = new i(-1, "invalid params");
    }
    for (;;)
    {
      ac.i("MicroMsg.AppBrandLivePusherView", "onUpdate code:%d info:%s", new Object[] { Integer.valueOf(paramBundle.errorCode), paramBundle.chn });
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
        String str = paramBundle.getString("pushUrl", localm.cjk);
        if ((str != null) && (!str.isEmpty()) && (localm.cjk != null) && (!localm.cjk.equalsIgnoreCase(str)) && (localm.cji.isPushing()))
        {
          ac.i("TXLivePusherJSAdapter", "updateLivePusher: stopPusher");
          localm.stopPreview();
          localm.cji.stopAudioRecord();
          localm.cji.stopPusher();
        }
        localm.cjk = str;
        localm.cji.setPusherUrl(localm.cjk);
        localm.cju = paramBundle.getBoolean("autopush", localm.cju);
        if ((localm.cju) && (localm.cjk != null) && (!localm.cjk.isEmpty()) && (!localm.cji.isPushing()))
        {
          ac.i("TXLivePusherJSAdapter", "updateLivePusher: startPusher");
          localm.bB(localm.cjA);
          localm.bC(localm.cjB);
          localm.cji.startPusher(localm.cjk);
        }
        paramBundle = new i();
      }
    }
  }
  
  public final void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap)
  {
    AppMethodBeat.i(145841);
    ac.w("MicroMsg.AppBrandLivePusherView", "onError code:%d msg:%s", new Object[] { Integer.valueOf(paramInt), paramString });
    if (this.ktC != null) {
      this.ktC.a(paramInt, paramString, paramHashMap);
    }
    AppMethodBeat.o(145841);
  }
  
  public final boolean g(String paramString, JSONObject paramJSONObject)
  {
    AppMethodBeat.i(145839);
    paramString = this.ktz.i(paramString, paramJSONObject);
    ac.i("MicroMsg.AppBrandLivePusherView", "onOperate code:%d info:%s", new Object[] { Integer.valueOf(paramString.errorCode), paramString.chn });
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
    sD(getRotationAngle());
    AppMethodBeat.o(145832);
  }
  
  public final void onExit()
  {
    AppMethodBeat.i(145840);
    Object localObject = this.ktz;
    if (!((m)localObject).mInited) {}
    for (localObject = new i(-3, "uninited livePusher");; localObject = new i())
    {
      ac.i("MicroMsg.AppBrandLivePusherView", "onDestroy code:%d info:%s", new Object[] { Integer.valueOf(((i)localObject).errorCode), ((i)localObject).chn });
      if (this.ktB != null) {
        this.ktB.bhc();
      }
      AppMethodBeat.o(145840);
      return;
      ((m)localObject).cji.stopBGM();
      ((m)localObject).stopPreview();
      ((m)localObject).cji.stopAudioRecord();
      ((m)localObject).cji.stopPusher();
      ((m)localObject).cji.setPushListener(null);
      ((m)localObject).mInited = false;
    }
  }
  
  public void setAudioVolumeNotifyListener(TXLivePusher.ITXAudioVolumeEvaluationListener paramITXAudioVolumeEvaluationListener)
  {
    this.ktz.cjr = paramITXAudioVolumeEvaluationListener;
  }
  
  public void setBGMNotifyListener(TXLivePusher.OnBGMNotify paramOnBGMNotify)
  {
    this.ktz.cjq = paramOnBGMNotify;
  }
  
  public void setOnErrorListener(b paramb)
  {
    this.ktC = paramb;
  }
  
  public void setOnExitListener(c paramc)
  {
    this.ktB = paramc;
  }
  
  public void setOnPushEventListener(ITXLivePushListener paramITXLivePushListener)
  {
    this.ktA = paramITXLivePushListener;
    this.ktz.cjj = this.ktA;
  }
  
  public void setSnapshotListener(TXLivePusher.ITXSnapshotListener paramITXSnapshotListener)
  {
    this.ktz.cjp = paramITXSnapshotListener;
  }
  
  final class a
    implements Runnable
  {
    int cjf;
    int number = 0;
    
    a() {}
    
    public final void run()
    {
      AppMethodBeat.i(145831);
      this.number += 1;
      ac.i("MicroMsg.AppBrandLivePusherView", "[CheckRotateTask] number=" + this.number + "  senorAngle=" + this.cjf);
      int i = AppBrandLivePusherView.c(AppBrandLivePusherView.this);
      if (i == this.cjf)
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
  
  public static abstract interface b
  {
    public abstract void a(int paramInt, String paramString, HashMap<String, Object> paramHashMap);
  }
  
  public static abstract interface c
  {
    public abstract void bhc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.jsapi.live.AppBrandLivePusherView
 * JD-Core Version:    0.7.0.1
 */