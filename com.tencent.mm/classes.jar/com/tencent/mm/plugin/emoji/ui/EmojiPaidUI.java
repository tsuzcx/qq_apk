package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.storage.ae;
import com.tencent.mm.ui.base.h.c;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.g[] pfV;
  
  protected final void a(com.tencent.mm.plugin.emoji.f.g paramg) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(108959);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      cdp();
      fh(131074, 50);
    }
    AppMethodBeat.o(108959);
  }
  
  protected final void a(boolean paramBoolean1, f paramf, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(108957);
    if ((paramf != null) && (paramBoolean1) && (this.paX != null)) {
      this.paX.b(paramf);
    }
    if ((this.paX == null) || (paramf == null) || (paramf.pay <= 0))
    {
      this.EP.setVisibility(0);
      this.pdC.setText(2131758271);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(108957);
      return;
    }
    this.EP.setVisibility(8);
    this.mListView.setVisibility(0);
    AppMethodBeat.o(108957);
  }
  
  protected final int aX(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108953);
    int i = super.aX(paramArrayOfByte);
    AppMethodBeat.o(108953);
    return i;
  }
  
  protected final int ccQ()
  {
    return 10;
  }
  
  protected final int ccR()
  {
    return 6;
  }
  
  protected final a ccS()
  {
    AppMethodBeat.i(108958);
    com.tencent.mm.plugin.emoji.a.d locald = new com.tencent.mm.plugin.emoji.a.d(getContext());
    AppMethodBeat.o(108958);
    return locald;
  }
  
  protected final void ccU() {}
  
  protected final boolean ccW()
  {
    return false;
  }
  
  protected final int ccZ()
  {
    return 2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108954);
    setMMTitle(2131758274);
    if (u.axK()) {
      addIconOptionMenu(0, 2131690603, new MenuItem.OnMenuItemClickListener()
      {
        public final boolean onMenuItemClick(MenuItem paramAnonymousMenuItem)
        {
          AppMethodBeat.i(108950);
          EmojiPaidUI.a(EmojiPaidUI.this);
          AppMethodBeat.o(108950);
          return true;
        }
      });
    }
    super.initView();
    this.EP.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(108954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108956);
    ac.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    cdf();
    String str = "";
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ac.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ac.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(str)));
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
            this.pdG = null;
            this.pdE = -1;
            K(false, false);
            com.tencent.mm.kernel.g.agR().agA().set(208900, Boolean.TRUE);
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
    h.wUl.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(108952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108955);
    super.onDestroy();
    if ((this.pfV != null) && (this.pfV.length > 0))
    {
      int i = 0;
      while (i < this.pfV.length)
      {
        com.tencent.mm.kernel.g.agQ().ghe.a(this.pfV[i]);
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