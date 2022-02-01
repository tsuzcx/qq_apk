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
import com.tencent.mm.g.c.av;
import com.tencent.mm.model.ar.a;
import com.tencent.mm.model.ar.b;
import com.tencent.mm.model.u;
import com.tencent.mm.model.w;
import com.tencent.mm.plugin.fav.a.af;
import com.tencent.mm.plugin.fav.a.x;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.o;
import com.tencent.mm.protocal.protobuf.ahn;
import com.tencent.mm.protocal.protobuf.ahp;
import com.tencent.mm.protocal.protobuf.aht;
import com.tencent.mm.protocal.protobuf.aia;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.storage.bj;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected o qLn = null;
  public final a qTe = new a();
  
  public b(o paramo)
  {
    this.qLn = paramo;
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, com.tencent.mm.plugin.fav.a.g paramg);
  
  protected final View a(View paramView, b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.qTh = paramView.findViewById(2131299852);
    if (paramb.qTh == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.qTi = ((WeImageView)paramView.findViewById(2131307191));
    if (paramb.qTi == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.iMz = ((TextView)paramView.findViewById(2131299814));
    if (paramb.iMz == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.qTj = ((TextView)paramView.findViewById(2131307192));
    if (paramb.qTj == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.fAz = ((TextView)paramView.findViewById(2131299847));
    if (paramb.fAz == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.iCi = ((CheckBox)paramView.findViewById(2131299771));
    if (paramb.iCi == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.qTk = ((ImageView)paramView.findViewById(2131299844));
    if (paramb.qTk == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.iCi.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
          localg = ((af)com.tencent.mm.kernel.g.ad(af.class)).getFavItemInfoStorage().tH(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.qIl)
          {
            paramAnonymousCompoundButton.qIm = localg;
            b.this.qTe.qPv.put(paramAnonymousCompoundButton.dhm, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.qTe.qTg != null) {
            b.this.qTe.qTg.tL(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.qTe.qPv.put(bs.dQ(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.qIl) {
            b.this.qTe.qPv.remove(paramAnonymousCompoundButton.dhm);
          } else {
            b.this.qTe.qPv.remove(bs.dQ(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.qJy = paramg;
    paramView.setTag(paramb);
    paramb.qTl = ((LinearLayout)paramView.findViewById(2131299841));
    paramb.qTm = ((TextView)paramView.findViewById(2131299840));
    paramb.qTm.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        ac.d("MicroMsg.FavBaseListItem", "manual restart upload");
        if ((paramAnonymousView.getTag() instanceof com.tencent.mm.plugin.fav.a.g)) {
          com.tencent.mm.plugin.fav.a.b.l((com.tencent.mm.plugin.fav.a.g)paramAnonymousView.getTag());
        }
        AppMethodBeat.o(107447);
      }
    });
    return paramView;
  }
  
  public abstract void a(View paramView, ahp paramahp);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.iMz.getContext();
    Object localObject = ((com.tencent.mm.plugin.messenger.foundation.a.k)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.foundation.a.k.class)).awB().aNs(paramb.qJy.field_fromUser);
    if ((localObject == null) || (!((av)localObject).field_username.equals(paramb.qJy.field_fromUser)))
    {
      ac.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.qJy.field_fromUser });
      paramb.iMz.setText("");
      ar.a.hnw.a(paramb.qJy.field_fromUser, "", null);
      return;
    }
    if (w.sQ(paramb.qJy.field_fromUser))
    {
      localObject = paramb.qJy.field_favProto.EBJ;
      if (u.axw().equals(((aht)localObject).dng)) {
        localObject = com.tencent.mm.plugin.fav.a.b.acr(((aht)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.iMz.setText(com.tencent.mm.pluginsdk.ui.span.k.b(localContext, (CharSequence)localObject, paramb.iMz.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.messenger.a.b.class)).wk(((aht)localObject).dng);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.acr(((av)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, com.tencent.mm.plugin.fav.a.g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.qJy = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.qJy.field_type == 18)
    {
      paramb.qTh.setVisibility(0);
      if (this.qTe.qPC) {
        break label215;
      }
      paramb.fAz.setText(m.h(paramb.fAz.getContext(), paramb.qJy.field_updateTime));
      a(paramb);
      if (!paramb.qJy.isUploadFailed()) {
        break label235;
      }
      paramb.qTl.setVisibility(0);
      paramb.iCi.setTag(paramg);
      if ((!this.qTe.qPu) && (!this.qTe.qPC)) {
        break label300;
      }
      paramb.iCi.setVisibility(0);
      if (!paramg.qIl) {
        break label252;
      }
      localCheckBox = paramb.iCi;
      if (this.qTe.qPv.get(paramg.dhm) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.qTm.setTag(paramg);
      if ((paramg.field_tagProto.EBX == null) || (paramg.field_tagProto.EBX.isEmpty())) {
        break label312;
      }
      paramb.qTk.setVisibility(0);
      return;
      paramb.qTh.setVisibility(8);
      break;
      label215:
      paramb.fAz.setText(com.tencent.mm.plugin.fav.a.b.ty(paramb.qJy.field_datatotalsize));
      break label64;
      label235:
      paramb.qTl.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.iCi;
      if (this.qTe.qPv.get(bs.dQ(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.iCi.setVisibility(8);
    }
    label312:
    paramb.qTk.setVisibility(8);
  }
  
  public static final class a
  {
    public String fzx;
    public long lastUpdateTime;
    public boolean nwB;
    public boolean qPC;
    public boolean qPu;
    public Map<String, com.tencent.mm.plugin.fav.a.g> qPv;
    public b.c qTg;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.nwB).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.fzx).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public TextView fAz;
    public CheckBox iCi;
    public TextView iMz;
    public com.tencent.mm.plugin.fav.a.g qJy;
    public View qTh;
    public WeImageView qTi;
    public TextView qTj;
    public ImageView qTk;
    public LinearLayout qTl;
    public TextView qTm;
  }
  
  public static abstract interface c
  {
    public abstract void tL(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.e.b
 * JD-Core Version:    0.7.0.1
 */