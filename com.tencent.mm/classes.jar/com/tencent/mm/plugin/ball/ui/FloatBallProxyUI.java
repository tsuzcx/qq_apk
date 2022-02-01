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
import com.tencent.mm.plugin.ball.a.h;
import com.tencent.mm.plugin.ball.model.BallInfo;
import com.tencent.mm.plugin.ball.service.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandler;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.u.g;
import com.tencent.mm.ui.base.u.i;
import com.tencent.mm.ui.v;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.a.f;
import com.tencent.mm.ui.widget.a.f.b;

@com.tencent.mm.ui.base.a(7)
public class FloatBallProxyUI
  extends MMActivity
{
  private e ubT;
  private BallInfo vjV = null;
  private f vlk;
  private int vll = 0;
  private boolean vlm = false;
  private boolean vln = false;
  private boolean vlo = false;
  
  private void FL(int paramInt)
  {
    AppMethodBeat.i(288299);
    String str1 = getResources().getString(paramInt);
    String str2 = getResources().getString(a.h.float_ball_dialog_ok);
    this.vln = false;
    this.ubT = k.a(this, str1, "", str2, new DialogInterface.OnClickListener()
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
    this.ubT.setOnDismissListener(new DialogInterface.OnDismissListener()
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
    AppMethodBeat.o(288299);
  }
  
  public static void a(int paramInt, a parama)
  {
    AppMethodBeat.i(288291);
    a(null, paramInt, null, false, parama);
    AppMethodBeat.o(288291);
  }
  
  public static void a(Context paramContext, final int paramInt, BallInfo paramBallInfo, boolean paramBoolean, final a parama)
  {
    AppMethodBeat.i(288295);
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
        protected void onReceiveResult(int paramAnonymousInt, Bundle paramAnonymousBundle)
        {
          AppMethodBeat.i(106282);
          if (parama != null) {
            parama.onCallback(paramInt, paramAnonymousInt);
          }
          AppMethodBeat.o(106282);
        }
      });
      if (!(paramContext instanceof Activity)) {
        localIntent.addFlags(268435456);
      }
      paramBallInfo = new com.tencent.mm.hellhoundlib.b.a().cG(localIntent);
      com.tencent.mm.hellhoundlib.a.a.b(paramContext, paramBallInfo.aYi(), "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramContext.startActivity((Intent)paramBallInfo.sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramContext, "com/tencent/mm/plugin/ball/ui/FloatBallProxyUI", "showFloatBallProxyUI", "(Landroid/content/Context;ILcom/tencent/mm/plugin/ball/model/BallInfo;ZLcom/tencent/mm/plugin/ball/ui/FloatBallProxyUI$OnFloatBallProxyUIResultCallback;)V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      AppMethodBeat.o(288295);
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
    v.g(getWindow());
    v.c(getWindow(), false);
    getWindow().setBackgroundDrawable(new ColorDrawable(0));
    if (getIntent() == null) {
      finish();
    }
    this.vll = getIntent().getIntExtra("key_proxy_mode", 1);
    switch (this.vll)
    {
    }
    for (;;)
    {
      this.vjV = ((BallInfo)getIntent().getParcelableExtra("key_ball_info"));
      this.vlo = getIntent().getBooleanExtra("key_can_message_ball", false);
      AppMethodBeat.o(106290);
      return;
      FL(a.h.float_ball_clean_to_add);
      continue;
      this.vlk = new f(this, 1, true);
      paramBundle = getString(a.h.float_ball_remove_all_balls_dialog_title);
      this.vlk.h(paramBundle, 17, 0);
      this.vlk.Vtg = new u.g()
      {
        public final void onCreateMMMenu(s paramAnonymouss)
        {
          AppMethodBeat.i(106283);
          paramAnonymouss.clear();
          paramAnonymouss.a(0, -65536, FloatBallProxyUI.this.getString(a.h.float_ball_menu_item_remove_all_balls));
          paramAnonymouss.a(1, -16777216, FloatBallProxyUI.this.getString(a.h.float_ball_menu_item_cancel_remove_all_balls));
          AppMethodBeat.o(106283);
        }
      };
      this.vlk.GAC = new u.i()
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
      this.vlk.aeLi = new f.b()
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
      this.vlk.dDn();
      continue;
      FL(a.h.float_ball_sync_with_handoff_fail);
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
    if ((this.ubT != null) && (this.ubT.isShowing()))
    {
      this.ubT.dismiss();
      this.ubT = null;
    }
    if ((this.vlk != null) && (this.vlk.isShowing()))
    {
      this.vlk.cyW();
      this.vlk = null;
    }
    AppMethodBeat.o(106292);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(288329);
    super.onPause();
    Log.i("MicroMsg.FloatBallProxyUI", "alvinluo onPause proxyType: %d, hasConfirmed: %b, canAddMessageBall: %b, ballInfo: %s", new Object[] { Integer.valueOf(this.vll), Boolean.valueOf(this.vln), Boolean.valueOf(this.vlo), this.vjV });
    if ((this.vll == 1) && (!this.vln) && (this.vlo) && (this.vjV != null)) {
      c.cYC().t(this.vjV);
    }
    AppMethodBeat.o(288329);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public static abstract interface a
  {
    public abstract void onCallback(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.ball.ui.FloatBallProxyUI
 * JD-Core Version:    0.7.0.1
 */