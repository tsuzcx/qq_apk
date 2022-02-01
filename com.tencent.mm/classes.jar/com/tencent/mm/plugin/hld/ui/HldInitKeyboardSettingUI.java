package com.tencent.mm.plugin.hld.ui;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.keyboard.c;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.plugin.hld.view.f;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bb;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI;", "Lcom/tencent/mm/ui/MMActivity;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "Landroid/view/View$OnClickListener;", "()V", "chooseSound", "", "chooseT9", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "soundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "soundBtn$delegate", "t26Bt", "Landroid/widget/RelativeLayout;", "getT26Bt", "()Landroid/widget/RelativeLayout;", "t26Bt$delegate", "t26SelectIv", "Landroid/widget/ImageView;", "getT26SelectIv", "()Landroid/widget/ImageView;", "t26SelectIv$delegate", "t26TitleTv", "Landroid/widget/TextView;", "getT26TitleTv", "()Landroid/widget/TextView;", "t26TitleTv$delegate", "t9Bt", "getT9Bt", "t9Bt$delegate", "t9SelectIv", "getT9SelectIv", "t9SelectIv$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "getLayoutId", "", "initView", "", "onCheck", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public class HldInitKeyboardSettingUI
  extends MMActivity
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final HldInitKeyboardSettingUI.a Jxu;
  private final j JrD;
  private final j JrG;
  private final j Jst;
  private final j Jsu;
  private final j Jsv;
  private boolean Jsw;
  private boolean Jsz;
  private final j Jxv;
  private final j Jxw;
  private final j Jxx;
  
  static
  {
    AppMethodBeat.i(312440);
    Jxu = new HldInitKeyboardSettingUI.a((byte)0);
    AppMethodBeat.o(312440);
  }
  
  public HldInitKeyboardSettingUI()
  {
    AppMethodBeat.i(312365);
    this.Jst = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jsu = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.Jsv = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.JrD = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.JrG = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.Jxv = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.Jxw = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Jxx = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(312365);
  }
  
  private static final boolean a(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(312433);
    s.u(paramHldInitKeyboardSettingUI, "this$0");
    paramHldInitKeyboardSettingUI.finish();
    AppMethodBeat.o(312433);
    return true;
  }
  
  private final ImageView fNs()
  {
    AppMethodBeat.i(312411);
    Object localObject = this.Jxv.getValue();
    s.s(localObject, "<get-t9SelectIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312411);
    return localObject;
  }
  
  private final ImageView fNt()
  {
    AppMethodBeat.i(312418);
    Object localObject = this.Jxw.getValue();
    s.s(localObject, "<get-t26SelectIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312418);
    return localObject;
  }
  
  private final ImeCheckBox fNu()
  {
    AppMethodBeat.i(312425);
    Object localObject = this.Jxx.getValue();
    s.s(localObject, "<get-soundBtn>(...)");
    localObject = (ImeCheckBox)localObject;
    AppMethodBeat.o(312425);
    return localObject;
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(312373);
    Object localObject = this.Jst.getValue();
    s.s(localObject, "<get-finishBt>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312373);
    return localObject;
  }
  
  private final RelativeLayout getT26Bt()
  {
    AppMethodBeat.i(312387);
    Object localObject = this.Jsv.getValue();
    s.s(localObject, "<get-t26Bt>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312387);
    return localObject;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(312397);
    Object localObject = this.JrG.getValue();
    s.s(localObject, "<get-t26TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312397);
    return localObject;
  }
  
  private final RelativeLayout getT9Bt()
  {
    AppMethodBeat.i(312380);
    Object localObject = this.Jsu.getValue();
    s.s(localObject, "<get-t9Bt>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312380);
    return localObject;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(312393);
    Object localObject = this.JrD.getValue();
    s.s(localObject, "<get-t9TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312393);
    return localObject;
  }
  
  public int getLayoutId()
  {
    return a.h.ime_choose_keyboard_ui;
  }
  
  public void initView()
  {
    AppMethodBeat.i(312484);
    super.initView();
    if (getSupportActionBar() != null)
    {
      localObject = getSupportActionBar();
      s.checkNotNull(localObject);
      ((ActionBar)localObject).hide();
    }
    setActionbarColor(getResources().getColor(a.c.white));
    setBackGroundColorResource(a.c.white);
    setBackBtn(new HldInitKeyboardSettingUI..ExternalSyntheticLambda0(this));
    getFinishBt().setEnabled(false);
    getFinishBt().setClickable(false);
    Object localObject = fNu();
    String str = getContext().getString(a.j.ime_setting_sound_switch);
    s.s(str, "context.getString(R.stri…ime_setting_sound_switch)");
    ((ImeCheckBox)localObject).setTitle(str);
    fNu().setChecked(this.Jsz);
    fNu().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    localObject = i.JyA;
    i.xp(this.Jsz);
    f.JzR.a((View)getFinishBt(), (View.OnClickListener)this);
    f.JzR.a((View)getT9Bt(), (View.OnClickListener)this);
    f.JzR.a((View)getT26Bt(), (View.OnClickListener)this);
    fNs().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.BW_70)));
    fNt().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.BW_70)));
    localObject = com.tencent.mm.plugin.hld.f.k.JyF;
    int i = (com.tencent.mm.plugin.hld.f.k.getScreenWidth((Context)this) - com.tencent.mm.cd.a.bs((Context)this, a.d.Edge_5A)) / 2;
    localObject = getT9Bt().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = i;
    getT9Bt().setLayoutParams((ViewGroup.LayoutParams)localObject);
    getT9Bt().invalidate();
    localObject = getT26Bt().getLayoutParams();
    ((ViewGroup.LayoutParams)localObject).width = i;
    getT26Bt().setLayoutParams((ViewGroup.LayoutParams)localObject);
    getT26Bt().invalidate();
    AppMethodBeat.o(312484);
  }
  
  public void onClick(View paramView)
  {
    AppMethodBeat.i(312510);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.finish_bt;
      if (paramView != null) {
        break label103;
      }
      label53:
      i = a.f.t9_rv;
      if (paramView != null) {
        break label278;
      }
      label61:
      i = a.f.t26_rv;
      if (paramView != null) {
        break label423;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/ui/HldInitKeyboardSettingUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312510);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label103:
      if (paramView.intValue() != i) {
        break label53;
      }
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      if (this.Jsw)
      {
        i = 1;
        label124:
        com.tencent.mm.plugin.hld.model.k.aL(i, 3, 1);
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        if (!this.Jsz) {
          break label259;
        }
        i = 4;
        label143:
        com.tencent.mm.plugin.hld.model.k.aL(i, 3, 1);
        localObject = new ArrayList();
        if (!getT9Bt().isSelected()) {
          break label264;
        }
        paramView = com.tencent.mm.plugin.hld.model.b.Jul;
        label171:
        ((ArrayList)localObject).add(paramView);
        if (!fNu().getSwitchBtn().afTT) {
          break label271;
        }
      }
      label259:
      label264:
      label271:
      for (paramView = com.tencent.mm.plugin.hld.model.b.Jun;; paramView = com.tencent.mm.plugin.hld.model.b.Juo)
      {
        ((ArrayList)localObject).add(paramView);
        ((ArrayList)localObject).add(com.tencent.mm.plugin.hld.model.b.Juu);
        paramView = e.JoK;
        e.a.iy((List)localObject);
        paramView = com.tencent.mm.plugin.hld.model.k.JvH;
        com.tencent.mm.plugin.hld.model.k.Yy(7);
        paramView = l.JyV;
        l.fPa();
        setResult(-1, new Intent());
        finish();
        break;
        i = 2;
        break label124;
        i = 5;
        break label143;
        paramView = com.tencent.mm.plugin.hld.model.b.Jum;
        break label171;
      }
      label278:
      if (paramView.intValue() != i) {
        break label61;
      }
      getT9Bt().setSelected(true);
      getT26Bt().setSelected(false);
      getT9TitleTv().setSelected(true);
      getT26TitleTv().setSelected(false);
      fNs().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.Brand)));
      fNt().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.BW_70)));
      paramView = i.JyA;
      i.YH(c.Jrp.ordinal());
      getFinishBt().setEnabled(true);
      getFinishBt().setClickable(true);
      this.Jsw = true;
      continue;
      label423:
      if (paramView.intValue() == i)
      {
        getT9Bt().setSelected(false);
        getT26Bt().setSelected(true);
        getT9TitleTv().setSelected(false);
        getT26TitleTv().setSelected(true);
        fNs().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.BW_70)));
        fNt().setImageDrawable(bb.e(MMApplicationContext.getContext().getResources().getDrawable(a.i.icons_filled_done2), MMApplicationContext.getContext().getResources().getColor(a.c.Brand)));
        paramView = i.JyA;
        i.YH(c.Jrq.ordinal());
        getFinishBt().setEnabled(true);
        getFinishBt().setClickable(true);
        this.Jsw = false;
      }
    }
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(312467);
    super.onCreate(paramBundle);
    initView();
    overridePendingTransition(a.a.slide_right_in, a.a.slide_left_out);
    paramBundle = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.aL(0, 3, 1);
    AppMethodBeat.o(312467);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(312493);
    s.u(paramView, "v");
    if (((paramView instanceof ImeCheckBox)) && (((ImeCheckBox)paramView).getId() == a.f.sound_bt))
    {
      this.Jsz = paramBoolean;
      paramView = i.JyA;
      i.xp(paramBoolean);
    }
    AppMethodBeat.o(312493);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeCheckBox>
  {
    c(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    d(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    e(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<TextView>
  {
    f(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    g(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    h(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<TextView>
  {
    i(HldInitKeyboardSettingUI paramHldInitKeyboardSettingUI)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.ui.HldInitKeyboardSettingUI
 * JD-Core Version:    0.7.0.1
 */