package com.tencent.kinda.framework.app;

import android.content.Context;
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
    AppMethodBeat.i(144376);
    this.measure = new TestMeasure();
    AppMethodBeat.o(144376);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(144377);
    this.measure = new TestMeasure();
    AppMethodBeat.o(144377);
  }
  
  public KindaPlatformLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(144378);
    this.measure = new TestMeasure();
    AppMethodBeat.o(144378);
  }
  
  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(144381);
    long l1 = System.currentTimeMillis();
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    long l2 = System.currentTimeMillis();
    TestMeasure localTestMeasure = this.measure;
    localTestMeasure.valLayout = (l2 - l1 + localTestMeasure.valLayout);
    AppMethodBeat.o(144381);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(144379);
    long l1 = System.currentTimeMillis();
    super.onMeasure(paramInt1, paramInt2);
    long l2 = System.currentTimeMillis();
    TestMeasure localTestMeasure = this.measure;
    localTestMeasure.valMeasure = (l2 - l1 + localTestMeasure.valMeasure);
    AppMethodBeat.o(144379);
  }
  
  public void requestLayout()
  {
    AppMethodBeat.i(144380);
    super.requestLayout();
    AppMethodBeat.o(144380);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.kinda.framework.app.KindaPlatformLayout
 * JD-Core Version:    0.7.0.1
 */