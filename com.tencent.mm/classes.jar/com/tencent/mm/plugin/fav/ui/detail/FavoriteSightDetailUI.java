package com.tencent.mm.plugin.fav.ui.detail;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.d;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.q;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.ajx;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ar;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p, k.a
{
  private ajx dtI;
  private k rFY;
  private com.tencent.mm.plugin.fav.a.g rGj;
  private boolean rIk;
  private boolean rIq;
  private View rJa;
  private ImageView rJb;
  private MMPinProgressBtn rJc;
  private VideoPlayerTextureView rJd;
  private ImageView rJe;
  private long rJf;
  private boolean rJg;
  private boolean rJh;
  private Runnable rJi;
  private boolean rJj;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(107222);
    this.rJg = true;
    this.rIk = false;
    this.rJh = false;
    this.rIq = false;
    this.rFY = new k();
    this.rJi = new Runnable()
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
    this.rJj = false;
    AppMethodBeat.o(107222);
  }
  
  private void cyA()
  {
    AppMethodBeat.i(107232);
    String str = com.tencent.mm.plugin.fav.a.b.d(this.dtI);
    if (!com.tencent.mm.vfs.o.fB(str))
    {
      AppMethodBeat.o(107232);
      return;
    }
    this.rJd.stop();
    this.rJd.setMute(true);
    this.rJd.setVideoPath(str);
    AppMethodBeat.o(107232);
  }
  
  @SuppressLint({"ResourceType"})
  private void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(107228);
    if (this.rGj.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.g(this.dtI))
      {
        this.rJb.setVisibility(8);
        this.rJc.setVisibility(8);
        cyA();
        AppMethodBeat.o(107228);
        return;
      }
      if (bu.isNullOrNil(this.dtI.GzA)) {
        this.rJb.setImageResource(2131691166);
      }
    }
    for (;;)
    {
      this.rJb.setVisibility(0);
      this.rJc.setVisibility(8);
      this.rJe.setVisibility(0);
      AppMethodBeat.o(107228);
      return;
      ae.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.rJb.setImageResource(2131691166);
      continue;
      if (this.rGj.cwv())
      {
        if (bu.isNullOrNil(this.dtI.GzA))
        {
          this.rJb.setImageResource(2131691166);
          if (!paramBoolean) {}
        }
        else
        {
          this.rJb.setImageResource(2131691166);
          if (paramBoolean) {
            com.tencent.mm.ui.base.h.cm(getContext(), getString(2131758104));
          }
        }
      }
      else if (this.rGj.isUploadFailed())
      {
        this.rJb.setImageResource(2131691166);
        if (paramBoolean) {
          com.tencent.mm.ui.base.h.cm(getContext(), getString(2131758844));
        }
      }
      else
      {
        if ((this.rGj.isDownloading()) || (this.rGj.cwu()))
        {
          this.rJb.setVisibility(8);
          this.rJc.setVisibility(0);
          c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua);
          if (localc != null) {
            this.rJc.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.rJe.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
            this.rJc.setProgress(0);
          }
        }
        ae.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.rJb.setImageResource(2131691166);
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107229);
    ae.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.rGj.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(this.rGj.field_localId);
    if (paramString == null)
    {
      ae.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107229);
      return;
    }
    this.rGj = paramString;
    this.dtI = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107229);
      return;
      if (this.rIq)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().ahs(this.dtI.dua).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.rGj, this.dtI, true);
          this.rIq = true;
        }
        ae.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.rIq) });
        bool = this.rIq;
      }
    }
    ar.ay(this.rJi);
    ar.o(this.rJi, 500L);
    AppMethodBeat.o(107229);
  }
  
  protected final MMLoadScrollView cyn()
  {
    AppMethodBeat.i(107223);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131304376);
    AppMethodBeat.o(107223);
    return localMMLoadScrollView;
  }
  
  public final void e(c paramc)
  {
    AppMethodBeat.i(107230);
    if ((paramc == null) || (paramc.field_dataId == null))
    {
      ae.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107230);
      return;
    }
    ae.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.dtI.dua, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
    if (paramc.field_offset > paramc.field_totalLen)
    {
      ae.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
      if (1 != paramc.field_type) {
        break label229;
      }
    }
    label229:
    for (paramc.field_status = 2;; paramc.field_status = 4)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.c(paramc);
      }
      if (paramc.field_dataId.equals(this.dtI.dua))
      {
        final int i = (int)paramc.getProgress();
        this.rJc.post(new Runnable()
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
    return 2131493991;
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
      m.d locald;
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
            this.rDo.dismiss();
            AppMethodBeat.o(107221);
          }
        };
        com.tencent.mm.plugin.fav.ui.l.a(getContext(), str, paramIntent, this.rGj, (Runnable)localObject);
        boolean bool = com.tencent.mm.model.x.wb(str);
        if (!bool) {
          break label159;
        }
        paramIntent = m.c.rBv;
        localObject = this.rGj;
        locald = m.d.rBy;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = r.zC(str);; paramInt1 = 0)
      {
        com.tencent.mm.plugin.fav.a.m.a(paramIntent, (com.tencent.mm.plugin.fav.a.g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131758834));
        AppMethodBeat.o(107231);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = m.c.rBu;
        break label87;
      }
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(107231);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107224);
    com.tencent.mm.pluginsdk.h.q(this);
    super.onCreate(paramBundle);
    this.rJf = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rGj = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(this.rJf);
    if (this.rGj == null)
    {
      ae.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.rJf) });
      finish();
      AppMethodBeat.o(107224);
      return;
    }
    H(this.rGj);
    com.tencent.mm.plugin.fav.a.m.x(this.rGj);
    a.a(this, this.rGj);
    this.dtI = com.tencent.mm.plugin.fav.a.b.c(this.rGj);
    this.rJb = ((ImageView)findViewById(2131305196));
    this.rJc = ((MMPinProgressBtn)findViewById(2131306379));
    this.rJa = findViewById(2131298353);
    this.rJd = ((VideoPlayerTextureView)findViewById(2131306410));
    this.rJe = ((ImageView)findViewById(2131306398));
    this.rJa.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if ((com.tencent.mm.r.a.ch(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.r.a.cj(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107207);
          return;
        }
        ae.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id), Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_itemStatus) });
        if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDone())
        {
          if (com.tencent.mm.plugin.fav.a.b.g(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))
          {
            com.tencent.mm.plugin.fav.a.m.a(m.a.rBh, FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if (bu.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GzA))
          {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          ae.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
          if (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isUploadFailed()) {
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
          if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cwv())
          {
            if (!bu.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GzA)) {
              break;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if ((!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDownloading()) && (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cwu())) {
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
    this.rJd.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
    {
      public final int eU(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        return 0;
      }
      
      public final void eb(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final void onCompletion()
      {
        AppMethodBeat.i(107212);
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).p(0.0D);
        AppMethodBeat.o(107212);
      }
      
      public final void onError(int paramAnonymousInt1, int paramAnonymousInt2)
      {
        AppMethodBeat.i(107211);
        ae.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == -1)
        {
          FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).stop();
          if (com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.fav.a.b.d(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))))
          {
            FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
            AppMethodBeat.o(107211);
            return;
          }
          if (com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.fav.a.b.a(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))) {
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
        ar.f(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(107209);
            com.tencent.mm.ui.base.h.l(FavoriteSightDetailUI.this.getContext(), 2131764680, 2131764690);
            AppMethodBeat.o(107209);
          }
        });
        AppMethodBeat.o(107211);
      }
      
      public final void ta()
      {
        AppMethodBeat.i(107210);
        ae.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).setLoop(true);
        FavoriteSightDetailUI.b(FavoriteSightDetailUI.this, FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).start());
        ar.f(new Runnable()
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
    setMMTitle(getString(2131758856));
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
    addIconOptionMenu(0, 2131764451, 2131690603, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107218);
        paramAnonymousMenuItem = new e(FavoriteSightDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.LfS = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(107214);
            if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cwr()) && (!FavoriteSightDetailUI.j(FavoriteSightDetailUI.this).u(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this)))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) && (FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GAI == 0)) {
                paramAnonymous2l.d(0, FavoriteSightDetailUI.this.getString(2131759001));
              }
              paramAnonymous2l.d(4, FavoriteSightDetailUI.this.getString(2131758988));
              paramAnonymous2l.d(3, FavoriteSightDetailUI.this.getString(2131758875));
              paramAnonymous2l.d(2, FavoriteSightDetailUI.this.getContext().getString(2131755707));
              AppMethodBeat.o(107214);
              return;
            }
          }
        };
        paramAnonymousMenuItem.LfT = new n.e()
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
              com.tencent.mm.plugin.fav.a.h.i(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, 1, 0);
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              d.c(FavoriteSightDetailUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.rHW;
              paramAnonymous2MenuItem.rAM += 1;
              AppMethodBeat.o(107217);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107216);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.b(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(2131755709), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107215);
                      FavoriteSightDetailUI.this.rHW.rAQ = true;
                      paramAnonymous3DialogInterface.dismiss();
                      ae.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id) });
                      FavoriteSightDetailUI.this.finish();
                      AppMethodBeat.o(107215);
                    }
                  });
                  AppMethodBeat.o(107216);
                }
              }, null);
              AppMethodBeat.o(107217);
              return;
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.rHW;
              paramAnonymous2MenuItem.rAP += 1;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(107217);
              return;
              j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.k(FavoriteSightDetailUI.this), FavoriteSightDetailUI.this.rHW);
            }
          }
        };
        paramAnonymousMenuItem.cPF();
        AppMethodBeat.o(107218);
        return true;
      }
    });
    if (!com.tencent.mm.vfs.o.fB(com.tencent.mm.plugin.fav.a.b.a(this.dtI))) {
      if (!bu.isNullOrNil(this.dtI.hCS)) {
        com.tencent.mm.plugin.fav.a.b.a(this.rGj, this.dtI);
      }
    }
    do
    {
      lD(false);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().a(this);
      com.tencent.mm.pluginsdk.h.r(this);
      AppMethodBeat.o(107224);
      return;
      paramBundle = com.tencent.mm.plugin.fav.ui.o.a(this.dtI, this.rGj);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    DisplayMetrics localDisplayMetrics;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.rJj)
    {
      this.rJj = true;
      localDisplayMetrics = this.rJa.getResources().getDisplayMetrics();
      f = localDisplayMetrics.density;
      localLayoutParams = this.rJa.getLayoutParams();
      if (localLayoutParams != null) {
        break label462;
      }
      ae.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.rJe.setImageBitmap(paramBundle);
      this.rJe.setVisibility(0);
      break;
      label462:
      localLayoutParams.width = (localDisplayMetrics.widthPixels - (int)(f * 36.0F + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.rJa.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107225);
    if (this.rJd != null)
    {
      this.rJd.setVideoCallback(null);
      this.rJd.stop();
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(107225);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107227);
    if (this.rJd != null) {
      this.rJd.stop();
    }
    super.onPause();
    AppMethodBeat.o(107227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107226);
    super.onResume();
    if (this.rJd != null)
    {
      if (this.rJg) {
        break label40;
      }
      cyA();
    }
    for (;;)
    {
      this.rJg = false;
      AppMethodBeat.o(107226);
      return;
      label40:
      if (!this.rJd.isPlaying()) {
        this.rJd.start();
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