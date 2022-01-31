package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.b;
import com.tencent.mm.plugin.account.friend.a.g;
import com.tencent.mm.plugin.account.friend.a.q;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.ui.p;
import com.tencent.mm.ui.p.a;

public final class InviteFacebookFriendsUI$a
  extends p<g>
{
  private int[] gvA;
  String gvB;
  private boolean[] gzj;
  
  public InviteFacebookFriendsUI$a(Context paramContext, p.a parama)
  {
    super(paramContext, new g());
    AppMethodBeat.i(124888);
    super.a(parama);
    AppMethodBeat.o(124888);
  }
  
  public final void Ku()
  {
    AppMethodBeat.i(124892);
    com.tencent.mm.plugin.account.friend.a.h localh = com.tencent.mm.plugin.account.a.getFacebookFrdStg();
    String str = this.gvB;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(" where facebookfriend.status = 102 ");
    if ((str != null) && (str.length() > 0))
    {
      localStringBuilder.append(" and ( ");
      localStringBuilder.append("facebookfriend.fbname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.nickname like '%" + str + "%' or ");
      localStringBuilder.append("facebookfriend.username like '%" + str + "%' ) ");
    }
    setCursor(localh.fnw.a("select facebookfriend.fbid,facebookfriend.fbname,facebookfriend.fbimgkey,facebookfriend.status,facebookfriend.username,facebookfriend.nickname,facebookfriend.nicknamepyinitial,facebookfriend.nicknamequanpin,facebookfriend.sex,facebookfriend.personalcard,facebookfriend.province,facebookfriend.city,facebookfriend.signature,facebookfriend.alias,facebookfriend.type,facebookfriend.email from facebookfriend  " + localStringBuilder.toString() + " order by  case when status = 100 then 0  when status = 102 then 3  when status = 101 then 1 else 2 end  , nicknamepyinitial", null, 0));
    this.gvA = new int[getCount()];
    this.gzj = new boolean[getCount()];
    super.notifyDataSetChanged();
    AppMethodBeat.o(124892);
  }
  
  public final void Kv()
  {
    AppMethodBeat.i(124893);
    Ku();
    AppMethodBeat.o(124893);
  }
  
  public final long[] arp()
  {
    AppMethodBeat.i(124890);
    Object localObject = this.gzj;
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
      if (this.gzj[j] == 0) {
        break label108;
      }
      localObject[i] = ((g)getItem(j)).dqE;
      i += 1;
    }
    label108:
    for (;;)
    {
      j += 1;
      break;
      AppMethodBeat.o(124890);
      return localObject;
    }
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(124889);
    g localg = (g)getItem(paramInt);
    Bitmap localBitmap;
    if (paramView == null)
    {
      paramViewGroup = new InviteFacebookFriendsUI.a.a();
      paramView = View.inflate(this.context, 2130969517, null);
      paramViewGroup.ehv = ((ImageView)paramView.findViewById(2131823956));
      paramViewGroup.gvI = ((TextView)paramView.findViewById(2131823957));
      paramViewGroup.gzm = ((TextView)paramView.findViewById(2131823962));
      paramViewGroup.gzn = ((CheckBox)paramView.findViewById(2131823963));
      paramView.setTag(paramViewGroup);
      paramViewGroup.gvI.setText(j.b(this.context, localg.aqk(), paramViewGroup.gvI.getTextSize()));
      localBitmap = b.qN(localg.dqE);
      if (localBitmap != null) {
        break label221;
      }
      paramViewGroup.ehv.setImageDrawable(com.tencent.mm.cb.a.k(this.context, 2131231207));
      label165:
      paramViewGroup.gzn.setChecked(this.gzj[paramInt]);
      if (!com.tencent.mm.plugin.account.a.getInviteFriendOpenStg().xm(Long.toString(localg.dqE))) {
        break label233;
      }
      paramViewGroup.gzm.setVisibility(0);
    }
    for (;;)
    {
      AppMethodBeat.o(124889);
      return paramView;
      paramViewGroup = (InviteFacebookFriendsUI.a.a)paramView.getTag();
      break;
      label221:
      paramViewGroup.ehv.setImageBitmap(localBitmap);
      break label165;
      label233:
      paramViewGroup.gzm.setVisibility(8);
    }
  }
  
  public final void mW(int paramInt)
  {
    AppMethodBeat.i(124891);
    if ((paramInt < 0) || (paramInt >= this.gzj.length))
    {
      AppMethodBeat.o(124891);
      return;
    }
    boolean[] arrayOfBoolean = this.gzj;
    if (arrayOfBoolean[paramInt] == 0) {}
    for (int i = 1;; i = 0)
    {
      arrayOfBoolean[paramInt] = i;
      super.notifyDataSetChanged();
      AppMethodBeat.o(124891);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.InviteFacebookFriendsUI.a
 * JD-Core Version:    0.7.0.1
 */