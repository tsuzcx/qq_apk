package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Looper;
import com.tencent.mm.h.a.fn;
import com.tencent.mm.h.a.fn.b;
import com.tencent.mm.h.a.re;
import com.tencent.mm.h.c.ao;
import com.tencent.mm.model.au;
import com.tencent.mm.model.q;
import com.tencent.mm.modelvoice.i;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.c.b.b;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bk;
import com.tencent.mm.sdk.platformtools.y;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bo;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;

public class ExtControlProviderOpenApi
  extends ExtContentProviderBase
{
  public static boolean jJO = false;
  private static final String[] jJP = { "retCode", "selfId" };
  private static final String[] jJQ = { "retCode", "sportConfig" };
  private static final String[] jJR = { "openid", "avatar" };
  private static final String[] jJS = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] jJT = { "ssid", "macAddress", "isSupportWechat", "name" };
  private Context context;
  private ah handler;
  private String[] jJU = null;
  private int jJV = -1;
  
  public ExtControlProviderOpenApi() {}
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.jJU = paramArrayOfString;
    this.jJV = paramInt;
    this.context = paramContext;
  }
  
  private Cursor L(String paramString1, String paramString2, String paramString3)
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((bk.bl(paramString1)) || (bk.bl(paramString2)) || (bk.bl(paramString3)))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      cL(3, 2004);
      return com.tencent.mm.pluginsdk.d.a.a.DA(2004);
    }
    Object localObject = null;
    try
    {
      int i = Integer.parseInt(paramString3);
      int j = Integer.parseInt(paramString1);
      int k = Integer.parseInt(paramString2);
      if (i != 2)
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: " + i);
        cL(3, 2005);
        return com.tencent.mm.pluginsdk.d.a.a.DA(2005);
      }
      if (b.aNp().acj(this.jKd) == null)
      {
        paramString1 = new bo();
        paramString1.field_appId = this.jKd;
        paramString1.field_packageName = aNA();
        paramString2 = this.jKd;
        boolean bool;
        if (bk.bl(paramString2))
        {
          bool = false;
          if (!bool) {
            break label305;
          }
        }
        label305:
        for (paramString1.field_status = 1;; paramString1.field_status = 0)
        {
          paramString1.field_sceneFlag = j;
          paramString1.field_msgTypeFlag = k;
          paramString1.field_msgState = i;
          bool = b.aNp().b(paramString1);
          y.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), aNA(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label382;
          }
          return com.tencent.mm.pluginsdk.d.a.a.DA(2006);
          bool = com.tencent.mm.pluginsdk.model.app.g.i(com.tencent.mm.pluginsdk.model.app.g.by(paramString2, true));
          break;
        }
        G(1, 4, 12);
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = localObject;
    }
    for (;;)
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      return com.tencent.mm.pluginsdk.d.a.a.DA(12);
      y.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.jKd, aNA() });
      label382:
      paramString1 = new StringBuilder().append(q.Gj());
      au.Hx();
      paramString1 = com.tencent.mm.sdk.platformtools.ad.bB(com.tencent.mm.model.c.CK());
      paramString2 = new MatrixCursor(jJP);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), bk.pm(paramString1) });
        G(0, 0, 1);
        y.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
        return paramString2;
      }
      catch (Exception paramString1) {}
    }
  }
  
  private void aNx()
  {
    String str1 = (String)b.aNo().get(ac.a.uto, null);
    String str2 = aNA();
    y.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.a(str1.split(";"), str2)) {
        b.aNo().c(ac.a.uto, str1 + ";" + aNA());
      }
      return;
    }
    b.aNo().c(ac.a.uto, aNA());
  }
  
  private Cursor k(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    int i = -1;
    y.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      cL(4, 2001);
      return com.tencent.mm.pluginsdk.d.a.a.DA(2001);
    }
    if (bk.bl(paramString1))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      cL(3, 2002);
      return com.tencent.mm.pluginsdk.d.a.a.DA(2002);
    }
    try
    {
      int j = bk.getInt(paramString1, -1);
      i = j;
    }
    catch (Exception paramString1)
    {
      label90:
      boolean bool;
      break label90;
    }
    if (i == 1) {
      return L(paramString2, paramString3, paramString4);
    }
    if (i == 2)
    {
      y.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (b.aNp().acj(this.jKd) == null)
      {
        y.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.jKd, aNA() });
        return com.tencent.mm.pluginsdk.d.a.a.DA(2007);
      }
      paramString1 = b.aNp();
      paramString2 = this.jKd;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.jKd, aNA() });
        if (bool) {
          break;
        }
        return com.tencent.mm.pluginsdk.d.a.a.DA(2008);
        if (paramString1.dXw.delete("OpenMsgListener", "appId=?", new String[] { bk.pl(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      G(0, 0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    }
    y.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    cL(3, 2003);
    return com.tencent.mm.pluginsdk.d.a.a.DA(2003);
  }
  
  private Cursor l(String[] paramArrayOfString)
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      cL(3, 3001);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3001);
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(jJR);
    int i = 0;
    for (;;)
    {
      com.tencent.mm.storage.ad localad;
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label362;
        }
        if (bk.bl(paramArrayOfString[i])) {
          break label376;
        }
        localObject = b.aNq().acu(paramArrayOfString[i]);
        if ((localObject == null) || (bk.bl(((bz)localObject).field_openId)) || (bk.bl(((bz)localObject).field_username)))
        {
          y.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          au.Hx();
          localad = com.tencent.mm.model.c.Fw().abl(((bz)localObject).field_username);
          if ((localad == null) || (localad.field_username == null) || (localad.field_username.length() <= 0)) {
            y.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        G(7, 4, 12);
        localMatrixCursor.close();
        return com.tencent.mm.pluginsdk.d.a.a.DA(12);
      }
      com.tencent.mm.ag.o.JQ();
      Object localObject = com.tencent.mm.ag.d.A(localad.field_username, false);
      if (bk.bl((String)localObject))
      {
        y.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        String str;
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.DP().cachePath))
        {
          int j = com.tencent.mm.kernel.g.DP().cachePath.length();
          str = com.tencent.mm.kernel.g.DP().dKt + ((String)localObject).substring(j);
          com.tencent.mm.vfs.e.nb(com.tencent.mm.vfs.e.aeS(str));
          com.tencent.mm.vfs.e.r((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          str = localad.field_username;
          com.tencent.mm.ag.d.b.kl((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label362:
          G(6, 0, 1);
          return localMatrixCursor;
        }
      }
      label376:
      i += 1;
    }
  }
  
  private Cursor m(String[] paramArrayOfString)
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      cL(3, 3101);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3101);
    }
    Object localObject3 = null;
    int i = 0;
    for (;;)
    {
      Object localObject2;
      if ((i < 5) && (i < paramArrayOfString.length))
      {
        String str2 = paramArrayOfString[i];
        Object localObject4 = localObject3;
        i locali;
        for (;;)
        {
          String str1;
          try
          {
            Object localObject1;
            if (!com.tencent.mm.modelvoice.o.i(str2, 0, true))
            {
              localObject4 = localObject3;
              y.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(jJS);
              }
              localObject4 = localObject1;
              locali = new i();
              localObject4 = localObject1;
              str1 = b.aNs() + "/" + com.tencent.mm.sdk.platformtools.ad.bB(str2);
              localObject4 = localObject1;
              y.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.e.aeQ(str1) > 0L)
              {
                localObject4 = localObject1;
                y.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.e.aeQ(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = locali.aH(str2, str1);
                }
                localObject4 = localObject1;
                if (!bk.bl((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                y.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            y.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = locali.aH(str2, str1);
        }
        localObject4 = localObject2;
        y.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(locali.mSampleRate), Integer.valueOf(locali.bCT), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          G(8, 0, 1);
          return localObject3;
        }
        G(9, 3, 4);
        return com.tencent.mm.pluginsdk.d.a.a.DA(4);
      }
      i += 1;
      localObject3 = localObject2;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return null;
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    return null;
  }
  
  public boolean onCreate()
  {
    this.handler = new ah();
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    y.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.jJV) });
    a(paramUri, this.context, this.jJV, this.jJU);
    paramArrayOfString1 = this.jKd;
    if (paramUri == null)
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      cL(3, 5);
      return com.tencent.mm.pluginsdk.d.a.a.DA(5);
    }
    if (bk.bl(this.jKd))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      cL(3, 7);
      return com.tencent.mm.pluginsdk.d.a.a.DA(7);
    }
    if (bk.bl(aNA()))
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      cL(3, 6);
      return com.tencent.mm.pluginsdk.d.a.a.DA(6);
    }
    if (!awd())
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      cL(1, 3);
      return com.tencent.mm.pluginsdk.d.a.a.DA(3);
    }
    int i = 1;
    if (!jJO) {
      i = aNB();
    }
    if (i != 1)
    {
      y.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = " + i);
      cL(2, i);
      return com.tencent.mm.pluginsdk.d.a.a.DA(i);
    }
    long l1;
    switch (this.jJV)
    {
    case 24: 
    case 26: 
    case 27: 
    case 28: 
    case 29: 
    case 30: 
    case 31: 
    case 32: 
    case 33: 
    case 39: 
    case 43: 
    case 44: 
    case 45: 
    case 47: 
    default: 
      cL(3, 15);
      return null;
    case 22: 
      return k(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
    case 23: 
      return l(paramArrayOfString2);
    case 25: 
      return m(paramArrayOfString2);
    case 34: 
      y.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          y.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          cL(3, 3401);
          return com.tencent.mm.pluginsdk.d.a.a.DA(3401);
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((bk.bl(paramUri)) || (!com.tencent.mm.vfs.e.bK(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        cL(3, 3402);
        return com.tencent.mm.pluginsdk.d.a.a.DA(3402);
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.c();
        if (SightVideoJNI.isSightOk(paramUri, paramArrayOfString1.oei, paramArrayOfString1.oej, paramArrayOfString1.oek, paramArrayOfString1.oem, paramArrayOfString1.oel, paramArrayOfString1.oel.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.br.d.e(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      G(12, 0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    case 35: 
      y.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (bk.bl(paramArrayOfString2[0])))
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        cL(3, 3201);
        return com.tencent.mm.pluginsdk.d.a.a.DA(3201);
      }
      paramUri = paramArrayOfString2[0];
      y.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).aNw();
      y.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        G(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        return com.tencent.mm.pluginsdk.d.a.a.DA(i);
        G(15, 0, i);
      }
    case 36: 
      y.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        cL(3, 3301);
        return com.tencent.mm.pluginsdk.d.a.a.DA(3301);
      }
      paramUri = paramArrayOfString2[0];
      i = bk.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      y.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((bk.bl(paramUri)) || (i < 0) || (bk.bl(paramArrayOfString1)))
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        cL(3, 3302);
        return com.tencent.mm.pluginsdk.d.a.a.DA(3302);
      }
      paramString1 = new re();
      paramString1.caJ.caK = paramUri;
      paramString1.caJ.caL = i;
      paramString1.caJ.caM = paramArrayOfString1;
      paramString1.caJ.aVr = com.tencent.mm.pluginsdk.a.h(paramUri, this.context);
      com.tencent.mm.sdk.b.a.udP.m(paramString1);
      G(16, 0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    case 37: 
      y.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new ah(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.1(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        G(19, 4, 14);
        return com.tencent.mm.pluginsdk.d.a.a.DA(14);
      }
      G(18, 0, 1);
      y.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      return paramUri;
    case 38: 
      y.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new ah(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        G(21, 4, 14);
        return com.tencent.mm.pluginsdk.d.a.a.DA(14);
      }
      G(20, 0, paramUri.intValue());
      return com.tencent.mm.pluginsdk.d.a.a.DA(paramUri.intValue());
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.br.d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        h.nFQ.f(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        G(24, 0, 1);
        return com.tencent.mm.pluginsdk.d.a.a.DA(1);
        y.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      y.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        y.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        G(23, 3, 2);
        return com.tencent.mm.pluginsdk.d.a.a.DA(2);
      }
      l1 = bk.getLong(paramArrayOfString2[0], -1L);
      long l2 = bk.getLong(paramArrayOfString2[1], -1L);
      long l3 = bk.getLong(paramArrayOfString2[2], -1L);
      y.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        y.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        G(23, 3, 2);
        return com.tencent.mm.pluginsdk.d.a.a.DA(2);
      }
      aNx();
      paramUri = new fn();
      paramUri.bMr.action = 2;
      paramUri.bMr.bMt = l2;
      paramUri.bMr.bMu = l1;
      paramUri.bMr.bMv = l3;
      if ((com.tencent.mm.sdk.b.a.udP.m(paramUri)) && (paramUri.bMs.bMx))
      {
        G(22, 0, paramUri.bMs.bMy);
        return com.tencent.mm.pluginsdk.d.a.a.DA(paramUri.bMs.bMy);
      }
      G(23, 4, 8);
      return com.tencent.mm.pluginsdk.d.a.a.DA(8);
    case 41: 
      y.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      aNx();
      paramUri = new fn();
      paramUri.bMr.action = 3;
      if ((com.tencent.mm.sdk.b.a.udP.m(paramUri)) && (paramUri.bMs.bMx))
      {
        paramArrayOfString1 = paramUri.bMs.bMw;
        paramString1 = new MatrixCursor(jJQ);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.bMs.bMy), bk.pm(paramArrayOfString1) });
        G(22, 0, paramUri.bMs.bMy);
        y.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.bMs.bMy) });
        return paramString1;
      }
      G(23, 4, 8);
      return com.tencent.mm.pluginsdk.d.a.a.DA(8);
    case 46: 
      y.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      au.Hx();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        G(27, 5, 4);
        return com.tencent.mm.pluginsdk.d.a.a.DA(4101);
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.br.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      G(26, 0, 1);
      return com.tencent.mm.pluginsdk.d.a.a.DA(1);
    }
    com.tencent.mm.plugin.ext.c.e.aNL().mContext = this.context;
    if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
    {
      y.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      return com.tencent.mm.pluginsdk.d.a.a.DA(4201);
    }
    i = bk.getInt(paramArrayOfString2[0], -1);
    if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
    {
      y.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
      G(32, 3, 2);
      return com.tencent.mm.pluginsdk.d.a.a.DA(4201);
    }
    paramArrayOfString1 = null;
    if ((i == 0) || (i == 1))
    {
      if (paramArrayOfString2.length < 2)
      {
        y.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
        return com.tencent.mm.pluginsdk.d.a.a.DA(4205);
      }
      paramUri = paramArrayOfString2[1];
      if (i == 1)
      {
        if (paramArrayOfString2.length < 3)
        {
          y.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
          return com.tencent.mm.pluginsdk.d.a.a.DA(4208);
        }
        paramArrayOfString1 = paramArrayOfString2[2];
      }
    }
    for (;;)
    {
      y.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.c.e.aNL();
        if (bk.bl(paramUri))
        {
          y.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.c.e.M(null, -1, 4205);
          return com.tencent.mm.pluginsdk.d.a.a.DA(4205);
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.c.c.Cg(paramUri);
        if ((paramArrayOfString1 != null) && (!bk.bl(paramArrayOfString1.url)))
        {
          y.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.c.c.Ci(paramUri.url))
          {
            y.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.c.e.M(paramUri.url, paramUri.type, 4207);
            return com.tencent.mm.pluginsdk.d.a.a.VH(paramUri.url);
            paramUri = com.tencent.mm.plugin.ext.c.e.aA(paramUri, false);
            if (paramUri == null)
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.c.e.M(null, -1, 4206);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4206);
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (bk.bl(paramUri.url)))
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              return com.tencent.mm.pluginsdk.d.a.a.DA(4203);
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.c.c.Ch(paramUri.url))
            {
              y.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.c.e.M(paramUri.url, paramUri.type, 1);
              return com.tencent.mm.pluginsdk.d.a.a.DA(1);
            }
            l1 = bk.UZ();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.c.c.Cj(paramUri.url);
            y.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(bk.cp(l1)) });
            if (paramArrayOfString1 == b.b.jKX)
            {
              com.tencent.mm.plugin.ext.c.c.Ce(paramUri.url);
              com.tencent.mm.plugin.ext.c.e.M(paramUri.url, paramUri.type, 1);
              return com.tencent.mm.pluginsdk.d.a.a.DA(1);
            }
            if (paramArrayOfString1 != b.b.jKW)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.jLl;
              y.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.valueOf(true), paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.c.e.aNN());
              y.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.c.c.Ce(paramUri.url);
                com.tencent.mm.plugin.ext.c.e.M(paramUri.url, paramUri.type, 1);
                return com.tencent.mm.pluginsdk.d.a.a.DA(1);
              }
            }
            com.tencent.mm.plugin.ext.c.c.Cf(paramUri.url);
            y.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.c.e.M(paramUri.url, paramUri.type, 4207);
            return com.tencent.mm.pluginsdk.d.a.a.VH(paramUri.url);
          }
        }
        else
        {
          y.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          return com.tencent.mm.pluginsdk.d.a.a.DA(1);
          paramArrayOfString2 = com.tencent.mm.plugin.ext.c.e.aNL();
          if (bk.bl(paramUri))
          {
            y.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.c.e.N(null, -1, 4205);
            return com.tencent.mm.pluginsdk.d.a.a.DA(4205);
          }
          paramString1 = com.tencent.mm.plugin.ext.c.c.Cg(paramUri);
          if ((paramString1 != null) && (!bk.bl(paramString1.url))) {
            y.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.c.c.Ci(paramUri.url)); paramUri = paramArrayOfString1)
          {
            y.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.c.e.N(paramUri.url, paramUri.type, 4207);
            return com.tencent.mm.pluginsdk.d.a.a.DA(4207);
            if (bk.bl(paramArrayOfString1))
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.c.e.N(null, -1, 4208);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4208);
            }
            paramString1 = com.tencent.mm.plugin.ext.c.e.aA(paramUri, true);
            if (paramString1 == null)
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.c.e.N(null, -1, 4206);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4206);
            }
            if (bk.bl(paramString1.bIW))
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.c.e.N(null, -1, 4210);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4210);
            }
            if (!paramString1.bIW.equalsIgnoreCase(paramArrayOfString1))
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.c.e.N(null, -1, 4209);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4209);
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (bk.bl(paramArrayOfString1.url)))
            {
              y.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.c.e.N(null, -1, 4203);
              return com.tencent.mm.pluginsdk.d.a.a.DA(4203);
            }
            com.tencent.mm.plugin.ext.c.c.a(paramUri, paramArrayOfString1);
          }
          y.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          y.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.jLl);
          paramArrayOfString1.addFlags(268435456);
          paramArrayOfString2.mContext.startActivity(paramArrayOfString1);
          com.tencent.mm.plugin.ext.c.e.N(paramUri.url, paramUri.type, 1);
          return com.tencent.mm.pluginsdk.d.a.a.DA(1);
          com.tencent.mm.plugin.ext.c.e.aNL();
          return com.tencent.mm.plugin.ext.c.e.aNM();
        }
      }
      continue;
      paramUri = null;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi
 * JD-Core Version:    0.7.0.1
 */