package com.tencent.mm.plugin.facedetect.c;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

final class d$2
  implements View.OnClickListener
{
  d$2(d paramd, boolean paramBoolean, int paramInt1, int paramInt2, String paramString, Bundle paramBundle) {}
  
  public final void onClick(View paramView)
  {
    if (this.jNt)
    {
      paramView = this.jNw;
      paramView.aNZ();
      paramView.iHI = true;
      return;
    }
    this.jNw.a(this.bEf, this.bEg, this.edL, this.jNu);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.facedetect.c.d.2
 * JD-Core Version:    0.7.0.1
 */