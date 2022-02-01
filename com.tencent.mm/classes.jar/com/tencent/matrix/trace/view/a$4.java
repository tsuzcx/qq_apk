package com.tencent.matrix.trace.view;

import android.widget.TextView;
import java.util.LinkedList;

final class a$4
  implements Runnable
{
  a$4(a parama, FloatFrameView paramFloatFrameView, float paramFloat, int paramInt, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9, String paramString10, String paramString11) {}
  
  public final void run()
  {
    FloatFrameView.LineChartView localLineChartView = this.cNU.cMT;
    FloatFrameView.LineChartView.a locala = new FloatFrameView.LineChartView.a(localLineChartView, (int)this.cNW, this.cNX);
    if (localLineChartView.cNj.size() >= 50) {
      localLineChartView.cNj.removeLast();
    }
    localLineChartView.cNj.addFirst(locala);
    localLineChartView.invalidate();
    this.cNU.cMS.setText(this.cNY);
    this.cNU.cMS.setTextColor(this.cNX);
    this.cNU.cNe.setText(this.cNZ);
    this.cNU.cMU.setText(this.cOa);
    this.cNU.cMV.setText(this.cOb);
    this.cNU.cMW.setText(this.cOc);
    this.cNU.cMX.setText(this.cOd);
    this.cNU.cNf.setText(this.cOe);
    this.cNU.cMY.setText(this.cOf);
    this.cNU.cMZ.setText(this.cOg);
    this.cNU.cNa.setText(this.cOh);
    this.cNU.cNb.setText(this.cOi);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.matrix.trace.view.a.4
 * JD-Core Version:    0.7.0.1
 */