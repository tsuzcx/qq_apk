package com.tencent.mm.plugin.ball.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.ResultReceiver;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.o.f;
import com.tencent.mm.ui.base.o.g;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

@com.tencent.mm.ui.base.a(7)
public class FloatBallProxyUI
  extends MMActivity
{
  private com.tencent.mm.ui.widget.a.d nUK;
  private BallInfo oWE = null;
  private e oXS;
  private int oXT = 0;
  private boolean oXU = false;
  private boolean oXV = false;
  private boolean oXW = false;
  
  private void BJ(int paramInt)
  {
    AppMethodBeat.i(217051);
    String str1 = getResources().getString(paramInt);
    String str2 = getResources().getString(2131760759);
    this.oXV = false;
    this.nUK = h.a(this, str1, "", str2, new DialogInterface.OnClickListener()
    {
      public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
      {
        AppMethodBeat.i(106286);
        Log.i("MicroMsg.FloatBallProxyUI", "click ok");
        FloatBallProxyUI.a(FloatBallProxyUI.this);
        FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
        FloatBallProxyUI.this.finish();
        AppMethodBeat.o(106286);
      }
    });
    this.nUK.setOnDismissListener(new DialogInterface.OnDismissListener()
    {
      public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
      {
        AppMethodBeat.i(106287);
        Log.i("MicroMsg.FloatBallProxyUI", "dismiss dialog");
        FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
        FloatBallProxyUI.this.finish();
        AppMethodBeat.o(106287);
      }
    });
    AppMethodBeat.o(217051);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(217048);
    a(null, paramInt, null, false, parama);
    AppMethodBeat.o(217048);
  }
  
  public static void a(Context paramContext, final int paramInt, BallInfo paramBallInfo, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(217049);
    if (paramContext == null) {
      paramContext = MMApplicationContext.getContext();
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, FloatBallProxyUI.class);
      if (paramBallInfo != null) {
        localIntent.putExtra("key_ball_info", paramBallInfo);
      }
      localIntent.putExtra("key_can_message_ball", paramBoolean);
      localIntent.putExtra("key_proxy_mode", paramInt);
      localIntent.putExtra("key_result_callback", new ResultReceiver(MMHandler.createFreeHandler(Looper.getMainLooper()))
      {
        protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(106282);
          if (parama != null) {
            parama.eU(paramInt, paramAnonymousInt);
          }
          AppMethodBeat.o(106282);
        }
      });
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramBallInfo = new com.tencent.mm.hellhoundlib.b.a().bl(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBallInfo.axQ(), "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramBallInfo.pG(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(217049);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(106291);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(106291);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(106290);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 0);
    r.e(getWindow());
    r.d(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null) {
      finish();
    }
    this.oXT = getIntent().getIntExtra("key_proxy_mode", 1);
    switch (this.oXT)
    {
    }
    for (;;)
    {
      this.oWE = ((BallInfo)getIntent().getParcelableExtra("key_ball_info"));
      this.oXW = getIntent().getBooleanExtra("key_can_message_ball", false);
      AppMethodBeat.o(106290);
      return;
      BJ(2131760758);
      continue;
      this.oXS = new e(this, 1, true);
      paramBundle = getString(2131760774);
      this.oXS.o(paramBundle, 17);
      this.oXS.HLX = new o.f()
      {
        public final void onCreateMMMenu(m paramAnonymousm)
        {
          AppMethodBeat.i(106283);
          paramAnonymousm.clear();
          paramAnonymousm.a(0, -65536, FloatBallProxyUI.this.getString(2131760763));
          paramAnonymousm.a(1, -16777216, FloatBallProxyUI.this.getString(2131760761));
          AppMethodBeat.o(106283);
        }
      };
      this.oXS.HLY = new o.g()
      {
        public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
        {
          AppMethodBeat.i(106284);
          if (paramAnonymousMenuItem.getItemId() == 0)
          {
            Log.i("MicroMsg.FloatBallProxyUI", "click remove all balls");
            FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
            FloatBallProxyUI.this.finish();
            AppMethodBeat.o(106284);
            return;
          }
          Log.i("MicroMsg.FloatBallProxyUI", "click cancel remove all balls");
          FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106284);
        }
      };
      this.oXS.PGl = new e.b()
      {
        public final void onDismiss()
        {
          AppMethodBeat.i(106285);
          Log.i("MicroMsg.FloatBallProxyUI", "dismiss bottom sheet");
          FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106285);
        }
      };
      this.oXS.dGm();
      continue;
      BJ(2131760775);
    }
  }
  
  public void onCreateBeforeSetContentView()
  {
    AppMethodBeat.i(106289);
    super.onCreateBeforeSetContentView();
    supportRequestWindowFeature(1);
    AppMethodBeat.o(106289);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(106292);
    super.onDestroy();
    if ((this.nUK != null) && (this.nUK.isShowing()))
    {
      this.nUK.dismiss();
      this.nUK = null;
    }
    if ((this.oXS != null) && (this.oXS.isShowing()))
    {
      this.oXS.bMo();
      this.oXS = null;
    }
    AppMethodBeat.o(106292);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(217050);
    super.onPause();
    Log.i("MicroMsg.FloatBallProxyUI", "alvinluo onPause proxyType: %d, hasConfirmed: %b, canAddMessageBall: %b, ballInfo: %s", new Object[] { Integer.valueOf(this.oXT), Boolean.valueOf(this.oXV), Boolean.valueOf(this.oXW), this.oWE });
    if ((this.oXT == 1) && (!this.oXV) && (this.oXW) && (this.oWE != null)) {
      com.tencent.mm.plugin.ball.service.d.ciB().t(this.oWE);
    }
    AppMethodBeat.o(217050);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void eU(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.FloatBallProxyUI
 * JD-Core Version:    0.7.0.1
 */