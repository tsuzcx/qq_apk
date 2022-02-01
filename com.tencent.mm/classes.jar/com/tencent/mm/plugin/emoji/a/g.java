package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.i.h;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.sdk.platformtools.Util;

public final class g
  extends f
{
  private int uAn = 0;
  private int uAo = 0;
  private int uAp = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final void Js(int paramInt)
  {
    this.uAn = paramInt;
  }
  
  public final void Jt(int paramInt)
  {
    this.uAo = paramInt;
  }
  
  public final void Ju(int paramInt)
  {
    this.uAp = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f Jv(int paramInt)
  {
    AppMethodBeat.i(108329);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.Jv(paramInt);
    AppMethodBeat.o(108329);
    return localf;
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(108328);
    final f.a locala = (f.a)paramView.getTag();
    if (this.uAn > 0) {
      if (paramInt == 0)
      {
        locala.uzM.setVisibility(0);
        locala.uzM.setText(getContext().getString(i.h.emoji_store_hot));
      }
    }
    for (;;)
    {
      if (locala.uzO != null) {
        locala.uzO.postDelayed(new Runnable()
        {
          public final void run()
          {
            AppMethodBeat.i(108326);
            locala.uzO.setPressed(false);
            AppMethodBeat.o(108326);
          }
        }, 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(108328);
      return paramView;
      if ((this.uAo > 0) && (paramInt == this.uAn))
      {
        locala.uzM.setVisibility(0);
        locala.uzM.setText(getContext().getString(i.h.emoji_store_recent));
      }
      else if (paramInt == this.uAn + this.uAo)
      {
        locala.uzM.setVisibility(0);
        if (!Util.isNullOrNil(j.cUG().uEt)) {
          locala.uzM.setText(j.cUG().uEt);
        } else if (j.cUG().uEr) {
          locala.uzM.setText(i.h.emoji_store_recenedownload);
        } else {
          locala.uzM.setText(getContext().getString(i.h.emoji_store_all));
        }
      }
      else
      {
        locala.uzM.setVisibility(8);
        continue;
        if (this.uAo > 0)
        {
          if (paramInt == 0)
          {
            locala.uzM.setVisibility(0);
            locala.uzM.setText(getContext().getString(i.h.emoji_store_recent));
          }
          else if (paramInt == this.uAn + this.uAo)
          {
            locala.uzM.setVisibility(0);
            if (!Util.isNullOrNil(j.cUG().uEt)) {
              locala.uzM.setText(j.cUG().uEt);
            } else if (j.cUG().uEr) {
              locala.uzM.setText(i.h.emoji_store_recenedownload);
            } else {
              locala.uzM.setText(getContext().getString(i.h.emoji_store_all));
            }
          }
          else
          {
            locala.uzM.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.uzM.setVisibility(0);
          if (!Util.isNullOrNil(j.cUG().uEt)) {
            locala.uzM.setText(j.cUG().uEt);
          } else if (j.cUG().uEr) {
            locala.uzM.setText(i.h.emoji_store_recenedownload);
          } else {
            locala.uzM.setText(getContext().getString(i.h.emoji_store_all));
          }
        }
        else
        {
          locala.uzM.setVisibility(8);
        }
      }
    }
  }
  
  public final int cTM()
  {
    return this.uAn;
  }
  
  public final int cTN()
  {
    return this.uAo;
  }
  
  public final int cTO()
  {
    return this.uAp;
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