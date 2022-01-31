package com.tencent.mm.plugin.emojicapture.model;

import a.f.b.j;
import a.l;
import a.l.m;
import android.content.Context;
import android.content.DialogInterface.OnClickListener;
import android.content.DialogInterface.OnDismissListener;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.compatible.e.ac;
import com.tencent.mm.compatible.e.w;
import com.tencent.mm.compatible.util.k;
import com.tencent.mm.kernel.b.f;
import com.tencent.mm.kernel.e.c;
import com.tencent.mm.plugin.emojicapture.api.EmojiCaptureReporter;
import com.tencent.mm.plugin.emojicapture.api.b.a;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy;
import com.tencent.mm.plugin.emojicapture.proxy.EmojiCaptureProxy.a;
import com.tencent.mm.plugin.expt.a.a.a;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.sdk.platformtools.ah;
import com.tencent.mm.storage.ac.a;
import com.tencent.mm.storage.z;
import com.tencent.mm.ui.widget.b.c.a;
import com.tencent.ttpic.VideoModule;
import com.tencent.ttpic.baseutils.LogUtils;
import com.tencent.ttpic.device.DeviceUtils;
import com.tencent.ttpic.util.FilterUtils;
import com.tencent.ttpic.util.ResourcePathMapper;
import com.tencent.ttpic.util.ResourcePathMapper.MODE;
import com.tencent.view.raw.FilterRawGet;
import com.tencent.view.raw.FilterRawGet.GetInputStream;
import com.tencent.ytcommon.util.YTCommonInterface;
import java.io.File;
import java.io.InputStream;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/emojicapture/model/PluginEmojiCapture;", "Lcom/tencent/mm/kernel/plugin/Plugin;", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture;", "Lcom/tencent/mm/kernel/api/ICoreAccountCallback;", "()V", "TAG", "", "TAG$1", "isInit", "", "()Z", "setInit", "(Z)V", "cameraCheck", "context", "Landroid/content/Context;", "execute", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "firstOpenCheck", "onResult", "Lcom/tencent/mm/plugin/emojicapture/api/IPluginEmojiCapture$CheckCallback;", "getExternalFilesDir", "Ljava/io/File;", "folder", "getRes", "Lcom/tencent/mm/plugin/emojicapture/api/IEmojiStickerRes;", "getVideoLutFileDir", "getYtDetectModelBackupFileDir", "getYtDetectModelFileDir", "initCheck", "initLibrary", "name", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "onAccountRelease", "overSizeCheck", "preCheck", "scene", "", "Companion", "plugin-emojicapture_release"})
public final class PluginEmojiCapture
  extends f
  implements com.tencent.mm.kernel.api.c, com.tencent.mm.plugin.emojicapture.api.b
{
  private static final int MIN_STORAGE_SIZE = 52428800;
  private static final String TAG = "MicroMsg.PlguinEmojiCapture.Companion";
  private static final String ltA = "weishi_yt_model";
  private static final String ltB = "weishi_yt_backup_model";
  public static final PluginEmojiCapture.a ltC;
  private static final String ltz = "weishi_video_lut";
  private boolean bRB;
  private final String eYr = "MicroMsg.PluginEmojiCapture";
  
  static
  {
    AppMethodBeat.i(2634);
    ltC = new PluginEmojiCapture.a((byte)0);
    TAG = "MicroMsg.PlguinEmojiCapture.Companion";
    MIN_STORAGE_SIZE = 52428800;
    ltz = "weishi_video_lut";
    ltA = "weishi_yt_model";
    ltB = "weishi_yt_backup_model";
    AppMethodBeat.o(2634);
  }
  
  private final boolean cameraCheck(Context paramContext)
  {
    AppMethodBeat.i(2629);
    if ((com.tencent.mm.plugin.voip.e.bN(paramContext)) || (com.tencent.mm.plugin.voip.e.bO(paramContext)) || (com.tencent.mm.bg.e.bM(paramContext)))
    {
      ab.i(this.eYr, "camera check false");
      AppMethodBeat.o(2629);
      return false;
    }
    AppMethodBeat.o(2629);
    return true;
  }
  
  private final void firstOpenCheck(Context paramContext, b.a parama)
  {
    AppMethodBeat.i(2627);
    Object localObject = com.tencent.mm.kernel.g.RL();
    j.p(localObject, "MMKernel.storage()");
    localObject = ((com.tencent.mm.kernel.e)localObject).Ru().i(ac.a.yKo);
    if ((localObject != null) && ((localObject instanceof Boolean)) && (((Boolean)localObject).booleanValue()))
    {
      parama.gR(true);
      AppMethodBeat.o(2627);
      return;
    }
    localObject = com.tencent.mm.ao.b.agp();
    j.p(localObject, "FontResLogic.getInstance()");
    if (!((com.tencent.mm.ao.b)localObject).agq()) {
      h.qsU.B(933L, 2L);
    }
    localObject = BitmapFactory.decodeResource(paramContext.getResources(), 2130838601);
    new c.a(paramContext).Rb(2131298978).a((Bitmap)localObject, false, 0).Rf(2131298977).Ri(2131298975).a((DialogInterface.OnDismissListener)new PluginEmojiCapture.b(parama)).aLZ().show();
    paramContext = com.tencent.mm.kernel.g.RL();
    j.p(paramContext, "MMKernel.storage()");
    paramContext.Ru().set(ac.a.yKo, Boolean.TRUE);
    ab.i(this.eYr, "first open check false");
    AppMethodBeat.o(2627);
  }
  
  private final void initCheck()
  {
    AppMethodBeat.i(2622);
    int i;
    if (!this.bRB)
    {
      int j = -1;
      i = j;
      try
      {
        initLibrary();
        i = j;
        VideoModule.init(ah.getContext(), getVideoLutFileDir(), getYtDetectModelFileDir(), getYtDetectModelBackupFileDir());
        i = j;
        ResourcePathMapper.init(ResourcePathMapper.MODE.LOCAL);
        i = j;
        FilterUtils.checkLibraryInit();
        i = j;
        j = YTCommonInterface.initAuth(ah.getContext(), "rel_wechat.lic", 0, false);
        i = j;
        ab.i(this.eYr, "init VideoModule initAuth: %s", new Object[] { Integer.valueOf(j) });
        i = j;
      }
      catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
      {
        for (;;)
        {
          d locald;
          ab.printErrStackTrace(this.eYr, (Throwable)localUnsatisfiedLinkError, "init error", new Object[0]);
        }
        FilterRawGet.setGetInputStream((FilterRawGet.GetInputStream)new c(this));
      }
      if (i != 0)
      {
        EmojiCaptureReporter.uB(17);
        locald = d.ltx;
        d.bon();
        this.bRB = false;
        AppMethodBeat.o(2622);
        return;
      }
    }
    try
    {
      i = ((com.tencent.mm.plugin.expt.a.a)com.tencent.mm.kernel.g.E(com.tencent.mm.plugin.expt.a.a.class)).a(a.a.lVk, 1);
      ab.i(this.eYr, "enableLog:".concat(String.valueOf(i)));
      if (i == 0)
      {
        ab.i(this.eYr, "disable renderUtils log");
        com.tencent.view.g.sa(false);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.eYr, (Throwable)localException, "get enable log error", new Object[0]);
      }
    }
    this.bRB = true;
    AppMethodBeat.o(2622);
  }
  
  private final void initLibrary()
  {
    AppMethodBeat.i(2623);
    ab.i(this.eYr, "init load pt library");
    k.a("image_filter_common", PluginEmojiCapture.class.getClassLoader());
    k.a("image_filter_gpu", PluginEmojiCapture.class.getClassLoader());
    k.a("format_convert", PluginEmojiCapture.class.getClassLoader());
    k.a("YTCommon", PluginEmojiCapture.class.getClassLoader());
    k.a("YTFaceTrackPro", PluginEmojiCapture.class.getClassLoader());
    k.a("algo_youtu_jni", PluginEmojiCapture.class.getClassLoader());
    k.a("pitu_tools", PluginEmojiCapture.class.getClassLoader());
    Object localObject = EmojiCaptureProxy.lwI;
    EmojiCaptureProxy.a.boO();
    localObject = EmojiCaptureProxy.lwI;
    localObject = EmojiCaptureProxy.access$getInstance$cp().getServerProxy();
    if (localObject != null)
    {
      ((com.tencent.mm.remoteservice.d)localObject).connect((Runnable)new d(this));
      AppMethodBeat.o(2623);
      return;
    }
    AppMethodBeat.o(2623);
  }
  
  private final boolean overSizeCheck(Context paramContext)
  {
    AppMethodBeat.i(2628);
    com.tencent.mm.emoji.a.e locale = com.tencent.mm.emoji.a.e.ewz;
    if (com.tencent.mm.emoji.a.e.OD())
    {
      new c.a(paramContext).Rb(2131298982).Rf(2131298981).Ri(2131298980).a((DialogInterface.OnClickListener)new PluginEmojiCapture.e(paramContext)).Rj(2131298979).aLZ().show();
      ab.i(this.eYr, "over size check false");
      AppMethodBeat.o(2628);
      return false;
    }
    AppMethodBeat.o(2628);
    return true;
  }
  
  public final void execute(com.tencent.mm.kernel.b.g paramg)
  {
    AppMethodBeat.i(2621);
    ab.i(this.eYr, "Plugin EmojiCapture Execute");
    if (paramg != null) {}
    for (paramg = Boolean.valueOf(paramg.mI(":tools"));; paramg = null)
    {
      if (paramg == null) {
        j.ebi();
      }
      if (paramg.booleanValue()) {
        initCheck();
      }
      AppMethodBeat.o(2621);
      return;
    }
  }
  
  public final File getExternalFilesDir(Context paramContext, String paramString)
  {
    Object localObject4 = null;
    Object localObject3 = null;
    AppMethodBeat.i(2633);
    j.q(paramContext, "context");
    j.q(paramString, "folder");
    Object localObject1 = localObject4;
    if (DeviceUtils.isExternalStorageAvailable())
    {
      localObject1 = localObject4;
      if (!DeviceUtils.isExternalStorageSpaceEnough(MIN_STORAGE_SIZE)) {}
    }
    try
    {
      localObject1 = paramContext.getExternalFilesDir(null);
      if (localObject1 == null)
      {
        localObject1 = "/Android/data/" + paramContext.getPackageName() + "/files/";
        localObject3 = localObject1;
        if (TextUtils.isEmpty((CharSequence)localObject1))
        {
          paramContext = paramContext.getFilesDir();
          j.p(paramContext, "context.filesDir");
          localObject3 = paramContext.getPath();
        }
        paramContext = new File((String)localObject3 + File.separator + paramString);
      }
      try
      {
        if ((paramContext.exists()) && (paramContext.isFile())) {
          paramContext.delete();
        }
        if (!paramContext.exists()) {
          paramContext.mkdirs();
        }
      }
      catch (Exception paramString)
      {
        for (;;)
        {
          Object localObject2;
          LogUtils.e((Throwable)paramString);
        }
      }
      AppMethodBeat.o(2633);
      return paramContext;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        ab.printErrStackTrace(this.eYr, (Throwable)localException, "", new Object[0]);
        localObject2 = localObject3;
        continue;
        localObject2 = ((File)localObject2).getPath();
      }
    }
  }
  
  public final com.tencent.mm.plugin.emojicapture.api.a getRes()
  {
    return (com.tencent.mm.plugin.emojicapture.api.a)com.tencent.mm.plugin.emojicapture.model.a.e.luf;
  }
  
  public final String getVideoLutFileDir()
  {
    AppMethodBeat.i(2630);
    Object localObject = ah.getContext();
    j.p(localObject, "MMApplicationContext.getContext()");
    localObject = getExternalFilesDir((Context)localObject, ltz).getPath();
    j.p(localObject, "getExternalFilesDir(MMAp… VIDEO_LUT_FILE_DIR).path");
    AppMethodBeat.o(2630);
    return localObject;
  }
  
  public final String getYtDetectModelBackupFileDir()
  {
    AppMethodBeat.i(2632);
    Object localObject = ah.getContext();
    j.p(localObject, "MMApplicationContext.getContext()");
    localObject = getExternalFilesDir((Context)localObject, ltB).getPath();
    j.p(localObject, "getExternalFilesDir(MMAp…DEL_BACKUP_FILE_DIR).path");
    AppMethodBeat.o(2632);
    return localObject;
  }
  
  public final String getYtDetectModelFileDir()
  {
    AppMethodBeat.i(2631);
    Object localObject = Environment.getExternalStorageDirectory();
    j.p(localObject, "Environment.getExternalStorageDirectory()");
    localObject = ((File)localObject).getPath();
    File localFile = new File((String)localObject + File.separator + ltA);
    if (!localFile.isDirectory()) {
      localFile.mkdirs();
    }
    if (DeviceUtils.canWriteFile(localFile.getAbsolutePath()))
    {
      localObject = localFile.getAbsolutePath();
      j.p(localObject, "dir.absolutePath");
      AppMethodBeat.o(2631);
      return localObject;
    }
    j.p(localObject, "root");
    AppMethodBeat.o(2631);
    return localObject;
  }
  
  public final boolean isInit()
  {
    return this.bRB;
  }
  
  public final String name()
  {
    return "plugin-emojicapture";
  }
  
  public final void onAccountInitialized(e.c paramc)
  {
    AppMethodBeat.i(2625);
    ab.i(this.eYr, "onAccountInitialized: ");
    com.tencent.mm.pluginsdk.cmd.b.a((com.tencent.mm.pluginsdk.cmd.a)new b(), new String[] { "//emojicapture" });
    paramc = com.tencent.mm.plugin.emojicapture.model.a.g.luh;
    com.tencent.mm.plugin.emojicapture.model.a.g.init();
    AppMethodBeat.o(2625);
  }
  
  public final void onAccountRelease()
  {
    AppMethodBeat.i(2626);
    ab.i(this.eYr, "onAccountRelease: ");
    com.tencent.mm.pluginsdk.cmd.b.N(new String[] { "//emojicapture" });
    com.tencent.mm.plugin.emojicapture.model.a.g localg = com.tencent.mm.plugin.emojicapture.model.a.g.luh;
    com.tencent.mm.plugin.emojicapture.model.a.g.destroy();
    AppMethodBeat.o(2626);
  }
  
  public final void preCheck(Context paramContext, int paramInt, b.a parama)
  {
    AppMethodBeat.i(2624);
    j.q(paramContext, "context");
    j.q(parama, "onResult");
    com.tencent.mm.ao.b.agp();
    com.tencent.mm.ao.b.agr();
    if ((cameraCheck(paramContext)) && (overSizeCheck(paramContext)))
    {
      if (paramInt != 2)
      {
        parama.gR(true);
        AppMethodBeat.o(2624);
        return;
      }
      firstOpenCheck(paramContext, parama);
      AppMethodBeat.o(2624);
      return;
    }
    parama.gR(false);
    AppMethodBeat.o(2624);
  }
  
  public final void setInit(boolean paramBoolean)
  {
    this.bRB = paramBoolean;
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "Ljava/io/InputStream;", "bitmapRes", "", "kotlin.jvm.PlatformType", "getInputStream"})
  static final class c
    implements FilterRawGet.GetInputStream
  {
    c(PluginEmojiCapture paramPluginEmojiCapture) {}
    
    public final InputStream getInputStream(String paramString)
    {
      AppMethodBeat.i(2618);
      ab.i(PluginEmojiCapture.access$getTAG$p(this.ltE), "get res: ".concat(String.valueOf(paramString)));
      Object localObject = ah.getContext();
      j.p(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getAssets();
      try
      {
        localObject = ((AssetManager)localObject).open("raw" + File.separator + paramString);
        return localObject;
      }
      catch (Exception localException)
      {
        ab.e(PluginEmojiCapture.access$getTAG$p(this.ltE), "cannot find res ".concat(String.valueOf(paramString)));
        return null;
      }
      finally
      {
        AppMethodBeat.o(2618);
      }
    }
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(PluginEmojiCapture paramPluginEmojiCapture) {}
    
    public final void run()
    {
      boolean bool2 = true;
      AppMethodBeat.i(2619);
      ab.i(PluginEmojiCapture.access$getTAG$p(this.ltE), "initLibrary: on connect");
      EmojiCaptureProxy.a locala = EmojiCaptureProxy.lwI;
      ac.ll(EmojiCaptureProxy.access$getInstance$cp().getDeviceInfoConfig());
      if ((m.I(Build.MODEL, "OPPO R9tm", true)) || (ac.erB.eqZ == 1) || (com.tencent.mm.compatible.util.d.fw(21)))
      {
        ab.i(PluginEmojiCapture.access$getTAG$p(this.ltE), "use small model");
        com.tencent.ttpic.fabby.FabbyManager.USE_SMALL_MODEL = true;
        com.tencent.ttpic.fabby.FabbyManager.USE_SMALL_IMAGE = true;
      }
      locala = EmojiCaptureProxy.lwI;
      int i = EmojiCaptureProxy.access$getInstance$cp().getUseGpuSegment();
      locala = EmojiCaptureProxy.lwI;
      if (EmojiCaptureProxy.access$getInstance$cp().getUseGpuSegment() > 0)
      {
        ab.i(PluginEmojiCapture.access$getTAG$p(this.ltE), "choose gpu segment. x ".concat(String.valueOf(i)));
        if (i == 1)
        {
          bool1 = true;
          com.tencent.ttpic.fabby.FabbyManager.sChooseGPU_Segment = bool1;
        }
      }
      else
      {
        i = ac.erB.era;
        if (i != -1)
        {
          ab.i(PluginEmojiCapture.access$getTAG$p(this.ltE), "choose gpu segment ".concat(String.valueOf(i)));
          if (i != 1) {
            break label202;
          }
        }
      }
      label202:
      for (boolean bool1 = bool2;; bool1 = false)
      {
        com.tencent.ttpic.fabby.FabbyManager.sChooseGPU_Segment = bool1;
        locala = EmojiCaptureProxy.lwI;
        EmojiCaptureProxy.a.boP();
        AppMethodBeat.o(2619);
        return;
        bool1 = false;
        break;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.emojicapture.model.PluginEmojiCapture
 * JD-Core Version:    0.7.0.1
 */