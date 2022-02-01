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
  public PopupWindow oQQ;
  public a oQR;
  
  public d(Context paramContext, View paramView)
  {
    AppMethodBeat.i(181765);
    this.mParentView = paramView;
    paramContext = LayoutInflater.from(paramContext).inflate(2131493745, null);
    paramContext.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
    this.oQQ = new PopupWindow(paramContext, -2, -2, false);
    this.oQQ.setClippingEnabled(false);
    paramContext.findViewById(2131306977).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181761);
        d.this.oQQ.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.oQR != null) {
          d.this.oQR.bZc();
        }
        AppMethodBeat.o(181761);
      }
    });
    paramContext.findViewById(2131306974).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181762);
        d.this.oQQ.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.oQR != null) {
          d.this.oQR.bZd();
        }
        AppMethodBeat.o(181762);
      }
    });
    paramContext.findViewById(2131306976).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181763);
        d.this.oQQ.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.oQR != null) {
          d.this.oQR.bZe();
        }
        AppMethodBeat.o(181763);
      }
    });
    paramContext.findViewById(2131306985).setOnClickListener(new View.OnClickListener()
    {
      public final void onClick(View paramAnonymousView)
      {
        AppMethodBeat.i(181764);
        d.this.oQQ.dismiss();
        d.this.mParentView.setVisibility(8);
        if (d.this.oQR != null) {
          d.this.oQR.bZf();
        }
        AppMethodBeat.o(181764);
      }
    });
    AppMethodBeat.o(181765);
  }
  
  public static abstract interface a
  {
    public abstract void bZc();
    
    public abstract void bZd();
    
    public abstract void bZe();
    
    public abstract void bZf();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.editor.model.nativenote.manager.d
 * JD-Core Version:    0.7.0.1
 */