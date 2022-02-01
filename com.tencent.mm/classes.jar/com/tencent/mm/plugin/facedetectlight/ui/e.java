package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private RelativeLayout pTf;
  private RelativeLayout pTg;
  private ImageView pTh;
  private ImageView pTi;
  private ImageView pTj;
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final int chg()
  {
    return 2131493914;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104328);
    this.pTf = ((RelativeLayout)findViewById(2131299732));
    this.pTg = ((RelativeLayout)findViewById(2131299730));
    setVisibility(4);
    this.pTf.setVisibility(4);
    this.pTg.setVisibility(4);
    this.pTh = ((ImageView)findViewById(2131299673));
    this.pTi = ((ImageView)findViewById(2131299670));
    this.pTj = ((ImageView)findViewById(2131299680));
    AppMethodBeat.o(104328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.e
 * JD-Core Version:    0.7.0.1
 */