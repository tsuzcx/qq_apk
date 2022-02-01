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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private ap mHandler;
  private TextView mtT;
  private n.b sMG;
  private ListView sMV;
  private a sMW;
  private String sMX;
  private String sMY;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ap()
    {
      public final void handleMessage(Message paramAnonymousMessage)
      {
        AppMethodBeat.i(26261);
        int i = paramAnonymousMessage.what;
        ad.d("MicroMsg.Label.ContactLabelMemberListUI", "handleMessage:%d", new Object[] { Integer.valueOf(i) });
        switch (i)
        {
        default: 
          ad.w("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] unknow msg.");
          AppMethodBeat.o(26261);
          return;
        }
        ContactLabelMemberListUI.a(ContactLabelMemberListUI.this);
        AppMethodBeat.o(26261);
      }
    };
    this.sMG = new n.b()
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
  
  private void cJa()
  {
    AppMethodBeat.i(26272);
    if (this.sMW != null)
    {
      this.sMW.sMR = com.tencent.mm.plugin.label.a.a.cIS().aeL(this.sMX);
      this.sMW.a(null, null);
    }
    this.sMY = com.tencent.mm.plugin.label.a.a.cIS().aeH(this.sMX);
    if (!bt.isNullOrNil(this.sMY)) {
      setMMTitle(this.sMY);
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
    cJa();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.sMX = getIntent().getStringExtra("label_id");
    this.sMY = getIntent().getStringExtra("label_name");
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
    setMMTitle(this.sMY);
    this.sMV = ((ListView)findViewById(2131298671));
    this.mtT = ((TextView)findViewById(2131299457));
    if (bt.isNullOrNil(this.sMX))
    {
      ad.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.sMW = new a(getContext());
    this.sMV.setAdapter(this.sMW);
    this.sMV.setOnItemClickListener(new AdapterView.OnItemClickListener()
    {
      public final void onItemClick(AdapterView<?> paramAnonymousAdapterView, View paramAnonymousView, int paramAnonymousInt, long paramAnonymousLong)
      {
        AppMethodBeat.i(26265);
        ContactLabelMemberListUI.a(ContactLabelMemberListUI.this, paramAnonymousInt);
        AppMethodBeat.o(26265);
      }
    });
    this.sMV.setEmptyView(this.mtT);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.sMW != null)
    {
      this.sMW.cHX();
      this.sMW.ePu();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    az.arV();
    c.apM().b(this.sMG);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    az.arV();
    c.apM().a(this.sMG);
    super.onResume();
    cJa();
    AppMethodBeat.o(26268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI
 * JD-Core Version:    0.7.0.1
 */