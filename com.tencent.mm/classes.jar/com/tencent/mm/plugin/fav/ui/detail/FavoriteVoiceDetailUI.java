package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.protocal.protobuf.ajn;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.base.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.i;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements k.a
{
  private long rAU;
  private FavChatVoiceView rBA;
  private com.tencent.mm.plugin.fav.a.g rtA;
  private n rtU;
  
  public final void a(String paramString, com.tencent.mm.sdk.e.m paramm)
  {
    AppMethodBeat.i(107288);
    this.rtA = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rAU);
    if (this.rtA == null)
    {
      ad.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
      AppMethodBeat.o(107288);
      return;
    }
    if (this.rtA.field_itemStatus != 10)
    {
      AppMethodBeat.o(107288);
      return;
    }
    if ((paramm == null) || (paramm.IhM == null))
    {
      AppMethodBeat.o(107288);
      return;
    }
    if (this.rtA.field_favProto.nZa.size() > 0)
    {
      paramm = b.c(this.rtA);
      paramString = b.d(paramm);
      int i = b.agi(paramm.Ghg);
      ad.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
      paramm = com.tencent.mm.plugin.fav.ui.m.G(this, (int)b.vu(paramm.duration)).toString();
      this.rBA.z(paramString, i, paramm);
    }
    AppMethodBeat.o(107288);
  }
  
  public int getLayoutId()
  {
    return 2131493994;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107284);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131758856));
    this.rAU = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.rtA = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(this.rAU);
    if (this.rtA == null)
    {
      ad.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().add(this);
      AppMethodBeat.o(107284);
      return;
      H(this.rtA);
      this.rtU = new n();
      this.rBA = ((FavChatVoiceView)findViewById(2131299769));
      this.rBA.setVoiceHelper(this.rtU);
      a.a(this, this.rtA);
      Object localObject = b.c(this.rtA);
      paramBundle = b.d((ajn)localObject);
      int i = b.agi(((ajn)localObject).Ghg);
      if (!i.fv(paramBundle)) {
        b.m(this.rtA);
      }
      localObject = com.tencent.mm.plugin.fav.ui.m.G(this, (int)b.vu(((ajn)localObject).duration)).toString();
      this.rBA.z(paramBundle, i, (String)localObject);
      setBackBtn(new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107278);
          FavoriteVoiceDetailUI.this.finish();
          AppMethodBeat.o(107278);
          return true;
        }
      });
      addIconOptionMenu(0, 2131764451, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107283);
          paramAnonymousMenuItem = new e(FavoriteVoiceDetailUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.KJy = new n.d()
          {
            public final void onCreateMMMenu(l paramAnonymous2l)
            {
              AppMethodBeat.i(107279);
              paramAnonymous2l.c(0, FavoriteVoiceDetailUI.this.getString(2131758875));
              paramAnonymous2l.jI(2, 2131758988);
              paramAnonymous2l.c(1, FavoriteVoiceDetailUI.this.getContext().getString(2131755707));
              AppMethodBeat.o(107279);
            }
          };
          paramAnonymousMenuItem.KJz = new n.e()
          {
            public final void onMMMenuItemSelected(MenuItem paramAnonymous2MenuItem, int paramAnonymous2Int)
            {
              AppMethodBeat.i(107282);
              switch (paramAnonymous2MenuItem.getItemId())
              {
              }
              for (;;)
              {
                AppMethodBeat.o(107282);
                return;
                paramAnonymous2MenuItem = new Intent();
                paramAnonymous2MenuItem.putExtra("key_fav_scene", 2);
                paramAnonymous2MenuItem.putExtra("key_fav_item_id", FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId);
                b.b(FavoriteVoiceDetailUI.this.getContext(), ".ui.FavTagEditUI", paramAnonymous2MenuItem);
                paramAnonymous2MenuItem = FavoriteVoiceDetailUI.this.rzL;
                paramAnonymous2MenuItem.rsC += 1;
                AppMethodBeat.o(107282);
                return;
                h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(2131755709), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(107281);
                    paramAnonymous3DialogInterface = h.b(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(2131755709), false, null);
                    final long l1 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId;
                    long l2 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_id;
                    b.b(FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId, new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107280);
                        FavoriteVoiceDetailUI.this.rzL.rsD = true;
                        paramAnonymous3DialogInterface.dismiss();
                        ad.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.rBF) });
                        FavoriteVoiceDetailUI.this.finish();
                        AppMethodBeat.o(107280);
                      }
                    });
                    AppMethodBeat.o(107281);
                  }
                }, null);
                AppMethodBeat.o(107282);
                return;
                j.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.b(FavoriteVoiceDetailUI.this), FavoriteVoiceDetailUI.this.rzL);
              }
            }
          };
          paramAnonymousMenuItem.cMW();
          AppMethodBeat.o(107283);
          return true;
        }
      });
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(107285);
    super.onDestroy();
    if (this.rBA != null) {
      this.rBA.stopPlay();
    }
    if (this.rtU != null) {
      this.rtU.destroy();
    }
    ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().remove(this);
    AppMethodBeat.o(107285);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107287);
    super.onPause();
    this.rtU.pause();
    AppMethodBeat.o(107287);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(107286);
    super.onResume();
    AppMethodBeat.o(107286);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI
 * JD-Core Version:    0.7.0.1
 */