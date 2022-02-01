package com.tencent.mm.plugin.facedetectlight.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.facedetect.model.FaceDetectReporter;
import com.tencent.mm.plugin.gif.MMAnimateView;

public final class d
  extends a
  implements View.OnClickListener
{
  public d(ViewGroup paramViewGroup, com.tencent.mm.plugin.facedetectlight.ui.container.a parama)
  {
    super(paramViewGroup, parama);
  }
  
  public final int coN()
  {
    return 2131493913;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(104326);
    FaceDetectReporter.cnC().cnD();
    FaceDetectReporter.cnC().cnE();
    FaceDetectReporter.cnC().qyj = System.currentTimeMillis();
    MMAnimateView localMMAnimateView = (MMAnimateView)findViewById(2131299705);
    localMMAnimateView.setImageResource(2131690129);
    localMMAnimateView.start();
    ((Button)findViewById(2131299704)).setOnClickListener(this);
    AppMethodBeat.o(104326);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(104327);
    if (paramView.getId() == 2131299704)
    {
      setVisibility(8);
      this.qGI.startPreview();
    }
    AppMethodBeat.o(104327);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.d
 * JD-Core Version:    0.7.0.1
 */