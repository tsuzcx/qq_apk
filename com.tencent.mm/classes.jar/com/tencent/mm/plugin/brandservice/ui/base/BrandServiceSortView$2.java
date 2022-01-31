package com.tencent.mm.plugin.brandservice.ui.base;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.protobuf.me;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.storage.ad;
import com.tencent.mm.ui.base.sortview.BaseSortView;
import com.tencent.mm.ui.base.sortview.c.a;

final class BrandServiceSortView$2
  implements c.a
{
  BrandServiceSortView$2(BrandServiceSortView paramBrandServiceSortView) {}
  
  public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(14059);
    long l = bo.yB();
    Context localContext = this.jVl.getContext();
    BrandServiceSortView.b localb;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(localContext).inflate(2130968900, null);
      localb = new BrandServiceSortView.b();
      localb.jTb = ((TextView)paramView.findViewById(2131821732));
      localb.contentView = paramView.findViewById(2131821733);
      localb.egq = ((ImageView)paramView.findViewById(2131821954));
      localb.jUv = ((ImageView)paramView.findViewById(2131821957));
      localb.egr = ((TextView)paramView.findViewById(2131821956));
      localb.jUw = paramView.findViewById(2131821953);
      paramView.setTag(localb);
    }
    me localme;
    for (;;)
    {
      localme = (me)paramd.data;
      if (localme != null) {
        break;
      }
      ab.e("MicroMsg.BrandServiceSortView", "should not be empty");
      AppMethodBeat.o(14059);
      return paramView;
      localb = (BrandServiceSortView.b)paramView.getTag();
    }
    if ((this.jVl.zsE) && (paramBoolean1))
    {
      localb.jTb.setText(paramd.zsM);
      localb.jTb.setVisibility(0);
      localb.username = localme.userName;
      localb.egq.setTag(localme.userName);
      a.b.s(localb.egq, localb.username);
      paramd = localme.contact.Of();
      BrandServiceSortView.a(this.jVl, localb.egr, localContext, paramd, (int)localb.egr.getTextSize());
      ab.v("MicroMsg.BrandServiceSortView", "bizinfo status%d", new Object[] { Integer.valueOf(localme.pyd.field_status) });
      paramd = localb.jUv;
      if ((!BrandServiceSortView.c(this.jVl)) || (localme.pyd.field_status != 1)) {
        break label461;
      }
      paramInt = 0;
      label330:
      paramd.setVisibility(paramInt);
      if ((this.jVl.getMode() != 0) || (!paramBoolean2)) {
        break label467;
      }
      localb.jUw.setBackgroundResource(2130838447);
      label360:
      if (!this.jVl.zsF) {
        break label480;
      }
      localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)this.jVl.getContext().getResources().getDimension(2131427494), localb.contentView.getPaddingBottom());
    }
    for (;;)
    {
      ab.v("MicroMsg.BrandServiceSortView", "get view use %d ms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(14059);
      return paramView;
      localb.jTb.setVisibility(8);
      break;
      label461:
      paramInt = 8;
      break label330;
      label467:
      localb.jUw.setBackgroundResource(2130839276);
      break label360;
      label480:
      localb.contentView.setPadding(localb.contentView.getPaddingLeft(), localb.contentView.getPaddingTop(), (int)this.jVl.getContext().getResources().getDimension(2131427808), localb.contentView.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.base.BrandServiceSortView.2
 * JD-Core Version:    0.7.0.1
 */