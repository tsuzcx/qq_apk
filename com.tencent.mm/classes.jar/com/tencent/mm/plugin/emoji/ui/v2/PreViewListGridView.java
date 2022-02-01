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
import com.tencent.mm.sdk.platformtools.aq;

public class PreViewListGridView
  extends ListView
{
  private WindowManager gNl;
  private aq mHandler;
  private int mOrientation;
  private boolean pWg;
  private WindowManager.LayoutParams pWm;
  private int pWn;
  private int pWo;
  private int pWp;
  private boolean pWq;
  private volatile int pWr;
  private String pWs;
  private PopEmojiView pWt;
  private a pWu;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.pWg = true;
    this.mHandler = new aq();
    this.pWr = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.pWg = true;
    this.mHandler = new aq();
    this.pWr = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.pWt = new PopEmojiView(getContext());
    this.pWn = paramContext.getResources().getDimensionPixelSize(2131166259);
    this.gNl = ((WindowManager)paramContext.getSystemService("window"));
    this.pWm = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.pWm.width = this.pWn;
    this.pWm.height = this.pWn;
    this.pWm.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.pWo = this.gNl.getDefaultDisplay().getHeight();
      this.pWp = this.gNl.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.pWo = this.gNl.getDefaultDisplay().getWidth();
    this.pWp = this.gNl.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void cko()
  {
    AppMethodBeat.i(109426);
    if (this.pWq)
    {
      this.gNl.removeView(this.pWt);
      this.pWq = false;
    }
    this.pWs = "";
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
    } while (!this.pWq);
    cko();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.pWu = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.pWg = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */