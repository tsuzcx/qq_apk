package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private RelativeLayout qBL;
  private RelativeLayout qBM;
  private ImageView qBN;
  private ImageView qBO;
  private ImageView qBP;
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final int coN()
  {
    return 2131493914;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104328);
    this.qBL = ((RelativeLayout)findViewById(2131299732));
    this.qBM = ((RelativeLayout)findViewById(2131299730));
    setVisibility(4);
    this.qBL.setVisibility(4);
    this.qBM.setVisibility(4);
    this.qBN = ((ImageView)findViewById(2131299673));
    this.qBO = ((ImageView)findViewById(2131299670));
    this.qBP = ((ImageView)findViewById(2131299680));
    AppMethodBeat.o(104328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.e
 * JD-Core Version:    0.7.0.1
 */