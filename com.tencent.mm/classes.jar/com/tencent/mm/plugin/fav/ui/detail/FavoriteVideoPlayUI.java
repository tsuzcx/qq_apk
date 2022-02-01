package com.tencent.mm.plugin.fav.ui.detail;

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
import com.tencent.mm.autogen.b.fi;
import com.tencent.mm.message.k.b;
import com.tencent.mm.model.ab;
import com.tencent.mm.platformtools.ExportFileUtil;
import com.tencent.mm.platformtools.ExportFileUtil.a;
import com.tencent.mm.plugin.fav.ui.e;
import com.tencent.mm.plugin.fav.ui.l.6;
import com.tencent.mm.plugin.fav.ui.q.d;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.i.e;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.BitmapFactory;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.system.AndroidMediaUtil;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.tools.f.c;
import com.tencent.mm.vfs.u;
import com.tencent.mm.vfs.y;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
@com.tencent.mm.ui.widget.pulldown.c(0)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private String Acs;
  private View.OnLongClickListener AkV;
  private boolean AlL;
  private String Amc;
  private RelativeLayout Amd;
  private FavVideoView Ame;
  private LinearLayout Amf;
  private boolean Amg;
  private int Amh;
  private boolean Ami;
  private boolean Amj;
  private boolean Amk;
  private String fullPath;
  private String hIQ;
  private boolean hTH;
  private boolean isAnimated;
  private long msgId;
  private ImageView pIB;
  private String pbn;
  private String thumbPath;
  private int videoDuration;
  private Bundle wAX;
  private com.tencent.mm.ui.tools.f wAY;
  private int wAZ;
  private int wBa;
  private int wBb;
  private int wBc;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(107266);
    this.AlL = true;
    this.isAnimated = false;
    this.wAZ = 0;
    this.wBa = 0;
    this.wBb = 0;
    this.wBc = 0;
    this.Amg = true;
    this.hTH = true;
    this.Ami = false;
    this.Acs = "";
    this.Amj = true;
    this.AkV = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107260);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.aYj());
        if (!FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).hS)
        {
          Log.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(107260);
          return true;
        }
        paramAnonymousView.getTag();
        paramAnonymousView = new com.tencent.mm.ui.widget.a.f(FavoriteVideoPlayUI.this.getContext(), 1, false);
        paramAnonymousView.Vtg = new u.g()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.s paramAnonymous2s)
          {
            AppMethodBeat.i(107258);
            if (FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.this))
            {
              if (y.ZC(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2s.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(q.i.favorite_share_with_friend));
              }
              paramAnonymous2s.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(q.i.save_video_to_local));
            }
            AppMethodBeat.o(107258);
          }
        };
        paramAnonymousView.GAC = new u.i()
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
              if (y.ZC(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this));
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 1);
                com.tencent.mm.br.c.d(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
                if (FavoriteVideoPlayUI.e(FavoriteVideoPlayUI.this) != 0) {
                  break;
                }
                com.tencent.mm.plugin.fav.a.h.I(FavoriteVideoPlayUI.this.getIntent().getLongExtra("key_detail_info_id", 0L), 1);
                AppMethodBeat.o(107259);
                return;
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this));
              }
              paramAnonymous2MenuItem = FavoriteVideoPlayUI.this;
              String str = FavoriteVideoPlayUI.d(FavoriteVideoPlayUI.this);
              FavoriteVideoPlayUI localFavoriteVideoPlayUI = FavoriteVideoPlayUI.this;
              ExportFileUtil.b(paramAnonymous2MenuItem.getContext(), str, new FavoriteVideoPlayUI.4(paramAnonymous2MenuItem, str, localFavoriteVideoPlayUI));
            }
          }
        };
        paramAnonymousView.dDn();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107260);
        return true;
      }
    };
    this.Amk = false;
    AppMethodBeat.o(107266);
  }
  
  private void i(ImageView paramImageView)
  {
    AppMethodBeat.i(107268);
    if (this.Amj)
    {
      this.Ame.e(this.fullPath, this.Ami, this.Acs);
      if (paramImageView != null)
      {
        if (!y.ZC(this.thumbPath)) {
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
      paramImageView.setImageResource(q.d.chat_video_nf_mask_from);
      continue;
      String str = getIntent().getStringExtra("record_xml");
      paramImageView = str;
      if (Util.isNullOrNil(str))
      {
        Object localObject = ((n)com.tencent.mm.kernel.h.ax(n.class)).gaZ().sl(this.msgId);
        paramImageView = str;
        if (localObject != null)
        {
          localObject = k.b.aP(((fi)localObject).field_content, ((fi)localObject).field_reserved);
          paramImageView = str;
          if (localObject != null) {
            paramImageView = ((k.b)localObject).nRF;
          }
        }
      }
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.record.a.g.class)).g(paramImageView, this.msgId, this.hIQ);
      this.Ame.e(this.fullPath, true, this.hIQ);
      this.Ame.setThumbView(this.thumbPath);
    }
  }
  
  public boolean dispatchKeyEvent(KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(107274);
    boolean bool = super.dispatchKeyEvent(paramKeyEvent);
    AppMethodBeat.o(107274);
    return bool;
  }
  
  public final void dmJ()
  {
    AppMethodBeat.i(107276);
    this.Amf.setVisibility(8);
    int k = this.Amd.getWidth();
    int j = this.Amd.getHeight();
    int i = j;
    if (this.wBb != 0)
    {
      i = j;
      if (this.wBc != 0) {
        i = (int)(k / this.wBb * this.wBc);
      }
    }
    this.wAY.oC(k, i);
    this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
    this.wAY.a(this.Ame, this.pIB, new f.c()
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
  
  public int getLayoutId()
  {
    return q.f.fav_video_play_ui;
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
            this.Afz.dismiss();
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
        String str4 = this.Amc;
        String str5 = this.pbn;
        if (localAppCompatActivity == null) {
          Log.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (Util.isNullOrNil(paramIntent)) {
            break label297;
          }
          com.tencent.mm.plugin.messenger.a.g.gaI().ap(str1, paramIntent, ab.IX(str1));
          break;
          if (Util.isNullOrNil(str1))
          {
            Log.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            u localu = new u(str2);
            if ((Util.isNullOrNil(str2)) && (!localu.jKS())) {
              Log.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.h.baH().postToWorker(new l.6(localAppCompatActivity, str1, str2, str3, paramInt1, str4, str5, local5));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.fav_finish_sent));
      AppMethodBeat.o(107275);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107275);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(107277);
    dmJ();
    AppMethodBeat.o(107277);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107267);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.rb(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.wAX = paramBundle;
      getWindow().addFlags(128);
      this.Amg = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.fullPath = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.Amc = getIntent().getStringExtra("key_detail_statExtStr");
      this.Amh = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.hTH = getIntent().getBooleanExtra("show_share", true);
      this.Ami = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.Acs = getIntent().getStringExtra("key_detail_data_id");
      this.Amj = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.hIQ = getIntent().getStringExtra("record_data_id");
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      this.pbn = getIntent().getStringExtra("key_detail_msg_uuid");
      if (!y.ZC(this.thumbPath))
      {
        paramBundle = e.auu(this.fullPath);
        if (paramBundle == null) {}
      }
      try
      {
        Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        BitmapUtil.saveBitmapToImage(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.Amg;
        if (Util.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!Util.isNullOrNil(this.fullPath)) {
            break label596;
          }
          str = "";
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.Amd = ((RelativeLayout)findViewById(q.e.video_ui_root));
          this.Ame = ((FavVideoView)findViewById(q.e.video_view));
          paramBundle = (ImageView)findViewById(q.e.video_thumb);
          this.pIB = ((ImageView)findViewById(q.e.gallery_bg));
          this.Amf = ((LinearLayout)findViewById(q.e.fav_expired_btn));
          if ((!this.Amg) && (this.Amf != null)) {
            this.Amf.setVisibility(0);
          }
          if (Util.isNullOrNil(this.fullPath)) {
            break label612;
          }
          if (!y.ZC(this.fullPath)) {
            break label604;
          }
          this.Ame.setVideoData(this.fullPath);
          Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          if (this.hTH) {
            this.Ame.setOnLongClickListener(this.AkV);
          }
          this.wAY = new com.tencent.mm.ui.tools.f(null);
          this.Ame.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107256);
              FavoriteVideoPlayUI.this.dmJ();
              AppMethodBeat.o(107256);
            }
          });
          this.Ame.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(107257);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.cH(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
              if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).dST();
              }
              com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
              AppMethodBeat.o(107257);
            }
          });
          if (!aw.ato()) {
            break label620;
          }
          this.Ame.setVideoScaleType(i.e.XYM);
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
          i(paramBundle);
          continue;
          label612:
          i(paramBundle);
        }
        label620:
        this.Ame.setVideoScaleType(i.e.XYK);
        AppMethodBeat.o(107267);
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107273);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.Ame.onDestroy();
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
    if (this.Ame.isPlaying()) {
      this.Amk = true;
    }
    FavVideoView localFavVideoView = this.Ame;
    Log.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    localFavVideoView.dSV();
    localFavVideoView.dSW();
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
    Log.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.AlL) });
    this.AlL = false;
    super.onResume();
    if (this.Amk) {
      this.Ame.dSX();
    }
    com.tencent.mm.plugin.ball.f.f.d(true, true, true);
    AppMethodBeat.o(107271);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(107270);
    Bundle localBundle = this.wAX;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.wAZ = getIntent().getIntExtra("img_gallery_top", 0);
        this.wBa = getIntent().getIntExtra("img_gallery_left", 0);
        this.wBb = getIntent().getIntExtra("img_gallery_width", 0);
        this.wBc = getIntent().getIntExtra("img_gallery_height", 0);
        this.wAY.af(this.wBa, this.wAZ, this.wBb, this.wBc);
        if (localBundle == null) {
          this.Ame.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVideoPlayUI
 * JD-Core Version:    0.7.0.1
 */