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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.al;
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.au.b.a;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.ac;
import com.tencent.mm.storage.an;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements f
{
  private String chatroomName;
  private int fMU;
  private int fMV;
  private ac fNS;
  private ProgressDialog fOC = null;
  private View fTD;
  private ImageView fTE;
  private TextView fTF;
  private TextView fTG;
  private TextView fTH;
  private TextView fTL;
  private View fTM;
  private TextView fTN;
  private m fTO;
  private String fTP;
  private boolean fTQ;
  private boolean fTR;
  private int status;
  
  private void Zl()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahE(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mt(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void Zm()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    ae.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    g.ajQ().gDv.a(519, this);
    this.fNS = ((com.tencent.mm.plugin.chatroom.a.c)g.ab(com.tencent.mm.plugin.chatroom.a.c.class)).azP().Bx(this.chatroomName);
    if (this.fNS == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.fTQ = v.aAC().equals(this.fNS.field_roomowner);
    if (!ad.foj()) {}
    for (boolean bool = true;; bool = false)
    {
      this.fTR = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void Zn()
  {
    AppMethodBeat.i(12795);
    vu(this.fNS.field_roomowner);
    int i = this.fNS.ftQ();
    this.fTG.setVisibility(0);
    if (i <= 40)
    {
      this.fTG.setText(getString(2131762722, new Object[] { getString(2131762716) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.fTG.setText(getString(2131762722, new Object[] { getString(2131762715) }));
    AppMethodBeat.o(12795);
  }
  
  private String vq(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.fNS == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.fNS.zP(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void vt(String paramString)
  {
    AppMethodBeat.i(12797);
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    if ((localan != null) && ((int)localan.ght > 0)) {}
    for (Object localObject2 = localan.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = vq(paramString);
      }
      localObject2 = localObject1;
      if (bu.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localan != null)
        {
          localObject2 = localObject1;
          if ((int)localan.ght > 0) {
            localObject2 = localan.adF();
          }
        }
      }
      localObject1 = localObject2;
      if (bu.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.fTE, paramString);
      this.fTF.setVisibility(0);
      this.fTF.setText(k.b(this, (CharSequence)localObject1, (int)this.fTF.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void vu(final String paramString)
  {
    AppMethodBeat.i(12796);
    an localan = ((l)g.ab(l.class)).azF().BH(paramString);
    if ((localan != null) && ((int)localan.ght <= 0))
    {
      au.a.hIG.a(paramString, this.chatroomName, new au.b.a()
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
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.fTJ);
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
    vt(paramString);
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
    this.fTD = findViewById(2131306214);
    this.fTM = findViewById(2131306216);
    this.fTE = ((ImageView)findViewById(2131306213));
    this.fTF = ((TextView)findViewById(2131306215));
    this.fTG = ((TextView)findViewById(2131306210));
    this.fTH = ((TextView)findViewById(2131306211));
    this.fTN = ((TextView)findViewById(2131306209));
    this.fTN.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
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
    this.fTL = ((TextView)findViewById(2131300766));
    this.fTL.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(2131757097, new Object[] { ad.fom() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", v.aAC());
          paramAnonymousView.putExtra("showShare", false);
          d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12782);
      }
    });
    if (this.fTQ)
    {
      this.fOC = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            g.ajQ().gDv.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.fTO = new m(this.chatroomName);
      g.ajQ().gDv.a(this.fTO, 0);
    }
    for (;;)
    {
      if (this.fTR) {
        this.fTL.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      Zn();
      if (!this.fTR) {
        this.fTL.setVisibility(0);
      }
      this.fTL.setText(2131762717);
      this.fTN.setVisibility(8);
      this.fTH.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12799);
    ae.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      ae.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
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
    Zm();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    g.ajQ().gDv.a(this.fTO);
    g.ajQ().gDv.b(519, this);
    if (this.fOC != null) {
      this.fOC.dismiss();
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
      Zm();
      int i = paramIntent.getIntExtra("left_quota", 0);
      Zn();
      this.fTN.setVisibility(8);
      this.fMV = i;
      if (this.fMV <= 0) {
        break label172;
      }
      this.fTH.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fMV) }));
    }
    for (;;)
    {
      if (!this.fTR) {
        this.fTL.setVisibility(0);
      }
      this.fTL.setText(2131762717);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        Zl();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        Zl();
      }
      bool = false;
      break;
      label172:
      this.fTH.setText(getString(2131762721));
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
    ae.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fOC != null) {
      this.fOC.dismiss();
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
      this.fMU = paramString.fMU;
      this.fMV = paramString.fMV;
      Zn();
      this.fTH.setVisibility(0);
      this.fTN.setText(getString(2131762713));
      if (this.fMV <= 0) {
        break label283;
      }
      this.fTH.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fMV) }));
      if (!this.fTR) {
        this.fTL.setVisibility(0);
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
      this.fTH.setText(getString(2131762721));
      break;
      this.fTN.setVisibility(0);
      this.fTL.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fTN.setVisibility(0);
      this.fTN.setEnabled(false);
      this.fTL.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fTN.setVisibility(8);
      this.fTL.setText(2131762717);
      this.fTN.setEnabled(false);
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