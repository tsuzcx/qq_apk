package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.c.ut;

final class EmojiStoreDetailUI$3
  implements AdapterView.OnItemClickListener
{
  EmojiStoreDetailUI$3(EmojiStoreDetailUI paramEmojiStoreDetailUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramAdapterView.getAdapter().getItem(paramInt);
    if ((paramAdapterView instanceof ut))
    {
      paramAdapterView = (ut)paramAdapterView;
      EmojiStoreDetailUI.a(this.jeK, paramAdapterView);
      h.nFQ.f(12787, new Object[] { Integer.valueOf(0), Integer.valueOf(0), paramAdapterView.jnU, Long.valueOf(EmojiStoreDetailUI.d(this.jeK)), paramAdapterView.sRs, paramAdapterView.syc, Integer.valueOf(26) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiStoreDetailUI.3
 * JD-Core Version:    0.7.0.1
 */