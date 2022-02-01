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
import com.tencent.mm.ak.j;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.g.a.aj;
import com.tencent.mm.g.a.wf;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.MMWizardActivity;

public class StartUnbindQQ
  extends MMWizardActivity
  implements com.tencent.mm.al.g
{
  private String igv = null;
  private View ijn;
  private com.tencent.mm.ui.widget.a.d ijo;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public int getLayoutId()
  {
    return 2131495640;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110193);
    setMMTitle(2131764550);
    this.ijn = findViewById(2131304632);
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
    this.ijn.setOnClickListener(new View.OnClickListener()
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
              com.tencent.mm.kernel.g.aeS().a(paramAnonymous2DialogInterface, 0);
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
    com.tencent.mm.kernel.g.aeS().a(253, this);
    this.igv = getIntent().getStringExtra("notice");
    AppMethodBeat.o(110190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110191);
    com.tencent.mm.kernel.g.aeS().b(253, this);
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
    ad.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramn.getType());
    if (paramn.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null), 0);
        ad.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().delete(new com.tencent.mm.b.p(paramInt1) + "@qqim");
        }
        paramn = com.tencent.mm.kernel.g.afB().afk().get(102407, null);
        if ((paramn != null) && (((String)paramn).length() > 0)) {
          com.tencent.mm.kernel.g.afB().afk().set(102407, null);
        }
      }
      try
      {
        com.tencent.mm.sdk.b.a.ESL.l(new aj());
        paramInt1 = bt.a((Integer)com.tencent.mm.kernel.g.afB().afk().get(9, null), 0);
        paramn = new com.tencent.mm.b.p(paramInt1) + "@qqim";
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apU().delete(paramn);
        ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aIf(paramn);
        com.tencent.mm.ak.p.auF().wf(paramn);
        String str = u.aqG() + "@qqim";
        com.tencent.mm.ak.p.auF().wf(str);
        com.tencent.mm.ak.p.auq();
        com.tencent.mm.ak.e.K(paramn, false);
        com.tencent.mm.ak.p.auq();
        com.tencent.mm.ak.e.K(paramn, true);
        com.tencent.mm.ak.p.auq();
        com.tencent.mm.ak.e.K(str, false);
        com.tencent.mm.ak.p.auq();
        com.tencent.mm.ak.e.K(str, true);
        paramn = (ar)((com.tencent.mm.plugin.account.a.a.a)com.tencent.mm.kernel.g.ad(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        ad.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramn.gPa.delete("qqgroup", null, null) > 0) {
          paramn.doNotify();
        }
        com.tencent.mm.plugin.account.a.a.hYu.Ll();
      }
      catch (Exception paramn)
      {
        for (;;)
        {
          ad.printErrStackTrace("MicroMsg.StartUnbindQQ", paramn, "", new Object[0]);
          ad.printErrStackTrace("MicroMsg.StartUnbindQQ", paramn, "", new Object[0]);
          continue;
          Xo(1);
        }
      }
      com.tencent.mm.kernel.g.afB().afk().set(9, Integer.valueOf(0));
      paramn = new wf();
      paramn.dBG.dBH = false;
      paramn.dBG.dBI = true;
      com.tencent.mm.sdk.b.a.ESL.l(paramn);
      if (!bt.isNullOrNil(this.igv))
      {
        com.tencent.mm.ui.base.h.a(this, this.igv, "", getString(2131755793), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110189);
            StartUnbindQQ.b(StartUnbindQQ.this);
            AppMethodBeat.o(110189);
          }
        });
        paramString = com.tencent.mm.h.a.oG(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */