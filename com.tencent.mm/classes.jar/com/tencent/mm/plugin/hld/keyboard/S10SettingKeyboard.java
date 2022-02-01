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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "mBackBtn", "Landroid/widget/RelativeLayout;", "getMBackBtn", "()Landroid/widget/RelativeLayout;", "mBackBtn$delegate", "Lkotlin/Lazy;", "mSoundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getMSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "mSoundBtn$delegate", "mTitleTv", "Landroid/widget/TextView;", "getMTitleTv", "()Landroid/widget/TextView;", "mTitleTv$delegate", "oriKeyVoiceChecked", "", "Ljava/lang/Boolean;", "oriTNineChecked", "t26Container", "getT26Container", "t26Container$delegate", "t26StateIconIv", "Landroid/widget/ImageView;", "getT26StateIconIv", "()Landroid/widget/ImageView;", "t26StateIconIv$delegate", "t26TitleTv", "getT26TitleTv", "t26TitleTv$delegate", "t9Container", "getT9Container", "t9Container$delegate", "t9StateIconIv", "getT9StateIconIv", "t9StateIconIv$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCheck", "", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S10SettingKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final S10SettingKeyboard.a JrA;
  private final j CAI;
  private final j JrB;
  private final j JrC;
  private final j JrD;
  private final j JrE;
  private final j JrF;
  private final j JrG;
  private final j JrH;
  private final j JrI;
  private Boolean JrJ;
  private Boolean JrK;
  
  static
  {
    AppMethodBeat.i(312948);
    JrA = new S10SettingKeyboard.a((byte)0);
    AppMethodBeat.o(312948);
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
    AppMethodBeat.i(312942);
    this.JrB = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.CAI = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.JrC = kotlin.k.cm((kotlin.g.a.a)new h(this));
    this.JrD = kotlin.k.cm((kotlin.g.a.a)new j(this));
    this.JrE = kotlin.k.cm((kotlin.g.a.a)new i(this));
    this.JrF = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.JrG = kotlin.k.cm((kotlin.g.a.a)new g(this));
    this.JrH = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.JrI = kotlin.k.cm((kotlin.g.a.a)new c(this));
    AppMethodBeat.o(312942);
  }
  
  private final RelativeLayout getMBackBtn()
  {
    AppMethodBeat.i(312887);
    Object localObject = this.CAI.getValue();
    s.s(localObject, "<get-mBackBtn>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312887);
    return localObject;
  }
  
  private final ImeCheckBox getMSoundBtn()
  {
    AppMethodBeat.i(312924);
    Object localObject = this.JrI.getValue();
    s.s(localObject, "<get-mSoundBtn>(...)");
    localObject = (ImeCheckBox)localObject;
    AppMethodBeat.o(312924);
    return localObject;
  }
  
  private final TextView getMTitleTv()
  {
    AppMethodBeat.i(312881);
    Object localObject = this.JrB.getValue();
    s.s(localObject, "<get-mTitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312881);
    return localObject;
  }
  
  private final RelativeLayout getT26Container()
  {
    AppMethodBeat.i(312908);
    Object localObject = this.JrF.getValue();
    s.s(localObject, "<get-t26Container>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312908);
    return localObject;
  }
  
  private final ImageView getT26StateIconIv()
  {
    AppMethodBeat.i(312918);
    Object localObject = this.JrH.getValue();
    s.s(localObject, "<get-t26StateIconIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312918);
    return localObject;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(312914);
    Object localObject = this.JrG.getValue();
    s.s(localObject, "<get-t26TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312914);
    return localObject;
  }
  
  private final RelativeLayout getT9Container()
  {
    AppMethodBeat.i(312892);
    Object localObject = this.JrC.getValue();
    s.s(localObject, "<get-t9Container>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312892);
    return localObject;
  }
  
  private final ImageView getT9StateIconIv()
  {
    AppMethodBeat.i(312903);
    Object localObject = this.JrE.getValue();
    s.s(localObject, "<get-t9StateIconIv>(...)");
    localObject = (ImageView)localObject;
    AppMethodBeat.o(312903);
    return localObject;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(312899);
    Object localObject = this.JrD.getValue();
    s.s(localObject, "<get-t9TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(312899);
    return localObject;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(312963);
    super.b(paramc);
    paramc = i.JyA;
    this.JrJ = Boolean.valueOf(i.fOp());
    paramc = getMSoundBtn();
    i locali = i.JyA;
    paramc.setChecked(i.fOp());
    paramc = i.JyA;
    if (i.fMo() == c.Jrp.ordinal()) {}
    for (boolean bool = true;; bool = false)
    {
      this.JrK = Boolean.valueOf(bool);
      paramc = i.JyA;
      if (i.fMo() != c.Jrp.ordinal()) {
        break;
      }
      getT9StateIconIv().setVisibility(0);
      getT26StateIconIv().setVisibility(8);
      AppMethodBeat.o(312963);
      return;
    }
    c.Jrq.ordinal();
    getT9StateIconIv().setVisibility(8);
    getT26StateIconIv().setVisibility(0);
    AppMethodBeat.o(312963);
  }
  
  public final c getKeyboardType()
  {
    return c.Jry;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312982);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.back_btn;
      if (paramView != null) {
        break label106;
      }
      label56:
      i = a.f.t9_container_rl;
      if (paramView != null) {
        break label367;
      }
      label64:
      i = a.f.t26_container_rl;
      if (paramView != null) {
        break label408;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(312982);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label106:
      if (paramView.intValue() != i) {
        break label56;
      }
      g.JuL.wW(true);
      paramView = l.JyV;
      if (l.bGa())
      {
        localObject = new ArrayList();
        boolean bool;
        if (getT9StateIconIv().getVisibility() == 0)
        {
          bool = true;
          if (!s.p(this.JrK, Boolean.valueOf(bool)))
          {
            if (!bool) {
              break label312;
            }
            paramView = com.tencent.mm.plugin.hld.model.b.Jul;
            label174:
            ((ArrayList)localObject).add(paramView);
            if (!bool) {
              break label319;
            }
            paramView = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.aL(1, 1, 0);
          }
          label195:
          bool = getMSoundBtn().getSwitchBtn().afTT;
          if (!s.p(this.JrJ, Boolean.valueOf(getMSoundBtn().getSwitchBtn().afTT)))
          {
            if (!getMSoundBtn().getSwitchBtn().afTT) {
              break label332;
            }
            paramView = com.tencent.mm.plugin.hld.model.b.Jun;
            label246:
            ((ArrayList)localObject).add(paramView);
            if (!bool) {
              break label339;
            }
            paramView = com.tencent.mm.plugin.hld.model.k.JvH;
            com.tencent.mm.plugin.hld.model.k.aL(4, 1, 0);
          }
        }
        for (;;)
        {
          if (!((ArrayList)localObject).isEmpty()) {
            break label352;
          }
          Log.i("WxIme.S10SettingKeyboard", "operation is null");
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S10SettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(312982);
          return;
          bool = false;
          break;
          label312:
          paramView = com.tencent.mm.plugin.hld.model.b.Jum;
          break label174;
          label319:
          paramView = com.tencent.mm.plugin.hld.model.k.JvH;
          com.tencent.mm.plugin.hld.model.k.aL(2, 1, 0);
          break label195;
          label332:
          paramView = com.tencent.mm.plugin.hld.model.b.Juo;
          break label246;
          label339:
          paramView = com.tencent.mm.plugin.hld.model.k.JvH;
          com.tencent.mm.plugin.hld.model.k.aL(5, 1, 0);
        }
        label352:
        paramView = e.JoK;
        e.a.iy((List)localObject);
        continue;
        label367:
        if (paramView.intValue() != i) {
          break label64;
        }
        paramView = i.JyA;
        i.YH(c.Jrp.ordinal());
        getT9StateIconIv().setVisibility(0);
        getT26StateIconIv().setVisibility(8);
        continue;
        label408:
        if (paramView.intValue() == i)
        {
          paramView = i.JyA;
          i.YH(c.Jrq.ordinal());
          getT9StateIconIv().setVisibility(8);
          getT26StateIconIv().setVisibility(0);
        }
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312957);
    super.onCreate();
    getT9Container().setOnClickListener((View.OnClickListener)this);
    getT26Container().setOnClickListener((View.OnClickListener)this);
    getMBackBtn().setOnClickListener((View.OnClickListener)this);
    ImeCheckBox localImeCheckBox = getMSoundBtn();
    String str = getContext().getString(a.j.ime_setting_sound_switch);
    s.s(str, "context.getString(R.stri…ime_setting_sound_switch)");
    localImeCheckBox.setTitle(str);
    getMSoundBtn().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    getMTitleTv().setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.d.ime_text_size));
    getT9TitleTv().setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.d.ime_text_size));
    getT26TitleTv().setTextSize(0, com.tencent.mm.cd.a.bs(getContext(), a.d.ime_text_size));
    AppMethodBeat.o(312957);
  }
  
  public final void z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(312987);
    s.u(paramView, "v");
    if ((paramView instanceof ImeCheckBox))
    {
      i locali = i.JyA;
      i.hV(paramView);
      if (((ImeCheckBox)paramView).getId() == a.f.sound_bt)
      {
        paramView = i.JyA;
        i.xp(paramBoolean);
      }
    }
    AppMethodBeat.o(312987);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    b(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<ImeCheckBox>
  {
    c(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    f(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class g
    extends u
    implements kotlin.g.a.a<TextView>
  {
    g(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class h
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    h(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class i
    extends u
    implements kotlin.g.a.a<ImageView>
  {
    i(S10SettingKeyboard paramS10SettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class j
    extends u
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