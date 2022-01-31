package com.tencent.mm.plugin.ext.openapi.provider;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.o;
import com.tencent.mm.g.a.fq;
import com.tencent.mm.g.a.fq.b;
import com.tencent.mm.g.a.sq;
import com.tencent.mm.g.c.aq;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.r;
import com.tencent.mm.modelvoice.k;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.plugin.appbrand.appusage.LocalUsageInfo;
import com.tencent.mm.plugin.appbrand.appusage.af;
import com.tencent.mm.plugin.appbrand.config.WxaAttributes;
import com.tencent.mm.plugin.ext.b;
import com.tencent.mm.plugin.ext.c.b.b;
import com.tencent.mm.plugin.ext.c.e.2;
import com.tencent.mm.plugin.ext.c.e.a;
import com.tencent.mm.plugin.ext.provider.ExtContentProviderBase;
import com.tencent.mm.plugin.ext.ui.RedirectToQrCodeStubUI;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.plugin.sight.base.SightVideoJNI;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.ak;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.bd;
import com.tencent.mm.storage.bp;
import com.tencent.mm.storage.bz;
import com.tencent.mm.storage.ca;
import com.tencent.mm.storage.z;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ExtControlProviderOpenApi
  extends ExtContentProviderBase
{
  public static boolean mdS = false;
  private static final String[] mdT = { "retCode", "selfId" };
  private static final String[] mdU = { "retCode", "sportConfig" };
  private static final String[] mdV = { "openid", "avatar" };
  private static final String[] mdW = { "voiceType", "sampleRateInHz", "channelConfig", "audioFormat", "filePath" };
  private static final String[] mdX = { "ssid", "macAddress", "isSupportWechat", "name" };
  private static final String[] mdY = { "username", "appId", "versionType", "nickname", "shortNickname", "iconURL", "collection", "runningFlag", "wechatPkg", "action", "intentInfo" };
  private Context context;
  private ak handler;
  private String[] mdZ = null;
  private int mea = -1;
  
  public ExtControlProviderOpenApi() {}
  
  public ExtControlProviderOpenApi(String[] paramArrayOfString, int paramInt, Context paramContext)
  {
    this.mdZ = paramArrayOfString;
    this.mea = paramInt;
    this.context = paramContext;
  }
  
  private Cursor Q(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(20320);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "doRegisterMsgListener");
    if ((com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString1)) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString2)) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString3)))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, scene = %s, msgType = %s, msgState = %s", new Object[] { paramString1, paramString2, paramString3 });
      ej(3, 2004);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2004);
      AppMethodBeat.o(20320);
      return paramString1;
    }
    Object localObject = null;
    try
    {
      int i = Integer.parseInt(paramString3);
      int j = Integer.parseInt(paramString1);
      int k = Integer.parseInt(paramString2);
      if (i != 2)
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong msgState: ".concat(String.valueOf(i)));
        ej(3, 2005);
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2005);
        AppMethodBeat.o(20320);
        return paramString1;
      }
      if (b.bts().asu(this.mei) == null)
      {
        paramString1 = new com.tencent.mm.storage.bo();
        paramString1.field_appId = this.mei;
        paramString1.field_packageName = btD();
        paramString2 = this.mei;
        boolean bool;
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString2))
        {
          bool = false;
          if (!bool) {
            break label328;
          }
        }
        label328:
        for (paramString1.field_status = 1;; paramString1.field_status = 0)
        {
          paramString1.field_sceneFlag = j;
          paramString1.field_msgTypeFlag = k;
          paramString1.field_msgState = i;
          bool = b.bts().insert(paramString1);
          ab.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver ret = %s, pkgName = %s, scene = %s, msgType = %s, msgState = %s, appStatus = %s", new Object[] { Boolean.valueOf(bool), btD(), Integer.valueOf(j), Integer.valueOf(i), Integer.valueOf(i), Integer.valueOf(paramString1.field_status) });
          if (bool) {
            break label413;
          }
          paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2006);
          AppMethodBeat.o(20320);
          return paramString1;
          bool = com.tencent.mm.pluginsdk.model.app.g.m(com.tencent.mm.pluginsdk.model.app.g.ca(paramString2, true));
          break;
        }
        S(1, 4, 12);
      }
    }
    catch (Exception paramString1)
    {
      paramString2 = localObject;
    }
    for (;;)
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "exception in doRegisterMsgListener, %s", new Object[] { paramString1.getMessage() });
      if (paramString2 != null) {
        paramString2.close();
      }
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(12);
      AppMethodBeat.o(20320);
      return paramString1;
      ab.w("MicroMsg.ExtControlProviderOpenApi", "This app had already been registered, appId = %s, pkg = %s", new Object[] { this.mei, btD() });
      label413:
      paramString1 = new StringBuilder().append(r.Zn());
      aw.aaz();
      paramString1 = com.tencent.mm.sdk.platformtools.ag.cE(com.tencent.mm.model.c.getUin());
      paramString2 = new MatrixCursor(mdT);
      try
      {
        paramString2.addRow(new Object[] { Integer.valueOf(1), com.tencent.mm.sdk.platformtools.bo.nullAsNil(paramString1) });
        S(0, 0, 1);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(1) });
        AppMethodBeat.o(20320);
        return paramString2;
      }
      catch (Exception paramString1) {}
    }
  }
  
  private void btA()
  {
    AppMethodBeat.i(20323);
    String str1 = (String)b.btr().get(ac.a.yDq, null);
    String str2 = btD();
    ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportBroadPkg: pkgNames: %s, pkg: %s", new Object[] { str1, str2 });
    if (str1 != null)
    {
      if (!com.tencent.mm.compatible.loader.a.contains(str1.split(";"), str2)) {
        b.btr().set(ac.a.yDq, str1 + ";" + btD());
      }
      AppMethodBeat.o(20323);
      return;
    }
    b.btr().set(ac.a.yDq, btD());
    AppMethodBeat.o(20323);
  }
  
  private Cursor m(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    AppMethodBeat.i(20319);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "registerMsgReceiver, op = %s", new Object[] { paramString1 });
    if (this.context == null)
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "context == null return code = 2001");
      ej(4, 2001);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2001);
      AppMethodBeat.o(20319);
      return paramString1;
    }
    if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString1))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, op is null return code = 2002");
      ej(3, 2002);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2002);
      AppMethodBeat.o(20319);
      return paramString1;
    }
    int i = -1;
    try
    {
      int j = com.tencent.mm.sdk.platformtools.bo.getInt(paramString1, -1);
      i = j;
    }
    catch (Exception paramString1)
    {
      label112:
      boolean bool;
      break label112;
    }
    if (i == 1)
    {
      paramString1 = Q(paramString2, paramString3, paramString4);
      AppMethodBeat.o(20319);
      return paramString1;
    }
    if (i == 2)
    {
      ab.d("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener");
      if (b.bts().asu(this.mei) == null)
      {
        ab.w("MicroMsg.ExtControlProviderOpenApi", "This app never been registered, appId = %s, pkg = %s", new Object[] { this.mei, btD() });
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2007);
        AppMethodBeat.o(20319);
        return paramString1;
      }
      paramString1 = b.bts();
      paramString2 = this.mei;
      if ((paramString2 == null) || (paramString2.length() <= 0)) {
        bool = false;
      }
      for (;;)
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "doUnRegisterMsgListener ret = %s, appId = %s, pkg = %s", new Object[] { Boolean.valueOf(bool), this.mei, btD() });
        if (bool) {
          break;
        }
        paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2008);
        AppMethodBeat.o(20319);
        return paramString1;
        if (paramString1.db.delete("OpenMsgListener", "appId=?", new String[] { com.tencent.mm.sdk.platformtools.bo.wC(paramString2) }) <= 0) {
          bool = false;
        } else {
          bool = true;
        }
      }
      S(0, 0, 1);
      paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20319);
      return paramString1;
    }
    ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args, no such op, %s", new Object[] { Integer.valueOf(i) });
    ej(3, 2003);
    paramString1 = com.tencent.mm.pluginsdk.d.a.a.Ls(2003);
    AppMethodBeat.o(20319);
    return paramString1;
  }
  
  private Cursor n(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20317);
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0))
    {
      ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
      AppMethodBeat.o(20317);
      return paramArrayOfString;
    }
    int i;
    try
    {
      i = Integer.parseInt(paramArrayOfString[0]);
      if (1 == i) {
        ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.g.class)).G(this.context, i);
      }
    }
    catch (NumberFormatException paramArrayOfString)
    {
      try
      {
        i = Integer.parseInt(paramArrayOfString[1]);
        if ((1 == i) || (2 == i)) {
          break label132;
        }
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
        AppMethodBeat.o(20317);
        return paramArrayOfString;
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
        AppMethodBeat.o(20317);
        return paramArrayOfString;
      }
      paramArrayOfString = paramArrayOfString;
      ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
      AppMethodBeat.o(20317);
      return paramArrayOfString;
    }
    for (;;)
    {
      label132:
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20317);
      return paramArrayOfString;
      if (2 != i) {
        break;
      }
      ((com.tencent.mm.plugin.appbrand.service.g)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.g.class)).db(this.context);
    }
    paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
    AppMethodBeat.o(20317);
    return paramArrayOfString;
  }
  
  private static Cursor o(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20318);
    if ((paramArrayOfString == null) || (paramArrayOfString.length < 2))
    {
      ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
      AppMethodBeat.o(20318);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(mdY);
    LocalUsageInfo localLocalUsageInfo;
    Object localObject2;
    Object localObject3;
    for (;;)
    {
      try
      {
        i = Integer.parseInt(paramArrayOfString[0]);
        j = Integer.parseInt(paramArrayOfString[1]);
        paramArrayOfString = null;
        if (1 == i)
        {
          paramArrayOfString = ((com.tencent.mm.plugin.appbrand.appusage.ag)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.appusage.ag.class)).nu(j);
          paramArrayOfString = com.tencent.luggage.g.c.A(paramArrayOfString).iterator();
          if (!paramArrayOfString.hasNext()) {
            break label538;
          }
          localLocalUsageInfo = (LocalUsageInfo)paramArrayOfString.next();
          localObject1 = ((com.tencent.mm.plugin.appbrand.service.i)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.appbrand.service.i.class)).Af(localLocalUsageInfo.appId);
          if (localObject1 == null) {
            continue;
          }
          localObject2 = ((WxaAttributes)localObject1).field_roundedSquareIconURL;
          localObject3 = ((WxaAttributes)localObject1).field_brandIconURL;
          localObject4 = ((WxaAttributes)localObject1).field_bigHeadURL;
          localObject5 = (com.tencent.mm.modelappbrand.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.modelappbrand.b.a.class);
          str1 = ah.getPackageName();
          i = localLocalUsageInfo.hcr;
          str2 = ((WxaAttributes)localObject1).field_username;
          String str3 = ((WxaAttributes)localObject1).field_nickname;
          String str4 = ((WxaAttributes)localObject1).field_appId;
          com.tencent.mm.kernel.g.RJ();
          j = com.tencent.mm.kernel.a.getUin();
          localObject2 = ((com.tencent.mm.modelappbrand.b.a)localObject5).a(str1, i, str2, str3, new String[] { localObject2, localObject3, localObject4 }, str4, j, 3);
          if (localObject2 == null) {
            continue;
          }
          localObject4 = ((Intent)localObject2).getExtras();
          if (localObject4 == null) {
            continue;
          }
          localObject3 = new HashMap();
          localObject5 = ((Bundle)localObject4).keySet().iterator();
          if (!((Iterator)localObject5).hasNext()) {
            break;
          }
          str1 = (String)((Iterator)localObject5).next();
          ((Map)localObject3).put(str1, ((Bundle)localObject4).get(str1));
          continue;
        }
        if (2 != i) {
          continue;
        }
      }
      catch (NumberFormatException paramArrayOfString)
      {
        ab.printErrStackTrace("MicroMsg.ExtControlProviderOpenApi", paramArrayOfString, "", new Object[0]);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
        AppMethodBeat.o(20318);
        return paramArrayOfString;
      }
      paramArrayOfString = ((af)com.tencent.mm.kernel.g.E(af.class)).a(j, null);
    }
    Object localObject4 = localLocalUsageInfo.username;
    Object localObject5 = localLocalUsageInfo.appId;
    int j = localLocalUsageInfo.hcr;
    String str1 = localLocalUsageInfo.nickname;
    String str2 = localLocalUsageInfo.bDi;
    Object localObject1 = ((WxaAttributes)localObject1).field_brandIconURL;
    if (localLocalUsageInfo.hcO) {}
    for (int i = 1;; i = 0)
    {
      localMatrixCursor.addRow(new Object[] { localObject4, localObject5, Integer.valueOf(j), str1, str2, localObject1, Integer.valueOf(i), Long.valueOf(localLocalUsageInfo.bDL), ((Intent)localObject2).getPackage(), ((Intent)localObject2).getAction(), new com.tencent.mm.aa.i((Map)localObject3).toString() });
      break;
    }
    label538:
    AppMethodBeat.o(20318);
    return localMatrixCursor;
  }
  
  private Cursor p(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20321);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "getUserAvatarByOpenId");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "wrong args");
      ej(3, 3001);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3001);
      AppMethodBeat.o(20321);
      return paramArrayOfString;
    }
    MatrixCursor localMatrixCursor = new MatrixCursor(mdV);
    int i = 0;
    for (;;)
    {
      try
      {
        if ((i >= paramArrayOfString.length) || (i >= 5)) {
          break label377;
        }
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString[i])) {
          break label397;
        }
        localObject = b.btt().asG(paramArrayOfString[i]);
        if ((localObject == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((bz)localObject).field_openId)) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(((bz)localObject).field_username)))
        {
          ab.e("MicroMsg.ExtControlProviderOpenApi", "openidInApp is null");
        }
        else
        {
          aw.aaz();
          localObject = com.tencent.mm.model.c.YA().arw(((bz)localObject).field_username);
          if ((localObject == null) || (((aq)localObject).field_username == null) || (((aq)localObject).field_username.length() <= 0)) {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "contact is null");
          }
        }
      }
      catch (Exception paramArrayOfString)
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "Exception occur, %s", new Object[] { paramArrayOfString.getMessage() });
        S(7, 4, 12);
        localMatrixCursor.close();
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(12);
        AppMethodBeat.o(20321);
        return paramArrayOfString;
      }
      o.acQ();
      Object localObject = com.tencent.mm.ah.d.E(((aq)localObject).field_username, false);
      if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String)localObject))
      {
        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: get avatar sfs path is null or nil");
      }
      else
      {
        if (((String)localObject).startsWith(com.tencent.mm.kernel.g.RL().cachePath))
        {
          int j = com.tencent.mm.kernel.g.RL().cachePath.length();
          String str = com.tencent.mm.kernel.g.RL().eHR + ((String)localObject).substring(j);
          com.tencent.mm.vfs.e.um(com.tencent.mm.vfs.e.avK(str));
          com.tencent.mm.vfs.e.C((String)localObject, str);
          localObject = str;
        }
        for (;;)
        {
          com.tencent.mm.ah.d.b.rf((String)localObject);
          localMatrixCursor.addRow(new Object[] { paramArrayOfString[i], localObject });
          break;
          label377:
          S(6, 0, 1);
          AppMethodBeat.o(20321);
          return localMatrixCursor;
        }
      }
      label397:
      i += 1;
    }
  }
  
  private Cursor q(String[] paramArrayOfString)
  {
    AppMethodBeat.i(20322);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "decodeVoice");
    if ((paramArrayOfString == null) || (paramArrayOfString.length <= 0) || (paramArrayOfString[0].length() <= 0))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "decodeVoice wrong args");
      ej(3, 3101);
      paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(3101);
      AppMethodBeat.o(20322);
      return paramArrayOfString;
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
        k localk;
        for (;;)
        {
          String str1;
          try
          {
            Object localObject1;
            if (!q.i(str2, 0, true))
            {
              localObject4 = localObject3;
              ab.w("MicroMsg.ExtControlProviderOpenApi", "wrong args : %s", new Object[] { paramArrayOfString[i] });
              localObject1 = localObject3;
            }
            else
            {
              localObject1 = localObject3;
              if (localObject3 == null)
              {
                localObject4 = localObject3;
                localObject1 = new MatrixCursor(mdW);
              }
              localObject4 = localObject1;
              localk = new k();
              localObject4 = localObject1;
              str1 = b.btv() + "/" + com.tencent.mm.sdk.platformtools.ag.cE(str2);
              localObject4 = localObject1;
              ab.i("MicroMsg.ExtControlProviderOpenApi", "summerpcm pcmPath[%s]", new Object[] { str1 });
              localObject4 = localObject1;
              if (com.tencent.mm.vfs.e.avI(str1) > 0L)
              {
                localObject4 = localObject1;
                ab.d("MicroMsg.ExtControlProviderOpenApi", "pcm already exist");
                localObject3 = str1;
                localObject4 = localObject1;
                if (com.tencent.mm.vfs.e.avI(str1) == 0L)
                {
                  localObject4 = localObject1;
                  localObject3 = localk.ba(str2, str1);
                }
                localObject4 = localObject1;
                if (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil((String)localObject3)) {
                  break;
                }
                localObject4 = localObject1;
                ab.w("MicroMsg.ExtControlProviderOpenApi", "wrong args targetFilePath is null");
              }
            }
          }
          catch (Exception localException)
          {
            ab.e("MicroMsg.ExtControlProviderOpenApi", "Exception in decodeVoice, %s", new Object[] { localException.getMessage() });
            localObject2 = localObject4;
          }
          localObject4 = localObject2;
          localObject3 = localk.ba(str2, str1);
        }
        localObject4 = localObject2;
        ab.d("MicroMsg.ExtControlProviderOpenApi", "decode to pcm success %d", new Object[] { Integer.valueOf(i) });
        localObject4 = localObject2;
        localObject2.addRow(new Object[] { Integer.valueOf(1), Integer.valueOf(localk.mSampleRate), Integer.valueOf(localk.cjH), Integer.valueOf(2), localObject3 });
      }
      else
      {
        if (localObject3 != null)
        {
          S(8, 0, 1);
          AppMethodBeat.o(20322);
          return localObject3;
        }
        S(9, 3, 4);
        paramArrayOfString = com.tencent.mm.pluginsdk.d.a.a.Ls(4);
        AppMethodBeat.o(20322);
        return paramArrayOfString;
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
    AppMethodBeat.i(20315);
    this.handler = new ak();
    AppMethodBeat.o(20315);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    AppMethodBeat.i(20316);
    ab.i("MicroMsg.ExtControlProviderOpenApi", "query(), ApiId = %s", new Object[] { Integer.valueOf(this.mea) });
    a(paramUri, this.context, this.mea, this.mdZ);
    paramArrayOfString1 = this.mei;
    if (paramUri == null)
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "uri == null return code = 5");
      ej(3, 5);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(5);
      AppMethodBeat.o(20316);
      return paramUri;
    }
    if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(this.mei))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "AppID == null return code = 7");
      ej(3, 7);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(7);
      AppMethodBeat.o(20316);
      return paramUri;
    }
    if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(btD()))
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "PkgName == null return code = 6");
      ej(3, 6);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(6);
      AppMethodBeat.o(20316);
      return paramUri;
    }
    if (!aVH())
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "not login return code = 3");
      ej(1, 3);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3);
      AppMethodBeat.o(20316);
      return paramUri;
    }
    int i = 1;
    if (!mdS) {
      i = btE();
    }
    if (i != 1)
    {
      ab.e("MicroMsg.ExtControlProviderOpenApi", "invalid appid ! return code = ".concat(String.valueOf(i)));
      ej(2, i);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(i);
      AppMethodBeat.o(20316);
      return paramUri;
    }
    long l1;
    switch (this.mea)
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
    case 49: 
    case 50: 
    default: 
      ej(3, 15);
      AppMethodBeat.o(20316);
      return null;
    case 22: 
      paramUri = m(paramUri.getQueryParameter("op"), paramUri.getQueryParameter("scene"), paramUri.getQueryParameter("msgType"), paramUri.getQueryParameter("msgState"));
      AppMethodBeat.o(20316);
      return paramUri;
    case 23: 
      paramUri = p(paramArrayOfString2);
      AppMethodBeat.o(20316);
      return paramUri;
    case 25: 
      paramUri = q(paramArrayOfString2);
      AppMethodBeat.o(20316);
      return paramUri;
    case 34: 
      ab.i("MicroMsg.ExtControlProviderOpenApi", "sendSight ");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (paramArrayOfString2[0].length() <= 0))
      {
        if (paramArrayOfString2 == null) {}
        for (boolean bool = true;; bool = false)
        {
          ab.e("MicroMsg.ExtControlProviderOpenApi", "sendSight wrong args,args == null:%s", new Object[] { Boolean.valueOf(bool) });
          ej(3, 3401);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3401);
          AppMethodBeat.o(20316);
          return paramUri;
        }
      }
      paramUri = paramArrayOfString2[0];
      if ((com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramUri)) || (!com.tencent.mm.vfs.e.cN(paramUri))) {
        i = 0;
      }
      while (i == 0)
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "isSightOk wrong args");
        ej(3, 3402);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3402);
        AppMethodBeat.o(20316);
        return paramUri;
        paramArrayOfString1 = new com.tencent.mm.plugin.sight.base.c();
        if (SightVideoJNI.isSightOk(paramUri, paramArrayOfString1.qSx, paramArrayOfString1.qSy, paramArrayOfString1.qSz, paramArrayOfString1.qSB, paramArrayOfString1.qSA, paramArrayOfString1.qSA.length) == 0) {
          i = 1;
        } else {
          i = 0;
        }
      }
      paramArrayOfString1 = new Intent();
      paramArrayOfString1.addFlags(268435456);
      paramArrayOfString1.addFlags(67108864);
      paramArrayOfString1.putExtra("sight_local_path", paramUri);
      com.tencent.mm.bq.d.f(this.context, ".ui.transmit.SightForwardUI", paramArrayOfString1);
      S(12, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20316);
      return paramUri;
    case 35: 
      ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to chatting by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString2[0])))
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "hy: args error: no phone num or phone num is null or nil");
        ej(3, 3201);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3201);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start searching for phone num: %s", new Object[] { paramUri });
      i = new com.tencent.mm.plugin.ext.b.c(this.context, paramUri).btz();
      ab.i("MicroMsg.ExtControlProviderOpenApi", " ret =  ", new Object[] { Integer.valueOf(i) });
      if (i != -1)
      {
        S(14, 0, i);
        i = 0;
      }
      for (;;)
      {
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(i);
        AppMethodBeat.o(20316);
        return paramUri;
        S(15, 0, i);
      }
    case 36: 
      ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start redirect to wechat out by phone num");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "hy: wechat out args error: args length error");
        ej(3, 3301);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3301);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      paramUri = paramArrayOfString2[0];
      i = com.tencent.mm.sdk.platformtools.bo.getInt(paramArrayOfString2[1], -1);
      paramArrayOfString1 = paramArrayOfString2[2];
      ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: start wechat out: contactid: %s, countrycode: %s,  phone num: %s", new Object[] { paramUri, Integer.valueOf(i), paramArrayOfString1 });
      if ((com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramUri)) || (i < 0) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString1)))
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: param err");
        ej(3, 3302);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(3302);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      paramString1 = new sq();
      paramString1.cJj.cJk = paramUri;
      paramString1.cJj.cJl = i;
      paramString1.cJj.cHB = paramArrayOfString1;
      paramString1.cJj.blZ = com.tencent.mm.pluginsdk.a.j(paramUri, this.context);
      com.tencent.mm.sdk.b.a.ymk.l(paramString1);
      S(16, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20316);
      return paramUri;
    case 37: 
      ab.d("MicroMsg.ExtControlProviderOpenApi", "getWifiList");
      this.handler = new ak(Looper.getMainLooper());
      paramUri = (MatrixCursor)new ExtControlProviderOpenApi.1(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        S(19, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(14);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      S(18, 0, 1);
      ab.i("MicroMsg.ExtControlProviderOpenApi", "returnMatrix syncTaskCur");
      AppMethodBeat.o(20316);
      return paramUri;
    case 38: 
      ab.d("MicroMsg.ExtControlProviderOpenApi", "connectWifi");
      this.handler = new ak(Looper.getMainLooper());
      paramUri = (Integer)new ExtControlProviderOpenApi.2(this, paramArrayOfString2).b(this.handler);
      if (paramUri == null)
      {
        S(21, 4, 14);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(14);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      S(20, 0, paramUri.intValue());
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(paramUri.intValue());
      AppMethodBeat.o(20316);
      return paramUri;
    case 42: 
      paramUri = new Intent();
      paramUri.addFlags(131072);
      paramUri.putExtra("key_from_scene", 4);
      if ((paramArrayOfString2 != null) && (paramArrayOfString2.length > 0) && (paramArrayOfString2[0].length() > 0))
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "openOffline business_attach:%s,appid:%s", new Object[] { paramArrayOfString2[0], paramArrayOfString1 });
        paramUri.putExtra("key_business_attach", paramArrayOfString2[0]);
      }
      for (;;)
      {
        paramUri.putExtra("key_appid", paramArrayOfString1);
        com.tencent.mm.bq.d.b(this.context, "offline", ".ui.WalletOfflineEntranceUI", paramUri);
        h.qsU.e(12097, new Object[] { Integer.valueOf(9), Integer.valueOf(0), Long.valueOf(System.currentTimeMillis()) });
        S(24, 0, 1);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
        AppMethodBeat.o(20316);
        return paramUri;
        ab.i("MicroMsg.ExtControlProviderOpenApi", "openOffline appid:%s", new Object[] { paramArrayOfString1 });
      }
    case 40: 
      ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep start");
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length < 3))
      {
        ab.e("MicroMsg.ExtControlProviderOpenApi", "args error: args length error");
        S(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      l1 = com.tencent.mm.sdk.platformtools.bo.getLong(paramArrayOfString2[0], -1L);
      long l2 = com.tencent.mm.sdk.platformtools.bo.getLong(paramArrayOfString2[1], -1L);
      long l3 = com.tencent.mm.sdk.platformtools.bo.getLong(paramArrayOfString2[2], -1L);
      ab.i("MicroMsg.ExtControlProviderOpenApi", "setSportStep: timestampe: %s, stepcount: %s,  version: %s", new Object[] { Long.valueOf(l2), Long.valueOf(l1), Long.valueOf(l3) });
      if ((l2 < 0L) || (l1 < 0L) || (l3 < 0L))
      {
        ab.i("MicroMsg.ExtControlProviderOpenApi", "param err");
        S(23, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(2);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      btA();
      paramUri = new fq();
      paramUri.ctM.action = 2;
      paramUri.ctM.ctO = l2;
      paramUri.ctM.ctP = l1;
      paramUri.ctM.aJH = l3;
      if ((com.tencent.mm.sdk.b.a.ymk.l(paramUri)) && (paramUri.ctN.ctR))
      {
        S(22, 0, paramUri.ctN.ctS);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(paramUri.ctN.ctS);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      S(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(8);
      AppMethodBeat.o(20316);
      return paramUri;
    case 41: 
      ab.i("MicroMsg.ExtControlProviderOpenApi", "getSportConfig start");
      btA();
      paramUri = new fq();
      paramUri.ctM.action = 3;
      if ((com.tencent.mm.sdk.b.a.ymk.l(paramUri)) && (paramUri.ctN.ctR))
      {
        paramArrayOfString1 = paramUri.ctN.ctQ;
        paramString1 = new MatrixCursor(mdU);
        paramString1.addRow(new Object[] { Integer.valueOf(paramUri.ctN.ctS), com.tencent.mm.sdk.platformtools.bo.nullAsNil(paramArrayOfString1) });
        S(22, 0, paramUri.ctN.ctS);
        ab.i("MicroMsg.ExtControlProviderOpenApi", "return  code =%s ", new Object[] { Integer.valueOf(paramUri.ctN.ctS) });
        AppMethodBeat.o(20316);
        return paramString1;
      }
      S(23, 4, 8);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(8);
      AppMethodBeat.o(20316);
      return paramUri;
    case 46: 
      ab.d("MicroMsg.ExtControlProviderOpenApi", "openClean appid:%s", new Object[] { paramArrayOfString1 });
      aw.aaz();
      if (!com.tencent.mm.model.c.isSDCardAvailable())
      {
        S(27, 5, 4);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4101);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      paramUri = new Intent();
      paramUri.putExtra("key_from_openapi", true);
      paramUri.putExtra("key_openapi_appid", paramArrayOfString1);
      com.tencent.mm.bq.d.b(this.context, "clean", ".ui.CleanUI", paramUri);
      S(26, 0, 1);
      paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
      AppMethodBeat.o(20316);
      return paramUri;
    case 48: 
      com.tencent.mm.plugin.ext.c.e.btO().mContext = this.context;
      if ((paramArrayOfString2 == null) || (paramArrayOfString2.length <= 0))
      {
        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length!");
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4201);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      i = com.tencent.mm.sdk.platformtools.bo.getInt(paramArrayOfString2[0], -1);
      if ((i < 0) || ((i != 0) && (i != 1) && (i != 2)))
      {
        ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid command!");
        S(32, 3, 2);
        paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4201);
        AppMethodBeat.o(20316);
        return paramUri;
      }
      paramArrayOfString1 = null;
      if ((i == 0) || (i == 1))
      {
        if (paramArrayOfString2.length < 2)
        {
          ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: invalid arg length when check or open!");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4205);
          AppMethodBeat.o(20316);
          return paramUri;
        }
        paramUri = paramArrayOfString2[1];
        if (i == 1)
        {
          if (paramArrayOfString2.length < 3)
          {
            ab.w("MicroMsg.ExtControlProviderOpenApi", "hy: not providing md5!");
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4208);
            AppMethodBeat.o(20316);
            return paramUri;
          }
          paramArrayOfString1 = paramArrayOfString2[2];
        }
      }
      break;
    }
    for (;;)
    {
      ab.i("MicroMsg.ExtControlProviderOpenApi", "hy: cmdid: %d, yuvHandle: %s", new Object[] { Integer.valueOf(i), paramUri });
      switch (i)
      {
      default: 
        AppMethodBeat.o(20316);
        return null;
      case 0: 
        paramString1 = com.tencent.mm.plugin.ext.c.e.btO();
        if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramUri))
        {
          ab.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleCheckQrCode");
          com.tencent.mm.plugin.ext.c.e.aa(null, -1, 4205);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4205);
          AppMethodBeat.o(20316);
          return paramUri;
        }
        paramArrayOfString1 = com.tencent.mm.plugin.ext.c.c.Nh(paramUri);
        if ((paramArrayOfString1 != null) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString1.url)))
        {
          ab.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramArrayOfString1 });
          paramUri = paramArrayOfString1;
        }
        break;
      }
      for (;;)
      {
        if (paramUri.type == 19)
        {
          if (com.tencent.mm.plugin.ext.c.c.Nj(paramUri.url))
          {
            ab.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url.toUpperCase() });
            com.tencent.mm.plugin.ext.c.e.aa(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ale(paramUri.url);
            AppMethodBeat.o(20316);
            return paramUri;
            paramUri = com.tencent.mm.plugin.ext.c.e.aN(paramUri, false);
            if (paramUri == null)
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleCheckQrCode");
              com.tencent.mm.plugin.ext.c.e.aa(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4206);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            paramUri = paramString1.a(paramUri);
            if ((paramUri == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramUri.url)))
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4203);
              AppMethodBeat.o(20316);
              return paramUri;
            }
          }
          else
          {
            if (com.tencent.mm.plugin.ext.c.c.Ni(paramUri.url))
            {
              ab.i("MicroMsg.ExtQrCodeHandler", "hy: wechat can open: %s", new Object[] { paramUri.url });
              com.tencent.mm.plugin.ext.c.e.aa(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            l1 = com.tencent.mm.sdk.platformtools.bo.yB();
            paramArrayOfString1 = com.tencent.mm.plugin.ext.c.c.Nk(paramUri.url);
            ab.i("MicroMsg.ExtQrCodeHandler", "hy: resolve config: %s, using: %d ms", new Object[] { paramArrayOfString1.toString(), Long.valueOf(com.tencent.mm.sdk.platformtools.bo.av(l1)) });
            if (paramArrayOfString1 == b.b.mfb)
            {
              com.tencent.mm.plugin.ext.c.c.Nf(paramUri.url);
              com.tencent.mm.plugin.ext.c.e.aa(paramUri.url, paramUri.type, 1);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            if (paramArrayOfString1 != b.b.mfa)
            {
              paramArrayOfString1 = paramUri.url;
              i = paramUri.type;
              int j = paramUri.mfp;
              ab.i("MicroMsg.ExtQrCodeHandler", "hy: start remote judge url: %s", new Object[] { paramArrayOfString1 });
              l1 = System.currentTimeMillis();
              paramArrayOfString1 = (Boolean)new e.2(paramString1, Boolean.TRUE, paramArrayOfString1, i, j).b(com.tencent.mm.plugin.ext.c.e.btQ());
              ab.i("MicroMsg.ExtQrCodeHandler", "hy: can open: %b, using %d ms", new Object[] { paramArrayOfString1, Long.valueOf(System.currentTimeMillis() - l1) });
              if (paramArrayOfString1.booleanValue())
              {
                com.tencent.mm.plugin.ext.c.c.Nf(paramUri.url);
                com.tencent.mm.plugin.ext.c.e.aa(paramUri.url, paramUri.type, 1);
                paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
                AppMethodBeat.o(20316);
                return paramUri;
              }
            }
            com.tencent.mm.plugin.ext.c.c.Ng(paramUri.url);
            ab.w("MicroMsg.ExtQrCodeHandler", "hy: remote wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.c.e.aa(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.ale(paramUri.url);
            AppMethodBeat.o(20316);
            return paramUri;
          }
        }
        else
        {
          ab.i("MicroMsg.ExtQrCodeHandler", "hy: subapp code. can open");
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
          AppMethodBeat.o(20316);
          return paramUri;
          paramArrayOfString2 = com.tencent.mm.plugin.ext.c.e.btO();
          if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramUri))
          {
            ab.w("MicroMsg.ExtQrCodeHandler", "hy: null handle in doHandleOpenQrCode");
            com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4205);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4205);
            AppMethodBeat.o(20316);
            return paramUri;
          }
          paramString1 = com.tencent.mm.plugin.ext.c.c.Nh(paramUri);
          if ((paramString1 != null) && (!com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString1.url))) {
            ab.i("MicroMsg.ExtQrCodeHandler", "hy: handled previously. yuvhandle: %s, url: %s. direct return", new Object[] { paramUri, paramString1 });
          }
          for (paramUri = paramString1; (paramUri.type == 19) && (com.tencent.mm.plugin.ext.c.c.Nj(paramUri.url)); paramUri = paramArrayOfString1)
          {
            ab.i("MicroMsg.ExtQrCodeHandler", "hy: fastjudge wechat cannot open: %s", new Object[] { paramUri.url });
            com.tencent.mm.plugin.ext.c.e.ab(paramUri.url, paramUri.type, 4207);
            paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4207);
            AppMethodBeat.o(20316);
            return paramUri;
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString1))
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: md5 not correct!!");
              com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4208);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4208);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            paramString1 = com.tencent.mm.plugin.ext.c.e.aN(paramUri, true);
            if (paramString1 == null)
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: not retrieved yuv data in doHandleOpenQrCode");
              com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4206);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4206);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            if (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramString1.cqq))
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: cannot retrieve md5 from yuv!");
              com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4210);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4210);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            if (!paramString1.cqq.equalsIgnoreCase(paramArrayOfString1))
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: yuv data not match!!");
              com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4209);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4209);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            paramArrayOfString1 = paramArrayOfString2.a(paramString1);
            if ((paramArrayOfString1 == null) || (com.tencent.mm.sdk.platformtools.bo.isNullOrNil(paramArrayOfString1.url)))
            {
              ab.w("MicroMsg.ExtQrCodeHandler", "hy: not resolved model");
              com.tencent.mm.plugin.ext.c.e.ab(null, -1, 4203);
              paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(4203);
              AppMethodBeat.o(20316);
              return paramUri;
            }
            com.tencent.mm.plugin.ext.c.c.a(paramUri, paramArrayOfString1);
          }
          ab.i("MicroMsg.ExtQrCodeHandler", "hy: do open");
          ab.i("MicroMsg.ExtQrCodeHandler", "hy: start open: %s", new Object[] { paramUri.toString() });
          paramArrayOfString1 = new Intent(paramArrayOfString2.mContext, RedirectToQrCodeStubUI.class);
          paramArrayOfString1.putExtra("K_STR", paramUri.url);
          paramArrayOfString1.putExtra("K_TYPE", paramUri.type);
          paramArrayOfString1.putExtra("K_VERSION", paramUri.mfp);
          paramArrayOfString1.addFlags(268435456);
          paramArrayOfString2.mContext.startActivity(paramArrayOfString1);
          com.tencent.mm.plugin.ext.c.e.ab(paramUri.url, paramUri.type, 1);
          paramUri = com.tencent.mm.pluginsdk.d.a.a.Ls(1);
          AppMethodBeat.o(20316);
          return paramUri;
          com.tencent.mm.plugin.ext.c.e.btO();
          paramUri = com.tencent.mm.plugin.ext.c.e.btP();
          AppMethodBeat.o(20316);
          return paramUri;
          paramUri = o(paramArrayOfString2);
          AppMethodBeat.o(20316);
          return paramUri;
          paramUri = n(paramArrayOfString2);
          AppMethodBeat.o(20316);
          return paramUri;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.ext.openapi.provider.ExtControlProviderOpenApi
 * JD-Core Version:    0.7.0.1
 */