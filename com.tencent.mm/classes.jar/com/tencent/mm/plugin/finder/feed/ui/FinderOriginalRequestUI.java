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
import com.tencent.mm.al.f;
import com.tencent.mm.al.n;
import com.tencent.mm.al.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.au;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gfx={1, 1, 16}, gfy={""}, gfz={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements f
{
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView gUs;
  private int sfA;
  public WeImageView sfv;
  public LinearLayout sfw;
  public CheckBox sfx;
  public TextView sfy;
  public Button sfz;
  private Dialog tipDialog;
  public TextView titleTv;
  
  private final void refreshView()
  {
    AppMethodBeat.i(202803);
    if (this.sfA == 1)
    {
      localObject1 = this.sfv;
      if (localObject1 == null) {
        p.bcb("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690392);
      localObject1 = this.sfv;
      if (localObject1 == null) {
        p.bcb("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099699));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bcb("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766473));
      localObject1 = this.gUs;
      if (localObject1 == null) {
        p.bcb("descTv");
      }
      ((TextView)localObject1).setText(2131766472);
      localObject1 = this.sfw;
      if (localObject1 == null) {
        p.bcb("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setText(2131755779);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(202803);
      return;
    }
    Object localObject3;
    TextView localTextView;
    if (this.sfA == 0)
    {
      localObject1 = this.sfv;
      if (localObject1 == null) {
        p.bcb("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131691487);
      localObject1 = this.sfv;
      if (localObject1 == null) {
        p.bcb("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bcb("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766465));
      localObject1 = this.gUs;
      if (localObject1 == null) {
        p.bcb("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766462));
      localObject1 = getString(2131766459);
      localObject2 = getString(2131766458, new Object[] { localObject1 });
      localObject3 = k.sLu;
      localObject3 = getContext();
      p.g(localObject3, "context");
      localObject3 = (Context)localObject3;
      p.g(localObject2, "agreeText");
      p.g(localObject1, "readingText");
      localTextView = this.sfy;
      if (localTextView == null) {
        p.bcb("readContentTv");
      }
      k.a((Context)localObject3, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.sfw;
      if (localObject1 == null) {
        p.bcb("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setText(2131766460);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(202803);
      return;
    }
    Object localObject1 = this.sfv;
    if (localObject1 == null) {
      p.bcb("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(2131690397);
    localObject1 = this.sfv;
    if (localObject1 == null) {
      p.bcb("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      p.bcb("titleTv");
    }
    ((TextView)localObject1).setText(2131766478);
    localObject1 = getString(2131766459);
    Object localObject2 = k.sLu;
    if (k.cLp())
    {
      localObject2 = k.sLu;
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = getString(2131766477, new Object[] { localObject1 });
      p.g(localObject3, "getString(R.string.finde…nal_spam_desc2, linkText)");
      p.g(localObject1, "linkText");
      localTextView = this.gUs;
      if (localTextView == null) {
        p.bcb("descTv");
      }
      k.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.sfw;
      if (localObject1 == null) {
        p.bcb("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.sfz;
      if (localObject1 == null) {
        p.bcb("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(202803);
      return;
      localObject2 = k.sLu;
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = k.sLu;
      localObject3 = getString(2131766476, new Object[] { localObject1, String.valueOf(k.cLq()) });
      p.g(localObject3, "getString(R.string.finde….getSpamDay().toString())");
      p.g(localObject1, "linkText");
      localTextView = this.gUs;
      if (localTextView == null) {
        p.bcb("descTv");
      }
      k.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202805);
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
    AppMethodBeat.o(202805);
    return localView1;
  }
  
  public final Button cCn()
  {
    AppMethodBeat.i(202800);
    Button localButton = this.sfz;
    if (localButton == null) {
      p.bcb("button");
    }
    AppMethodBeat.o(202800);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return 2131496239;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202801);
    super.onCreate(paramBundle);
    paramBundle = k.sLu;
    if (k.cLo() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.sfA = 2;
      }
      setActionbarColor(getResources().getColor(2131101179));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(2131307894);
      p.g(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.sfv = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131307900);
      p.g(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(2131307893);
      p.g(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.gUs = ((TextView)paramBundle);
      paramBundle = findViewById(2131307892);
      p.g(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.sfw = ((LinearLayout)paramBundle);
      paramBundle = findViewById(2131307891);
      p.g(paramBundle, "findViewById(R.id.original_checkbox)");
      this.sfx = ((CheckBox)paramBundle);
      paramBundle = findViewById(2131307897);
      p.g(paramBundle, "findViewById(R.id.original_read_tv)");
      this.sfy = ((TextView)paramBundle);
      paramBundle = findViewById(2131297690);
      p.g(paramBundle, "findViewById(R.id.cancel_btn)");
      this.sfz = ((Button)paramBundle);
      paramBundle = this.sfx;
      if (paramBundle == null) {
        p.bcb("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.sfw;
      if (paramBundle == null) {
        p.bcb("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      g.aiU().a(3785, (f)this);
      AppMethodBeat.o(202801);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202802);
    super.onDestroy();
    g.aiU().b(3785, (f)this);
    AppMethodBeat.o(202802);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202804);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.sfA = 1;
      refreshView();
      AppMethodBeat.o(202804);
      return;
    }
    t.makeText((Context)this, 2131759279, 0).show();
    AppMethodBeat.o(202804);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(202794);
      this.sfB.cCn().setClickable(paramBoolean);
      this.sfB.cCn().setEnabled(paramBoolean);
      AppMethodBeat.o(202794);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202795);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      paramView = this.sfB.sfx;
      if (paramView == null) {
        p.bcb("readCheckBox");
      }
      paramView.toggle();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202795);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202796);
      this.sfB.finish();
      AppMethodBeat.o(202796);
      return true;
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202797);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahq());
      this.sfB.finish();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(202797);
    }
  }
  
  @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202799);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahq());
      paramView = u.aAu();
      if (bt.isNullOrNil(paramView))
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202799);
        return;
      }
      localObject = FinderOriginalRequestUI.a(this.sfB);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        p.g(paramView, "username");
        paramView = new au(paramView, (byte)0);
        g.aiU().b((n)paramView);
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(202799);
        return;
        localObject = this.sfB;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(2131755906);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)h.b(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(2131755936), false, (DialogInterface.OnCancelListener)a.sfC));
      }
    }
    
    @l(gfx={1, 1, 16}, gfy={""}, gfz={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a sfC;
      
      static
      {
        AppMethodBeat.i(202798);
        sfC = new a();
        AppMethodBeat.o(202798);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */