package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.t;
import com.tencent.mm.kernel.c;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.emoji.i.g;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.l;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.h[] uJJ;
  
  protected final void a(boolean paramBoolean1, l paraml, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(108957);
    if ((paraml != null) && (paramBoolean1) && (this.uEH != null)) {
      this.uEH.b(paraml);
    }
    if ((this.uEH == null) || (paraml == null) || (paraml.uEw <= 0))
    {
      this.Xd.setVisibility(0);
      this.uHh.setText(i.h.emoji_no_play_history);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(108957);
      return;
    }
    this.Xd.setVisibility(8);
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
  
  protected final int cVA()
  {
    return 2;
  }
  
  protected final int cVr()
  {
    return 10;
  }
  
  protected final int cVs()
  {
    return 6;
  }
  
  protected final a cVt()
  {
    AppMethodBeat.i(108958);
    d locald = new d(getContext());
    AppMethodBeat.o(108958);
    return locald;
  }
  
  protected final void cVv() {}
  
  protected final boolean cVx()
  {
    return false;
  }
  
  protected final void h(com.tencent.mm.plugin.emoji.f.h paramh) {}
  
  public void initView()
  {
    AppMethodBeat.i(108954);
    setMMTitle(i.h.emoji_paid);
    if (z.bdp()) {
      addIconOptionMenu(0, i.g.icons_outlined_more, new EmojiPaidUI.1(this));
    }
    super.initView();
    this.Xd.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(108954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108956);
    Log.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    cVG();
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
            cVI();
            N(false, false);
            com.tencent.mm.kernel.h.aHG().aHp().i(208900, Boolean.TRUE);
            Toast.makeText(this, i.h.emoji_restore_success, 0).show();
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
      Toast.makeText(this, i.h.emoji_restore_failed, 0).show();
      AppMethodBeat.o(108956);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108952);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.IzE.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(108952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108955);
    super.onDestroy();
    if ((this.uJJ != null) && (this.uJJ.length > 0))
    {
      int i = 0;
      while (i < this.uJJ.length)
      {
        com.tencent.mm.kernel.h.aHF().kcd.a(this.uJJ[i]);
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
      cVS();
      fZ(131074, 50);
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