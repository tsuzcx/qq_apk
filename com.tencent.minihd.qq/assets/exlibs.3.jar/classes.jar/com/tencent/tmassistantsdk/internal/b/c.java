package com.tencent.tmassistantsdk.internal.b;

import com.tencent.assistant.sdk.remote.SDKActionCallback.Stub;
import com.tencent.tmassistant.d;
import com.tencent.tmassistantbase.a.k;
import java.util.ArrayList;

class c
  extends SDKActionCallback.Stub
{
  c(b paramb) {}
  
  public void onActionResult(byte[] paramArrayOfByte)
  {
    k.c("TMAssistantDownloadOpenSDKClient", "onActionResult  callBack data:" + paramArrayOfByte + "  mListeners.size:" + this.a.a.size());
    d.a().a(paramArrayOfByte, this.a.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.minihd.qq\assets\exlibs.3.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.internal.b.c
 * JD-Core Version:    0.7.0.1
 */