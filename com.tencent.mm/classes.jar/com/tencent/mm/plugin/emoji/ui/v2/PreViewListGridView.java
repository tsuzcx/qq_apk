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
import com.tencent.mm.plugin.emoji.i.c;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.MMHandler;

public class PreViewListGridView
  extends ListView
{
  private MMHandler mHandler;
  private int mOrientation;
  private WindowManager mWindowManager;
  private int uQA;
  private boolean uQB;
  private volatile int uQC;
  private String uQD;
  private PopEmojiView uQE;
  private a uQF;
  private boolean uQr;
  private WindowManager.LayoutParams uQx;
  private int uQy;
  private int uQz;
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(109421);
    this.uQr = true;
    this.mHandler = new MMHandler();
    this.uQC = -1;
    init(paramContext);
    AppMethodBeat.o(109421);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(109422);
    this.uQr = true;
    this.mHandler = new MMHandler();
    this.uQC = -1;
    init(paramContext);
    AppMethodBeat.o(109422);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(109423);
    this.uQE = new PopEmojiView(getContext());
    this.uQy = paramContext.getResources().getDimensionPixelSize(i.c.emoji_preview_image_size);
    this.mWindowManager = ((WindowManager)paramContext.getSystemService("window"));
    this.uQx = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.uQx.width = this.uQy;
    this.uQx.height = this.uQy;
    this.uQx.gravity = 17;
    this.mOrientation = getResources().getConfiguration().orientation;
    if (this.mOrientation == 2)
    {
      this.uQz = this.mWindowManager.getDefaultDisplay().getHeight();
      this.uQA = this.mWindowManager.getDefaultDisplay().getWidth();
      AppMethodBeat.o(109423);
      return;
    }
    this.uQz = this.mWindowManager.getDefaultDisplay().getWidth();
    this.uQA = this.mWindowManager.getDefaultDisplay().getHeight();
    AppMethodBeat.o(109423);
  }
  
  public final void cWX()
  {
    AppMethodBeat.i(109426);
    if (this.uQB)
    {
      this.mWindowManager.removeView(this.uQE);
      this.uQB = false;
    }
    this.uQD = "";
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
    } while (!this.uQB);
    cWX();
    AppMethodBeat.o(109425);
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    AppMethodBeat.i(109424);
    super.setAdapter(paramListAdapter);
    this.uQF = ((a)paramListAdapter);
    AppMethodBeat.o(109424);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.uQr = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */