package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.ax;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ay.a;
import com.tencent.mm.model.ay.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.anb;
import com.tencent.mm.protocal.protobuf.and;
import com.tencent.mm.protocal.protobuf.anh;
import com.tencent.mm.protocal.protobuf.ano;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected o tdg = null;
  public final a tle = new a();
  
  public b(o paramo)
  {
    this.tdg = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.tlh = paramView.findViewById(2131300531);
    if (paramb.tlh == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.tli = ((WeImageView)paramView.findViewById(2131300530));
    if (paramb.tli == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.kgE = ((TextView)paramView.findViewById(2131300489));
    if (paramb.kgE == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.tlj = ((TextView)paramView.findViewById(2131300534));
    if (paramb.tlj == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.timeTV = ((TextView)paramView.findViewById(2131300525));
    if (paramb.timeTV == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.jVQ = ((CheckBox)paramView.findViewById(2131300442));
    if (paramb.jVQ == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.tlk = ((ImageView)paramView.findViewById(2131300522));
    if (paramb.tlk == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.jVQ.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(107446);
        if (paramAnonymousCompoundButton.getTag() == null)
        {
          AppMethodBeat.o(107446);
          return;
        }
        paramAnonymousCompoundButton = (com.tencent.mm.plugin.fav.a.g)paramAnonymousCompoundButton.getTag();
        com.tencent.mm.plugin.fav.a.g localg;
        if (paramAnonymousBoolean)
        {
          localg = ((af)com.tencent.mm.kernel.g.ah(af.class)).getFavItemInfoStorage().DY(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.tad)
          {
            paramAnonymousCompoundButton.tae = localg;
            b.this.tle.thm.put(paramAnonymousCompoundButton.dLb, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.tle.tlg != null) {
            b.this.tle.tlg.Ec(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.tle.thm.put(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.tad) {
            b.this.tle.thm.remove(paramAnonymousCompoundButton.dLb);
          } else {
            b.this.tle.thm.remove(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.tbr = paramg;
    paramView.setTag(paramb);
    paramb.tll = ((LinearLayout)paramView.findViewById(2131300519));
    paramb.tlm = ((TextView)paramView.findViewById(2131300518));
    paramb.tlm.setOnClickListener(new b.2(this));
    return paramView;
  }
  
  public abstract void a(View paramView, and paramand);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.kgE.getContext();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.l)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.foundation.a.l.class)).aSN().bjK(paramb.tbr.field_fromUser);
    if ((localObject == null) || (!((ax)localObject).field_username.equals(paramb.tbr.field_fromUser)))
    {
      Log.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.tbr.field_fromUser });
      paramb.kgE.setText("");
      ay.a.iDq.a(paramb.tbr.field_fromUser, "", null);
      return;
    }
    if (ab.Eq(paramb.tbr.field_fromUser))
    {
      localObject = paramb.tbr.field_favProto.Lya;
      if (z.aTY().equals(((anh)localObject).dRL)) {
        localObject = com.tencent.mm.plugin.fav.a.b.arL(((anh)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.kgE.setText(com.tencent.mm.pluginsdk.ui.span.l.b(localContext, (CharSequence)localObject, paramb.kgE.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(((anh)localObject).dRL);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.arL(((ax)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.tbr = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.tbr.field_type == 18)
    {
      paramb.tlh.setVisibility(0);
      if (this.tle.tht) {
        break label215;
      }
      paramb.timeTV.setText(m.h(paramb.timeTV.getContext(), paramb.tbr.field_updateTime));
      a(paramb);
      if (!paramb.tbr.cUy()) {
        break label235;
      }
      paramb.tll.setVisibility(0);
      paramb.jVQ.setTag(paramg);
      if ((!this.tle.thl) && (!this.tle.tht)) {
        break label300;
      }
      paramb.jVQ.setVisibility(0);
      if (!paramg.tad) {
        break label252;
      }
      localCheckBox = paramb.jVQ;
      if (this.tle.thm.get(paramg.dLb) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.tlm.setTag(paramg);
      if ((paramg.field_tagProto.Lyo == null) || (paramg.field_tagProto.Lyo.isEmpty())) {
        break label312;
      }
      paramb.tlk.setVisibility(0);
      return;
      paramb.tlh.setVisibility(8);
      break;
      label215:
      paramb.timeTV.setText(com.tencent.mm.plugin.fav.a.b.DP(paramb.tbr.field_datatotalsize));
      break label64;
      label235:
      paramb.tll.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.jVQ;
      if (this.tle.thm.get(Util.notNullToString(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.jVQ.setVisibility(8);
    }
    label312:
    paramb.tlk.setVisibility(8);
  }
  
  public static final class a
  {
    public String gzZ;
    public long lastUpdateTime;
    public boolean poG;
    public boolean thl;
    public Map<String, com.tencent.mm.plugin.fav.a.g> thm;
    public boolean tht;
    public b.c tlg;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.poG).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.gzZ).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public CheckBox jVQ;
    public TextView kgE;
    public com.tencent.mm.plugin.fav.a.g tbr;
    public TextView timeTV;
    public View tlh;
    public WeImageView tli;
    public TextView tlj;
    public ImageView tlk;
    public LinearLayout tll;
    public TextView tlm;
  }
  
  public static abstract interface c
  {
    public abstract void Ec(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.b
 * JD-Core Version:    0.7.0.1
 */