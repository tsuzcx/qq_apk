package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fr;
import com.tencent.mm.g.a.fr.a;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.plugin.base.stub.f;
import com.tencent.mm.sdk.event.IListener;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

final class WorkerProfile$8
  extends IListener<fr>
{
  WorkerProfile$8(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(161238);
    this.__eventId = fr.class.getName().hashCode();
    AppMethodBeat.o(161238);
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt, String paramString)
  {
    AppMethodBeat.i(19550);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
      localContext = MMApplicationContext.getContext();
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
      AppMethodBeat.o(19550);
      return false;
    }
    int j = paramArrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      Log.i("MicroMsg.WorkerProfile", "arg : %s", new Object[] { paramArrayOfString1[i] });
      i += 1;
    }
    String str1 = paramArrayOfString1[0];
    String str2 = paramArrayOfString1[1];
    paramContext = null;
    if (paramArrayOfString1.length > 2) {
      paramContext = paramArrayOfString1[2];
    }
    j = 0;
    if (paramArrayOfString1.length > 3) {
      j = Util.getInt(paramArrayOfString1[3], 0);
    }
    int k = 0;
    if (paramArrayOfString1.length > 4) {
      k = Util.getInt(paramArrayOfString1[4], 0);
    }
    Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
      AppMethodBeat.o(19550);
      return false;
    case 1: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
        AppMethodBeat.o(19550);
        return false;
      }
      break;
    case 2: 
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[] { paramString });
        AppMethodBeat.o(19550);
        return false;
      }
      break;
    }
    Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[] { str1, str2, paramContext, paramString });
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      Log.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
      AppMethodBeat.o(19550);
      return false;
    }
    i = 0;
    if (j == 1) {
      i = 8;
    }
    for (;;)
    {
      paramArrayOfString1 = new Intent(localContext, WXBizEntryActivity.class);
      paramArrayOfString1.putExtra("key_command_id", i);
      paramArrayOfString1.putExtra("appId", str1);
      paramArrayOfString1.putExtra("toUserName", str2);
      paramArrayOfString1.putExtra("extInfo", paramContext);
      paramArrayOfString1.putExtra("source", paramInt);
      paramArrayOfString1.putExtra("scene", j);
      paramArrayOfString1.putExtra("jump_profile_type", k);
      paramArrayOfString1.addFlags(268435456).addFlags(67108864);
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0)) {
        break label482;
      }
      paramContext = new ArrayList();
      paramInt = 0;
      while (paramInt < paramArrayOfString2.length)
      {
        paramContext.add(paramArrayOfString2[paramInt]);
        paramInt += 1;
      }
      if (j == 0) {
        i = 7;
      }
    }
    paramArrayOfString1.putStringArrayListExtra("androidPackNameList", paramContext);
    label482:
    f.u(paramArrayOfString1, localContext);
    AppMethodBeat.o(19550);
    return true;
  }
  
  private static boolean a(fr paramfr)
  {
    AppMethodBeat.i(19549);
    if (paramfr == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
      AppMethodBeat.o(19549);
      return false;
    }
    if (!(paramfr instanceof fr))
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
      AppMethodBeat.o(19549);
      return false;
    }
    if (paramfr.dIP == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
      AppMethodBeat.o(19549);
      return false;
    }
    String str3;
    String str4;
    switch (paramfr.dIP.op)
    {
    default: 
      boolean bool = a(paramfr.dIP.context, paramfr.dIP.selectionArgs, paramfr.dIP.dBX, paramfr.dIP.source, paramfr.dIP.dIQ);
      AppMethodBeat.o(19549);
      return bool;
    case 27: 
      if ((paramfr.dIP.selectionArgs == null) || (paramfr.dIP.selectionArgs.length < 2))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
        AppMethodBeat.o(19549);
        return true;
      }
      str3 = paramfr.dIP.selectionArgs[0];
      str4 = paramfr.dIP.selectionArgs[1];
      if (paramfr.dIP.selectionArgs.length < 3) {
        break;
      }
    }
    for (Object localObject = Util.nullAsNil(paramfr.dIP.selectionArgs[2]);; localObject = "")
    {
      try
      {
        String str1 = URLEncoder.encode((String)localObject, "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label242:
        break label242;
      }
      if ((str3 == null) || (str4 == null))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[] { str3, str4 });
        AppMethodBeat.o(19549);
        return true;
      }
      String str2;
      if (paramfr.dIP.selectionArgs.length >= 4)
      {
        str2 = paramfr.dIP.selectionArgs[3];
        if (Util.isNullOrNil(str2)) {}
      }
      for (int i = Util.getInt(str2, 0);; i = 0)
      {
        Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
        str2 = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[] { str4, str3, localObject, Integer.valueOf(i), Integer.valueOf(0) });
        localObject = new Intent(paramfr.dIP.context, WXCustomSchemeEntryActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setData(Uri.parse(str2));
        ((Intent)localObject).putExtra("translate_link_scene", 1);
        paramfr = paramfr.dIP.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().bl(localObject);
        com.tencent.mm.hellhoundlib.a.a.a(paramfr, ((com.tencent.mm.hellhoundlib.b.a)localObject).axQ(), "com/tencent/mm/app/WorkerProfile$16", "callback", "(Lcom/tencent/mm/autogen/events/ExtCallBizEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramfr.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).pG(0));
        com.tencent.mm.hellhoundlib.a.a.a(paramfr, "com/tencent/mm/app/WorkerProfile$16", "callback", "(Lcom/tencent/mm/autogen/events/ExtCallBizEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(19549);
        return true;
        Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
        paramfr = paramfr.dIP.context;
        localObject = new Intent(paramfr, WXBizEntryActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("key_command_id", 11);
        f.u((Intent)localObject, paramfr);
        AppMethodBeat.o(19549);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.8
 * JD-Core Version:    0.7.0.1
 */