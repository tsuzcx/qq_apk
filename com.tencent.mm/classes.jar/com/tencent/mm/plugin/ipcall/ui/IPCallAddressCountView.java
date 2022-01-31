package com.tencent.mm.plugin.ipcall.ui;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;
import com.tencent.mm.R.j;

public class IPCallAddressCountView
  extends FrameLayout
{
  private View eML;
  private TextView lus;
  
  private IPCallAddressCountView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public IPCallAddressCountView(Context paramContext, int paramInt)
  {
    this(paramContext);
    setAddressCount(paramInt);
  }
  
  public IPCallAddressCountView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  private void init()
  {
    inflate(getContext(), R.i.ip_call_address_count_view, this);
    this.eML = findViewById(R.h.contact_count_view_fl);
    this.lus = ((TextView)findViewById(R.h.contact_count_tv));
  }
  
  public void setAddressCount(int paramInt)
  {
    this.lus.setText(getContext().getResources().getQuantityString(R.j.address_contact_count, paramInt, new Object[] { Integer.valueOf(paramInt) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.ipcall.ui.IPCallAddressCountView
 * JD-Core Version:    0.7.0.1
 */