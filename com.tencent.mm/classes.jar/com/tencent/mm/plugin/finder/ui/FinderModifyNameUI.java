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
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextWatcher;
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
import com.tencent.mm.ak.q;
import com.tencent.mm.kernel.e;
import com.tencent.mm.plugin.finder.cgi.ay;
import com.tencent.mm.plugin.i.a.d;
import com.tencent.mm.pluginsdk.ui.span.k;
import com.tencent.mm.protocal.protobuf.aqf;
import com.tencent.mm.protocal.protobuf.atf;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import d.g.b.p;
import d.l;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "", "modifyBtn", "Landroid/widget/Button;", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "plugin-finder_release"})
public final class FinderModifyNameUI
  extends MMFinderUI
  implements com.tencent.mm.ak.f, com.tencent.mm.plugin.i.a.s<aqf>, com.tencent.mm.ui.tools.b.c.a, b.a
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private ScrollView fSp;
  private int nMm;
  private ProgressDialog sMH;
  private int sMJ;
  private View sMv;
  private InputPanelFrameLayout sMw;
  private View sMx;
  private TextView sMz;
  private EditText sPd;
  private TextView sPe;
  private Button sPf;
  private View sPg;
  private TextView sPh;
  private com.tencent.mm.plugin.finder.api.g sPi;
  private int sPj;
  private final a sPk;
  private int scene;
  private TextView titleTv;
  
  public FinderModifyNameUI()
  {
    AppMethodBeat.i(167455);
    this.TAG = "Finder.FinderModifyNameUI";
    this.sMJ = 20;
    this.sPj = 400;
    this.sPk = new a(this);
    AppMethodBeat.o(167455);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(204638);
    p.h(paramTextView, "descTv");
    p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderModifyNameUI.f(this, paramSpannable, paramTextView));
    AppMethodBeat.o(204638);
  }
  
  private final void ad(String paramString1, String paramString2, String paramString3)
  {
    AppMethodBeat.i(204636);
    ae.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = d.juN.matcher((CharSequence)paramString1);
    if (((Matcher)localObject).find())
    {
      String str1 = ((Matcher)localObject).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject).start(0) > 0)
      {
        i = ((Matcher)localObject).start(0);
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204636);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        p.g(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(str2);
      }
      localStringBuilder.append(str1);
      if (((Matcher)localObject).end(0) < paramString1.length())
      {
        i = ((Matcher)localObject).end(0);
        j = paramString1.length();
        if (paramString1 == null)
        {
          paramString1 = new d.v("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(204636);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        p.g(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      p.g(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      p.g(str1, "content");
      localObject = getContext();
      p.g(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099769);
      localObject = getContext();
      p.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.j(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099776), false, (d.g.a.b)new FinderModifyNameUI.g(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.sMz;
      if (paramString1 == null) {
        p.bdF("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(204636);
      return;
      paramString2 = this.sMz;
      if (paramString2 == null) {
        p.bdF("topErrorTip");
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
      return this.sMJ;
    }
    return this.sPj;
  }
  
  private final void refreshView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167445);
    Object localObject = com.tencent.mm.kernel.g.ajR();
    p.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).ajA().getInt(am.a.Jbx, 0);
    ae.i(this.TAG, "user extFlag ".concat(String.valueOf(i)));
    if (this.scene == 1)
    {
      if ((i & 0x2) == 0) {
        break label132;
      }
      i = 1;
      localObject = this.sPd;
      if (localObject == null) {
        p.bdF("edit");
      }
      if (i != 0) {
        break label137;
      }
      bool1 = true;
      label90:
      ((EditText)localObject).setEnabled(bool1);
      localObject = this.sPf;
      if (localObject == null) {
        p.bdF("modifyBtn");
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
  
  public final void Ky(String paramString)
  {
    AppMethodBeat.i(167446);
    int i = com.tencent.mm.ui.tools.f.cU(getMaxLength(), paramString);
    paramString = this.sPe;
    if (paramString == null) {
      p.bdF("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(i));
    paramString = this.sPe;
    if (paramString == null) {
      p.bdF("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099660));
    if (i <= d.k.j.lw((int)(getMaxLength() * 0.1F), 1))
    {
      paramString = this.sPe;
      if (paramString == null) {
        p.bdF("editLimit");
      }
      paramString.setVisibility(0);
    }
    for (;;)
    {
      paramString = this.sMz;
      if (paramString == null) {
        p.bdF("topErrorTip");
      }
      paramString.setText((CharSequence)"");
      paramString = this.sMz;
      if (paramString == null) {
        p.bdF("topErrorTip");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(167446);
      return;
      paramString = this.sPe;
      if (paramString == null) {
        p.bdF("editLimit");
      }
      paramString.setVisibility(4);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204639);
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
    AppMethodBeat.o(204639);
    return localView1;
  }
  
  public final void aUT()
  {
    AppMethodBeat.i(167447);
    TextView localTextView = this.sPe;
    if (localTextView == null) {
      p.bdF("editLimit");
    }
    localTextView.setText((CharSequence)String.valueOf(getMaxLength()));
    localTextView = this.sPe;
    if (localTextView == null) {
      p.bdF("editLimit");
    }
    localTextView.setTextColor(getResources().getColor(2131099660));
    AppMethodBeat.o(167447);
  }
  
  public final void cW(String paramString)
  {
    AppMethodBeat.i(167448);
    paramString = this.sPe;
    if (paramString == null) {
      p.bdF("editLimit");
    }
    paramString.setText((CharSequence)"0");
    paramString = this.sPe;
    if (paramString == null) {
      p.bdF("editLimit");
    }
    paramString.setVisibility(0);
    paramString = this.sPe;
    if (paramString == null) {
      p.bdF("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099804));
    AppMethodBeat.o(167448);
  }
  
  public final void g(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167450);
    this.nMm = paramInt;
    if (paramBoolean)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("keyboardHeight ").append(paramInt).append(", inputContainer.height ");
      View localView = this.sMx;
      if (localView == null) {
        p.bdF("inputContainer");
      }
      ae.i((String)localObject1, localView.getHeight());
      localObject1 = this.sPg;
      if (localObject1 == null) {
        p.bdF("edtContainer");
      }
      ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this.sPk);
      localObject1 = this.sPf;
      if (localObject1 == null) {
        p.bdF("modifyBtn");
      }
      localObject1 = ((Button)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (LinearLayout.LayoutParams)localObject1;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      localObject2 = this.sPf;
      if (localObject2 == null) {
        p.bdF("modifyBtn");
      }
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.sMx;
      if (localObject1 == null) {
        p.bdF("inputContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = this.sMx;
      if (localObject2 == null) {
        p.bdF("inputContainer");
      }
      ((FrameLayout.LayoutParams)localObject1).height = (((View)localObject2).getHeight() - paramInt);
      localObject2 = this.sMx;
      if (localObject2 == null) {
        p.bdF("inputContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.sMx;
      if (localObject1 == null) {
        p.bdF("inputContainer");
      }
      ((View)localObject1).requestLayout();
      AppMethodBeat.o(167450);
      return;
    }
    Object localObject1 = this.sPg;
    if (localObject1 == null) {
      p.bdF("edtContainer");
    }
    ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.sPk);
    localObject1 = this.sPf;
    if (localObject1 == null) {
      p.bdF("modifyBtn");
    }
    localObject1 = ((Button)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165277);
    Object localObject2 = this.sPf;
    if (localObject2 == null) {
      p.bdF("modifyBtn");
    }
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.sMx;
    if (localObject1 == null) {
      p.bdF("inputContainer");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new d.v("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).height = -1;
    localObject2 = this.sMx;
    if (localObject2 == null) {
      p.bdF("inputContainer");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.sMx;
    if (localObject1 == null) {
      p.bdF("inputContainer");
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.sMx;
    if (localObject1 == null) {
      p.bdF("inputContainer");
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
    p.g(localObject3, "findViewById(R.id.finder_modify_name_container)");
    this.sPg = ((View)localObject3);
    localObject3 = findViewById(2131300001);
    p.g(localObject3, "findViewById(R.id.finder_input_container)");
    this.sMx = ((View)localObject3);
    localObject3 = findViewById(2131300012);
    p.g(localObject3, "findViewById(R.id.finder_modify_title)");
    this.titleTv = ((TextView)localObject3);
    localObject3 = findViewById(2131299990);
    p.g(localObject3, "findViewById(R.id.finder_edit)");
    this.sPd = ((EditText)localObject3);
    localObject3 = findViewById(2131299991);
    p.g(localObject3, "findViewById(R.id.finder_edit_limit)");
    this.sPe = ((TextView)localObject3);
    localObject3 = findViewById(2131299308);
    p.g(localObject3, "findViewById(R.id.edt_bottom_space)");
    this.sMv = ((View)localObject3);
    localObject3 = findViewById(2131300010);
    p.g(localObject3, "findViewById(R.id.finder_modify_btn)");
    this.sPf = ((Button)localObject3);
    localObject3 = findViewById(2131302438);
    p.g(localObject3, "findViewById(R.id.modify_max_tip)");
    this.sPh = ((TextView)localObject3);
    localObject3 = findViewById(2131304371);
    p.g(localObject3, "findViewById(R.id.scroll_container)");
    this.fSp = ((ScrollView)localObject3);
    localObject3 = findViewById(2131301033);
    p.g(localObject3, "findViewById(R.id.input_panel)");
    this.sMw = ((InputPanelFrameLayout)localObject3);
    localObject3 = findViewById(2131306005);
    p.g(localObject3, "findViewById(R.id.top_error_tip)");
    this.sMz = ((TextView)localObject3);
    localObject3 = this.sPf;
    if (localObject3 == null) {
      p.bdF("modifyBtn");
    }
    ((Button)localObject3).setOnClickListener((View.OnClickListener)new b(this));
    localObject3 = (TextWatcher)new e(this);
    Object localObject4 = this.sPd;
    if (localObject4 == null) {
      p.bdF("edit");
    }
    ((EditText)localObject4).addTextChangedListener((TextWatcher)localObject3);
    localObject3 = this.sPd;
    if (localObject3 == null) {
      p.bdF("edit");
    }
    ((EditText)localObject3).setOnTouchListener((View.OnTouchListener)new c(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    localObject3 = this.sMw;
    if (localObject3 == null) {
      p.bdF("inputPanel");
    }
    ((InputPanelFrameLayout)localObject3).setExternalListener((b.a)this);
    switch (this.scene)
    {
    }
    for (;;)
    {
      refreshView();
      localObject1 = this.sPd;
      if (localObject1 == null) {
        p.bdF("edit");
      }
      ((EditText)localObject1).requestFocus();
      AppMethodBeat.o(167444);
      return;
      localObject1 = this.sPd;
      if (localObject1 == null) {
        p.bdF("edit");
      }
      ((EditText)localObject1).setMaxLines(1);
      localObject3 = this.sPd;
      if (localObject3 == null) {
        p.bdF("edit");
      }
      localObject4 = (Context)getContext();
      com.tencent.mm.plugin.finder.api.g localg = this.sPi;
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = localg.VK();
      }
      ((EditText)localObject3).setText((CharSequence)k.c((Context)localObject4, (CharSequence)localObject1));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bdF("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131759256));
      continue;
      localObject2 = this.titleTv;
      if (localObject2 == null) {
        p.bdF("titleTv");
      }
      ((TextView)localObject2).setText((CharSequence)getString(2131759257));
      localObject2 = this.sPd;
      if (localObject2 == null) {
        p.bdF("edit");
      }
      ((EditText)localObject2).setMaxLines(5);
      localObject2 = this.sPd;
      if (localObject2 == null) {
        p.bdF("edit");
      }
      localObject3 = (Context)getContext();
      localObject4 = this.sPi;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject4).field_signature;
      }
      ((EditText)localObject2).setText((CharSequence)k.c((Context)localObject3, (CharSequence)localObject1));
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167443);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.api.c.rPy;
    this.sPi = com.tencent.mm.plugin.finder.api.c.a.ahT(com.tencent.mm.model.v.aAK());
    this.scene = getIntent().getIntExtra("key_scene", 0);
    initView();
    com.tencent.mm.kernel.g.ajj().a(3761, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(167443);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167452);
    super.onDestroy();
    com.tencent.mm.kernel.g.ajj().b(3761, (com.tencent.mm.ak.f)this);
    AppMethodBeat.o(167452);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167451);
    super.onResume();
    ay localay = new ay(2);
    com.tencent.mm.kernel.g.ajj().b((com.tencent.mm.ak.n)localay);
    AppMethodBeat.o(167451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.n paramn)
  {
    int i = 1;
    AppMethodBeat.i(167453);
    ae.i(this.TAG, "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if (paramn != null) {}
    for (paramString = Integer.valueOf(paramn.getType()); paramString == null; paramString = null)
    {
      AppMethodBeat.o(167453);
      return;
    }
    atf localatf;
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramn == null)
      {
        paramString = new d.v("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167453);
        throw paramString;
      }
      localatf = ((ay)paramn).cAk();
      if (localatf != null)
      {
        paramString = localatf.GKb;
        if (paramString != null)
        {
          if (this.scene != 1) {
            break label267;
          }
          paramInt1 = i;
          if (paramInt1 == 0) {
            break label272;
          }
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = this.sPh;
        if (paramString == null) {
          p.bdF("modifyCountTip");
        }
        paramString.setText((CharSequence)((ay)paramn).cAk().GKb);
        paramString = this.sPh;
        if (paramString == null) {
          p.bdF("modifyCountTip");
        }
        paramString.setVisibility(0);
      }
      if (localatf.sMJ > 0) {
        this.sMJ = localatf.sMJ;
      }
      if (localatf.sPj > 0) {
        this.sPj = localatf.sPj;
      }
      refreshView();
      AppMethodBeat.o(167453);
      return;
      label267:
      paramInt1 = 0;
      break;
      label272:
      paramString = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167437);
      if (paramInt8 != paramInt4)
      {
        paramInt1 = this.sPl.getResources().getDimensionPixelSize(2131165303);
        if (paramInt8 < paramInt4)
        {
          if (FinderModifyNameUI.h(this.sPl).getHeight() < paramInt1)
          {
            FinderModifyNameUI.h(this.sPl).scrollBy(0, paramInt4 - paramInt8);
            AppMethodBeat.o(167437);
          }
        }
        else if (FinderModifyNameUI.h(this.sPl).getScrollY() > 0) {
          FinderModifyNameUI.h(this.sPl).scrollBy(0, paramInt4 - paramInt8);
        }
      }
      AppMethodBeat.o(167437);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167438);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bd(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).ahF());
      paramView = com.tencent.mm.plugin.finder.spam.a.sEK;
      if (com.tencent.mm.plugin.finder.spam.a.ajm("personalInfo"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167438);
        return;
      }
      ae.i(FinderModifyNameUI.a(this.sPl), "doClick create contact btn");
      paramView = FinderModifyNameUI.b(this.sPl).getText().toString();
      if (paramView == null)
      {
        paramView = new d.v("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(167438);
        throw paramView;
      }
      localObject = d.n.n.trim((CharSequence)paramView).toString();
      paramView = "";
      int i;
      switch (FinderModifyNameUI.c(this.sPl))
      {
      default: 
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167438);
        return;
      case 1: 
        if (((CharSequence)localObject).length() == 0)
        {
          i = 1;
          if (i == 0) {
            break label273;
          }
          paramView = this.sPl.getString(2131766426, new Object[] { this.sPl.getString(2131759280) });
          p.g(paramView, "getString(R.string.finde….string.finder_nickname))");
        }
        break;
      }
      label517:
      label521:
      for (;;)
      {
        if (((CharSequence)paramView).length() > 0)
        {
          i = 1;
          label238:
          if (i == 0) {
            break label376;
          }
          FinderModifyNameUI.a(this.sPl, paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(167438);
          return;
          i = 0;
          break;
          label273:
          if (com.tencent.mm.ui.tools.f.aYK((String)localObject) <= FinderModifyNameUI.d(this.sPl)) {
            break label517;
          }
          paramView = this.sPl.getString(2131766427, new Object[] { this.sPl.getString(2131759280) });
          p.g(paramView, "getString(R.string.finde….string.finder_nickname))");
        }
        for (;;)
        {
          break;
          if (com.tencent.mm.ui.tools.f.aYK((String)localObject) <= FinderModifyNameUI.e(this.sPl)) {
            break label521;
          }
          paramView = this.sPl.getString(2131766427, new Object[] { this.sPl.getString(2131759356) });
          p.g(paramView, "getString(R.string.finde…string.finder_signature))");
          break;
          i = 0;
          break label238;
          label376:
          switch (FinderModifyNameUI.c(this.sPl))
          {
          default: 
            break;
          case 1: 
            ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).b((String)localObject, (com.tencent.mm.plugin.i.a.s)this.sPl);
            FinderModifyNameUI.a(this.sPl, (ProgressDialog)h.b((Context)this.sPl, this.sPl.getString(2131755919), false, null));
            break;
          case 2: 
            ((com.tencent.mm.plugin.i.a.n)com.tencent.mm.kernel.g.ab(com.tencent.mm.plugin.i.a.n.class)).c((String)localObject, (com.tencent.mm.plugin.i.a.s)this.sPl);
            FinderModifyNameUI.a(this.sPl, (ProgressDialog)h.b((Context)this.sPl, this.sPl.getString(2131755919), false, null));
            break;
            paramView = "";
          }
        }
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167439);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bd(paramView);
      localb.bd(paramMotionEvent);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z", this, localb.ahF());
      if (p.i(paramView, FinderModifyNameUI.b(this.sPl)))
      {
        p.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(false, this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$2", "android/view/View$OnTouchListener", "onTouch", "(Landroid/view/View;Landroid/view/MotionEvent;)Z");
        AppMethodBeat.o(167439);
        return false;
        FinderModifyNameUI.g(this.sPl).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderModifyNameUI.g(this.sPl).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167440);
      this.sPl.finish();
      AppMethodBeat.o(167440);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(167441);
      com.tencent.mm.ui.tools.b.c.d(FinderModifyNameUI.b(this.sPl)).kj(1, FinderModifyNameUI.f(this.sPl)).a(f.a.Lfh).fPi().a((com.tencent.mm.ui.tools.b.c.a)this.sPl);
      AppMethodBeat.o(167441);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderModifyNameUI
 * JD-Core Version:    0.7.0.1
 */