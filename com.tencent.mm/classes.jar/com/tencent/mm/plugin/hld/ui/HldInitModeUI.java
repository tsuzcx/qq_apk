package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
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
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import java.util.ArrayList;
import java.util.List;
import kotlin.g;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldInitModeUI;", "Lcom/tencent/mm/ui/MMActivity;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "()V", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "finishLayout", "Landroid/widget/FrameLayout;", "getFinishLayout", "()Landroid/widget/FrameLayout;", "finishLayout$delegate", "normalSelectIv", "Landroid/widget/ImageView;", "normalTitle", "Landroid/widget/RelativeLayout;", "safetySelectIv", "safetyTitle", "settingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "doOplogSyncCallback", "", "success", "", "getForceOrientation", "", "getLayoutId", "handleInitMode", "safetyMode", "initView", "isSelect", "id", "onClick", "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateChildrenView", "updateStyle", "Companion", "plugin-hld_release"})
public class HldInitModeUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.hld.b.f
{
  public static final a DGc;
  private final kotlin.f DFW;
  private ImageView DFX;
  private ImageView DFY;
  private RelativeLayout DFZ;
  private RelativeLayout DGa;
  private s DGb;
  private final kotlin.f Dzq;
  
  static
  {
    AppMethodBeat.i(215609);
    DGc = new a((byte)0);
    AppMethodBeat.o(215609);
  }
  
  public HldInitModeUI()
  {
    AppMethodBeat.i(215608);
    this.Dzq = g.ar((kotlin.g.a.a)new d(this));
    this.DFW = g.ar((kotlin.g.a.a)new e(this));
    AppMethodBeat.o(215608);
  }
  
  private final boolean UG(int paramInt)
  {
    AppMethodBeat.i(215602);
    ImageView localImageView = (ImageView)((LinearLayout)findViewById(paramInt)).findViewById(a.f.state_icon);
    p.j(localImageView, "selectIv");
    if (localImageView.getVisibility() == 0)
    {
      AppMethodBeat.o(215602);
      return true;
    }
    AppMethodBeat.o(215602);
    return false;
  }
  
  private final void Uv(final int paramInt)
  {
    AppMethodBeat.i(215603);
    LinearLayout localLinearLayout = (LinearLayout)findViewById(paramInt);
    p.j(localLinearLayout, "view");
    localLinearLayout.setVisibility(0);
    Object localObject = (RelativeLayout)localLinearLayout.findViewById(a.f.title_ll);
    ImageView localImageView = (ImageView)localLinearLayout.findViewById(a.f.state_icon);
    TextView localTextView1 = (TextView)localLinearLayout.findViewById(a.f.title_tv);
    TextView localTextView2 = (TextView)localLinearLayout.findViewById(a.f.desc_tv);
    p.j(localImageView, "selectIv");
    localImageView.setTag(Integer.valueOf(paramInt));
    if (paramInt == a.f.safety_item)
    {
      this.DFX = localImageView;
      this.DFZ = ((RelativeLayout)localObject);
      p.j(localTextView1, "titleTv");
      localTextView1.setText((CharSequence)getString(a.j.ime_mode_safety_name));
      p.j(localTextView2, "descTv");
      localTextView2.setText((CharSequence)getString(a.j.ime_mode_safety_desc));
      localObject = this.DFX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
    }
    for (;;)
    {
      localLinearLayout.setOnClickListener((View.OnClickListener)new g(this, paramInt));
      AppMethodBeat.o(215603);
      return;
      if (paramInt == a.f.normal_item)
      {
        this.DFY = localImageView;
        this.DGa = ((RelativeLayout)localObject);
        p.j(localTextView1, "titleTv");
        localTextView1.setText((CharSequence)getString(a.j.ime_mode_normal_name));
        p.j(localTextView2, "descTv");
        localTextView2.setText((CharSequence)getString(a.j.ime_mode_normal_desc));
        localObject = this.DFY;
        if (localObject != null) {
          ((ImageView)localObject).setVisibility(4);
        }
      }
    }
  }
  
