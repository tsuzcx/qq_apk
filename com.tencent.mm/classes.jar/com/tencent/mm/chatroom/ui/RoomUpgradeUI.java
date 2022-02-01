package com.tencent.mm.chatroom.ui;

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
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.model.ar;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.az.b.a;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;

public class RoomUpgradeUI
  extends MMActivity
  implements com.tencent.mm.am.h
{
  private String chatroomName;
  private TextView lLA;
  private View lLB;
  private TextView lLC;
  private com.tencent.mm.chatroom.d.p lLD;
  private String lLE;
  private boolean lLF;
  private boolean lLG;
  private View lLs;
  private ImageView lLt;
  private TextView lLu;
  private TextView lLv;
  private TextView lLw;
  private int lyt;
  private int lyu;
  private ProgressDialog lzP = null;
  private aj lzy;
  private int status;
  
  private String Dd(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.lzy == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.lzy.getDisplayName(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void Dh(String paramString)
  {
    AppMethodBeat.i(12797);
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((localau != null) && ((int)localau.maN > 0)) {}
    for (Object localObject2 = localau.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = Dd(paramString);
      }
      localObject2 = localObject1;
      if (Util.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localau != null)
        {
          localObject2 = localObject1;
          if ((int)localau.maN > 0) {
            localObject2 = localau.aSU();
          }
        }
      }
      localObject1 = localObject2;
      if (Util.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.g(this.lLt, paramString);
      this.lLu.setVisibility(0);
      this.lLu.setText(com.tencent.mm.pluginsdk.ui.span.p.d(this, (CharSequence)localObject1, (int)this.lLu.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void Di(final String paramString)
  {
    AppMethodBeat.i(12796);
    au localau = ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().JE(paramString);
    if ((localau != null) && ((int)localau.maN <= 0))
    {
      az.a.okP.a(paramString, this.chatroomName, new az.b.a()
      {
        public final void getContactCallBack(String paramAnonymousString, boolean paramAnonymousBoolean)
        {
          AppMethodBeat.i(12784);
          if (paramAnonymousBoolean) {
            RoomUpgradeUI.g(RoomUpgradeUI.this).post(new Runnable()
            {
              public final void run()
              {
                AppMethodBeat.i(12783);
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.lLy);
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
    Dh(paramString);
    AppMethodBeat.o(12796);
  }
  
  private void aNh()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
    com.tencent.mm.hellhoundlib.a.a.b(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
    com.tencent.mm.hellhoundlib.a.a.c(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void aNi()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    Log.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    com.tencent.mm.kernel.h.baD().mCm.a(519, this);
    this.lzy = ((com.tencent.mm.plugin.chatroom.a.b)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.chatroom.a.b.class)).bzK().Ju(this.chatroomName);
    if (this.lzy == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.lLF = z.bAM().equals(this.lzy.field_roomowner);
    if (!LocaleUtil.isSimplifiedChineseAppLang()) {}
    for (boolean bool = true;; bool = false)
    {
      this.lLG = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void aNj()
  {
    AppMethodBeat.i(12795);
    Di(this.lzy.field_roomowner);
    int i = this.lzy.iZm();
    this.lLv.setVisibility(0);
    if (i <= 40)
    {
      this.lLv.setText(getString(a.i.lJj, new Object[] { getString(a.i.lJd) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.lLv.setText(getString(a.i.lJj, new Object[] { getString(a.i.lJc) }));
    AppMethodBeat.o(12795);
  }
  
  public int getLayoutId()
  {
    return a.f.lGj;
  }
  
  public void initView()
  {
    AppMethodBeat.i(12791);
    setMMTitle(a.i.lJb);
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
    this.lLs = findViewById(a.e.lFU);
    this.lLB = findViewById(a.e.lFW);
    this.lLt = ((ImageView)findViewById(a.e.lFT));
    this.lLu = ((TextView)findViewById(a.e.lFV));
    this.lLv = ((TextView)findViewById(a.e.lFR));
    this.lLw = ((TextView)findViewById(a.e.lFS));
    this.lLC = ((TextView)findViewById(a.e.lFQ));
    this.lLC.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12781);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomUpgradeUI$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
            d.a(RoomUpgradeUI.this, RoomUpgradeUI.c(RoomUpgradeUI.this), true);
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
    this.lLA = ((TextView)findViewById(a.e.lEP));
    this.lLA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(a.i.chatroom_how_to_upgrade, new Object[] { LocaleUtil.getApplicationLanguage() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", z.bAM());
          paramAnonymousView.putExtra("showShare", false);
          com.tencent.mm.br.c.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(12782);
      }
    });
    if (this.lLF)
    {
      this.lzP = k.a(this, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            com.tencent.mm.kernel.h.baD().mCm.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.lLD = new com.tencent.mm.chatroom.d.p(this.chatroomName);
      com.tencent.mm.kernel.h.baD().mCm.a(this.lLD, 0);
    }
    for (;;)
    {
      if (this.lLG) {
        this.lLA.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      aNj();
      if (!this.lLG) {
        this.lLA.setVisibility(0);
      }
      this.lLA.setText(a.i.lJe);
      this.lLC.setVisibility(8);
      this.lLw.setVisibility(8);
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
    aNi();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    com.tencent.mm.kernel.h.baD().mCm.a(this.lLD);
    com.tencent.mm.kernel.h.baD().mCm.b(519, this);
    if (this.lzP != null) {
      this.lzP.dismiss();
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
      aNi();
      int i = paramIntent.getIntExtra("left_quota", 0);
      aNj();
      this.lLC.setVisibility(8);
      this.lyu = i;
      if (this.lyu <= 0) {
        break label172;
      }
      this.lLw.setText(getString(a.i.lJh, new Object[] { Integer.valueOf(this.lyu) }));
    }
    for (;;)
    {
      if (!this.lLG) {
        this.lLA.setVisibility(0);
      }
      this.lLA.setText(a.i.lJe);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        aNh();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        aNh();
      }
      bool = false;
      break;
      label172:
      this.lLw.setText(getString(a.i.lJi));
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(12800);
    Log.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.lzP != null) {
      this.lzP.dismiss();
    }
    if ((paramInt1 != 0) || (paramInt2 != 0))
    {
      k.a(this, getString(a.i.lJg), getString(a.i.app_tip), false, new DialogInterface.OnClickListener()
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
    if ((paramInt1 == 0) && (paramInt2 == 0) && (paramp.getType() == 519))
    {
      paramString = (com.tencent.mm.chatroom.d.p)paramp;
      this.status = paramString.status;
      this.lyt = paramString.lyt;
      this.lyu = paramString.lyu;
      aNj();
      this.lLw.setVisibility(0);
      this.lLC.setText(getString(a.i.lJa));
      if (this.lyu <= 0) {
        break label283;
      }
      this.lLw.setText(getString(a.i.lJh, new Object[] { Integer.valueOf(this.lyu) }));
      if (!this.lLG) {
        this.lLA.setVisibility(0);
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
      this.lLw.setText(getString(a.i.lJi));
      break;
      this.lLC.setVisibility(0);
      this.lLA.setText(a.i.lJf);
      AppMethodBeat.o(12800);
      return;
      this.lLC.setVisibility(0);
      this.lLC.setEnabled(false);
      this.lLA.setText(a.i.lJf);
      AppMethodBeat.o(12800);
      return;
      this.lLC.setVisibility(8);
      this.lLA.setText(a.i.lJe);
      this.lLC.setEnabled(false);
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.RoomUpgradeUI
 * JD-Core Version:    0.7.0.1
 */