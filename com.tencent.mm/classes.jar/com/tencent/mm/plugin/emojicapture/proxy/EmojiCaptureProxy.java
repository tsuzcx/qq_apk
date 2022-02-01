package com.tencent.mm.plugin.emojicapture.proxy;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.q;
import com.tencent.mm.compatible.deviceinfo.ae;
import com.tencent.mm.compatible.deviceinfo.c;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.b.a.a;
import com.tencent.mm.plugin.expt.a.b.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.aj;
import com.tencent.mm.sdk.platformtools.t;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.storage.aw;
import com.tencent.mm.storage.emotion.EmojiInfo;
import com.tencent.mm.storage.emotion.EmojiInfo.a;
import com.tencent.mm.storage.emotion.EmojiInfo.b;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import d.g.b.k;
import d.v;
import java.io.Serializable;
import java.lang.reflect.Method;
import java.util.Arrays;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "Lcom/tencent/mm/remoteservice/BaseClientRequest;", "serverProxy", "Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "(Lcom/tencent/mm/remoteservice/RemoteServiceProxy;)V", "RESULT_KEY", "", "getServerProxy", "()Lcom/tencent/mm/remoteservice/RemoteServiceProxy;", "checkUseCPUCrop", "", "createEmojiInfo", "", "emojiInfo", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "createEmojiInfoRemote", "bundle", "Landroid/os/Bundle;", "deleteEmojiInfoByEnterTime", "timeEnter", "", "deleteEmojiInfoByEnterTimeRemote", "deleteEmojiInfoByMd5", "md5", "deleteEmojiInfoByMd5Remote", "getConfigStorage", "", "_key", "", "defval", "getDeviceInfoConfig", "getDeviceInfoConfigRemote", "getDynamicConfig", "key", "getDynamicConfigInMM", "getEnableAutoRotate", "getEnableAutoRotateRemote", "getForbidLensId", "getInt", "Lcom/tencent/mm/storage/ConstantsStorage$BusinessInfoKey;", "defva", "getLensList", "getLensListRemote", "getUseGpuSegment", "getUseGpuSegmentRemote", "isSpringFestivalEnable", "isSpringFestivalEnableRemote", "objectsToBundle", "params", "", "([Ljava/lang/Object;)Landroid/os/Bundle;", "onCallback", "methodName", "data", "clientCall", "postUploadTask", "filePath", "mixingMd5", "postUploadTaskRemote", "showImitateDialog", "showImitateDialogRemote", "updateEmojiInfo", "updateEmojiInfoRemote", "useCPUCrop", "Companion", "plugin-emojicapture_release"})
public final class EmojiCaptureProxy
  extends com.tencent.mm.remoteservice.a
{
  private static int fLq;
  private static boolean fLr;
  private static EmojiCaptureProxy oNc;
  public static final a oNd;
  private final String RESULT_KEY;
  private final com.tencent.mm.remoteservice.d fLo;
  
  static
  {
    AppMethodBeat.i(414);
    oNd = new a((byte)0);
    oNc = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(aj.getContext()));
    fLr = true;
    AppMethodBeat.o(414);
  }
  
  public EmojiCaptureProxy(com.tencent.mm.remoteservice.d paramd)
  {
    super(paramd);
    this.fLo = paramd;
    this.RESULT_KEY = "result_key";
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean checkUseCPUCrop()
  {
    AppMethodBeat.i(402);
    ad.m("MicroMsg.EmojiCaptureProxy", "checkUseCPUCrop", new Object[0]);
    boolean bool = ((a.a)com.tencent.mm.plugin.emojicapture.b.a.oJw.ajp()).gwB;
    AppMethodBeat.o(402);
    return bool;
  }
  
  public final void createEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(384);
    k.h(paramEmojiInfo, "emojiInfo");
    ad.i("MicroMsg.EmojiCaptureProxy", "createEmojiInfo: " + paramEmojiInfo.JS());
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
    k.h(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("createEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.JS();; paramBundle = null)
    {
      ad.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().l(localEmojiInfo.JS(), 0, EmojiInfo.LBY, localEmojiInfo.field_size);
      paramBundle = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      paramBundle = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().t(localEmojiInfo);
      AppMethodBeat.o(392);
      return;
    }
    EmojiCaptureReporter.AL(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.oKa;
    com.tencent.mm.plugin.emojicapture.model.e.bYb();
    AppMethodBeat.o(392);
  }
  
  public final void deleteEmojiInfoByEnterTime(long paramLong)
  {
    AppMethodBeat.i(395);
    ad.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTime: ".concat(String.valueOf(paramLong)));
    REMOTE_CALL("deleteEmojiInfoByEnterTimeRemote", new Object[] { Long.valueOf(paramLong) });
    AppMethodBeat.o(395);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByEnterTimeRemote(long paramLong)
  {
    AppMethodBeat.i(396);
    ad.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByEnterTimeRemote: ".concat(String.valueOf(paramLong)));
    Object localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    k.g(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((aw)localObject).bxR().wq(paramLong);
    AppMethodBeat.o(396);
  }
  
  public final void deleteEmojiInfoByMd5(String paramString)
  {
    AppMethodBeat.i(393);
    k.h(paramString, "md5");
    ad.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfo: ".concat(String.valueOf(paramString)));
    REMOTE_CALL("deleteEmojiInfoByMd5Remote", new Object[] { paramString });
    AppMethodBeat.o(393);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void deleteEmojiInfoByMd5Remote(String paramString)
  {
    AppMethodBeat.i(394);
    k.h(paramString, "md5");
    ad.i("MicroMsg.EmojiCaptureProxy", "deleteEmojiInfoByMd5Remote: ".concat(String.valueOf(paramString)));
    Object localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    localObject = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiStorageMgr();
    k.g(localObject, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    ((aw)localObject).bxR().aJy(paramString);
    AppMethodBeat.o(394);
  }
  
  @com.tencent.mm.remoteservice.f
  public final Object getConfigStorage(int paramInt, Object paramObject)
  {
    AppMethodBeat.i(408);
    k.h(paramObject, "defval");
    ae.a locala = ((ae.a[])ae.a.class.getEnumConstants())[paramInt];
    ad.i("MicroMsg.EmojiCaptureProxy", "getConfigStorage, %s %s", new Object[] { locala, paramObject });
    paramObject = g.afB().afk().get(locala, paramObject);
    AppMethodBeat.o(408);
    return paramObject;
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
    String str = g.afB().afl().eMW();
    k.g(str, "storage().getServerCfgIn…RINFO_SERVER_CONFIG_INFO)");
    AppMethodBeat.o(407);
    return str;
  }
  
  public final String getDynamicConfig(String paramString)
  {
    AppMethodBeat.i(385);
    k.h(paramString, "key");
    Object localObject = REMOTE_CALL("getDynamicConfigInMM", new Object[] { paramString });
    ad.i("MicroMsg.EmojiCaptureProxy", "getDynamicConfig, key: %s, value: %s", new Object[] { paramString, localObject });
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
    k.h(paramString, "key");
    paramString = ((com.tencent.mm.plugin.zero.b.a)g.ab(com.tencent.mm.plugin.zero.b.a.class)).Zd().getValue(paramString);
    AppMethodBeat.o(405);
    return paramString;
  }
  
  public final boolean getEnableAutoRotate()
  {
    AppMethodBeat.i(386);
    boolean bool = k.g(REMOTE_CALL("getEnableAutoRotateRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(386);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean getEnableAutoRotateRemote()
  {
    return ae.fFw.fBH;
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
  
  public final int getInt(ae.a parama, int paramInt)
  {
    AppMethodBeat.i(387);
    k.h(parama, "key");
    ad.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s", new Object[] { parama, Integer.valueOf(paramInt) });
    Object localObject = REMOTE_CALL("getConfigStorage", new Object[] { parama, Integer.valueOf(paramInt) });
    ad.i("MicroMsg.EmojiCaptureProxy", "getInt %s %s and get val %s", new Object[] { parama, Integer.valueOf(paramInt), localObject });
    if (localObject == null)
    {
      AppMethodBeat.o(387);
      return paramInt;
    }
    paramInt = com.tencent.mm.sdk.platformtools.bt.getInt(localObject.toString(), paramInt);
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
    com.tencent.mm.kernel.b localb = g.afA();
    k.g(localb, "MMKernel.network()");
    localb.aeS().b((com.tencent.mm.al.n)new com.tencent.mm.sticker.b.b());
    AppMethodBeat.o(411);
  }
  
  public final com.tencent.mm.remoteservice.d getServerProxy()
  {
    return this.fLo;
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
      i = ((com.tencent.mm.plugin.expt.a.b)g.ab(com.tencent.mm.plugin.expt.a.b.class)).a(b.a.pox, 1);
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
    boolean bool = k.g(REMOTE_CALL("isSpringFestivalEnableRemote", new Object[0]), Boolean.TRUE);
    AppMethodBeat.o(389);
    return bool;
  }
  
  @com.tencent.mm.remoteservice.f
  public final boolean isSpringFestivalEnableRemote()
  {
    AppMethodBeat.i(406);
    boolean bool = com.tencent.mm.emoji.a.l.isSpringFestivalEnable();
    AppMethodBeat.o(406);
    return bool;
  }
  
  public final Bundle objectsToBundle(Object... paramVarArgs)
  {
    AppMethodBeat.i(412);
    k.h(paramVarArgs, "params");
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
            paramVarArgs = new v("null cannot be cast to non-null type android.os.Parcelable");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          localBundle.putParcelable(String.valueOf(i), (Parcelable)localObject);
        }
        else if ((paramVarArgs[i] instanceof ae.a))
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          ad.i("MicroMsg.EmojiCaptureProxy", "objectsToBundle: %s", new Object[] { Integer.valueOf(((ae.a)localObject).ordinal()) });
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type com.tencent.mm.storage.ConstantsStorage.BusinessInfoKey");
            AppMethodBeat.o(412);
            throw paramVarArgs;
          }
          localBundle.putInt(String.valueOf(i), ((ae.a)localObject).ordinal());
        }
        else
        {
          localObject = paramVarArgs[i];
          if (localObject == null)
          {
            paramVarArgs = new v("null cannot be cast to non-null type java.io.Serializable");
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
    k.h(paramString, "methodName");
    k.h(paramBundle, "data");
    ad.i("MicroMsg.EmojiCaptureProxy", "class:%s, method:%s, clientCall:%B", new Object[] { getClass().getName(), paramString, Boolean.valueOf(paramBoolean) });
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
        k.g(localObject1, "mth");
        if (!d.n.n.I(((Method)localObject1).getName(), paramString, true)) {
          break label289;
        }
      }
      catch (Exception paramString)
      {
        ad.e("MicroMsg.EmojiCaptureProxy", "exception:%s", new Object[] { com.tencent.mm.sdk.platformtools.bt.m((Throwable)paramString) });
        AppMethodBeat.o(413);
        return;
      }
      if (((Method)localObject1).isAnnotationPresent((Class)localObject2))
      {
        localObject2 = getArgs(paramBundle);
        localObject2 = ((Method)localObject1).invoke(this, Arrays.copyOf((Object[])localObject2, localObject2.length));
        if ((k.g(((Method)localObject1).getReturnType(), Void.TYPE) ^ true))
        {
          if ((localObject2 instanceof Parcelable))
          {
            paramBundle.putParcelable(this.RESULT_KEY, (Parcelable)localObject2);
            AppMethodBeat.o(413);
            return;
          }
          if (k.g("getConfigStorage", paramString)) {
            ad.i("MicroMsg.EmojiCaptureProxy", "put result as Serializable: %s", new Object[] { (Serializable)localObject2 });
          }
          paramBundle.putSerializable(this.RESULT_KEY, (Serializable)localObject2);
          AppMethodBeat.o(413);
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
          localObject2 = com.tencent.mm.remoteservice.f.class;
        }
      }
    }
  }
  
  public final void postUploadTask(String paramString1, String paramString2)
  {
    AppMethodBeat.i(399);
    k.h(paramString1, "filePath");
    k.h(paramString2, "mixingMd5");
    ad.i("MicroMsg.EmojiCaptureProxy", "postUploadTask: " + paramString1 + ", " + paramString2);
    REMOTE_CALL("postUploadTaskRemote", new Object[] { paramString1, paramString2 });
    AppMethodBeat.o(399);
  }
  
  @com.tencent.mm.remoteservice.f
  public final void postUploadTaskRemote(String paramString1, String paramString2)
  {
    AppMethodBeat.i(400);
    k.h(paramString1, "filePath");
    k.h(paramString2, "mixingMd5");
    ad.i("MicroMsg.EmojiCaptureProxy", "postUploadTaskRemote: " + paramString1 + ", " + paramString2);
    int i = (int)com.tencent.mm.vfs.i.aMN(paramString1);
    Object localObject = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(localObject, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString2 = ((com.tencent.mm.plugin.emoji.b.d)localObject).getEmojiMgr().Tz(paramString2);
    if (paramString2 == null)
    {
      AppMethodBeat.o(400);
      return;
    }
    if (i <= 0)
    {
      paramString2.a(EmojiInfo.b.FBN);
      paramString2.a(EmojiInfo.a.FBx);
      paramString1 = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiMgr().updateEmojiInfo(paramString2);
      EmojiCaptureReporter.g(paramString2.field_captureEnterTime, 4, paramString2.field_captureScene);
      AppMethodBeat.o(400);
      return;
    }
    localObject = com.tencent.mm.vfs.i.aEN(paramString1);
    String str = EmojiInfo.gac() + (String)localObject;
    com.tencent.mm.vfs.i.lD(paramString1, str);
    ad.i("MicroMsg.EmojiCaptureProxy", "upload file " + str + " length is " + i);
    paramString1 = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    k.g(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.bxR().aJy(paramString2.JS());
    paramString2.Cb((String)localObject);
    paramString2.a(EmojiInfo.a.FBy);
    paramString2.setSize((int)com.tencent.mm.vfs.i.aMN(str));
    if (t.aFn(str))
    {
      paramString2.field_wxamMd5 = ((String)localObject);
      paramString2.field_externMd5 = ((String)localObject);
    }
    paramString1 = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
    k.g(paramString1, "MMKernel.plugin(IPluginEmoji::class.java)");
    paramString1 = ((com.tencent.mm.plugin.emoji.b.d)paramString1).getEmojiStorageMgr();
    k.g(paramString1, "MMKernel.plugin(IPluginE…ass.java).emojiStorageMgr");
    paramString1.bxR().J(paramString2);
    paramString1 = com.tencent.mm.emoji.c.i.fSK;
    com.tencent.mm.emoji.c.i.o(paramString2);
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
    Object localObject = aj.getContext();
    k.g(localObject, "MMApplicationContext.getContext()");
    localObject = ((Context)localObject).getResources().getString(2131758071);
    new f.a(aj.getContext()).aMo((String)localObject).aaF(2131758070).b((f.c)EmojiCaptureProxy.b.oNe).show();
    AppMethodBeat.o(404);
  }
  
  public final void updateEmojiInfo(EmojiInfo paramEmojiInfo)
  {
    AppMethodBeat.i(397);
    k.h(paramEmojiInfo, "emojiInfo");
    ad.i("MicroMsg.EmojiCaptureProxy", "updateEmojiInfo: " + paramEmojiInfo.JS());
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
    k.h(paramBundle, "bundle");
    paramBundle.setClassLoader(EmojiInfo.class.getClassLoader());
    EmojiInfo localEmojiInfo = (EmojiInfo)paramBundle.getParcelable("emoji");
    StringBuilder localStringBuilder = new StringBuilder("updateEmojiInfoRemote: ");
    if (localEmojiInfo != null) {}
    for (paramBundle = localEmojiInfo.JS();; paramBundle = null)
    {
      ad.i("MicroMsg.EmojiCaptureProxy", paramBundle);
      if (localEmojiInfo == null) {
        break;
      }
      paramBundle = g.ad(com.tencent.mm.plugin.emoji.b.d.class);
      k.g(paramBundle, "MMKernel.plugin(IPluginEmoji::class.java)");
      ((com.tencent.mm.plugin.emoji.b.d)paramBundle).getEmojiMgr().updateEmojiInfo(localEmojiInfo);
      AppMethodBeat.o(398);
      return;
    }
    EmojiCaptureReporter.AL(31);
    paramBundle = com.tencent.mm.plugin.emojicapture.model.e.oKa;
    com.tencent.mm.plugin.emojicapture.model.e.bYb();
    AppMethodBeat.o(398);
  }
  
  public final boolean useCPUCrop()
  {
    AppMethodBeat.i(401);
    ad.m("MicroMsg.EmojiCaptureProxy", "useCPUCrop", new Object[0]);
    Object localObject = REMOTE_CALL("checkUseCPUCrop", new Object[0]);
    if (localObject == null)
    {
      localObject = new v("null cannot be cast to non-null type kotlin.Boolean");
      AppMethodBeat.o(401);
      throw ((Throwable)localObject);
    }
    boolean bool = ((Boolean)localObject).booleanValue();
    AppMethodBeat.o(401);
    return bool;
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy$Companion;", "", "()V", "TAG", "", "instance", "Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "getInstance", "()Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;", "setInstance", "(Lcom/tencent/mm/plugin/emojicapture/proxy/EmojiCaptureProxy;)V", "needCreate", "", "requestCount", "", "requestConnect", "", "tryRelease", "plugin-emojicapture_release"})
  public static final class a
  {
    public static void aba()
    {
      AppMethodBeat.i(381);
      EmojiCaptureProxy.access$setRequestCount$cp(EmojiCaptureProxy.access$getRequestCount$cp() + 1);
      if (EmojiCaptureProxy.access$getNeedCreate$cp())
      {
        EmojiCaptureProxy.access$setNeedCreate$cp(false);
        EmojiCaptureProxy localEmojiCaptureProxy = new EmojiCaptureProxy(new com.tencent.mm.remoteservice.d(aj.getContext()));
        k.h(localEmojiCaptureProxy, "<set-?>");
        EmojiCaptureProxy.access$setInstance$cp(localEmojiCaptureProxy);
      }
      AppMethodBeat.o(381);
    }
    
    public static void bYs()
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy
 * JD-Core Version:    0.7.0.1
 */