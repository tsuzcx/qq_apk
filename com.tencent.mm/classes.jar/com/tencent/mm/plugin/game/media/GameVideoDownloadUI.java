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
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.av.a.a.c.a;
import com.tencent.mm.i.h.a;
import com.tencent.mm.plugin.game.api.f.a;
import com.tencent.mm.plugin.game.commlib.e.b.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.ax;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.vfs.i;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoDownloadUI
  extends MMActivity
{
  private static final String taU;
  private String Kc;
  private long lxJ = 0L;
  private String mAppId;
  private Context mContext;
  private String mFilePath;
  private int mFrom;
  private String taV;
  private CycleProgressView taW;
  private a taX;
  
  static
  {
    AppMethodBeat.i(41142);
    taU = com.tencent.mm.plugin.game.commlib.e.b.b(b.a.sWv) + "haowan/";
    AppMethodBeat.o(41142);
  }
  
  private Map Gq(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(41138);
    if (this.lxJ != 0L) {
      l = System.currentTimeMillis() - this.lxJ;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("costtime", Long.valueOf(l));
    localHashMap.put("failid", Integer.valueOf(paramInt));
    AppMethodBeat.o(41138);
    return localHashMap;
  }
  
  private void a(String paramString, final f.a parama)
  {
    AppMethodBeat.i(41137);
    final long l = System.currentTimeMillis();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = this.Kc;
    localh.url = paramString;
    localh.frw = 0;
    localh.frr = 3;
    localh.concurrentCount = 4;
    i.aSh(i.aSs(this.mFilePath));
    localh.field_fullpath = this.mFilePath;
    localh.frE = new h.a()
    {
      public final void a(String paramAnonymousString, int paramAnonymousInt, com.tencent.mm.i.d paramAnonymousd)
      {
        AppMethodBeat.i(41129);
        ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video mediaId:%s, rawMediaId:%s", new Object[] { paramAnonymousString, GameVideoDownloadUI.f(GameVideoDownloadUI.this) });
        if (GameVideoDownloadUI.f(GameVideoDownloadUI.this).equals(paramAnonymousString))
        {
          ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video cost time:%d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
          if (paramAnonymousInt == 0) {
            ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] success", new Object[] { parama });
          }
          while ((paramAnonymousInt == 0) && (!TextUtils.isEmpty(GameVideoDownloadUI.h(GameVideoDownloadUI.this))))
          {
            paramAnonymousString = new com.tencent.mm.vfs.e(GameVideoDownloadUI.h(GameVideoDownloadUI.this));
            if (!paramAnonymousString.exists()) {
              break;
            }
            ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download file size:%d", new Object[] { Long.valueOf(paramAnonymousString.length()) });
            this.tbe.ag(GameVideoDownloadUI.h(GameVideoDownloadUI.this), 0, 0);
            AppMethodBeat.o(41129);
            return;
            ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download video[%s] fail, ret:%d", new Object[] { parama, Integer.valueOf(paramAnonymousInt) });
          }
          t.makeText(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 2131759999, 1).show();
          if (this.tbe != null) {
            this.tbe.ag(GameVideoDownloadUI.h(GameVideoDownloadUI.this), 2, paramAnonymousInt);
          }
        }
        AppMethodBeat.o(41129);
      }
      
      public final void a(String paramAnonymousString1, long paramAnonymousLong1, long paramAnonymousLong2, String paramAnonymousString2) {}
      
      public final void i(String paramAnonymousString, final long paramAnonymousLong1, long paramAnonymousLong2)
      {
        AppMethodBeat.i(41128);
        ac.d("MicroMsg.Haowan.GameVideoDownloadUI", "download video offset:%d, total:%d", new Object[] { Long.valueOf(paramAnonymousLong1), Long.valueOf(paramAnonymousLong2) });
        if ((GameVideoDownloadUI.f(GameVideoDownloadUI.this).equals(paramAnonymousString)) && (paramAnonymousLong2 != 0L)) {
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41127);
              GameVideoDownloadUI.g(GameVideoDownloadUI.this).setProgress((int)(paramAnonymousLong1 * 100L / this.tbg));
              AppMethodBeat.o(41127);
            }
          });
        }
        AppMethodBeat.o(41128);
      }
      
      public final void onDataAvailable(String paramAnonymousString, long paramAnonymousLong1, long paramAnonymousLong2) {}
    };
    this.lxJ = System.currentTimeMillis();
    this.taX = new a(localh);
    ap.n(this.taX, 500L);
    AppMethodBeat.o(41137);
  }
  
  private void ahi(String paramString)
  {
    AppMethodBeat.i(41132);
    a(paramString, new f.a()
    {
      public final void ag(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(41126);
        String str = paramAnonymousString;
        if (paramAnonymousString != null)
        {
          str = paramAnonymousString;
          if (paramAnonymousString.endsWith(".temp"))
          {
            str = paramAnonymousString.replace(".temp", "");
            i.ma(paramAnonymousString, str);
            ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "download videoPath:%s", new Object[] { str });
          }
        }
        switch (paramAnonymousInt1)
        {
        case 1: 
        default: 
          AppMethodBeat.o(41126);
          return;
        case 0: 
          com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 48, GameVideoDownloadUI.d(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, 0)));
          ap.f(new Runnable()
          {
            public final void run()
            {
              AppMethodBeat.i(41125);
              GameVideoDownloadUI.5.this.tbc.setVisibility(8);
              AppMethodBeat.o(41125);
            }
          });
          paramAnonymousString = new Intent();
          paramAnonymousString.putExtras(GameVideoDownloadUI.this.getIntent().getExtras());
          paramAnonymousString.putExtra("video_path", str);
          com.tencent.mm.br.d.b(GameVideoDownloadUI.e(GameVideoDownloadUI.this), "game", ".media.GameVideoEditorProxyUI", paramAnonymousString, 223);
          AppMethodBeat.o(41126);
          return;
        }
        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.e(GameVideoDownloadUI.this), 8760, 0, 56, GameVideoDownloadUI.d(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, paramAnonymousInt2)));
        if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 3) {
          l.d(GameVideoDownloadUI.c(GameVideoDownloadUI.this), "video download err:".concat(String.valueOf(paramAnonymousInt2)), GameVideoDownloadUI.d(GameVideoDownloadUI.this), -3, "video download err:".concat(String.valueOf(paramAnonymousInt2)));
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
  
  private void cPE()
  {
    AppMethodBeat.i(41136);
    ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "cancel video download!");
    com.tencent.mm.game.report.b.a.a(this.mContext, 8760, 1, 2, this.mAppId, com.tencent.mm.game.report.b.a.a(this.mFrom, Gq(0)));
    if (this.mFrom == 3) {
      l.d(this.taV, "video download cancel", this.mAppId, -2, "video download cancel");
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
    return 2131494398;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(41133);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
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
    cPE();
    AppMethodBeat.o(41135);
  }
  
  public void onCreate(final Bundle paramBundle)
  {
    AppMethodBeat.i(41131);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.taV = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    paramBundle = getIntent().getStringExtra("video_url");
    Object localObject1 = getIntent().getStringExtra("thumb_url");
    this.taW = ((CycleProgressView)findViewById(2131298917));
    findViewById(2131299198).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(41120);
        GameVideoDownloadUI.a(GameVideoDownloadUI.this);
        AppMethodBeat.o(41120);
      }
    });
    final ImageView localImageView1 = (ImageView)findViewById(2131306348);
    final ImageView localImageView2 = (ImageView)findViewById(2131306324);
    int i = c.getScreenWidth(this.mContext);
    int j = i * 1080 / 1920;
    Object localObject2 = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
    ((FrameLayout.LayoutParams)localObject2).width = i;
    ((FrameLayout.LayoutParams)localObject2).height = j;
    localImageView2.setLayoutParams((ViewGroup.LayoutParams)localObject2);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    localObject2 = com.tencent.mm.av.o.aFB();
    c.a locala = new c.a();
    locala.hKx = true;
    ((com.tencent.mm.av.a.a)localObject2).a((String)localObject1, localImageView1, locala.aFT(), new com.tencent.mm.av.a.c.h()
    {
      public final Bitmap a(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        return null;
      }
      
      public final void b(String paramAnonymousString, View paramAnonymousView) {}
      
      public final void b(String paramAnonymousString, View paramAnonymousView, com.tencent.mm.av.a.d.b paramAnonymousb)
      {
        AppMethodBeat.i(41122);
        ap.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(41121);
            GameVideoDownloadUI.2.this.taZ.setVisibility(0);
            GameVideoDownloadUI.2.this.tba.setVisibility(8);
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
      this.Kc = ((Bundle)localObject1).getString("key_video_media_id");
    }
    ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "video cache path:%s", new Object[] { this.mFilePath });
    if (!i.eA(this.mFilePath)) {
      this.mFilePath = (taU + "MMVideo_" + ah.dg(paramBundle) + ".mp4");
    }
    if (bs.isNullOrNil(this.Kc)) {
      this.Kc = ("MMVideo_" + ah.dg(paramBundle));
    }
    if ((!ax.isWifi(this)) && (this.mFrom == 3)) {
      com.tencent.mm.ui.base.h.a(this, getString(2131760000), "", getString(2131759998), getString(2131759997), false, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(41123);
          GameVideoDownloadUI.a(GameVideoDownloadUI.this, paramBundle);
          AppMethodBeat.o(41123);
        }
      }, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(41124);
          if (GameVideoDownloadUI.b(GameVideoDownloadUI.this) == 3) {
            l.d(GameVideoDownloadUI.c(GameVideoDownloadUI.this), "video download cancel", GameVideoDownloadUI.d(GameVideoDownloadUI.this), -2, "video download cancel");
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
      ac.i("MicroMsg.Haowan.GameVideoDownloadUI", "onCreate");
      com.tencent.mm.game.report.b.a.a(this, 8760, 0, 1, this.mAppId, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      AppMethodBeat.o(41131);
      return;
      ahi(paramBundle);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(41134);
    super.onDestroy();
    if (this.taX != null) {
      ap.aB(this.taX);
    }
    com.tencent.mm.modelvideo.o.aJz().k(this.Kc, null);
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
    private com.tencent.mm.i.h tbi;
    
    public a(com.tencent.mm.i.h paramh)
    {
      this.tbi = paramh;
    }
    
    public final void run()
    {
      AppMethodBeat.i(41130);
      if (this.tbi != null) {
        com.tencent.mm.modelvideo.o.aJz().a(this.tbi, false);
      }
      AppMethodBeat.o(41130);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameVideoDownloadUI
 * JD-Core Version:    0.7.0.1
 */