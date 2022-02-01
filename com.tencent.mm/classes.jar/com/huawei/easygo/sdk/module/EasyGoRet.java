package com.huawei.easygo.sdk.module;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EasyGoRet
{
  public int code;
  public Bundle result;
  
  public EasyGoRet(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(208248);
    this.code = 0;
    this.result = new Bundle();
    this.code = paramInt;
    this.result = paramBundle;
    AppMethodBeat.o(208248);
  }
  
  public EasyGoRet(com.huawei.easygo.module.EasyGoRet paramEasyGoRet)
  {
    AppMethodBeat.i(208247);
    this.code = 0;
    this.result = new Bundle();
    if (paramEasyGoRet != null)
    {
      this.code = paramEasyGoRet.code;
      this.result = paramEasyGoRet.result;
    }
    AppMethodBeat.o(208247);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.huawei.easygo.sdk.module.EasyGoRet
 * JD-Core Version:    0.7.0.1
 */