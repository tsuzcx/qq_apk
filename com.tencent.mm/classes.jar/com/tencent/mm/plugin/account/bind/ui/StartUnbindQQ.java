package com.tencent.mm.plugin.account.bind.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.tencent.mm.ag.d;
import com.tencent.mm.ag.i;
import com.tencent.mm.ah.f;
import com.tencent.mm.ah.m;
import com.tencent.mm.h.a.af;
import com.tencent.mm.h.a.so;
import com.tencent.mm.kernel.e;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.q;
import com.tencent.mm.plugin.account.bind.a.e;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.an;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.widget.a.c;

public class StartUnbindQQ
  extends MMWizardActivity
  implements f
{
  private String fbB = null;
  private View feH;
  private c feI;
  private com.tencent.mm.ui.base.p tipDialog;
  
  protected final int getLayoutId()
  {
    return a.f.start_unbindqq;
  }
  
  protected final void initView()
  {
    setMMTitle(a.i.unbind_qq);
    this.feH = findViewById(a.e.setting_start_unbind_qq);
    setBackBtn(new StartUnbindQQ.1(this));
    this.feH.setOnClickListener(new StartUnbindQQ.2(this));
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    g.Dk().a(253, this);
    this.fbB = getIntent().getStringExtra("notice");
  }
  
  public void onDestroy()
  {
    g.Dk().b(253, this);
    super.onDestroy();
  }
  
  protected void onResume()
  {
    super.onResume();
    initView();
  }
  
  public void onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    y.d("MicroMsg.StartUnbindQQ", "onSceneEnd " + paramInt1 + " errCode " + paramInt2 + " errMsg " + paramString + "  " + paramm.getType());
    if (paramm.getType() == 253)
    {
      if (this.tipDialog != null)
      {
        this.tipDialog.dismiss();
        this.tipDialog = null;
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramInt1 = bk.a((Integer)g.DP().Dz().get(9, null), 0);
        y.d("MicroMsg.StartUnbindQQ", "iBindUin " + paramInt1);
        if (paramInt1 != 0) {
          ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().delete(new com.tencent.mm.a.o(paramInt1) + "@qqim");
        }
        paramm = g.DP().Dz().get(102407, null);
        if ((paramm != null) && (((String)paramm).length() > 0)) {
          g.DP().Dz().o(102407, null);
        }
      }
    }
    try
    {
      com.tencent.mm.sdk.b.a.udP.m(new af());
      paramInt1 = bk.a((Integer)g.DP().Dz().get(9, null), 0);
      paramm = new com.tencent.mm.a.o(paramInt1) + "@qqim";
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).FE().delete(paramm);
      ((com.tencent.mm.plugin.messenger.foundation.a.j)g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abr(paramm);
      com.tencent.mm.ag.o.Kh().kq(paramm);
      String str = q.Gj() + "@qqim";
      com.tencent.mm.ag.o.Kh().kq(str);
      com.tencent.mm.ag.o.JQ();
      d.B(paramm, false);
      com.tencent.mm.ag.o.JQ();
      d.B(paramm, true);
      com.tencent.mm.ag.o.JQ();
      d.B(str, false);
      com.tencent.mm.ag.o.JQ();
      d.B(str, true);
      paramm = (an)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getQQGroupStg();
      y.d("MicroMsg.QQGroupStorage", "delete all");
      if (paramm.dXo.delete("qqgroup", null, null) > 0) {
        paramm.doNotify();
      }
      com.tencent.mm.plugin.account.a.a.eUS.tk();
    }
    catch (Exception paramm)
    {
      for (;;)
      {
        y.printErrStackTrace("MicroMsg.StartUnbindQQ", paramm, "", new Object[0]);
        y.printErrStackTrace("MicroMsg.StartUnbindQQ", paramm, "", new Object[0]);
        continue;
        FW(1);
      }
    }
    g.DP().Dz().o(9, Integer.valueOf(0));
    paramm = new so();
    paramm.ccd.cce = false;
    paramm.ccd.ccf = true;
    com.tencent.mm.sdk.b.a.udP.m(paramm);
    if (!bk.bl(this.fbB))
    {
      com.tencent.mm.ui.base.h.a(this, this.fbB, "", getString(a.i.app_i_known), new StartUnbindQQ.3(this));
      paramString = com.tencent.mm.i.a.eI(paramString);
      if (paramString != null) {
        paramString.a(this, null, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.StartUnbindQQ
 * JD-Core Version:    0.7.0.1
 */