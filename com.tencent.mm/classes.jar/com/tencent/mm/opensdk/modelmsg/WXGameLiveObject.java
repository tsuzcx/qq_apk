package com.tencent.mm.opensdk.modelmsg;

import android.os.Bundle;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.opensdk.utils.b;
import java.util.HashMap;

public class WXGameLiveObject
  implements WXMediaMessage.IMediaObject
{
  private static final String TAG = "MicroMsg.SDK.WXGameObject";
  public HashMap<String, String> extraInfoMap;
  
  public WXGameLiveObject()
  {
    AppMethodBeat.i(242988);
    this.extraInfoMap = new HashMap();
    AppMethodBeat.o(242988);
  }
  
  public boolean checkArgs()
  {
    return true;
  }
  
  public String getExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(243003);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null)
    {
      paramString1 = (String)localHashMap.get(paramString1);
      if (paramString1 != null) {
        break label41;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(243003);
      return paramString2;
      AppMethodBeat.o(243003);
      return null;
      label41:
      paramString2 = paramString1;
    }
  }
  
  public void putExtra(String paramString1, String paramString2)
  {
    AppMethodBeat.i(242999);
    if (this.extraInfoMap == null) {
      this.extraInfoMap = new HashMap();
    }
    if (!b.b(paramString1)) {
      this.extraInfoMap.put(paramString1, paramString2);
    }
    AppMethodBeat.o(242999);
  }
  
  public void serialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242990);
    HashMap localHashMap = this.extraInfoMap;
    if (localHashMap != null) {
      paramBundle.putSerializable("_wxgame_extrainfo", localHashMap);
    }
    AppMethodBeat.o(242990);
  }
  
  public int type()
  {
    return 70;
  }
  
  public void unserialize(Bundle paramBundle)
  {
    AppMethodBeat.i(242993);
    this.extraInfoMap = ((HashMap)paramBundle.getSerializable("_wxgame_extrainfo"));
    AppMethodBeat.o(242993);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.opensdk.modelmsg.WXGameLiveObject
 * JD-Core Version:    0.7.0.1
 */