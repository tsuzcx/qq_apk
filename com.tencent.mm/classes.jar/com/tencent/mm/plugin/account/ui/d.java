package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.cb.a;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.storage.bd;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.r.a;

@Deprecated
final class d
  extends r<com.tencent.mm.plugin.account.friend.a.g>
{
  private int[] fdQ;
  private String fdR;
  d.a flJ;
  
  public d(Context paramContext, r.a parama)
  {
    super(paramContext, new com.tencent.mm.plugin.account.friend.a.g());
    this.uMi = parama;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    Object localObject = (com.tencent.mm.plugin.account.friend.a.g)getItem(paramInt);
    if (paramView == null)
    {
      paramViewGroup = new d.b();
      paramView = View.inflate(this.context, q.g.facebook_friend_item, null);
      paramViewGroup.dpY = ((ImageView)paramView.findViewById(q.f.contactitem_avatar_iv));
      paramViewGroup.fdY = ((TextView)paramView.findViewById(q.f.qq_friend_name));
      paramViewGroup.ffL = ((TextView)paramView.findViewById(q.f.qq_friend_add_state));
      paramViewGroup.flK = ((TextView)paramView.findViewById(q.f.qq_friend_add_tv));
      paramViewGroup.flL = ((TextView)paramView.findViewById(q.f.qq_friend_invite_tv));
      paramViewGroup.flM = ((ImageView)paramView.findViewById(q.f.qq_friend_submenu));
      paramView.setTag(paramViewGroup);
      paramViewGroup.fdY.setText(com.tencent.mm.pluginsdk.ui.d.j.a(this.context, ((com.tencent.mm.plugin.account.friend.a.g)localObject).WI(), paramViewGroup.fdY.getTextSize()));
      paramViewGroup.flL.setVisibility(8);
      paramViewGroup.flM.setVisibility(0);
      switch (this.fdQ[paramInt])
      {
      }
    }
    for (;;)
    {
      localObject = com.tencent.mm.ag.b.jU(((com.tencent.mm.plugin.account.friend.a.g)localObject).cCs);
      if (localObject != null) {
        break label454;
      }
      paramViewGroup.dpY.setImageDrawable(a.g(this.context, q.i.default_avatar));
      return paramView;
      paramViewGroup = (d.b)paramView.getTag();
      break;
      paramViewGroup.flK.setVisibility(8);
      paramViewGroup.ffL.setVisibility(0);
      paramViewGroup.ffL.setText(q.j.friend_waiting);
      paramViewGroup.ffL.setTextColor(this.context.getResources().getColor(q.c.add_state_color_waiting));
      continue;
      if ((((com.tencent.mm.plugin.account.friend.a.g)localObject).status != 102) && (!((com.tencent.mm.plugin.messenger.foundation.a.j)com.tencent.mm.kernel.g.r(com.tencent.mm.plugin.messenger.foundation.a.j.class)).Fw().abg(((com.tencent.mm.plugin.account.friend.a.g)localObject).getUsername())))
      {
        paramViewGroup.ffL.setVisibility(8);
        paramViewGroup.flK.setVisibility(0);
      }
      else if (((com.tencent.mm.plugin.account.friend.a.g)localObject).status == 102)
      {
        paramViewGroup.ffL.setVisibility(8);
        paramViewGroup.flK.setVisibility(8);
        paramViewGroup.flM.setVisibility(8);
      }
      else
      {
        paramViewGroup.ffL.setVisibility(0);
        paramViewGroup.ffL.setText(q.j.friend_added);
        paramViewGroup.ffL.setTextColor(this.context.getResources().getColor(q.c.add_state_color_added));
        paramViewGroup.flK.setVisibility(8);
      }
    }
    label454:
    paramViewGroup.dpY.setImageBitmap((Bitmap)localObject);
    return paramView;
  }
  
  public final void pA(String paramString)
  {
    this.fdR = bk.pl(paramString.trim());
    bcS();
    yc();
  }
  
  public final void yc()
  {
    com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.b.getFacebookFrdStg();
    String str = this.fdR;
    StringBuilder localStringBuilder = new StringBuilder();
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" where ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
    }
    setCursor(localh.dXo.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
    this.fdQ = new int[getCount()];
    if ((this.flJ != null) && (this.fdR != null)) {
      this.flJ.jU(getCursor().getCount());
    }
    super.notifyDataSetChanged();
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.d
 * JD-Core Version:    0.7.0.1
 */