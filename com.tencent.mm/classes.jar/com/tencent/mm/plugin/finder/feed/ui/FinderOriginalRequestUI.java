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
import com.tencent.mm.ak.f;
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.v;
import com.tencent.mm.plugin.finder.cgi.av;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.k;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.p;
import d.l;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements f
{
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView gXb;
  public WeImageView soo;
  public LinearLayout sop;
  public CheckBox soq;
  public TextView sor;
  public Button sos;
  private int sot;
  private Dialog tipDialog;
  public TextView titleTv;
  
  private final void refreshView()
  {
    AppMethodBeat.i(203282);
    if (this.sot == 1)
    {
      localObject1 = this.soo;
      if (localObject1 == null) {
        p.bdF("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690392);
      localObject1 = this.soo;
      if (localObject1 == null) {
        p.bdF("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099699));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bdF("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766473));
      localObject1 = this.gXb;
      if (localObject1 == null) {
        p.bdF("descTv");
      }
      ((TextView)localObject1).setText(2131766472);
      localObject1 = this.sop;
      if (localObject1 == null) {
        p.bdF("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setText(2131755779);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(203282);
      return;
    }
    Object localObject3;
    TextView localTextView;
    if (this.sot == 0)
    {
      localObject1 = this.soo;
      if (localObject1 == null) {
        p.bdF("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131691487);
      localObject1 = this.soo;
      if (localObject1 == null) {
        p.bdF("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bdF("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766465));
      localObject1 = this.gXb;
      if (localObject1 == null) {
        p.bdF("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766462));
      localObject1 = getString(2131766459);
      localObject2 = getString(2131766458, new Object[] { localObject1 });
      localObject3 = k.sWF;
      localObject3 = getContext();
      p.g(localObject3, "context");
      localObject3 = (Context)localObject3;
      p.g(localObject2, "agreeText");
      p.g(localObject1, "readingText");
      localTextView = this.sor;
      if (localTextView == null) {
        p.bdF("readContentTv");
      }
      k.a((Context)localObject3, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.sop;
      if (localObject1 == null) {
        p.bdF("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setText(2131766460);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(203282);
      return;
    }
    Object localObject1 = this.soo;
    if (localObject1 == null) {
      p.bdF("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(2131690397);
    localObject1 = this.soo;
    if (localObject1 == null) {
      p.bdF("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      p.bdF("titleTv");
    }
    ((TextView)localObject1).setText(2131766478);
    localObject1 = getString(2131766459);
    Object localObject2 = k.sWF;
    if (k.cNU())
    {
      localObject2 = k.sWF;
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = getString(2131766477, new Object[] { localObject1 });
      p.g(localObject3, "getString(R.string.finde…nal_spam_desc2, linkText)");
      p.g(localObject1, "linkText");
      localTextView = this.gXb;
      if (localTextView == null) {
        p.bdF("descTv");
      }
      k.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.sop;
      if (localObject1 == null) {
        p.bdF("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.sos;
      if (localObject1 == null) {
        p.bdF("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(203282);
      return;
      localObject2 = k.sWF;
      localObject2 = getContext();
      p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = k.sWF;
      localObject3 = getString(2131766476, new Object[] { localObject1, String.valueOf(k.cNV()) });
      p.g(localObject3, "getString(R.string.finde….getSpamDay().toString())");
      p.g(localObject1, "linkText");
      localTextView = this.gXb;
      if (localTextView == null) {
        p.bdF("descTv");
      }
      k.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(203284);
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
    AppMethodBeat.o(203284);
    return localView1;
  }
  
  public final Button cDZ()
  {
    AppMethodBeat.i(203279);
    Button localButton = this.sos;
    if (localButton == null) {
      p.bdF("button");
    }
    AppMethodBeat.o(203279);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return 2131496239;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(203280);
    super.onCreate(paramBundle);
    paramBundle = k.sWF;
    if (k.cNT() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.sot = 2;
      }
      setActionbarColor(getResources().getColor(2131101179));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(2131307894);
      p.g(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.soo = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131307900);
      p.g(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(2131307893);
      p.g(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.gXb = ((TextView)paramBundle);
      paramBundle = findViewById(2131307892);
      p.g(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.sop = ((LinearLayout)paramBundle);
      paramBundle = findViewById(2131307891);
      p.g(paramBundle, "findViewById(R.id.original_checkbox)");
      this.soq = ((CheckBox)paramBundle);
      paramBundle = findViewById(2131307897);
      p.g(paramBundle, "findViewById(R.id.original_read_tv)");
      this.sor = ((TextView)paramBundle);
      paramBundle = findViewById(2131297690);
      p.g(paramBundle, "findViewById(R.id.cancel_btn)");
      this.sos = ((Button)paramBundle);
      paramBundle = this.soq;
      if (paramBundle == null) {
        p.bdF("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.sop;
      if (paramBundle == null) {
        p.bdF("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      g.ajj().a(3785, (f)this);
      AppMethodBeat.o(203280);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(203281);
    super.onDestroy();
    g.ajj().b(3785, (f)this);
    AppMethodBeat.o(203281);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(203283);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.sot = 1;
      refreshView();
      AppMethodBeat.o(203283);
      return;
    }
    t.makeText((Context)this, 2131759279, 0).show();
    AppMethodBeat.o(203283);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(203273);
      this.sou.cDZ().setClickable(paramBoolean);
      this.sou.cDZ().setEnabled(paramBoolean);
      AppMethodBeat.o(203273);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203274);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      paramView = this.sou.soq;
      if (paramView == null) {
        p.bdF("readCheckBox");
      }
      paramView.toggle();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203274);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(203275);
      this.sou.finish();
      AppMethodBeat.o(203275);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203276);
      b localb = new b();
      localb.bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.ahF());
      this.sou.finish();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(203276);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(203278);
      Object localObject = new b();
      ((b)localObject).bd(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).ahF());
      paramView = v.aAK();
      if (bu.isNullOrNil(paramView))
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203278);
        return;
      }
      localObject = FinderOriginalRequestUI.a(this.sou);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        p.g(paramView, "username");
        paramView = new av(paramView, (byte)0);
        g.ajj().b((n)paramView);
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(203278);
        return;
        localObject = this.sou;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(2131755906);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)h.b(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(2131755936), false, (DialogInterface.OnCancelListener)a.sov));
      }
    }
    
    @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a sov;
      
      static
      {
        AppMethodBeat.i(203277);
        sov = new a();
        AppMethodBeat.o(203277);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */