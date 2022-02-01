package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.lifecycle.q;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.a.gj;
import com.tencent.mm.autogen.a.gj.a;
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

class WorkerProfile$17
  extends IListener<gj>
{
  WorkerProfile$17(WorkerProfile paramWorkerProfile, q paramq)
  {
    super(paramq);
    AppMethodBeat.i(239146);
    this.__eventId = gj.class.getName().hashCode();
    AppMethodBeat.o(239146);
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt, String paramString)
  {
    AppMethodBeat.i(239152);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
      localContext = MMApplicationContext.getContext();
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
      AppMethodBeat.o(239152);
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
      AppMethodBeat.o(239152);
      return false;
    case 1: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
        AppMethodBeat.o(239152);
        return false;
      }
      break;
    case 2: 
      if (Util.isNullOrNil(paramString))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[] { paramString });
        AppMethodBeat.o(239152);
        return false;
      }
      break;
    }
    Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[] { str1, str2, paramContext, paramString });
    if ((Util.isNullOrNil(str1)) || (Util.isNullOrNil(str2)))
    {
      Log.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
      AppMethodBeat.o(239152);
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
        break label474;
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
    label474:
    f.t(paramArrayOfString1, localContext);
    AppMethodBeat.o(239152);
    return true;
  }
  
  private static boolean a(gj paramgj)
  {
    AppMethodBeat.i(239149);
    if (paramgj == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
      AppMethodBeat.o(239149);
      return false;
    }
    if (!(paramgj instanceof gj))
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
      AppMethodBeat.o(239149);
      return false;
    }
    if (paramgj.hGv == null)
    {
      Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
      AppMethodBeat.o(239149);
      return false;
    }
    String str3;
    String str4;
    switch (paramgj.hGv.op)
    {
    default: 
      boolean bool = a(paramgj.hGv.context, paramgj.hGv.hyS, paramgj.hGv.hyR, paramgj.hGv.source, paramgj.hGv.hGw);
      AppMethodBeat.o(239149);
      return bool;
    case 27: 
      if ((paramgj.hGv.hyS == null) || (paramgj.hGv.hyS.length < 2))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
        AppMethodBeat.o(239149);
        return true;
      }
      str3 = paramgj.hGv.hyS[0];
      str4 = paramgj.hGv.hyS[1];
      if (paramgj.hGv.hyS.length < 3) {
        break;
      }
    }
    for (Object localObject = Util.nullAsNil(paramgj.hGv.hyS[2]);; localObject = "")
    {
      try
      {
        String str1 = URLEncoder.encode((String)localObject, "UTF-8");
        localObject = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label236:
        break label236;
      }
      if ((str3 == null) || (str4 == null))
      {
        Log.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[] { str3, str4 });
        AppMethodBeat.o(239149);
        return true;
      }
      String str2;
      if (paramgj.hGv.hyS.length >= 4)
      {
        str2 = paramgj.hGv.hyS[3];
        if (Util.isNullOrNil(str2)) {}
      }
      for (int i = Util.getInt(str2, 0);; i = 0)
      {
        Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
        str2 = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[] { str4, str3, localObject, Integer.valueOf(i), Integer.valueOf(0) });
        localObject = new Intent(paramgj.hGv.context, WXCustomSchemeEntryActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).setData(Uri.parse(str2));
        ((Intent)localObject).putExtra("translate_link_scene", 1);
        paramgj = paramgj.hGv.context;
        localObject = new com.tencent.mm.hellhoundlib.b.a().cG(localObject);
        com.tencent.mm.hellhoundlib.a.a.b(paramgj, ((com.tencent.mm.hellhoundlib.b.a)localObject).aYi(), "com/tencent/mm/app/WorkerProfile$17", "callback", "(Lcom/tencent/mm/autogen/events/ExtCallBizEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        paramgj.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject).sb(0));
        com.tencent.mm.hellhoundlib.a.a.c(paramgj, "com/tencent/mm/app/WorkerProfile$17", "callback", "(Lcom/tencent/mm/autogen/events/ExtCallBizEvent;)Z", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
        AppMethodBeat.o(239149);
        return true;
        Log.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
        paramgj = paramgj.hGv.context;
        localObject = new Intent(paramgj, WXBizEntryActivity.class);
        ((Intent)localObject).addFlags(268435456);
        ((Intent)localObject).putExtra("key_command_id", 11);
        f.t((Intent)localObject, paramgj);
        AppMethodBeat.o(239149);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.17
 * JD-Core Version:    0.7.0.1
 */