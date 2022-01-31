package com.tencent.mm.plugin.exdevice.ui;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class a$2
  implements View.OnClickListener
{
  a$2(a parama, String paramString) {}
  
  public final void onClick(View paramView)
  {
    paramView = a.b(this.jDT);
    Intent localIntent = new Intent(paramView, ExdeviceProfileUI.class);
    localIntent.putExtra("username", this.egy);
    paramView.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.exdevice.ui.a.2
 * JD-Core Version:    0.7.0.1
 */