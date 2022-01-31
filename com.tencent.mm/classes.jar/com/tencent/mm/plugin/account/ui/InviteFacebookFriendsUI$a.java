package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

public final class InviteFacebookFriendsUI$a
  extends r<g>
{
  private int[] fdQ;
  String fdR;
  private boolean[] fhC;
  
  public InviteFacebookFriendsUI$a(Context paramContext, r.a parama)
  {
    super(paramContext, new g());
    this.uMi = parama;
  }
  
  public final long[] XH()
  {
    Object localObject = this.fhC;
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
      if (this.fhC[j] == 0) {
        break label98;
      }
      localObject[i] = ((g)getItem(j)).cCs;
      i += 1;
    }
    label98:
    for (;;)
    {
      j += 1;
      break;
      return localObject;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    g localg = (g)getItem(paramInt);
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramViewGroup = new InviteFacebookFriendsUI.a.a();
      paramView = View.inflate(this.context, q.g.facebook_invite_friend_item, null);
      paramViewGroup.dpY = ((ImageView)paramView.findViewById(q.f.contactitem_avatar_iv));
      paramViewGroup.fdY = ((TextView)paramView.findViewById(q.f.qq_friend_name));
      paramViewGroup.fhF = ((TextView)paramView.findViewById(q.f.invite_friends_open_already_state));
      paramViewGroup.fhG = ((CheckBox)paramView.findViewById(q.f.inviteqqfriends_send_cb));
      paramView.setTag(paramViewGroup);
      paramViewGroup.fdY.setText(j.a(this.context, localg.WI(), paramViewGroup.fdY.getTextSize()));
      localBitmap = com.tencent.mm.ag.b.jU(localg.cCs);
      if (localBitmap != null) {
        break label217;
      }
      paramViewGroup.dpY.setImageDrawable(a.g(this.context, q.i.default_avatar));
    }
    for (;;)
    {
      paramViewGroup.fhG.setChecked(this.fhC[paramInt]);
      if (!com.tencent.mm.plugin.account.b.getInviteFriendOpenStg().pQ(Long.toString(localg.cCs))) {
        break label229;
      }
      paramViewGroup.fhF.setVisibility(0);
      return paramView;
      paramViewGroup = (InviteFacebookFriendsUI.a.a)paramView.getTag();
      break;
      label217:
      paramViewGroup.dpY.setImageBitmap(localBitmap);
    }
    label229:
    paramViewGroup.fhF.setVisibility(8);
    return paramView;
  }
  
  public final void kb(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.fhC.length)) {
      return;
    }
    boolean[] arrayOfBoolean = this.fhC;
    if (this.fhC[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      return;
    }
  }
  
  public final void yc()
  {
    com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
    String str = this.fdR;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" where facebookfriend.status = 102 ");
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
    }
    setCursor(localh.dXo.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
    this.fdQ = new int[getCount()];
    this.fhC = new boolean[getCount()];
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.a
 * JD-Core Version:    0.7.0.1
 */