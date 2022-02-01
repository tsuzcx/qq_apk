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
import android.text.style.ForegroundColorSpan;
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
import com.tencent.mm.ak.i;
import com.tencent.mm.kernel.e;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.cd;
import com.tencent.mm.plugin.finder.utils.d;
import com.tencent.mm.plugin.i.a.ai;
import com.tencent.mm.plugin.i.a.k;
import com.tencent.mm.protocal.protobuf.azg;
import com.tencent.mm.protocal.protobuf.bed;
import com.tencent.mm.protocal.protobuf.cjj;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.tools.f;
import com.tencent.mm.ui.tools.f.a;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.b.a;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.p;
import kotlin.k.j;
import kotlin.n.n;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "modifyBtn", "Landroid/widget/Button;", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "plugin-finder_release"})
public final class FinderModifyNameUI
  extends MMFinderUI
  implements i, ai<azg>, com.tencent.mm.ui.tools.b.c.a, b.a
{
  private final String TAG;
  private HashMap _$_findViewCache;
  private ScrollView gxx;
  private int oXi;
  private int scene;
  private TextView titleTv;
  private com.tencent.mm.plugin.finder.api.g uCY;
  private View uht;
  private ProgressDialog vIA;
  private int vIE;
  private View vIp;
  private InputPanelFrameLayout vIq;
  private TextView vIr;
  private EditText vMl;
  private TextView vMm;
  private Button vMn;
  private View vMo;
  private TextView vMp;
  private int vMq;
  private final int vMr;
  private final a vMs;
  
  public FinderModifyNameUI()
  {
    AppMethodBeat.i(167455);
    this.TAG = "Finder.FinderModifyNameUI";
    this.vIE = 20;
    this.vMq = 400;
    this.vMr = 20001;
    this.vMs = new a(this);
    AppMethodBeat.o(167455);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(252547);
    p.h(paramTextView, "descTv");
    p.h(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderModifyNameUI.f(this, paramSpannable, paramTextView));
    AppMethodBeat.o(252547);
  }
  
  private final void aj(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(252545);
    Log.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = k.PATTERN.matcher((CharSequence)paramString1);
    if (((Matcher)localObject).find())
    {
      String str1 = ((Matcher)localObject).group(1);
      StringBuilder localStringBuilder = new StringBuilder();
      if (((Matcher)localObject).start(0) > 0)
      {
        i = ((Matcher)localObject).start(0);
        if (paramString1 == null)
        {
          paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252545);
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
          paramString1 = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252545);
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
      int k = ((AppCompatActivity)localObject).getResources().getColor(2131099783);
      localObject = getContext();
      p.g(localObject, "context");
      paramString1.setSpan(new com.tencent.mm.plugin.finder.view.l(str1, k, ((AppCompatActivity)localObject).getResources().getColor(2131099790), (kotlin.g.a.b)new g(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.vIr;
      if (paramString2 == null) {
        p.btv("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.vIr;
      if (paramString2 == null) {
        p.btv("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.vIr;
      if (paramString1 == null) {
        p.btv("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(252545);
      return;
      paramString2 = this.vIr;
      if (paramString2 == null) {
        p.btv("topErrorTip");
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
      return this.vIE;
    }
    return this.vMq;
  }
  
  private final void refreshView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167445);
    Object localObject = com.tencent.mm.kernel.g.aAh();
    p.g(localObject, "MMKernel.storage()");
    int i = ((e)localObject).azQ().getInt(ar.a.Okw, 0);
    Log.i(this.TAG, "user extFlag ".concat(String.valueOf(i)));
    if (this.scene == 1)
    {
      if ((i & 0x2) == 0) {
        break label132;
      }
      i = 1;
      localObject = this.vMl;
      if (localObject == null) {
        p.btv("edit");
      }
      if (i != 0) {
        break label137;
      }
      bool1 = true;
      label90:
      ((EditText)localObject).setEnabled(bool1);
      localObject = this.vMn;
      if (localObject == null) {
        p.btv("modifyBtn");
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
  
  public final void Tw(String paramString)
  {
    AppMethodBeat.i(167446);
    int i = f.dp(getMaxLength(), paramString);
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(i));
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099662));
    if (i <= j.mZ((int)(getMaxLength() * 0.1F), 1))
    {
      paramString = this.vMm;
      if (paramString == null) {
        p.btv("editLimit");
      }
      paramString.setVisibility(0);
    }
    for (;;)
    {
      paramString = this.vIr;
      if (paramString == null) {
        p.btv("topErrorTip");
      }
      paramString.setText((CharSequence)"");
      paramString = this.vIr;
      if (paramString == null) {
        p.btv("topErrorTip");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(167446);
      return;
      paramString = this.vMm;
      if (paramString == null) {
        p.btv("editLimit");
      }
      paramString.setVisibility(4);
    }
  }
  
  public final void Tx(String paramString)
  {
    AppMethodBeat.i(252544);
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(getMaxLength()));
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099662));
    AppMethodBeat.o(252544);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252549);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252549);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252548);
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
    AppMethodBeat.o(252548);
    return localView1;
  }
  
  public final void dv(String paramString)
  {
    AppMethodBeat.i(167448);
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setText((CharSequence)"0");
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setVisibility(0);
    paramString = this.vMm;
    if (paramString == null) {
      p.btv("editLimit");
    }
    paramString.setTextColor(getResources().getColor(2131099819));
    AppMethodBeat.o(167448);
  }
  
  public final void f(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167450);
    this.oXi = paramInt;
    if (paramBoolean)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("keyboardHeight ").append(paramInt).append(", inputContainer.height ");
      View localView = this.uht;
      if (localView == null) {
        p.btv("inputContainer");
      }
      Log.i((String)localObject1, localView.getHeight());
      localObject1 = this.vMo;
      if (localObject1 == null) {
        p.btv("edtContainer");
      }
      ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this.vMs);
      localObject1 = this.vMn;
      if (localObject1 == null) {
        p.btv("modifyBtn");
      }
      localObject1 = ((Button)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (LinearLayout.LayoutParams)localObject1;
      ((LinearLayout.LayoutParams)localObject1).bottomMargin = 0;
      localObject2 = this.vMn;
      if (localObject2 == null) {
        p.btv("modifyBtn");
      }
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.uht;
      if (localObject1 == null) {
        p.btv("inputContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = this.uht;
      if (localObject2 == null) {
        p.btv("inputContainer");
      }
      ((FrameLayout.LayoutParams)localObject1).height = (((View)localObject2).getHeight() - paramInt);
      localObject2 = this.uht;
      if (localObject2 == null) {
        p.btv("inputContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.uht;
      if (localObject1 == null) {
        p.btv("inputContainer");
      }
      ((View)localObject1).requestLayout();
      AppMethodBeat.o(167450);
      return;
    }
    Object localObject1 = this.vMo;
    if (localObject1 == null) {
      p.btv("edtContainer");
    }
    ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.vMs);
    localObject1 = this.vMn;
    if (localObject1 == null) {
      p.btv("modifyBtn");
    }
    localObject1 = ((Button)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(2131165281);
    Object localObject2 = this.vMn;
    if (localObject2 == null) {
      p.btv("modifyBtn");
    }
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.uht;
    if (localObject1 == null) {
      p.btv("inputContainer");
    }
    localObject1 = ((View)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (FrameLayout.LayoutParams)localObject1;
    ((FrameLayout.LayoutParams)localObject1).height = -1;
    localObject2 = this.uht;
    if (localObject2 == null) {
      p.btv("inputContainer");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.uht;
    if (localObject1 == null) {
      p.btv("inputContainer");
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.uht;
    if (localObject1 == null) {
      p.btv("inputContainer");
    }
    ((View)localObject1).scrollTo(0, 0);
    AppMethodBeat.o(167450);
  }
  
  public final int getLayoutId()
  {
    return 2131494518;
  }
  
  public final void initView()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167444);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    getController().p((Activity)this, getResources().getColor(2131101424));
    Object localObject3 = findViewById(2131301361);
    p.g(localObject3, "findViewById(R.id.finder_modify_name_container)");
    this.vMo = ((View)localObject3);
    localObject3 = findViewById(2131300853);
    p.g(localObject3, "findViewById(R.id.finder_input_container)");
    this.uht = ((View)localObject3);
    localObject3 = findViewById(2131301362);
    p.g(localObject3, "findViewById(R.id.finder_modify_title)");
    this.titleTv = ((TextView)localObject3);
    localObject3 = findViewById(2131300804);
    p.g(localObject3, "findViewById(R.id.finder_edit)");
    this.vMl = ((EditText)localObject3);
    localObject3 = findViewById(2131300805);
    p.g(localObject3, "findViewById(R.id.finder_edit_limit)");
    this.vMm = ((TextView)localObject3);
    localObject3 = findViewById(2131299912);
    p.g(localObject3, "findViewById(R.id.edt_bottom_space)");
    this.vIp = ((View)localObject3);
    localObject3 = findViewById(2131301360);
    p.g(localObject3, "findViewById(R.id.finder_modify_btn)");
    this.vMn = ((Button)localObject3);
    localObject3 = findViewById(2131304838);
    p.g(localObject3, "findViewById(R.id.modify_max_tip)");
    this.vMp = ((TextView)localObject3);
    localObject3 = findViewById(2131307333);
    p.g(localObject3, "findViewById(R.id.scroll_container)");
    this.gxx = ((ScrollView)localObject3);
    localObject3 = findViewById(2131302683);
    p.g(localObject3, "findViewById(R.id.input_panel)");
    this.vIq = ((InputPanelFrameLayout)localObject3);
    localObject3 = findViewById(2131309314);
    p.g(localObject3, "findViewById(R.id.top_error_tip)");
    this.vIr = ((TextView)localObject3);
    localObject3 = this.vMn;
    if (localObject3 == null) {
      p.btv("modifyBtn");
    }
    ((Button)localObject3).setOnClickListener((View.OnClickListener)new b(this));
    localObject3 = (TextWatcher)new e(this);
    Object localObject4 = this.vMl;
    if (localObject4 == null) {
      p.btv("edit");
    }
    ((EditText)localObject4).addTextChangedListener((TextWatcher)localObject3);
    localObject3 = this.vMl;
    if (localObject3 == null) {
      p.btv("edit");
    }
    ((EditText)localObject3).setOnTouchListener((View.OnTouchListener)new c(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    localObject3 = this.vIq;
    if (localObject3 == null) {
      p.btv("inputPanel");
    }
    ((InputPanelFrameLayout)localObject3).setExternalListener((b.a)this);
    switch (this.scene)
    {
    }
    for (;;)
    {
      refreshView();
      localObject1 = this.vMl;
      if (localObject1 == null) {
        p.btv("edit");
      }
      ((EditText)localObject1).requestFocus();
      AppMethodBeat.o(167444);
      return;
      localObject1 = this.vMl;
      if (localObject1 == null) {
        p.btv("edit");
      }
      ((EditText)localObject1).setMaxLines(1);
      localObject3 = this.vMl;
      if (localObject3 == null) {
        p.btv("edit");
      }
      localObject4 = (Context)getContext();
      com.tencent.mm.plugin.finder.api.g localg = this.uCY;
      localObject1 = localObject2;
      if (localg != null) {
        localObject1 = localg.getNickname();
      }
      ((EditText)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)localObject1));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.btv("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131760277));
      continue;
      localObject2 = this.titleTv;
      if (localObject2 == null) {
        p.btv("titleTv");
      }
      ((TextView)localObject2).setText((CharSequence)getString(2131760278));
      localObject2 = this.vMl;
      if (localObject2 == null) {
        p.btv("edit");
      }
      ((EditText)localObject2).setMaxLines(5);
      localObject2 = this.vMl;
      if (localObject2 == null) {
        p.btv("edit");
      }
      localObject3 = (Context)getContext();
      localObject4 = this.uCY;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.api.g)localObject4).field_signature;
      }
      ((EditText)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(252543);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    label264:
    String str;
    if (paramInt1 == this.vMr)
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
            paramIntent = new cjj();
            paramIntent.parseFrom((byte[])localObject1);
            if (paramIntent == null) {
              break label629;
            }
            if (Util.isNullOrNil(paramIntent.nickname)) {
              break label617;
            }
            localObject1 = this.vMl;
            if (localObject1 == null) {
              p.btv("edit");
            }
            paramInt2 = ((EditText)localObject1).getSelectionEnd();
            localObject1 = this.vMl;
            if (localObject1 == null) {
              p.btv("edit");
            }
            localObject2 = ((EditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (this.scene != 2) {
              break label407;
            }
            localObject1 = this.vMl;
            if (localObject1 == null) {
              p.btv("edit");
            }
            i = ((EditText)localObject1).getSelectionEnd();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (i <= 0) {
              break label407;
            }
            paramInt1 = i - 1;
            paramInt2 = 1;
            if ((paramInt1 < 0) || (paramInt2 == 0)) {
              break;
            }
            localObject1 = this.vMl;
            if (localObject1 == null) {
              p.btv("edit");
            }
            if (((EditText)localObject1).getText().toString().charAt(paramInt1) != '@') {
              break label264;
            }
            paramInt1 -= 1;
            continue;
          }
          catch (Exception paramIntent)
          {
            Log.e(this.TAG, "onActivityResult LocalFinderAtContact parseFrom:%s", new Object[] { paramIntent.getMessage() });
            paramIntent = null;
            continue;
          }
          paramIntent = null;
          continue;
          paramInt2 = 0;
        }
        paramInt2 = paramInt1 + 1;
        paramInt1 = paramInt2;
        if (paramInt2 > ((String)localObject2).length()) {
          paramInt1 = ((String)localObject2).length();
        }
        localObject1 = new StringBuilder();
        if (localObject2 == null)
        {
          paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252543);
          throw paramIntent;
        }
        str = ((String)localObject2).substring(0, paramInt1);
        p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append(str);
        paramInt2 = ((String)localObject2).length();
        if (localObject2 == null)
        {
          paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(252543);
          throw paramIntent;
        }
        localObject2 = ((String)localObject2).substring(i, paramInt2);
        p.g(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject2;
        label407:
        if (paramInt1 <= ((String)localObject1).length()) {
          break label636;
        }
        paramInt1 = ((String)localObject1).length();
      }
    }
    label617:
    label629:
    label636:
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (localObject1 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252543);
        throw paramIntent;
      }
      str = ((String)localObject1).substring(0, paramInt1);
      p.g(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = ((StringBuilder)localObject2).append(str).append('@').append(paramIntent.nickname).append(' ');
      paramInt2 = ((String)localObject1).length();
      if (localObject1 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(252543);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      p.g(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = (String)localObject1;
      paramIntent = paramIntent.nickname;
      if (paramIntent != null) {}
      for (paramInt2 = paramIntent.length();; paramInt2 = 0)
      {
        paramIntent = this.vMl;
        if (paramIntent == null) {
          p.btv("edit");
        }
        paramIntent.setText((CharSequence)localObject1);
        paramIntent = this.vMl;
        if (paramIntent == null) {
          p.btv("edit");
        }
        paramIntent.setSelection(paramInt2 + paramInt1 + 2);
        AppMethodBeat.o(252543);
        return;
      }
      AppMethodBeat.o(252543);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167443);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.api.c.tsp;
    this.uCY = com.tencent.mm.plugin.finder.api.c.a.asG(z.aUg());
    this.scene = getIntent().getIntExtra("key_scene", 0);
    initView();
    com.tencent.mm.kernel.g.azz().a(3761, (i)this);
    AppMethodBeat.o(167443);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167452);
    super.onDestroy();
    com.tencent.mm.kernel.g.azz().b(3761, (i)this);
    AppMethodBeat.o(167452);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167451);
    super.onResume();
    cd localcd = new cd(2);
    com.tencent.mm.kernel.g.azz().b((com.tencent.mm.ak.q)localcd);
    AppMethodBeat.o(167451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.ak.q paramq)
  {
    int i = 1;
    AppMethodBeat.i(167453);
    Log.i(this.TAG, "onSceneEnd errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    if (paramq != null) {}
    for (paramString = Integer.valueOf(paramq.getType()); paramString == null; paramString = null)
    {
      AppMethodBeat.o(167453);
      return;
    }
    bed localbed;
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167453);
        throw paramString;
      }
      localbed = ((cd)paramq).cZc();
      if (localbed != null)
      {
        paramString = localbed.LNL;
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
        paramString = this.vMp;
        if (paramString == null) {
          p.btv("modifyCountTip");
        }
        paramString.setText((CharSequence)((cd)paramq).cZc().LNL);
        paramString = this.vMp;
        if (paramString == null) {
          p.btv("modifyCountTip");
        }
        paramString.setVisibility(0);
      }
      if (localbed.vIE > 0) {
        this.vIE = localbed.vIE;
      }
      if (localbed.vMq > 0) {
        this.vMq = localbed.vMq;
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
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167437);
      if (paramInt8 != paramInt4)
      {
        paramInt1 = this.vMt.getResources().getDimensionPixelSize(2131165314);
        if (paramInt8 < paramInt4)
        {
          if (FinderModifyNameUI.i(this.vMt).getHeight() < paramInt1)
          {
            FinderModifyNameUI.i(this.vMt).scrollBy(0, paramInt4 - paramInt8);
            AppMethodBeat.o(167437);
          }
        }
        else if (FinderModifyNameUI.i(this.vMt).getScrollY() > 0) {
          FinderModifyNameUI.i(this.vMt).scrollBy(0, paramInt4 - paramInt8);
        }
      }
      AppMethodBeat.o(167437);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167438);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).axR());
      paramView = com.tencent.mm.plugin.finder.spam.a.vwk;
      if (com.tencent.mm.plugin.finder.spam.a.avp("personalInfo"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167438);
        return;
      }
      Log.i(FinderModifyNameUI.a(this.vMt), "doClick create contact btn");
      paramView = FinderModifyNameUI.b(this.vMt).getText().toString();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(167438);
        throw paramView;
      }
      localObject = n.trim((CharSequence)paramView).toString();
      paramView = "";
      int i;
      switch (FinderModifyNameUI.c(this.vMt))
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
          paramView = this.vMt.getString(2131759816, new Object[] { this.vMt.getString(2131760332) });
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
          FinderModifyNameUI.a(this.vMt, paramView);
          com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
          AppMethodBeat.o(167438);
          return;
          i = 0;
          break;
          label273:
          if (f.bnP((String)localObject) <= FinderModifyNameUI.d(this.vMt)) {
            break label517;
          }
          paramView = this.vMt.getString(2131759817, new Object[] { this.vMt.getString(2131760332) });
          p.g(paramView, "getString(R.string.finde….string.finder_nickname))");
        }
        for (;;)
        {
          break;
          if (f.bnP((String)localObject) <= FinderModifyNameUI.e(this.vMt)) {
            break label521;
          }
          paramView = this.vMt.getString(2131759817, new Object[] { this.vMt.getString(2131760584) });
          p.g(paramView, "getString(R.string.finde…string.finder_signature))");
          break;
          i = 0;
          break label238;
          label376:
          switch (FinderModifyNameUI.c(this.vMt))
          {
          default: 
            break;
          case 1: 
            ((com.tencent.mm.plugin.i.a.x)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).d((String)localObject, (ai)this.vMt);
            FinderModifyNameUI.a(this.vMt, (ProgressDialog)h.a((Context)this.vMt, this.vMt.getString(2131756011), false, null));
            break;
          case 2: 
            ((com.tencent.mm.plugin.i.a.x)com.tencent.mm.kernel.g.af(com.tencent.mm.plugin.i.a.x.class)).e((String)localObject, (ai)this.vMt);
            FinderModifyNameUI.a(this.vMt, (ProgressDialog)h.a((Context)this.vMt, this.vMt.getString(2131756011), false, null));
            break;
            paramView = "";
          }
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167439);
      if (p.j(paramView, FinderModifyNameUI.b(this.vMt)))
      {
        p.g(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(167439);
        return false;
        FinderModifyNameUI.h(this.vMt).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderModifyNameUI.h(this.vMt).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167440);
      this.vMt.finish();
      AppMethodBeat.o(167440);
      return true;
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(167441);
      com.tencent.mm.ui.tools.b.c.f(FinderModifyNameUI.b(this.vMt)).lv(1, FinderModifyNameUI.f(this.vMt)).a(f.a.Qui).CN(true).a((com.tencent.mm.ui.tools.b.c.a)this.vMt);
      if ((FinderModifyNameUI.c(this.vMt) == 2) && (paramEditable != null))
      {
        Object localObject = (ForegroundColorSpan[])paramEditable.getSpans(0, paramEditable.length(), ForegroundColorSpan.class);
        p.g(localObject, "spans");
        int j = localObject.length;
        while (i < j)
        {
          paramEditable.removeSpan(localObject[i]);
          i += 1;
        }
        localObject = d.vVg;
        d.a(paramEditable.toString(), (kotlin.g.a.q)new a(paramEditable));
      }
      AppMethodBeat.o(167441);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      Object localObject2 = null;
      AppMethodBeat.i(252540);
      if ((FinderModifyNameUI.c(this.vMt) == 2) && (paramInt3 == 1))
      {
        Object localObject1 = localObject2;
        if (paramCharSequence != null)
        {
          p.h(paramCharSequence, "$this$getOrNull");
          localObject1 = localObject2;
          if (paramInt1 >= 0)
          {
            localObject1 = localObject2;
            if (paramInt1 <= n.aO(paramCharSequence)) {
              localObject1 = Character.valueOf(paramCharSequence.charAt(paramInt1));
            }
          }
        }
        if (localObject1 == null)
        {
          AppMethodBeat.o(252540);
          return;
        }
        if (((Character)localObject1).charValue() == '@')
        {
          Log.i(FinderModifyNameUI.a(this.vMt), "at auto goto");
          paramCharSequence = new Intent();
          paramCharSequence.putExtra("key_scene", 2);
          paramCharSequence.putExtra("KEY_ENTER_SCENE", 1);
          localObject1 = com.tencent.mm.plugin.finder.utils.a.vUU;
          com.tencent.mm.plugin.finder.utils.a.c((MMActivity)this.vMt, paramCharSequence, FinderModifyNameUI.g(this.vMt));
        }
      }
      AppMethodBeat.o(252540);
    }
    
    @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "start", "", "end", "nickname", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.q<Integer, Integer, String, kotlin.x>
    {
      a(Editable paramEditable)
      {
        super();
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, kotlin.x>
  {
    g(FinderModifyNameUI paramFinderModifyNameUI, String paramString1, String paramString2)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderModifyNameUI
 * JD-Core Version:    0.7.0.1
 */