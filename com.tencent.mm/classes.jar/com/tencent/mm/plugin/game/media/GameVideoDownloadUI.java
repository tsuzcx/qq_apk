package com.tencent.mm.plugin.game.media;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.bq.d;
import com.tencent.mm.plugin.game.api.f.a;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.pluginsdk.ui.tools.i;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.at;
import com.tencent.mm.ui.MMActivity;
import java.util.HashMap;
import java.util.Map;

@com.tencent.mm.ui.base.a(19)
public class GameVideoDownloadUI
  extends MMActivity
{
  private String Cu;
  private long itL = 0L;
  private String mAppId;
  private Context mContext;
  private int mFrom;
  private CycleProgressView nlA;
  private String nlz;
  
  private void Qa(String paramString)
  {
    AppMethodBeat.i(151856);
    a(paramString, new f.a()
    {
      public final void ah(String paramAnonymousString, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(151851);
        switch (paramAnonymousInt1)
        {
        case 1: 
        default: 
          AppMethodBeat.o(151851);
          return;
        case 0: 
          com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), 0, 48, GameVideoDownloadUI.c(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, 0)));
          al.d(new GameVideoDownloadUI.5.1(this));
          Intent localIntent = new Intent();
          localIntent.putExtras(GameVideoDownloadUI.this.getIntent().getExtras());
          localIntent.putExtra("video_path", paramAnonymousString);
          d.b(GameVideoDownloadUI.b(GameVideoDownloadUI.this), "game", ".media.GameVideoEditorProxyUI", localIntent, 223);
          AppMethodBeat.o(151851);
          return;
        }
        com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.b(GameVideoDownloadUI.this), 0, 56, GameVideoDownloadUI.c(GameVideoDownloadUI.this), com.tencent.mm.game.report.b.a.a(GameVideoDownloadUI.d(GameVideoDownloadUI.this), GameVideoDownloadUI.a(GameVideoDownloadUI.this, paramAnonymousInt2)));
        if (GameVideoDownloadUI.d(GameVideoDownloadUI.this) == 1) {
          i.c(GameVideoDownloadUI.e(GameVideoDownloadUI.this), "video download err:".concat(String.valueOf(paramAnonymousInt2)), GameVideoDownloadUI.c(GameVideoDownloadUI.this), -3, "video download err:".concat(String.valueOf(paramAnonymousInt2)));
        }
        for (;;)
        {
          GameVideoDownloadUI.this.finish();
          break;
          if (GameVideoDownloadUI.d(GameVideoDownloadUI.this) == 4) {
            GameVideoDownloadUI.this.setResult(-1, new Intent().putExtra("webview_callback_err", 2));
          }
        }
      }
    });
    AppMethodBeat.o(151856);
  }
  
  private void a(String paramString, f.a parama)
  {
    AppMethodBeat.i(151859);
    this.Cu = ("GameVideo_" + (paramString.hashCode() & 0x7FFFFFFF));
    Object localObject = new StringBuilder();
    com.tencent.mm.modelvideo.o.alD();
    localObject = com.tencent.mm.modelvideo.o.getAccVideoPath() + "game_cloud_" + (paramString.hashCode() & 0x7FFFFFFF) + ".mp4";
    long l = System.currentTimeMillis();
    com.tencent.mm.i.h localh = new com.tencent.mm.i.h();
    localh.field_mediaId = this.Cu;
    localh.url = paramString;
    localh.edJ = 0;
    localh.edE = 6;
    localh.concurrentCount = 4;
    com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK((String)localObject));
    localh.field_fullpath = ((String)localObject);
    localh.edQ = new GameVideoDownloadUI.6(this, l, paramString, (String)localObject, parama);
    this.itL = System.currentTimeMillis();
    com.tencent.mm.modelvideo.o.alF().a(localh, false);
    AppMethodBeat.o(151859);
  }
  
  private Map xb(int paramInt)
  {
    long l = 0L;
    AppMethodBeat.i(151860);
    if (this.itL != 0L) {
      l = System.currentTimeMillis() - this.itL;
    }
    HashMap localHashMap = new HashMap();
    localHashMap.put("costtime", Long.valueOf(l));
    localHashMap.put("failid", Integer.valueOf(paramInt));
    AppMethodBeat.o(151860);
    return localHashMap;
  }
  
  public int getLayoutId()
  {
    return 2130969831;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(151857);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ab.i("MicroMsg.GameVideoDownloadUI", "requestCode:%d, resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    if (paramInt1 == 223)
    {
      setResult(paramInt2, paramIntent);
      finish();
    }
    AppMethodBeat.o(151857);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(151858);
    super.onBackPressed();
    ab.i("MicroMsg.GameVideoDownloadUI", "cancel video download!");
    com.tencent.mm.modelvideo.o.alF().j(this.Cu, null);
    com.tencent.mm.game.report.b.a.a(this.mContext, 1, 2, this.mAppId, com.tencent.mm.game.report.b.a.a(this.mFrom, xb(0)));
    if (this.mFrom == 1) {
      i.c(this.nlz, "video download cancel", this.mAppId, -2, "video download cancel");
    }
    for (;;)
    {
      finish();
      AppMethodBeat.o(151858);
      return;
      if (this.mFrom == 4) {
        setResult(-1, new Intent().putExtra("webview_callback_err", 1));
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(151855);
    supportRequestWindowFeature(1);
    super.onCreate(paramBundle);
    setSelfNavigationBarVisible(8);
    getWindow().addFlags(2097280);
    getWindow().setFlags(201327616, 201327616);
    this.mContext = this;
    this.mFrom = getIntent().getIntExtra("from", -1);
    this.nlz = getIntent().getStringExtra("business_type");
    this.mAppId = getIntent().getStringExtra("appid");
    paramBundle = getIntent().getStringExtra("video_url");
    String str = getIntent().getStringExtra("thumb_url");
    this.nlA = ((CycleProgressView)findViewById(2131824786));
    findViewById(2131824787).setOnClickListener(new GameVideoDownloadUI.1(this));
    ImageView localImageView1 = (ImageView)findViewById(2131824784);
    ImageView localImageView2 = (ImageView)findViewById(2131824785);
    int i = c.getScreenWidth(this.mContext);
    int j = i * 1080 / 1920;
    FrameLayout.LayoutParams localLayoutParams = (FrameLayout.LayoutParams)localImageView2.getLayoutParams();
    localLayoutParams.width = i;
    localLayoutParams.height = j;
    localImageView2.setLayoutParams(localLayoutParams);
    localImageView1.setVisibility(8);
    localImageView2.setVisibility(0);
    com.tencent.mm.at.o.ahG().a(str, localImageView1, new GameVideoDownloadUI.2(this, localImageView1, localImageView2));
    if ((!at.isWifi(this)) && (this.mFrom == 1)) {
      com.tencent.mm.ui.base.h.a(this, getString(2131300472), "", getString(2131300470), getString(2131300469), false, new GameVideoDownloadUI.3(this, paramBundle), new GameVideoDownloadUI.4(this));
    }
    for (;;)
    {
      ab.i("MicroMsg.GameVideoDownloadUI", "onCreate");
      com.tencent.mm.game.report.b.a.a(this, 0, 1, this.mAppId, com.tencent.mm.game.report.b.a.a(this.mFrom, null));
      AppMethodBeat.o(151855);
      return;
      Qa(paramBundle);
    }
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