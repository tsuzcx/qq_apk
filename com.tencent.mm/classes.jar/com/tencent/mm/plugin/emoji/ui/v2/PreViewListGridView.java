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
import com.tencent.mm.plugin.emoji.h.c;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class PreViewListGridView
  extends ListView
{
  private MMHandler mHandler;
  private int mOrientation;
  private WindowManager mWindowManager;
  private boolean xZc;
  private WindowManager.LayoutParams xZi;
  private int xZj;
  private int xZk;
  private int xZl;
  private boolean xZm;
  private volatile int xZn;
  private String xZo;
  private PopEmojiView xZp;
  private a xZq;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.xZc = true;
    this.mHandler = new MMHandler();
    this.xZn = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.xZc = true;
    this.mHandler = new MMHandler();
    this.xZn = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.xZp = new PopEmojiView(getContext());
    this.xZj = paramContext.getResources().getDimensionPixelSize(h.c.emoji_preview_image_size);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.xZi = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.xZi.width = this.xZj;
    this.xZi.height = this.xZj;
    this.xZi.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.xZk = this.mWindowManager.getDefaultDisplay().getHeight();
      this.xZl = this.mWindowManager.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.xZk = this.mWindowManager.getDefaultDisplay().getWidth();
    this.xZl = this.mWindowManager.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void dCD()
  {
    AppMethodBeat.i(109426);
    if (this.xZm)
    {
      this.mWindowManager.removeView(this.xZp);
      this.xZm = false;
    }
    this.xZo = "";
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
    } while (!this.xZm);
    dCD();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.xZq = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.xZc = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */