package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ui.w;

public class AAQueryListH5UrlFooterView
  extends LinearLayout
{
  private TextView gpt;
  
  public AAQueryListH5UrlFooterView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(40720);
    init(paramContext);
    AppMethodBeat.o(40720);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(40721);
    init(paramContext);
    AppMethodBeat.o(40721);
  }
  
  public AAQueryListH5UrlFooterView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    AppMethodBeat.i(40722);
    init(paramContext);
    AppMethodBeat.o(40722);
  }
  
  private void init(Context paramContext)
  {
    AppMethodBeat.i(40723);
    this.gpt = ((TextView)w.hM(paramContext).inflate(2130968580, this, true).findViewById(2131820909));
    AppMethodBeat.o(40723);
  }
  
  public TextView getBottomLinkTv()
  {
    return this.gpt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.aa.ui.AAQueryListH5UrlFooterView
 * JD-Core Version:    0.7.0.1
 */