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
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.commlib.util.b.a;
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
import com.tencent.mm.vfs.s;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements i
{
  private static Set<String> xDB;
  private boolean gPs;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  private d pNk;
  private a xDA;
  a xDC;
  i.a xDD;
  i.c xDE;
  d.a xDF;
  i.b xDG;
  private i xDt;
  private i.e xDu;
  private float xDv;
  private int xDw;
  private boolean xDx;
  private int xDy;
  private com.tencent.mm.pluginsdk.ui.h xDz;
  
  static
  {
    AppMethodBeat.i(41327);
    xDB = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.xDu = i.e.Kcb;
    this.mMute = false;
    this.xDv = -1.0F;
    this.xDy = 0;
    this.xDD = new i.a()
    {
      public final void aO(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          s.nw(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.dUJ().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.xDE = new i.c()
    {
      public final void DX(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
      
      public final void yU(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
    };
    this.xDF = new d.a()
    {
      public final void aTw() {}
      
      public final void aTx() {}
      
      public final void aTy() {}
      
      public final void aTz() {}
    };
    this.xDG = new i.b()
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
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).tf();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).fp(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.xDF);
        AppMethodBeat.o(41290);
      }
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void fo(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.xDu = i.e.Kcb;
    this.mMute = false;
    this.xDv = -1.0F;
    this.xDy = 0;
    this.xDD = new i.a()
    {
      public final void aO(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          s.nw(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.dUJ().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.xDE = new i.c()
    {
      public final void DX(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.CyF.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
      
      public final void yU(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.CyF.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
    };
    this.xDF = new d.a()
    {
      public final void aTw() {}
      
      public final void aTx() {}
      
      public final void aTy() {}
      
      public final void aTz() {}
    };
    this.xDG = new i.b()
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
      
      public final void dH(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).tf();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dI(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dJ(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).fp(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dK(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.xDF);
        AppMethodBeat.o(41290);
      }
      
      public final void dL(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dM(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void fo(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String aAf(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String aAg(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private i dUF()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.goG();
    localCommonVideoView.setReporter(this.xDE);
    localCommonVideoView.setIMMVideoViewCallback(this.xDG);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private i dUG()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.xDE);
    localGameMMVideoView.setIMMVideoViewCallback(this.xDG);
    localGameMMVideoView.setIMMDownloadFinish(this.xDD);
    String str = getRootPath();
    FilePathGenerator.checkMkdir(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.xDC = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.xDC);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void dUH()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = xDB.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(s.deleteFile(str)), str });
    }
    xDB.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean dUI()
  {
    return (this.gPs) || (this.xDx);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = b.c(b.a.xvG) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.pNk = new d();
    AppMethodBeat.o(41293);
  }
  
  public final boolean aO(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.xDv = paramFloat;
    if (this.xDt != null)
    {
      boolean bool = this.xDt.aO(paramFloat);
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
    this.xDw = paramInt;
    this.gPs = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!Util.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.xDx = paramBoolean;
        if (this.xDx) {
          break label304;
        }
        localObject = aAg(paramString);
        if (!s.YS((String)localObject)) {
          break label304;
        }
        s.deleteFile(aAf(paramString));
        this.xDx = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.xDt != null) {
          break label342;
        }
        if (!dUI()) {
          break label312;
        }
        Log.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.xDt = dUF();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.xDu);
      aO(this.xDv);
      setMute(this.mMute);
      if (paramInt != 0)
      {
        setVideoFooterView(this.xDz);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.xDt, paramString);
      }
      this.xDt.c(this.gPs, this.mUrl, this.xDw);
      if ((this.xDt instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.xDt).setFilepath(aAf(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (s.YS(((PString)localObject).value))
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
      this.xDt = dUG();
      paramInt = i;
      continue;
      label342:
      if (dUI())
      {
        if ((this.xDt instanceof MMVideoView))
        {
          this.xDt.stop();
          this.xDt.dFl();
          removeView((View)this.xDt);
          Log.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.xDt = dUF();
          paramInt = i;
        }
        else
        {
          Log.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.xDt.stop();
          paramInt = 0;
        }
      }
      else if ((this.xDt instanceof CommonVideoView))
      {
        this.xDt.stop();
        this.xDt.dFl();
        removeView((View)this.xDt);
        Log.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.xDt = dUG();
        paramInt = i;
      }
      else
      {
        Log.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.xDt.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.xDt != null)
    {
      paramBoolean = this.xDt.c(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final void dFl()
  {
    AppMethodBeat.i(41317);
    if (this.xDt != null) {
      this.xDt.dFl();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.xDt != null)
    {
      int i = this.xDt.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.xDt != null)
    {
      int i = this.xDt.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.xDt != null)
    {
      int i = this.xDt.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.xDt instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.xDt).getFilePath();
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
    if (this.xDx)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = aAg(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.xDt instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.xDt).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.xDt != null)
    {
      int i = this.xDt.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.xDt != null)
    {
      i = this.xDt.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.xDw;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(41314);
    if (this.xDt != null)
    {
      boolean bool = this.xDt.isLive();
      AppMethodBeat.o(41314);
      return bool;
    }
    AppMethodBeat.o(41314);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.xDt != null)
    {
      boolean bool = this.xDt.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.xDt != null) {
      this.xDt.onUIDestroy();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.xDt != null)
    {
      this.xDy = this.xDt.getCurrPosSec();
      this.xDt.onUIPause();
    }
    this.pNk.fp(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.xDt instanceof GameMMVideoView)) {
      if (s.YS(this.mUrl))
      {
        str = this.mUrl;
        this.xDt.stop();
        c(this.gPs, str, this.xDw);
        this.xDt.c(this.xDy, true);
        Log.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.xDy) });
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
      if ((i == 0) && (this.xDt != null)) {
        this.xDt.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (s.YS(aAg(this.mUrl)))
      {
        str = aAg(this.mUrl);
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
    if (this.xDt != null)
    {
      boolean bool = this.xDt.p(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(41320);
    if (this.xDt != null)
    {
      setKeepScreenOn(false);
      this.pNk.fp(false);
      boolean bool = this.xDt.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.xDt != null) {
      this.xDt.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.xDt != null) {
      this.xDt.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    if (paramb != null) {
      this.xDG = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.xDt != null) {
      this.xDt.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.mMute = paramBoolean;
    if (this.xDt != null) {
      this.xDt.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(41325);
    this.xDu = parame;
    if (this.xDt != null) {
      this.xDt.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(41316);
    this.xDz = paramh;
    if (this.xDt != null) {
      this.xDt.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.xDA = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.xDt != null)
    {
      this.xDt.start();
      setKeepScreenOn(true);
      this.pNk.a(this.xDF);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.xDt != null)
    {
      this.xDt.stop();
      this.pNk.fp(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void tf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */