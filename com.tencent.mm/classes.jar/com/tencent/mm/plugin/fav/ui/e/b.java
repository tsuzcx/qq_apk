package com.tencent.mm.plugin.fav.ui.e;

import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.c.aw;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.model.as.a;
import com.tencent.mm.model.as.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.akd;
import com.tencent.mm.protocal.protobuf.akf;
import com.tencent.mm.protocal.protobuf.akj;
import com.tencent.mm.protocal.protobuf.akq;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bp;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  public final a rDh = new a();
  protected o rvp = null;
  
  public b(o paramo)
  {
    this.rvp = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.rDk = paramView.findViewById(2131299852);
    if (paramb.rDk == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.rDl = ((WeImageView)paramView.findViewById(2131307191));
    if (paramb.rDl == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.jfJ = ((TextView)paramView.findViewById(2131299814));
    if (paramb.jfJ == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.rDm = ((TextView)paramView.findViewById(2131307192));
    if (paramb.rDm == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.fTP = ((TextView)paramView.findViewById(2131299847));
    if (paramb.fTP == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.iVs = ((CheckBox)paramView.findViewById(2131299771));
    if (paramb.iVs == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.rDn = ((ImageView)paramView.findViewById(2131299844));
    if (paramb.rDn == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.iVs.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
          localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vE(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.rsm)
          {
            paramAnonymousCompoundButton.rsn = localg;
            b.this.rDh.rzu.put(paramAnonymousCompoundButton.dsK, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.rDh.rDj != null) {
            b.this.rDh.rDj.vI(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.rDh.rzu.put(bt.dT(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.rsm) {
            b.this.rDh.rzu.remove(paramAnonymousCompoundButton.dsK);
          } else {
            b.this.rDh.rzu.remove(bt.dT(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.rtA = paramg;
    paramView.setTag(paramb);
    paramb.rDo = ((LinearLayout)paramView.findViewById(2131299841));
    paramb.rDp = ((TextView)paramView.findViewById(2131299840));
    paramb.rDp.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
        ad.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g)) {
          com.tencent.mm.plugin.fav.a.b.l((com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag());
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107447);
      }
    });
    return paramView;
  }
  
  public abstract void a(View paramView, akf paramakf);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.jfJ.getContext();
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azp().aTk(paramb.rtA.field_fromUser);
    if ((localObject == null) || (!((aw)localObject).field_username.equals(paramb.rtA.field_fromUser)))
    {
      ad.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.rtA.field_fromUser });
      paramb.jfJ.setText("");
      as.a.hFO.a(paramb.rtA.field_fromUser, "", null);
      return;
    }
    if (w.vF(paramb.rtA.field_fromUser))
    {
      localObject = paramb.rtA.field_favProto.Gjv;
      if (u.aAm().equals(((akj)localObject).dyU)) {
        localObject = com.tencent.mm.plugin.fav.a.b.agg(((akj)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.jfJ.setText(k.b(localContext, (CharSequence)localObject, paramb.jfJ.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zf(((akj)localObject).dyU);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.agg(((aw)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.rtA = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.rtA.field_type == 18)
    {
      paramb.rDk.setVisibility(0);
      if (this.rDh.rzB) {
        break label215;
      }
      paramb.fTP.setText(m.h(paramb.fTP.getContext(), paramb.rtA.field_updateTime));
      a(paramb);
      if (!paramb.rtA.isUploadFailed()) {
        break label235;
      }
      paramb.rDo.setVisibility(0);
      paramb.iVs.setTag(paramg);
      if ((!this.rDh.rzt) && (!this.rDh.rzB)) {
        break label300;
      }
      paramb.iVs.setVisibility(0);
      if (!paramg.rsm) {
        break label252;
      }
      localCheckBox = paramb.iVs;
      if (this.rDh.rzu.get(paramg.dsK) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.rDp.setTag(paramg);
      if ((paramg.field_tagProto.GjJ == null) || (paramg.field_tagProto.GjJ.isEmpty())) {
        break label312;
      }
      paramb.rDn.setVisibility(0);
      return;
      paramb.rDk.setVisibility(8);
      break;
      label215:
      paramb.fTP.setText(com.tencent.mm.plugin.fav.a.b.vv(paramb.rtA.field_datatotalsize));
      break label64;
      label235:
      paramb.rDo.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.iVs;
      if (this.rDh.rzu.get(bt.dT(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.iVs.setVisibility(8);
    }
    label312:
    paramb.rDn.setVisibility(8);
  }
  
  public static final class a
  {
    public String fSM;
    public long lastUpdateTime;
    public boolean nXZ;
    public b.c rDj;
    public boolean rzB;
    public boolean rzt;
    public Map<String, com.tencent.mm.plugin.fav.a.g> rzu;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.nXZ).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.fSM).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public TextView fTP;
    public CheckBox iVs;
    public TextView jfJ;
    public View rDk;
    public WeImageView rDl;
    public TextView rDm;
    public ImageView rDn;
    public LinearLayout rDo;
    public TextView rDp;
    public com.tencent.mm.plugin.fav.a.g rtA;
  }
  
  public static abstract interface c
  {
    public abstract void vI(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.b
 * JD-Core Version:    0.7.0.1
 */