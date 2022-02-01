package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap.CompressFormat;
import android.os.Build.VERSION;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.f.c.et;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.fav.ui.l.6;
import com.tencent.mm.plugin.fav.ui.s.d;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.o;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.vfs.q;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private String fEa;
  private boolean fNQ;
  private String fullPath;
  private boolean isAnimated;
  private ImageView mLT;
  private String mic;
  private long msgId;
  private String thumbPath;
  private Bundle twA;
  private com.tencent.mm.ui.tools.f twB;
  private int twC;
  private int twD;
  private int twE;
  private int twF;
  private int videoDuration;
  private String wGj;
  private View.OnLongClickListener wOt;
  private String wPA;
  private RelativeLayout wPB;
  private FavVideoView wPC;
  private LinearLayout wPD;
  private boolean wPE;
  private int wPF;
  private boolean wPG;
  private boolean wPH;
  private boolean wPI;
  private boolean wPj;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(107266);
    this.wPj = true;
    this.isAnimated = false;
    this.twC = 0;
    this.twD = 0;
    this.twE = 0;
    this.twF = 0;
    this.wPE = true;
    this.fNQ = true;
    this.wPG = false;
    this.wGj = "";
    this.wPH = true;
    this.wOt = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107260);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aFi());
        if (!FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).gX)
        {
          Log.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(107260);
          return true;
        }
        paramAnonymousView.getTag();
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(FavoriteVideoPlayUI.this.getContext(), 1, false);
        paramAnonymousView.ODT = new q.f()
        {
          public final void onCreateMMMenu(o paramAnonymous2o)
          {
            AppMethodBeat.i(107258);
            if (FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.this))
            {
              if (com.tencent.mm.vfs.u.agG(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2o.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(s.i.favorite_share_with_friend));
              }
              paramAnonymous2o.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(s.i.save_video_to_local));
            }
            AppMethodBeat.o(107258);
          }
        };
        paramAnonymousView.ODU = new q.g()
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
              if (com.tencent.mm.vfs.u.agG(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this));
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 1);
                com.tencent.mm.by.c.d(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
                if (FavoriteVideoPlayUI.e(FavoriteVideoPlayUI.this) != 0) {
                  break;
                }
                com.tencent.mm.plugin.fav.a.h.y(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0L), 1);
                AppMethodBeat.o(107259);
                return;
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this));
              }
              paramAnonymous2MenuItem = FavoriteVideoPlayUI.this;
              String str = FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this);
              FavoriteVideoPlayUI localFavoriteVideoPlayUI = FavoriteVideoPlayUI.this;
              p.b(paramAnonymous2MenuItem.getContext(), str, new FavoriteVideoPlayUI.4(paramAnonymous2MenuItem, str, localFavoriteVideoPlayUI));
            }
          }
        };
        paramAnonymousView.eik();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107260);
        return true;
      }
    };
    this.wPI = false;
    AppMethodBeat.o(107266);
  }
  
  private void g(ImageView paramImageView)
  {
    AppMethodBeat.i(107268);
    if (this.wPH)
    {
      this.wPC.b(this.fullPath, this.wPG, this.wGj);
      if (paramImageView != null)
      {
        if (!com.tencent.mm.vfs.u.agG(this.thumbPath)) {
          break label70;
        }
        paramImageView.setImageBitmap(BackwardSupportUtil.BitmapFactory.decodeFile(this.thumbPath, 1.0F));
      }
    }
    for (;;)
    {
      Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
      AppMethodBeat.o(107268);
      return;
      label70:
      paramImageView.setImageResource(s.d.chat_video_nf_mask_from);
      continue;
      String str = getIntent().getStringExtra("record_xml");
      paramImageView = str;
      if (Util.isNullOrNil(str))
      {
        paramImageView = ((n)com.tencent.mm.kernel.h.ae(n.class)).eSe().Oq(this.msgId);
        k.b localb = k.b.aG(paramImageView.field_content, paramImageView.field_reserved);
        paramImageView = str;
        if (localb != null) {
          paramImageView = localb.lmA;
        }
      }
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.record.a.g.class)).h(paramImageView, this.msgId, this.fEa);
      this.wPC.b(this.fullPath, true, this.fEa);
      this.wPC.setThumbView(this.thumbPath);
    }
  }
  
  public final void cJs()
  {
    AppMethodBeat.i(107276);
    this.wPD.setVisibility(8);
    int k = this.wPB.getWidth();
    int j = this.wPB.getHeight();
    int i = j;
    if (this.twE != 0)
    {
      i = j;
      if (this.twF != 0) {
        i = (int)(k / this.twE * this.twF);
      }
    }
    this.twB.mJ(k, i);
    this.twB.V(this.twD, this.twC, this.twE, this.twF);
    this.twB.a(this.wPC, this.mLT, new f.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(164105);
        new MMHandler().post(new Runnable()
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
    return s.f.fav_video_play_ui;
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
          break label82;
        }
      }
      Runnable local5;
      label82:
      for (paramIntent = null;; paramIntent = paramIntent.getStringExtra("custom_send_text"))
      {
        local5 = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(164101);
            this.wJe.dismiss();
            AppMethodBeat.o(164101);
          }
        };
        if (!Util.isNullOrNil((String)localObject)) {
          break label93;
        }
        AppMethodBeat.o(107275);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label93:
      Object localObject = Util.stringsToList(((String)localObject).split(",")).iterator();
      label297:
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        AppCompatActivity localAppCompatActivity = getContext();
        String str2 = this.fullPath;
        String str3 = this.thumbPath;
        paramInt1 = this.videoDuration;
        String str4 = this.wPA;
        String str5 = this.mic;
        if (localAppCompatActivity == null) {
          Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label297;
          }
          com.tencent.mm.plugin.messenger.a.g.eRW().ai(str1, paramIntent, ab.QZ(str1));
          break;
          if (Util.isNullOrNil(str1))
          {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            q localq = new q(str2);
            if ((Util.isNullOrNil(str2)) && (!localq.ifE())) {
              Log.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.h.aHJ().postToWorker(new l.6(localAppCompatActivity, str1, str2, str3, paramInt1, str4, str5, local5));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(s.i.fav_finish_sent));
      AppMethodBeat.o(107275);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107275);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(107277);
    cJs();
    AppMethodBeat.o(107277);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107267);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.qV(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.twA = paramBundle;
      getWindow().addFlags(128);
      this.wPE = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.fullPath = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.wPA = getIntent().getStringExtra("key_detail_statExtStr");
      this.wPF = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.fNQ = getIntent().getBooleanExtra("show_share", true);
      this.wPG = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.wGj = getIntent().getStringExtra("key_detail_data_id");
      this.wPH = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.fEa = getIntent().getStringExtra("record_data_id");
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      this.mic = getIntent().getStringExtra("key_detail_msg_uuid");
      if (!com.tencent.mm.vfs.u.agG(this.thumbPath))
      {
        paramBundle = com.tencent.mm.plugin.fav.ui.e.aAn(this.fullPath);
        if (paramBundle == null) {}
      }
      try
      {
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        BitmapUtil.saveBitmapToImage(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.wPE;
        if (Util.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!Util.isNullOrNil(this.fullPath)) {
            break label596;
          }
          str = "";
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.wPB = ((RelativeLayout)findViewById(s.e.video_ui_root));
          this.wPC = ((FavVideoView)findViewById(s.e.video_view));
          paramBundle = (ImageView)findViewById(s.e.video_thumb);
          this.mLT = ((ImageView)findViewById(s.e.gallery_bg));
          this.wPD = ((LinearLayout)findViewById(s.e.fav_expired_btn));
          if ((!this.wPE) && (this.wPD != null)) {
            this.wPD.setVisibility(0);
          }
          if (Util.isNullOrNil(this.fullPath)) {
            break label612;
          }
          if (!com.tencent.mm.vfs.u.agG(this.fullPath)) {
            break label604;
          }
          this.wPC.setVideoData(this.fullPath);
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          if (this.fNQ) {
            this.wPC.setOnLongClickListener(this.wOt);
          }
          this.twB = new com.tencent.mm.ui.tools.f(null);
          this.wPC.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107256);
              FavoriteVideoPlayUI.this.cJs();
              AppMethodBeat.o(107256);
            }
          });
          this.wPC.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(107257);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bn(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
              if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).dmc();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(107257);
            }
          });
          if (!ar.hIM()) {
            break label620;
          }
          this.wPC.setVideoScaleType(i.e.RcG);
          AppMethodBeat.o(107267);
          return;
          getWindow().setFlags(1024, 1024);
        }
      }
      catch (Exception paramBundle)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label596:
          String str = this.fullPath;
          continue;
          label604:
          g(paramBundle);
          continue;
          label612:
          g(paramBundle);
        }
        label620:
        this.wPC.setVideoScaleType(i.e.RcE);
        AppMethodBeat.o(107267);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107273);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.wPC.onDestroy();
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
    if (this.wPC.isPlaying()) {
      this.wPI = true;
    }
    FavVideoView localFavVideoView = this.wPC;
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    localFavVideoView.dme();
    localFavVideoView.dmf();
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
    Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.wPj) });
    this.wPj = false;
    super.onResume();
    if (this.wPI) {
      this.wPC.dmg();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(107271);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(107270);
    Bundle localBundle = this.twA;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.twC = getIntent().getIntExtra("img_gallery_top", 0);
        this.twD = getIntent().getIntExtra("img_gallery_left", 0);
        this.twE = getIntent().getIntExtra("img_gallery_width", 0);
        this.twF = getIntent().getIntExtra("img_gallery_height", 0);
        this.twB.V(this.twD, this.twC, this.twE, this.twF);
        if (localBundle == null) {
          this.wPC.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
          {
            public final boolean onPreDraw()
            {
              AppMethodBeat.i(164103);
              FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).getViewTreeObserver().removeOnPreDrawListener(this);
              FavoriteVideoPlayUI.h(FavoriteVideoPlayUI.this).a(FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this), FavoriteVideoPlayUI.g(FavoriteVideoPlayUI.this), new f.c()
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