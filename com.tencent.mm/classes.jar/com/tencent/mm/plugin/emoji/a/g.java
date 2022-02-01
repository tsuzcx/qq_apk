package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.h.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends f
{
  private int xGQ = 0;
  private int xGR = 0;
  private int xGS = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void JZ(int paramInt)
  {
    this.xGQ = paramInt;
  }
  
  public final void Ka(int paramInt)
  {
    this.xGR = paramInt;
  }
  
  public final void Kb(int paramInt)
  {
    this.xGS = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f Kd(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.Kd(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.xGQ > 0) {
      if (paramInt == 0)
      {
        locala.xGp.setVisibility(0);
        locala.xGp.setText(getContext().getString(h.h.emoji_store_hot));
      }
    }
    for (;;)
    {
      if (locala.xGr != null) {
        locala.xGr.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.xGr.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.xGR > 0) && (paramInt == this.xGQ))
      {
        locala.xGp.setVisibility(0);
        locala.xGp.setText(getContext().getString(h.h.emoji_store_recent));
      }
      else if (paramInt == this.xGQ + this.xGR)
      {
        locala.xGp.setVisibility(0);
        if (!Util.isNullOrNil(j.dzN().xMK)) {
          locala.xGp.setText(j.dzN().xMK);
        } else if (j.dzN().xMI) {
          locala.xGp.setText(h.h.emoji_store_recenedownload);
        } else {
          locala.xGp.setText(getContext().getString(h.h.emoji_store_all));
        }
      }
      else
      {
        locala.xGp.setVisibility(8);
        continue;
        if (this.xGR > 0)
        {
          if (paramInt == 0)
          {
            locala.xGp.setVisibility(0);
            locala.xGp.setText(getContext().getString(h.h.emoji_store_recent));
          }
          else if (paramInt == this.xGQ + this.xGR)
          {
            locala.xGp.setVisibility(0);
            if (!Util.isNullOrNil(j.dzN().xMK)) {
              locala.xGp.setText(j.dzN().xMK);
            } else if (j.dzN().xMI) {
              locala.xGp.setText(h.h.emoji_store_recenedownload);
            } else {
              locala.xGp.setText(getContext().getString(h.h.emoji_store_all));
            }
          }
          else
          {
            locala.xGp.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.xGp.setVisibility(0);
          if (!Util.isNullOrNil(j.dzN().xMK)) {
            locala.xGp.setText(j.dzN().xMK);
          } else if (j.dzN().xMI) {
            locala.xGp.setText(h.h.emoji_store_recenedownload);
          } else {
            locala.xGp.setText(getContext().getString(h.h.emoji_store_all));
          }
        }
        else
        {
          locala.xGp.setVisibility(8);
        }
      }
    }
  }
  
  public final int dyh()
  {
    return this.xGQ;
  }
  
  public final int dyi()
  {
    return this.xGR;
  }
  
  public final int dyj()
  {
    return this.xGS;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108327);
    int i = super.getCount();
    AppMethodBeat.o(108327);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */