package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.f;
import com.tencent.mm.ai.m;
import com.tencent.mm.ai.p;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.ao.b.a;
import com.tencent.mm.model.r;
import com.tencent.mm.n.a;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
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
  private ProgressDialog eeN = null;
  private int eew;
  private int eex;
  private u efi;
  private View ehP;
  private ImageView ehQ;
  private TextView ehR;
  private TextView ehS;
  private TextView ehT;
  private TextView ehX;
  private View ehY;
  private TextView ehZ;
  private com.tencent.mm.chatroom.c.j eia;
  private String eib;
  private boolean eic;
  private boolean eid;
  private int status;
  
  private void Kb()
  {
    AppMethodBeat.i(104244);
    Intent localIntent = new Intent(this, RoomAlphaProcessUI.class);
    localIntent.addFlags(67108864);
    localIntent.addFlags(65536);
    localIntent.putExtra("RoomInfo_Id", this.chatroomName);
    startActivity(localIntent);
    AppMethodBeat.o(104244);
  }
  
  private void Kc()
  {
    AppMethodBeat.i(104245);
    this.chatroomName = getIntent().getStringExtra("room_name");
    ab.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    g.RK().eHt.a(519, this);
    this.efi = ((c)g.E(c.class)).YJ().oU(this.chatroomName);
    if (this.efi == null)
    {
      finish();
      AppMethodBeat.o(104245);
      return;
    }
    this.eic = r.Zn().equals(this.efi.field_roomowner);
    if (!aa.dsD()) {}
    for (boolean bool = true;; bool = false)
    {
      this.eid = bool;
      AppMethodBeat.o(104245);
      return;
    }
  }
  
  private void Kd()
  {
    AppMethodBeat.i(104251);
    lb(this.efi.field_roomowner);
    int i = this.efi.dwr();
    this.ehS.setVisibility(0);
    if (i <= 40)
    {
      this.ehS.setText(getString(2131302810, new Object[] { getString(2131302804) }));
      AppMethodBeat.o(104251);
      return;
    }
    this.ehS.setText(getString(2131302810, new Object[] { getString(2131302803) }));
    AppMethodBeat.o(104251);
  }
  
  private String kW(String paramString)
  {
    AppMethodBeat.i(104254);
    if (this.efi == null)
    {
      AppMethodBeat.o(104254);
      return null;
    }
    paramString = this.efi.nE(paramString);
    AppMethodBeat.o(104254);
    return paramString;
  }
  
  private void la(String paramString)
  {
    AppMethodBeat.i(104253);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if ((localad != null) && ((int)localad.euF > 0)) {}
    for (Object localObject2 = localad.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = kW(paramString);
      }
      localObject2 = localObject1;
      if (bo.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localad != null)
        {
          localObject2 = localObject1;
          if ((int)localad.euF > 0) {
            localObject2 = localad.Oe();
          }
        }
      }
      localObject1 = localObject2;
      if (bo.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.ehQ, paramString);
      this.ehR.setVisibility(0);
      this.ehR.setText(com.tencent.mm.pluginsdk.ui.d.j.b(this, (CharSequence)localObject1, (int)this.ehR.getTextSize()));
      AppMethodBeat.o(104253);
      return;
    }
  }
  
  private void lb(final String paramString)
  {
    AppMethodBeat.i(104252);
    ad localad = ((com.tencent.mm.plugin.messenger.foundation.a.j)g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arw(paramString);
    if ((localad != null) && ((int)localad.euF <= 0))
    {
      ao.a.flI.a(paramString, this.chatroomName, new ao.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(104239);
          if (paramAnonymousBoolean) {
            RoomUpgradeUI.g(RoomUpgradeUI.this).post(new RoomUpgradeUI.4.1(this));
          }
          AppMethodBeat.o(104239);
        }
      });
      AppMethodBeat.o(104252);
      return;
    }
    la(paramString);
    AppMethodBeat.o(104252);
  }
  
  public int getLayoutId()
  {
    return 2130969027;
  }
  
  public void initView()
  {
    AppMethodBeat.i(104246);
    setMMTitle(2131302802);
    setBackBtn(new RoomUpgradeUI.1(this));
    this.ehP = findViewById(2131822429);
    this.ehY = findViewById(2131822432);
    this.ehQ = ((ImageView)findViewById(2131822430));
    this.ehR = ((TextView)findViewById(2131822431));
    this.ehS = ((TextView)findViewById(2131822433));
    this.ehT = ((TextView)findViewById(2131822435));
    this.ehZ = ((TextView)findViewById(2131822434));
    this.ehZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(104236);
        switch (RoomUpgradeUI.a(RoomUpgradeUI.this))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(104236);
          return;
          if (RoomUpgradeUI.b(RoomUpgradeUI.this))
          {
            b.a(RoomUpgradeUI.this, RoomUpgradeUI.c(RoomUpgradeUI.this), true);
            AppMethodBeat.o(104236);
            return;
          }
          RoomUpgradeUI.a(RoomUpgradeUI.this, true);
          AppMethodBeat.o(104236);
          return;
          if (RoomUpgradeUI.b(RoomUpgradeUI.this))
          {
            RoomUpgradeUI.d(RoomUpgradeUI.this);
            AppMethodBeat.o(104236);
            return;
          }
          RoomUpgradeUI.a(RoomUpgradeUI.this, false);
        }
      }
    });
    this.ehX = ((TextView)findViewById(2131822436));
    this.ehX.setOnClickListener(new RoomUpgradeUI.3(this));
    if (this.eic)
    {
      this.eeN = h.b(this, getString(2131301086), true, new RoomUpgradeUI.5(this));
      this.eia = new com.tencent.mm.chatroom.c.j(this.chatroomName);
      g.RK().eHt.a(this.eia, 0);
    }
    for (;;)
    {
      if (this.eid) {
        this.ehX.setVisibility(8);
      }
      AppMethodBeat.o(104246);
      return;
      Kd();
      if (!this.eid) {
        this.ehX.setVisibility(0);
      }
      this.ehX.setText(2131302805);
      this.ehZ.setVisibility(8);
      this.ehT.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(104256);
    ab.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      ab.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
      AppMethodBeat.o(104256);
      return;
    }
    finish();
    AppMethodBeat.o(104256);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(104242);
    super.onCreate(paramBundle);
    Kc();
    initView();
    AppMethodBeat.o(104242);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(104249);
    g.RK().eHt.a(this.eia);
    g.RK().eHt.b(519, this);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(104249);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(104243);
    boolean bool;
    if (paramIntent.hasExtra("upgrade_success"))
    {
      bool = paramIntent.getBooleanExtra("upgrade_success", false);
      if (!bool) {
        break label189;
      }
      Kc();
      int i = paramIntent.getIntExtra("left_quota", 0);
      Kd();
      this.ehZ.setVisibility(8);
      this.eex = i;
      if (this.eex <= 0) {
        break label172;
      }
      this.ehT.setText(getString(2131302808, new Object[] { Integer.valueOf(this.eex) }));
    }
    for (;;)
    {
      if (!this.eid) {
        this.ehX.setVisibility(0);
      }
      this.ehX.setText(2131302805);
      AppMethodBeat.o(104243);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        Kb();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        Kb();
      }
      bool = false;
      break;
      label172:
      this.ehT.setText(getString(2131302809));
    }
    label189:
    AppMethodBeat.o(104243);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(104248);
    super.onPause();
    AppMethodBeat.o(104248);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(104247);
    super.onResume();
    AppMethodBeat.o(104247);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(104257);
    ab.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.eeN != null) {
      this.eeN.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.a(this, getString(2131302807), getString(2131297087), false, new RoomUpgradeUI.6(this));
      AppMethodBeat.o(104257);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramm.getType() == 519))
    {
      paramString = (com.tencent.mm.chatroom.c.j)paramm;
      this.status = paramString.status;
      this.eew = paramString.eew;
      this.eex = paramString.eex;
      Kd();
      this.ehT.setVisibility(0);
      this.ehZ.setText(getString(2131302801));
      if (this.eex <= 0) {
        break label283;
      }
      this.ehT.setText(getString(2131302808, new Object[] { Integer.valueOf(this.eex) }));
      if (!this.eid) {
        this.ehX.setVisibility(0);
      }
      switch (this.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(104257);
      return;
      label283:
      this.ehT.setText(getString(2131302809));
      break;
      this.ehZ.setVisibility(0);
      this.ehX.setText(2131302806);
      AppMethodBeat.o(104257);
      return;
      this.ehZ.setVisibility(0);
      this.ehZ.setEnabled(false);
      this.ehX.setText(2131302806);
      AppMethodBeat.o(104257);
      return;
      this.ehZ.setVisibility(8);
      this.ehX.setText(2131302805);
      this.ehZ.setEnabled(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI
 * JD-Core Version:    0.7.0.1
 */