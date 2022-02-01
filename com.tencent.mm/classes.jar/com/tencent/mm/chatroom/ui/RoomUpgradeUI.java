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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.as.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.am;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements f
{
  private String chatroomName;
  private int fKR;
  private int fKS;
  private ab fLO;
  private ProgressDialog fMu = null;
  private TextView fRA;
  private TextView fRB;
  private TextView fRF;
  private View fRG;
  private TextView fRH;
  private m fRI;
  private String fRJ;
  private boolean fRK;
  private boolean fRL;
  private View fRx;
  private ImageView fRy;
  private TextView fRz;
  private int status;
  
  private void Zc()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void Zd()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    ad.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    g.ajB().gAO.a(519, this);
    this.fLO = ((c)g.ab(c.class)).azz().AN(this.chatroomName);
    if (this.fLO == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.fRK = u.aAm().equals(this.fLO.field_roomowner);
    if (!ac.fkp()) {}
    for (boolean bool = true;; bool = false)
    {
      this.fRL = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void Ze()
  {
    AppMethodBeat.i(12795);
    uY(this.fLO.field_roomowner);
    int i = this.fLO.fpQ();
    this.fRA.setVisibility(0);
    if (i <= 40)
    {
      this.fRA.setText(getString(2131762722, new Object[] { getString(2131762716) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.fRA.setText(getString(2131762722, new Object[] { getString(2131762715) }));
    AppMethodBeat.o(12795);
  }
  
  private String uU(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.fLO == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.fLO.zf(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void uX(String paramString)
  {
    AppMethodBeat.i(12797);
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    if ((localam != null) && ((int)localam.gfj > 0)) {}
    for (Object localObject2 = localam.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = uU(paramString);
      }
      localObject2 = localObject1;
      if (bt.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localam != null)
        {
          localObject2 = localObject1;
          if ((int)localam.gfj > 0) {
            localObject2 = localam.adu();
          }
        }
      }
      localObject1 = localObject2;
      if (bt.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.fRy, paramString);
      this.fRz.setVisibility(0);
      this.fRz.setText(k.b(this, (CharSequence)localObject1, (int)this.fRz.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void uY(final String paramString)
  {
    AppMethodBeat.i(12796);
    am localam = ((l)g.ab(l.class)).azp().Bf(paramString);
    if ((localam != null) && ((int)localam.gfj <= 0))
    {
      as.a.hFO.a(paramString, this.chatroomName, new as.b.a()
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
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.fRD);
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
    uX(paramString);
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
    this.fRx = findViewById(2131306214);
    this.fRG = findViewById(2131306216);
    this.fRy = ((ImageView)findViewById(2131306213));
    this.fRz = ((TextView)findViewById(2131306215));
    this.fRA = ((TextView)findViewById(2131306210));
    this.fRB = ((TextView)findViewById(2131306211));
    this.fRH = ((TextView)findViewById(2131306209));
    this.fRH.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
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
    this.fRF = ((TextView)findViewById(2131300766));
    this.fRF.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(2131757097, new Object[] { ac.fks() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", u.aAm());
          paramAnonymousView.putExtra("showShare", false);
          d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12782);
      }
    });
    if (this.fRK)
    {
      this.fMu = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            g.ajB().gAO.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.fRI = new m(this.chatroomName);
      g.ajB().gAO.a(this.fRI, 0);
    }
    for (;;)
    {
      if (this.fRL) {
        this.fRF.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      Ze();
      if (!this.fRL) {
        this.fRF.setVisibility(0);
      }
      this.fRF.setText(2131762717);
      this.fRH.setVisibility(8);
      this.fRB.setVisibility(8);
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
    Zd();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    g.ajB().gAO.a(this.fRI);
    g.ajB().gAO.b(519, this);
    if (this.fMu != null) {
      this.fMu.dismiss();
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
      Zd();
      int i = paramIntent.getIntExtra("left_quota", 0);
      Ze();
      this.fRH.setVisibility(8);
      this.fKS = i;
      if (this.fKS <= 0) {
        break label172;
      }
      this.fRB.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fKS) }));
    }
    for (;;)
    {
      if (!this.fRL) {
        this.fRF.setVisibility(0);
      }
      this.fRF.setText(2131762717);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        Zc();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        Zc();
      }
      bool = false;
      break;
      label172:
      this.fRB.setText(getString(2131762721));
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
    if (this.fMu != null) {
      this.fMu.dismiss();
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
      this.fKR = paramString.fKR;
      this.fKS = paramString.fKS;
      Ze();
      this.fRB.setVisibility(0);
      this.fRH.setText(getString(2131762713));
      if (this.fKS <= 0) {
        break label283;
      }
      this.fRB.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fKS) }));
      if (!this.fRL) {
        this.fRF.setVisibility(0);
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
      this.fRB.setText(getString(2131762721));
      break;
      this.fRH.setVisibility(0);
      this.fRF.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fRH.setVisibility(0);
      this.fRH.setEnabled(false);
      this.fRF.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fRH.setVisibility(8);
      this.fRF.setText(2131762717);
      this.fRH.setEnabled(false);
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