package com.tencent.mm.plugin.appbrand.appcache.b.b;

import android.text.TextUtils;
import com.tencent.mm.protocal.protobuf.ebw;
import com.tencent.mm.vending.j.d;

public abstract class a<_Ret, _CmdStruct>
  implements com.tencent.mm.vending.c.a<_Ret, d<String, String, _CmdStruct>>
{
  private String cf(String paramString1, String paramString2)
  {
    String str = "PredownloadCmdSequence$" + aXD() + '$' + paramString1;
    paramString1 = str;
    if (!TextUtils.isEmpty(paramString2)) {
      paramString1 = str + '$' + paramString2;
    }
    return paramString1;
  }
  
  abstract String aXD();
  
  abstract _Ret b(String paramString1, String paramString2, _CmdStruct param_CmdStruct);
  
  abstract ebw ch(_CmdStruct param_CmdStruct);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.appcache.b.b.a
 * JD-Core Version:    0.7.0.1
 */