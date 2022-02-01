package com.tencent.mm.plugin.luckymoney.hk.ui;

import android.app.Activity;
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
import com.tencent.mm.an.c.a;
import com.tencent.mm.cw.f;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.plugin.wxpay.a.a;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.bmf;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private static final String ExY;
  private String ExZ;
  private com.tencent.mm.plugin.luckymoney.hk.a.a Eya;
  private Dialog tipDialog;
  
  static
  {
    AppMethodBeat.i(270967);
    ExY = MMApplicationContext.getContext().getResources().getString(a.i.wallet_unknown_err);
    AppMethodBeat.o(270967);
  }
  
  private void eOs()
  {
    AppMethodBeat.i(270962);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "go to detail ui");
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(274377);
        Object localObject = new Intent(LuckyMoneyHKBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
        ((Intent)localObject).putExtras(LuckyMoneyHKBeforeDetailUI.this.getIntent());
        ((Intent)localObject).putExtra("key_hk_flag", 1);
        LuckyMoneyHKBeforeDetailUI localLuckyMoneyHKBeforeDetailUI = LuckyMoneyHKBeforeDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bm(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyHKBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aFh(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyHKBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sf(0));
        com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyHKBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(187332);
            LuckyMoneyHKBeforeDetailUI.this.finish();
            AppMethodBeat.o(187332);
          }
        }, 500L);
        AppMethodBeat.o(274377);
      }
    }.run();
    AppMethodBeat.o(270962);
  }
  
  public void finish()
  {
    AppMethodBeat.i(270961);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(270961);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(270959);
    super.onCreate(paramBundle);
    overridePendingTransition(0, a.a.receive_fade_out);
    ar.r(this, getResources().getColor(a.c.transparent));
    setContentViewVisibility(8);
    this.ExZ = getIntent().getStringExtra("key_sendid");
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid=" + Util.nullAsNil(this.ExZ) + ", nativeurl=" + Util.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (b.aNx(this.ExZ) != null)
      {
        eOs();
        AppMethodBeat.o(270959);
        return;
      }
      try
      {
        Object localObject1 = getIntent().getByteArrayExtra("key_detail_info");
        if (localObject1 != null)
        {
          localObject1 = (com.tencent.mm.plugin.luckymoney.model.q)new com.tencent.mm.plugin.luckymoney.model.q().parseFrom((byte[])localObject1);
          if (localObject1 != null)
          {
            b.a(this.ExZ, (com.tencent.mm.plugin.luckymoney.model.q)localObject1);
            eOs();
            AppMethodBeat.o(270959);
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
    if ((Util.isNullOrNil(this.ExZ)) && (!Util.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.ExZ = ((Uri)localObject2).getQueryParameter("sendid");
      label253:
      if (!Util.isNullOrNil(this.ExZ))
      {
        localObject2 = this.ExZ;
        this.tipDialog = h.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(270697);
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
            AppMethodBeat.o(270697);
          }
        });
        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail");
        this.Eya = new com.tencent.mm.plugin.luckymoney.hk.a.a(paramBundle, (String)localObject2, 0, getIntent().getIntExtra("key_hk_scene", 0));
        this.Eya.bhW().b(new com.tencent.mm.vending.c.a() {}).a(this);
        AppMethodBeat.o(270959);
        return;
      }
      Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid null or nil, finish");
      finish();
      AppMethodBeat.o(270959);
      return;
    }
    catch (Exception localException2)
    {
      break label253;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */