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
  
  public final int bvM()
  {
    return 2130969500;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(806);
    FaceDetectReporter.buB().buC();
    FaceDetectReporter.buB().buD();
    FaceDetectReporter.buB().miO = System.currentTimeMillis();
    MMAnimateView localMMAnimateView = (MMAnimateView)findViewById(2131823900);
    localMMAnimateView.setImageResource(2131231285);
    localMMAnimateView.start();
    ((Button)findViewById(2131823903)).setOnClickListener(this);
    AppMethodBeat.o(806);
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(807);
    if (paramView.getId() == 2131823903)
    {
      setVisibility(8);
      this.mrz.startPreview();
    }
    AppMethodBeat.o(807);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetectlight.ui.d
 * JD-Core Version:    0.7.0.1
 */