package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.b.a;
import com.tencent.mm.am.p;
import com.tencent.mm.cp.f;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.bzx;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private static final String KqL;
  private String KqM;
  private com.tencent.mm.plugin.luckymoney.hk.a.a KqN;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(283846);
    KqL = MMApplicationContext.getContext().getResources().getString(a.i.wallet_unknown_err);
    AppMethodBeat.o(283846);
  }
  
  private void fWP()
  {
    AppMethodBeat.i(283829);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "go to detail ui");
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(283839);
        Object localObject = new Intent(LuckyMoneyHKBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
        ((Intent)localObject).putExtras(LuckyMoneyHKBeforeDetailUI.this.getIntent());
        ((Intent)localObject).putExtra("key_hk_flag", 1);
        LuckyMoneyHKBeforeDetailUI localLuckyMoneyHKBeforeDetailUI = LuckyMoneyHKBeforeDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyHKBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyHKBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyHKBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(283834);
            LuckyMoneyHKBeforeDetailUI.this.finish();
            AppMethodBeat.o(283834);
          }
        }, 500L);
        AppMethodBeat.o(283839);
      }
    }.run();
    AppMethodBeat.o(283829);
  }
  
  public void finish()
  {
    AppMethodBeat.i(283855);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(283855);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(283851);
    super.onCreate(paramBundle);
    overridePendingTransition(0, a.a.receive_fade_out);
    aw.t(this, getResources().getColor(a.c.transparent));
    setContentViewVisibility(8);
    this.KqM = getIntent().getStringExtra("key_sendid");
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid=" + Util.nullAsNil(this.KqM) + ", nativeurl=" + Util.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (b.aKs(this.KqM) != null)
      {
        fWP();
        AppMethodBeat.o(283851);
        return;
      }
      try
      {
        Object localObject1 = getIntent().getByteArrayExtra("key_detail_info");
        if (localObject1 != null)
        {
          localObject1 = (q)new q().parseFrom((byte[])localObject1);
          if (localObject1 != null)
          {
            b.a(this.KqM, (q)localObject1);
            fWP();
            AppMethodBeat.o(283851);
            return;
          }
        }
      }
      catch (Exception localException1)
      {
        Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + localException1.getLocalizedMessage());
      }
    }
    Object localObject2;
    if ((Util.isNullOrNil(this.KqM)) && (!Util.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.KqM = ((Uri)localObject2).getQueryParameter("sendid");
      label253:
      if (!Util.isNullOrNil(this.KqM))
      {
        localObject2 = this.KqM;
        this.tipDialog = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(283841);
            if ((LuckyMoneyHKBeforeDetailUI.a(LuckyMoneyHKBeforeDetailUI.this) != null) && (LuckyMoneyHKBeforeDetailUI.a(LuckyMoneyHKBeforeDetailUI.this).isShowing())) {
              LuckyMoneyHKBeforeDetailUI.a(LuckyMoneyHKBeforeDetailUI.this).dismiss();
            }
            if (LuckyMoneyHKBeforeDetailUI.b(LuckyMoneyHKBeforeDetailUI.this) != null) {
              LuckyMoneyHKBeforeDetailUI.b(LuckyMoneyHKBeforeDetailUI.this).cancel();
            }
            if ((LuckyMoneyHKBeforeDetailUI.c(LuckyMoneyHKBeforeDetailUI.this).getVisibility() == 8) || (LuckyMoneyHKBeforeDetailUI.d(LuckyMoneyHKBeforeDetailUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "user cancel & finish");
              LuckyMoneyHKBeforeDetailUI.this.finish();
            }
            AppMethodBeat.o(283841);
          }
        });
        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail");
        this.KqN = new com.tencent.mm.plugin.luckymoney.hk.a.a(paramBundle, (String)localObject2, 0, getIntent().getIntExtra("key_hk_scene", 0));
        this.KqN.bFJ().b(new com.tencent.mm.vending.c.a() {}).a(this);
        AppMethodBeat.o(283851);
        return;
      }
      Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid null or nil, finish");
      finish();
      AppMethodBeat.o(283851);
      return;
    }
    catch (Exception localException2)
    {
      break label253;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */