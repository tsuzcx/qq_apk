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
import com.tencent.mm.f.c.ax;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ag;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.plugin.fav.ui.s.e;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.l;
import com.tencent.mm.protocal.protobuf.aoc;
import com.tencent.mm.protocal.protobuf.aoe;
import com.tencent.mm.protocal.protobuf.aoi;
import com.tencent.mm.protocal.protobuf.aop;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.bv;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected o wJr = null;
  public final a wRC = new a();
  
  public b(o paramo)
  {
    this.wJr = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, g paramg);
  
  protected final View a(View paramView, b paramb, g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.wRF = paramView.findViewById(s.e.fav_type_layout);
    if (paramb.wRF == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.wRG = ((WeImageView)paramView.findViewById(s.e.fav_type_iv));
    if (paramb.wRG == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.mYd = ((TextView)paramView.findViewById(s.e.fav_name));
    if (paramb.mYd == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.wRH = ((TextView)paramView.findViewById(s.e.fav_version_info));
    if (paramb.wRH == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.timeTV = ((TextView)paramView.findViewById(s.e.fav_time));
    if (paramb.timeTV == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.mNd = ((CheckBox)paramView.findViewById(s.e.fav_checkbox));
    if (paramb.mNd == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.wRI = ((ImageView)paramView.findViewById(s.e.fav_tag_iv));
    if (paramb.wRI == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.mNd.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
    {
      public final void onCheckedChanged(CompoundButton paramAnonymousCompoundButton, boolean paramAnonymousBoolean)
      {
        AppMethodBeat.i(107446);
        if (paramAnonymousCompoundButton.getTag() == null)
        {
          AppMethodBeat.o(107446);
          return;
        }
        paramAnonymousCompoundButton = (g)paramAnonymousCompoundButton.getTag();
        g localg;
        if (paramAnonymousBoolean)
        {
          localg = ((ag)h.ag(ag.class)).getFavItemInfoStorage().Km(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.wGh)
          {
            paramAnonymousCompoundButton.wGi = localg;
            b.this.wRC.wNC.put(paramAnonymousCompoundButton.fDQ, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.wRC.wRE != null) {
            b.this.wRC.wRE.Kq(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.wRC.wNC.put(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.wGh) {
            b.this.wRC.wNC.remove(paramAnonymousCompoundButton.fDQ);
          } else {
            b.this.wRC.wNC.remove(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.wHw = paramg;
    paramView.setTag(paramb);
    paramb.wRJ = ((LinearLayout)paramView.findViewById(s.e.fav_sync_error_ll));
    paramb.wRK = ((TextView)paramView.findViewById(s.e.fav_sync_error_btn));
    paramb.wRK.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.bn(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
        Log.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if ((paramAnonymousView.getTag() instanceof g)) {
          com.tencent.mm.plugin.fav.a.b.l((g)paramAnonymousView.getTag());
        }
        a.a(this, "com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(107447);
      }
    });
    return paramView;
  }
  
  public abstract void a(View paramView, aoe paramaoe);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.mYd.getContext();
    Object localObject = ((n)h.ae(n.class)).bbL().bwh(paramb.wHw.field_fromUser);
    if ((localObject == null) || (!((ax)localObject).field_username.equals(paramb.wHw.field_fromUser)))
    {
      Log.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.wHw.field_fromUser });
      paramb.mYd.setText("");
      az.a.ltq.a(paramb.wHw.field_fromUser, "", null);
      return;
    }
    if (ab.Lj(paramb.wHw.field_fromUser))
    {
      localObject = paramb.wHw.field_favProto.SAB;
      if (z.bcZ().equals(((aoi)localObject).fLi)) {
        localObject = com.tencent.mm.plugin.fav.a.b.azM(((aoi)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.mYd.setText(l.b(localContext, (CharSequence)localObject, paramb.mYd.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)h.ae(com.tencent.mm.plugin.messenger.a.b.class)).PJ(((aoi)localObject).fLi);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.azM(((ax)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.wHw = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.wHw.field_type == 18)
    {
      paramb.wRF.setVisibility(0);
      if (this.wRC.wNJ) {
        break label215;
      }
      paramb.timeTV.setText(m.h(paramb.timeTV.getContext(), paramb.wHw.field_updateTime));
      a(paramb);
      if (!paramb.wHw.djE()) {
        break label235;
      }
      paramb.wRJ.setVisibility(0);
      paramb.mNd.setTag(paramg);
      if ((!this.wRC.wNB) && (!this.wRC.wNJ)) {
        break label300;
      }
      paramb.mNd.setVisibility(0);
      if (!paramg.wGh) {
        break label252;
      }
      localCheckBox = paramb.mNd;
      if (this.wRC.wNC.get(paramg.fDQ) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.wRK.setTag(paramg);
      if ((paramg.field_tagProto.SAP == null) || (paramg.field_tagProto.SAP.isEmpty())) {
        break label312;
      }
      paramb.wRI.setVisibility(0);
      return;
      paramb.wRF.setVisibility(8);
      break;
      label215:
      paramb.timeTV.setText(com.tencent.mm.plugin.fav.a.b.Kd(paramb.wHw.field_datatotalsize));
      break label64;
      label235:
      paramb.wRJ.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.mNd;
      if (this.wRC.wNC.get(Util.notNullToString(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.mNd.setVisibility(8);
    }
    label312:
    paramb.wRI.setVisibility(8);
  }
  
  public static final class a
  {
    public String jkc;
    public long lastUpdateTime;
    public boolean sxF;
    public boolean wNB;
    public Map<String, g> wNC;
    public boolean wNJ;
    public b.c wRE;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.sxF).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.jkc).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public CheckBox mNd;
    public TextView mYd;
    public TextView timeTV;
    public g wHw;
    public View wRF;
    public WeImageView wRG;
    public TextView wRH;
    public ImageView wRI;
    public LinearLayout wRJ;
    public TextView wRK;
  }
  
  public static abstract interface c
  {
    public abstract void Kq(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.b
 * JD-Core Version:    0.7.0.1
 */