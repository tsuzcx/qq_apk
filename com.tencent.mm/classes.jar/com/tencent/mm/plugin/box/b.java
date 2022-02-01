package com.tencent.mm.plugin.box;

import android.content.Context;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.box.a.c;
import com.tencent.mm.plugin.box.c.a;
import com.tencent.mm.plugin.websearch.api.ai;
import com.tencent.mm.plugin.websearch.api.at;
import com.tencent.mm.protocal.protobuf.qt;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.LocaleUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import java.util.HashMap;
import java.util.UUID;

public final class b
  implements c
{
  public final void b(Context paramContext, String paramString, long paramLong)
  {
    AppMethodBeat.i(76317);
    String str = ai.afr(2).fYv();
    Log.i("MicroMsg.Box.BoxUILogic", "startBoxHomeUI type=%d query=%s messageSvrID=%d", new Object[] { Integer.valueOf(3), paramString, Long.valueOf(paramLong) });
    qt localqt = new qt();
    localqt.KXB = UUID.randomUUID().toString();
    localqt.KXA = paramString;
    localqt.oUv = 3;
    HashMap localHashMap = new HashMap();
    localHashMap.put("query", paramString);
    localHashMap.put("type", "3");
    localHashMap.put("messageSvrID", String.valueOf(paramLong));
    localHashMap.put("lang", LocaleUtil.getCurrentLanguage(MMApplicationContext.getContext()));
    localHashMap.put("platform", "android");
    localHashMap.put("version", String.valueOf(ai.aft(2)));
    localHashMap.put("netType", ai.ait());
    localHashMap.put("isClientLoading", "1");
    localHashMap.put("wechatVersion", BuildInfo.CLIENT_VERSION);
    paramString = new StringBuffer();
    paramString.append("file://");
    paramString.append(str);
    paramString.append("?");
    paramString.append(ai.toUrlParams(localHashMap));
    localqt.Url = paramString.toString();
    paramContext = new a(paramContext, localqt);
    paramContext.show();
    paramContext.getWindow().setLayout(-1, -1);
    AppMethodBeat.o(76317);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.box.b
 * JD-Core Version:    0.7.0.1
 */