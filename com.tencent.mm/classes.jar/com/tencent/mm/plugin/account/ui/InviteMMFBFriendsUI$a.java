package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.cd.a;
import com.tencent.mm.plugin.account.b;
import com.tencent.mm.plugin.account.friend.model.e;
import com.tencent.mm.plugin.account.friend.model.n;
import com.tencent.mm.pluginsdk.ui.span.p;
import com.tencent.mm.storagebase.h;
import com.tencent.mm.ui.x;
import com.tencent.mm.ui.x.a;

public final class InviteMMFBFriendsUI$a
  extends x<com.tencent.mm.plugin.account.friend.model.d>
{
  private int[] duY;
  String pQS;
  private boolean[] pUK;
  
  public InviteMMFBFriendsUI$a(Context paramContext, x.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.model.d());
    AppMethodBeat.i(305126);
    super.a(parama);
    AppMethodBeat.o(305126);
  }
  
  public final void aNy()
  {
    AppMethodBeat.i(305141);
    e locale = b.getFacebookFrdStg();
    String str = this.pQS;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" where facebookfriend.status = 102 ");
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
    }
    w(locale.omV.rawQuery("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null));
    this.duY = new int[getCount()];
    this.pUK = new boolean[getCount()];
    super.notifyDataSetChanged();
    AppMethodBeat.o(305141);
  }
  
  public final void aNz()
  {
    AppMethodBeat.i(305143);
    aNy();
    AppMethodBeat.o(305143);
  }
  
  public final long[] bYa()
  {
    AppMethodBeat.i(305135);
    Object localObject = this.pUK;
    int m = localObject.length;
    int i = 0;
    int k;
    for (int j = 0; i < m; j = k)
    {
      k = j;
      if (localObject[i] != 0) {
        k = j + 1;
      }
      i += 1;
    }
    localObject = new long[j];
    i = 0;
    j = 0;
    if (j < getCount())
    {
      if (this.pUK[j] == 0) {
        break label108;
      }
      localObject[i] = ((com.tencent.mm.plugin.account.friend.model.d)getItem(j)).kaa;
      i += 1;
    }
    label108:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(305135);
      return localObject;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(305130);
    com.tencent.mm.plugin.account.friend.model.d locald = (com.tencent.mm.plugin.account.friend.model.d)getItem(paramInt);
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramViewGroup = new a();
      paramView = View.inflate(this.context, r.g.facebook_invite_friend_item, null);
      paramViewGroup.lKK = ((ImageView)paramView.findViewById(r.f.contactitem_avatar_iv));
      paramViewGroup.pQZ = ((TextView)paramView.findViewById(r.f.qq_friend_name));
      paramViewGroup.pUN = ((TextView)paramView.findViewById(r.f.invite_friends_open_already_state));
      paramViewGroup.pUO = ((CheckBox)paramView.findViewById(r.f.inviteqqfriends_send_cb));
      paramView.setTag(paramViewGroup);
      paramViewGroup.pQZ.setText(p.b(this.context, locald.bWR(), paramViewGroup.pQZ.getTextSize()));
      localBitmap = com.tencent.mm.modelavatar.d.Lv(locald.kaa);
      if (localBitmap != null) {
        break label227;
      }
      paramViewGroup.lKK.setImageDrawable(a.m(this.context, r.i.default_avatar));
      label171:
      paramViewGroup.pUO.setChecked(this.pUK[paramInt]);
      if (!b.getInviteFriendOpenStg().Te(Long.toString(locald.kaa))) {
        break label239;
      }
      paramViewGroup.pUN.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(305130);
      return paramView;
      paramViewGroup = (a)paramView.getTag();
      break;
      label227:
      paramViewGroup.lKK.setImageBitmap(localBitmap);
      break label171;
      label239:
      paramViewGroup.pUN.setVisibility(8);
    }
  }
  
  public final void yv(int paramInt)
  {
    AppMethodBeat.i(305138);
    if ((paramInt < 0) || (paramInt >= this.pUK.length))
    {
      AppMethodBeat.o(305138);
      return;
    }
    boolean[] arrayOfBoolean = this.pUK;
    if (arrayOfBoolean[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      AppMethodBeat.o(305138);
      return;
    }
  }
  
  public static final class a
  {
    ImageView lKK;
    TextView pQZ;
    TextView pUN;
    CheckBox pUO;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteMMFBFriendsUI.a
 * JD-Core Version:    0.7.0.1
 */