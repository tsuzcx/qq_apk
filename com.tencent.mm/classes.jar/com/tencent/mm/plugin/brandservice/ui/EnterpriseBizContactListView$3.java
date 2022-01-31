package com.tencent.mm.plugin.brandservice.ui;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.brandservice.b.b;
import com.tencent.mm.plugin.brandservice.b.c;
import com.tencent.mm.plugin.brandservice.b.d;
import com.tencent.mm.plugin.brandservice.b.e;
import com.tencent.mm.plugin.brandservice.b.g;
import com.tencent.mm.plugin.brandservice.b.h;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;

final class EnterpriseBizContactListView$3
  implements c.a
{
  EnterpriseBizContactListView$3(EnterpriseBizContactListView paramEnterpriseBizContactListView) {}
  
  public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = bk.UZ();
    Context localContext = this.idA.getContext();
    EnterpriseBizContactListView.c localc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(localContext).inflate(b.e.enterprise_biz_list_item_sort, null);
      localc = new EnterpriseBizContactListView.c();
      localc.icl = ((TextView)paramView.findViewById(b.d.catalogTV));
      localc.contentView = paramView.findViewById(b.d.contentView);
      localc.doU = ((ImageView)paramView.findViewById(b.d.app_avatar_iv));
      localc.idH = ((ImageView)paramView.findViewById(b.d.new_iv));
      localc.doV = ((TextView)paramView.findViewById(b.d.brand_service_nickname));
      localc.idI = paramView.findViewById(b.d.selector);
      paramView.setTag(localc);
    }
    jt localjt;
    for (;;)
    {
      localjt = (jt)paramd.data;
      if (localjt != null) {
        break;
      }
      y.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
      return paramView;
      localc = (EnterpriseBizContactListView.c)paramView.getTag();
    }
    paramInt = 0;
    if (localjt.mVy.LA()) {
      paramInt = 1;
    }
    if ((this.idA.vee) && (paramBoolean1)) {
      if (paramd.vem.equals("!2"))
      {
        localc.icl.setText(this.idA.getContext().getString(b.h.enterprise_sub_placetop));
        localc.icl.setVisibility(0);
        if (paramInt == 0) {
          break label506;
        }
        localc.username = localjt.userName;
        localc.doU.setImageResource(b.g.enterprise_chat_entry_avatar);
        paramd = this.idA.getResources().getString(b.h.enterprise_chat_entry_title);
        EnterpriseBizContactListView.a(localc.doV, localContext, paramd, (int)localc.doV.getTextSize());
        label296:
        y.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localjt.mVy.field_status) });
        paramd = localc.idH;
        if (localjt.mVy.field_status != 1) {
          break label587;
        }
        paramInt = 0;
        label341:
        paramd.setVisibility(paramInt);
        if ((this.idA.getMode() != 0) || (!paramBoolean2)) {
          break label593;
        }
        localc.idI.setBackgroundResource(b.c.comm_list_item_selector_no_divider);
        label372:
        if (!this.idA.vef) {
          break label607;
        }
        localc.contentView.setPadding(localc.contentView.getPaddingLeft(), localc.contentView.getPaddingTop(), (int)this.idA.getContext().getResources().getDimension(b.b.AddressScrollBarWidth), localc.contentView.getPaddingBottom());
      }
    }
    for (;;)
    {
      y.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
      return paramView;
      if (!paramd.vem.equals("!1"))
      {
        localc.icl.setText(paramd.vem);
        localc.icl.setVisibility(0);
        break;
      }
      localc.icl.setVisibility(8);
      break;
      label506:
      localc.username = localjt.userName;
      localc.iconUrl = localjt.mVy.field_brandIconURL;
      localc.doU.setTag(localjt.userName);
      a.b.a(localc.doU, localc.username);
      paramd = localjt.dnp.Bq();
      EnterpriseBizContactListView.a(localc.doV, localContext, paramd, (int)localc.doV.getTextSize());
      break label296;
      label587:
      paramInt = 8;
      break label341;
      label593:
      localc.idI.setBackgroundResource(b.c.list_item_normal);
      break label372;
      label607:
      localc.contentView.setPadding(localc.contentView.getPaddingLeft(), localc.contentView.getPaddingTop(), (int)this.idA.getContext().getResources().getDimension(b.b.NormalPadding), localc.contentView.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.3
 * JD-Core Version:    0.7.0.1
 */