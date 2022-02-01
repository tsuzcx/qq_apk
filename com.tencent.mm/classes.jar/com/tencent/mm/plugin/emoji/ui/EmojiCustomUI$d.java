package com.tencent.mm.plugin.emoji.ui;

import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

final class EmojiCustomUI$d
{
  ImageView image;
  View jGG;
  CheckBox oCl;
  
  public EmojiCustomUI$d(View paramView)
  {
    AppMethodBeat.i(108894);
    this.jGG = paramView.findViewById(2131301137);
    this.image = ((ImageView)paramView.findViewById(2131300914));
    this.oCl = ((CheckBox)paramView.findViewById(2131298264));
    AppMethodBeat.o(108894);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.EmojiCustomUI.d
 * JD-Core Version:    0.7.0.1
 */