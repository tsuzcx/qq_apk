package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnLayoutChangeListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.cgi.di;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.c;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.service.r;
import com.tencent.mm.plugin.findersdk.a.ck;
import com.tencent.mm.pluginsdk.ui.span.t;
import com.tencent.mm.protocal.protobuf.bqe;
import com.tencent.mm.protocal.protobuf.bys;
import com.tencent.mm.protocal.protobuf.djg;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.y;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.Metadata;
import kotlin.g.b.ah.f;
import kotlin.n.n;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "modifyBtn", "Landroid/widget/Button;", "modifyCountDialogTips", "modifyCountDialogTipsPlaceholder", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "checkEmptyLine", "", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfirmClick", "name", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "superImportUIComponents", "set", "Ljava/util/HashSet;", "Ljava/lang/Class;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lkotlin/collections/HashSet;", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderModifyNameUI
  extends MMFinderUI
  implements com.tencent.mm.am.h, ck<bqe>, com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.ui.widget.c.a
{
  private View DXs;
  private ProgressDialog FPA;
  private int FPD;
  private View FPq;
  private InputPanelFrameLayout FPr;
  private View FPs;
  private TextView FPt;
  private EditText FSo;
  private TextView FSp;
  private Button FSq;
  private TextView FSr;
  private String FSs;
  private String FSt;
  private com.tencent.mm.plugin.finder.api.m FSu;
  private int FSv;
  private final int FSw;
  private final a FSx;
  private final String TAG;
  private ScrollView lDL;
  private int sNb;
  private int scene;
  private TextView titleTv;
  
  public FinderModifyNameUI()
  {
    AppMethodBeat.i(167455);
    this.TAG = "Finder.FinderModifyNameUI";
    this.FSs = "";
    this.FSt = "$nickname$";
    this.FPD = 20;
    this.FSv = 400;
    this.FSw = 20001;
    this.FSx = new a(this);
    AppMethodBeat.o(167455);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(347695);
    kotlin.g.b.s.u(paramTextView, "descTv");
    kotlin.g.b.s.u(paramSpannable, "text");
    paramTextView.setOnTouchListener(new FinderModifyNameUI..ExternalSyntheticLambda2(paramSpannable, paramTextView, this));
    AppMethodBeat.o(347695);
  }
  
  private static final void a(FinderModifyNameUI paramFinderModifyNameUI, View paramView)
  {
    com.tencent.mm.ui.widget.a.g.a locala = null;
    AppMethodBeat.i(347712);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderModifyNameUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    kotlin.g.b.s.u(paramFinderModifyNameUI, "this$0");
    paramView = com.tencent.mm.plugin.findersdk.d.a.Hdr;
    if (com.tencent.mm.plugin.findersdk.d.a.aDj("personalInfo"))
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347712);
      return;
    }
    Log.i(paramFinderModifyNameUI.TAG, "doClick create contact btn");
    localObject2 = new ah.f();
    localObject1 = paramFinderModifyNameUI.FSo;
    paramView = (View)localObject1;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("edit");
      paramView = null;
    }
    paramView = paramView.getText().toString();
    if (paramView == null)
    {
      paramFinderModifyNameUI = new NullPointerException("null cannot be cast to non-null type kotlin.CharSequence");
      AppMethodBeat.o(347712);
      throw paramFinderModifyNameUI;
    }
    ((ah.f)localObject2).aqH = n.bq((CharSequence)paramView).toString();
    localObject1 = ((ah.f)localObject2).aqH;
    paramView = paramFinderModifyNameUI.FSu;
    if (paramView == null)
    {
      paramView = locala;
      if (kotlin.g.b.s.p(localObject1, paramView)) {
        break label354;
      }
      if (paramFinderModifyNameUI.scene != 1) {
        break label331;
      }
      paramView = n.m(paramFinderModifyNameUI.FSs, paramFinderModifyNameUI.FSt, (String)((ah.f)localObject2).aqH, true);
      locala = new com.tencent.mm.ui.widget.a.g.a((Context)paramFinderModifyNameUI);
      locala.bDE(paramView).NF(true);
      locala.bDI(paramFinderModifyNameUI.getString(e.h.finder_confirm_change_name));
      locala.bDJ(paramFinderModifyNameUI.getString(e.h.finder_confirm_change_name_cancel));
      locala.b(new FinderModifyNameUI..ExternalSyntheticLambda4(paramFinderModifyNameUI, (ah.f)localObject2));
      locala.show();
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(347712);
      return;
      paramView = paramView.getNickname();
      break;
      label331:
      if (paramFinderModifyNameUI.scene == 2)
      {
        paramFinderModifyNameUI.aBb((String)((ah.f)localObject2).aqH);
        continue;
        label354:
        paramFinderModifyNameUI.finish();
      }
    }
  }
  
  private static final void a(FinderModifyNameUI paramFinderModifyNameUI, ah.f paramf, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(347701);
    kotlin.g.b.s.u(paramFinderModifyNameUI, "this$0");
    kotlin.g.b.s.u(paramf, "$name");
    kotlin.g.b.s.u(paramString, "s");
    paramFinderModifyNameUI.aBb((String)paramf.aqH);
    AppMethodBeat.o(347701);
  }
  
  private static final boolean a(Spannable paramSpannable, TextView paramTextView, FinderModifyNameUI paramFinderModifyNameUI, View paramView, MotionEvent paramMotionEvent)
  {
    AppMethodBeat.i(347735);
    kotlin.g.b.s.u(paramSpannable, "$text");
    kotlin.g.b.s.u(paramTextView, "$descTv");
    kotlin.g.b.s.u(paramFinderModifyNameUI, "this$0");
    int j = paramMotionEvent.getAction();
    if (paramView == null)
    {
      paramSpannable = new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
      AppMethodBeat.o(347735);
      throw paramSpannable;
    }
    paramView = (TextView)paramView;
    switch (j)
    {
    case 2: 
    default: 
      switch (j)
      {
      }
      break;
    }
    for (;;)
    {
      boolean bool = false;
      Log.i(paramFinderModifyNameUI.TAG, "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
      AppMethodBeat.o(347735);
      return bool;
      Object localObject1 = (ClickableSpan[])paramSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
      if (localObject1 == null) {
        break;
      }
      int k = localObject1.length;
      int i = 0;
      while (i < k)
      {
        Object localObject2 = localObject1[i];
        if ((localObject2 instanceof t))
        {
          ((t)localObject2).setIsPressed(false);
          paramTextView.invalidate();
        }
        i += 1;
      }
      i = (int)paramMotionEvent.getX();
      k = (int)paramMotionEvent.getY();
      int m = paramView.getPaddingLeft();
      int n = paramView.getPaddingTop();
      int i1 = paramView.getScrollX();
      int i2 = paramView.getScrollY();
      localObject1 = paramView.getLayout();
      i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
      localObject1 = (ClickableSpan[])paramSpannable.getSpans(i, i, ClickableSpan.class);
      if (localObject1.length != 0)
      {
        localObject1 = localObject1[0];
        switch (j)
        {
        }
        for (;;)
        {
          bool = true;
          break;
          ((ClickableSpan)localObject1).onClick((View)paramView);
          continue;
          if ((localObject1 instanceof t))
          {
            ((t)localObject1).setIsPressed(true);
            paramTextView.invalidate();
          }
          Selection.setSelection(paramSpannable, paramSpannable.getSpanStart(localObject1), paramSpannable.getSpanEnd(localObject1));
        }
      }
      Selection.removeSelection(paramSpannable);
    }
  }
  
  private static final boolean a(FinderModifyNameUI paramFinderModifyNameUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(347724);
    kotlin.g.b.s.u(paramFinderModifyNameUI, "this$0");
    paramFinderModifyNameUI.finish();
    AppMethodBeat.o(347724);
    return true;
  }
  
  private static final boolean a(FinderModifyNameUI paramFinderModifyNameUI, View paramView, MotionEvent paramMotionEvent)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    AppMethodBeat.i(347717);
    kotlin.g.b.s.u(paramFinderModifyNameUI, "this$0");
    EditText localEditText2 = paramFinderModifyNameUI.FSo;
    EditText localEditText1 = localEditText2;
    if (localEditText2 == null)
    {
      kotlin.g.b.s.bIx("edit");
      localEditText1 = null;
    }
    if (kotlin.g.b.s.p(paramView, localEditText1)) {}
    switch (paramMotionEvent.getActionMasked())
    {
    case 2: 
    default: 
      AppMethodBeat.o(347717);
      return false;
    case 0: 
      paramFinderModifyNameUI = paramFinderModifyNameUI.lDL;
      if (paramFinderModifyNameUI == null)
      {
        kotlin.g.b.s.bIx("scrollView");
        paramFinderModifyNameUI = localObject1;
      }
      for (;;)
      {
        paramFinderModifyNameUI.requestDisallowInterceptTouchEvent(true);
        break;
      }
    }
    paramFinderModifyNameUI = paramFinderModifyNameUI.lDL;
    if (paramFinderModifyNameUI == null)
    {
      kotlin.g.b.s.bIx("scrollView");
      paramFinderModifyNameUI = localObject2;
    }
    for (;;)
    {
      paramFinderModifyNameUI.requestDisallowInterceptTouchEvent(false);
      break;
    }
  }
  
  private final void aBb(String paramString)
  {
    AppMethodBeat.i(347663);
    Object localObject = "";
    switch (this.scene)
    {
    default: 
      AppMethodBeat.o(347663);
      return;
    case 1: 
      if (((CharSequence)paramString).length() == 0)
      {
        i = 1;
        if (i == 0) {
          break label127;
        }
        localObject = getString(e.h.finder_input_not_empty_tip, new Object[] { getString(e.h.finder_nickname) });
        kotlin.g.b.s.s(localObject, "getString(R.string.finde….string.finder_nickname))");
        label90:
        if (((CharSequence)localObject).length() <= 0) {
          break label213;
        }
      }
      break;
    }
    label213:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label218;
      }
      am((String)localObject, null, null);
      AppMethodBeat.o(347663);
      return;
      i = 0;
      break;
      label127:
      if (g.bCx(paramString) <= this.FPD) {
        break label90;
      }
      localObject = getString(e.h.finder_input_too_long_tip, new Object[] { getString(e.h.finder_nickname) });
      kotlin.g.b.s.s(localObject, "getString(R.string.finde….string.finder_nickname))");
      break label90;
      if (g.bCx(paramString) <= this.FSv) {
        break label90;
      }
      localObject = getString(e.h.finder_input_too_long_tip, new Object[] { getString(e.h.finder_signature) });
      kotlin.g.b.s.s(localObject, "getString(R.string.finde…string.finder_signature))");
      break label90;
    }
    label218:
    switch (this.scene)
    {
    }
    for (;;)
    {
      AppMethodBeat.o(347663);
      return;
      ((r)com.tencent.mm.kernel.h.ax(r.class)).d(paramString, (ck)this);
      this.FPA = ((ProgressDialog)com.tencent.mm.ui.base.k.a((Context)this, getString(e.h.app_updating), false, null));
      AppMethodBeat.o(347663);
      return;
      localObject = this.FSu;
      if (localObject == null) {}
      for (localObject = null; !kotlin.g.b.s.p(paramString, localObject); localObject = ((com.tencent.mm.plugin.finder.api.m)localObject).getSignature())
      {
        ((r)com.tencent.mm.kernel.h.ax(r.class)).e(paramString, (ck)this);
        this.FPA = ((ProgressDialog)com.tencent.mm.ui.base.k.a((Context)this, getString(e.h.app_updating), false, null));
        AppMethodBeat.o(347663);
        return;
      }
      finish();
    }
  }
  
  private final void am(String paramString1, String paramString2, String paramString3)
  {
    Object localObject1 = null;
    AppMethodBeat.i(347688);
    Log.i(this.TAG, kotlin.g.b.s.X("showError ", paramString1));
    Object localObject2 = com.tencent.mm.plugin.findersdk.a.k.PATTERN.matcher((CharSequence)paramString1);
    if (((Matcher)localObject2).find())
    {
      String str1 = ((Matcher)localObject2).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject2).start(0) > 0)
      {
        i = ((Matcher)localObject2).start(0);
        if (paramString1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347688);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        kotlin.g.b.s.s(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject2).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject2).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347688);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        kotlin.g.b.s.s(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      kotlin.g.b.s.s(paramString1, "sb.toString()");
      int i = ((Matcher)localObject2).start(0);
      int j = str1.length();
      localObject2 = new SpannableString((CharSequence)paramString1);
      kotlin.g.b.s.s(str1, "content");
      ((SpannableString)localObject2).setSpan(new com.tencent.mm.plugin.finder.view.q(str1, getContext().getResources().getColor(e.b.Link), getContext().getResources().getColor(e.b.Link_Alpha_0_6), (kotlin.g.a.b)new FinderModifyNameUI.e(this, paramString2, paramString3)), i, i + j, 17);
      paramString1 = this.FPt;
      if (paramString1 == null)
      {
        kotlin.g.b.s.bIx("topErrorTip");
        paramString1 = null;
        paramString1.setText((CharSequence)localObject2);
        paramString2 = this.FPt;
        paramString1 = paramString2;
        if (paramString2 == null)
        {
          kotlin.g.b.s.bIx("topErrorTip");
          paramString1 = null;
        }
        a(paramString1, (Spannable)localObject2);
        label372:
        paramString1 = this.FPt;
        if (paramString1 != null) {
          break label435;
        }
        kotlin.g.b.s.bIx("topErrorTip");
        paramString1 = localObject1;
      }
    }
    label435:
    for (;;)
    {
      paramString1.setVisibility(0);
      AppMethodBeat.o(347688);
      return;
      break;
      paramString3 = this.FPt;
      paramString2 = paramString3;
      if (paramString3 == null)
      {
        kotlin.g.b.s.bIx("topErrorTip");
        paramString2 = null;
      }
      paramString2.setText((CharSequence)paramString1);
      break label372;
    }
  }
  
  private final int getMaxLength()
  {
    switch (this.scene)
    {
    default: 
      return 2147483647;
    case 1: 
      return this.FPD;
    }
    return this.FSv;
  }
  
  private final void refreshView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167445);
    int i = com.tencent.mm.kernel.h.baE().ban().getInt(at.a.adbs, 0);
    Log.i(this.TAG, kotlin.g.b.s.X("user extFlag ", Integer.valueOf(i)));
    Object localObject;
    if (this.scene == 1)
    {
      if ((i & 0x2) == 0) {
        break label130;
      }
      i = 1;
      localObject = this.FSo;
      if (localObject != null) {
        break label135;
      }
      kotlin.g.b.s.bIx("edit");
      localObject = null;
      label75:
      if (i != 0) {
        break label138;
      }
      bool1 = true;
      label81:
      ((EditText)localObject).setEnabled(bool1);
      Button localButton = this.FSq;
      localObject = localButton;
      if (localButton == null)
      {
        kotlin.g.b.s.bIx("modifyBtn");
        localObject = null;
      }
      if (i != 0) {
        break label143;
      }
    }
    label130:
    label135:
    label138:
    label143:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Button)localObject).setEnabled(bool1);
      AppMethodBeat.o(167445);
      return;
      i = 0;
      break;
      break label75;
      bool1 = false;
      break label81;
    }
  }
  
  public final void Tw(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(167446);
    int i = g.ej(getMaxLength(), paramString);
    paramString = this.FSp;
    TextView localTextView;
    if (paramString == null)
    {
      kotlin.g.b.s.bIx("editLimit");
      paramString = null;
      paramString.setText((CharSequence)String.valueOf(i));
      localTextView = this.FSp;
      paramString = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("editLimit");
        paramString = null;
      }
      paramString.setTextColor(getResources().getColor(e.b.BW_0_Alpha_0_3));
      if (i > kotlin.k.k.qu((int)(getMaxLength() * 0.1F), 1)) {
        break label185;
      }
      localTextView = this.FSp;
      paramString = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("editLimit");
        paramString = null;
      }
      paramString.setVisibility(0);
      label126:
      paramString = this.FPt;
      if (paramString != null) {
        break label215;
      }
      kotlin.g.b.s.bIx("topErrorTip");
      paramString = null;
      label143:
      paramString.setText((CharSequence)"");
      paramString = this.FPt;
      if (paramString != null) {
        break label218;
      }
      kotlin.g.b.s.bIx("topErrorTip");
      paramString = localObject;
    }
    label185:
    label215:
    label218:
    for (;;)
    {
      paramString.setVisibility(8);
      AppMethodBeat.o(167446);
      return;
      break;
      localTextView = this.FSp;
      paramString = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("editLimit");
        paramString = null;
      }
      paramString.setVisibility(4);
      break label126;
      break label143;
    }
  }
  
  public final void Tx(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(347850);
    paramString = this.FSp;
    if (paramString == null)
    {
      kotlin.g.b.s.bIx("editLimit");
      paramString = null;
      paramString.setText((CharSequence)String.valueOf(getMaxLength()));
      paramString = this.FSp;
      if (paramString != null) {
        break label80;
      }
      kotlin.g.b.s.bIx("editLimit");
      paramString = localObject;
    }
    label80:
    for (;;)
    {
      paramString.setTextColor(getResources().getColor(e.b.BW_0_Alpha_0_3));
      AppMethodBeat.o(347850);
      return;
      break;
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final void eY(String paramString)
  {
    Object localObject = null;
    AppMethodBeat.i(167448);
    paramString = this.FSp;
    if (paramString == null)
    {
      kotlin.g.b.s.bIx("editLimit");
      paramString = null;
      paramString.setText((CharSequence)"0");
      TextView localTextView = this.FSp;
      paramString = localTextView;
      if (localTextView == null)
      {
        kotlin.g.b.s.bIx("editLimit");
        paramString = null;
      }
      paramString.setVisibility(0);
      paramString = this.FSp;
      if (paramString != null) {
        break label100;
      }
      kotlin.g.b.s.bIx("editLimit");
      paramString = localObject;
    }
    label100:
    for (;;)
    {
      paramString.setTextColor(getResources().getColor(e.b.Red_100));
      AppMethodBeat.o(167448);
      return;
      break;
    }
  }
  
  public final int getLayoutId()
  {
    return e.f.finder_modify_name_ui;
  }
  
  public final void initView()
  {
    Object localObject3 = null;
    AppMethodBeat.i(167444);
    setMMTitle("");
    setActionbarColor(getResources().getColor(e.b.white));
    getController().s((Activity)this, getResources().getColor(e.b.white));
    Object localObject1 = findViewById(e.e.finder_modify_name_container);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_modify_name_container)");
    this.DXs = ((View)localObject1);
    localObject1 = findViewById(e.e.finder_input_container);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_input_container)");
    this.FPs = ((View)localObject1);
    localObject1 = findViewById(e.e.finder_modify_title);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_modify_title)");
    this.titleTv = ((TextView)localObject1);
    localObject1 = findViewById(e.e.finder_edit);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_edit)");
    this.FSo = ((EditText)localObject1);
    localObject1 = findViewById(e.e.finder_edit_limit);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_edit_limit)");
    this.FSp = ((TextView)localObject1);
    localObject1 = findViewById(e.e.edt_bottom_space);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.edt_bottom_space)");
    this.FPq = ((View)localObject1);
    localObject1 = findViewById(e.e.finder_modify_btn);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.finder_modify_btn)");
    this.FSq = ((Button)localObject1);
    localObject1 = findViewById(e.e.modify_max_tip);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.modify_max_tip)");
    this.FSr = ((TextView)localObject1);
    localObject1 = findViewById(e.e.scroll_container);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.scroll_container)");
    this.lDL = ((ScrollView)localObject1);
    localObject1 = findViewById(e.e.input_panel);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.input_panel)");
    this.FPr = ((InputPanelFrameLayout)localObject1);
    localObject1 = findViewById(e.e.top_error_tip);
    kotlin.g.b.s.s(localObject1, "findViewById(R.id.top_error_tip)");
    this.FPt = ((TextView)localObject1);
    Object localObject2 = this.FSq;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("modifyBtn");
      localObject1 = null;
    }
    ((Button)localObject1).setOnClickListener(new FinderModifyNameUI..ExternalSyntheticLambda1(this));
    Object localObject4 = (TextWatcher)new b(this);
    localObject2 = this.FSo;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("edit");
      localObject1 = null;
    }
    ((EditText)localObject1).addTextChangedListener((TextWatcher)localObject4);
    localObject2 = this.FSo;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("edit");
      localObject1 = null;
    }
    ((EditText)localObject1).setOnTouchListener(new FinderModifyNameUI..ExternalSyntheticLambda3(this));
    setBackBtn(new FinderModifyNameUI..ExternalSyntheticLambda0(this));
    localObject1 = this.FPr;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("inputPanel");
      localObject1 = null;
      ((InputPanelFrameLayout)localObject1).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
      switch (this.scene)
      {
      default: 
        refreshView();
        localObject1 = this.FSo;
        if (localObject1 == null)
        {
          kotlin.g.b.s.bIx("edit");
          localObject1 = localObject3;
        }
        break;
      }
    }
    for (;;)
    {
      ((EditText)localObject1).requestFocus();
      AppMethodBeat.o(167444);
      return;
      break;
      localObject2 = this.FSo;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("edit");
        localObject1 = null;
      }
      ((EditText)localObject1).setMaxLines(2);
      localObject1 = this.FSo;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("edit");
        localObject1 = null;
        label533:
        localObject4 = (Context)getContext();
        localObject2 = this.FSu;
        if (localObject2 != null) {
          break label606;
        }
        localObject2 = null;
        label553:
        ((EditText)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)localObject2));
        localObject1 = this.titleTv;
        if (localObject1 != null) {
          break label614;
        }
        kotlin.g.b.s.bIx("titleTv");
        localObject1 = null;
      }
      label606:
      label614:
      for (;;)
      {
        ((TextView)localObject1).setText((CharSequence)getString(e.h.finder_modify_nickname_title));
        break;
        break label533;
        localObject2 = ((com.tencent.mm.plugin.finder.api.m)localObject2).getNickname();
        break label553;
      }
      localObject1 = this.titleTv;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("titleTv");
        localObject1 = null;
        label634:
        ((TextView)localObject1).setText((CharSequence)getString(e.h.finder_modify_signature_title));
        localObject2 = this.FSo;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          kotlin.g.b.s.bIx("edit");
          localObject1 = null;
        }
        ((EditText)localObject1).setMaxLines(5);
        localObject1 = this.FSo;
        if (localObject1 != null) {
          break label731;
        }
        kotlin.g.b.s.bIx("edit");
        localObject1 = null;
        label689:
        localObject4 = (Context)getContext();
        localObject2 = this.FSu;
        if (localObject2 != null) {
          break label734;
        }
      }
      label731:
      label734:
      for (localObject2 = null;; localObject2 = ((com.tencent.mm.plugin.finder.api.m)localObject2).field_signature)
      {
        ((EditText)localObject1).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.p.b((Context)localObject4, (CharSequence)localObject2));
        break;
        break label634;
        break label689;
      }
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(347836);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject3;
    Object localObject4;
    if (paramInt1 == this.FSw)
    {
      showVKB();
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        localObject1 = paramIntent.getByteArrayExtra("key_select_contact");
        if (localObject1 != null) {}
        int i;
        for (;;)
        {
          try
          {
            paramIntent = new djg();
            paramIntent.parseFrom((byte[])localObject1);
            if ((paramIntent == null) || (Util.isNullOrNil(paramIntent.nickname))) {
              break label621;
            }
            localObject3 = this.FSo;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              kotlin.g.b.s.bIx("edit");
              localObject1 = null;
            }
            paramInt1 = ((EditText)localObject1).getSelectionEnd();
            localObject3 = this.FSo;
            localObject1 = localObject3;
            if (localObject3 == null)
            {
              kotlin.g.b.s.bIx("edit");
              localObject1 = null;
            }
            localObject3 = ((EditText)localObject1).getText().toString();
            if (this.scene != 2) {
              break label642;
            }
            localObject4 = this.FSo;
            localObject1 = localObject4;
            if (localObject4 == null)
            {
              kotlin.g.b.s.bIx("edit");
              localObject1 = null;
            }
            i = ((EditText)localObject1).getSelectionEnd();
            if (i <= 0) {
              break label642;
            }
            paramInt2 = 1;
            paramInt1 = i - 1;
            if ((paramInt1 < 0) || (paramInt2 == 0)) {
              break;
            }
            localObject4 = this.FSo;
            localObject1 = localObject4;
            if (localObject4 == null)
            {
              kotlin.g.b.s.bIx("edit");
              localObject1 = null;
            }
            if (((EditText)localObject1).getText().toString().charAt(paramInt1) != '@') {
              break label278;
            }
            paramInt1 -= 1;
            continue;
            paramIntent = null;
          }
          catch (Exception paramIntent)
          {
            Log.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
          }
          continue;
          label278:
          paramInt2 = 0;
        }
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
        if (paramInt2 > ((String)localObject3).length()) {
          paramInt1 = ((String)localObject3).length();
        }
        if (localObject3 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347836);
          throw paramIntent;
        }
        localObject1 = ((String)localObject3).substring(0, paramInt1);
        kotlin.g.b.s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        paramInt2 = ((String)localObject3).length();
        if (localObject3 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347836);
          throw paramIntent;
        }
        localObject3 = ((String)localObject3).substring(i, paramInt2);
        kotlin.g.b.s.s(localObject3, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      }
    }
    label642:
    for (Object localObject1 = kotlin.g.b.s.X((String)localObject1, localObject3);; localObject1 = localObject3)
    {
      if (paramInt1 > ((String)localObject1).length()) {
        paramInt1 = ((String)localObject1).length();
      }
      for (;;)
      {
        localObject3 = new StringBuilder();
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347836);
          throw paramIntent;
        }
        localObject4 = ((String)localObject1).substring(0, paramInt1);
        kotlin.g.b.s.s(localObject4, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject3 = ((StringBuilder)localObject3).append((String)localObject4).append('@').append(paramIntent.nickname).append(' ');
        paramInt2 = ((String)localObject1).length();
        if (localObject1 == null)
        {
          paramIntent = new NullPointerException("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(347836);
          throw paramIntent;
        }
        localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
        kotlin.g.b.s.s(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject3 = (String)localObject1;
        paramIntent = paramIntent.nickname;
        if (paramIntent == null)
        {
          paramInt2 = 0;
          localObject1 = this.FSo;
          paramIntent = (Intent)localObject1;
          if (localObject1 == null)
          {
            kotlin.g.b.s.bIx("edit");
            paramIntent = null;
          }
          paramIntent.setText((CharSequence)localObject3);
          paramIntent = this.FSo;
          if (paramIntent != null) {
            break label636;
          }
          kotlin.g.b.s.bIx("edit");
          paramIntent = localObject2;
        }
        label621:
        label636:
        for (;;)
        {
          paramIntent.setSelection(paramInt1 + paramInt2 + 2);
          AppMethodBeat.o(347836);
          return;
          paramInt2 = paramIntent.length();
          break;
        }
      }
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167443);
    super.onCreate(paramBundle);
    paramBundle = d.AwY;
    this.FSu = d.a.auT(z.bAW());
    this.scene = getIntent().getIntExtra("key_scene", 0);
    initView();
    com.tencent.mm.kernel.h.aZW().a(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167443);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167452);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3761, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(167452);
  }
  
  public final void onInputPanelChange(boolean paramBoolean, int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167450);
    this.sNb = paramInt;
    if (paramBoolean)
    {
      localObject4 = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder("keyboardHeight ").append(paramInt).append(", inputContainer.height ");
      localObject3 = this.FPs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("inputContainer");
        localObject1 = null;
      }
      Log.i((String)localObject4, ((View)localObject1).getHeight());
      localObject1 = this.DXs;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("edtContainer");
        localObject1 = null;
      }
      for (;;)
      {
        ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this.FSx);
        localObject3 = this.FSq;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          kotlin.g.b.s.bIx("modifyBtn");
          localObject1 = null;
        }
        localObject1 = ((Button)localObject1).getLayoutParams();
        if (localObject1 != null) {
          break;
        }
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject4 = (LinearLayout.LayoutParams)localObject1;
      ((LinearLayout.LayoutParams)localObject4).bottomMargin = 0;
      localObject3 = this.FSq;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("modifyBtn");
        localObject1 = null;
      }
      ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject3 = this.FPs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("inputContainer");
        localObject1 = null;
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject4 = (FrameLayout.LayoutParams)localObject1;
      localObject3 = this.FPs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("inputContainer");
        localObject1 = null;
      }
      ((FrameLayout.LayoutParams)localObject4).height = (((View)localObject1).getHeight() - paramInt);
      localObject3 = this.FPs;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        kotlin.g.b.s.bIx("inputContainer");
        localObject1 = null;
      }
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
      localObject1 = this.FPs;
      if (localObject1 == null)
      {
        kotlin.g.b.s.bIx("inputContainer");
        localObject1 = localObject2;
      }
      for (;;)
      {
        ((View)localObject1).requestLayout();
        AppMethodBeat.o(167450);
        return;
      }
    }
    Object localObject1 = this.DXs;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("edtContainer");
      localObject1 = null;
    }
    for (;;)
    {
      ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.FSx);
      localObject2 = this.FSq;
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        kotlin.g.b.s.bIx("modifyBtn");
        localObject1 = null;
      }
      localObject1 = ((Button)localObject1).getLayoutParams();
      if (localObject1 != null) {
        break;
      }
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    Object localObject4 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject4).bottomMargin = getResources().getDimensionPixelSize(e.c.Edge_12A);
    localObject2 = this.FSq;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("modifyBtn");
      localObject1 = null;
    }
    ((Button)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject2 = this.FPs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("inputContainer");
      localObject1 = null;
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject4 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject4).height = -1;
    localObject2 = this.FPs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("inputContainer");
      localObject1 = null;
    }
    ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject4);
    localObject2 = this.FPs;
    localObject1 = localObject2;
    if (localObject2 == null)
    {
      kotlin.g.b.s.bIx("inputContainer");
      localObject1 = null;
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.FPs;
    if (localObject1 == null)
    {
      kotlin.g.b.s.bIx("inputContainer");
      localObject1 = localObject3;
    }
    for (;;)
    {
      ((View)localObject1).scrollTo(0, 0);
      AppMethodBeat.o(167450);
      return;
    }
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167451);
    super.onResume();
    di localdi = new di(2);
    com.tencent.mm.kernel.h.aZW().a((com.tencent.mm.am.p)localdi, 0);
    AppMethodBeat.o(167451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.am.p paramp)
  {
    int i = 1;
    Object localObject = null;
    AppMethodBeat.i(167453);
    Log.i(this.TAG, "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if (paramp == null) {}
    for (paramString = null; paramString == null; paramString = Integer.valueOf(paramp.getType()))
    {
      AppMethodBeat.o(167453);
      return;
    }
    bys localbys;
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramp == null)
      {
        paramString = new NullPointerException("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167453);
        throw paramString;
      }
      localbys = ((di)paramp).dVy();
      if (localbys != null)
      {
        paramString = localbys.aahr;
        if (paramString != null)
        {
          if (this.scene != 1) {
            break label298;
          }
          paramInt1 = i;
          if (paramInt1 == 0) {
            break label303;
          }
          label168:
          if (paramString != null)
          {
            paramString = this.FSr;
            if (paramString != null) {
              break label308;
            }
            kotlin.g.b.s.bIx("modifyCountTip");
            paramString = null;
            label189:
            paramString.setText((CharSequence)((di)paramp).dVy().aahr);
            paramString = this.FSr;
            if (paramString != null) {
              break label311;
            }
            kotlin.g.b.s.bIx("modifyCountTip");
            paramString = localObject;
          }
        }
      }
    }
    label298:
    label303:
    label308:
    label311:
    for (;;)
    {
      paramString.setVisibility(0);
      if (localbys.FPD > 0) {
        this.FPD = localbys.FPD;
      }
      if (localbys.FSv > 0) {
        this.FSv = localbys.FSv;
      }
      paramp = localbys.aahH;
      paramString = paramp;
      if (paramp == null) {
        paramString = "";
      }
      this.FSs = paramString;
      refreshView();
      AppMethodBeat.o(167453);
      return;
      paramInt1 = 0;
      break;
      paramString = null;
      break label168;
      break label189;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  public final void superImportUIComponents(HashSet<Class<? extends UIComponent>> paramHashSet)
  {
    AppMethodBeat.i(347799);
    kotlin.g.b.s.u(paramHashSet, "set");
    super.superImportUIComponents(paramHashSet);
    paramHashSet.add(com.tencent.mm.plugin.finder.accessibility.m.class);
    AppMethodBeat.o(347799);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements View.OnLayoutChangeListener
  {
    a(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      View localView2 = null;
      View localView1 = null;
      AppMethodBeat.i(167437);
      if (paramInt8 != paramInt4)
      {
        paramInt1 = this.FSy.getResources().getDimensionPixelSize(e.c.Edge_A);
        if (paramInt8 < paramInt4)
        {
          localView2 = FinderModifyNameUI.f(this.FSy);
          paramView = localView2;
          if (localView2 == null)
          {
            kotlin.g.b.s.bIx("inputContainer");
            paramView = null;
          }
          if (paramView.getHeight() < paramInt1)
          {
            paramView = FinderModifyNameUI.f(this.FSy);
            if (paramView == null)
            {
              kotlin.g.b.s.bIx("inputContainer");
              paramView = localView1;
            }
            for (;;)
            {
              paramView.scrollBy(0, paramInt4 - paramInt8);
              AppMethodBeat.o(167437);
              return;
            }
          }
        }
        else
        {
          localView1 = FinderModifyNameUI.f(this.FSy);
          paramView = localView1;
          if (localView1 == null)
          {
            kotlin.g.b.s.bIx("inputContainer");
            paramView = null;
          }
          if (paramView.getScrollY() > 0)
          {
            paramView = FinderModifyNameUI.f(this.FSy);
            if (paramView != null) {
              break label177;
            }
            kotlin.g.b.s.bIx("inputContainer");
            paramView = localView2;
          }
        }
      }
      label177:
      for (;;)
      {
        paramView.scrollBy(0, paramInt4 - paramInt8);
        AppMethodBeat.o(167437);
        return;
      }
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements TextWatcher
  {
    b(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(167441);
      EditText localEditText = FinderModifyNameUI.a(this.FSy);
      Object localObject = localEditText;
      if (localEditText == null)
      {
        kotlin.g.b.s.bIx("edit");
        localObject = null;
      }
      c.i((EditText)localObject).oF(1, FinderModifyNameUI.b(this.FSy)).b(com.tencent.mm.ui.tools.g.a.afII).Nc(true).a((com.tencent.mm.ui.tools.b.c.a)this.FSy);
      if ((FinderModifyNameUI.c(this.FSy) == 2) && (paramEditable != null))
      {
        localObject = (ForegroundColorSpan[])paramEditable.getSpans(0, paramEditable.length(), ForegroundColorSpan.class);
        kotlin.g.b.s.s(localObject, "spans");
        int j = localObject.length;
        while (i < j)
        {
          paramEditable.removeSpan(localObject[i]);
          i += 1;
        }
        localObject = com.tencent.mm.plugin.finder.utils.h.Gga;
        com.tencent.mm.plugin.finder.utils.h.a(paramEditable.toString(), (kotlin.g.a.q)new FinderModifyNameUI.b.a(paramEditable));
      }
      AppMethodBeat.o(167441);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(347430);
      if ((FinderModifyNameUI.c(this.FSy) == 2) && (paramInt3 == 1)) {
        if (paramCharSequence != null)
        {
          paramCharSequence = n.q(paramCharSequence, paramInt1);
          if (paramCharSequence != null) {
            break label107;
          }
        }
      }
      for (paramInt1 = 0;; paramInt1 = 1)
      {
        if (paramInt1 != 0)
        {
          Log.i(FinderModifyNameUI.d(this.FSy), "at auto goto");
          paramCharSequence = new Intent();
          paramCharSequence.putExtra("key_scene", 2);
          paramCharSequence.putExtra("KEY_ENTER_SCENE", 1);
          com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.GfO;
          com.tencent.mm.plugin.finder.utils.a.b((MMActivity)this.FSy, paramCharSequence, FinderModifyNameUI.e(this.FSy));
        }
        AppMethodBeat.o(347430);
        return;
        label107:
        if (paramCharSequence.charValue() != '@') {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderModifyNameUI
 * JD-Core Version:    0.7.0.1
 */