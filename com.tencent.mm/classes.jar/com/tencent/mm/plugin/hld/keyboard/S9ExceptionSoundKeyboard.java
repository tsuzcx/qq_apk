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
import com.tencent.mm.plugin.hld.f.l;
import com.tencent.mm.plugin.hld.model.g;
import com.tencent.mm.plugin.hld.view.ImeCheckBox;
import com.tencent.mm.ui.widget.MMSwitchBtn;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "Lcom/tencent/mm/plugin/hld/view/IImeCheckBoxCallback;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chooseSound", "", "chooseVibrate", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "mBackBtn", "Landroid/widget/RelativeLayout;", "getMBackBtn", "()Landroid/widget/RelativeLayout;", "mBackBtn$delegate", "mSoundBtn", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "getMSoundBtn", "()Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "mSoundBtn$delegate", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onCheck", "", "v", "Landroid/view/View;", "checked", "onClick", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S9ExceptionSoundKeyboard
  extends ImeKeyboard
  implements View.OnClickListener, com.tencent.mm.plugin.hld.view.b
{
  public static final S9ExceptionSoundKeyboard.a Jsy;
  private final j CAI;
  private final j JrI;
  private boolean JsA;
  private final j Jst;
  private boolean Jsz;
  
  static
  {
    AppMethodBeat.i(312940);
    Jsy = new S9ExceptionSoundKeyboard.a((byte)0);
    AppMethodBeat.o(312940);
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
    AppMethodBeat.i(312934);
    this.CAI = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.JrI = kotlin.k.cm((kotlin.g.a.a)new d(this));
    this.Jst = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jsz = true;
    this.JsA = true;
    AppMethodBeat.o(312934);
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(312916);
    Object localObject = this.Jst.getValue();
    s.s(localObject, "<get-finishBt>(...)");
    localObject = (Button)localObject;
    AppMethodBeat.o(312916);
    return localObject;
  }
  
  private final RelativeLayout getMBackBtn()
  {
    AppMethodBeat.i(312905);
    Object localObject = this.CAI.getValue();
    s.s(localObject, "<get-mBackBtn>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(312905);
    return localObject;
  }
  
  private final ImeCheckBox getMSoundBtn()
  {
    AppMethodBeat.i(312912);
    Object localObject = this.JrI.getValue();
    s.s(localObject, "<get-mSoundBtn>(...)");
    localObject = (ImeCheckBox)localObject;
    AppMethodBeat.o(312912);
    return localObject;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(312956);
    super.b(paramc);
    paramc = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.aL(0, 2, 2);
    AppMethodBeat.o(312956);
  }
  
  public final c getKeyboardType()
  {
    return c.Jrx;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(312967);
    Object localObject = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S9ExceptionSoundKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.back_btn;
      if (paramView != null) {
        break label85;
      }
      label48:
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
        AppMethodBeat.o(312967);
        return;
        paramView = Integer.valueOf(paramView.getId());
        break;
        if (paramView.intValue() != i) {
          break label48;
        }
        paramView = g.JuL;
        if (g.fMo() != c.Jrw.ordinal())
        {
          paramView.a(c.Jrw);
        }
        else
        {
          localObject = i.JyA;
          paramView.Yu(i.fMo());
        }
      }
    }
    label133:
    paramView = com.tencent.mm.plugin.hld.model.k.JvH;
    if (this.Jsz)
    {
      i = 4;
      label154:
      com.tencent.mm.plugin.hld.model.k.aL(i, 2, 2);
      paramView = l.JyV;
      l.fPa();
      g.JuL.fLY();
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      com.tencent.mm.plugin.hld.model.k.Yy(7);
      paramView = e.JoK;
      if (!getMSoundBtn().getSwitchBtn().afTT) {
        break label219;
      }
    }
    label219:
    for (paramView = com.tencent.mm.plugin.hld.model.b.Jun;; paramView = com.tencent.mm.plugin.hld.model.b.Juo)
    {
      e.a.a(paramView, 0L, null, 6);
      break;
      i = 5;
      break label154;
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(312947);
    super.onCreate();
    Object localObject = i.JyA;
    this.Jsz = i.fOp();
    localObject = i.JyA;
    this.JsA = i.fOq();
    localObject = getMSoundBtn();
    String str = getContext().getString(a.j.ime_setting_sound_switch);
    s.s(str, "context.getString(R.stri…ime_setting_sound_switch)");
    ((ImeCheckBox)localObject).setTitle(str);
    getMSoundBtn().setChecked(this.Jsz);
    getMSoundBtn().setIImeSeekCallback((com.tencent.mm.plugin.hld.view.b)this);
    getMBackBtn().setOnClickListener((View.OnClickListener)this);
    getFinishBt().setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(312947);
  }
  
  public final void z(View paramView, boolean paramBoolean)
  {
    AppMethodBeat.i(312976);
    s.u(paramView, "v");
    if ((paramView instanceof ImeCheckBox))
    {
      i locali = i.JyA;
      i.hV(paramView);
      if (((ImeCheckBox)paramView).getId() == a.f.sound_bt)
      {
        this.Jsz = paramBoolean;
        paramView = i.JyA;
        i.xp(paramBoolean);
      }
    }
    AppMethodBeat.o(312976);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(S9ExceptionSoundKeyboard paramS9ExceptionSoundKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(S9ExceptionSoundKeyboard paramS9ExceptionSoundKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/plugin/hld/view/ImeCheckBox;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
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