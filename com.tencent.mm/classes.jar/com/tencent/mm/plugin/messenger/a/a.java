package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;

public abstract class a
  extends o
{
  private long vJd = -1L;
  
  public a()
  {
    super(1, null);
  }
  
  public void onClick(View paramView)
  {
    if (bt.aO(this.vJd) > 1000L)
    {
      super.onClick(paramView);
      onClickImp(paramView);
    }
    for (;;)
    {
      this.vJd = bt.HI();
      return;
      ad.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
  
  public abstract void onClickImp(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.a
 * JD-Core Version:    0.7.0.1
 */