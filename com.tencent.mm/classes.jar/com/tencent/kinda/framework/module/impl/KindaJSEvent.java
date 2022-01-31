package com.tencent.kinda.framework.module.impl;

import com.tencent.kinda.gen.KJSEvent;
import com.tencent.kinda.gen.KindaJSEventType;
import com.tencent.kinda.gen.VoidCallback;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.HashMap;

public class KindaJSEvent
  implements KJSEvent
{
  public static String KindaClosed = "KindaClosed";
  public static String KindaClosedAnimated = "KindaClosedAnimated";
  public KindaJSEventType mEventType;
  public HashMap<String, String> mExtraInfo;
  public String mResult;
  
  public KindaJSEvent()
  {
    AppMethodBeat.i(144525);
    this.mEventType = KindaJSEventType.WEB;
    this.mExtraInfo = new KindaJSEvent.1(this);
    AppMethodBeat.o(144525);
  }
  
  public void kindaCloseWebViewImpl(boolean paramBoolean, VoidCallback paramVoidCallback)
  {
    AppMethodBeat.i(144526);
    HashMap localHashMap = this.mExtraInfo;
    String str2 = KindaClosedAnimated;
    if (paramBoolean) {}
    for (String str1 = "1";; str1 = "0")
    {
      localHashMap.put(str2, str1);
      if (paramVoidCallback != null) {
        paramVoidCallback.call();
      }
      AppMethodBeat.o(144526);
      return;
    }
  }
  
  public void kindaEndWithResult(String paramString, HashMap<String, String> paramHashMap)
  {
    this.mResult = paramString;
    this.mExtraInfo = paramHashMap;
  }
  
  public KindaJSEventType kindaGetType()
  {
    return this.mEventType;
  }
  
  public void setType(KindaJSEventType paramKindaJSEventType)
  {
    this.mEventType = paramKindaJSEventType;
  }
  
  public boolean shouldClosePage()
  {
    AppMethodBeat.i(144527);
    String str = (String)this.mExtraInfo.get(KindaClosed);
    if ((str != null) && (str == "1"))
    {
      AppMethodBeat.o(144527);
      return true;
    }
    AppMethodBeat.o(144527);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.kinda.framework.module.impl.KindaJSEvent
 * JD-Core Version:    0.7.0.1
 */