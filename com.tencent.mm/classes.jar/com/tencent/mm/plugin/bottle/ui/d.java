package com.tencent.mm.plugin.bottle.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.mm.R.h;
import com.tencent.mm.R.i;

public final class d
  extends Toast
{
  Context context;
  private TextView flb;
  private View view;
  
  public d(Context paramContext)
  {
    super(paramContext);
    this.context = paramContext;
    this.view = ((LayoutInflater)paramContext.getSystemService("layout_inflater")).inflate(R.i.bottle_toast, null);
    this.flb = ((TextView)this.view.findViewById(R.h.bottle_toast_text));
    setGravity(17, 0, 0);
    setDuration(0);
    setView(this.view);
  }
  
  public final void setText(int paramInt)
  {
    setText(this.context.getString(paramInt));
  }
  
  public final void setText(CharSequence paramCharSequence)
  {
    this.flb.setText(paramCharSequence);
  }
  
  public final void show()
  {
    super.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.bottle.ui.d
 * JD-Core Version:    0.7.0.1
 */