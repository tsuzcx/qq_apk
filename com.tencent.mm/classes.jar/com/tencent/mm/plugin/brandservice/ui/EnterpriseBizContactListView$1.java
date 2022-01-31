package com.tencent.mm.plugin.brandservice.ui;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mm.ai.f;
import com.tencent.mm.plugin.brandservice.a;
import com.tencent.mm.pluginsdk.m;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;

final class EnterpriseBizContactListView$1
  implements AdapterView.OnItemClickListener
{
  EnterpriseBizContactListView$1(EnterpriseBizContactListView paramEnterpriseBizContactListView) {}
  
  public final void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    paramAdapterView = paramView.getTag();
    if ((paramAdapterView == null) || (!(paramAdapterView instanceof EnterpriseBizContactListView.c))) {}
    EnterpriseBizContactListView.c localc;
    do
    {
      return;
      localc = (EnterpriseBizContactListView.c)paramAdapterView;
    } while (bk.bl(localc.username));
    boolean bool1 = f.ld(localc.username);
    boolean bool2 = f.eW(localc.username);
    com.tencent.mm.ai.d locald = f.kX(localc.username);
    if (locald == null) {}
    for (paramAdapterView = null;; paramAdapterView = locald.LC())
    {
      paramView = paramAdapterView;
      if (paramAdapterView == null) {
        paramView = "";
      }
      if (!bool1) {
        break;
      }
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("rawUrl", paramView);
      paramAdapterView.putExtra("useJs", true);
      paramAdapterView.putExtra("srcUsername", localc.username);
      paramAdapterView.putExtra("bizofstartfrom", "enterpriseHomeSubBrand");
      paramAdapterView.addFlags(67108864);
      com.tencent.mm.br.d.b(this.idA.getContext(), "webview", ".ui.tools.WebViewUI", paramAdapterView);
      EnterpriseBizContactListView.a(this.idA, locald, 2);
      return;
    }
    if (bool2)
    {
      paramAdapterView = new Intent();
      paramAdapterView.putExtra("Contact_User", localc.username);
      paramAdapterView.addFlags(67108864);
      paramAdapterView.putExtra("biz_chat_from_scene", 3);
      com.tencent.mm.br.d.e(this.idA.getContext(), ".ui.bizchat.BizChatConversationUI", paramAdapterView);
      return;
    }
    paramAdapterView = new Intent();
    paramAdapterView.addFlags(67108864);
    paramAdapterView.putExtra("finish_direct", true);
    paramAdapterView.putExtra("Chat_User", localc.username);
    paramAdapterView.putExtra("chat_from_scene", 2);
    paramView = this.idA.getContext();
    y.i("MicroMsg.BrandService.BrandServiceApplication", "startChattingUI");
    a.eUR.e(paramAdapterView, paramView);
    EnterpriseBizContactListView.a(this.idA, locald, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.1
 * JD-Core Version:    0.7.0.1
 */