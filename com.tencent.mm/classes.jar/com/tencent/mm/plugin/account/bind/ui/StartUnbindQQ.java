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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.t;
import com.tencent.mm.g.a.am;
import com.tencent.mm.g.a.yo;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMWizardActivity;

public class StartUnbindQQ
  extends MMWizardActivity
  implements i
{
  private String kaJ = null;
  private com.tencent.mm.ui.widget.a.d kdA;
  private View kdz;
  private com.tencent.mm.ui.base.q tipDialog;
  
  public int getLayoutId()
  {
    return 2131496545;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110193);
    setMMTitle(2131766895);
    this.kdz = findViewById(2131307684);
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
    this.kdz.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110188);
        b localb = new b();
        localb.bm(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
        if (StartUnbindQQ.a(StartUnbindQQ.this) == null) {
          StartUnbindQQ.a(StartUnbindQQ.this, com.tencent.mm.ui.base.h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(2131765307), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110187);
              paramAnonymous2DialogInterface = new com.tencent.mm.plugin.account.bind.a.d("");
              g.azz().a(paramAnonymous2DialogInterface, 0);
              paramAnonymous2DialogInterface = StartUnbindQQ.this;
              StartUnbindQQ localStartUnbindQQ = StartUnbindQQ.this;
              StartUnbindQQ.this.getString(2131755998);
              StartUnbindQQ.a(paramAnonymous2DialogInterface, com.tencent.mm.ui.base.h.a(localStartUnbindQQ, StartUnbindQQ.this.getString(2131765308), true, null));
              AppMethodBeat.o(110187);
            }
          }, new DialogInterface.OnClickListener()
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int) {}
          }));
        }
        for (;;)
        {
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(110188);
          return;
          StartUnbindQQ.a(StartUnbindQQ.this).show();
        }
      }
    });
    AppMethodBeat.o(110193);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(110190);
    super.onCreate(paramBundle);
    g.azz().a(253, this);
    this.kaJ = getIntent().getStringExtra("notice");
    AppMethodBeat.o(110190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110191);
    g.azz().b(253, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(110194);
    Log.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramq.getType());
    if (paramq.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = Util.nullAs((Integer)g.aAh().azQ().get(9, null), 0);
        Log.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().delete(new com.tencent.mm.b.p(paramInt1) + "@qqim");
        }
        paramq = g.aAh().azQ().get(102407, null);
        if ((paramq != null) && (((String)paramq).length() > 0)) {
          g.aAh().azQ().set(102407, null);
        }
      }
      try
      {
        EventCenter.instance.publish(new am());
        paramInt1 = Util.nullAs((Integer)g.aAh().azQ().get(9, null), 0);
        paramq = new com.tencent.mm.b.p(paramInt1) + "@qqim";
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSW().delete(paramq);
        ((com.tencent.mm.plugin.messenger.foundation.a.l)g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().aNa(paramq);
        com.tencent.mm.aj.p.aYB().My(paramq);
        String str = z.aTY() + "@qqim";
        com.tencent.mm.aj.p.aYB().My(str);
        com.tencent.mm.aj.p.aYn();
        com.tencent.mm.aj.e.N(paramq, false);
        com.tencent.mm.aj.p.aYn();
        com.tencent.mm.aj.e.N(paramq, true);
        com.tencent.mm.aj.p.aYn();
        com.tencent.mm.aj.e.N(str, false);
        com.tencent.mm.aj.p.aYn();
        com.tencent.mm.aj.e.N(str, true);
        paramq = (ar)((com.tencent.mm.plugin.account.a.a.a)g.ah(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        Log.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramq.iFy.delete("qqgroup", null, null) > 0) {
          paramq.doNotify();
        }
        com.tencent.mm.plugin.account.a.a.jRu.WZ();
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramq, "", new Object[0]);
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramq, "", new Object[0]);
          continue;
          ala(1);
        }
      }
      g.aAh().azQ().set(9, Integer.valueOf(0));
      paramq = new yo();
      paramq.eeN.eeO = false;
      paramq.eeN.eeP = true;
      EventCenter.instance.publish(paramq);
      if (!Util.isNullOrNil(this.kaJ))
      {
        com.tencent.mm.ui.base.h.a(this, this.kaJ, "", getString(2131755874), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110189);
            StartUnbindQQ.b(StartUnbindQQ.this);
            AppMethodBeat.o(110189);
          }
        });
        paramString = com.tencent.mm.h.a.Dk(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */