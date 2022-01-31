package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
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
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.plugin.fav.ui.c;
import com.tencent.mm.plugin.fav.ui.i.5;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.record.a.f;
import com.tencent.mm.plugin.webview.ui.tools.widget.o;
import com.tencent.mm.pluginsdk.ui.tools.n;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.util.Iterator;
import java.util.List;

@a(3)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private View.OnClickListener bTw;
  private boolean cBz;
  private long cpO;
  private String eNO;
  private int eVA;
  private boolean isAnimated;
  private com.tencent.mm.ui.tools.e kip;
  private Bundle kuF;
  private int kuG;
  private int kuH;
  private int kuI;
  private int kuJ;
  private boolean mAO;
  private View.OnLongClickListener mAd;
  private String mBg;
  private RelativeLayout mBh;
  private ImageView mBi;
  private FavVideoView mBj;
  private LinearLayout mBk;
  private boolean mBl;
  private int mBm;
  private boolean mBn;
  private String mBo;
  private boolean mBp;
  private String mBq;
  private String thumbPath;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(74466);
    this.mAO = true;
    this.isAnimated = false;
    this.kuG = 0;
    this.kuH = 0;
    this.kuI = 0;
    this.kuJ = 0;
    this.mBl = true;
    this.cBz = true;
    this.mBn = false;
    this.mBo = "";
    this.mBp = true;
    this.bTw = new FavoriteVideoPlayUI.1(this);
    this.mAd = new FavoriteVideoPlayUI.2(this);
    AppMethodBeat.o(74466);
  }
  
  public static void f(String paramString, Context paramContext)
  {
    AppMethodBeat.i(74469);
    String str = u.vs(paramString);
    ab.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", new Object[] { paramString, str });
    if (bo.isNullOrNil(str))
    {
      Toast.makeText(paramContext, paramContext.getString(2131304521), 1).show();
      AppMethodBeat.o(74469);
      return;
    }
    Toast.makeText(paramContext, paramContext.getString(2131304522, new Object[] { str }), 1).show();
    n.a(str, paramContext);
    AppMethodBeat.o(74469);
  }
  
  private void h(ImageView paramImageView)
  {
    AppMethodBeat.i(74468);
    if (this.mBp)
    {
      this.mBj.a(this.eNO, this.mBn, this.mBo);
      if (paramImageView != null)
      {
        if (!com.tencent.mm.vfs.e.cN(this.thumbPath)) {
          break label70;
        }
        paramImageView.setImageBitmap(BackwardSupportUtil.b.k(this.thumbPath, 1.0F));
      }
    }
    for (;;)
    {
      ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
      AppMethodBeat.o(74468);
      return;
      label70:
      paramImageView.setImageResource(2130838259);
      continue;
      ((f)com.tencent.mm.kernel.g.E(f.class)).c(getIntent().getStringExtra("record_xml"), this.cpO, this.mBq);
      this.mBj.a(this.eNO, true, this.mBq);
      this.mBj.setThumbView(this.thumbPath);
    }
  }
  
  public final void bdV()
  {
    AppMethodBeat.i(74476);
    this.mBk.setVisibility(8);
    int k = this.mBh.getWidth();
    int j = this.mBh.getHeight();
    int i = j;
    if (this.kuI != 0)
    {
      i = j;
      if (this.kuJ != 0) {
        i = (int)(k / this.kuI * this.kuJ);
      }
    }
    this.kip.hO(k, i);
    this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
    this.kip.a(this.mBj, this.mBi, new FavoriteVideoPlayUI.5(this), null);
    AppMethodBeat.o(74476);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(74474);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(74474);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2130969566;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74475);
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label82;
        }
      }
      FavoriteVideoPlayUI.3 local3;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local3 = new FavoriteVideoPlayUI.3(this, h.b(getContext(), getString(2131299734), false, null));
        if (!bo.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(74475);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Object localObject = bo.P(((String)localObject).split(",")).iterator();
      label289:
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        AppCompatActivity localAppCompatActivity = getContext();
        String str2 = this.eNO;
        String str3 = this.thumbPath;
        paramInt1 = this.eVA;
        String str4 = this.mBg;
        if (localAppCompatActivity == null) {
          ab.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (bo.isNullOrNil(paramIntent)) {
            break label289;
          }
          com.tencent.mm.plugin.messenger.a.g.bPJ().K(str1, paramIntent, t.oF(str1));
          break;
          if (bo.isNullOrNil(str1))
          {
            ab.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            com.tencent.mm.vfs.b localb = new com.tencent.mm.vfs.b(str2);
            if ((bo.isNullOrNil(str2)) && (!localb.exists())) {
              ab.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.g.RO().ac(new i.5(localAppCompatActivity, str1, str2, str3, paramInt1, str4, local3));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131299674));
      AppMethodBeat.o(74475);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74475);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(74477);
    bdV();
    AppMethodBeat.o(74477);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74467);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.fv(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.kuF = paramBundle;
      getWindow().addFlags(128);
      this.mBl = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.eNO = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.eVA = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.mBg = getIntent().getStringExtra("key_detail_statExtStr");
      this.mBm = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.cBz = getIntent().getBooleanExtra("show_share", true);
      this.mBn = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.mBo = getIntent().getStringExtra("key_detail_data_id");
      this.mBp = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.mBq = getIntent().getStringExtra("record_data_id");
      this.cpO = getIntent().getLongExtra("message_id", -1L);
      if (!com.tencent.mm.vfs.e.cN(this.thumbPath))
      {
        paramBundle = c.NW(this.eNO);
        if (paramBundle == null) {}
      }
      try
      {
        ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        com.tencent.mm.sdk.platformtools.d.a(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.mBl;
        if (bo.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!bo.isNullOrNil(this.eNO)) {
            break label562;
          }
          str = "";
          ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.mBh = ((RelativeLayout)findViewById(2131822188));
          this.mBj = ((FavVideoView)findViewById(2131821436));
          paramBundle = (ImageView)findViewById(2131822189);
          this.mBi = ((ImageView)findViewById(2131822135));
          this.mBk = ((LinearLayout)findViewById(2131824000));
          if ((!this.mBl) && (this.mBk != null)) {
            this.mBk.setVisibility(0);
          }
          if (this.mBi != null) {
            this.mBi.setLayerType(2, null);
          }
          if (bo.isNullOrNil(this.eNO)) {
            break label578;
          }
          if (!com.tencent.mm.vfs.e.cN(this.eNO)) {
            break label570;
          }
          this.mBj.setVideoData(this.eNO);
          ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          this.mBj.setOnClickListener(this.bTw);
          if (this.cBz) {
            this.mBj.setOnLongClickListener(this.mAd);
          }
          this.kip = new com.tencent.mm.ui.tools.e(null);
          AppMethodBeat.o(74467);
          return;
          getWindow().setFlags(1024, 1024);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label562:
          String str = this.eNO;
          continue;
          label570:
          h(paramBundle);
          continue;
          label578:
          h(paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74473);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.mBj.onDestroy();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(74473);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74472);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    FavVideoView localFavVideoView = this.mBj;
    ab.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    if (localFavVideoView.kvG.isPlaying())
    {
      ab.i("MicroMsg.FavVideoView", "VideoPlay: pausePlay()");
      localFavVideoView.kvG.pause();
    }
    super.onPause();
    o.La(2);
    AppMethodBeat.o(74472);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74471);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    ab.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.mAO) });
    if (!this.mAO) {
      this.mBj.onResume();
    }
    this.mAO = false;
    super.onResume();
    o.La(1);
    AppMethodBeat.o(74471);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(74470);
    Bundle localBundle = this.kuF;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.kuG = getIntent().getIntExtra("img_gallery_top", 0);
        this.kuH = getIntent().getIntExtra("img_gallery_left", 0);
        this.kuI = getIntent().getIntExtra("img_gallery_width", 0);
        this.kuJ = getIntent().getIntExtra("img_gallery_height", 0);
        this.kip.L(this.kuH, this.kuG, this.kuI, this.kuJ);
        if (localBundle == null) {
          this.mBj.getViewTreeObserver().addOnPreDrawListener(new FavoriteVideoPlayUI.4(this));
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(74470);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */