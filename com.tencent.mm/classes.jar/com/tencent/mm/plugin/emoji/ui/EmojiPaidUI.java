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
import com.tencent.mm.ak.t;
import com.tencent.mm.kernel.b;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.storage.MStorageEventData;
import com.tencent.mm.storage.ao;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.h[] rgA;
  
  protected final void a(com.tencent.mm.plugin.emoji.f.h paramh) {}
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.g paramg, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(108957);
    if ((paramg != null) && (paramBoolean1) && (this.rbD != null)) {
      this.rbD.b(paramg);
    }
    if ((this.rbD == null) || (paramg == null) || (paramg.rbs <= 0))
    {
      this.GQ.setVisibility(0);
      this.rec.setText(2131758559);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(108957);
      return;
    }
    this.GQ.setVisibility(8);
    this.mListView.setVisibility(0);
    AppMethodBeat.o(108957);
  }
  
  protected final int bp(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(108953);
    int i = super.bp(paramArrayOfByte);
    AppMethodBeat.o(108953);
    return i;
  }
  
  protected final int cGH()
  {
    return 10;
  }
  
  protected final int cGI()
  {
    return 6;
  }
  
  protected final a cGJ()
  {
    AppMethodBeat.i(108958);
    d locald = new d(getContext());
    AppMethodBeat.o(108958);
    return locald;
  }
  
  protected final void cGL() {}
  
  protected final boolean cGN()
  {
    return false;
  }
  
  protected final int cGQ()
  {
    return 2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(108954);
    setMMTitle(2131758562);
    if (z.aUn()) {
      addIconOptionMenu(0, 2131690843, new MenuItem.OnMenuItemClickListener()
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
    this.GQ.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(108954);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(108956);
    Log.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    cGW();
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
            this.reh = null;
            this.ree = -1;
            J(false, false);
            com.tencent.mm.kernel.g.aAh().azQ().set(208900, Boolean.TRUE);
            Toast.makeText(this, 2131758583, 0).show();
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
      Toast.makeText(this, 2131758582, 0).show();
      AppMethodBeat.o(108956);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(108952);
    super.onCreate(paramBundle);
    com.tencent.mm.plugin.report.service.h.CyF.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(108952);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(108955);
    super.onDestroy();
    if ((this.rgA != null) && (this.rgA.length > 0))
    {
      int i = 0;
      while (i < this.rgA.length)
      {
        com.tencent.mm.kernel.g.aAg().hqi.a(this.rgA[i]);
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
      cHg();
      fC(131074, 50);
    }
    AppMethodBeat.o(108959);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiPaidUI
 * JD-Core Version:    0.7.0.1
 */