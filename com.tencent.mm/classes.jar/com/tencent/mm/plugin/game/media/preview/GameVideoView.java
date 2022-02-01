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
import com.tencent.mm.plugin.game.commlib.e.b;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.pluginsdk.ui.CommonVideoView;
import com.tencent.mm.pluginsdk.ui.g;
import com.tencent.mm.pluginsdk.ui.h.a;
import com.tencent.mm.pluginsdk.ui.h.b;
import com.tencent.mm.pluginsdk.ui.h.c;
import com.tencent.mm.pluginsdk.ui.h.d;
import com.tencent.mm.pluginsdk.ui.h.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements com.tencent.mm.pluginsdk.ui.h
{
  private static Set<String> rUz;
  private boolean cmw;
  private Context mContext;
  private String mUrl;
  private d nnt;
  a rUA;
  h.a rUB;
  h.c rUC;
  d.a rUD;
  h.b rUE;
  private com.tencent.mm.pluginsdk.ui.h rUq;
  private h.e rUr;
  private float rUs;
  private int rUt;
  private boolean rUu;
  private boolean rUv;
  private int rUw;
  private g rUx;
  private a rUy;
  
  static
  {
    AppMethodBeat.i(41327);
    rUz = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.rUr = h.e.BVs;
    this.cmw = false;
    this.rUs = -1.0F;
    this.rUw = 0;
    this.rUB = new h.a()
    {
      public final void aH(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          i.lC(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cCD().add(paramAnonymousString);
          ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.rUC = new h.c()
    {
      public final void ln(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void pj(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.rUD = new d.a()
    {
      public final void aqt() {}
      
      public final void aqu() {}
      
      public final void aqv() {}
      
      public final void aqw() {}
    };
    this.rUE = new h.b()
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
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).rq();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ea(false);
        AppMethodBeat.o(41289);
      }
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.rUD);
        AppMethodBeat.o(41290);
      }
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void jw(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.rUr = h.e.BVs;
    this.cmw = false;
    this.rUs = -1.0F;
    this.rUw = 0;
    this.rUB = new h.a()
    {
      public final void aH(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          i.lC(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cCD().add(paramAnonymousString);
          ad.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.rUC = new h.c()
    {
      public final void ln(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.vKh.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void pj(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.vKh.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.rUD = new d.a()
    {
      public final void aqt() {}
      
      public final void aqu() {}
      
      public final void aqv() {}
      
      public final void aqw() {}
    };
    this.rUE = new h.b()
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
      
      public final void db(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).rq();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dc(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ad.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dd(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ea(false);
        AppMethodBeat.o(41289);
      }
      
      public final void de(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ad.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.rUD);
        AppMethodBeat.o(41290);
      }
      
      public final void dg(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dh(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void jw(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String Th(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String acw(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  public static void cCA()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = rUz.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ad.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(i.deleteFile(str)), str });
    }
    rUz.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean cCB()
  {
    return (this.rUu) || (this.rUv);
  }
  
  private com.tencent.mm.pluginsdk.ui.h cCy()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.exr();
    localCommonVideoView.setReporter(this.rUC);
    localCommonVideoView.setIMMVideoViewCallback(this.rUE);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h cCz()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.rUC);
    localGameMMVideoView.setIMMVideoViewCallback(this.rUE);
    localGameMMVideoView.setIMMDownloadFinish(this.rUB);
    String str = getRootPath();
    l.aAk(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.rUA = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.rUA);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = b.b(b.a.rOF) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.nnt = new d();
    AppMethodBeat.o(41293);
  }
  
  public final boolean aXf()
  {
    AppMethodBeat.i(41314);
    if (this.rUq != null)
    {
      boolean bool = this.rUq.aXf();
      AppMethodBeat.o(41314);
      return bool;
    }
    AppMethodBeat.o(41314);
    return false;
  }
  
  public final boolean ax(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.rUs = paramFloat;
    if (this.rUq != null)
    {
      boolean bool = this.rUq.ax(paramFloat);
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
    this.rUt = paramInt;
    this.rUu = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!bt.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.rUv = paramBoolean;
        if (this.rUv) {
          break label304;
        }
        localObject = acw(paramString);
        if (!i.eK((String)localObject)) {
          break label304;
        }
        i.deleteFile(Th(paramString));
        this.rUv = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.rUq != null) {
          break label342;
        }
        if (!cCB()) {
          break label312;
        }
        ad.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.rUq = cCy();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.rUr);
      ax(this.rUs);
      setMute(this.cmw);
      if (paramInt != 0)
      {
        setVideoFooterView(this.rUx);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.rUq, paramString);
      }
      this.rUq.c(this.rUu, this.mUrl, this.rUt);
      if ((this.rUq instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.rUq).setFilepath(Th(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (i.eK(((PString)localObject).value))
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
      this.rUq = cCz();
      paramInt = i;
      continue;
      label342:
      if (cCB())
      {
        if ((this.rUq instanceof MMVideoView))
        {
          this.rUq.stop();
          this.rUq.cCC();
          removeView((View)this.rUq);
          ad.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.rUq = cCy();
          paramInt = i;
        }
        else
        {
          ad.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.rUq.stop();
          paramInt = 0;
        }
      }
      else if ((this.rUq instanceof CommonVideoView))
      {
        this.rUq.stop();
        this.rUq.cCC();
        removeView((View)this.rUq);
        ad.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.rUq = cCz();
        paramInt = i;
      }
      else
      {
        ad.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.rUq.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.rUq != null)
    {
      paramBoolean = this.rUq.c(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final void cCC()
  {
    AppMethodBeat.i(41317);
    if (this.rUq != null) {
      this.rUq.cCC();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.rUq != null)
    {
      int i = this.rUq.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.rUq != null)
    {
      int i = this.rUq.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.rUq != null)
    {
      int i = this.rUq.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.rUq instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.rUq).getFilePath();
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
    if (this.rUv)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = acw(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.rUq instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.rUq).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.rUq != null)
    {
      int i = this.rUq.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.rUq != null)
    {
      i = this.rUq.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.rUt;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.rUq != null)
    {
      boolean bool = this.rUq.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.rUq != null) {
      this.rUq.onUIDestroy();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.rUq != null)
    {
      this.rUw = this.rUq.getCurrPosSec();
      this.rUq.onUIPause();
    }
    this.nnt.ea(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.rUq instanceof GameMMVideoView)) {
      if (i.eK(this.mUrl))
      {
        str = this.mUrl;
        this.rUq.stop();
        c(this.rUu, str, this.rUt);
        this.rUq.c(this.rUw, true);
        ad.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.rUw) });
        aq.n(new Runnable()
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
      if ((i == 0) && (this.rUq != null)) {
        this.rUq.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (i.eK(acw(this.mUrl)))
      {
        str = acw(this.mUrl);
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
    if (this.rUq != null)
    {
      boolean bool = this.rUq.p(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final boolean pause()
  {
    AppMethodBeat.i(41320);
    if (this.rUq != null)
    {
      setKeepScreenOn(false);
      this.nnt.ea(false);
      boolean bool = this.rUq.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.rUq != null) {
      this.rUq.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.rUq != null) {
      this.rUq.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    if (paramb != null) {
      this.rUE = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.rUq != null) {
      this.rUq.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.cmw = paramBoolean;
    if (this.rUq != null) {
      this.rUq.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(41325);
    this.rUr = parame;
    if (this.rUq != null) {
      this.rUq.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(41316);
    this.rUx = paramg;
    if (this.rUq != null) {
      this.rUq.setVideoFooterView(paramg);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.rUy = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.rUq != null)
    {
      this.rUq.start();
      setKeepScreenOn(true);
      this.nnt.a(this.rUD);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.rUq != null)
    {
      this.rUq.stop();
      this.nnt.ea(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void rq();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */