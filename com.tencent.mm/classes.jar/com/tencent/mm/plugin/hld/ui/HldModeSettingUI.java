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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.by.c;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.e;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.a.m;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.b.f;
import com.tencent.mm.plugin.hld.model.WxImeInterService;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.model.k.q;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.w.b;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldModeSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/hld/cgi/ImeOplogSyncCallback;", "()V", "currentMode", "", "normalSelectIv", "Landroid/widget/ImageView;", "normalTitle", "Landroid/widget/RelativeLayout;", "oriMode", "safetySelectIv", "safetyTitle", "settingDialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "doOplogSyncCallback", "", "success", "getForceOrientation", "", "getLayoutId", "initView", "isSelect", "id", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "updateChildrenView", "updateStyle", "isSafeMode", "Companion", "plugin-hld_release"})
public final class HldModeSettingUI
  extends MMActivity
  implements f
{
  public static final a DGn;
  private ImageView DFX;
  private ImageView DFY;
  private RelativeLayout DFZ;
  private RelativeLayout DGa;
  private s DGb;
  private boolean DGl;
  private boolean DGm;
  
  static
  {
    AppMethodBeat.i(211512);
    DGn = new a((byte)0);
    AppMethodBeat.o(211512);
  }
  
  public HldModeSettingUI()
  {
    AppMethodBeat.i(211510);
    com.tencent.mm.plugin.hld.f.i locali = com.tencent.mm.plugin.hld.f.i.DHq;
    this.DGl = com.tencent.mm.plugin.hld.f.i.eGC();
    locali = com.tencent.mm.plugin.hld.f.i.DHq;
    this.DGm = com.tencent.mm.plugin.hld.f.i.eGC();
    AppMethodBeat.o(211510);
  }
  
  private final void Uv(final int paramInt)
  {
    int i = 4;
    AppMethodBeat.i(211498);
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
      if (localObject != null)
      {
        if (!this.DGm) {
          break label202;
        }
        i = 0;
        ((ImageView)localObject).setVisibility(i);
      }
    }
    label202:
    do
    {
      do
      {
        localLinearLayout.setOnClickListener((View.OnClickListener)new f(this, paramInt));
        AppMethodBeat.o(211498);
        return;
        i = 4;
        break;
      } while (paramInt != a.f.normal_item);
      this.DFY = localImageView;
      this.DGa = ((RelativeLayout)localObject);
      p.j(localTextView1, "titleTv");
      localTextView1.setText((CharSequence)getString(a.j.ime_mode_normal_name));
      p.j(localTextView2, "descTv");
      localTextView2.setText((CharSequence)getString(a.j.ime_mode_normal_desc));
      localObject = this.DFY;
    } while (localObject == null);
    if (this.DGm) {}
    for (;;)
    {
      ((ImageView)localObject).setVisibility(i);
      break;
      i = 0;
    }
  }
  
  private final void sV(boolean paramBoolean)
  {
    AppMethodBeat.i(211501);
    Object localObject1;
    Object localObject2;
    if (paramBoolean)
    {
      localObject1 = this.DFZ;
      if (localObject1 != null)
      {
        localObject1 = ((RelativeLayout)localObject1).getParent();
        localObject2 = this.DGa;
        if (localObject2 == null) {
          break label310;
        }
        localObject3 = ((RelativeLayout)localObject2).getParent();
        label38:
        localObject2 = localObject1;
        localObject1 = localObject3;
        if ((localObject2 instanceof View)) {
          break label394;
        }
      }
    }
    label394:
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
                    AppMethodBeat.o(211501);
                    return;
                    localObject1 = null;
                    break;
                    label310:
                    localObject3 = null;
                    break label38;
                    localObject1 = this.DGa;
                    if (localObject1 != null)
                    {
                      localObject1 = ((RelativeLayout)localObject1).getParent();
                      label330:
                      localObject2 = this.DFZ;
                      if (localObject2 == null) {
                        break label360;
                      }
                    }
                    label360:
                    for (localObject2 = ((RelativeLayout)localObject2).getParent();; localObject2 = null)
                    {
                      localObject3 = localObject1;
                      localObject1 = localObject2;
                      localObject2 = localObject3;
                      break;
                      localObject1 = null;
                      break label330;
                    }
                  }
                }
                AppMethodBeat.o(211501);
                return;
              }
            }
          }
        }
      }
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
    AppMethodBeat.i(211497);
    setMMTitle("");
    hideActionbarLine();
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    addTextOptionMenu(0, getString(a.j.app_finish), (MenuItem.OnMenuItemClickListener)new e(this), null, w.b.Wao);
    Uv(a.f.safety_item);
    Uv(a.f.normal_item);
    sV(this.DGm);
    AppMethodBeat.o(211497);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(211495);
    k localk = k.DDb;
    long l = System.currentTimeMillis();
    if (!k.eEz()) {
      com.tencent.e.h.ZvG.d((Runnable)new k.q(l), "WxIme.ImeReporter");
    }
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(211495);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void sJ(boolean paramBoolean)
  {
    AppMethodBeat.i(211505);
    Log.i("WxIme.HldModeSettingUI", "doOplogSyncCallback ".concat(String.valueOf(paramBoolean)));
    Object localObject = this.DGb;
    if (localObject != null) {
      ((s)localObject).dismiss();
    }
    if (paramBoolean)
    {
      localObject = com.tencent.mm.plugin.hld.f.i.DHq;
      com.tencent.mm.plugin.hld.f.i.td(this.DGl);
      com.tencent.e.h.ZvG.be((Runnable)new b(this));
      finish();
      AppMethodBeat.o(211505);
      return;
    }
    com.tencent.e.h.ZvG.bc((Runnable)new c(this));
    AppMethodBeat.o(211505);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldModeSettingUI$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class b
    implements Runnable
  {
    b(HldModeSettingUI paramHldModeSettingUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(213542);
      Object localObject = new Intent(MMApplicationContext.getContext(), WxImeInterService.class);
      ((Intent)localObject).putExtra("ime_load_contact", true);
      ((Intent)localObject).putExtra("ime_mode_switch", true);
      c.l((Intent)localObject, "hld");
      if (HldModeSettingUI.a(this.DGo))
      {
        localObject = com.tencent.mm.plugin.hld.c.a.DvH;
        com.tencent.mm.plugin.hld.c.a.sK(true);
        AppMethodBeat.o(213542);
        return;
      }
      localObject = com.tencent.mm.plugin.hld.c.a.DvH;
      com.tencent.mm.plugin.hld.c.a.sK(false);
      AppMethodBeat.o(213542);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class c
    implements Runnable
  {
    c(HldModeSettingUI paramHldModeSettingUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(209843);
      w.makeText((Context)this.DGo, (CharSequence)this.DGo.getString(a.j.ime_mode_setting_fail), 0).show();
      AppMethodBeat.o(209843);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(HldModeSettingUI paramHldModeSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(215141);
      this.DGo.finish();
      AppMethodBeat.o(215141);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class e
    implements MenuItem.OnMenuItemClickListener
  {
    e(HldModeSettingUI paramHldModeSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(209840);
      Log.i("WxIme.HldModeSettingUI", "current mode is safety(" + HldModeSettingUI.a(this.DGo) + "), oriMode:" + HldModeSettingUI.b(this.DGo));
      if (HldModeSettingUI.b(this.DGo) != HldModeSettingUI.a(this.DGo))
      {
        paramMenuItem = this.DGo;
        Context localContext = (Context)this.DGo;
        this.DGo.getString(a.j.app_tip);
        HldModeSettingUI.a(paramMenuItem, com.tencent.mm.ui.base.h.a(localContext, this.DGo.getString(a.j.app_waiting), false, null));
        paramMenuItem = e.Dvq;
        if (HldModeSettingUI.b(this.DGo))
        {
          paramMenuItem = com.tencent.mm.plugin.hld.model.b.DBs;
          e.a.a(paramMenuItem, 0L, (f)this.DGo, 2);
        }
      }
      for (;;)
      {
        AppMethodBeat.o(209840);
        return true;
        paramMenuItem = com.tencent.mm.plugin.hld.model.b.DBt;
        break;
        this.DGo.finish();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(HldModeSettingUI paramHldModeSettingUI, int paramInt) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(213880);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldModeSettingUI$updateChildrenView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      int i = paramInt;
      if (i == a.f.safety_item)
      {
        paramView = HldModeSettingUI.c(this.DGo);
        if (paramView != null) {
          paramView.setVisibility(0);
        }
        paramView = HldModeSettingUI.d(this.DGo);
        if (paramView != null) {
          paramView.setVisibility(4);
        }
        HldModeSettingUI.a(this.DGo, true);
        HldModeSettingUI.b(this.DGo, true);
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldModeSettingUI$updateChildrenView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(213880);
        return;
        if (i == a.f.normal_item)
        {
          paramView = HldModeSettingUI.c(this.DGo);
          if (paramView != null) {
            paramView.setVisibility(4);
          }
          paramView = HldModeSettingUI.d(this.DGo);
          if (paramView != null) {
            paramView.setVisibility(0);
          }
          HldModeSettingUI.a(this.DGo, false);
          HldModeSettingUI.b(this.DGo, false);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldModeSettingUI
 * JD-Core Version:    0.7.0.1
 */