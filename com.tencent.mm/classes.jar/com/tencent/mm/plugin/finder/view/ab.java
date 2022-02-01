package com.tencent.mm.plugin.finder.view;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.h;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.h;
import com.tencent.mm.ui.widget.a.h.b;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage;", "Lcom/tencent/mm/ui/widget/dialog/MMCustomHalfBottomDialog$CustomBottomSheetPage;", "callback", "Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "(Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;)V", "getCallback", "()Lcom/tencent/mm/plugin/finder/view/GameTeamSelectCoinBottomPage$Callback;", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "maxValue", "", "getMaxValue", "()I", "setMaxValue", "(I)V", "rootView", "Landroid/view/ViewGroup;", "getView", "Landroid/view/View;", "root", "onPagePopped", "", "onPagePushed", "Companion", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ab
  extends h.b
{
  public static final ab.a GEx;
  private final ac.a GEy;
  private i lKz;
  int pxI;
  private ViewGroup pzj;
  
  static
  {
    AppMethodBeat.i(344812);
    GEx = new ab.a((byte)0);
    AppMethodBeat.o(344812);
  }
  
  public ab(ac.a parama)
  {
    AppMethodBeat.i(344706);
    this.GEy = parama;
    AppMethodBeat.o(344706);
  }
  
  private static final void a(View paramView1, ab paramab, View paramView2)
  {
    AppMethodBeat.i(344751);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramab);
    localb.cH(paramView2);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    if (paramView1 != null)
    {
      localObject = (MMEditText)paramView1.findViewById(p.e.BCo);
      if (localObject != null)
      {
        ((MMEditText)localObject).clearFocus();
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
      paramView1.postDelayed(new ab..ExternalSyntheticLambda6(paramab), 300L);
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344751);
      return;
    }
  }
  
  private static final void a(ab paramab)
  {
    AppMethodBeat.i(344741);
    s.u(paramab, "this$0");
    paramab.jHR();
    AppMethodBeat.o(344741);
  }
  
  private static final void a(ab paramab, int paramInt, boolean paramBoolean)
  {
    AppMethodBeat.i(344790);
    s.u(paramab, "this$0");
    Log.i("MicroMsg.GameTeamInputCoinValueBottomPage", "KeyboardHeightObserver " + paramInt + ' ' + paramBoolean);
    paramab = paramab.JfN;
    if (paramab != null)
    {
      paramab = paramab.getWindow();
      if (paramab != null)
      {
        paramab = paramab.getDecorView();
        if (paramab != null) {
          paramab.setPadding(0, 0, 0, paramInt);
        }
      }
    }
    AppMethodBeat.o(344790);
  }
  
  private static final void a(MMEditText paramMMEditText, ab paramab)
  {
    AppMethodBeat.i(344804);
    s.u(paramMMEditText, "$editText");
    s.u(paramab, "this$0");
    paramMMEditText.requestFocus();
    paramMMEditText.setSelection(paramMMEditText.getText().length());
    paramab = paramab.pzj;
    if (paramab == null)
    {
      paramab = null;
      if (!(paramab instanceof MMActivity)) {
        break label100;
      }
      paramab = (MMActivity)paramab;
    }
    for (;;)
    {
      if (paramab != null)
      {
        paramab = paramab.getSystemService("input_method");
        if (paramab == null)
        {
          paramMMEditText = new NullPointerException("null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
          AppMethodBeat.o(344804);
          throw paramMMEditText;
          paramab = paramab.getContext();
          break;
          label100:
          paramab = null;
          continue;
        }
        ((InputMethodManager)paramab).showSoftInput((View)paramMMEditText, 0);
      }
    }
    AppMethodBeat.o(344804);
  }
  
  private static final void a(MMEditText paramMMEditText, ab paramab, View paramView)
  {
    AppMethodBeat.i(344730);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramMMEditText);
    localb.cH(paramab);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramMMEditText, "$this_apply");
    s.u(paramab, "this$0");
    if (paramView.isEnabled()) {
      if (((CharSequence)paramMMEditText.getText().toString()).length() <= 0) {
        break label148;
      }
    }
    label148:
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        paramab.GEy.UK(Integer.parseInt(paramMMEditText.getText().toString()));
      }
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344730);
      return;
    }
  }
  
  private static final boolean a(View paramView, ab paramab, MMEditText paramMMEditText, TextView paramTextView, int paramInt, KeyEvent paramKeyEvent)
  {
    AppMethodBeat.i(344717);
    s.u(paramab, "this$0");
    s.u(paramMMEditText, "$this_apply");
    if ((paramInt == 6) && (((Button)paramView.findViewById(p.e.button)).isEnabled())) {
      paramab.GEy.UK(Integer.parseInt(paramMMEditText.getText().toString()));
    }
    AppMethodBeat.o(344717);
    return false;
  }
  
  private static final void b(View paramView1, ab paramab, View paramView2)
  {
    AppMethodBeat.i(344775);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramView1);
    localb.cH(paramab);
    localb.cH(paramView2);
    a.c("com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramab, "this$0");
    if (paramView1 != null)
    {
      localObject = (MMEditText)paramView1.findViewById(p.e.BCo);
      if (localObject != null)
      {
        ((MMEditText)localObject).clearFocus();
        paramView2 = paramView1.getContext();
        if (!(paramView2 instanceof MMActivity)) {
          break label157;
        }
      }
    }
    label157:
    for (paramView2 = (MMActivity)paramView2;; paramView2 = null)
    {
      if (paramView2 != null) {
        paramView2.hideVKB((View)localObject);
      }
      paramView1.postDelayed(new ab..ExternalSyntheticLambda5(paramab), 300L);
      a.a(new Object(), "com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(344775);
      return;
    }
  }
  
  private static final void b(ab paramab)
  {
    AppMethodBeat.i(344764);
    s.u(paramab, "this$0");
    paramab.GEy.flC();
    AppMethodBeat.o(344764);
  }
  
  public final View E(final ViewGroup paramViewGroup)
  {
    AppMethodBeat.i(344920);
    s.u(paramViewGroup, "root");
    View localView = LayoutInflater.from(paramViewGroup.getContext()).inflate(p.f.CcH, paramViewGroup, false);
    Object localObject = (MMEditText)localView.findViewById(p.e.BCo);
    if (localObject != null)
    {
      ((MMEditText)localObject).setInputType(2);
      ((MMEditText)localObject).setKeyListener((KeyListener)DigitsKeyListener.getInstance("0123456789"));
      ((MMEditText)localObject).setImeOptions(6);
      ((MMEditText)localObject).setOnEditorActionListener(new ab..ExternalSyntheticLambda3(localView, this, (MMEditText)localObject));
      ((MMEditText)localObject).addTextChangedListener((TextWatcher)new b(localView, (MMEditText)localObject, this, paramViewGroup));
      Button localButton = (Button)localView.findViewById(p.e.button);
      localButton.setEnabled(false);
      localButton.setOnClickListener(new ab..ExternalSyntheticLambda2((MMEditText)localObject, this));
    }
    localView.findViewById(p.e.finder_live_back_btn).setOnClickListener(new ab..ExternalSyntheticLambda1(localView, this));
    ((WeImageView)localView.findViewById(p.e.BMg)).setOnClickListener(new ab..ExternalSyntheticLambda0(localView, this));
    ((TextView)localView.findViewById(p.e.BXU)).setText((CharSequence)paramViewGroup.getContext().getString(p.h.CgS, new Object[] { Integer.valueOf(this.pxI) }));
    paramViewGroup = paramViewGroup.getContext();
    if (paramViewGroup == null)
    {
      paramViewGroup = new NullPointerException("null cannot be cast to non-null type android.app.Activity");
      AppMethodBeat.o(344920);
      throw paramViewGroup;
    }
    paramViewGroup = new i((Activity)paramViewGroup);
    paramViewGroup.afIL = new ab..ExternalSyntheticLambda4(this);
    localObject = ah.aiuX;
    this.lKz = paramViewGroup;
    this.pzj = ((ViewGroup)localView);
    s.s(localView, "rootView");
    AppMethodBeat.o(344920);
    return localView;
  }
  
  public final void eAM()
  {
    AppMethodBeat.i(344932);
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
      localObject = (MMEditText)((ViewGroup)localObject).findViewById(p.e.BCo);
      if (localObject != null) {
        ((MMEditText)localObject).postDelayed(new ab..ExternalSyntheticLambda7((MMEditText)localObject, this), 300L);
      }
    }
    AppMethodBeat.o(344932);
  }
  
  public final void flD()
  {
    AppMethodBeat.i(344946);
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
    AppMethodBeat.o(344946);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/view/GameTeamInputCoinValueBottomPage$getView$1$2", "Landroid/text/TextWatcher;", "afterTextChanged", "", "editable", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(View paramView, MMEditText paramMMEditText, ab paramab, ViewGroup paramViewGroup) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(345122);
      int i;
      Object localObject2;
      Object localObject1;
      ViewGroup localViewGroup;
      View localView;
      label105:
      label111:
      boolean bool;
      if (paramEditable == null)
      {
        i = -1;
        if ((i > 8) && (paramEditable != null)) {
          paramEditable.delete(paramEditable.length() - 1, paramEditable.length());
        }
        paramEditable = (TextView)this.aVR.findViewById(p.e.BXU);
        if (paramEditable != null)
        {
          localObject2 = this.Eoz;
          localObject1 = jdField_this;
          localViewGroup = paramViewGroup;
          localView = this.aVR;
          if (((CharSequence)((MMEditText)localObject2).getText().toString()).length() != 0) {
            break label225;
          }
          i = 1;
          if (i == 0) {
            break label230;
          }
          i = -1;
          if ((i == -1) || ((i <= ((ab)localObject1).pxI) && (i > 0))) {
            break label252;
          }
          paramEditable.setTextColor(localViewGroup.getContext().getResources().getColor(p.b.Red_100));
          localObject2 = localViewGroup.getContext();
          if (i > 0) {
            break label245;
          }
          i = p.h.CgT;
          label162:
          paramEditable.setText((CharSequence)((Context)localObject2).getString(i, new Object[] { Integer.valueOf(((ab)localObject1).pxI) }));
          paramEditable = (Button)localView.findViewById(p.e.button);
          label202:
          bool = false;
        }
      }
      for (;;)
      {
        paramEditable.setEnabled(bool);
        AppMethodBeat.o(345122);
        return;
        i = paramEditable.length();
        break;
        label225:
        i = 0;
        break label105;
        label230:
        i = Integer.parseInt(((MMEditText)localObject2).getText().toString());
        break label111;
        label245:
        i = p.h.CgR;
        break label162;
        label252:
        paramEditable.setTextColor(localViewGroup.getContext().getResources().getColor(p.b.BW_100_Alpha_0_5));
        paramEditable.setText((CharSequence)localViewGroup.getContext().getString(p.h.CgS, new Object[] { Integer.valueOf(((ab)localObject1).pxI) }));
        localObject1 = (Button)localView.findViewById(p.e.button);
        paramEditable = (Editable)localObject1;
        if (i == -1) {
          break label202;
        }
        bool = true;
        paramEditable = (Editable)localObject1;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.view.ab
 * JD-Core Version:    0.7.0.1
 */