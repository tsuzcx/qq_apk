package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.e;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends f
{
  private int qXA = 0;
  private int qXB = 0;
  private int qXz = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void FK(int paramInt)
  {
    this.qXz = paramInt;
  }
  
  public final void FL(int paramInt)
  {
    this.qXA = paramInt;
  }
  
  public final void FM(int paramInt)
  {
    this.qXB = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f FN(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.FN(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.qXz > 0) {
      if (paramInt == 0)
      {
        locala.qWY.setVisibility(0);
        locala.qWY.setText(this.mContext.getString(2131758623));
      }
    }
    for (;;)
    {
      if (locala.qXa != null) {
        locala.qXa.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.qXa.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.qXA > 0) && (paramInt == this.qXz))
      {
        locala.qWY.setVisibility(0);
        locala.qWY.setText(this.mContext.getString(2131758644));
      }
      else if (paramInt == this.qXz + this.qXA)
      {
        locala.qWY.setVisibility(0);
        if (!Util.isNullOrNil(e.cFX().rbp)) {
          locala.qWY.setText(e.cFX().rbp);
        } else if (e.cFX().rbn) {
          locala.qWY.setText(2131758643);
        } else {
          locala.qWY.setText(this.mContext.getString(2131758603));
        }
      }
      else
      {
        locala.qWY.setVisibility(8);
        continue;
        if (this.qXA > 0)
        {
          if (paramInt == 0)
          {
            locala.qWY.setVisibility(0);
            locala.qWY.setText(this.mContext.getString(2131758644));
          }
          else if (paramInt == this.qXz + this.qXA)
          {
            locala.qWY.setVisibility(0);
            if (!Util.isNullOrNil(e.cFX().rbp)) {
              locala.qWY.setText(e.cFX().rbp);
            } else if (e.cFX().rbn) {
              locala.qWY.setText(2131758643);
            } else {
              locala.qWY.setText(this.mContext.getString(2131758603));
            }
          }
          else
          {
            locala.qWY.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.qWY.setVisibility(0);
          if (!Util.isNullOrNil(e.cFX().rbp)) {
            locala.qWY.setText(e.cFX().rbp);
          } else if (e.cFX().rbn) {
            locala.qWY.setText(2131758643);
          } else {
            locala.qWY.setText(this.mContext.getString(2131758603));
          }
        }
        else
        {
          locala.qWY.setVisibility(8);
        }
      }
    }
  }
  
  public final int cFk()
  {
    return this.qXz;
  }
  
  public final int cFl()
  {
    return this.qXA;
  }
  
  public final int cFm()
  {
    return this.qXB;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108327);
    int i = super.getCount();
    AppMethodBeat.o(108327);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */