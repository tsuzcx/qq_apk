package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import androidx.constraintlayout.a.a.j;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class ConstraintHelper
  extends View
{
  protected int[] EA = new int[32];
  protected Context EB;
  protected j EC;
  protected boolean EE = false;
  private String EF;
  protected int mCount;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.EB = paramContext;
    f(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.EB = paramContext;
    f(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.EB = paramContext;
    f(paramAttributeSet);
  }
  
  private void setIds(String paramString)
  {
    if (paramString == null) {
      return;
    }
    int j;
    for (int i = 0;; i = j + 1)
    {
      j = paramString.indexOf(',', i);
      if (j == -1)
      {
        y(paramString.substring(i));
        return;
      }
      y(paramString.substring(i, j));
    }
  }
  
  private void y(String paramString)
  {
    if (paramString == null) {}
    while (this.EB == null) {
      return;
    }
    paramString = paramString.trim();
    i = 0;
    try
    {
      j = R.id.class.getField(paramString).getInt(null);
      i = j;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int j;
        Object localObject;
        continue;
        i = j;
      }
    }
    j = i;
    if (i == 0) {
      j = this.EB.getResources().getIdentifier(paramString, "id", this.EB.getPackageName());
    }
    if ((j == 0) && (isInEditMode()) && ((getParent() instanceof ConstraintLayout)))
    {
      localObject = ((ConstraintLayout)getParent()).u(paramString);
      if ((localObject != null) && ((localObject instanceof Integer)))
      {
        i = ((Integer)localObject).intValue();
        if (i != 0)
        {
          setTag(i, null);
          return;
        }
        new StringBuilder("Could not find id of \"").append(paramString).append("\"");
        return;
      }
    }
  }
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.EF);
    }
    if (this.EC == null) {}
    for (;;)
    {
      return;
      this.EC.fU();
      int i = 0;
      while (i < this.mCount)
      {
        View localView = paramConstraintLayout.bg(this.EA[i]);
        if (localView != null) {
          this.EC.e(paramConstraintLayout.u(localView));
        }
        i += 1;
      }
    }
  }
  
  protected void f(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == R.styleable.ConstraintLayout_Layout_constraint_referenced_ids)
        {
          this.EF = paramAttributeSet.getString(k);
          setIds(this.EF);
        }
        i += 1;
      }
    }
  }
  
  public final void fY()
  {
    if (this.EC == null) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = getLayoutParams();
    } while (!(localLayoutParams instanceof ConstraintLayout.LayoutParams));
    ((ConstraintLayout.LayoutParams)localLayoutParams).Gh = this.EC;
  }
  
  public void fZ() {}
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.EA, this.mCount);
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.EE)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    setMeasuredDimension(0, 0);
  }
  
  public void setReferencedIds(int[] paramArrayOfInt)
  {
    int i = 0;
    this.mCount = 0;
    while (i < paramArrayOfInt.length)
    {
      setTag(paramArrayOfInt[i], null);
      i += 1;
    }
  }
  
  public void setTag(int paramInt, Object paramObject)
  {
    if (this.mCount + 1 > this.EA.length) {
      this.EA = Arrays.copyOf(this.EA, this.EA.length * 2);
    }
    this.EA[this.mCount] = paramInt;
    this.mCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintHelper
 * JD-Core Version:    0.7.0.1
 */