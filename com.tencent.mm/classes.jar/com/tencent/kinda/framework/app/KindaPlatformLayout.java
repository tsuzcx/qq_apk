package com.tencent.kinda.framework.app;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class KindaPlatformLayout
  extends LinearLayout
{
  public static String TAG = "KindaPlatformLayout";
  private TestMeasure measure;
  
  public KindaPlatformLayout(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(18462);
    this.measure = new TestMeasure();
    AppMethodBeat.o(18462);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(18463);
    this.measure = new TestMeasure();
    AppMethodBeat.o(18463);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(18464);
    this.measure = new TestMeasure();
    AppMethodBeat.o(18464);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(18467);
    long l1 = SystemClock.elapsedRealtime();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    long l2 = SystemClock.elapsedRealtime();
    TestMeasure localTestMeasure = this.measure;
    localTestMeasure.valLayout = (l2 - l1 + localTestMeasure.valLayout);
    AppMethodBeat.o(18467);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(18465);
    long l1 = SystemClock.elapsedRealtime();
    super.onMeasure(paramInt1, paramInt2);
    long l2 = SystemClock.elapsedRealtime();
    TestMeasure localTestMeasure = this.measure;
    localTestMeasure.valMeasure = (l2 - l1 + localTestMeasure.valMeasure);
    AppMethodBeat.o(18465);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(18466);
    super.requestLayout();
    AppMethodBeat.o(18466);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformLayout
 * JD-Core Version:    0.7.0.1
 */