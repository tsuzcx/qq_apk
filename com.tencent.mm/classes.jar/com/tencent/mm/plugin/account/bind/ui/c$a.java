package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.bind.a.e;

final class c$a
{
  String bIW;
  TextView eXu;
  int fdX;
  TextView fdY;
  View fdZ;
  ProgressBar fea;
  int status;
  
  public c$a(c paramc, View paramView)
  {
    this.fdY = ((TextView)paramView.findViewById(a.e.mobile_friend_name));
    this.fdZ = paramView.findViewById(a.e.mobile_friend_action_view);
    this.eXu = ((TextView)paramView.findViewById(a.e.mobile_friend_status_tv));
    this.fea = ((ProgressBar)paramView.findViewById(a.e.mobile_friend_status_pb));
    this.fdZ.setOnClickListener(new c.a.1(this, paramc));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.c.a
 * JD-Core Version:    0.7.0.1
 */