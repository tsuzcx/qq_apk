package com.tencent.mm.plugin.finder.record.plugin;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView.v;
import com.tencent.maas.MJMaasCore.TemplateServiceProvider;
import com.tencent.maas.model.MJTemplateMetadata;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.publish.l.e;
import com.tencent.mm.plugin.finder.video.plugin.view.RecordTypeSelectView;
import com.tencent.mm.plugin.finder.view.InterceptRecyclerView;
import com.tencent.mm.plugin.mmsight.ui.MMSightRecordButton;
import com.tencent.mm.plugin.recordvideo.jumper.RecordConfigProvider;
import com.tencent.mm.plugin.recordvideo.plugin.parent.BaseScopePluginLayout;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.b;
import com.tencent.mm.plugin.recordvideo.plugin.parent.a.c;
import com.tencent.mm.plugin.recordvideo.plugin.v;
import com.tencent.mm.plugin.recordvideo.plugin.v.a;
import com.tencent.mm.plugin.recordvideo.plugin.y;
import com.tencent.mm.protocal.protobuf.aex;
import com.tencent.mm.protocal.protobuf.fxr;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.a.e;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.d.d;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.j;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.bg;
import kotlinx.coroutines.l;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin;", "Lcom/tencent/mm/plugin/recordvideo/plugin/IBaseRecordPlugin;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/maas/MJMaasCore$TemplateServiceProvider;", "pluginLayout", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "(Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;)V", "beautifyPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin;", "closePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordClosePlugin;", "configProvider", "Lcom/tencent/mm/plugin/recordvideo/jumper/RecordConfigProvider;", "context", "Landroid/content/Context;", "kotlin.jvm.PlatformType", "dialog", "Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "getDialog", "()Lcom/tencent/mm/ui/widget/dialog/MMAlertDialog;", "dialog$delegate", "Lkotlin/Lazy;", "isEmptyTemplate", "", "isTemplateFollowMode", "isTemplateMode", "lifeCyclePluginList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "parentLayout", "Landroid/view/ViewGroup;", "getPluginLayout", "()Lcom/tencent/mm/plugin/recordvideo/plugin/parent/BaseScopePluginLayout;", "setPluginLayout", "recordPathPlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/FinderSubVideoFilePlugin;", "recordPlugin", "Lcom/tencent/mm/plugin/recordvideo/plugin/RecordButtonPlugin;", "selectTypePlugin", "Lcom/tencent/mm/plugin/finder/video/plugin/subvideo/FinderRecordTypePlugin;", "subRecordLayout", "templateCloseBtn", "Landroid/view/View;", "templateEffectBtn", "templateEffectMargin", "templateLayout", "templateListPlugin", "Lcom/tencent/mm/plugin/finder/record/plugin/FinderTemplateListPlugin;", "addVideoPath", "", "path", "", "cancelSubRecordDelete", "execSubRecordDelete", "getRecordType", "", "getVideoList", "handleFollowRecord", "provider", "initLogic", "normalRecordFinish", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "normalRecordStart", "onBackPress", "onClick", "v", "onPause", "onRequestTemplateMetadata", "Lcom/tencent/maas/model/MJTemplateMetadata;", "p0", "onResume", "recordTimeNotEnough", "reset", "setVisibility", "visibility", "showNormalView", "showTemplateView", "statusChange", "status", "Lcom/tencent/mm/plugin/recordvideo/plugin/parent/IRecordStatus$RecordStatus;", "param", "Landroid/os/Bundle;", "subRecordFinish", "switchToEmptyTemplate", "empty", "templateFollowMode", "templateRecordFinish", "templateRecordStart", "updateMaxRecordTimeMs", "durationMs", "updateRecordHint", "hint", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecordTipByAudioPermission", "permission", "runnable", "Ljava/lang/Runnable;", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
  implements View.OnClickListener, MJMaasCore.TemplateServiceProvider, v
{
  public static final b.a FiG;
  private final j FiH;
  public final com.tencent.mm.plugin.finder.video.plugin.f FiI;
  private final com.tencent.mm.plugin.finder.video.plugin.c FiJ;
  private final ViewGroup FiK;
  private final c FiL;
  private final com.tencent.mm.plugin.finder.video.plugin.subvideo.a FiM;
  private final y FiN;
  private final com.tencent.mm.plugin.finder.video.plugin.b FiO;
  private final View FiP;
  private final View FiQ;
  private final View FiR;
  private final ArrayList<v> FiS;
  private final ViewGroup FiT;
  private boolean FiU;
  private boolean FiV;
  private boolean FiW;
  private final Context context;
  public BaseScopePluginLayout oaR;
  private final ViewGroup oaS;
  private RecordConfigProvider oaV;
  
  static
  {
    AppMethodBeat.i(337231);
    FiG = new b.a((byte)0);
    AppMethodBeat.o(337231);
  }
  
  public b(BaseScopePluginLayout paramBaseScopePluginLayout)
  {
    AppMethodBeat.i(337079);
    this.oaR = paramBaseScopePluginLayout;
    this.context = this.oaR.getContext();
    this.FiH = kotlin.k.cm((kotlin.g.a.a)new b.b(this));
    this.FiI = new com.tencent.mm.plugin.finder.video.plugin.f((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR);
    paramBaseScopePluginLayout = this.oaR.findViewById(l.e.FhU);
    s.s(paramBaseScopePluginLayout, "pluginLayout.findViewById(R.id.close_page_img)");
    this.FiJ = new com.tencent.mm.plugin.finder.video.plugin.c((WeImageView)paramBaseScopePluginLayout, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR, null);
    this.FiK = ((ViewGroup)this.oaR.findViewById(l.e.record_plugin));
    this.FiL = new c(this.oaR);
    paramBaseScopePluginLayout = this.oaR.findViewById(l.e.record_type_view);
    s.s(paramBaseScopePluginLayout, "pluginLayout.findViewById(R.id.record_type_view)");
    this.FiM = new com.tencent.mm.plugin.finder.video.plugin.subvideo.a((RecordTypeSelectView)paramBaseScopePluginLayout, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR);
    paramBaseScopePluginLayout = new y((RelativeLayout)this.oaR, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR);
    paramBaseScopePluginLayout.NLh = false;
    Object localObject = ah.aiuX;
    this.FiN = paramBaseScopePluginLayout;
    this.oaS = ((ViewGroup)this.oaR.findViewById(l.e.FhW));
    paramBaseScopePluginLayout = (ViewGroup)this.oaR;
    localObject = this.oaS.findViewById(l.e.beauty_effect);
    s.s(localObject, "templateLayout.findViewById(R.id.beauty_effect)");
    this.FiO = new com.tencent.mm.plugin.finder.video.plugin.b(paramBaseScopePluginLayout, (View)localObject, (com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR);
    this.FiP = this.oaR.findViewById(l.e.FhV);
    this.FiQ = this.oaR.findViewById(l.e.Fib);
    this.FiR = this.oaR.findViewById(l.e.Fid);
    paramBaseScopePluginLayout = new ArrayList();
    paramBaseScopePluginLayout.add(this.FiN);
    paramBaseScopePluginLayout.add(this.FiI);
    localObject = ah.aiuX;
    this.FiS = paramBaseScopePluginLayout;
    this.FiT = ((ViewGroup)this.oaR.findViewById(l.e.FhY));
    this.FiQ.setOnClickListener((View.OnClickListener)this);
    this.FiP.setOnClickListener((View.OnClickListener)this);
    this.oaR.findViewById(l.e.FhX).setOnClickListener((View.OnClickListener)this);
    this.oaR.findViewById(l.e.FhZ).setOnClickListener((View.OnClickListener)this);
    paramBaseScopePluginLayout = this.FiL;
    localObject = new b..ExternalSyntheticLambda1(this);
    paramBaseScopePluginLayout.Fjg.onTouchListener = ((View.OnTouchListener)localObject);
    AppMethodBeat.o(337079);
  }
  
  private static final void a(Runnable paramRunnable, View paramView)
  {
    AppMethodBeat.i(337111);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramRunnable);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramRunnable, "$runnable");
    paramRunnable.run();
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(337111);
  }
  
  private static final boolean a(b paramb, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(337105);
    s.u(paramb, "this$0");
    boolean bool = paramb.FiN.Ldl.onTouchEvent(paramMotionEvent);
    AppMethodBeat.o(337105);
    return bool;
  }
  
  private final boolean c(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(337091);
    Object localObject = paramRecordConfigProvider.oSS.getByteArray("KEY_POST_VIDEO_TEMPLATE");
    if (localObject == null)
    {
      AppMethodBeat.o(337091);
      return false;
    }
    try
    {
      paramRecordConfigProvider = new fxr();
      paramRecordConfigProvider.parseFrom((byte[])localObject);
      Log.i("MicroMsg.FinderRecordControlPlugin", "template:" + paramRecordConfigProvider.id + " name:" + paramRecordConfigProvider.abVq.title);
      if (TextUtils.isEmpty((CharSequence)paramRecordConfigProvider.id))
      {
        AppMethodBeat.o(337091);
        return false;
      }
      this.FiU = true;
      this.FiJ.setVisibility(0);
      this.FiP.setVisibility(4);
      localObject = this.oaS;
      s.s(localObject, "templateLayout");
      com.tencent.mm.ui.anim.d.a.la((View)localObject);
      this.FiN.gIL();
      this.FiL.setVisibility(0);
      this.FiM.setVisibility(4);
      localObject = this.FiL;
      paramRecordConfigProvider = paramRecordConfigProvider.id;
      s.s(paramRecordConfigProvider, "template.id");
      s.u(paramRecordConfigProvider, "templateId");
      BaseScopePluginLayout.a(((c)localObject).oaR, null, null, (m)new c.c(paramRecordConfigProvider, (c)localObject, null), 3);
      this.FiV = true;
      AppMethodBeat.o(337091);
      return true;
    }
    catch (Exception paramRecordConfigProvider)
    {
      AppMethodBeat.o(337091);
    }
    return false;
  }
  
  private final void eLl()
  {
    AppMethodBeat.i(337097);
    this.FiJ.setVisibility(4);
    Object localObject = this.FiP;
    s.s(localObject, "templateCloseBtn");
    com.tencent.mm.ui.anim.d.a.kZ((View)localObject);
    this.FiL.setVisibility(0);
    this.FiM.setVisibility(4);
    localObject = this.oaS;
    s.s(localObject, "templateLayout");
    com.tencent.mm.ui.anim.d.a.la((View)localObject);
    AppMethodBeat.o(337097);
  }
  
  public final void RG(int paramInt)
  {
    AppMethodBeat.i(337326);
    Log.i("MicroMsg.FinderRecordControlPlugin", s.X("updateMaxRecordTimeMs ", Integer.valueOf(paramInt)));
    y localy = this.FiN;
    RecordConfigProvider localRecordConfigProvider = this.oaV;
    s.checkNotNull(localRecordConfigProvider);
    localy.NKX = kotlin.k.k.qv(paramInt, localRecordConfigProvider.NHZ + 250);
    AppMethodBeat.o(337326);
  }
  
  public final void a(RecordConfigProvider paramRecordConfigProvider)
  {
    AppMethodBeat.i(337264);
    s.u(paramRecordConfigProvider, "configProvider");
    v.a.a((v)this, paramRecordConfigProvider);
    this.oaV = paramRecordConfigProvider;
    this.FiN.e(paramRecordConfigProvider);
    if (!c(paramRecordConfigProvider))
    {
      paramRecordConfigProvider = this.FiL;
      BaseScopePluginLayout.a(paramRecordConfigProvider.oaR, null, null, (m)new c.e(paramRecordConfigProvider, null), 3);
    }
    AppMethodBeat.o(337264);
  }
  
  public final Object ag(d<? super ah> paramd)
  {
    AppMethodBeat.i(337319);
    paramd = l.a((kotlin.d.f)bg.kCh(), (m)new f(this, null), paramd);
    if (paramd == kotlin.d.a.a.aiwj)
    {
      AppMethodBeat.o(337319);
      return paramd;
    }
    paramd = ah.aiuX;
    AppMethodBeat.o(337319);
    return paramd;
  }
  
  public final int buc()
  {
    if ((this.FiU) || (this.FiV)) {
      return 3;
    }
    if (this.FiM.Gtk) {
      return 2;
    }
    return 1;
  }
  
  public final void bwk()
  {
    AppMethodBeat.i(337379);
    s.u(this, "this");
    AppMethodBeat.o(337379);
  }
  
  public final void d(boolean paramBoolean, Runnable paramRunnable)
  {
    AppMethodBeat.i(337341);
    s.u(paramRunnable, "runnable");
    if (paramBoolean)
    {
      this.FiN.gIH();
      AppMethodBeat.o(337341);
      return;
    }
    this.FiN.d(new b..ExternalSyntheticLambda0(paramRunnable));
    AppMethodBeat.o(337341);
  }
  
  public final String name()
  {
    AppMethodBeat.i(337368);
    String str = v.a.b(this);
    AppMethodBeat.o(337368);
    return str;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(337375);
    s.u(this, "this");
    AppMethodBeat.o(337375);
  }
  
  public final boolean onBackPress()
  {
    AppMethodBeat.i(337295);
    if (this.FiI.GsX.size() > 0)
    {
      BaseScopePluginLayout.a(this.oaR, (kotlin.d.f)bg.kCh(), null, (m)new e(this, null), 2);
      AppMethodBeat.o(337295);
      return true;
    }
    Iterator localIterator = this.FiS.iterator();
    while (localIterator.hasNext())
    {
      v localv = (v)localIterator.next();
      if (localv.onBackPress())
      {
        Log.i("MicroMsg.FinderRecordControlPlugin", "plugin:" + localv.name() + " handle back press");
        AppMethodBeat.o(337295);
        return true;
      }
    }
    AppMethodBeat.o(337295);
    return false;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(337356);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = l.e.Fib;
      if (paramView != null) {
        break label111;
      }
      label53:
      i = l.e.FhV;
      if (paramView != null) {
        break label148;
      }
      label61:
      i = l.e.FhX;
      if (paramView != null) {
        break label268;
      }
      label69:
      i = l.e.FhZ;
      if (paramView != null) {
        break label292;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/record/plugin/FinderRecordControlPlugin", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(337356);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label111:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = com.tencent.mm.plugin.finder.record.report.a.Fjw;
      com.tencent.mm.plugin.finder.record.report.a.azD("icon_shooting_template");
      this.FiU = true;
      this.FiN.gIL();
      eLl();
      continue;
      label148:
      if (paramView.intValue() != i) {
        break label61;
      }
      this.FiU = false;
      this.FiW = false;
      a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR, a.c.NQr);
      this.FiJ.setVisibility(0);
      paramView = this.FiP;
      s.s(paramView, "templateCloseBtn");
      com.tencent.mm.ui.anim.d.a.la(paramView);
      this.FiL.setVisibility(4);
      this.FiM.setVisibility(0);
      paramView = this.oaS;
      s.s(paramView, "templateLayout");
      com.tencent.mm.ui.anim.d.a.kZ((View)paramView);
      if (this.FiM.Gtk)
      {
        this.FiN.gIJ();
      }
      else
      {
        this.FiN.gIK();
        continue;
        label268:
        if (paramView.intValue() != i) {
          break label69;
        }
        a.b.a((com.tencent.mm.plugin.recordvideo.plugin.parent.a)this.oaR, a.c.NNO);
        continue;
        label292:
        if (paramView.intValue() == i)
        {
          this.FiN.yC(true);
          ((e)this.FiH.getValue()).show();
        }
      }
    }
  }
  
  public final void onDetach()
  {
    AppMethodBeat.i(337385);
    s.u(this, "this");
    AppMethodBeat.o(337385);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(337276);
    s.u((v)this, "this");
    Iterator localIterator = ((Iterable)this.FiS).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onPause();
    }
    AppMethodBeat.o(337276);
  }
  
  public final void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    AppMethodBeat.i(337389);
    v.a.a(this, paramArrayOfString, paramArrayOfInt);
    AppMethodBeat.o(337389);
  }
  
  public final MJTemplateMetadata onRequestTemplateMetadata(String paramString)
  {
    AppMethodBeat.i(337313);
    s.u(paramString, "p0");
    paramString = this.FiL.onRequestTemplateMetadata(paramString);
    AppMethodBeat.o(337313);
    return paramString;
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(337285);
    s.u((v)this, "this");
    Iterator localIterator = ((Iterable)this.FiS).iterator();
    while (localIterator.hasNext()) {
      ((v)localIterator.next()).onResume();
    }
    Log.d("MicroMsg.FinderRecordControlPlugin", s.X("onResume, templateMode:", Boolean.valueOf(this.FiU)));
    if ((!this.FiV) && ((this.FiU) || (this.FiW)))
    {
      this.FiN.gIL();
      eLl();
    }
    AppMethodBeat.o(337285);
  }
  
  public final void release()
  {
    AppMethodBeat.i(337396);
    s.u(this, "this");
    AppMethodBeat.o(337396);
  }
  
  public final void reset()
  {
    AppMethodBeat.i(337304);
    s.u((v)this, "this");
    this.FiN.reset();
    if (buc() != 3)
    {
      this.FiJ.setVisibility(0);
      if (this.FiI.GsX.isEmpty())
      {
        this.FiM.setVisibility(0);
        this.FiT.setVisibility(4);
        ViewGroup localViewGroup = this.oaS;
        s.s(localViewGroup, "templateLayout");
        com.tencent.mm.ui.anim.d.a.kZ((View)localViewGroup);
      }
    }
    AppMethodBeat.o(337304);
  }
  
  public final void setVisibility(int paramInt)
  {
    AppMethodBeat.i(337269);
    s.u((v)this, "this");
    this.FiK.clearAnimation();
    this.FiK.setVisibility(paramInt);
    AppMethodBeat.o(337269);
  }
  
  public final void ts(boolean paramBoolean)
  {
    AppMethodBeat.i(337333);
    Log.i("MicroMsg.FinderRecordControlPlugin", s.X("switchToEmptyTemplate:", Boolean.valueOf(paramBoolean)));
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      this.FiU = bool;
      this.FiW = paramBoolean;
      AppMethodBeat.o(337333);
      return;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class c
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public c(b paramb, d<? super c> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337065);
      paramObject = (d)new c(this.FiX, paramd);
      AppMethodBeat.o(337065);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337060);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337060);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.a(this.FiX).setVisibility(0);
      paramObject = ah.aiuX;
      AppMethodBeat.o(337060);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class d
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public d(b paramb, d<? super d> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337061);
      paramObject = (d)new d(this.FiX, paramd);
      AppMethodBeat.o(337061);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337053);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337053);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.a(this.FiX).setVisibility(4);
      paramObject = b.b(this.FiX);
      s.s(paramObject, "templateLayout");
      com.tencent.mm.ui.anim.d.a.la((View)paramObject);
      paramObject = b.c(this.FiX);
      s.s(paramObject, "templateCloseBtn");
      com.tencent.mm.ui.anim.d.a.la(paramObject);
      paramObject = b.d(this.FiX);
      s.s(paramObject, "subRecordLayout");
      com.tencent.mm.ui.anim.d.a.la((View)paramObject);
      b.e(this.FiX).setVisibility(4);
      paramObject = ah.aiuX;
      AppMethodBeat.o(337053);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    e(b paramb, d<? super e> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337051);
      paramObject = (d)new e(this.FiX, paramd);
      AppMethodBeat.o(337051);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337042);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337042);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.a(this.FiX).fjO();
      paramObject = ah.aiuX;
      AppMethodBeat.o(337042);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    f(b paramb, d<? super f> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337037);
      paramObject = (d)new f(this.FiX, paramd);
      AppMethodBeat.o(337037);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337028);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337028);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.f(this.FiX).abi(b.i(this.FiX).GsX.size());
      b.f(this.FiX).agC(com.tencent.mm.plugin.recordvideo.b.h.record_hint_record_too_short);
      this.FiX.reset();
      paramObject = ah.aiuX;
      AppMethodBeat.o(337028);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class g
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public g(a.c paramc, Bundle paramBundle, b paramb, d<? super g> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337043);
      paramObject = (d)new g(this.Fiw, this.Din, this.FiX, paramd);
      AppMethodBeat.o(337043);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      int i = 0;
      AppMethodBeat.i(337032);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337032);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = this.Fiw;
      switch (a.$EnumSwitchMapping$0[paramObject.ordinal()])
      {
      }
      for (;;)
      {
        paramObject = ah.aiuX;
        AppMethodBeat.o(337032);
        return paramObject;
        paramObject = this.Din;
        if (paramObject != null)
        {
          localObject = this.FiX;
          y localy = b.f((b)localObject);
          RecordConfigProvider localRecordConfigProvider;
          if (!paramObject.getBoolean("PARAM_1_BOOLEAN"))
          {
            localRecordConfigProvider = b.j((b)localObject);
            if (localRecordConfigProvider == null)
            {
              bool = false;
              label148:
              if (!bool) {
                break label215;
              }
            }
          }
          label215:
          for (boolean bool = true;; bool = false)
          {
            localy.AY(bool);
            if (!paramObject.getBoolean("PARAM_1_BOOLEAN")) {
              break label220;
            }
            b.f((b)localObject).gIJ();
            b.k((b)localObject).setVisibility(8);
            b.l((b)localObject).setVisibility(8);
            break;
            bool = s.p(localRecordConfigProvider.NHV, Boolean.TRUE);
            break label148;
          }
          label220:
          b.f((b)localObject).gIK();
          b.k((b)localObject).setVisibility(0);
          b.l((b)localObject).setVisibility(0);
          continue;
          paramObject = this.Din;
          if (paramObject == null) {}
          for (paramObject = null; paramObject == null; paramObject = Boolean.valueOf(paramObject.getBoolean("PARAM_1_BOOLEAN")))
          {
            paramObject = ah.aiuX;
            AppMethodBeat.o(337032);
            return paramObject;
          }
          paramObject.booleanValue();
          localObject = this.FiX;
          if (paramObject.booleanValue()) {
            i = 4;
          }
          ((b)localObject).setVisibility(i);
        }
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class h
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public h(b paramb, d<? super h> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337040);
      paramObject = (d)new h(this.FiX, paramd);
      AppMethodBeat.o(337040);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337030);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337030);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.a(this.FiX).setVisibility(0);
      b.f(this.FiX).AY(false);
      b.f(this.FiX).reset();
      paramObject = b.d(this.FiX);
      s.s(paramObject, "subRecordLayout");
      com.tencent.mm.ui.anim.d.a.kZ((View)paramObject);
      paramObject = ah.aiuX;
      AppMethodBeat.o(337030);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class i
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public i(b paramb, d<? super i> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337035);
      paramObject = (d)new i(this.FiX, paramd);
      AppMethodBeat.o(337035);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337026);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337026);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      if (b.h(this.FiX)) {
        b.a(this.FiX).setVisibility(0);
      }
      for (;;)
      {
        paramObject = b.g(this.FiX);
        Log.i("MicroMsg.FinderTemplateListPlugin", s.X("stop record, cur selected template idx: ", Integer.valueOf(paramObject.Fjh)));
        paramObject.vqv = true;
        localObject = paramObject.Fjd.getLayoutManager();
        if (localObject != null) {
          break;
        }
        paramObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(337026);
        throw paramObject;
        paramObject = b.c(this.FiX);
        s.s(paramObject, "templateCloseBtn");
        com.tencent.mm.ui.anim.d.a.kZ(paramObject);
      }
      localObject = (LinearLayoutManager)localObject;
      int i = ((LinearLayoutManager)localObject).Ju();
      int k = ((LinearLayoutManager)localObject).Jw();
      if (i <= k)
      {
        int j;
        do
        {
          j = i;
          i = j + 1;
          localObject = paramObject.Fjd.fU(j);
          if (localObject != null)
          {
            localObject = ((RecyclerView.v)localObject).caK;
            if (localObject != null)
            {
              ((View)localObject).setVisibility(0);
              ((View)localObject).setAlpha(1.0F);
            }
          }
        } while (j != k);
      }
      paramObject.Fjd.requestLayout();
      paramObject = ah.aiuX;
      AppMethodBeat.o(337026);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class j
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public j(b paramb, d<? super j> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337038);
      paramObject = (d)new j(this.FiX, paramd);
      AppMethodBeat.o(337038);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337029);
      Object localObject = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337029);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      paramObject = b.c(this.FiX);
      s.s(paramObject, "templateCloseBtn");
      com.tencent.mm.ui.anim.d.a.la(paramObject);
      paramObject = b.g(this.FiX);
      Log.i("MicroMsg.FinderTemplateListPlugin", s.X("start record, cur selected template idx: ", Integer.valueOf(paramObject.Fjh)));
      paramObject.vqv = false;
      localObject = paramObject.Fjd.getLayoutManager();
      if (localObject == null)
      {
        paramObject = new NullPointerException("null cannot be cast to non-null type androidx.recyclerview.widget.LinearLayoutManager");
        AppMethodBeat.o(337029);
        throw paramObject;
      }
      localObject = (LinearLayoutManager)localObject;
      int i = ((LinearLayoutManager)localObject).Ju();
      int k = ((LinearLayoutManager)localObject).Jw();
      if (i <= k)
      {
        int j;
        do
        {
          j = i;
          i = j + 1;
          if (j != paramObject.Fjh)
          {
            Log.i("MicroMsg.FinderTemplateListPlugin", s.X("startRecord fadeOut view index:", Integer.valueOf(j)));
            localObject = paramObject.Fjd.fU(j);
            if (localObject != null)
            {
              localObject = ((RecyclerView.v)localObject).caK;
              if (localObject != null) {
                com.tencent.mm.ui.anim.d.a.la((View)localObject);
              }
            }
          }
        } while (j != k);
      }
      paramObject = ah.aiuX;
      AppMethodBeat.o(337029);
      return paramObject;
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  public static final class k
    extends kotlin.d.b.a.k
    implements m<aq, d<? super ah>, Object>
  {
    int label;
    
    public k(b paramb, String paramString, d<? super k> paramd)
    {
      super(paramd);
    }
    
    public final d<ah> create(Object paramObject, d<?> paramd)
    {
      AppMethodBeat.i(337027);
      paramObject = (d)new k(this.FiX, this.FiY, paramd);
      AppMethodBeat.o(337027);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(337021);
      kotlin.d.a.a locala = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(337021);
        throw paramObject;
      }
      ResultKt.throwOnFailure(paramObject);
      b.f(this.FiX).cH(this.FiY, true);
      paramObject = ah.aiuX;
      AppMethodBeat.o(337021);
      return paramObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.record.plugin.b
 * JD-Core Version:    0.7.0.1
 */