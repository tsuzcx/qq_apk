package com.tencent.mm.plugin.emojicapture.proxy;

import a.f.b.j;
import a.l;
import a.l.m;
import a.v;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.c;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.pluginsdk.g.a.a.b;
import com.tencent.mm.remoteservice.f;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.sdk.platformtools.bo;
import com.tencent.mm.sdk.platformtools.r;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.bs;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.e.a;
import com.tencent.mm.ui.widget.b.e.c;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkResUpdate", "", "subType", "", "version", "checkResUpdateRemote", "checkUseCPUCrop", "", "createEmojiInfo", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureProxy
  extends com.tencent.mm.remoteservice.a
{
  private static int evn;
  private static boolean evo;
  private static EmojiCaptureProxy lwH;
  public static final EmojiCaptureProxy.a lwI;
  private final String RESULT_KEY;
  private final com.tencent.mm.remoteservice.d evl;
  
  static
  {
    AppMethodBeat.i(2837);
    lwI = new EmojiCaptureProxy.a((byte)0);
    lwH = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(ah.getContext()));
    evo = true;
    AppMethodBeat.o(2837);
  }
  
  public EmojiCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    this.evl = paramd;
    this.RESULT_KEY = "result_key";
  }
  
  public final void checkResUpdate(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2826);
    REMOTE_CALL("checkResUpdateRemote", new Object[] { Integer.valueOf(paramInt1), Integer.valueOf(paramInt2) });
    AppMethodBeat.o(2826);
  }
  
  @f
  public final void checkResUpdateRemote(int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(2827);
    Object localObject = com.tencent.mm.plugin.emojicapture.model.a.g.luh;
    ab.i(com.tencent.mm.plugin.emojicapture.model.a.g.TAG, "checkResUpdate: ".concat(String.valueOf(paramInt1)));
    b.dmb();
    localObject = b.hc(59, paramInt1);
    if (com.tencent.mm.vfs.e.cN((String)localObject))
    {
      com.tencent.mm.plugin.emojicapture.model.a.e locale = com.tencent.mm.plugin.emojicapture.model.a.e.luf;
      bo.ii((String)localObject, com.tencent.mm.plugin.emojicapture.model.a.e.boD());
      localObject = com.tencent.mm.plugin.emojicapture.model.a.e.luf;
      if (com.tencent.mm.plugin.emojicapture.model.a.e.uJ(paramInt1).lvE > paramInt2)
      {
        com.tencent.mm.plugin.emojicapture.model.a.g.uK(paramInt1);
        AppMethodBeat.o(2827);
        return;
      }
      b.dmb();
      b.LE(59);
      AppMethodBeat.o(2827);
      return;
    }
    b.dmb();
    b.LE(59);
    AppMethodBeat.o(2827);
  }
  
  @f
  public final boolean checkUseCPUCrop()
  {
    AppMethodBeat.i(2825);
    ab.b("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
    boolean bool = ((com.tencent.mm.plugin.emojicapture.b.a.a)com.tencent.mm.plugin.emojicapture.b.a.lta.Uw()).eZM;
    AppMethodBeat.o(2825);
    return bool;
  }
  
  public final void createEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(2807);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + paramEmojiInfo.Al());
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", (Parcelable)paramEmojiInfo);
    REMOTE_CALL("createEmojiInfoRemote", new Object[] { localBundle });
    AppMethodBeat.o(2807);
  }
  
  @f
  public final void createEmojiInfoRemote(Bundle paramBundle)
  {
    AppMethodBeat.i(2815);
    j.q(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("createEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.Al();; paramBundle = null)
    {
      ab.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().j(localEmojiInfo.Al(), 0, EmojiInfo.yPo, localEmojiInfo.field_size);
      paramBundle = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      paramBundle = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().r(localEmojiInfo);
      AppMethodBeat.o(2815);
      return;
    }
    EmojiCaptureReporter.uB(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.d.ltx;
    com.tencent.mm.plugin.emojicapture.model.d.boq();
    AppMethodBeat.o(2815);
  }
  
  public final void deleteEmojiInfoByEnterTime(long paramLong)
  {
    AppMethodBeat.i(2818);
    ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(paramLong)));
    REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(2818);
  }
  
  @f
  public final void deleteEmojiInfoByEnterTimeRemote(long paramLong)
  {
    AppMethodBeat.i(2819);
    ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(paramLong)));
    Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    j.p(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((at)localObject).aUI().os(paramLong);
    AppMethodBeat.o(2819);
  }
  
  public final void deleteEmojiInfoByMd5(String paramString)
  {
    AppMethodBeat.i(2816);
    j.q(paramString, "md5");
    ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(paramString)));
    REMOTE_CALL("deleteEmojiInfoByMd5Remote", new Object[] { paramString });
    AppMethodBeat.o(2816);
  }
  
  @f
  public final void deleteEmojiInfoByMd5Remote(String paramString)
  {
    AppMethodBeat.i(2817);
    j.q(paramString, "md5");
    ab.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(paramString)));
    Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    j.p(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((at)localObject).aUI().asQ(paramString);
    AppMethodBeat.o(2817);
  }
  
  @f
  public final Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(2833);
    j.q(paramObject, "defval");
    ac.a locala = ((ac.a[])ac.a.class.getEnumConstants())[paramInt];
    ab.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    paramObject = com.tencent.mm.kernel.g.RL().Ru().get(locala, paramObject);
    AppMethodBeat.o(2833);
    return paramObject;
  }
  
  public final String getDeviceInfoConfig()
  {
    AppMethodBeat.i(2813);
    Object localObject = REMOTE_CALL("getDeviceInfoConfigRemote", new Object[0]);
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(2813);
      return localObject;
    }
    AppMethodBeat.o(2813);
    return null;
  }
  
  @f
  public final String getDeviceInfoConfigRemote()
  {
    AppMethodBeat.i(2832);
    String str = com.tencent.mm.kernel.g.RL().Rv().dyM();
    j.p(str, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
    AppMethodBeat.o(2832);
    return str;
  }
  
  public final String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(2808);
    j.q(paramString, "key");
    Object localObject = REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    ab.i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(2808);
      return "";
    }
    paramString = (String)localObject;
    AppMethodBeat.o(2808);
    return paramString;
  }
  
  @f
  public final String getDynamicConfigInMM(String paramString)
  {
    AppMethodBeat.i(2830);
    j.q(paramString, "key");
    paramString = ((com.tencent.mm.plugin.zero.b.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.zero.b.a.class)).Nq().getValue(paramString);
    AppMethodBeat.o(2830);
    return paramString;
  }
  
  public final boolean getEnableAutoRotate()
  {
    AppMethodBeat.i(2809);
    boolean bool = j.e(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(2809);
    return bool;
  }
  
  @f
  public final boolean getEnableAutoRotateRemote()
  {
    return ac.eru.eoC;
  }
  
  public final String getForbidLensId()
  {
    AppMethodBeat.i(2811);
    Object localObject = REMOTE_CALL("getDynamicConfigInMM", new Object[] { "EmotionSpringFestivalPendantBlockedIdList" });
    if ((localObject instanceof String))
    {
      localObject = (String)localObject;
      AppMethodBeat.o(2811);
      return localObject;
    }
    AppMethodBeat.o(2811);
    return null;
  }
  
  public final int getInt(ac.a parama, int paramInt)
  {
    AppMethodBeat.i(2810);
    j.q(parama, "key");
    ab.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    ab.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(2810);
      return paramInt;
    }
    paramInt = bo.getInt(localObject.toString(), paramInt);
    AppMethodBeat.o(2810);
    return paramInt;
  }
  
  public final com.tencent.mm.remoteservice.d getServerProxy()
  {
    return this.evl;
  }
  
  public final int getUseGpuSegment()
  {
    AppMethodBeat.i(2814);
    Object localObject = REMOTE_CALL("getUseGpuSegmentRemote", new Object[0]);
    if ((localObject instanceof Integer))
    {
      int i = ((Number)localObject).intValue();
      AppMethodBeat.o(2814);
      return i;
    }
    AppMethodBeat.o(2814);
    return 0;
  }
  
  @f
  public final int getUseGpuSegmentRemote()
  {
    AppMethodBeat.i(2834);
    try
    {
      i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(com.tencent.mm.plugin.expt.a.a.a.lVl, 1);
      AppMethodBeat.o(2834);
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
    AppMethodBeat.i(2812);
    boolean bool = j.e(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(2812);
    return bool;
  }
  
  @f
  public final boolean isSpringFestivalEnableRemote()
  {
    AppMethodBeat.i(2831);
    boolean bool = com.tencent.mm.emoji.a.h.isSpringFestivalEnable();
    AppMethodBeat.o(2831);
    return bool;
  }
  
  public final Bundle objectsToBundle(Object... paramVarArgs)
  {
    AppMethodBeat.i(2835);
    j.q(paramVarArgs, "params");
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
          paramVarArgs = new v("null cannot be cast to non-null type android.os.Bundle");
          AppMethodBeat.o(2835);
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
            paramVarArgs = new v("null cannot be cast to non-null type android.os.Parcelable");
            AppMethodBeat.o(2835);
            throw paramVarArgs;
          }
          localBundle.putParcelable(String.valueOf(i), (Parcelable)localObject);
        }
        else if ((paramVarArgs[i] instanceof ac.a))
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(2835);
            throw paramVarArgs;
          }
          ab.i("MicroMsg.EmojiCaptureProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ac.a)localObject).ordinal()) });
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(2835);
            throw paramVarArgs;
          }
          localBundle.putInt(String.valueOf(i), ((ac.a)localObject).ordinal());
        }
        else
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type java.io.Serializable");
            AppMethodBeat.o(2835);
            throw paramVarArgs;
          }
          localBundle.putSerializable(String.valueOf(i), (Serializable)localObject);
        }
      }
    }
    AppMethodBeat.o(2835);
    return localBundle;
  }
  
  public final void onCallback(String paramString, Bundle paramBundle, boolean paramBoolean)
  {
    AppMethodBeat.i(2836);
    j.q(paramString, "methodName");
    j.q(paramBundle, "data");
    ab.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
    Object localObject2 = null;
    for (;;)
    {
      int i;
      Object localObject1;
      try
      {
        Method[] arrayOfMethod = getClass().getMethods();
        int j = arrayOfMethod.length;
        i = 0;
        localObject1 = localObject2;
        if (i >= j) {
          break label272;
        }
        localObject1 = arrayOfMethod[i];
        j.p(localObject1, "mth");
        if (!m.I(((Method)localObject1).getName(), paramString, true)) {
          break label289;
        }
      }
      catch (Exception paramString)
      {
        ab.e("MicroMsg.EmojiCaptureProxy", "exception:%s", new Object[] { bo.l((Throwable)paramString) });
        AppMethodBeat.o(2836);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent((Class)localObject2))
      {
        localObject2 = getArgs(paramBundle);
        localObject2 = ((Method)localObject1).invoke(this, Arrays.copyOf((Object[])localObject2, localObject2.length));
        if ((j.e(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((localObject2 instanceof Parcelable))
          {
            paramBundle.putParcelable(this.RESULT_KEY, (Parcelable)localObject2);
            AppMethodBeat.o(2836);
            return;
          }
          if (j.e("getConfigStorage", paramString)) {
            ab.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable(this.RESULT_KEY, (Serializable)localObject2);
          AppMethodBeat.o(2836);
          return;
        }
      }
      label272:
      if (localObject1 != null) {
        if (paramBoolean)
        {
          localObject2 = com.tencent.mm.remoteservice.e.class;
          continue;
          label289:
          i += 1;
        }
        else
        {
          localObject2 = f.class;
        }
      }
    }
  }
  
  public final void postUploadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2822);
    j.q(paramString1, "filePath");
    j.q(paramString2, "mixingMd5");
    ab.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + paramString1 + ", " + paramString2);
    REMOTE_CALL("postUploadTaskRemote", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(2822);
  }
  
  @f
  public final void postUploadTaskRemote(String paramString1, String paramString2)
  {
    AppMethodBeat.i(2823);
    j.q(paramString1, "filePath");
    j.q(paramString2, "mixingMd5");
    ab.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + paramString1 + ", " + paramString2);
    int i = (int)com.tencent.mm.vfs.e.avI(paramString1);
    Object localObject = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString2 = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().Kt(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(2823);
      return;
    }
    if (i <= 0)
    {
      paramString2.a(EmojiInfo.b.yPT);
      paramString2.a(EmojiInfo.a.yPD);
      paramString1 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiMgr().updateEmojiInfo(paramString2);
      EmojiCaptureReporter.g(paramString2.field_captureEnterTime, 4, paramString2.field_captureScene);
      AppMethodBeat.o(2823);
      return;
    }
    localObject = com.tencent.mm.vfs.e.avP(paramString1);
    String str = EmojiInfo.dQD() + (String)localObject;
    com.tencent.mm.vfs.e.aT(paramString1, str);
    ab.i("MicroMsg.EmojiCaptureProxy", "upload file " + str + " length is " + i);
    paramString1 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    j.p(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.aUI().asQ(paramString2.Al());
    paramString2.wW((String)localObject);
    paramString2.a(EmojiInfo.a.yPE);
    paramString2.setSize((int)com.tencent.mm.vfs.e.avI(str));
    if (r.aoZ(str))
    {
      paramString2.field_wxamMd5 = ((String)localObject);
      paramString2.field_externMd5 = ((String)localObject);
    }
    paramString1 = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
    j.p(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    j.p(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.aUI().H(paramString2);
    paramString1 = com.tencent.mm.emoji.d.d.eyp;
    com.tencent.mm.emoji.d.d.k(paramString2);
    AppMethodBeat.o(2823);
  }
  
  public final void showImitateDialog()
  {
    AppMethodBeat.i(2828);
    REMOTE_CALL("showImitateDialogRemote", new Object[0]);
    AppMethodBeat.o(2828);
  }
  
  @f
  public final void showImitateDialogRemote()
  {
    AppMethodBeat.i(2829);
    Object localObject = ah.getContext();
    j.p(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131298976);
    new e.a(ah.getContext()).avu((String)localObject).Rm(2131298975).b((e.c)EmojiCaptureProxy.b.lwJ).show();
    AppMethodBeat.o(2829);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(2820);
    j.q(paramEmojiInfo, "emojiInfo");
    ab.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + paramEmojiInfo.Al());
    Bundle localBundle = new Bundle();
    localBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    localBundle.putParcelable("emoji", (Parcelable)paramEmojiInfo);
    REMOTE_CALL("updateEmojiInfoRemote", new Object[] { localBundle });
    AppMethodBeat.o(2820);
  }
  
  @f
  public final void updateEmojiInfoRemote(Bundle paramBundle)
  {
    AppMethodBeat.i(2821);
    j.q(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("updateEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.Al();; paramBundle = null)
    {
      ab.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = com.tencent.mm.kernel.g.G(com.tencent.mm.plugin.emoji.b.d.class);
      j.p(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(2821);
      return;
    }
    EmojiCaptureReporter.uB(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.d.ltx;
    com.tencent.mm.plugin.emojicapture.model.d.boq();
    AppMethodBeat.o(2821);
  }
  
  public final boolean useCPUCrop()
  {
    AppMethodBeat.i(2824);
    ab.b("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
    Object localObject = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(2824);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(2824);
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy
 * JD-Core Version:    0.7.0.1
 */