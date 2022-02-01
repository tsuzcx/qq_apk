package com.tencent.mm.plugin.finder.live.viewmodel;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.ax;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.aa.d;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.t;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "TAG", "", "bottomSpace", "Landroid/view/View;", "getBottomSpace", "()Landroid/view/View;", "setBottomSpace", "(Landroid/view/View;)V", "btnContainer", "Landroid/widget/LinearLayout;", "getBtnContainer", "()Landroid/widget/LinearLayout;", "setBtnContainer", "(Landroid/widget/LinearLayout;)V", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "descTv", "Lcom/tencent/mm/ui/widget/MMEditText;", "getDescTv", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setDescTv", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "edtContainer", "getEdtContainer", "setEdtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "keyboardHeight", "getKeyboardHeight", "setKeyboardHeight", "(I)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "postBtnMaxMarginBottom", "getPostBtnMaxMarginBottom", "setPostBtnMaxMarginBottom", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "textCountTv", "Landroid/widget/TextView;", "getTextCountTv", "()Landroid/widget/TextView;", "setTextCountTv", "(Landroid/widget/TextView;)V", "textLeft", "getTextLeft", "setTextLeft", "checkNeedScroll", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "isResized", "", "onPause", "onResume", "setInputConfig", "plugin-finder_release"})
public final class d
  extends UIComponent
  implements h
{
  private final int MAX_INPUT_SIZE;
  private final String TAG;
  private String desc;
  public ScrollView jbL;
  private com.tencent.mm.ui.tools.i jij;
  int pIk;
  public TextView yOA;
  public View yOO;
  public View yOP;
  private final View.OnLayoutChangeListener yPg;
  public MMEditText zbm;
  public LinearLayout zbn;
  final int zbo;
  int zbp;
  int zbq;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(277936);
    this.TAG = "Finder.FinderGameLiveEditUIC";
    this.MAX_INPUT_SIZE = 60;
    this.zbo = (this.MAX_INPUT_SIZE * 2);
    this.zbp = this.MAX_INPUT_SIZE;
    this.desc = "";
    this.zbq = ((int)getResources().getDimension(b.d.Edge_12A));
    this.yPg = ((View.OnLayoutChangeListener)new b(this));
    AppMethodBeat.o(277936);
  }
  
  private final void dFO()
  {
    AppMethodBeat.i(277931);
    Object localObject1 = new Point();
    Object localObject2 = getActivity().getWindowManager();
    p.j(localObject2, "activity.windowManager");
    ((WindowManager)localObject2).getDefaultDisplay().getSize((Point)localObject1);
    int j = ((Point)localObject1).y;
    localObject1 = getActivity().findViewById(b.f.game_post_root);
    int i;
    int k;
    int[] arrayOfInt;
    if (localObject1 != null)
    {
      i = ((View)localObject1).getHeight();
      k = Math.max(j, i);
      arrayOfInt = new int[2];
      localObject1 = getActivity().findViewById(b.f.game_team_condition_layout);
      p.j(localObject1, "gameTeamContainer");
      if (((View)localObject1).getVisibility() != 0) {
        break label320;
      }
      ((View)localObject1).getLocationInWindow(arrayOfInt);
      i = arrayOfInt[1];
    }
    for (;;)
    {
      i += ((View)localObject1).getHeight();
      j = this.pIk;
      localObject1 = this.zbn;
      if (localObject1 == null) {
        p.bGy("btnContainer");
      }
      j = k - j - ((LinearLayout)localObject1).getHeight() - ax.aB((Context)getContext()) - (int)getActivity().getResources().getDimension(b.d.Edge_3A);
      Log.i(this.TAG, "totalHeight " + k + " bottom " + i + ", maxBottom " + j + ", " + this.pIk + ' ');
      localObject1 = this.yOO;
      if (localObject1 == null) {
        p.bGy("bottomSpace");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break label386;
      }
      localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(277931);
      throw ((Throwable)localObject1);
      i = 0;
      break;
      label320:
      localObject1 = this.yOP;
      if (localObject1 == null) {
        p.bGy("edtContainer");
      }
      ((View)localObject1).getLocationInWindow(arrayOfInt);
      j = arrayOfInt[1];
      localObject2 = this.yOP;
      localObject1 = localObject2;
      i = j;
      if (localObject2 == null)
      {
        p.bGy("edtContainer");
        localObject1 = localObject2;
        i = j;
      }
    }
    label386:
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    localObject2 = this.TAG;
    Object localObject3 = new StringBuilder("bottom height ");
    View localView = this.yOO;
    if (localView == null) {
      p.bGy("bottomSpace");
    }
    Log.i((String)localObject2, localView.getHeight());
    localObject2 = new aa.d();
    ((aa.d)localObject2).aaBA = (i - j);
    if (((aa.d)localObject2).aaBA > 0)
    {
      localObject3 = this.yOO;
      if (localObject3 == null) {
        p.bGy("bottomSpace");
      }
      ((LinearLayout.LayoutParams)localObject1).height = (((View)localObject3).getHeight() + ((aa.d)localObject2).aaBA);
      localObject3 = this.yOO;
      if (localObject3 == null) {
        p.bGy("bottomSpace");
      }
      ((View)localObject3).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.yOO;
      if (localObject1 == null) {
        p.bGy("bottomSpace");
      }
      ((View)localObject1).requestLayout();
      localObject1 = this.yOO;
      if (localObject1 == null) {
        p.bGy("bottomSpace");
      }
      ((View)localObject1).post((Runnable)new a(this, (aa.d)localObject2));
    }
    if (this.pIk > 0)
    {
      localObject1 = this.zbn;
      if (localObject1 == null) {
        p.bGy("btnContainer");
      }
      ((LinearLayout)localObject1).getLocationInWindow(arrayOfInt);
      i = arrayOfInt[1];
      localObject1 = this.zbn;
      if (localObject1 == null) {
        p.bGy("btnContainer");
      }
      j = ((LinearLayout)localObject1).getHeight();
      float f1 = k - this.pIk;
      float f2 = getActivity().getResources().getDimension(b.d.Edge_2A);
      float f3 = ax.aB((Context)getContext());
      f1 = j + i - (f1 - f2 - f3);
      if (f1 > 0.0F)
      {
        localObject1 = this.zbn;
        if (localObject1 == null) {
          p.bGy("btnContainer");
        }
        localObject1 = ((LinearLayout)localObject1).getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(277931);
          throw ((Throwable)localObject1);
        }
        localObject1 = (FrameLayout.LayoutParams)localObject1;
        i = ((FrameLayout.LayoutParams)localObject1).bottomMargin;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)f1 + i);
        localObject2 = this.zbn;
        if (localObject2 == null) {
          p.bGy("btnContainer");
        }
        ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    AppMethodBeat.o(277931);
  }
  
  public final void A(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(277932);
    this.pIk = paramInt;
    if (paramInt > 0)
    {
      dFO();
      localObject1 = this.yOP;
      if (localObject1 == null) {
        p.bGy("edtContainer");
      }
      ((View)localObject1).addOnLayoutChangeListener(this.yPg);
      AppMethodBeat.o(277932);
      return;
    }
    dFO();
    Object localObject1 = this.jbL;
    if (localObject1 == null) {
      p.bGy("scrollView");
    }
    ((ScrollView)localObject1).scrollTo(0, 0);
    localObject1 = this.yOO;
    if (localObject1 == null) {
      p.bGy("bottomSpace");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(277932);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject1).height = 0;
    ((LinearLayout.LayoutParams)localObject1).weight = 1.0F;
    Object localObject2 = this.yOO;
    if (localObject2 == null) {
      p.bGy("bottomSpace");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.yOO;
    if (localObject1 == null) {
      p.bGy("bottomSpace");
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.yOP;
    if (localObject1 == null) {
      p.bGy("edtContainer");
    }
    ((View)localObject1).removeOnLayoutChangeListener(this.yPg);
    localObject1 = this.zbn;
    if (localObject1 == null) {
      p.bGy("btnContainer");
    }
    localObject1 = ((LinearLayout)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(277932);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).bottomMargin = Math.max(this.zbq, 0);
    localObject2 = this.zbn;
    if (localObject2 == null) {
      p.bGy("btnContainer");
    }
    ((LinearLayout)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    AppMethodBeat.o(277932);
  }
  
  public final MMEditText dFM()
  {
    AppMethodBeat.i(277924);
    MMEditText localMMEditText = this.zbm;
    if (localMMEditText == null) {
      p.bGy("descTv");
    }
    AppMethodBeat.o(277924);
    return localMMEditText;
  }
  
  public final LinearLayout dFN()
  {
    AppMethodBeat.i(277926);
    LinearLayout localLinearLayout = this.zbn;
    if (localLinearLayout == null) {
      p.bGy("btnContainer");
    }
    AppMethodBeat.o(277926);
    return localLinearLayout;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(277929);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("DESC");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.desc = paramBundle;
    paramBundle = getActivity().findViewById(b.f.bottom_space);
    p.j(paramBundle, "activity.findViewById(R.id.bottom_space)");
    this.yOO = paramBundle;
    paramBundle = getActivity().findViewById(b.f.edt_container);
    p.j(paramBundle, "activity.findViewById(R.id.edt_container)");
    this.yOP = paramBundle;
    paramBundle = getActivity().findViewById(b.f.scroll_view);
    p.j(paramBundle, "activity.findViewById(R.id.scroll_view)");
    this.jbL = ((ScrollView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.post_desc_edt);
    p.j(paramBundle, "activity.findViewById(R.id.post_desc_edt)");
    this.zbm = ((MMEditText)paramBundle);
    paramBundle = getActivity().findViewById(b.f.textcount_hint);
    p.j(paramBundle, "activity.findViewById(R.id.textcount_hint)");
    this.yOA = ((TextView)paramBundle);
    paramBundle = getActivity().findViewById(b.f.ok_btn_container);
    p.j(paramBundle, "activity.findViewById(R.id.ok_btn_container)");
    this.zbn = ((LinearLayout)paramBundle);
    paramBundle = getActivity();
    if (paramBundle == null)
    {
      paramBundle = new t("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(277929);
      throw paramBundle;
    }
    this.jij = new com.tencent.mm.ui.tools.i((Activity)paramBundle);
    paramBundle = this.jij;
    if (paramBundle == null) {
      p.bGy("keyboardHeightProvider");
    }
    paramBundle.setKeyboardHeightObserver((h)this);
    paramBundle = (InputFilter)f.zbt;
    localObject = (InputFilter)new g(this, this.zbo, g.a.XSu);
    MMEditText localMMEditText = this.zbm;
    if (localMMEditText == null) {
      p.bGy("descTv");
    }
    localMMEditText.setFilters(new InputFilter[] { paramBundle, localObject });
    paramBundle = (TextWatcher)new h(this);
    localObject = this.zbm;
    if (localObject == null) {
      p.bGy("descTv");
    }
    ((MMEditText)localObject).addTextChangedListener(paramBundle);
    paramBundle = this.zbm;
    if (paramBundle == null) {
      p.bGy("descTv");
    }
    paramBundle.setText((CharSequence)this.desc);
    paramBundle = this.jbL;
    if (paramBundle == null) {
      p.bGy("scrollView");
    }
    paramBundle.setOnTouchListener((View.OnTouchListener)new c(this));
    paramBundle = this.zbn;
    if (paramBundle == null) {
      p.bGy("btnContainer");
    }
    paramBundle.post((Runnable)new d(this));
    AppMethodBeat.o(277929);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(277934);
    super.onPause();
    com.tencent.mm.ui.tools.i locali = this.jij;
    if (locali == null) {
      p.bGy("keyboardHeightProvider");
    }
    locali.close();
    AppMethodBeat.o(277934);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(277933);
    super.onResume();
    MMEditText localMMEditText = this.zbm;
    if (localMMEditText == null) {
      p.bGy("descTv");
    }
    localMMEditText.post((Runnable)new e(this));
    AppMethodBeat.o(277933);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class a
    implements Runnable
  {
    a(d paramd, aa.d paramd1) {}
    
    public final void run()
    {
      AppMethodBeat.i(276486);
      ScrollView localScrollView = this.zbr.jbL;
      if (localScrollView == null) {
        p.bGy("scrollView");
      }
      localScrollView.scrollBy(0, this.zbs.aaBA);
      AppMethodBeat.o(276486);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "onLayoutChange"})
  static final class b
    implements View.OnLayoutChangeListener
  {
    b(d paramd) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(232541);
      Log.i(d.a(this.zbr), "oldBottom " + paramInt8 + ", bottom " + paramInt4);
      if (paramInt8 != paramInt4) {
        d.c(this.zbr);
      }
      AppMethodBeat.o(232541);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "motionEvent", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(d paramd) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(234671);
      if (this.zbr.pIk > 0)
      {
        paramView = this.zbr.getActivity();
        if (paramView == null)
        {
          paramView = new t("null cannot be cast to non-null type com.tencent.mm.ui.MMActivity");
          AppMethodBeat.o(234671);
          throw paramView;
        }
        ((MMActivity)paramView).hideVKB();
      }
      AppMethodBeat.o(234671);
      return false;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class d
    implements Runnable
  {
    d(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(244672);
      Object localObject = new int[2];
      View localView = this.zbr.yOO;
      if (localView == null) {
        p.bGy("bottomSpace");
      }
      localView.getLocationInWindow((int[])localObject);
      int i = localObject[1];
      this.zbr.dFN().getLocationInWindow((int[])localObject);
      int j = localObject[1];
      if (i > 0)
      {
        i = j - i;
        if (i < 0)
        {
          Log.i(d.a(this.zbr), "adjust postBtnMaxMarginBottom, from:" + this.zbr.zbq + ", to:" + (this.zbr.zbq + i - (int)this.zbr.getResources().getDimension(b.d.Edge_3A)));
          this.zbr.zbq = (i + this.zbr.zbq - (int)this.zbr.getResources().getDimension(b.d.Edge_3A));
          localObject = this.zbr.dFN().getLayoutParams();
          if (localObject == null)
          {
            localObject = new t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            AppMethodBeat.o(244672);
            throw ((Throwable)localObject);
          }
          localObject = (FrameLayout.LayoutParams)localObject;
          ((FrameLayout.LayoutParams)localObject).bottomMargin = Math.max(this.zbr.zbq, 0);
          this.zbr.dFN().setLayoutParams((ViewGroup.LayoutParams)localObject);
          AppMethodBeat.o(244672);
        }
      }
      else
      {
        localObject = this.zbr.dFN().findViewById(b.f.game_post_license_container);
        p.j(localObject, "btnContainer.findViewByI…e_post_license_container)");
        if (((View)localObject).getVisibility() == 0) {
          this.zbr.zbq = ((int)this.zbr.getResources().getDimension(b.d.Edge_8A));
        }
      }
      AppMethodBeat.o(244672);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class e
    implements Runnable
  {
    e(d paramd) {}
    
    public final void run()
    {
      AppMethodBeat.i(272756);
      d.b(this.zbr).start();
      AppMethodBeat.o(272756);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class f
    implements InputFilter
  {
    public static final f zbt;
    
    static
    {
      AppMethodBeat.i(287121);
      zbt = new f();
      AppMethodBeat.o(287121);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(287120);
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(287120);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(287120);
        return paramCharSequence;
      }
      AppMethodBeat.o(287120);
      return null;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC$setInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder_release"})
  public static final class g
    extends g
  {
    g(int paramInt, g.a parama)
    {
      super(locala);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(273609);
      CharSequence localCharSequence;
      if (paramSpanned != null)
      {
        paramInt2 = paramSpanned.length();
        if (paramInt2 <= paramInt3) {
          break label203;
        }
        if (paramSpanned == null) {
          break label197;
        }
        localCharSequence = paramSpanned.subSequence(0, paramInt3);
        label41:
        paramInt2 = g.a(String.valueOf(localCharSequence), g.a.XSu);
        label53:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label218;
        }
      }
      label197:
      label203:
      label218:
      for (paramInt3 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.XSu);; paramInt3 = 0)
      {
        paramInt4 = g.a(String.valueOf(paramCharSequence), g.a.XSu);
        int i = this.zbr.zbo;
        int j = g.bAE(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= this.zbr.zbo) {
          break label242;
        }
        paramInt2 = kotlin.k.i.ov(i - paramInt2 - paramInt3 - j, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label224;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(273609);
        return paramCharSequence;
        paramInt2 = 0;
        break;
        localCharSequence = null;
        break label41;
        paramInt2 = g.a(String.valueOf(paramSpanned), g.a.XSu);
        break label53;
      }
      label224:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(273609);
      return paramCharSequence;
      label242:
      if (paramCharSequence == null) {
        paramCharSequence = (CharSequence)"";
      }
      for (;;)
      {
        AppMethodBeat.o(273609);
        return paramCharSequence;
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC$setInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class h
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(281150);
      this.zbr.zbp = (g.dq(this.zbr.zbo, String.valueOf(paramEditable)) / 2);
      TextView localTextView = this.zbr.yOA;
      if (localTextView == null) {
        p.bGy("textCountTv");
      }
      if (this.zbr.zbp >= 0) {}
      for (paramEditable = (CharSequence)String.valueOf(this.zbr.zbp);; paramEditable = (CharSequence)"0")
      {
        localTextView.setText(paramEditable);
        AppMethodBeat.o(281150);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.d
 * JD-Core Version:    0.7.0.1
 */