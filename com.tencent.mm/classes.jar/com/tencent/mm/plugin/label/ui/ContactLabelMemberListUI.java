package com.tencent.mm.plugin.label.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.l;
import com.tencent.mm.model.au;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.e.m.b;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.s;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private TextView hIY;
  private ListView lBK;
  private a lBL;
  private String lBM;
  private String lBN;
  private m.b lBv = new ContactLabelMemberListUI.2(this);
  private ah mHandler = new ContactLabelMemberListUI.1(this);
  
  private void bdJ()
  {
    if (this.lBL != null)
    {
      this.lBL.lBG = com.tencent.mm.plugin.label.a.a.bdA().Go(this.lBM);
      this.lBL.a(null, null);
    }
    this.lBN = com.tencent.mm.plugin.label.a.a.bdA().Gk(this.lBM);
    if (!bk.bl(this.lBN)) {
      setMMTitle(this.lBN);
    }
  }
  
  protected final int getLayoutId()
  {
    return R.i.contact_label_member_list_ui;
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      y.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      return;
    }
    bdJ();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    this.lBM = getIntent().getStringExtra("label_id");
    this.lBN = getIntent().getStringExtra("label_name");
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        ContactLabelMemberListUI.this.finish();
        return false;
      }
    });
    addTextOptionMenu(0, getString(R.l.label_manager), new ContactLabelMemberListUI.4(this));
    setMMTitle(this.lBN);
    this.lBK = ((ListView)findViewById(R.h.contact_label_member_list));
    this.hIY = ((TextView)findViewById(R.h.empty));
    if (bk.bl(this.lBM))
    {
      y.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.lBL = new a(this.mController.uMN);
    this.lBK.setAdapter(this.lBL);
    this.lBK.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.lBK.setEmptyView(this.hIY);
  }
  
  protected void onDestroy()
  {
    if (this.lBL != null)
    {
      this.lBL.bcS();
      this.lBL.uMi = null;
    }
    super.onDestroy();
  }
  
  protected void onPause()
  {
    au.Hx();
    c.Fw().b(this.lBv);
    super.onPause();
  }
  
  protected void onResume()
  {
    au.Hx();
    c.Fw().a(this.lBv);
    super.onResume();
    bdJ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.label.ui.ContactLabelMemberListUI
 * JD-Core Version:    0.7.0.1
 */