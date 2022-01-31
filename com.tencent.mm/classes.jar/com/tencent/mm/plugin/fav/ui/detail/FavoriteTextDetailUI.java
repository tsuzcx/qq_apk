package com.tencent.mm.plugin.fav.ui.detail;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.ClipboardManager;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.m.b;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.tools.l;
import com.tencent.mm.ui.widget.MMLoadScrollView;

public class FavoriteTextDetailUI
  extends BaseFavDetailReportUI
{
  private static final int mAX;
  private l contextMenuHelper;
  private long mAN;
  private TextView mAY;
  private ClipboardManager mAZ;
  private com.tencent.mm.plugin.fav.a.g mAr;
  private com.tencent.mm.plugin.fav.a.g mBa;
  private n.d mBb;
  
  static
  {
    AppMethodBeat.i(74455);
    mAX = b.MT();
    AppMethodBeat.o(74455);
  }
  
  public FavoriteTextDetailUI()
  {
    AppMethodBeat.i(74445);
    this.mBb = new FavoriteTextDetailUI.3(this);
    AppMethodBeat.o(74445);
  }
  
  private void byg()
  {
    AppMethodBeat.i(74451);
    this.mAr = ((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().kb(this.mAN);
    F(this.mAr);
    if ((this.mAr == null) || (this.mAr.field_favProto == null))
    {
      ab.w("MicroMsg.FavoriteTextDetailUI", "id[%d] info is null, return", new Object[] { Long.valueOf(this.mAN) });
      AppMethodBeat.o(74451);
      return;
    }
    a.a(this, this.mAr);
    if ((this.mBa != null) && (this.mBa.field_edittime == this.mAr.field_edittime))
    {
      ab.w("MicroMsg.FavoriteTextDetailUI", "not change, return");
      AppMethodBeat.o(74451);
      return;
    }
    this.mBa = this.mAr;
    this.mAY.setText(this.mAr.field_favProto.desc);
    com.tencent.mm.pluginsdk.ui.d.j.k(this.mAY, 1);
    AppMethodBeat.o(74451);
  }
  
  protected final MMLoadScrollView bxU()
  {
    AppMethodBeat.i(74446);
    MMLoadScrollView localMMLoadScrollView = (MMLoadScrollView)findViewById(2131824115);
    AppMethodBeat.o(74446);
    return localMMLoadScrollView;
  }
  
  public int getLayoutId()
  {
    return 2130969575;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74453);
    if ((1 == paramInt1) && (-1 == paramInt2))
    {
      h.bO(getContext(), getString(2131297064));
      new ak().postDelayed(new FavoriteTextDetailUI.4(this), 250L);
      AppMethodBeat.o(74453);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74453);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74447);
    super.onCreate(paramBundle);
    this.mAY = ((TextView)findViewById(2131824120));
    this.mAZ = ((ClipboardManager)ah.getContext().getSystemService("clipboard"));
    this.mAN = getIntent().getLongExtra("key_detail_info_id", -1L);
    com.tencent.mm.pluginsdk.wallet.j.Mx(5);
    this.contextMenuHelper = new l(getContext());
    this.contextMenuHelper.a(this.mAY, this, this.mBb);
    setMMTitle(getString(2131299687));
    setBackBtn(new FavoriteTextDetailUI.1(this));
    addIconOptionMenu(0, 2131304317, 2130839668, new FavoriteTextDetailUI.2(this));
    AppMethodBeat.o(74447);
  }
  
  public void onCreateContextMenu(ContextMenu paramContextMenu, View paramView, ContextMenu.ContextMenuInfo paramContextMenuInfo)
  {
    AppMethodBeat.i(74452);
    paramContextMenu.add(0, 1, 0, getString(2131296895));
    AppMethodBeat.o(74452);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74448);
    super.onDestroy();
    AppMethodBeat.o(74448);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(74450);
    super.onPause();
    AppMethodBeat.o(74450);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(74449);
    super.onResume();
    byg();
    AppMethodBeat.o(74449);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.detail.FavoriteTextDetailUI
 * JD-Core Version:    0.7.0.1
 */