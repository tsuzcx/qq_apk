package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.ab;

public class GameBlockView
  extends LinearLayout
{
  LinearLayout mDJ;
  LayoutInflater mInflater;
  LinearLayout.LayoutParams nvD;
  k nvE;
  GameBlockView.a nvF;
  
  public GameBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(111744);
    super.onFinishInflate();
    setOrientation(1);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.nvD = new LinearLayout.LayoutParams(-1, -2);
    this.mDJ = this;
    this.nvE = new k();
    ab.i("MicroMsg.GameBlockView", "initView finished");
    AppMethodBeat.o(111744);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView
 * JD-Core Version:    0.7.0.1
 */