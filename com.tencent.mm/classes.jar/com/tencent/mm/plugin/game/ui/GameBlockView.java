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
import com.tencent.mm.sdk.platformtools.ad;

public class GameBlockView
  extends LinearLayout
{
  LayoutInflater mInflater;
  LinearLayout qlu;
  LinearLayout.LayoutParams sfh;
  k sfi;
  a sfj;
  
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
    this.sfh = new LinearLayout.LayoutParams(-1, -2);
    this.qlu = this;
    this.sfi = new k();
    ad.i("MicroMsg.GameBlockView", "initView finished");
    AppMethodBeat.o(41910);
  }
  
  static final class a
  {
    public ImageView seX;
    public TextView seY;
    public ViewGroup sfm;
    public TextView sfn;
    public GameDownloadView sfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.game.ui.GameBlockView
 * JD-Core Version:    0.7.0.1
 */