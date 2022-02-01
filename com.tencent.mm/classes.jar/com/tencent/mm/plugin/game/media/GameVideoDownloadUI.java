package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.modelcdntran.j;
import com.tencent.mm.modelimage.loader.c.b;
import com.tencent.mm.modelimage.r;
import com.tencent.mm.modelvideo.v;
import com.tencent.mm.plugin.game.commlib.view.CycleProgressView;
import com.tencent.mm.plugin.game.h.e;
import com.tencent.mm.plugin.game.h.f;
import com.tencent.mm.plugin.game.h.i;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoDownloadUI
  extends MMActivity
{
  private static final String IAj;
  private CycleProgressView IAk;
  private int IAu;
  private s IAv;
  private String IAw;
  private a IAx;
  private int IyH;
  private String cY;
  private String mAppId;
  private Context mContext;
  private String mFilePath;
  private int mFrom;
  private long toQ;
  
  static
  {
    AppMethodBeat.i(41142);
    IAj = com.tencent.mm.plugin.game.commlib.e.c.c(com.tencent.mm.plugin.game.commlib.e.c.a.Itm) + "haowan/";
    AppMethodBeat.o(41142);
  }
  
  public GameVideoDownloadUI()
  {
    AppMethodBeat.i(276855);
    this.IAv = new o(this);
    this.toQ = 0L;
    this.IyH = 0;
    AppMethodBeat.o(276855);
  }
  
  private Map Xv(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(41138);
    if (this.toQ != 0L) {
      l = System.currentTimeMillis() - this.toQ;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("costtime", Long.valueOf(l));
    localHashMap.put("failid", Integer.valueOf(paramInt));
    AppMethodBeat.o(41138);
    return localHashMap;
  }
  
  private void a(String paramString, final com.tencent.mm.plugin.game.api.h.a parama)
  {
    AppMethodBeat.i(41137);
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
    localh.lxs = new com.tencent.mm.g.h.a()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt, d paramAnonymousd)
      {
        AppMethodBeat.i(41129);
        Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video mediaId:%s, rawMediaId:%s", new Object[] { paramAnonymousString, GameVideoDownloadUI.g(GameVideoDownloadUI.this) });
        if (GameVideoDownloadUI.g(GameVideoDownloadUI.this).equals(paramAnonymousString))
        {
          Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          if (paramAnonymousInt == 0) {
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] success", new Object[] { parama });
          }
          while ((paramAnonymousInt == 0) && (!TextUtils.isEmpty(GameVideoDownloadUI.i(GameVideoDownloadUI.this))))
          {
            paramAnonymousString = new u(GameVideoDownloadUI.i(GameVideoDownloadUI.this));
            if (!paramAnonymousString.jKS()) {
              break;
            }
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download file size:%d", new Object[] { Long.valueOf(paramAnonymousString.length()) });
            this.IAC.aw(GameVideoDownloadUI.i(GameVideoDownloadUI.this), 0, 0);
            AppMethodBeat.o(41129);
            return;
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] fail, ret:%d", new Object[] { parama, Integer.valueOf(paramAnonymousInt) });
          }
          aa.makeText(GameVideoDownloadUI.e(GameVideoDownloadUI.this), h.i.Ice, 1).show();
          if (this.IAC != null) {
            this.IAC.aw(GameVideoDownloadUI.i(GameVideoDownloadUI.this), 2, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(41129);
      }
      
      public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
      
      public final void h(String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(41128);
        Log.d("MicroMsg.Haowan.GameVideoDownloadUI", "download video offset:%d, total:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if ((GameVideoDownloadUI.g(GameVideoDownloadUI.this).equals(paramAnonymousString)) && (paramAnonymousLong2 != 0L)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41127);
              GameVideoDownloadUI.h(GameVideoDownloadUI.this).setProgress((int)(paramAnonymousLong1 * 100L / this.IAr));
              AppMethodBeat.o(41127);
            }
          });
        }
        AppMethodBeat.o(41128);
      }
      
      public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
      
      public final void onM3U8Ready(String paramAnonymousString1, String paramAnonymousString2) {}
    };
    this.toQ = System.currentTimeMillis();
    this.IAx = new a(localh);
    MMHandlerThread.postToMainThreadDelayed(this.IAx, 500L);
    AppMethodBeat.o(41137);
  }
  
  private void aGz(String paramString)
  {
    AppMethodBeat.i(41132);
    a(paramString, new com.tencent.mm.plugin.game.api.h.a()
    {
      public final void aw(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41126);
        String str = paramAnonymousString;
        if (paramAnonymousString != null)
        {
          str = paramAnonymousString;
          if (paramAnonymousString.endsWith(".temp"))
          {
            str = paramAnonymousString.replace(".temp", "");
            y.qn(paramAnonymousString, str);
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download videoPath:%s", new Object[] { str });
          }
        }
        switch (paramAnonymousInt1)
        {
        case 1: 
        default: 
          AppMethodBeat.o(41126);
          return;
        case 0: 
          com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 48, GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.f(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, 0)));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41125);
              GameVideoDownloadUI.5.this.IAA.setVisibility(8);
              AppMethodBeat.o(41125);
            }
          });
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtras(GameVideoDownloadUI.this.getIntent().getExtras());
          paramAnonymousString.putExtra("video_path", str);
          com.tencent.mm.br.c.b(GameVideoDownloadUI.e(GameVideoDownloadUI.this), "game", ".media.GameVideoEditorProxyUI", paramAnonymousString, 223);
          AppMethodBeat.o(41126);
          return;
        }
        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 56, GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.f(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, paramAnonymousInt2)));
        if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 3) {
          n.d(GameVideoDownloadUI.c(GameVideoDownloadUI.this), "video download err:".concat(String.valueOf(paramAnonymousInt2)), GameVideoDownloadUI.d(GameVideoDownloadUI.this), -3, "video download err:".concat(String.valueOf(paramAnonymousInt2)));
        }
        for (;;)
        {
          GameVideoDownloadUI.this.finish();
          break;
          if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 5) {
            GameVideoDownloadUI.this.setResult(-1, new Intent().putExtra("webview_callback_err", 2));
          }
        }
      }
    });
    AppMethodBeat.o(41132);
  }
  
  private void fFE()
  {
    AppMethodBeat.i(41136);
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "cancel video download!");
    com.tencent.mm.game.report.b.a.a(this.mContext, 8760, 1, 2, this.mAppId, this.IyH, com.tencent.mm.game.report.b.a.a(this.mFrom, Xv(0)));
    if (this.mFrom == 3) {
      n.d(this.IAw, "video download cancel", this.mAppId, -2, "video download cancel");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(41136);
      return;
      if (this.mFrom == 5) {
        setResult(-1, new Intent().putExtra("webview_callback_err", 1));
      }
    }
  }
  
  private boolean fFF()
  {
    return this.IAu == 11;
  }
  
  public int getLayoutId()
  {
    return h.f.Iar;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41133);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if ((!fFF()) && (paramInt1 == 223))
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(41133);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(41135);
    super.onBackPressed();
    if (fFF())
    {
      this.IAv.onBackPressed();
      AppMethodBeat.o(41135);
      return;
    }
    fFE();
    AppMethodBeat.o(41135);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(41131);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    this.mContext = this;
    this.IAu = getIntent().getIntExtra("game_from", -1);
    if (fFF())
    {
      this.IAv.onCreate();
      AppMethodBeat.o(41131);
      return;
    }
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.IAw = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    paramBundle = getIntent().getStringExtra("video_url");
    Object localObject1 = getIntent().getStringExtra("thumb_url");
    this.IyH = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    this.IAk = ((CycleProgressView)findViewById(h.e.HTL));
    findViewById(h.e.HTM).setOnClickListener(new GameVideoDownloadUI.1(this));
    final ImageView localImageView1 = (ImageView)findViewById(h.e.HYg);
    final ImageView localImageView2 = (ImageView)findViewById(h.e.HYe);
    int i = com.tencent.mm.plugin.game.d.c.getScreenWidth(this.mContext);
    int j = i * 1080 / 1920;
    Object localObject2 = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = i;
    ((FrameLayout.LayoutParams)localObject2).height = j;
    localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    localObject2 = r.bKe();
    com.tencent.mm.modelimage.loader.a.c.a locala = new com.tencent.mm.modelimage.loader.a.c.a();
    locala.oKp = true;
    ((com.tencent.mm.modelimage.loader.a)localObject2).a((String)localObject1, localImageView1, locala.bKx(), new com.tencent.mm.modelimage.loader.b.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView, b paramAnonymousb)
      {
        AppMethodBeat.i(41122);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41121);
            GameVideoDownloadUI.2.this.IAn.setVisibility(0);
            GameVideoDownloadUI.2.this.IAo.setVisibility(8);
            AppMethodBeat.o(41121);
          }
        });
        AppMethodBeat.o(41122);
      }
      
      public final void c(String paramAnonymousString, View paramAnonymousView) {}
    });
    localObject1 = getIntent().getBundleExtra("ext_data");
    if (localObject1 != null)
    {
      this.mFilePath = ((Bundle)localObject1).getString("key_video_cache_path");
      this.cY = ((Bundle)localObject1).getString("key_video_media_id");
    }
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "video cache path:%s", new Object[] { this.mFilePath });
    if (!y.ZC(this.mFilePath)) {
      this.mFilePath = (IAj + "MMVideo_" + MD5Util.getMD5String(paramBundle) + ".mp4");
    }
    if (Util.isNullOrNil(this.cY)) {
      this.cY = ("MMVideo_" + MD5Util.getMD5String(paramBundle));
    }
    if ((!NetStatusUtil.isWifi(this)) && (this.mFrom == 3)) {
      k.a(this, getString(h.i.Icg), "", getString(h.i.Icd), getString(h.i.Icc), false, new GameVideoDownloadUI.3(this, paramBundle), new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(41124);
          if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 3) {
            n.d(GameVideoDownloadUI.c(GameVideoDownloadUI.this), "video download cancel", GameVideoDownloadUI.d(GameVideoDownloadUI.this), -2, "video download cancel");
          }
          for (;;)
          {
            GameVideoDownloadUI.this.finish();
            AppMethodBeat.o(41124);
            return;
            if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 5) {
              GameVideoDownloadUI.this.setResult(-1, new Intent().putExtra("webview_callback_err", 1));
            }
          }
        }
      });
    }
    for (;;)
    {
      Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "onCreate");
      com.tencent.mm.game.report.b.a.a(this, 8760, 0, 1, this.mAppId, this.IyH, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      AppMethodBeat.o(41131);
      return;
      aGz(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41134);
    super.onDestroy();
    if (fFF())
    {
      this.IAv.onDestroy();
      AppMethodBeat.o(41134);
      return;
    }
    if (this.IAx != null) {
      MMHandlerThread.removeRunnable(this.IAx);
    }
    v.bOi().l(this.cY, null);
    AppMethodBeat.o(41134);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
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
      AppMethodBeat.i(41130);
      if (this.IAt != null) {
        v.bOi().a(this.IAt, false);
      }
      AppMethodBeat.o(41130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI
 * JD-Core Version:    0.7.0.1
 */