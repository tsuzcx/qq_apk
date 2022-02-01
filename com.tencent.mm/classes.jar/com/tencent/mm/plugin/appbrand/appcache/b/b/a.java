package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.protobuf.dwf;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct>
  implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>>
{
  private String bW(String paramString1, String paramString2)
  {
    String str = "PredownloadCmdSequence$" + aQI() + '$' + paramString1;
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + '$' + paramString2;
    }
    return paramString1;
  }
  
  abstract String aQI();
  
  abstract _Ret c(String paramString1, String paramString2, _CmdStruct param_CmdStruct);
  
  abstract dwf cj(_CmdStruct param_CmdStruct);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.a
 * JD-Core Version:    0.7.0.1
 */