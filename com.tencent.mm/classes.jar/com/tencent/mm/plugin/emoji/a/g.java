package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.at;

public final class g
  extends f
{
  private int leo = 0;
  private int lep = 0;
  private int leq = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(52752);
    f.a locala = (f.a)paramView.getTag();
    if (this.leo > 0) {
      if (paramInt == 0)
      {
        locala.ldM.setVisibility(0);
        locala.ldM.setText(this.mContext.getString(2131299203));
      }
    }
    for (;;)
    {
      if (locala.ldO != null) {
        locala.ldO.postDelayed(new g.1(this, locala), 100L);
      }
      paramView = super.b(paramInt, paramView, paramViewGroup);
      AppMethodBeat.o(52752);
      return paramView;
      if ((this.lep > 0) && (paramInt == this.leo))
      {
        locala.ldM.setVisibility(0);
        locala.ldM.setText(this.mContext.getString(2131299224));
      }
      else if (paramInt == this.leo + this.lep)
      {
        locala.ldM.setVisibility(0);
        if (i.getEmojiStorageMgr().dxv()) {
          locala.ldM.setText(2131299223);
        } else {
          locala.ldM.setText(this.mContext.getString(2131299183));
        }
      }
      else
      {
        locala.ldM.setVisibility(8);
        continue;
        if (this.lep > 0)
        {
          if (paramInt == 0)
          {
            locala.ldM.setVisibility(0);
            locala.ldM.setText(this.mContext.getString(2131299224));
          }
          else if (paramInt == this.leo + this.lep)
          {
            locala.ldM.setVisibility(0);
            if (i.getEmojiStorageMgr().dxv()) {
              locala.ldM.setText(2131299223);
            } else {
              locala.ldM.setText(this.mContext.getString(2131299183));
            }
          }
          else
          {
            locala.ldM.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.ldM.setVisibility(0);
          if (i.getEmojiStorageMgr().dxv()) {
            locala.ldM.setText(2131299223);
          } else {
            locala.ldM.setText(this.mContext.getString(2131299183));
          }
        }
        else
        {
          locala.ldM.setVisibility(8);
        }
      }
    }
  }
  
  public final int bkC()
  {
    return this.leo;
  }
  
  public final int bkD()
  {
    return this.lep;
  }
  
  public final int bkE()
  {
    return this.leq;
  }
  
  protected final boolean bkG()
  {
    AppMethodBeat.i(52754);
    boolean bool = i.getEmojiStorageMgr().dxv();
    AppMethodBeat.o(52754);
    return bool;
  }
  
  public final int getCount()
  {
    AppMethodBeat.i(52751);
    int i = super.getCount();
    AppMethodBeat.o(52751);
    return i;
  }
  
  public final void ug(int paramInt)
  {
    this.leo = paramInt;
  }
  
  public final void uh(int paramInt)
  {
    this.lep = paramInt;
  }
  
  public final void ui(int paramInt)
  {
    this.leq = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f uj(int paramInt)
  {
    AppMethodBeat.i(52753);
    com.tencent.mm.plugin.emoji.a.a.f localf = super.uj(paramInt);
    AppMethodBeat.o(52753);
    return localf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */