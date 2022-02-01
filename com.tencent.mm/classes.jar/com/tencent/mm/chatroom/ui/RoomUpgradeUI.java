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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ap;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.ay.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ah;
import com.tencent.mm.storage.as;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements i
{
  private String chatroomName;
  private int gsf;
  private int gsg;
  private ProgressDialog gtM = null;
  private ah gtd;
  private View gyK;
  private ImageView gyL;
  private TextView gyM;
  private TextView gyN;
  private TextView gyO;
  private TextView gyS;
  private View gyT;
  private TextView gyU;
  private m gyV;
  private String gyW;
  private boolean gyX;
  private boolean gyY;
  private int status;
  
  private String DH(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.gtd == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.gtd.getDisplayName(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void DK(String paramString)
  {
    AppMethodBeat.i(12797);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((localas != null) && ((int)localas.gMZ > 0)) {}
    for (Object localObject2 = localas.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = DH(paramString);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localas != null)
        {
          localObject2 = localObject1;
          if ((int)localas.gMZ > 0) {
            localObject2 = localas.arI();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.gyL, paramString);
      this.gyM.setVisibility(0);
      this.gyM.setText(com.tencent.mm.pluginsdk.ui.span.l.e(this, (CharSequence)localObject1, (int)this.gyM.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void DL(final String paramString)
  {
    AppMethodBeat.i(12796);
    as localas = ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().Kn(paramString);
    if ((localas != null) && ((int)localas.gMZ <= 0))
    {
      ay.a.iDq.a(paramString, this.chatroomName, new ay.b.a()
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
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.gyQ);
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
    DK(paramString);
    AppMethodBeat.o(12796);
  }
  
  private void amY()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void amZ()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    Log.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    g.aAg().hqi.a(519, this);
    this.gtd = ((com.tencent.mm.plugin.chatroom.a.c)g.af(com.tencent.mm.plugin.chatroom.a.c.class)).aSX().Kd(this.chatroomName);
    if (this.gtd == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.gyX = z.aTY().equals(this.gtd.field_roomowner);
    if (!LocaleUtil.isSimplifiedChineseAppLang()) {}
    for (boolean bool = true;; bool = false)
    {
      this.gyY = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void ana()
  {
    AppMethodBeat.i(12795);
    DL(this.gtd.field_roomowner);
    int i = this.gtd.gBw();
    this.gyN.setVisibility(0);
    if (i <= 40)
    {
      this.gyN.setText(getString(2131764805, new Object[] { getString(2131764799) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.gyN.setText(getString(2131764805, new Object[] { getString(2131764798) }));
    AppMethodBeat.o(12795);
  }
  
  public int getLayoutId()
  {
    return 2131493475;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12791);
    setMMTitle(2131764797);
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
    this.gyK = findViewById(2131309613);
    this.gyT = findViewById(2131309615);
    this.gyL = ((ImageView)findViewById(2131309612));
    this.gyM = ((TextView)findViewById(2131309614));
    this.gyN = ((TextView)findViewById(2131309609));
    this.gyO = ((TextView)findViewById(2131309610));
    this.gyU = ((TextView)findViewById(2131309608));
    this.gyU.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
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
    this.gyS = ((TextView)findViewById(2131302360));
    this.gyS.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(2131757298, new Object[] { LocaleUtil.getApplicationLanguage() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", z.aTY());
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.c.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12782);
      }
    });
    if (this.gyX)
    {
      this.gtM = h.a(this, getString(2131762446), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            g.aAg().hqi.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.gyV = new m(this.chatroomName);
      g.aAg().hqi.a(this.gyV, 0);
    }
    for (;;)
    {
      if (this.gyY) {
        this.gyS.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      ana();
      if (!this.gyY) {
        this.gyS.setVisibility(0);
      }
      this.gyS.setText(2131764800);
      this.gyU.setVisibility(8);
      this.gyO.setVisibility(8);
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
    amZ();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    g.aAg().hqi.a(this.gyV);
    g.aAg().hqi.b(519, this);
    if (this.gtM != null) {
      this.gtM.dismiss();
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
      amZ();
      int i = paramIntent.getIntExtra("left_quota", 0);
      ana();
      this.gyU.setVisibility(8);
      this.gsg = i;
      if (this.gsg <= 0) {
        break label172;
      }
      this.gyO.setText(getString(2131764803, new Object[] { Integer.valueOf(this.gsg) }));
    }
    for (;;)
    {
      if (!this.gyY) {
        this.gyS.setVisibility(0);
      }
      this.gyS.setText(2131764800);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        amY();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        amY();
      }
      bool = false;
      break;
      label172:
      this.gyO.setText(getString(2131764804));
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
    if (this.gtM != null) {
      this.gtM.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      h.a(this, getString(2131764802), getString(2131755998), false, new DialogInterface.OnClickListener()
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
      this.gsf = paramString.gsf;
      this.gsg = paramString.gsg;
      ana();
      this.gyO.setVisibility(0);
      this.gyU.setText(getString(2131764796));
      if (this.gsg <= 0) {
        break label283;
      }
      this.gyO.setText(getString(2131764803, new Object[] { Integer.valueOf(this.gsg) }));
      if (!this.gyY) {
        this.gyS.setVisibility(0);
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
      this.gyO.setText(getString(2131764804));
      break;
      this.gyU.setVisibility(0);
      this.gyS.setText(2131764801);
      AppMethodBeat.o(12800);
      return;
      this.gyU.setVisibility(0);
      this.gyU.setEnabled(false);
      this.gyS.setText(2131764801);
      AppMethodBeat.o(12800);
      return;
      this.gyU.setVisibility(8);
      this.gyS.setText(2131764800);
      this.gyU.setEnabled(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI
 * JD-Core Version:    0.7.0.1
 */