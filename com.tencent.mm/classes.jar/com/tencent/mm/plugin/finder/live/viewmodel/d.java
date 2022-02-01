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
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.widget.ah;
import com.tencent.mm.plugin.finder.view.aa;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.component.k.b;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.Metadata;
import kotlin.g.b.ah.d;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/ui/tools/KeyboardHeightObserver;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "TAG", "", "bottomSpace", "Landroid/view/View;", "getBottomSpace", "()Landroid/view/View;", "setBottomSpace", "(Landroid/view/View;)V", "btnContainer", "Landroid/widget/LinearLayout;", "getBtnContainer", "()Landroid/widget/LinearLayout;", "setBtnContainer", "(Landroid/widget/LinearLayout;)V", "desc", "getDesc", "()Ljava/lang/String;", "setDesc", "(Ljava/lang/String;)V", "descTv", "Lcom/tencent/mm/ui/widget/MMEditText;", "getDescTv", "()Lcom/tencent/mm/ui/widget/MMEditText;", "setDescTv", "(Lcom/tencent/mm/ui/widget/MMEditText;)V", "edtContainer", "getEdtContainer", "setEdtContainer", "edtLayoutListener", "Landroid/view/View$OnLayoutChangeListener;", "keyboardHeight", "getKeyboardHeight", "setKeyboardHeight", "(I)V", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "postBtnMaxMarginBottom", "getPostBtnMaxMarginBottom", "setPostBtnMaxMarginBottom", "scrollView", "Landroid/widget/ScrollView;", "getScrollView", "()Landroid/widget/ScrollView;", "setScrollView", "(Landroid/widget/ScrollView;)V", "textCountTv", "Landroid/widget/TextView;", "getTextCountTv", "()Landroid/widget/TextView;", "setTextCountTv", "(Landroid/widget/TextView;)V", "textLeft", "getTextLeft", "setTextLeft", "checkNeedScroll", "", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onKeyboardHeightChanged", "height", "isResized", "", "onPause", "onResume", "setInputConfig", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
  extends UIComponent
  implements h
{
  public View DXr;
  public View DXs;
  public MMEditText DXt;
  public TextView DXu;
  public LinearLayout DXv;
  final int DXw;
  int DXx;
  private int DXy;
  private final View.OnLayoutChangeListener DXz;
  private final int MAX_INPUT_SIZE;
  private final String TAG;
  private String desc;
  public ScrollView lDL;
  private i lKz;
  private int sNb;
  
  public d(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(356178);
    this.TAG = "Finder.FinderGameLiveEditUIC";
    this.MAX_INPUT_SIZE = 60;
    this.DXw = (this.MAX_INPUT_SIZE * 2);
    this.DXx = this.MAX_INPUT_SIZE;
    this.desc = "";
    this.DXy = ((int)getResources().getDimension(p.c.Edge_12A));
    this.DXz = new d..ExternalSyntheticLambda1(this);
    AppMethodBeat.o(356178);
  }
  
  private static final void a(d paramd)
  {
    AppMethodBeat.i(356249);
    s.u(paramd, "this$0");
    Object localObject = new int[2];
    paramd.ewN().getLocationInWindow((int[])localObject);
    int i = localObject[1];
    paramd.ewR().getLocationInWindow((int[])localObject);
    int j = localObject[1];
    if (i > 0)
    {
      i = j - i;
      if (i < 0)
      {
        Log.i(paramd.TAG, "adjust postBtnMaxMarginBottom, from:" + paramd.DXy + ", to:" + (paramd.DXy + i - (int)paramd.getResources().getDimension(p.c.Edge_3A)));
        paramd.DXy = (i + paramd.DXy - (int)paramd.getResources().getDimension(p.c.Edge_3A));
        localObject = paramd.ewR().getLayoutParams();
        if (localObject == null)
        {
          paramd = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(356249);
          throw paramd;
        }
        localObject = (FrameLayout.LayoutParams)localObject;
        ((FrameLayout.LayoutParams)localObject).bottomMargin = Math.max(paramd.DXy, 0);
        paramd.ewR().setLayoutParams((ViewGroup.LayoutParams)localObject);
        AppMethodBeat.o(356249);
      }
    }
    else if (paramd.ewR().findViewById(p.e.BUZ).getVisibility() == 0)
    {
      paramd.DXy = ((int)paramd.getResources().getDimension(p.c.Edge_8A));
    }
    AppMethodBeat.o(356249);
  }
  
  private static final void a(d paramd, View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
  {
    AppMethodBeat.i(356280);
    s.u(paramd, "this$0");
    Log.i(paramd.TAG, "oldBottom " + paramInt8 + ", bottom " + paramInt4);
    if (paramInt8 != paramInt4) {
      paramd.ewS();
    }
    AppMethodBeat.o(356280);
  }
  
  private static final void a(d paramd, ah.d paramd1)
  {
    AppMethodBeat.i(356260);
    s.u(paramd, "this$0");
    s.u(paramd1, "$distance");
    paramd.ewP().scrollBy(0, paramd1.aixb);
    AppMethodBeat.o(356260);
  }
  
  private static final boolean a(d paramd, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(356237);
    s.u(paramd, "this$0");
    if (paramd.sNb > 0) {
      ((MMActivity)paramd.getActivity()).hideVKB();
    }
    AppMethodBeat.o(356237);
    return false;
  }
  
  private static final CharSequence b(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
  {
    AppMethodBeat.i(356286);
    paramCharSequence = paramCharSequence.toString();
    paramSpanned = (CharSequence)"\n";
    if (paramCharSequence == null)
    {
      paramCharSequence = new NullPointerException("null cannot be cast to non-null type java.lang.String");
      AppMethodBeat.o(356286);
      throw paramCharSequence;
    }
    if (paramCharSequence.contentEquals(paramSpanned))
    {
      paramCharSequence = (CharSequence)"";
      AppMethodBeat.o(356286);
      return paramCharSequence;
    }
    AppMethodBeat.o(356286);
    return null;
  }
  
  private static final void b(d paramd)
  {
    AppMethodBeat.i(356270);
    s.u(paramd, "this$0");
    i locali = paramd.lKz;
    paramd = locali;
    if (locali == null)
    {
      s.bIx("keyboardHeightProvider");
      paramd = null;
    }
    paramd.start();
    AppMethodBeat.o(356270);
  }
  
  private View ewN()
  {
    AppMethodBeat.i(356186);
    View localView = this.DXr;
    if (localView != null)
    {
      AppMethodBeat.o(356186);
      return localView;
    }
    s.bIx("bottomSpace");
    AppMethodBeat.o(356186);
    return null;
  }
  
  private View ewO()
  {
    AppMethodBeat.i(356196);
    View localView = this.DXs;
    if (localView != null)
    {
      AppMethodBeat.o(356196);
      return localView;
    }
    s.bIx("edtContainer");
    AppMethodBeat.o(356196);
    return null;
  }
  
  private ScrollView ewP()
  {
    AppMethodBeat.i(356203);
    ScrollView localScrollView = this.lDL;
    if (localScrollView != null)
    {
      AppMethodBeat.o(356203);
      return localScrollView;
    }
    s.bIx("scrollView");
    AppMethodBeat.o(356203);
    return null;
  }
  
  private LinearLayout ewR()
  {
    AppMethodBeat.i(356209);
    LinearLayout localLinearLayout = this.DXv;
    if (localLinearLayout != null)
    {
      AppMethodBeat.o(356209);
      return localLinearLayout;
    }
    s.bIx("btnContainer");
    AppMethodBeat.o(356209);
    return null;
  }
  
  private final void ewS()
  {
    AppMethodBeat.i(356228);
    Object localObject1 = new Point();
    getActivity().getWindowManager().getDefaultDisplay().getSize((Point)localObject1);
    int j = ((Point)localObject1).y;
    localObject1 = getActivity().findViewById(p.e.BVb);
    if (localObject1 == null)
    {
      i = 0;
      j = Math.max(j, i);
      localObject1 = new int[2];
      localObject2 = getActivity().findViewById(p.e.BVq);
      if (((View)localObject2).getVisibility() != 0) {
        break label269;
      }
      ((View)localObject2).getLocationInWindow((int[])localObject1);
      i = localObject1[1];
    }
    int k;
    for (int i = ((View)localObject2).getHeight() + i;; i = localObject1[1] + ewO().getHeight())
    {
      k = j - this.sNb - ewR().getHeight() - bf.bk((Context)getContext()) - (int)getActivity().getResources().getDimension(p.c.Edge_3A);
      Log.i(this.TAG, "totalHeight " + j + " bottom " + i + ", maxBottom " + k + ", " + this.sNb + ' ');
      localObject2 = ewN().getLayoutParams();
      if (localObject2 != null) {
        break label295;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(356228);
      throw ((Throwable)localObject1);
      i = ((View)localObject1).getHeight();
      break;
      label269:
      ewO().getLocationInWindow((int[])localObject1);
    }
    label295:
    Object localObject2 = (LinearLayout.LayoutParams)localObject2;
    Log.i(this.TAG, s.X("bottom height ", Integer.valueOf(ewN().getHeight())));
    ah.d locald = new ah.d();
    locald.aixb = (i - k);
    if (locald.aixb > 0)
    {
      ((LinearLayout.LayoutParams)localObject2).height = (ewN().getHeight() + locald.aixb);
      ewN().setLayoutParams((ViewGroup.LayoutParams)localObject2);
      ewN().requestLayout();
      ewN().post(new d..ExternalSyntheticLambda5(this, locald));
    }
    if (this.sNb > 0)
    {
      ewR().getLocationInWindow((int[])localObject1);
      i = localObject1[1];
      k = ewR().getHeight();
      float f1 = j - this.sNb;
      float f2 = getActivity().getResources().getDimension(p.c.Edge_2A);
      float f3 = bf.bk((Context)getContext());
      f1 = k + i - (f1 - f2 - f3);
      if (f1 > 0.0F)
      {
        localObject1 = ewR().getLayoutParams();
        if (localObject1 == null)
        {
          localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
          AppMethodBeat.o(356228);
          throw ((Throwable)localObject1);
        }
        localObject1 = (FrameLayout.LayoutParams)localObject1;
        i = ((FrameLayout.LayoutParams)localObject1).bottomMargin;
        ((FrameLayout.LayoutParams)localObject1).bottomMargin = ((int)f1 + i);
        ewR().setLayoutParams((ViewGroup.LayoutParams)localObject1);
      }
    }
    AppMethodBeat.o(356228);
  }
  
  public final MMEditText ewQ()
  {
    AppMethodBeat.i(356331);
    MMEditText localMMEditText = this.DXt;
    if (localMMEditText != null)
    {
      AppMethodBeat.o(356331);
      return localMMEditText;
    }
    s.bIx("descTv");
    AppMethodBeat.o(356331);
    return null;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(356345);
    super.onCreate(paramBundle);
    Object localObject = getIntent().getStringExtra("DESC");
    paramBundle = (Bundle)localObject;
    if (localObject == null) {
      paramBundle = "";
    }
    this.desc = paramBundle;
    paramBundle = getActivity().findViewById(p.e.bottom_space);
    s.s(paramBundle, "activity.findViewById(R.id.bottom_space)");
    s.u(paramBundle, "<set-?>");
    this.DXr = paramBundle;
    paramBundle = getActivity().findViewById(p.e.edt_container);
    s.s(paramBundle, "activity.findViewById(R.id.edt_container)");
    s.u(paramBundle, "<set-?>");
    this.DXs = paramBundle;
    paramBundle = getActivity().findViewById(p.e.scroll_view);
    s.s(paramBundle, "activity.findViewById(R.id.scroll_view)");
    paramBundle = (ScrollView)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.lDL = paramBundle;
    paramBundle = getActivity().findViewById(p.e.post_desc_edt);
    s.s(paramBundle, "activity.findViewById(R.id.post_desc_edt)");
    paramBundle = (MMEditText)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.DXt = paramBundle;
    paramBundle = getActivity().findViewById(p.e.textcount_hint);
    s.s(paramBundle, "activity.findViewById(R.id.textcount_hint)");
    paramBundle = (TextView)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.DXu = paramBundle;
    paramBundle = getActivity().findViewById(p.e.BYG);
    s.s(paramBundle, "activity.findViewById(R.id.ok_btn_container)");
    paramBundle = (LinearLayout)paramBundle;
    s.u(paramBundle, "<set-?>");
    this.DXv = paramBundle;
    this.lKz = new i((Activity)getActivity());
    paramBundle = this.lKz;
    if (paramBundle == null)
    {
      s.bIx("keyboardHeightProvider");
      paramBundle = null;
    }
    for (;;)
    {
      paramBundle.afIL = ((h)this);
      paramBundle = d..ExternalSyntheticLambda0.INSTANCE;
      localObject = (InputFilter)new a(this, this.DXw, g.a.afII);
      ewQ().setFilters(new InputFilter[] { paramBundle, localObject });
      paramBundle = (TextWatcher)new b(this);
      ewQ().addTextChangedListener(paramBundle);
      ewQ().setText((CharSequence)this.desc);
      ewP().setOnTouchListener(new d..ExternalSyntheticLambda2(this));
      ewR().post(new d..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(356345);
      return;
    }
  }
  
  public final void onKeyboardHeightChanged(int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(356359);
    Object localObject = com.tencent.mm.ui.component.k.aeZF;
    localObject = ((e)com.tencent.mm.ui.component.k.nq((Context)getContext()).q(e.class)).DXJ;
    if (localObject != null)
    {
      localObject = ((ah)localObject).EqP;
      if ((localObject == null) || (((aa)localObject).isShowing() != true)) {}
    }
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(356359);
      return;
    }
    this.sNb = paramInt;
    if (paramInt > 0)
    {
      ewS();
      ewO().addOnLayoutChangeListener(this.DXz);
      AppMethodBeat.o(356359);
      return;
    }
    ewS();
    ewP().scrollTo(0, 0);
    localObject = ewN().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(356359);
      throw ((Throwable)localObject);
    }
    localObject = (LinearLayout.LayoutParams)localObject;
    ((LinearLayout.LayoutParams)localObject).height = 0;
    ((LinearLayout.LayoutParams)localObject).weight = 1.0F;
    ewN().setLayoutParams((ViewGroup.LayoutParams)localObject);
    ewN().requestLayout();
    ewO().removeOnLayoutChangeListener(this.DXz);
    localObject = ewR().getLayoutParams();
    if (localObject == null)
    {
      localObject = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(356359);
      throw ((Throwable)localObject);
    }
    localObject = (FrameLayout.LayoutParams)localObject;
    ((FrameLayout.LayoutParams)localObject).bottomMargin = Math.max(this.DXy, 0);
    ewR().setLayoutParams((ViewGroup.LayoutParams)localObject);
    AppMethodBeat.o(356359);
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(356376);
    super.onPause();
    i locali2 = this.lKz;
    i locali1 = locali2;
    if (locali2 == null)
    {
      s.bIx("keyboardHeightProvider");
      locali1 = null;
    }
    locali1.close();
    AppMethodBeat.o(356376);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(356369);
    super.onResume();
    ewQ().post(new d..ExternalSyntheticLambda4(this));
    AppMethodBeat.o(356369);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC$setInputConfig$filters$2", "Lcom/tencent/mm/ui/tools/InputTextLengthFilter;", "filter", "", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "destStart", "destEnd", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    extends g
  {
    a(d paramd, int paramInt, g.a parama)
    {
      super(parama);
    }
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(356126);
      Object localObject;
      if (paramSpanned == null)
      {
        paramInt2 = 0;
        if (paramInt2 <= paramInt3) {
          break label203;
        }
        if (paramSpanned != null) {
          break label188;
        }
        localObject = null;
        label26:
        paramInt2 = g.a(String.valueOf(localObject), g.a.afII);
        label38:
        if ((paramSpanned == null) || (paramSpanned.length() <= paramInt4)) {
          break label218;
        }
      }
      label188:
      label203:
      label218:
      for (paramInt3 = g.a(paramSpanned.subSequence(paramInt4, paramSpanned.length()).toString(), g.a.afII);; paramInt3 = 0)
      {
        paramInt4 = g.a(String.valueOf(paramCharSequence), g.a.afII);
        int i = this.DXA.DXw;
        int j = g.bCA(String.valueOf(paramCharSequence));
        if (paramInt3 + (paramInt2 + paramInt4) <= this.DXA.DXw) {
          break label242;
        }
        paramInt2 = kotlin.k.k.qu(i - paramInt2 - paramInt3 - j, 0);
        if ((paramCharSequence != null) && (paramInt1 >= 0) && (paramCharSequence.length() >= paramInt1 + paramInt2)) {
          break label224;
        }
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(356126);
        return paramCharSequence;
        paramInt2 = paramSpanned.length();
        break;
        localObject = paramSpanned.subSequence(0, paramInt3);
        break label26;
        paramInt2 = g.a(String.valueOf(paramSpanned), g.a.afII);
        break label38;
      }
      label224:
      paramCharSequence = paramCharSequence.subSequence(paramInt1, paramInt2 + paramInt1);
      AppMethodBeat.o(356126);
      return paramCharSequence;
      label242:
      if (paramCharSequence == null)
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(356126);
        return paramCharSequence;
      }
      AppMethodBeat.o(356126);
      return paramCharSequence;
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/live/viewmodel/FinderGameLiveEditUIC$setInputConfig$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(d paramd) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(356125);
      this.DXA.DXx = (g.ej(this.DXA.DXw, String.valueOf(paramEditable)) / 2);
      paramEditable = this.DXA.DXu;
      if (paramEditable != null) {
        if (this.DXA.DXx < 0) {
          break label85;
        }
      }
      label85:
      for (CharSequence localCharSequence = (CharSequence)String.valueOf(this.DXA.DXx);; localCharSequence = (CharSequence)"0")
      {
        paramEditable.setText(localCharSequence);
        AppMethodBeat.o(356125);
        return;
        s.bIx("textCountTv");
        paramEditable = null;
        break;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.d
 * JD-Core Version:    0.7.0.1
 */