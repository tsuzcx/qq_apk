package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.a.d;

final class f$b
{
  String account;
  ImageView dpY;
  TextView eXu;
  int fdX;
  View fdZ;
  TextView feg;
  TextView feh;
  TextView fei;
  ProgressBar fej;
  int status;
  
  public f$b(f paramf, View paramView)
  {
    this.feg = ((TextView)paramView.findViewById(a.d.friend_item_catalog));
    this.dpY = ((ImageView)paramView.findViewById(a.d.friend_item_avatar_iv));
    this.feh = ((TextView)paramView.findViewById(a.d.friend_item_nickname));
    this.fei = ((TextView)paramView.findViewById(a.d.friend_item_wx_nickname));
    this.fdZ = paramView.findViewById(a.d.friend_item_action_view);
    this.eXu = ((TextView)paramView.findViewById(a.d.friend_item_status_tv));
    this.fej = ((ProgressBar)paramView.findViewById(a.d.friend_item_status_pb));
    this.fdZ.setOnClickListener(new f.b.1(this, paramf));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.f.b
 * JD-Core Version:    0.7.0.1
 */