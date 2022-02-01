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
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.n.d;
import com.tencent.mm.ui.base.n.e;
import com.tencent.mm.ui.q;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.e.b;

@com.tencent.mm.ui.base.a(7)
public class FloatBallProxyUI
  extends MMActivity
{
  private com.tencent.mm.ui.widget.a.d mHN;
  private BallInfo nLK = null;
  private e nMW;
  private int nMX = 0;
  private boolean nMY = false;
  private boolean nMZ = false;
  private boolean nNa = false;
  
  public static void a(Context paramContext, BallInfo paramBallInfo, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(209496);
    if (paramContext == null) {
      paramContext = ak.getContext();
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, FloatBallProxyUI.class);
      if (paramBallInfo != null) {
        localIntent.putExtra("key_ball_info", paramBallInfo);
      }
      localIntent.putExtra("key_can_message_ball", paramBoolean);
      localIntent.putExtra("key_proxy_mode", 1);
      localIntent.putExtra("key_result_callback", new ResultReceiver(aq.createFreeHandler(Looper.getMainLooper()))
      {
        protected final void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(106282);
          if (parama != null) {
            parama.eH(this.nNc, paramAnonymousInt);
          }
          AppMethodBeat.o(106282);
        }
      });
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramBallInfo = new com.tencent.mm.hellhoundlib.b.a().bc(localIntent);
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, paramBallInfo.ahE(), "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramBallInfo.mt(0));
      com.tencent.mm.hellhoundlib.a.a.a(paramContext, "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(209496);
      return;
    }
  }
  
  public static void a(a parama)
  {
    AppMethodBeat.i(209495);
    a(null, null, false, parama);
    AppMethodBeat.o(209495);
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
    q.b(getWindow());
    q.c(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null) {
      finish();
    }
    this.nMX = getIntent().getIntExtra("key_proxy_mode", 1);
    if (this.nMX == 1)
    {
      paramBundle = getResources().getString(2131759445);
      String str = getResources().getString(2131759446);
      this.nMZ = false;
      this.mHN = h.a(this, paramBundle, "", str, new DialogInterface.OnClickListener()
      {
        public final void onClick(DialogInterface paramAnonymousDialogInterface, int paramAnonymousInt)
        {
          AppMethodBeat.i(106286);
          ae.i("MicroMsg.FloatBallProxyUI", "click ok");
          FloatBallProxyUI.a(FloatBallProxyUI.this);
          FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106286);
        }
      });
      this.mHN.setOnDismissListener(new DialogInterface.OnDismissListener()
      {
        public final void onDismiss(DialogInterface paramAnonymousDialogInterface)
        {
          AppMethodBeat.i(106287);
          ae.i("MicroMsg.FloatBallProxyUI", "dismiss dialog");
          FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
          FloatBallProxyUI.this.finish();
          AppMethodBeat.o(106287);
        }
      });
    }
    for (;;)
    {
      this.nLK = ((BallInfo)getIntent().getParcelableExtra("key_ball_info"));
      this.nNa = getIntent().getBooleanExtra("key_can_message_ball", false);
      AppMethodBeat.o(106290);
      return;
      if (this.nMX == 2)
      {
        this.nMW = new e(this, 1, true);
        paramBundle = getString(2131759460);
        this.nMW.p(paramBundle, 17);
        this.nMW.LfS = new n.d()
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
        this.nMW.LfT = new n.e()
        {
          public final void onMMMenuItemSelected(MenuItem paramAnonymousMenuItem, int paramAnonymousInt)
          {
            AppMethodBeat.i(106284);
            if (paramAnonymousMenuItem.getItemId() == 0)
            {
              ae.i("MicroMsg.FloatBallProxyUI", "click remove all balls");
              FloatBallProxyUI.a(FloatBallProxyUI.this, 1);
              FloatBallProxyUI.this.finish();
              AppMethodBeat.o(106284);
              return;
            }
            ae.i("MicroMsg.FloatBallProxyUI", "click cancel remove all balls");
            FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
            FloatBallProxyUI.this.finish();
            AppMethodBeat.o(106284);
          }
        };
        this.nMW.KtV = new e.b()
        {
          public final void onDismiss()
          {
            AppMethodBeat.i(106285);
            ae.i("MicroMsg.FloatBallProxyUI", "dismiss bottom sheet");
            FloatBallProxyUI.a(FloatBallProxyUI.this, 2);
            FloatBallProxyUI.this.finish();
            AppMethodBeat.o(106285);
          }
        };
        this.nMW.cPF();
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
    if ((this.mHN != null) && (this.mHN.isShowing()))
    {
      this.mHN.dismiss();
      this.mHN = null;
    }
    if ((this.nMW != null) && (this.nMW.isShowing()))
    {
      this.nMW.bqD();
      this.nMW = null;
    }
    AppMethodBeat.o(106292);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(209497);
    super.onPause();
    ae.i("MicroMsg.FloatBallProxyUI", "alvinluo onPause proxyType: %d, hasConfirmed: %b, canAddMessageBall: %b, ballInfo: %s", new Object[] { Integer.valueOf(this.nMX), Boolean.valueOf(this.nMZ), Boolean.valueOf(this.nNa), this.nLK });
    if ((this.nMX == 1) && (!this.nMZ) && (this.nNa) && (this.nLK != null)) {
      com.tencent.mm.plugin.ball.service.d.bLK().u(this.nLK);
    }
    AppMethodBeat.o(209497);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void eH(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.FloatBallProxyUI
 * JD-Core Version:    0.7.0.1
 */