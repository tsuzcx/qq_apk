package com.facebook.login.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.facebook.login.R.id;
import com.facebook.login.R.layout;
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
    AppMethodBeat.i(40481);
    init();
    AppMethodBeat.o(40481);
  }
  
  private void init()
  {
    AppMethodBeat.i(40482);
    LayoutInflater.from(getContext()).inflate(R.layout.com_facebook_tooltip_bubble, this);
    this.topArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_top_pointer));
    this.bottomArrow = ((ImageView)findViewById(R.id.com_facebook_tooltip_bubble_view_bottom_pointer));
    this.bodyFrame = findViewById(R.id.com_facebook_body_frame);
    this.xOut = ((ImageView)findViewById(R.id.com_facebook_button_xout));
    AppMethodBeat.o(40482);
  }
  
  public void showBottomArrow()
  {
    AppMethodBeat.i(40484);
    this.topArrow.setVisibility(4);
    this.bottomArrow.setVisibility(0);
    AppMethodBeat.o(40484);
  }
  
  public void showTopArrow()
  {
    AppMethodBeat.i(40483);
    this.topArrow.setVisibility(0);
    this.bottomArrow.setVisibility(4);
    AppMethodBeat.o(40483);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.facebook.login.widget.ToolTipPopup.PopupContentView
 * JD-Core Version:    0.7.0.1
 */