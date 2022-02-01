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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

@com.tencent.mm.ui.base.a(7)
public class FloatBallProxyUI
  extends MMActivity
{
  private com.tencent.mm.ui.widget.a.d lAE;
  private BallInfo mDH = null;
  private e mET;
  private int mEU = 0;
  private boolean mEV = false;
  private boolean mEW = false;
  private boolean mEX = false;
  
  public static void a(Context paramContext, BallInfo paramBallInfo, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(190657);
    if (paramContext == null) {
      paramContext = aj.getContext();
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, FloatBallProxyUI.class);
      if (paramBallInfo != null) {
        localIntent.putExtra("key_ball_info", paramBallInfo);
      }
      localIntent.putExtra("key_can_message_ball", paramBoolean);
      localIntent.putExtra("key_proxy_mode", 1);
      localIntent.putExtra("key_result_callback", new ResultReceiver(ap.createFreeHandler(Looper.getMainLooper()))
      {
        protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(106282);
          if (parama != null) {
            parama.wC(paramAnonymousInt);
          }
          AppMethodBeat.o(106282);
        }
      });
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramBallInfo = new com.tencent.mm.hellhoundlib.b.a().bd(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBallInfo.adn(), "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramBallInfo.lS(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(190657);
      return;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(190656);
    a(null, null, false, parama);
    AppMethodBeat.o(190656);
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
    p.b(getWindow());
    p.c(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null) {
      finish();
    }
    this.mEU = getIntent().getIntExtra("key_proxy_mode", 1);
    if (this.mEU == 1)
    {
      paramBundle = getResources().getString(2131759445);
      String str = getResources().getString(2131759446);
      this.mEW = false;
      this.lAE = h.a(this, paramBundle, "", str, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106286);
          ad.i("MicroMsg.FloatBallProxyUI", "click ok");
          FloatBallProxyUI.a(FloatBallProxyUI.this);
          FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106286);
        }
      });
      this.lAE.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(106287);
          ad.i("MicroMsg.FloatBallProxyUI", "dismiss dialog");
          FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106287);
        }
      });
    }
    for (;;)
    {
      this.mDH = ((BallInfo)getIntent().getParcelableExtra("key_ball_info"));
      this.mEX = getIntent().getBooleanExtra("key_can_message_ball", false);
      AppMethodBeat.o(106290);
      return;
      if (this.mEU == 2)
      {
        this.mET = new e(this, 1, true);
        paramBundle = getString(2131759460);
        this.mET.q(paramBundle, 17);
        this.mET.HrX = new n.c()
        {
          public final void onCreateMMMenu(l paramAnonymousl)
          {
            AppMethodBeat.i(106283);
            paramAnonymousl.clear();
            paramAnonymousl.a(0, -65536, FloatBallProxyUI.this.getString(2131759449));
            paramAnonymousl.a(1, -16777216, FloatBallProxyUI.this.getString(2131759448));
            AppMethodBeat.o(106283);
          }
        };
        this.mET.HrY = new n.d()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(106284);
            if (paramAnonymousMenuItem.getItemId() == 0)
            {
              ad.i("MicroMsg.FloatBallProxyUI", "click remove all balls");
              FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
              FloatBallProxyUI.this.finish();
              AppMethodBeat.o(106284);
              return;
            }
            ad.i("MicroMsg.FloatBallProxyUI", "click cancel remove all balls");
            FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
            FloatBallProxyUI.this.finish();
            AppMethodBeat.o(106284);
          }
        };
        this.mET.GHn = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(106285);
            ad.i("MicroMsg.FloatBallProxyUI", "dismiss bottom sheet");
            FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
            FloatBallProxyUI.this.finish();
            AppMethodBeat.o(106285);
          }
        };
        this.mET.csG();
      }
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
    if ((this.lAE != null) && (this.lAE.isShowing()))
    {
      this.lAE.dismiss();
      this.lAE = null;
    }
    if ((this.mET != null) && (this.mET.isShowing()))
    {
      this.mET.bfo();
      this.mET = null;
    }
    AppMethodBeat.o(106292);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(190658);
    super.onPause();
    ad.i("MicroMsg.FloatBallProxyUI", "alvinluo onPause proxyType: %d, hasConfirmed: %b, canAddMessageBall: %b, ballInfo: %s", new Object[] { Integer.valueOf(this.mEU), Boolean.valueOf(this.mEW), Boolean.valueOf(this.mEX), this.mDH });
    if ((this.mEU == 1) && (!this.mEW) && (this.mEX) && (this.mDH != null)) {
      com.tencent.mm.plugin.ball.service.d.bzH().r(this.mDH);
    }
    AppMethodBeat.o(190658);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void wC(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.FloatBallProxyUI
 * JD-Core Version:    0.7.0.1
 */