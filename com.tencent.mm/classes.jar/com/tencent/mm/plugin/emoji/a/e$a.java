package com.tencent.mm.plugin.emoji.a;

import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.f.e;

final class e$a
{
  TextView eXO;
  ImageView gSx;
  View iVb;
  ImageView iVc;
  
  public e$a(e parame, View paramView)
  {
    this.iVc = ((ImageView)paramView.findViewById(f.e.emoji_store_manager_list_item_updonw));
    this.gSx = ((ImageView)paramView.findViewById(f.e.emoji_store_manager_list_item_icon));
    this.eXO = ((TextView)paramView.findViewById(f.e.emoji_store_manager_list_item_title));
    this.iVb = paramView.findViewById(f.e.emoji_item_container);
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.height = e.a(parame);
      paramView.setLayoutParams(localLayoutParams);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.e.a
 * JD-Core Version:    0.7.0.1
 */