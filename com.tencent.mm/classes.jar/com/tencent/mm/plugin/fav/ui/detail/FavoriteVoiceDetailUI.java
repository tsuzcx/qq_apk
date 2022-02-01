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
import com.tencent.mm.protocal.protobuf.aml;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.base.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.s;
import java.util.Iterator;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements MStorage.IOnStorageChange
{
  private n tbL;
  private com.tencent.mm.plugin.fav.a.g tbr;
  private long tiR;
  private FavChatVoiceView tjx;
  
  public int getLayoutId()
  {
    return 2131494164;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107284);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131759179));
    this.tiR = getIntent().getLongExtra("key_detail_info_id", -1L);
    paramBundle = getIntent().getStringExtra("key_detail_data_id");
    this.tbr = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
    if (this.tbr == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().add(this);
      AppMethodBeat.o(107284);
      return;
      if (!Util.isNullOrNil(paramBundle))
      {
        localObject = this.tbr.field_favProto.ppH.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!((aml)((Iterator)localObject).next()).dLl.equals(paramBundle)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      H(this.tbr);
      this.tbL = new n();
      this.tjx = ((FavChatVoiceView)findViewById(2131300440));
      this.tjx.setVoiceHelper(this.tbL);
      a.a(this, this.tbr);
      Object localObject = b.c(this.tbr);
      paramBundle = b.d((aml)localObject);
      int i = b.arN(((aml)localObject).LvC);
      if (!s.YS(paramBundle)) {
        b.m(this.tbr);
      }
      localObject = com.tencent.mm.plugin.fav.ui.m.J(this, (int)b.DO(((aml)localObject).duration)).toString();
      this.tjx.I(paramBundle, i, (String)localObject);
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
      addIconOptionMenu(0, 2131766795, 2131690843, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107283);
          paramAnonymousMenuItem = new e(FavoriteVoiceDetailUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.HLX = new o.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.m paramAnonymous2m)
            {
              AppMethodBeat.i(107279);
              paramAnonymous2m.d(0, FavoriteVoiceDetailUI.this.getString(2131759199));
              paramAnonymous2m.kV(2, 2131759313);
              paramAnonymous2m.d(1, FavoriteVoiceDetailUI.this.getContext().getString(2131755778));
              AppMethodBeat.o(107279);
            }
          };
          paramAnonymousMenuItem.HLY = new o.g()
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
                paramAnonymous2MenuItem = FavoriteVoiceDetailUI.this.thD;
                paramAnonymous2MenuItem.tau += 1;
                AppMethodBeat.o(107282);
                return;
                h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(2131755780), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(107281);
                    paramAnonymous3DialogInterface = h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(2131755780), false, null);
                    final long l1 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId;
                    long l2 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_id;
                    b.b(FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId, new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107280);
                        FavoriteVoiceDetailUI.this.thD.tav = true;
                        paramAnonymous3DialogInterface.dismiss();
                        Log.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.jry) });
                        FavoriteVoiceDetailUI.this.finish();
                        AppMethodBeat.o(107280);
                      }
                    });
                    AppMethodBeat.o(107281);
                  }
                }, null);
                AppMethodBeat.o(107282);
                return;
                j.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.b(FavoriteVoiceDetailUI.this), FavoriteVoiceDetailUI.this.thD);
              }
            }
          };
          paramAnonymousMenuItem.dGm();
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
    if (this.tjx != null) {
      this.tjx.stopPlay();
    }
    if (this.tbL != null) {
      this.tbL.destroy();
    }
    ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().remove(this);
    AppMethodBeat.o(107285);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107288);
    this.tbr = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(this.tiR);
    if (this.tbr == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
      AppMethodBeat.o(107288);
      return;
    }
    if (this.tbr.field_itemStatus != 10)
    {
      AppMethodBeat.o(107288);
      return;
    }
    if ((paramMStorageEventData == null) || (paramMStorageEventData.stg == null))
    {
      AppMethodBeat.o(107288);
      return;
    }
    if (this.tbr.field_favProto.ppH.size() > 0)
    {
      paramMStorageEventData = b.c(this.tbr);
      paramString = b.d(paramMStorageEventData);
      int i = b.arN(paramMStorageEventData.LvC);
      Log.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
      paramMStorageEventData = com.tencent.mm.plugin.fav.ui.m.J(this, (int)b.DO(paramMStorageEventData.duration)).toString();
      this.tjx.I(paramString, i, paramMStorageEventData);
    }
    AppMethodBeat.o(107288);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107287);
    super.onPause();
    this.tbL.pause();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI
 * JD-Core Version:    0.7.0.1
 */