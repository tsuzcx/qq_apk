package com.facebook.yoga.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.ViewGroup.LayoutParams;
import com.tencent.kinda.R.styleable;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class YogaLayout$LayoutParams
  extends ViewGroup.LayoutParams
{
  SparseArray<Float> numericAttributes;
  SparseArray<String> stringAttributes;
  
  public YogaLayout$LayoutParams(int paramInt1, int paramInt2)
  {
    super(paramInt1, paramInt2);
    AppMethodBeat.i(18234);
    this.numericAttributes = new SparseArray();
    this.stringAttributes = new SparseArray();
    if (paramInt1 >= 0) {
      this.numericAttributes.put(55, Float.valueOf(paramInt1));
    }
    if (paramInt2 >= 0) {
      this.numericAttributes.put(20, Float.valueOf(paramInt2));
    }
    AppMethodBeat.o(18234);
  }
  
  public YogaLayout$LayoutParams(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(18235);
    this.numericAttributes = new SparseArray();
    this.stringAttributes = new SparseArray();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.yoga);
    if (this.width >= 0) {
      this.numericAttributes.put(55, Float.valueOf(this.width));
    }
    if (this.height >= 0) {
      this.numericAttributes.put(20, Float.valueOf(this.height));
    }
    int j = paramContext.getIndexCount();
    int i = 0;
    if (i < j)
    {
      int k = paramContext.getIndex(i);
      paramAttributeSet = new TypedValue();
      paramContext.getValue(k, paramAttributeSet);
      if (paramAttributeSet.type == 5) {
        this.numericAttributes.put(k, Float.valueOf(paramContext.getDimensionPixelSize(k, 0)));
      }
      for (;;)
      {
        i += 1;
        break;
        if (paramAttributeSet.type == 3) {
          this.stringAttributes.put(k, paramContext.getString(k));
        } else {
          this.numericAttributes.put(k, Float.valueOf(paramContext.getFloat(k, 0.0F)));
        }
      }
    }
    paramContext.recycle();
    AppMethodBeat.o(18235);
  }
  
  public YogaLayout$LayoutParams(ViewGroup.LayoutParams paramLayoutParams)
  {
    super(paramLayoutParams);
    AppMethodBeat.i(18233);
    if ((paramLayoutParams instanceof LayoutParams))
    {
      this.numericAttributes = ((LayoutParams)paramLayoutParams).numericAttributes.clone();
      this.stringAttributes = ((LayoutParams)paramLayoutParams).stringAttributes.clone();
      AppMethodBeat.o(18233);
      return;
    }
    this.numericAttributes = new SparseArray();
    this.stringAttributes = new SparseArray();
    if (paramLayoutParams.width >= 0) {
      this.numericAttributes.put(55, Float.valueOf(this.width));
    }
    if (paramLayoutParams.height >= 0) {
      this.numericAttributes.put(20, Float.valueOf(this.height));
    }
    AppMethodBeat.o(18233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.facebook.yoga.android.YogaLayout.LayoutParams
 * JD-Core Version:    0.7.0.1
 */