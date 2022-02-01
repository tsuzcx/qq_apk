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
  protected int[] bkI = new int[32];
  protected Context bkJ;
  protected j bkK;
  protected boolean bkL = false;
  private String bkM;
  protected int mCount;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.bkJ = paramContext;
    f(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.bkJ = paramContext;
    f(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.bkJ = paramContext;
    f(paramAttributeSet);
  }
  
  private void aq(String paramString)
  {
    if (paramString == null) {}
    while (this.bkJ == null) {
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
      j = this.bkJ.getResources().getIdentifier(paramString, "id", this.bkJ.getPackageName());
    }
    if ((j == 0) && (isInEditMode()) && ((getParent() instanceof ConstraintLayout)))
    {
      localObject = ((ConstraintLayout)getParent()).at(paramString);
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
        aq(paramString.substring(i));
        return;
      }
      aq(paramString.substring(i, j));
    }
  }
  
  public final void Dh()
  {
    if (this.bkK == null) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = getLayoutParams();
    } while (!(localLayoutParams instanceof ConstraintLayout.LayoutParams));
    ((ConstraintLayout.LayoutParams)localLayoutParams).bml = this.bkK;
  }
  
  public void Di() {}
  
  public void a(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.bkM);
    }
    if (this.bkK == null) {}
    for (;;)
    {
      return;
      this.bkK.Dd();
      int i = 0;
      while (i < this.mCount)
      {
        View localView = paramConstraintLayout.dU(this.bkI[i]);
        if (localView != null) {
          this.bkK.e(paramConstraintLayout.D(localView));
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
          this.bkM = paramAttributeSet.getString(k);
          setIds(this.bkM);
        }
        i += 1;
      }
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.bkI, this.mCount);
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.bkL)
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
    if (this.mCount + 1 > this.bkI.length) {
      this.bkI = Arrays.copyOf(this.bkI, this.bkI.length * 2);
    }
    this.bkI[this.mCount] = paramInt;
    this.mCount += 1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes11.jar
 * Qualified Name:     androidx.constraintlayout.widget.ConstraintHelper
 * JD-Core Version:    0.7.0.1
 */