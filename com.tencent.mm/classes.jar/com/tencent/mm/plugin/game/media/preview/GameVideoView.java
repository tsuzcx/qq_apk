package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.d;
import com.tencent.mm.model.d.a;
import com.tencent.mm.modelvideo.MMVideoView;
import com.tencent.mm.plugin.game.commlib.e.c;
import com.tencent.mm.plugin.game.commlib.e.c.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.FilePathGenerator;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.vfs.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements i
{
  private static Set<String> CHC;
  private com.tencent.mm.pluginsdk.ui.h CHA;
  private a CHB;
  a CHD;
  i.a CHE;
  i.c CHF;
  d.a CHG;
  i.b CHH;
  private i CHu;
  private i.e CHv;
  private float CHw;
  private int CHx;
  private boolean CHy;
  private int CHz;
  private boolean jzL;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  private d sUi;
  
  static
  {
    AppMethodBeat.i(41327);
    CHC = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.CHv = i.e.RcG;
    this.mMute = false;
    this.CHw = -1.0F;
    this.CHz = 0;
    this.CHE = new i.a()
    {
      public final void aR(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          u.on(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.exQ().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.CHF = new i.c()
    {
      public final void EW(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void KP(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.CHG = new d.a()
    {
      public final void bcu() {}
      
      public final void bcv() {}
      
      public final void bcw() {}
      
      public final void bcx() {}
    };
    this.CHH = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        Log.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).qX();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.a(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).fZ(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.CHG);
        AppMethodBeat.o(41290);
      }
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void fC(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.CHv = i.e.RcG;
    this.mMute = false;
    this.CHw = -1.0F;
    this.CHz = 0;
    this.CHE = new i.a()
    {
      public final void aR(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          u.on(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.exQ().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.CHF = new i.c()
    {
      public final void EW(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.IzE.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void KP(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.IzE.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.CHG = new d.a()
    {
      public final void bcu() {}
      
      public final void bcv() {}
      
      public final void bcw() {}
      
      public final void bcx() {}
    };
    this.CHH = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        Log.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void dS(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).qX();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dT(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.a(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dU(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).fZ(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dV(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.CHG);
        AppMethodBeat.o(41290);
      }
      
      public final void dW(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dX(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void fC(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String aJQ(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String aJR(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private i exM()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.hjs();
    localCommonVideoView.setReporter(this.CHF);
    localCommonVideoView.setIMMVideoViewCallback(this.CHH);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private i exN()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.CHF);
    localGameMMVideoView.setIMMVideoViewCallback(this.CHH);
    localGameMMVideoView.setIMMDownloadFinish(this.CHE);
    String str = getRootPath();
    FilePathGenerator.checkMkdir(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.CHD = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.CHD);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void exO()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = CHC.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(u.deleteFile(str)), str });
    }
    CHC.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean exP()
  {
    return (this.jzL) || (this.CHy);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = c.c(c.a.Czw) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.sUi = d.bcs();
    AppMethodBeat.o(41293);
  }
  
  public final boolean a(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.CHu != null)
    {
      paramBoolean = this.CHu.a(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.CHw = paramFloat;
    if (this.CHu != null)
    {
      boolean bool = this.CHu.aO(paramFloat);
      AppMethodBeat.o(41326);
      return bool;
    }
    AppMethodBeat.o(41326);
    return false;
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(41297);
    this.CHx = paramInt;
    this.jzL = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!Util.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.CHy = paramBoolean;
        if (this.CHy) {
          break label304;
        }
        localObject = aJR(paramString);
        if (!u.agG((String)localObject)) {
          break label304;
        }
        u.deleteFile(aJQ(paramString));
        this.CHy = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.CHu != null) {
          break label342;
        }
        if (!exP()) {
          break label312;
        }
        Log.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.CHu = exM();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.CHv);
      aO(this.CHw);
      setMute(this.mMute);
      if (paramInt != 0)
      {
        setVideoFooterView(this.CHA);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.CHu, paramString);
      }
      this.CHu.c(this.jzL, this.mUrl, this.CHx);
      if ((this.CHu instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.CHu).setFilepath(aJQ(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (u.agG(((PString)localObject).value))
      {
        paramBoolean = true;
        break;
      }
      paramBoolean = false;
      break;
      label304:
      this.mUrl = paramString;
      break label121;
      label312:
      Log.i("MicroMsg.Haowan.GameVideoView", "new use mm video view! path:%s", new Object[] { paramString });
      this.CHu = exN();
      paramInt = i;
      continue;
      label342:
      if (exP())
      {
        if ((this.CHu instanceof MMVideoView))
        {
          this.CHu.stop();
          this.CHu.egX();
          removeView((View)this.CHu);
          Log.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.CHu = exM();
          paramInt = i;
        }
        else
        {
          Log.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.CHu.stop();
          paramInt = 0;
        }
      }
      else if ((this.CHu instanceof CommonVideoView))
      {
        this.CHu.stop();
        this.CHu.egX();
        removeView((View)this.CHu);
        Log.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.CHu = exN();
        paramInt = i;
      }
      else
      {
        Log.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.CHu.stop();
        paramInt = 0;
      }
    }
  }
  
  public final void egX()
  {
    AppMethodBeat.i(41317);
    if (this.CHu != null) {
      this.CHu.egX();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.CHu != null)
    {
      int i = this.CHu.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.CHu != null)
    {
      int i = this.CHu.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.CHu != null)
    {
      int i = this.CHu.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.CHu instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.CHu).getFilePath();
      AppMethodBeat.o(41294);
      return str;
    }
    String str = this.mUrl;
    AppMethodBeat.o(41294);
    return str;
  }
  
  public String getLocalPath()
  {
    AppMethodBeat.i(41296);
    if (this.CHy)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = aJR(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.CHu instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.CHu).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.CHu != null)
    {
      int i = this.CHu.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.CHu != null)
    {
      i = this.CHu.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.CHx;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(41314);
    if (this.CHu != null)
    {
      boolean bool = this.CHu.isLive();
      AppMethodBeat.o(41314);
      return bool;
    }
    AppMethodBeat.o(41314);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.CHu != null)
    {
      boolean bool = this.CHu.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.CHu != null) {
      this.CHu.onUIDestroy();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.CHu != null)
    {
      this.CHz = this.CHu.getCurrPosSec();
      this.CHu.onUIPause();
    }
    this.sUi.fZ(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.CHu instanceof GameMMVideoView)) {
      if (u.agG(this.mUrl))
      {
        str = this.mUrl;
        this.CHu.stop();
        c(this.jzL, str, this.CHx);
        this.CHu.a(this.CHz, true);
        Log.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.CHz) });
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41281);
            if ((GameVideoView.a(GameVideoView.this) instanceof CommonVideoView)) {
              ((CommonVideoView)GameVideoView.a(GameVideoView.this)).hideLoading();
            }
            AppMethodBeat.o(41281);
          }
        }, 1000L);
        i = 1;
      }
    }
    for (;;)
    {
      if ((i == 0) && (this.CHu != null)) {
        this.CHu.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (u.agG(aJR(this.mUrl)))
      {
        str = aJR(this.mUrl);
        break;
      }
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final boolean p(double paramDouble)
  {
    AppMethodBeat.i(41305);
    if (this.CHu != null)
    {
      boolean bool = this.CHu.p(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(41320);
    if (this.CHu != null)
    {
      setKeepScreenOn(false);
      this.sUi.fZ(false);
      boolean bool = this.CHu.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.CHu != null) {
      this.CHu.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.CHu != null) {
      this.CHu.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    if (paramb != null) {
      this.CHH = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.CHu != null) {
      this.CHu.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.mMute = paramBoolean;
    if (this.CHu != null) {
      this.CHu.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(41325);
    this.CHv = parame;
    if (this.CHu != null) {
      this.CHu.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(41316);
    this.CHA = paramh;
    if (this.CHu != null) {
      this.CHu.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.CHB = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.CHu != null)
    {
      this.CHu.start();
      setKeepScreenOn(true);
      this.sUi.a(this.CHG);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.CHu != null)
    {
      this.CHu.stop();
      this.sUi.fZ(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void qX();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */