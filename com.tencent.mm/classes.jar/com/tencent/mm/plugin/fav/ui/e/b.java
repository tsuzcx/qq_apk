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
import com.tencent.mm.model.au.a;
import com.tencent.mm.model.au.b;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.messenger.foundation.a.l;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.akn;
import com.tencent.mm.protocal.protobuf.akp;
import com.tencent.mm.protocal.protobuf.akt;
import com.tencent.mm.protocal.protobuf.ala;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.bq;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected o rDB = null;
  public final a rLs = new a();
  
  public b(o paramo)
  {
    this.rDB = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.rLv = paramView.findViewById(2131299852);
    if (paramb.rLv == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.rLw = ((WeImageView)paramView.findViewById(2131307191));
    if (paramb.rLw == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.jiC = ((TextView)paramView.findViewById(2131299814));
    if (paramb.jiC == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.rLx = ((TextView)paramView.findViewById(2131307192));
    if (paramb.rLx == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.fVV = ((TextView)paramView.findViewById(2131299847));
    if (paramb.fVV == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.iYl = ((CheckBox)paramView.findViewById(2131299771));
    if (paramb.iYl == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.rLy = ((ImageView)paramView.findViewById(2131299844));
    if (paramb.rLy == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.iYl.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
          localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().vU(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.rAz)
          {
            paramAnonymousCompoundButton.rAA = localg;
            b.this.rLs.rHF.put(paramAnonymousCompoundButton.dtQ, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.rLs.rLu != null) {
            b.this.rLs.rLu.vY(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.rLs.rHF.put(bu.dU(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.rAz) {
            b.this.rLs.rHF.remove(paramAnonymousCompoundButton.dtQ);
          } else {
            b.this.rLs.rHF.remove(bu.dU(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.rBM = paramg;
    paramView.setTag(paramb);
    paramb.rLz = ((LinearLayout)paramView.findViewById(2131299841));
    paramb.rLA = ((TextView)paramView.findViewById(2131299840));
    paramb.rLA.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bd(paramAnonymousView);
        a.b("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
        ae.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g)) {
          com.tencent.mm.plugin.fav.a.b.l((com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag());
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107447);
      }
    });
    return paramView;
  }
  
  public abstract void a(View paramView, akp paramakp);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.jiC.getContext();
    Object localObject = ((l)com.tencent.mm.kernel.g.ab(l.class)).azF().aUL(paramb.rBM.field_fromUser);
    if ((localObject == null) || (!((aw)localObject).field_username.equals(paramb.rBM.field_fromUser)))
    {
      ae.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.rBM.field_fromUser });
      paramb.jiC.setText("");
      au.a.hIG.a(paramb.rBM.field_fromUser, "", null);
      return;
    }
    if (com.tencent.mm.model.x.wb(paramb.rBM.field_fromUser))
    {
      localObject = paramb.rBM.field_favProto.GCe;
      if (v.aAC().equals(((akt)localObject).dzZ)) {
        localObject = com.tencent.mm.plugin.fav.a.b.ahd(((akt)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.jiC.setText(k.b(localContext, (CharSequence)localObject, paramb.jiC.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).zP(((akt)localObject).dzZ);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.ahd(((aw)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.rBM = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.rBM.field_type == 18)
    {
      paramb.rLv.setVisibility(0);
      if (this.rLs.rHM) {
        break label215;
      }
      paramb.fVV.setText(m.h(paramb.fVV.getContext(), paramb.rBM.field_updateTime));
      a(paramb);
      if (!paramb.rBM.isUploadFailed()) {
        break label235;
      }
      paramb.rLz.setVisibility(0);
      paramb.iYl.setTag(paramg);
      if ((!this.rLs.rHE) && (!this.rLs.rHM)) {
        break label300;
      }
      paramb.iYl.setVisibility(0);
      if (!paramg.rAz) {
        break label252;
      }
      localCheckBox = paramb.iYl;
      if (this.rLs.rHF.get(paramg.dtQ) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.rLA.setTag(paramg);
      if ((paramg.field_tagProto.GCs == null) || (paramg.field_tagProto.GCs.isEmpty())) {
        break label312;
      }
      paramb.rLy.setVisibility(0);
      return;
      paramb.rLv.setVisibility(8);
      break;
      label215:
      paramb.fVV.setText(com.tencent.mm.plugin.fav.a.b.vL(paramb.rBM.field_datatotalsize));
      break label64;
      label235:
      paramb.rLz.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.iYl;
      if (this.rLs.rHF.get(bu.dU(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.iYl.setVisibility(8);
    }
    label312:
    paramb.rLy.setVisibility(8);
  }
  
  public static final class a
  {
    public String fUS;
    public long lastUpdateTime;
    public boolean odI;
    public boolean rHE;
    public Map<String, com.tencent.mm.plugin.fav.a.g> rHF;
    public boolean rHM;
    public b.c rLu;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.odI).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.fUS).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public TextView fVV;
    public CheckBox iYl;
    public TextView jiC;
    public com.tencent.mm.plugin.fav.a.g rBM;
    public TextView rLA;
    public View rLv;
    public WeImageView rLw;
    public TextView rLx;
    public ImageView rLy;
    public LinearLayout rLz;
  }
  
  public static abstract interface c
  {
    public abstract void vY(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.b
 * JD-Core Version:    0.7.0.1
 */