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
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.h;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.m;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements com.tencent.mm.pluginsdk.ui.i
{
  private static Set<String> uah;
  private boolean ctO;
  private Context mContext;
  private String mUrl;
  private d ota;
  private com.tencent.mm.pluginsdk.ui.i tZY;
  private i.e tZZ;
  private float uaa;
  private int uab;
  private boolean uac;
  private boolean uad;
  private int uae;
  private h uaf;
  private a uag;
  a uai;
  i.a uaj;
  i.c uak;
  d.a ual;
  i.b uam;
  
  static
  {
    AppMethodBeat.i(41327);
    uah = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.tZZ = i.e.ESO;
    this.ctO = false;
    this.uaa = -1.0F;
    this.uae = 0;
    this.uaj = new i.a()
    {
      public final void aK(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          com.tencent.mm.vfs.i.mz(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cYs().add(paramAnonymousString);
          ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.uak = new i.c()
    {
      public final void qQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        g.yhR.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void vk(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        g.yhR.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.ual = new d.a()
    {
      public final void aAa() {}
      
      public final void aAb() {}
      
      public final void azY() {}
      
      public final void azZ() {}
    };
    this.uam = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ad.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).ta();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ex(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.ual);
        AppMethodBeat.o(41290);
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eT(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.tZZ = i.e.ESO;
    this.ctO = false;
    this.uaa = -1.0F;
    this.uae = 0;
    this.uaj = new i.a()
    {
      public final void aK(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          com.tencent.mm.vfs.i.mz(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cYs().add(paramAnonymousString);
          ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.uak = new i.c()
    {
      public final void qQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        g.yhR.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void vk(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        g.yhR.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.ual = new d.a()
    {
      public final void aAa() {}
      
      public final void aAb() {}
      
      public final void azY() {}
      
      public final void azZ() {}
    };
    this.uam = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ad.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).ta();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ex(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.ual);
        AppMethodBeat.o(41290);
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eT(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String aba(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String alQ(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private com.tencent.mm.pluginsdk.ui.i cYo()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.fbJ();
    localCommonVideoView.setReporter(this.uak);
    localCommonVideoView.setIMMVideoViewCallback(this.uam);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.i cYp()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.uak);
    localGameMMVideoView.setIMMVideoViewCallback(this.uam);
    localGameMMVideoView.setIMMDownloadFinish(this.uaj);
    String str = getRootPath();
    m.aLc(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.uai = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.uai);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void cYq()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = uah.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(com.tencent.mm.vfs.i.deleteFile(str)), str });
    }
    uah.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean cYr()
  {
    return (this.uac) || (this.uad);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = b.c(b.a.tTd) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.ota = new d();
    AppMethodBeat.o(41293);
  }
  
  public final boolean aE(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.uaa = paramFloat;
    if (this.tZY != null)
    {
      boolean bool = this.tZY.aE(paramFloat);
      AppMethodBeat.o(41326);
      return bool;
    }
    AppMethodBeat.o(41326);
    return false;
  }
  
  public final boolean bhH()
  {
    AppMethodBeat.i(41314);
    if (this.tZY != null)
    {
      boolean bool = this.tZY.bhH();
      AppMethodBeat.o(41314);
      return bool;
    }
    AppMethodBeat.o(41314);
    return false;
  }
  
  public final void c(boolean paramBoolean, String paramString, int paramInt)
  {
    int i = 1;
    AppMethodBeat.i(41297);
    this.uab = paramInt;
    this.uac = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!bt.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.uad = paramBoolean;
        if (this.uad) {
          break label304;
        }
        localObject = alQ(paramString);
        if (!com.tencent.mm.vfs.i.fv((String)localObject)) {
          break label304;
        }
        com.tencent.mm.vfs.i.deleteFile(aba(paramString));
        this.uad = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.tZY != null) {
          break label342;
        }
        if (!cYr()) {
          break label312;
        }
        ad.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.tZY = cYo();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.tZZ);
      aE(this.uaa);
      setMute(this.ctO);
      if (paramInt != 0)
      {
        setVideoFooterView(this.uaf);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.tZY, paramString);
      }
      this.tZY.c(this.uac, this.mUrl, this.uab);
      if ((this.tZY instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.tZY).setFilepath(aba(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (com.tencent.mm.vfs.i.fv(((PString)localObject).value))
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
      ad.i("MicroMsg.Haowan.GameVideoView", "new use mm video view! path:%s", new Object[] { paramString });
      this.tZY = cYp();
      paramInt = i;
      continue;
      label342:
      if (cYr())
      {
        if ((this.tZY instanceof MMVideoView))
        {
          this.tZY.stop();
          this.tZY.cMk();
          removeView((View)this.tZY);
          ad.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.tZY = cYo();
          paramInt = i;
        }
        else
        {
          ad.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.tZY.stop();
          paramInt = 0;
        }
      }
      else if ((this.tZY instanceof CommonVideoView))
      {
        this.tZY.stop();
        this.tZY.cMk();
        removeView((View)this.tZY);
        ad.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.tZY = cYp();
        paramInt = i;
      }
      else
      {
        ad.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.tZY.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.tZY != null)
    {
      paramBoolean = this.tZY.c(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final void cMk()
  {
    AppMethodBeat.i(41317);
    if (this.tZY != null) {
      this.tZY.cMk();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.tZY != null)
    {
      int i = this.tZY.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.tZY != null)
    {
      int i = this.tZY.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.tZY != null)
    {
      int i = this.tZY.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.tZY instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.tZY).getFilePath();
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
    if (this.uad)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = alQ(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.tZY instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.tZY).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.tZY != null)
    {
      int i = this.tZY.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.tZY != null)
    {
      i = this.tZY.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.uab;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.tZY != null)
    {
      boolean bool = this.tZY.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(41305);
    if (this.tZY != null)
    {
      boolean bool = this.tZY.o(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.tZY != null) {
      this.tZY.onUIDestroy();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.tZY != null)
    {
      this.uae = this.tZY.getCurrPosSec();
      this.tZY.onUIPause();
    }
    this.ota.ex(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.tZY instanceof GameMMVideoView)) {
      if (com.tencent.mm.vfs.i.fv(this.mUrl))
      {
        str = this.mUrl;
        this.tZY.stop();
        c(this.uac, str, this.uab);
        this.tZY.c(this.uae, true);
        ad.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.uae) });
        aq.o(new Runnable()
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
      if ((i == 0) && (this.tZY != null)) {
        this.tZY.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (com.tencent.mm.vfs.i.fv(alQ(this.mUrl)))
      {
        str = alQ(this.mUrl);
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
    if (this.tZY != null)
    {
      setKeepScreenOn(false);
      this.ota.ex(false);
      boolean bool = this.tZY.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.tZY != null) {
      this.tZY.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.tZY != null) {
      this.tZY.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    if (paramb != null) {
      this.uam = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.tZY != null) {
      this.tZY.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.ctO = paramBoolean;
    if (this.tZY != null) {
      this.tZY.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(41325);
    this.tZZ = parame;
    if (this.tZY != null) {
      this.tZY.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(41316);
    this.uaf = paramh;
    if (this.tZY != null) {
      this.tZY.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.uag = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.tZY != null)
    {
      this.tZY.start();
      setKeepScreenOn(true);
      this.ota.a(this.ual);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.tZY != null)
    {
      this.tZY.stop();
      this.ota.ex(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void ta();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */