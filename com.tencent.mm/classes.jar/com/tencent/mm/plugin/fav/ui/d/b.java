package com.tencent.mm.plugin.fav.ui.d;

import android.content.Context;
import android.content.res.Resources;
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
import com.tencent.mm.autogen.b.az;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.az.a;
import com.tencent.mm.model.az.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.fav.a.ah;
import com.tencent.mm.plugin.fav.a.g;
import com.tencent.mm.plugin.fav.a.y;
import com.tencent.mm.plugin.fav.ui.FavoriteImageServer;
import com.tencent.mm.plugin.fav.ui.m;
import com.tencent.mm.plugin.fav.ui.q.e;
import com.tencent.mm.plugin.fav.ui.q.i;
import com.tencent.mm.plugin.messenger.foundation.a.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.protocal.protobuf.arf;
import com.tencent.mm.protocal.protobuf.arv;
import com.tencent.mm.protocal.protobuf.arx;
import com.tencent.mm.protocal.protobuf.asb;
import com.tencent.mm.protocal.protobuf.asi;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.mm.storage.bx;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.List;
import java.util.Map;

public abstract class b
{
  protected FavoriteImageServer AfM = null;
  public final a Aof = new a();
  
  public b(FavoriteImageServer paramFavoriteImageServer)
  {
    this.AfM = paramFavoriteImageServer;
  }
  
  public static boolean a(View paramView, arf paramarf)
  {
    if (paramarf == null) {
      return false;
    }
    return am(paramView, paramarf.dataType);
  }
  
