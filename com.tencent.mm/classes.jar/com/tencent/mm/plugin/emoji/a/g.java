package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.sdk.platformtools.bt;

public final class g
  extends f
{
  private int pBj = 0;
  private int pBk = 0;
  private int pBl = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void BP(int paramInt)
  {
    this.pBj = paramInt;
  }
  
  public final void BQ(int paramInt)
  {
    this.pBk = paramInt;
  }
  
  public final void BR(int paramInt)
  {
    this.pBl = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f BS(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.BS(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.pBj > 0) {
      if (paramInt == 0)
      {
        locala.pAI.setVisibility(0);
        locala.pAI.setText(this.mContext.getString(2131758329));
      }
    }
    for (;;)
    {
      if (locala.pAK != null) {
        locala.pAK.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.pAK.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.pBk > 0) && (paramInt == this.pBj))
      {
        locala.pAI.setVisibility(0);
        locala.pAI.setText(this.mContext.getString(2131758350));
      }
      else if (paramInt == this.pBj + this.pBk)
      {
        locala.pAI.setVisibility(0);
        if (!bt.isNullOrNil(d.cgI().pEf)) {
          locala.pAI.setText(d.cgI().pEf);
        } else if (d.cgI().pEd) {
          locala.pAI.setText(2131758349);
        } else {
          locala.pAI.setText(this.mContext.getString(2131758309));
        }
      }
      else
      {
        locala.pAI.setVisibility(8);
        continue;
        if (this.pBk > 0)
        {
          if (paramInt == 0)
          {
            locala.pAI.setVisibility(0);
            locala.pAI.setText(this.mContext.getString(2131758350));
          }
          else if (paramInt == this.pBj + this.pBk)
          {
            locala.pAI.setVisibility(0);
            if (!bt.isNullOrNil(d.cgI().pEf)) {
              locala.pAI.setText(d.cgI().pEf);
            } else if (d.cgI().pEd) {
              locala.pAI.setText(2131758349);
            } else {
              locala.pAI.setText(this.mContext.getString(2131758309));
            }
          }
          else
          {
            locala.pAI.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.pAI.setVisibility(0);
          if (!bt.isNullOrNil(d.cgI().pEf)) {
            locala.pAI.setText(d.cgI().pEf);
          } else if (d.cgI().pEd) {
            locala.pAI.setText(2131758349);
          } else {
            locala.pAI.setText(this.mContext.getString(2131758309));
          }
        }
        else
        {
          locala.pAI.setVisibility(8);
        }
      }
    }
  }
  
  public final int cgi()
  {
    return this.pBj;
  }
  
  public final int cgj()
  {
    return this.pBk;
  }
  
  public final int cgk()
  {
    return this.pBl;
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