package com.tencent.mm.plugin.fav.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI
  extends FavBaseUI
{
  private View.OnClickListener bTw;
  private String mxJ;
  private com.tencent.mm.plugin.fav.ui.a.b mxK;
  private Set<Integer> mxL;
  private k mxM;
  private String toUser;
  
  public FavSelectUI()
  {
    AppMethodBeat.i(74108);
    this.mxK = null;
    this.mxL = new HashSet();
    this.mxM = new k();
    this.bTw = new FavSelectUI.5(this);
    AppMethodBeat.o(74108);
  }
  
  public final com.tencent.mm.plugin.fav.ui.a.a bxl()
  {
    AppMethodBeat.i(74111);
    if (this.mxK == null)
    {
      getContext();
      this.mxK = new com.tencent.mm.plugin.fav.ui.a.b(this.mvC, false);
    }
    com.tencent.mm.plugin.fav.ui.a.b localb = this.mxK;
    AppMethodBeat.o(74111);
    return localb;
  }
  
  protected final void bxm() {}
  
  protected final boolean bxn()
  {
    AppMethodBeat.i(74112);
    if (((ae)com.tencent.mm.kernel.g.G(ae.class)).getFavItemInfoStorage().getCount() > 0)
    {
      AppMethodBeat.o(74112);
      return true;
    }
    AppMethodBeat.o(74112);
    return false;
  }
  
  protected final void bxo()
  {
    AppMethodBeat.i(74113);
    this.mvx.setCompoundDrawablesWithIntrinsicBounds(0, 2130838832, 0, 0);
    this.mvx.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(getContext(), 10));
    this.mvx.setText(2131299706);
    AppMethodBeat.o(74113);
  }
  
  protected final View.OnClickListener bxp()
  {
    return this.bTw;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(74114);
    if ((paramInt1 == 0) && (-1 == paramInt2))
    {
      finish();
      AppMethodBeat.o(74114);
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(74114);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(74109);
    super.onCreate(paramBundle);
    this.toUser = getIntent().getStringExtra("key_to_user");
    this.mxJ = getIntent().getStringExtra("key_fav_item_id");
    if (this.mxJ != null)
    {
      paramBundle = this.mxJ.split(",");
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        int k = bo.getInt(paramBundle[i], 2147483647);
        if (2147483647 != k) {
          this.mxL.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    this.mxL.remove(Integer.valueOf(3));
    this.mxK.e(this.mxL);
    this.mxM.mts = false;
    this.mxK.a(this.mxM);
    this.mqF.post(new FavSelectUI.1(this));
    addIconOptionMenu(0, 2131230741, new FavSelectUI.2(this));
    setMMTitle(2131299823);
    setBackBtn(new FavSelectUI.3(this));
    AppMethodBeat.o(74109);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(74115);
    super.onDestroy();
    if (this.mxK != null) {
      this.mxK.finish();
    }
    AppMethodBeat.o(74115);
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(74110);
    paramAdapterView = (a.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSelectUI", "on item click, holder is null");
      AppMethodBeat.o(74110);
      return;
    }
    if (paramAdapterView.muk == null)
    {
      com.tencent.mm.sdk.platformtools.ab.w("MicroMsg.FavSelectUI", "on item click, info is null");
      AppMethodBeat.o(74110);
      return;
    }
    paramView = paramAdapterView.muk;
    h.i(paramView.field_localId, 1, 1);
    if (paramView.field_type == 3)
    {
      com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131296331));
      AppMethodBeat.o(74110);
      return;
    }
    if ((paramView.field_type == 8) && (t.nU(this.toUser)))
    {
      com.tencent.mm.ui.widget.snackbar.b.l(this, getString(2131296329));
      AppMethodBeat.o(74110);
      return;
    }
    ((com.tencent.mm.plugin.fav.a.ab)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.fav.a.ab.class)).a(getContext(), this.toUser, paramAdapterView.muk, true, new FavSelectUI.4(this, paramAdapterView));
    AppMethodBeat.o(74110);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI
 * JD-Core Version:    0.7.0.1
 */