  public static boolean am(View paramView, int paramInt)
  {
    Log.d("MicroMsg.FavBaseListItem", "field type %d", new Object[] { Integer.valueOf(paramInt) });
    if (((paramView instanceof TextView)) && (((TextView)paramView).getText() != null)) {}
    for (String str = ((TextView)paramView).getText().toString();; str = "")
    {
      switch (paramInt)
      {
      case 9: 
      case 12: 
      case 13: 
      case 14: 
      case 20: 
      case 21: 
      case 23: 
      case 24: 
      case 25: 
      case 26: 
      case 27: 
      case 28: 
      case 30: 
      default: 
        return false;
      case 1: 
        paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_chat) + str);
      }
      for (;;)
      {
        return true;
        paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_note) + str);
        continue;
        paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.note_type_chat_voice) + str);
        continue;
        paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_url) + str);
        continue;
        if (com.tencent.mm.plugin.fav.a.b.dQh())
        {
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.note_type_finder) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_music) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_music) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_location) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_file) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sight) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_video) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_image) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_mall_product) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_friend_card) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_kefu_card) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_title_record) + str);
          continue;
          paramView.setContentDescription(paramView.getContext().getResources().getString(q.i.favorite_sub_app_brand) + str);
        }
      }
    }
  }
  
  public static boolean b(View paramView, g paramg)
  {
    if (paramg == null) {
      return false;
    }
    return am(paramView, paramg.field_type);
  }
  
  public abstract View a(View paramView, ViewGroup paramViewGroup, g paramg);
  
  protected final View a(View paramView, b paramb, g paramg)
  {
    if (paramView == null) {
      throw new NullPointerException("base item view is null");
    }
    paramb.Aoi = paramView.findViewById(q.e.fav_type_layout);
    if (paramb.Aoi == null) {
      throw new IllegalArgumentException("base item view do not contain id named favTypeLayout");
    }
    paramb.Aoj = ((WeImageView)paramView.findViewById(q.e.fav_type_iv));
    if (paramb.Aoj == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_type_iv");
    }
    paramb.pUL = ((TextView)paramView.findViewById(q.e.fav_name));
    if (paramb.pUL == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_name");
    }
    paramb.Aok = ((TextView)paramView.findViewById(q.e.fav_version_info));
    if (paramb.Aok == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_version_info");
    }
    paramb.timeTV = ((TextView)paramView.findViewById(q.e.fav_time));
    if (paramb.timeTV == null) {
      throw new IllegalArgumentException("base item view do not contain id named fav_time");
    }
    paramb.pJL = ((CheckBox)paramView.findViewById(q.e.fav_checkbox));
    if (paramb.pJL == null) {
      throw new IllegalArgumentException("base item view do not contain id named checkbox");
    }
    paramb.Aol = ((ImageView)paramView.findViewById(q.e.fav_tag_iv));
    if (paramb.Aol == null) {
      throw new IllegalArgumentException("base item view do not contain id named tagIV");
    }
    paramb.pJL.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
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
          localg = ((ah)h.az(ah.class)).getFavItemInfoStorage().mK(paramAnonymousCompoundButton.field_localId);
          if (paramAnonymousCompoundButton.Acq)
          {
            paramAnonymousCompoundButton.Acr = localg;
            b.this.Aof.Akf.put(paramAnonymousCompoundButton.hIG, paramAnonymousCompoundButton);
          }
        }
        for (;;)
        {
          if (b.this.Aof.Aoh != null) {
            b.this.Aof.Aoh.mO(paramAnonymousCompoundButton.field_localId);
          }
          AppMethodBeat.o(107446);
          return;
          b.this.Aof.Akf.put(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)), localg);
          continue;
          if (paramAnonymousCompoundButton.Acq) {
            b.this.Aof.Akf.remove(paramAnonymousCompoundButton.hIG);
          } else {
            b.this.Aof.Akf.remove(Util.notNullToString(Long.valueOf(paramAnonymousCompoundButton.field_localId)));
          }
        }
      }
    });
    paramb.AdF = paramg;
    paramView.setTag(paramb);
    paramb.Aom = ((LinearLayout)paramView.findViewById(q.e.fav_sync_error_ll));
    paramb.Aon = ((TextView)paramView.findViewById(q.e.fav_sync_error_btn));
    paramb.Aon.setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(107447);
        com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
        localb.cH(paramAnonymousView);
        a.c("com/tencent/mm/plugin/fav/ui/listitem/FavBaseListItem$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
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
  
  public abstract void a(View paramView, arx paramarx);
  
  protected void a(b paramb)
  {
    Context localContext = paramb.pUL.getContext();
    Object localObject = ((n)h.ax(n.class)).bzA().bxv(paramb.AdF.field_fromUser);
    if ((localObject == null) || (!((az)localObject).field_username.equals(paramb.AdF.field_fromUser)))
    {
      Log.w("MicroMsg.FavBaseListItem", "render name, user is %s, but name is null", new Object[] { paramb.AdF.field_fromUser });
      paramb.pUL.setText("");
      az.a.okP.a(paramb.AdF.field_fromUser, "", null);
      return;
    }
    if (au.bwE(paramb.AdF.field_fromUser))
    {
      localObject = paramb.AdF.field_favProto.ZBt;
      if (z.bAM().equals(((asb)localObject).hQQ)) {
        localObject = com.tencent.mm.plugin.fav.a.b.atS(((asb)localObject).toUser);
      }
    }
    for (;;)
    {
      paramb.pUL.setText(p.b(localContext, (CharSequence)localObject, paramb.pUL.getTextSize()));
      return;
      localObject = ((com.tencent.mm.plugin.messenger.a.b)h.ax(com.tencent.mm.plugin.messenger.a.b.class)).getDisplayName(((asb)localObject).hQQ);
      continue;
      localObject = com.tencent.mm.plugin.fav.a.b.atS(((az)localObject).field_username);
    }
  }
  
  protected final void a(b paramb, g paramg)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    paramb.AdF = paramg;
    label64:
    label87:
    CheckBox localCheckBox;
    if (paramb.AdF.field_type == 18)
    {
      paramb.Aoi.setVisibility(0);
      if (this.Aof.Akm) {
        break label215;
      }
      paramb.timeTV.setText(m.h(paramb.timeTV.getContext(), paramb.AdF.field_updateTime));
      a(paramb);
      if (!paramb.AdF.dQp()) {
        break label235;
      }
      paramb.Aom.setVisibility(0);
      paramb.pJL.setTag(paramg);
      if ((!this.Aof.Ake) && (!this.Aof.Akm)) {
        break label300;
      }
      paramb.pJL.setVisibility(0);
      if (!paramg.Acq) {
        break label252;
      }
      localCheckBox = paramb.pJL;
      if (this.Aof.Akf.get(paramg.hIG) == null) {
        break label247;
      }
      label155:
      localCheckBox.setChecked(bool1);
    }
    for (;;)
    {
      paramb.Aon.setTag(paramg);
      if ((paramg.field_tagProto.ZBH == null) || (paramg.field_tagProto.ZBH.isEmpty())) {
        break label312;
      }
      paramb.Aol.setVisibility(0);
      return;
      paramb.Aoi.setVisibility(8);
      break;
      label215:
      paramb.timeTV.setText(com.tencent.mm.plugin.fav.a.b.mB(paramb.AdF.field_datatotalsize));
      break label64;
      label235:
      paramb.Aom.setVisibility(8);
      break label87;
      label247:
      bool1 = false;
      break label155;
      label252:
      localCheckBox = paramb.pJL;
      if (this.Aof.Akf.get(Util.notNullToString(Long.valueOf(paramg.field_localId))) != null) {}
      for (bool1 = bool2;; bool1 = false)
      {
        localCheckBox.setChecked(bool1);
        break;
      }
      label300:
      paramb.pJL.setVisibility(8);
    }
    label312:
    paramb.Aol.setVisibility(8);
  }
  
  public static final class a
  {
    public boolean Ake;
    public Map<String, g> Akf;
    public boolean Akm;
    public b.c Aoh;
    public String lMG;
    public long lastUpdateTime;
    public boolean vDm;
    
    public final String toString()
    {
      AppMethodBeat.i(107448);
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("lastUpdateTime:").append(this.lastUpdateTime).append('\n');
      ((StringBuilder)localObject).append("isSearching:").append(this.vDm).append('\n');
      ((StringBuilder)localObject).append("search str:").append(this.lMG).append('\n');
      localObject = ((StringBuilder)localObject).toString();
      AppMethodBeat.o(107448);
      return localObject;
    }
  }
  
  public static class b
  {
    public g AdF;
    public View Aoi;
    public WeImageView Aoj;
    public TextView Aok;
    public ImageView Aol;
    public LinearLayout Aom;
    public TextView Aon;
    public CheckBox pJL;
    public TextView pUL;
    public TextView timeTV;
  }
  
  public static abstract interface c
  {
    public abstract void mO(long paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.fav.ui.d.b
 * JD-Core Version:    0.7.0.1
 */