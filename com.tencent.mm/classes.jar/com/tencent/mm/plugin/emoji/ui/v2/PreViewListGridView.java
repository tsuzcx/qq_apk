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
import com.tencent.mm.sdk.platformtools.ak;

public class PreViewListGridView
  extends ListView
{
  private WindowManager lnU;
  private boolean lsi;
  private WindowManager.LayoutParams lso;
  private int lsp;
  private int lsq;
  private int lsr;
  private boolean lss;
  private volatile int lst;
  private String lsu;
  private PopEmojiView lsv;
  private a lsw;
  private ak mHandler;
  private int mOrientation;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(53848);
    this.lsi = true;
    this.mHandler = new ak();
    this.lst = -1;
    init(paramContext);
    AppMethodBeat.o(53848);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(53849);
    this.lsi = true;
    this.mHandler = new ak();
    this.lst = -1;
    init(paramContext);
    AppMethodBeat.o(53849);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(53850);
    this.lsv = new PopEmojiView(getContext());
    this.lsp = paramContext.getResources().getDimensionPixelSize(2131428393);
    this.lnU = ((WindowManager)paramContext.getSystemService("window"));
    this.lso = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.lso.width = this.lsp;
    this.lso.height = this.lsp;
    this.lso.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.lsq = this.lnU.getDefaultDisplay().getHeight();
      this.lsr = this.lnU.getDefaultDisplay().getWidth();
      AppMethodBeat.o(53850);
      return;
    }
    this.lsq = this.lnU.getDefaultDisplay().getWidth();
    this.lsr = this.lnU.getDefaultDisplay().getHeight();
    AppMethodBeat.o(53850);
  }
  
  public final void bnw()
  {
    AppMethodBeat.i(53853);
    if (this.lss)
    {
      this.lnU.removeView(this.lsv);
      this.lss = false;
    }
    this.lsu = "";
    AppMethodBeat.o(53853);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(53852);
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      boolean bool = super.onInterceptTouchEvent(paramMotionEvent);
      AppMethodBeat.o(53852);
      return bool;
    } while (!this.lss);
    bnw();
    AppMethodBeat.o(53852);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(53851);
    super.setAdapter(paramListAdapter);
    this.lsw = ((a)paramListAdapter);
    AppMethodBeat.o(53851);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.lsi = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */