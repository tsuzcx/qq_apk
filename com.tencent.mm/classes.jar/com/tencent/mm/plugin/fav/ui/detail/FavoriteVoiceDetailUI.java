package com.tencent.mm.plugin.fav.ui.detail;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.h.a;
import com.tencent.mm.plugin.fav.a.o;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.f;
import com.tencent.mm.plugin.fav.ui.q.h;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorage.IOnStorageChange;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.a.f;
import java.util.Iterator;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements MStorage.IOnStorageChange
{
  private g AdF;
  private o Aee;
  private long AlK;
  private FavChatVoiceView Amq;
  
  public int getLayoutId()
  {
    return q.f.favorite_voice_detail_ui;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(107284);
    super.onCreate(paramBundle);
    setMMTitle(getString(q.i.favorite_detail));
    this.AlK = getIntent().getLongExtra("key_detail_info_id", -1L);
    paramBundle = getIntent().getStringExtra("key_detail_data_id");
    this.AdF = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(this.AlK);
    if (this.AdF == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((ah)h.az(ah.class)).getFavItemInfoStorage().add(this);
      AppMethodBeat.o(107284);
      return;
      if (!Util.isNullOrNil(paramBundle))
      {
        localObject = this.AdF.field_favProto.vEn.iterator();
        while (((Iterator)localObject).hasNext()) {
          if (!((arf)((Iterator)localObject).next()).hIQ.equals(paramBundle)) {
            ((Iterator)localObject).remove();
          }
        }
      }
      H(this.AdF);
      this.Aee = new o();
      this.Amq = ((FavChatVoiceView)findViewById(q.e.fav_chatvoice_player));
      this.Amq.setVoiceHelper(this.Aee);
      a.a(this, this.AdF);
      Object localObject = b.c(this.AdF);
      paramBundle = b.d((arf)localObject);
      int i = b.atU(((arf)localObject).ZyU);
      if (!com.tencent.mm.vfs.y.ZC(paramBundle)) {
        b.m(this.AdF);
      }
      localObject = m.Q(this, (int)b.mA(((arf)localObject).duration)).toString();
      this.Amq.M(paramBundle, i, (String)localObject);
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
      addIconOptionMenu(0, q.i.top_item_desc_more, q.h.icons_outlined_more, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(107283);
          paramAnonymousMenuItem = new f(FavoriteVoiceDetailUI.this.getContext(), 1, false);
          paramAnonymousMenuItem.Vtg = new u.g()
          {
            public final void onCreateMMMenu(s paramAnonymous2s)
            {
              AppMethodBeat.i(107279);
              paramAnonymous2s.c(0, FavoriteVoiceDetailUI.this.getString(q.i.favorite_edit_tag_tips));
              paramAnonymous2s.oh(2, q.i.favorite_save_as_note);
              paramAnonymous2s.c(1, FavoriteVoiceDetailUI.this.getContext().getString(q.i.app_delete));
              AppMethodBeat.o(107279);
            }
          };
          paramAnonymousMenuItem.GAC = new u.i()
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
                paramAnonymous2MenuItem = FavoriteVoiceDetailUI.this.Akw;
                paramAnonymous2MenuItem.AcG += 1;
                AppMethodBeat.o(107282);
                return;
                k.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(q.i.app_delete_tips), "", new DialogInterface.OnClickListener()
                {
                  public final void onClick(final DialogInterface paramAnonymous3DialogInterface, int paramAnonymous3Int)
                  {
                    AppMethodBeat.i(107281);
                    paramAnonymous3DialogInterface = k.a(FavoriteVoiceDetailUI.this.getContext(), FavoriteVoiceDetailUI.this.getString(q.i.app_delete_tips), false, null);
                    final long l1 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId;
                    long l2 = FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_id;
                    b.b(FavoriteVoiceDetailUI.a(FavoriteVoiceDetailUI.this).field_localId, new Runnable()
                    {
                      public final void run()
                      {
                        AppMethodBeat.i(107280);
                        FavoriteVoiceDetailUI.this.Akw.AcH = true;
                        paramAnonymous3DialogInterface.dismiss();
                        Log.d("MicroMsg.FavoriteDetailUI", "do del fav voice, local id %d, fav id %d", new Object[] { Long.valueOf(l1), Long.valueOf(this.pal) });
                        FavoriteVoiceDetailUI.this.finish();
                        AppMethodBeat.o(107280);
                      }
                    });
                    AppMethodBeat.o(107281);
                  }
                }, null);
                AppMethodBeat.o(107282);
                return;
                j.a(FavoriteVoiceDetailUI.this, FavoriteVoiceDetailUI.b(FavoriteVoiceDetailUI.this), FavoriteVoiceDetailUI.this.Akw);
              }
            }
          };
          paramAnonymousMenuItem.dDn();
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
    if (this.Amq != null) {
      this.Amq.stopPlay();
    }
    if (this.Aee != null) {
      this.Aee.destroy();
    }
    ((ah)h.az(ah.class)).getFavItemInfoStorage().remove(this);
    AppMethodBeat.o(107285);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(107288);
    this.AdF = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(this.AlK);
    if (this.AdF == null)
    {
      Log.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
      AppMethodBeat.o(107288);
      return;
    }
    if (this.AdF.field_itemStatus != 10)
    {
      AppMethodBeat.o(107288);
      return;
    }
    if ((paramMStorageEventData == null) || (paramMStorageEventData.stg == null))
    {
      AppMethodBeat.o(107288);
      return;
    }
    if (this.AdF.field_favProto.vEn.size() > 0)
    {
      paramMStorageEventData = b.c(this.AdF);
      paramString = b.d(paramMStorageEventData);
      int i = b.atU(paramMStorageEventData.ZyU);
      Log.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
      paramMStorageEventData = m.Q(this, (int)b.mA(paramMStorageEventData.duration)).toString();
      this.Amq.M(paramString, i, paramMStorageEventData);
    }
    AppMethodBeat.o(107288);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(107287);
    super.onPause();
    this.Aee.pause();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI
 * JD-Core Version:    0.7.0.1
 */