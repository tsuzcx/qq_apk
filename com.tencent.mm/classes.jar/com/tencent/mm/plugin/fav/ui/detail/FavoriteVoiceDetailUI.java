package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.b;
import com.tencent.mm.plugin.fav.a.n;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.FavChatVoiceView;
import com.tencent.mm.plugin.fav.ui.j;
import com.tencent.mm.protocal.protobuf.aca;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.e.k.a;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.vfs.e;
import java.util.LinkedList;

public class FavoriteVoiceDetailUI
  extends BaseFavDetailReportUI
  implements k.a
{
  private long mAN;
  private FavChatVoiceView mBv;
  private n muE;
  private com.tencent.mm.plugin.fav.a.g muk;
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(74488);
    this.muk = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mAN);
    if (this.muk == null)
    {
      ab.w("MicroMsg.FavoriteDetailUI", "on notify changed, get fav item info error");
      finish();
      AppMethodBeat.o(74488);
      return;
    }
    if (this.muk.field_itemStatus != 10)
    {
      AppMethodBeat.o(74488);
      return;
    }
    if ((paramm == null) || (paramm.yrX == null))
    {
      AppMethodBeat.o(74488);
      return;
    }
    if (this.muk.field_favProto.wVc.size() > 0)
    {
      paramm = b.c(this.muk);
      paramString = b.b(paramm);
      int i = b.NC(paramm.wSR);
      ab.i("MicroMsg.FavoriteDetailUI", "on notify changed, favVoiceView.updateInfo");
      paramm = j.C(this, (int)b.jR(paramm.duration)).toString();
      this.mBv.u(paramString, i, paramm);
    }
    AppMethodBeat.o(74488);
  }
  
  public int getLayoutId()
  {
    return 2130969576;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74484);
    super.onCreate(paramBundle);
    setMMTitle(getString(2131299687));
    this.mAN = getIntent().getLongExtra("key_detail_info_id", -1L);
    this.muk = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mAN);
    if (this.muk == null)
    {
      ab.w("MicroMsg.FavoriteDetailUI", "get fav item info error");
      finish();
    }
    for (;;)
    {
      ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().add(this);
      AppMethodBeat.o(74484);
      return;
      F(this.muk);
      this.muE = new n();
      this.mBv = ((FavChatVoiceView)findViewById(2131824121));
      this.mBv.setVoiceHelper(this.muE);
      a.a(this, this.muk);
      Object localObject = b.c(this.muk);
      paramBundle = b.b((aca)localObject);
      int i = b.NC(((aca)localObject).wSR);
      if (!e.cN(paramBundle)) {
        b.m(this.muk);
      }
      localObject = j.C(this, (int)b.jR(((aca)localObject).duration)).toString();
      this.mBv.u(paramBundle, i, (String)localObject);
      setBackBtn(new FavoriteVoiceDetailUI.1(this));
      addIconOptionMenu(0, 2131304317, 2130839668, new FavoriteVoiceDetailUI.2(this));
    }
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74485);
    super.onDestroy();
    if (this.mBv != null) {
      this.mBv.stopPlay();
    }
    if (this.muE != null) {
      this.muE.destroy();
    }
    ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().remove(this);
    AppMethodBeat.o(74485);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74487);
    super.onPause();
    this.muE.pause();
    AppMethodBeat.o(74487);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74486);
    super.onResume();
    AppMethodBeat.o(74486);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteVoiceDetailUI
 * JD-Core Version:    0.7.0.1
 */