package com.tencent.mm.plugin.account.bind.ui;

import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.plugin.account.bind.a.e;

final class a$b
{
  ImageView dpY;
  TextView eXu;
  String fds;
  TextView fdt;
  TextView fdu;
  View fdv;
  ProgressBar fdw;
  int position;
  
  public a$b(a parama, View paramView)
  {
    this.dpY = ((ImageView)paramView.findViewById(a.e.gcontact_avatar_iv));
    this.fdt = ((TextView)paramView.findViewById(a.e.gcontact_name_tv));
    this.fdv = paramView.findViewById(a.e.gcontact_operation_view);
    this.eXu = ((TextView)paramView.findViewById(a.e.gcontact_status_tv));
    this.fdw = ((ProgressBar)paramView.findViewById(a.e.gcontact_invita_pb));
    this.fdu = ((TextView)paramView.findViewById(a.e.gcontact_email_tv));
    this.fdv.setOnClickListener(new a.b.1(this, parama));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.account.bind.ui.a.b
 * JD-Core Version:    0.7.0.1
 */