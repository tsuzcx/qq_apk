package com.miui.easygo.sdk.module;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;

public class EasyGoRet
{
  public int code;
  public Bundle result;
  
  public EasyGoRet(int paramInt, Bundle paramBundle)
  {
    AppMethodBeat.i(222766);
    AppMethodBeat.i("EasyGoRet".hashCode());
    this.code = 0;
    this.result = new Bundle();
    this.code = paramInt;
    this.result = paramBundle;
    AppMethodBeat.o("EasyGoRet".hashCode());
    AppMethodBeat.o(222766);
  }
  
  public EasyGoRet(com.miui.easygo.module.EasyGoRet paramEasyGoRet)
  {
    AppMethodBeat.i(222767);
    AppMethodBeat.i("EasyGoRet".hashCode());
    this.code = 0;
    this.result = new Bundle();
    if (paramEasyGoRet != null)
    {
      this.code = paramEasyGoRet.code;
      this.result = paramEasyGoRet.result;
    }
    AppMethodBeat.o("EasyGoRet".hashCode());
    AppMethodBeat.o(222767);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.miui.easygo.sdk.module.EasyGoRet
 * JD-Core Version:    0.7.0.1
 */