package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;

public class MMKeyboardUperView
  extends ScrollView
{
  private int defaultHeight = -1;
  private View fnP;
  private Runnable fnQ = new Runnable()
  {
    public final void run()
    {
      MMKeyboardUperView.this.fullScroll(130);
      MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(4);
    }
  };
  private Runnable fnR = new Runnable()
  {
    public final void run()
    {
      MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(0);
    }
  };
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void setupUperView(View paramView)
  {
    this.fnP = paramView;
    this.defaultHeight = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMKeyboardUperView
 * JD-Core Version:    0.7.0.1
 */