package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.Layout;
import android.text.Selection;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
import android.text.style.ClickableSpan;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLayoutChangeListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout.LayoutParams;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ScrollView;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.y;
import com.tencent.mm.plugin.finder.spam.a;
import com.tencent.mm.plugin.i.a.i;
import com.tencent.mm.pluginsdk.ui.span.o;
import com.tencent.mm.protocal.protobuf.ajz;
import com.tencent.mm.protocal.protobuf.alv;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.r;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.b.c.a;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import d.v;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@d.l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "", "modifyBtn", "Landroid/widget/Button;", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "plugin-finder_release"})
public final class FinderModifyNameUI
  extends MMFinderUI
  implements com.tencent.mm.al.g, i<ajz>, c.a, com.tencent.mm.ui.widget.b.a
{
  private int KXV;
  private int KXW;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ScrollView ftp;
  private int mEi;
  private ProgressDialog qLE;
  private View qLp;
  private InputPanelFrameLayout qLq;
  private View qLr;
  private TextView qLt;
  private EditText qNI;
  private TextView qNJ;
  private Button qNK;
  private View qNL;
  private TextView qNN;
  private com.tencent.mm.plugin.finder.api.f qNO;
  private final a qNP;
  private int scene;
  private TextView titleTv;
  
  public FinderModifyNameUI()
  {
    AppMethodBeat.i(167455);
    this.TAG = "Finder.FinderModifyNameUI";
    this.KXV = 20;
    this.KXW = 400;
    this.qNP = new a(this);
    AppMethodBeat.o(167455);
  }
  
  private void a(final TextView paramTextView, final Spannable paramSpannable)
  {
    AppMethodBeat.i(199273);
    d.g.b.k.h(paramTextView, "descTv");
    d.g.b.k.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new f(this, paramSpannable, paramTextView));
    AppMethodBeat.o(199273);
  }
  
  private final void bg(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(199271);
    ad.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = com.tencent.mm.plugin.i.a.l.iyI.matcher((CharSequence)paramString1);
    if (((Matcher)localObject).find())
    {
      String str1 = ((Matcher)localObject).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject).start(0) > 0)
      {
        i = ((Matcher)localObject).start(0);
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199271);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        d.g.b.k.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(199271);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        d.g.b.k.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      d.g.b.k.g(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      d.g.b.k.g(str1, "content");
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099769);
      localObject = getContext();
      d.g.b.k.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.e(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new FinderModifyNameUI.g(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.qLt;
      if (paramString2 == null) {
        d.g.b.k.aPZ("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.qLt;
      if (paramString2 == null) {
        d.g.b.k.aPZ("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.qLt;
      if (paramString1 == null) {
        d.g.b.k.aPZ("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(199271);
      return;
      paramString2 = this.qLt;
      if (paramString2 == null) {
        d.g.b.k.aPZ("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
    }
  }
  
  private final int getMaxLength()
  {
    switch (this.scene)
    {
    default: 
      return 2147483647;
    case 1: 
      return this.KXV;
    }
    return this.KXW;
  }
  
  private final void refreshView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167445);
    Object localObject = com.tencent.mm.kernel.g.afB();
    d.g.b.k.g(localObject, "MMKernel.storage()");
    int i = ((com.tencent.mm.kernel.e)localObject).afk().getInt(ae.a.Fwo, 0);
    ad.i(this.TAG, "user extFlag ".concat(String.valueOf(i)));
    if (this.scene == 1)
    {
      if ((i & 0x2) == 0) {
        break label132;
      }
      i = 1;
      localObject = this.qNI;
      if (localObject == null) {
        d.g.b.k.aPZ("edit");
      }
      if (i != 0) {
        break label137;
      }
      bool1 = true;
      label90:
      ((EditText)localObject).setEnabled(bool1);
      localObject = this.qNK;
      if (localObject == null) {
        d.g.b.k.aPZ("modifyBtn");
      }
      if (i != 0) {
        break label142;
      }
    }
    label132:
    label137:
    label142:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((Button)localObject).setEnabled(bool1);
      AppMethodBeat.o(167445);
      return;
      i = 0;
      break;
      bool1 = false;
      break label90;
    }
  }
  
  public final void CH(String paramString)
  {
    AppMethodBeat.i(167446);
    int i = com.tencent.mm.ui.tools.f.cJ(getMaxLength(), paramString);
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(i));
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099660));
    if (i <= d.k.h.kK((int)(getMaxLength() * 0.1F), 1))
    {
      paramString = this.qNJ;
      if (paramString == null) {
        d.g.b.k.aPZ("editLimit");
      }
      paramString.setVisibility(0);
      AppMethodBeat.o(167446);
      return;
    }
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setVisibility(4);
    AppMethodBeat.o(167446);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199274);
    if (this._$_findViewCache == null) {
      this._$_findViewCache = new HashMap();
    }
    View localView2 = (View)this._$_findViewCache.get(Integer.valueOf(paramInt));
    View localView1 = localView2;
    if (localView2 == null)
    {
      localView1 = findViewById(paramInt);
      this._$_findViewCache.put(Integer.valueOf(paramInt), localView1);
    }
    AppMethodBeat.o(199274);
    return localView1;
  }
  
  public final void aKr()
  {
    AppMethodBeat.i(167447);
    TextView localTextView = this.qNJ;
    if (localTextView == null) {
      d.g.b.k.aPZ("editLimit");
    }
    localTextView.setText((CharSequence)String.valueOf(getMaxLength()));
    localTextView = this.qNJ;
    if (localTextView == null) {
      d.g.b.k.aPZ("editLimit");
    }
    localTextView.setTextColor(getResources().getColor(2131099660));
    AppMethodBeat.o(167447);
  }
  
  public final void ck(String paramString)
  {
    AppMethodBeat.i(167448);
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setText((CharSequence)"0");
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setVisibility(0);
    paramString = this.qNJ;
    if (paramString == null) {
      d.g.b.k.aPZ("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099804));
    AppMethodBeat.o(167448);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167450);
    this.mEi = paramInt;
    if (paramBoolean)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("keyboardHeight ").append(paramInt).append(", inputContainer.height ");
      View localView = this.qLr;
      if (localView == null) {
        d.g.b.k.aPZ("inputContainer");
      }
      ad.i((String)localObject1, localView.getHeight());
      localObject1 = this.qNL;
      if (localObject1 == null) {
        d.g.b.k.aPZ("edtContainer");
      }
      ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this.qNP);
      localObject1 = this.qNK;
      if (localObject1 == null) {
        d.g.b.k.aPZ("modifyBtn");
      }
      localObject1 = ((Button)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (LinearLayout.LayoutParams)localObject1;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      localObject2 = this.qNK;
      if (localObject2 == null) {
        d.g.b.k.aPZ("modifyBtn");
      }
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.qLr;
      if (localObject1 == null) {
        d.g.b.k.aPZ("inputContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = this.qLr;
      if (localObject2 == null) {
        d.g.b.k.aPZ("inputContainer");
      }
      ((FrameLayout.LayoutParams)localObject1).height = (((View)localObject2).getHeight() - paramInt);
      localObject2 = this.qLr;
      if (localObject2 == null) {
        d.g.b.k.aPZ("inputContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.qLr;
      if (localObject1 == null) {
        d.g.b.k.aPZ("inputContainer");
      }
      ((View)localObject1).requestLayout();
      AppMethodBeat.o(167450);
      return;
    }
    Object localObject1 = this.qNL;
    if (localObject1 == null) {
      d.g.b.k.aPZ("edtContainer");
    }
    ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.qNP);
    localObject1 = this.qNK;
    if (localObject1 == null) {
      d.g.b.k.aPZ("modifyBtn");
    }
    localObject1 = ((Button)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165277);
    Object localObject2 = this.qNK;
    if (localObject2 == null) {
      d.g.b.k.aPZ("modifyBtn");
    }
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.qLr;
    if (localObject1 == null) {
      d.g.b.k.aPZ("inputContainer");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).height = -1;
    localObject2 = this.qLr;
    if (localObject2 == null) {
      d.g.b.k.aPZ("inputContainer");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.qLr;
    if (localObject1 == null) {
      d.g.b.k.aPZ("inputContainer");
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.qLr;
    if (localObject1 == null) {
      d.g.b.k.aPZ("inputContainer");
    }
    ((View)localObject1).scrollTo(0, 0);
    AppMethodBeat.o(167450);
  }
  
  public final int getLayoutId()
  {
    return 2131494071;
  }
  
  public final void initView()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167444);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    getController().q((Activity)this, getResources().getColor(2131101179));
    Object localObject3 = findViewById(2131300011);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_modify_name_container)");
    this.qNL = ((View)localObject3);
    localObject3 = findViewById(2131300001);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_input_container)");
    this.qLr = ((View)localObject3);
    localObject3 = findViewById(2131300012);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_modify_title)");
    this.titleTv = ((TextView)localObject3);
    localObject3 = findViewById(2131299990);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_edit)");
    this.qNI = ((EditText)localObject3);
    localObject3 = findViewById(2131299991);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_edit_limit)");
    this.qNJ = ((TextView)localObject3);
    localObject3 = findViewById(2131299308);
    d.g.b.k.g(localObject3, "findViewById(R.id.edt_bottom_space)");
    this.qLp = ((View)localObject3);
    localObject3 = findViewById(2131300010);
    d.g.b.k.g(localObject3, "findViewById(R.id.finder_modify_btn)");
    this.qNK = ((Button)localObject3);
    localObject3 = findViewById(2131302438);
    d.g.b.k.g(localObject3, "findViewById(R.id.modify_max_tip)");
    this.qNN = ((TextView)localObject3);
    localObject3 = findViewById(2131304371);
    d.g.b.k.g(localObject3, "findViewById(R.id.scroll_container)");
    this.ftp = ((ScrollView)localObject3);
    localObject3 = findViewById(2131301033);
    d.g.b.k.g(localObject3, "findViewById(R.id.input_panel)");
    this.qLq = ((InputPanelFrameLayout)localObject3);
    localObject3 = findViewById(2131306005);
    d.g.b.k.g(localObject3, "findViewById(R.id.top_error_tip)");
    this.qLt = ((TextView)localObject3);
    localObject3 = this.qNK;
    if (localObject3 == null) {
      d.g.b.k.aPZ("modifyBtn");
    }
    ((Button)localObject3).setOnClickListener((View.OnClickListener)new b(this));
    localObject3 = (TextWatcher)new e(this);
    Object localObject4 = this.qNI;
    if (localObject4 == null) {
      d.g.b.k.aPZ("edit");
    }
    ((EditText)localObject4).addTextChangedListener((TextWatcher)localObject3);
    localObject3 = this.qNI;
    if (localObject3 == null) {
      d.g.b.k.aPZ("edit");
    }
    ((EditText)localObject3).setOnTouchListener((View.OnTouchListener)new c(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    localObject3 = this.qLq;
    if (localObject3 == null) {
      d.g.b.k.aPZ("inputPanel");
    }
    ((InputPanelFrameLayout)localObject3).setExternalListener((com.tencent.mm.ui.widget.b.a)this);
    switch (this.scene)
    {
    }
    for (;;)
    {
      refreshView();
      localObject1 = this.qNI;
      if (localObject1 == null) {
        d.g.b.k.aPZ("edit");
      }
      ((EditText)localObject1).requestFocus();
      AppMethodBeat.o(167444);
      return;
      localObject1 = this.qNI;
      if (localObject1 == null) {
        d.g.b.k.aPZ("edit");
      }
      ((EditText)localObject1).setMaxLines(1);
      localObject3 = this.qNI;
      if (localObject3 == null) {
        d.g.b.k.aPZ("edit");
      }
      localObject4 = (Context)getContext();
      com.tencent.mm.plugin.finder.api.f localf = this.qNO;
      localObject1 = localObject2;
      if (localf != null) {
        localObject1 = localf.Su();
      }
      ((EditText)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject4, (CharSequence)localObject1));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        d.g.b.k.aPZ("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131759256));
      continue;
      localObject2 = this.titleTv;
      if (localObject2 == null) {
        d.g.b.k.aPZ("titleTv");
      }
      ((TextView)localObject2).setText((CharSequence)getString(2131759257));
      localObject2 = this.qNI;
      if (localObject2 == null) {
        d.g.b.k.aPZ("edit");
      }
      ((EditText)localObject2).setMaxLines(5);
      localObject2 = this.qNI;
      if (localObject2 == null) {
        d.g.b.k.aPZ("edit");
      }
      localObject3 = (Context)getContext();
      localObject4 = this.qNO;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.api.f)localObject4).field_signature;
      }
      ((EditText)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.k.c((Context)localObject3, (CharSequence)localObject1));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167443);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.api.b.qnX;
    paramBundle = u.aqO();
    d.g.b.k.g(paramBundle, "ConfigStorageLogic.getMyFinderUsername()");
    this.qNO = com.tencent.mm.plugin.finder.api.b.a.YL(paramBundle);
    this.scene = getIntent().getIntExtra("key_scene", 0);
    initView();
    com.tencent.mm.kernel.g.aeS().a(3761, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167443);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167452);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3761, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(167452);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167451);
    super.onResume();
    if (this.scene == 1)
    {
      y localy = new y(2);
      com.tencent.mm.kernel.g.aeS().b((n)localy);
    }
    AppMethodBeat.o(167451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(167453);
    ad.i(this.TAG, "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType()); paramString == null; paramString = null)
    {
      AppMethodBeat.o(167453);
      return;
    }
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167453);
        throw paramString;
      }
      paramString = ((y)paramn).ckV();
      if (paramString != null)
      {
        if (paramString.DmS != null)
        {
          TextView localTextView = this.qNN;
          if (localTextView == null) {
            d.g.b.k.aPZ("modifyCountTip");
          }
          localTextView.setText((CharSequence)((y)paramn).ckV().DmS);
          paramn = this.qNN;
          if (paramn == null) {
            d.g.b.k.aPZ("modifyCountTip");
          }
          paramn.setVisibility(0);
        }
        if (paramString.KXV > 0) {
          this.KXV = paramString.KXV;
        }
        if (paramString.KXW > 0) {
          this.KXW = paramString.KXW;
        }
      }
      refreshView();
    }
    AppMethodBeat.o(167453);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167437);
      if (paramInt8 != paramInt4)
      {
        paramInt1 = this.qNQ.getResources().getDimensionPixelSize(2131165303);
        if (paramInt8 < paramInt4)
        {
          if (FinderModifyNameUI.f(this.qNQ).getHeight() < paramInt1)
          {
            FinderModifyNameUI.f(this.qNQ).scrollBy(0, paramInt4 - paramInt8);
            AppMethodBeat.o(167437);
          }
        }
        else if (FinderModifyNameUI.f(this.qNQ).getScrollY() > 0) {
          FinderModifyNameUI.f(this.qNQ).scrollBy(0, paramInt4 - paramInt8);
        }
      }
      AppMethodBeat.o(167437);
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167438);
      paramView = a.qIC;
      if (a.Zv("personalInfo"))
      {
        AppMethodBeat.o(167438);
        return;
      }
      ad.i(FinderModifyNameUI.a(this.qNQ), "doClick create contact btn");
      String str = FinderModifyNameUI.c(this.qNQ).getText().toString();
      paramView = "";
      int i;
      switch (FinderModifyNameUI.b(this.qNQ))
      {
      default: 
        AppMethodBeat.o(167438);
        return;
      case 1: 
        if (((CharSequence)str).length() == 0) {}
        for (i = 1; i != 0; i = 0)
        {
          paramView = this.qNQ.getString(2131766404, new Object[] { this.qNQ.getString(2131759280) });
          d.g.b.k.g(paramView, "getString(R.string.finde….string.finder_nickname))");
          if (((CharSequence)paramView).length() <= 0) {
            break label329;
          }
          i = 1;
          label150:
          if (i == 0) {
            break label334;
          }
          FinderModifyNameUI.a(this.qNQ, paramView);
          AppMethodBeat.o(167438);
          return;
        }
        if (com.tencent.mm.ui.tools.f.aLJ(str) > FinderModifyNameUI.g(this.qNQ))
        {
          paramView = this.qNQ.getString(2131766405, new Object[] { this.qNQ.getString(2131759280) });
          d.g.b.k.g(paramView, "getString(R.string.finde….string.finder_nickname))");
        }
        break;
      }
      for (;;)
      {
        break;
        if (((CharSequence)str).length() == 0) {}
        for (i = 1;; i = 0)
        {
          if (i == 0) {
            break label280;
          }
          paramView = this.qNQ.getString(2131766404, new Object[] { this.qNQ.getString(2131759356) });
          d.g.b.k.g(paramView, "getString(R.string.finde…string.finder_signature))");
          break;
        }
        label280:
        if (com.tencent.mm.ui.tools.f.aLJ(str) > FinderModifyNameUI.h(this.qNQ))
        {
          paramView = this.qNQ.getString(2131766405, new Object[] { this.qNQ.getString(2131759356) });
          d.g.b.k.g(paramView, "getString(R.string.finde…string.finder_signature))");
        }
        break;
        label329:
        i = 0;
        break label150;
        label334:
        switch (FinderModifyNameUI.b(this.qNQ))
        {
        }
        for (;;)
        {
          AppMethodBeat.o(167438);
          return;
          ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).b(FinderModifyNameUI.c(this.qNQ).getText().toString(), (i)this.qNQ);
          FinderModifyNameUI.a(this.qNQ, (ProgressDialog)com.tencent.mm.ui.base.h.b((Context)this.qNQ, this.qNQ.getString(2131755919), false, null));
          AppMethodBeat.o(167438);
          return;
          ((com.tencent.mm.plugin.i.a.g)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.g.class)).c(FinderModifyNameUI.c(this.qNQ).getText().toString(), (i)this.qNQ);
          FinderModifyNameUI.a(this.qNQ, (ProgressDialog)com.tencent.mm.ui.base.h.b((Context)this.qNQ, this.qNQ.getString(2131755919), false, null));
        }
        paramView = "";
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167439);
      if (d.g.b.k.g(paramView, FinderModifyNameUI.c(this.qNQ)))
      {
        d.g.b.k.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(167439);
        return false;
        FinderModifyNameUI.e(this.qNQ).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderModifyNameUI.e(this.qNQ).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167440);
      this.qNQ.finish();
      AppMethodBeat.o(167440);
      return true;
    }
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167441);
      c.d(FinderModifyNameUI.c(this.qNQ)).jE(1, FinderModifyNameUI.d(this.qNQ)).a(f.a.Hrm).feh().a((c.a)this.qNQ);
      AppMethodBeat.o(167441);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @d.l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "view", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class f
    implements View.OnTouchListener
  {
    f(FinderModifyNameUI paramFinderModifyNameUI, Spannable paramSpannable, TextView paramTextView) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(199269);
      d.g.b.k.g(paramMotionEvent, "event");
      int j = paramMotionEvent.getAction();
      if (paramView == null)
      {
        paramView = new v("null cannot be cast to non-null type android.widget.TextView");
        AppMethodBeat.o(199269);
        throw paramView;
      }
      paramView = (TextView)paramView;
      Spannable localSpannable = paramSpannable;
      Object localObject1;
      int k;
      int i;
      if ((j == 1) || (j == 3))
      {
        localObject1 = (ClickableSpan[])localSpannable.getSpans(0, paramSpannable.length(), ClickableSpan.class);
        if (localObject1 != null)
        {
          k = localObject1.length;
          i = 0;
          while (i < k)
          {
            Object localObject2 = localObject1[i];
            if ((localObject2 instanceof o))
            {
              ((o)localObject2).setIsPressed(false);
              paramTextView.invalidate();
            }
            i += 1;
          }
        }
      }
      if ((j == 1) || (j == 0))
      {
        i = (int)paramMotionEvent.getX();
        k = (int)paramMotionEvent.getY();
        int m = paramView.getPaddingLeft();
        int n = paramView.getPaddingTop();
        int i1 = paramView.getScrollX();
        int i2 = paramView.getScrollY();
        localObject1 = paramView.getLayout();
        i = ((Layout)localObject1).getOffsetForHorizontal(((Layout)localObject1).getLineForVertical(k - n + i2), i - m + i1);
        localObject1 = (ClickableSpan[])localSpannable.getSpans(i, i, ClickableSpan.class);
        if (localObject1.length != 0)
        {
          localObject1 = localObject1[0];
          if (j == 1) {
            ((ClickableSpan)localObject1).onClick((View)paramView);
          }
        }
      }
      for (boolean bool = true;; bool = false)
      {
        ad.i(FinderModifyNameUI.a(this.qNQ), "touch " + paramMotionEvent.getX() + ", " + paramMotionEvent.getY() + ", ret:" + bool);
        AppMethodBeat.o(199269);
        return bool;
        if (j != 0) {
          break;
        }
        if ((localObject1 instanceof o))
        {
          ((o)localObject1).setIsPressed(true);
          paramTextView.invalidate();
        }
        Selection.setSelection(localSpannable, localSpannable.getSpanStart(localObject1), localSpannable.getSpanEnd(localObject1));
        break;
        Selection.removeSelection(localSpannable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderModifyNameUI
 * JD-Core Version:    0.7.0.1
 */