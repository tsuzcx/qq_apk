package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.plugin.emoji.f.e;

final class EmojiCustomUI$d
{
  View jdj;
  ImageView jdk;
  CheckBox jdl;
  
  public EmojiCustomUI$d(View paramView)
  {
    this.jdj = paramView.findViewById(f.e.item);
    this.jdk = ((ImageView)paramView.findViewById(f.e.image));
    this.jdl = ((CheckBox)paramView.findViewById(f.e.checked));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d
 * JD-Core Version:    0.7.0.1
 */