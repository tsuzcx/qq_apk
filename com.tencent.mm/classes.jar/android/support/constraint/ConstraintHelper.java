package android.support.constraint;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.support.constraint.solver.widgets.Helper;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class ConstraintHelper
  extends View
{
  protected int mCount;
  protected Helper mHelperWidget;
  protected int[] mIds = new int[32];
  private String mReferenceIds;
  protected boolean mUseViewMeasure = false;
  protected Context myContext;
  
  public ConstraintHelper(Context paramContext)
  {
    super(paramContext);
    this.myContext = paramContext;
    init(null);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  public ConstraintHelper(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.myContext = paramContext;
    init(paramAttributeSet);
  }
  
  private void addID(String paramString)
  {
    if (paramString == null) {}
    while (this.myContext == null) {
      return;
    }
    paramString = paramString.trim();
    for (;;)
    {
      int j;
      try
      {
        i = R.id.class.getField(paramString).getInt(null);
        j = i;
        if (i == 0) {
          j = this.myContext.getResources().getIdentifier(paramString, "id", this.myContext.getPackageName());
        }
        if ((j == 0) && (isInEditMode()) && ((getParent() instanceof ConstraintLayout)))
        {
          Object localObject = ((ConstraintLayout)getParent()).getDesignInformation(0, paramString);
          if ((localObject != null) && ((localObject instanceof Integer)))
          {
            i = ((Integer)localObject).intValue();
            if (i != 0)
            {
              setTag(i, null);
              return;
            }
          }
        }
      }
      catch (Exception localException)
      {
        i = 0;
        continue;
        new StringBuilder("Could not find id of \"").append(paramString).append("\"");
        return;
      }
      int i = j;
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
        addID(paramString.substring(i));
        return;
      }
      addID(paramString.substring(i, j));
    }
  }
  
  public int[] getReferencedIds()
  {
    return Arrays.copyOf(this.mIds, this.mCount);
  }
  
  protected void init(AttributeSet paramAttributeSet)
  {
    if (paramAttributeSet != null)
    {
      paramAttributeSet = getContext().obtainStyledAttributes(paramAttributeSet, R.styleable.ConstraintLayout_Layout);
      int j = paramAttributeSet.getIndexCount();
      int i = 0;
      while (i < j)
      {
        int k = paramAttributeSet.getIndex(i);
        if (k == 9)
        {
          this.mReferenceIds = paramAttributeSet.getString(k);
          setIds(this.mReferenceIds);
        }
        i += 1;
      }
    }
  }
  
  public void onDraw(Canvas paramCanvas) {}
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.mUseViewMeasure)
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
    if (this.mCount + 1 > this.mIds.length) {
      this.mIds = Arrays.copyOf(this.mIds, this.mIds.length * 2);
    }
    this.mIds[this.mCount] = paramInt;
    this.mCount += 1;
  }
  
  public void updatePostLayout(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePostMeasure(ConstraintLayout paramConstraintLayout) {}
  
  public void updatePreLayout(ConstraintLayout paramConstraintLayout)
  {
    if (isInEditMode()) {
      setIds(this.mReferenceIds);
    }
    if (this.mHelperWidget == null) {}
    for (;;)
    {
      return;
      this.mHelperWidget.removeAllIds();
      int i = 0;
      while (i < this.mCount)
      {
        View localView = paramConstraintLayout.getViewById(this.mIds[i]);
        if (localView != null) {
          this.mHelperWidget.add(paramConstraintLayout.getViewWidget(localView));
        }
        i += 1;
      }
    }
  }
  
  public void validateParams()
  {
    if (this.mHelperWidget == null) {}
    ViewGroup.LayoutParams localLayoutParams;
    do
    {
      return;
      localLayoutParams = getLayoutParams();
    } while (!(localLayoutParams instanceof ConstraintLayout.LayoutParams));
    ((ConstraintLayout.LayoutParams)localLayoutParams).widget = this.mHelperWidget;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     android.support.constraint.ConstraintHelper
 * JD-Core Version:    0.7.0.1
 */