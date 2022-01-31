package com.tencent.mm.plugin.brandservice.ui.base;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.brandservice.b;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.pluginsdk.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.ui.contact.z;

final class BrandServiceSortView$1
  implements AdapterView.OnItemClickListener
{
  BrandServiceSortView$1(BrandServiceSortView paramBrandServiceSortView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    AppMethodBeat.i(14058);
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof BrandServiceSortView.b)))
    {
      ab.w("MicroMsg.BrandServiceSortView", "view tag is null or is not a instance of ResHolder.");
      AppMethodBeat.o(14058);
      return;
    }
    paramView = (BrandServiceSortView.b)paramAdapterView;
    if (bo.isNullOrNil(paramView.username))
    {
      ab.w("MicroMsg.BrandServiceSortView", "username is null or nil.");
      AppMethodBeat.o(14058);
      return;
    }
    ai.agy(paramView.username);
    z.r(BrandServiceSortView.a(this.jVl), 12, 4, paramInt - 1);
    if (BrandServiceSortView.b(this.jVl))
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("Select_Contact", paramView.username);
      paramAdapterView.putExtra("Select_Conv_User", paramView.username);
      if ((this.jVl.getContext() instanceof Activity))
      {
        paramView = (Activity)this.jVl.getContext();
        paramView.setResult(-1, paramAdapterView);
        paramView.finish();
        AppMethodBeat.o(14058);
        return;
      }
    }
    paramView = paramView.username;
    paramAdapterView = this.jVl.getContext();
    ab.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    paramView = new Intent().putExtra("Chat_User", paramView);
    paramView.putExtra("finish_direct", true);
    paramView.putExtra("chat_from_scene", 2);
    paramView.putExtra("specific_chat_from_scene", 4);
    paramView.putExtra("img_gallery_enter_from_chatting_ui", true);
    b.gmO.d(paramView, paramAdapterView);
    AppMethodBeat.o(14058);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.1
 * JD-Core Version:    0.7.0.1
 */