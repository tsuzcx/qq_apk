package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.ax;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements com.tencent.mm.al.g
{
  public LinearLayout KSA;
  public CheckBox KSB;
  public TextView KSC;
  private int KSD;
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView lEA;
  public Button mWp;
  public WeImageView tZZ;
  private Dialog tipDialog;
  public TextView titleTv;
  
  private final void refreshView()
  {
    AppMethodBeat.i(198526);
    if (this.KSD == 1)
    {
      localObject1 = this.tZZ;
      if (localObject1 == null) {
        k.aPZ("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690392);
      localObject1 = this.tZZ;
      if (localObject1 == null) {
        k.aPZ("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099699));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        k.aPZ("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766459));
      localObject1 = this.lEA;
      if (localObject1 == null) {
        k.aPZ("descTv");
      }
      ((TextView)localObject1).setText(2131766458);
      localObject1 = this.KSA;
      if (localObject1 == null) {
        k.aPZ("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setText(2131755779);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(198526);
      return;
    }
    Object localObject3;
    TextView localTextView;
    if (this.KSD == 0)
    {
      localObject1 = this.tZZ;
      if (localObject1 == null) {
        k.aPZ("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131691486);
      localObject1 = this.tZZ;
      if (localObject1 == null) {
        k.aPZ("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        k.aPZ("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766446));
      localObject1 = this.lEA;
      if (localObject1 == null) {
        k.aPZ("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766443));
      localObject1 = getString(2131766440);
      localObject2 = getString(2131766439, new Object[] { localObject1 });
      localObject3 = com.tencent.mm.plugin.finder.utils.q.LaJ;
      localObject3 = getContext();
      k.g(localObject3, "context");
      localObject3 = (Context)localObject3;
      k.g(localObject2, "agreeText");
      k.g(localObject1, "readingText");
      localTextView = this.KSC;
      if (localTextView == null) {
        k.aPZ("readContentTv");
      }
      com.tencent.mm.plugin.finder.utils.q.a((Context)localObject3, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.KSA;
      if (localObject1 == null) {
        k.aPZ("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setText(2131766441);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(198526);
      return;
    }
    Object localObject1 = this.tZZ;
    if (localObject1 == null) {
      k.aPZ("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(2131690397);
    localObject1 = this.tZZ;
    if (localObject1 == null) {
      k.aPZ("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      k.aPZ("titleTv");
    }
    ((TextView)localObject1).setText(2131766464);
    localObject1 = getString(2131766440);
    Object localObject2 = com.tencent.mm.plugin.finder.utils.q.LaJ;
    if (com.tencent.mm.plugin.finder.utils.q.fVW())
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.q.LaJ;
      localObject2 = getContext();
      k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = getString(2131766463, new Object[] { localObject1 });
      k.g(localObject3, "getString(R.string.finde…nal_spam_desc2, linkText)");
      k.g(localObject1, "linkText");
      localTextView = this.lEA;
      if (localTextView == null) {
        k.aPZ("descTv");
      }
      com.tencent.mm.plugin.finder.utils.q.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.KSA;
      if (localObject1 == null) {
        k.aPZ("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.mWp;
      if (localObject1 == null) {
        k.aPZ("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(198526);
      return;
      localObject2 = com.tencent.mm.plugin.finder.utils.q.LaJ;
      localObject2 = getContext();
      k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.utils.q.LaJ;
      localObject3 = getString(2131766462, new Object[] { localObject1, String.valueOf(com.tencent.mm.plugin.finder.utils.q.fVX()) });
      k.g(localObject3, "getString(R.string.finde….getSpamDay().toString())");
      k.g(localObject1, "linkText");
      localTextView = this.lEA;
      if (localTextView == null) {
        k.aPZ("descTv");
      }
      com.tencent.mm.plugin.finder.utils.q.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(198528);
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
    AppMethodBeat.o(198528);
    return localView1;
  }
  
  public final Button fTL()
  {
    AppMethodBeat.i(198523);
    Button localButton = this.mWp;
    if (localButton == null) {
      k.aPZ("button");
    }
    AppMethodBeat.o(198523);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return 2131496238;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(198524);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.utils.q.LaJ;
    if (com.tencent.mm.plugin.finder.utils.q.fVV() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.KSD = 2;
      }
      setActionbarColor(getResources().getColor(2131101179));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(2131307802);
      k.g(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.tZZ = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131307808);
      k.g(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(2131307801);
      k.g(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.lEA = ((TextView)paramBundle);
      paramBundle = findViewById(2131307800);
      k.g(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.KSA = ((LinearLayout)paramBundle);
      paramBundle = findViewById(2131307799);
      k.g(paramBundle, "findViewById(R.id.original_checkbox)");
      this.KSB = ((CheckBox)paramBundle);
      paramBundle = findViewById(2131307805);
      k.g(paramBundle, "findViewById(R.id.original_read_tv)");
      this.KSC = ((TextView)paramBundle);
      paramBundle = findViewById(2131297690);
      k.g(paramBundle, "findViewById(R.id.cancel_btn)");
      this.mWp = ((Button)paramBundle);
      paramBundle = this.KSB;
      if (paramBundle == null) {
        k.aPZ("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.KSA;
      if (paramBundle == null) {
        k.aPZ("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      com.tencent.mm.kernel.g.aeS().a(3785, (com.tencent.mm.al.g)this);
      AppMethodBeat.o(198524);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(198525);
    super.onDestroy();
    com.tencent.mm.kernel.g.aeS().b(3785, (com.tencent.mm.al.g)this);
    AppMethodBeat.o(198525);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(198527);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.KSD = 1;
      refreshView();
      AppMethodBeat.o(198527);
      return;
    }
    t.makeText((Context)this, 2131759279, 0).show();
    AppMethodBeat.o(198527);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(198517);
      this.KSE.fTL().setClickable(paramBoolean);
      this.KSE.fTL().setEnabled(paramBoolean);
      AppMethodBeat.o(198517);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198518);
      paramView = this.KSE.KSB;
      if (paramView == null) {
        k.aPZ("readCheckBox");
      }
      paramView.toggle();
      AppMethodBeat.o(198518);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(198519);
      this.KSE.finish();
      AppMethodBeat.o(198519);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198520);
      this.KSE.finish();
      AppMethodBeat.o(198520);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(198522);
      paramView = u.aqO();
      if (bt.isNullOrNil(paramView))
      {
        AppMethodBeat.o(198522);
        return;
      }
      Object localObject = FinderOriginalRequestUI.a(this.KSE);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        k.g(paramView, "username");
        paramView = new ax(paramView, (byte)0);
        com.tencent.mm.kernel.g.aeS().b((n)paramView);
        AppMethodBeat.o(198522);
        return;
        localObject = this.KSE;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(2131755906);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)h.b(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(2131755936), false, (DialogInterface.OnCancelListener)a.KSF));
      }
    }
    
    @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a KSF;
      
      static
      {
        AppMethodBeat.i(198521);
        KSF = new a();
        AppMethodBeat.o(198521);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */