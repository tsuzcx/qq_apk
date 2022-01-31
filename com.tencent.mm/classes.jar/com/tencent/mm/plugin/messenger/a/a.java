package com.tencent.mm.plugin.messenger.a;

import android.view.View;
import com.tencent.mm.pluginsdk.ui.d.n;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;

public abstract class a
  extends n
{
  private long oCV = -1L;
  
  public a()
  {
    super(1, null);
  }
  
  public void onClick(View paramView)
  {
    if (bo.av(this.oCV) > 1000L)
    {
      super.onClick(paramView);
      onClickImp(paramView);
    }
    for (;;)
    {
      this.oCV = bo.yB();
      return;
      ab.w("MicroMsg.AvoidDuplicatedPressableSpan", "hy: too often click");
      setIsPressed(false);
    }
  }
  
  public abstract void onClickImp(View paramView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.messenger.a.a
 * JD-Core Version:    0.7.0.1
 */