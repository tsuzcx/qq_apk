package com.tencent.mm.plugin.editor.model.nativenote.manager;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.matrix.trace.core.AppMethodBeat;

public final class d
{
  public View mParentView;
  public PopupWindow onq;
  public a onr;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131493745, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.onq = new PopupWindow(paramContext, -2, -2, false);
    this.onq.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        d.this.onq.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.onr != null) {
          d.this.onr.bRN();
        }
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        d.this.onq.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.onr != null) {
          d.this.onr.bRO();
        }
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        d.this.onq.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.onr != null) {
          d.this.onr.bRP();
        }
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        d.this.onq.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.onr != null) {
          d.this.onr.bRQ();
        }
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void bRN();
    
    public abstract void bRO();
    
    public abstract void bRP();
    
    public abstract void bRQ();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */