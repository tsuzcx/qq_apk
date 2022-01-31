package com.tencent.mm.plugin.fav.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.TextView;
import com.tencent.mm.plugin.fav.a.ab;
import com.tencent.mm.plugin.fav.a.ae;
import com.tencent.mm.plugin.fav.a.h;
import com.tencent.mm.plugin.fav.a.k;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.d.a.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.MMActivity;
import java.util.HashSet;
import java.util.Set;

public class FavSelectUI
  extends FavBaseUI
{
  private String kcY;
  private com.tencent.mm.plugin.fav.ui.a.b kcZ = null;
  private Set<Integer> kda = new HashSet();
  private k kdb = new k();
  private View.OnClickListener kdc = new FavSelectUI.5(this);
  private String toUser;
  
  public final com.tencent.mm.plugin.fav.ui.a.a aQX()
  {
    if (this.kcZ == null)
    {
      AppCompatActivity localAppCompatActivity = this.mController.uMN;
      this.kcZ = new com.tencent.mm.plugin.fav.ui.a.b(this.kbg, false);
    }
    return this.kcZ;
  }
  
  protected final void aQY() {}
  
  protected final boolean aQZ()
  {
    return ((ae)com.tencent.mm.kernel.g.t(ae.class)).getFavItemInfoStorage().getCount() > 0;
  }
  
  protected final void aRa()
  {
    this.kbb.setCompoundDrawablesWithIntrinsicBounds(0, n.d.favorites_empty_favorites_icon, 0, 0);
    this.kbb.setCompoundDrawablePadding(com.tencent.mm.cb.a.fromDPToPix(this.mController.uMN, 10));
    this.kbb.setText(n.i.favorite_empty_fav);
  }
  
  protected final View.OnClickListener aRb()
  {
    return this.kdc;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (-1 == paramInt2))
    {
      finish();
      return;
    }
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.toUser = getIntent().getStringExtra("key_to_user");
    this.kcY = getIntent().getStringExtra("key_fav_item_id");
    if (this.kcY != null)
    {
      paramBundle = this.kcY.split(",");
      int j = paramBundle.length;
      int i = 0;
      while (i < j)
      {
        int k = bk.getInt(paramBundle[i], 2147483647);
        if (2147483647 != k) {
          this.kda.add(Integer.valueOf(k));
        }
        i += 1;
      }
    }
    this.kda.remove(Integer.valueOf(3));
    this.kcZ.f(this.kda);
    this.kdb.jZa = false;
    this.kcZ.a(this.kdb);
    this.jWn.post(new FavSelectUI.1(this));
    addIconOptionMenu(0, n.h.actionbar_icon_dark_search, new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        paramAnonymousMenuItem = new Intent();
        FavSelectUI.a(FavSelectUI.this, paramAnonymousMenuItem);
        return true;
      }
    });
    setMMTitle(n.i.favorite_select_title);
    setBackBtn(new FavSelectUI.3(this));
  }
  
  protected void onDestroy()
  {
    super.onDestroy();
    if (this.kcZ != null) {
      this.kcZ.finish();
    }
  }
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (a.b)paramView.getTag();
    if (paramAdapterView == null)
    {
      y.w("MicroMsg.FavSelectUI", "on item click, holder is null");
      return;
    }
    if (paramAdapterView.jZN == null)
    {
      y.w("MicroMsg.FavSelectUI", "on item click, info is null");
      return;
    }
    paramView = paramAdapterView.jZN;
    h.f(paramView.field_localId, 1, 1);
    if (paramView.field_type == 3)
    {
      com.tencent.mm.ui.widget.snackbar.b.h(this, getString(n.i.Fav_Voice_CannotForward));
      return;
    }
    if ((paramView.field_type == 8) && (com.tencent.mm.model.s.hl(this.toUser)))
    {
      com.tencent.mm.ui.widget.snackbar.b.h(this, getString(n.i.Fav_File_CannotForward));
      return;
    }
    ((ab)com.tencent.mm.kernel.g.r(ab.class)).a(this.mController.uMN, this.toUser, paramAdapterView.jZN, n.i.app_send, true, new FavSelectUI.4(this, paramAdapterView));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.FavSelectUI
 * JD-Core Version:    0.7.0.1
 */