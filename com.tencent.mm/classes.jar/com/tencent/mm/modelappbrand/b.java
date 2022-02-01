package com.tencent.mm.modelappbrand;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.app.AppForegroundDelegate;
import com.tencent.mm.autogen.a.zp;
import com.tencent.mm.autogen.a.zp.a;
import com.tencent.mm.message.a;
import com.tencent.mm.message.k.a;
import com.tencent.mm.message.k.b;
import com.tencent.mm.plugin.appbrand.api.j;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.WxaVersionInfo;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes.a;
import com.tencent.mm.plugin.appbrand.service.ab;
import com.tencent.mm.plugin.appbrand.service.g;
import com.tencent.mm.plugin.appbrand.service.s;
import com.tencent.mm.plugin.appbrand.service.y;
import com.tencent.mm.plugin.expt.b.c;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.au;
import com.tencent.threadpool.i;
import org.json.JSONException;
import org.json.JSONObject;

public final class b
{
  public static boolean KH(String paramString)
  {
    AppMethodBeat.i(2618);
    if (Util.isNullOrNil(paramString))
    {
      AppMethodBeat.o(2618);
      return false;
    }
    try
    {
      paramString = new JSONObject(paramString).optJSONObject("BindWxaInfo");
      if (paramString != null)
      {
        if (paramString.optInt("openWxaByBizQRCode", 0) > 0)
        {
          AppMethodBeat.o(2618);
          return true;
        }
        AppMethodBeat.o(2618);
        return false;
      }
    }
    catch (JSONException paramString)
    {
      AppMethodBeat.o(2618);
    }
    return false;
  }
  
  private static void a(zp paramzp, k.b paramb)
  {
    paramzp.icM.appId = paramb.nTE;
    paramzp.icM.userName = paramb.nTD;
    paramzp.icM.icO = paramb.nTC;
    paramzp.icM.icP = paramb.nTW;
    paramzp.icM.icS = paramb.nTG;
    paramzp.icM.appVersion = paramb.nTX;
    paramzp.icM.icV.opX = paramb.nTP;
    paramzp = paramzp.icM;
    if (paramb.nTW != 0) {}
    for (boolean bool = true;; bool = false)
    {
      paramzp.icT = bool;
      return;
    }
  }
  
  public static void a(String paramString, WxaAttributes paramWxaAttributes, final k.b paramb)
  {
    AppMethodBeat.i(233827);
    if (!TextUtils.isEmpty(paramString)) {}
    try
    {
      ((y)com.tencent.mm.kernel.h.ax(y.class)).VF(paramString);
      label26:
      com.tencent.threadpool.h.ahAA.bo(new Runnable()
      {
        public final void run()
        {
          AppMethodBeat.i(233818);
          if (AppForegroundDelegate.heY.eLx)
          {
            if (b.this != null)
            {
              try
              {
                if (b.this.cld().aqJ())
                {
                  ((g)com.tencent.mm.kernel.h.ax(g.class)).c(ab.tUe);
                  AppMethodBeat.o(233818);
                  return;
                }
                if (b.this.cld().clj())
                {
                  ((g)com.tencent.mm.kernel.h.ax(g.class)).a(ab.tUe);
                  AppMethodBeat.o(233818);
                  return;
                }
              }
              catch (Exception localException)
              {
                AppMethodBeat.o(233818);
                return;
              }
              ((g)com.tencent.mm.kernel.h.ax(g.class)).b(ab.tUe);
              AppMethodBeat.o(233818);
              return;
            }
            if (k.a.uB(paramb.nTK))
            {
              ((g)com.tencent.mm.kernel.h.ax(g.class)).a(ab.tUe);
              AppMethodBeat.o(233818);
              return;
            }
            ((g)com.tencent.mm.kernel.h.ax(g.class)).b(ab.tUe);
            ((g)com.tencent.mm.kernel.h.ax(g.class)).c(ab.tUe);
          }
          AppMethodBeat.o(233818);
        }
      });
      AppMethodBeat.o(233827);
      return;
    }
    catch (Exception paramString)
    {
      break label26;
    }
  }
  
