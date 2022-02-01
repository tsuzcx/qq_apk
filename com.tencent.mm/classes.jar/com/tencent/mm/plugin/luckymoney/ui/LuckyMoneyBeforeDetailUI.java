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
import com.tencent.mm.al.n;
import com.tencent.mm.plugin.luckymoney.model.ah;
import com.tencent.mm.plugin.luckymoney.model.av;
import com.tencent.mm.plugin.luckymoney.model.l;
import com.tencent.mm.plugin.luckymoney.model.u;
import com.tencent.mm.plugin.luckymoney.story.b.d;
import com.tencent.mm.protocal.protobuf.bhr;
import com.tencent.mm.protocal.protobuf.bnu;
import com.tencent.mm.protocal.protobuf.csj;
import com.tencent.mm.sdk.e.c;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aq;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.al;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.wallet_core.c.a.a;
import java.util.LinkedList;
import java.util.List;

@com.tencent.mm.ui.base.a(7)
public class LuckyMoneyBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private Dialog tipDialog;
  private String vuW;
  private com.tencent.mm.plugin.luckymoney.story.a.b vuX;
  
  private void djg()
  {
    AppMethodBeat.i(163704);
    ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "try fetch story info");
    if (!getIntent().getBooleanExtra("key_has_story", true))
    {
      ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no story, don't fetch data");
      djh();
      AppMethodBeat.o(163704);
      return;
    }
    final String str = getIntent().getStringExtra("key_packet_id");
    Object localObject;
    if (bt.isNullOrNil(str))
    {
      localObject = com.tencent.mm.plugin.luckymoney.a.b.aoP(this.vuW);
      if (localObject != null)
      {
        localObject = av.aoX(((l)localObject).voC);
        if ((localObject != null) && (((av)localObject).vnI != null)) {
          str = ((av)localObject).vnI.Gat;
        }
      }
    }
    for (;;)
    {
      if (bt.isNullOrNil(str))
      {
        ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "no packet id");
        djh();
        AppMethodBeat.o(163704);
        return;
      }
      localObject = new com.tencent.mm.plugin.luckymoney.story.b.a();
      ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_packet_id = str;
      boolean bool = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhE().get((c)localObject, new String[0]);
      long l = ((com.tencent.mm.plugin.luckymoney.story.b.a)localObject).field_update_time;
      ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "has story info: %s, %s", new Object[] { Boolean.valueOf(bool), Long.valueOf(l) });
      if (System.currentTimeMillis() - l > 86400000L)
      {
        ad.w("MicroMsg.LuckyMoneyBeforeDetailUI", "need refetch story");
        bool = false;
      }
      if (bool)
      {
        localObject = com.tencent.mm.plugin.luckymoney.story.b.a.a((com.tencent.mm.plugin.luckymoney.story.b.a)localObject);
        List localList = com.tencent.mm.plugin.luckymoney.b.a.dhH().dhF().apa(str);
        ((csj)localObject).HkG.addAll(localList);
        com.tencent.mm.plugin.luckymoney.a.b.a(str, (csj)localObject);
        djh();
        AppMethodBeat.o(163704);
        return;
      }
      if (this.tipDialog == null) {
        this.tipDialog = h.a(getContext(), 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163699);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.vuU.forceCancel();
            if (LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this) != null) {
              LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this).cancel();
            }
            if ((LuckyMoneyBeforeDetailUI.c(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8) || (LuckyMoneyBeforeDetailUI.d(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4))
            {
              ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
              LuckyMoneyBeforeDetailUI.this.finish();
            }
            AppMethodBeat.o(163699);
          }
        });
      }
      this.vuX = new com.tencent.mm.plugin.luckymoney.story.a.b();
      this.vuX.b(new com.tencent.mm.plugin.luckymoney.story.a.a(str, true));
      this.vuX.a(new a.a() {}, 0L);
      AppMethodBeat.o(163704);
      return;
    }
  }
  
  private void djh()
  {
    AppMethodBeat.i(163705);
    ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
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
        localObject = new com.tencent.mm.hellhoundlib.b.a().bc(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyBeforeDetailUI, ((com.tencent.mm.hellhoundlib.b.a)localObject).ahp(), "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        localLuckyMoneyBeforeDetailUI.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).mq(0));
        com.tencent.mm.hellhoundlib.a.a.a(localLuckyMoneyBeforeDetailUI, "com/tencent/mm/plugin/luckymoney/ui/LuckyMoneyBeforeDetailUI$3", "run", "()V", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        aq.o(new Runnable()
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
    overridePendingTransition(0, 2130772119);
    al.r(this, getResources().getColor(2131101053));
    setContentViewVisibility(8);
    this.vuW = getIntent().getStringExtra("key_sendid");
    paramBundle = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + bt.nullAsNil(this.vuW) + ", nativeurl=" + bt.nullAsNil(paramBundle) + ", jumpFrom=" + i);
    if (i == 2)
    {
      if (com.tencent.mm.plugin.luckymoney.a.b.aoP(this.vuW) != null)
      {
        djg();
        AppMethodBeat.o(65443);
        return;
      }
      try
      {
        Object localObject1 = getIntent().getByteArrayExtra("key_detail_info");
        if (localObject1 != null)
        {
          localObject1 = (l)new l().parseFrom((byte[])localObject1);
          if (localObject1 != null)
          {
            com.tencent.mm.plugin.luckymoney.a.b.a(this.vuW, (l)localObject1);
            djg();
            AppMethodBeat.o(65443);
            return;
          }
        }
      }
      catch (Exception localException1)
      {
        ad.w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + localException1.getLocalizedMessage());
      }
    }
    Object localObject2;
    if ((bt.isNullOrNil(this.vuW)) && (!bt.isNullOrNil(paramBundle))) {
      localObject2 = Uri.parse(paramBundle);
    }
    try
    {
      this.vuW = ((Uri)localObject2).getQueryParameter("sendid");
      label265:
      if (!bt.isNullOrNil(this.vuW))
      {
        localObject2 = this.vuW;
        ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
        this.tipDialog = h.a(getContext(), 3, 2131820985, getString(2131760709), true, new DialogInterface.OnCancelListener()
        {
          public final void onCancel(DialogInterface paramAnonymousDialogInterface)
          {
            AppMethodBeat.i(163703);
            if ((LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this) != null) && (LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).isShowing())) {
              LuckyMoneyBeforeDetailUI.a(LuckyMoneyBeforeDetailUI.this).dismiss();
            }
            LuckyMoneyBeforeDetailUI.this.vuU.forceCancel();
            if (LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this) != null) {
              LuckyMoneyBeforeDetailUI.b(LuckyMoneyBeforeDetailUI.this).cancel();
            }
            if ((LuckyMoneyBeforeDetailUI.f(LuckyMoneyBeforeDetailUI.this).getVisibility() == 8) || (LuckyMoneyBeforeDetailUI.g(LuckyMoneyBeforeDetailUI.this).getVisibility() == 4))
            {
              ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "user cancel & finish");
              LuckyMoneyBeforeDetailUI.this.finish();
            }
            AppMethodBeat.o(163703);
          }
        });
        doSceneProgress(new ah((String)localObject2, 11, 0, paramBundle, "v1.0", ""), false);
        AppMethodBeat.o(65443);
        return;
      }
      ad.w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
      finish();
      AppMethodBeat.o(65443);
      return;
    }
    catch (Exception localException2)
    {
      break label265;
    }
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(65444);
    ad.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramn.getType());
    if ((paramn instanceof ah))
    {
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (ah)paramn;
        com.tencent.mm.plugin.luckymoney.a.b.a(this.vuW, paramString.vpO);
        getIntent().putExtra("key_process_content", paramString.vqa);
        getIntent().putExtra("key_detail_emoji_md5", paramString.vqb);
        getIntent().putExtra("key_detail_emoji_type", paramString.vqc);
        getIntent().putExtra("key_emoji_switch", paramString.vqd);
        djg();
        AppMethodBeat.o(65444);
        return true;
      }
      h.cl(this, paramString);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */