package com.tencent.mm.plugin.game.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.game.report.e;
import com.tencent.mm.plugin.game.f.c;
import com.tencent.mm.sdk.platformtools.ac;

public class GameBlockView
  extends LinearLayout
{
  LayoutInflater mInflater;
  LinearLayout qTW;
  LinearLayout.LayoutParams tna;
  k tnb;
  a tnc;
  
  public GameBlockView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  protected void onFinishInflate()
  {
    AppMethodBeat.i(41910);
    super.onFinishInflate();
    setOrientation(1);
    this.mInflater = ((LayoutInflater)getContext().getSystemService("layout_inflater"));
    this.tna = new LinearLayout.LayoutParams(-1, -2);
    this.qTW = this;
    this.tnb = new k();
    ac.i("MicroMsg.GameBlockView", "initView finished");
    AppMethodBeat.o(41910);
  }
  
  static final class a
  {
    public ImageView tmQ;
    public TextView tmR;
    public ViewGroup tnf;
    public TextView tng;
    public GameDownloadView tnh;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView
 * JD-Core Version:    0.7.0.1
 */