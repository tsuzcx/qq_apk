package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.az;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.e.n;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ao;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private ao mHandler;
  private TextView mVV;
  private ListView tUA;
  private a tUB;
  private String tUC;
  private String tUD;
  private n.b tUl;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ao()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26261);
        int i = paramAnonymousMessage.what;
        ac.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        default: 
          ac.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
          AppMethodBeat.o(26261);
          return;
        }
        ContactLabelMemberListUI.a(ContactLabelMemberListUI.this);
        AppMethodBeat.o(26261);
      }
    };
    this.tUl = new n.b()
    {
      public final void a(int paramAnonymousInt, n paramAnonymousn, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26262);
        ac.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
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
  
  private void cWl()
  {
    AppMethodBeat.i(26272);
    if (this.tUB != null)
    {
      this.tUB.tUw = com.tencent.mm.plugin.label.a.a.cWd().ajD(this.tUC);
      this.tUB.a(null, null);
    }
    this.tUD = com.tencent.mm.plugin.label.a.a.cWd().ajz(this.tUC);
    if (!bs.isNullOrNil(this.tUD)) {
      setMMTitle(this.tUD);
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
    ac.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ac.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26271);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(26271);
      return;
    }
    cWl();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.tUC = getIntent().getStringExtra("label_id");
    this.tUD = getIntent().getStringExtra("label_name");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(26263);
        ContactLabelMemberListUI.this.finish();
        AppMethodBeat.o(26263);
        return false;
      }
    });
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
    setMMTitle(this.tUD);
    this.tUA = ((ListView)findViewById(2131298671));
    this.mVV = ((TextView)findViewById(2131299457));
    if (bs.isNullOrNil(this.tUC))
    {
      ac.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.tUB = new a(getContext());
    this.tUA.setAdapter(this.tUB);
    this.tUA.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26265);
        ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, paramAnonymousInt);
        AppMethodBeat.o(26265);
      }
    });
    this.tUA.setEmptyView(this.mVV);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.tUB != null)
    {
      this.tUB.cVi();
      this.tUB.feY();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    az.ayM();
    c.awB().b(this.tUl);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    az.ayM();
    c.awB().a(this.tUl);
    super.onResume();
    cWl();
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