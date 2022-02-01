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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.br.c;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.aa.model.cgi.NetSceneNewAAQueryPFInfo;
import com.tencent.mm.plugin.aa.model.e;
import com.tencent.mm.protocal.protobuf.dia;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;

public class LaunchAABeforeUI
  extends AppCompatActivity
{
  private String appId;
  private String jWm;
  private i jWn;
  private Dialog tipDialog;
  
  public LaunchAABeforeUI()
  {
    AppMethodBeat.i(63575);
    this.jWn = new i()
    {
      public final void onSceneEnd(int paramAnonymousInt1, int paramAnonymousInt2, String paramAnonymousString, q paramAnonymousq)
      {
        AppMethodBeat.i(63573);
        Log.i("MicroMsg.Aa.LaunchAABeforeUI", "onSceneEnd() errType:" + paramAnonymousInt1 + " errCode:" + paramAnonymousInt2 + " errMsg:" + paramAnonymousString + " netsceneType:" + paramAnonymousq.getType());
        if ((paramAnonymousq instanceof NetSceneNewAAQueryPFInfo))
        {
          if (LaunchAABeforeUI.a(LaunchAABeforeUI.this) != null) {
            LaunchAABeforeUI.a(LaunchAABeforeUI.this).dismiss();
          }
          if ((paramAnonymousInt1 == 0) && (paramAnonymousInt2 == 0))
          {
            paramAnonymousString = (NetSceneNewAAQueryPFInfo)paramAnonymousq;
            if (paramAnonymousString.jTr == null) {}
            for (paramAnonymousString = null;; paramAnonymousString = paramAnonymousString.jTr)
            {
              Log.i("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo retcode:%s retmsg:%s", new Object[] { Integer.valueOf(paramAnonymousString.dDN), paramAnonymousString.qwn });
              if (paramAnonymousString.dDN != 0) {
                break;
              }
              paramAnonymousq = new Intent();
              paramAnonymousq.putExtra("enter_scene", 6);
              paramAnonymousq.putExtra("pfInfo", NetSceneNewAAQueryPFInfo.a(paramAnonymousString));
              paramAnonymousq.putExtra("pfOrderNo", LaunchAABeforeUI.b(LaunchAABeforeUI.this));
              e.a(paramAnonymousString.MMI);
              if (BuildInfo.DEBUG) {
                Log.d("MicroMsg.Aa.LaunchAABeforeUI", "NetSceneNewAAQueryPFInfo PfInfoParcel:%s", new Object[] { NetSceneNewAAQueryPFInfo.a(paramAnonymousString) });
              }
              c.b(LaunchAABeforeUI.this, "aa", ".ui.LaunchAAUI", paramAnonymousq);
              LaunchAABeforeUI.a(LaunchAABeforeUI.this, false);
              LaunchAABeforeUI.this.finish();
              AppMethodBeat.o(63573);
              return;
            }
            paramAnonymousq = LaunchAABeforeUI.this;
            if (Util.isNullOrNil(paramAnonymousString.qwn)) {}
            for (paramAnonymousString = LaunchAABeforeUI.this.getString(2131762176);; paramAnonymousString = paramAnonymousString.qwn)
            {
              h.a(paramAnonymousq, paramAnonymousString, "", LaunchAABeforeUI.this.getString(2131762180), new DialogInterface.OnClickListener()
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
          h.cD(LaunchAABeforeUI.this, paramAnonymousString);
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
    AppMethodBeat.i(213014);
    Resources localResources = MMApplicationContext.getResources();
    AppMethodBeat.o(213014);
    return localResources;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(63576);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    getWindow().getDecorView().setSystemUiVisibility(1280);
    ao.q(this, getResources().getColor(2131101287));
    g.aAi();
    g.aAg().hqi.a(1809, this.jWn);
    this.jWm = getIntent().getStringExtra("pfOrderNo");
    this.appId = getIntent().getStringExtra("appid");
    this.tipDialog = h.a(this, 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
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
    paramBundle = new NetSceneNewAAQueryPFInfo(this.jWm, this.appId);
    g.aAi();
    g.aAg().hqi.a(paramBundle, 0);
    setResult(0);
    AppMethodBeat.o(63576);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(63578);
    g.aAi();
    g.aAg().hqi.b(1809, this.jWn);
    super.onDestroy();
    AppMethodBeat.o(63578);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.LaunchAABeforeUI
 * JD-Core Version:    0.7.0.1
 */