  public static void a(String paramString1, String paramString2, int paramInt, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(233814);
    zp localzp = new zp();
    a(localzp, paramb);
    b(localzp, paramb);
    localzp.icM.scene = paramInt;
    int i;
    if (a(paramb, ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramb.nTD)))
    {
      i = 1;
      if (paramInt != 1074) {
        break label197;
      }
      paramString1 = String.format("%s:%s:%s:%s", new Object[] { paramString1, paramb.title, paramb.nTC, Integer.valueOf(i) });
      localzp.icM.hzx = paramString1;
      Log.d("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "sceneNote = %s", new Object[] { localzp.icM.hzx });
    }
    for (;;)
    {
      localzp.icM.hDf = paramBundle;
      localzp.icM.chatType = paramBundle.getInt("chat_type", -1);
      localzp.icM.icX = paramBundle.getString("chatroom_username", "");
      localzp.publish();
      AppMethodBeat.o(233814);
      return;
      i = 0;
      break;
      label197:
      if (paramInt == 1157)
      {
        String str = paramString2;
        if (paramString2 == null) {
          str = "";
        }
        paramString1 = String.format("%s:%s:%s:%s:%s", new Object[] { paramString1, paramb.title, str, paramb.nTC, Integer.valueOf(i) });
        localzp.icM.hzx = paramString1;
        Log.d("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "sceneNote = %s", new Object[] { localzp.icM.hzx });
      }
      else if (paramInt == 1073)
      {
        localzp.icM.hzx = String.valueOf(i);
      }
    }
  }
  
  public static void a(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    AppMethodBeat.i(2619);
    zp localzp = new zp();
    a(localzp, paramb);
    b(localzp, paramb);
    int j = paramBundle.getInt("chat_type", -1);
    if (au.bwQ(paramString1))
    {
      localzp.icM.scene = 1202;
      localzp.icM.hzx = (paramb.nTI + ":" + paramString1);
      localzp.icM.hDf = paramBundle;
      localzp.icM.chatType = j;
      localzp.icM.icX = paramBundle.getString("chatroom_username", "");
      localzp.publish();
      AppMethodBeat.o(2619);
      return;
    }
    zp.a locala = localzp.icM;
    if (paramBoolean)
    {
      i = 1008;
      label155:
      locala.scene = i;
      locala = localzp.icM;
      StringBuilder localStringBuilder = new StringBuilder().append(paramString1);
      if (!paramBoolean) {
        break label337;
      }
      paramString1 = ":".concat(String.valueOf(paramString2));
      label196:
      locala.hzx = (paramString1 + ":" + paramb.nTI + ":" + j);
      if (paramBundle == null) {
        break label343;
      }
      i = paramBundle.getInt("stat_scene", 0);
      label248:
      if ((i != 2) && (i != 1)) {
        break label347;
      }
      if (!a(paramb, ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramb.nTD))) {
        break label349;
      }
    }
    label337:
    label343:
    label347:
    label349:
    for (int i = 1;; i = 0)
    {
      paramString1 = new StringBuilder();
      paramString2 = localzp.icM;
      paramString2.hzx = (paramString2.hzx + ":" + i);
      break;
      i = 1007;
      break label155;
      paramString1 = "";
      break label196;
      i = 0;
      break label248;
      break;
    }
  }
  
