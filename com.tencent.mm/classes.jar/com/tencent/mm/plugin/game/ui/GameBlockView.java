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
import com.tencent.mm.game.report.f;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.game.e.c;
import com.tencent.mm.sdk.platformtools.Log;

public class GameBlockView
  extends LinearLayout
{
  LayoutInflater mInflater;
  LinearLayout tmh;
  LinearLayout.LayoutParams xOV;
  k xOW;
  a xOX;
  
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
    this.xOV = new LinearLayout.LayoutParams(-1, -2);
    this.tmh = this;
    this.xOW = new k();
    Log.i("MicroMsg.GameBlockView", "initView finished");
    AppMethodBeat.o(41910);
  }
  
  static final class a
  {
    public ImageView xOL;
    public TextView xOM;
    public ViewGroup xPa;
    public TextView xPb;
    public GameDownloadView xPc;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView
 * JD-Core Version:    0.7.0.1
 */