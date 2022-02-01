package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class e
  extends a
{
  private RelativeLayout rtG;
  private RelativeLayout rtH;
  private ImageView rtI;
  private ImageView rtJ;
  private ImageView rtK;
  
  public e(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final int cvT()
  {
    return 2131493914;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104328);
    this.rtG = ((RelativeLayout)findViewById(2131299732));
    this.rtH = ((RelativeLayout)findViewById(2131299730));
    setVisibility(4);
    this.rtG.setVisibility(4);
    this.rtH.setVisibility(4);
    this.rtI = ((ImageView)findViewById(2131299673));
    this.rtJ = ((ImageView)findViewById(2131299670));
    this.rtK = ((ImageView)findViewById(2131299680));
    AppMethodBeat.o(104328);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.e
 * JD-Core Version:    0.7.0.1
 */