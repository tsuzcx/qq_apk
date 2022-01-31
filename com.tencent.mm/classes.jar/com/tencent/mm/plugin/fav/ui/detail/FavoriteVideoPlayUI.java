package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.ui.i.5;
import com.tencent.mm.plugin.fav.ui.n.d;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.plugin.fav.ui.n.f;
import com.tencent.mm.plugin.fav.ui.n.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.f;
import com.tencent.mm.pluginsdk.ui.tools.l;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ai;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

@a(3)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private boolean bTT = true;
  private String erh;
  private com.tencent.mm.ui.tools.e itA;
  private int itB = 0;
  private int itC = 0;
  private int itD = 0;
  private int itE = 0;
  private Bundle ity;
  private boolean itz = false;
  private int jlu;
  private View.OnClickListener kdc = new FavoriteVideoPlayUI.1(this);
  private View.OnLongClickListener kfL = new FavoriteVideoPlayUI.2(this);
  private int kgA;
  private boolean kgB = false;
  private String kgC = "";
  private boolean kgc = true;
  private String kgu;
  private RelativeLayout kgv;
  private ImageView kgw;
  private FavVideoView kgx;
  private LinearLayout kgy;
  private boolean kgz = true;
  private String thumbPath;
  
  private void e(ImageView paramImageView)
  {
    this.kgx.a(this.erh, this.kgB, this.kgC);
    if (paramImageView != null)
    {
      if (!com.tencent.mm.vfs.e.bK(this.thumbPath)) {
        break label53;
      }
      paramImageView.setImageBitmap(BackwardSupportUtil.b.e(this.thumbPath, 1.0F));
    }
    for (;;)
    {
      y.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
      return;
      label53:
      paramImageView.setImageResource(n.d.chat_video_nf_mask_from);
    }
  }
  
  public static void f(String paramString, Context paramContext)
  {
    String str = u.of(paramString);
    y.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", new Object[] { paramString, str });
    if (bk.bl(str))
    {
      Toast.makeText(paramContext, paramContext.getString(n.i.video_file_save_failed), 1).show();
      return;
    }
    Toast.makeText(paramContext, paramContext.getString(n.i.video_file_saved, new Object[] { str }), 1).show();
    l.a(str, paramContext);
  }
  
  public final void aBR()
  {
    this.kgy.setVisibility(8);
    int k = this.kgv.getWidth();
    int j = this.kgv.getHeight();
    int i = j;
    if (this.itD != 0)
    {
      i = j;
      if (this.itE != 0) {
        i = (int)(k / this.itD * this.itE);
      }
    }
    this.itA.fH(k, i);
    this.itA.E(this.itC, this.itB, this.itD, this.itE);
    this.itA.a(this.kgx, this.kgw, new FavoriteVideoPlayUI.5(this), null);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    return super.dispatchKeyEvent(paramKeyEvent);
  }
  
  protected final int getLayoutId()
  {
    return n.f.fav_video_play_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label73;
        }
      }
      Runnable local3;
      label73:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local3 = new Runnable()
        {
          public final void run()
          {
            this.kbH.dismiss();
          }
        };
        if (!bk.bl((String)localObject)) {
          break label84;
        }
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label84:
      Object localObject = bk.G(((String)localObject).split(",")).iterator();
      label283:
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        AppCompatActivity localAppCompatActivity = this.mController.uMN;
        String str2 = this.erh;
        String str3 = this.thumbPath;
        paramInt1 = this.jlu;
        String str4 = this.kgu;
        if (localAppCompatActivity == null) {
          y.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (bk.bl(paramIntent)) {
            break label283;
          }
          com.tencent.mm.plugin.messenger.a.g.bhI().D(str1, paramIntent, com.tencent.mm.model.s.hW(str1));
          break;
          if (bk.bl(str1))
          {
            y.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(str2);
            if ((bk.bl(str2)) && (!localb.exists())) {
              y.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.g.DS().O(new i.5(localAppCompatActivity, str1, str2, str3, paramInt1, str4, local3));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.h(this, getString(n.i.fav_finish_sent));
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onBackPressed()
  {
    aBR();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.mController.hideTitleView();
    if (com.tencent.mm.compatible.util.d.gF(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.ity = paramBundle;
      getWindow().addFlags(128);
      this.kgz = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.erh = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.jlu = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.kgu = getIntent().getStringExtra("key_detail_statExtStr");
      this.kgA = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.bTT = getIntent().getBooleanExtra("show_share", true);
      this.kgB = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.kgC = getIntent().getStringExtra("key_detail_data_id");
      if (!com.tencent.mm.vfs.e.bK(this.thumbPath))
      {
        paramBundle = com.tencent.mm.plugin.fav.ui.c.CU(this.erh);
        if (paramBundle == null) {}
      }
      try
      {
        y.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        com.tencent.mm.sdk.platformtools.c.a(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.kgz;
        if (bk.bl(this.thumbPath))
        {
          paramBundle = "";
          if (!bk.bl(this.erh)) {
            break label507;
          }
          str = "";
          y.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.kgv = ((RelativeLayout)findViewById(n.e.video_ui_root));
          this.kgx = ((FavVideoView)findViewById(n.e.video_view));
          paramBundle = (ImageView)findViewById(n.e.video_thumb);
          this.kgw = ((ImageView)findViewById(n.e.gallery_bg));
          this.kgy = ((LinearLayout)findViewById(n.e.fav_expired_btn));
          if ((!this.kgz) && (this.kgy != null)) {
            this.kgy.setVisibility(0);
          }
          if (this.kgw != null) {
            this.kgw.setLayerType(2, null);
          }
          if (bk.bl(this.erh)) {
            break label523;
          }
          if (!com.tencent.mm.vfs.e.bK(this.erh)) {
            break label515;
          }
          this.kgx.setVideoData(this.erh);
          y.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          this.kgx.setOnClickListener(this.kdc);
          if (this.bTT) {
            this.kgx.setOnLongClickListener(this.kfL);
          }
          this.itA = new com.tencent.mm.ui.tools.e(null);
          return;
          getWindow().setFlags(1024, 1024);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label507:
          String str = this.erh;
          continue;
          label515:
          e(paramBundle);
          continue;
          label523:
          e(paramBundle);
        }
      }
    }
  }
  
  protected void onDestroy()
  {
    setResult(0, getIntent().putExtra("key_activity_browse_time", czu()));
    this.kgx.onDestroy();
    getWindow().clearFlags(128);
    super.onDestroy();
  }
  
  protected void onPause()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    FavVideoView localFavVideoView = this.kgx;
    y.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    if (localFavVideoView.iuC.isPlaying())
    {
      y.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      localFavVideoView.iuC.pause();
    }
    super.onPause();
    o.Dh(2);
  }
  
  protected void onResume()
  {
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    y.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.kgc) });
    if (!this.kgc) {
      this.kgx.onResume();
    }
    this.kgc = false;
    super.onResume();
    o.Dh(1);
  }
  
  public void onStart()
  {
    Bundle localBundle = this.ity;
    if (!this.itz)
    {
      this.itz = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.itB = getIntent().getIntExtra("img_gallery_top", 0);
        this.itC = getIntent().getIntExtra("img_gallery_left", 0);
        this.itD = getIntent().getIntExtra("img_gallery_width", 0);
        this.itE = getIntent().getIntExtra("img_gallery_height", 0);
        this.itA.E(this.itC, this.itB, this.itD, this.itE);
        if (localBundle == null) {
          this.kgx.getViewTreeObserver().addOnPreDrawListener(new FavoriteVideoPlayUI.4(this));
        }
      }
    }
    super.onStart();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */