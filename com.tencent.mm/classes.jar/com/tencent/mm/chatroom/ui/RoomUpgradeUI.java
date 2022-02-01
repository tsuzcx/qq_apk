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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.br.d;
import com.tencent.mm.chatroom.d.m;
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.aj;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.ar.b.a;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.chatroom.a.c;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ai;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.x;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;

public class RoomUpgradeUI
  extends MMActivity
  implements com.tencent.mm.ak.g
{
  private String chatroomName;
  private int fsr;
  private int fss;
  private x ftP;
  private ProgressDialog fts = null;
  private View fyk;
  private ImageView fyl;
  private TextView fym;
  private TextView fyn;
  private TextView fyo;
  private TextView fys;
  private View fyt;
  private TextView fyu;
  private m fyv;
  private String fyw;
  private boolean fyx;
  private boolean fyy;
  private int status;
  
  private void WI()
  {
    AppMethodBeat.i(12789);
    Object localObject = new Intent(this, RoomAlphaProcessUI.class);
    ((Intent)localObject).addFlags(67108864);
    ((Intent)localObject).addFlags(65536);
    ((Intent)localObject).putExtra("RoomInfo_Id", this.chatroomName);
    localObject = new com.tencent.mm.hellhoundlib.b.a().ba(localObject);
    com.tencent.mm.hellhoundlib.a.a.a(this, ((com.tencent.mm.hellhoundlib.b.a)localObject).aeD(), "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).lR(0));
    com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/chatroom/ui/RoomUpgradeUI", "doUpgrade", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
    AppMethodBeat.o(12789);
  }
  
  private void WJ()
  {
    AppMethodBeat.i(12790);
    this.chatroomName = getIntent().getStringExtra("room_name");
    ac.i("MicroMsg.RoomUpgradeProductsUI", "the roomName is %s", new Object[] { this.chatroomName });
    com.tencent.mm.kernel.g.agQ().ghe.a(519, this);
    this.ftP = ((c)com.tencent.mm.kernel.g.ab(c.class)).awK().xN(this.chatroomName);
    if (this.ftP == null)
    {
      finish();
      AppMethodBeat.o(12790);
      return;
    }
    this.fyx = u.axw().equals(this.ftP.field_roomowner);
    if (!ab.eUL()) {}
    for (boolean bool = true;; bool = false)
    {
      this.fyy = bool;
      AppMethodBeat.o(12790);
      return;
    }
  }
  
  private void WK()
  {
    AppMethodBeat.i(12795);
    sj(this.ftP.field_roomowner);
    int i = this.ftP.eZO();
    this.fyn.setVisibility(0);
    if (i <= 40)
    {
      this.fyn.setText(getString(2131762722, new Object[] { getString(2131762716) }));
      AppMethodBeat.o(12795);
      return;
    }
    this.fyn.setText(getString(2131762722, new Object[] { getString(2131762715) }));
    AppMethodBeat.o(12795);
  }
  
  private String se(String paramString)
  {
    AppMethodBeat.i(12798);
    if (this.ftP == null)
    {
      AppMethodBeat.o(12798);
      return null;
    }
    paramString = this.ftP.wk(paramString);
    AppMethodBeat.o(12798);
    return paramString;
  }
  
  private void si(String paramString)
  {
    AppMethodBeat.i(12797);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((localai != null) && ((int)localai.fLJ > 0)) {}
    for (Object localObject2 = localai.field_conRemark;; localObject2 = null)
    {
      Object localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = se(paramString);
      }
      localObject2 = localObject1;
      if (bs.isNullOrNil((String)localObject1))
      {
        localObject2 = localObject1;
        if (localai != null)
        {
          localObject2 = localObject1;
          if ((int)localai.fLJ > 0) {
            localObject2 = localai.aaR();
          }
        }
      }
      localObject1 = localObject2;
      if (bs.isNullOrNil((String)localObject2)) {
        localObject1 = paramString;
      }
      a.b.c(this.fyl, paramString);
      this.fym.setVisibility(0);
      this.fym.setText(com.tencent.mm.pluginsdk.ui.span.k.b(this, (CharSequence)localObject1, (int)this.fym.getTextSize()));
      AppMethodBeat.o(12797);
      return;
    }
  }
  
  private void sj(final String paramString)
  {
    AppMethodBeat.i(12796);
    ai localai = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNt(paramString);
    if ((localai != null) && ((int)localai.fLJ <= 0))
    {
      ar.a.hnw.a(paramString, this.chatroomName, new ar.b.a()
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
                RoomUpgradeUI.b(RoomUpgradeUI.this, RoomUpgradeUI.4.this.fyq);
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
    si(paramString);
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
    this.fyk = findViewById(2131306214);
    this.fyt = findViewById(2131306216);
    this.fyl = ((ImageView)findViewById(2131306213));
    this.fym = ((TextView)findViewById(2131306215));
    this.fyn = ((TextView)findViewById(2131306210));
    this.fyo = ((TextView)findViewById(2131306211));
    this.fyu = ((TextView)findViewById(2131306209));
    this.fyu.setOnClickListener(new View.OnClickListener()
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
    this.fys = ((TextView)findViewById(2131300766));
    this.fys.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(12782);
        if (RoomUpgradeUI.e(RoomUpgradeUI.this).getVisibility() == 0)
        {
          paramAnonymousView = new Intent();
          RoomUpgradeUI.a(RoomUpgradeUI.this, RoomUpgradeUI.this.getString(2131757097, new Object[] { ab.eUO() }));
          paramAnonymousView.putExtra("rawUrl", RoomUpgradeUI.f(RoomUpgradeUI.this));
          paramAnonymousView.putExtra("geta8key_username", u.axw());
          paramAnonymousView.putExtra("showShare", false);
          d.b(RoomUpgradeUI.this, "webview", "com.tencent.mm.plugin.webview.ui.tools.WebViewUI", paramAnonymousView, 500);
        }
        AppMethodBeat.o(12782);
      }
    });
    if (this.fyx)
    {
      this.fts = h.b(this, getString(2131760709), true, new DialogInterface.OnCancelListener()
      {
        public final void onCancel(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(12785);
          if (RoomUpgradeUI.h(RoomUpgradeUI.this) != null)
          {
            com.tencent.mm.kernel.g.agQ().ghe.a(RoomUpgradeUI.h(RoomUpgradeUI.this));
            RoomUpgradeUI.i(RoomUpgradeUI.this);
          }
          RoomUpgradeUI.this.finish();
          AppMethodBeat.o(12785);
        }
      });
      this.fyv = new m(this.chatroomName);
      com.tencent.mm.kernel.g.agQ().ghe.a(this.fyv, 0);
    }
    for (;;)
    {
      if (this.fyy) {
        this.fys.setVisibility(8);
      }
      AppMethodBeat.o(12791);
      return;
      WK();
      if (!this.fyy) {
        this.fys.setVisibility(0);
      }
      this.fys.setText(2131762717);
      this.fyu.setVisibility(8);
      this.fyo.setVisibility(8);
    }
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(12799);
    ac.d("MicroMsg.RoomUpgradeProductsUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    switch (paramInt1)
    {
    default: 
      ac.e("MicroMsg.RoomUpgradeProductsUI", "onActivityResult unknow request");
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
    WJ();
    initView();
    AppMethodBeat.o(12787);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(12794);
    com.tencent.mm.kernel.g.agQ().ghe.a(this.fyv);
    com.tencent.mm.kernel.g.agQ().ghe.b(519, this);
    if (this.fts != null) {
      this.fts.dismiss();
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
      WJ();
      int i = paramIntent.getIntExtra("left_quota", 0);
      WK();
      this.fyu.setVisibility(8);
      this.fss = i;
      if (this.fss <= 0) {
        break label172;
      }
      this.fyo.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fss) }));
    }
    for (;;)
    {
      if (!this.fyy) {
        this.fys.setVisibility(0);
      }
      this.fys.setText(2131762717);
      AppMethodBeat.o(12788);
      return;
      if ((paramIntent.hasExtra("wizard_activity_result_code")) && (paramIntent.getIntExtra("wizard_activity_result_code", -1) == -1)) {
        WI();
      }
      if (paramIntent.hasExtra("announce_ok")) {
        WI();
      }
      bool = false;
      break;
      label172:
      this.fyo.setText(getString(2131762721));
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
    ac.d("MicroMsg.RoomUpgradeProductsUI", "onSceneEnd: errType = " + paramInt1 + " errCode = " + paramInt2 + " errMsg = " + paramString);
    if (this.fts != null) {
      this.fts.dismiss();
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
      this.fsr = paramString.fsr;
      this.fss = paramString.fss;
      WK();
      this.fyo.setVisibility(0);
      this.fyu.setText(getString(2131762713));
      if (this.fss <= 0) {
        break label283;
      }
      this.fyo.setText(getString(2131762720, new Object[] { Integer.valueOf(this.fss) }));
      if (!this.fyy) {
        this.fys.setVisibility(0);
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
      this.fyo.setText(getString(2131762721));
      break;
      this.fyu.setVisibility(0);
      this.fys.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fyu.setVisibility(0);
      this.fyu.setEnabled(false);
      this.fys.setText(2131762718);
      AppMethodBeat.o(12800);
      return;
      this.fyu.setVisibility(8);
      this.fys.setText(2131762717);
      this.fyu.setEnabled(false);
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