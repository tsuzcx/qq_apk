package com.tencent.mm.plugin.brandservice.ui.base;

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
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.jt;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;

final class BrandServiceSortView$2
  implements c.a
{
  BrandServiceSortView$2(BrandServiceSortView paramBrandServiceSortView) {}
  
  public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    long l = bk.UZ();
    Context localContext = this.iex.getContext();
    BrandServiceSortView.b localb;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(localContext).inflate(b.e.brand_service_lv_item, null);
      localb = new BrandServiceSortView.b();
      localb.icl = ((TextView)paramView.findViewById(b.d.catalogTV));
      localb.contentView = paramView.findViewById(b.d.contentView);
      localb.doU = ((ImageView)paramView.findViewById(b.d.app_avatar_iv));
      localb.idH = ((ImageView)paramView.findViewById(b.d.new_iv));
      localb.doV = ((TextView)paramView.findViewById(b.d.brand_service_nickname));
      localb.idI = paramView.findViewById(b.d.selector);
      paramView.setTag(localb);
    }
    jt localjt;
    for (;;)
    {
      localjt = (jt)paramd.data;
      if (localjt != null) {
        break;
      }
      y.e("MicroMsg.BrandServiceSortView", "should not be empty");
      return paramView;
      localb = (BrandServiceSortView.b)paramView.getTag();
    }
    if ((this.iex.vee) && (paramBoolean1))
    {
      localb.icl.setText(paramd.vem);
      localb.icl.setVisibility(0);
      localb.username = localjt.userName;
      localb.doU.setTag(localjt.userName);
      a.b.n(localb.doU, localb.username);
      paramd = localjt.dnp.Bq();
      BrandServiceSortView.a(this.iex, localb.doV, localContext, paramd, (int)localb.doV.getTextSize());
      y.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localjt.mVy.field_status) });
      paramd = localb.idH;
      if ((!BrandServiceSortView.c(this.iex)) || (localjt.mVy.field_status != 1)) {
        break label452;
      }
      paramInt = 0;
      label325:
      paramd.setVisibility(paramInt);
      if ((this.iex.getMode() != 0) || (!paramBoolean2)) {
        break label458;
      }
      localb.idI.setBackgroundResource(b.c.comm_list_item_selector_no_divider);
      label356:
      if (!this.iex.vef) {
        break label472;
      }
      localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)this.iex.getContext().getResources().getDimension(b.b.AddressScrollBarWidth), localb.contentView.getPaddingBottom());
    }
    for (;;)
    {
      y.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bk.cp(l)) });
      return paramView;
      localb.icl.setVisibility(8);
      break;
      label452:
      paramInt = 8;
      break label325;
      label458:
      localb.idI.setBackgroundResource(b.c.list_item_normal);
      break label356;
      label472:
      localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)this.iex.getContext().getResources().getDimension(b.b.NormalPadding), localb.contentView.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.2
 * JD-Core Version:    0.7.0.1
 */