package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.text.Editable;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.ui.widget.a.h.b;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "callback", "Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Callback;", "(Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Callback;)V", "TAG", "", "getTAG", "()Ljava/lang/String;", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/LiveChargeBottomSheet$Callback;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "maxValue", "", "getMaxValue", "()I", "setMaxValue", "(I)V", "rootView", "Landroid/view/ViewGroup;", "getView", "Landroid/view/View;", "root", "isTextValueValid", "", "value", "onPagePopped", "", "onPagePushed", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class af
  extends h.b
{
  private final ae.a GFd;
  private final String TAG;
  private i lKz;
  private int pxI;
  private ViewGroup pzj;
  
  public af(ae.a parama)
  {
    AppMethodBeat.i(344610);
    this.GFd = parama;
    this.TAG = "LiveChargeInputCoinValueBottomPage";
    this.pxI = 4;
    AppMethodBeat.o(344610);
  }
  
  private static final void a(View paramView1, af paramaf, View paramView2)
  {
    AppMethodBeat.i(344642);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramaf);
    localb.cH(paramView2);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaf, "this$0");
    if (paramView1 != null)
    {
      localObject = (EditText)paramView1.findViewById(p.e.BCo);
      if (localObject != null)
      {
        ((EditText)localObject).clearFocus();
        paramView2 = paramView1.getContext();
        if (!(paramView2 instanceof MMActivity)) {
          break label155;
        }
      }
    }
    label155:
    for (paramView2 = (MMActivity)paramView2;; paramView2 = null)
    {
      if (paramView2 != null) {
        paramView2.hideVKB((View)localObject);
      }
      paramView1.postDelayed(new af..ExternalSyntheticLambda4(paramaf), 300L);
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344642);
      return;
    }
  }
  
  private static final void a(EditText paramEditText, af paramaf)
  {
    AppMethodBeat.i(344660);
    s.u(paramEditText, "$editText");
    s.u(paramaf, "this$0");
    paramEditText.requestFocus();
    paramEditText.setSelection(paramEditText.getText().length());
    Object localObject = paramaf.pzj;
    if (localObject == null)
    {
      localObject = null;
      if (!(localObject instanceof MMActivity)) {
        break label98;
      }
      localObject = (MMActivity)localObject;
    }
    for (;;)
    {
      if (localObject != null)
      {
        localObject = ((MMActivity)localObject).getSystemService("input_method");
        if (localObject == null)
        {
          paramEditText = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(344660);
          throw paramEditText;
          localObject = ((ViewGroup)localObject).getContext();
          break;
          label98:
          localObject = null;
          continue;
        }
        boolean bool = ((InputMethodManager)localObject).showSoftInput((View)paramEditText, 0);
        Log.i(paramaf.TAG, s.X("showSoftInput result:", Boolean.valueOf(bool)));
      }
    }
    AppMethodBeat.o(344660);
  }
  
  private static final void a(TextView paramTextView, af paramaf, EditText paramEditText, View paramView)
  {
    AppMethodBeat.i(344629);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramTextView);
    localb.cH(paramaf);
    localb.cH(paramEditText);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramaf, "this$0");
    s.u(paramEditText, "$this_apply");
    if ((paramTextView.isEnabled()) && (aCH(paramEditText.getText().toString()))) {
      paramaf.GFd.UK(Integer.parseInt(paramEditText.getText().toString()));
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/view/LiveChargeInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(344629);
  }
  
  private static final void a(af paramaf)
  {
    AppMethodBeat.i(344634);
    s.u(paramaf, "this$0");
    paramaf.jHR();
    AppMethodBeat.o(344634);
  }
  
  private static final void a(af paramaf, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344652);
    s.u(paramaf, "this$0");
    Log.i(paramaf.TAG, "KeyboardHeightObserver " + paramInt + ' ' + paramBoolean);
    paramaf = paramaf.JfN;
    if (paramaf != null)
    {
      paramaf = paramaf.getWindow();
      if (paramaf != null)
      {
        paramaf = paramaf.getDecorView();
        if (paramaf != null) {
          paramaf.setPadding(0, 0, 0, paramInt);
        }
      }
    }
    AppMethodBeat.o(344652);
  }
  
  static boolean aCH(String paramString)
  {
    AppMethodBeat.i(344620);
    CharSequence localCharSequence = (CharSequence)paramString;
    if ((localCharSequence == null) || (localCharSequence.length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      AppMethodBeat.o(344620);
      return false;
    }
    if (Util.safeParseInt(paramString) > 0)
    {
      AppMethodBeat.o(344620);
      return true;
    }
    AppMethodBeat.o(344620);
    return false;
  }
  
  public final View E(ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(344708);
    s.u(paramViewGroup, "root");
    final View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.Cdp, paramViewGroup, false);
    Object localObject1 = (EditText)localView.findViewById(p.e.BCo);
    if (localObject1 != null)
    {
      ((EditText)localObject1).setInputType(2);
      ((EditText)localObject1).setKeyListener((KeyListener)DigitsKeyListener.getInstance("0123456789"));
      ((EditText)localObject1).setImeOptions(6);
      Object localObject2 = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((EditText)localObject1, this.pxI, this.pxI, (kotlin.g.a.a)new a(this, (EditText)localObject1, localView));
      localObject2 = (TextView)localView.findViewById(p.e.button);
      ((TextView)localObject2).setEnabled(false);
      com.tencent.mm.plugin.finder.live.utils.a locala = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      s.s(localObject2, "button");
      com.tencent.mm.plugin.finder.live.utils.a.c((TextView)localObject2, false);
      ((TextView)localObject2).setOnClickListener(new af..ExternalSyntheticLambda1((TextView)localObject2, this, (EditText)localObject1));
    }
    localView.findViewById(p.e.finder_live_back_btn).setOnClickListener(new af..ExternalSyntheticLambda0(localView, this));
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(344708);
      throw paramViewGroup;
    }
    paramViewGroup = new i((Activity)paramViewGroup);
    paramViewGroup.afIL = new af..ExternalSyntheticLambda2(this);
    localObject1 = ah.aiuX;
    this.lKz = paramViewGroup;
    this.pzj = ((ViewGroup)localView);
    s.s(localView, "rootView");
    AppMethodBeat.o(344708);
    return localView;
  }
  
  public final void eAM()
  {
    AppMethodBeat.i(344713);
    super.eAM();
    Object localObject = this.JfN;
    if (localObject != null)
    {
      localObject = ((h)localObject).getWindow();
      if (localObject != null) {
        ((Window)localObject).setSoftInputMode(48);
      }
    }
    localObject = this.lKz;
    if (localObject != null) {
      ((i)localObject).start();
    }
    localObject = this.pzj;
    if (localObject != null)
    {
      localObject = (EditText)((ViewGroup)localObject).findViewById(p.e.BCo);
      if (localObject != null) {
        ((EditText)localObject).postDelayed(new af..ExternalSyntheticLambda3((EditText)localObject, this), 300L);
      }
    }
    AppMethodBeat.o(344713);
  }
  
  public final void flD()
  {
    AppMethodBeat.i(344720);
    super.flD();
    Object localObject = this.lKz;
    if (localObject != null) {
      ((i)localObject).close();
    }
    localObject = this.JfN;
    if (localObject != null)
    {
      localObject = ((h)localObject).getWindow();
      if (localObject != null)
      {
        localObject = ((Window)localObject).getDecorView();
        if (localObject != null) {
          ((View)localObject).setPadding(0, 0, 0, 0);
        }
      }
    }
    AppMethodBeat.o(344720);
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements kotlin.g.a.a<ah>
  {
    a(af paramaf, EditText paramEditText, View paramView)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.af
 * JD-Core Version:    0.7.0.1
 */