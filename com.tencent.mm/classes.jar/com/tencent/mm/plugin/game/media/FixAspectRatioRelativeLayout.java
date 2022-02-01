package com.tencent.mm.plugin.game.media;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.game.g.a;
import com.tencent.mm.sdk.platformtools.Log;

public class FixAspectRatioRelativeLayout
  extends RelativeLayout
{
  private float tEJ;
  
  public FixAspectRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40896);
    c(paramContext, paramAttributeSet, 0);
    AppMethodBeat.o(40896);
  }
  
  public FixAspectRatioRelativeLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40897);
    c(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.o(40897);
  }
  
  private void c(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    AppMethodBeat.i(40898);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, g.a.FixAspectRatioImageView, paramInt, 0);
    this.tEJ = paramContext.getFloat(0, 0.0F);
    paramContext.recycle();
    AppMethodBeat.o(40898);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(40899);
    paramInt1 = View.MeasureSpec.getSize(paramInt1);
    paramInt2 = View.MeasureSpec.getSize(paramInt2);
    int i = (int)(this.tEJ * paramInt1);
    Log.i("MicroMsg.FixAspectRatioRelativeLayout", "width = %d, height = %d, ratioHeight = %d", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), Integer.valueOf(i) });
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(paramInt1, 1073741824), View.MeasureSpec.makeMeasureSpec(i, 1073741824));
    AppMethodBeat.o(40899);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.FixAspectRatioRelativeLayout
 * JD-Core Version:    0.7.0.1
 */