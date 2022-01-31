package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;

final class BrandServiceSortView$1
  implements AdapterView.OnItemClickListener
{
  BrandServiceSortView$1(BrandServiceSortView paramBrandServiceSortView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof BrandServiceSortView.b)))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
      return;
    }
    paramView = (BrandServiceSortView.b)paramAdapterView;
    if (bk.bl(paramView.username))
    {
      com.tencent.mm.sdk.platformtools.y.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
      return;
    }
    ai.Rx(paramView.username);
    com.tencent.mm.ui.contact.y.o(BrandServiceSortView.a(this.iex), 12, 4, paramInt - 1);
    if (BrandServiceSortView.b(this.iex))
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("Select_Contact", paramView.username);
      paramAdapterView.putExtra("Select_Conv_User", paramView.username);
      if ((this.iex.getContext() instanceof Activity))
      {
        paramView = (Activity)this.iex.getContext();
        paramView.setResult(-1, paramAdapterView);
        paramView.finish();
        return;
      }
    }
    paramView = paramView.username;
    paramAdapterView = this.iex.getContext();
    com.tencent.mm.sdk.platformtools.y.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    paramView = new Intent().putExtra("Chat_User", paramView);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("chat_from_scene", 2);
    paramView.putExtra("specific_chat_from_scene", 4);
    paramView.putExtra("img_gallery_enter_from_chatting_ui", true);
    a.eUR.e(paramView, paramAdapterView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.1
 * JD-Core Version:    0.7.0.1
 */