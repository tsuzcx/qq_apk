package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class IPCallAddressCountView
  extends FrameLayout
{
  private View gcq;
  private TextView nRK;
  
  private IPCallAddressCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(22045);
    init();
    AppMethodBeat.o(22045);
  }
  
  public IPCallAddressCountView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(22046);
    setAddressCount(paramInt);
    AppMethodBeat.o(22046);
  }
  
  public IPCallAddressCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(22044);
    init();
    AppMethodBeat.o(22044);
  }
  
  private void init()
  {
    AppMethodBeat.i(22047);
    inflate(getContext(), 2130969920, this);
    this.gcq = findViewById(2131823033);
    this.nRK = ((TextView)findViewById(2131823034));
    AppMethodBeat.o(22047);
  }
  
  public void setAddressCount(int paramInt)
  {
    AppMethodBeat.i(22048);
    this.nRK.setText(getContext().getResources().getQuantityString(2131361793, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(22048);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView
 * JD-Core Version:    0.7.0.1
 */