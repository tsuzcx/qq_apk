package com.tencent.mm.plugin.hld.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.a;
import com.tencent.mm.plugin.hld.a.c;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.h;
import com.tencent.mm.plugin.hld.a.i;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.au;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "Landroid/view/View$OnClickListener;", "()V", "chooseSound", "", "chooseT9", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "soundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "soundBtn$delegate", "t26Bt", "Landroid/widget/RelativeLayout;", "getT26Bt", "()Landroid/widget/RelativeLayout;", "t26Bt$delegate", "t26SelectIv", "Landroid/widget/ImageView;", "getT26SelectIv", "()Landroid/widget/ImageView;", "t26SelectIv$delegate", "t26TitleTv", "Landroid/widget/TextView;", "getT26TitleTv", "()Landroid/widget/TextView;", "t26TitleTv$delegate", "t9Bt", "getT9Bt", "t9Bt$delegate", "t9SelectIv", "getT9SelectIv", "t9SelectIv$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "getLayoutId", "", "initView", "", "onCheck", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"})
public class HldInitKeyboardSettingUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final a DFU;
  private final f DFR;
  private final f DFS;
  private final f DFT;
  private final f DyB;
  private final f Dyy;
  private final f Dzq;
  private final f Dzr;
  private final f Dzs;
  private boolean Dzt;
  private boolean Dzw;
  
  static
  {
    AppMethodBeat.i(212861);
    DFU = new a((byte)0);
    AppMethodBeat.o(212861);
  }
  
  public HldInitKeyboardSettingUI()
  {
    AppMethodBeat.i(212860);
    this.Dzq = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dzr = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Dzs = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Dyy = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.DyB = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.DFR = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.DFS = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.DFT = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(212860);
  }
  
  private final ImageView eFA()
  {
    AppMethodBeat.i(212846);
    ImageView localImageView = (ImageView)this.DFS.getValue();
    AppMethodBeat.o(212846);
    return localImageView;
  }
  
  private final ImeCheckBox eFB()
  {
    AppMethodBeat.i(212848);
    ImeCheckBox localImeCheckBox = (ImeCheckBox)this.DFT.getValue();
    AppMethodBeat.o(212848);
    return localImeCheckBox;
  }
  
  private final ImageView eFz()
  {
    AppMethodBeat.i(212844);
    ImageView localImageView = (ImageView)this.DFR.getValue();
    AppMethodBeat.o(212844);
    return localImageView;
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(212835);
    Button localButton = (Button)this.Dzq.getValue();
    AppMethodBeat.o(212835);
    return localButton;
  }
  
  private final RelativeLayout getT26Bt()
  {
    AppMethodBeat.i(212838);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzs.getValue();
    AppMethodBeat.o(212838);
    return localRelativeLayout;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(212842);
    TextView localTextView = (TextView)this.DyB.getValue();
    AppMethodBeat.o(212842);
    return localTextView;
  }
  
  private final RelativeLayout getT9Bt()
  {
    AppMethodBeat.i(212836);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzr.getValue();
    AppMethodBeat.o(212836);
    return localRelativeLayout;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(212840);
    TextView localTextView = (TextView)this.Dyy.getValue();
    AppMethodBeat.o(212840);
    return localTextView;
  }
  
  public int getLayoutId()
  {
    return a.h.ime_choose_keyboard_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(212854);
    super.initView();
    if (getSupportActionBar() != null)
    {
      localObject1 = getSupportActionBar();
      if (localObject1 == null) {
        p.iCn();
      }
      ((ActionBar)localObject1).hide();
    }
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
    getFinishBt().setEnabled(false);
    getFinishBt().setClickable(false);
    Object localObject1 = eFB();
    Object localObject2 = getContext().getString(a.j.ime_setting_sound_switch);
    p.j(localObject2, "context.getString(R.stri…ime_setting_sound_switch)");
    ((ImeCheckBox)localObject1).setTitle((String)localObject2);
    eFB().setChecked(this.Dzw);
    eFB().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    localObject1 = i.DHq;
    i.te(this.Dzw);
    localObject1 = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getFinishBt(), (View.OnClickListener)this);
    localObject1 = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getT9Bt(), (View.OnClickListener)this);
    localObject1 = com.tencent.mm.plugin.hld.view.g.DIP;
    com.tencent.mm.plugin.hld.view.g.a((View)getT26Bt(), (View.OnClickListener)this);
    localObject1 = eFz();
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources().getDrawable(a.i.icons_filled_done2);
    Context localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(a.c.BW_70)));
    localObject1 = eFA();
    localObject2 = MMApplicationContext.getContext();
    p.j(localObject2, "MMApplicationContext.getContext()");
    localObject2 = ((Context)localObject2).getResources().getDrawable(a.i.icons_filled_done2);
    localContext = MMApplicationContext.getContext();
    p.j(localContext, "MMApplicationContext.getContext()");
    ((ImageView)localObject1).setImageDrawable(au.e((Drawable)localObject2, localContext.getResources().getColor(a.c.BW_70)));
    localObject1 = com.tencent.mm.plugin.hld.f.k.DHH;
    int i = (com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)this) - com.tencent.mm.ci.a.aZ((Context)this, a.d.Edge_5A)) / 2;
    localObject1 = getT9Bt().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = i;
    getT9Bt().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    getT9Bt().invalidate();
    localObject1 = getT26Bt().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject1).width = i;
    getT26Bt().setLayoutParams((ViewGroup.LayoutParams)localObject1);
    getT26Bt().invalidate();
    AppMethodBeat.o(212854);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(212859);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.finish_bt;
      if (paramView != null) {
        break label103;
      }
      label59:
      i = a.f.t9_rv;
      if (paramView != null) {
        break label278;
      }
      label67:
      i = a.f.t26_rv;
      if (paramView != null) {
        break label473;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(212859);
      return;
      paramView = null;
      break;
      label103:
      if (paramView.intValue() != i) {
        break label59;
      }
      paramView = com.tencent.mm.plugin.hld.model.k.DDb;
      if (this.Dzt)
      {
        i = 1;
        label124:
        com.tencent.mm.plugin.hld.model.k.ap(i, 3, 1);
        paramView = com.tencent.mm.plugin.hld.model.k.DDb;
        if (!this.Dzw) {
          break label259;
        }
        i = 4;
        label143:
        com.tencent.mm.plugin.hld.model.k.ap(i, 3, 1);
        localObject = new ArrayList();
        if (!getT9Bt().isSelected()) {
          break label264;
        }
        paramView = com.tencent.mm.plugin.hld.model.b.DBm;
        label171:
        ((ArrayList)localObject).add(paramView);
        if (!eFB().getSwitchBtn().isCheck()) {
          break label271;
        }
      }
      label259:
      label264:
      label271:
      for (paramView = com.tencent.mm.plugin.hld.model.b.DBo;; paramView = com.tencent.mm.plugin.hld.model.b.DBp)
      {
        ((ArrayList)localObject).add(paramView);
        ((ArrayList)localObject).add(com.tencent.mm.plugin.hld.model.b.DBv);
        paramView = e.Dvq;
        e.a.fB((List)localObject);
        paramView = com.tencent.mm.plugin.hld.model.k.DDb;
        com.tencent.mm.plugin.hld.model.k.UB(7);
        paramView = com.tencent.mm.plugin.hld.f.l.DHK;
        com.tencent.mm.plugin.hld.f.l.eHr();
        setResult(-1, new Intent());
        finish();
        break;
        i = 2;
        break label124;
        i = 5;
        break label143;
        paramView = com.tencent.mm.plugin.hld.model.b.DBn;
        break label171;
      }
      label278:
      if (paramView.intValue() != i) {
        break label67;
      }
      getT9Bt().setSelected(true);
      getT26Bt().setSelected(false);
      getT9TitleTv().setSelected(true);
      getT26TitleTv().setSelected(false);
      paramView = eFz();
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(a.i.icons_filled_done2);
      Context localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      paramView.setImageDrawable(au.e((Drawable)localObject, localContext.getResources().getColor(a.c.Brand)));
      paramView = eFA();
      localObject = MMApplicationContext.getContext();
      p.j(localObject, "MMApplicationContext.getContext()");
      localObject = ((Context)localObject).getResources().getDrawable(a.i.icons_filled_done2);
      localContext = MMApplicationContext.getContext();
      p.j(localContext, "MMApplicationContext.getContext()");
      paramView.setImageDrawable(au.e((Drawable)localObject, localContext.getResources().getColor(a.c.BW_70)));
      paramView = i.DHq;
      i.UJ(c.Dyl.ordinal());
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      this.Dzt = true;
      continue;
      label473:
      if (paramView.intValue() == i)
      {
        getT9Bt().setSelected(false);
        getT26Bt().setSelected(true);
        getT9TitleTv().setSelected(false);
        getT26TitleTv().setSelected(true);
        paramView = eFz();
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getDrawable(a.i.icons_filled_done2);
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        paramView.setImageDrawable(au.e((Drawable)localObject, localContext.getResources().getColor(a.c.BW_70)));
        paramView = eFA();
        localObject = MMApplicationContext.getContext();
        p.j(localObject, "MMApplicationContext.getContext()");
        localObject = ((Context)localObject).getResources().getDrawable(a.i.icons_filled_done2);
        localContext = MMApplicationContext.getContext();
        p.j(localContext, "MMApplicationContext.getContext()");
        paramView.setImageDrawable(au.e((Drawable)localObject, localContext.getResources().getColor(a.c.Brand)));
        paramView = i.DHq;
        i.UJ(c.Dym.ordinal());
        getFinishBt().setEnabled(true);
        getFinishBt().setClickable(true);
        this.Dzt = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(212851);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    paramBundle = com.tencent.mm.plugin.hld.model.k.DDb;
    com.tencent.mm.plugin.hld.model.k.ap(0, 3, 1);
    AppMethodBeat.o(212851);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(212856);
    p.k(paramView, "v");
    if (((paramView instanceof ImeCheckBox)) && (((ImeCheckBox)paramView).getId() == a.f.sound_bt))
    {
      this.Dzw = paramBoolean;
      paramView = i.DHq;
      i.te(paramBoolean);
    }
    AppMethodBeat.o(212856);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Button>
  {
    b(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(213584);
      this.DFV.finish();
      AppMethodBeat.o(213584);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImeCheckBox>
  {
    d(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<TextView>
  {
    g(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    h(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<TextView>
  {
    j(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldInitKeyboardSettingUI
 * JD-Core Version:    0.7.0.1
 */