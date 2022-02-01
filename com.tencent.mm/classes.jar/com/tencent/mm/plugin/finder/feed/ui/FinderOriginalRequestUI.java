package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.am.p;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.da;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.g;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.ac;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.aa;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import kotlin.Metadata;
import kotlin.ah;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements com.tencent.mm.am.h
{
  public WeImageView Bqk;
  public LinearLayout Bql;
  public CheckBox Bqm;
  public TextView Bqn;
  public Button Bqo;
  private int Bqp;
  private final String TAG = "Finder.FinderOriginalRequestUI";
  public TextView descTv;
  private Dialog tipDialog;
  public TextView titleTv;
  
  private static final void a(FinderOriginalRequestUI paramFinderOriginalRequestUI, View paramView)
  {
    AppMethodBeat.i(364783);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderOriginalRequestUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderOriginalRequestUI, "this$0");
    paramFinderOriginalRequestUI.efC().toggle();
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364783);
  }
  
  private static final void a(FinderOriginalRequestUI paramFinderOriginalRequestUI, CompoundButton paramCompoundButton, boolean paramBoolean)
  {
    AppMethodBeat.i(364777);
    kotlin.g.b.s.u(paramFinderOriginalRequestUI, "this$0");
    paramFinderOriginalRequestUI.efE().setClickable(paramBoolean);
    paramFinderOriginalRequestUI.efE().setEnabled(paramBoolean);
    AppMethodBeat.o(364777);
  }
  
  private static final boolean a(FinderOriginalRequestUI paramFinderOriginalRequestUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(364770);
    kotlin.g.b.s.u(paramFinderOriginalRequestUI, "this$0");
    paramFinderOriginalRequestUI.finish();
    AppMethodBeat.o(364770);
    return true;
  }
  
  private static final void b(FinderOriginalRequestUI paramFinderOriginalRequestUI, View paramView)
  {
    AppMethodBeat.i(364790);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderOriginalRequestUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderOriginalRequestUI, "this$0");
    paramFinderOriginalRequestUI.finish();
    a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
    AppMethodBeat.o(364790);
  }
  
  private static final void c(FinderOriginalRequestUI paramFinderOriginalRequestUI, View paramView)
  {
    AppMethodBeat.i(364804);
    Object localObject = new Object();
    b localb = new b();
    localb.cH(paramFinderOriginalRequestUI);
    localb.cH(paramView);
    a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", localObject, localb.aYj());
    kotlin.g.b.s.u(paramFinderOriginalRequestUI, "this$0");
    localObject = z.bAW();
    if (Util.isNullOrNil((String)localObject))
    {
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364804);
      return;
    }
    paramView = paramFinderOriginalRequestUI.tipDialog;
    if (paramView == null) {}
    for (paramView = null;; paramView = ah.aiuX)
    {
      if (paramView == null)
      {
        paramView = (Context)paramFinderOriginalRequestUI.getContext();
        paramFinderOriginalRequestUI.getContext().getString(e.h.app_tip);
        paramFinderOriginalRequestUI.tipDialog = ((Dialog)k.a(paramView, paramFinderOriginalRequestUI.getContext().getString(e.h.app_waiting), false, FinderOriginalRequestUI..ExternalSyntheticLambda0.INSTANCE));
      }
      kotlin.g.b.s.s(localObject, "username");
      paramFinderOriginalRequestUI = new da((String)localObject, (byte)0);
      com.tencent.mm.kernel.h.aZW().a((p)paramFinderOriginalRequestUI, 0);
      a.a(new Object(), "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(364804);
      return;
      paramView.show();
    }
  }
  
  private LinearLayout efB()
  {
    AppMethodBeat.i(364728);
    LinearLayout localLinearLayout = this.Bql;
    if (localLinearLayout != null)
    {
      AppMethodBeat.o(364728);
      return localLinearLayout;
    }
    kotlin.g.b.s.bIx("readLayout");
    AppMethodBeat.o(364728);
    return null;
  }
  
  private CheckBox efC()
  {
    AppMethodBeat.i(364734);
    CheckBox localCheckBox = this.Bqm;
    if (localCheckBox != null)
    {
      AppMethodBeat.o(364734);
      return localCheckBox;
    }
    kotlin.g.b.s.bIx("readCheckBox");
    AppMethodBeat.o(364734);
    return null;
  }
  
  private TextView efD()
  {
    AppMethodBeat.i(364740);
    TextView localTextView = this.Bqn;
    if (localTextView != null)
    {
      AppMethodBeat.o(364740);
      return localTextView;
    }
    kotlin.g.b.s.bIx("readContentTv");
    AppMethodBeat.o(364740);
    return null;
  }
  
  private Button efE()
  {
    AppMethodBeat.i(364745);
    Button localButton = this.Bqo;
    if (localButton != null)
    {
      AppMethodBeat.o(364745);
      return localButton;
    }
    kotlin.g.b.s.bIx("button");
    AppMethodBeat.o(364745);
    return null;
  }
  
  private TextView getDescTv()
  {
    AppMethodBeat.i(364722);
    TextView localTextView = this.descTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(364722);
      return localTextView;
    }
    kotlin.g.b.s.bIx("descTv");
    AppMethodBeat.o(364722);
    return null;
  }
  
  private WeImageView getIconIv()
  {
    AppMethodBeat.i(364710);
    WeImageView localWeImageView = this.Bqk;
    if (localWeImageView != null)
    {
      AppMethodBeat.o(364710);
      return localWeImageView;
    }
    kotlin.g.b.s.bIx("iconIv");
    AppMethodBeat.o(364710);
    return null;
  }
  
  private TextView getTitleTv()
  {
    AppMethodBeat.i(364717);
    TextView localTextView = this.titleTv;
    if (localTextView != null)
    {
      AppMethodBeat.o(364717);
      return localTextView;
    }
    kotlin.g.b.s.bIx("titleTv");
    AppMethodBeat.o(364717);
    return null;
  }
  
  private static final void m(DialogInterface paramDialogInterface) {}
  
  private final void refreshView()
  {
    AppMethodBeat.i(364762);
    if (this.Bqp == 1)
    {
      getIconIv().setImageResource(e.g.icons_filled_done2);
      getIconIv().setIconColor(getResources().getColor(e.b.Brand));
      getTitleTv().setText((CharSequence)getString(e.h.finder_original_has_apply_title));
      getDescTv().setText(e.h.finder_original_has_apply_desc);
      efB().setVisibility(8);
      efE().setClickable(true);
      efE().setEnabled(true);
      efE().setText(e.h.app_finish);
      efE().setOnClickListener(new FinderOriginalRequestUI..ExternalSyntheticLambda2(this));
      AppMethodBeat.o(364762);
      return;
    }
    Object localObject2;
    Object localObject3;
    if (this.Bqp == 0)
    {
      getIconIv().setImageResource(e.g.finder_original);
      getIconIv().setIconColor(getResources().getColor(e.b.Orange_100));
      getTitleTv().setText((CharSequence)getString(e.h.finder_original_apply_title));
      getDescTv().setText((CharSequence)getString(e.h.finder_original_apply_desc));
      str = getString(e.h.finder_original_agree_tips_link);
      kotlin.g.b.s.s(str, "getString(R.string.finde…original_agree_tips_link)");
      localObject1 = getString(e.h.finder_original_agree_tips, new Object[] { str });
      kotlin.g.b.s.s(localObject1, "getString(R.string.finde…_agree_tips, readingText)");
      localObject2 = ac.Ghd;
      localObject2 = getContext();
      kotlin.g.b.s.s(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = ac.Ghd;
      ac.a((Context)localObject2, ac.feY(), (String)localObject1, str, efD(), this.TAG);
      efB().setVisibility(0);
      efE().setVisibility(0);
      efE().setText(e.h.finder_original_apply);
      efE().setOnClickListener(new FinderOriginalRequestUI..ExternalSyntheticLambda4(this));
      AppMethodBeat.o(364762);
      return;
    }
    getIconIv().setImageResource(e.g.icons_filled_error);
    getIconIv().setIconColor(getResources().getColor(e.b.Orange_100));
    getTitleTv().setText(e.h.finder_original_spam_title);
    String str = getString(e.h.finder_original_agree_tips_link);
    kotlin.g.b.s.s(str, "getString(R.string.finde…original_agree_tips_link)");
    Object localObject1 = ac.Ghd;
    if (ac.ffc())
    {
      localObject1 = ac.Ghd;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = ac.Ghd;
      localObject2 = ac.feY();
      localObject3 = getString(e.h.finder_original_spam_desc2, new Object[] { str });
      kotlin.g.b.s.s(localObject3, "getString(R.string.finde…nal_spam_desc2, linkText)");
      ac.a((Context)localObject1, (String)localObject2, (String)localObject3, str, getDescTv(), this.TAG);
    }
    for (;;)
    {
      efB().setVisibility(8);
      efE().setVisibility(8);
      AppMethodBeat.o(364762);
      return;
      localObject1 = ac.Ghd;
      localObject1 = getContext();
      kotlin.g.b.s.s(localObject1, "context");
      localObject1 = (Context)localObject1;
      localObject2 = ac.Ghd;
      localObject2 = ac.feY();
      int i = e.h.finder_original_spam_desc1;
      localObject3 = ac.Ghd;
      localObject3 = getString(i, new Object[] { str, String.valueOf(ac.ffd()) });
      kotlin.g.b.s.s(localObject3, "getString(R.string.finde….getSpamDay().toString())");
      ac.a((Context)localObject1, (String)localObject2, (String)localObject3, str, getDescTv(), this.TAG);
    }
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_original_request_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(364858);
    super.onCreate(paramBundle);
    paramBundle = ac.Ghd;
    if (ac.ffb() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.Bqp = 2;
      }
      setActionbarColor(getResources().getColor(e.b.white));
      setMMTitle("");
      setBackBtn(new FinderOriginalRequestUI..ExternalSyntheticLambda1(this));
      paramBundle = findViewById(e.e.original_icon_iv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_icon_iv)");
      paramBundle = (WeImageView)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.Bqk = paramBundle;
      paramBundle = findViewById(e.e.original_title_tv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_title_tv)");
      paramBundle = (TextView)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.titleTv = paramBundle;
      paramBundle = findViewById(e.e.original_desc_tv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_desc_tv)");
      paramBundle = (TextView)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.descTv = paramBundle;
      paramBundle = findViewById(e.e.original_checkbox_layout);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      paramBundle = (LinearLayout)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.Bql = paramBundle;
      paramBundle = findViewById(e.e.original_checkbox);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_checkbox)");
      paramBundle = (CheckBox)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.Bqm = paramBundle;
      paramBundle = findViewById(e.e.original_read_tv);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.original_read_tv)");
      paramBundle = (TextView)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.Bqn = paramBundle;
      paramBundle = findViewById(e.e.cancel_btn);
      kotlin.g.b.s.s(paramBundle, "findViewById(R.id.cancel_btn)");
      paramBundle = (Button)paramBundle;
      kotlin.g.b.s.u(paramBundle, "<set-?>");
      this.Bqo = paramBundle;
      efC().setOnCheckedChangeListener(new FinderOriginalRequestUI..ExternalSyntheticLambda5(this));
      efB().setOnClickListener(new FinderOriginalRequestUI..ExternalSyntheticLambda3(this));
      refreshView();
      com.tencent.mm.kernel.h.aZW().a(3785, (com.tencent.mm.am.h)this);
      AppMethodBeat.o(364858);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(364868);
    super.onDestroy();
    com.tencent.mm.kernel.h.aZW().b(3785, (com.tencent.mm.am.h)this);
    AppMethodBeat.o(364868);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, p paramp)
  {
    AppMethodBeat.i(364874);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.Bqp = 1;
      refreshView();
      AppMethodBeat.o(364874);
      return;
    }
    aa.makeText((Context)this, e.h.finder_network_failed, 0).show();
    AppMethodBeat.o(364874);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */