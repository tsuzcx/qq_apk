package com.tencent.mm.chatroom.ui;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.ah.p;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.af;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.am.b.a;
import com.tencent.mm.model.q;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.x;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements f
{
  private String chatroomName;
  private int dmV;
  private int dmW;
  private u dnL;
  private ProgressDialog dnm = null;
  private View dqA;
  private TextView dqB;
  private com.tencent.mm.chatroom.c.j dqC;
  private String dqD;
  private boolean dqE;
  private boolean dqF;
  private View dqr;
  private ImageView dqs;
  private TextView dqt;
  private TextView dqu;
  private TextView dqv;
  private TextView dqz;
  private int status;
  
  private void eQ(String paramString)
  {
    Object localObject2 = null;
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(paramString);
    if ((localad != null) && ((int)localad.dBe > 0)) {}
    for (Object localObject1 = localad.field_conRemark;; localObject1 = null)
    {
      if (bk.bl((String)localObject1)) {
        if (this.dnL == null) {
          localObject1 = localObject2;
        }
      }
      for (;;)
      {
        localObject2 = localObject1;
        if (bk.bl((String)localObject1))
        {
          localObject2 = localObject1;
          if (localad != null)
          {
            localObject2 = localObject1;
            if ((int)localad.dBe > 0) {
              localObject2 = localad.Bp();
            }
          }
        }
        localObject1 = localObject2;
        if (bk.bl((String)localObject2)) {
          localObject1 = paramString;
        }
        a.b.a(this.dqs, paramString);
        this.dqt.setVisibility(0);
        this.dqt.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, (int)this.dqt.getTextSize()));
        return;
        localObject1 = this.dnL.gV(paramString);
      }
    }
  }
  
  private void xJ()
  {
    Intent localIntent = new Intent(this, RoomAlphaProcessUI.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("RoomInfo_Id", this.chatroomName);
    startActivity(localIntent);
  }
  
  private void xK()
  {
    this.chatroomName = getIntent().getStringExtra("room_name");
    y.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    g.DO().dJT.a(519, this);
    this.dnL = ((c)g.r(c.class)).FF().in(this.chatroomName);
    if (this.dnL == null)
    {
      finish();
      return;
    }
    this.dqE = q.Gj().equals(this.dnL.field_roomowner);
    if (!x.cqG()) {}
    for (boolean bool = true;; bool = false)
    {
      this.dqF = bool;
      return;
    }
  }
  
  private void xL()
  {
    final String str = this.dnL.field_roomowner;
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abl(str);
    if ((localad != null) && ((int)localad.dBe <= 0)) {
      am.a.dVy.a(str, this.chatroomName, new am.b.a()
      {
        public final void m(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          if (paramAnonymousBoolean) {
            RoomUpgradeUI.g(RoomUpgradeUI.this).post(new RoomUpgradeUI.4.1(this));
          }
        }
      });
    }
    for (;;)
    {
      int i = this.dnL.ctR();
      this.dqu.setVisibility(0);
      if (i > 40) {
        break;
      }
      this.dqu.setText(getString(a.i.room_upgrade_intro_maxcount, new Object[] { getString(a.i.room_upgrade_entry_maxcount_summary_normal) }));
      return;
      eQ(str);
    }
    this.dqu.setText(getString(a.i.room_upgrade_intro_maxcount, new Object[] { getString(a.i.room_upgrade_entry_maxcount_summary_biggroup) }));
  }
  
  public final int getLayoutId()
  {
    return a.f.chatroom_upgrade;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.room_upgrade_entry_maxcount);
    setBackBtn(new RoomUpgradeUI.1(this));
    this.dqr = findViewById(a.e.upgrader_info_container);
    this.dqA = findViewById(a.e.upgrader_responsibility);
    this.dqs = ((ImageView)findViewById(a.e.upgrader_avatar));
    this.dqt = ((TextView)findViewById(a.e.upgrader_nickname));
    this.dqu = ((TextView)findViewById(a.e.upgrade_intro));
    this.dqv = ((TextView)findViewById(a.e.upgrade_quota_left));
    this.dqB = ((TextView)findViewById(a.e.upgrade_button));
    this.dqB.setOnClickListener(new RoomUpgradeUI.2(this));
    this.dqz = ((TextView)findViewById(a.e.how_to_upgrade_maxcount));
    this.dqz.setOnClickListener(new RoomUpgradeUI.3(this));
    if (this.dqE)
    {
      this.dnm = h.b(this, getString(a.i.loading_tips), true, new RoomUpgradeUI.5(this));
      this.dqC = new com.tencent.mm.chatroom.c.j(this.chatroomName);
      g.DO().dJT.a(this.dqC, 0);
    }
    for (;;)
    {
      if (this.dqF) {
        this.dqz.setVisibility(8);
      }
      return;
      xL();
      if (!this.dqF) {
        this.dqz.setVisibility(0);
      }
      this.dqz.setText(a.i.room_upgrade_how_to_upgrade_maxcount_member_view);
      this.dqB.setVisibility(8);
      this.dqv.setVisibility(8);
    }
  }
  
  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    y.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      y.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
      return;
    }
    finish();
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    xK();
    initView();
  }
  
  protected void onDestroy()
  {
    g.DO().dJT.c(this.dqC);
    g.DO().dJT.b(519, this);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    super.onDestroy();
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    boolean bool;
    if (paramIntent.hasExtra("upgrade_success"))
    {
      bool = paramIntent.getBooleanExtra("upgrade_success", false);
      if (bool)
      {
        xK();
        int i = paramIntent.getIntExtra("left_quota", 0);
        xL();
        this.dqB.setVisibility(8);
        this.dmW = i;
        if (this.dmW <= 0) {
          break label160;
        }
        this.dqv.setText(getString(a.i.room_upgrade_info_quota_left, new Object[] { Integer.valueOf(this.dmW) }));
      }
    }
    for (;;)
    {
      if (!this.dqF) {
        this.dqz.setVisibility(0);
      }
      this.dqz.setText(a.i.room_upgrade_how_to_upgrade_maxcount_member_view);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        xJ();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        xJ();
      }
      bool = false;
      break;
      label160:
      this.dqv.setText(getString(a.i.room_upgrade_info_quota_run_out));
    }
  }
  
  public void onPause()
  {
    super.onPause();
  }
  
  public void onResume()
  {
    super.onResume();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.dnm != null) {
      this.dnm.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0)) {
      h.a(this, getString(a.i.room_upgrade_info_err), getString(a.i.app_tip), false, new RoomUpgradeUI.6(this));
    }
    while ((paramInt1 != 0) || (paramInt2 != 0) || (paramm.getType() != 519)) {
      return;
    }
    paramString = (com.tencent.mm.chatroom.c.j)paramm;
    this.status = paramString.status;
    this.dmV = paramString.dmV;
    this.dmW = paramString.dmW;
    xL();
    this.dqv.setVisibility(0);
    this.dqB.setText(getString(a.i.room_upgrade_button_bigchatroom));
    if (this.dmW > 0) {
      this.dqv.setText(getString(a.i.room_upgrade_info_quota_left, new Object[] { Integer.valueOf(this.dmW) }));
    }
    for (;;)
    {
      if (!this.dqF) {
        this.dqz.setVisibility(0);
      }
      switch (this.status)
      {
      default: 
        return;
      case 1: 
      case 2: 
      case 5: 
        this.dqB.setVisibility(0);
        this.dqz.setText(a.i.room_upgrade_how_to_upgrade_maxcount_owner_view);
        return;
        this.dqv.setText(getString(a.i.room_upgrade_info_quota_run_out));
      }
    }
    this.dqB.setVisibility(0);
    this.dqB.setEnabled(false);
    this.dqz.setText(a.i.room_upgrade_how_to_upgrade_maxcount_owner_view);
    return;
    this.dqB.setVisibility(8);
    this.dqz.setText(a.i.room_upgrade_how_to_upgrade_maxcount_member_view);
    this.dqB.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI
 * JD-Core Version:    0.7.0.1
 */