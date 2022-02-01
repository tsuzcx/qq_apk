package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.c;
import com.tencent.mm.plugin.fav.a.n.d;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.s.c;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.k.a;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements q, MStorage.IOnStorageChange
{
  private anm fDI;
  private k wLT;
  private g wMe;
  private boolean wOi;
  private boolean wOo;
  private View wPd;
  private ImageView wPe;
  private MMPinProgressBtn wPf;
  private VideoPlayerTextureView wPg;
  private ImageView wPh;
  private long wPi;
  private boolean wPj;
  private boolean wPk;
  private Runnable wPl;
  private boolean wPm;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(107222);
    this.wPj = true;
    this.wOi = false;
    this.wPk = false;
    this.wOo = false;
    this.wLT = new k();
    this.wPl = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(107219);
        if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDone()) && (com.tencent.mm.plugin.fav.a.b.g(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))) && (FavoriteSightDetailUI.d(FavoriteSightDetailUI.this) != null) && (FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).isPlaying()))
        {
          AppMethodBeat.o(107219);
          return;
        }
        FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true);
        AppMethodBeat.o(107219);
      }
    };
    this.wPm = false;
    AppMethodBeat.o(107222);
  }
  
  private void dlK()
  {
    AppMethodBeat.i(107232);
    String str = com.tencent.mm.plugin.fav.a.b.d(this.fDI);
    if (!u.agG(str))
    {
      AppMethodBeat.o(107232);
      return;
    }
    this.wPg.stop();
    this.wPg.setMute(true);
    this.wPg.setVideoPath(str);
    AppMethodBeat.o(107232);
  }
  
  @SuppressLint({"ResourceType"})
  private void nU(boolean paramBoolean)
  {
    AppMethodBeat.i(107228);
    if (this.wMe.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.g(this.fDI))
      {
        this.wPe.setVisibility(8);
        this.wPf.setVisibility(8);
        dlK();
        AppMethodBeat.o(107228);
        return;
      }
      if (Util.isNullOrNil(this.fDI.Rwb)) {
        this.wPe.setImageResource(s.h.shortvideo_play_btn);
      }
    }
    for (;;)
    {
      this.wPe.setVisibility(0);
      this.wPf.setVisibility(8);
      this.wPh.setVisibility(0);
      AppMethodBeat.o(107228);
      return;
      Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.wPe.setImageResource(s.h.shortvideo_play_btn);
      continue;
      if (this.wMe.djF())
      {
        if (Util.isNullOrNil(this.fDI.Rwb))
        {
          this.wPe.setImageResource(s.h.shortvideo_play_btn);
          if (!paramBoolean) {}
        }
        else
        {
          this.wPe.setImageResource(s.h.shortvideo_play_btn);
          if (paramBoolean) {
            com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.download_fail));
          }
        }
      }
      else if (this.wMe.djE())
      {
        this.wPe.setImageResource(s.h.shortvideo_play_btn);
        if (paramBoolean) {
          com.tencent.mm.ui.base.h.cO(getContext(), getString(s.i.fav_upload_fail));
        }
      }
      else
      {
        if ((this.wMe.isDownloading()) || (this.wMe.djD()))
        {
          this.wPe.setVisibility(8);
          this.wPf.setVisibility(0);
          com.tencent.mm.plugin.fav.a.c localc = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa);
          if (localc != null) {
            this.wPf.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.wPh.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
            this.wPf.setProgress(0);
          }
        }
        Log.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.wPe.setImageResource(s.h.shortvideo_play_btn);
      }
    }
  }
  
  protected final MMLoadScrollView dly()
  {
    AppMethodBeat.i(107223);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(s.e.scroll_view);
    AppMethodBeat.o(107223);
    return localMMLoadScrollView;
  }
  
  public final void e(com.tencent.mm.plugin.fav.a.c paramc)
  {
    AppMethodBeat.i(107230);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107230);
      return;
    }
    Log.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.fDI.fEa, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
    if (paramc.field_offset > paramc.field_totalLen)
    {
      Log.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
      if (1 != paramc.field_type) {
        break label229;
      }
    }
    label229:
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.c(paramc);
      }
      if (paramc.field_dataId.equals(this.fDI.fEa))
      {
        final int i = (int)paramc.getProgress();
        this.wPf.post(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107220);
            FavoriteSightDetailUI.c(FavoriteSightDetailUI.this).setProgress(i);
            AppMethodBeat.o(107220);
          }
        });
      }
      AppMethodBeat.o(107230);
      return;
    }
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return s.f.favorite_sight_detail_ui;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(107231);
    if ((paramInt1 == 1) && (-1 == paramInt2))
    {
      String str;
      label29:
      Object localObject;
      label87:
      n.d locald;
      if (paramIntent == null)
      {
        str = null;
        if (paramIntent != null) {
          break label148;
        }
        paramIntent = null;
        localObject = new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107221);
            this.wJe.dismiss();
            AppMethodBeat.o(107221);
          }
        };
        l.a(getContext(), str, paramIntent, this.wMe, (Runnable)localObject);
        boolean bool = ab.Lj(str);
        if (!bool) {
          break label159;
        }
        paramIntent = n.c.wHf;
        localObject = this.wMe;
        locald = n.d.wHi;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = v.Pu(str);; paramInt1 = 0)
      {
        n.a(paramIntent, (g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(s.i.fav_finish_sent));
        AppMethodBeat.o(107231);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = n.c.wHe;
        break label87;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107231);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107224);
    com.tencent.mm.pluginsdk.h.r(this);
    super.onCreate(paramBundle);
    this.wPi = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.wMe = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wPi);
    if (this.wMe == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.wPi) });
      finish();
      AppMethodBeat.o(107224);
      return;
    }
    H(this.wMe);
    n.x(this.wMe);
    a.a(this, this.wMe);
    this.fDI = com.tencent.mm.plugin.fav.a.b.c(this.wMe);
    this.wPe = ((ImageView)findViewById(s.e.status_btn));
    this.wPf = ((MMPinProgressBtn)findViewById(s.e.video_progress));
    this.wPd = findViewById(s.e.click_area);
    this.wPg = ((VideoPlayerTextureView)findViewById(s.e.video_view));
    this.wPh = ((ImageView)findViewById(s.e.video_thumb));
    this.wPd.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if ((com.tencent.mm.q.a.cy(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cw(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cB(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107207);
          return;
        }
        Log.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id), Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_itemStatus) });
        if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDone())
        {
          if (com.tencent.mm.plugin.fav.a.b.g(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))
          {
            n.a(n.a.wGR, FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if (Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).Rwb))
          {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
          if (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).djE()) {
            break label438;
          }
          com.tencent.mm.plugin.fav.a.b.l(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
        }
        for (;;)
        {
          FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107207);
          return;
          if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).djF())
          {
            if (!Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).Rwb)) {
              break;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if ((!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDownloading()) && (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).djD())) {
            break;
          }
          if (FavoriteSightDetailUI.c(FavoriteSightDetailUI.this).getVisibility() == 8) {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false);
          }
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107207);
          return;
          label438:
          com.tencent.mm.plugin.fav.a.b.m(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
        }
      }
    });
    this.wPg.setVideoCallback(new k.a()
    {
      public final void eM(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int fE(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107212);
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).q(0.0D);
        AppMethodBeat.o(107212);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107211);
        Log.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == -1)
        {
          FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).stop();
          if (u.agG(com.tencent.mm.plugin.fav.a.b.d(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))))
          {
            FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
            AppMethodBeat.o(107211);
            return;
          }
          if (u.agG(com.tencent.mm.plugin.fav.a.b.a(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))) {
            FavoriteSightDetailUI.e(FavoriteSightDetailUI.this).setVisibility(0);
          }
          AppMethodBeat.o(107211);
          return;
        }
        if (FavoriteSightDetailUI.g(FavoriteSightDetailUI.this))
        {
          onCompletion();
          AppMethodBeat.o(107211);
          return;
        }
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).stop();
        if (FavoriteSightDetailUI.h(FavoriteSightDetailUI.this))
        {
          AppMethodBeat.o(107211);
          return;
        }
        FavoriteSightDetailUI.i(FavoriteSightDetailUI.this);
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107209);
            com.tencent.mm.ui.base.h.p(FavoriteSightDetailUI.this.getContext(), s.i.video_file_play_faile, s.i.video_play_err);
            AppMethodBeat.o(107209);
          }
        });
        AppMethodBeat.o(107211);
      }
      
      public final void qX()
      {
        AppMethodBeat.i(107210);
        Log.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).setLoop(true);
        FavoriteSightDetailUI.b(FavoriteSightDetailUI.this, FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).start());
        MMHandlerThread.postToMainThread(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107208);
            FavoriteSightDetailUI.e(FavoriteSightDetailUI.this).setVisibility(8);
            AppMethodBeat.o(107208);
          }
        });
        AppMethodBeat.o(107210);
      }
    });
    setMMTitle(getString(s.i.favorite_detail));
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107213);
        FavoriteSightDetailUI.this.finish();
        AppMethodBeat.o(107213);
        return true;
      }
    });
    addIconOptionMenu(0, s.i.top_item_desc_more, s.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107218);
        paramAnonymousMenuItem = new e(FavoriteSightDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.ODT = new q.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
          {
            AppMethodBeat.i(107214);
            if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).djA()) && (!FavoriteSightDetailUI.j(FavoriteSightDetailUI.this).u(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this)))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) && (FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).SyU == 0)) {
                paramAnonymous2o.d(0, FavoriteSightDetailUI.this.getString(s.i.favorite_share_with_friend));
              }
              paramAnonymous2o.d(4, FavoriteSightDetailUI.this.getString(s.i.favorite_save_as_note));
              paramAnonymous2o.d(3, FavoriteSightDetailUI.this.getString(s.i.favorite_edit_tag_tips));
              paramAnonymous2o.d(2, FavoriteSightDetailUI.this.getContext().getString(s.i.app_delete));
              AppMethodBeat.o(107214);
              return;
            }
          }
        };
        paramAnonymousMenuItem.ODU = new q.g()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
          {
            AppMethodBeat.i(107217);
            switch (paramAnonymous2MenuItem.getItemId())
            {
            }
            for (;;)
            {
              AppMethodBeat.o(107217);
              return;
              com.tencent.mm.plugin.fav.a.h.y(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.by.c.d(FavoriteSightDetailUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.wNU;
              paramAnonymous2MenuItem.wGu += 1;
              AppMethodBeat.o(107217);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(s.i.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107216);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(s.i.app_delete_tips), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107215);
                      FavoriteSightDetailUI.this.wNU.wGy = true;
                      paramAnonymous3DialogInterface.dismiss();
                      Log.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id) });
                      FavoriteSightDetailUI.this.finish();
                      AppMethodBeat.o(107215);
                    }
                  });
                  AppMethodBeat.o(107216);
                }
              }, null);
              AppMethodBeat.o(107217);
              return;
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.wNU;
              paramAnonymous2MenuItem.wGx += 1;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(107217);
              return;
              j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.k(FavoriteSightDetailUI.this), FavoriteSightDetailUI.this.wNU);
            }
          }
        };
        paramAnonymousMenuItem.eik();
        AppMethodBeat.o(107218);
        return true;
      }
    });
    if (!u.agG(com.tencent.mm.plugin.fav.a.b.a(this.fDI))) {
      if (!Util.isNullOrNil(this.fDI.lmm)) {
        com.tencent.mm.plugin.fav.a.b.a(this.wMe, this.fDI);
      }
    }
    do
    {
      nU(false);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(this);
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().a(this);
      com.tencent.mm.pluginsdk.h.s(this);
      AppMethodBeat.o(107224);
      return;
      paramBundle = com.tencent.mm.plugin.fav.ui.o.a(this.fDI, this.wMe);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    int k;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.wPm)
    {
      this.wPm = true;
      k = ar.au(getContext()).x;
      f = getResources().getDimensionPixelOffset(s.c.FavDetailPadding) * 2;
      localLayoutParams = this.wPd.getLayoutParams();
      if (localLayoutParams != null) {
        break label470;
      }
      Log.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.wPh.setImageBitmap(paramBundle);
      this.wPh.setVisibility(0);
      break;
      label470:
      localLayoutParams.width = (k - (int)(f + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.wPd.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107225);
    if (this.wPg != null)
    {
      this.wPg.setVideoCallback(null);
      this.wPg.stop();
    }
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(this);
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(107225);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107229);
    Log.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.wMe.field_localId) });
    paramString = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wMe.field_localId);
    if (paramString == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107229);
      return;
    }
    this.wMe = paramString;
    this.fDI = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107229);
      return;
      if (this.wOo)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavCdnStorage().aAb(this.fDI.fEa).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.wMe, this.fDI, true);
          this.wOo = true;
        }
        Log.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.wOo) });
        bool = this.wOo;
      }
    }
    MMHandlerThread.removeRunnable(this.wPl);
    MMHandlerThread.postToMainThreadDelayed(this.wPl, 500L);
    AppMethodBeat.o(107229);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107227);
    if (this.wPg != null) {
      this.wPg.stop();
    }
    super.onPause();
    AppMethodBeat.o(107227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107226);
    super.onResume();
    if (this.wPg != null)
    {
      if (this.wPj) {
        break label40;
      }
      dlK();
    }
    for (;;)
    {
      this.wPj = false;
      AppMethodBeat.o(107226);
      return;
      label40:
      if (!this.wPg.isPlaying()) {
        this.wPg.start();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI
 * JD-Core Version:    0.7.0.1
 */