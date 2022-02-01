package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.bg;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.MStorageEx;
import com.tencent.mm.sdk.storage.MStorageEx.IOnStorageChange;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private MMHandler mHandler;
  private TextView oMM;
  private MStorageEx.IOnStorageChange yCE;
  private ListView yCT;
  private a yCU;
  private String yCV;
  private String yCW;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(26266);
    this.mHandler = new ContactLabelMemberListUI.1(this);
    this.yCE = new MStorageEx.IOnStorageChange()
    {
      public final void onNotifyChange(int paramAnonymousInt, MStorageEx paramAnonymousMStorageEx, Object paramAnonymousObject)
      {
        AppMethodBeat.i(26262);
        Log.d("MicroMsg.Label.ContactLabelMemberListUI", "event:%d, obj:%s", new Object[] { Integer.valueOf(paramAnonymousInt), paramAnonymousObject });
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
  
  private void eco()
  {
    AppMethodBeat.i(26272);
    if (this.yCU != null)
    {
      this.yCU.yCP = com.tencent.mm.plugin.label.a.a.ecg().aCK(this.yCV);
      this.yCU.onNotifyChange(null, null);
    }
    this.yCW = com.tencent.mm.plugin.label.a.a.ecg().aCG(this.yCV);
    if (!Util.isNullOrNil(this.yCW)) {
      setMMTitle(this.yCW);
    }
    AppMethodBeat.o(26272);
  }
  
  public int getLayoutId()
  {
    return 2131493780;
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
    eco();
    AppMethodBeat.o(26271);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(26267);
    super.onCreate(paramBundle);
    this.yCV = getIntent().getStringExtra("label_id");
    this.yCW = getIntent().getStringExtra("label_name");
    setBackBtn(new ContactLabelMemberListUI.3(this));
    addTextOptionMenu(0, getString(2131762120), new MenuItem.OnMenuItemClickListener()
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
    setMMTitle(this.yCW);
    this.yCT = ((ListView)findViewById(2131299108));
    this.oMM = ((TextView)findViewById(2131300076));
    if (Util.isNullOrNil(this.yCV))
    {
      Log.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.yCU = new a(getContext());
    this.yCT.setAdapter(this.yCU);
    this.yCT.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.yCT.setEmptyView(this.oMM);
    AppMethodBeat.o(26267);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(26270);
    if (this.yCU != null)
    {
      this.yCU.ebf();
      this.yCU.gGV();
    }
    super.onDestroy();
    AppMethodBeat.o(26270);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(26269);
    bg.aVF();
    c.aSN().remove(this.yCE);
    super.onPause();
    AppMethodBeat.o(26269);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(26268);
    bg.aVF();
    c.aSN().add(this.yCE);
    super.onResume();
    eco();
    AppMethodBeat.o(26268);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI
 * JD-Core Version:    0.7.0.1
 */