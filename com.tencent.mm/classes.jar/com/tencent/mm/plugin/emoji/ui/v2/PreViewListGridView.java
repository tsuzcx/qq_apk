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
  private WindowManager gKC;
  private ap mHandler;
  private int mOrientation;
  private boolean pPB;
  private WindowManager.LayoutParams pPH;
  private int pPI;
  private int pPJ;
  private int pPK;
  private boolean pPL;
  private volatile int pPM;
  private String pPN;
  private PopEmojiView pPO;
  private a pPP;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.pPB = true;
    this.mHandler = new ap();
    this.pPM = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.pPB = true;
    this.mHandler = new ap();
    this.pPM = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.pPO = new PopEmojiView(getContext());
    this.pPI = paramContext.getResources().getDimensionPixelSize(2131166259);
    this.gKC = ((WindowManager)paramContext.getSystemService("window"));
    this.pPH = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.pPH.width = this.pPI;
    this.pPH.height = this.pPI;
    this.pPH.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.pPJ = this.gKC.getDefaultDisplay().getHeight();
      this.pPK = this.gKC.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.pPJ = this.gKC.getDefaultDisplay().getWidth();
    this.pPK = this.gKC.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void ciY()
  {
    AppMethodBeat.i(109426);
    if (this.pPL)
    {
      this.gKC.removeView(this.pPO);
      this.pPL = false;
    }
    this.pPN = "";
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
    } while (!this.pPL);
    ciY();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.pPP = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.pPB = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */