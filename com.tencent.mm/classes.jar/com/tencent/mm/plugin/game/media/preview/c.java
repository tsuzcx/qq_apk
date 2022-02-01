package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.a;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.commlib.e.b;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.plugin.game.media.CycleProgressView;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.am;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.ap;
import junit.framework.Assert;

public final class c
{
  private static final String tcy;
  private Context context;
  private View gDe;
  private boolean gRx;
  private long startTime;
  private f.b taN;
  private f.a taO;
  private String tcA;
  private e tcB;
  private a tcC;
  private CycleProgressView tcz;
  
  static
  {
    AppMethodBeat.i(41345);
    tcy = b.b(b.a.sWv) + "haowan/";
    AppMethodBeat.o(41345);
  }
  
  public c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(41339);
    this.gRx = false;
    this.taN = new f.b()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4)
      {
        AppMethodBeat.i(41334);
        if (!c.c(c.this).equals(paramAnonymousString1))
        {
          AppMethodBeat.o(41334);
          return;
        }
        c.d(c.this).setVisibility(8);
        ac.i("MicroMsg.Haowan.VideoShareWrapper", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Long.valueOf(System.currentTimeMillis() - c.e(c.this)) });
        if (c.f(c.this) != null) {
          c.f(c.this).a(new c.b(c.this, c.g(c.this), paramAnonymousString3, paramAnonymousString4));
        }
        AppMethodBeat.o(41334);
      }
    };
    this.taO = new f.a()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41336);
        if (!c.c(c.this).equals(paramAnonymousString1))
        {
          AppMethodBeat.o(41336);
          return;
        }
        ac.d("MicroMsg.Haowan.VideoShareWrapper", "localId:%s, upload video percent:%d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt2) });
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41335);
            c.h(c.this).setProgress(paramAnonymousInt2);
            AppMethodBeat.o(41335);
          }
        });
        AppMethodBeat.o(41336);
      }
    };
    this.context = paramContext;
    this.gDe = paramView;
    this.tcz = ((CycleProgressView)paramView.findViewById(2131298917));
    AppMethodBeat.o(41339);
  }
  
  final void a(final e parame, a parama)
  {
    AppMethodBeat.i(41340);
    if (parame == null)
    {
      AppMethodBeat.o(41340);
      return;
    }
    this.gRx = false;
    this.tcB = parame;
    this.tcC = parama;
    if (parame.dqZ)
    {
      this.gDe.setVisibility(0);
      com.tencent.mm.plugin.game.f.c.bUw().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41332);
          String str = c.tcy + "thumb_" + System.currentTimeMillis() + ".jpg";
          c.a(c.this, parame.videoUrl, str);
          AppMethodBeat.o(41332);
        }
      });
      AppMethodBeat.o(41340);
      return;
    }
    parama.a(new b(parame));
    AppMethodBeat.o(41340);
  }
  
  public final void cPO()
  {
    AppMethodBeat.i(41341);
    this.gRx = true;
    this.gDe.setVisibility(8);
    g.eBZ();
    boolean bool = am.Jy(this.tcA);
    g.eBZ().b(this.taN);
    g.eBZ().b(this.taO);
    ac.i("MicroMsg.Haowan.VideoShareWrapper", "cancel share task ret:%b, localId:%s", new Object[] { Boolean.valueOf(bool), this.tcA });
    AppMethodBeat.o(41341);
  }
  
  static abstract interface a
  {
    public abstract void a(c.b paramb);
  }
  
  final class b
  {
    String hgd;
    String pBm;
    String tcG;
    String tcH;
    String videoUrl;
    
    public b(e parame)
    {
      AppMethodBeat.i(41337);
      Assert.assertTrue("need net video", parame.dqZ);
      this.pBm = parame.appName;
      this.tcG = parame.title;
      this.hgd = parame.sVC;
      this.tcH = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1";
      this.videoUrl = parame.videoUrl;
      AppMethodBeat.o(41337);
    }
    
    public b(e parame, String paramString1, String paramString2)
    {
      AppMethodBeat.i(41338);
      if (!parame.dqZ) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("need local video", bool);
        this.pBm = parame.appName;
        this.tcG = parame.title;
        this.hgd = paramString2;
        this.tcH = "https://game.weixin.qq.com/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1";
        this.videoUrl = paramString1;
        AppMethodBeat.o(41338);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.c
 * JD-Core Version:    0.7.0.1
 */