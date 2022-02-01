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
import com.tencent.f.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.p;
import com.tencent.mm.platformtools.p.a;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.l.6;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private String dLl;
  private boolean dUo;
  private String fullPath;
  private boolean isAnimated;
  private ImageView jUG;
  private String jsz;
  private long msgId;
  private Bundle qaD;
  private com.tencent.mm.ui.tools.e qaE;
  private int qaF;
  private int qaG;
  private int qaH;
  private int qaI;
  private String taf;
  private String thumbPath;
  private boolean tiS;
  private View.OnLongClickListener tib;
  private String tjj;
  private RelativeLayout tjk;
  private FavVideoView tjl;
  private LinearLayout tjm;
  private boolean tjn;
  private int tjo;
  private boolean tjp;
  private boolean tjq;
  private boolean tjr;
  private int videoDuration;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(107266);
    this.tiS = true;
    this.isAnimated = false;
    this.qaF = 0;
    this.qaG = 0;
    this.qaH = 0;
    this.qaI = 0;
    this.tjn = true;
    this.dUo = true;
    this.tjp = false;
    this.taf = "";
    this.tjq = true;
    this.tib = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107260);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.axR());
        if (!FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).ZA)
        {
          Log.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(107260);
          return true;
        }
        paramAnonymousView.getTag();
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(FavoriteVideoPlayUI.this.getContext(), 1, false);
        paramAnonymousView.HLX = new o.f()
        {
          public final void onCreateMMMenu(m paramAnonymous2m)
          {
            AppMethodBeat.i(107258);
            if (FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.this))
            {
              if (com.tencent.mm.vfs.s.YS(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2m.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(2131759326));
              }
              paramAnonymous2m.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(2131764871));
            }
            AppMethodBeat.o(107258);
          }
        };
        paramAnonymousView.HLY = new o.g()
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
              if (com.tencent.mm.vfs.s.YS(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this));
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 1);
                c.c(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
                if (FavoriteVideoPlayUI.e(FavoriteVideoPlayUI.this) != 0) {
                  break;
                }
                com.tencent.mm.plugin.fav.a.h.w(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0L), 1);
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
        paramAnonymousView.dGm();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107260);
        return true;
      }
    };
    this.tjr = false;
    AppMethodBeat.o(107266);
  }
  
  private void h(ImageView paramImageView)
  {
    AppMethodBeat.i(107268);
    if (this.tjq)
    {
      this.tjl.c(this.fullPath, this.tjp, this.taf);
      if (paramImageView != null)
      {
        if (!com.tencent.mm.vfs.s.YS(this.thumbPath)) {
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
      paramImageView.setImageResource(2131231666);
      continue;
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.record.a.g.class)).h(getIntent().getStringExtra("record_xml"), this.msgId, this.dLl);
      this.tjl.c(this.fullPath, true, this.dLl);
      this.tjl.setThumbView(this.thumbPath);
    }
  }
  
  public final void cvQ()
  {
    AppMethodBeat.i(107276);
    this.tjm.setVisibility(8);
    int k = this.tjk.getWidth();
    int j = this.tjk.getHeight();
    int i = j;
    if (this.qaH != 0)
    {
      i = j;
      if (this.qaI != 0) {
        i = (int)(k / this.qaH * this.qaI);
      }
    }
    this.qaE.ls(k, i);
    this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
    this.qaE.a(this.tjl, this.jUG, new e.c()
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
    return 2131494154;
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
            this.tcT.dismiss();
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
        String str4 = this.tjj;
        String str5 = this.jsz;
        if (localAppCompatActivity == null) {
          Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label297;
          }
          com.tencent.mm.plugin.messenger.a.g.eir().ad(str1, paramIntent, ab.JG(str1));
          break;
          if (Util.isNullOrNil(str1))
          {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            o localo = new o(str2);
            if ((Util.isNullOrNil(str2)) && (!localo.exists())) {
              Log.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.g.aAk().postToWorker(new l.6(localAppCompatActivity, str1, str2, str3, paramInt1, str4, str5, local5));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131759157));
      AppMethodBeat.o(107275);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107275);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(107277);
    cvQ();
    AppMethodBeat.o(107277);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107267);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.oD(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.qaD = paramBundle;
      getWindow().addFlags(128);
      this.tjn = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.fullPath = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.tjj = getIntent().getStringExtra("key_detail_statExtStr");
      this.tjo = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.dUo = getIntent().getBooleanExtra("show_share", true);
      this.tjp = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.taf = getIntent().getStringExtra("key_detail_data_id");
      this.tjq = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.dLl = getIntent().getStringExtra("record_data_id");
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      this.jsz = getIntent().getStringExtra("key_detail_msg_uuid");
      if (!com.tencent.mm.vfs.s.YS(this.thumbPath))
      {
        paramBundle = com.tencent.mm.plugin.fav.ui.e.asm(this.fullPath);
        if (paramBundle == null) {}
      }
      try
      {
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        BitmapUtil.saveBitmapToImage(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.tjn;
        if (Util.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!Util.isNullOrNil(this.fullPath)) {
            break label580;
          }
          str = "";
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.tjk = ((RelativeLayout)findViewById(2131309840));
          this.tjl = ((FavVideoView)findViewById(2131309841));
          paramBundle = (ImageView)findViewById(2131309829);
          this.jUG = ((ImageView)findViewById(2131301854));
          this.tjm = ((LinearLayout)findViewById(2131300461));
          if ((!this.tjn) && (this.tjm != null)) {
            this.tjm.setVisibility(0);
          }
          if (Util.isNullOrNil(this.fullPath)) {
            break label596;
          }
          if (!com.tencent.mm.vfs.s.YS(this.fullPath)) {
            break label588;
          }
          this.tjl.setVideoData(this.fullPath);
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          if (this.dUo) {
            this.tjl.setOnLongClickListener(this.tib);
          }
          this.qaE = new com.tencent.mm.ui.tools.e(null);
          this.tjl.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107256);
              FavoriteVideoPlayUI.this.cvQ();
              AppMethodBeat.o(107256);
            }
          });
          this.tjl.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(107257);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bm(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
              if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).cWU();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
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
          Log.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label580:
          String str = this.fullPath;
          continue;
          label588:
          h(paramBundle);
          continue;
          label596:
          h(paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107273);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.tjl.onDestroy();
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
    if (this.tjl.isPlaying()) {
      this.tjr = true;
    }
    FavVideoView localFavVideoView = this.tjl;
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    localFavVideoView.cWW();
    localFavVideoView.cWX();
    super.onPause();
    f.e(false, true, true);
    AppMethodBeat.o(107272);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107271);
    if (Build.VERSION.SDK_INT >= 21) {
      getWindow().clearFlags(2048);
    }
    Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.tiS) });
    this.tiS = false;
    super.onResume();
    if (this.tjr) {
      this.tjl.cWY();
    }
    f.e(true, true, true);
    AppMethodBeat.o(107271);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(107270);
    Bundle localBundle = this.qaD;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.qaF = getIntent().getIntExtra("img_gallery_top", 0);
        this.qaG = getIntent().getIntExtra("img_gallery_left", 0);
        this.qaH = getIntent().getIntExtra("img_gallery_width", 0);
        this.qaI = getIntent().getIntExtra("img_gallery_height", 0);
        this.qaE.Q(this.qaG, this.qaF, this.qaH, this.qaI);
        if (localBundle == null) {
          this.tjl.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */