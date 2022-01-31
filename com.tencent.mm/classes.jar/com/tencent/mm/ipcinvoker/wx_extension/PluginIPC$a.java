package com.tencent.mm.ipcinvoker.wx_extension;

import com.tencent.mm.ipcinvoker.h.a.a;
import com.tencent.mm.sdk.platformtools.y;

final class PluginIPC$a
  implements a
{
  static final a dHn = new a();
  
  public final void a(int paramInt, String paramString1, String paramString2, Object... paramVarArgs)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 2: 
      y.v(paramString1, paramString2, paramVarArgs);
      return;
    case 3: 
      y.d(paramString1, paramString2, paramVarArgs);
      return;
    case 4: 
      y.i(paramString1, paramString2, paramVarArgs);
      return;
    case 5: 
      y.w(paramString1, paramString2, paramVarArgs);
      return;
    case 6: 
      y.e(paramString1, paramString2, paramVarArgs);
      return;
    }
    y.e(paramString1, paramString2, paramVarArgs);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.ipcinvoker.wx_extension.PluginIPC.a
 * JD-Core Version:    0.7.0.1
 */