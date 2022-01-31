package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiCustomUI$d
{
  View iDS;
  ImageView image;
  CheckBox llV;
  
  public EmojiCustomUI$d(View paramView)
  {
    AppMethodBeat.i(53334);
    this.iDS = paramView.findViewById(2131821556);
    this.image = ((ImageView)paramView.findViewById(2131820629));
    this.llV = ((CheckBox)paramView.findViewById(2131823565));
    AppMethodBeat.o(53334);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d
 * JD-Core Version:    0.7.0.1
 */