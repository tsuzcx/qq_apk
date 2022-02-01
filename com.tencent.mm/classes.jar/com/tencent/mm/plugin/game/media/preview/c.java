package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.i.a;
import com.tencent.mm.plugin.game.b.b.e;
import com.tencent.mm.plugin.game.commlib.util.b;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.plugin.game.media.CycleProgressView;
import com.tencent.mm.plugin.webview.model.WebViewJSSDKVideoItem;
import com.tencent.mm.plugin.webview.model.an;
import com.tencent.mm.plugin.webview.model.f.a;
import com.tencent.mm.plugin.webview.model.f.b;
import com.tencent.mm.plugin.webview.modeltools.g;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.WeChatHosts;
import junit.framework.Assert;

public final class c
{
  private static final String xDI;
  private Context context;
  private View hSw;
  private boolean ifz;
  private long startTime;
  private f.b xBY;
  private f.a xBZ;
  private CycleProgressView xDJ;
  private String xDK;
  private e xDL;
  private a xDM;
  
  static
  {
    AppMethodBeat.i(41345);
    xDI = b.c(b.a.xvG) + "haowan/";
    AppMethodBeat.o(41345);
  }
  
  public c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(41339);
    this.ifz = false;
    this.xBY = new f.b()
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
        Log.i("MicroMsg.Haowan.VideoShareWrapper", "success : %b, errCode: %d, localId : %s, mediaId : %s, mediaUrl : %s, costTime: %d", new Object[] { Boolean.valueOf(paramAnonymousBoolean), Integer.valueOf(paramAnonymousInt), paramAnonymousString1, paramAnonymousString2, paramAnonymousString3, Long.valueOf(System.currentTimeMillis() - c.e(c.this)) });
        if (c.f(c.this) != null) {
          c.f(c.this).a(new c.b(c.this, c.g(c.this), paramAnonymousString3, paramAnonymousString4));
        }
        AppMethodBeat.o(41334);
      }
    };
    this.xBZ = new f.a()
    {
      public final void a(boolean paramAnonymousBoolean, int paramAnonymousInt1, final int paramAnonymousInt2, String paramAnonymousString1, String paramAnonymousString2)
      {
        AppMethodBeat.i(41336);
        if (!c.c(c.this).equals(paramAnonymousString1))
        {
          AppMethodBeat.o(41336);
          return;
        }
        Log.d("MicroMsg.Haowan.VideoShareWrapper", "localId:%s, upload video percent:%d", new Object[] { paramAnonymousString1, Integer.valueOf(paramAnonymousInt2) });
        MMHandlerThread.postToMainThread(new Runnable()
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
    this.hSw = paramView;
    this.xDJ = ((CycleProgressView)paramView.findViewById(2131299401));
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
    this.ifz = false;
    this.xDL = parame;
    this.xDM = parama;
    if (parame.dLQ)
    {
      this.hSw.setVisibility(0);
      com.tencent.mm.plugin.game.e.c.cyh().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41332);
          String str = c.xDI + "thumb_" + System.currentTimeMillis() + ".jpg";
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
  
  public final void dUK()
  {
    AppMethodBeat.i(41341);
    this.ifz = true;
    this.hSw.setVisibility(8);
    g.gdu();
    boolean bool = an.WG(this.xDK);
    g.gdu().b(this.xBY);
    g.gdu().b(this.xBZ);
    Log.i("MicroMsg.Haowan.VideoShareWrapper", "cancel share task ret:%b, localId:%s", new Object[] { Boolean.valueOf(bool), this.xDK });
    AppMethodBeat.o(41341);
  }
  
  static abstract interface a
  {
    public abstract void a(c.b paramb);
  }
  
  final class b
  {
    String imageUrl;
    String msN;
    String videoUrl;
    String xDQ;
    String xDR;
    
    public b(e parame)
    {
      AppMethodBeat.i(41337);
      Assert.assertTrue("need net video", parame.dLQ);
      this.msN = parame.appName;
      this.xDQ = parame.title;
      this.imageUrl = parame.xuM;
      this.xDR = ("https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1");
      this.videoUrl = parame.videoUrl;
      AppMethodBeat.o(41337);
    }
    
    public b(e parame, String paramString1, String paramString2)
    {
      AppMethodBeat.i(41338);
      if (!parame.dLQ) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("need local video", bool);
        this.msN = parame.appName;
        this.xDQ = parame.title;
        this.imageUrl = paramString2;
        this.xDR = ("https://" + WeChatHosts.domainString(2131761707) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1");
        this.videoUrl = paramString1;
        AppMethodBeat.o(41338);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.c
 * JD-Core Version:    0.7.0.1
 */