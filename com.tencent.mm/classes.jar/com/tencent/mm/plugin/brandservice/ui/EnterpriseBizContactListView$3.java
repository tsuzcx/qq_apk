package com.tencent.mm.plugin.brandservice.ui;

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

final class EnterpriseBizContactListView$3
  implements c.a
{
  EnterpriseBizContactListView$3(EnterpriseBizContactListView paramEnterpriseBizContactListView) {}
  
  public final View a(com.tencent.mm.ui.base.sortview.d paramd, View paramView, int paramInt, boolean paramBoolean1, boolean paramBoolean2)
  {
    AppMethodBeat.i(13957);
    long l = bo.yB();
    Context localContext = this.jUo.getContext();
    EnterpriseBizContactListView.c localc;
    if (paramView == null)
    {
      paramView = LayoutInflater.from(localContext).inflate(2130969428, null);
      localc = new EnterpriseBizContactListView.c();
      localc.jTb = ((TextView)paramView.findViewById(2131821732));
      localc.contentView = paramView.findViewById(2131821733);
      localc.egq = ((ImageView)paramView.findViewById(2131821954));
      localc.jUv = ((ImageView)paramView.findViewById(2131821957));
      localc.egr = ((TextView)paramView.findViewById(2131821956));
      localc.jUw = paramView.findViewById(2131821953);
      paramView.setTag(localc);
    }
    me localme;
    for (;;)
    {
      localme = (me)paramd.data;
      if (localme != null) {
        break;
      }
      ab.e("MicroMsg.BrandService.EnterpriseBizContactListView", "should not be empty");
      AppMethodBeat.o(13957);
      return paramView;
      localc = (EnterpriseBizContactListView.c)paramView.getTag();
    }
    paramInt = 0;
    if (localme.pyd.aei()) {
      paramInt = 1;
    }
    if ((this.jUo.zsE) && (paramBoolean1)) {
      if (paramd.zsM.equals("!2"))
      {
        localc.jTb.setText(this.jUo.getContext().getString(2131299323));
        localc.jTb.setVisibility(0);
        if (paramInt == 0) {
          break label510;
        }
        localc.username = localme.userName;
        localc.egq.setImageResource(2131231279);
        paramd = this.jUo.getResources().getString(2131299304);
        EnterpriseBizContactListView.a(localc.egr, localContext, paramd, (int)localc.egr.getTextSize());
        label298:
        ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "bizinfo status%d", new Object[] { Integer.valueOf(localme.pyd.field_status) });
        paramd = localc.jUv;
        if (localme.pyd.field_status != 1) {
          break label591;
        }
        paramInt = 0;
        label343:
        paramd.setVisibility(paramInt);
        if ((this.jUo.getMode() != 0) || (!paramBoolean2)) {
          break label597;
        }
        localc.jUw.setBackgroundResource(2130838447);
        label373:
        if (!this.jUo.zsF) {
          break label611;
        }
        localc.contentView.setPadding(localc.contentView.getPaddingLeft(), localc.contentView.getPaddingTop(), (int)this.jUo.getContext().getResources().getDimension(2131427494), localc.contentView.getPaddingBottom());
      }
    }
    for (;;)
    {
      ab.v("MicroMsg.BrandService.EnterpriseBizContactListView", "get view use %d ms", new Object[] { Long.valueOf(bo.av(l)) });
      AppMethodBeat.o(13957);
      return paramView;
      if (!paramd.zsM.equals("!1"))
      {
        localc.jTb.setText(paramd.zsM);
        localc.jTb.setVisibility(0);
        break;
      }
      localc.jTb.setVisibility(8);
      break;
      label510:
      localc.username = localme.userName;
      localc.iconUrl = localme.pyd.field_brandIconURL;
      localc.egq.setTag(localme.userName);
      a.b.c(localc.egq, localc.username);
      paramd = localme.contact.Of();
      EnterpriseBizContactListView.a(localc.egr, localContext, paramd, (int)localc.egr.getTextSize());
      break label298;
      label591:
      paramInt = 8;
      break label343;
      label597:
      localc.jUw.setBackgroundResource(2130839276);
      break label373;
      label611:
      localc.contentView.setPadding(localc.contentView.getPaddingLeft(), localc.contentView.getPaddingTop(), (int)this.jUo.getContext().getResources().getDimension(2131427808), localc.contentView.getPaddingBottom());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.brandservice.ui.EnterpriseBizContactListView.3
 * JD-Core Version:    0.7.0.1
 */