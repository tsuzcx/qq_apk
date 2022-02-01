package com.tencent.mm.plugin.aa.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.am.s;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo;
import com.tencent.mm.plugin.aa.model.f;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.ekn;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;

public class LaunchAABeforeUI
  extends AppCompatActivity
{
  private String appId;
  private String pKg;
  private com.tencent.mm.am.h pKh;
  private Dialog tipDialog;
  
  public LaunchAABeforeUI()
  {
    AppMethodBeat.i(63575);
    this.pKh = new com.tencent.mm.am.h()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, p paramAnonymousp)
      {
        AppMethodBeat.i(63573);
        Log.i("MicroMsg.Aa.LaunchAABeforeUI", "onSceneEnd() errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " errMsg:" + paramAnonymousString + " netsceneType:" + paramAnonymousp.getType());
        if ((paramAnonymousp instanceof NetSceneNewAAQueryPFInfo))
        {
          if (LaunchAABeforeUI.a(LaunchAABeforeUI.this) != null) {
            LaunchAABeforeUI.a(LaunchAABeforeUI.this).dismiss();
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (NetSceneNewAAQueryPFInfo)paramAnonymousp;
            if (paramAnonymousString.pHn == null) {}
            for (paramAnonymousString = null;; paramAnonymousString = paramAnonymousString.pHn)
            {
              Log.i("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo retcode:%s retmsg:%s", new Object[] { Integer.valueOf(paramAnonymousString.hAV), paramAnonymousString.wYI });
              if (paramAnonymousString.hAV != 0) {
                break;
              }
              paramAnonymousp = new Intent();
              paramAnonymousp.putExtra("enter_scene", 6);
              paramAnonymousp.putExtra("pfInfo", NetSceneNewAAQueryPFInfo.a(paramAnonymousString));
              paramAnonymousp.putExtra("pfOrderNo", LaunchAABeforeUI.b(LaunchAABeforeUI.this));
              f.a(paramAnonymousString.abpz);
              if (BuildInfo.DEBUG) {
                Log.d("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo PfInfoParcel:%s", new Object[] { NetSceneNewAAQueryPFInfo.a(paramAnonymousString) });
              }
              com.tencent.mm.br.c.b(LaunchAABeforeUI.this, "aa", ".ui.LaunchAAUI", paramAnonymousp);
              LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
              LaunchAABeforeUI.this.finish();
              AppMethodBeat.o(63573);
              return;
            }
            paramAnonymousp = LaunchAABeforeUI.this;
            if (Util.isNullOrNil(paramAnonymousString.wYI)) {}
            for (paramAnonymousString = LaunchAABeforeUI.this.getString(a.i.launch_aa_error_msg);; paramAnonymousString = paramAnonymousString.wYI)
            {
              k.a(paramAnonymousp, paramAnonymousString, "", LaunchAABeforeUI.this.getString(a.i.launch_aa_i_know), new DialogInterface.OnClickListener()
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
          k.cZ(LaunchAABeforeUI.this, paramAnonymousString);
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
  
  public Resources getResources()
  {
    AppMethodBeat.i(268520);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(268520);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63576);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    aw.t(this, getResources().getColor(a.c.transparent));
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(1809, this.pKh);
    this.pKg = getIntent().getStringExtra("pfOrderNo");
    this.appId = getIntent().getStringExtra("appid");
    this.tipDialog = k.a(this, 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
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
    paramBundle = new NetSceneNewAAQueryPFInfo(this.pKg, this.appId);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.a(paramBundle, 0);
    setResult(0);
    AppMethodBeat.o(63576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63578);
    com.tencent.mm.kernel.h.baF();
    com.tencent.mm.kernel.h.baD().mCm.b(1809, this.pKh);
    super.onDestroy();
    AppMethodBeat.o(63578);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI
 * JD-Core Version:    0.7.0.1
 */