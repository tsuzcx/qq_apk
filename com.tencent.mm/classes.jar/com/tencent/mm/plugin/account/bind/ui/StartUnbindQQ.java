package com.tencent.mm.plugin.account.bind.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.autogen.a.abs;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.AvatarStorage;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.model.ao;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.base.w;

public class StartUnbindQQ
  extends MMWizardActivity
  implements com.tencent.mm.am.h
{
  private String pOI = null;
  private View pRG;
  private com.tencent.mm.ui.widget.a.e pRH;
  private w tipDialog;
  
  public int getLayoutId()
  {
    return a.f.start_unbindqq;
  }
  
  public void initView()
  {
    AppMethodBeat.i(110193);
    setMMTitle(a.i.unbind_qq);
    this.pRG = findViewById(a.e.setting_start_unbind_qq);
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
    this.pRG.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(110188);
        b localb = new b();
        localb.cH(paramAnonymousView);
        com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/account/bind/ui/StartUnbindQQ$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
        if (StartUnbindQQ.a(StartUnbindQQ.this) == null) {
          StartUnbindQQ.a(StartUnbindQQ.this, com.tencent.mm.ui.base.k.a(StartUnbindQQ.this, StartUnbindQQ.this.getString(a.i.setting_unbinding_confirm), null, new DialogInterface.OnClickListener()new DialogInterface.OnClickListener
          {
            public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
            {
              AppMethodBeat.i(110187);
              paramAnonymous2DialogInterface = new com.tencent.mm.plugin.account.bind.a.e("");
              com.tencent.mm.kernel.h.aZW().a(paramAnonymous2DialogInterface, 0);
              paramAnonymous2DialogInterface = StartUnbindQQ.this;
              StartUnbindQQ localStartUnbindQQ = StartUnbindQQ.this;
              StartUnbindQQ.this.getString(a.i.app_tip);
              StartUnbindQQ.a(paramAnonymous2DialogInterface, com.tencent.mm.ui.base.k.a(localStartUnbindQQ, StartUnbindQQ.this.getString(a.i.setting_unbinding_qq), true, null));
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
    com.tencent.mm.kernel.h.aZW().a(253, this);
    this.pOI = getIntent().getStringExtra("notice");
    AppMethodBeat.o(110190);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(110191);
    com.tencent.mm.kernel.h.aZW().b(253, this);
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
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    AppMethodBeat.i(110194);
    Log.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramp.getType());
    if (paramp.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null), 0);
        Log.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().Mo(new com.tencent.mm.b.p(paramInt1) + "@qqim");
        }
        paramp = com.tencent.mm.kernel.h.baE().ban().d(102407, null);
        if ((paramp != null) && (((String)paramp).length() > 0)) {
          com.tencent.mm.kernel.h.baE().ban().B(102407, null);
        }
      }
      try
      {
        new com.tencent.mm.autogen.a.aq().publish();
        paramInt1 = Util.nullAs((Integer)com.tencent.mm.kernel.h.baE().ban().d(9, null), 0);
        paramp = new com.tencent.mm.b.p(paramInt1) + "@qqim";
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzJ().Mo(paramp);
        ((n)com.tencent.mm.kernel.h.ax(n.class)).bzA().bxC(paramp);
        q.bFE().LT(paramp);
        String str = z.bAM() + "@qqim";
        q.bFE().LT(str);
        q.bFp();
        AvatarStorage.T(paramp, false);
        q.bFp();
        AvatarStorage.T(paramp, true);
        q.bFp();
        AvatarStorage.T(str, false);
        q.bFp();
        AvatarStorage.T(str, true);
        paramp = (ao)((com.tencent.mm.plugin.account.sdk.a.a)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.account.sdk.a.a.class)).getQQGroupStg();
        Log.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramp.omV.delete("qqgroup", null, null) > 0) {
          paramp.doNotify();
        }
        com.tencent.mm.plugin.account.sdk.a.pFo.aDx();
      }
      catch (Exception paramp)
      {
        for (;;)
        {
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramp, "", new Object[0]);
          Log.printErrStackTrace("MicroMsg.StartUnbindQQ", paramp, "", new Object[0]);
          continue;
          aAp(1);
        }
      }
      com.tencent.mm.kernel.h.baE().ban().B(9, Integer.valueOf(0));
      paramp = new abs();
      paramp.ifi.hAJ = false;
      paramp.ifi.ifj = true;
      paramp.publish();
      if (!Util.isNullOrNil(this.pOI))
      {
        com.tencent.mm.ui.base.k.a(this, this.pOI, "", getString(a.i.app_i_known), new DialogInterface.OnClickListener()
        {
          public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
          {
            AppMethodBeat.i(110189);
            StartUnbindQQ.b(StartUnbindQQ.this);
            AppMethodBeat.o(110189);
          }
        });
        paramString = com.tencent.mm.broadcast.a.CH(paramString);
        if (paramString == null) {
          break label608;
        }
        paramString.a(this, null, null);
        AppMethodBeat.o(110194);
      }
    }
    label608:
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