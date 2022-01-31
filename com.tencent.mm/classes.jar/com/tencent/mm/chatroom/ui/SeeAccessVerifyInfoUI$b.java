package com.tencent.mm.chatroom.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.as.a.a;
import com.tencent.mm.as.a.a.c;
import com.tencent.mm.as.a.a.c.a;
import com.tencent.mm.as.o;
import com.tencent.mm.pluginsdk.ui.d.j;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.util.ArrayList;
import java.util.List;

public final class SeeAccessVerifyInfoUI$b
  extends BaseAdapter
{
  List<SeeAccessVerifyInfoUI.a> drc = new ArrayList();
  private c drd = null;
  Context mContext;
  
  public SeeAccessVerifyInfoUI$b(SeeAccessVerifyInfoUI paramSeeAccessVerifyInfoUI, Context paramContext)
  {
    this.mContext = paramContext;
    xM();
    paramSeeAccessVerifyInfoUI = new c.a();
    paramSeeAccessVerifyInfoUI.erf = true;
    paramSeeAccessVerifyInfoUI.erC = true;
    paramSeeAccessVerifyInfoUI.eru = a.h.default_avatar;
    this.drd = paramSeeAccessVerifyInfoUI.OV();
  }
  
  private void xM()
  {
    String[] arrayOfString1 = null;
    String[] arrayOfString3;
    int i;
    label93:
    List localList;
    SeeAccessVerifyInfoUI localSeeAccessVerifyInfoUI;
    String str3;
    String str1;
    if (!bk.bl(SeeAccessVerifyInfoUI.l(this.dqZ)))
    {
      String[] arrayOfString2 = SeeAccessVerifyInfoUI.l(this.dqZ).split(",");
      if (bk.bl(SeeAccessVerifyInfoUI.m(this.dqZ))) {
        break label200;
      }
      arrayOfString3 = SeeAccessVerifyInfoUI.m(this.dqZ).split(",");
      if (bk.bl(SeeAccessVerifyInfoUI.n(this.dqZ))) {
        break label208;
      }
      arrayOfString1 = SeeAccessVerifyInfoUI.n(this.dqZ).split(",");
      this.drc.clear();
      i = 0;
      if (i >= arrayOfString2.length) {
        break label199;
      }
      localList = this.drc;
      localSeeAccessVerifyInfoUI = this.dqZ;
      str3 = arrayOfString2[i];
      if ((arrayOfString3.length > i) && (!bk.bl(arrayOfString3[i]))) {
        break label218;
      }
      str1 = arrayOfString2[i];
      label140:
      if ((arrayOfString1 != null) && (arrayOfString1.length > i) && (!bk.bl(arrayOfString1[i]))) {
        break label226;
      }
    }
    label199:
    label200:
    label208:
    label218:
    label226:
    for (String str2 = "";; str2 = arrayOfString1[i])
    {
      localList.add(new SeeAccessVerifyInfoUI.a(localSeeAccessVerifyInfoUI, str3, str1, str2));
      i += 1;
      break label93;
      y.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesUsernames null");
      return;
      y.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesNicknames null");
      return;
      y.w("MicroMsg.SeeAccessVerifyInfoUI", "mInviteesHeadimgurls null");
      break;
      str1 = arrayOfString3[i];
      break label140;
    }
  }
  
  public final int getCount()
  {
    return this.drc.size();
  }
  
  public final Object getItem(int paramInt)
  {
    return this.drc.get(paramInt);
  }
  
  public final long getItemId(int paramInt)
  {
    return paramInt;
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if (paramView == null)
    {
      paramView = View.inflate(this.mContext, a.f.roominfo_contact, null);
      paramViewGroup = this.dqZ.bK(paramView);
    }
    for (;;)
    {
      paramViewGroup.doU.setVisibility(0);
      paramViewGroup.drf.setVisibility(0);
      o.ON().a(((SeeAccessVerifyInfoUI.a)this.drc.get(paramInt)).drb, paramViewGroup.doU, this.drd);
      paramViewGroup.drf.setText(j.a(this.mContext, bk.pm(((SeeAccessVerifyInfoUI.a)this.drc.get(paramInt)).nickname), paramViewGroup.drf.getTextSize()));
      paramView.setOnClickListener(new SeeAccessVerifyInfoUI.b.1(this, paramInt));
      return paramView;
      paramViewGroup = (SeeAccessVerifyInfoUI.c)paramView.getTag();
      if (paramViewGroup == null) {
        paramViewGroup = this.dqZ.bK(paramView);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.chatroom.ui.SeeAccessVerifyInfoUI.b
 * JD-Core Version:    0.7.0.1
 */