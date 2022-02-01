package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.bh;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private MStorageEx.IOnStorageChange JVD;
  private ListView JVY;
  private a JVZ;
  private String JWa;
  private String JWb;
  private MMHandler mHandler;
  private TextView uZW;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ContactLabelMemberListUI.1(this);
    this.JVD = new ContactLabelMemberListUI.2(this);
    AppMethodBeat.o(26266);
  }
  
  private void fTt()
  {
    AppMethodBeat.i(26272);
    if (this.JVZ != null)
    {
      this.JVZ.JVU = com.tencent.mm.plugin.label.a.a.fTb().aJK(this.JWa);
      this.JVZ.onNotifyChange(null, null);
    }
    this.JWb = com.tencent.mm.plugin.label.a.a.fTb().aJG(this.JWa);
    if (!Util.isNullOrNil(this.JWb)) {
      setMMTitle(this.JWb);
    }
    AppMethodBeat.o(26272);
  }
  
  public int getLayoutId()
  {
    return R.i.giv;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(26271);
    Log.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(26271);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(26271);
      return;
    }
    fTt();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.JWa = getIntent().getStringExtra("label_id");
    this.JWb = getIntent().getStringExtra("label_name");
    setBackBtn(new ContactLabelMemberListUI.3(this));
    addTextOptionMenu(0, getString(R.l.gMk), new MenuItem.OnMenuItemClickListener()
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
    setMMTitle(this.JWb);
    this.JVY = ((ListView)findViewById(R.h.fDb));
    this.uZW = ((TextView)findViewById(R.h.empty));
    if (Util.isNullOrNil(this.JWa))
    {
      Log.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.JVZ = new a(getContext());
    this.JVY.setAdapter(this.JVZ);
    this.JVY.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.JVY.setEmptyView(this.uZW);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.JVZ != null)
    {
      this.JVZ.fSd();
      this.JVZ.jhO();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    bh.bCz();
    c.bzA().remove(this.JVD);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    bh.bCz();
    c.bzA().add(this.JVD);
    super.onResume();
    fTt();
    AppMethodBeat.o(26268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI
 * JD-Core Version:    0.7.0.1
 */