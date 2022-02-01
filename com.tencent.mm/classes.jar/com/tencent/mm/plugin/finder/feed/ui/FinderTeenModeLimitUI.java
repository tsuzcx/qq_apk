package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.cn;
import com.tencent.mm.plugin.finder.PluginFinder;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.report.z;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.viewmodel.component.as;
import com.tencent.mm.plugin.finder.viewmodel.component.as.a;
import com.tencent.mm.plugin.finder.viewmodel.teenmode.c;
import com.tencent.mm.protocal.protobuf.bui;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.storage.au;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.y;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.ah;
import kotlin.g.a.m;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.n.n;
import kotlinx.coroutines.aq;
import kotlinx.coroutines.ar;
import kotlinx.coroutines.j;
import org.json.JSONObject;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "guardianView", "Landroid/view/View;", "isCurfew", "", "doVerifyPassword", "", "exitFinder", "getCommentScene", "", "getGuardianContact", "Lcom/tencent/mm/storage/Contact;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLayoutId", "handleConfirmOK", "initGuardianView", "initView", "isFinish", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "report21875", "eid", "", "isResult", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderTeenModeLimitUI
  extends MMFinderUI
{
  public static final FinderTeenModeLimitUI.a Bse;
  private View Bsf;
  private boolean Bsg;
  
  static
  {
    AppMethodBeat.i(365731);
    Bse = new FinderTeenModeLimitUI.a((byte)0);
    AppMethodBeat.o(365731);
  }
  
  private static final void a(FinderTeenModeLimitUI paramFinderTeenModeLimitUI, View paramView)
  {
    AppMethodBeat.i(365695);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderTeenModeLimitUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderTeenModeLimitUI, "this$0");
    Log.i("FinderHotWordTimelineUI", "exitFinder");
    paramFinderTeenModeLimitUI.setResult(11112);
    if (!paramFinderTeenModeLimitUI.efT()) {
      paramFinderTeenModeLimitUI.finish();
    }
    paramFinderTeenModeLimitUI.t("teenagemode_timelock_exit", 0, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365695);
  }
  
  private static final void b(FinderTeenModeLimitUI paramFinderTeenModeLimitUI, View paramView)
  {
    AppMethodBeat.i(365702);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderTeenModeLimitUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderTeenModeLimitUI, "this$0");
    Log.i("FinderHotWordTimelineUI", "doVerifyPassword");
    ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).n((Activity)paramFinderTeenModeLimitUI, 12222);
    paramFinderTeenModeLimitUI.t("teenagemode_timelock_pwdvalidation", 0, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(365702);
  }
  
  private final boolean efT()
  {
    AppMethodBeat.i(365683);
    boolean bool1 = isFinishing();
    boolean bool2 = isDestroyed();
    AppMethodBeat.o(365683);
    return bool1 | bool2;
  }
  
  private final void t(String paramString, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(365674);
    Object localObject1 = new JSONObject();
    Object localObject2;
    if (this.Bsg)
    {
      ((JSONObject)localObject1).put("limit_type", "1");
      if (paramBoolean) {
        ((JSONObject)localObject1).put("valid_result", paramInt);
      }
      localObject2 = z.FrZ;
      localObject1 = ((JSONObject)localObject1).toString();
      s.s(localObject1, "kvJson.toString()");
      localObject2 = n.bV((String)localObject1, ",", ";");
      localObject1 = as.GSQ;
      localObject1 = getContext();
      s.s(localObject1, "context");
      localObject1 = as.a.hu((Context)localObject1);
      if (localObject1 != null) {
        break label140;
      }
    }
    label140:
    for (localObject1 = null;; localObject1 = ((as)localObject1).fou())
    {
      z.b(1, paramString, (String)localObject2, (bui)localObject1);
      AppMethodBeat.o(365674);
      return;
      ((JSONObject)localObject1).put("limit_type", "2");
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getCommentScene()
  {
    return 127;
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_teen_mode_tip_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(365780);
    Object localObject = findViewById(e.e.exit_finder_btn);
    if (localObject != null) {
      ((View)localObject).setOnClickListener(new FinderTeenModeLimitUI..ExternalSyntheticLambda1(this));
    }
    TextView localTextView = (TextView)findViewById(e.e.tips_title_content);
    int i;
    int j;
    if (localTextView != null)
    {
      if (!this.Bsg) {
        break label182;
      }
      localObject = c.GWG;
      i = c.fpB();
      localObject = c.GWG;
      j = c.fpC();
    }
    for (localObject = (CharSequence)localTextView.getResources().getString(e.h.finder_teen_mode_tips_content, new Object[] { Integer.valueOf(i), Integer.valueOf(j) });; localObject = (CharSequence)localTextView.getResources().getString(e.h.finder_teen_mode_tips_content_40, new Object[] { Integer.valueOf(i) }))
    {
      localTextView.setText((CharSequence)localObject);
      localObject = findViewById(e.e.layout_teen_limit_action_one);
      if (localObject != null) {
        ((View)localObject).setOnClickListener(new FinderTeenModeLimitUI..ExternalSyntheticLambda0(this));
      }
      localObject = findViewById(e.e.layout_teen_limit_action_two);
      s.s(localObject, "findViewById(R.id.layout_teen_limit_action_two)");
      this.Bsf = ((View)localObject);
      j.a(ar.kBZ(), null, null, (m)new c(this, null), 3);
      AppMethodBeat.o(365780);
      return;
      label182:
      localObject = c.GWG;
      i = c.fpA() / 60;
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(365793);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 12222) {
      switch (paramInt2)
      {
      }
    }
    for (;;)
    {
      AppMethodBeat.o(365793);
      return;
      t("teenagemode_timelock_pwdvalidation_result", 0, true);
      AppMethodBeat.o(365793);
      return;
      paramIntent = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.teenmode.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.teenmode.d.class)).vs(this.Bsg);
      setResult(-1);
      if (!efT()) {
        finish();
      }
      t("teenagemode_timelock_pwdvalidation_result", 1, true);
    }
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(365788);
    setResult(11112);
    super.onBackPressed();
    AppMethodBeat.o(365788);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(365757);
    super.onCreate(paramBundle);
    paramBundle = getSupportActionBar();
    if (paramBundle != null) {
      paramBundle.hide();
    }
    getController().s((Activity)this, getResources().getColor(e.b.white));
    this.Bsg = getIntent().getBooleanExtra("key_is_curfew", false);
    paramBundle = new JSONObject();
    if (this.Bsg) {
      paramBundle.put("limit_type", "1");
    }
    for (;;)
    {
      getIntent().putExtra("key_udf_kv", paramBundle.toString());
      paramBundle = com.tencent.mm.ui.component.k.aeZF;
      ((com.tencent.mm.plugin.finder.viewmodel.teenmode.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.teenmode.d.class)).GWK = false;
      initView();
      AppMethodBeat.o(365757);
      return;
      paramBundle.put("limit_type", "2");
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(365770);
    super.onDestroy();
    com.tencent.mm.ui.component.k localk = com.tencent.mm.ui.component.k.aeZF;
    ((com.tencent.mm.plugin.finder.viewmodel.teenmode.d)com.tencent.mm.ui.component.k.cn(PluginFinder.class).q(com.tencent.mm.plugin.finder.viewmodel.teenmode.d.class)).GWK = true;
    AppMethodBeat.o(365770);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends kotlin.d.b.a.k
    implements m<aq, kotlin.d.d<? super ah>, Object>
  {
    int label;
    
    c(FinderTeenModeLimitUI paramFinderTeenModeLimitUI, kotlin.d.d<? super c> paramd)
    {
      super(paramd);
    }
    
    private static final void a(FinderTeenModeLimitUI paramFinderTeenModeLimitUI, View paramView1, View paramView2)
    {
      AppMethodBeat.i(364950);
      Object localObject1 = new Object();
      Object localObject2 = new b();
      ((b)localObject2).cH(paramFinderTeenModeLimitUI);
      ((b)localObject2).cH(paramView1);
      ((b)localObject2).cH(paramView2);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI$initGuardianView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((b)localObject2).aYj());
      int i;
      if (FinderTeenModeLimitUI.c(paramFinderTeenModeLimitUI))
      {
        paramView2 = new StringBuilder();
        localObject1 = c.GWG;
        localObject1 = c.fpB() + ":00";
        paramView2 = new StringBuilder("0");
        localObject2 = c.GWG;
        localObject2 = c.fpC() + ":00";
        i = 6;
        paramView2 = s.X("finder_limit_curfew_", Integer.valueOf(cn.getSyncServerTimeSecond()));
      }
      int j;
      for (localObject1 = paramView1.getResources().getString(e.h.finder_teen_mode_guardian_curfew_req_content, new Object[] { localObject1, localObject2 });; localObject1 = paramView1.getResources().getString(e.h.finder_teen_mode_guardian_lock_req_content, new Object[] { Integer.valueOf(j) }))
      {
        s.s(localObject1, "if (isCurfew) {\n        …  )\n                    }");
        Log.i("FinderHotWordTimelineUI", s.X("key: ", paramView2));
        ((com.tencent.mm.plugin.teenmode.a.d)h.ax(com.tencent.mm.plugin.teenmode.a.d.class)).a(paramView1.getContext(), i, paramView2, paramView1.getResources().getString(e.h.finder_teen_mode_guardian_temp_req_title), (String)localObject1, "", null, new FinderTeenModeLimitUI.c..ExternalSyntheticLambda1(paramFinderTeenModeLimitUI));
        com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderTeenModeLimitUI$initGuardianView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(364950);
        return;
        paramView2 = c.GWG;
        j = c.fpA() / 60;
        i = 5;
        paramView2 = s.X("finder_limit_time_lock_", Integer.valueOf(cn.getSyncServerTimeSecond()));
      }
    }
    
    private static final void a(FinderTeenModeLimitUI paramFinderTeenModeLimitUI, boolean paramBoolean)
    {
      AppMethodBeat.i(364929);
      if (paramBoolean) {
        com.tencent.mm.ae.d.a(600L, (kotlin.g.a.a)new a(paramFinderTeenModeLimitUI));
      }
      AppMethodBeat.o(364929);
    }
    
    public final kotlin.d.d<ah> create(Object paramObject, kotlin.d.d<?> paramd)
    {
      AppMethodBeat.i(364991);
      paramObject = (kotlin.d.d)new c(this.Bsh, paramd);
      AppMethodBeat.o(364991);
      return paramObject;
    }
    
    public final Object invokeSuspend(Object paramObject)
    {
      AppMethodBeat.i(364985);
      Object localObject2 = kotlin.d.a.a.aiwj;
      switch (this.label)
      {
      default: 
        paramObject = new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        AppMethodBeat.o(364985);
        throw paramObject;
      case 0: 
        ResultKt.throwOnFailure(paramObject);
        paramObject = (kotlin.d.d)this;
        this.label = 1;
        localObject1 = FinderTeenModeLimitUI.ac(paramObject);
        paramObject = localObject1;
        if (localObject1 == localObject2)
        {
          AppMethodBeat.o(364985);
          return localObject2;
        }
        break;
      case 1: 
        ResultKt.throwOnFailure(paramObject);
      }
      Object localObject1 = (au)paramObject;
      paramObject = FinderTeenModeLimitUI.a(this.Bsh);
      if (paramObject == null)
      {
        s.bIx("guardianView");
        paramObject = null;
        localObject2 = this.Bsh;
        TextView localTextView = (TextView)paramObject.findViewById(e.e.tv_teen_limit_action_title);
        localTextView.setText((CharSequence)localTextView.getResources().getString(e.h.finder_teen_mode_send_to_guardian));
        paramObject.setOnClickListener(new FinderTeenModeLimitUI.c..ExternalSyntheticLambda0((FinderTeenModeLimitUI)localObject2, paramObject));
        if (localObject1 == null) {
          break label194;
        }
      }
      label194:
      for (int i = 0;; i = 8)
      {
        paramObject.setVisibility(i);
        paramObject = ah.aiuX;
        AppMethodBeat.o(364985);
        return paramObject;
        break;
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends u
      implements kotlin.g.a.a<ah>
    {
      a(FinderTeenModeLimitUI paramFinderTeenModeLimitUI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderTeenModeLimitUI
 * JD-Core Version:    0.7.0.1
 */