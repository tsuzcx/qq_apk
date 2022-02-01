package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.w;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.ui.l.6;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.messenger.a.j;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.ui.widget.snackbar.b;
import java.util.Iterator;
import java.util.List;

@a(3)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private String dkb;
  private boolean drV;
  private String gjt;
  private String hAt;
  private boolean isAnimated;
  private long msgId;
  private Bundle nzU;
  private com.tencent.mm.ui.tools.e nzV;
  private int nzW;
  private int nzX;
  private int nzY;
  private int nzZ;
  private String pZG;
  private ImageView qdk;
  private View.OnLongClickListener qhH;
  private String qiL;
  private RelativeLayout qiM;
  private FavVideoView qiN;
  private LinearLayout qiO;
  private boolean qiP;
  private int qiQ;
  private boolean qiR;
  private boolean qiS;
  private boolean qiT;
  private boolean qit;
  private String thumbPath;
  private int videoDuration;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(107266);
    this.qit = true;
    this.isAnimated = false;
    this.nzW = 0;
    this.nzX = 0;
    this.nzY = 0;
    this.nzZ = 0;
    this.qiP = true;
    this.drV = true;
    this.qiR = false;
    this.pZG = "";
    this.qiS = true;
    this.qhH = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107260);
        if (!FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).WD)
        {
          ad.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
          AppMethodBeat.o(107260);
          return true;
        }
        paramAnonymousView.getTag();
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(FavoriteVideoPlayUI.this.getContext(), 1, false);
        paramAnonymousView.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(107258);
            if (FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.this))
            {
              if (com.tencent.mm.vfs.i.eK(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2l.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(2131759001));
              }
              paramAnonymous2l.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(2131762784));
            }
            AppMethodBeat.o(107258);
          }
        };
        paramAnonymousView.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(107259);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107259);
              return;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              if (com.tencent.mm.vfs.i.eK(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this));
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 1);
                com.tencent.mm.bs.d.c(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
                if (FavoriteVideoPlayUI.e(FavoriteVideoPlayUI.this) != 0) {
                  break;
                }
                com.tencent.mm.plugin.fav.a.h.i(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0L), 1, 0);
                AppMethodBeat.o(107259);
                return;
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this));
              }
              paramAnonymous2MenuItem = FavoriteVideoPlayUI.this;
              String str1 = FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this);
              FavoriteVideoPlayUI localFavoriteVideoPlayUI = FavoriteVideoPlayUI.this;
              String str2 = u.Af(str1);
              ad.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", new Object[] { str1, str2 });
              if (bt.isNullOrNil(str2))
              {
                Toast.makeText(localFavoriteVideoPlayUI, localFavoriteVideoPlayUI.getString(2131764682), 1).show();
                AppMethodBeat.o(107259);
                return;
              }
              Toast.makeText(localFavoriteVideoPlayUI, localFavoriteVideoPlayUI.getString(2131764683, new Object[] { str2 }), 1).show();
              q.k(str2, localFavoriteVideoPlayUI);
              com.tencent.e.h.Iye.aP(new FavoriteVideoPlayUI.4(paramAnonymous2MenuItem, str2));
            }
          }
        };
        paramAnonymousView.csG();
        AppMethodBeat.o(107260);
        return true;
      }
    };
    this.qiT = false;
    AppMethodBeat.o(107266);
  }
  
  private void f(ImageView paramImageView)
  {
    AppMethodBeat.i(107268);
    if (this.qiS)
    {
      this.qiN.c(this.gjt, this.qiR, this.pZG);
      if (paramImageView != null)
      {
        if (!com.tencent.mm.vfs.i.eK(this.thumbPath)) {
          break label70;
        }
        paramImageView.setImageBitmap(BackwardSupportUtil.b.n(this.thumbPath, 1.0F));
      }
    }
    for (;;)
    {
      ad.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
      AppMethodBeat.o(107268);
      return;
      label70:
      paramImageView.setImageResource(2131231602);
      continue;
      ((com.tencent.mm.plugin.record.a.f)g.ab(com.tencent.mm.plugin.record.a.f.class)).f(getIntent().getStringExtra("record_xml"), this.msgId, this.dkb);
      this.qiN.c(this.gjt, true, this.dkb);
      this.qiN.setThumbView(this.thumbPath);
    }
  }
  
  public final void bKT()
  {
    AppMethodBeat.i(107276);
    this.qiO.setVisibility(8);
    int k = this.qiM.getWidth();
    int j = this.qiM.getHeight();
    int i = j;
    if (this.nzY != 0)
    {
      i = j;
      if (this.nzZ != 0) {
        i = (int)(k / this.nzY * this.nzZ);
      }
    }
    this.nzV.jB(k, i);
    this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
    this.nzV.a(this.qiN, this.qdk, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(164105);
        new ap().post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(164104);
            FavoriteVideoPlayUI.this.finish();
            FavoriteVideoPlayUI.this.overridePendingTransition(0, 0);
            AppMethodBeat.o(164104);
          }
        });
        AppMethodBeat.o(164105);
      }
      
      public final void onAnimationStart() {}
    }, null);
    AppMethodBeat.o(107276);
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107274);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(107274);
    return bool;
  }
  
  public int getLayoutId()
  {
    return 2131493984;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107275);
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      if (paramIntent == null)
      {
        localObject = null;
        if (paramIntent != null) {
          break label80;
        }
      }
      Runnable local5;
      label80:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local5 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(164101);
            this.qcu.dismiss();
            AppMethodBeat.o(164101);
          }
        };
        if (!bt.isNullOrNil((String)localObject)) {
          break label91;
        }
        AppMethodBeat.o(107275);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label91:
      Object localObject = bt.S(((String)localObject).split(",")).iterator();
      label295:
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        AppCompatActivity localAppCompatActivity = getContext();
        String str2 = this.gjt;
        String str3 = this.thumbPath;
        paramInt1 = this.videoDuration;
        String str4 = this.qiL;
        String str5 = this.hAt;
        if (localAppCompatActivity == null) {
          ad.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (bt.isNullOrNil(paramIntent)) {
            break label295;
          }
          j.cOB().W(str1, paramIntent, w.tq(str1));
          break;
          if (bt.isNullOrNil(str1))
          {
            ad.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            com.tencent.mm.vfs.e locale = new com.tencent.mm.vfs.e(str2);
            if ((bt.isNullOrNil(str2)) && (!locale.exists())) {
              ad.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              g.afE().ax(new l.6(localAppCompatActivity, str1, str2, str3, paramInt1, str4, str5, local5));
            }
          }
        }
      }
      b.n(this, getString(2131758834));
      AppMethodBeat.o(107275);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107275);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(107277);
    bKT();
    AppMethodBeat.o(107277);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107267);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.lf(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.nzU = paramBundle;
      getWindow().addFlags(128);
      this.qiP = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.gjt = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.qiL = getIntent().getStringExtra("key_detail_statExtStr");
      this.qiQ = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.drV = getIntent().getBooleanExtra("show_share", true);
      this.qiR = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.pZG = getIntent().getStringExtra("key_detail_data_id");
      this.qiS = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.dkb = getIntent().getStringExtra("record_data_id");
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      this.hAt = getIntent().getStringExtra("key_detail_msg_uuid");
      if (!com.tencent.mm.vfs.i.eK(this.thumbPath))
      {
        paramBundle = com.tencent.mm.plugin.fav.ui.e.Yw(this.gjt);
        if (paramBundle == null) {}
      }
      try
      {
        ad.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        com.tencent.mm.sdk.platformtools.f.a(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.qiP;
        if (bt.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!bt.isNullOrNil(this.gjt)) {
            break label580;
          }
          str = "";
          ad.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.qiM = ((RelativeLayout)findViewById(2131306409));
          this.qiN = ((FavVideoView)findViewById(2131306410));
          paramBundle = (ImageView)findViewById(2131306398);
          this.qdk = ((ImageView)findViewById(2131300336));
          this.qiO = ((LinearLayout)findViewById(2131299788));
          if ((!this.qiP) && (this.qiO != null)) {
            this.qiO.setVisibility(0);
          }
          if (bt.isNullOrNil(this.gjt)) {
            break label596;
          }
          if (!com.tencent.mm.vfs.i.eK(this.gjt)) {
            break label588;
          }
          this.qiN.setVideoData(this.gjt);
          ad.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          if (this.drV) {
            this.qiN.setOnLongClickListener(this.qhH);
          }
          this.nzV = new com.tencent.mm.ui.tools.e(null);
          this.qiN.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107256);
              FavoriteVideoPlayUI.this.bKT();
              AppMethodBeat.o(107256);
            }
          });
          this.qiN.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(107257);
              if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).cjX();
              }
              AppMethodBeat.o(107257);
            }
          });
          AppMethodBeat.o(107267);
          return;
          getWindow().setFlags(1024, 1024);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label580:
          String str = this.gjt;
          continue;
          label588:
          f(paramBundle);
          continue;
          label596:
          f(paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107273);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.qiN.onDestroy();
    getWindow().clearFlags(128);
    super.onDestroy();
    AppMethodBeat.o(107273);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107272);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().setFlags(2048, 2048);
    }
    if (this.qiN.isPlaying()) {
      this.qiT = true;
    }
    FavVideoView localFavVideoView = this.qiN;
    ad.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    localFavVideoView.cjZ();
    localFavVideoView.cka();
    super.onPause();
    com.tencent.mm.plugin.ball.f.f.d(false, true, true);
    AppMethodBeat.o(107272);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107271);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    ad.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.qit) });
    this.qit = false;
    super.onResume();
    if (this.qiT) {
      this.qiN.ckb();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(107271);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(107270);
    Bundle localBundle = this.nzU;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.nzW = getIntent().getIntExtra("img_gallery_top", 0);
        this.nzX = getIntent().getIntExtra("img_gallery_left", 0);
        this.nzY = getIntent().getIntExtra("img_gallery_width", 0);
        this.nzZ = getIntent().getIntExtra("img_gallery_height", 0);
        this.nzV.P(this.nzX, this.nzW, this.nzY, this.nzZ);
        if (localBundle == null) {
          this.qiN.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(164103);
              FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
              FavoriteVideoPlayUI.h(FavoriteVideoPlayUI.this).a(FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this), FavoriteVideoPlayUI.g(FavoriteVideoPlayUI.this), new e.c()
              {
                public final void onAnimationEnd() {}
                
                public final void onAnimationStart()
                {
                  AppMethodBeat.i(164102);
                  if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                    FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).onResume();
                  }
                  AppMethodBeat.o(164102);
                }
              });
              AppMethodBeat.o(164103);
              return true;
            }
          });
        }
      }
    }
    super.onStart();
    AppMethodBeat.o(107270);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */