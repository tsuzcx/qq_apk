package com.tencent.mm.plugin.game.media.preview;

import android.content.Context;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.autogen.b.e;
import com.tencent.mm.plugin.game.commlib.view.CycleProgressView;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.i;
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
  private static final String IBT;
  private f.b IAd;
  private f.a IAe;
  private CycleProgressView IBU;
  private String IBV;
  private e IBW;
  private a IBX;
  private Context context;
  private View njN;
  private boolean nzW;
  private long startTime;
  
  static
  {
    AppMethodBeat.i(41345);
    IBT = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Itm) + "haowan/";
    AppMethodBeat.o(41345);
  }
  
  public c(Context paramContext, View paramView)
  {
    AppMethodBeat.i(41339);
    this.nzW = false;
    this.IAd = new f.b()
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
    this.IAe = new f.a()
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
    this.njN = paramView;
    this.IBU = ((CycleProgressView)paramView.findViewById(h.e.HTL));
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
    this.nzW = false;
    this.IBW = parame;
    this.IBX = parama;
    if (parame.hJv)
    {
      this.njN.setVisibility(0);
      com.tencent.mm.plugin.game.d.c.dqg().postToWorker(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(41332);
          String str = c.IBT + "thumb_" + System.currentTimeMillis() + ".jpg";
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
  
  public final void fFN()
  {
    AppMethodBeat.i(41341);
    this.nzW = true;
    this.njN.setVisibility(8);
    g.ivY();
    boolean bool = an.WU(this.IBV);
    g.ivY().b(this.IAd);
    g.ivY().b(this.IAe);
    Log.i("MicroMsg.Haowan.VideoShareWrapper", "cancel share task ret:%b, localId:%s", new Object[] { Boolean.valueOf(bool), this.IBV });
    AppMethodBeat.o(41341);
  }
  
  static abstract interface a
  {
    public abstract void a(c.b paramb);
  }
  
  final class b
  {
    String ICb;
    String ICc;
    String imageUrl;
    String svG;
    String videoUrl;
    
    public b(e parame)
    {
      AppMethodBeat.i(41337);
      Assert.assertTrue("need net video", parame.hJv);
      this.svG = parame.appName;
      this.ICb = parame.title;
      this.imageUrl = parame.Idm;
      this.ICc = ("https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1");
      this.videoUrl = parame.videoUrl;
      AppMethodBeat.o(41337);
    }
    
    public b(e parame, String paramString1, String paramString2)
    {
      AppMethodBeat.i(41338);
      if (!parame.hJv) {}
      for (boolean bool = true;; bool = false)
      {
        Assert.assertTrue("need local video", bool);
        this.svG = parame.appName;
        this.ICb = parame.title;
        this.imageUrl = paramString2;
        this.ICc = ("https://" + WeChatHosts.domainString(h.i.host_game_weixin_qq_com) + "/cgi-bin/h5/static/appcenter/index.html?v_d=eY1maoA1&no_cache=1");
        this.videoUrl = paramString1;
        AppMethodBeat.o(41338);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.preview.c
 * JD-Core Version:    0.7.0.1
 */