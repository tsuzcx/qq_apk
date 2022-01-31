package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.au;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.storage.ak;

final class BottleConversationUI$7
  implements AdapterView.OnItemClickListener
{
  BottleConversationUI$7(BottleConversationUI paramBottleConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(18562);
    paramAdapterView = (ak)BottleConversationUI.a(this.jSo).getItem(paramInt);
    paramView = new Intent();
    paramView.addFlags(67108864);
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("key_need_send_video", false);
    com.tencent.mm.plugin.bottle.a.gmO.d(paramView, this.jSo);
    AppMethodBeat.o(18562);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.7
 * JD-Core Version:    0.7.0.1
 */