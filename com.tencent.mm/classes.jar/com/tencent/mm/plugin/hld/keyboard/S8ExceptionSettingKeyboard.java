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
import com.tencent.mm.plugin.hld.model.g;
import kotlin.Metadata;
import kotlin.g.b.s;
import kotlin.g.b.u;
import kotlin.j;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard;", "Lcom/tencent/mm/plugin/hld/keyboard/ImeKeyboard;", "Landroid/view/View$OnClickListener;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "chooseT9", "", "finishBt", "Landroid/widget/Button;", "getFinishBt", "()Landroid/widget/Button;", "finishBt$delegate", "Lkotlin/Lazy;", "t26Bt", "Landroid/widget/RelativeLayout;", "getT26Bt", "()Landroid/widget/RelativeLayout;", "t26Bt$delegate", "t26TitleTv", "Landroid/widget/TextView;", "getT26TitleTv", "()Landroid/widget/TextView;", "t26TitleTv$delegate", "t9Bt", "getT9Bt", "t9Bt$delegate", "t9TitleTv", "getT9TitleTv", "t9TitleTv$delegate", "chooseFinishIfNeed", "", "getKeyboardType", "Lcom/tencent/mm/plugin/hld/keyboard/KeyboardType;", "onClick", "v", "Landroid/view/View;", "onCreate", "onResume", "listener", "Lcom/tencent/mm/plugin/hld/api/IKeyboardActionListener;", "Companion", "plugin-hld_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class S8ExceptionSettingKeyboard
  extends ImeKeyboard
  implements View.OnClickListener
{
  public static final S8ExceptionSettingKeyboard.a Jss;
  private final j JrD;
  private final j JrG;
  private final j Jst;
  private final j Jsu;
  private final j Jsv;
  private boolean Jsw;
  
  static
  {
    AppMethodBeat.i(313067);
    Jss = new S8ExceptionSettingKeyboard.a((byte)0);
    AppMethodBeat.o(313067);
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
    AppMethodBeat.i(313049);
    this.Jst = kotlin.k.cm((kotlin.g.a.a)new b(this));
    this.Jsu = kotlin.k.cm((kotlin.g.a.a)new e(this));
    this.Jsv = kotlin.k.cm((kotlin.g.a.a)new c(this));
    this.JrD = kotlin.k.cm((kotlin.g.a.a)new f(this));
    this.JrG = kotlin.k.cm((kotlin.g.a.a)new d(this));
    AppMethodBeat.o(313049);
  }
  
  private final void fLP()
  {
    AppMethodBeat.i(313059);
    Object localObject = getResources();
    int i;
    if (localObject != null)
    {
      localObject = ((Resources)localObject).getConfiguration();
      if ((localObject != null) && (((Configuration)localObject).orientation == 2))
      {
        i = 1;
        if (i != 0)
        {
          localObject = com.tencent.mm.plugin.hld.model.k.JvH;
          if (!this.Jsw) {
            break label102;
          }
          i = 1;
          label50:
          com.tencent.mm.plugin.hld.model.k.aL(i, 1, 2);
          g.JuL.a(c.Jrx);
          localObject = e.JoK;
          if (!getT9Bt().isSelected()) {
            break label107;
          }
        }
      }
    }
    label102:
    label107:
    for (localObject = com.tencent.mm.plugin.hld.model.b.Jul;; localObject = com.tencent.mm.plugin.hld.model.b.Jum)
    {
      e.a.a((com.tencent.mm.plugin.hld.model.b)localObject, 0L, null, 6);
      AppMethodBeat.o(313059);
      return;
      i = 0;
      break;
      i = 2;
      break label50;
    }
  }
  
  private final Button getFinishBt()
  {
    AppMethodBeat.i(312998);
    Button localButton = (Button)this.Jst.getValue();
    AppMethodBeat.o(312998);
    return localButton;
  }
  
  private final RelativeLayout getT26Bt()
  {
    AppMethodBeat.i(313012);
    Object localObject = this.Jsv.getValue();
    s.s(localObject, "<get-t26Bt>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313012);
    return localObject;
  }
  
  private final TextView getT26TitleTv()
  {
    AppMethodBeat.i(313027);
    Object localObject = this.JrG.getValue();
    s.s(localObject, "<get-t26TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(313027);
    return localObject;
  }
  
  private final RelativeLayout getT9Bt()
  {
    AppMethodBeat.i(313005);
    Object localObject = this.Jsu.getValue();
    s.s(localObject, "<get-t9Bt>(...)");
    localObject = (RelativeLayout)localObject;
    AppMethodBeat.o(313005);
    return localObject;
  }
  
  private final TextView getT9TitleTv()
  {
    AppMethodBeat.i(313019);
    Object localObject = this.JrD.getValue();
    s.s(localObject, "<get-t9TitleTv>(...)");
    localObject = (TextView)localObject;
    AppMethodBeat.o(313019);
    return localObject;
  }
  
  public final void b(com.tencent.mm.plugin.hld.a.c paramc)
  {
    AppMethodBeat.i(313084);
    super.b(paramc);
    paramc = com.tencent.mm.plugin.hld.model.k.JvH;
    com.tencent.mm.plugin.hld.model.k.aL(0, 1, 2);
    AppMethodBeat.o(313084);
  }
  
  public final c getKeyboardType()
  {
    return c.Jrw;
  }
  
  public final void onClick(View paramView)
  {
    AppMethodBeat.i(313099);
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aYj());
    int i;
    if (paramView == null)
    {
      paramView = null;
      i = a.f.finish_bt;
      if (paramView != null) {
        break label101;
      }
      label52:
      i = a.f.t9_rv;
      if (paramView != null) {
        break label178;
      }
      label60:
      i = a.f.t26_rv;
      if (paramView != null) {
        break label271;
      }
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/hld/keyboard/S8ExceptionSettingKeyboard", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(313099);
      return;
      paramView = Integer.valueOf(paramView.getId());
      break;
      label101:
      if (paramView.intValue() != i) {
        break label52;
      }
      paramView = com.tencent.mm.plugin.hld.model.k.JvH;
      if (this.Jsw)
      {
        i = 1;
        label122:
        com.tencent.mm.plugin.hld.model.k.aL(i, 1, 2);
        g.JuL.a(c.Jrx);
        paramView = e.JoK;
        if (!getT9Bt().isSelected()) {
          break label171;
        }
      }
      label171:
      for (paramView = com.tencent.mm.plugin.hld.model.b.Jul;; paramView = com.tencent.mm.plugin.hld.model.b.Jum)
      {
        e.a.a(paramView, 0L, null, 6);
        break;
        i = 2;
        break label122;
      }
      label178:
      if (paramView.intValue() != i) {
        break label60;
      }
      getT9Bt().setSelected(true);
      getT26Bt().setSelected(false);
      getT9TitleTv().setSelected(true);
      getT26TitleTv().setSelected(false);
      paramView = i.JyA;
      i.YH(c.Jrp.ordinal());
      paramView = getFinishBt();
      if (paramView != null) {
        paramView.setEnabled(true);
      }
      paramView = getFinishBt();
      if (paramView != null) {
        paramView.setClickable(true);
      }
      this.Jsw = true;
      fLP();
      continue;
      label271:
      if (paramView.intValue() == i)
      {
        getT9Bt().setSelected(false);
        getT26Bt().setSelected(true);
        getT9TitleTv().setSelected(false);
        getT26TitleTv().setSelected(true);
        paramView = i.JyA;
        i.YH(c.Jrq.ordinal());
        paramView = getFinishBt();
        if (paramView != null) {
          paramView.setEnabled(true);
        }
        paramView = getFinishBt();
        if (paramView != null) {
          paramView.setClickable(true);
        }
        this.Jsw = false;
        fLP();
      }
    }
  }
  
  public final void onCreate()
  {
    AppMethodBeat.i(313078);
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
    AppMethodBeat.o(313078);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/Button;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends u
    implements kotlin.g.a.a<Button>
  {
    b(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class c
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    c(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class d
    extends u
    implements kotlin.g.a.a<TextView>
  {
    d(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/RelativeLayout;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class e
    extends u
    implements kotlin.g.a.a<RelativeLayout>
  {
    e(S8ExceptionSettingKeyboard paramS8ExceptionSettingKeyboard)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType"}, k=3, mv={1, 5, 1}, xi=48)
  static final class f
    extends u
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