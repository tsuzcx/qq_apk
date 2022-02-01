package com.tencent.mm.plugin.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ScrollView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class MMKeyboardUperView
  extends ScrollView
{
  private int defaultHeight;
  private View jma;
  private Runnable jmb;
  private Runnable jmc;
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(128257);
    this.defaultHeight = -1;
    this.jmb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128254);
        MMKeyboardUperView.this.fullScroll(130);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(4);
        AppMethodBeat.o(128254);
      }
    };
    this.jmc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128255);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(0);
        AppMethodBeat.o(128255);
      }
    };
    AppMethodBeat.o(128257);
  }
  
  public MMKeyboardUperView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(128256);
    this.defaultHeight = -1;
    this.jmb = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128254);
        MMKeyboardUperView.this.fullScroll(130);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(4);
        AppMethodBeat.o(128254);
      }
    };
    this.jmc = new Runnable()
    {
      public final void run()
      {
        AppMethodBeat.i(128255);
        MMKeyboardUperView.a(MMKeyboardUperView.this).setVisibility(0);
        AppMethodBeat.o(128255);
      }
    };
    AppMethodBeat.o(128256);
  }
  
  public void setupUperView(View paramView)
  {
    this.jma = paramView;
    this.defaultHeight = -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.account.ui.MMKeyboardUperView
 * JD-Core Version:    0.7.0.1
 */