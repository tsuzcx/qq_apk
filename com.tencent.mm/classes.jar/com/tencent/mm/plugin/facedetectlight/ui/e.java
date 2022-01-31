package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private RelativeLayout mmu;
  private RelativeLayout mmv;
  private ImageView mmw;
  private ImageView mmx;
  private ImageView mmy;
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final int bvM()
  {
    return 2130969501;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(808);
    this.mmu = ((RelativeLayout)findViewById(2131823863));
    this.mmv = ((RelativeLayout)findViewById(2131823858));
    setVisibility(4);
    this.mmu.setVisibility(4);
    this.mmv.setVisibility(4);
    this.mmw = ((ImageView)findViewById(2131823869));
    this.mmx = ((ImageView)findViewById(2131823868));
    this.mmy = ((ImageView)findViewById(2131823865));
    AppMethodBeat.o(808);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.e
 * JD-Core Version:    0.7.0.1
 */