package com.tencent.mm.plugin.game.media;

import android.content.Intent;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.g.h.a;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelimage.loader.a;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.plugin.game.commlib.view.CycleProgressView;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import com.tencent.threadpool.i;

public final class o
  implements s
{
  private static final String IAj;
  private CycleProgressView IAk;
  private a IAl;
  private String cY;
  private String mFilePath;
  private MMActivity pVV;
  
  static
  {
    AppMethodBeat.i(276848);
    IAj = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Itm) + "video/";
    AppMethodBeat.o(276848);
  }
  
  public o(MMActivity paramMMActivity)
  {
    this.pVV = paramMMActivity;
  }
  
  private void aGy(String paramString)
  {
    AppMethodBeat.i(276833);
    final long l = System.currentTimeMillis();
    com.tencent.mm.g.h localh = new com.tencent.mm.g.h();
    localh.taskName = "task_GameVideoDownloadUI";
    localh.field_mediaId = this.cY;
    localh.url = paramString;
    localh.lxi = 0;
    localh.lxc = 3;
    localh.concurrentCount = 4;
    y.bDX(y.bEo(this.mFilePath));
    localh.field_fullpath = this.mFilePath;
    localh.lxs = new h.a()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(276814);
        Log.i("MicroMsg.GameVideoDownloadPerform", "download video mediaId:%s, rawMediaId:%s", new Object[] { paramAnonymousString, o.b(o.this) });
        if (o.b(o.this).equals(paramAnonymousString))
        {
          Log.i("MicroMsg.GameVideoDownloadPerform", "download video cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          if (paramAnonymousInt == 0) {
            Log.i("MicroMsg.GameVideoDownloadPerform", "download video[%s] success", new Object[] { this.Alb });
          }
          while ((paramAnonymousInt == 0) && (!TextUtils.isEmpty(o.d(o.this))))
          {
            paramAnonymousString = new u(o.d(o.this));
            if (!paramAnonymousString.jKS()) {
              break;
            }
            Log.i("MicroMsg.GameVideoDownloadPerform", "download file size:%d", new Object[] { Long.valueOf(paramAnonymousString.length()) });
            paramAnonymousString = ExportFileUtil.P(o.e(o.this), o.d(o.this));
            if (paramAnonymousString != null) {
              AndroidMediaUtil.refreshMediaScanner(paramAnonymousString, MMApplicationContext.getContext());
            }
            o.a(o.this, 0);
            AppMethodBeat.o(276814);
            return;
            Log.i("MicroMsg.GameVideoDownloadPerform", "download video[%s] fail, ret:%d", new Object[] { this.Alb, Integer.valueOf(paramAnonymousInt) });
          }
          o.a(o.this, paramAnonymousInt);
        }
        AppMethodBeat.o(276814);
      }
      
      public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
      
      public final void h(String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(276811);
        Log.d("MicroMsg.GameVideoDownloadPerform", "download video offset:%d, total:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if ((o.b(o.this).equals(paramAnonymousString)) && (paramAnonymousLong2 != 0L)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(276804);
              o.c(o.this).setProgress((int)(paramAnonymousLong1 * 100L / this.IAr));
              AppMethodBeat.o(276804);
            }
          });
        }
        AppMethodBeat.o(276811);
      }
      
      public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public final void onM3U8Ready(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    this.IAl = new a(localh);
    MMHandlerThread.postToMainThreadDelayed(this.IAl, 500L);
    AppMethodBeat.o(276833);
  }
  
  private void fFE()
  {
    AppMethodBeat.i(276829);
    Log.i("MicroMsg.GameVideoDownloadPerform", "cancel video download!");
    this.pVV.setResult(0);
    this.pVV.finish();
    AppMethodBeat.o(276829);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(276851);
    fFE();
    AppMethodBeat.o(276851);
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(276849);
    String str1 = this.pVV.getIntent().getStringExtra("video_url");
    String str2 = this.pVV.getIntent().getStringExtra("thumb_url");
    this.IAk = ((CycleProgressView)this.pVV.findViewById(h.e.HTL));
    this.pVV.findViewById(h.e.HTM).setOnClickListener(new o.1(this));
    final ImageView localImageView1 = (ImageView)this.pVV.findViewById(h.e.HYg);
    final ImageView localImageView2 = (ImageView)this.pVV.findViewById(h.e.HYe);
    int i = com.tencent.mm.plugin.game.d.c.getScreenWidth(this.pVV);
    int j = i * 1080 / 1920;
    Object localObject = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject).width = i;
    ((FrameLayout.LayoutParams)localObject).height = j;
    localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    localObject = r.bKe();
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    ((a)localObject).a(str2, localImageView1, locala.bKx(), new com.tencent.mm.modelimage.loader.b.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
      {
        AppMethodBeat.i(276810);
        com.tencent.threadpool.h.ahAA.bk(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(276854);
            o.2.this.IAn.setVisibility(0);
            o.2.this.IAo.setVisibility(8);
            AppMethodBeat.o(276854);
          }
        });
        AppMethodBeat.o(276810);
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView) {}
    });
    this.mFilePath = (IAj + "MMVideo_" + MD5Util.getMD5String(str1) + ".mp4");
    this.cY = ("MMVideo_" + MD5Util.getMD5String(str1));
    if (!NetStatusUtil.isWifi(this.pVV)) {
      k.a(this.pVV, this.pVV.getString(h.i.Icf), "", this.pVV.getString(h.i.Icd), this.pVV.getString(h.i.Icc), false, new o.3(this, str1), new o.4(this));
    }
    for (;;)
    {
      Log.i("MicroMsg.GameVideoDownloadPerform", "onCreate");
      AppMethodBeat.o(276849);
      return;
      aGy(str1);
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(276850);
    if (this.IAl != null) {
      MMHandlerThread.removeRunnable(this.IAl);
    }
    v.bOi().l(this.cY, null);
    AppMethodBeat.o(276850);
  }
  
  final class a
    implements Runnable
  {
    private com.tencent.mm.g.h IAt;
    
    public a(com.tencent.mm.g.h paramh)
    {
      this.IAt = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(276803);
      if (this.IAt != null) {
        v.bOi().a(this.IAt, false);
      }
      AppMethodBeat.o(276803);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.o
 * JD-Core Version:    0.7.0.1
 */