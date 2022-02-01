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
import com.tencent.mm.ak.c.a;
import com.tencent.mm.co.f;
import com.tencent.mm.plugin.luckymoney.a.b;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBaseUI;
import com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyDetailUI;
import com.tencent.mm.protocal.protobuf.bfb;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.h;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyHKBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private static final String yUb;
  private Dialog tipDialog;
  private String yUc;
  private com.tencent.mm.plugin.luckymoney.hk.a.a yUd;
  
  static
  {
    AppMethodBeat.i(213280);
    yUb = MMApplicationContext.getContext().getResources().getString(2131768354);
    AppMethodBeat.o(213280);
  }
  
  private void eeX()
  {
    AppMethodBeat.i(213276);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "go to detail ui");
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(213271);
        Object localObject = new Intent(LuckyMoneyHKBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
        ((Intent)localObject).putExtras(LuckyMoneyHKBeforeDetailUI.this.getIntent());
        ((Intent)localObject).putExtra("key_hk_flag", 1);
        LuckyMoneyHKBeforeDetailUI localLuckyMoneyHKBeforeDetailUI = LuckyMoneyHKBeforeDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyHKBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyHKBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyHKBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/hk/ui/LuckyMoneyHKBeforeDetailUI$1", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(213270);
            LuckyMoneyHKBeforeDetailUI.this.finish();
            AppMethodBeat.o(213270);
          }
        }, 500L);
        AppMethodBeat.o(213271);
      }
    }.run();
    AppMethodBeat.o(213276);
  }
  
  public void finish()
  {
    AppMethodBeat.i(213275);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(213275);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(213274);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 2130772143);
    ao.q(this, getResources().getColor(2131101287));
    setContentViewVisibility(8);
    this.yUc = getIntent().getStringExtra("key_sendid");
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid=" + Util.nullAsNil(this.yUc) + ", nativeurl=" + Util.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (b.aDn(this.yUc) != null)
      {
        eeX();
        AppMethodBeat.o(213274);
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
            b.a(this.yUc, (com.tencent.mm.plugin.luckymoney.model.q)localObject1);
            eeX();
            AppMethodBeat.o(213274);
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
    if ((Util.isNullOrNil(this.yUc)) && (!Util.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.yUc = ((Uri)localObject2).getQueryParameter("sendid");
      label251:
      if (!Util.isNullOrNil(this.yUc))
      {
        localObject2 = this.yUc;
        this.tipDialog = h.a(getContext(), 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(213272);
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
            AppMethodBeat.o(213272);
          }
        });
        Log.i("MicroMsg.LuckyMoneyHKBeforeDetailUI", "do query detail");
        this.yUd = new com.tencent.mm.plugin.luckymoney.hk.a.a(paramBundle, (String)localObject2, 0, getIntent().getIntExtra("key_hk_scene", 0));
        this.yUd.aYI().b(new com.tencent.mm.vending.c.a() {}).a(this);
        AppMethodBeat.o(213274);
        return;
      }
      Log.w("MicroMsg.LuckyMoneyHKBeforeDetailUI", "sendid null or nil, finish");
      finish();
      AppMethodBeat.o(213274);
      return;
    }
    catch (Exception localException2)
    {
      break label251;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.hk.ui.LuckyMoneyHKBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */