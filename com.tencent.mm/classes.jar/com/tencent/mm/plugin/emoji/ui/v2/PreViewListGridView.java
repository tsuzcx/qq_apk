package com.tencent.mm.plugin.emoji.ui.v2;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ap;

public class PreViewListGridView
  extends ListView
{
  private ap mHandler;
  private int mOrientation;
  private WindowManager oEl;
  private boolean oIB;
  private WindowManager.LayoutParams oIH;
  private int oII;
  private int oIJ;
  private int oIK;
  private boolean oIL;
  private volatile int oIM;
  private String oIN;
  private PopEmojiView oIO;
  private a oIP;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.oIB = true;
    this.mHandler = new ap();
    this.oIM = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.oIB = true;
    this.mHandler = new ap();
    this.oIM = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.oIO = new PopEmojiView(getContext());
    this.oII = paramContext.getResources().getDimensionPixelSize(2131166259);
    this.oEl = ((WindowManager)paramContext.getSystemService("window"));
    this.oIH = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.oIH.width = this.oII;
    this.oIH.height = this.oII;
    this.oIH.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.oIJ = this.oEl.getDefaultDisplay().getHeight();
      this.oIK = this.oEl.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.oIJ = this.oEl.getDefaultDisplay().getWidth();
    this.oIK = this.oEl.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void bXi()
  {
    AppMethodBeat.i(109426);
    if (this.oIL)
    {
      this.oEl.removeView(this.oIO);
      this.oIL = false;
    }
    this.oIN = "";
    AppMethodBeat.o(109426);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(109425);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(109425);
      return bool;
    } while (!this.oIL);
    bXi();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.oIP = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.oIB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */