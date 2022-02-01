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
import com.tencent.mm.sdk.platformtools.ao;

public class PreViewListGridView
  extends ListView
{
  private WindowManager gqS;
  private ao mHandler;
  private int mOrientation;
  private boolean pmb;
  private WindowManager.LayoutParams pmh;
  private int pmi;
  private int pmj;
  private int pmk;
  private boolean pml;
  private volatile int pmm;
  private String pmn;
  private PopEmojiView pmo;
  private a pmp;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.pmb = true;
    this.mHandler = new ao();
    this.pmm = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.pmb = true;
    this.mHandler = new ao();
    this.pmm = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.pmo = new PopEmojiView(getContext());
    this.pmi = paramContext.getResources().getDimensionPixelSize(2131166259);
    this.gqS = ((WindowManager)paramContext.getSystemService("window"));
    this.pmh = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.pmh.width = this.pmi;
    this.pmh.height = this.pmi;
    this.pmh.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.pmj = this.gqS.getDefaultDisplay().getHeight();
      this.pmk = this.gqS.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.pmj = this.gqS.getDefaultDisplay().getWidth();
    this.pmk = this.gqS.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void cev()
  {
    AppMethodBeat.i(109426);
    if (this.pml)
    {
      this.gqS.removeView(this.pmo);
      this.pml = false;
    }
    this.pmn = "";
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
    } while (!this.pml);
    cev();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.pmp = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.pmb = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */