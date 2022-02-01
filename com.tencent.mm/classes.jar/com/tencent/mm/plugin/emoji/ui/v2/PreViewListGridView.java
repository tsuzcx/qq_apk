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
import com.tencent.mm.sdk.platformtools.MMHandler;

public class PreViewListGridView
  extends ListView
{
  private MMHandler mHandler;
  private int mOrientation;
  private WindowManager mWindowManager;
  private boolean rnf;
  private WindowManager.LayoutParams rnl;
  private int rnm;
  private int rnn;
  private int rno;
  private boolean rnp;
  private volatile int rnq;
  private String rnr;
  private PopEmojiView rns;
  private a rnt;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.rnf = true;
    this.mHandler = new MMHandler();
    this.rnq = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.rnf = true;
    this.mHandler = new MMHandler();
    this.rnq = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.rns = new PopEmojiView(getContext());
    this.rnm = paramContext.getResources().getDimensionPixelSize(2131166302);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.rnl = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.rnl.width = this.rnm;
    this.rnl.height = this.rnm;
    this.rnl.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.rnn = this.mWindowManager.getDefaultDisplay().getHeight();
      this.rno = this.mWindowManager.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.rnn = this.mWindowManager.getDefaultDisplay().getWidth();
    this.rno = this.mWindowManager.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void cIq()
  {
    AppMethodBeat.i(109426);
    if (this.rnp)
    {
      this.mWindowManager.removeView(this.rns);
      this.rnp = false;
    }
    this.rnr = "";
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
    } while (!this.rnp);
    cIq();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.rnt = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.rnf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */