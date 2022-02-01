package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.k;
import com.tencent.mm.loader.g.c;
import com.tencent.mm.loader.g.f;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.d;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.live.cgi.k.a;
import com.tencent.mm.plugin.finder.loader.e;
import com.tencent.mm.plugin.finder.loader.t;
import com.tencent.mm.plugin.finder.loader.t.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.g;
import com.tencent.mm.plugin.finder.upload.m;
import com.tencent.mm.plugin.findersdk.a.a;
import com.tencent.mm.protocal.protobuf.axc;
import com.tencent.mm.protocal.protobuf.bcn;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.ar;
import com.tencent.mm.ui.tools.h;
import com.tencent.mm.ui.tools.i;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.widget.a.f.c;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.x;

@com.tencent.mm.ui.base.a(32)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "TAG", "", "getTAG", "()Ljava/lang/String;", "avatarChoose", "Landroid/widget/ImageView;", "avatarGroup", "Landroid/view/View;", "avatarIv", "avatarPath", "avatarUrl", "confirmBtn", "Landroid/widget/Button;", "confirmBtnBottomMargin", "curAvatarUrl", "curNickname", "filterMyAvatarUrl", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "maxNickNameLength", "mySelfAvatarUrl", "nickNameStr", "nicknameClear", "nicknameEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "sourceType", "splitLine3", "adjustConfirmBtn", "", "show", "height", "continuePost", "getLayoutId", "getReportTag", "initConfigValue", "initConfirmBtnConfig", "initLayout", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "parseIntent", "setAvatar", "path", "setConfirmBtnStatus", "enable", "showAlertDialog", "title", "content", "buttonTitle", "plugin-finder-live_release"})
public final class FinderLiveCreateVisitorModeUI
  extends MMFinderUI
{
  final String TAG = "FinderLiveCreateVisitorModeUI";
  private HashMap _$_findViewCache;
  private i jij;
  private ImageView jiu;
  private String nfY;
  private Button raT;
  private int sourceType;
  private String wQa;
  private final int xOK = 1000;
  private final int xOL = 1001;
  private View xOM;
  private ImageView xON;
  private MMEditText xOO;
  private ImageView xOP;
  private View xOQ;
  private boolean xOR = true;
  private String xOS;
  private String xOT;
  private String xOU;
  private String xOV;
  private int xOW = 28;
  private int xOX;
  
  private final void ox(boolean paramBoolean)
  {
    AppMethodBeat.i(233047);
    Button localButton = this.raT;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    AppCompatActivity localAppCompatActivity;
    if (paramBoolean)
    {
      if (ar.isDarkMode())
      {
        localButton = this.raT;
        if (localButton != null)
        {
          localAppCompatActivity = getContext();
          p.j(localAppCompatActivity, "context");
          localButton.setTextColor(localAppCompatActivity.getResources().getColor(b.c.BW_100_Alpha_0_8));
          AppMethodBeat.o(233047);
          return;
        }
        AppMethodBeat.o(233047);
        return;
      }
      localButton = this.raT;
      if (localButton != null)
      {
        localAppCompatActivity = getContext();
        p.j(localAppCompatActivity, "context");
        localButton.setTextColor(localAppCompatActivity.getResources().getColor(b.c.White));
        AppMethodBeat.o(233047);
        return;
      }
      AppMethodBeat.o(233047);
      return;
    }
    if (ar.isDarkMode())
    {
      localButton = this.raT;
      if (localButton != null)
      {
        localAppCompatActivity = getContext();
        p.j(localAppCompatActivity, "context");
        localButton.setTextColor(localAppCompatActivity.getResources().getColor(b.c.BW_100_Alpha_0_2));
        AppMethodBeat.o(233047);
        return;
      }
      AppMethodBeat.o(233047);
      return;
    }
    localButton = this.raT;
    if (localButton != null)
    {
      localAppCompatActivity = getContext();
      p.j(localAppCompatActivity, "context");
      localButton.setTextColor(localAppCompatActivity.getResources().getColor(b.c.BW_0_Alpha_0_2));
      AppMethodBeat.o(233047);
      return;
    }
    AppMethodBeat.o(233047);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(233077);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(233077);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(233076);
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
    AppMethodBeat.o(233076);
    return localView1;
  }
  
  public final String dvl()
  {
    return this.TAG;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_live_create_visitor_role_ui;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(233055);
    if (paramInt1 == this.xOK)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.h((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bbW());
        getIntent().putExtra("key_source_img_path", paramIntent);
        paramIntent = com.tencent.mm.plugin.finder.utils.a.ACH;
        com.tencent.mm.plugin.finder.utils.a.c((Activity)this, getIntent(), this.xOL);
        AppMethodBeat.o(233055);
      }
    }
    else if ((paramInt1 == this.xOL) && (paramIntent != null) && (paramInt2 == -1))
    {
      this.wQa = paramIntent.getStringExtra("key_result_img_path");
      Log.i(this.TAG, "avatar path %s file length %d KB", new Object[] { this.wQa, Long.valueOf(com.tencent.mm.vfs.u.bBQ(this.wQa) / 1024L) });
      paramIntent = this.wQa;
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = BitmapUtil.extractThumbNail(paramIntent, 256, 256, false);
        if (paramIntent != null)
        {
          ImageView localImageView = this.jiu;
          if (localImageView != null)
          {
            localImageView.setImageBitmap(paramIntent);
            AppMethodBeat.o(233055);
            return;
          }
          AppMethodBeat.o(233055);
          return;
        }
      }
    }
    AppMethodBeat.o(233055);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int k = 1;
    int j = 0;
    AppMethodBeat.i(233039);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.c.a.a.a.a.a.Zlt;
    int i = ((Number)com.tencent.c.a.a.a.a.a.imi().aSr()).intValue();
    if ((i > 0) && (i < 2147483647)) {
      this.xOW = i;
    }
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this), b.i.icons_filled_back);
    paramBundle = com.tencent.c.a.a.a.a.a.Zlt;
    boolean bool;
    Object localObject;
    if (((Number)com.tencent.c.a.a.a.a.a.imj().aSr()).intValue() == 0)
    {
      bool = true;
      this.xOR = bool;
      Log.i(this.TAG, "initConfigValue filterMyAvatarUrl:" + this.xOR);
      paramBundle = getIntent();
      if (paramBundle == null) {
        break label764;
      }
      localObject = a.a.BuJ;
      paramBundle = paramBundle.getStringExtra(a.a.emM());
      label144:
      this.xOT = paramBundle;
      paramBundle = getIntent();
      if (paramBundle == null) {
        break label769;
      }
      localObject = a.a.BuJ;
      paramBundle = paramBundle.getStringExtra(a.a.emN());
      label171:
      this.xOS = paramBundle;
      paramBundle = getIntent();
      if (paramBundle == null) {
        break label774;
      }
      i = paramBundle.getIntExtra("KEY_SOURCE", 0);
      label194:
      this.sourceType = i;
      this.xOM = findViewById(b.f.avatar_group);
      this.jiu = ((ImageView)findViewById(b.f.avatar_iv));
      this.xON = ((ImageView)findViewById(b.f.visitor_choose_iv));
      this.xOO = ((MMEditText)findViewById(b.f.nickname_input_et));
      localObject = this.xOO;
      if (localObject != null)
      {
        paramBundle = this.xOT;
        if (paramBundle == null) {
          break label779;
        }
        paramBundle = (CharSequence)paramBundle;
        label277:
        ((MMEditText)localObject).setText(paramBundle);
      }
      this.xOP = ((ImageView)findViewById(b.f.nickname_clear_iv));
      paramBundle = this.xOP;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      }
      this.raT = ((Button)findViewById(b.f.confirm_btn));
      paramBundle = com.tencent.mm.am.q.bhP().TS(z.bcZ());
      p.j(paramBundle, "SubCoreAvatar.getImgFlag…etUsernameFromUserInfo())");
      this.xOU = paramBundle.bhI();
      paramBundle = (CharSequence)this.xOS;
      i = k;
      if (paramBundle != null)
      {
        if (paramBundle.length() != 0) {
          break label789;
        }
        i = k;
      }
      label387:
      if (i == 0) {
        break label794;
      }
      paramBundle = this.xOU;
      label396:
      this.nfY = paramBundle;
      paramBundle = this.jiu;
      if (paramBundle != null)
      {
        localObject = t.ztT;
        localObject = t.dJi();
        e locale = new e(this.nfY);
        t localt = t.ztT;
        ((com.tencent.mm.loader.d)localObject).a(locale, paramBundle, t.a(t.a.ztZ));
      }
      paramBundle = this.xOM;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new c(this));
      }
      i = this.xOW / 2;
      if (i > 0) {
        break label826;
      }
      i = this.xOW;
    }
    label769:
    label774:
    label779:
    label789:
    label794:
    label826:
    for (;;)
    {
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.yRm;
      com.tencent.mm.plugin.finder.live.utils.a.a((EditText)this.xOO, null, this.xOW, i, (kotlin.g.a.a)new d(this));
      this.xOQ = findViewById(b.f.spilt_line_3);
      ox(false);
      paramBundle = this.raT;
      if (paramBundle != null) {
        paramBundle.setOnClickListener((View.OnClickListener)new e(this));
      }
      paramBundle = this.raT;
      if (paramBundle != null)
      {
        paramBundle = paramBundle.getLayoutParams();
        label577:
        localObject = paramBundle;
        if (!(paramBundle instanceof ViewGroup.MarginLayoutParams)) {
          localObject = null;
        }
        paramBundle = (ViewGroup.MarginLayoutParams)localObject;
        i = j;
        if (paramBundle != null) {
          i = paramBundle.bottomMargin;
        }
        this.xOX = i;
        if (this.xOX <= 0)
        {
          paramBundle = MMApplicationContext.getContext();
          p.j(paramBundle, "MMApplicationContext.getContext()");
          this.xOX = paramBundle.getResources().getDimensionPixelOffset(b.d.Edge_8A);
        }
        switch (this.sourceType)
        {
        default: 
          paramBundle = this.raT;
          if (paramBundle != null) {
            paramBundle.setBackgroundResource(b.e.finder_live_btn_green_selector);
          }
          break;
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "initConfirmBtnConfig:" + this.xOX + ", sourceType:" + this.sourceType);
        Log.i(this.TAG, "maxNickNameLength:" + this.xOW);
        AppMethodBeat.o(233039);
        return;
        bool = false;
        break;
        label764:
        paramBundle = null;
        break label144;
        paramBundle = null;
        break label171;
        i = 0;
        break label194;
        paramBundle = (CharSequence)"";
        break label277;
        i = 0;
        break label387;
        paramBundle = this.xOS;
        break label396;
        paramBundle = null;
        break label577;
        paramBundle = this.raT;
        if (paramBundle != null) {
          paramBundle.setBackgroundResource(b.e.finder_live_lottery_btn_bg);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(233044);
    super.onPause();
    i locali = this.jij;
    if (locali != null)
    {
      locali.close();
      AppMethodBeat.o(233044);
      return;
    }
    AppMethodBeat.o(233044);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(233042);
    super.onResume();
    Object localObject = getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null)
      {
        ((View)localObject).post((Runnable)new g(this));
        AppMethodBeat.o(233042);
        return;
      }
    }
    AppMethodBeat.o(233042);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$continuePost$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder-live_release"})
  public static final class a
    implements k.a
  {
    public final void a(bcn parambcn)
    {
      AppMethodBeat.i(233023);
      p.k(parambcn, "resp");
      Log.i(this.xOY.TAG, "save alias nickName:" + FinderLiveCreateVisitorModeUI.e(this.xOY) + ",avatar:" + FinderLiveCreateVisitorModeUI.g(this.xOY));
      FinderLiveCreateVisitorModeUI localFinderLiveCreateVisitorModeUI = this.xOY;
      Intent localIntent = new Intent();
      Object localObject = a.a.BuJ;
      String str2 = a.a.emM();
      String str1 = parambcn.SNO.nickname;
      localObject = str1;
      if (str1 == null) {
        localObject = FinderLiveCreateVisitorModeUI.e(this.xOY);
      }
      localIntent.putExtra(str2, (String)localObject);
      localObject = a.a.BuJ;
      str2 = a.a.emN();
      str1 = parambcn.SNO.ueX;
      localObject = str1;
      if (str1 == null) {
        localObject = FinderLiveCreateVisitorModeUI.g(this.xOY);
      }
      localIntent.putExtra(str2, (String)localObject);
      localObject = a.a.BuJ;
      str1 = a.a.emO();
      localObject = parambcn.SNO.SJz;
      parambcn = (bcn)localObject;
      if (localObject == null) {
        parambcn = FinderLiveCreateVisitorModeUI.g(this.xOY);
      }
      localIntent.putExtra(str1, parambcn);
      localFinderLiveCreateVisitorModeUI.setResult(-1, localIntent);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this));
      this.xOY.finish();
      AppMethodBeat.o(233023);
    }
    
    public final void aY(final int paramInt, final String paramString)
    {
      AppMethodBeat.i(233024);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this, paramInt, paramString));
      AppMethodBeat.o(233024);
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class a
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      a(FinderLiveCreateVisitorModeUI.a parama, int paramInt, String paramString)
      {
        super();
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
    static final class b
      extends kotlin.g.b.q
      implements kotlin.g.a.a<x>
    {
      b(FinderLiveCreateVisitorModeUI.a parama)
      {
        super();
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232860);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = FinderLiveCreateVisitorModeUI.b(this.xOY);
      if (paramView != null) {
        paramView.setText((CharSequence)"");
      }
      paramView = FinderLiveCreateVisitorModeUI.c(this.xOY);
      if (paramView != null) {
        paramView.setVisibility(4);
      }
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(232860);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class c
    implements View.OnClickListener
  {
    c(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(233293);
      com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
      localb.bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      com.tencent.mm.pluginsdk.ui.tools.u.a((Activity)this.xOY, FinderLiveCreateVisitorModeUI.d(this.xOY), 1, 5, null, false);
      com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$3", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(233293);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
  static final class d
    extends kotlin.g.b.q
    implements kotlin.g.a.a<x>
  {
    d(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI)
    {
      super();
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(232917);
      Object localObject = new com.tencent.mm.hellhoundlib.b.b();
      ((com.tencent.mm.hellhoundlib.b.b)localObject).bn(paramView);
      com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((com.tencent.mm.hellhoundlib.b.b)localObject).aFi());
      FinderLiveCreateVisitorModeUI.a(this.xOY, false);
      paramView = FinderLiveCreateVisitorModeUI.f(this.xOY);
      localObject = (CharSequence)paramView;
      int i;
      if ((localObject == null) || (((CharSequence)localObject).length() == 0))
      {
        i = 1;
        if (i != 0) {
          break label135;
        }
        localObject = g.AAk;
        localObject = g.ecj();
        String str = z.bdh();
        p.j(str, "ConfigStorageLogic.getMyFinderUsername()");
        ((g)localObject).a(paramView, str, (f)new f()
        {
          public final void a(c paramAnonymousc, com.tencent.mm.loader.g.j paramAnonymousj)
          {
            AppMethodBeat.i(233273);
            p.k(paramAnonymousc, "task");
            p.k(paramAnonymousj, "status");
            if ((paramAnonymousj == com.tencent.mm.loader.g.j.kQd) && (!Util.isNullOrNil(((m)paramAnonymousc).resultUrl)))
            {
              FinderLiveCreateVisitorModeUI.b(this.xPa.xOY, ((m)paramAnonymousc).resultUrl);
              FinderLiveCreateVisitorModeUI.h(this.xPa.xOY);
              AppMethodBeat.o(233273);
              return;
            }
            Log.e(this.xPa.xOY.TAG, "upload avatar fail,status:".concat(String.valueOf(paramAnonymousj)));
            FinderLiveCreateVisitorModeUI.a(this.xPa.xOY, true);
            com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this));
            AppMethodBeat.o(233273);
          }
          
          @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "invoke"})
          static final class a
            extends kotlin.g.b.q
            implements kotlin.g.a.a<x>
          {
            a(FinderLiveCreateVisitorModeUI.e.1 param1)
            {
              super();
            }
          }
        });
      }
      for (;;)
      {
        com.tencent.mm.hellhoundlib.a.a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$5", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(232917);
        return;
        i = 0;
        break;
        label135:
        FinderLiveCreateVisitorModeUI.h(this.xOY);
      }
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(233248);
      this.xOY.hideVKB();
      this.xOY.finish();
      AppMethodBeat.o(233248);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "run"})
  static final class g
    implements Runnable
  {
    g(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void run()
    {
      AppMethodBeat.i(233403);
      if (FinderLiveCreateVisitorModeUI.a(this.xOY) == null)
      {
        FinderLiveCreateVisitorModeUI.a(this.xOY, new i((Activity)this.xOY));
        locali = FinderLiveCreateVisitorModeUI.a(this.xOY);
        if (locali != null) {
          locali.setKeyboardHeightObserver((h)new h()
          {
            public final void A(int paramAnonymousInt, boolean paramAnonymousBoolean)
            {
              AppMethodBeat.i(233909);
              Log.i(this.xPc.xOY.TAG, "onKeyboardHeightChanged, height:" + paramAnonymousInt + ", isResized:" + paramAnonymousBoolean);
              FinderLiveCreateVisitorModeUI localFinderLiveCreateVisitorModeUI = this.xPc.xOY;
              if (paramAnonymousInt > 0) {}
              for (paramAnonymousBoolean = true;; paramAnonymousBoolean = false)
              {
                FinderLiveCreateVisitorModeUI.a(localFinderLiveCreateVisitorModeUI, paramAnonymousBoolean, paramAnonymousInt);
                AppMethodBeat.o(233909);
                return;
              }
            }
          });
        }
      }
      i locali = FinderLiveCreateVisitorModeUI.a(this.xOY);
      if (locali != null)
      {
        locali.start();
        AppMethodBeat.o(233403);
        return;
      }
      AppMethodBeat.o(233403);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "bOk", "", "text", "", "kotlin.jvm.PlatformType", "onDialogClick"})
  static final class h
    implements f.c
  {
    h(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void g(boolean paramBoolean, String paramString)
    {
      AppMethodBeat.i(233263);
      Log.i(this.xOY.TAG, "showAlertDialog click bOk:".concat(String.valueOf(paramBoolean)));
      AppMethodBeat.o(233263);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveCreateVisitorModeUI
 * JD-Core Version:    0.7.0.1
 */