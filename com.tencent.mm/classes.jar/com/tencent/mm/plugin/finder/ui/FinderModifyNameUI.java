package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.d;
import com.tencent.mm.plugin.finder.api.d.a;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ch;
import com.tencent.mm.plugin.finder.utils.e;
import com.tencent.mm.plugin.finder.view.o;
import com.tencent.mm.plugin.findersdk.a.aj;
import com.tencent.mm.plugin.findersdk.a.j;
import com.tencent.mm.protocal.protobuf.bfc;
import com.tencent.mm.protocal.protobuf.ble;
import com.tencent.mm.protocal.protobuf.cse;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.tools.b.c;
import com.tencent.mm.ui.tools.g;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.w;
import com.tencent.mm.ui.widget.InputPanelFrameLayout;
import com.tencent.mm.ui.widget.a.f.a;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.n.n;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/ui/widget/InputPanelHelper$OnInputPanelChange;", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "Lcom/tencent/mm/plugin/findersdk/api/IModifyUserResult;", "Lcom/tencent/mm/protocal/protobuf/FinderModUserInfo;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "REQUEST_CODE_SELECT_AT_CONTACT", "", "TAG", "", "edit", "Landroid/widget/EditText;", "editBottomSpace", "Landroid/view/View;", "editLimit", "Landroid/widget/TextView;", "edtContainer", "edtLayoutListener", "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Lcom/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1;", "inputContainer", "inputPanel", "Lcom/tencent/mm/ui/widget/InputPanelFrameLayout;", "keyboardHeight", "modifyBtn", "Landroid/widget/Button;", "modifyCountDialogTips", "modifyCountDialogTipsPlaceholder", "modifyCountTip", "nicknameMaxLength", "progressDialog", "Landroid/app/ProgressDialog;", "scene", "scrollView", "Landroid/widget/ScrollView;", "selfContact", "Lcom/tencent/mm/plugin/finder/api/LocalFinderContact;", "signatureMaxLength", "titleTv", "topErrorTip", "doPrepareUser", "", "doWhenLess", "text", "doWhenMore", "doWhenOK", "getLayoutId", "getMaxLength", "hideError", "initView", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onConfirmClick", "name", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInputPanelChange", "isKeyboardShow", "", "onModifyResult", "req", "ret", "Lcom/tencent/mm/protocal/protobuf/FinderCmdRet;", "onResume", "onSceneEnd", "errType", "errCode", "errMsg", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "setSpanTouch", "descTv", "Landroid/text/Spannable;", "showError", "errTip", "appname", "applink", "plugin-finder_release"})
public final class FinderModifyNameUI
  extends MMFinderUI
  implements com.tencent.mm.an.i, aj<bfc>, com.tencent.mm.ui.tools.b.c.a, com.tencent.mm.ui.widget.c.a
{
  private View Apm;
  private InputPanelFrameLayout Apn;
  private TextView Apo;
  private ProgressDialog Apv;
  private int Apz;
  private EditText AsY;
  private TextView AsZ;
  private Button Ata;
  private TextView Atb;
  private String Atc;
  private String Atd;
  private com.tencent.mm.plugin.finder.api.i Ate;
  private int Atf;
  private final int Atg;
  private final a Ath;
  private final String TAG;
  private HashMap _$_findViewCache;
  private ScrollView jbL;
  private int pIk;
  private int scene;
  private TextView titleTv;
  private View yOP;
  private View ybx;
  
  public FinderModifyNameUI()
  {
    AppMethodBeat.i(167455);
    this.TAG = "Finder.FinderModifyNameUI";
    this.Atc = "";
    this.Atd = "$nickname$";
    this.Apz = 20;
    this.Atf = 400;
    this.Atg = 20001;
    this.Ath = new a(this);
    AppMethodBeat.o(167455);
  }
  
  private void a(TextView paramTextView, Spannable paramSpannable)
  {
    AppMethodBeat.i(289592);
    p.k(paramTextView, "descTv");
    p.k(paramSpannable, "text");
    paramTextView.setOnTouchListener((View.OnTouchListener)new FinderModifyNameUI.f(this, paramSpannable, paramTextView));
    AppMethodBeat.o(289592);
  }
  
  private final void ag(String paramString1, final String paramString2, final String paramString3)
  {
    AppMethodBeat.i(289591);
    Log.i(this.TAG, "showError ".concat(String.valueOf(paramString1)));
    Object localObject = j.PATTERN.matcher((CharSequence)paramString1);
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
          AppMethodBeat.o(289591);
          throw paramString1;
        }
        String str2 = paramString1.substring(0, i);
        p.j(str2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
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
          AppMethodBeat.o(289591);
          throw paramString1;
        }
        paramString1 = paramString1.substring(i, j);
        p.j(paramString1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localStringBuilder.append(paramString1);
      }
      paramString1 = localStringBuilder.toString();
      p.j(paramString1, "sb.toString()");
      int i = ((Matcher)localObject).start(0);
      int j = str1.length();
      paramString1 = new SpannableString((CharSequence)paramString1);
      p.j(str1, "content");
      localObject = getContext();
      p.j(localObject, "context");
      int k = ((AppCompatActivity)localObject).getResources().getColor(b.c.Link);
      localObject = getContext();
      p.j(localObject, "context");
      paramString1.setSpan(new o(str1, k, ((AppCompatActivity)localObject).getResources().getColor(b.c.Link_Alpha_0_6), (kotlin.g.a.b)new g(this, paramString2, paramString3)), i, i + j, 17);
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
      }
      paramString2.setText((CharSequence)paramString1);
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
      }
      a(paramString2, (Spannable)paramString1);
    }
    for (;;)
    {
      paramString1 = this.Apo;
      if (paramString1 == null) {
        p.bGy("topErrorTip");
      }
      paramString1.setVisibility(0);
      AppMethodBeat.o(289591);
      return;
      paramString2 = this.Apo;
      if (paramString2 == null) {
        p.bGy("topErrorTip");
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
      return this.Apz;
    }
    return this.Atf;
  }
  
  private final void refreshView()
  {
    boolean bool2 = true;
    AppMethodBeat.i(167445);
    Object localObject = h.aHG();
    p.j(localObject, "MMKernel.storage()");
    int i = ((f)localObject).aHp().getInt(ar.a.Vzn, 0);
    Log.i(this.TAG, "user extFlag ".concat(String.valueOf(i)));
    if (this.scene == 1)
    {
      if ((i & 0x2) == 0) {
        break label132;
      }
      i = 1;
      localObject = this.AsY;
      if (localObject == null) {
        p.bGy("edit");
      }
      if (i != 0) {
        break label137;
      }
      bool1 = true;
      label90:
      ((EditText)localObject).setEnabled(bool1);
      localObject = this.Ata;
      if (localObject == null) {
        p.bGy("modifyBtn");
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
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(289595);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(289595);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(289594);
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
    AppMethodBeat.o(289594);
    return localView1;
  }
  
  public final void abc(String paramString)
  {
    AppMethodBeat.i(167446);
    int i = g.dq(getMaxLength(), paramString);
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(i));
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setTextColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
    if (i <= kotlin.k.i.ov((int)(getMaxLength() * 0.1F), 1))
    {
      paramString = this.AsZ;
      if (paramString == null) {
        p.bGy("editLimit");
      }
      paramString.setVisibility(0);
    }
    for (;;)
    {
      paramString = this.Apo;
      if (paramString == null) {
        p.bGy("topErrorTip");
      }
      paramString.setText((CharSequence)"");
      paramString = this.Apo;
      if (paramString == null) {
        p.bGy("topErrorTip");
      }
      paramString.setVisibility(8);
      AppMethodBeat.o(167446);
      return;
      paramString = this.AsZ;
      if (paramString == null) {
        p.bGy("editLimit");
      }
      paramString.setVisibility(4);
    }
  }
  
  public final void abd(String paramString)
  {
    AppMethodBeat.i(289590);
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setText((CharSequence)String.valueOf(getMaxLength()));
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setTextColor(getResources().getColor(b.c.BW_0_Alpha_0_3));
    AppMethodBeat.o(289590);
  }
  
  public final void dN(String paramString)
  {
    AppMethodBeat.i(167448);
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setText((CharSequence)"0");
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setVisibility(0);
    paramString = this.AsZ;
    if (paramString == null) {
      p.bGy("editLimit");
    }
    paramString.setTextColor(getResources().getColor(b.c.Red_100));
    AppMethodBeat.o(167448);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_modify_name_ui;
  }
  
  public final void h(boolean paramBoolean, int paramInt)
  {
    AppMethodBeat.i(167450);
    this.pIk = paramInt;
    if (paramBoolean)
    {
      localObject1 = this.TAG;
      localObject2 = new StringBuilder("keyboardHeight ").append(paramInt).append(", inputContainer.height ");
      View localView = this.ybx;
      if (localView == null) {
        p.bGy("inputContainer");
      }
      Log.i((String)localObject1, localView.getHeight());
      localObject1 = this.yOP;
      if (localObject1 == null) {
        p.bGy("edtContainer");
      }
      ((View)localObject1).addOnLayoutChangeListener((View.OnLayoutChangeListener)this.Ath);
      localObject1 = this.Ata;
      if (localObject1 == null) {
        p.bGy("modifyBtn");
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
      localObject2 = this.Ata;
      if (localObject2 == null) {
        p.bGy("modifyBtn");
      }
      ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.ybx;
      if (localObject1 == null) {
        p.bGy("inputContainer");
      }
      localObject1 = ((View)localObject1).getLayoutParams();
      if (localObject1 == null)
      {
        localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        AppMethodBeat.o(167450);
        throw ((Throwable)localObject1);
      }
      localObject1 = (FrameLayout.LayoutParams)localObject1;
      localObject2 = this.ybx;
      if (localObject2 == null) {
        p.bGy("inputContainer");
      }
      ((FrameLayout.LayoutParams)localObject1).height = (((View)localObject2).getHeight() - paramInt);
      localObject2 = this.ybx;
      if (localObject2 == null) {
        p.bGy("inputContainer");
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      localObject1 = this.ybx;
      if (localObject1 == null) {
        p.bGy("inputContainer");
      }
      ((View)localObject1).requestLayout();
      AppMethodBeat.o(167450);
      return;
    }
    Object localObject1 = this.yOP;
    if (localObject1 == null) {
      p.bGy("edtContainer");
    }
    ((View)localObject1).removeOnLayoutChangeListener((View.OnLayoutChangeListener)this.Ath);
    localObject1 = this.Ata;
    if (localObject1 == null) {
      p.bGy("modifyBtn");
    }
    localObject1 = ((Button)localObject1).getLayoutParams();
    if (localObject1 == null)
    {
      localObject1 = new kotlin.t("null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
      AppMethodBeat.o(167450);
      throw ((Throwable)localObject1);
    }
    localObject1 = (LinearLayout.LayoutParams)localObject1;
    ((LinearLayout.LayoutParams)localObject1).bottomMargin = getResources().getDimensionPixelSize(b.d.Edge_12A);
    Object localObject2 = this.Ata;
    if (localObject2 == null) {
      p.bGy("modifyBtn");
    }
    ((Button)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.ybx;
    if (localObject1 == null) {
      p.bGy("inputContainer");
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
    localObject2 = this.ybx;
    if (localObject2 == null) {
      p.bGy("inputContainer");
    }
    ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
    localObject1 = this.ybx;
    if (localObject1 == null) {
      p.bGy("inputContainer");
    }
    ((View)localObject1).requestLayout();
    localObject1 = this.ybx;
    if (localObject1 == null) {
      p.bGy("inputContainer");
    }
    ((View)localObject1).scrollTo(0, 0);
    AppMethodBeat.o(167450);
  }
  
  public final void initView()
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167444);
    setMMTitle("");
    setActionbarColor(getResources().getColor(b.c.white));
    getController().q((Activity)this, getResources().getColor(b.c.white));
    Object localObject3 = findViewById(b.f.finder_modify_name_container);
    p.j(localObject3, "findViewById(R.id.finder_modify_name_container)");
    this.yOP = ((View)localObject3);
    localObject3 = findViewById(b.f.finder_input_container);
    p.j(localObject3, "findViewById(R.id.finder_input_container)");
    this.ybx = ((View)localObject3);
    localObject3 = findViewById(b.f.finder_modify_title);
    p.j(localObject3, "findViewById(R.id.finder_modify_title)");
    this.titleTv = ((TextView)localObject3);
    localObject3 = findViewById(b.f.finder_edit);
    p.j(localObject3, "findViewById(R.id.finder_edit)");
    this.AsY = ((EditText)localObject3);
    localObject3 = findViewById(b.f.finder_edit_limit);
    p.j(localObject3, "findViewById(R.id.finder_edit_limit)");
    this.AsZ = ((TextView)localObject3);
    localObject3 = findViewById(b.f.edt_bottom_space);
    p.j(localObject3, "findViewById(R.id.edt_bottom_space)");
    this.Apm = ((View)localObject3);
    localObject3 = findViewById(b.f.finder_modify_btn);
    p.j(localObject3, "findViewById(R.id.finder_modify_btn)");
    this.Ata = ((Button)localObject3);
    localObject3 = findViewById(b.f.modify_max_tip);
    p.j(localObject3, "findViewById(R.id.modify_max_tip)");
    this.Atb = ((TextView)localObject3);
    localObject3 = findViewById(b.f.scroll_container);
    p.j(localObject3, "findViewById(R.id.scroll_container)");
    this.jbL = ((ScrollView)localObject3);
    localObject3 = findViewById(b.f.input_panel);
    p.j(localObject3, "findViewById(R.id.input_panel)");
    this.Apn = ((InputPanelFrameLayout)localObject3);
    localObject3 = findViewById(b.f.top_error_tip);
    p.j(localObject3, "findViewById(R.id.top_error_tip)");
    this.Apo = ((TextView)localObject3);
    localObject3 = this.Ata;
    if (localObject3 == null) {
      p.bGy("modifyBtn");
    }
    ((Button)localObject3).setOnClickListener((View.OnClickListener)new b(this));
    localObject3 = (TextWatcher)new e(this);
    Object localObject4 = this.AsY;
    if (localObject4 == null) {
      p.bGy("edit");
    }
    ((EditText)localObject4).addTextChangedListener((TextWatcher)localObject3);
    localObject3 = this.AsY;
    if (localObject3 == null) {
      p.bGy("edit");
    }
    ((EditText)localObject3).setOnTouchListener((View.OnTouchListener)new c(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new d(this));
    localObject3 = this.Apn;
    if (localObject3 == null) {
      p.bGy("inputPanel");
    }
    ((InputPanelFrameLayout)localObject3).setExternalListener((com.tencent.mm.ui.widget.c.a)this);
    switch (this.scene)
    {
    }
    for (;;)
    {
      refreshView();
      localObject1 = this.AsY;
      if (localObject1 == null) {
        p.bGy("edit");
      }
      ((EditText)localObject1).requestFocus();
      AppMethodBeat.o(167444);
      return;
      localObject1 = this.AsY;
      if (localObject1 == null) {
        p.bGy("edit");
      }
      ((EditText)localObject1).setMaxLines(2);
      localObject3 = this.AsY;
      if (localObject3 == null) {
        p.bGy("edit");
      }
      localObject4 = (Context)getContext();
      com.tencent.mm.plugin.finder.api.i locali = this.Ate;
      localObject1 = localObject2;
      if (locali != null) {
        localObject1 = locali.getNickname();
      }
      ((EditText)localObject3).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject4, (CharSequence)localObject1));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bGy("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(b.j.finder_modify_nickname_title));
      continue;
      localObject2 = this.titleTv;
      if (localObject2 == null) {
        p.bGy("titleTv");
      }
      ((TextView)localObject2).setText((CharSequence)getString(b.j.finder_modify_signature_title));
      localObject2 = this.AsY;
      if (localObject2 == null) {
        p.bGy("edit");
      }
      ((EditText)localObject2).setMaxLines(5);
      localObject2 = this.AsY;
      if (localObject2 == null) {
        p.bGy("edit");
      }
      localObject3 = (Context)getContext();
      localObject4 = this.Ate;
      if (localObject4 != null) {
        localObject1 = ((com.tencent.mm.plugin.finder.api.i)localObject4).field_signature;
      }
      ((EditText)localObject2).setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject3, (CharSequence)localObject1));
    }
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(289589);
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    Object localObject1;
    Object localObject2;
    label264:
    String str;
    if (paramInt1 == this.Atg)
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
            paramIntent = new cse();
            paramIntent.parseFrom((byte[])localObject1);
            if (paramIntent == null) {
              break label633;
            }
            if (Util.isNullOrNil(paramIntent.nickname)) {
              break label621;
            }
            localObject1 = this.AsY;
            if (localObject1 == null) {
              p.bGy("edit");
            }
            paramInt2 = ((EditText)localObject1).getSelectionEnd();
            localObject1 = this.AsY;
            if (localObject1 == null) {
              p.bGy("edit");
            }
            localObject2 = ((EditText)localObject1).getText().toString();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (this.scene != 2) {
              break label409;
            }
            localObject1 = this.AsY;
            if (localObject1 == null) {
              p.bGy("edit");
            }
            i = ((EditText)localObject1).getSelectionEnd();
            paramInt1 = paramInt2;
            localObject1 = localObject2;
            if (i <= 0) {
              break label409;
            }
            paramInt1 = i - 1;
            paramInt2 = 1;
            if ((paramInt1 < 0) || (paramInt2 == 0)) {
              break;
            }
            localObject1 = this.AsY;
            if (localObject1 == null) {
              p.bGy("edit");
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
          AppMethodBeat.o(289589);
          throw paramIntent;
        }
        str = ((String)localObject2).substring(0, paramInt1);
        p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = ((StringBuilder)localObject1).append(str);
        paramInt2 = ((String)localObject2).length();
        if (localObject2 == null)
        {
          paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
          AppMethodBeat.o(289589);
          throw paramIntent;
        }
        localObject2 = ((String)localObject2).substring(i, paramInt2);
        p.j(localObject2, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        localObject1 = (String)localObject2;
        label409:
        if (paramInt1 <= ((String)localObject1).length()) {
          break label640;
        }
        paramInt1 = ((String)localObject1).length();
      }
    }
    label640:
    for (;;)
    {
      localObject2 = new StringBuilder();
      if (localObject1 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(289589);
        throw paramIntent;
      }
      str = ((String)localObject1).substring(0, paramInt1);
      p.j(str, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject2 = ((StringBuilder)localObject2).append(str).append('@').append(paramIntent.nickname).append(' ');
      paramInt2 = ((String)localObject1).length();
      if (localObject1 == null)
      {
        paramIntent = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(289589);
        throw paramIntent;
      }
      localObject1 = ((String)localObject1).substring(paramInt1, paramInt2);
      p.j(localObject1, "(this as java.lang.Strin…ing(startIndex, endIndex)");
      localObject1 = (String)localObject1;
      paramIntent = paramIntent.nickname;
      if (paramIntent != null) {}
      for (paramInt2 = paramIntent.length();; paramInt2 = 0)
      {
        paramIntent = this.AsY;
        if (paramIntent == null) {
          p.bGy("edit");
        }
        paramIntent.setText((CharSequence)localObject1);
        paramIntent = this.AsY;
        if (paramIntent == null) {
          p.bGy("edit");
        }
        paramIntent.setSelection(paramInt2 + paramInt1 + 2);
        label621:
        AppMethodBeat.o(289589);
        return;
      }
      label633:
      AppMethodBeat.o(289589);
      return;
    }
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167443);
    super.onCreate(paramBundle);
    paramBundle = d.wZQ;
    this.Ate = d.a.aAK(z.bdh());
    this.scene = getIntent().getIntExtra("key_scene", 0);
    initView();
    h.aGY().a(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167443);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(167452);
    super.onDestroy();
    h.aGY().b(3761, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(167452);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(167451);
    super.onResume();
    ch localch = new ch(2);
    h.aGY().b((com.tencent.mm.an.q)localch);
    AppMethodBeat.o(167451);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
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
    ble localble;
    if ((paramString.intValue() == 3761) && (paramInt1 == 0) && (paramInt2 == 0))
    {
      if (paramq == null)
      {
        paramString = new kotlin.t("null cannot be cast to non-null type com.tencent.mm.plugin.finder.cgi.NetSceneFinderPrepareUser");
        AppMethodBeat.o(167453);
        throw paramString;
      }
      localble = ((ch)paramq).dnR();
      if (localble != null)
      {
        paramString = localble.SVZ;
        if (paramString != null)
        {
          if (this.scene != 1) {
            break label290;
          }
          paramInt1 = i;
          if (paramInt1 == 0) {
            break label295;
          }
        }
      }
    }
    for (;;)
    {
      if (paramString != null)
      {
        paramString = this.Atb;
        if (paramString == null) {
          p.bGy("modifyCountTip");
        }
        paramString.setText((CharSequence)((ch)paramq).dnR().SVZ);
        paramString = this.Atb;
        if (paramString == null) {
          p.bGy("modifyCountTip");
        }
        paramString.setVisibility(0);
      }
      if (localble.Apz > 0) {
        this.Apz = localble.Apz;
      }
      if (localble.Atf > 0) {
        this.Atf = localble.Atf;
      }
      paramq = localble.SWp;
      paramString = paramq;
      if (paramq == null) {
        paramString = "";
      }
      this.Atc = paramString;
      refreshView();
      AppMethodBeat.o(167453);
      return;
      label290:
      paramInt1 = 0;
      break;
      label295:
      paramString = null;
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$edtLayoutListener$1", "Landroid/view/View$OnLayoutChangeListener;", "onLayoutChange", "", "v", "Landroid/view/View;", "left", "", "top", "right", "bottom", "oldLeft", "oldTop", "oldRight", "oldBottom", "plugin-finder_release"})
  public static final class a
    implements View.OnLayoutChangeListener
  {
    public final void onLayoutChange(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6, int paramInt7, int paramInt8)
    {
      AppMethodBeat.i(167437);
      if (paramInt8 != paramInt4)
      {
        paramInt1 = this.Ati.getResources().getDimensionPixelSize(b.d.Edge_A);
        if (paramInt8 < paramInt4)
        {
          if (FinderModifyNameUI.j(this.Ati).getHeight() < paramInt1)
          {
            FinderModifyNameUI.j(this.Ati).scrollBy(0, paramInt4 - paramInt8);
            AppMethodBeat.o(167437);
          }
        }
        else if (FinderModifyNameUI.j(this.Ati).getScrollY() > 0) {
          FinderModifyNameUI.j(this.Ati).scrollBy(0, paramInt4 - paramInt8);
        }
      }
      AppMethodBeat.o(167437);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(167438);
      Object localObject1 = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject1).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject1).aFi());
      paramView = com.tencent.mm.plugin.findersdk.c.a.Bwg;
      if (com.tencent.mm.plugin.findersdk.c.a.aGS("personalInfo"))
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167438);
        return;
      }
      Log.i(FinderModifyNameUI.a(this.Ati), "doClick create contact btn");
      localObject1 = new aa.f();
      paramView = FinderModifyNameUI.b(this.Ati).getText().toString();
      if (paramView == null)
      {
        paramView = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(167438);
        throw paramView;
      }
      ((aa.f)localObject1).aaBC = n.bb((CharSequence)paramView).toString();
      Object localObject2 = (String)((aa.f)localObject1).aaBC;
      paramView = FinderModifyNameUI.c(this.Ati);
      if (paramView != null)
      {
        paramView = paramView.getNickname();
        if (!(p.h(localObject2, paramView) ^ true)) {
          break label328;
        }
        if (FinderModifyNameUI.d(this.Ati) != 1) {
          break label300;
        }
        paramView = n.l(FinderModifyNameUI.e(this.Ati), FinderModifyNameUI.f(this.Ati), (String)((aa.f)localObject1).aaBC, true);
        localObject2 = new f.a(MMApplicationContext.getContext());
        ((f.a)localObject2).bBl(paramView).HL(true);
        ((f.a)localObject2).bBp(this.Ati.getString(b.j.finder_confirm_change_name));
        ((f.a)localObject2).bBq(this.Ati.getString(b.j.finder_confirm_change_name_cancel));
        ((f.a)localObject2).b((f.c)new f.c()
        {
          public final void g(boolean paramAnonymousBoolean, String paramAnonymousString)
          {
            AppMethodBeat.i(281015);
            p.k(paramAnonymousString, "s");
            FinderModifyNameUI.a(this.Atj.Ati, (String)this.Atk.aaBC);
            AppMethodBeat.o(281015);
          }
        });
        ((f.a)localObject2).show();
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(167438);
        return;
        paramView = null;
        break;
        label300:
        if (FinderModifyNameUI.d(this.Ati) == 2)
        {
          FinderModifyNameUI.a(this.Ati, (String)((aa.f)localObject1).aaBC);
          continue;
          label328:
          this.Ati.finish();
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class c
    implements View.OnTouchListener
  {
    c(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(167439);
      if (p.h(paramView, FinderModifyNameUI.b(this.Ati)))
      {
        p.j(paramMotionEvent, "event");
        switch (paramMotionEvent.getActionMasked())
        {
        }
      }
      for (;;)
      {
        AppMethodBeat.o(167439);
        return false;
        FinderModifyNameUI.i(this.Ati).requestDisallowInterceptTouchEvent(true);
        continue;
        FinderModifyNameUI.i(this.Ati).requestDisallowInterceptTouchEvent(false);
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class d
    implements MenuItem.OnMenuItemClickListener
  {
    d(FinderModifyNameUI paramFinderModifyNameUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167440);
      this.Ati.finish();
      AppMethodBeat.o(167440);
      return true;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderModifyNameUI$initView$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      int i = 0;
      AppMethodBeat.i(167441);
      c.i(FinderModifyNameUI.b(this.Ati)).mM(1, FinderModifyNameUI.g(this.Ati)).b(g.a.XSu).Hh(true).a((com.tencent.mm.ui.tools.b.c.a)this.Ati);
      if ((FinderModifyNameUI.d(this.Ati) == 2) && (paramEditable != null))
      {
        Object localObject = (ForegroundColorSpan[])paramEditable.getSpans(0, paramEditable.length(), ForegroundColorSpan.class);
        p.j(localObject, "spans");
        int j = localObject.length;
        while (i < j)
        {
          paramEditable.removeSpan(localObject[i]);
          i += 1;
        }
        localObject = e.ACV;
        e.a(paramEditable.toString(), (kotlin.g.a.q)new FinderModifyNameUI.e.a(paramEditable));
      }
      AppMethodBeat.o(167441);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
    {
      AppMethodBeat.i(275984);
      if ((FinderModifyNameUI.d(this.Ati) == 2) && (paramInt3 == 1))
      {
        if (paramCharSequence != null) {}
        for (paramCharSequence = n.w(paramCharSequence, paramInt1); paramCharSequence == null; paramCharSequence = null)
        {
          AppMethodBeat.o(275984);
          return;
        }
        if (paramCharSequence.charValue() == '@')
        {
          Log.i(FinderModifyNameUI.a(this.Ati), "at auto goto");
          paramCharSequence = new Intent();
          paramCharSequence.putExtra("key_scene", 2);
          paramCharSequence.putExtra("KEY_ENTER_SCENE", 1);
          com.tencent.mm.plugin.finder.utils.a locala = com.tencent.mm.plugin.finder.utils.a.ACH;
          com.tencent.mm.plugin.finder.utils.a.c((MMActivity)this.Ati, paramCharSequence, FinderModifyNameUI.h(this.Ati));
        }
      }
      AppMethodBeat.o(275984);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "", "invoke"})
  static final class g
    extends kotlin.g.b.q
    implements kotlin.g.a.b<String, x>
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