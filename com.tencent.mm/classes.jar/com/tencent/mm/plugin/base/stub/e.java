package com.tencent.mm.plugin.base.stub;

import android.content.Context;
import android.content.Intent;
import android.content.pm.Signature;
import android.net.Uri;
import com.tencent.mm.a.g;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public final class e
{
  public static boolean a(Context paramContext, String[] paramArrayOfString1, String[] paramArrayOfString2)
  {
    if (paramContext == null)
    {
      y.e("MicroMsg.WXBizLogic", "context is null");
      return false;
    }
    String str1;
    if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0))
    {
      str1 = paramArrayOfString2[0];
      paramArrayOfString2 = g.o(com.tencent.mm.pluginsdk.model.app.p.bj(paramContext, paramArrayOfString2[0])[0].toByteArray());
    }
    for (;;)
    {
      y.i("MicroMsg.WXBizLogic", "openBusinessWebview packageName = %s, sig = %s", new Object[] { str1, paramArrayOfString2 });
      if ((paramArrayOfString1 == null) || (paramArrayOfString1.length < 3))
      {
        y.e("MicroMsg.WXBizLogic", "args is null");
        return false;
      }
      String str2 = paramArrayOfString1[0];
      if (bk.bl(str2))
      {
        y.e("MicroMsg.WXBizLogic", "appId is null");
        return false;
      }
      int i = bk.getInt(paramArrayOfString1[1], 0);
      if (i <= 0)
      {
        y.e("MicroMsg.WXBizLogic", "businessType(%d) invalid", new Object[] { Integer.valueOf(i) });
        return false;
      }
      Object localObject = bk.pm(paramArrayOfString1[2]);
      y.i("MicroMsg.WXBizLogic", "openBusinessWebview, appid = %s, businessType = %d, queryInfo = %s", new Object[] { str2, Integer.valueOf(i), localObject });
      paramArrayOfString1 = "";
      try
      {
        localObject = URLEncoder.encode(bk.pm((String)localObject), "UTF-8");
        paramArrayOfString1 = (String[])localObject;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        for (;;)
        {
          y.printErrStackTrace("MicroMsg.WXBizLogic", localUnsupportedEncodingException, "", new Object[0]);
        }
      }
      paramArrayOfString1 = String.format("weixin://dl/openbusinesswebview/link?appid=%s&type=%d&query=%s", new Object[] { str2, Integer.valueOf(i), paramArrayOfString1 });
      y.i("MicroMsg.WXBizLogic", "openBusinessWebview url format = %s", new Object[] { paramArrayOfString1 });
      localObject = new Intent(paramContext, WXBizEntryActivity.class);
      ((Intent)localObject).setData(Uri.parse(paramArrayOfString1));
      ((Intent)localObject).addFlags(268435456);
      ((Intent)localObject).putExtra("key_package_name", str1);
      ((Intent)localObject).putExtra("translate_link_scene", 1);
      ((Intent)localObject).putExtra("key_package_signature", paramArrayOfString2);
      ((Intent)localObject).putExtra("key_command_id", 25);
      paramContext.startActivity((Intent)localObject);
      return true;
      paramArrayOfString2 = null;
      str1 = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.base.stub.e
 * JD-Core Version:    0.7.0.1
 */