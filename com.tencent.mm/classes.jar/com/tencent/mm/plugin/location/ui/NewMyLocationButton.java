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

public class NewMyLocationButton
  extends FrameLayout
{
  private Context context;
  private b.a dZA;
  private ImageButton ocg;
  private LinearLayout och;
  private com.tencent.mm.plugin.k.d oci;
  private boolean ocj;
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(113464);
    this.ocj = true;
    this.dZA = new NewMyLocationButton.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113464);
  }
  
  public NewMyLocationButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(113463);
    this.ocj = true;
    this.dZA = new NewMyLocationButton.1(this);
    this.context = paramContext;
    init();
    AppMethodBeat.o(113463);
  }
  
  private void init()
  {
    AppMethodBeat.i(113465);
    View localView = View.inflate(this.context, 2130970359, this);
    this.ocg = ((ImageButton)localView.findViewById(2131826547));
    this.och = ((LinearLayout)localView.findViewById(2131826548));
    AppMethodBeat.o(113465);
  }
  
  public void setAnimToSelf(boolean paramBoolean)
  {
    this.ocj = paramBoolean;
  }
  
  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    AppMethodBeat.i(113466);
    this.ocg.setOnClickListener(paramOnClickListener);
    AppMethodBeat.o(113466);
  }
  
  public void setProgressBar(com.tencent.mm.plugin.k.d paramd)
  {
    AppMethodBeat.i(113467);
    this.oci = paramd;
    this.och.setVisibility(0);
    this.ocg.setVisibility(8);
    com.tencent.mm.modelgeo.d.agQ().b(this.dZA, true);
    AppMethodBeat.o(113467);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.location.ui.NewMyLocationButton
 * JD-Core Version:    0.7.0.1
 */