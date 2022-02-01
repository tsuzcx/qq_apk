package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.fav.ui.s.f;
import com.tencent.mm.plugin.fav.ui.s.h;
import com.tencent.mm.plugin.fav.ui.s.i;
import com.tencent.mm.protocal.protobuf.anm;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.q.f;
import com.tencent.mm.ui.base.q.g;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.vfs.u;
import java.util.Iterator;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements MStorage.IOnStorageChange
{
  private com.tencent.mm.plugin.fav.a.o wHQ;
  private g wHw;
  private FavChatVoiceView wPO;
  private long wPi;
  
  public int getLayoutId()
  {
    return s.f.favorite_voice_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107284);
    super.onCreate(paramBundle);
    setMMTitle(getString(s.i.favorite_detail));
    this.wPi = getIntent().getLongExtra("key_detail_info_id", -1L);
    paramBundle = getIntent().getStringExtra("key_detail_data_id");
    this.wHw = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wPi);
    if (this.wHw == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().add(this);
      AppMethodBeat.o(107284);
      return;
      if (!Util.isNullOrNil(paramBundle))
      {
        localObject = this.wHw.field_favProto.syG.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!((anm)((Iterator)localObject).next()).fEa.equals(paramBundle)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      H(this.wHw);
      this.wHQ = new com.tencent.mm.plugin.fav.a.o();
      this.wPO = ((FavChatVoiceView)findViewById(s.e.fav_chatvoice_player));
      this.wPO.setVoiceHelper(this.wHQ);
      a.a(this, this.wHw);
      Object localObject = b.c(this.wHw);
      paramBundle = b.d((anm)localObject);
      int i = b.azO(((anm)localObject).Syc);
      if (!u.agG(paramBundle)) {
        b.m(this.wHw);
      }
      localObject = m.N(this, (int)b.Kc(((anm)localObject).duration)).toString();
      this.wPO.K(paramBundle, i, (String)localObject);
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
      addIconOptionMenu(0, s.i.top_item_desc_more, s.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107283);
          paramAnonymousMenuItem = new e(FavoriteVoiceDetailUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.ODT = new q.f()
          {
            public final void onCreateMMMenu(com.tencent.mm.ui.base.o paramAnonymous2o)
            {
              AppMethodBeat.i(107279);
              paramAnonymous2o.d(0, FavoriteVoiceDetailUI.this.getString(s.i.favorite_edit_tag_tips));
              paramAnonymous2o.mn(2, s.i.favorite_save_as_note);
              paramAnonymous2o.d(1, FavoriteVoiceDetailUI.this.getContext().getString(s.i.app_delete));
              AppMethodBeat.o(107279);
            }
          };
          paramAnonymousMenuItem.ODU = new q.g()
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
                paramAnonymous2MenuItem = FavoriteVoiceDetailUI.this.wNU;
                paramAnonymous2MenuItem.wGx += 1;
                AppMethodBeat.o(107282);
                return;
                com.tencent.mm.ui.base.h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(s.i.app_delete_tips), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(107281);
                    paramAnonymous3DialogInterface = com.tencent.mm.ui.base.h.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(s.i.app_delete_tips), false, null);
                    final long l1 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId;
                    long l2 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_id;
                    b.b(FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId, new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107280);
                        FavoriteVoiceDetailUI.this.wNU.wGy = true;
                        paramAnonymous3DialogInterface.dismiss();
                        Log.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.mhb) });
                        FavoriteVoiceDetailUI.this.finish();
                        AppMethodBeat.o(107280);
                      }
                    });
                    AppMethodBeat.o(107281);
                  }
                }, null);
                AppMethodBeat.o(107282);
                return;
                j.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.b(FavoriteVoiceDetailUI.this), FavoriteVoiceDetailUI.this.wNU);
              }
            }
          };
          paramAnonymousMenuItem.eik();
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
    if (this.wPO != null) {
      this.wPO.stopPlay();
    }
    if (this.wHQ != null) {
      this.wHQ.destroy();
    }
    ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().remove(this);
    AppMethodBeat.o(107285);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107288);
    this.wHw = ((ag)com.tencent.mm.kernel.h.ag(ag.class)).getFavItemInfoStorage().Km(this.wPi);
    if (this.wHw == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
      AppMethodBeat.o(107288);
      return;
    }
    if (this.wHw.field_itemStatus != 10)
    {
      AppMethodBeat.o(107288);
      return;
    }
    if ((paramMStorageEventData == null) || (paramMStorageEventData.stg == null))
    {
      AppMethodBeat.o(107288);
      return;
    }
    if (this.wHw.field_favProto.syG.size() > 0)
    {
      paramMStorageEventData = b.c(this.wHw);
      paramString = b.d(paramMStorageEventData);
      int i = b.azO(paramMStorageEventData.Syc);
      Log.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
      paramMStorageEventData = m.N(this, (int)b.Kc(paramMStorageEventData.duration)).toString();
      this.wPO.K(paramString, i, paramMStorageEventData);
    }
    AppMethodBeat.o(107288);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107287);
    super.onPause();
    this.wHQ.pause();
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