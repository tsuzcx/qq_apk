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
  private View ifK;
  private TextView tNm;
  
  private IPCallAddressCountView(Context paramContext)
  {
    super(paramContext);
    AppMethodBeat.i(25661);
    init();
    AppMethodBeat.o(25661);
  }
  
  public IPCallAddressCountView(Context paramContext, int paramInt)
  {
    this(paramContext);
    AppMethodBeat.i(25662);
    setAddressCount(paramInt);
    AppMethodBeat.o(25662);
  }
  
  public IPCallAddressCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    AppMethodBeat.i(25660);
    init();
    AppMethodBeat.o(25660);
  }
  
  private void init()
  {
    AppMethodBeat.i(25663);
    inflate(getContext(), 2131494498, this);
    this.ifK = findViewById(2131298592);
    this.tNm = ((TextView)findViewById(2131298591));
    AppMethodBeat.o(25663);
  }
  
  public void setAddressCount(int paramInt)
  {
    AppMethodBeat.i(25664);
    this.tNm.setText(getContext().getResources().getQuantityString(2131623937, paramInt, new Object[] { Integer.valueOf(paramInt) }));
    AppMethodBeat.o(25664);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView
 * JD-Core Version:    0.7.0.1
 */