  private final void eFC()
  {
    AppMethodBeat.i(215604);
    if (!getFinishBt().isEnabled())
    {
      AppMethodBeat.o(215604);
      return;
    }
    Object localObject1;
    Object localObject2;
    if (UG(a.f.safety_item))
    {
      localObject1 = this.DFZ;
      if (localObject1 != null)
      {
        localObject1 = ((RelativeLayout)localObject1).getParent();
        localObject2 = this.DGa;
        if (localObject2 == null) {
          break label312;
        }
        localObject3 = ((RelativeLayout)localObject2).getParent();
        label59:
        localObject2 = localObject1;
        localObject1 = localObject3;
        if ((localObject2 instanceof View)) {
          break label391;
        }
      }
    }
    label391:
    for (Object localObject3 = null;; localObject3 = localObject2)
    {
      localObject3 = (View)localObject3;
      if (localObject3 != null) {
        ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_select_bg);
      }
      if (!(localObject1 instanceof View)) {}
      for (localObject3 = null;; localObject3 = localObject1)
      {
        localObject3 = (View)localObject3;
        if (localObject3 != null) {
          ((View)localObject3).setBackgroundResource(a.e.ime_collect_data_item_unselect_bg);
        }
        if (!(localObject2 instanceof View)) {}
        for (localObject3 = null;; localObject3 = localObject2)
        {
          localObject3 = (View)localObject3;
          if (localObject3 != null)
          {
            localObject3 = (TextView)((View)localObject3).findViewById(a.f.title_tv);
            if (localObject3 != null) {
              ((TextView)localObject3).setTextColor(getResources().getColor(a.c.Brand));
            }
          }
          if (!(localObject2 instanceof View)) {
            localObject2 = null;
          }
          for (;;)
          {
            localObject2 = (View)localObject2;
            if (localObject2 != null)
            {
              localObject2 = (TextView)((View)localObject2).findViewById(a.f.desc_tv);
              if (localObject2 != null) {
                ((TextView)localObject2).setTextColor(getResources().getColor(a.c.Brand));
              }
            }
            if (!(localObject1 instanceof View)) {}
            for (localObject2 = null;; localObject2 = localObject1)
            {
              localObject2 = (View)localObject2;
              if (localObject2 != null)
              {
                localObject2 = (TextView)((View)localObject2).findViewById(a.f.title_tv);
                if (localObject2 != null) {
                  ((TextView)localObject2).setTextColor(getResources().getColor(a.c.normal_text_color));
                }
              }
              if (!(localObject1 instanceof View)) {
                localObject1 = null;
              }
              for (;;)
              {
                localObject1 = (View)localObject1;
                if (localObject1 != null)
                {
                  localObject1 = (TextView)((View)localObject1).findViewById(a.f.desc_tv);
                  if (localObject1 != null)
                  {
                    ((TextView)localObject1).setTextColor(getResources().getColor(a.c.hint_text_color));
                    AppMethodBeat.o(215604);
                    return;
                    localObject1 = null;
                    break;
                    label312:
                    localObject3 = null;
                    break label59;
                    localObject1 = this.DGa;
                    if (localObject1 != null)
                    {
                      localObject1 = ((RelativeLayout)localObject1).getParent();
                      label331:
                      localObject2 = this.DFZ;
                      if (localObject2 == null) {
                        break label359;
                      }
                    }
                    label359:
                    for (localObject2 = ((RelativeLayout)localObject2).getParent();; localObject2 = null)
                    {
                      localObject3 = localObject1;
                      localObject1 = localObject2;
                      localObject2 = localObject3;
                      break;
                      localObject1 = null;
                      break label331;
                    }
                  }
                }
                AppMethodBeat.o(215604);
                return;
              }
            }
          }
        }
      }
    }
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(215592);
    Button localButton = (Button)this.Dzq.getValue();
    AppMethodBeat.o(215592);
    return localButton;
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
    AppMethodBeat.i(215598);
    super.initView();
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    Uv(a.f.safety_item);
    Uv(a.f.normal_item);
    getFinishBt().setOnClickListener((View.OnClickListener)this);
    ((FrameLayout)this.DFW.getValue()).setOnClickListener((View.OnClickListener)this);
    Object localObject = com.tencent.mm.plugin.hld.f.l.DHK;
    switch (com.tencent.mm.plugin.hld.f.l.eHc())
    {
    default: 
      localObject = this.DFX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      localObject = this.DFY;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      getFinishBt().setEnabled(false);
      getFinishBt().setClickable(false);
      eFC();
    }
    for (;;)
    {
      localObject = new StringBuilder("init default mode:");
      com.tencent.mm.plugin.hld.f.l locall = com.tencent.mm.plugin.hld.f.l.DHK;
      Log.i("WxIme.HldInitModeUI", com.tencent.mm.plugin.hld.f.l.eHc());
      AppMethodBeat.o(215598);
      return;
      localObject = this.DFX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      localObject = this.DFY;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      eFC();
      continue;
      localObject = this.DFX;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(4);
      }
      localObject = this.DFY;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(0);
      }
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      eFC();
    }
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(215600);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.finish_container;
      if (paramView != null) {
        break label98;
      }
      label62:
      i = a.f.finish_bt;
      if (paramView != null) {
        break label156;
      }
    }
    label98:
    while (paramView.intValue() != i)
    {
      do
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(215600);
        return;
        paramView = null;
        break;
        if (paramView.intValue() != i) {
          break label62;
        }
      } while (getFinishBt().isEnabled());
      w.cP((Context)getContext(), getString(a.j.contact_info_wxime_keyboard_mode_select_toast));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(215600);
      return;
    }
    label156:
    boolean bool = UG(a.f.safety_item);
    paramView = (Context)this;
    getString(a.j.app_tip);
    this.DGb = com.tencent.mm.ui.base.h.a(paramView, getString(a.j.app_waiting), false, null);
    localObject = new ArrayList();
    if (bool) {}
    for (paramView = com.tencent.mm.plugin.hld.model.b.DBt;; paramView = com.tencent.mm.plugin.hld.model.b.DBs)
    {
      ((ArrayList)localObject).add(paramView);
      ((ArrayList)localObject).add(com.tencent.mm.plugin.hld.model.b.DBu);
      paramView = e.Dvq;
      e.a.a((List)localObject, (com.tencent.mm.plugin.hld.b.f)this);
      break;
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(215595);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    AppMethodBeat.o(215595);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(215607);
    Log.i("WxIme.HldModeSettingUI", "doOplogSyncCallback ".concat(String.valueOf(paramBoolean)));
    Log.i("WxIme.HldInitModeUI", "doOplogSyncCallback ".concat(String.valueOf(paramBoolean)));
    Object localObject = this.DGb;
    if (localObject != null) {
      ((s)localObject).dismiss();
    }
    if (paramBoolean)
    {
      paramBoolean = UG(a.f.safety_item);
      localObject = k.DDb;
      localObject = getContext();
      p.j(localObject, "context");
      int j = ((AppCompatActivity)localObject).getIntent().getIntExtra("ime_enter_scene", 6);
      if (paramBoolean) {}
      for (int i = 2;; i = 1)
      {
        k.ao(10, j, i);
        localObject = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHo();
        Log.i("WxIme.HldInitModeUI", "set safetyMode:".concat(String.valueOf(paramBoolean)));
        localObject = com.tencent.mm.plugin.hld.f.i.DHq;
        com.tencent.mm.plugin.hld.f.i.td(paramBoolean);
        com.tencent.e.h.ZvG.be((Runnable)b.DGd);
        setResult(-1, new Intent());
        finish();
        AppMethodBeat.o(215607);
        return;
      }
    }
    com.tencent.e.h.ZvG.bc((Runnable)new c(this));
    AppMethodBeat.o(215607);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldInitModeUI$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    public static final b DGd;
    
    static
    {
      AppMethodBeat.i(217899);
      DGd = new b();
      AppMethodBeat.o(217899);
    }
    
    public final void run()
    {
      AppMethodBeat.i(217897);
      Intent localIntent = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      localIntent.putExtra("ime_load_contact", true);
      localIntent.putExtra("ime_mode_switch", true);
      c.l(localIntent, "hld");
      AppMethodBeat.o(217897);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(HldInitModeUI paramHldInitModeUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(217147);
      w.makeText((Context)this.DGe, (CharSequence)this.DGe.getString(a.j.ime_mode_setting_fail), 0).show();
      AppMethodBeat.o(217147);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<Button>
  {
    d(HldInitModeUI paramHldInitModeUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/FrameLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<FrameLayout>
  {
    e(HldInitModeUI paramHldInitModeUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(HldInitModeUI paramHldInitModeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213855);
      this.DGe.finish();
      AppMethodBeat.o(213855);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(HldInitModeUI paramHldInitModeUI, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(217121);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitModeUI$updateChildrenView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      int i = paramInt;
      if (i == a.f.safety_item)
      {
        paramView = HldInitModeUI.a(this.DGe);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = HldInitModeUI.b(this.DGe);
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        HldInitModeUI.c(this.DGe).setEnabled(true);
        HldInitModeUI.c(this.DGe).setClickable(true);
        HldInitModeUI.d(this.DGe);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitModeUI$updateChildrenView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(217121);
        return;
        if (i == a.f.normal_item)
        {
          paramView = HldInitModeUI.a(this.DGe);
          if (paramView != null) {
            paramView.setVisibility(4);
          }
          paramView = HldInitModeUI.b(this.DGe);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          HldInitModeUI.c(this.DGe).setEnabled(true);
          HldInitModeUI.c(this.DGe).setClickable(true);
          HldInitModeUI.d(this.DGe);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldInitModeUI
 * JD-Core Version:    0.7.0.1
 */