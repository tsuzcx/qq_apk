package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.emoji.c.o;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.expt.b.c.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.sdk.storage.ISQLiteDatabase;
import com.tencent.mm.sticker.b.b;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.bl;
import com.tencent.mm.storage.co;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.g.a;
import com.tencent.mm.vfs.y;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkUseCPUCrop", "", "createEmojiInfo", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getLensList", "getLensListRemote", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class EmojiCaptureProxy
  extends com.tencent.mm.remoteservice.a
{
  private static int wrD;
  public static final a yjA;
  private static EmojiCaptureProxy yjB;
  private static boolean yjC;
  private final String nBg;
  private final com.tencent.mm.remoteservice.d pfZ;
  
  static
  {
    AppMethodBeat.i(414);
    yjA = new a((byte)0);
    yjB = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
    yjC = true;
    AppMethodBeat.o(414);
  }
  
  public EmojiCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    this.pfZ = paramd;
    this.nBg = "result_key";
  }
  
  private static final void J(boolean paramBoolean, String paramString) {}
  
  @com.tencent.mm.remoteservice.f
  public final boolean checkUseCPUCrop()
  {
    AppMethodBeat.i(402);
    Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.ygu.boF()).nFT;
    AppMethodBeat.o(402);
    return bool;
  }
  
  public final void createEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(384);
    kotlin.g.b.s.u(paramEmojiInfo, "emojiInfo");
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("createEmojiInfo: ", paramEmojiInfo.getMd5()));
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", (Parcelable)paramEmojiInfo);
    REMOTE_CALL("createEmojiInfoRemote", new Object[] { localBundle });
    AppMethodBeat.o(384);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void createEmojiInfoRemote(Bundle paramBundle)
  {
    AppMethodBeat.i(392);
    kotlin.g.b.s.u(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    if (localEmojiInfo == null) {}
    for (paramBundle = null;; paramBundle = localEmojiInfo.getMd5())
    {
      Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("createEmojiInfoRemote: ", paramBundle));
      if (localEmojiInfo == null) {
        break;
      }
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().o(localEmojiInfo.getMd5(), 0, EmojiInfo.aklO, localEmojiInfo.field_size);
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().t(localEmojiInfo);
      AppMethodBeat.o(392);
      return;
    }
    EmojiCaptureReporter.KN(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.ygT;
    com.tencent.mm.plugin.emojicapture.model.e.dEi();
    AppMethodBeat.o(392);
  }
  
  public final void deleteEmojiInfoByEnterTime(long paramLong)
  {
    AppMethodBeat.i(395);
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("deleteEmojiInfoByEnterTime: ", Long.valueOf(paramLong)));
    REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(395);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByEnterTimeRemote(long paramLong)
  {
    AppMethodBeat.i(396);
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("deleteEmojiInfoByEnterTimeRemote: ", Long.valueOf(paramLong)));
    com.tencent.mm.storage.emotion.f localf = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju;
    if ((paramLong != 0L) && (localf.db.delete("EmojiInfo", "captureEnterTime=".concat(String.valueOf(paramLong)), null) > 0)) {
      localf.doNotify("event_update_emoji");
    }
    AppMethodBeat.o(396);
  }
  
  public final void deleteEmojiInfoByMd5(String paramString)
  {
    AppMethodBeat.i(393);
    kotlin.g.b.s.u(paramString, "md5");
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("deleteEmojiInfo: ", paramString));
    REMOTE_CALL("deleteEmojiInfoByMd5Remote", new Object[] { paramString });
    AppMethodBeat.o(393);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByMd5Remote(String paramString)
  {
    AppMethodBeat.i(394);
    kotlin.g.b.s.u(paramString, "md5");
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("deleteEmojiInfoByMd5Remote: ", paramString));
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.bzb(paramString);
    AppMethodBeat.o(394);
  }
  
  @com.tencent.mm.remoteservice.f
  public final Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(408);
    kotlin.g.b.s.u(paramObject, "defval");
    Object localObject = (at.a[])at.a.class.getEnumConstants();
    if (localObject == null) {}
    for (localObject = null;; localObject = localObject[paramInt])
    {
      Log.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", new Object[] { localObject, paramObject });
      paramObject = com.tencent.mm.kernel.h.baE().ban().get((at.a)localObject, paramObject);
      AppMethodBeat.o(408);
      return paramObject;
    }
  }
  
  public final String getDeviceInfoConfig()
  {
    AppMethodBeat.i(390);
    Object localObject = REMOTE_CALL("getDeviceInfoConfigRemote", new Object[0]);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(390);
      return localObject;
    }
    AppMethodBeat.o(390);
    return null;
  }
  
  @com.tencent.mm.remoteservice.f
  public final String getDeviceInfoConfigRemote()
  {
    AppMethodBeat.i(407);
    String str = com.tencent.mm.kernel.h.baE().bao().jcN();
    kotlin.g.b.s.s(str, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
    AppMethodBeat.o(407);
    return str;
  }
  
  public final String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(385);
    kotlin.g.b.s.u(paramString, "key");
    Object localObject = REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    Log.i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(385);
      return "";
    }
    paramString = (String)localObject;
    AppMethodBeat.o(385);
    return paramString;
  }
  
  @com.tencent.mm.remoteservice.f
  public final String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(405);
    kotlin.g.b.s.u(paramString, "key");
    paramString = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.zero.b.a.class)).aRC().getValue(paramString);
    AppMethodBeat.o(405);
    return paramString;
  }
  
  public final boolean getEnableAutoRotate()
  {
    AppMethodBeat.i(386);
    boolean bool = kotlin.g.b.s.p(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(386);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean getEnableAutoRotateRemote()
  {
    return af.lXY.lTF;
  }
  
  public final String getForbidLensId()
  {
    AppMethodBeat.i(388);
    Object localObject = REMOTE_CALL("getDynamicConfigInMM", new Object[] { "EmotionSpringFestivalPendantBlockedIdList" });
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(388);
      return localObject;
    }
    AppMethodBeat.o(388);
    return null;
  }
  
  public final int getInt(at.a parama, int paramInt)
  {
    AppMethodBeat.i(387);
    kotlin.g.b.s.u(parama, "key");
    Log.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    Log.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(387);
      return paramInt;
    }
    paramInt = Util.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(387);
    return paramInt;
  }
  
  public final void getLensList()
  {
    AppMethodBeat.i(410);
    REMOTE_CALL("getLensListRemote", new Object[0]);
    AppMethodBeat.o(410);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void getLensListRemote()
  {
    AppMethodBeat.i(411);
    com.tencent.mm.kernel.h.baD().mCm.a((p)new b(), 0);
    AppMethodBeat.o(411);
  }
  
  public final com.tencent.mm.remoteservice.d getServerProxy()
  {
    return this.pfZ;
  }
  
  public final int getUseGpuSegment()
  {
    AppMethodBeat.i(391);
    Object localObject = REMOTE_CALL("getUseGpuSegmentRemote", new Object[0]);
    if ((localObject instanceof Integer))
    {
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(391);
      return i;
    }
    AppMethodBeat.o(391);
    return 0;
  }
  
  @com.tencent.mm.remoteservice.f
  public final int getUseGpuSegmentRemote()
  {
    AppMethodBeat.i(409);
    try
    {
      i = ((com.tencent.mm.plugin.expt.b.c)com.tencent.mm.kernel.h.ax(com.tencent.mm.plugin.expt.b.c.class)).a(c.a.yRq, 1);
      AppMethodBeat.o(409);
      return i;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        int i = 1;
      }
    }
  }
  
  public final boolean isSpringFestivalEnable()
  {
    AppMethodBeat.i(389);
    boolean bool = kotlin.g.b.s.p(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(389);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean isSpringFestivalEnableRemote()
  {
    AppMethodBeat.i(406);
    boolean bool = o.isSpringFestivalEnable();
    AppMethodBeat.o(406);
    return bool;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(413);
    kotlin.g.b.s.u(paramString, "methodName");
    kotlin.g.b.s.u(paramBundle, "data");
    Log.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        kotlin.g.b.s.s(arrayOfMethod, "methods");
        int j = arrayOfMethod.length;
        int i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label276;
        }
        localObject1 = arrayOfMethod[i];
        i += 1;
        if (!n.T(((Method)localObject1).getName(), paramString, true)) {
          continue;
        }
      }
      catch (Exception paramString)
      {
        Log.e("MicroMsg.EmojiCaptureProxy", "exception:%s", new Object[] { Util.stackTraceToString((Throwable)paramString) });
        AppMethodBeat.o(413);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent((Class)localObject2))
      {
        localObject2 = getArgs(paramBundle);
        localObject2 = ((Method)localObject1).invoke(this, Arrays.copyOf((Object[])localObject2, localObject2.length));
        if (!kotlin.g.b.s.p(((Method)localObject1).getReturnType(), Void.TYPE))
        {
          if ((localObject2 instanceof Parcelable))
          {
            paramBundle.putParcelable(this.nBg, (Parcelable)localObject2);
            AppMethodBeat.o(413);
            return;
          }
          if (kotlin.g.b.s.p("getConfigStorage", paramString)) {
            Log.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable(this.nBg, (Serializable)localObject2);
          AppMethodBeat.o(413);
          return;
        }
      }
      label276:
      if (localObject1 != null) {
        if (paramBoolean) {
          localObject2 = com.tencent.mm.remoteservice.e.class;
        } else {
          localObject2 = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void postUploadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(399);
    kotlin.g.b.s.u(paramString1, "filePath");
    kotlin.g.b.s.u(paramString2, "mixingMd5");
    Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + paramString1 + ", " + paramString2);
    REMOTE_CALL("postUploadTaskRemote", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(399);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void postUploadTaskRemote(String paramString1, String paramString2)
  {
    AppMethodBeat.i(400);
    kotlin.g.b.s.u(paramString1, "filePath");
    kotlin.g.b.s.u(paramString2, "mixingMd5");
    Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + paramString1 + ", " + paramString2);
    int i = (int)y.bEl(paramString1);
    paramString2 = ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().aoe(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(400);
      return;
    }
    if (i <= 0)
    {
      paramString2.a(EmojiInfo.b.admw);
      paramString2.a(EmojiInfo.a.admg);
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(paramString2);
      EmojiCaptureReporter.i(paramString2.field_captureEnterTime, 4, paramString2.field_captureScene);
      AppMethodBeat.o(400);
      return;
    }
    String str1 = y.bub(paramString1);
    String str2 = kotlin.g.b.s.X(EmojiInfo.kMp(), str1);
    y.qn(paramString1, str2);
    Log.i("MicroMsg.EmojiCaptureProxy", "upload file " + str2 + " length is " + i);
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.bzb(paramString2.getMd5());
    paramString2.field_md5 = str1;
    paramString2.a(EmojiInfo.a.admh);
    paramString2.field_size = ((int)y.bEl(str2));
    if (ImgUtil.isWXGF(str2))
    {
      paramString2.field_wxamMd5 = str1;
      paramString2.field_externMd5 = str1;
    }
    ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiStorageMgr().adju.K(paramString2);
    paramString1 = com.tencent.mm.emoji.e.h.mol;
    com.tencent.mm.emoji.e.h.m(paramString2);
    AppMethodBeat.o(400);
  }
  
  public final Bundle q(Object... paramVarArgs)
  {
    AppMethodBeat.i(412);
    kotlin.g.b.s.u(paramVarArgs, "params");
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      if ((paramVarArgs[i] instanceof Bundle)) {
        localBundle.putBundle(kotlin.g.b.s.X("", Integer.valueOf(i)), (Bundle)paramVarArgs[i]);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof Parcelable))
        {
          localBundle.putParcelable(kotlin.g.b.s.X("", Integer.valueOf(i)), (Parcelable)paramVarArgs[i]);
        }
        else if ((paramVarArgs[i] instanceof at.a))
        {
          Log.i("MicroMsg.EmojiCaptureProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((at.a)paramVarArgs[i]).ordinal()) });
          localBundle.putInt(kotlin.g.b.s.X("", Integer.valueOf(i)), ((at.a)paramVarArgs[i]).ordinal());
        }
        else
        {
          localBundle.putSerializable(kotlin.g.b.s.X("", Integer.valueOf(i)), (Serializable)paramVarArgs[i]);
        }
      }
    }
    AppMethodBeat.o(412);
    return localBundle;
  }
  
  public final void showImitateDialog()
  {
    AppMethodBeat.i(403);
    REMOTE_CALL("showImitateDialogRemote", new Object[0]);
    AppMethodBeat.o(403);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void showImitateDialogRemote()
  {
    AppMethodBeat.i(404);
    String str = MMApplicationContext.getContext().getResources().getString(a.i.yfF);
    kotlin.g.b.s.s(str, "getContext().resources.g…g_first_open_imitate_msg)");
    new g.a(MMApplicationContext.getContext()).bDE(str).aEX(a.i.yfE).b(EmojiCaptureProxy..ExternalSyntheticLambda0.INSTANCE).show();
    AppMethodBeat.o(404);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(397);
    kotlin.g.b.s.u(paramEmojiInfo, "emojiInfo");
    Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("updateEmojiInfo: ", paramEmojiInfo.getMd5()));
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", (Parcelable)paramEmojiInfo);
    REMOTE_CALL("updateEmojiInfoRemote", new Object[] { localBundle });
    AppMethodBeat.o(397);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void updateEmojiInfoRemote(Bundle paramBundle)
  {
    AppMethodBeat.i(398);
    kotlin.g.b.s.u(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    if (localEmojiInfo == null) {}
    for (paramBundle = null;; paramBundle = localEmojiInfo.getMd5())
    {
      Log.i("MicroMsg.EmojiCaptureProxy", kotlin.g.b.s.X("updateEmojiInfoRemote: ", paramBundle));
      if (localEmojiInfo == null) {
        break;
      }
      ((com.tencent.mm.plugin.emoji.c.d)com.tencent.mm.kernel.h.az(com.tencent.mm.plugin.emoji.c.d.class)).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(398);
      return;
    }
    EmojiCaptureReporter.KN(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.ygT;
    com.tencent.mm.plugin.emojicapture.model.e.dEi();
    AppMethodBeat.o(398);
  }
  
  public final boolean useCPUCrop()
  {
    AppMethodBeat.i(401);
    Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
    Object localObject = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(401);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(401);
    return bool;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void dEA()
    {
      AppMethodBeat.i(382);
      EmojiCaptureProxy.access$setRequestCount$cp(EmojiCaptureProxy.access$getRequestCount$cp() - 1);
      if (EmojiCaptureProxy.access$getRequestCount$cp() <= 0)
      {
        EmojiCaptureProxy.access$setNeedCreate$cp(true);
        com.tencent.mm.remoteservice.d locald = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
        if (locald != null) {
          locald.release();
        }
      }
      AppMethodBeat.o(382);
    }
    
    public static void dEz()
    {
      AppMethodBeat.i(381);
      EmojiCaptureProxy.access$setRequestCount$cp(EmojiCaptureProxy.access$getRequestCount$cp() + 1);
      if (EmojiCaptureProxy.access$getNeedCreate$cp())
      {
        EmojiCaptureProxy.access$setNeedCreate$cp(false);
        EmojiCaptureProxy localEmojiCaptureProxy = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
        kotlin.g.b.s.u(localEmojiCaptureProxy, "<set-?>");
        EmojiCaptureProxy.access$setInstance$cp(localEmojiCaptureProxy);
      }
      AppMethodBeat.o(381);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy
 * JD-Core Version:    0.7.0.1
 */