package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.a.fd;
import com.tencent.mm.g.a.fd.a;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

final class WorkerProfile$8
  extends c<fd>
{
  WorkerProfile$8(WorkerProfile paramWorkerProfile)
  {
    AppMethodBeat.i(15477);
    this.__eventId = fd.class.getName().hashCode();
    AppMethodBeat.o(15477);
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt, String paramString)
  {
    AppMethodBeat.i(15479);
    Context localContext = paramContext;
    if (paramContext == null)
    {
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
      localContext = ah.getContext();
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
      AppMethodBeat.o(15479);
      return false;
    }
    int j = paramArrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      ab.i("MicroMsg.WorkerProfile", "arg : %s", new Object[] { paramArrayOfString1[i] });
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
      j = bo.getInt(paramArrayOfString1[3], 0);
    }
    int k = 0;
    if (paramArrayOfString1.length > 4) {
      k = bo.getInt(paramArrayOfString1[4], 0);
    }
    ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
      AppMethodBeat.o(15479);
      return false;
    case 1: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
        AppMethodBeat.o(15479);
        return false;
      }
      break;
    case 2: 
      if (bo.isNullOrNil(paramString))
      {
        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[] { paramString });
        AppMethodBeat.o(15479);
        return false;
      }
      break;
    }
    ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[] { str1, str2, paramContext, paramString });
    if ((bo.isNullOrNil(str1)) || (bo.isNullOrNil(str2)))
    {
      ab.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
      AppMethodBeat.o(15479);
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
    localContext.startActivity(paramArrayOfString1);
    AppMethodBeat.o(15479);
    return true;
  }
  
  private static boolean a(fd paramfd)
  {
    AppMethodBeat.i(15478);
    if (paramfd == null)
    {
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
      AppMethodBeat.o(15478);
      return false;
    }
    if (!(paramfd instanceof fd))
    {
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
      AppMethodBeat.o(15478);
      return false;
    }
    if (paramfd.csL == null)
    {
      ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
      AppMethodBeat.o(15478);
      return false;
    }
    String str2;
    String str3;
    switch (paramfd.csL.op)
    {
    default: 
      boolean bool = a(paramfd.csL.context, paramfd.csL.selectionArgs, paramfd.csL.cmj, paramfd.csL.cpt, paramfd.csL.csM);
      AppMethodBeat.o(15478);
      return bool;
    case 27: 
      if ((paramfd.csL.selectionArgs == null) || (paramfd.csL.selectionArgs.length < 2))
      {
        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
        AppMethodBeat.o(15478);
        return true;
      }
      str2 = paramfd.csL.selectionArgs[0];
      str3 = paramfd.csL.selectionArgs[1];
      if (paramfd.csL.selectionArgs.length < 3) {
        break;
      }
    }
    for (Object localObject1 = bo.nullAsNil(paramfd.csL.selectionArgs[2]);; localObject1 = "")
    {
      try
      {
        String str1 = URLEncoder.encode((String)localObject1, "UTF-8");
        localObject1 = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label242:
        break label242;
      }
      if ((str2 == null) || (str3 == null))
      {
        ab.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[] { str2, str3 });
        AppMethodBeat.o(15478);
        return true;
      }
      Object localObject2;
      if (paramfd.csL.selectionArgs.length >= 4)
      {
        localObject2 = paramfd.csL.selectionArgs[3];
        if (bo.isNullOrNil((String)localObject2)) {}
      }
      for (int i = bo.getInt((String)localObject2, 0);; i = 0)
      {
        ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
        localObject1 = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[] { str3, str2, localObject1, Integer.valueOf(i), Integer.valueOf(0) });
        localObject2 = new Intent(paramfd.csL.context, WXCustomSchemeEntryActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        ((Intent)localObject2).putExtra("translate_link_scene", 1);
        paramfd.csL.context.startActivity((Intent)localObject2);
        AppMethodBeat.o(15478);
        return true;
        ab.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
        paramfd = paramfd.csL.context;
        localObject1 = new Intent(paramfd, WXBizEntryActivity.class);
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("key_command_id", 11);
        paramfd.startActivity((Intent)localObject1);
        AppMethodBeat.o(15478);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.8
 * JD-Core Version:    0.7.0.1
 */