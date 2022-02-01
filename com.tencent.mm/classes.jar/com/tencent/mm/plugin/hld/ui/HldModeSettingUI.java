package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.b.f;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.y.b;
import com.tencent.threadpool.h;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldModeSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "()V", "currentMode", "", "normalSelectIv", "Landroid/widget/ImageView;", "normalTitle", "Landroid/widget/RelativeLayout;", "oriMode", "safetySelectIv", "safetyTitle", "settingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "doOplogSyncCallback", "", "success", "getForceOrientation", "", "getLayoutId", "initView", "isSelect", "id", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateChildrenView", "updateStyle", "isSafeMode", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class HldModeSettingUI
  extends MMActivity
  implements f
{
  public static final HldModeSettingUI.a JxM;
  private ImageView JxB;
  private ImageView JxC;
  private RelativeLayout JxD;
  private RelativeLayout JxE;
  private w JxF;
  private boolean JxN;
  private boolean JxO;
  
  static
  {
    AppMethodBeat.i(312409);
    JxM = new HldModeSettingUI.a((byte)0);
    AppMethodBeat.o(312409);
  }
  
  public HldModeSettingUI()
  {
    AppMethodBeat.i(312337);
    com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.JyA;
    this.JxN = com.tencent.mm.plugin.hld.f.i.fOo();
    locali = com.tencent.mm.plugin.hld.f.i.JyA;
    this.JxO = com.tencent.mm.plugin.hld.f.i.fOo();
    AppMethodBeat.o(312337);
  }
  
  private final void Ys(int paramInt)
  {
    int i = 4;
    AppMethodBeat.i(312348);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(paramInt);
    localLinearLayout.setVisibility(0);
    Object localObject = (RelativeLayout)localLinearLayout.findViewById(a.f.title_ll);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(a.f.state_icon);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.f.title_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.f.desc_tv);
    localImageView.setTag(Integer.valueOf(paramInt));
    if (paramInt == a.f.safety_item)
    {
      this.JxB = localImageView;
      this.JxD = ((RelativeLayout)localObject);
      localTextView1.setText((CharSequence)getString(a.j.ime_mode_safety_name));
      localTextView2.setText((CharSequence)getString(a.j.ime_mode_safety_desc));
      localObject = this.JxB;
      if (localObject != null)
      {
        if (!this.JxO) {
          break label172;
        }
        i = 0;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    label172:
    do
    {
      do
      {
        localLinearLayout.setOnClickListener(new HldModeSettingUI..ExternalSyntheticLambda2(paramInt, this));
        AppMethodBeat.o(312348);
        return;
        i = 4;
        break;
      } while (paramInt != a.f.normal_item);
      this.JxC = localImageView;
      this.JxE = ((RelativeLayout)localObject);
      localTextView1.setText((CharSequence)getString(a.j.ime_mode_normal_name));
      localTextView2.setText((CharSequence)getString(a.j.ime_mode_normal_desc));
      localObject = this.JxC;
    } while (localObject == null);
    if (this.JxO) {}
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      break;
      i = 0;
    }
  }
  
  private static final void a(int paramInt, HldModeSettingUI paramHldModeSettingUI, View paramView)
  {
    AppMethodBeat.i(312384);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramHldModeSettingUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldModeSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramHldModeSettingUI, "this$0");
    if (paramInt == a.f.safety_item)
    {
      paramView = paramHldModeSettingUI.JxB;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramHldModeSettingUI.JxC;
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      paramHldModeSettingUI.JxN = true;
      paramHldModeSettingUI.xa(true);
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/hld/ui/HldModeSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312384);
      return;
      if (paramInt == a.f.normal_item)
      {
        paramView = paramHldModeSettingUI.JxB;
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        paramView = paramHldModeSettingUI.JxC;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramHldModeSettingUI.JxN = false;
        paramHldModeSettingUI.xa(false);
      }
    }
  }
  
  private static final void a(HldModeSettingUI paramHldModeSettingUI)
  {
    AppMethodBeat.i(312391);
    s.u(paramHldModeSettingUI, "this$0");
    Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
    localIntent.putExtra("ime_load_contact", true);
    localIntent.putExtra("ime_mode_switch", true);
    c.n(localIntent, "hld");
    if (paramHldModeSettingUI.JxN)
    {
      paramHldModeSettingUI = com.tencent.mm.plugin.hld.c.a.JoL;
      com.tencent.mm.plugin.hld.c.a.wQ(true);
      AppMethodBeat.o(312391);
      return;
    }
    paramHldModeSettingUI = com.tencent.mm.plugin.hld.c.a.JoL;
    com.tencent.mm.plugin.hld.c.a.wQ(false);
    AppMethodBeat.o(312391);
  }
  
  private static final boolean a(HldModeSettingUI paramHldModeSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312364);
    s.u(paramHldModeSettingUI, "this$0");
    paramHldModeSettingUI.finish();
    AppMethodBeat.o(312364);
    return true;
  }
  
  private static final void b(HldModeSettingUI paramHldModeSettingUI)
  {
    AppMethodBeat.i(312399);
    s.u(paramHldModeSettingUI, "this$0");
    aa.makeText((Context)paramHldModeSettingUI, (CharSequence)paramHldModeSettingUI.getString(a.j.ime_mode_setting_fail), 0).show();
    AppMethodBeat.o(312399);
  }
  
  private static final boolean b(HldModeSettingUI paramHldModeSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312375);
    s.u(paramHldModeSettingUI, "this$0");
    Log.i("WxIme.HldModeSettingUI", "current mode is safety(" + paramHldModeSettingUI.JxN + "), oriMode:" + paramHldModeSettingUI.JxO);
    if (paramHldModeSettingUI.JxO != paramHldModeSettingUI.JxN)
    {
      paramMenuItem = (Context)paramHldModeSettingUI;
      paramHldModeSettingUI.getString(a.j.app_tip);
      paramHldModeSettingUI.JxF = com.tencent.mm.ui.base.k.a(paramMenuItem, paramHldModeSettingUI.getString(a.j.app_waiting), false, null);
      paramMenuItem = e.JoK;
      if (paramHldModeSettingUI.JxO)
      {
        paramMenuItem = com.tencent.mm.plugin.hld.model.b.Jur;
        e.a.a(paramMenuItem, 0L, (f)paramHldModeSettingUI, 2);
      }
    }
    for (;;)
    {
      AppMethodBeat.o(312375);
      return true;
      paramMenuItem = com.tencent.mm.plugin.hld.model.b.Jus;
      break;
      paramHldModeSettingUI.finish();
    }
  }
  
  private final void xa(boolean paramBoolean)
  {
    AppMethodBeat.i(312359);
    Object localObject2;
    label32:
    Object localObject3;
    if (paramBoolean)
    {
      localObject1 = this.JxD;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.JxE;
        if (localObject2 != null) {
          break label285;
        }
        localObject2 = null;
        if (!(localObject1 instanceof View)) {
          break label334;
        }
        localObject3 = (View)localObject1;
        label45:
        if (localObject3 != null) {
          ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_select_bg);
        }
        if (!(localObject2 instanceof View)) {
          break label340;
        }
        localObject3 = (View)localObject2;
        label71:
        if (localObject3 != null) {
          ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_unselect_bg);
        }
        if (!(localObject1 instanceof View)) {
          break label346;
        }
        localObject3 = (View)localObject1;
        label97:
        if (localObject3 != null)
        {
          localObject3 = (TextView)((View)localObject3).findViewById(a.f.title_tv);
          if (localObject3 != null) {
            ((TextView)localObject3).setTextColor(getResources().getColor(a.c.Brand));
          }
        }
        if (!(localObject1 instanceof View)) {
          break label352;
        }
        localObject1 = (View)localObject1;
        label147:
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(a.f.desc_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getResources().getColor(a.c.Brand));
          }
        }
        if (!(localObject2 instanceof View)) {
          break label357;
        }
        localObject1 = (View)localObject2;
        label192:
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(a.f.title_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getResources().getColor(a.c.normal_text_color));
          }
        }
        if (!(localObject2 instanceof View)) {
          break label362;
        }
      }
    }
    label285:
    label304:
    label326:
    label334:
    label340:
    label346:
    label352:
    label357:
    label362:
    for (Object localObject1 = (View)localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = (TextView)((View)localObject1).findViewById(a.f.desc_tv);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
        }
      }
      AppMethodBeat.o(312359);
      return;
      localObject1 = ((RelativeLayout)localObject1).getParent();
      break;
      localObject2 = ((RelativeLayout)localObject2).getParent();
      break label32;
      localObject1 = this.JxE;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.JxD;
        if (localObject2 != null) {
          break label326;
        }
      }
      for (localObject2 = null;; localObject2 = ((RelativeLayout)localObject2).getParent())
      {
        break;
        localObject1 = ((RelativeLayout)localObject1).getParent();
        break label304;
      }
      localObject3 = null;
      break label45;
      localObject3 = null;
      break label71;
      localObject3 = null;
      break label97;
      localObject1 = null;
      break label147;
      localObject1 = null;
      break label192;
    }
  }
  
  public final int getForceOrientation()
  {
    return 1;
  }
  
  public final int getLayoutId()
  {
    return a.m.wxime_safety_setting;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(312476);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(new HldModeSettingUI..ExternalSyntheticLambda0(this));
    addTextOptionMenu(0, getString(a.j.app_finish), new HldModeSettingUI..ExternalSyntheticLambda1(this), null, y.b.adEJ);
    Ys(a.f.safety_item);
    Ys(a.f.normal_item);
    xa(this.JxO);
    AppMethodBeat.o(312476);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312464);
    com.tencent.mm.plugin.hld.model.k localk = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.rP(System.currentTimeMillis());
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(312464);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(312491);
    Log.i("WxIme.HldModeSettingUI", s.X("doOplogSyncCallback ", Boolean.valueOf(paramBoolean)));
    Object localObject = this.JxF;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.JyA;
      com.tencent.mm.plugin.hld.f.i.xo(this.JxN);
      h.ahAA.bm(new HldModeSettingUI..ExternalSyntheticLambda3(this));
      finish();
      AppMethodBeat.o(312491);
      return;
    }
    h.ahAA.bk(new HldModeSettingUI..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(312491);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldModeSettingUI
 * JD-Core Version:    0.7.0.1
 */