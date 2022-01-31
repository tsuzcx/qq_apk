package com.tencent.mm.plugin.account.bind.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.d;
import com.tencent.mm.ah.i;
import com.tencent.mm.ah.o;
import com.tencent.mm.ai.f;
import com.tencent.mm.g.a.ag;
import com.tencent.mm.g.a.ug;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.plugin.messenger.foundation.a.a.k;
import com.tencent.mm.plugin.messenger.foundation.a.j;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.b.c;

public class StartUnbindQQ
  extends MMWizardActivity
  implements f
{
  private String gtt = null;
  private View gwq;
  private c gwr;
  private com.tencent.mm.ui.base.p tipDialog;
  
  public int getLayoutId()
  {
    return 2130970911;
  }
  
  public void initView()
  {
    AppMethodBeat.i(13768);
    setMMTitle(2131304406);
    this.gwq = findViewById(2131828225);
    setBackBtn(new StartUnbindQQ.1(this));
    this.gwq.setOnClickListener(new StartUnbindQQ.2(this));
    AppMethodBeat.o(13768);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(13765);
    super.onCreate(paramBundle);
    g.Rc().a(253, this);
    this.gtt = getIntent().getStringExtra("notice");
    AppMethodBeat.o(13765);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(13766);
    g.Rc().b(253, this);
    super.onDestroy();
    AppMethodBeat.o(13766);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(13767);
    super.onResume();
    initView();
    AppMethodBeat.o(13767);
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ai.m paramm)
  {
    AppMethodBeat.i(13769);
    ab.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (paramm.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = bo.a((Integer)g.RL().Ru().get(9, null), 0);
        ab.d("MicroMsg.StartUnbindQQ", "iBindUin ".concat(String.valueOf(paramInt1)));
        if (paramInt1 != 0) {
          ((j)g.E(j.class)).YI().delete(new com.tencent.mm.a.p(paramInt1) + "@qqim");
        }
        paramm = g.RL().Ru().get(102407, null);
        if ((paramm != null) && (((String)paramm).length() > 0)) {
          g.RL().Ru().set(102407, null);
        }
      }
      try
      {
        com.tencent.mm.sdk.b.a.ymk.l(new ag());
        paramInt1 = bo.a((Integer)g.RL().Ru().get(9, null), 0);
        paramm = new com.tencent.mm.a.p(paramInt1) + "@qqim";
        ((j)g.E(j.class)).YI().delete(paramm);
        ((j)g.E(j.class)).YA().arC(paramm);
        o.adg().rk(paramm);
        String str = r.Zn() + "@qqim";
        o.adg().rk(str);
        o.acQ();
        d.F(paramm, false);
        o.acQ();
        d.F(paramm, true);
        o.acQ();
        d.F(str, false);
        o.acQ();
        d.F(str, true);
        paramm = (an)((com.tencent.mm.plugin.account.a.a.a)g.G(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
        ab.d("MicroMsg.QQGroupStorage", "delete all");
        if (paramm.fnw.delete("qqgroup", null, null) > 0) {
          paramm.doNotify();
        }
        com.tencent.mm.plugin.account.a.a.gmP.BO();
      }
      catch (Exception paramm)
      {
        for (;;)
        {
          ab.printErrStackTrace("MicroMsg.StartUnbindQQ", paramm, "", new Object[0]);
          ab.printErrStackTrace("MicroMsg.StartUnbindQQ", paramm, "", new Object[0]);
          continue;
          Oi(1);
        }
      }
      g.RL().Ru().set(9, Integer.valueOf(0));
      paramm = new ug();
      paramm.cKJ.cKK = false;
      paramm.cKJ.cKL = true;
      com.tencent.mm.sdk.b.a.ymk.l(paramm);
      if (!bo.isNullOrNil(this.gtt))
      {
        com.tencent.mm.ui.base.h.a(this, this.gtt, "", getString(2131296977), new StartUnbindQQ.3(this));
        paramString = com.tencent.mm.h.a.kO(paramString);
        if (paramString == null) {
          break label616;
        }
        paramString.a(this, null, null);
        AppMethodBeat.o(13769);
      }
    }
    label616:
    AppMethodBeat.o(13769);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */