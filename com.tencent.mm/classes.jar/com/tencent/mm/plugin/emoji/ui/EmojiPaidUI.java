package com.tencent.mm.plugin.emoji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.p;
import com.tencent.mm.kernel.b;
import com.tencent.mm.model.r;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.d;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.e.m;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.z;
import java.util.ArrayList;

public class EmojiPaidUI
  extends BaseEmojiStoreUI
{
  private com.tencent.mm.plugin.emoji.f.g[] lmg;
  
  protected final void a(com.tencent.mm.plugin.emoji.f.g paramg) {}
  
  public final void a(String paramString, m paramm)
  {
    AppMethodBeat.i(53398);
    if ((paramString != null) && (paramString.equals("event_update_group")))
    {
      bms();
      eb(131074, 50);
    }
    AppMethodBeat.o(53398);
  }
  
  protected final void a(boolean paramBoolean1, com.tencent.mm.plugin.emoji.model.e parame, boolean paramBoolean2, boolean paramBoolean3)
  {
    AppMethodBeat.i(53396);
    if ((parame != null) && (paramBoolean1) && (this.lhv != null)) {
      this.lhv.b(parame);
    }
    if ((this.lhv == null) || (parame == null) || (parame.lhk <= 0))
    {
      this.xy.setVisibility(0);
      this.ljU.setText(2131299154);
      this.mListView.setVisibility(8);
      AppMethodBeat.o(53396);
      return;
    }
    this.xy.setVisibility(8);
    this.mListView.setVisibility(0);
    AppMethodBeat.o(53396);
  }
  
  protected final int aI(byte[] paramArrayOfByte)
  {
    AppMethodBeat.i(53392);
    int i = super.aI(paramArrayOfByte);
    AppMethodBeat.o(53392);
    return i;
  }
  
  protected final int blS()
  {
    return 10;
  }
  
  protected final int blT()
  {
    return 6;
  }
  
  protected final a blU()
  {
    AppMethodBeat.i(53397);
    d locald = new d(getContext());
    AppMethodBeat.o(53397);
    return locald;
  }
  
  protected final void blW() {}
  
  protected final boolean blY()
  {
    return false;
  }
  
  protected final int bmb()
  {
    return 2;
  }
  
  public void initView()
  {
    AppMethodBeat.i(53393);
    setMMTitle(2131299157);
    if (r.ZA()) {
      addIconOptionMenu(0, 2130839668, new EmojiPaidUI.1(this));
    }
    super.initView();
    this.xy.setVisibility(8);
    this.mListView.setVisibility(8);
    AppMethodBeat.o(53393);
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(53395);
    ab.i("MicroMsg.emoji.EmojiPaidUI", "onActivityResult . requestCode:" + paramInt1 + "  resultCode:" + paramInt2);
    bmh();
    String str = "";
    if (paramIntent != null)
    {
      paramInt1 = paramIntent.getIntExtra("key_err_code", 0);
      ab.w("MicroMsg.emoji.EmojiPaidUI", "errCode:".concat(String.valueOf(paramInt1)));
      str = paramIntent.getStringExtra("key_err_msg");
      ab.w("MicroMsg.emoji.EmojiPaidUI", "errMsg:".concat(String.valueOf(str)));
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
            this.ljY = null;
            this.ljW = -1;
            z(false, false);
            com.tencent.mm.kernel.g.RL().Ru().set(208900, Boolean.TRUE);
            Toast.makeText(this, 2131299167, 0).show();
            AppMethodBeat.o(53395);
            return;
          }
          Toast.makeText(this, str, 0).show();
          AppMethodBeat.o(53395);
          return;
        }
        Toast.makeText(this, str, 0).show();
        AppMethodBeat.o(53395);
        return;
      }
      Toast.makeText(this, 2131299166, 0).show();
      AppMethodBeat.o(53395);
      return;
      paramInt1 = 0;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53391);
    super.onCreate(paramBundle);
    h.qsU.e(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(10), Integer.valueOf(10) });
    AppMethodBeat.o(53391);
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53394);
    super.onDestroy();
    if ((this.lmg != null) && (this.lmg.length > 0))
    {
      int i = 0;
      while (i < this.lmg.length)
      {
        com.tencent.mm.kernel.g.RK().eHt.a(this.lmg[i]);
        i += 1;
      }
    }
    AppMethodBeat.o(53394);
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