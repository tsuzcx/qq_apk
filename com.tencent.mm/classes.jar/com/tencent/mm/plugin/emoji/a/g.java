package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.f.h;
import com.tencent.mm.plugin.emoji.model.i;
import com.tencent.mm.storage.at;

public final class g
  extends f
{
  private int iVj = 0;
  private int iVk = 0;
  private int iVl = 0;
  
  public g(Context paramContext)
  {
    super(paramContext);
  }
  
  public final int aGQ()
  {
    return this.iVj;
  }
  
  public final int aGR()
  {
    return this.iVk;
  }
  
  public final int aGS()
  {
    return this.iVl;
  }
  
  protected final boolean aGU()
  {
    return i.getEmojiStorageMgr().cuS();
  }
  
  public final View b(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    f.a locala = (f.a)paramView.getTag();
    if (this.iVj > 0) {
      if (paramInt == 0)
      {
        locala.iUI.setVisibility(0);
        locala.iUI.setText(this.mContext.getString(f.h.emoji_store_hot));
      }
    }
    for (;;)
    {
      if (locala.iUK != null) {
        locala.iUK.postDelayed(new g.1(this, locala), 100L);
      }
      return super.b(paramInt, paramView, paramViewGroup);
      if ((this.iVk > 0) && (paramInt == this.iVj))
      {
        locala.iUI.setVisibility(0);
        locala.iUI.setText(this.mContext.getString(f.h.emoji_store_recent));
      }
      else if (paramInt == this.iVj + this.iVk)
      {
        locala.iUI.setVisibility(0);
        if (i.getEmojiStorageMgr().cuS()) {
          locala.iUI.setText(f.h.emoji_store_recenedownload);
        } else {
          locala.iUI.setText(this.mContext.getString(f.h.emoji_store_all));
        }
      }
      else
      {
        locala.iUI.setVisibility(8);
        continue;
        if (this.iVk > 0)
        {
          if (paramInt == 0)
          {
            locala.iUI.setVisibility(0);
            locala.iUI.setText(this.mContext.getString(f.h.emoji_store_recent));
          }
          else if (paramInt == this.iVj + this.iVk)
          {
            locala.iUI.setVisibility(0);
            if (i.getEmojiStorageMgr().cuS()) {
              locala.iUI.setText(f.h.emoji_store_recenedownload);
            } else {
              locala.iUI.setText(this.mContext.getString(f.h.emoji_store_all));
            }
          }
          else
          {
            locala.iUI.setVisibility(8);
          }
        }
        else if (paramInt == 0)
        {
          locala.iUI.setVisibility(0);
          if (i.getEmojiStorageMgr().cuS()) {
            locala.iUI.setText(f.h.emoji_store_recenedownload);
          } else {
            locala.iUI.setText(this.mContext.getString(f.h.emoji_store_all));
          }
        }
        else
        {
          locala.iUI.setVisibility(8);
        }
      }
    }
  }
  
  public final int getCount()
  {
    return super.getCount();
  }
  
  public final void pM(int paramInt)
  {
    this.iVj = paramInt;
  }
  
  public final void pN(int paramInt)
  {
    this.iVk = paramInt;
  }
  
  public final void pO(int paramInt)
  {
    this.iVl = paramInt;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.f pP(int paramInt)
  {
    return super.pP(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.a.g
 * JD-Core Version:    0.7.0.1
 */