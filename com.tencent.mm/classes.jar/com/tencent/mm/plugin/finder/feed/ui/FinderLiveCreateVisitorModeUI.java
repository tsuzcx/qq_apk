package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout.LayoutParams;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.h;
import com.tencent.mm.model.z;
import com.tencent.mm.modelavatar.j;
import com.tencent.mm.modelavatar.q;
import com.tencent.mm.plugin.finder.live.cgi.u.a;
import com.tencent.mm.plugin.finder.live.p.b;
import com.tencent.mm.plugin.finder.live.p.c;
import com.tencent.mm.plugin.finder.live.p.d;
import com.tencent.mm.plugin.finder.live.p.e;
import com.tencent.mm.plugin.finder.live.p.f;
import com.tencent.mm.plugin.finder.live.p.g;
import com.tencent.mm.plugin.finder.loader.p;
import com.tencent.mm.plugin.finder.loader.p.a;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.upload.m;
import com.tencent.mm.plugin.findersdk.a.a;
import com.tencent.mm.pluginsdk.ui.tools.t;
import com.tencent.mm.protocal.protobuf.bcz;
import com.tencent.mm.protocal.protobuf.bmp;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.aw;
import com.tencent.mm.ui.bf;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.vfs.y;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;
import kotlin.n.n;

