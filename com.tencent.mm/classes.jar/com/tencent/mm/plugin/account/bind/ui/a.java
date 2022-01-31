package com.tencent.mm.plugin.account.bind.ui;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.ag.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.account.bind.a.d;
import com.tencent.mm.plugin.account.bind.a.f;
import com.tencent.mm.plugin.account.bind.a.h;
import com.tencent.mm.plugin.account.bind.a.i;
import com.tencent.mm.plugin.account.friend.a.n;
import com.tencent.mm.plugin.account.friend.a.o;
import com.tencent.mm.sdk.e.e;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.ui.r;

public final class a
  extends r<n>
{
  private String fay;
  a.a fdr;
  private Context mContext;
  private String mFilter;
  private LayoutInflater mLayoutInflater;
  
  public a(Context paramContext, String paramString)
  {
    super(paramContext, new n());
    this.fay = paramString;
    this.mContext = paramContext;
    this.mLayoutInflater = LayoutInflater.from(this.mContext);
  }
  
  public final View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    if ((paramView == null) || (paramView.getTag() == null))
    {
      paramView = this.mLayoutInflater.inflate(a.f.gcontact_friend_list_item, null);
      paramViewGroup = new a.b(this, paramView);
      paramView.setTag(paramViewGroup);
    }
    n localn;
    for (;;)
    {
      localn = (n)getItem(paramInt);
      if (localn != null) {
        break;
      }
      return paramView;
      paramViewGroup = (a.b)paramView.getTag();
    }
    paramViewGroup.position = paramInt;
    paramViewGroup.fds = localn.field_googlegmail;
    switch (localn.field_status)
    {
    default: 
      if (TextUtils.isEmpty(localn.field_googlename))
      {
        paramViewGroup.fdt.setText(bk.aab(localn.field_googlegmail));
        switch (localn.field_status)
        {
        default: 
          switch (localn.field_googlecgistatus)
          {
          default: 
            paramViewGroup.fdu.setText(localn.field_googlegmail);
            return paramView;
          }
          break;
        }
      }
      break;
    case 0: 
    case 2: 
      label138:
      label168:
      label200:
      if (localn.field_small_url == null) {}
      break;
    }
    for (Bitmap localBitmap = b.a(localn.field_username, false, -1);; localBitmap = null)
    {
      if (localBitmap == null)
      {
        paramViewGroup.dpY.setImageDrawable(com.tencent.mm.cb.a.g(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.dpY.setImageBitmap(localBitmap);
      break;
      localBitmap = b.jR(localn.field_googleid);
      if (localBitmap == null)
      {
        paramViewGroup.dpY.setImageDrawable(com.tencent.mm.cb.a.g(this.mContext, a.h.default_avatar));
        break;
      }
      paramViewGroup.dpY.setImageBitmap(localBitmap);
      break;
      paramViewGroup.fdt.setText(localn.field_googlename);
      break label138;
      paramViewGroup.fdv.setClickable(true);
      paramViewGroup.fdv.setBackgroundResource(a.d.btn_solid_green);
      paramViewGroup.eXu.setText(a.i.gcontact_add);
      paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
      break label168;
      paramViewGroup.fdv.setClickable(true);
      paramViewGroup.fdv.setBackgroundResource(a.d.btn_solid_grey);
      paramViewGroup.eXu.setText(a.i.gcontact_invite);
      paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label168;
      paramViewGroup.fdv.setClickable(false);
      paramViewGroup.fdv.setBackgroundDrawable(null);
      paramViewGroup.eXu.setText(a.i.gcontact_added);
      paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      break label168;
      paramViewGroup.eXu.setVisibility(4);
      paramViewGroup.fdw.setVisibility(0);
      break label200;
      paramViewGroup.fdv.setClickable(false);
      paramViewGroup.fdv.setBackgroundDrawable(null);
      paramViewGroup.eXu.setVisibility(0);
      paramViewGroup.fdw.setVisibility(8);
      paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
      switch (localn.field_status)
      {
      default: 
        break;
      case 0: 
        paramViewGroup.eXu.setText(a.i.gcontact_add_done);
        break;
      case 1: 
        paramViewGroup.eXu.setText(a.i.gcontact_invite_done);
        break;
        paramViewGroup.eXu.setVisibility(0);
        paramViewGroup.fdw.setVisibility(8);
        switch (localn.field_status)
        {
        default: 
          break;
        case 0: 
          paramViewGroup.eXu.setText(a.i.gcontact_add);
          paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.white));
          break;
        case 1: 
          paramViewGroup.eXu.setText(a.i.gcontact_invite);
          paramViewGroup.eXu.setTextColor(this.mContext.getResources().getColor(com.tencent.mm.plugin.account.bind.a.b.lightgrey));
          break;
        }
        break;
      }
    }
  }
  
  public final void pA(String paramString)
  {
    this.mFilter = bk.pl(paramString);
    bcS();
    yc();
  }
  
  public final void yc()
  {
    o localo = (o)((com.tencent.mm.plugin.account.a.a.a)g.t(com.tencent.mm.plugin.account.a.a.a.class)).getGoogleFriendStorage();
    String str1 = this.mFilter;
    String str2 = this.fay;
    StringBuilder localStringBuilder = new StringBuilder();
    if (!TextUtils.isEmpty(str1))
    {
      localStringBuilder.append(" WHERE ( ");
      localStringBuilder.append("GoogleFriend.googlegmail!='" + str2 + "' AND ");
      localStringBuilder.append("GoogleFriend.googlename LIKE '%" + str1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.googlenamepy LIKE '%" + str1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.googlegmail LIKE '%" + str1 + "%' OR ");
      localStringBuilder.append("GoogleFriend.nickname LIKE '%" + str1 + "%' ) ");
    }
    for (;;)
    {
      localStringBuilder.append(" GROUP BY googleid,contecttype");
      localStringBuilder.append(" ORDER BY status , googlenamepy ASC , usernamepy ASC");
      setCursor(localo.dXw.rawQuery("SELECT GoogleFriend.googleid,GoogleFriend.googlename,GoogleFriend.googlephotourl,GoogleFriend.googlegmail,GoogleFriend.username,GoogleFriend.nickname,GoogleFriend.nicknameqp,GoogleFriend.usernamepy,GoogleFriend.small_url,GoogleFriend.big_url,GoogleFriend.ret,GoogleFriend.status,GoogleFriend.googleitemid,GoogleFriend.googlecgistatus,GoogleFriend.contecttype,GoogleFriend.googlenamepy FROM GoogleFriend  " + localStringBuilder.toString(), null));
      super.notifyDataSetChanged();
      return;
      localStringBuilder.append(" WHERE ( GoogleFriend.googlegmail!='" + str2 + "' )");
    }
  }
  
  protected final void yd()
  {
    yc();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a
 * JD-Core Version:    0.7.0.1
 */