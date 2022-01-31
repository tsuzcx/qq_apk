package com.tencent.mm.plugin.account.friend.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.friend.a.d;

final class e$b
{
  ImageView dpY;
  TextView eXu;
  int fdX;
  TextView fdY;
  View fdZ;
  ProgressBar fea;
  String fig;
  int status;
  
  public e$b(e parame, View paramView)
  {
    this.dpY = ((ImageView)paramView.findViewById(a.d.contactitem_avatar_iv));
    this.fdY = ((TextView)paramView.findViewById(a.d.qq_friend_name));
    this.fdZ = paramView.findViewById(a.d.qq_friend_action_view);
    this.eXu = ((TextView)paramView.findViewById(a.d.qq_friend_status_tv));
    this.fea = ((ProgressBar)paramView.findViewById(a.d.qq_friend_status_pb));
    this.fdZ.setOnClickListener(new e.b.1(this, parame));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.friend.ui.e.b
 * JD-Core Version:    0.7.0.1
 */