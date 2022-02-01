package com.tencent.mm.plugin.emoji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.s;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.h.g;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.m;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.aq;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.e.h[] xSz;
  
  protected final void a(boolean paramBoolean1, m paramm, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(108957);
    if ((paramm != null) && (paramBoolean1) && (this.xNj != null)) {
      this.xNj.b(paramm);
    }
    if ((this.xNj == null) || (paramm == null) || (paramm.xMT <= 0))
    {
      this.bEx.setVisibility(0);
      this.xPN.setText(h.h.emoji_no_play_history);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(108957);
      return;
    }
    this.bEx.setVisibility(8);
    this.mListView.setVisibility(0);
    AppMethodBeat.o(108957);
  }
  
  protected final int bC(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108953);
    int i = super.bC(paramArrayOfByte);
    AppMethodBeat.o(108953);
    return i;
  }
  
  protected final int dAR()
  {
    return 10;
  }
  
  protected final int dAS()
  {
    return 6;
  }
  
  protected final a dAT()
  {
    AppMethodBeat.i(108958);
    d locald = new d(getContext());
    AppMethodBeat.o(108958);
    return locald;
  }
  
  protected final void dAV() {}
  
  protected final boolean dAX()
  {
    return false;
  }
  
  protected final int dBa()
  {
    return 2;
  }
  
  protected final boolean dBj()
  {
    return true;
  }
  
  protected final void h(com.tencent.mm.plugin.emoji.e.h paramh) {}
  
  public void initView()
  {
    AppMethodBeat.i(108954);
    setMMTitle(h.h.emoji_paid);
    if (z.bBh()) {
      addIconOptionMenu(0, h.g.icons_outlined_more, new EmojiPaidUI.1(this));
    }
    super.initView();
    this.bEx.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(108954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108956);
    Log.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    dismissLoadingDialog();
    String str = "";
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      Log.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      Log.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(str)));
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
            bD(null);
            dBh();
            R(false, false);
            com.tencent.mm.kernel.h.baE().ban().B(208900, Boolean.TRUE);
            Toast.makeText(this, h.h.emoji_restore_success, 0).show();
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
      Toast.makeText(this, h.h.emoji_restore_failed, 0).show();
      AppMethodBeat.o(108956);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108952);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.OAn.b(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(108952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108955);
    super.onDestroy();
    if ((this.xSz != null) && (this.xSz.length > 0))
    {
      int i = 0;
      while (i < this.xSz.length)
      {
        com.tencent.mm.kernel.h.baD().mCm.a(this.xSz[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(108955);
  }
  
  public void onNotifyChange(String paramString, MStorageEventData paramMStorageEventData)
  {
    AppMethodBeat.i(108959);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      dBx();
      gS(131074, 50);
    }
    AppMethodBeat.o(108959);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI
 * JD-Core Version:    0.7.0.1
 */