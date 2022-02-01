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
import com.tencent.e.i;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.x;
import com.tencent.mm.modelvideo.u;
import com.tencent.mm.platformtools.v;
import com.tencent.mm.plugin.ball.f.f;
import com.tencent.mm.plugin.fav.ui.l.6;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView;
import com.tencent.mm.plugin.fav.ui.widget.FavVideoView.b;
import com.tencent.mm.pluginsdk.ui.tools.q;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.tools.e.c;
import com.tencent.mm.vfs.k;
import com.tencent.mm.vfs.o;
import java.util.Iterator;
import java.util.List;

@com.tencent.mm.ui.base.a(3)
public class FavoriteVideoPlayUI
  extends MMActivity
{
  private boolean dCy;
  private String dua;
  private String hgD;
  private ImageView iXI;
  private boolean isAnimated;
  private String ixk;
  private long msgId;
  private Bundle oMP;
  private com.tencent.mm.ui.tools.e oMQ;
  private int oMR;
  private int oMS;
  private int oMT;
  private int oMU;
  private String rAB;
  private View.OnLongClickListener rIu;
  private FavVideoView rJA;
  private LinearLayout rJB;
  private boolean rJC;
  private int rJD;
  private boolean rJE;
  private boolean rJF;
  private boolean rJG;
  private boolean rJg;
  private String rJy;
  private RelativeLayout rJz;
  private String thumbPath;
  private int videoDuration;
  
  public FavoriteVideoPlayUI()
  {
    AppMethodBeat.i(107266);
    this.rJg = true;
    this.isAnimated = false;
    this.oMR = 0;
    this.oMS = 0;
    this.oMT = 0;
    this.oMU = 0;
    this.rJC = true;
    this.dCy = true;
    this.rJE = false;
    this.rAB = "";
    this.rJF = true;
    this.rIu = new View.OnLongClickListener()
    {
      public final boolean onLongClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107260);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z", this, localb.ahF());
        if (!FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).Zn)
        {
          ae.i("MicroMsg.FavoriteVideoPlayUI", "longClickListener onClick isPrepared:false");
          com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
          AppMethodBeat.o(107260);
          return true;
        }
        paramAnonymousView.getTag();
        paramAnonymousView = new com.tencent.mm.ui.widget.a.e(FavoriteVideoPlayUI.this.getContext(), 1, false);
        paramAnonymousView.LfS = new n.d()
        {
          public final void onCreateMMMenu(l paramAnonymous2l)
          {
            AppMethodBeat.i(107258);
            if (FavoriteVideoPlayUI.b(FavoriteVideoPlayUI.this))
            {
              if (o.fB(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2l.add(0, 1, 0, FavoriteVideoPlayUI.this.getString(2131759001));
              }
              paramAnonymous2l.add(0, 2, 0, FavoriteVideoPlayUI.this.getString(2131762784));
            }
            AppMethodBeat.o(107258);
          }
        };
        paramAnonymousView.LfT = new n.e()
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
              if (o.fB(FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this))) {
                paramAnonymous2MenuItem.putExtra("image_path", FavoriteVideoPlayUI.c(FavoriteVideoPlayUI.this));
              }
              for (;;)
              {
                paramAnonymous2MenuItem.putExtra("Retr_Msg_Type", 1);
                com.tencent.mm.br.d.c(FavoriteVideoPlayUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
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
              String str2 = u.Ib(str1);
              ae.i("MicroMsg.FavoriteVideoPlayUI", "save video now video path %s out path %s", new Object[] { str1, str2 });
              if (bu.isNullOrNil(str2))
              {
                Toast.makeText(localFavoriteVideoPlayUI, localFavoriteVideoPlayUI.getString(2131764682), 1).show();
                AppMethodBeat.o(107259);
                return;
              }
              Toast.makeText(localFavoriteVideoPlayUI, localFavoriteVideoPlayUI.getString(2131764683, new Object[] { com.tencent.mm.sdk.f.b.aSY(str2) }), 1).show();
              q.k(str2, localFavoriteVideoPlayUI);
              com.tencent.e.h.MqF.aO(new FavoriteVideoPlayUI.4(paramAnonymous2MenuItem, str2));
            }
          }
        };
        paramAnonymousView.cPF();
        com.tencent.mm.hellhoundlib.a.a.a(true, this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$3", "android/view/View$OnLongClickListener", "onLongClick", "(Landroid/view/View;)Z");
        AppMethodBeat.o(107260);
        return true;
      }
    };
    this.rJG = false;
    AppMethodBeat.o(107266);
  }
  
  private void g(ImageView paramImageView)
  {
    AppMethodBeat.i(107268);
    if (this.rJF)
    {
      this.rJA.c(this.hgD, this.rJE, this.rAB);
      if (paramImageView != null)
      {
        if (!o.fB(this.thumbPath)) {
          break label70;
        }
        paramImageView.setImageBitmap(BackwardSupportUtil.b.p(this.thumbPath, 1.0F));
      }
    }
    for (;;)
    {
      ae.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: fullPath is not null,but not exist videoView.setVideoData(null)");
      AppMethodBeat.o(107268);
      return;
      label70:
      paramImageView.setImageResource(2131231602);
      continue;
      ((com.tencent.mm.plugin.record.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.record.a.g.class)).g(getIntent().getStringExtra("record_xml"), this.msgId, this.dua);
      this.rJA.c(this.hgD, true, this.dua);
      this.rJA.setThumbView(this.thumbPath);
    }
  }
  
  public final void bYa()
  {
    AppMethodBeat.i(107276);
    this.rJB.setVisibility(8);
    int k = this.rJz.getWidth();
    int j = this.rJz.getHeight();
    int i = j;
    if (this.oMT != 0)
    {
      i = j;
      if (this.oMU != 0) {
        i = (int)(k / this.oMT * this.oMU);
      }
    }
    this.oMQ.kg(k, i);
    this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
    this.oMQ.a(this.rJA, this.iXI, new e.c()
    {
      public final void onAnimationEnd()
      {
        AppMethodBeat.i(164105);
        new aq().post(new Runnable()
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
            this.rDo.dismiss();
            AppMethodBeat.o(164101);
          }
        };
        if (!bu.isNullOrNil((String)localObject)) {
          break label91;
        }
        AppMethodBeat.o(107275);
        return;
        localObject = paramIntent.getStringExtra("Select_Conv_User");
        break;
      }
      label91:
      Object localObject = bu.U(((String)localObject).split(",")).iterator();
      label295:
      while (((Iterator)localObject).hasNext())
      {
        String str1 = (String)((Iterator)localObject).next();
        AppCompatActivity localAppCompatActivity = getContext();
        String str2 = this.hgD;
        String str3 = this.thumbPath;
        paramInt1 = this.videoDuration;
        String str4 = this.rJy;
        String str5 = this.ixk;
        if (localAppCompatActivity == null) {
          ae.w("MicroMsg.FavSendLogic", "want to send fav video, but context is null");
        }
        for (;;)
        {
          if (bu.isNullOrNil(paramIntent)) {
            break label295;
          }
          com.tencent.mm.plugin.messenger.a.g.doC().aa(str1, paramIntent, x.Bb(str1));
          break;
          if (bu.isNullOrNil(str1))
          {
            ae.w("MicroMsg.FavSendLogic", "want to send fav video, but to user is null");
          }
          else
          {
            k localk = new k(str2);
            if ((bu.isNullOrNil(str2)) && (!localk.exists())) {
              ae.w("MicroMsg.FavSendLogic", "want to send fav video, but datapath is null or is not exist ");
            } else {
              com.tencent.mm.kernel.g.ajU().aw(new l.6(localAppCompatActivity, str1, str2, str3, paramInt1, str4, str5, local5));
            }
          }
        }
      }
      com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131758834));
      AppMethodBeat.o(107275);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107275);
  }
  
  public void onBackPressed()
  {
    AppMethodBeat.i(107277);
    bYa();
    AppMethodBeat.o(107277);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107267);
    super.onCreate(paramBundle);
    hideTitleView();
    if (com.tencent.mm.compatible.util.d.lA(19)) {
      getWindow().setFlags(201327616, 201327616);
    }
    for (;;)
    {
      this.oMP = paramBundle;
      getWindow().addFlags(128);
      this.rJC = getIntent().getBooleanExtra("key_detail_data_valid", true);
      this.hgD = getIntent().getStringExtra("key_detail_fav_path");
      this.thumbPath = getIntent().getStringExtra("key_detail_fav_thumb_path");
      this.videoDuration = getIntent().getIntExtra("key_detail_fav_video_duration", 0);
      this.rJy = getIntent().getStringExtra("key_detail_statExtStr");
      this.rJD = getIntent().getIntExtra("key_detail_fav_video_scene_from", 0);
      this.dCy = getIntent().getBooleanExtra("show_share", true);
      this.rJE = getIntent().getBooleanExtra("key_detail_fav_video_show_download_status", false);
      this.rAB = getIntent().getStringExtra("key_detail_data_id");
      this.rJF = getIntent().getBooleanExtra("key_detail_is_data_exist", true);
      this.dua = getIntent().getStringExtra("record_data_id");
      this.msgId = getIntent().getLongExtra("message_id", -1L);
      this.ixk = getIntent().getStringExtra("key_detail_msg_uuid");
      if (!o.fB(this.thumbPath))
      {
        paramBundle = com.tencent.mm.plugin.fav.ui.e.ahE(this.hgD);
        if (paramBundle == null) {}
      }
      try
      {
        ae.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: create thumbpath bitmap, saveBitmapToImage ");
        com.tencent.mm.sdk.platformtools.h.a(paramBundle, 60, Bitmap.CompressFormat.JPEG, this.thumbPath, true);
        boolean bool = this.rJC;
        if (bu.isNullOrNil(this.thumbPath))
        {
          paramBundle = "";
          if (!bu.isNullOrNil(this.hgD)) {
            break label580;
          }
          str = "";
          ae.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay: init data, isVideoValid: %B. thumbPath: %s, fullPath: %s", new Object[] { Boolean.valueOf(bool), paramBundle, str });
          this.rJz = ((RelativeLayout)findViewById(2131306409));
          this.rJA = ((FavVideoView)findViewById(2131306410));
          paramBundle = (ImageView)findViewById(2131306398);
          this.iXI = ((ImageView)findViewById(2131300336));
          this.rJB = ((LinearLayout)findViewById(2131299788));
          if ((!this.rJC) && (this.rJB != null)) {
            this.rJB.setVisibility(0);
          }
          if (bu.isNullOrNil(this.hgD)) {
            break label596;
          }
          if (!o.fB(this.hgD)) {
            break label588;
          }
          this.rJA.setVideoData(this.hgD);
          ae.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  videoView.setVideoData(fullPath)");
          if (this.dCy) {
            this.rJA.setOnLongClickListener(this.rIu);
          }
          this.oMQ = new com.tencent.mm.ui.tools.e(null);
          this.rJA.setCallback(new FavVideoView.b()
          {
            public final void finish()
            {
              AppMethodBeat.i(107256);
              FavoriteVideoPlayUI.this.bYa();
              AppMethodBeat.o(107256);
            }
          });
          this.rJA.setOnClickListener(new View.OnClickListener()
          {
            public final void onClick(View paramAnonymousView)
            {
              AppMethodBeat.i(107257);
              com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
              localb.bd(paramAnonymousView);
              com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteVideoPlayUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
              if (FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this) != null) {
                FavoriteVideoPlayUI.a(FavoriteVideoPlayUI.this).cyR();
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
          ae.printErrStackTrace("MicroMsg.FavoriteVideoPlayUI", paramBundle, "", new Object[0]);
          continue;
          paramBundle = this.thumbPath;
          continue;
          label580:
          String str = this.hgD;
          continue;
          label588:
          g(paramBundle);
          continue;
          label596:
          g(paramBundle);
        }
      }
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107273);
    setResult(0, getIntent().putExtra("key_activity_browse_time", getActivityBrowseTimeMs()));
    this.rJA.onDestroy();
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
    if (this.rJA.isPlaying()) {
      this.rJG = true;
    }
    FavVideoView localFavVideoView = this.rJA;
    ae.i("MicroMsg.FavVideoView", "VideoPlay:   onPause()");
    localFavVideoView.cyT();
    localFavVideoView.cyU();
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
    ae.i("MicroMsg.FavoriteVideoPlayUI", "VideoPlay:  onResume,hadOnStart is %B", new Object[] { Boolean.valueOf(this.rJg) });
    this.rJg = false;
    super.onResume();
    if (this.rJG) {
      this.rJA.cyV();
    }
    f.e(true, true, true);
    AppMethodBeat.o(107271);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(107270);
    Bundle localBundle = this.oMP;
    if (!this.isAnimated)
    {
      this.isAnimated = true;
      if (Build.VERSION.SDK_INT >= 12)
      {
        this.oMR = getIntent().getIntExtra("img_gallery_top", 0);
        this.oMS = getIntent().getIntExtra("img_gallery_left", 0);
        this.oMT = getIntent().getIntExtra("img_gallery_width", 0);
        this.oMU = getIntent().getIntExtra("img_gallery_height", 0);
        this.oMQ.R(this.oMS, this.oMR, this.oMT, this.oMU);
        if (localBundle == null) {
          this.rJA.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
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