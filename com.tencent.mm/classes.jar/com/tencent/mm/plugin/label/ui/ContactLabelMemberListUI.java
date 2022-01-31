package com.tencent.mm.plugin.label.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.label.a.b;
import com.tencent.mm.sdk.e.n.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.MMActivity;

public class ContactLabelMemberListUI
  extends MMActivity
{
  private TextView jCy;
  private ak mHandler;
  private n.b nYH;
  private ListView nYW;
  private a nYX;
  private String nYY;
  private String nYZ;
  
  public ContactLabelMemberListUI()
  {
    AppMethodBeat.i(22644);
    this.mHandler = new ContactLabelMemberListUI.1(this);
    this.nYH = new ContactLabelMemberListUI.2(this);
    AppMethodBeat.o(22644);
  }
  
  private void bLd()
  {
    AppMethodBeat.i(22650);
    if (this.nYX != null)
    {
      this.nYX.nYS = com.tencent.mm.plugin.label.a.a.bKV().RR(this.nYY);
      this.nYX.a(null, null);
    }
    this.nYZ = com.tencent.mm.plugin.label.a.a.bKV().RN(this.nYY);
    if (!bo.isNullOrNil(this.nYZ)) {
      setMMTitle(this.nYZ);
    }
    AppMethodBeat.o(22650);
  }
  
  public int getLayoutId()
  {
    return 2130969262;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(22649);
    ab.i("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. requestcode:%d resultCode:%d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    switch (paramInt1)
    {
    default: 
      ab.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] onActivity result. unknow requestcode:%d", new Object[] { Integer.valueOf(paramInt1) });
      AppMethodBeat.o(22649);
      return;
    }
    if (paramInt2 == -1)
    {
      finish();
      AppMethodBeat.o(22649);
      return;
    }
    bLd();
    AppMethodBeat.o(22649);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(22645);
    super.onCreate(paramBundle);
    this.nYY = getIntent().getStringExtra("label_id");
    this.nYZ = getIntent().getStringExtra("label_name");
    setBackBtn(new ContactLabelMemberListUI.3(this));
    addTextOptionMenu(0, getString(2131301005), new ContactLabelMemberListUI.4(this));
    setMMTitle(this.nYZ);
    this.nYW = ((ListView)findViewById(2131823174));
    this.jCy = ((TextView)findViewById(2131821788));
    if (bo.isNullOrNil(this.nYY))
    {
      ab.e("MicroMsg.Label.ContactLabelMemberListUI", "[cpan] inite view");
      finish();
    }
    this.nYX = new a(getContext());
    this.nYW.setAdapter(this.nYX);
    this.nYW.setOnItemClickListener(new ContactLabelMemberListUI.5(this));
    this.nYW.setEmptyView(this.jCy);
    AppMethodBeat.o(22645);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(22648);
    if (this.nYX != null)
    {
      this.nYX.bKb();
      this.nYX.dAW();
    }
    super.onDestroy();
    AppMethodBeat.o(22648);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(22647);
    aw.aaz();
    c.YA().b(this.nYH);
    super.onPause();
    AppMethodBeat.o(22647);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(22646);
    aw.aaz();
    c.YA().a(this.nYH);
    super.onResume();
    bLd();
    AppMethodBeat.o(22646);
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