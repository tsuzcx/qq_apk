package com.tencent.mm.plugin.appbrand.phonenumber;

import a.f.b.j;
import a.f.b.y;
import a.l;
import a.l.m;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.a;
import android.support.v7.widget.RecyclerView.i;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.bn;
import com.tencent.mm.plugin.appbrand.config.WxaExposedParams.a;
import com.tencent.mm.plugin.appbrand.v;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.q.b;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "addPhoneLineV", "Landroid/view/View;", "addPhoneTv", "Landroid/widget/TextView;", "appId", "", "authDesc", "exposeTv", "itemAdapter", "Lcom/tencent/mm/plugin/appbrand/phonenumber/DeleteItemAdapter;", "listRv", "Landroid/support/v7/widget/RecyclerView;", "pagePath", "getPagePath", "()Ljava/lang/String;", "setPagePath", "(Ljava/lang/String;)V", "phoneItems", "Ljava/util/ArrayList;", "Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneItem;", "Lkotlin/collections/ArrayList;", "showDelete", "", "tipsTv", "getLayoutId", "", "initExpose", "", "initListView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onResume", "updateListView", "Companion", "plugin-appbrand-integration_release"})
@com.tencent.mm.ui.base.a(3)
public final class PhoneNumberManagerUI
  extends MMActivity
{
  public static final a iEq;
  private String appId;
  private String cmG;
  private boolean iDd;
  private final ArrayList<PhoneItem> iDe;
  private String iEj;
  private RecyclerView iEk;
  private TextView iEl;
  private View iEm;
  private TextView iEn;
  private TextView iEo;
  private i iEp;
  
  static
  {
    AppMethodBeat.i(134868);
    iEq = new a((byte)0);
    AppMethodBeat.o(134868);
  }
  
  public PhoneNumberManagerUI()
  {
    AppMethodBeat.i(134867);
    this.appId = "";
    this.iDe = new ArrayList();
    AppMethodBeat.o(134867);
  }
  
  public final int getLayoutId()
  {
    return 2130968706;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(134865);
    super.onCreate(paramBundle);
    setActionbarColor(-1);
    getContentView().setBackgroundColor(getActionbarColor());
    paramBundle = getIntent().getStringExtra("APPID");
    j.p(paramBundle, "intent.getStringExtra(APPID)");
    this.appId = paramBundle;
    this.iEj = getIntent().getStringExtra("AUTHDESC");
    this.cmG = getIntent().getStringExtra("PAGEPATH");
    this.iDd = getIntent().getBooleanExtra("SHOW_DELETE", false);
    ab.i("MicroMsg.PhoneNumberManagerUI", "onCreate() appId:%s showDelete:%b", new Object[] { this.appId, Boolean.valueOf(this.iDd) });
    b.a.a.a.a.a.a.a.a.CKU.azx(this.appId);
    if (this.iDd) {
      overridePendingTransition(2131034130, 2131034130);
    }
    this.iEk = ((RecyclerView)findViewById(2131821288));
    paramBundle = this.iEk;
    if (paramBundle != null) {
      paramBundle.setLayoutManager((RecyclerView.i)new LinearLayoutManager());
    }
    paramBundle = getContext();
    j.p(paramBundle, "context");
    this.iEp = new i((Context)paramBundle, this.iDe);
    paramBundle = this.iEp;
    if (paramBundle != null) {
      paramBundle.iDd = this.iDd;
    }
    paramBundle = this.iEk;
    if (paramBundle != null) {
      paramBundle.setAdapter((RecyclerView.a)this.iEp);
    }
    String str1 = getString(2131297166);
    paramBundle = y.BNt;
    paramBundle = getString(2131297167);
    j.p(paramBundle, "getString(R.string.appbr…mber_expose_slogan_start)");
    String str2 = String.format(paramBundle, Arrays.copyOf(new Object[] { str1 }, 1));
    j.p(str2, "java.lang.String.format(format, *args)");
    this.iEn = ((TextView)findViewById(2131821292));
    Object localObject2 = new WxaExposedParams.a();
    WxaExposedParams.a locala = ((WxaExposedParams.a)localObject2).AG(this.appId);
    Object localObject1 = this.cmG;
    paramBundle = (Bundle)localObject1;
    if (localObject1 == null) {
      paramBundle = "";
    }
    locala.AK(paramBundle).nz(8);
    localObject1 = new com.tencent.mm.plugin.appbrand.jsapi.a.a(v.b(((WxaExposedParams.a)localObject2).ayJ()));
    paramBundle = new SpannableString((CharSequence)str2);
    localObject2 = (CharSequence)str2;
    j.p(str1, "expose_desc_end");
    paramBundle.setSpan(localObject1, m.a((CharSequence)localObject2, str1, 0, false, 6), m.a((CharSequence)str2, str1, 0, false, 6) + str1.length(), 18);
    localObject1 = this.iEn;
    if (localObject1 != null) {
      ((TextView)localObject1).setMovementMethod(LinkMovementMethod.getInstance());
    }
    localObject1 = this.iEn;
    if (localObject1 != null) {
      ((TextView)localObject1).setText((CharSequence)paramBundle);
    }
    this.iEl = ((TextView)findViewById(2131821289));
    paramBundle = this.iEl;
    if (paramBundle != null) {
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
    }
    this.iEm = findViewById(2131821290);
    this.iEo = ((TextView)findViewById(2131821291));
    paramBundle = this.iEo;
    if (paramBundle != null)
    {
      paramBundle.setVisibility(4);
      AppMethodBeat.o(134865);
      return;
    }
    AppMethodBeat.o(134865);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(143967);
    super.onDestroy();
    b.a.a.a.a.a.a.a.a.CKU.afj(this.appId);
    AppMethodBeat.o(143967);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(134866);
    super.onResume();
    setMMTitle(2131297176);
    hideActionbarLine();
    this.iDe.clear();
    Object localObject1 = this.iDe;
    Object localObject2 = k.iDv;
    ((ArrayList)localObject1).addAll((Collection)k.aKP());
    localObject1 = this.iEp;
    if (localObject1 != null)
    {
      localObject2 = (List)this.iDe;
      j.q(localObject2, "phoneItems");
      ((i)localObject1).iDe = ((ArrayList)localObject2);
      ((i)localObject1).notifyDataSetChanged();
    }
    if ((this.iDd) || (this.iDe.size() >= 3))
    {
      localObject1 = this.iEl;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
      localObject1 = this.iEm;
      if (localObject1 != null) {
        ((View)localObject1).setVisibility(8);
      }
      if (!this.iDd) {
        break label244;
      }
      localObject1 = this.iEo;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(8);
      }
    }
    for (;;)
    {
      if (!this.iDd) {
        break label290;
      }
      addTextOptionMenu(0, getString(2131297168), (MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.c(this), null, q.b.zbA);
      setBackBtn((MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.d(this), 2131230739);
      AppMethodBeat.o(134866);
      return;
      localObject1 = this.iEl;
      if (localObject1 != null) {
        ((TextView)localObject1).setVisibility(0);
      }
      localObject1 = this.iEm;
      if (localObject1 == null) {
        break;
      }
      ((View)localObject1).setVisibility(0);
      break;
      label244:
      if (this.iDe.size() >= 3)
      {
        localObject1 = this.iEo;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(0);
        }
      }
      else
      {
        localObject1 = this.iEo;
        if (localObject1 != null) {
          ((TextView)localObject1).setVisibility(8);
        }
      }
    }
    label290:
    addTextOptionMenu(0, getString(2131297175), (MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.e(this), null, q.b.zbA);
    setBackBtn((MenuItem.OnMenuItemClickListener)new PhoneNumberManagerUI.f(this));
    AppMethodBeat.o(134866);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/appbrand/phonenumber/PhoneNumberManagerUI$Companion;", "", "()V", "APPID", "", "AUTH_DESC", "MAX_COUNT", "", "PAGE_PATH", "SHOWDELETE", "TAG", "editPhoneNumber", "", "context", "Landroid/content/Context;", "appId", "plugin-appbrand-integration_release"})
  public static final class a {}
  
  @l(eaO={1, 1, 13}, eaP={""}, eaQ={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(PhoneNumberManagerUI paramPhoneNumberManagerUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(134859);
      Object localObject = b.a.a.a.a.a.a.a.a.CKU.azy(PhoneNumberManagerUI.a(this.iEr));
      if (localObject != null)
      {
        paramView = b.a.a.a.a.a.a.a.a.CKU.azy(PhoneNumberManagerUI.a(this.iEr));
        if (paramView == null) {
          break label140;
        }
      }
      label140:
      for (paramView = Long.valueOf(paramView.GP());; paramView = null)
      {
        if (paramView == null) {
          j.ebi();
        }
        ((bn)localObject).ee(paramView.longValue() + 1L);
        paramView = PhoneNumberAddUI.iDA;
        paramView = this.iEr.getContext();
        j.p(paramView, "context");
        paramView = (Context)paramView;
        localObject = PhoneNumberManagerUI.a(this.iEr);
        j.q(paramView, "context");
        j.q(localObject, "appId");
        Intent localIntent = new Intent(paramView, PhoneNumberAddUI.class);
        localIntent.putExtra("APPID", (String)localObject);
        paramView.startActivity(localIntent);
        AppMethodBeat.o(134859);
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.appbrand.phonenumber.PhoneNumberManagerUI
 * JD-Core Version:    0.7.0.1
 */