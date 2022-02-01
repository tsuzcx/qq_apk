package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.bs;

public final class g
  extends f
{
  private int oXA = 0;
  private int oXB = 0;
  private int oXz = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Bh(int paramInt)
  {
    this.oXz = paramInt;
  }
  
  public final void Bi(int paramInt)
  {
    this.oXA = paramInt;
  }
  
  public final void Bj(int paramInt)
  {
    this.oXB = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f Bk(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.Bk(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.oXz > 0) {
      if (paramInt == 0)
      {
        locala.oWY.setVisibility(0);
        locala.oWY.setText(this.mContext.getString(2131758329));
      }
    }
    for (;;)
    {
      if (locala.oXa != null) {
        locala.oXa.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.oXa.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.oXA > 0) && (paramInt == this.oXz))
      {
        locala.oWY.setVisibility(0);
        locala.oWY.setText(this.mContext.getString(2131758350));
      }
      else if (paramInt == this.oXz + this.oXA)
      {
        locala.oWY.setVisibility(0);
        if (!bs.isNullOrNil(d.cce().pav)) {
          locala.oWY.setText(d.cce().pav);
        } else if (d.cce().pat) {
          locala.oWY.setText(2131758349);
        } else {
          locala.oWY.setText(this.mContext.getString(2131758309));
        }
      }
      else
      {
        locala.oWY.setVisibility(8);
        continue;
        if (this.oXA > 0)
        {
          if (paramInt == 0)
          {
            locala.oWY.setVisibility(0);
            locala.oWY.setText(this.mContext.getString(2131758350));
          }
          else if (paramInt == this.oXz + this.oXA)
          {
            locala.oWY.setVisibility(0);
            if (!bs.isNullOrNil(d.cce().pav)) {
              locala.oWY.setText(d.cce().pav);
            } else if (d.cce().pat) {
              locala.oWY.setText(2131758349);
            } else {
              locala.oWY.setText(this.mContext.getString(2131758309));
            }
          }
          else
          {
            locala.oWY.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.oWY.setVisibility(0);
          if (!bs.isNullOrNil(d.cce().pav)) {
            locala.oWY.setText(d.cce().pav);
          } else if (d.cce().pat) {
            locala.oWY.setText(2131758349);
          } else {
            locala.oWY.setText(this.mContext.getString(2131758309));
          }
        }
        else
        {
          locala.oWY.setVisibility(8);
        }
      }
    }
  }
  
  public final int cbE()
  {
    return this.oXz;
  }
  
  public final int cbF()
  {
    return this.oXA;
  }
  
  public final int cbG()
  {
    return this.oXB;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108327);
    int i = super.getCount();
    AppMethodBeat.o(108327);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */