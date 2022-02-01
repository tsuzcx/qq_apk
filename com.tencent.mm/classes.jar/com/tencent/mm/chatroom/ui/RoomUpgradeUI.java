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
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.af;
import com.tencent.mm.storage.bg;
import com.tencent.mm.storage.w;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements com.tencent.mm.al.g
{
  private String chatroomName;
  private int foS;
  private int foT;
  private ProgressDialog fpP = null;
  private w fql;
  private View fuD;
  private ImageView fuE;
  private TextView fuF;
  private TextView fuG;
  private TextView fuH;
  private TextView fuL;
  private View fuM;
  private TextView fuN;
  private m fuO;
  private String fuP;
  private boolean fuQ;
  private boolean fuR;
  private int status;
  
  private void VK()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bd(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).adn(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lS(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void VL()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    ad.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    com.tencent.mm.kernel.g.afA().gcy.a(519, this);
    this.fql = ((c)com.tencent.mm.kernel.g.ab(c.class)).apV().tH(this.chatroomName);
    if (this.fql == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.fuQ = u.aqG().equals(this.fql.field_roomowner);
    if (!ac.eFr()) {}
    for (boolean bool = true;; bool = false)
    {
      this.fuR = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void VM()
  {
    AppMethodBeat.i(12795);
    oX(this.fql.field_roomowner);
    int i = this.fql.eKr();
    this.fuG.setVisibility(0);
    if (i <= 40)
    {
      this.fuG.setText(getString(2131762722, new Object[] { getString(2131762716) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.fuG.setText(getString(2131762722, new Object[] { getString(2131762715) }));
    AppMethodBeat.o(12795);
  }
  
  private String oS(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.fql == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.fql.sh(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void oW(String paramString)
  {
    AppMethodBeat.i(12797);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((localaf != null) && ((int)localaf.fId > 0)) {}
    for (Object localObject2 = localaf.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = oS(paramString);
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localaf != null)
        {
          localObject2 = localObject1;
          if ((int)localaf.fId > 0) {
            localObject2 = localaf.ZW();
          }
        }
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.fuE, paramString);
      this.fuF.setVisibility(0);
      this.fuF.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, (int)this.fuF.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void oX(final String paramString)
  {
    AppMethodBeat.i(12796);
    af localaf = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHY(paramString);
    if ((localaf != null) && ((int)localaf.fId <= 0))
    {
      ar.a.gMW.a(paramString, this.chatroomName, new ar.b.a()
      {
        public final void p(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12784);
          if (paramAnonymousBoolean) {
            RoomUpgradeUI.g(RoomUpgradeUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12783);
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.fuJ);
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
    oW(paramString);
    AppMethodBeat.o(12796);
  }
  
  public int getLayoutId()
  {
    return 2131493381;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12791);
    setMMTitle(2131762714);
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
    this.fuD = findViewById(2131306214);
    this.fuM = findViewById(2131306216);
    this.fuE = ((ImageView)findViewById(2131306213));
    this.fuF = ((TextView)findViewById(2131306215));
    this.fuG = ((TextView)findViewById(2131306210));
    this.fuH = ((TextView)findViewById(2131306211));
    this.fuN = ((TextView)findViewById(2131306209));
    this.fuN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        switch (RoomUpgradeUI.a(RoomUpgradeUI.this))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(12781);
          return;
          if (RoomUpgradeUI.b(RoomUpgradeUI.this))
          {
            b.a(RoomUpgradeUI.this, RoomUpgradeUI.c(RoomUpgradeUI.this), true);
            AppMethodBeat.o(12781);
            return;
          }
          RoomUpgradeUI.a(RoomUpgradeUI.this, true);
          AppMethodBeat.o(12781);
          return;
          if (RoomUpgradeUI.b(RoomUpgradeUI.this))
          {
            RoomUpgradeUI.d(RoomUpgradeUI.this);
            AppMethodBeat.o(12781);
            return;
          }
          RoomUpgradeUI.a(RoomUpgradeUI.this, false);
        }
      }
    });
    this.fuL = ((TextView)findViewById(2131300766));
    this.fuL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(2131757097, new Object[] { ac.eFu() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", u.aqG());
          paramAnonymousView.putExtra("showShare", false);
          d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        AppMethodBeat.o(12782);
      }
    });
    if (this.fuQ)
    {
      this.fpP = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            com.tencent.mm.kernel.g.afA().gcy.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.fuO = new m(this.chatroomName);
      com.tencent.mm.kernel.g.afA().gcy.a(this.fuO, 0);
    }
    for (;;)
    {
      if (this.fuR) {
        this.fuL.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      VM();
      if (!this.fuR) {
        this.fuL.setVisibility(0);
      }
      this.fuL.setText(2131762717);
      this.fuN.setVisibility(8);
      this.fuH.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12799);
    ad.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      ad.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
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
    VL();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    com.tencent.mm.kernel.g.afA().gcy.a(this.fuO);
    com.tencent.mm.kernel.g.afA().gcy.b(519, this);
    if (this.fpP != null) {
      this.fpP.dismiss();
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
      VL();
      int i = paramIntent.getIntExtra("left_quota", 0);
      VM();
      this.fuN.setVisibility(8);
      this.foT = i;
      if (this.foT <= 0) {
        break label172;
      }
      this.fuH.setText(getString(2131762720, new Object[] { Integer.valueOf(this.foT) }));
    }
    for (;;)
    {
      if (!this.fuR) {
        this.fuL.setVisibility(0);
      }
      this.fuL.setText(2131762717);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        VK();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        VK();
      }
      bool = false;
      break;
      label172:
      this.fuH.setText(getString(2131762721));
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(12800);
    ad.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fpP != null) {
      this.fpP.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.a(this, getString(2131762719), getString(2131755906), false, new DialogInterface.OnClickListener()
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramn.getType() == 519))
    {
      paramString = (m)paramn;
      this.status = paramString.status;
      this.foS = paramString.foS;
      this.foT = paramString.foT;
      VM();
      this.fuH.setVisibility(0);
      this.fuN.setText(getString(2131762713));
      if (this.foT <= 0) {
        break label283;
      }
      this.fuH.setText(getString(2131762720, new Object[] { Integer.valueOf(this.foT) }));
      if (!this.fuR) {
        this.fuL.setVisibility(0);
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
      this.fuH.setText(getString(2131762721));
      break;
      this.fuN.setVisibility(0);
      this.fuL.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fuN.setVisibility(0);
      this.fuN.setEnabled(false);
      this.fuL.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fuN.setVisibility(8);
      this.fuL.setText(2131762717);
      this.fuN.setEnabled(false);
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