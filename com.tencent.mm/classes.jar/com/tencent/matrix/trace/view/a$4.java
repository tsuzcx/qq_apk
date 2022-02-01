package com.tencent.matrix.trace.view;

import android.widget.TextView;
import java.util.LinkedList;

final class a$4
  implements Runnable
{
  a$4(a parama, FloatFrameView paramFloatFrameView, float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {}
  
  public final void run()
  {
    FloatFrameView.LineChartView localLineChartView = this.cCl.cBl;
    FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)this.cCo, this.cCp);
    if (localLineChartView.cBB.size() >= 50) {
      localLineChartView.cBB.removeLast();
    }
    localLineChartView.cBB.addFirst(locala);
    localLineChartView.invalidate();
    this.cCl.cBk.setText(this.cCq);
    this.cCl.cBk.setTextColor(this.cCp);
    this.cCl.cBw.setText(this.cCr);
    this.cCl.cBm.setText(this.cCs);
    this.cCl.cBn.setText(this.cCt);
    this.cCl.cBo.setText(this.cCu);
    this.cCl.cBp.setText(this.cCv);
    this.cCl.cBx.setText(this.cCw);
    this.cCl.cBq.setText(this.cCx);
    this.cCl.cBr.setText(this.cCy);
    this.cCl.cBs.setText(this.cCz);
    this.cCl.cBt.setText(this.cCA);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.4
 * JD-Core Version:    0.7.0.1
 */