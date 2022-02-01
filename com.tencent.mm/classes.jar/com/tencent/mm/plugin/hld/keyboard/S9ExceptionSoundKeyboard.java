package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.a.j;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.k;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import kotlin.f;
import kotlin.g.b.p;
import kotlin.g.b.q;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chooseSound", "", "chooseVibrate", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "mBackBtn", "Landroid/widget/RelativeLayout;", "getMBackBtn", "()Landroid/widget/RelativeLayout;", "mBackBtn$delegate", "mSoundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getMSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "mSoundBtn$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCheck", "", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"})
public final class S9ExceptionSoundKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final a Dzy;
  private final f DyD;
  private final f Dzq;
  private boolean Dzw;
  private boolean Dzx;
  private final f zdF;
  
  static
  {
    AppMethodBeat.i(211814);
    Dzy = new a((byte)0);
    AppMethodBeat.o(211814);
  }
  
  public S9ExceptionSoundKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S9ExceptionSoundKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S9ExceptionSoundKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(211813);
    this.zdF = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.DyD = kotlin.g.ar((kotlin.g.a.a)new d(this));
    this.Dzq = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dzw = true;
    this.Dzx = true;
    AppMethodBeat.o(211813);
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(211803);
    Button localButton = (Button)this.Dzq.getValue();
    AppMethodBeat.o(211803);
    return localButton;
  }
  
  private final RelativeLayout getMBackBtn()
  {
    AppMethodBeat.i(211800);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.zdF.getValue();
    AppMethodBeat.o(211800);
    return localRelativeLayout;
  }
  
  private final ImeCheckBox getMSoundBtn()
  {
    AppMethodBeat.i(211801);
    ImeCheckBox localImeCheckBox = (ImeCheckBox)this.DyD.getValue();
    AppMethodBeat.o(211801);
    return localImeCheckBox;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(211807);
    super.b(paramc);
    paramc = k.DDb;
    k.ap(0, 2, 2);
    AppMethodBeat.o(211807);
  }
  
  public final c getKeyboardType()
  {
    return c.Dyt;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(211810);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.back_btn;
      if (paramView != null) {
        break label85;
      }
      label54:
      i = a.f.finish_bt;
      if (paramView != null) {
        break label133;
      }
    }
    label85:
    while (paramView.intValue() != i) {
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(211810);
        return;
        paramView = null;
        break;
        if (paramView.intValue() != i) {
          break label54;
        }
        paramView = com.tencent.mm.plugin.hld.model.g.DCm;
        if (com.tencent.mm.plugin.hld.model.g.eEm() != c.Dys.ordinal())
        {
          paramView.a(c.Dys);
        }
        else
        {
          localObject = i.DHq;
          paramView.Ux(i.eEm());
        }
      }
    }
    label133:
    paramView = k.DDb;
    if (this.Dzw)
    {
      i = 4;
      label154:
      k.ap(i, 2, 2);
      paramView = com.tencent.mm.plugin.hld.f.l.DHK;
      com.tencent.mm.plugin.hld.f.l.eHr();
      com.tencent.mm.plugin.hld.model.g.DCm.eDW();
      paramView = k.DDb;
      k.UB(7);
      paramView = e.Dvq;
      if (!getMSoundBtn().getSwitchBtn().isCheck()) {
        break label219;
      }
    }
    label219:
    for (paramView = com.tencent.mm.plugin.hld.model.b.DBo;; paramView = com.tencent.mm.plugin.hld.model.b.DBp)
    {
      e.a.a(paramView, 0L, null, 6);
      break;
      i = 5;
      break label154;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(211805);
    super.onCreate();
    Object localObject = i.DHq;
    this.Dzw = i.eGD();
    localObject = i.DHq;
    this.Dzx = i.eGE();
    localObject = getMSoundBtn();
    String str = getContext().getString(a.j.ime_setting_sound_switch);
    p.j(str, "context.getString(R.stri…ime_setting_sound_switch)");
    ((ImeCheckBox)localObject).setTitle(str);
    getMSoundBtn().setChecked(this.Dzw);
    getMSoundBtn().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    getMBackBtn().setOnClickListener((View.OnClickListener)this);
    getFinishBt().setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(211805);
  }
  
  public final void t(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(211811);
    p.k(paramView, "v");
    if ((paramView instanceof ImeCheckBox))
    {
      i locali = i.DHq;
      i.fj(paramView);
      if (((ImeCheckBox)paramView).getId() == a.f.sound_bt)
      {
        this.Dzw = paramBoolean;
        paramView = i.DHq;
        i.te(paramBoolean);
      }
    }
    AppMethodBeat.o(211811);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Button>
  {
    b(S9ExceptionSoundKeyboard paramS9ExceptionSoundKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(S9ExceptionSoundKeyboard paramS9ExceptionSoundKeyboard)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<ImeCheckBox>
  {
    d(S9ExceptionSoundKeyboard paramS9ExceptionSoundKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S9ExceptionSoundKeyboard
 * JD-Core Version:    0.7.0.1
 */