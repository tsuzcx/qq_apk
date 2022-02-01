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
import com.tencent.mm.vfs.y;
import com.tencent.thumbplayer.api.ITPPlayer;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements i
{
  private static Set<String> IBM;
  private i IBD;
  private i.e IBE;
  private float IBF;
  private int IBG;
  private boolean IBH;
  private boolean IBI;
  private int IBJ;
  private com.tencent.mm.pluginsdk.ui.h IBK;
  private a IBL;
  a IBN;
  i.a IBO;
  i.c IBP;
  d.a IBQ;
  i.b IBR;
  private Context mContext;
  private boolean mMute;
  private String mUrl;
  private d vZw;
  
  static
  {
    AppMethodBeat.i(41327);
    IBM = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.IBE = i.e.XYM;
    this.mMute = false;
    this.IBF = -1.0F;
    this.IBJ = 0;
    this.IBO = new i.a()
    {
      public final void bd(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          y.O(paramAnonymousString, str, false);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.fFM().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.IBP = new i.c()
    {
      public final void Du(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
      
      public final void hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
    };
    this.IBQ = new d.a()
    {
      public final void bAi() {}
      
      public final void bAj() {}
      
      public final void bAk() {}
      
      public final void bAl() {}
    };
    this.IBR = new i.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        Log.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).Qz();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.b(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).gR(false);
        AppMethodBeat.o(41289);
      }
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.IBQ);
        AppMethodBeat.o(41290);
      }
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void gE(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.IBE = i.e.XYM;
    this.mMute = false;
    this.IBF = -1.0F;
    this.IBJ = 0;
    this.IBO = new i.a()
    {
      public final void bd(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          y.O(paramAnonymousString, str, false);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.fFM().add(paramAnonymousString);
          Log.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.IBP = new i.c()
    {
      public final void Du(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.OAn.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
      
      public final void hp(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.OAn.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
    };
    this.IBQ = new d.a()
    {
      public final void bAi() {}
      
      public final void bAj() {}
      
      public final void bAk() {}
      
      public final void bAl() {}
    };
    this.IBR = new i.b()
    {
      public final void d(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        Log.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void e(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void el(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).Qz();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void em(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        Log.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.b(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void en(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).gR(false);
        AppMethodBeat.o(41289);
      }
      
      public final void eo(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        Log.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.IBQ);
        AppMethodBeat.o(41290);
      }
      
      public final void ep(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eq(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void gE(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void onSeekComplete(ITPPlayer paramAnonymousITPPlayer) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String aGF(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String aGG(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private i fFI()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.iKk();
    localCommonVideoView.setReporter(this.IBP);
    localCommonVideoView.setIMMVideoViewCallback(this.IBR);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private i fFJ()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.IBP);
    localGameMMVideoView.setIMMVideoViewCallback(this.IBR);
    localGameMMVideoView.setIMMDownloadFinish(this.IBO);
    String str = getRootPath();
    FilePathGenerator.checkMkdir(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.IBN = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.IBN);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void fFK()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = IBM.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      Log.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(y.deleteFile(str)), str });
    }
    IBM.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean fFL()
  {
    return (this.IBH) || (this.IBI);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = c.c(c.a.Itm) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.vZw = new d();
    AppMethodBeat.o(41293);
  }
  
  public final boolean G(double paramDouble)
  {
    AppMethodBeat.i(41305);
    if (this.IBD != null)
    {
      boolean bool = this.IBD.G(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final void b(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(41297);
    this.IBG = paramInt;
    this.IBH = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!Util.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.IBI = paramBoolean;
        if (this.IBI) {
          break label304;
        }
        localObject = aGG(paramString);
        if (!y.ZC((String)localObject)) {
          break label304;
        }
        y.deleteFile(aGF(paramString));
        this.IBI = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.IBD != null) {
          break label342;
        }
        if (!fFL()) {
          break label312;
        }
        Log.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.IBD = fFI();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.IBE);
      bM(this.IBF);
      setMute(this.mMute);
      if (paramInt != 0)
      {
        setVideoFooterView(this.IBK);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.IBD, paramString);
      }
      this.IBD.b(this.IBH, this.mUrl, this.IBG);
      if ((this.IBD instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.IBD).setFilepath(aGF(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (y.ZC(((PString)localObject).value))
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
      this.IBD = fFJ();
      paramInt = i;
      continue;
      label342:
      if (fFL())
      {
        if ((this.IBD instanceof MMVideoView))
        {
          this.IBD.stop();
          this.IBD.eLM();
          removeView((View)this.IBD);
          Log.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.IBD = fFI();
          paramInt = i;
        }
        else
        {
          Log.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.IBD.stop();
          paramInt = 0;
        }
      }
      else if ((this.IBD instanceof CommonVideoView))
      {
        this.IBD.stop();
        this.IBD.eLM();
        removeView((View)this.IBD);
        Log.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.IBD = fFJ();
        paramInt = i;
      }
      else
      {
        Log.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.IBD.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean b(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.IBD != null)
    {
      paramBoolean = this.IBD.b(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final boolean bM(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.IBF = paramFloat;
    if (this.IBD != null)
    {
      boolean bool = this.IBD.bM(paramFloat);
      AppMethodBeat.o(41326);
      return bool;
    }
    AppMethodBeat.o(41326);
    return false;
  }
  
  public final void eLM()
  {
    AppMethodBeat.i(41317);
    if (this.IBD != null) {
      this.IBD.eLM();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.IBD != null)
    {
      int i = this.IBD.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.IBD != null)
    {
      int i = this.IBD.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.IBD != null)
    {
      int i = this.IBD.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.IBD instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.IBD).getFilePath();
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
    if (this.IBI)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = aGG(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.IBD instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.IBD).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.IBD != null)
    {
      int i = this.IBD.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.IBD != null)
    {
      i = this.IBD.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.IBG;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isLive()
  {
    AppMethodBeat.i(41314);
    if (this.IBD != null)
    {
      boolean bool = this.IBD.isLive();
      AppMethodBeat.o(41314);
      return bool;
    }
    AppMethodBeat.o(41314);
    return false;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.IBD != null)
    {
      boolean bool = this.IBD.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.IBD != null) {
      this.IBD.onUIDestroy();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.IBD != null)
    {
      this.IBJ = this.IBD.getCurrPosSec();
      this.IBD.onUIPause();
    }
    this.vZw.gR(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.IBD instanceof GameMMVideoView)) {
      if (y.ZC(this.mUrl))
      {
        str = this.mUrl;
        this.IBD.stop();
        b(this.IBH, str, this.IBG);
        this.IBD.b(this.IBJ, true);
        Log.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.IBJ) });
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
      if ((i == 0) && (this.IBD != null)) {
        this.IBD.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (y.ZC(aGG(this.mUrl)))
      {
        str = aGG(this.mUrl);
        break;
      }
      i = 0;
      continue;
      i = 0;
    }
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(41320);
    if (this.IBD != null)
    {
      setKeepScreenOn(false);
      this.vZw.gR(false);
      boolean bool = this.IBD.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.IBD != null) {
      this.IBD.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.IBD != null) {
      this.IBD.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    if (paramb != null) {
      this.IBR = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.IBD != null) {
      this.IBD.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.mMute = paramBoolean;
    if (this.IBD != null) {
      this.IBD.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(41325);
    this.IBE = parame;
    if (this.IBD != null) {
      this.IBD.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(com.tencent.mm.pluginsdk.ui.h paramh)
  {
    AppMethodBeat.i(41316);
    this.IBK = paramh;
    if (this.IBD != null) {
      this.IBD.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.IBL = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.IBD != null)
    {
      this.IBD.start();
      setKeepScreenOn(true);
      this.vZw.a(this.IBQ);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.IBD != null)
    {
      this.IBD.stop();
      this.vZw.gR(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void Qz();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */