package com.facebook.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.tencent.matrix.trace.core.AppMethodBeat;

class ToolTipPopup$PopupContentView
  extends FrameLayout
{
  private View bodyFrame;
  private ImageView bottomArrow;
  private ImageView topArrow;
  private ImageView xOut;
  
  public ToolTipPopup$PopupContentView(ToolTipPopup paramToolTipPopup, Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(92714);
    init();
    AppMethodBeat.o(92714);
  }
  
  private void init()
  {
    AppMethodBeat.i(92715);
    LayoutInflater.from(getContext()).inflate(2130969189, this);
    this.topArrow = ((ImageView)findViewById(2131822969));
    this.bottomArrow = ((ImageView)findViewById(2131822972));
    this.bodyFrame = findViewById(2131822968);
    this.xOut = ((ImageView)findViewById(2131822970));
    AppMethodBeat.o(92715);
  }
  
  public void showBottomArrow()
  {
    AppMethodBeat.i(92717);
    this.topArrow.setVisibility(4);
    this.bottomArrow.setVisibility(0);
    AppMethodBeat.o(92717);
  }
  
  public void showTopArrow()
  {
    AppMethodBeat.i(92716);
    this.topArrow.setVisibility(0);
    this.bottomArrow.setVisibility(4);
    AppMethodBeat.o(92716);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.facebook.login.widget.ToolTipPopup.PopupContentView
 * JD-Core Version:    0.7.0.1
 */