package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.aq;
import com.tencent.mm.plugin.luckymoney.model.ar;
import com.tencent.mm.plugin.luckymoney.model.bj;
import com.tencent.mm.plugin.luckymoney.model.q;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.wxpay.a.c;
import com.tencent.mm.plugin.wxpay.a.i;
import com.tencent.mm.plugin.wxpay.a.j;
import com.tencent.mm.protocal.protobuf.crg;
import com.tencent.mm.protocal.protobuf.czi;
import com.tencent.mm.protocal.protobuf.eoh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.base.k;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private int KmN;
  private String KqM;
  private int KzF;
  private com.tencent.mm.plugin.luckymoney.story.a.b KzG;
  private String KzH;
  private String KzI;
  private int KzJ;
  private int lCR;
  private String sWX;
  private Dialog tipDialog;
  
  private void fWP()
  {
    AppMethodBeat.i(163705);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
    if (this.tipDialog != null) {
      this.tipDialog.dismiss();
    }
    new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(163702);
        Object localObject = new Intent(LuckyMoneyBeforeDetailUI.this.getContext(), LuckyMoneyDetailUI.class);
        ((Intent)localObject).putExtras(LuckyMoneyBeforeDetailUI.this.getIntent());
        LuckyMoneyBeforeDetailUI localLuckyMoneyBeforeDetailUI = LuckyMoneyBeforeDetailUI.this;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(localLuckyMoneyBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(localLuckyMoneyBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        MMHandlerThread.postToMainThreadDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(163701);
            LuckyMoneyBeforeDetailUI.this.finish();
            AppMethodBeat.o(163701);
          }
        }, 500L);
        AppMethodBeat.o(163702);
      }
    }.run();
    AppMethodBeat.o(163705);
  }
  
  private void fYf()
  {
    AppMethodBeat.i(163704);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "try fetch story info");
    if (!getIntent().getBooleanExtra("key_has_story", true))
    {
      Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no story, don't fetch data");
      fWP();
      AppMethodBeat.o(163704);
      return;
    }
    final String str = getIntent().getStringExtra("key_packet_id");
    Object localObject;
    if (Util.isNullOrNil(str))
    {
      localObject = com.tencent.mm.plugin.luckymoney.a.b.aKs(this.KqM);
      if (localObject != null)
      {
        localObject = bj.aKE(((q)localObject).Ksl);
        if ((localObject != null) && (((bj)localObject).Krm != null)) {
          str = ((bj)localObject).Krm.ZoK;
        }
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no packet id");
        fWP();
        AppMethodBeat.o(163704);
        return;
      }
      localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = str;
      boolean bool = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWh().get((IAutoDBItem)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "has story info: %s, %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      if (System.currentTimeMillis() - l > 86400000L)
      {
        Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "need refetch story");
        bool = false;
      }
      if (bool)
      {
        localObject = com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject);
        List localList = com.tencent.mm.plugin.luckymoney.app.a.fWk().fWi().aKI(str);
        ((eoh)localObject).absw.addAll(localList);
        com.tencent.mm.plugin.luckymoney.a.b.a(str, (eoh)localObject);
        fWP();
        AppMethodBeat.o(163704);
        return;
      }
      if (this.tipDialog == null) {
        this.tipDialog = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163699);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.KzD.forceCancel();
            if (LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this) != null) {
              LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this).cancel();
            }
            if ((LuckyMoneyBeforeDetailUI.c(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8) || (LuckyMoneyBeforeDetailUI.d(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
              LuckyMoneyBeforeDetailUI.this.finish();
            }
            AppMethodBeat.o(163699);
          }
        });
      }
      this.KzG = new com.tencent.mm.plugin.luckymoney.story.a.b();
      this.KzG.d(new com.tencent.mm.plugin.luckymoney.story.a.a(str, true));
      this.KzG.a(new com.tencent.mm.wallet_core.model.a.a() {}, 0L);
      AppMethodBeat.o(163704);
      return;
    }
  }
  
  public void finish()
  {
    AppMethodBeat.i(65445);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(65445);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(65443);
    super.onCreate(paramBundle);
    overridePendingTransition(0, com.tencent.mm.plugin.wxpay.a.a.receive_fade_out);
    aw.t(this, getResources().getColor(a.c.transparent));
    setContentViewVisibility(8);
    this.KqM = getIntent().getStringExtra("key_sendid");
    this.KzF = getIntent().getIntExtra("scene_id", 0);
    this.sWX = getIntent().getStringExtra("key_username");
    this.KmN = getIntent().getIntExtra("key_hb_kind", 1);
    this.lCR = getIntent().getIntExtra("key_from", 0);
    this.KzH = getIntent().getStringExtra("key_live_id");
    this.KzI = getIntent().getStringExtra("key_live_attach");
    this.KzJ = getIntent().getIntExtra("key_live_anchor_type", 0);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "from scene: %s", new Object[] { Integer.valueOf(this.lCR) });
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + Util.nullAsNil(this.KqM) + ", nativeurl=" + Util.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (com.tencent.mm.plugin.luckymoney.a.b.aKs(this.KqM) != null)
      {
        fYf();
        AppMethodBeat.o(65443);
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
            com.tencent.mm.plugin.luckymoney.a.b.a(this.KqM, (q)localObject1);
            fYf();
            AppMethodBeat.o(65443);
            return;
          }
        }
      }
      catch (Exception localException1)
      {
        Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + localException1.getLocalizedMessage());
      }
    }
    Object localObject2;
    if ((Util.isNullOrNil(this.KqM)) && (!Util.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.KqM = ((Uri)localObject2).getQueryParameter("sendid");
      label389:
      if (!Util.isNullOrNil(this.KqM))
      {
        localObject2 = this.KqM;
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
        this.tipDialog = k.a(getContext(), 3, a.j.LuckyMoneyNoAnimDialog, getString(a.i.loading_tips), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163703);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.KzD.forceCancel();
            if (LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this) != null) {
              LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this).cancel();
            }
            if ((LuckyMoneyBeforeDetailUI.f(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8) || (LuckyMoneyBeforeDetailUI.g(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4))
            {
              Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
              LuckyMoneyBeforeDetailUI.this.finish();
            }
            AppMethodBeat.o(163703);
          }
        });
        if (this.KzF != 0) {
          if (ah.uX(this.KzF)) {
            paramBundle = new ar((String)localObject2, 0, paramBundle, "v1.0", "");
          }
        }
        for (;;)
        {
          doSceneProgress(paramBundle, false);
          AppMethodBeat.o(65443);
          return;
          if (this.lCR == 3)
          {
            paramBundle = new com.tencent.mm.plugin.luckymoney.model.a.d((String)localObject2, 0, paramBundle, "v1.0", "", this.KzH, this.KzI, this.KzJ);
          }
          else
          {
            paramBundle = new aq((String)localObject2, 11, 0, paramBundle, "v1.0", "");
            continue;
            if (this.KmN == 5) {
              paramBundle = new ar((String)localObject2, 0, paramBundle, "v1.0", "");
            } else if ((this.lCR == 3) || (this.KmN == 7)) {
              paramBundle = new com.tencent.mm.plugin.luckymoney.model.a.d((String)localObject2, 0, paramBundle, "v1.0", "", this.KzH, this.KzI, this.KzJ);
            } else {
              paramBundle = new aq((String)localObject2, 11, 0, paramBundle, "v1.0", "");
            }
          }
        }
      }
      Log.w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
      finish();
      AppMethodBeat.o(65443);
      return;
    }
    catch (Exception localException2)
    {
      break label389;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(65444);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramp.getType());
    if ((paramp instanceof aq))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (aq)paramp;
        com.tencent.mm.plugin.luckymoney.a.b.a(this.KqM, paramString.KtU);
        getIntent().putExtra("key_process_content", paramString.Kuj);
        getIntent().putExtra("key_detail_emoji_md5", paramString.Kuk);
        getIntent().putExtra("key_detail_emoji_type", paramString.Kul);
        getIntent().putExtra("key_emoji_switch", paramString.Kum);
        fYf();
        AppMethodBeat.o(65444);
        return true;
      }
      k.cZ(this, paramString);
      finish();
      AppMethodBeat.o(65444);
      return true;
    }
    AppMethodBeat.o(65444);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */