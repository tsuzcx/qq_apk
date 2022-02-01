package com.tencent.mm.plugin.game.media;

import android.app.Activity;
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
import com.tencent.mm.an.e;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.av.q;
import com.tencent.mm.i.d;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.game.api.g.a;
import com.tencent.mm.plugin.game.commlib.util.b.a;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MD5Util;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.NetStatusUtil;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.vfs.s;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoDownloadUI
  extends MMActivity
{
  private static final String xCf;
  private String Mc;
  private String mAppId;
  private Context mContext;
  private String mFilePath;
  private int mFrom;
  private long njp = 0L;
  private int xAD = 0;
  private String xCg;
  private CycleProgressView xCh;
  private GameVideoDownloadUI.a xCi;
  
  static
  {
    AppMethodBeat.i(41142);
    xCf = com.tencent.mm.plugin.game.commlib.util.b.c(b.a.xvG) + "haowan/";
    AppMethodBeat.o(41142);
  }
  
  private Map Oi(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(41138);
    if (this.njp != 0L) {
      l = System.currentTimeMillis() - this.njp;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("costtime", Long.valueOf(l));
    localHashMap.put("failid", Integer.valueOf(paramInt));
    AppMethodBeat.o(41138);
    return localHashMap;
  }
  
  private void a(String paramString, final g.a parama)
  {
    AppMethodBeat.i(41137);
    final long l = System.currentTimeMillis();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.taskName = "task_GameVideoDownloadUI";
    localh.field_mediaId = this.Mc;
    localh.url = paramString;
    localh.gqU = 0;
    localh.gqP = 3;
    localh.concurrentCount = 4;
    s.boN(s.boZ(this.mFilePath));
    localh.field_fullpath = this.mFilePath;
    localh.gre = new h.a()
    {
      public final void Ds(String paramAnonymousString) {}
      
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
            paramAnonymousString = new com.tencent.mm.vfs.o(GameVideoDownloadUI.i(GameVideoDownloadUI.this));
            if (!paramAnonymousString.exists()) {
              break;
            }
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download file size:%d", new Object[] { Long.valueOf(paramAnonymousString.length()) });
            this.xCp.an(GameVideoDownloadUI.i(GameVideoDownloadUI.this), 0, 0);
            AppMethodBeat.o(41129);
            return;
            Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] fail, ret:%d", new Object[] { parama, Integer.valueOf(paramAnonymousInt) });
          }
          u.makeText(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 2131761363, 1).show();
          if (this.xCp != null) {
            this.xCp.an(GameVideoDownloadUI.i(GameVideoDownloadUI.this), 2, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(41129);
      }
      
      public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(41128);
        Log.d("MicroMsg.Haowan.GameVideoDownloadUI", "download video offset:%d, total:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if ((GameVideoDownloadUI.g(GameVideoDownloadUI.this).equals(paramAnonymousString)) && (paramAnonymousLong2 != 0L)) {
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41127);
              GameVideoDownloadUI.h(GameVideoDownloadUI.this).setProgress((int)(paramAnonymousLong1 * 100L / this.xCr));
              AppMethodBeat.o(41127);
            }
          });
        }
        AppMethodBeat.o(41128);
      }
      
      public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
    };
    this.njp = System.currentTimeMillis();
    this.xCi = new GameVideoDownloadUI.a(this, localh);
    MMHandlerThread.postToMainThreadDelayed(this.xCi, 500L);
    AppMethodBeat.o(41137);
  }
  
  private void azZ(String paramString)
  {
    AppMethodBeat.i(41132);
    a(paramString, new g.a()
    {
      public final void an(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41126);
        String str = paramAnonymousString;
        if (paramAnonymousString != null)
        {
          str = paramAnonymousString;
          if (paramAnonymousString.endsWith(".temp"))
          {
            str = paramAnonymousString.replace(".temp", "");
            s.nx(paramAnonymousString, str);
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
          com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 48, GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.f(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.c(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, 0)));
          MMHandlerThread.postToMainThread(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41125);
              GameVideoDownloadUI.5.this.xCn.setVisibility(8);
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
        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 56, GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.f(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.c(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, paramAnonymousInt2)));
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
  
  private void dUB()
  {
    AppMethodBeat.i(41136);
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "cancel video download!");
    com.tencent.mm.game.report.b.a.a(this.mContext, 8760, 1, 2, this.mAppId, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, Oi(0)));
    if (this.mFrom == 3) {
      n.d(this.xCg, "video download cancel", this.mAppId, -2, "video download cancel");
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
  
  public int getLayoutId()
  {
    return 2131494964;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41133);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 223)
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
    dUB();
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
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.xCg = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    paramBundle = getIntent().getStringExtra("video_url");
    Object localObject1 = getIntent().getStringExtra("thumb_url");
    this.xAD = getIntent().getIntExtra("game_haowan_source_scene_id", 0);
    this.xCh = ((CycleProgressView)findViewById(2131299401));
    findViewById(2131299754).setOnClickListener(new GameVideoDownloadUI.1(this));
    final ImageView localImageView1 = (ImageView)findViewById(2131309774);
    final ImageView localImageView2 = (ImageView)findViewById(2131309745);
    int i = com.tencent.mm.plugin.game.e.c.getScreenWidth(this.mContext);
    int j = i * 1080 / 1920;
    Object localObject2 = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = i;
    ((FrameLayout.LayoutParams)localObject2).height = j;
    localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    localObject2 = q.bcV();
    c.a locala = new c.a();
    locala.jbf = true;
    ((com.tencent.mm.av.a.a)localObject2).a((String)localObject1, localImageView1, locala.bdv(), new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(41122);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41121);
            GameVideoDownloadUI.2.this.xCk.setVisibility(0);
            GameVideoDownloadUI.2.this.xCl.setVisibility(8);
            AppMethodBeat.o(41121);
          }
        });
        AppMethodBeat.o(41122);
      }
    });
    localObject1 = getIntent().getBundleExtra("ext_data");
    if (localObject1 != null)
    {
      this.mFilePath = ((Bundle)localObject1).getString("key_video_cache_path");
      this.Mc = ((Bundle)localObject1).getString("key_video_media_id");
    }
    Log.i("MicroMsg.Haowan.GameVideoDownloadUI", "video cache path:%s", new Object[] { this.mFilePath });
    if (!s.YS(this.mFilePath)) {
      this.mFilePath = (xCf + "MMVideo_" + MD5Util.getMD5String(paramBundle) + ".mp4");
    }
    if (Util.isNullOrNil(this.Mc)) {
      this.Mc = ("MMVideo_" + MD5Util.getMD5String(paramBundle));
    }
    if ((!NetStatusUtil.isWifi(this)) && (this.mFrom == 3)) {
      com.tencent.mm.ui.base.h.a(this, getString(2131761364), "", getString(2131761362), getString(2131761361), false, new GameVideoDownloadUI.3(this, paramBundle), new DialogInterface.OnClickListener()
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
      com.tencent.mm.game.report.b.a.a(this, 8760, 0, 1, this.mAppId, this.xAD, com.tencent.mm.game.report.b.a.c(this.mFrom, null));
      AppMethodBeat.o(41131);
      return;
      azZ(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41134);
    super.onDestroy();
    if (this.xCi != null) {
      MMHandlerThread.removeRunnable(this.xCi);
    }
    com.tencent.mm.modelvideo.o.bhk().m(this.Mc, null);
    AppMethodBeat.o(41134);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI
 * JD-Core Version:    0.7.0.1
 */