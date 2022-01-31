package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.a.g;
import com.tencent.mm.aa.i;
import com.tencent.mm.model.v;
import com.tencent.mm.model.v.b;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.bo;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class e
{
  public static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(18159);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(18159);
      return false;
    }
    String str2 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    String str1 = str2;
    if (paramArrayOfString2 != null)
    {
      localObject1 = localObject2;
      str1 = str2;
      if (paramArrayOfString2.length > 0)
      {
        str1 = paramArrayOfString2[0];
        localObject1 = g.w(com.tencent.mm.pluginsdk.model.app.p.bv(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ab.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", new Object[] { str1, localObject1 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
    {
      ab.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(18159);
      return false;
    }
    str2 = paramArrayOfString1[0];
    if (bo.isNullOrNil(str2))
    {
      ab.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(18159);
      return false;
    }
    int i = bo.getInt(paramArrayOfString1[1], 0);
    if (i <= 0)
    {
      ab.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", new Object[] { Integer.valueOf(i) });
      AppMethodBeat.o(18159);
      return false;
    }
    paramArrayOfString2 = bo.nullAsNil(paramArrayOfString1[2]);
    ab.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString2 });
    paramArrayOfString1 = "";
    try
    {
      paramArrayOfString2 = URLEncoder.encode(bo.nullAsNil(paramArrayOfString2), "UTF-8");
      paramArrayOfString1 = paramArrayOfString2;
    }
    catch (UnsupportedEncodingException paramArrayOfString2)
    {
      for (;;)
      {
        ab.printErrStackTrace("MicroMsg.WXBizLogic", paramArrayOfString2, "", new Object[0]);
      }
    }
    paramArrayOfString1 = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString1 });
    ab.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", new Object[] { paramArrayOfString1 });
    paramArrayOfString2 = new Intent(paramContext, WXBizEntryActivity.class);
    paramArrayOfString2.setData(Uri.parse(paramArrayOfString1));
    paramArrayOfString2.addFlags(268435456);
    paramArrayOfString2.putExtra("key_package_name", str1);
    paramArrayOfString2.putExtra("key_app_id", str2);
    paramArrayOfString2.putExtra("translate_link_scene", 1);
    paramArrayOfString2.putExtra("key_package_signature", (String)localObject1);
    paramArrayOfString2.putExtra("key_command_id", 25);
    paramContext.startActivity(paramArrayOfString2);
    AppMethodBeat.o(18159);
    return true;
  }
  
  public static boolean b(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    AppMethodBeat.i(18160);
    if (paramContext == null)
    {
      ab.e("MicroMsg.WXBizLogic", "context is null");
      AppMethodBeat.o(18160);
      return false;
    }
    String str3 = null;
    String str4 = null;
    String str2 = str4;
    String str1 = str3;
    if (paramArrayOfString2 != null)
    {
      str2 = str4;
      str1 = str3;
      if (paramArrayOfString2.length > 0)
      {
        str1 = paramArrayOfString2[0];
        str2 = g.w(com.tencent.mm.pluginsdk.model.app.p.bv(paramContext, paramArrayOfString2[0])[0].toByteArray());
      }
    }
    ab.i("MicroMsg.WXBizLogic", "openBusinessView packageName = %s, sig = %s", new Object[] { str1, str2 });
    if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 4))
    {
      ab.e("MicroMsg.WXBizLogic", "args is null");
      AppMethodBeat.o(18160);
      return false;
    }
    str3 = paramArrayOfString1[0];
    if (bo.isNullOrNil(str3))
    {
      ab.e("MicroMsg.WXBizLogic", "appId is null");
      AppMethodBeat.o(18160);
      return false;
    }
    str4 = paramArrayOfString1[1];
    if (bo.isNullOrNil(str4))
    {
      ab.e("MicroMsg.WXBizLogic", "businessType isEmpty");
      AppMethodBeat.o(18160);
      return false;
    }
    paramArrayOfString2 = bo.nullAsNil(paramArrayOfString1[2]);
    String str5 = bo.nullAsNil(paramArrayOfString1[3]);
    boolean bool = str4.startsWith("native");
    if (bool)
    {
      paramArrayOfString1 = "openNativeView";
      paramArrayOfString1 = String.format("weixin://dl/%s/?appid=%s&businessType=%s", new Object[] { paramArrayOfString1, str3, str4 });
      ab.i("MicroMsg.WXBizLogic", "openBusinessView url format = %s,query=%s,extInfo=%s", new Object[] { paramArrayOfString1, paramArrayOfString2, str5 });
      if ((bool) || (bo.isNullOrNil(str5))) {
        break label455;
      }
    }
    for (;;)
    {
      try
      {
        int j = new i(str5).optInt("miniProgramType", 0);
        if (j >= 0)
        {
          i = j;
          if (j <= 2) {}
        }
        else
        {
          i = 0;
        }
        Intent localIntent = new Intent(paramContext, WXBizEntryActivity.class);
        localIntent.setData(Uri.parse(paramArrayOfString1));
        localIntent.addFlags(268435456);
        localIntent.putExtra("key_package_name", str1);
        localIntent.putExtra("key_app_id", str3);
        localIntent.putExtra("key_business_type", str4);
        localIntent.putExtra("translate_link_scene", 1);
        localIntent.putExtra("key_package_signature", str2);
        localIntent.putExtra("key_command_id", 26);
        paramContext.startActivity(localIntent);
        paramContext = v.aae().z("key_data_center_session_id", true);
        paramContext.i("key_launch_miniprogram_type", Integer.valueOf(i));
        paramContext.i("key_launch_miniprogram_query_info", paramArrayOfString2);
        paramContext.i("key_open_business_view_ext_info", str5);
        AppMethodBeat.o(18160);
        return true;
      }
      catch (Exception localException) {}
      paramArrayOfString1 = "jumpFakeWxa";
      break;
      label455:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.e
 * JD-Core Version:    0.7.0.1
 */