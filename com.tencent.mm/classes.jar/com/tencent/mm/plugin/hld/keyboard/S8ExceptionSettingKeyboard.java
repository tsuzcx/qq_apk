package com.tencent.mm.plugin.hld.keyboard;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.hld.a.f;
import com.tencent.mm.plugin.hld.b.e;
import com.tencent.mm.plugin.hld.b.e.a;
import com.tencent.mm.plugin.hld.f.i;
import com.tencent.mm.plugin.hld.model.k;
import kotlin.f;
import kotlin.g.b.q;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chooseT9", "", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "t26Bt", "Landroid/widget/RelativeLayout;", "getT26Bt", "()Landroid/widget/RelativeLayout;", "t26Bt$delegate", "t26TitleTv", "Landroid/widget/TextView;", "getT26TitleTv", "()Landroid/widget/TextView;", "t26TitleTv$delegate", "t9Bt", "getT9Bt", "t9Bt$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "chooseFinishIfNeed", "", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onClick", "v", "Landroid/view/View;", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"})
public final class S8ExceptionSettingKeyboard
  extends ImeKeyboard
  implements View.OnClickListener
{
  public static final a Dzu;
  private final f DyB;
  private final f Dyy;
  private final f Dzq;
  private final f Dzr;
  private final f Dzs;
  private boolean Dzt;
  
  static
  {
    AppMethodBeat.i(209071);
    Dzu = new a((byte)0);
    AppMethodBeat.o(209071);
  }
  
  public S8ExceptionSettingKeyboard(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public S8ExceptionSettingKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    this(paramContext, paramAttributeSet, paramInt, (byte)0);
  }
  
  private S8ExceptionSettingKeyboard(Context paramContext, AttributeSet paramAttributeSet, int paramInt, byte paramByte)
  {
    super(paramContext, paramAttributeSet, paramInt, (byte)0);
    AppMethodBeat.i(209069);
    this.Dzq = kotlin.g.ar((kotlin.g.a.a)new b(this));
    this.Dzr = kotlin.g.ar((kotlin.g.a.a)new e(this));
    this.Dzs = kotlin.g.ar((kotlin.g.a.a)new c(this));
    this.Dyy = kotlin.g.ar((kotlin.g.a.a)new f(this));
    this.DyB = kotlin.g.ar((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(209069);
  }
  
  private final void eDM()
  {
    AppMethodBeat.i(209068);
    Object localObject = getResources();
    int i;
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getConfiguration();
      if (localObject != null) {
        if (((Configuration)localObject).orientation == 2)
        {
          localObject = k.DDb;
          if (!this.Dzt) {
            break label97;
          }
          i = 1;
          k.ap(i, 1, 2);
          com.tencent.mm.plugin.hld.model.g.DCm.a(c.Dyt);
          localObject = e.Dvq;
          if (!getT9Bt().isSelected()) {
            break label102;
          }
        }
      }
    }
    label97:
    label102:
    for (localObject = com.tencent.mm.plugin.hld.model.b.DBm;; localObject = com.tencent.mm.plugin.hld.model.b.DBn)
    {
      e.a.a((com.tencent.mm.plugin.hld.model.b)localObject, 0L, null, 6);
      AppMethodBeat.o(209068);
      return;
      AppMethodBeat.o(209068);
      return;
      i = 2;
      break;
    }
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(209058);
    Button localButton = (Button)this.Dzq.getValue();
    AppMethodBeat.o(209058);
    return localButton;
  }
  
  private final RelativeLayout getT26Bt()
  {
    AppMethodBeat.i(209060);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzs.getValue();
    AppMethodBeat.o(209060);
    return localRelativeLayout;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(209063);
    TextView localTextView = (TextView)this.DyB.getValue();
    AppMethodBeat.o(209063);
    return localTextView;
  }
  
  private final RelativeLayout getT9Bt()
  {
    AppMethodBeat.i(209059);
    RelativeLayout localRelativeLayout = (RelativeLayout)this.Dzr.getValue();
    AppMethodBeat.o(209059);
    return localRelativeLayout;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(209061);
    TextView localTextView = (TextView)this.Dyy.getValue();
    AppMethodBeat.o(209061);
    return localTextView;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(209065);
    super.b(paramc);
    paramc = k.DDb;
    k.ap(0, 1, 2);
    AppMethodBeat.o(209065);
  }
  
  public final c getKeyboardType()
  {
    return c.Dys;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(209066);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.bn(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
    int i;
    if (paramView != null)
    {
      paramView = Integer.valueOf(paramView.getId());
      i = a.f.finish_bt;
      if (paramView != null) {
        break label93;
      }
      label54:
      i = a.f.t9_rv;
      if (paramView != null) {
        break label170;
      }
      label62:
      i = a.f.t26_rv;
      if (paramView != null) {
        break label263;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(209066);
      return;
      paramView = null;
      break;
      label93:
      if (paramView.intValue() != i) {
        break label54;
      }
      paramView = k.DDb;
      if (this.Dzt)
      {
        i = 1;
        label114:
        k.ap(i, 1, 2);
        com.tencent.mm.plugin.hld.model.g.DCm.a(c.Dyt);
        paramView = e.Dvq;
        if (!getT9Bt().isSelected()) {
          break label163;
        }
      }
      label163:
      for (paramView = com.tencent.mm.plugin.hld.model.b.DBm;; paramView = com.tencent.mm.plugin.hld.model.b.DBn)
      {
        e.a.a(paramView, 0L, null, 6);
        break;
        i = 2;
        break label114;
      }
      label170:
      if (paramView.intValue() != i) {
        break label62;
      }
      getT9Bt().setSelected(true);
      getT26Bt().setSelected(false);
      getT9TitleTv().setSelected(true);
      getT26TitleTv().setSelected(false);
      paramView = i.DHq;
      i.UJ(c.Dyl.ordinal());
      paramView = getFinishBt();
      if (paramView != null) {
        paramView.setEnabled(true);
      }
      paramView = getFinishBt();
      if (paramView != null) {
        paramView.setClickable(true);
      }
      this.Dzt = true;
      eDM();
      continue;
      label263:
      if (paramView.intValue() == i)
      {
        getT9Bt().setSelected(false);
        getT26Bt().setSelected(true);
        getT9TitleTv().setSelected(false);
        getT26TitleTv().setSelected(true);
        paramView = i.DHq;
        i.UJ(c.Dym.ordinal());
        paramView = getFinishBt();
        if (paramView != null) {
          paramView.setEnabled(true);
        }
        paramView = getFinishBt();
        if (paramView != null) {
          paramView.setClickable(true);
        }
        this.Dzt = false;
        eDM();
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(209064);
    super.onCreate();
    Button localButton = getFinishBt();
    if (localButton != null) {
      localButton.setEnabled(false);
    }
    localButton = getFinishBt();
    if (localButton != null) {
      localButton.setClickable(false);
    }
    localButton = getFinishBt();
    if (localButton != null) {
      localButton.setOnClickListener((View.OnClickListener)this);
    }
    getT9Bt().setOnClickListener((View.OnClickListener)this);
    getT26Bt().setOnClickListener((View.OnClickListener)this);
    AppMethodBeat.o(209064);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard$Companion;", "", "()V", "TAG", "", "plugin-hld_release"})
  public static final class a {}
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType", "invoke"})
  static final class b
    extends q
    implements kotlin.g.a.a<Button>
  {
    b(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class c
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class d
    extends q
    implements kotlin.g.a.a<TextView>
  {
    d(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType", "invoke"})
  static final class e
    extends q
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class f
    extends q
    implements kotlin.g.a.a<TextView>
  {
    f(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.hld.keyboard.S8ExceptionSettingKeyboard
 * JD-Core Version:    0.7.0.1
 */