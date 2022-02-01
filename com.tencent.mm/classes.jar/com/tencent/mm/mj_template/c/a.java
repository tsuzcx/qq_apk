package com.tencent.mm.mj_template.c;

import android.app.Activity;
import android.content.Intent;
import android.os.Parcelable;
import androidx.lifecycle.j;
import androidx.lifecycle.p;
import androidx.lifecycle.q;
import com.tencent.c.h.a;
import com.tencent.c.h.b;
import com.tencent.c.h.d;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.mj_template.api.MJTemplateSession;
import com.tencent.mm.mj_template.maas.e;
import com.tencent.mm.mj_template.plugin.PluginMaasTemplate;
import com.tencent.mm.mj_template.report.MaasPageFinderReporter;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.eo;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.xeffect.d.a;
import io.flutter.embedding.engine.plugins.FlutterPlugin;
import io.flutter.embedding.engine.plugins.FlutterPlugin.FlutterPluginBinding;
import io.flutter.embedding.engine.plugins.activity.ActivityAware;
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding;
import io.flutter.plugin.common.PluginRegistry.ActivityResultListener;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/mj_template/template_square/MaasTemplateApiFlutterPlugin;", "Lio/flutter/embedding/engine/plugins/FlutterPlugin;", "Lcom/tencent/pigeon/MJTemplateApi$HostPageLaunch;", "Lio/flutter/embedding/engine/plugins/activity/ActivityAware;", "finderApi", "Lcom/tencent/mm/mj_template/api/IFinderModuleApi;", "plugin", "Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate;", "(Lcom/tencent/mm/mj_template/api/IFinderModuleApi;Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate;)V", "activity", "Landroid/app/Activity;", "getFinderApi", "()Lcom/tencent/mm/mj_template/api/IFinderModuleApi;", "onActivityResult", "Lio/flutter/plugin/common/PluginRegistry$ActivityResultListener;", "getPlugin", "()Lcom/tencent/mm/mj_template/plugin/PluginMaasTemplate;", "reporter", "Lcom/tencent/mm/mj_template/report/MaasPageFinderReporter;", "getMaasVersion", "", "()Ljava/lang/Long;", "getWeVisionVersion", "launchAlbum", "", "request", "Lcom/tencent/pigeon/MJTemplateApi$AlbumRequest;", "result", "Lcom/tencent/pigeon/MJTemplateApi$Result;", "", "onAttachedToActivity", "p0", "Lio/flutter/embedding/engine/plugins/activity/ActivityPluginBinding;", "onAttachedToEngine", "Lio/flutter/embedding/engine/plugins/FlutterPlugin$FlutterPluginBinding;", "onDetachedFromActivity", "onDetachedFromActivityForConfigChanges", "onDetachedFromEngine", "onReattachedToActivityForConfigChanges", "reportTemplateListItemClicked", "templateId", "", "reportTemplateListItemExposed", "Companion", "plugin-mj-template_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends h.b
  implements FlutterPlugin, ActivityAware
{
  public static final a.a ogj;
  private Activity activity;
  private final com.tencent.mm.mj_template.api.b ogk;
  private final PluginMaasTemplate ogl;
  private PluginRegistry.ActivityResultListener ogm;
  private MaasPageFinderReporter ogn;
  
  static
  {
    AppMethodBeat.i(239565);
    ogj = new a.a((byte)0);
    AppMethodBeat.o(239565);
  }
  
  public a(com.tencent.mm.mj_template.api.b paramb, PluginMaasTemplate paramPluginMaasTemplate)
  {
    AppMethodBeat.i(239546);
    this.ogk = paramb;
    this.ogl = paramPluginMaasTemplate;
    AppMethodBeat.o(239546);
  }
  
  private static final boolean a(h.d paramd, a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(239552);
    s.u(paramd, "$result");
    s.u(parama, "this$0");
    if ((paramInt1 == 1) && (paramInt2 == -1))
    {
      Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "square finished");
      paramd.success(Boolean.TRUE);
    }
    for (;;)
    {
      parama.ogm = null;
      AppMethodBeat.o(239552);
      return true;
      Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "square not finished ");
      paramd.success(Boolean.FALSE);
    }
  }
  
  private static final boolean a(a parama, int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(239559);
    s.u(parama, "this$0");
    parama = parama.ogm;
    if (parama == null)
    {
      AppMethodBeat.o(239559);
      return false;
    }
    boolean bool = parama.onActivityResult(paramInt1, paramInt2, paramIntent);
    AppMethodBeat.o(239559);
    return bool;
  }
  
  public final void HT(String paramString)
  {
    AppMethodBeat.i(239616);
    MaasPageFinderReporter localMaasPageFinderReporter = this.ogn;
    if (localMaasPageFinderReporter != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localMaasPageFinderReporter.HN(str);
    }
    AppMethodBeat.o(239616);
  }
  
  public final void HU(String paramString)
  {
    AppMethodBeat.i(239621);
    MaasPageFinderReporter localMaasPageFinderReporter = this.ogn;
    if (localMaasPageFinderReporter != null)
    {
      String str = paramString;
      if (paramString == null) {
        str = "";
      }
      localMaasPageFinderReporter.HO(str);
    }
    AppMethodBeat.o(239621);
  }
  
  public final void a(h.a parama, h.d<Boolean> paramd)
  {
    AppMethodBeat.i(239599);
    s.u(parama, "request");
    s.u(paramd, "result");
    Activity localActivity = this.activity;
    if (localActivity == null)
    {
      Log.e("MicroMsg.MJTemplateApiFlutterPlugin", "activity is null");
      paramd.D(new Throwable("activity not attached"));
      AppMethodBeat.o(239599);
      return;
    }
    fxr localfxr = new fxr();
    try
    {
      localfxr.parseFrom(parama.buffer);
      Object localObject1 = e.nZS;
      e.bxp();
      localObject1 = com.tencent.mm.mj_template.b.b.ofM;
      Object localObject2 = localfxr.id;
      localObject1 = localObject2;
      if (localObject2 == null) {
        localObject1 = "";
      }
      com.tencent.mm.mj_template.b.b.aJ((String)localObject1, 2);
      localObject1 = this.ogk;
      localObject2 = new Intent();
      parama = parama.buffer;
      s.s(parama, "request.buffer");
      ((Intent)localObject2).putExtra("mj_template_session", (Parcelable)new MJTemplateSession(parama));
      parama = localfxr.abVq;
      if (parama == null)
      {
        parama = null;
        ((Intent)localObject2).putExtra("album_footer_info_str", parama);
        parama = Integer.valueOf(localfxr.abVs.YGF);
        if (((Number)parama).intValue() <= 0) {
          break label307;
        }
        i = 1;
        if (i == 0) {
          break label312;
        }
        if (parama != null) {
          break label317;
        }
        i = 20;
        ((Intent)localObject2).putExtra("max_select_count", i);
        ((Intent)localObject2).putExtra("min_select_count", localfxr.abVs.YGE);
        parama = ah.aiuX;
        ((com.tencent.mm.mj_template.api.b)localObject1).c(localActivity, (Intent)localObject2);
        this.ogm = new a..ExternalSyntheticLambda0(paramd, this);
        AppMethodBeat.o(239599);
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Log.e("MicroMsg.MJTemplateApiFlutterPlugin", "parse template info error", new Object[] { localException });
        continue;
        parama = parama.ZmU;
        continue;
        label307:
        int i = 0;
        continue;
        label312:
        parama = null;
        continue;
        label317:
        i = parama.intValue();
      }
    }
  }
  
  public final Long byS()
  {
    AppMethodBeat.i(239604);
    d.a locala = com.tencent.mm.xeffect.d.agXC;
    AppMethodBeat.o(239604);
    return Long.valueOf(140L);
  }
  
  public final Long byT()
  {
    AppMethodBeat.i(239611);
    AppMethodBeat.o(239611);
    return Long.valueOf(1001000L);
  }
  
  public final void onAttachedToActivity(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(239625);
    s.u(paramActivityPluginBinding, "p0");
    Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "onAttachedToActivity");
    this.activity = paramActivityPluginBinding.getActivity();
    paramActivityPluginBinding.addActivityResultListener(new a..ExternalSyntheticLambda1(this));
    paramActivityPluginBinding = ((com.tencent.mm.plugin.expt.b.d)h.ax(com.tencent.mm.plugin.expt.b.d.class)).dHN();
    Object localObject1 = paramActivityPluginBinding;
    if (paramActivityPluginBinding == null) {
      localObject1 = "";
    }
    paramActivityPluginBinding = this.activity;
    if (paramActivityPluginBinding == null)
    {
      paramActivityPluginBinding = null;
      Object localObject2 = paramActivityPluginBinding;
      if (paramActivityPluginBinding == null) {
        localObject2 = new Intent();
      }
      localObject1 = new MaasPageFinderReporter((String)localObject1, 134, "square_feed_template", (Intent)localObject2);
      this.ogn = ((MaasPageFinderReporter)localObject1);
      paramActivityPluginBinding = this.activity;
      if (!(paramActivityPluginBinding instanceof q)) {
        break label170;
      }
    }
    label170:
    for (paramActivityPluginBinding = (q)paramActivityPluginBinding;; paramActivityPluginBinding = null)
    {
      if (paramActivityPluginBinding != null)
      {
        paramActivityPluginBinding = paramActivityPluginBinding.getLifecycle();
        if (paramActivityPluginBinding != null) {
          paramActivityPluginBinding.addObserver((p)localObject1);
        }
      }
      AppMethodBeat.o(239625);
      return;
      paramActivityPluginBinding = paramActivityPluginBinding.getIntent();
      break;
    }
  }
  
  public final void onAttachedToEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(239585);
    s.u(paramFlutterPluginBinding, "p0");
    Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "onAttachedToEngine");
    h.b.a(paramFlutterPluginBinding.getBinaryMessenger(), (h.b)this);
    AppMethodBeat.o(239585);
  }
  
  public final void onDetachedFromActivity()
  {
    AppMethodBeat.i(239637);
    Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "onDetachedFromActivity");
    e locale = e.nZS;
    e.release();
    this.activity = null;
    this.ogn = null;
    this.ogl.destroyEngine();
    AppMethodBeat.o(239637);
  }
  
  public final void onDetachedFromActivityForConfigChanges() {}
  
  public final void onDetachedFromEngine(FlutterPlugin.FlutterPluginBinding paramFlutterPluginBinding)
  {
    AppMethodBeat.i(239591);
    s.u(paramFlutterPluginBinding, "p0");
    Log.i("MicroMsg.MJTemplateApiFlutterPlugin", "onDetachedFromEngine");
    AppMethodBeat.o(239591);
  }
  
  public final void onReattachedToActivityForConfigChanges(ActivityPluginBinding paramActivityPluginBinding)
  {
    AppMethodBeat.i(239632);
    s.u(paramActivityPluginBinding, "p0");
    AppMethodBeat.o(239632);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.mj_template.c.a
 * JD-Core Version:    0.7.0.1
 */