package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.ao.a;
import com.tencent.mm.model.ao.b;
import com.tencent.mm.model.r;
import com.tencent.mm.model.t;
import com.tencent.mm.plugin.fav.ui.l;
import com.tencent.mm.protocal.protobuf.acq;
import com.tencent.mm.protocal.protobuf.acs;
import com.tencent.mm.protocal.protobuf.acw;
import com.tencent.mm.protocal.protobuf.add;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.storage.bd;
import java.util.List;
import java.util.Map;

public abstract class a
{
  public final a.a mCS = new a.a();
  protected l mvC = null;
  
  public a(l paraml)
  {
    this.mvC = paraml;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, a.b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.mCV = paramView.findViewById(2131824031);
    if (paramb.mCV == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.gzk = ((TextView)paramView.findViewById(2131820611));
    if (paramb.gzk == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.ekh = ((TextView)paramView.findViewById(2131820618));
    if (paramb.ekh == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.gpN = ((CheckBox)paramView.findViewById(2131820600));
    if (paramb.gpN == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.mCW = ((ImageView)paramView.findViewById(2131824032));
    if (paramb.mCW == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.gpN.setOnCheckedChangeListener(new a.1(this));
    paramb.muk = paramg;
    paramView.setTag(paramb);
    paramb.mCX = ((LinearLayout)paramView.findViewById(2131824029));
    paramb.mCY = ((TextView)paramView.findViewById(2131824030));
    paramb.mCY.setOnClickListener(new a.2(this));
    return paramView;
  }
  
  public abstract void a(View paramView, acs paramacs);
  
  protected final void a(a.b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    paramb.muk = paramg;
    label59:
    Context localContext;
    Object localObject;
    label184:
    boolean bool;
    if (paramb.muk.field_type == 18)
    {
      paramb.mCV.setVisibility(0);
      if (this.mCS.mzx) {
        break label310;
      }
      paramb.ekh.setText(com.tencent.mm.plugin.fav.ui.j.g(paramb.ekh.getContext(), paramb.muk.field_updateTime));
      localContext = paramb.gzk.getContext();
      localObject = ((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.foundation.a.j.class)).YA().arv(paramb.muk.field_fromUser);
      if ((localObject != null) && (((aq)localObject).field_username.equals(paramb.muk.field_fromUser))) {
        break label330;
      }
      ab.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.muk.field_fromUser });
      paramb.gzk.setText("");
      ao.a.flI.a(paramb.muk.field_fromUser, "", null);
      if (!paramb.muk.bwp()) {
        break label440;
      }
      paramb.mCX.setVisibility(0);
      paramb.gpN.setTag(paramg);
      if ((!this.mCS.mzp) && (!this.mCS.mzx)) {
        break label457;
      }
      paramb.gpN.setVisibility(0);
      localObject = paramb.gpN;
      if (this.mCS.mzq.get(Long.valueOf(paramg.field_localId)) == null) {
        break label452;
      }
      bool = true;
      label250:
      ((CheckBox)localObject).setChecked(bool);
    }
    for (;;)
    {
      paramb.mCY.setTag(paramg);
      if ((paramg.field_tagProto.wVq == null) || (paramg.field_tagProto.wVq.isEmpty())) {
        break label469;
      }
      paramb.mCW.setVisibility(0);
      return;
      paramb.mCV.setVisibility(8);
      break;
      label310:
      paramb.ekh.setText(com.tencent.mm.plugin.fav.a.b.jS(paramb.muk.field_datatotalsize));
      break label59;
      label330:
      if (t.lA(paramb.muk.field_fromUser))
      {
        localObject = paramb.muk.field_favProto.wVa;
        if (r.Zn().equals(((acw)localObject).czp)) {
          localObject = com.tencent.mm.plugin.fav.a.b.NA(((acw)localObject).toUser);
        }
      }
      for (;;)
      {
        paramb.gzk.setText(com.tencent.mm.pluginsdk.ui.d.j.b(localContext, (CharSequence)localObject, paramb.gzk.getTextSize()));
        break;
        localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.messenger.a.b.class)).nD(((acw)localObject).czp);
        continue;
        localObject = com.tencent.mm.plugin.fav.a.b.NA(((aq)localObject).field_username);
      }
      label440:
      paramb.mCX.setVisibility(8);
      break label184;
      label452:
      bool = false;
      break label250;
      label457:
      paramb.gpN.setVisibility(8);
    }
    label469:
    paramb.mCW.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.a
 * JD-Core Version:    0.7.0.1
 */