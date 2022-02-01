package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.d;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.List;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBackBtn", "Landroid/widget/RelativeLayout;", "getMBackBtn", "()Landroid/widget/RelativeLayout;", "mBackBtn$delegate", "Lkotlin/Lazy;", "mSoundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getMSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "mSoundBtn$delegate", "mTitleTv", "Landroid/widget/TextView;", "getMTitleTv", "()Landroid/widget/TextView;", "mTitleTv$delegate", "oriKeyVoiceChecked", "", "Ljava/lang/Boolean;", "oriTNineChecked", "t26Container", "getT26Container", "t26Container$delegate", "t26StateIconIv", "Landroid/widget/ImageView;", "getT26StateIconIv", "()Landroid/widget/ImageView;", "t26StateIconIv$delegate", "t26TitleTv", "getT26TitleTv", "t26TitleTv$delegate", "t9Container", "getT9Container", "t9Container$delegate", "t9StateIconIv", "getT9StateIconIv", "t9StateIconIv$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCheck", "", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"})
public final class S10SettingKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final a DyG;
  private final f DyA;
  private final f DyB;
  private final f DyC;
  private final f DyD;
  private Boolean DyE;
  private Boolean DyF;
  private final f Dyw;
  private final f Dyx;
  private final f Dyy;
  private final f Dyz;
  private final f zdF;
  
  static
  {
    AppMethodBeat.i(211152);
    DyG = new a((byte)0);
    AppMethodBeat.o(211152);
  }
  
  public S10SettingKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S10SettingKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S10SettingKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(211151);
    this.Dyw = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.zdF = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dyx = kotlin.g.ar((kotlin.g.a.a)new h(this));
    this.Dyy = kotlin.g.ar((kotlin.g.a.a)new j(this));
    this.Dyz = kotlin.g.ar((kotlin.g.a.a)new i(this));
    this.DyA = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.DyB = kotlin.g.ar((kotlin.g.a.a)new g(this));
    this.DyC = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.DyD = kotlin.g.ar((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(211151);
  }
  
  private final RelativeLayout getMBackBtn()
  {
    AppMethodBeat.i(211136);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.zdF.getValue();
    AppMethodBeat.o(211136);
    return localRelativeLayout;
  }
  
  private final ImeCheckBox getMSoundBtn()
  {
    AppMethodBeat.i(211143);
    ImeCheckBox localImeCheckBox = (ImeCheckBox)this.DyD.getValue();
    AppMethodBeat.o(211143);
    return localImeCheckBox;
  }
  
  private final TextView getMTitleTv()
  {
    AppMethodBeat.i(211135);
    TextView localTextView = (TextView)this.Dyw.getValue();
    AppMethodBeat.o(211135);
    return localTextView;
  }
  
  private final RelativeLayout getT26Container()
  {
    AppMethodBeat.i(211140);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.DyA.getValue();
    AppMethodBeat.o(211140);
    return localRelativeLayout;
  }
  
  private final ImageView getT26StateIconIv()
  {
    AppMethodBeat.i(211142);
    ImageView localImageView = (ImageView)this.DyC.getValue();
    AppMethodBeat.o(211142);
    return localImageView;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(211141);
    TextView localTextView = (TextView)this.DyB.getValue();
    AppMethodBeat.o(211141);
    return localTextView;
  }
  
  private final RelativeLayout getT9Container()
  {
    AppMethodBeat.i(211137);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dyx.getValue();
    AppMethodBeat.o(211137);
    return localRelativeLayout;
  }
  
  private final ImageView getT9StateIconIv()
  {
    AppMethodBeat.i(211139);
    ImageView localImageView = (ImageView)this.Dyz.getValue();
    AppMethodBeat.o(211139);
    return localImageView;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(211138);
    TextView localTextView = (TextView)this.Dyy.getValue();
    AppMethodBeat.o(211138);
    return localTextView;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(211145);
    super.b(paramc);
    paramc = i.DHq;
    this.DyE = Boolean.valueOf(i.eGD());
    paramc = getMSoundBtn();
    i locali = i.DHq;
    paramc.setChecked(i.eGD());
    paramc = i.DHq;
    if (i.eEm() == c.Dyl.ordinal()) {}
    for (boolean bool = true;; bool = false)
    {
      this.DyF = Boolean.valueOf(bool);
      paramc = i.DHq;
      if (i.eEm() != c.Dyl.ordinal()) {
        break;
      }
      getT9StateIconIv().setVisibility(0);
      getT26StateIconIv().setVisibility(8);
      AppMethodBeat.o(211145);
      return;
    }
    c.Dym.ordinal();
    getT9StateIconIv().setVisibility(8);
    getT26StateIconIv().setVisibility(0);
    AppMethodBeat.o(211145);
  }
  
  public final c getKeyboardType()
  {
    return c.Dyu;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211148);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.back_btn;
      if (paramView != null) {
        break label106;
      }
      label62:
      i = a.f.t9_container_rl;
      if (paramView != null) {
        break label371;
      }
      label70:
      i = a.f.t26_container_rl;
      if (paramView != null) {
        break label412;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(211148);
      return;
      paramView = null;
      break;
      label106:
      if (paramView.intValue() != i) {
        break label62;
      }
      com.tencent.mm.plugin.hld.model.g.DCm.sQ(true);
      paramView = com.tencent.mm.plugin.hld.f.l.DHK;
      if (com.tencent.mm.plugin.hld.f.l.biq())
      {
        localObject = new ArrayList();
        boolean bool;
        if (getT9StateIconIv().getVisibility() == 0)
        {
          bool = true;
          if ((p.h(this.DyF, Boolean.valueOf(bool)) ^ true))
          {
            if (!bool) {
              break label316;
            }
            paramView = com.tencent.mm.plugin.hld.model.b.DBm;
            label176:
            ((ArrayList)localObject).add(paramView);
            if (!bool) {
              break label323;
            }
            paramView = k.DDb;
            k.ap(1, 1, 0);
          }
          label197:
          bool = getMSoundBtn().getSwitchBtn().isCheck();
          if ((p.h(this.DyE, Boolean.valueOf(getMSoundBtn().getSwitchBtn().isCheck())) ^ true))
          {
            if (!getMSoundBtn().getSwitchBtn().isCheck()) {
              break label336;
            }
            paramView = com.tencent.mm.plugin.hld.model.b.DBo;
            label250:
            ((ArrayList)localObject).add(paramView);
            if (!bool) {
              break label343;
            }
            paramView = k.DDb;
            k.ap(4, 1, 0);
          }
        }
        for (;;)
        {
          if (!((ArrayList)localObject).isEmpty()) {
            break label356;
          }
          Log.i("WxIme.S10SettingKeyboard", "operation is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(211148);
          return;
          bool = false;
          break;
          label316:
          paramView = com.tencent.mm.plugin.hld.model.b.DBn;
          break label176;
          label323:
          paramView = k.DDb;
          k.ap(2, 1, 0);
          break label197;
          label336:
          paramView = com.tencent.mm.plugin.hld.model.b.DBp;
          break label250;
          label343:
          paramView = k.DDb;
          k.ap(5, 1, 0);
        }
        label356:
        paramView = e.Dvq;
        e.a.fB((List)localObject);
        continue;
        label371:
        if (paramView.intValue() != i) {
          break label70;
        }
        paramView = i.DHq;
        i.UJ(c.Dyl.ordinal());
        getT9StateIconIv().setVisibility(0);
        getT26StateIconIv().setVisibility(8);
        continue;
        label412:
        if (paramView.intValue() == i)
        {
          paramView = i.DHq;
          i.UJ(c.Dym.ordinal());
          getT9StateIconIv().setVisibility(8);
          getT26StateIconIv().setVisibility(0);
        }
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(211144);
    super.onCreate();
    getT9Container().setOnClickListener((View.OnClickListener)this);
    getT26Container().setOnClickListener((View.OnClickListener)this);
    getMBackBtn().setOnClickListener((View.OnClickListener)this);
    ImeCheckBox localImeCheckBox = getMSoundBtn();
    String str = getContext().getString(a.j.ime_setting_sound_switch);
    p.j(str, "context.getString(R.stri…ime_setting_sound_switch)");
    localImeCheckBox.setTitle(str);
    getMSoundBtn().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    getMTitleTv().setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_text_size));
    getT9TitleTv().setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_text_size));
    getT26TitleTv().setTextSize(0, com.tencent.mm.ci.a.aZ(getContext(), a.d.ime_text_size));
    AppMethodBeat.o(211144);
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(211149);
    p.k(paramView, "v");
    if ((paramView instanceof ImeCheckBox))
    {
      i locali = i.DHq;
      i.fj(paramView);
      if (((ImeCheckBox)paramView).getId() == a.f.sound_bt)
      {
        paramView = i.DHq;
        i.te(paramBoolean);
      }
    }
    AppMethodBeat.o(211149);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<ImeCheckBox>
  {
    c(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    f(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class g
    extends q
    implements kotlin.g.a.a<TextView>
  {
    g(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class h
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    h(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class i
    extends q
    implements kotlin.g.a.a<ImageView>
  {
    i(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class j
    extends q
    implements kotlin.g.a.a<TextView>
  {
    j(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S10SettingKeyboard
 * JD-Core Version:    0.7.0.1
 */