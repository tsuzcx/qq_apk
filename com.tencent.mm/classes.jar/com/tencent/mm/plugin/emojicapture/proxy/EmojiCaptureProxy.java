package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.q;
import com.tencent.mm.compatible.deviceinfo.af;
import com.tencent.mm.emoji.b.o;
import com.tencent.mm.emoji.d.i;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.emojicapture.a.i;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.expt.b.b.a;
import com.tencent.mm.sdk.platformtools.ImgUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.storage.bj;
import com.tencent.mm.storage.cl;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import com.tencent.mm.vfs.u;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.n.n;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkUseCPUCrop", "", "createEmojiInfo", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getLensList", "getLensListRemote", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureProxy
  extends com.tencent.mm.remoteservice.a
{
  private static int jGL;
  private static boolean jGM;
  private static EmojiCaptureProxy uXk;
  public static final a uXl;
  private final String RESULT_KEY;
  private final com.tencent.mm.remoteservice.d jGJ;
  
  static
  {
    AppMethodBeat.i(414);
    uXl = new a((byte)0);
    uXk = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
    jGM = true;
    AppMethodBeat.o(414);
  }
  
  public EmojiCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    this.jGJ = paramd;
    this.RESULT_KEY = "result_key";
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean checkUseCPUCrop()
  {
    AppMethodBeat.i(402);
    Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.uTG.aUb()).laO;
    AppMethodBeat.o(402);
    return bool;
  }
  
  public final void createEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(384);
    p.k(paramEmojiInfo, "emojiInfo");
    Log.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + paramEmojiInfo.getMd5());
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
    p.k(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("createEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.getMd5();; paramBundle = null)
    {
      Log.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().n(localEmojiInfo.getMd5(), 0, EmojiInfo.YCF, localEmojiInfo.field_size);
      paramBundle = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      paramBundle = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().t(localEmojiInfo);
      AppMethodBeat.o(392);
      return;
    }
    EmojiCaptureReporter.JP(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.uUh;
    com.tencent.mm.plugin.emojicapture.model.e.cXS();
    AppMethodBeat.o(392);
  }
  
  public final void deleteEmojiInfoByEnterTime(long paramLong)
  {
    AppMethodBeat.i(395);
    Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(paramLong)));
    REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(395);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByEnterTimeRemote(long paramLong)
  {
    AppMethodBeat.i(396);
    Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(paramLong)));
    Object localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    p.j(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((bj)localObject).ctY().UY(paramLong);
    AppMethodBeat.o(396);
  }
  
  public final void deleteEmojiInfoByMd5(String paramString)
  {
    AppMethodBeat.i(393);
    p.k(paramString, "md5");
    Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(paramString)));
    REMOTE_CALL("deleteEmojiInfoByMd5Remote", new Object[] { paramString });
    AppMethodBeat.o(393);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByMd5Remote(String paramString)
  {
    AppMethodBeat.i(394);
    p.k(paramString, "md5");
    Log.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(paramString)));
    Object localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    p.j(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((bj)localObject).ctY().bxL(paramString);
    AppMethodBeat.o(394);
  }
  
  @com.tencent.mm.remoteservice.f
  public final Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(408);
    p.k(paramObject, "defval");
    Object localObject = (ar.a[])ar.a.class.getEnumConstants();
    if (localObject != null) {}
    for (localObject = localObject[paramInt];; localObject = null)
    {
      Log.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", new Object[] { localObject, paramObject });
      paramObject = h.aHG().aHp().get((ar.a)localObject, paramObject);
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
    String str = h.aHG().aHq().hAK();
    p.j(str, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
    AppMethodBeat.o(407);
    return str;
  }
  
  public final String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(385);
    p.k(paramString, "key");
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
    p.k(paramString, "key");
    paramString = ((com.tencent.mm.plugin.zero.b.a)h.ae(com.tencent.mm.plugin.zero.b.a.class)).axc().getValue(paramString);
    AppMethodBeat.o(405);
    return paramString;
  }
  
  public final boolean getEnableAutoRotate()
  {
    AppMethodBeat.i(386);
    boolean bool = p.h(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(386);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean getEnableAutoRotateRemote()
  {
    return af.juH.jqy;
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
  
  public final int getInt(ar.a parama, int paramInt)
  {
    AppMethodBeat.i(387);
    p.k(parama, "key");
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
    com.tencent.mm.kernel.c localc = h.aHF();
    p.j(localc, "MMKernel.network()");
    localc.aGY().b((q)new com.tencent.mm.sticker.b.b());
    AppMethodBeat.o(411);
  }
  
  public final com.tencent.mm.remoteservice.d getServerProxy()
  {
    return this.jGJ;
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
      i = ((com.tencent.mm.plugin.expt.b.b)h.ae(com.tencent.mm.plugin.expt.b.b.class)).a(b.a.vCU, 1);
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
    boolean bool = p.h(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
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
  
  public final Bundle o(Object... paramVarArgs)
  {
    AppMethodBeat.i(412);
    p.k(paramVarArgs, "params");
    Bundle localBundle = new Bundle();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      Object localObject;
      if ((paramVarArgs[i] instanceof Bundle))
      {
        localObject = paramVarArgs[i];
        if (localObject == null)
        {
          paramVarArgs = new kotlin.t("null cannot be cast to non-null type android.os.Bundle");
          AppMethodBeat.o(412);
          throw paramVarArgs;
        }
        localBundle.putBundle(String.valueOf(i), (Bundle)localObject);
      }
      for (;;)
      {
        i += 1;
        break;
        if ((paramVarArgs[i] instanceof Parcelable))
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new kotlin.t("null cannot be cast to non-null type android.os.Parcelable");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          localBundle.putParcelable(String.valueOf(i), (Parcelable)localObject);
        }
        else if ((paramVarArgs[i] instanceof ar.a))
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          Log.i("MicroMsg.EmojiCaptureProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ar.a)localObject).ordinal()) });
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          localBundle.putInt(String.valueOf(i), ((ar.a)localObject).ordinal());
        }
        else
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new kotlin.t("null cannot be cast to non-null type java.io.Serializable");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          localBundle.putSerializable(String.valueOf(i), (Serializable)localObject);
        }
      }
    }
    AppMethodBeat.o(412);
    return localBundle;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(413);
    p.k(paramString, "methodName");
    p.k(paramBundle, "data");
    Log.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        p.j(arrayOfMethod, "this.javaClass.methods");
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label280;
        }
        localObject1 = arrayOfMethod[i];
        p.j(localObject1, "mth");
        if (!n.L(((Method)localObject1).getName(), paramString, true)) {
          break label297;
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
        if ((p.h(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((localObject2 instanceof Parcelable))
          {
            paramBundle.putParcelable(this.RESULT_KEY, (Parcelable)localObject2);
            AppMethodBeat.o(413);
            return;
          }
          if (p.h("getConfigStorage", paramString)) {
            Log.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable(this.RESULT_KEY, (Serializable)localObject2);
          AppMethodBeat.o(413);
          return;
        }
      }
      label280:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          localObject2 = com.tencent.mm.remoteservice.e.class;
          continue;
          label297:
          i += 1;
        }
        else
        {
          localObject2 = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void postUploadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(399);
    p.k(paramString1, "filePath");
    p.k(paramString2, "mixingMd5");
    Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + paramString1 + ", " + paramString2);
    REMOTE_CALL("postUploadTaskRemote", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(399);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void postUploadTaskRemote(String paramString1, String paramString2)
  {
    AppMethodBeat.i(400);
    p.k(paramString1, "filePath");
    p.k(paramString2, "mixingMd5");
    Log.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + paramString1 + ", " + paramString2);
    int i = (int)u.bBQ(paramString1);
    Object localObject = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString2 = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().aud(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(400);
      return;
    }
    if (i <= 0)
    {
      paramString2.a(EmojiInfo.b.VIA);
      paramString2.a(EmojiInfo.a.VIk);
      paramString1 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiMgr().updateEmojiInfo(paramString2);
      EmojiCaptureReporter.g(paramString2.field_captureEnterTime, 4, paramString2.field_captureScene);
      AppMethodBeat.o(400);
      return;
    }
    localObject = u.buc(paramString1);
    String str = EmojiInfo.ifj() + (String)localObject;
    u.oo(paramString1, str);
    Log.i("MicroMsg.EmojiCaptureProxy", "upload file " + str + " length is " + i);
    paramString1 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    p.j(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.ctY().bxL(paramString2.getMd5());
    paramString2.setMd5((String)localObject);
    paramString2.a(EmojiInfo.a.VIl);
    paramString2.setSize((int)u.bBQ(str));
    if (ImgUtil.isWXGF(str))
    {
      paramString2.field_wxamMd5 = ((String)localObject);
      paramString2.field_externMd5 = ((String)localObject);
    }
    paramString1 = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
    p.j(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    p.j(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.ctY().K(paramString2);
    paramString1 = i.jPu;
    i.n(paramString2);
    AppMethodBeat.o(400);
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
    Object localObject = MMApplicationContext.getContext();
    p.j(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(a.i.uSR);
    p.j(localObject, "MMApplicationContext.get…g_first_open_imitate_msg)");
    new f.a(MMApplicationContext.getContext()).bBl((String)localObject).ayp(a.i.uSQ).b((f.c)b.uXm).show();
    AppMethodBeat.o(404);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(397);
    p.k(paramEmojiInfo, "emojiInfo");
    Log.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + paramEmojiInfo.getMd5());
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
    p.k(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("updateEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.getMd5();; paramBundle = null)
    {
      Log.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = h.ag(com.tencent.mm.plugin.emoji.b.d.class);
      p.j(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(398);
      return;
    }
    EmojiCaptureReporter.JP(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.uUh;
    com.tencent.mm.plugin.emojicapture.model.e.cXS();
    AppMethodBeat.o(398);
  }
  
  public final boolean useCPUCrop()
  {
    AppMethodBeat.i(401);
    Log.printInfoStack("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
    Object localObject = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
    if (localObject == null)
    {
      localObject = new kotlin.t("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(401);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(401);
    return bool;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"})
  public static final class a
  {
    public static void cYi()
    {
      AppMethodBeat.i(381);
      EmojiCaptureProxy.access$setRequestCount$cp(EmojiCaptureProxy.access$getRequestCount$cp() + 1);
      if (EmojiCaptureProxy.access$getNeedCreate$cp())
      {
        EmojiCaptureProxy.access$setNeedCreate$cp(false);
        EmojiCaptureProxy localEmojiCaptureProxy = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(MMApplicationContext.getContext()));
        p.k(localEmojiCaptureProxy, "<set-?>");
        EmojiCaptureProxy.access$setInstance$cp(localEmojiCaptureProxy);
      }
      AppMethodBeat.o(381);
    }
    
    public static void cYj()
    {
      AppMethodBeat.i(382);
      EmojiCaptureProxy.access$setRequestCount$cp(EmojiCaptureProxy.access$getRequestCount$cp() - 1);
      if (EmojiCaptureProxy.access$getRequestCount$cp() <= 0)
      {
        EmojiCaptureProxy.access$setNeedCreate$cp(true);
        com.tencent.mm.remoteservice.d locald = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
        if (locald != null)
        {
          locald.release();
          AppMethodBeat.o(382);
          return;
        }
      }
      AppMethodBeat.o(382);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class b
    implements f.c
  {
    public static final b uXm;
    
    static
    {
      AppMethodBeat.i(383);
      uXm = new b();
      AppMethodBeat.o(383);
    }
    
    public final void g(boolean paramBoolean, String paramString) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy
 * JD-Core Version:    0.7.0.1
 */