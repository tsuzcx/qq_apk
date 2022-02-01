package android.support.v7.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.v4.widget.q;
import android.support.v7.a.a.a;
import android.text.Layout;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.widget.TextView;

public class DialogTitle
  extends TextView
{
  public DialogTitle(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DialogTitle(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    Object localObject = getLayout();
    if (localObject != null)
    {
      int i = ((Layout)localObject).getLineCount();
      if ((i > 0) && (((Layout)localObject).getEllipsisCount(i - 1) > 0))
      {
        setSingleLine(false);
        setMaxLines(2);
        localObject = getContext().obtainStyledAttributes(null, a.a.TextAppearance, 16842817, 16973892);
        i = ((TypedArray)localObject).getDimensionPixelSize(0, 0);
        if (i != 0) {
          setTextSize(0, i);
        }
        ((TypedArray)localObject).recycle();
        super.onMeasure(paramInt1, paramInt2);
      }
    }
  }
  
  public void setCustomSelectionActionModeCallback(ActionMode.Callback paramCallback)
  {
    super.setCustomSelectionActionModeCallback(q.a(this, paramCallback));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     android.support.v7.widget.DialogTitle
 * JD-Core Version:    0.7.0.1
 */