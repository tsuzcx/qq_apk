package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.g[] oCv;
  
  protected final void a(com.tencent.mm.plugin.emoji.f.g paramg) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(108959);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      bWc();
      fe(131074, 50);
    }
    AppMethodBeat.o(108959);
  }
  
  protected final void a(boolean paramBoolean1, f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(108957);
    if ((paramf != null) && (paramBoolean1) && (this.oxx != null)) {
      this.oxx.b(paramf);
    }
    if ((this.oxx == null) || (paramf == null) || (paramf.owY <= 0))
    {
      this.DR.setVisibility(0);
      this.oAc.setText(2131758271);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(108957);
      return;
    }
    this.DR.setVisibility(8);
    this.mListView.setVisibility(0);
    AppMethodBeat.o(108957);
  }
  
  protected final int aY(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108953);
    int i = super.aY(paramArrayOfByte);
    AppMethodBeat.o(108953);
    return i;
  }
  
  protected final int bVD()
  {
    return 10;
  }
  
  protected final int bVE()
  {
    return 6;
  }
  
  protected final a bVF()
  {
    AppMethodBeat.i(108958);
    d locald = new d(getContext());
    AppMethodBeat.o(108958);
    return locald;
  }
  
  protected final void bVH() {}
  
  protected final boolean bVJ()
  {
    return false;
  }
  
  protected final int bVM()
  {
    return 2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108954);
    setMMTitle(2131758274);
    if (u.aqU()) {
      addIconOptionMenu(0, 2131690603, new EmojiPaidUI.1(this));
    }
    super.initView();
    this.DR.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(108954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108956);
    ad.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    bVS();
    String str = "";
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ad.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ad.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(str)));
    }
    for (;;)
    {
      if (paramInt2 == -1)
      {
        if ((paramIntent != null) && (paramInt1 == 0))
        {
          paramIntent = paramIntent.getStringArrayListExtra("key_response_product_ids");
          if ((paramIntent != null) && (paramIntent.size() > 0))
          {
            this.oAg = null;
            this.oAe = -1;
            I(false, false);
            com.tencent.mm.kernel.g.afB().afk().set(208900, Boolean.TRUE);
            Toast.makeText(this, 2131758293, 0).show();
            AppMethodBeat.o(108956);
            return;
          }
          Toast.makeText(this, str, 0).show();
          AppMethodBeat.o(108956);
          return;
        }
        Toast.makeText(this, str, 0).show();
        AppMethodBeat.o(108956);
        return;
      }
      Toast.makeText(this, 2131758292, 0).show();
      AppMethodBeat.o(108956);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108952);
    super.onCreate(paramBundle);
    h.vKh.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(108952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108955);
    super.onDestroy();
    if ((this.oCv != null) && (this.oCv.length > 0))
    {
      int i = 0;
      while (i < this.oCv.length)
      {
        com.tencent.mm.kernel.g.afA().gcy.a(this.oCv[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(108955);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI
 * JD-Core Version:    0.7.0.1
 */