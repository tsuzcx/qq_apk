package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.luckymoney.model.af;
import com.tencent.mm.plugin.luckymoney.model.ap;
import com.tencent.mm.plugin.luckymoney.model.bh;
import com.tencent.mm.plugin.luckymoney.model.z;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.buh;
import com.tencent.mm.protocal.protobuf.cbe;
import com.tencent.mm.protocal.protobuf.dlt;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMHandlerThread;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.IAutoDBItem;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private String mRa;
  private Dialog tipDialog;
  private int yQh;
  private String yUc;
  private int zbZ;
  private com.tencent.mm.plugin.luckymoney.story.a.b zca;
  
  private void eeX()
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
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
  
  private void egb()
  {
    AppMethodBeat.i(163704);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "try fetch story info");
    if (!getIntent().getBooleanExtra("key_has_story", true))
    {
      Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no story, don't fetch data");
      eeX();
      AppMethodBeat.o(163704);
      return;
    }
    final String str = getIntent().getStringExtra("key_packet_id");
    Object localObject;
    if (Util.isNullOrNil(str))
    {
      localObject = com.tencent.mm.plugin.luckymoney.a.b.aDn(this.yUc);
      if (localObject != null)
      {
        localObject = bh.aDy(((com.tencent.mm.plugin.luckymoney.model.q)localObject).yVB);
        if ((localObject != null) && (((bh)localObject).yUC != null)) {
          str = ((bh)localObject).yUC.Lot;
        }
      }
    }
    for (;;)
    {
      if (Util.isNullOrNil(str))
      {
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no packet id");
        eeX();
        AppMethodBeat.o(163704);
        return;
      }
      localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = str;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.eex().eeu().get((IAutoDBItem)localObject, new String[0]);
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
        List localList = com.tencent.mm.plugin.luckymoney.b.a.eex().eev().aDB(str);
        ((dlt)localObject).MPo.addAll(localList);
        com.tencent.mm.plugin.luckymoney.a.b.a(str, (dlt)localObject);
        eeX();
        AppMethodBeat.o(163704);
        return;
      }
      if (this.tipDialog == null) {
        this.tipDialog = h.a(getContext(), 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163699);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.zbX.forceCancel();
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
      this.zca = new com.tencent.mm.plugin.luckymoney.story.a.b();
      this.zca.b(new com.tencent.mm.plugin.luckymoney.story.a.a(str, true));
      this.zca.a(new a.a() {}, 0L);
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
    overridePendingTransition(0, 2130772143);
    com.tencent.mm.ui.ao.q(this, getResources().getColor(2131101287));
    setContentViewVisibility(8);
    this.yUc = getIntent().getStringExtra("key_sendid");
    this.zbZ = getIntent().getIntExtra("scene_id", 0);
    this.mRa = getIntent().getStringExtra("key_username");
    this.yQh = getIntent().getIntExtra("key_hb_kind", 1);
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + Util.nullAsNil(this.yUc) + ", nativeurl=" + Util.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (com.tencent.mm.plugin.luckymoney.a.b.aDn(this.yUc) != null)
      {
        egb();
        AppMethodBeat.o(65443);
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
            com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, (com.tencent.mm.plugin.luckymoney.model.q)localObject1);
            egb();
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
    if ((Util.isNullOrNil(this.yUc)) && (!Util.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.yUc = ((Uri)localObject2).getQueryParameter("sendid");
      label309:
      if (!Util.isNullOrNil(this.yUc))
      {
        localObject2 = this.yUc;
        Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
        this.tipDialog = h.a(getContext(), 3, 2131821007, getString(2131762446), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163703);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.zbX.forceCancel();
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
        if (this.zbZ != 0) {
          if (af.rQ(this.zbZ)) {
            paramBundle = new ap((String)localObject2, 0, paramBundle, "v1.0", "");
          }
        }
        for (;;)
        {
          doSceneProgress(paramBundle, false);
          AppMethodBeat.o(65443);
          return;
          paramBundle = new com.tencent.mm.plugin.luckymoney.model.ao((String)localObject2, 11, 0, paramBundle, "v1.0", "");
          continue;
          if (this.yQh == 5) {
            paramBundle = new ap((String)localObject2, 0, paramBundle, "v1.0", "");
          } else {
            paramBundle = new com.tencent.mm.plugin.luckymoney.model.ao((String)localObject2, 11, 0, paramBundle, "v1.0", "");
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
      break label309;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    AppMethodBeat.i(65444);
    Log.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramq.getType());
    if ((paramq instanceof com.tencent.mm.plugin.luckymoney.model.ao))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.ao)paramq;
        com.tencent.mm.plugin.luckymoney.a.b.a(this.yUc, paramString.yWT);
        getIntent().putExtra("key_process_content", paramString.yXg);
        getIntent().putExtra("key_detail_emoji_md5", paramString.yXh);
        getIntent().putExtra("key_detail_emoji_type", paramString.yXi);
        getIntent().putExtra("key_emoji_switch", paramString.yXj);
        egb();
        AppMethodBeat.o(65444);
        return true;
      }
      h.cD(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */