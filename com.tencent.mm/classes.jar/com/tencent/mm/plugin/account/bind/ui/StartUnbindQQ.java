package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.j;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.g.a.ak;
import com.tencent.mm.g.a.wq;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.ae;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.MMWizardActivity;

public class StartUnbindQQ
  extends MMWizardActivity
  implements com.tencent.mm.ak.g
{
  private String iGE = null;
  private View iJu;
  private com.tencent.mm.ui.widget.a.d iJv;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public int getLayoutId()
  {
    return 2131495640;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110193);
    setMMTitle(2131764550);
    this.iJu = findViewById(2131304632);
    setBackBtn(new MenuItem.OnMenuItemClickListener()
    {
      public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
      {
        AppMethodBeat.i(110186);
        StartUnbindQQ.this.finish();
        AppMethodBeat.o(110186);
        return true;
      }
    });
    this.iJu.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110188);
        if (StartUnbindQQ.a(StartUnbindQQ.this) == null)
        {
          StartUnbindQQ.a(StartUnbindQQ.this, com.tencent.mm.ui.base.h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(2131763141), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110187);
              paramAnonymous2DialogInterface = new com.tencent.mm.plugin.account.bind.a.d("");
              com.tencent.mm.kernel.g.agi().a(paramAnonymous2DialogInterface, 0);
              paramAnonymous2DialogInterface = StartUnbindQQ.this;
              StartUnbindQQ localStartUnbindQQ = StartUnbindQQ.this;
              StartUnbindQQ.this.getString(2131755906);
              StartUnbindQQ.a(paramAnonymous2DialogInterface, com.tencent.mm.ui.base.h.b(localStartUnbindQQ, StartUnbindQQ.this.getString(2131763142), true, null));
              AppMethodBeat.o(110187);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }));
          AppMethodBeat.o(110188);
          return;
        }
        StartUnbindQQ.a(StartUnbindQQ.this).show();
        AppMethodBeat.o(110188);
      }
    });
    AppMethodBeat.o(110193);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110190);
    super.onCreate(paramBundle);
    com.tencent.mm.kernel.g.agi().a(253, this);
    this.iGE = getIntent().getStringExtra("notice");
    AppMethodBeat.o(110190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110191);
    com.tencent.mm.kernel.g.agi().b(253, this);
    super.onDestroy();
    AppMethodBeat.o(110191);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(110192);
    super.onResume();
    initView();
    AppMethodBeat.o(110192);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(110194);
    ac.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramn.getType());
    if (paramn.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null), 0);
        ac.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().delete(new com.tencent.mm.b.p(paramInt1) + "@qqim");
        }
        paramn = com.tencent.mm.kernel.g.agR().agA().get(102407, null);
        if ((paramn != null) && (((String)paramn).length() > 0)) {
          com.tencent.mm.kernel.g.agR().agA().set(102407, null);
        }
      }
      try
      {
        com.tencent.mm.sdk.b.a.GpY.l(new ak());
        paramInt1 = bs.a((Integer)com.tencent.mm.kernel.g.agR().agA().get(9, null), 0);
        paramn = new com.tencent.mm.b.p(paramInt1) + "@qqim";
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awJ().delete(paramn);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNA(paramn);
        com.tencent.mm.aj.p.aBw().Al(paramn);
        String str = u.axw() + "@qqim";
        com.tencent.mm.aj.p.aBw().Al(str);
        com.tencent.mm.aj.p.aBh();
        com.tencent.mm.aj.e.L(paramn, false);
        com.tencent.mm.aj.p.aBh();
        com.tencent.mm.aj.e.L(paramn, true);
        com.tencent.mm.aj.p.aBh();
        com.tencent.mm.aj.e.L(str, false);
        com.tencent.mm.aj.p.aBh();
        com.tencent.mm.aj.e.L(str, true);
        paramn = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        ac.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramn.hpA.delete("qqgroup", null, null) > 0) {
          paramn.doNotify();
        }
        com.tencent.mm.plugin.account.a.a.iyy.Lj();
      }
      catch (Exception paramn)
      {
        for (;;)
        {
          ac.printErrStackTrace("MicroMsg.StartUnbindQQ", paramn, "", new Object[0]);
          ac.printErrStackTrace("MicroMsg.StartUnbindQQ", paramn, "", new Object[0]);
          continue;
          ZA(1);
        }
      }
      com.tencent.mm.kernel.g.agR().agA().set(9, Integer.valueOf(0));
      paramn = new wq();
      paramn.dzu.dzv = false;
      paramn.dzu.dzw = true;
      com.tencent.mm.sdk.b.a.GpY.l(paramn);
      if (!bs.isNullOrNil(this.iGE))
      {
        com.tencent.mm.ui.base.h.a(this, this.iGE, "", getString(2131755793), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110189);
            StartUnbindQQ.b(StartUnbindQQ.this);
            AppMethodBeat.o(110189);
          }
        });
        paramString = com.tencent.mm.h.a.rM(paramString);
        if (paramString == null) {
          break label614;
        }
        paramString.a(this, null, null);
        AppMethodBeat.o(110194);
      }
    }
    label614:
    AppMethodBeat.o(110194);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */