package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.br.c;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.b.f;
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.w;
import com.tencent.threadpool.h;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldInitModeUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "()V", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "finishLayout", "Landroid/widget/FrameLayout;", "getFinishLayout", "()Landroid/widget/FrameLayout;", "finishLayout$delegate", "normalSelectIv", "Landroid/widget/ImageView;", "normalTitle", "Landroid/widget/RelativeLayout;", "safetySelectIv", "safetyTitle", "settingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "doOplogSyncCallback", "", "success", "", "getForceOrientation", "", "getLayoutId", "handleInitMode", "safetyMode", "initView", "isSelect", "id", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateChildrenView", "updateStyle", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public class HldInitModeUI
  extends MMActivity
  implements View.OnClickListener, f
{
  public static final HldInitModeUI.a Jxz;
  private final j Jst;
  private final j JxA;
  private ImageView JxB;
  private ImageView JxC;
  private RelativeLayout JxD;
  private RelativeLayout JxE;
  private w JxF;
  
  static
  {
    AppMethodBeat.i(312530);
    Jxz = new HldInitModeUI.a((byte)0);
    AppMethodBeat.o(312530);
  }
  
  public HldInitModeUI()
  {
    AppMethodBeat.i(312442);
    this.Jst = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.JxA = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(312442);
  }
  
  private final boolean YE(int paramInt)
  {
    AppMethodBeat.i(312460);
    if (((ImageView)((LinearLayout)findViewById(paramInt)).findViewById(a.f.state_icon)).getVisibility() == 0)
    {
      AppMethodBeat.o(312460);
      return true;
    }
    AppMethodBeat.o(312460);
    return false;
  }
  
  private final void Ys(int paramInt)
  {
    AppMethodBeat.i(312473);
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
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
    }
    for (;;)
    {
      localLinearLayout.setOnClickListener(new HldInitModeUI..ExternalSyntheticLambda1(paramInt, this));
      AppMethodBeat.o(312473);
      return;
      if (paramInt == a.f.normal_item)
      {
        this.JxC = localImageView;
        this.JxE = ((RelativeLayout)localObject);
        localTextView1.setText((CharSequence)getString(a.j.ime_mode_normal_name));
        localTextView2.setText((CharSequence)getString(a.j.ime_mode_normal_desc));
        localObject = this.JxC;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(4);
        }
      }
    }
  }
  
  private static final void a(int paramInt, HldInitModeUI paramHldInitModeUI, View paramView)
  {
    AppMethodBeat.i(312506);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.sc(paramInt);
    localb.cH(paramHldInitModeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramHldInitModeUI, "this$0");
    if (paramInt == a.f.safety_item)
    {
      paramView = paramHldInitModeUI.JxB;
      if (paramView != null) {
        paramView.setVisibility(0);
      }
      paramView = paramHldInitModeUI.JxC;
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      paramHldInitModeUI.getFinishBt().setEnabled(true);
      paramHldInitModeUI.getFinishBt().setClickable(true);
      paramHldInitModeUI.fNv();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312506);
      return;
      if (paramInt == a.f.normal_item)
      {
        paramView = paramHldInitModeUI.JxB;
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        paramView = paramHldInitModeUI.JxC;
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramHldInitModeUI.getFinishBt().setEnabled(true);
        paramHldInitModeUI.getFinishBt().setClickable(true);
        paramHldInitModeUI.fNv();
      }
    }
  }
  
  private static final void a(HldInitModeUI paramHldInitModeUI)
  {
    AppMethodBeat.i(312520);
    s.u(paramHldInitModeUI, "this$0");
    aa.makeText((Context)paramHldInitModeUI, (CharSequence)paramHldInitModeUI.getString(a.j.ime_mode_setting_fail), 0).show();
    AppMethodBeat.o(312520);
  }
  
  private static final boolean a(HldInitModeUI paramHldInitModeUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312497);
    s.u(paramHldInitModeUI, "this$0");
    paramHldInitModeUI.finish();
    AppMethodBeat.o(312497);
    return true;
  }
  
  private final void fNv()
  {
    AppMethodBeat.i(312488);
    if (!getFinishBt().isEnabled())
    {
      AppMethodBeat.o(312488);
      return;
    }
    Object localObject2;
    label55:
    Object localObject3;
    if (YE(a.f.safety_item))
    {
      localObject1 = this.JxD;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.JxE;
        if (localObject2 != null) {
          break label296;
        }
        localObject2 = null;
        if (!(localObject1 instanceof View)) {
          break label345;
        }
        localObject3 = (View)localObject1;
        label67:
        if (localObject3 != null) {
          ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_select_bg);
        }
        if (!(localObject2 instanceof View)) {
          break label350;
        }
        localObject3 = (View)localObject2;
        label90:
        if (localObject3 != null) {
          ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_unselect_bg);
        }
        if (!(localObject1 instanceof View)) {
          break label355;
        }
        localObject3 = (View)localObject1;
        label113:
        if (localObject3 != null)
        {
          localObject3 = (TextView)((View)localObject3).findViewById(a.f.title_tv);
          if (localObject3 != null) {
            ((TextView)localObject3).setTextColor(getResources().getColor(a.c.Brand));
          }
        }
        if (!(localObject1 instanceof View)) {
          break label360;
        }
        localObject1 = (View)localObject1;
        label158:
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(a.f.desc_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getResources().getColor(a.c.Brand));
          }
        }
        if (!(localObject2 instanceof View)) {
          break label365;
        }
        localObject1 = (View)localObject2;
        label203:
        if (localObject1 != null)
        {
          localObject1 = (TextView)((View)localObject1).findViewById(a.f.title_tv);
          if (localObject1 != null) {
            ((TextView)localObject1).setTextColor(getResources().getColor(a.c.normal_text_color));
          }
        }
        if (!(localObject2 instanceof View)) {
          break label370;
        }
      }
    }
    label296:
    label315:
    label337:
    label345:
    label350:
    label355:
    label360:
    label365:
    label370:
    for (Object localObject1 = (View)localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject1 = (TextView)((View)localObject1).findViewById(a.f.desc_tv);
        if (localObject1 != null) {
          ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
        }
      }
      AppMethodBeat.o(312488);
      return;
      localObject1 = ((RelativeLayout)localObject1).getParent();
      break;
      localObject2 = ((RelativeLayout)localObject2).getParent();
      break label55;
      localObject1 = this.JxE;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.JxD;
        if (localObject2 != null) {
          break label337;
        }
      }
      for (localObject2 = null;; localObject2 = ((RelativeLayout)localObject2).getParent())
      {
        break;
        localObject1 = ((RelativeLayout)localObject1).getParent();
        break label315;
      }
      localObject3 = null;
      break label67;
      localObject3 = null;
      break label90;
      localObject3 = null;
      break label113;
      localObject1 = null;
      break label158;
      localObject1 = null;
      break label203;
    }
  }
  
  private static final void fNw()
  {
    AppMethodBeat.i(312513);
    Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
    localIntent.putExtra("ime_load_contact", true);
    localIntent.putExtra("ime_mode_switch", true);
    c.n(localIntent, "hld");
    AppMethodBeat.o(312513);
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(312450);
    Object localObject = this.Jst.getValue();
    s.s(localObject, "<get-finishBt>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312450);
    return localObject;
  }
  
  public int getForceOrientation()
  {
    return 1;
  }
  
  public int getLayoutId()
  {
    return a.h.ime_collect_data_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(312586);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(new HldInitModeUI..ExternalSyntheticLambda0(this));
    Ys(a.f.safety_item);
    Ys(a.f.normal_item);
    getFinishBt().setOnClickListener((View.OnClickListener)this);
    Object localObject = this.JxA.getValue();
    s.s(localObject, "<get-finishLayout>(...)");
    ((FrameLayout)localObject).setOnClickListener((View.OnClickListener)this);
    localObject = l.JyV;
    switch (l.fOL())
    {
    default: 
      localObject = this.JxB;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      localObject = this.JxC;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      getFinishBt().setEnabled(false);
      getFinishBt().setClickable(false);
      fNv();
    }
    for (;;)
    {
      localObject = l.JyV;
      Log.i("WxIme.HldInitModeUI", s.X("init default mode:", Integer.valueOf(l.fOL())));
      AppMethodBeat.o(312586);
      return;
      localObject = this.JxB;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.JxC;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      fNv();
      continue;
      localObject = this.JxB;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      localObject = this.JxC;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      fNv();
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(312599);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.finish_container;
      if (paramView != null) {
        break label90;
      }
      label52:
      i = a.f.finish_bt;
      if (paramView != null) {
        break label144;
      }
    }
    label90:
    while (paramView.intValue() != i)
    {
      do
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(312599);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != i) {
          break label52;
        }
      } while (getFinishBt().isEnabled());
      aa.showTextToast((Context)getContext(), getString(a.j.contact_info_wxime_keyboard_mode_select_toast));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312599);
      return;
    }
    label144:
    boolean bool = YE(a.f.safety_item);
    paramView = (Context)this;
    getString(a.j.app_tip);
    this.JxF = com.tencent.mm.ui.base.k.a(paramView, getString(a.j.app_waiting), false, null);
    localObject = new ArrayList();
    if (bool) {}
    for (paramView = com.tencent.mm.plugin.hld.model.b.Jus;; paramView = com.tencent.mm.plugin.hld.model.b.Jur)
    {
      ((ArrayList)localObject).add(paramView);
      ((ArrayList)localObject).add(com.tencent.mm.plugin.hld.model.b.Jut);
      paramView = e.JoK;
      e.a.a((List)localObject, (f)this);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312571);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(312571);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void wP(boolean paramBoolean)
  {
    AppMethodBeat.i(312613);
    Log.i("WxIme.HldModeSettingUI", s.X("doOplogSyncCallback ", Boolean.valueOf(paramBoolean)));
    Log.i("WxIme.HldInitModeUI", s.X("doOplogSyncCallback ", Boolean.valueOf(paramBoolean)));
    Object localObject = this.JxF;
    if (localObject != null) {
      ((w)localObject).dismiss();
    }
    if (paramBoolean)
    {
      paramBoolean = YE(a.f.safety_item);
      localObject = com.tencent.mm.plugin.hld.model.k.JvH;
      int j = getContext().getIntent().getIntExtra("ime_enter_scene", 6);
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        com.tencent.mm.plugin.hld.model.k.aK(10, j, i);
        localObject = l.JyV;
        l.fOX();
        Log.i("WxIme.HldInitModeUI", s.X("set safetyMode:", Boolean.valueOf(paramBoolean)));
        localObject = com.tencent.mm.plugin.hld.f.i.JyA;
        com.tencent.mm.plugin.hld.f.i.xo(paramBoolean);
        h.ahAA.bm(HldInitModeUI..ExternalSyntheticLambda3.INSTANCE);
        setResult(-1, new Intent());
        finish();
        AppMethodBeat.o(312613);
        return;
      }
    }
    h.ahAA.bk(new HldInitModeUI..ExternalSyntheticLambda2(this));
    AppMethodBeat.o(312613);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(HldInitModeUI paramHldInitModeUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<FrameLayout>
  {
    c(HldInitModeUI paramHldInitModeUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldInitModeUI
 * JD-Core Version:    0.7.0.1
 */