package com.tencent.mm.plugin.fav.ui.detail;

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
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.n.a;
import com.tencent.mm.plugin.fav.a.n.c;
import com.tencent.mm.plugin.fav.a.n.d;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.a.r;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.q.c;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.i.a;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.f;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements q, MStorage.IOnStorageChange
{
  private g AiB;
  private com.tencent.mm.plugin.fav.a.k Air;
  private boolean AkK;
  private boolean AkQ;
  private View AlF;
  private ImageView AlG;
  private MMPinProgressBtn AlH;
  private VideoPlayerTextureView AlI;
  private ImageView AlJ;
  private long AlK;
  private boolean AlL;
  private boolean AlM;
  private Runnable AlN;
  private boolean AlO;
  private arf hIy;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(107222);
    this.AlL = true;
    this.AkK = false;
    this.AlM = false;
    this.AkQ = false;
    this.Air = new com.tencent.mm.plugin.fav.a.k();
    this.AlN = new Runnable()
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
    this.AlO = false;
    AppMethodBeat.o(107222);
  }
  
  private void dSA()
  {
    AppMethodBeat.i(107232);
    String str = com.tencent.mm.plugin.fav.a.b.d(this.hIy);
    if (!com.tencent.mm.vfs.y.ZC(str))
    {
      AppMethodBeat.o(107232);
      return;
    }
    this.AlI.stop();
    this.AlI.setMute(true);
    this.AlI.setVideoPath(str);
    AppMethodBeat.o(107232);
  }
  
  private void pu(boolean paramBoolean)
  {
    AppMethodBeat.i(107228);
    if (this.AiB.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.g(this.hIy))
      {
        this.AlG.setVisibility(8);
        this.AlH.setVisibility(8);
        dSA();
        AppMethodBeat.o(107228);
        return;
      }
      if (Util.isNullOrNil(this.hIy.Ysw)) {
        this.AlG.setImageResource(q.h.shortvideo_play_btn);
      }
    }
    for (;;)
    {
      this.AlG.setVisibility(0);
      this.AlH.setVisibility(8);
      this.AlJ.setVisibility(0);
      AppMethodBeat.o(107228);
      return;
      Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.AlG.setImageResource(q.h.shortvideo_play_btn);
      continue;
      if (this.AiB.dQq())
      {
        if (Util.isNullOrNil(this.hIy.Ysw))
        {
          this.AlG.setImageResource(q.h.shortvideo_play_btn);
          if (!paramBoolean) {}
        }
        else
        {
          this.AlG.setImageResource(q.h.shortvideo_play_btn);
          if (paramBoolean) {
            com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.download_fail));
          }
        }
      }
      else if (this.AiB.dQp())
      {
        this.AlG.setImageResource(q.h.shortvideo_play_btn);
        if (paramBoolean) {
          com.tencent.mm.ui.base.k.cZ(getContext(), getString(q.i.fav_upload_fail));
        }
      }
      else
      {
        if ((this.AiB.isDownloading()) || (this.AiB.dQo()))
        {
          this.AlG.setVisibility(8);
          this.AlH.setVisibility(0);
          com.tencent.mm.plugin.fav.a.c localc = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ);
          if (localc != null) {
            this.AlH.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.AlJ.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
            this.AlH.setProgress(0);
          }
        }
        Log.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.AlG.setImageResource(q.h.shortvideo_play_btn);
      }
    }
  }
  
  protected final MMLoadScrollView dSo()
  {
    AppMethodBeat.i(107223);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(q.e.scroll_view);
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
    Log.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.hIy.hIQ, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
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
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.c(paramc);
      }
      if (paramc.field_dataId.equals(this.hIy.hIQ))
      {
        final int i = (int)paramc.getProgress();
        this.AlH.post(new Runnable()
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
    return q.f.favorite_sight_detail_ui;
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
            this.Afz.dismiss();
            AppMethodBeat.o(107221);
          }
        };
        l.a(getContext(), str, paramIntent, this.AiB, (Runnable)localObject);
        boolean bool = au.bwE(str);
        if (!bool) {
          break label159;
        }
        paramIntent = n.c.Ado;
        localObject = this.AiB;
        locald = n.d.Adr;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = v.getMembersCountByChatRoomName(str);; paramInt1 = 0)
      {
        n.a(paramIntent, (g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.u(this, getString(q.i.fav_finish_sent));
        AppMethodBeat.o(107231);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = n.c.Adn;
        break label87;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107231);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107224);
    com.tencent.mm.pluginsdk.h.w(this);
    super.onCreate(paramBundle);
    this.AlK = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.AiB = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.AlK);
    if (this.AiB == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.AlK) });
      finish();
      AppMethodBeat.o(107224);
      return;
    }
    H(this.AiB);
    n.x(this.AiB);
    a.a(this, this.AiB);
    this.hIy = com.tencent.mm.plugin.fav.a.b.c(this.AiB);
    this.AlG = ((ImageView)findViewById(q.e.status_btn));
    this.AlH = ((MMPinProgressBtn)findViewById(q.e.video_progress));
    this.AlF = findViewById(q.e.click_area);
    this.AlI = ((VideoPlayerTextureView)findViewById(q.e.video_view));
    this.AlJ = ((ImageView)findViewById(q.e.video_thumb));
    this.AlF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if ((com.tencent.mm.n.a.dm(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dl(paramAnonymousView.getContext())) || (com.tencent.mm.n.a.dp(paramAnonymousView.getContext())))
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
            n.a(n.a.Ada, FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if (Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).Ysw))
          {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
          if (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).dQp()) {
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
          if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).dQq())
          {
            if (!Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).Ysw)) {
              break;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if ((!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDownloading()) && (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).dQo())) {
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
    this.AlI.setVideoCallback(new i.a()
    {
      public final void Qz()
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
      
      public final void fG(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int gw(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107212);
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).H(0.0D);
        AppMethodBeat.o(107212);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107211);
        Log.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == -1)
        {
          FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).stop();
          if (com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.fav.a.b.d(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))))
          {
            FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
            AppMethodBeat.o(107211);
            return;
          }
          if (com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.fav.a.b.a(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))) {
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
            com.tencent.mm.ui.base.k.s(FavoriteSightDetailUI.this.getContext(), q.i.video_file_play_faile, q.i.video_play_err);
            AppMethodBeat.o(107209);
          }
        });
        AppMethodBeat.o(107211);
      }
    });
    setMMTitle(getString(q.i.favorite_detail));
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
    addIconOptionMenu(0, q.i.top_item_desc_more, q.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107218);
        paramAnonymousMenuItem = new f(FavoriteSightDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.Vtg = new u.g()
        {
          public final void onCreateMMMenu(s paramAnonymous2s)
          {
            AppMethodBeat.i(107214);
            if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).dQl()) && (!FavoriteSightDetailUI.j(FavoriteSightDetailUI.this).u(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this)))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) && (FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).ZzM == 0)) {
                paramAnonymous2s.c(0, FavoriteSightDetailUI.this.getString(q.i.favorite_share_with_friend));
              }
              paramAnonymous2s.c(4, FavoriteSightDetailUI.this.getString(q.i.favorite_save_as_note));
              paramAnonymous2s.c(3, FavoriteSightDetailUI.this.getString(q.i.favorite_edit_tag_tips));
              paramAnonymous2s.c(2, FavoriteSightDetailUI.this.getContext().getString(q.i.app_delete));
              AppMethodBeat.o(107214);
              return;
            }
          }
        };
        paramAnonymousMenuItem.GAC = new u.i()
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
              com.tencent.mm.plugin.fav.a.h.I(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.br.c.d(FavoriteSightDetailUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.Akw;
              paramAnonymous2MenuItem.AcD += 1;
              AppMethodBeat.o(107217);
              return;
              com.tencent.mm.ui.base.k.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(q.i.app_delete_tips), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107216);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.k.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(q.i.app_delete_tips), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107215);
                      FavoriteSightDetailUI.this.Akw.AcH = true;
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
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.Akw;
              paramAnonymous2MenuItem.AcG += 1;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(107217);
              return;
              j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.k(FavoriteSightDetailUI.this), FavoriteSightDetailUI.this.Akw);
            }
          }
        };
        paramAnonymousMenuItem.dDn();
        AppMethodBeat.o(107218);
        return true;
      }
    });
    if (!com.tencent.mm.vfs.y.ZC(com.tencent.mm.plugin.fav.a.b.a(this.hIy))) {
      if (!Util.isNullOrNil(this.hIy.nRr)) {
        com.tencent.mm.plugin.fav.a.b.a(this.AiB, this.hIy);
      }
    }
    do
    {
      pu(false);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().add(this);
      ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().a(this);
      com.tencent.mm.pluginsdk.h.x(this);
      AppMethodBeat.o(107224);
      return;
      paramBundle = FavoriteImageServer.a(this.hIy, this.AiB);
    } while (paramBundle == null);
    int j = paramBundle.getWidth();
    int k = paramBundle.getHeight();
    Object localObject;
    int i;
    label424:
    float f;
    if (!this.AlO)
    {
      this.AlO = true;
      localObject = aw.bf(getContext());
      if (localObject == null) {
        break label479;
      }
      i = ((Point)localObject).x;
      f = getResources().getDimensionPixelOffset(q.c.FavDetailPadding) * 2;
      localObject = this.AlF.getLayoutParams();
      if (localObject != null) {
        break label490;
      }
      Log.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.AlJ.setImageBitmap(paramBundle);
      this.AlJ.setVisibility(0);
      break;
      label479:
      i = com.tencent.mm.cd.a.ms(getContext());
      break label424;
      label490:
      ((ViewGroup.LayoutParams)localObject).width = (i - (int)(f + 0.5F));
      ((ViewGroup.LayoutParams)localObject).height = (((ViewGroup.LayoutParams)localObject).width * k / j);
      this.AlF.setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107225);
    if (this.AlI != null)
    {
      this.AlI.setVideoCallback(null);
      this.AlI.stop();
    }
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().remove(this);
    ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(107225);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107229);
    Log.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.AiB.field_localId) });
    paramString = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavItemInfoStorage().mK(this.AiB.field_localId);
    if (paramString == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107229);
      return;
    }
    this.AiB = paramString;
    this.hIy = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107229);
      return;
      if (this.AkQ)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((ah)com.tencent.mm.kernel.h.az(ah.class)).getFavCdnStorage().aui(this.hIy.hIQ).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.AiB, this.hIy, true);
          this.AkQ = true;
        }
        Log.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.AkQ) });
        bool = this.AkQ;
      }
    }
    MMHandlerThread.removeRunnable(this.AlN);
    MMHandlerThread.postToMainThreadDelayed(this.AlN, 500L);
    AppMethodBeat.o(107229);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107227);
    if (this.AlI != null) {
      this.AlI.stop();
    }
    super.onPause();
    AppMethodBeat.o(107227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107226);
    super.onResume();
    if (this.AlI != null)
    {
      if (this.AlL) {
        break label40;
      }
      dSA();
    }
    for (;;)
    {
      this.AlL = false;
      AppMethodBeat.o(107226);
      return;
      label40:
      if (!this.AlI.isPlaying()) {
        this.AlI.start();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI
 * JD-Core Version:    0.7.0.1
 */