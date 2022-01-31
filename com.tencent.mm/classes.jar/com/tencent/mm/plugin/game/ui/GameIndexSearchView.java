package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

public class GameIndexSearchView
  extends LinearLayout
{
  LayoutInflater Lu;
  private Context mContext;
  
  public GameIndexSearchView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    setOrientation(0);
    this.mContext = paramContext;
    this.Lu = ((LayoutInflater)this.mContext.getSystemService("layout_inflater"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameIndexSearchView
 * JD-Core Version:    0.7.0.1
 */