  public static boolean a(k.b paramb, WxaAttributes paramWxaAttributes)
  {
    boolean bool2 = false;
    AppMethodBeat.i(233822);
    if (paramWxaAttributes == null)
    {
      paramb = (a)paramb.aK(a.class);
      if (paramb == null) {
        break label228;
      }
    }
    label228:
    for (boolean bool3 = vI(paramb.nOX);; bool3 = false)
    {
      Log.i("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "[wantShowRelievedBuyFlag] attrs is null, get showRelievedBuyFlag flag from AppContentAppBrandPiece showRelievedBuyFlag:%b", new Object[] { Boolean.valueOf(bool3) });
      for (;;)
      {
        boolean bool1 = bool2;
        if (((c)com.tencent.mm.kernel.h.ax(c.class)).a(c.a.znj, 0) == 1) {
          bool1 = true;
        }
        AppMethodBeat.o(233822);
        return bool3 & bool1;
        a locala = (a)paramb.aK(a.class);
        if ((paramWxaAttributes.clf() == null) || (paramb.nTX <= paramWxaAttributes.clf().appVersion) || (locala == null)) {
          break;
        }
        bool3 = vI(locala.nOX);
        Log.i("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "[wantShowRelievedBuyFlag] appbrandVersion:%d, appVersion:%d", new Object[] { Integer.valueOf(paramb.nTX), Integer.valueOf(paramWxaAttributes.clf().appVersion) });
        Log.i("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "[wantShowRelievedBuyFlag] use attrs:%b", new Object[] { Boolean.valueOf(bool3) });
      }
      if (paramWxaAttributes.cld() != null) {}
      for (int i = paramWxaAttributes.cld().nOX;; i = 0)
      {
        bool3 = vI(i);
        break;
      }
    }
  }
  
  private static void b(zp paramzp, k.b paramb)
  {
    AppMethodBeat.i(2622);
    if (paramb != null)
    {
      paramb = (a)paramb.aK(a.class);
      if ((paramb != null) && (!Util.isNullOrNil(paramb.nOZ))) {
        paramzp.icM.idf = paramb.nOZ;
      }
      if (paramb != null)
      {
        j localj = new j();
        localj.nPb = paramb.nPb;
        paramzp.icM.idg = localj.toJsonString();
      }
    }
    AppMethodBeat.o(2622);
  }
  
  public static void b(String paramString1, String paramString2, boolean paramBoolean, k.b paramb, Bundle paramBundle)
  {
    int j = 1;
    AppMethodBeat.i(2621);
    if (TextUtils.isEmpty(paramb.nTJ))
    {
      Log.e("MicroMsg.AppBrand.api-message.AppBrandCommonApi", "visitFromPageWithShareTicketAppMessage shareKey isEmpty, transform to normal visit, talkerUsername[%s] msgUsername[%s] groupChat[%b]", new Object[] { paramString1, paramString2, Boolean.valueOf(paramBoolean) });
      a(paramString1, paramString2, paramBoolean, paramb, paramBundle);
      AppMethodBeat.o(2621);
      return;
    }
    zp localzp = new zp();
    a(localzp, paramb);
    b(localzp, paramb);
    int k = paramBundle.getInt("chat_type", -1);
    if (au.bwQ(paramString1))
    {
      localzp.icM.scene = 1202;
      localzp.icM.hzx = (paramb.nTI + ":" + paramString1);
    }
    Object localObject;
    do
    {
      localObject = localzp.icM;
      i = j;
      if (paramBoolean) {
        i = 2;
      }
      ((zp.a)localObject).icZ = i;
      localObject = localzp.icM;
      if (paramBoolean) {
        paramString2 = paramString1;
      }
      ((zp.a)localObject).ida = paramString2;
      localzp.icM.icV.eoU = paramb.nTJ;
      localzp.icM.icV.eoT = paramString1;
      localzp.icM.chatType = k;
      localzp.icM.icX = paramBundle.getString("chatroom_username", "");
      localzp.icM.hDf = paramBundle;
      localzp.publish();
      AppMethodBeat.o(2621);
      return;
      localzp.icM.scene = 1044;
      localzp.icM.hzx = (paramb.nTI + ":" + k + ":" + paramString1);
      i = paramBundle.getInt("stat_scene", 0);
    } while ((i != 2) && (i != 1));
    if (a(paramb, ((s)com.tencent.mm.kernel.h.ax(s.class)).Xy(paramb.nTD))) {}
    for (int i = 1;; i = 0)
    {
      localObject = new StringBuilder();
      zp.a locala = localzp.icM;
      locala.hzx = (locala.hzx + ":" + i);
      break;
    }
  }
  
  public static boolean b(k.b paramb)
  {
    return ((paramb.type == 33) && ((paramb.nTF == 2) || (paramb.nTF == 3))) || (paramb.type == 36);
  }
  
  public static boolean c(k.b paramb)
  {
    return paramb.type == 44;
  }
  
  private static boolean vI(int paramInt)
  {
    return ((paramInt & 0x1) == 1) && ((paramInt >> 1 & 0x1) == 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.modelappbrand.b
 * JD-Core Version:    0.7.0.1
 */