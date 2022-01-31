package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import com.tencent.mm.plugin.game.e.b;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.y;

public class GameBlockView
  extends LinearLayout
{
  LayoutInflater Lu;
  LinearLayout.LayoutParams kXB;
  k kXC;
  GameBlockView.a kXD;
  LinearLayout kjd;
  
  public GameBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    super.onFinishInflate();
    setOrientation(1);
    this.Lu = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.kXB = new LinearLayout.LayoutParams(-1, -2);
    this.kjd = this;
    this.kXC = new k();
    y.i("MicroMsg.GameBlockView", "initView finished");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView
 * JD-Core Version:    0.7.0.1
 */