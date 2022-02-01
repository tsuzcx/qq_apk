package com.tencent.mm.plugin.finder.live.viewmodel.component;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.live.report.k;
import com.tencent.mm.plugin.finder.live.report.s.ak;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.viewmodel.component.aj.a;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.arp;
import com.tencent.mm.protocal.protobuf.bbh;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.s;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.component.UIComponent;
import com.tencent.mm.ui.tools.g.a;
import com.tencent.mm.ui.widget.MMEditText;
import java.util.ArrayList;
import java.util.List;
import kotlin.a.j;
import kotlin.f;
import kotlin.g.b.aa.f;
import kotlin.g.b.p;
import kotlin.r;
import kotlin.x;

@kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC;", "Lcom/tencent/mm/ui/component/UIComponent;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "activity", "Landroidx/appcompat/app/AppCompatActivity;", "(Landroidx/appcompat/app/AppCompatActivity;)V", "MAX_INPUT_LENGTH", "", "getMAX_INPUT_LENGTH", "()I", "MAX_INPUT_SIZE", "getMAX_INPUT_SIZE", "TAG", "", "contact", "Lcom/tencent/mm/protocal/protobuf/FinderContact;", "dialog", "Lcom/tencent/mm/ui/base/MMProgressDialog;", "getDialog", "()Lcom/tencent/mm/ui/base/MMProgressDialog;", "setDialog", "(Lcom/tencent/mm/ui/base/MMProgressDialog;)V", "isFromProfile", "", "mAuthView", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "getMAuthView", "()Landroid/widget/ImageView;", "mAuthView$delegate", "Lkotlin/Lazy;", "mAvatarView", "getMAvatarView", "mAvatarView$delegate", "mBackBtn", "Landroid/widget/TextView;", "getMBackBtn", "()Landroid/widget/TextView;", "mBackBtn$delegate", "mConfirmBtn", "getMConfirmBtn", "mConfirmBtn$delegate", "mEditLayout", "Landroid/view/View;", "getMEditLayout", "()Landroid/view/View;", "mEditLayout$delegate", "mEditView", "Lcom/tencent/mm/ui/widget/MMEditText;", "getMEditView", "()Lcom/tencent/mm/ui/widget/MMEditText;", "mEditView$delegate", "mLimitText", "getMLimitText", "mLimitText$delegate", "mNameView", "getMNameView", "mNameView$delegate", "mNoticeTimeLayout", "getMNoticeTimeLayout", "mNoticeTimeLayout$delegate", "mNoticeTimeTxt", "getMNoticeTimeTxt", "mNoticeTimeTxt$delegate", "selectedNoticeTime", "afterCreateNotice", "", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderCreateLiveNoticeResponse;", "checkTextLimit", "doCreateFinderNotice", "startTime", "getLayoutId", "initData", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateLiveNote", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshTimeView", "firstIndex", "secIndex", "thirdIndex", "setWindowStyle", "showOrDimissLoading", "show", "cancelListener", "Landroid/content/DialogInterface$OnCancelListener;", "Companion", "plugin-finder_release"})
public final class c
  extends UIComponent
  implements com.tencent.mm.an.i
{
  private static final String zdN = "KEY_FINDER_LIVE_NOTICE_CONTACT";
  private static final String zdO = "KEY_FINDER_LIVE_NOTICE_INFO";
  private static final int zdP = 100;
  private static final String zdQ = "KEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE";
  public static final a zdR;
  private final int MAX_INPUT_SIZE;
  private final String TAG;
  private FinderContact contact;
  private boolean moh;
  s oTk;
  private final f ycj;
  private final f yck;
  private final f ycl;
  final int zbo;
  private final f zdF;
  private final f zdG;
  private final f zdH;
  private final f zdI;
  private final f zdJ;
  private final f zdK;
  private final f zdL;
  private int zdM;
  
  static
  {
    AppMethodBeat.i(279914);
    zdR = new a((byte)0);
    zdN = "KEY_FINDER_LIVE_NOTICE_CONTACT";
    zdO = "KEY_FINDER_LIVE_NOTICE_INFO";
    zdP = 100;
    zdQ = "KEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE";
    AppMethodBeat.o(279914);
  }
  
  public c(AppCompatActivity paramAppCompatActivity)
  {
    super(paramAppCompatActivity);
    AppMethodBeat.i(279913);
    this.TAG = "FinderLiveNoticeUIC";
    this.zdF = kotlin.g.ar((kotlin.g.a.a)new n(paramAppCompatActivity));
    this.ycj = kotlin.g.ar((kotlin.g.a.a)new m(paramAppCompatActivity));
    this.yck = kotlin.g.ar((kotlin.g.a.a)new s(paramAppCompatActivity));
    this.ycl = kotlin.g.ar((kotlin.g.a.a)new l(paramAppCompatActivity));
    this.zdG = kotlin.g.ar((kotlin.g.a.a)new q(paramAppCompatActivity));
    this.zdH = kotlin.g.ar((kotlin.g.a.a)new p(paramAppCompatActivity));
    this.zdI = kotlin.g.ar((kotlin.g.a.a)new t(paramAppCompatActivity));
    this.zdJ = kotlin.g.ar((kotlin.g.a.a)new u(paramAppCompatActivity));
    this.zdK = kotlin.g.ar((kotlin.g.a.a)new o(paramAppCompatActivity));
    this.zdL = kotlin.g.ar((kotlin.g.a.a)new r(paramAppCompatActivity));
    this.MAX_INPUT_SIZE = 60;
    this.zbo = (this.MAX_INPUT_SIZE * 2);
    AppMethodBeat.o(279913);
  }
  
  private final MMEditText dGr()
  {
    AppMethodBeat.i(279907);
    MMEditText localMMEditText = (MMEditText)this.zdG.getValue();
    AppMethodBeat.o(279907);
    return localMMEditText;
  }
  
  private final TextView dGs()
  {
    AppMethodBeat.i(279908);
    TextView localTextView = (TextView)this.zdJ.getValue();
    AppMethodBeat.o(279908);
    return localTextView;
  }
  
  private final void py(final boolean paramBoolean)
  {
    AppMethodBeat.i(279911);
    com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new w(this, paramBoolean, null));
    AppMethodBeat.o(279911);
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_notice_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(279909);
    super.onCreate(paramBundle);
    paramBundle = getIntent().getByteArrayExtra(zdN);
    if (paramBundle != null)
    {
      this.contact = new FinderContact();
      localObject1 = this.contact;
      if (localObject1 == null) {
        p.bGy("contact");
      }
      ((FinderContact)localObject1).parseFrom(paramBundle);
    }
    this.moh = getIntent().getBooleanExtra(zdQ, false);
    ((TextView)this.zdF.getValue()).setOnClickListener((View.OnClickListener)new e(this));
    paramBundle = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramBundle = com.tencent.mm.plugin.finder.loader.t.dJh();
    Object localObject1 = this.contact;
    if (localObject1 == null) {
      p.bGy("contact");
    }
    localObject1 = new e(((FinderContact)localObject1).headUrl);
    Object localObject2 = (ImageView)this.ycj.getValue();
    p.j(localObject2, "mAvatarView");
    com.tencent.mm.plugin.finder.loader.t localt = com.tencent.mm.plugin.finder.loader.t.ztT;
    paramBundle.a(localObject1, (ImageView)localObject2, com.tencent.mm.plugin.finder.loader.t.a(t.a.ztX));
    paramBundle = (TextView)this.yck.getValue();
    p.j(paramBundle, "mNameView");
    localObject1 = (Context)getActivity();
    localObject2 = this.contact;
    if (localObject2 == null) {
      p.bGy("contact");
    }
    paramBundle.setText((CharSequence)com.tencent.mm.pluginsdk.ui.span.l.c((Context)localObject1, (CharSequence)((FinderContact)localObject2).nickname));
    paramBundle = com.tencent.mm.plugin.finder.utils.aj.AGc;
    paramBundle = (ImageView)this.ycl.getValue();
    p.j(paramBundle, "mAuthView");
    localObject1 = this.contact;
    if (localObject1 == null) {
      p.bGy("contact");
    }
    com.tencent.mm.plugin.finder.utils.aj.a(paramBundle, ((FinderContact)localObject1).authInfo);
    ((View)this.zdI.getValue()).setOnClickListener((View.OnClickListener)new f(this));
    ((TextView)this.zdK.getValue()).setOnClickListener((View.OnClickListener)new g(this));
    dGs().post((Runnable)new h(this));
    ((View)this.zdH.getValue()).setOnClickListener((View.OnClickListener)new i(this));
    paramBundle = (InputFilter)new k(this);
    localObject1 = (InputFilter)new com.tencent.mm.ui.tools.g(this.zbo, g.a.XSu);
    localObject2 = dGr();
    p.j(localObject2, "mEditView");
    ((MMEditText)localObject2).setFilters(new InputFilter[] { paramBundle, localObject1 });
    dGr().addTextChangedListener((TextWatcher)new j(this));
    h.aGY().a(6653, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(279909);
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(279910);
    super.onDestroy();
    h.aGY().b(6653, (com.tencent.mm.an.i)this);
    AppMethodBeat.o(279910);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, com.tencent.mm.an.q paramq)
  {
    AppMethodBeat.i(279912);
    Log.i(this.TAG, "errType " + paramInt1 + ", errCode " + paramInt2 + ", errMsg " + paramString);
    py(false);
    if ((paramInt1 == 0) && (paramInt2 == 0) && ((paramq instanceof ax)))
    {
      final arp localarp = ((ax)paramq).dnW();
      s.ak localak;
      if (this.moh)
      {
        com.tencent.mm.ae.d.a(500L, (kotlin.g.a.a)new b(this, localarp));
        paramString = k.yBj;
        localak = s.ak.yJb;
        paramString = localarp.live_notice_info;
        if (paramString != null)
        {
          paramq = paramString.SNb;
          paramString = paramq;
          if (paramq != null) {}
        }
        else
        {
          paramString = "";
        }
        k.a(localak, "", paramString);
        AppMethodBeat.o(279912);
        return;
      }
      if (localarp.live_notice_info != null)
      {
        paramString = k.yBj;
        localak = s.ak.yJa;
        paramString = localarp.live_notice_info;
        if (paramString != null)
        {
          paramInt1 = paramString.fod;
          label192:
          long l = paramInt1;
          paramString = localarp.live_notice_info;
          if (paramString != null)
          {
            paramq = paramString.SNb;
            paramString = paramq;
            if (paramq != null) {}
          }
          else
          {
            paramString = "";
          }
          k.a(localak, String.valueOf(l * 1000L), paramString);
        }
      }
      else
      {
        paramq = new Intent();
        paramq.putExtra("finder_username", z.bdh());
        paramq.putExtra("KEY_FINDER_SELF_FLAG", true);
        if (localarp == null) {
          break label361;
        }
        paramString = localarp.live_notice_info;
        if (paramString == null) {
          break label361;
        }
      }
      label361:
      for (paramString = paramString.toByteArray();; paramString = null)
      {
        paramq.putExtra("KEY_FINDER_LIVE_NOTICE_INFO", paramString);
        paramString = com.tencent.mm.plugin.finder.viewmodel.component.aj.Bnu;
        aj.a.a((Context)getActivity(), paramq, 0L, 0, false, 124);
        paramString = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.enterFinderProfileUI((Context)getActivity(), paramq);
        com.tencent.mm.ae.d.a(500L, (kotlin.g.a.a)new c(this));
        break;
        paramInt1 = 0;
        break label192;
      }
    }
    w.w((Context)getActivity(), getActivity().getResources().getString(b.j.finder_live_notice_create_failed), b.i.icons_filled_info);
    AppMethodBeat.o(279912);
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$Companion;", "", "()V", "KEY_FINDER_LIVE_NOTICE_CONTACT", "", "getKEY_FINDER_LIVE_NOTICE_CONTACT", "()Ljava/lang/String;", "KEY_FINDER_LIVE_NOTICE_INFO", "getKEY_FINDER_LIVE_NOTICE_INFO", "KEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE", "getKEY_FINDER_LIVE_NOTICE_IS_FROM_PROFILE", "REQUEST_CODE_ENTER_LIVE_NOTICE_UI", "", "getREQUEST_CODE_ENTER_LIVE_NOTICE_UI", "()I", "plugin-finder_release"})
  public static final class a {}
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class b
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    b(c paramc, arp paramarp)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class c
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    c(c paramc)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$checkTextLimit$1", "Lcom/tencent/mm/ui/tools/legalchecker/InputTextBoundaryCheck$DoAfterCheck;", "doWhenLess", "", "text", "", "doWhenMore", "doWhenOK", "plugin-finder_release"})
  public static final class d
    implements com.tencent.mm.ui.tools.b.c.a
  {
    public final void abc(String paramString)
    {
      AppMethodBeat.i(284504);
      int i = kotlin.k.i.ov(com.tencent.mm.ui.tools.g.dq(this.zdS.zbo, paramString) / 2, 0);
      paramString = c.e(this.zdS);
      p.j(paramString, "mLimitText");
      paramString.setText((CharSequence)String.valueOf(i));
      AppMethodBeat.o(284504);
    }
    
    public final void abd(String paramString) {}
    
    public final void dN(String paramString)
    {
      AppMethodBeat.i(284502);
      paramString = c.e(this.zdS);
      p.j(paramString, "mLimitText");
      paramString.setText((CharSequence)"0");
      AppMethodBeat.o(284502);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291911);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.zdS.getActivity().finish();
      this.zdS.getActivity().overridePendingTransition(com.tencent.mm.plugin.finder.b.a.anim_not_change, com.tencent.mm.plugin.finder.b.a.sight_slide_bottom_out);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(291911);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class f
    implements View.OnClickListener
  {
    f(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(286688);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.a(this.zdS);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(286688);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class g
    implements View.OnClickListener
  {
    g(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(278012);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      c.a(this.zdS, c.b(this.zdS));
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(278012);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class h
    implements Runnable
  {
    h(c paramc) {}
    
    public final void run()
    {
      AppMethodBeat.i(267903);
      c.a(this.zdS, 1, 12, 0);
      AppMethodBeat.o(267903);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class i
    implements View.OnClickListener
  {
    i(c paramc) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(291273);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      c.c(this.zdS).requestFocus();
      if ((this.zdS.getActivity() instanceof MMActivity))
      {
        localObject = this.zdS.getActivity();
        paramView = (View)localObject;
        if (!(localObject instanceof MMActivity)) {
          paramView = null;
        }
        paramView = (MMActivity)paramView;
        if (paramView != null) {
          paramView.showVKB();
        }
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(291273);
        return;
        paramView = (InputMethodManager)this.zdS.getActivity().getSystemService("input_method");
        if (paramView != null) {
          paramView.showSoftInput((View)c.c(this.zdS), 0);
        }
      }
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/live/viewmodel/component/FinderLiveNoticeUIC$initView$6", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "p0", "", "p1", "", "p2", "p3", "onTextChanged", "plugin-finder_release"})
  public static final class j
    implements TextWatcher
  {
    public final void afterTextChanged(Editable paramEditable)
    {
      AppMethodBeat.i(264005);
      c.d(this.zdS);
      AppMethodBeat.o(264005);
    }
    
    public final void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
    
    public final void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "kotlin.jvm.PlatformType", "source", "start", "", "end", "dest", "Landroid/text/Spanned;", "dstart", "dend", "filter"})
  static final class k
    implements InputFilter
  {
    k(c paramc) {}
    
    public final CharSequence filter(CharSequence paramCharSequence, int paramInt1, int paramInt2, Spanned paramSpanned, int paramInt3, int paramInt4)
    {
      AppMethodBeat.i(291512);
      paramSpanned = c.c(this.zdS);
      p.j(paramSpanned, "mEditView");
      paramSpanned.getText();
      paramCharSequence = paramCharSequence.toString();
      paramSpanned = (CharSequence)"\n";
      if (paramCharSequence == null)
      {
        paramCharSequence = new kotlin.t("null cannot be cast to non-null type java.lang.String");
        AppMethodBeat.o(291512);
        throw paramCharSequence;
      }
      if (paramCharSequence.contentEquals(paramSpanned))
      {
        paramCharSequence = (CharSequence)"";
        AppMethodBeat.o(291512);
        return paramCharSequence;
      }
      AppMethodBeat.o(291512);
      return null;
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class l
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    l(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/ImageView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class m
    extends kotlin.g.b.q
    implements kotlin.g.a.a<ImageView>
  {
    m(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class n
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    n(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class o
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    o(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class p
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    p(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Lcom/tencent/mm/ui/widget/MMEditText;", "kotlin.jvm.PlatformType", "invoke"})
  static final class q
    extends kotlin.g.b.q
    implements kotlin.g.a.a<MMEditText>
  {
    q(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class r
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    r(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class s
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    s(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/view/View;", "kotlin.jvm.PlatformType", "invoke"})
  static final class t
    extends kotlin.g.b.q
    implements kotlin.g.a.a<View>
  {
    t(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "invoke"})
  static final class u
    extends kotlin.g.b.q
    implements kotlin.g.a.a<TextView>
  {
    u(AppCompatActivity paramAppCompatActivity)
    {
      super();
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "hasSetResult", "", "result", "", "kotlin.jvm.PlatformType", "secondResult", "thirdResult", "onResult"})
  static final class v<T>
    implements com.tencent.mm.ui.widget.picker.b.a<Object>
  {
    v(c paramc, com.tencent.mm.ui.widget.picker.b paramb, aa.f paramf) {}
    
    public final void a(boolean paramBoolean, Object paramObject1, Object paramObject2, Object paramObject3)
    {
      AppMethodBeat.i(271594);
      this.zdU.hide();
      List localList;
      if (paramBoolean)
      {
        try
        {
          localList = (List)((r)this.zdV.aaBC).Mx;
          if (paramObject1 != null) {
            break label76;
          }
          paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
          AppMethodBeat.o(271594);
          throw paramObject1;
        }
        catch (Throwable paramObject1)
        {
          Log.i(c.f(this.zdS), paramObject1.getMessage());
        }
      }
      else
      {
        AppMethodBeat.o(271594);
        return;
      }
      label76:
      int i = j.a(localList, (CharSequence)paramObject1);
      paramObject1 = ((ArrayList)((r)this.zdV.aaBC).My).get(i);
      p.j(paramObject1, "triple.second[firstChosenIndex]");
      paramObject1 = (List)paramObject1;
      if (paramObject2 == null)
      {
        paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(271594);
        throw paramObject1;
      }
      int j = j.a(paramObject1, (CharSequence)paramObject2);
      paramObject1 = ((ArrayList)((r)this.zdV.aaBC).aazK).get(j);
      p.j(paramObject1, "triple.third[secChosenIndex]");
      paramObject1 = (List)paramObject1;
      if (paramObject3 == null)
      {
        paramObject1 = new kotlin.t("null cannot be cast to non-null type kotlin.CharSequence");
        AppMethodBeat.o(271594);
        throw paramObject1;
      }
      int k = j.a(paramObject1, (CharSequence)paramObject3);
      c.a(this.zdS, i, j, k);
      AppMethodBeat.o(271594);
    }
  }
  
  @kotlin.l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class w
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    w(c paramc, boolean paramBoolean, DialogInterface.OnCancelListener paramOnCancelListener)
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.viewmodel.component.c
 * JD-Core Version:    0.7.0.1
 */