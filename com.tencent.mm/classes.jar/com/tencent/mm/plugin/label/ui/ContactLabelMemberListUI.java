package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.ba;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private ap mHandler;
  private TextView nws;
  private n.b uWN;
  private ListView uXc;
  private a uXd;
  private String uXe;
  private String uXf;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ContactLabelMemberListUI.1(this);
    this.uWN = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26262);
        ad.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
        if (ContactLabelMemberListUI.b(ContactLabelMemberListUI.this) != null)
        {
          ContactLabelMemberListUI.b(ContactLabelMemberListUI.this).removeMessages(5001);
          ContactLabelMemberListUI.b(ContactLabelMemberListUI.this).sendEmptyMessageDelayed(5001, 300L);
        }
        AppMethodBeat.o(26262);
      }
    };
    AppMethodBeat.o(26266);
  }
  
  private void dfw()
  {
    AppMethodBeat.i(26272);
    if (this.uXd != null)
    {
      this.uXd.uWY = com.tencent.mm.plugin.label.a.a.dfo().aop(this.uXe);
      this.uXd.a(null, null);
    }
    this.uXf = com.tencent.mm.plugin.label.a.a.dfo().aol(this.uXe);
    if (!bt.isNullOrNil(this.uXf)) {
      setMMTitle(this.uXf);
    }
    AppMethodBeat.o(26272);
  }
  
  public int getLayoutId()
  {
    return 2131493650;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26271);
    ad.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ad.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26271);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(26271);
      return;
    }
    dfw();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.uXe = getIntent().getStringExtra("label_id");
    this.uXf = getIntent().getStringExtra("label_name");
    setBackBtn(new ContactLabelMemberListUI.3(this));
    addTextOptionMenu(0, getString(2131760608), new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26264);
        paramAnonymousMenuItem = new Intent();
        paramAnonymousMenuItem.setClass(ContactLabelMemberListUI.this, ContactLabelEditUI.class);
        paramAnonymousMenuItem.putExtra("label_id", ContactLabelMemberListUI.c(ContactLabelMemberListUI.this));
        paramAnonymousMenuItem.putExtra("label_name", ContactLabelMemberListUI.d(ContactLabelMemberListUI.this));
        ContactLabelMemberListUI.this.startActivityForResult(paramAnonymousMenuItem, 10001);
        AppMethodBeat.o(26264);
        return false;
      }
    });
    setMMTitle(this.uXf);
    this.uXc = ((ListView)findViewById(2131298671));
    this.nws = ((TextView)findViewById(2131299457));
    if (bt.isNullOrNil(this.uXe))
    {
      ad.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.uXd = new a(getContext());
    this.uXc.setAdapter(this.uXd);
    this.uXc.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.uXc.setEmptyView(this.nws);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.uXd != null)
    {
      this.uXd.det();
      this.uXd.fvg();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    ba.aBQ();
    c.azp().b(this.uWN);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    ba.aBQ();
    c.azp().a(this.uWN);
    super.onResume();
    dfw();
    AppMethodBeat.o(26268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI
 * JD-Core Version:    0.7.0.1
 */