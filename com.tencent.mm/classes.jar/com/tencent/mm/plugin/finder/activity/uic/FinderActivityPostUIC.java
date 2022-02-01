package com.tencent.mm.plugin.finder.activity.uic;

import android.arch.lifecycle.ViewModelProvider;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.loader.d;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.loader.g.j;
import com.tencent.mm.plugin.finder.cgi.cc;
import com.tencent.mm.plugin.finder.loader.m;
import com.tencent.mm.plugin.finder.loader.m.a;
import com.tencent.mm.plugin.finder.upload.k;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ao;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.widget.MMEditText;
import kotlin.g.b.p;

@kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroid/support/v7/app/AppCompatActivity;", "(Landroid/support/v7/app/AppCompatActivity;)V", "activityDesc", "", "activityName", "activityType", "", "avatarImage", "Landroid/widget/ImageView;", "cancelBtn", "Landroid/widget/TextView;", "cndCoverUrl", "descEdit", "Lcom/tencent/mm/ui/widget/MMEditText;", "isCoverSet", "", "localCoverUrl", "nameEdit", "nameLimit", "nickName", "nickNameText", "postBtn", "Landroid/widget/Button;", "scrollView", "Landroid/widget/ScrollView;", "titleText", "userName", "cancelActivity", "", "doPost", "doScene", "task", "Lcom/tencent/mm/loader/loader/IWorkTask;", "getActivityName", "initEdit", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onGetTopicIdSuccess", "eventTopicId", "", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "setCoverStyle", "setNormalStyle", "setPostBtnStatus", "isEnabled", "setTextColor", "color", "plugin-finder_release"})
public final class FinderActivityPostUIC
  extends UIComponent
  implements i
{
  private String activityName;
  private ScrollView gxx;
  private TextView kaq;
  private String nickName;
  private ImageView tqQ;
  private TextView tqS;
  private boolean trA;
  private String trB;
  private String trC;
  private int trD;
  private String trk;
  private final int trv;
  private TextView trw;
  private MMEditText trx;
  private MMEditText jdField_try;
  private Button trz;
  private String userName;
  
  public FinderActivityPostUIC(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(242105);
    this.trv = 10;
    this.nickName = "";
    this.userName = "";
    this.activityName = "";
    this.trk = "";
    this.trB = "";
    this.trC = "";
    this.trD = 101;
    AppMethodBeat.o(242105);
  }
  
  private final void e(c paramc)
  {
    AppMethodBeat.i(242101);
    String str = getActivityName();
    Object localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    if ((paramc instanceof k)) {}
    for (paramc = ((k)paramc).coverUrl;; paramc = "")
    {
      this.trB = paramc;
      g.azz().b((q)new cc(this.userName, str, (String)localObject, this.trB));
      AppMethodBeat.o(242101);
      return;
    }
  }
  
  private final String getActivityName()
  {
    AppMethodBeat.i(242100);
    Object localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    localObject = ((MMEditText)localObject).getText().toString();
    AppMethodBeat.o(242100);
    return localObject;
  }
  
  private final void mN(boolean paramBoolean)
  {
    AppMethodBeat.i(242098);
    Button localButton1 = this.trz;
    if (localButton1 == null) {
      p.btv("postBtn");
    }
    Button localButton2 = this.trz;
    if (localButton2 == null) {
      p.btv("postBtn");
    }
    localButton2.setEnabled(paramBoolean);
    if (this.trA)
    {
      if (paramBoolean)
      {
        localButton1.setTextColor(localButton1.getResources().getColor(2131099844));
        AppMethodBeat.o(242098);
        return;
      }
      localButton1.setTextColor(Color.parseColor("#7f9e9e9e"));
      AppMethodBeat.o(242098);
      return;
    }
    if (paramBoolean)
    {
      localButton1.setTextColor(localButton1.getResources().getColor(2131099672));
      AppMethodBeat.o(242098);
      return;
    }
    localButton1.setTextColor(localButton1.getResources().getColor(2131100577));
    AppMethodBeat.o(242098);
  }
  
  private final void setTextColor(int paramInt)
  {
    AppMethodBeat.i(242104);
    Object localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject).setTextColor(paramInt);
    localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject).setTextColor(paramInt);
    localObject = this.trw;
    if (localObject == null) {
      p.btv("titleText");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.kaq;
    if (localObject == null) {
      p.btv("cancelBtn");
    }
    ((TextView)localObject).setTextColor(paramInt);
    localObject = this.trz;
    if (localObject == null) {
      p.btv("postBtn");
    }
    ((Button)localObject).setTextColor(paramInt);
    if (!Util.isNullOrNil(this.activityName)) {}
    for (boolean bool = true;; bool = false)
    {
      mN(bool);
      AppMethodBeat.o(242104);
      return;
    }
  }
  
  public final void cXo()
  {
    boolean bool = false;
    AppMethodBeat.i(242103);
    this.trA = false;
    setTextColor(getResources().getColor(2131100044));
    Object localObject = this.tqS;
    if (localObject == null) {
      p.btv("nickNameText");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131099746));
    localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(2131232683);
    localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(2131099662));
    localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(2131232683);
    localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(2131099662));
    localObject = this.trz;
    if (localObject == null) {
      p.btv("postBtn");
    }
    ((Button)localObject).setBackgroundResource(2131232467);
    if (!Util.isNullOrNil(this.activityName)) {
      bool = true;
    }
    mN(bool);
    AppMethodBeat.o(242103);
  }
  
  public final void cXx()
  {
    AppMethodBeat.i(242102);
    this.trA = true;
    int i = getResources().getColor(2131100406);
    Object localObject = this.tqS;
    if (localObject == null) {
      p.btv("nickNameText");
    }
    ((TextView)localObject).setTextColor(getResources().getColor(2131099679));
    setTextColor(i);
    localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(2131232684);
    localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject).setBackgroundResource(2131232684);
    localObject = this.trz;
    if (localObject == null) {
      p.btv("postBtn");
    }
    ((Button)localObject).setBackgroundResource(2131232468);
    localObject = this.trx;
    if (localObject == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(2131100409));
    localObject = this.jdField_try;
    if (localObject == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject).setHintTextColor(getResources().getColor(2131100409));
    AppMethodBeat.o(242102);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(242096);
    super.onCreate(paramBundle);
    paramBundle = getActivity().findViewById(2131300763);
    p.g(paramBundle, "activity.findViewById(R.…der_activity_post_scroll)");
    this.gxx = ((ScrollView)paramBundle);
    Object localObject1 = getIntent().getStringExtra("key_nick_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.nickName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_user_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.userName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_name");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.activityName = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_desc");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.trk = paramBundle;
    localObject1 = getIntent().getStringExtra("key_activity_local_cover_url");
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    this.trC = paramBundle;
    this.trD = getIntent().getIntExtra("key_activity_type", 101);
    this.trA = Util.isNullOrNil(this.trC);
    g.azz().a(4050, (i)this);
    paramBundle = com.tencent.mm.pluginsdk.ui.span.l.c((Context)getActivity(), (CharSequence)this.nickName).toString();
    p.g(paramBundle, "MMSpanManager.spanForSmi…this.nickName).toString()");
    localObject1 = getActivity().findViewById(2131300754);
    ((TextView)localObject1).setOnClickListener((View.OnClickListener)new c(this));
    p.g(localObject1, "activity.findViewById<Te…)\n            }\n        }");
    this.kaq = ((TextView)localObject1);
    localObject1 = getActivity().findViewById(2131300764);
    p.g(localObject1, "activity.findViewById(R.…nder_activity_post_title)");
    this.trw = ((TextView)localObject1);
    localObject1 = this.trw;
    if (localObject1 == null) {
      p.btv("titleText");
    }
    ao.a((Paint)((TextView)localObject1).getPaint(), 0.8F);
    localObject1 = getActivity();
    Object localObject2 = ((AppCompatActivity)localObject1).findViewById(2131300762);
    p.g(localObject2, "findViewById(R.id.finder_activity_post_name_edit)");
    this.trx = ((MMEditText)localObject2);
    if (!TextUtils.isEmpty((CharSequence)this.activityName))
    {
      localObject2 = this.trx;
      if (localObject2 == null) {
        p.btv("nameEdit");
      }
      ((MMEditText)localObject2).setText((CharSequence)this.activityName);
    }
    localObject2 = ((AppCompatActivity)localObject1).findViewById(2131300758);
    p.g(localObject2, "findViewById(R.id.finder_activity_post_desc_edit)");
    this.jdField_try = ((MMEditText)localObject2);
    if (!TextUtils.isEmpty((CharSequence)this.trk))
    {
      localObject2 = this.jdField_try;
      if (localObject2 == null) {
        p.btv("descEdit");
      }
      ((MMEditText)localObject2).setText((CharSequence)this.trk);
    }
    localObject2 = ((AppCompatActivity)localObject1).findViewById(2131296475);
    p.g(localObject2, "findViewById(R.id.activity_profile_header_name)");
    this.tqS = ((TextView)localObject2);
    localObject1 = ((AppCompatActivity)localObject1).findViewById(2131296472);
    p.g(localObject1, "findViewById(R.id.activity_profile_header_avatar)");
    this.tqQ = ((ImageView)localObject1);
    localObject1 = this.tqS;
    if (localObject1 == null) {
      p.btv("nickNameText");
    }
    ((TextView)localObject1).setText((CharSequence)paramBundle);
    localObject1 = getIntent().getStringExtra("key_avatar_url");
    paramBundle = m.uJa;
    paramBundle = m.dka();
    localObject1 = new com.tencent.mm.plugin.finder.loader.a((String)localObject1);
    localObject2 = this.tqQ;
    if (localObject2 == null) {
      p.btv("avatarImage");
    }
    m localm = m.uJa;
    paramBundle.a(localObject1, (ImageView)localObject2, m.a(m.a.uJe));
    paramBundle = new StringBuilder("nameEdit size ");
    localObject1 = this.trx;
    if (localObject1 == null) {
      p.btv("nameEdit");
    }
    paramBundle = paramBundle.append(((MMEditText)localObject1).getTextSize()).append("  descEdit size ");
    localObject1 = this.jdField_try;
    if (localObject1 == null) {
      p.btv("descEdit");
    }
    paramBundle.append(((MMEditText)localObject1).getTextSize());
    h.hkS();
    paramBundle = this.trx;
    if (paramBundle == null) {
      p.btv("nameEdit");
    }
    paramBundle.setFilters((InputFilter[])new InputFilter.LengthFilter[] { new InputFilter.LengthFilter(this.trv) });
    paramBundle = (View.OnTouchListener)new b(this);
    localObject1 = this.trx;
    if (localObject1 == null) {
      p.btv("nameEdit");
    }
    ((MMEditText)localObject1).setOnTouchListener(paramBundle);
    localObject1 = this.jdField_try;
    if (localObject1 == null) {
      p.btv("descEdit");
    }
    ((MMEditText)localObject1).setOnTouchListener(paramBundle);
    paramBundle = getActivity().findViewById(2131300753);
    p.g(paramBundle, "activity.findViewById(R.…finder_activity_post_btn)");
    this.trz = ((Button)paramBundle);
    paramBundle = this.trz;
    if (paramBundle == null) {
      p.btv("postBtn");
    }
    if (!Util.isNullOrNil(this.activityName)) {}
    for (boolean bool = true;; bool = false)
    {
      mN(bool);
      paramBundle.setOnClickListener((View.OnClickListener)new d(this));
      paramBundle = this.trx;
      if (paramBundle == null) {
        p.btv("nameEdit");
      }
      paramBundle.addTextChangedListener((TextWatcher)new e(this));
      AppMethodBeat.o(242096);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(242097);
    super.onDestroy();
    g.azz().b(4050, (i)this);
    AppMethodBeat.o(242097);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(242099);
    if ((paramq instanceof cc))
    {
      paramString = com.tencent.mm.ui.component.a.PRN;
      ((FinderActivitySelectCoverUIC)com.tencent.mm.ui.component.a.b(getActivity()).get(FinderActivitySelectCoverUIC.class)).cXy();
      mN(true);
      if ((paramInt1 == 0) && (paramInt2 == 0))
      {
        long l = ((cc)paramq).twd;
        paramString = getActivityName();
        paramq = this.jdField_try;
        if (paramq == null) {
          p.btv("descEdit");
        }
        String str = paramq.getText().toString();
        paramq = new Intent();
        paramq.putExtra("key_topic_id", l);
        paramq.putExtra("key_activity_name", paramString);
        paramq.putExtra("key_activity_desc", str);
        paramq.putExtra("key_activity_local_cover_url", this.trC);
        paramq.putExtra("key_cover_url", this.trB);
        paramq.putExtra("key_activity_type", 101);
        new StringBuilder("eventTopicId:").append(l).append("  name:").append(paramString).append("  desc:").append(str);
        h.hkS();
        paramString = getActivity();
        paramString.setResult(-1, paramq);
        if (!paramString.isFinishing()) {
          paramString.finish();
        }
        AppMethodBeat.o(242099);
        return;
      }
      u.makeText((Context)getActivity(), (CharSequence)"预创建失败", 0).show();
    }
    AppMethodBeat.o(242099);
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$doPost$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder_release"})
  public static final class a
    implements f<c>
  {
    public final void a(c paramc, j paramj)
    {
      AppMethodBeat.i(242091);
      p.h(paramc, "task");
      p.h(paramj, "status");
      if (paramj == j.ibx)
      {
        u.makeText((Context)this.trE.getActivity(), (CharSequence)this.trE.getString(2131760658), 0).show();
        paramc = com.tencent.mm.ui.component.a.PRN;
        ((FinderActivitySelectCoverUIC)com.tencent.mm.ui.component.a.b(this.trE.getActivity()).get(FinderActivitySelectCoverUIC.class)).cXy();
        FinderActivityPostUIC.a(this.trE, true);
        AppMethodBeat.o(242091);
        return;
      }
      u.makeText((Context)this.trE.getActivity(), (CharSequence)this.trE.getString(2131760660), 0).show();
      paramj = com.tencent.mm.ui.component.a.PRN;
      ((FinderActivitySelectCoverUIC)com.tencent.mm.ui.component.a.b(this.trE.getActivity()).get(FinderActivitySelectCoverUIC.class)).setCover(FinderActivityPostUIC.f(this.trE));
      FinderActivityPostUIC.a(this.trE, paramc);
      AppMethodBeat.o(242091);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "event", "Landroid/view/MotionEvent;", "onTouch"})
  static final class b
    implements View.OnTouchListener
  {
    b(FinderActivityPostUIC paramFinderActivityPostUIC) {}
    
    public final boolean onTouch(View paramView, MotionEvent paramMotionEvent)
    {
      AppMethodBeat.i(242092);
      if ((p.j(paramView, FinderActivityPostUIC.c(this.trE))) || (p.j(paramView, FinderActivityPostUIC.d(this.trE))))
      {
        if (paramMotionEvent == null) {
          break label64;
        }
        paramView = Integer.valueOf(paramMotionEvent.getActionMasked());
        if (paramView != null) {
          break label69;
        }
        label49:
        if (paramView != null) {
          break label90;
        }
      }
      label64:
      label69:
      label90:
      while (paramView.intValue() != 3)
      {
        if (paramView != null) {
          break label112;
        }
        for (;;)
        {
          AppMethodBeat.o(242092);
          return false;
          paramView = null;
          break;
          if (paramView.intValue() != 0) {
            break label49;
          }
          FinderActivityPostUIC.e(this.trE).requestDisallowInterceptTouchEvent(true);
        }
      }
      for (;;)
      {
        FinderActivityPostUIC.e(this.trE).requestDisallowInterceptTouchEvent(false);
        break;
        label112:
        if (paramView.intValue() != 1) {
          break;
        }
      }
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$1$1"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderActivityPostUIC paramFinderActivityPostUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242093);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderActivityPostUIC.a(this.trE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242093);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick", "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$2$1"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderActivityPostUIC paramFinderActivityPostUIC) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(242094);
      b localb = new b();
      localb.bm(paramView);
      com.tencent.mm.hellhoundlib.a.a.b("com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      FinderActivityPostUIC.b(this.trE);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$$inlined$apply$lambda$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(242094);
    }
  }
  
  @kotlin.l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/activity/uic/FinderActivityPostUIC$initView$3", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "", "start", "", "count", "after", "onTextChanged", "before", "plugin-finder_release"})
  public static final class e
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(242095);
      FinderActivityPostUIC localFinderActivityPostUIC = this.trE;
      if (!Util.isNullOrNil(String.valueOf(paramEditable))) {}
      for (boolean bool = true;; bool = false)
      {
        FinderActivityPostUIC.a(localFinderActivityPostUIC, bool);
        AppMethodBeat.o(242095);
        return;
      }
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.uic.FinderActivityPostUIC
 * JD-Core Version:    0.7.0.1
 */