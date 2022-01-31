package com.tencent.mm.plugin.location.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.modelgeo.b.a;

public class MyLocationButton
  extends FrameLayout
{
  private Context context;
  public b.a dZA;
  private ImageButton ocg;
  private LinearLayout och;
  private com.tencent.mm.plugin.k.d oci;
  private boolean ocj;
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113450);
    this.ocj = true;
    this.dZA = new MyLocationButton.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113450);
  }
  
  public MyLocationButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113449);
    this.ocj = true;
    this.dZA = new MyLocationButton.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113449);
  }
  
  private void init()
  {
    AppMethodBeat.i(113451);
    View localView = View.inflate(this.context, 2130970334, this);
    this.ocg = ((ImageButton)localView.findViewById(2131826465));
    this.och = ((LinearLayout)localView.findViewById(2131821119));
    AppMethodBeat.o(113451);
  }
  
  public final void bLG()
  {
    AppMethodBeat.i(113452);
    this.ocg.setImageResource(2130839956);
    AppMethodBeat.o(113452);
  }
  
  public final void bLH()
  {
    AppMethodBeat.i(113453);
    this.ocg.setImageResource(2130839957);
    AppMethodBeat.o(113453);
  }
  
  public ImageButton getMyLocationBtn()
  {
    return this.ocg;
  }
  
  public LinearLayout getProgressBar()
  {
    return this.och;
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.ocj = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113454);
    this.ocg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113454);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(113455);
    this.oci = paramd;
    this.och.setVisibility(0);
    this.ocg.setVisibility(8);
    com.tencent.mm.modelgeo.d.agQ().b(this.dZA, true);
    AppMethodBeat.o(113455);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.MyLocationButton
 * JD-Core Version:    0.7.0.1
 */