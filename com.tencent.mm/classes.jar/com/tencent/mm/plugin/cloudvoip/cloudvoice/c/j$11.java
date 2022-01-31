package com.tencent.mm.plugin.cloudvoip.cloudvoice.c;

import android.telephony.PhoneStateListener;

final class j$11
  extends PhoneStateListener
{
  j$11(j paramj) {}
  
  public final void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    switch (paramInt)
    {
    default: 
      return;
    }
    this.iFU.H(new j.11.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.cloudvoip.cloudvoice.c.j.11
 * JD-Core Version:    0.7.0.1
 */