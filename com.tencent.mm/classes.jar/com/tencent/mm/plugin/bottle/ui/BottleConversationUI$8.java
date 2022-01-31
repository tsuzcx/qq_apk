package com.tencent.mm.plugin.bottle.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.h.c.as;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.storage.ak;

final class BottleConversationUI$8
  implements AdapterView.OnItemClickListener
{
  BottleConversationUI$8(BottleConversationUI paramBottleConversationUI) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = (ak)BottleConversationUI.a(this.hZr).getItem(paramInt);
    paramView = new Intent();
    paramView.addFlags(67108864);
    paramView.putExtra("Chat_User", paramAdapterView.field_username);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("key_need_send_video", false);
    com.tencent.mm.plugin.bottle.a.eUR.e(paramView, this.hZr);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.BottleConversationUI.8
 * JD-Core Version:    0.7.0.1
 */