package com.tencent.mm.bl;

import android.annotation.TargetApi;
import android.content.Context;
import android.view.OrientationEventListener;
import com.tencent.mm.sdk.platformtools.y;

@TargetApi(3)
public final class a
  extends OrientationEventListener
{
  private a.b eQA;
  private a.a eQy = a.a.eQB;
  private int eQz = 45;
  
  public a(Context paramContext, a.b paramb)
  {
    super(paramContext);
    this.eQA = paramb;
  }
  
  public final void disable()
  {
    super.disable();
    this.eQy = a.a.eQB;
  }
  
  public final void enable()
  {
    super.enable();
  }
  
  public final void onOrientationChanged(int paramInt)
  {
    if (paramInt == -1) {
      return;
    }
    a.a locala2 = this.eQy;
    a.a locala1;
    if (((paramInt >= 360 - this.eQz) && (paramInt < 360)) || ((paramInt >= 0) && (paramInt <= this.eQz + 0))) {
      locala1 = a.a.eQC;
    }
    for (;;)
    {
      if (locala1 != this.eQy)
      {
        if ((this.eQA != null) && (this.eQy != a.a.eQB)) {
          this.eQA.a(this.eQy, locala1);
        }
        this.eQy = locala1;
      }
      y.i("MicroMsg.OrientationListenerHelper", "OrientationListener onOrientationChanged:" + paramInt);
      return;
      if ((paramInt >= 270 - this.eQz) && (paramInt <= this.eQz + 270))
      {
        locala1 = a.a.eQD;
      }
      else if ((paramInt >= 180 - this.eQz) && (paramInt <= this.eQz + 180))
      {
        locala1 = a.a.eQE;
      }
      else
      {
        locala1 = locala2;
        if (paramInt >= 90 - this.eQz)
        {
          locala1 = locala2;
          if (paramInt <= this.eQz + 90) {
            locala1 = a.a.eQF;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.bl.a
 * JD-Core Version:    0.7.0.1
 */