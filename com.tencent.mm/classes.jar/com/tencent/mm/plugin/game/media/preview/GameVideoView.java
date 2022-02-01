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
import com.tencent.mm.pluginsdk.ui.i;
import com.tencent.mm.pluginsdk.ui.i.a;
import com.tencent.mm.pluginsdk.ui.i.b;
import com.tencent.mm.pluginsdk.ui.i.c;
import com.tencent.mm.pluginsdk.ui.i.d;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pointers.PString;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.sdk.platformtools.n;
import com.tencent.mm.vfs.o;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GameVideoView
  extends RelativeLayout
  implements i
{
  private static Set<String> ulj;
  private boolean cur;
  private Context mContext;
  private String mUrl;
  private d ozB;
  private i ula;
  private i.e ulb;
  private float ulc;
  private int uld;
  private boolean ule;
  private boolean ulf;
  private int ulg;
  private h ulh;
  private a uli;
  a ulk;
  i.a ull;
  i.c ulm;
  d.a uln;
  i.b ulo;
  
  static
  {
    AppMethodBeat.i(41327);
    ulj = new HashSet();
    AppMethodBeat.o(41327);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(41291);
    this.ulb = i.e.Flj;
    this.cur = false;
    this.ulc = -1.0F;
    this.ulg = 0;
    this.ull = new i.a()
    {
      public final void aM(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ae.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          o.mF(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.dbc().add(paramAnonymousString);
          ae.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.ulm = new i.c()
    {
      public final void rd(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        g.yxI.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void vG(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        g.yxI.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.uln = new d.a()
    {
      public final void aAo() {}
      
      public final void aAp() {}
      
      public final void aAq() {}
      
      public final void aAr() {}
    };
    this.ulo = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ae.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).ta();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ae.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ez(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ae.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.uln);
        AppMethodBeat.o(41290);
      }
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eX(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41291);
  }
  
  public GameVideoView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(41292);
    this.ulb = i.e.Flj;
    this.cur = false;
    this.ulc = -1.0F;
    this.ulg = 0;
    this.ull = new i.a()
    {
      public final void aM(String paramAnonymousString, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(41282);
        ae.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish path [%s] isPlayNow [%b]", new Object[] { paramAnonymousString, Boolean.valueOf(paramAnonymousBoolean) });
        if ((paramAnonymousString != null) && (paramAnonymousString.endsWith(".temp")))
        {
          String str = paramAnonymousString.replace(".temp", "");
          o.mF(paramAnonymousString, str);
          GameVideoView.b(GameVideoView.this);
          GameVideoView.a(GameVideoView.this, str);
          GameVideoView.dbc().add(paramAnonymousString);
          ae.i("MicroMsg.Haowan.GameVideoView", "onDownloadFinish tempPath [%s] newPath [%s]", new Object[] { paramAnonymousString, str });
        }
        AppMethodBeat.o(41282);
      }
    };
    this.ulm = new i.c()
    {
      public final void rd(long paramAnonymousLong)
      {
        AppMethodBeat.i(41283);
        g.yxI.idkeyStat(600L, paramAnonymousLong, 1L, false);
        AppMethodBeat.o(41283);
      }
      
      public final void vG(String paramAnonymousString)
      {
        AppMethodBeat.i(41284);
        g.yxI.kvStat(14349, paramAnonymousString);
        AppMethodBeat.o(41284);
      }
    };
    this.uln = new d.a()
    {
      public final void aAo() {}
      
      public final void aAp() {}
      
      public final void aAq() {}
      
      public final void aAr() {}
    };
    this.ulo = new i.b()
    {
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41285);
        ae.w("MicroMsg.Haowan.GameVideoView", "%d onError[%s %d, %d]", new Object[] { Integer.valueOf(hashCode()), paramAnonymousString3, Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41285);
      }
      
      public final void d(String paramAnonymousString1, String paramAnonymousString2, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41288);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onGetVideoSize[%d %d]", new Object[] { Integer.valueOf(hashCode()), Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        AppMethodBeat.o(41288);
      }
      
      public final void ds(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41286);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onPrepared", new Object[] { Integer.valueOf(hashCode()) });
        if (GameVideoView.c(GameVideoView.this) != null) {
          GameVideoView.c(GameVideoView.this).ta();
        }
        AppMethodBeat.o(41286);
      }
      
      public final void dt(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41287);
        ae.i("MicroMsg.Haowan.GameVideoView", "%d onVideoEnded", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.c(0.0D, true);
        AppMethodBeat.o(41287);
      }
      
      public final void du(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41289);
        ae.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPause", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(false);
        GameVideoView.d(GameVideoView.this).ez(false);
        AppMethodBeat.o(41289);
      }
      
      public final void dv(String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41290);
        ae.d("MicroMsg.Haowan.GameVideoView", "%d onVideoPlay", new Object[] { Integer.valueOf(hashCode()) });
        GameVideoView.this.setKeepScreenOn(true);
        GameVideoView.d(GameVideoView.this).a(GameVideoView.this.uln);
        AppMethodBeat.o(41290);
      }
      
      public final void dw(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void dx(String paramAnonymousString1, String paramAnonymousString2) {}
      
      public final void eX(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    initView();
    AppMethodBeat.o(41292);
  }
  
  private static String abR(String paramString)
  {
    AppMethodBeat.i(41300);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4.temp";
    AppMethodBeat.o(41300);
    return paramString;
  }
  
  private static String amQ(String paramString)
  {
    AppMethodBeat.i(41301);
    paramString = getRootPath() + "MMVideo_" + paramString.hashCode() + ".mp4";
    AppMethodBeat.o(41301);
    return paramString;
  }
  
  private i daY()
  {
    AppMethodBeat.i(41298);
    CommonVideoView localCommonVideoView = new CommonVideoView(this.mContext);
    localCommonVideoView.ffx();
    localCommonVideoView.setReporter(this.ulm);
    localCommonVideoView.setIMMVideoViewCallback(this.ulo);
    AppMethodBeat.o(41298);
    return localCommonVideoView;
  }
  
  private i daZ()
  {
    AppMethodBeat.i(41299);
    GameMMVideoView localGameMMVideoView = new GameMMVideoView(this.mContext);
    localGameMMVideoView.setReporter(this.ulm);
    localGameMMVideoView.setIMMVideoViewCallback(this.ulo);
    localGameMMVideoView.setIMMDownloadFinish(this.ull);
    String str = getRootPath();
    n.aMy(str);
    localGameMMVideoView.setRootPath(str);
    localGameMMVideoView.setLoop(true);
    this.ulk = new a(localGameMMVideoView);
    localGameMMVideoView.setIOnlineVideoProxy(this.ulk);
    AppMethodBeat.o(41299);
    return localGameMMVideoView;
  }
  
  public static void dba()
  {
    AppMethodBeat.i(41303);
    Iterator localIterator = ulj.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      ae.i("MicroMsg.Haowan.GameVideoView", "delete temp cache ret:%b, cachePath:%s", new Object[] { Boolean.valueOf(o.deleteFile(str)), str });
    }
    ulj.clear();
    AppMethodBeat.o(41303);
  }
  
  private boolean dbb()
  {
    return (this.ule) || (this.ulf);
  }
  
  public static String getRootPath()
  {
    AppMethodBeat.i(41302);
    String str = b.c(b.a.udU) + "haowan/";
    AppMethodBeat.o(41302);
    return str;
  }
  
  private void initView()
  {
    AppMethodBeat.i(41293);
    this.mContext = getContext();
    this.ozB = new d();
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
    this.ulc = paramFloat;
    if (this.ula != null)
    {
      boolean bool = this.ula.aE(paramFloat);
      AppMethodBeat.o(41326);
      return bool;
    }
    AppMethodBeat.o(41326);
    return false;
  }
  
  public final boolean bip()
  {
    AppMethodBeat.i(41314);
    if (this.ula != null)
    {
      boolean bool = this.ula.bip();
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
    this.uld = paramInt;
    this.ule = paramBoolean;
    Object localObject = new PString();
    ((PString)localObject).value = paramString;
    if (!bu.isNullOrNil(((PString)localObject).value)) {
      if (((PString)localObject).value.indexOf("file://") == 0)
      {
        ((PString)localObject).value = ((PString)localObject).value.substring(7);
        paramBoolean = true;
        this.ulf = paramBoolean;
        if (this.ulf) {
          break label304;
        }
        localObject = amQ(paramString);
        if (!o.fB((String)localObject)) {
          break label304;
        }
        o.deleteFile(abR(paramString));
        this.ulf = true;
        this.mUrl = ((String)localObject);
        label121:
        if (this.ula != null) {
          break label342;
        }
        if (!dbb()) {
          break label312;
        }
        ae.i("MicroMsg.Haowan.GameVideoView", "new use common video view! path:%s", new Object[] { paramString });
        this.ula = daY();
        paramInt = i;
      }
    }
    for (;;)
    {
      setScaleType(this.ulb);
      aE(this.ulc);
      setMute(this.cur);
      if (paramInt != 0)
      {
        setVideoFooterView(this.ulh);
        paramString = new RelativeLayout.LayoutParams(-1, -2);
        paramString.addRule(13);
        addView((View)this.ula, paramString);
      }
      this.ula.c(this.ule, this.mUrl, this.uld);
      if ((this.ula instanceof GameMMVideoView)) {
        ((GameMMVideoView)this.ula).setFilepath(abR(this.mUrl));
      }
      AppMethodBeat.o(41297);
      return;
      if (o.fB(((PString)localObject).value))
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
      ae.i("MicroMsg.Haowan.GameVideoView", "new use mm video view! path:%s", new Object[] { paramString });
      this.ula = daZ();
      paramInt = i;
      continue;
      label342:
      if (dbb())
      {
        if ((this.ula instanceof MMVideoView))
        {
          this.ula.stop();
          this.ula.cOS();
          removeView((View)this.ula);
          ae.i("MicroMsg.Haowan.GameVideoView", "use common video view! path:%s", new Object[] { paramString });
          this.ula = daY();
          paramInt = i;
        }
        else
        {
          ae.i("MicroMsg.Haowan.GameVideoView", "use last common video view! path:%s", new Object[] { paramString });
          this.ula.stop();
          paramInt = 0;
        }
      }
      else if ((this.ula instanceof CommonVideoView))
      {
        this.ula.stop();
        this.ula.cOS();
        removeView((View)this.ula);
        ae.i("MicroMsg.Haowan.GameVideoView", "use mm video view! path:%s", new Object[] { paramString });
        this.ula = daZ();
        paramInt = i;
      }
      else
      {
        ae.i("MicroMsg.Haowan.GameVideoView", "use last mm video view! path:%s", new Object[] { paramString });
        this.ula.stop();
        paramInt = 0;
      }
    }
  }
  
  public final boolean c(double paramDouble, boolean paramBoolean)
  {
    AppMethodBeat.i(41306);
    if (this.ula != null)
    {
      paramBoolean = this.ula.c(paramDouble, paramBoolean);
      AppMethodBeat.o(41306);
      return paramBoolean;
    }
    AppMethodBeat.o(41306);
    return false;
  }
  
  public final void cOS()
  {
    AppMethodBeat.i(41317);
    if (this.ula != null) {
      this.ula.cOS();
    }
    AppMethodBeat.o(41317);
  }
  
  public int getCacheTimeSec()
  {
    AppMethodBeat.i(41312);
    if (this.ula != null)
    {
      int i = this.ula.getCacheTimeSec();
      AppMethodBeat.o(41312);
      return i;
    }
    AppMethodBeat.o(41312);
    return 0;
  }
  
  public int getCurrPosMs()
  {
    AppMethodBeat.i(41310);
    if (this.ula != null)
    {
      int i = this.ula.getCurrPosMs();
      AppMethodBeat.o(41310);
      return i;
    }
    AppMethodBeat.o(41310);
    return 0;
  }
  
  public int getCurrPosSec()
  {
    AppMethodBeat.i(41311);
    if (this.ula != null)
    {
      int i = this.ula.getCurrPosSec();
      AppMethodBeat.o(41311);
      return i;
    }
    AppMethodBeat.o(41311);
    return 0;
  }
  
  public String getFilePath()
  {
    AppMethodBeat.i(41294);
    if ((this.ula instanceof GameMMVideoView))
    {
      str = ((GameMMVideoView)this.ula).getFilePath();
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
    if (this.ulf)
    {
      str = this.mUrl;
      AppMethodBeat.o(41296);
      return str;
    }
    String str = amQ(this.mUrl);
    AppMethodBeat.o(41296);
    return str;
  }
  
  public String getMediaId()
  {
    AppMethodBeat.i(41295);
    if ((this.ula instanceof GameMMVideoView))
    {
      String str = ((GameMMVideoView)this.ula).getMediaId();
      AppMethodBeat.o(41295);
      return str;
    }
    AppMethodBeat.o(41295);
    return null;
  }
  
  public int getPlayerType()
  {
    AppMethodBeat.i(41304);
    if (this.ula != null)
    {
      int i = this.ula.getPlayerType();
      AppMethodBeat.o(41304);
      return i;
    }
    AppMethodBeat.o(41304);
    return 0;
  }
  
  public int getVideoDurationSec()
  {
    AppMethodBeat.i(41309);
    if (this.ula != null)
    {
      i = this.ula.getVideoDurationSec();
      AppMethodBeat.o(41309);
      return i;
    }
    int i = this.uld;
    AppMethodBeat.o(41309);
    return i;
  }
  
  public final boolean isPlaying()
  {
    AppMethodBeat.i(41313);
    if (this.ula != null)
    {
      boolean bool = this.ula.isPlaying();
      AppMethodBeat.o(41313);
      return bool;
    }
    AppMethodBeat.o(41313);
    return false;
  }
  
  public final boolean o(double paramDouble)
  {
    AppMethodBeat.i(41305);
    if (this.ula != null)
    {
      boolean bool = this.ula.o(paramDouble);
      AppMethodBeat.o(41305);
      return bool;
    }
    AppMethodBeat.o(41305);
    return false;
  }
  
  public final void onUIDestroy()
  {
    AppMethodBeat.i(41324);
    if (this.ula != null) {
      this.ula.onUIDestroy();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41324);
  }
  
  public final void onUIPause()
  {
    AppMethodBeat.i(41323);
    if (this.ula != null)
    {
      this.ulg = this.ula.getCurrPosSec();
      this.ula.onUIPause();
    }
    this.ozB.ez(false);
    setKeepScreenOn(false);
    AppMethodBeat.o(41323);
  }
  
  public final void onUIResume()
  {
    AppMethodBeat.i(41322);
    String str;
    int i;
    if ((this.ula instanceof GameMMVideoView)) {
      if (o.fB(this.mUrl))
      {
        str = this.mUrl;
        this.ula.stop();
        c(this.ule, str, this.uld);
        this.ula.c(this.ulg, true);
        ae.i("MicroMsg.Haowan.GameVideoView", "change to local video. currPosSec:%d", new Object[] { Integer.valueOf(this.ulg) });
        ar.o(new Runnable()
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
      if ((i == 0) && (this.ula != null)) {
        this.ula.onUIResume();
      }
      AppMethodBeat.o(41322);
      return;
      if (o.fB(amQ(this.mUrl)))
      {
        str = amQ(this.mUrl);
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
    if (this.ula != null)
    {
      setKeepScreenOn(false);
      this.ozB.ez(false);
      boolean bool = this.ula.pause();
      AppMethodBeat.o(41320);
      return bool;
    }
    AppMethodBeat.o(41320);
    return false;
  }
  
  public void setCover(Bitmap paramBitmap)
  {
    AppMethodBeat.i(41315);
    if (this.ula != null) {
      this.ula.setCover(paramBitmap);
    }
    AppMethodBeat.o(41315);
  }
  
  public void setFullDirection(int paramInt)
  {
    AppMethodBeat.i(41308);
    if (this.ula != null) {
      this.ula.setFullDirection(paramInt);
    }
    AppMethodBeat.o(41308);
  }
  
  public void setIMMVideoViewCallback(i.b paramb)
  {
    if (paramb != null) {
      this.ulo = paramb;
    }
  }
  
  public void setIsShowBasicControls(boolean paramBoolean)
  {
    AppMethodBeat.i(41307);
    if (this.ula != null) {
      this.ula.setIsShowBasicControls(paramBoolean);
    }
    AppMethodBeat.o(41307);
  }
  
  public void setLoop(boolean paramBoolean) {}
  
  public void setLoopCompletionCallback(i.d paramd) {}
  
  public void setMute(boolean paramBoolean)
  {
    AppMethodBeat.i(41321);
    this.cur = paramBoolean;
    if (this.ula != null) {
      this.ula.setMute(paramBoolean);
    }
    AppMethodBeat.o(41321);
  }
  
  public void setScaleType(i.e parame)
  {
    AppMethodBeat.i(41325);
    this.ulb = parame;
    if (this.ula != null) {
      this.ula.setScaleType(parame);
    }
    AppMethodBeat.o(41325);
  }
  
  public void setVideoFooterView(h paramh)
  {
    AppMethodBeat.i(41316);
    this.ulh = paramh;
    if (this.ula != null) {
      this.ula.setVideoFooterView(paramh);
    }
    AppMethodBeat.o(41316);
  }
  
  public void setVideoPreparedListener(a parama)
  {
    this.uli = parama;
  }
  
  public final void start()
  {
    AppMethodBeat.i(41318);
    if (this.ula != null)
    {
      this.ula.start();
      setKeepScreenOn(true);
      this.ozB.a(this.uln);
    }
    AppMethodBeat.o(41318);
  }
  
  public final void stop()
  {
    AppMethodBeat.i(41319);
    if (this.ula != null)
    {
      this.ula.stop();
      this.ozB.ez(false);
      setKeepScreenOn(false);
    }
    AppMethodBeat.o(41319);
  }
  
  static abstract interface a
  {
    public abstract void ta();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.GameVideoView
 * JD-Core Version:    0.7.0.1
 */