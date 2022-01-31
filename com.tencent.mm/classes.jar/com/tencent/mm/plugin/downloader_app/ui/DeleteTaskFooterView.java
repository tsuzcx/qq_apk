package com.tencent.mm.plugin.downloader_app.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.downloader_app.b.d;
import com.tencent.mm.plugin.downloader_app.b.d.c;

public class DeleteTaskFooterView
  extends LinearLayout
{
  private boolean Md;
  private LinearLayout lbS;
  ImageView lbT;
  LinearLayout lbU;
  TextView lbV;
  ImageView lbW;
  boolean lbX;
  private d.c lbY;
  
  public DeleteTaskFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(136218);
    this.Md = true;
    this.lbX = false;
    this.lbY = new DeleteTaskFooterView.1(this);
    AppMethodBeat.o(136218);
  }
  
  public void onAttachedToWindow()
  {
    AppMethodBeat.i(136220);
    super.onAttachedToWindow();
    d.a(this.lbY);
    AppMethodBeat.o(136220);
  }
  
  public void onDetachedFromWindow()
  {
    AppMethodBeat.i(136221);
    super.onDetachedFromWindow();
    d.b(this.lbY);
    AppMethodBeat.o(136221);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(136219);
    super.onFinishInflate();
    View localView = LayoutInflater.from(getContext()).inflate(2130969303, this, true);
    this.lbS = ((LinearLayout)localView.findViewById(2131823366));
    this.lbT = ((ImageView)localView.findViewById(2131823367));
    this.lbS.setOnClickListener(new DeleteTaskFooterView.2(this));
    this.lbU = ((LinearLayout)localView.findViewById(2131823368));
    this.lbU.setOnClickListener(new DeleteTaskFooterView.3(this));
    this.lbU.setClickable(false);
    this.lbV = ((TextView)localView.findViewById(2131823370));
    this.lbW = ((ImageView)localView.findViewById(2131823369));
    AppMethodBeat.o(136219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.downloader_app.ui.DeleteTaskFooterView
 * JD-Core Version:    0.7.0.1
 */