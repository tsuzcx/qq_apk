package com.tencent.liteav.audio.impl;

import android.telephony.PhoneStateListener;
import com.tencent.liteav.basic.log.TXCLog;

class c$1$1
  extends PhoneStateListener
{
  c$1$1(c.1 param1) {}
  
  public void onCallStateChanged(int paramInt, String paramString)
  {
    super.onCallStateChanged(paramInt, paramString);
    TXCLog.i("AudioCenter:TXCTelephonyMgr", "onCallStateChanged:" + paramInt);
    c.a(this.a.a, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.liteav.audio.impl.c.1.1
 * JD-Core Version:    0.7.0.1
 */