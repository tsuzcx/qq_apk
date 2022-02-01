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
import com.tencent.mm.g.c.au;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ago;
import com.tencent.mm.protocal.protobuf.agq;
import com.tencent.mm.protocal.protobuf.agu;
import com.tencent.mm.protocal.protobuf.ahb;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.storage.bg;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected o qcI = null;
  public final a qkC = new a();
  
  public b(o paramo)
  {
    this.qcI = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.qkF = paramView.findViewById(2131299852);
    if (paramb.qkF == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.qkG = ((WeImageView)paramView.findViewById(2131307191));
    if (paramb.qkG == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.imt = ((TextView)paramView.findViewById(2131299814));
    if (paramb.imt == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.qkH = ((TextView)paramView.findViewById(2131307192));
    if (paramb.qkH == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.fwS = ((TextView)paramView.findViewById(2131299847));
    if (paramb.fwS == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.icb = ((CheckBox)paramView.findViewById(2131299771));
    if (paramb.icb == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.qkI = ((ImageView)paramView.findViewById(2131299844));
    if (paramb.qkI == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.icb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
          localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().pS(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.pZE)
          {
            paramAnonymousCompoundButton.pZF = localg;
            b.this.qkC.qgT.put(paramAnonymousCompoundButton.djR, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.qkC.qkE != null) {
            b.this.qkC.qkE.pW(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.qkC.qgT.put(bt.dP(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.pZE) {
            b.this.qkC.qgT.remove(paramAnonymousCompoundButton.djR);
          } else {
            b.this.qkC.qgT.remove(bt.dP(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.qaS = paramg;
    paramView.setTag(paramb);
    paramb.qkJ = ((LinearLayout)paramView.findViewById(2131299841));
    paramb.qkK = ((TextView)paramView.findViewById(2131299840));
    paramb.qkK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        ad.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g)) {
          com.tencent.mm.plugin.fav.a.b.l((com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag());
        }
        AppMethodBeat.o(107447);
      }
    });
    return paramView;
  }
  
  public abstract void a(View paramView, agq paramagq);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.imt.getContext();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).apM().aHX(paramb.qaS.field_fromUser);
    if ((localObject == null) || (!((au)localObject).field_username.equals(paramb.qaS.field_fromUser)))
    {
      ad.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.qaS.field_fromUser });
      paramb.imt.setText("");
      ar.a.gMW.a(paramb.qaS.field_fromUser, "", null);
      return;
    }
    if (w.pF(paramb.qaS.field_fromUser))
    {
      localObject = paramb.qaS.field_favProto.DiD;
      if (u.aqG().equals(((agu)localObject).dpv)) {
        localObject = com.tencent.mm.plugin.fav.a.b.XV(((agu)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.imt.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)localObject, paramb.imt.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).sh(((agu)localObject).dpv);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.XV(((au)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.qaS = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.qaS.field_type == 18)
    {
      paramb.qkF.setVisibility(0);
      if (this.qkC.qha) {
        break label215;
      }
      paramb.fwS.setText(m.h(paramb.fwS.getContext(), paramb.qaS.field_updateTime));
      a(paramb);
      if (!paramb.qaS.isUploadFailed()) {
        break label235;
      }
      paramb.qkJ.setVisibility(0);
      paramb.icb.setTag(paramg);
      if ((!this.qkC.qgS) && (!this.qkC.qha)) {
        break label300;
      }
      paramb.icb.setVisibility(0);
      if (!paramg.pZE) {
        break label252;
      }
      localCheckBox = paramb.icb;
      if (this.qkC.qgT.get(paramg.djR) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.qkK.setTag(paramg);
      if ((paramg.field_tagProto.DiR == null) || (paramg.field_tagProto.DiR.isEmpty())) {
        break label312;
      }
      paramb.qkI.setVisibility(0);
      return;
      paramb.qkF.setVisibility(8);
      break;
      label215:
      paramb.fwS.setText(com.tencent.mm.plugin.fav.a.b.pJ(paramb.qaS.field_datatotalsize));
      break label64;
      label235:
      paramb.qkJ.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.icb;
      if (this.qkC.qgT.get(bt.dP(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.icb.setVisibility(8);
    }
    label312:
    paramb.qkI.setVisibility(8);
  }
  
  public static final class a
  {
    public String fvQ;
    public long lastUpdateTime;
    public boolean mUj;
    public boolean qgS;
    public Map<String, com.tencent.mm.plugin.fav.a.g> qgT;
    public boolean qha;
    public b.c qkE;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.mUj).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.fvQ).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public TextView fwS;
    public CheckBox icb;
    public TextView imt;
    public com.tencent.mm.plugin.fav.a.g qaS;
    public View qkF;
    public WeImageView qkG;
    public TextView qkH;
    public ImageView qkI;
    public LinearLayout qkJ;
    public TextView qkK;
  }
  
  public static abstract interface c
  {
    public abstract void pW(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.b
 * JD-Core Version:    0.7.0.1
 */