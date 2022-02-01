package com.tencent.mm.plugin.aa.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.bs.d;
import com.tencent.mm.kernel.b;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo;
import com.tencent.mm.plugin.aa.model.e;
import com.tencent.mm.protocal.protobuf.cfe;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.ai;

public class LaunchAABeforeUI
  extends AppCompatActivity
{
  private String appId;
  private String icv;
  private com.tencent.mm.al.g icw;
  private Dialog tipDialog;
  
  public LaunchAABeforeUI()
  {
    AppMethodBeat.i(63575);
    this.icw = new com.tencent.mm.al.g()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, n paramAnonymousn)
      {
        AppMethodBeat.i(63573);
        ad.i("MicroMsg.Aa.LaunchAABeforeUI", "onSceneEnd() errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " errMsg:" + paramAnonymousString + " netsceneType:" + paramAnonymousn.getType());
        if ((paramAnonymousn instanceof NetSceneNewAAQueryPFInfo))
        {
          if (LaunchAABeforeUI.a(LaunchAABeforeUI.this) != null) {
            LaunchAABeforeUI.a(LaunchAABeforeUI.this).dismiss();
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (NetSceneNewAAQueryPFInfo)paramAnonymousn;
            if (paramAnonymousString.iao == null) {}
            for (paramAnonymousString = null;; paramAnonymousString = paramAnonymousString.iao)
            {
              ad.i("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo retcode:%s retmsg:%s", new Object[] { Integer.valueOf(paramAnonymousString.dcG), paramAnonymousString.nTK });
              if (paramAnonymousString.dcG != 0) {
                break;
              }
              paramAnonymousn = new Intent();
              paramAnonymousn.putExtra("enter_scene", 6);
              paramAnonymousn.putExtra("pfInfo", NetSceneNewAAQueryPFInfo.a(paramAnonymousString));
              paramAnonymousn.putExtra("pfOrderNo", LaunchAABeforeUI.b(LaunchAABeforeUI.this));
              e.a(paramAnonymousString.Ebu);
              if (com.tencent.mm.sdk.platformtools.h.DEBUG) {
                ad.d("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo PfInfoParcel:%s", new Object[] { NetSceneNewAAQueryPFInfo.a(paramAnonymousString) });
              }
              d.b(LaunchAABeforeUI.this, "aa", ".ui.LaunchAAUI", paramAnonymousn);
              LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
              LaunchAABeforeUI.this.finish();
              AppMethodBeat.o(63573);
              return;
            }
            paramAnonymousn = LaunchAABeforeUI.this;
            if (bt.isNullOrNil(paramAnonymousString.nTK)) {}
            for (paramAnonymousString = LaunchAABeforeUI.this.getString(2131760654);; paramAnonymousString = paramAnonymousString.nTK)
            {
              com.tencent.mm.ui.base.h.a(paramAnonymousn, paramAnonymousString, "", LaunchAABeforeUI.this.getString(2131760658), new DialogInterface.OnClickListener()
              {
                public final void onClick(DialogInterface paramAnonymous2DialogInterface, int paramAnonymous2Int)
                {
                  AppMethodBeat.i(63572);
                  LaunchAABeforeUI.a(LaunchAABeforeUI.this, true);
                  LaunchAABeforeUI.this.finish();
                  AppMethodBeat.o(63572);
                }
              });
              AppMethodBeat.o(63573);
              return;
            }
          }
          LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
          com.tencent.mm.ui.base.h.cf(LaunchAABeforeUI.this, paramAnonymousString);
          LaunchAABeforeUI.this.finish();
        }
        AppMethodBeat.o(63573);
      }
    };
    AppMethodBeat.o(63575);
  }
  
  public void finish()
  {
    AppMethodBeat.i(63577);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(63577);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63576);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    ai.r(this, getResources().getColor(2131101053));
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(1809, this.icw);
    this.icv = getIntent().getStringExtra("pfOrderNo");
    this.appId = getIntent().getStringExtra("appid");
    this.tipDialog = com.tencent.mm.ui.base.h.a(this, 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
    {
      public final void onCancel(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(63574);
        if ((LaunchAABeforeUI.a(LaunchAABeforeUI.this) != null) && (LaunchAABeforeUI.a(LaunchAABeforeUI.this).isShowing())) {
          LaunchAABeforeUI.a(LaunchAABeforeUI.this).dismiss();
        }
        LaunchAABeforeUI.this.finish();
        AppMethodBeat.o(63574);
      }
    });
    paramBundle = new NetSceneNewAAQueryPFInfo(this.icv, this.appId);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.a(paramBundle, 0);
    setResult(0);
    AppMethodBeat.o(63576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63578);
    com.tencent.mm.kernel.g.afC();
    com.tencent.mm.kernel.g.afA().gcy.b(1809, this.icw);
    super.onDestroy();
    AppMethodBeat.o(63578);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI
 * JD-Core Version:    0.7.0.1
 */