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
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.sdk.platformtools.l;
import com.tencent.mm.vfs.i;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements com.tencent.mm.pluginsdk.ui.h
{
  private static Set<String> tcr;
  private boolean cjy;
  private Context mContext;
  private String mUrl;
  private d nQt;
  private com.tencent.mm.pluginsdk.ui.h tci;
  private h.e tcj;
  private float tck;
  private int tcl;
  private boolean tcm;
  private boolean tcn;
  private int tco;
  private g tcp;
  private a tcq;
  a tcs;
  h.a tct;
  h.c tcu;
  d.a tcv;
  h.b tcw;
  
  static
  {
    AppMethodBeat.i(41327);
    tcr = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.tcj = h.e.DnJ;
    this.cjy = false;
    this.tck = -1.0F;
    this.tco = 0;
    this.tct = new h.a()
    {
      public final void aI(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ac.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          i.lZ(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cPN().add(paramAnonymousString);
          ac.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.tcu = new h.c()
    {
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void sv(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.tcv = new d.a()
    {
      public final void axj() {}
      
      public final void axk() {}
      
      public final void axl() {}
      
      public final void axm() {}
    };
    this.tcw = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ac.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).rB();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ac.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ev(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ac.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.tcv);
        AppMethodBeat.o(41290);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eJ(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.tcj = h.e.DnJ;
    this.cjy = false;
    this.tck = -1.0F;
    this.tco = 0;
    this.tct = new h.a()
    {
      public final void aI(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ac.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          i.lZ(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.cPN().add(paramAnonymousString);
          ac.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.tcu = new h.c()
    {
      public final void oQ(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        com.tencent.mm.plugin.report.service.h.wUl.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void sv(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        com.tencent.mm.plugin.report.service.h.wUl.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.tcv = new d.a()
    {
      public final void axj() {}
      
      public final void axk() {}
      
      public final void axl() {}
      
      public final void axm() {}
    };
    this.tcw = new h.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ac.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void jdMethod_do(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).rB();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dp(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ac.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void dq(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ac.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ev(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dr(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ac.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.tcv);
        AppMethodBeat.o(41290);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eJ(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String Xt(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String aho(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private com.tencent.mm.pluginsdk.ui.h cPJ()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.eML();
    localCommonVideoView.setReporter(this.tcu);
    localCommonVideoView.setIMMVideoViewCallback(this.tcw);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private com.tencent.mm.pluginsdk.ui.h cPK()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.tcu);
    localGameMMVideoView.setIMMVideoViewCallback(this.tcw);
    localGameMMVideoView.setIMMDownloadFinish(this.tct);
    String str = getRootPath();
    l.aFC(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.tcs = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.tcs);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void cPL()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = tcr.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ac.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(i.deleteFile(str)), str });
    }
    tcr.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean cPM()
  {
    return (this.tcm) || (this.tcn);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = b.b(b.a.sWv) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.nQt = new d();
    AppMethodBeat.o(41293);
  }
  
  public final boolean aB(float paramFloat)
  {
    AppMethodBeat.i(41326);
    if (paramFloat <= 0.0F)
    {
      AppMethodBeat.o(41326);
      return false;
    }
    this.tck = paramFloat;
    if (this.tci != null)
    {
      boolean bool = this.tci.aB(paramFloat);
      AppMethodBeat.o(41326);
      return bool;
    }
    AppMethodBeat.o(41326);
    return false;
  }
  
  public final boolean bed()
  {
    AppMethodBeat.i(41314);
    if (this.tci != null)
    {
      boolean bool = this.tci.bed();
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
    this.tcl = paramInt;
    this.tcm = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!bs.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.tcn = paramBoolean;
        if (this.tcn) {
          break label304;
        }
        localObject = aho(paramString);
        if (!i.eA((String)localObject)) {
          break label304;
        }
        i.deleteFile(Xt(paramString));
        this.tcn = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.tci != null) {
          break label342;
        }
        if (!cPM()) {
          break label312;
        }
        ac.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.tci = cPJ();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.tcj);
      aB(this.tck);
      setMute(this.cjy);
      if (paramInt != 0)
      {
        setVideoFooterView(this.tcp);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.tci, paramString);
      }
      this.tci.c(this.tcm, this.mUrl, this.tcl);
      if ((this.tci instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.tci).setFilepath(Xt(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (i.eA(((PString)localObject).value))
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
      ac.i("MicroMsg.Haowan.GameVideoView", "new use mm video view! path:%s", new Object[] { paramString });
      this.tci = cPK();
      paramInt = i;
      continue;
      label342:
      if (cPM())
      {
        if ((this.tci instanceof MMVideoView))
        {
          this.tci.stop();
          this.tci.cDR();
          removeView((View)this.tci);
          ac.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.tci = cPJ();
          paramInt = i;
        }
        else
        {
          ac.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.tci.stop();
          paramInt = 0;
        }
      }
      else if ((this.tci instanceof CommonVideoView))
      {
        this.tci.stop();
        this.tci.cDR();
        removeView((View)this.tci);
        ac.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.tci = cPK();
        paramInt = i;
      }
      else
      {
        ac.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.tci.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.tci != null)
    {
      paramBoolean = this.tci.c(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final void cDR()
  {
    AppMethodBeat.i(41317);
    if (this.tci != null) {
      this.tci.cDR();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.tci != null)
    {
      int i = this.tci.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.tci != null)
    {
      int i = this.tci.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.tci != null)
    {
      int i = this.tci.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.tci instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.tci).getFilePath();
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
    if (this.tcn)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = aho(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.tci instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.tci).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.tci != null)
    {
      int i = this.tci.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.tci != null)
    {
      i = this.tci.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.tcl;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.tci != null)
    {
      boolean bool = this.tci.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(41305);
    if (this.tci != null)
    {
      boolean bool = this.tci.o(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.tci != null) {
      this.tci.onUIDestroy();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.tci != null)
    {
      this.tco = this.tci.getCurrPosSec();
      this.tci.onUIPause();
    }
    this.nQt.ev(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.tci instanceof GameMMVideoView)) {
      if (i.eA(this.mUrl))
      {
        str = this.mUrl;
        this.tci.stop();
        c(this.tcm, str, this.tcl);
        this.tci.c(this.tco, true);
        ac.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.tco) });
        ap.n(new Runnable()
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
      if ((i == 0) && (this.tci != null)) {
        this.tci.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (i.eA(aho(this.mUrl)))
      {
        str = aho(this.mUrl);
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
    if (this.tci != null)
    {
      setKeepScreenOn(false);
      this.nQt.ev(false);
      boolean bool = this.tci.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.tci != null) {
      this.tci.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.tci != null) {
      this.tci.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(h.b paramb)
  {
    if (paramb != null) {
      this.tcw = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.tci != null) {
      this.tci.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(h.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.cjy = paramBoolean;
    if (this.tci != null) {
      this.tci.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(h.e parame)
  {
    AppMethodBeat.i(41325);
    this.tcj = parame;
    if (this.tci != null) {
      this.tci.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(g paramg)
  {
    AppMethodBeat.i(41316);
    this.tcp = paramg;
    if (this.tci != null) {
      this.tci.setVideoFooterView(paramg);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.tcq = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.tci != null)
    {
      this.tci.start();
      setKeepScreenOn(true);
      this.nQt.a(this.tcv);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.tci != null)
    {
      this.tci.stop();
      this.nQt.ev(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void rB();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */