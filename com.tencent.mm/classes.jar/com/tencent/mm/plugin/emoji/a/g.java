package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.bu;

public final class g
  extends f
{
  private int pHN = 0;
  private int pHO = 0;
  private int pHP = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Cb(int paramInt)
  {
    this.pHN = paramInt;
  }
  
  public final void Cc(int paramInt)
  {
    this.pHO = paramInt;
  }
  
  public final void Cd(int paramInt)
  {
    this.pHP = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f Ce(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.Ce(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.pHN > 0) {
      if (paramInt == 0)
      {
        locala.pHm.setVisibility(0);
        locala.pHm.setText(this.mContext.getString(2131758329));
      }
    }
    for (;;)
    {
      if (locala.pHo != null) {
        locala.pHo.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.pHo.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.pHO > 0) && (paramInt == this.pHN))
      {
        locala.pHm.setVisibility(0);
        locala.pHm.setText(this.mContext.getString(2131758350));
      }
      else if (paramInt == this.pHN + this.pHO)
      {
        locala.pHm.setVisibility(0);
        if (!bu.isNullOrNil(d.chY().pKJ)) {
          locala.pHm.setText(d.chY().pKJ);
        } else if (d.chY().pKH) {
          locala.pHm.setText(2131758349);
        } else {
          locala.pHm.setText(this.mContext.getString(2131758309));
        }
      }
      else
      {
        locala.pHm.setVisibility(8);
        continue;
        if (this.pHO > 0)
        {
          if (paramInt == 0)
          {
            locala.pHm.setVisibility(0);
            locala.pHm.setText(this.mContext.getString(2131758350));
          }
          else if (paramInt == this.pHN + this.pHO)
          {
            locala.pHm.setVisibility(0);
            if (!bu.isNullOrNil(d.chY().pKJ)) {
              locala.pHm.setText(d.chY().pKJ);
            } else if (d.chY().pKH) {
              locala.pHm.setText(2131758349);
            } else {
              locala.pHm.setText(this.mContext.getString(2131758309));
            }
          }
          else
          {
            locala.pHm.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.pHm.setVisibility(0);
          if (!bu.isNullOrNil(d.chY().pKJ)) {
            locala.pHm.setText(d.chY().pKJ);
          } else if (d.chY().pKH) {
            locala.pHm.setText(2131758349);
          } else {
            locala.pHm.setText(this.mContext.getString(2131758309));
          }
        }
        else
        {
          locala.pHm.setVisibility(8);
        }
      }
    }
  }
  
  public final int chA()
  {
    return this.pHP;
  }
  
  public final int chy()
  {
    return this.pHN;
  }
  
  public final int chz()
  {
    return this.pHO;
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