@com.tencent.mm.ui.base.a(32)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "REQUEST_CODE_CROP_AVATAR", "", "REQUEST_CODE_SELECT_AVATAR", "TAG", "", "getTAG", "()Ljava/lang/String;", "avatarChoose", "Landroid/widget/ImageView;", "avatarGroup", "Landroid/view/View;", "avatarIv", "avatarPath", "avatarUrl", "confirmBtn", "Landroid/widget/Button;", "confirmBtnBottomMargin", "curAvatarUrl", "curNickname", "filterMyAvatarUrl", "", "keyboardHeightProvider", "Lcom/tencent/mm/ui/tools/KeyboardHeightProvider;", "maxNickNameLength", "mySelfAvatarUrl", "nickNameStr", "nicknameClear", "nicknameEt", "Lcom/tencent/mm/ui/widget/MMEditText;", "sourceType", "splitLine3", "adjustConfirmBtn", "", "show", "height", "continuePost", "getLayoutId", "getReportTag", "initConfigValue", "initConfirmBtnConfig", "initLayout", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onPause", "onResume", "parseIntent", "setAvatar", "path", "setConfirmBtnStatus", "enable", "showAlertDialog", "title", "content", "buttonTitle", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderLiveCreateVisitorModeUI
  extends MMFinderUI
{
  private String AmC;
  private final int BoG = 1000;
  private final int BoH = 1001;
  private View BoI;
  private ImageView BoJ;
  private MMEditText BoK;
  private ImageView BoL;
  private View BoM;
  private boolean BoN = true;
  private String BoO;
  private String BoP;
  private String BoQ;
  private String BoR;
  private int BoS = 28;
  private int BoT;
  final String TAG = "FinderLiveCreateVisitorModeUI";
  private ImageView lKK;
  private com.tencent.mm.ui.tools.i lKz;
  private String nVM;
  private int sourceType;
  private Button ugK;
  
  private static final void a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI)
  {
    AppMethodBeat.i(364503);
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    if (paramFinderLiveCreateVisitorModeUI.lKz == null)
    {
      paramFinderLiveCreateVisitorModeUI.lKz = new com.tencent.mm.ui.tools.i((Activity)paramFinderLiveCreateVisitorModeUI);
      com.tencent.mm.ui.tools.i locali = paramFinderLiveCreateVisitorModeUI.lKz;
      if (locali != null) {
        locali.afIL = new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda4(paramFinderLiveCreateVisitorModeUI);
      }
    }
    paramFinderLiveCreateVisitorModeUI = paramFinderLiveCreateVisitorModeUI.lKz;
    if (paramFinderLiveCreateVisitorModeUI != null) {
      paramFinderLiveCreateVisitorModeUI.start();
    }
    AppMethodBeat.o(364503);
  }
  
  private static final void a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, int paramInt, boolean paramBoolean)
  {
    int j = 1;
    ViewGroup localViewGroup = null;
    AppMethodBeat.i(364495);
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    Log.i(paramFinderLiveCreateVisitorModeUI.TAG, "onKeyboardHeightChanged, height:" + paramInt + ", isResized:" + paramBoolean);
    int i;
    Object localObject1;
    label69:
    label84:
    int m;
    int k;
    label131:
    int n;
    if (paramInt > 0)
    {
      i = 1;
      localObject1 = paramFinderLiveCreateVisitorModeUI.ugK;
      if (localObject1 != null) {
        break label363;
      }
      localObject1 = null;
      if (!(localObject1 instanceof RelativeLayout.LayoutParams)) {
        break label373;
      }
      localObject1 = (RelativeLayout.LayoutParams)localObject1;
      m = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      if (localObject1 != null)
      {
        if (i == 0) {
          break label469;
        }
        k = bf.bf(MMApplicationContext.getContext()).y;
        localObject2 = paramFinderLiveCreateVisitorModeUI.ugK;
        if (localObject2 != null) {
          break label379;
        }
        i = 0;
        localObject2 = new int[2];
        View localView = paramFinderLiveCreateVisitorModeUI.BoM;
        if (localView != null) {
          localView.getLocationOnScreen((int[])localObject2);
        }
        n = localObject2[1];
        localObject2 = paramFinderLiveCreateVisitorModeUI.BoM;
        if (localObject2 != null) {
          break label388;
        }
        label171:
        Log.i(paramFinderLiveCreateVisitorModeUI.TAG, "adjustConfirmBtn screenHeight:" + k + ",confirmBtnContainerH:" + i + ",descContainerY:" + n + ",itemHeight:" + j + ",height:" + paramInt);
        if ((i != 0) && (n != 0) && (k - m - i - (n + j) > paramInt)) {
          break label398;
        }
        localObject2 = paramFinderLiveCreateVisitorModeUI.BoM;
        if (localObject2 != null)
        {
          paramInt = ((View)localObject2).getId();
          ((RelativeLayout.LayoutParams)localObject1).removeRule(12);
          ((RelativeLayout.LayoutParams)localObject1).addRule(3, paramInt);
          ((RelativeLayout.LayoutParams)localObject1).bottomMargin = 0;
        }
        label301:
        localObject2 = paramFinderLiveCreateVisitorModeUI.ugK;
        if (localObject2 != null) {
          break label494;
        }
      }
    }
    label363:
    label494:
    for (Object localObject2 = null;; localObject2 = ((Button)localObject2).getParent())
    {
      if ((localObject2 instanceof ViewGroup)) {
        localViewGroup = (ViewGroup)localObject2;
      }
      if (localViewGroup != null) {
        localViewGroup.updateViewLayout((View)paramFinderLiveCreateVisitorModeUI.ugK, (ViewGroup.LayoutParams)localObject1);
      }
      AppMethodBeat.o(364495);
      return;
      i = 0;
      break;
      localObject1 = ((Button)localObject1).getLayoutParams();
      break label69;
      label373:
      localObject1 = null;
      break label84;
      label379:
      i = ((Button)localObject2).getHeight();
      break label131;
      j = ((View)localObject2).getHeight();
      break label171;
      m = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
      int i1 = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_6A);
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = (kotlin.k.k.qv(m, k - paramInt - (j + n) - i - i1) + paramInt);
      break label301;
      ((RelativeLayout.LayoutParams)localObject1).removeRule(3);
      ((RelativeLayout.LayoutParams)localObject1).addRule(12);
      ((RelativeLayout.LayoutParams)localObject1).bottomMargin = paramFinderLiveCreateVisitorModeUI.BoT;
      break label301;
    }
  }
  
  private static final void a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, View paramView)
  {
    AppMethodBeat.i(364516);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCreateVisitorModeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    paramView = paramFinderLiveCreateVisitorModeUI.BoK;
    if (paramView != null) {
      paramView.setText((CharSequence)"");
    }
    paramFinderLiveCreateVisitorModeUI = paramFinderLiveCreateVisitorModeUI.BoL;
    if (paramFinderLiveCreateVisitorModeUI != null) {
      paramFinderLiveCreateVisitorModeUI.setVisibility(4);
    }
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364516);
  }
  
  private static final void a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, boolean paramBoolean, String paramString)
  {
    AppMethodBeat.i(364550);
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    Log.i(paramFinderLiveCreateVisitorModeUI.TAG, s.X("showAlertDialog click bOk:", Boolean.valueOf(paramBoolean)));
    AppMethodBeat.o(364550);
  }
  
  private static final boolean a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364480);
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    paramFinderLiveCreateVisitorModeUI.hideVKB();
    paramFinderLiveCreateVisitorModeUI.finish();
    AppMethodBeat.o(364480);
    return true;
  }
  
  private static final void b(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, View paramView)
  {
    AppMethodBeat.i(364529);
    Object localObject = new Object();
    com.tencent.mm.hellhoundlib.b.b localb = new com.tencent.mm.hellhoundlib.b.b();
    localb.cH(paramFinderLiveCreateVisitorModeUI);
    localb.cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    t.a((Activity)paramFinderLiveCreateVisitorModeUI, paramFinderLiveCreateVisitorModeUI.BoG, 1, 5, null, false);
    com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364529);
  }
  
  private static final void c(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, View paramView)
  {
    AppMethodBeat.i(364541);
    Object localObject1 = new Object();
    Object localObject2 = new com.tencent.mm.hellhoundlib.b.b();
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramFinderLiveCreateVisitorModeUI);
    ((com.tencent.mm.hellhoundlib.b.b)localObject2).cH(paramView);
    com.tencent.mm.hellhoundlib.a.a.c("com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject1, ((com.tencent.mm.hellhoundlib.b.b)localObject2).aYj());
    s.u(paramFinderLiveCreateVisitorModeUI, "this$0");
    paramFinderLiveCreateVisitorModeUI.qc(false);
    paramView = paramFinderLiveCreateVisitorModeUI.AmC;
    localObject1 = (CharSequence)paramView;
    int i;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0))
    {
      i = 1;
      if (i != 0) {
        break label175;
      }
      localObject1 = ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).finderPostManager();
      localObject2 = z.bAW();
      s.s(localObject2, "getMyFinderUsername()");
      ((com.tencent.mm.plugin.finder.publish.b)localObject1).h(paramView, (String)localObject2, new c(paramFinderLiveCreateVisitorModeUI));
    }
    for (;;)
    {
      com.tencent.mm.hellhoundlib.a.a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364541);
      return;
      i = 0;
      break;
      label175:
      paramFinderLiveCreateVisitorModeUI.efh();
    }
  }
  
  private final void efh()
  {
    AppMethodBeat.i(364471);
    Object localObject1 = (CharSequence)this.BoR;
    if ((localObject1 == null) || (((CharSequence)localObject1).length() == 0)) {}
    for (int i = 1; i != 0; i = 0)
    {
      Log.i(this.TAG, "continuePost nickNameStr:" + this.BoR + " is empty!");
      qc(true);
      AppMethodBeat.o(364471);
      return;
    }
    localObject1 = this.nVM;
    Object localObject2 = (CharSequence)this.nVM;
    if ((localObject2 == null) || (((CharSequence)localObject2).length() == 0))
    {
      i = 1;
      if ((i != 0) || (!s.p(this.nVM, this.BoQ)) || (!this.BoN)) {
        break label228;
      }
      localObject1 = this.nVM;
      if (localObject1 != null) {
        break label204;
      }
      localObject1 = null;
    }
    label147:
    label160:
    label204:
    label225:
    label228:
    for (;;)
    {
      localObject2 = this.BoR;
      if (localObject2 == null)
      {
        localObject2 = "";
        if (localObject1 != null) {
          break label225;
        }
        localObject1 = "";
      }
      for (;;)
      {
        new com.tencent.mm.plugin.finder.live.cgi.u((String)localObject2, (String)localObject1, (u.a)new a(this)).bFJ();
        AppMethodBeat.o(364471);
        return;
        i = 0;
        break;
        localObject2 = a.a.Hbu;
        localObject1 = n.d((String)localObject1, (CharSequence)a.a.fqY());
        break label147;
        break label160;
      }
    }
  }
  
  private final void qc(boolean paramBoolean)
  {
    AppMethodBeat.i(364461);
    Button localButton = this.ugK;
    if (localButton != null) {
      localButton.setEnabled(paramBoolean);
    }
    if (paramBoolean)
    {
      if (aw.isDarkMode())
      {
        localButton = this.ugK;
        if (localButton != null)
        {
          localButton.setTextColor(getContext().getResources().getColor(p.b.BW_100_Alpha_0_8));
          AppMethodBeat.o(364461);
        }
      }
      else
      {
        localButton = this.ugK;
        if (localButton != null)
        {
          localButton.setTextColor(getContext().getResources().getColor(p.b.White));
          AppMethodBeat.o(364461);
        }
      }
    }
    else if (aw.isDarkMode())
    {
      localButton = this.ugK;
      if (localButton != null)
      {
        localButton.setTextColor(getContext().getResources().getColor(p.b.BW_100_Alpha_0_2));
        AppMethodBeat.o(364461);
      }
    }
    else
    {
      localButton = this.ugK;
      if (localButton != null) {
        localButton.setTextColor(getContext().getResources().getColor(p.b.BW_0_Alpha_0_2));
      }
    }
    AppMethodBeat.o(364461);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final String efe()
  {
    return this.TAG;
  }
  
  public final int getLayoutId()
  {
    return p.f.Cdx;
  }
  
  public final void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    AppMethodBeat.i(364705);
    if (paramInt1 == this.BoG)
    {
      if ((paramIntent != null) && (paramInt2 == -1))
      {
        setIntent(new Intent());
        paramIntent = com.tencent.mm.ui.tools.b.i((Context)getContext(), paramIntent, com.tencent.mm.plugin.image.d.bzL());
        getIntent().putExtra("key_source_img_path", paramIntent);
        ((com.tencent.mm.plugin.finder.publish.c)h.az(com.tencent.mm.plugin.finder.publish.c.class)).publishRouterApi().d((Activity)this, getIntent(), this.BoH);
        AppMethodBeat.o(364705);
      }
    }
    else if ((paramInt1 == this.BoH) && (paramIntent != null) && (paramInt2 == -1))
    {
      this.AmC = paramIntent.getStringExtra("key_result_img_path");
      Log.i(this.TAG, "avatar path %s file length %d KB", new Object[] { this.AmC, Long.valueOf(y.bEl(this.AmC) / 1024L) });
      paramIntent = this.AmC;
      if (!Util.isNullOrNil(paramIntent))
      {
        paramIntent = BitmapUtil.extractThumbNail(paramIntent, 256, 256, false);
        if (paramIntent != null)
        {
          ImageView localImageView = this.lKK;
          if (localImageView != null) {
            localImageView.setImageBitmap(paramIntent);
          }
        }
      }
    }
    AppMethodBeat.o(364705);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    int j = 0;
    AppMethodBeat.i(364677);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
    int i = ((Number)com.tencent.d.a.a.a.a.a.jSL().bmg()).intValue();
    if ((i > 0) && (i < 2147483647)) {
      this.BoS = i;
    }
    setMMTitle("");
    setActionbarColor(getContext().getResources().getColor(p.b.white_color));
    setBackBtn(new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda0(this), p.g.icons_filled_back);
    paramBundle = com.tencent.d.a.a.a.a.a.ahiX;
    boolean bool;
    label144:
    label160:
    label176:
    Object localObject1;
    if (((Number)com.tencent.d.a.a.a.a.a.jSM().bmg()).intValue() == 0)
    {
      bool = true;
      this.BoN = bool;
      Log.i(this.TAG, s.X("initConfigValue filterMyAvatarUrl:", Boolean.valueOf(this.BoN)));
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label690;
      }
      paramBundle = null;
      this.BoP = paramBundle;
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label706;
      }
      paramBundle = null;
      this.BoO = paramBundle;
      paramBundle = getIntent();
      if (paramBundle != null) {
        break label722;
      }
      i = 0;
      this.sourceType = i;
      this.BoI = findViewById(p.e.BBK);
      this.lKK = ((ImageView)findViewById(p.e.avatar_iv));
      this.BoJ = ((ImageView)findViewById(p.e.CbV));
      this.BoK = ((MMEditText)findViewById(p.e.BYA));
      Object localObject2 = this.BoK;
      if (localObject2 != null)
      {
        localObject1 = this.BoP;
        paramBundle = (Bundle)localObject1;
        if (localObject1 == null) {
          paramBundle = "";
        }
        ((MMEditText)localObject2).setText((CharSequence)paramBundle);
      }
      this.BoL = ((ImageView)findViewById(p.e.BYz));
      paramBundle = this.BoL;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda3(this));
      }
      this.ugK = ((Button)findViewById(p.e.confirm_btn));
      paramBundle = q.bFE().LS(z.bAM());
      if (paramBundle != null) {
        break label734;
      }
      paramBundle = "";
      label339:
      this.BoQ = paramBundle;
      paramBundle = (CharSequence)this.BoO;
      if ((paramBundle != null) && (paramBundle.length() != 0)) {
        break label755;
      }
      i = 1;
      label367:
      if (i == 0) {
        break label760;
      }
      paramBundle = this.BoQ;
      label376:
      this.nVM = paramBundle;
      paramBundle = this.lKK;
      if (paramBundle != null)
      {
        localObject1 = p.ExI;
        localObject1 = p.eCq();
        localObject2 = new com.tencent.mm.plugin.finder.loader.b(this.nVM);
        p localp = p.ExI;
        ((com.tencent.mm.loader.d)localObject1).a(localObject2, paramBundle, p.a(p.a.ExO));
      }
      paramBundle = this.BoI;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda1(this));
      }
      i = this.BoS / 2;
      if (i > 0) {
        break label808;
      }
      i = this.BoS;
    }
    label547:
    label808:
    for (;;)
    {
      paramBundle = com.tencent.mm.plugin.finder.live.utils.a.DJT;
      com.tencent.mm.plugin.finder.live.utils.a.a((EditText)this.BoK, this.BoS, i, (kotlin.g.a.a)new b(this));
      this.BoM = findViewById(p.e.Cbp);
      qc(false);
      paramBundle = this.ugK;
      if (paramBundle != null) {
        paramBundle.setOnClickListener(new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda2(this));
      }
      paramBundle = this.ugK;
      if (paramBundle == null)
      {
        paramBundle = null;
        if (!(paramBundle instanceof ViewGroup.MarginLayoutParams)) {
          break label776;
        }
        paramBundle = (ViewGroup.MarginLayoutParams)paramBundle;
        label559:
        if (paramBundle != null) {
          break label781;
        }
        i = j;
        label565:
        this.BoT = i;
        if (this.BoT <= 0) {
          this.BoT = MMApplicationContext.getContext().getResources().getDimensionPixelOffset(p.c.Edge_8A);
        }
        if (this.sourceType != 1) {
          break label789;
        }
        paramBundle = this.ugK;
        if (paramBundle != null) {
          paramBundle.setBackgroundResource(p.d.finder_live_lottery_btn_bg);
        }
      }
      for (;;)
      {
        Log.i(this.TAG, "initConfirmBtnConfig:" + this.BoT + ", sourceType:" + this.sourceType);
        Log.i(this.TAG, s.X("maxNickNameLength:", Integer.valueOf(this.BoS)));
        AppMethodBeat.o(364677);
        return;
        bool = false;
        break;
        label690:
        localObject1 = a.a.Hbu;
        paramBundle = paramBundle.getStringExtra(a.a.fqV());
        break label144;
        label706:
        localObject1 = a.a.Hbu;
        paramBundle = paramBundle.getStringExtra(a.a.fqW());
        break label160;
        label722:
        i = paramBundle.getIntExtra("KEY_SOURCE", 0);
        break label176;
        label734:
        localObject1 = paramBundle.bFx();
        paramBundle = (Bundle)localObject1;
        if (localObject1 != null) {
          break label339;
        }
        paramBundle = "";
        break label339;
        label755:
        i = 0;
        break label367;
        label760:
        paramBundle = this.BoO;
        break label376;
        paramBundle = paramBundle.getLayoutParams();
        break label547;
        paramBundle = null;
        break label559;
        i = paramBundle.bottomMargin;
        break label565;
        paramBundle = this.ugK;
        if (paramBundle != null) {
          paramBundle.setBackgroundResource(p.d.BzO);
        }
      }
    }
  }
  
  public final void onPause()
  {
    AppMethodBeat.i(364688);
    super.onPause();
    com.tencent.mm.ui.tools.i locali = this.lKz;
    if (locali != null) {
      locali.close();
    }
    AppMethodBeat.o(364688);
  }
  
  public final void onResume()
  {
    AppMethodBeat.i(364683);
    super.onResume();
    Object localObject = getWindow();
    if (localObject != null)
    {
      localObject = ((Window)localObject).getDecorView();
      if (localObject != null) {
        ((View)localObject).post(new FinderLiveCreateVisitorModeUI..ExternalSyntheticLambda6(this));
      }
    }
    AppMethodBeat.o(364683);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$continuePost$1", "Lcom/tencent/mm/plugin/finder/live/cgi/CgiFinderLiveSetSockPuppetAttr$CallBack;", "onFail", "", "errType", "", "errCode", "errMsg", "", "onSuccess", "resp", "Lcom/tencent/mm/protocal/protobuf/FinderLiveSetSockPuppetAttrResponse;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements u.a
  {
    a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void a(bmp parambmp)
    {
      AppMethodBeat.i(365080);
      s.u(parambmp, "resp");
      Log.i(this.BoU.TAG, "save alias nickName:" + FinderLiveCreateVisitorModeUI.c(this.BoU) + ",avatar:" + FinderLiveCreateVisitorModeUI.e(this.BoU));
      FinderLiveCreateVisitorModeUI localFinderLiveCreateVisitorModeUI1 = this.BoU;
      Intent localIntent = new Intent();
      FinderLiveCreateVisitorModeUI localFinderLiveCreateVisitorModeUI2 = this.BoU;
      Object localObject1 = a.a.Hbu;
      String str = a.a.fqV();
      localObject1 = parambmp.ZVf;
      Object localObject2;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = FinderLiveCreateVisitorModeUI.c(localFinderLiveCreateVisitorModeUI2);
        }
        localIntent.putExtra(str, (String)localObject2);
        localObject1 = a.a.Hbu;
        str = a.a.fqW();
        localObject1 = parambmp.ZVf;
        if (localObject1 != null) {
          break label250;
        }
        localObject1 = null;
        label140:
        localObject2 = localObject1;
        if (localObject1 == null) {
          localObject2 = FinderLiveCreateVisitorModeUI.e(localFinderLiveCreateVisitorModeUI2);
        }
        localIntent.putExtra(str, (String)localObject2);
        localObject1 = a.a.Hbu;
        localObject2 = a.a.fqX();
        parambmp = parambmp.ZVf;
        if (parambmp != null) {
          break label258;
        }
      }
      label258:
      for (parambmp = null;; parambmp = parambmp.ZNJ)
      {
        localObject1 = parambmp;
        if (parambmp == null) {
          localObject1 = FinderLiveCreateVisitorModeUI.e(localFinderLiveCreateVisitorModeUI2);
        }
        localIntent.putExtra((String)localObject2, (String)localObject1);
        parambmp = ah.aiuX;
        localFinderLiveCreateVisitorModeUI1.setResult(-1, localIntent);
        com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new b(this.BoU));
        this.BoU.finish();
        AppMethodBeat.o(365080);
        return;
        localObject1 = ((bcz)localObject1).nickname;
        break;
        label250:
        localObject1 = ((bcz)localObject1).xkY;
        break label140;
      }
    }
    
    public final void bu(final int paramInt, final String paramString)
    {
      AppMethodBeat.i(365087);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.BoU, paramInt, paramString));
      AppMethodBeat.o(365087);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI, int paramInt, String paramString)
      {
        super();
      }
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class b
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      b(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI)
      {
        super();
      }
    }
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
  static final class b
    extends kotlin.g.b.u
    implements kotlin.g.a.a<ah>
  {
    b(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI)
    {
      super();
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/feed/ui/FinderLiveCreateVisitorModeUI$initLayout$5$1", "Lcom/tencent/mm/loader/loader/LoaderCoreCallback;", "Lcom/tencent/mm/loader/loader/IWorkTask;", "onLoaderFin", "", "task", "status", "Lcom/tencent/mm/loader/loader/WorkStatus;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class c
    implements com.tencent.mm.loader.f.e<com.tencent.mm.loader.f.c>
  {
    c(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI) {}
    
    public final void a(com.tencent.mm.loader.f.c paramc, com.tencent.mm.loader.f.i parami)
    {
      AppMethodBeat.i(365109);
      s.u(paramc, "task");
      s.u(parami, "status");
      if ((parami == com.tencent.mm.loader.f.i.nrG) && (!Util.isNullOrNil(((m)paramc).resultUrl)))
      {
        FinderLiveCreateVisitorModeUI.b(this.BoU, ((m)paramc).resultUrl);
        FinderLiveCreateVisitorModeUI.f(this.BoU);
        AppMethodBeat.o(365109);
        return;
      }
      Log.e(this.BoU.TAG, s.X("upload avatar fail,status:", parami));
      FinderLiveCreateVisitorModeUI.a(this.BoU, true);
      com.tencent.mm.ae.d.uiThread((kotlin.g.a.a)new a(this.BoU));
      AppMethodBeat.o(365109);
    }
    
    @Metadata(d1={""}, d2={"<anonymous>", ""}, k=3, mv={1, 5, 1}, xi=48)
    static final class a
      extends kotlin.g.b.u
      implements kotlin.g.a.a<ah>
    {
      a(FinderLiveCreateVisitorModeUI paramFinderLiveCreateVisitorModeUI)
      {
        super();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderLiveCreateVisitorModeUI
 * JD-Core Version:    0.7.0.1
 */