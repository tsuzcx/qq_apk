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
import com.tencent.mm.bs.d;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.c;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.i;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements com.tencent.mm.plugin.fav.a.p, k.a
{
  private ajn dsC;
  private View rAP;
  private ImageView rAQ;
  private MMPinProgressBtn rAR;
  private VideoPlayerTextureView rAS;
  private ImageView rAT;
  private long rAU;
  private boolean rAV;
  private boolean rAW;
  private Runnable rAX;
  private boolean rAY;
  private boolean rAf;
  private k rxN;
  private com.tencent.mm.plugin.fav.a.g rxY;
  private boolean rzZ;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(107222);
    this.rAV = true;
    this.rzZ = false;
    this.rAW = false;
    this.rAf = false;
    this.rxN = new k();
    this.rAX = new Runnable()
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
    this.rAY = false;
    AppMethodBeat.o(107222);
  }
  
  private void cwZ()
  {
    AppMethodBeat.i(107232);
    String str = com.tencent.mm.plugin.fav.a.b.d(this.dsC);
    if (!i.fv(str))
    {
      AppMethodBeat.o(107232);
      return;
    }
    this.rAS.stop();
    this.rAS.setMute(true);
    this.rAS.setVideoPath(str);
    AppMethodBeat.o(107232);
  }
  
  @SuppressLint({"ResourceType"})
  private void lD(boolean paramBoolean)
  {
    AppMethodBeat.i(107228);
    if (this.rxY.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.g(this.dsC))
      {
        this.rAQ.setVisibility(8);
        this.rAR.setVisibility(8);
        cwZ();
        AppMethodBeat.o(107228);
        return;
      }
      if (bt.isNullOrNil(this.dsC.GgR)) {
        this.rAQ.setImageResource(2131691166);
      }
    }
    for (;;)
    {
      this.rAQ.setVisibility(0);
      this.rAR.setVisibility(8);
      this.rAT.setVisibility(0);
      AppMethodBeat.o(107228);
      return;
      ad.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.rAQ.setImageResource(2131691166);
      continue;
      if (this.rxY.cuU())
      {
        if (bt.isNullOrNil(this.dsC.GgR))
        {
          this.rAQ.setImageResource(2131691166);
          if (!paramBoolean) {}
        }
        else
        {
          this.rAQ.setImageResource(2131691166);
          if (paramBoolean) {
            com.tencent.mm.ui.base.h.cl(getContext(), getString(2131758104));
          }
        }
      }
      else if (this.rxY.isUploadFailed())
      {
        this.rAQ.setImageResource(2131691166);
        if (paramBoolean) {
          com.tencent.mm.ui.base.h.cl(getContext(), getString(2131758844));
        }
      }
      else
      {
        if ((this.rxY.isDownloading()) || (this.rxY.cuT()))
        {
          this.rAQ.setVisibility(8);
          this.rAR.setVisibility(0);
          c localc = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU);
          if (localc != null) {
            this.rAR.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.rAT.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
            this.rAR.setProgress(0);
          }
        }
        ad.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.rAQ.setImageResource(2131691166);
      }
    }
  }
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107229);
    ad.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.rxY.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rxY.field_localId);
    if (paramString == null)
    {
      ad.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107229);
      return;
    }
    this.rxY = paramString;
    this.dsC = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107229);
      return;
      if (this.rAf)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().agv(this.dsC.dsU).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.rxY, this.dsC, true);
          this.rAf = true;
        }
        ad.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.rAf) });
        bool = this.rAf;
      }
    }
    aq.aA(this.rAX);
    aq.o(this.rAX, 500L);
    AppMethodBeat.o(107229);
  }
  
  protected final MMLoadScrollView cwM()
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
      ad.w("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, item is null");
      AppMethodBeat.o(107230);
      return;
    }
    ad.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.dsC.dsU, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
    if (paramc.field_offset > paramc.field_totalLen)
    {
      ad.e("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, cdn offset length > cdn total length, do cdnLengthError()");
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
      if (paramc.field_dataId.equals(this.dsC.dsU))
      {
        final int i = (int)paramc.getProgress();
        this.rAR.post(new Runnable()
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
            this.rvc.dismiss();
            AppMethodBeat.o(107221);
          }
        };
        com.tencent.mm.plugin.fav.ui.l.a(getContext(), str, paramIntent, this.rxY, (Runnable)localObject);
        boolean bool = w.vF(str);
        if (!bool) {
          break label159;
        }
        paramIntent = m.c.rti;
        localObject = this.rxY;
        locald = m.d.rtl;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = com.tencent.mm.model.q.yS(str);; paramInt1 = 0)
      {
        com.tencent.mm.plugin.fav.a.m.a(paramIntent, (com.tencent.mm.plugin.fav.a.g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.n(this, getString(2131758834));
        AppMethodBeat.o(107231);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = m.c.rth;
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
    this.rAU = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rxY = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rAU);
    if (this.rxY == null)
    {
      ad.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.rAU) });
      finish();
      AppMethodBeat.o(107224);
      return;
    }
    H(this.rxY);
    com.tencent.mm.plugin.fav.a.m.x(this.rxY);
    a.a(this, this.rxY);
    this.dsC = com.tencent.mm.plugin.fav.a.b.c(this.rxY);
    this.rAQ = ((ImageView)findViewById(2131305196));
    this.rAR = ((MMPinProgressBtn)findViewById(2131306379));
    this.rAP = findViewById(2131298353);
    this.rAS = ((VideoPlayerTextureView)findViewById(2131306410));
    this.rAT = ((ImageView)findViewById(2131306398));
    this.rAP.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if ((com.tencent.mm.s.a.cf(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.cd(paramAnonymousView.getContext())) || (com.tencent.mm.s.a.ch(paramAnonymousView.getContext())))
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(107207);
          return;
        }
        ad.i("MicroMsg.FavoriteSightDetailUI", "click item favid %d, localid %d, itemstatus %d", new Object[] { Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id), Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_itemStatus) });
        if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDone())
        {
          if (com.tencent.mm.plugin.fav.a.b.g(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))
          {
            com.tencent.mm.plugin.fav.a.m.a(m.a.rsU, FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if (bt.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GgR))
          {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          ad.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
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
          if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cuU())
          {
            if (!bt.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GgR)) {
              break;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if ((!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDownloading()) && (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cuT())) {
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
    this.rAS.setVideoCallback(new com.tencent.mm.pluginsdk.ui.tools.h.a()
    {
      public final int eT(int paramAnonymousInt1, int paramAnonymousInt2)
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
        ad.e("MicroMsg.FavoriteSightDetailUI", "VideoPlay: on play video error what %d extra %d.", new Object[] { Integer.valueOf(paramAnonymousInt1), Integer.valueOf(paramAnonymousInt2) });
        if (paramAnonymousInt1 == -1)
        {
          FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).stop();
          if (i.fv(com.tencent.mm.plugin.fav.a.b.d(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))))
          {
            FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
            AppMethodBeat.o(107211);
            return;
          }
          if (i.fv(com.tencent.mm.plugin.fav.a.b.a(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))) {
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
        aq.f(new Runnable()
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
        ad.i("MicroMsg.FavoriteSightDetailUI", " onPrepared");
        FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).setLoop(true);
        FavoriteSightDetailUI.b(FavoriteSightDetailUI.this, FavoriteSightDetailUI.d(FavoriteSightDetailUI.this).start());
        aq.f(new Runnable()
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
        paramAnonymousMenuItem.KJy = new n.d()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.l paramAnonymous2l)
          {
            AppMethodBeat.i(107214);
            if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cuQ()) && (!FavoriteSightDetailUI.j(FavoriteSightDetailUI.this).u(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this)))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) && (FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).GhZ == 0)) {
                paramAnonymous2l.c(0, FavoriteSightDetailUI.this.getString(2131759001));
              }
              paramAnonymous2l.c(4, FavoriteSightDetailUI.this.getString(2131758988));
              paramAnonymous2l.c(3, FavoriteSightDetailUI.this.getString(2131758875));
              paramAnonymous2l.c(2, FavoriteSightDetailUI.this.getContext().getString(2131755707));
              AppMethodBeat.o(107214);
              return;
            }
          }
        };
        paramAnonymousMenuItem.KJz = new n.e()
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
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.rzL;
              paramAnonymous2MenuItem.rsz += 1;
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
                      FavoriteSightDetailUI.this.rzL.rsD = true;
                      paramAnonymous3DialogInterface.dismiss();
                      ad.i("MicroMsg.FavoriteSightDetailUI", "do del fav file, local id %d, fav id %d", new Object[] { Long.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId), Integer.valueOf(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_id) });
                      FavoriteSightDetailUI.this.finish();
                      AppMethodBeat.o(107215);
                    }
                  });
                  AppMethodBeat.o(107216);
                }
              }, null);
              AppMethodBeat.o(107217);
              return;
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.rzL;
              paramAnonymous2MenuItem.rsC += 1;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(107217);
              return;
              j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.k(FavoriteSightDetailUI.this), FavoriteSightDetailUI.this.rzL);
            }
          }
        };
        paramAnonymousMenuItem.cMW();
        AppMethodBeat.o(107218);
        return true;
      }
    });
    if (!i.fv(com.tencent.mm.plugin.fav.a.b.a(this.dsC))) {
      if (!bt.isNullOrNil(this.dsC.hAe)) {
        com.tencent.mm.plugin.fav.a.b.a(this.rxY, this.dsC);
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
      paramBundle = o.a(this.dsC, this.rxY);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    DisplayMetrics localDisplayMetrics;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.rAY)
    {
      this.rAY = true;
      localDisplayMetrics = this.rAP.getResources().getDisplayMetrics();
      f = localDisplayMetrics.density;
      localLayoutParams = this.rAP.getLayoutParams();
      if (localLayoutParams != null) {
        break label462;
      }
      ad.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.rAT.setImageBitmap(paramBundle);
      this.rAT.setVisibility(0);
      break;
      label462:
      localLayoutParams.width = (localDisplayMetrics.widthPixels - (int)(f * 36.0F + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.rAP.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107225);
    if (this.rAS != null)
    {
      this.rAS.setVideoCallback(null);
      this.rAS.stop();
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this);
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(107225);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107227);
    if (this.rAS != null) {
      this.rAS.stop();
    }
    super.onPause();
    AppMethodBeat.o(107227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107226);
    super.onResume();
    if (this.rAS != null)
    {
      if (this.rAV) {
        break label40;
      }
      cwZ();
    }
    for (;;)
    {
      this.rAV = false;
      AppMethodBeat.o(107226);
      return;
      label40:
      if (!this.rAS.isPlaying()) {
        this.rAS.start();
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