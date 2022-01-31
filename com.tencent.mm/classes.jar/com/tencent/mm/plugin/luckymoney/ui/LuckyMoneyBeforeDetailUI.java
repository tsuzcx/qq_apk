package com.tencent.mm.plugin.luckymoney.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.m;
import com.tencent.mm.plugin.luckymoney.model.k;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.al;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.base.a;
import com.tencent.mm.ui.base.h;
import java.io.IOException;

@a(3)
public class LuckyMoneyBeforeDetailUI
  extends LuckyMoneyBaseUI
{
  private Dialog gKM;
  
  private void iZ(boolean paramBoolean)
  {
    AppMethodBeat.i(42581);
    ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "go to detail ui");
    LuckyMoneyBeforeDetailUI.1 local1 = new LuckyMoneyBeforeDetailUI.1(this);
    if (paramBoolean)
    {
      al.p(local1, 100L);
      AppMethodBeat.o(42581);
      return;
    }
    local1.run();
    AppMethodBeat.o(42581);
  }
  
  public void finish()
  {
    AppMethodBeat.i(42580);
    super.finish();
    overridePendingTransition(0, 0);
    AppMethodBeat.o(42580);
  }
  
  public int getLayoutId()
  {
    return -1;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(42578);
    super.onCreate(paramBundle);
    overridePendingTransition(0, 2131034241);
    com.tencent.mm.ui.af.o(this, getResources().getColor(2131690605));
    setContentViewVisibility(8);
    paramBundle = getIntent().getStringExtra("key_sendid");
    String str = getIntent().getStringExtra("key_native_url");
    int i = getIntent().getIntExtra("key_jump_from", 2);
    ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid=" + bo.nullAsNil(paramBundle) + ", nativeurl=" + bo.nullAsNil(str) + ", jumpFrom=" + i);
    if (i == 2) {
      try
      {
        byte[] arrayOfByte = getIntent().getByteArrayExtra("key_detail_info");
        if ((arrayOfByte != null) && ((k)new k().parseFrom(arrayOfByte) != null))
        {
          iZ(false);
          AppMethodBeat.o(42578);
          return;
        }
      }
      catch (Exception localException1)
      {
        ab.w("MicroMsg.LuckyMoneyBeforeDetailUI", "Parse LuckyMoneyDetail fail!" + localException1.getLocalizedMessage());
      }
    }
    Object localObject;
    if ((bo.isNullOrNil(paramBundle)) && (!bo.isNullOrNil(str))) {
      localObject = Uri.parse(str);
    }
    for (;;)
    {
      try
      {
        localObject = ((Uri)localObject).getQueryParameter("sendid");
        paramBundle = (Bundle)localObject;
        if (bo.isNullOrNil(paramBundle)) {
          break;
        }
        ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "get recordList");
        this.gKM = h.a(getContext(), 3, 2131493306, getString(2131301086), true, new LuckyMoneyBeforeDetailUI.2(this));
        doSceneProgress(new com.tencent.mm.plugin.luckymoney.model.af(paramBundle, 11, 0, str, "v1.0", ""), false);
        AppMethodBeat.o(42578);
        return;
      }
      catch (Exception localException2) {}
    }
    ab.w("MicroMsg.LuckyMoneyBeforeDetailUI", "sendid null or nil, finish");
    finish();
    AppMethodBeat.o(42578);
  }
  
  public final boolean onSceneEnd(int paramInt1, int paramInt2, String paramString, m paramm)
  {
    AppMethodBeat.i(42579);
    ab.i("MicroMsg.LuckyMoneyBeforeDetailUI", "onSceneEnd() errType:" + paramInt1 + " errCode:" + paramInt2 + " errMsg:" + paramString + " netsceneType:" + paramm.getType());
    if ((paramm instanceof com.tencent.mm.plugin.luckymoney.model.af))
    {
      if (this.gKM != null) {
        this.gKM.dismiss();
      }
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        paramString = (com.tencent.mm.plugin.luckymoney.model.af)paramm;
        try
        {
          getIntent().putExtra("key_detail_info", paramString.ooO.toByteArray());
          getIntent().putExtra("key_process_content", paramString.opa);
          getIntent().putExtra("key_detail_emoji_md5", paramString.opb);
          getIntent().putExtra("key_detail_emoji_type", paramString.opc);
          getIntent().putExtra("key_emoji_switch", paramString.opd);
          iZ(true);
          AppMethodBeat.o(42579);
          return true;
        }
        catch (IOException paramString)
        {
          for (;;)
          {
            ab.printErrStackTrace("MicroMsg.LuckyMoneyBeforeDetailUI", paramString, "", new Object[0]);
            finish();
          }
        }
      }
      h.bO(this, paramString);
      finish();
      AppMethodBeat.o(42579);
      return true;
    }
    AppMethodBeat.o(42579);
    return false;
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.ui.LuckyMoneyBeforeDetailUI
 * JD-Core Version:    0.7.0.1
 */