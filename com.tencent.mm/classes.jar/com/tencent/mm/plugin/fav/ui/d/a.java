package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.am.a;
import com.tencent.mm.model.am.b;
import com.tencent.mm.model.q;
import com.tencent.mm.model.s;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.plugin.fav.ui.n.e;
import com.tencent.mm.protocal.c.yj;
import com.tencent.mm.protocal.c.yl;
import com.tencent.mm.protocal.c.yp;
import com.tencent.mm.protocal.c.yw;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;

public abstract class a
{
  protected l kbg = null;
  public final a.a kio = new a.a();
  
  public a(l paraml)
  {
    this.kbg = paraml;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, a.b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.kir = paramView.findViewById(n.e.fav_type_layout);
    if (paramb.kir == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.fhD = ((TextView)paramView.findViewById(n.e.fav_name));
    if (paramb.fhD == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.dsz = ((TextView)paramView.findViewById(n.e.fav_time));
    if (paramb.dsz == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.eXQ = ((CheckBox)paramView.findViewById(n.e.fav_checkbox));
    if (paramb.eXQ == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.kis = ((ImageView)paramView.findViewById(n.e.fav_tag_iv));
    if (paramb.kis == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.eXQ.setOnCheckedChangeListener(new a.1(this));
    paramb.jZN = paramg;
    paramView.setTag(paramb);
    paramb.kit = ((LinearLayout)paramView.findViewById(n.e.fav_sync_error_ll));
    paramb.kiu = ((TextView)paramView.findViewById(n.e.fav_sync_error_btn));
    paramb.kiu.setOnClickListener(new a.2(this));
    return paramView;
  }
  
  public abstract void a(View paramView, yl paramyl);
  
  protected final void a(a.b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramb.jZN = paramg;
    label59:
    Context localContext;
    Object localObject;
    label184:
    boolean bool;
    if (paramb.jZN.field_type == 18)
    {
      paramb.kir.setVisibility(0);
      if (this.kio.keO) {
        break label310;
      }
      paramb.dsz.setText(com.tencent.mm.plugin.fav.ui.j.f(paramb.dsz.getContext(), paramb.jZN.field_updateTime));
      localContext = paramb.fhD.getContext();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abk(paramb.jZN.field_fromUser);
      if ((localObject != null) && (((ao)localObject).field_username.equals(paramb.jZN.field_fromUser))) {
        break label330;
      }
      y.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.jZN.field_fromUser });
      paramb.fhD.setText("");
      am.a.dVy.a(paramb.jZN.field_fromUser, "", null);
      if (!paramb.jZN.aQa()) {
        break label440;
      }
      paramb.kit.setVisibility(0);
      paramb.eXQ.setTag(paramg);
      if ((!this.kio.keG) && (!this.kio.keO)) {
        break label457;
      }
      paramb.eXQ.setVisibility(0);
      localObject = paramb.eXQ;
      if (this.kio.keH.get(Long.valueOf(paramg.field_localId)) == null) {
        break label452;
      }
      bool = true;
      label250:
      ((CheckBox)localObject).setChecked(bool);
    }
    for (;;)
    {
      paramb.kiu.setTag(paramg);
      if ((paramg.field_tagProto.sXq == null) || (paramg.field_tagProto.sXq.isEmpty())) {
        break label469;
      }
      paramb.kis.setVisibility(0);
      return;
      paramb.kir.setVisibility(8);
      break;
      label310:
      paramb.dsz.setText(com.tencent.mm.plugin.fav.a.b.ev(paramb.jZN.field_datatotalsize));
      break label59;
      label330:
      if (s.fn(paramb.jZN.field_fromUser))
      {
        localObject = paramb.jZN.field_favProto.sXa;
        if (q.Gj().equals(((yp)localObject).bRO)) {
          localObject = com.tencent.mm.plugin.fav.a.b.Cy(((yp)localObject).toUser);
        }
      }
      for (;;)
      {
        paramb.fhD.setText(com.tencent.mm.pluginsdk.ui.d.j.a(localContext, (CharSequence)localObject, paramb.fhD.getTextSize()));
        break;
        localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.a.b.class)).gU(((yp)localObject).bRO);
        continue;
        localObject = com.tencent.mm.plugin.fav.a.b.Cy(((ao)localObject).field_username);
      }
      label440:
      paramb.kit.setVisibility(8);
      break label184;
      label452:
      bool = false;
      break label250;
      label457:
      paramb.eXQ.setVisibility(8);
    }
    label469:
    paramb.kis.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */