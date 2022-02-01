package androidx.appcompat.app;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import androidx.appcompat.a.j;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class ActionBar$LayoutParams
  extends ViewGroup.MarginLayoutParams
{
  public int ek;
  
  public ActionBar$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    this.ek = 0;
    this.ek = 8388627;
  }
  
  public ActionBar$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(237947);
    this.ek = 0;
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, a.j.ActionBarLayout);
    this.ek = paramContext.getInt(a.j.ActionBarLayout_android_layout_gravity, 0);
    paramContext.recycle();
    AppMethodBeat.o(237947);
  }
  
  public ActionBar$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.ek = 0;
  }
  
  public ActionBar$LayoutParams(LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    this.ek = 0;
    this.ek = paramLayoutParams.ek;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     androidx.appcompat.app.ActionBar.LayoutParams
 * JD-Core Version:    0.7.0.1
 */