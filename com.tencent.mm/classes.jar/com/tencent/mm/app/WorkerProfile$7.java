package com.tencent.mm.app;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.mm.h.a.fa;
import com.tencent.mm.h.a.fa.a;
import com.tencent.mm.plugin.base.stub.WXBizEntryActivity;
import com.tencent.mm.plugin.base.stub.WXCustomSchemeEntryActivity;
import com.tencent.mm.sdk.b.c;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;

final class WorkerProfile$7
  extends c<fa>
{
  WorkerProfile$7(WorkerProfile paramWorkerProfile)
  {
    this.udX = fa.class.getName().hashCode();
  }
  
  private static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2, int paramInt, String paramString)
  {
    Context localContext = paramContext;
    if (paramContext == null)
    {
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:context is null.");
      localContext = ae.getContext();
    }
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 2))
    {
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:args error.");
      return false;
    }
    int j = paramArrayOfString1.length;
    int i = 0;
    while (i < j)
    {
      y.i("MicroMsg.WorkerProfile", "arg : %s", new Object[] { paramArrayOfString1[i] });
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
      j = bk.getInt(paramArrayOfString1[3], 0);
    }
    int k = 0;
    if (paramArrayOfString1.length > 4) {
      k = bk.getInt(paramArrayOfString1[4], 0);
    }
    y.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source(%d)", new Object[] { Integer.valueOf(paramInt) });
    switch (paramInt)
    {
    default: 
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:source is out of range.");
      return false;
    case 1: 
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length == 0))
      {
        y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:packageNames is null or nil.");
        return false;
      }
      break;
    case 2: 
      if (bk.bl(paramString))
      {
        y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:fromURL(%s) is null or nil.", new Object[] { paramString });
        return false;
      }
      break;
    }
    y.i("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener: appId(%s), toUserName(%s), extInfo(%s), fromURL(%s)", new Object[] { str1, str2, paramContext, paramString });
    if ((bk.bl(str1)) || (bk.bl(str2)))
    {
      y.e("MicroMsg.WorkerProfile", "appId or toUsername is null or nil.");
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
        break label446;
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
    label446:
    localContext.startActivity(paramArrayOfString1);
    return true;
  }
  
  private static boolean a(fa paramfa)
  {
    if (paramfa == null)
    {
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is null.");
      return false;
    }
    if (!(paramfa instanceof fa))
    {
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event is not a instance of ExtCallBizEvent.");
      return false;
    }
    if (paramfa.bLr == null)
    {
      y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent IListener:event.data is null.");
      return false;
    }
    String str2;
    String str3;
    switch (paramfa.bLr.op)
    {
    default: 
      return a(paramfa.bLr.context, paramfa.bLr.selectionArgs, paramfa.bLr.bEY, paramfa.bLr.source, paramfa.bLr.bLs);
    case 27: 
      if ((paramfa.bLr.selectionArgs == null) || (paramfa.bLr.selectionArgs.length < 2))
      {
        y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent selectionArgs error.");
        return true;
      }
      str2 = paramfa.bLr.selectionArgs[0];
      str3 = paramfa.bLr.selectionArgs[1];
      if (paramfa.bLr.selectionArgs.length < 3) {
        break;
      }
    }
    for (Object localObject1 = bk.pm(paramfa.bLr.selectionArgs[2]);; localObject1 = "")
    {
      try
      {
        String str1 = URLEncoder.encode((String)localObject1, "UTF-8");
        localObject1 = str1;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        label202:
        break label202;
      }
      if ((str2 == null) || (str3 == null))
      {
        y.e("MicroMsg.WorkerProfile", "ExtCallBizEvent wrong args, %s, %s", new Object[] { str2, str3 });
        return true;
      }
      Object localObject2;
      if (paramfa.bLr.selectionArgs.length >= 4)
      {
        localObject2 = paramfa.bLr.selectionArgs[3];
        if (bk.bl((String)localObject2)) {}
      }
      for (int i = bk.getInt((String)localObject2, 0);; i = 0)
      {
        y.i("MicroMsg.WorkerProfile", "ExtCallBizEvent jump biz tempSession");
        localObject1 = String.format("weixin://dl/business/tempsession/?username=%s&appid=%s&sessionFrom=%s&showtype=%s&scene=%s", new Object[] { str3, str2, localObject1, Integer.valueOf(i), Integer.valueOf(0) });
        localObject2 = new Intent(paramfa.bLr.context, WXCustomSchemeEntryActivity.class);
        ((Intent)localObject2).addFlags(268435456);
        ((Intent)localObject2).setData(Uri.parse((String)localObject1));
        ((Intent)localObject2).putExtra("translate_link_scene", 1);
        paramfa.bLr.context.startActivity((Intent)localObject2);
        return true;
        y.i("MicroMsg.WorkerProfile", "ExtCallBizEvent open exdevice rank list.");
        paramfa = paramfa.bLr.context;
        localObject1 = new Intent(paramfa, WXBizEntryActivity.class);
        ((Intent)localObject1).addFlags(268435456);
        ((Intent)localObject1).putExtra("key_command_id", 11);
        paramfa.startActivity((Intent)localObject1);
        return true;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.app.WorkerProfile.7
 * JD-Core Version:    0.7.0.1
 */