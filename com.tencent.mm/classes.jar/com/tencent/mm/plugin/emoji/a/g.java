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
  private int otY = 0;
  private int otZ = 0;
  private int oua = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Ap(int paramInt)
  {
    this.otY = paramInt;
  }
  
  public final void Aq(int paramInt)
  {
    this.otZ = paramInt;
  }
  
  public final void Ar(int paramInt)
  {
    this.oua = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f As(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.As(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.otY > 0) {
      if (paramInt == 0)
      {
        locala.otx.setVisibility(0);
        locala.otx.setText(this.mContext.getString(2131758329));
      }
    }
    for (;;)
    {
      if (locala.otz != null) {
        locala.otz.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.otz.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.otZ > 0) && (paramInt == this.otY))
      {
        locala.otx.setVisibility(0);
        locala.otx.setText(this.mContext.getString(2131758350));
      }
      else if (paramInt == this.otY + this.otZ)
      {
        locala.otx.setVisibility(0);
        if (!bt.isNullOrNil(d.bUR().owV)) {
          locala.otx.setText(d.bUR().owV);
        } else if (d.bUR().owT) {
          locala.otx.setText(2131758349);
        } else {
          locala.otx.setText(this.mContext.getString(2131758309));
        }
      }
      else
      {
        locala.otx.setVisibility(8);
        continue;
        if (this.otZ > 0)
        {
          if (paramInt == 0)
          {
            locala.otx.setVisibility(0);
            locala.otx.setText(this.mContext.getString(2131758350));
          }
          else if (paramInt == this.otY + this.otZ)
          {
            locala.otx.setVisibility(0);
            if (!bt.isNullOrNil(d.bUR().owV)) {
              locala.otx.setText(d.bUR().owV);
            } else if (d.bUR().owT) {
              locala.otx.setText(2131758349);
            } else {
              locala.otx.setText(this.mContext.getString(2131758309));
            }
          }
          else
          {
            locala.otx.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.otx.setVisibility(0);
          if (!bt.isNullOrNil(d.bUR().owV)) {
            locala.otx.setText(d.bUR().owV);
          } else if (d.bUR().owT) {
            locala.otx.setText(2131758349);
          } else {
            locala.otx.setText(this.mContext.getString(2131758309));
          }
        }
        else
        {
          locala.otx.setVisibility(8);
        }
      }
    }
  }
  
  public final int bUr()
  {
    return this.otY;
  }
  
  public final int bUs()
  {
    return this.otZ;
  }
  
  public final int bUt()
  {
    return this.oua;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(108327);
    int i = super.getCount();
    AppMethodBeat.o(108327);
    return i;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */