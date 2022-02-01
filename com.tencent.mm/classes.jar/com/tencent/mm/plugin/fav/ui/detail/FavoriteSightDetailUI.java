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
import com.tencent.mm.model.ab;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.m.a;
import com.tencent.mm.plugin.fav.a.m.c;
import com.tencent.mm.plugin.fav.a.m.d;
import com.tencent.mm.plugin.fav.a.p;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.pluginsdk.ui.tools.VideoPlayerTextureView;
import com.tencent.mm.pluginsdk.ui.tools.j.a;
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.widget.MMLoadScrollView;
import com.tencent.mm.ui.widget.MMPinProgressBtn;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;

public class FavoriteSightDetailUI
  extends BaseFavDetailReportUI
  implements p, MStorage.IOnStorageChange
{
  private aml dKT;
  private k tfE;
  private com.tencent.mm.plugin.fav.a.g tfP;
  private boolean thR;
  private boolean thX;
  private View tiM;
  private ImageView tiN;
  private MMPinProgressBtn tiO;
  private VideoPlayerTextureView tiP;
  private ImageView tiQ;
  private long tiR;
  private boolean tiS;
  private boolean tiT;
  private Runnable tiU;
  private boolean tiV;
  
  public FavoriteSightDetailUI()
  {
    AppMethodBeat.i(107222);
    this.tiS = true;
    this.thR = false;
    this.tiT = false;
    this.thX = false;
    this.tfE = new k();
    this.tiU = new Runnable()
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
    this.tiV = false;
    AppMethodBeat.o(107222);
  }
  
  private void cWD()
  {
    AppMethodBeat.i(107232);
    String str = com.tencent.mm.plugin.fav.a.b.d(this.dKT);
    if (!s.YS(str))
    {
      AppMethodBeat.o(107232);
      return;
    }
    this.tiP.stop();
    this.tiP.setMute(true);
    this.tiP.setVideoPath(str);
    AppMethodBeat.o(107232);
  }
  
  @SuppressLint({"ResourceType"})
  private void mG(boolean paramBoolean)
  {
    AppMethodBeat.i(107228);
    if (this.tfP.isDone())
    {
      if (com.tencent.mm.plugin.fav.a.b.g(this.dKT))
      {
        this.tiN.setVisibility(8);
        this.tiO.setVisibility(8);
        cWD();
        AppMethodBeat.o(107228);
        return;
      }
      if (Util.isNullOrNil(this.dKT.KuR)) {
        this.tiN.setImageResource(2131691480);
      }
    }
    for (;;)
    {
      this.tiN.setVisibility(0);
      this.tiO.setVisibility(8);
      this.tiQ.setVisibility(0);
      AppMethodBeat.o(107228);
      return;
      Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
      this.tiN.setImageResource(2131691480);
      continue;
      if (this.tfP.cUz())
      {
        if (Util.isNullOrNil(this.dKT.KuR))
        {
          this.tiN.setImageResource(2131691480);
          if (!paramBoolean) {}
        }
        else
        {
          this.tiN.setImageResource(2131691480);
          if (paramBoolean) {
            com.tencent.mm.ui.base.h.cD(getContext(), getString(2131758370));
          }
        }
      }
      else if (this.tfP.cUy())
      {
        this.tiN.setImageResource(2131691480);
        if (paramBoolean) {
          com.tencent.mm.ui.base.h.cD(getContext(), getString(2131759167));
        }
      }
      else
      {
        if ((this.tfP.isDownloading()) || (this.tfP.cUx()))
        {
          this.tiN.setVisibility(8);
          this.tiO.setVisibility(0);
          com.tencent.mm.plugin.fav.a.c localc = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
          if (localc != null) {
            this.tiO.setProgress((int)localc.getProgress());
          }
          for (;;)
          {
            this.tiQ.setVisibility(0);
            AppMethodBeat.o(107228);
            return;
            this.tiO.setProgress(0);
          }
        }
        Log.w("MicroMsg.FavoriteSightDetailUI", "other status, not done, downloading, uploading, downloadfail, uploadfail");
        this.tiN.setImageResource(2131691480);
      }
    }
  }
  
  protected final MMLoadScrollView cWr()
  {
    AppMethodBeat.i(107223);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131307339);
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
    Log.i("MicroMsg.FavoriteSightDetailUI", "on cdn status changed, dataID is %s, field id is %s,offset is %d, total is %d,cdn status is %d, cdn type is %d (send or recieve)", new Object[] { this.dKT.dLl, paramc.field_dataId, Integer.valueOf(paramc.field_offset), Integer.valueOf(paramc.field_totalLen), Integer.valueOf(paramc.field_status), Integer.valueOf(paramc.field_type) });
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
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(paramc, new String[0]);
      if (paramc.field_type == 0) {
        com.tencent.mm.plugin.fav.a.b.b(paramc);
      }
      if (paramc.field_type == 1) {
        com.tencent.mm.plugin.fav.a.b.c(paramc);
      }
      if (paramc.field_dataId.equals(this.dKT.dLl))
      {
        final int i = (int)paramc.getProgress();
        this.tiO.post(new Runnable()
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
    return 2131494161;
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
            this.tcT.dismiss();
            AppMethodBeat.o(107221);
          }
        };
        l.a(getContext(), str, paramIntent, this.tfP, (Runnable)localObject);
        boolean bool = ab.Eq(str);
        if (!bool) {
          break label159;
        }
        paramIntent = m.c.tba;
        localObject = this.tfP;
        locald = m.d.tbd;
        if (!bool) {
          break label166;
        }
      }
      label148:
      label159:
      label166:
      for (paramInt1 = v.Ie(str);; paramInt1 = 0)
      {
        com.tencent.mm.plugin.fav.a.m.a(paramIntent, (com.tencent.mm.plugin.fav.a.g)localObject, locald, paramInt1);
        com.tencent.mm.ui.widget.snackbar.b.r(this, getString(2131759157));
        AppMethodBeat.o(107231);
        return;
        str = paramIntent.getStringExtra("Select_Conv_User");
        break;
        paramIntent = paramIntent.getStringExtra("custom_send_text");
        break label29;
        paramIntent = m.c.taZ;
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
    this.tiR = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.tfP = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
    if (this.tfP == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.tiR) });
      finish();
      AppMethodBeat.o(107224);
      return;
    }
    H(this.tfP);
    com.tencent.mm.plugin.fav.a.m.x(this.tfP);
    a.a(this, this.tfP);
    this.dKT = com.tencent.mm.plugin.fav.a.b.c(this.tfP);
    this.tiN = ((ImageView)findViewById(2131308392));
    this.tiO = ((MMPinProgressBtn)findViewById(2131309808));
    this.tiM = findViewById(2131298752);
    this.tiP = ((VideoPlayerTextureView)findViewById(2131309841));
    this.tiQ = ((ImageView)findViewById(2131309829));
    this.tiM.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107207);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if ((com.tencent.mm.q.a.cC(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cA(paramAnonymousView.getContext())) || (com.tencent.mm.q.a.cE(paramAnonymousView.getContext())))
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
            com.tencent.mm.plugin.fav.a.m.a(m.a.taM, FavoriteSightDetailUI.a(FavoriteSightDetailUI.this));
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, true, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if (Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).KuR))
          {
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          Log.w("MicroMsg.FavoriteSightDetailUI", "? info is done, source file not exist, cdn data url is not null");
          if (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cUy()) {
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
          if (FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cUz())
          {
            if (!Util.isNullOrNil(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).KuR)) {
              break;
            }
            FavoriteSightDetailUI.a(FavoriteSightDetailUI.this, false, paramAnonymousView.getContext());
            com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/fav/ui/detail/FavoriteSightDetailUI$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
            AppMethodBeat.o(107207);
            return;
          }
          if ((!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).isDownloading()) && (!FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cUx())) {
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
    this.tiP.setVideoCallback(new j.a()
    {
      public final void eo(int paramAnonymousInt1, int paramAnonymousInt2) {}
      
      public final int fh(int paramAnonymousInt1, int paramAnonymousInt2)
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
          if (s.YS(com.tencent.mm.plugin.fav.a.b.d(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this))))
          {
            FavoriteSightDetailUI.f(FavoriteSightDetailUI.this);
            AppMethodBeat.o(107211);
            return;
          }
          if (s.YS(com.tencent.mm.plugin.fav.a.b.a(FavoriteSightDetailUI.b(FavoriteSightDetailUI.this)))) {
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
            com.tencent.mm.ui.base.h.n(FavoriteSightDetailUI.this.getContext(), 2131767073, 2131767097);
            AppMethodBeat.o(107209);
          }
        });
        AppMethodBeat.o(107211);
      }
      
      public final void tf()
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
    setMMTitle(getString(2131759179));
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
    addIconOptionMenu(0, 2131766795, 2131690843, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(107218);
        paramAnonymousMenuItem = new e(FavoriteSightDetailUI.this.getContext(), 1, false);
        paramAnonymousMenuItem.HLX = new o.f()
        {
          public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
          {
            AppMethodBeat.i(107214);
            if ((FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).cUu()) && (!FavoriteSightDetailUI.j(FavoriteSightDetailUI.this).u(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this)))) {}
            for (int i = 1;; i = 0)
            {
              if ((i != 0) && (FavoriteSightDetailUI.b(FavoriteSightDetailUI.this).Lwv == 0)) {
                paramAnonymous2m.d(0, FavoriteSightDetailUI.this.getString(2131759326));
              }
              paramAnonymous2m.d(4, FavoriteSightDetailUI.this.getString(2131759313));
              paramAnonymous2m.d(3, FavoriteSightDetailUI.this.getString(2131759199));
              paramAnonymous2m.d(2, FavoriteSightDetailUI.this.getContext().getString(2131755778));
              AppMethodBeat.o(107214);
              return;
            }
          }
        };
        paramAnonymousMenuItem.HLY = new o.g()
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
              com.tencent.mm.plugin.fav.a.h.w(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, 1);
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("Select_Conv_Type", 3);
              paramAnonymous2MenuItem.putExtra("scene_from", 1);
              paramAnonymous2MenuItem.putExtra("mutil_select_is_ret", true);
              paramAnonymous2MenuItem.putExtra("select_fav_local_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.br.c.c(FavoriteSightDetailUI.this.getContext(), ".ui.transmit.SelectConversationUI", paramAnonymous2MenuItem, 1);
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.thD;
              paramAnonymous2MenuItem.tar += 1;
              AppMethodBeat.o(107217);
              return;
              com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
              {
                public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                {
                  AppMethodBeat.i(107216);
                  paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteSightDetailUI.this.getContext(), FavoriteSightDetailUI.this.getString(2131755780), false, null);
                  com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId, new Runnable()
                  {
                    public final void run()
                    {
                      AppMethodBeat.i(107215);
                      FavoriteSightDetailUI.this.thD.tav = true;
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
              paramAnonymous2MenuItem = FavoriteSightDetailUI.this.thD;
              paramAnonymous2MenuItem.tau += 1;
              paramAnonymous2MenuItem = new Intent();
              paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
              paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteSightDetailUI.a(FavoriteSightDetailUI.this).field_localId);
              com.tencent.mm.plugin.fav.a.b.b(FavoriteSightDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
              AppMethodBeat.o(107217);
              return;
              j.a(FavoriteSightDetailUI.this, FavoriteSightDetailUI.k(FavoriteSightDetailUI.this), FavoriteSightDetailUI.this.thD);
            }
          }
        };
        paramAnonymousMenuItem.dGm();
        AppMethodBeat.o(107218);
        return true;
      }
    });
    if (!s.YS(com.tencent.mm.plugin.fav.a.b.a(this.dKT))) {
      if (!Util.isNullOrNil(this.dKT.iwX)) {
        com.tencent.mm.plugin.fav.a.b.a(this.tfP, this.dKT);
      }
    }
    do
    {
      mG(false);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().a(this);
      com.tencent.mm.pluginsdk.h.r(this);
      AppMethodBeat.o(107224);
      return;
      paramBundle = o.a(this.dKT, this.tfP);
    } while (paramBundle == null);
    int i = paramBundle.getWidth();
    int j = paramBundle.getHeight();
    DisplayMetrics localDisplayMetrics;
    float f;
    ViewGroup.LayoutParams localLayoutParams;
    if (!this.tiV)
    {
      this.tiV = true;
      localDisplayMetrics = this.tiM.getResources().getDisplayMetrics();
      f = localDisplayMetrics.density;
      localLayoutParams = this.tiM.getLayoutParams();
      if (localLayoutParams != null) {
        break label462;
      }
      Log.e("MicroMsg.FavoriteSightDetailUI", "setViewResize, but params is null");
    }
    for (;;)
    {
      this.tiQ.setImageBitmap(paramBundle);
      this.tiQ.setVisibility(0);
      break;
      label462:
      localLayoutParams.width = (localDisplayMetrics.widthPixels - (int)(f * 36.0F + 0.5F));
      localLayoutParams.height = (j * localLayoutParams.width / i);
      this.tiM.setLayoutParams(localLayoutParams);
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107225);
    if (this.tiP != null)
    {
      this.tiP.setVideoCallback(null);
      this.tiP.stop();
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().b(this);
    super.onDestroy();
    AppMethodBeat.o(107225);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107229);
    Log.i("MicroMsg.FavoriteSightDetailUI", "on favitem change, notifyId:%s, curId:%d", new Object[] { paramString, Long.valueOf(this.tfP.field_localId) });
    paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tfP.field_localId);
    if (paramString == null)
    {
      Log.w("MicroMsg.FavoriteSightDetailUI", "error, on notify change, cannot find info");
      finish();
      AppMethodBeat.o(107229);
      return;
    }
    this.tfP = paramString;
    this.dKT = com.tencent.mm.plugin.fav.a.b.c(paramString);
    paramString = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl);
    boolean bool;
    if (paramString == null) {
      bool = false;
    }
    while (bool)
    {
      AppMethodBeat.o(107229);
      return;
      if (this.thX)
      {
        bool = false;
      }
      else
      {
        if ((paramString.field_status == 4) && (((af)com.tencent.mm.kernel.g.ah(af.class)).getFavCdnStorage().asa(this.dKT.dLl).field_extFlag != 0))
        {
          com.tencent.mm.plugin.fav.a.b.a(this.tfP, this.dKT, true);
          this.thX = true;
        }
        Log.i("MicroMsg.FavoriteSightDetailUI", "FavoriteFileDetail download, check retry, return %B", new Object[] { Boolean.valueOf(this.thX) });
        bool = this.thX;
      }
    }
    MMHandlerThread.removeRunnable(this.tiU);
    MMHandlerThread.postToMainThreadDelayed(this.tiU, 500L);
    AppMethodBeat.o(107229);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107227);
    if (this.tiP != null) {
      this.tiP.stop();
    }
    super.onPause();
    AppMethodBeat.o(107227);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107226);
    super.onResume();
    if (this.tiP != null)
    {
      if (this.tiS) {
        break label40;
      }
      cWD();
    }
    for (;;)
    {
      this.tiS = false;
      AppMethodBeat.o(107226);
      return;
      label40:
      if (!this.tiP.isPlaying()) {
        this.tiP.start();
      }
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteSightDetailUI
 * JD-Core Version:    0.7.0.1
 */