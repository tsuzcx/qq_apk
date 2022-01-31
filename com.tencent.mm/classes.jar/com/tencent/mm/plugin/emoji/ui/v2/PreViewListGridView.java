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
import com.tencent.mm.plugin.emoji.f.c;
import com.tencent.mm.pluginsdk.ui.emoji.PopEmojiView;
import com.tencent.mm.sdk.platformtools.ah;

public class PreViewListGridView
  extends ListView
{
  private int adN;
  private WindowManager jfe;
  private boolean jjA;
  private volatile int jjB = -1;
  private String jjC;
  private PopEmojiView jjD;
  private d jjE;
  private boolean jjq = true;
  private WindowManager.LayoutParams jjw;
  private int jjx;
  private int jjy;
  private int jjz;
  private ah mHandler = new ah();
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init(paramContext);
  }
  
  public PreViewListGridView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init(paramContext);
  }
  
  private void init(Context paramContext)
  {
    this.jjD = new PopEmojiView(getContext());
    this.jjx = paramContext.getResources().getDimensionPixelSize(f.c.emoji_preview_image_size);
    this.jfe = ((WindowManager)paramContext.getSystemService("window"));
    this.jjw = new WindowManager.LayoutParams(-1, -1, 2, 8, 1);
    this.jjw.width = this.jjx;
    this.jjw.height = this.jjx;
    this.jjw.gravity = 17;
    this.adN = getResources().getConfiguration().orientation;
    if (this.adN == 2)
    {
      this.jjy = this.jfe.getDefaultDisplay().getHeight();
      this.jjz = this.jfe.getDefaultDisplay().getWidth();
      return;
    }
    this.jjy = this.jfe.getDefaultDisplay().getWidth();
    this.jjz = this.jfe.getDefaultDisplay().getHeight();
  }
  
  public final void aJJ()
  {
    if (this.jjA)
    {
      this.jfe.removeView(this.jjD);
      this.jjA = false;
    }
    this.jjC = "";
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    }
    do
    {
      return super.onInterceptTouchEvent(paramMotionEvent);
    } while (!this.jjA);
    aJJ();
    return true;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    super.setAdapter(paramListAdapter);
    this.jjE = ((d)paramListAdapter);
  }
  
  public void setEnablePreView(boolean paramBoolean)
  {
    this.jjq = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.PreViewListGridView
 * JD-Core Version:    0.7.0.1
 */