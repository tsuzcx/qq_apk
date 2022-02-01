package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bc;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private aq mHandler;
  private TextView nBN;
  private n.b viB;
  private ListView viQ;
  private a viR;
  private String viS;
  private String viT;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ContactLabelMemberListUI.1(this);
    this.viB = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26262);
        ae.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
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
  
  private void dio()
  {
    AppMethodBeat.i(26272);
    if (this.viR != null)
    {
      this.viR.viM = com.tencent.mm.plugin.label.a.a.dig().apr(this.viS);
      this.viR.a(null, null);
    }
    this.viT = com.tencent.mm.plugin.label.a.a.dig().apn(this.viS);
    if (!bu.isNullOrNil(this.viT)) {
      setMMTitle(this.viT);
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
    ae.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ae.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26271);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(26271);
      return;
    }
    dio();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.viS = getIntent().getStringExtra("label_id");
    this.viT = getIntent().getStringExtra("label_name");
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
    setMMTitle(this.viT);
    this.viQ = ((ListView)findViewById(2131298671));
    this.nBN = ((TextView)findViewById(2131299457));
    if (bu.isNullOrNil(this.viS))
    {
      ae.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.viR = new a(getContext());
    this.viQ.setAdapter(this.viR);
    this.viQ.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.viQ.setEmptyView(this.nBN);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.viR != null)
    {
      this.viR.dhl();
      this.viR.fzh();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    bc.aCg();
    c.azF().b(this.viB);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    bc.aCg();
    c.azF().a(this.viB);
    super.onResume();
    dio();
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