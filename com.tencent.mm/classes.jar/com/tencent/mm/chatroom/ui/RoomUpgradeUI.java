package com.tencent.mm.chatroom.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.contact.d;
import com.tencent.mm.f.c.ax;
import com.tencent.mm.model.aq;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;

public class RoomUpgradeUI
  extends MMActivity
  implements i
{
  private String chatroomName;
  private int iWq;
  private int iWr;
  private ProgressDialog iXX = null;
  private ah iXp;
  private View jiN;
  private ImageView jiO;
  private TextView jiP;
  private TextView jiQ;
  private TextView jiR;
  private TextView jiV;
  private View jiW;
  private TextView jiX;
  private m jiY;
  private String jiZ;
  private boolean jja;
  private boolean jjb;
  private int status;
  
  private void KB(String paramString)
  {
    AppMethodBeat.i(12797);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((localas != null) && ((int)localas.jxt > 0)) {}
    for (Object localObject2 = localas.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = Ky(paramString);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localas != null)
        {
          localObject2 = localObject1;
          if ((int)localas.jxt > 0) {
            localObject2 = localas.ayr();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.jiO, paramString);
      this.jiP.setVisibility(0);
      this.jiP.setText(l.d(this, (CharSequence)localObject1, (int)this.jiP.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void KC(final String paramString)
  {
    AppMethodBeat.i(12796);
    as localas = ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().RG(paramString);
    if ((localas != null) && ((int)localas.jxt <= 0))
    {
      az.a.ltq.a(paramString, this.chatroomName, new az.b.a()
      {
        public final void s(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12784);
          if (paramAnonymousBoolean) {
            RoomUpgradeUI.g(RoomUpgradeUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12783);
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.jiT);
                AppMethodBeat.o(12783);
              }
            });
          }
          AppMethodBeat.o(12784);
        }
      });
      AppMethodBeat.o(12796);
      return;
    }
    KB(paramString);
    AppMethodBeat.o(12796);
  }
  
  private String Ky(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.iXp == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.iXp.PJ(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void asZ()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void ata()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    Log.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    com.tencent.mm.kernel.h.aHF().kcd.a(519, this);
    this.iXp = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ae(com.tencent.mm.plugin.chatroom.a.b.class)).bbV().Rw(this.chatroomName);
    if (this.iXp == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.jja = z.bcZ().equals(this.iXp.field_roomowner);
    if (!LocaleUtil.isSimplifiedChineseAppLang()) {}
    for (boolean bool = true;; bool = false)
    {
      this.jjb = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void atb()
  {
    AppMethodBeat.i(12795);
    KC(this.iXp.field_roomowner);
    int i = this.iXp.hxH();
    this.jiQ.setVisibility(0);
    if (i <= 40)
    {
      this.jiQ.setText(getString(a.i.jgT, new Object[] { getString(a.i.jgN) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.jiQ.setText(getString(a.i.jgT, new Object[] { getString(a.i.jgM) }));
    AppMethodBeat.o(12795);
  }
  
  public int getLayoutId()
  {
    return a.f.jea;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12791);
    setMMTitle(a.i.jgL);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(12780);
        RoomUpgradeUI.this.finish();
        AppMethodBeat.o(12780);
        return true;
      }
    });
    this.jiN = findViewById(a.e.jdM);
    this.jiW = findViewById(a.e.jdO);
    this.jiO = ((ImageView)findViewById(a.e.jdL));
    this.jiP = ((TextView)findViewById(a.e.jdN));
    this.jiQ = ((TextView)findViewById(a.e.jdJ));
    this.jiR = ((TextView)findViewById(a.e.jdK));
    this.jiX = ((TextView)findViewById(a.e.jdI));
    this.jiX.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        switch (RoomUpgradeUI.a(RoomUpgradeUI.this))
        {
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(12781);
          return;
          if (RoomUpgradeUI.b(RoomUpgradeUI.this))
          {
            b.a(RoomUpgradeUI.this, RoomUpgradeUI.c(RoomUpgradeUI.this), true);
          }
          else
          {
            RoomUpgradeUI.a(RoomUpgradeUI.this, true);
            continue;
            if (RoomUpgradeUI.b(RoomUpgradeUI.this)) {
              RoomUpgradeUI.d(RoomUpgradeUI.this);
            } else {
              RoomUpgradeUI.a(RoomUpgradeUI.this, false);
            }
          }
        }
      }
    });
    this.jiV = ((TextView)findViewById(a.e.jcJ));
    this.jiV.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", z.bcZ());
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.by.c.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12782);
      }
    });
    if (this.jja)
    {
      this.iXX = com.tencent.mm.ui.base.h.a(this, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            com.tencent.mm.kernel.h.aHF().kcd.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.jiY = new m(this.chatroomName);
      com.tencent.mm.kernel.h.aHF().kcd.a(this.jiY, 0);
    }
    for (;;)
    {
      if (this.jjb) {
        this.jiV.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      atb();
      if (!this.jjb) {
        this.jiV.setVisibility(0);
      }
      this.jiV.setText(a.i.jgO);
      this.jiX.setVisibility(8);
      this.jiR.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12799);
    Log.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      Log.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
      AppMethodBeat.o(12799);
      return;
    }
    finish();
    AppMethodBeat.o(12799);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(12787);
    super.onCreate(paramBundle);
    ata();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    com.tencent.mm.kernel.h.aHF().kcd.a(this.jiY);
    com.tencent.mm.kernel.h.aHF().kcd.b(519, this);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    super.onDestroy();
    AppMethodBeat.o(12794);
  }
  
  public void onNewIntent(Intent paramIntent)
  {
    AppMethodBeat.i(12788);
    boolean bool;
    if (paramIntent.hasExtra("upgrade_success"))
    {
      bool = paramIntent.getBooleanExtra("upgrade_success", false);
      if (!bool) {
        break label189;
      }
      ata();
      int i = paramIntent.getIntExtra("left_quota", 0);
      atb();
      this.jiX.setVisibility(8);
      this.iWr = i;
      if (this.iWr <= 0) {
        break label172;
      }
      this.jiR.setText(getString(a.i.jgR, new Object[] { Integer.valueOf(this.iWr) }));
    }
    for (;;)
    {
      if (!this.jjb) {
        this.jiV.setVisibility(0);
      }
      this.jiV.setText(a.i.jgO);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        asZ();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        asZ();
      }
      bool = false;
      break;
      label172:
      this.jiR.setText(getString(a.i.jgS));
    }
    label189:
    AppMethodBeat.o(12788);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(12793);
    super.onPause();
    AppMethodBeat.o(12793);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(12792);
    super.onResume();
    AppMethodBeat.o(12792);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(12800);
    Log.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.iXX != null) {
      this.iXX.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      com.tencent.mm.ui.base.h.a(this, getString(a.i.jgQ), getString(a.i.app_tip), false, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(12786);
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12786);
        }
      });
      AppMethodBeat.o(12800);
      return;
    }
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramq.getType() == 519))
    {
      paramString = (m)paramq;
      this.status = paramString.status;
      this.iWq = paramString.iWq;
      this.iWr = paramString.iWr;
      atb();
      this.jiR.setVisibility(0);
      this.jiX.setText(getString(a.i.jgK));
      if (this.iWr <= 0) {
        break label283;
      }
      this.jiR.setText(getString(a.i.jgR, new Object[] { Integer.valueOf(this.iWr) }));
      if (!this.jjb) {
        this.jiV.setVisibility(0);
      }
      switch (this.status)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(12800);
      return;
      label283:
      this.jiR.setText(getString(a.i.jgS));
      break;
      this.jiX.setVisibility(0);
      this.jiV.setText(a.i.jgP);
      AppMethodBeat.o(12800);
      return;
      this.jiX.setVisibility(0);
      this.jiX.setEnabled(false);
      this.jiV.setText(a.i.jgP);
      AppMethodBeat.o(12800);
      return;
      this.jiX.setVisibility(8);
      this.jiV.setText(a.i.jgO);
      this.jiX.setEnabled(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI
 * JD-Core Version:    0.7.0.1
 */