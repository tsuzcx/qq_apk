package com.tencent.mm.mj_template.plugin;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.b.g;
import com.tencent.mm.kernel.f.c;
import com.tencent.mm.kernel.h;
import com.tencent.mm.mj_template.album_template.multi_template.MaasAlbumMultiTemplatePreviewUI;
import com.tencent.mm.mj_template.album_template.single_template.MaasAlbumTemplatePreviewUI;
import com.tencent.mm.mj_template.album_template.single_template.MaasAlbumTemplatePreviewUI.a;
import com.tencent.mm.mj_template.api.MJTemplateSession;
import com.tencent.mm.mj_template.api.MaasAlbumMultiTemplateRequestParams;
import com.tencent.mm.mj_template.api.MaasAlbumTemplateRequestParams;
import com.tencent.mm.mj_template.maas.sdk.MaasSdkResMgr.resEventListener.1;
import com.tencent.mm.mj_template.maas.sdk.f;
import com.tencent.mm.plugin.flutter.ui.NormalTaskCachedFlutterActivity;
import com.tencent.mm.plugin.gallery.model.GalleryItem.MediaItem;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.byy;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.BuildInfo;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.component.PluginSupportUIC;
import com.tencent.mm.vfs.af;
import com.tencent.mm.vfs.y;
import io.flutter.embedding.android.PatchedFlutterActivity.CachedEngineIntentBuilder;
import io.flutter.embedding.engine.FlutterEngine;
import io.flutter.embedding.engine.FlutterEngineCache;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.PluginRegistry;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.b.a.k;
import kotlin.d.d<-Lkotlin.ah;>;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.cb;
import kotlinx.coroutines.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate;", "Lcom/tencent/mm/ui/component/PluginSupportUIC;", "Lcom/tencent/mm/mj_template/api/IPluginMaasTemplate;", "()V", "cachedEngineInfo", "Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate$CachedEngineInfo;", "preloadEngineJob", "Lkotlinx/coroutines/Job;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "templatePlugin", "Lcom/tencent/mm/mj_template/template_square/MaasTemplateApiFlutterPlugin;", "configure", "", "profile", "Lcom/tencent/mm/kernel/plugin/ProcessProfile;", "creationBySameTemplate", "context", "Landroid/app/Activity;", "templateInfo", "Lcom/tencent/mm/protocal/protobuf/FinderVideoTemplateInfo;", "originIntent", "Landroid/content/Intent;", "entranceType", "", "destroyEngine", "enterAlubmTemplatePreviewUI", "requestCode", "mediaList", "", "Lcom/tencent/mm/plugin/gallery/model/GalleryItem$MediaItem;", "enterMultiTemplatePreviewUI", "execute", "getFinderMaasConfig", "Lcom/tencent/mm/mj_template/api/IFinderMaasXConfig;", "getMaasPermissionChecker", "Lcom/tencent/mm/mj_template/api/IMaasUserPermissoinChecker;", "getPreloadedTemplateInfo", "Lcom/tencent/mm/protocal/protobuf/VideoTemplate;", "templateId", "", "getSnsMaasConfig", "Lcom/tencent/mm/mj_template/plugin/SnsMaasConfigImpl;", "isDeviceSupportAlbumTemplate", "", "jumpToTemplateUI", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "intent", "launchTemplateSquare", "Landroid/content/Context;", "eventTopicId", "", "api", "Lcom/tencent/mm/mj_template/api/IFinderModuleApi;", "onAccountInitialized", "upgrade", "Lcom/tencent/mm/kernel/CoreStorage$UpgradeInfo;", "preload", "preloadEngineImpl", "priorityTplId", "(JLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "preloadMaas", "preloadTemplateInfo", "isFinder", "releaseMaas", "CachedEngineInfo", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class PluginMaasTemplate
  extends PluginSupportUIC
  implements com.tencent.mm.mj_template.api.d
{
  public static final int Ue;
  public static final PluginMaasTemplate.b ocy;
  private PluginMaasTemplate.a ocA;
  private cb ocB;
  private com.tencent.mm.mj_template.c.a ocz;
  private final aq scope;
  
  static
  {
    AppMethodBeat.i(239698);
    ocy = new PluginMaasTemplate.b((byte)0);
    Ue = 8;
    AppMethodBeat.o(239698);
  }
  
  public PluginMaasTemplate()
  {
    AppMethodBeat.i(239649);
    this.scope = ar.kBZ();
    AppMethodBeat.o(239649);
  }
  
  private final Object preloadEngineImpl(long paramLong, String paramString, kotlin.d.d<? super ah> paramd)
  {
    Object localObject1 = null;
    AppMethodBeat.i(239662);
    if ((paramd instanceof e))
    {
      localObject2 = (e)paramd;
      if ((((e)localObject2).label & 0x80000000) != 0) {
        ((e)localObject2).label += -2147483648;
      }
    }
    kotlin.d.a.a locala;
    for (paramd = (kotlin.d.d<? super ah>)localObject2;; paramd = new e(this, paramd))
    {
      localObject2 = paramd.result;
      locala = kotlin.d.a.a.aiwj;
      switch (paramd.label)
      {
      default: 
        paramString = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239662);
        throw paramString;
      }
    }
    ResultKt.throwOnFailure(localObject2);
    Log.i("MicroMsg.PluginMJTemplate", "preload flutter engine impl with topicId: " + paramLong + ", priorityTplId: " + paramString + ' ');
    Object localObject2 = new PluginMaasTemplate.a(paramLong, paramString, null, 12);
    long l;
    if (!s.p(this.ocA, localObject2))
    {
      PluginMaasTemplate.a locala1;
      if (this.ocA != null)
      {
        locala1 = this.ocA;
        if (locala1 != null) {
          break label335;
        }
      }
      for (;;)
      {
        if (localObject1 != null)
        {
          Log.w("MicroMsg.PluginMJTemplate", "has unreleased engine");
          localObject1 = this.ocA;
          if (localObject1 != null)
          {
            Log.i("MicroMsg.PluginMJTemplate", s.X("do release first ", ((PluginMaasTemplate.a)localObject1).engineId));
            FlutterEngineCache.getInstance().remove(((PluginMaasTemplate.a)localObject1).engineId);
          }
        }
        this.ocA = ((PluginMaasTemplate.a)localObject2);
        l = Util.currentTicks();
        localObject1 = com.tencent.mm.plugin.flutter.b.b.Hke;
        paramString = (kotlin.g.a.b)new f(paramLong, paramString);
        paramd.L$0 = localObject2;
        paramd.Yx = l;
        paramd.label = 1;
        paramd = ((com.tencent.mm.plugin.flutter.b.b)localObject1).a("mj_template", false, paramString, paramd);
        if (paramd != locala) {
          break;
        }
        AppMethodBeat.o(239662);
        return locala;
        label335:
        localObject1 = locala1.engineId;
      }
      paramLong = paramd.Yx;
      paramString = (PluginMaasTemplate.a)paramd.L$0;
      ResultKt.throwOnFailure(localObject2);
      paramd = (kotlin.d.d<? super ah>)localObject2;
    }
    for (;;)
    {
      localObject1 = (kotlin.r)paramd;
      paramd = (String)((kotlin.r)localObject1).bsC;
      localObject1 = (FlutterEngine)((kotlin.r)localObject1).bsD;
      s.u(paramd, "<set-?>");
      paramString.engineId = paramd;
      paramString.flutterEngine = ((FlutterEngine)localObject1);
      Log.i("MicroMsg.PluginMJTemplate", "preload flutter engine finished cost:" + Util.ticksToNow(paramLong) + ", " + paramd);
      paramString = ah.aiuX;
      AppMethodBeat.o(239662);
      return paramString;
      paramString = (String)localObject2;
      paramLong = l;
    }
  }
  
  public final void configure(g paramg)
  {
    int i = 1;
    AppMethodBeat.i(239800);
    super.configure(paramg);
    af.aR("Maas/Persist", "Maas/Persist", 6);
    af.a("Maas/Cache", "Maas/Cache", 2592000000L, 6);
    if ((paramg != null) && (paramg.bbA() == true)) {}
    while (i != 0)
    {
      paramg = f.obN;
      Log.i(f.TAG, "init: ");
      if (!BuildInfo.IS_ARM64)
      {
        Log.w(f.TAG, "check res only arm64");
        AppMethodBeat.o(239800);
        return;
        i = 0;
      }
      else
      {
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
        Object localObject1 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avT(103);
        if (localObject1 != null)
        {
          localObject1 = ((Iterable)localObject1).iterator();
          while (((Iterator)localObject1).hasNext())
          {
            i = ((com.tencent.mm.pluginsdk.res.downloader.model.r)((Iterator)localObject1).next()).field_subType;
            Object localObject2 = new StringBuilder();
            Object localObject3 = com.tencent.mm.mj_template.maas.sdk.e.obI;
            if (!y.ZC(com.tencent.mm.mj_template.maas.sdk.e.bxN() + '/' + i))
            {
              com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
              localObject2 = com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.nK(103, i);
              Log.i(f.TAG, "init: get cached file " + i + ", " + localObject2);
              if (localObject2 != null)
              {
                localObject3 = f.obN;
                f.N(i, (String)localObject2);
              }
            }
          }
        }
        f.obR.alive();
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.iJf();
        com.tencent.mm.pluginsdk.res.downloader.checkresupdate.b.avS(103);
        paramg.bxR();
        f.bxU();
        Log.i(f.TAG, "init: end");
      }
    }
    AppMethodBeat.o(239800);
  }
  
  public final void creationBySameTemplate(Activity paramActivity, byy parambyy, Intent paramIntent, int paramInt)
  {
    AppMethodBeat.i(239745);
    s.u(paramActivity, "context");
    s.u(parambyy, "templateInfo");
    s.u(paramIntent, "originIntent");
    preloadMaas();
    if (paramInt > 0)
    {
      localObject1 = com.tencent.mm.plugin.finder.utils.u.GgT;
      com.tencent.mm.plugin.finder.utils.u.a((Context)paramActivity, paramIntent, 133, paramInt);
    }
    Object localObject2 = parambyy.id;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localObject1 = getPreloadedTemplateInfo((String)localObject1);
    Object localObject3;
    if (localObject1 == null)
    {
      localObject1 = new fxr();
      ((fxr)localObject1).id = parambyy.id;
      ((fxr)localObject1).type = parambyy.type;
      ((fxr)localObject1).aahW = parambyy.aahW;
      localObject2 = new aex();
      ((aex)localObject2).ZmT = parambyy.ZmT;
      localObject3 = ah.aiuX;
      ((fxr)localObject1).abVq = ((aex)localObject2);
    }
    for (;;)
    {
      localObject3 = ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi();
      if (parambyy.type != 2) {
        break;
      }
      paramIntent.putExtra("KEY_POST_VIDEO_TEMPLATE", ((fxr)localObject1).toByteArray());
      parambyy = ah.aiuX;
      ((com.tencent.mm.plugin.finder.publish.e)localObject3).m(paramActivity, paramIntent);
      AppMethodBeat.o(239745);
      return;
    }
    paramIntent.putExtra("key_finder_post_from", 5);
    byte[] arrayOfByte = ((fxr)localObject1).toByteArray();
    s.s(arrayOfByte, "videoTemplate.toByteArray()");
    localObject2 = parambyy.aahZ;
    parambyy = (byy)localObject2;
    if (localObject2 == null) {
      parambyy = "";
    }
    paramIntent.putExtra("mj_template_session", (Parcelable)new MJTemplateSession(arrayOfByte, parambyy));
    parambyy = ((fxr)localObject1).abVq;
    if (parambyy == null)
    {
      parambyy = "";
      paramIntent.putExtra("album_footer_info_str", parambyy);
      parambyy = ((fxr)localObject1).abVs;
      if (parambyy != null) {
        break label390;
      }
      paramInt = 20;
      label313:
      paramIntent.putExtra("max_select_count", paramInt);
      parambyy = ((fxr)localObject1).abVs;
      if (parambyy != null) {
        break label447;
      }
    }
    label390:
    label411:
    label433:
    label438:
    label447:
    for (paramInt = 0;; paramInt = parambyy.YGE)
    {
      paramIntent.putExtra("min_select_count", paramInt);
      parambyy = ah.aiuX;
      ((com.tencent.mm.plugin.finder.publish.e)localObject3).c(paramActivity, paramIntent, 666);
      AppMethodBeat.o(239745);
      return;
      localObject2 = parambyy.ZmU;
      parambyy = (byy)localObject2;
      if (localObject2 != null) {
        break;
      }
      parambyy = "";
      break;
      parambyy = Integer.valueOf(parambyy.YGF);
      if (((Number)parambyy).intValue() > 0)
      {
        paramInt = 1;
        if (paramInt == 0) {
          break label433;
        }
      }
      for (;;)
      {
        if (parambyy != null) {
          break label438;
        }
        paramInt = 20;
        break;
        paramInt = 0;
        break label411;
        parambyy = null;
      }
      paramInt = parambyy.intValue();
      break label313;
    }
  }
  
  public final void destroyEngine()
  {
    AppMethodBeat.i(239713);
    Log.i("MicroMsg.PluginMJTemplate", "enter destroyEngine");
    Object localObject = this.ocA;
    if (localObject != null)
    {
      Log.i("MicroMsg.PluginMJTemplate", s.X("destroyEngine ", ((PluginMaasTemplate.a)localObject).engineId));
      FlutterEngineCache.getInstance().remove(((PluginMaasTemplate.a)localObject).engineId);
    }
    this.ocA = null;
    this.ocz = null;
    localObject = this.ocB;
    if (localObject != null) {
      ((cb)localObject).a(null);
    }
    this.ocB = null;
    AppMethodBeat.o(239713);
  }
  
  public final void enterAlubmTemplatePreviewUI(Activity paramActivity, int paramInt, List<? extends GalleryItem.MediaItem> paramList, Intent paramIntent)
  {
    AppMethodBeat.i(239730);
    s.u(paramActivity, "context");
    s.u(paramList, "mediaList");
    s.u(paramIntent, "originIntent");
    Log.i("MicroMsg.PluginMJTemplate", "enterAlubmTemplatePreviewUI");
    MJTemplateSession localMJTemplateSession = (MJTemplateSession)paramIntent.getParcelableExtra("mj_template_session");
    if (localMJTemplateSession == null) {}
    for (paramActivity = null;; paramActivity = ah.aiuX)
    {
      if (paramActivity == null) {
        Log.e("MicroMsg.PluginMJTemplate", "mjTemplateSession is null");
      }
      AppMethodBeat.o(239730);
      return;
      Intent localIntent = new Intent((Context)paramActivity, MaasAlbumTemplatePreviewUI.class);
      localIntent.putExtras(paramIntent);
      localIntent.putExtra("request_params", (Parcelable)new MaasAlbumTemplateRequestParams(paramList, localMJTemplateSession));
      paramList = ah.aiuX;
      com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(localIntent).aYi(), "com/tencent/mm/mj_template/plugin/PluginMaasTemplate", "enterAlubmTemplatePreviewUI", "(Landroid/app/Activity;ILjava/util/List;Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    }
  }
  
  public final void enterMultiTemplatePreviewUI(Activity paramActivity, int paramInt, List<? extends GalleryItem.MediaItem> paramList, Intent paramIntent)
  {
    AppMethodBeat.i(239738);
    s.u(paramActivity, "context");
    s.u(paramList, "mediaList");
    s.u(paramIntent, "originIntent");
    Log.i("MicroMsg.PluginMJTemplate", "enterMultiTemplatePreviewUI");
    paramIntent.setClass((Context)paramActivity, MaasAlbumMultiTemplatePreviewUI.class);
    paramIntent.putExtra("key_finder_post_from", 5);
    paramIntent.putExtra("request_params", (Parcelable)new MaasAlbumMultiTemplateRequestParams(paramList));
    paramList = ah.aiuX;
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/mj_template/plugin/PluginMaasTemplate", "enterMultiTemplatePreviewUI", "(Landroid/app/Activity;ILjava/util/List;Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(239738);
  }
  
  public final void execute(g paramg)
  {
    AppMethodBeat.i(239805);
    s.u(paramg, "profile");
    if (paramg.bbA())
    {
      paramg = com.tencent.mm.mj_template.template_res.c.ofY;
      com.tencent.mm.mj_template.template_res.c.byQ().init();
      paramg = com.tencent.mm.mj_template.template_res.c.ofY;
      com.tencent.mm.mj_template.template_res.c.byR().init();
    }
    AppMethodBeat.o(239805);
  }
  
  public final com.tencent.mm.mj_template.api.a getFinderMaasConfig()
  {
    return (com.tencent.mm.mj_template.api.a)b.ocx;
  }
  
  public final com.tencent.mm.mj_template.api.c getMaasPermissionChecker()
  {
    return (com.tencent.mm.mj_template.api.c)com.tencent.mm.mj_template.a.a.nZt;
  }
  
  public final fxr getPreloadedTemplateInfo(String paramString)
  {
    AppMethodBeat.i(239780);
    s.u(paramString, "templateId");
    com.tencent.mm.mj_template.b.b localb = com.tencent.mm.mj_template.b.b.ofM;
    paramString = com.tencent.mm.mj_template.b.b.HR(paramString);
    AppMethodBeat.o(239780);
    return paramString;
  }
  
  public final d getSnsMaasConfig()
  {
    return d.odz;
  }
  
  public final boolean isDeviceSupportAlbumTemplate()
  {
    AppMethodBeat.i(239809);
    com.tencent.mm.mj_template.album_template.b localb = com.tencent.mm.mj_template.album_template.b.nWa;
    boolean bool = com.tencent.mm.mj_template.album_template.b.bwC();
    AppMethodBeat.o(239809);
    return bool;
  }
  
  public final void jumpToTemplateUI(Activity paramActivity, int paramInt, ArrayList<GalleryItem.MediaItem> paramArrayList, Intent paramIntent)
  {
    AppMethodBeat.i(239787);
    s.u(paramActivity, "context");
    s.u(paramArrayList, "mediaList");
    s.u(paramIntent, "intent");
    MaasAlbumTemplatePreviewUI.a locala = MaasAlbumTemplatePreviewUI.nXJ;
    s.u(paramActivity, "context");
    s.u(paramArrayList, "mediaList");
    s.u(paramIntent, "intent");
    paramIntent.setClass((Context)paramActivity, MaasAlbumTemplatePreviewUI.class);
    paramIntent.putParcelableArrayListExtra("Template_Media_List", paramArrayList);
    paramIntent.putExtra("source_sns", true);
    com.tencent.mm.hellhoundlib.a.a.a(paramActivity, com.tencent.mm.hellhoundlib.b.c.a(paramInt, new com.tencent.mm.hellhoundlib.b.a()).cG(paramIntent).aYi(), "com/tencent/mm/mj_template/album_template/single_template/MaasAlbumTemplatePreviewUI$Companion", "jumpToTemplateUI", "(Landroid/app/Activity;ILjava/util/ArrayList;Landroid/content/Intent;)V", "android/app/Activity", "startActivityForResult", "(Landroid/content/Intent;I)V");
    AppMethodBeat.o(239787);
  }
  
  public final void launchTemplateSquare(final Context paramContext, long paramLong, final Intent paramIntent, com.tencent.mm.mj_template.api.b paramb)
  {
    AppMethodBeat.i(239707);
    s.u(paramContext, "context");
    s.u(paramIntent, "originIntent");
    s.u(paramb, "api");
    if (this.ocz == null) {
      this.ocz = new com.tencent.mm.mj_template.c.a(paramb, this);
    }
    j.a(this.scope, null, null, (m)new c(paramLong, this, paramContext, paramIntent, null), 3);
    AppMethodBeat.o(239707);
  }
  
  public final void onAccountInitialized(f.c paramc) {}
  
  public final void preload(final long paramLong)
  {
    AppMethodBeat.i(239702);
    PluginMaasTemplate.a locala = new PluginMaasTemplate.a(paramLong, null, null, 14);
    if (!s.p(this.ocA, locala)) {
      this.ocB = j.a(this.scope, null, null, (m)new d(this, paramLong, null), 3);
    }
    AppMethodBeat.o(239702);
  }
  
  public final void preloadMaas()
  {
    AppMethodBeat.i(239764);
    com.tencent.mm.mj_template.maas.e locale = com.tencent.mm.mj_template.maas.e.nZS;
    com.tencent.mm.mj_template.maas.e.bxp();
    AppMethodBeat.o(239764);
  }
  
  public final void preloadTemplateInfo(String paramString, boolean paramBoolean)
  {
    AppMethodBeat.i(239774);
    s.u(paramString, "templateId");
    com.tencent.mm.mj_template.b.b localb = com.tencent.mm.mj_template.b.b.ofM;
    if (paramBoolean) {}
    for (int i = 2;; i = 4)
    {
      com.tencent.mm.mj_template.b.b.aJ(paramString, i);
      AppMethodBeat.o(239774);
      return;
    }
  }
  
  public final void releaseMaas()
  {
    AppMethodBeat.i(239769);
    com.tencent.mm.mj_template.maas.e locale = com.tencent.mm.mj_template.maas.e.nZS;
    com.tencent.mm.mj_template.maas.e.release();
    AppMethodBeat.o(239769);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(long paramLong, PluginMaasTemplate paramPluginMaasTemplate, Context paramContext, Intent paramIntent, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239659);
      paramObject = (kotlin.d.d)new c(this.ocF, paramContext, paramIntent, this.ocH, paramd);
      AppMethodBeat.o(239659);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      Object localObject1 = null;
      AppMethodBeat.i(239652);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      Object localObject2;
      int i;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239652);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = new PluginMaasTemplate.a(this.ocF, null, null, 14);
        localObject2 = PluginMaasTemplate.access$getPreloadEngineJob$p(paramContext);
        if ((localObject2 != null) && (((cb)localObject2).isActive() == true))
        {
          i = 1;
          if (i == 0) {
            break label244;
          }
          localObject2 = PluginMaasTemplate.access$getPreloadEngineJob$p(paramContext);
          if ((localObject2 == null) || (((cb)localObject2).isCompleted())) {
            break label205;
          }
          i = 1;
        }
      case 1: 
        for (;;)
        {
          if ((i != 0) && (s.p(paramObject, PluginMaasTemplate.access$getCachedEngineInfo$p(paramContext))))
          {
            paramObject = PluginMaasTemplate.access$getPreloadEngineJob$p(paramContext);
            if (paramObject != null)
            {
              localObject2 = (kotlin.d.d)this;
              this.label = 1;
              if (paramObject.ay((kotlin.d.d)localObject2) == locala)
              {
                AppMethodBeat.o(239652);
                return locala;
                i = 0;
                break;
                label205:
                i = 0;
                continue;
                ResultKt.throwOnFailure(paramObject);
              }
            }
            paramObject = PluginMaasTemplate.access$getCachedEngineInfo$p(paramContext);
            if (paramObject != null) {
              break label338;
            }
          }
        }
      }
      label323:
      label338:
      for (paramObject = localObject1;; paramObject = paramObject.flutterEngine)
      {
        if (paramObject != null) {
          break label346;
        }
        paramObject = ah.aiuX;
        AppMethodBeat.o(239652);
        return paramObject;
        label244:
        if (PluginMaasTemplate.access$getCachedEngineInfo$p(paramContext) != null)
        {
          paramObject = PluginMaasTemplate.access$getCachedEngineInfo$p(paramContext);
          if (paramObject != null) {
            break label323;
          }
        }
        for (paramObject = null; paramObject == null; paramObject = paramObject.engineId)
        {
          Log.w("MicroMsg.PluginMJTemplate", "trigger preload");
          paramObject = paramContext;
          long l = this.ocF;
          localObject2 = (kotlin.d.d)this;
          this.label = 2;
          if (PluginMaasTemplate.preloadEngineImpl$default(paramObject, l, null, (kotlin.d.d)localObject2, 2, null) != locala) {
            break;
          }
          AppMethodBeat.o(239652);
          return locala;
        }
        ResultKt.throwOnFailure(paramObject);
        break;
      }
      label346:
      localObject1 = PluginMaasTemplate.access$getTemplatePlugin$p(paramContext);
      if (localObject1 != null) {
        paramObject.getPlugins().add((FlutterPlugin)localObject1);
      }
      ((com.tencent.mm.plugin.flutter.thumbplayer.a.a)h.ax(com.tencent.mm.plugin.flutter.thumbplayer.a.a.class)).a(paramObject);
      paramObject = NormalTaskCachedFlutterActivity.Hls;
      paramObject = PluginMaasTemplate.access$getCachedEngineInfo$p(paramContext);
      if (paramObject == null)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(239652);
        return paramObject;
      }
      paramObject = paramObject.engineId;
      s.u(paramObject, "cachedEngineId");
      localObject1 = new PatchedFlutterActivity.CachedEngineIntentBuilder(NormalTaskCachedFlutterActivity.class, paramObject).destroyEngineWithActivity(true).build(paramIntent);
      ((Intent)localObject1).putExtras(this.ocH);
      s.s(localObject1, "NormalTaskCachedFlutterA…iginIntent)\n            }");
      paramObject = paramIntent;
      localObject1 = new com.tencent.mm.hellhoundlib.b.a().cG(localObject1);
      com.tencent.mm.hellhoundlib.a.a.b(paramObject, ((com.tencent.mm.hellhoundlib.b.a)localObject1).aYi(), "com/tencent/mm/mj_template/plugin/PluginMaasTemplate$launchTemplateSquare$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      paramObject.startActivity((Intent)((com.tencent.mm.hellhoundlib.b.a)localObject1).sb(0));
      com.tencent.mm.hellhoundlib.a.a.c(paramObject, "com/tencent/mm/mj_template/plugin/PluginMaasTemplate$launchTemplateSquare$1", "invokeSuspend", "(Ljava/lang/Object;)Ljava/lang/Object;", "Undefined", "startActivity", "(Landroid/content/Intent;)V");
      Log.i("MicroMsg.PluginMJTemplate", "launchTemplateSquare");
      paramObject = ah.aiuX;
      AppMethodBeat.o(239652);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    long Yx;
    int label;
    
    d(PluginMaasTemplate paramPluginMaasTemplate, long paramLong, kotlin.d.d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(239651);
      paramObject = (kotlin.d.d)new d(this.ocG, paramLong, paramd);
      AppMethodBeat.o(239651);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239646);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      long l1;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(239646);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        l1 = Util.currentTicks();
        Log.i("MicroMsg.PluginMJTemplate", "preload");
        paramObject = this.ocG;
        long l2 = paramLong;
        kotlin.d.d locald = (kotlin.d.d)this;
        this.Yx = l1;
        this.label = 1;
        if (PluginMaasTemplate.preloadEngineImpl$default(paramObject, l2, null, locald, 2, null) == locala)
        {
          AppMethodBeat.o(239646);
          return locala;
        }
        break;
      case 1: 
        l1 = this.Yx;
        ResultKt.throwOnFailure(paramObject);
      }
      for (;;)
      {
        Log.i("MicroMsg.PluginMJTemplate", s.X("preload finished cost:", kotlin.d.b.a.b.BF(Util.ticksToNow(l1))));
        paramObject = ah.aiuX;
        AppMethodBeat.o(239646);
        return paramObject;
      }
    }
  }
  
  @Metadata(k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.d
  {
    Object L$0;
    long Yx;
    int label;
    
    e(PluginMaasTemplate paramPluginMaasTemplate, kotlin.d.d<? super e> paramd)
    {
      super();
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(239639);
      this.result = paramObject;
      this.label |= 0x80000000;
      paramObject = PluginMaasTemplate.access$preloadEngineImpl(this.ocG, 0L, null, (kotlin.d.d)this);
      AppMethodBeat.o(239639);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "", "", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.g.b.u
    implements kotlin.g.a.b<Map<String, Object>, ah>
  {
    f(long paramLong, String paramString)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.plugin.PluginMaasTemplate
 * JD-Core Version:    0.7.0.1
 */