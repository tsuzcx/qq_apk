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
import com.tencent.mm.am.k;
import com.tencent.mm.an.i;
import com.tencent.mm.an.t;
import com.tencent.mm.b.p;
import com.tencent.mm.f.a.an;
import com.tencent.mm.f.a.zv;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.friend.a.ar;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.event.EventCenter;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.widget.a.d;

public class StartUnbindQQ
  extends MMWizardActivity
  implements i
{
  private String mSb = null;
  private View mUZ;
  private d mVa;
  private s tipDialog;
  
  public int getLayoutId()
  {
    return a.f.start_unbindqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110193);
    setMMTitle(a.i.unbind_qq);
    this.mUZ = findViewById(a.e.setting_start_unbind_qq);
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
    this.mUZ.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110188);
        b localb = new b();
        localb.bn(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        if (StartUnbindQQ.a(StartUnbindQQ.this) == null) {
          StartUnbindQQ.a(StartUnbindQQ.this, com.tencent.mm.ui.base.h.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(a.i.setting_unbinding_confirm), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110187);
              paramAnonymous2DialogInterface = new e("");
              com.tencent.mm.kernel.h.aGY().a(paramAnonymous2DialogInterface, 0);
              paramAnonymous2DialogInterface = StartUnbindQQ.this;
              StartUnbindQQ localStartUnbindQQ = StartUnbindQQ.this;
              StartUnbindQQ.this.getString(a.i.app_tip);
              StartUnbindQQ.a(paramAnonymous2DialogInterface, com.tencent.mm.ui.base.h.a(localStartUnbindQQ, StartUnbindQQ.this.getString(a.i.setting_unbinding_qq), true, null));
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
    com.tencent.mm.kernel.h.aGY().a(253, this);
    this.mSb = getIntent().getStringExtra("notice");
    AppMethodBeat.o(110190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110191);
    com.tencent.mm.kernel.h.aGY().b(253, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
        paramInt1 = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null), 0);
        Log.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().Up(new p(paramInt1) + "@qqim");
        }
        paramq = com.tencent.mm.kernel.h.aHG().aHp().b(102407, null);
        if ((paramq != null) && (((String)paramq).length() > 0)) {
          com.tencent.mm.kernel.h.aHG().aHp().i(102407, null);
        }
      }
      try
      {
        EventCenter.instance.publish(new an());
        paramInt1 = Util.nullAs((Integer)com.tencent.mm.kernel.h.aHG().aHp().b(9, null), 0);
        paramq = new p(paramInt1) + "@qqim";
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbU().Up(paramq);
        ((n)com.tencent.mm.kernel.h.ae(n.class)).bbL().bwp(paramq);
        com.tencent.mm.am.q.bhP().TT(paramq);
        String str = z.bcZ() + "@qqim";
        com.tencent.mm.am.q.bhP().TT(str);
        com.tencent.mm.am.q.bhz();
        com.tencent.mm.am.f.P(paramq, false);
        com.tencent.mm.am.q.bhz();
        com.tencent.mm.am.f.P(paramq, true);
        com.tencent.mm.am.q.bhz();
        com.tencent.mm.am.f.P(str, false);
        com.tencent.mm.am.q.bhz();
        com.tencent.mm.am.f.P(str, true);
        paramq = (ar)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.ag(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
        Log.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramq.lvy.delete("qqgroup", null, null) > 0) {
          paramq.doNotify();
        }
        com.tencent.mm.plugin.account.sdk.a.mIH.abC();
      }
      catch (Exception paramq)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramq, "", new Object[0]);
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramq, "", new Object[0]);
          continue;
          atX(1);
        }
      }
      com.tencent.mm.kernel.h.aHG().aHp().i(9, Integer.valueOf(0));
      paramq = new zv();
      paramq.fZc.fZd = false;
      paramq.fZc.fZe = true;
      EventCenter.instance.publish(paramq);
      if (!Util.isNullOrNil(this.mSb))
      {
        com.tencent.mm.ui.base.h.a(this, this.mSb, "", getString(a.i.app_i_known), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110189);
            StartUnbindQQ.b(StartUnbindQQ.this);
            AppMethodBeat.o(110189);
          }
        });
        paramString = com.tencent.mm.h.a.Kb(paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */