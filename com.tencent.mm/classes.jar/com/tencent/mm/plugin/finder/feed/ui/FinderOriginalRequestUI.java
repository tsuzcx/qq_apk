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
import com.tencent.mm.ak.i;
import com.tencent.mm.ak.q;
import com.tencent.mm.ak.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.kernel.g;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.cgi.by;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.u;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements i
{
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView hPW;
  private Dialog tipDialog;
  public TextView titleTv;
  public WeImageView ubT;
  public LinearLayout ubU;
  public CheckBox ubV;
  public TextView ubW;
  public Button ubX;
  private int ubY;
  
  private final void refreshView()
  {
    AppMethodBeat.i(245444);
    if (this.ubY == 1)
    {
      localObject1 = this.ubT;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690538);
      localObject1 = this.ubT;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099710));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131760387));
      localObject1 = this.hPW;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      ((TextView)localObject1).setText(2131760386);
      localObject1 = this.ubU;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setText(2131755858);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(245444);
      return;
    }
    Object localObject3;
    Object localObject4;
    TextView localTextView;
    if (this.ubY == 0)
    {
      localObject1 = this.ubT;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690279);
      localObject1 = this.ubT;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099793));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131760379));
      localObject1 = this.hPW;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131760376));
      localObject1 = getString(2131760373);
      kotlin.g.b.p.g(localObject1, "getString(R.string.finde…original_agree_tips_link)");
      localObject2 = getString(2131760372, new Object[] { localObject1 });
      kotlin.g.b.p.g(localObject2, "getString(R.string.finde…_agree_tips, readingText)");
      localObject3 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject3 = getContext();
      kotlin.g.b.p.g(localObject3, "context");
      localObject3 = (Context)localObject3;
      localObject4 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject4 = com.tencent.mm.plugin.finder.utils.p.dBT();
      localTextView = this.ubW;
      if (localTextView == null) {
        kotlin.g.b.p.btv("readContentTv");
      }
      com.tencent.mm.plugin.finder.utils.p.a((Context)localObject3, (String)localObject4, (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.ubU;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setText(2131760374);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(245444);
      return;
    }
    Object localObject1 = this.ubT;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(2131690547);
    localObject1 = this.ubT;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099793));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      kotlin.g.b.p.btv("titleTv");
    }
    ((TextView)localObject1).setText(2131760393);
    localObject1 = getString(2131760373);
    kotlin.g.b.p.g(localObject1, "getString(R.string.finde…original_agree_tips_link)");
    Object localObject2 = com.tencent.mm.plugin.finder.utils.p.vVY;
    if (com.tencent.mm.plugin.finder.utils.p.dBX())
    {
      localObject2 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject3 = com.tencent.mm.plugin.finder.utils.p.dBT();
      localObject4 = getString(2131760392, new Object[] { localObject1 });
      kotlin.g.b.p.g(localObject4, "getString(R.string.finde…nal_spam_desc2, linkText)");
      localTextView = this.hPW;
      if (localTextView == null) {
        kotlin.g.b.p.btv("descTv");
      }
      com.tencent.mm.plugin.finder.utils.p.a((Context)localObject2, (String)localObject3, (String)localObject4, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.ubU;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.ubX;
      if (localObject1 == null) {
        kotlin.g.b.p.btv("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(245444);
      return;
      localObject2 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject2 = getContext();
      kotlin.g.b.p.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject3 = com.tencent.mm.plugin.finder.utils.p.dBT();
      localObject4 = com.tencent.mm.plugin.finder.utils.p.vVY;
      localObject4 = getString(2131760391, new Object[] { localObject1, String.valueOf(com.tencent.mm.plugin.finder.utils.p.dBY()) });
      kotlin.g.b.p.g(localObject4, "getString(R.string.finde….getSpamDay().toString())");
      localTextView = this.hPW;
      if (localTextView == null) {
        kotlin.g.b.p.btv("descTv");
      }
      com.tencent.mm.plugin.finder.utils.p.a((Context)localObject2, (String)localObject3, (String)localObject4, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(245447);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(245447);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(245446);
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
    AppMethodBeat.o(245446);
    return localView1;
  }
  
  public final Button dek()
  {
    AppMethodBeat.i(245441);
    Button localButton = this.ubX;
    if (localButton == null) {
      kotlin.g.b.p.btv("button");
    }
    AppMethodBeat.o(245441);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return 2131494554;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(245442);
    super.onCreate(paramBundle);
    paramBundle = com.tencent.mm.plugin.finder.utils.p.vVY;
    if (com.tencent.mm.plugin.finder.utils.p.dBW() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.ubY = 2;
      }
      setActionbarColor(getResources().getColor(2131101424));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(2131305706);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.ubT = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131305717);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(2131305704);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.hPW = ((TextView)paramBundle);
      paramBundle = findViewById(2131305703);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.ubU = ((LinearLayout)paramBundle);
      paramBundle = findViewById(2131305702);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_checkbox)");
      this.ubV = ((CheckBox)paramBundle);
      paramBundle = findViewById(2131305714);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.original_read_tv)");
      this.ubW = ((TextView)paramBundle);
      paramBundle = findViewById(2131297963);
      kotlin.g.b.p.g(paramBundle, "findViewById(R.id.cancel_btn)");
      this.ubX = ((Button)paramBundle);
      paramBundle = this.ubV;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.ubU;
      if (paramBundle == null) {
        kotlin.g.b.p.btv("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      g.azz().a(3785, (i)this);
      AppMethodBeat.o(245442);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(245443);
    super.onDestroy();
    g.azz().b(3785, (i)this);
    AppMethodBeat.o(245443);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(245445);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.ubY = 1;
      refreshView();
      AppMethodBeat.o(245445);
      return;
    }
    u.makeText((Context)this, 2131760326, 0).show();
    AppMethodBeat.o(245445);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(245435);
      this.ubZ.dek().setClickable(paramBoolean);
      this.ubZ.dek().setEnabled(paramBoolean);
      AppMethodBeat.o(245435);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245436);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      paramView = this.ubZ.ubV;
      if (paramView == null) {
        kotlin.g.b.p.btv("readCheckBox");
      }
      paramView.toggle();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245436);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(245437);
      this.ubZ.finish();
      AppMethodBeat.o(245437);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245438);
      b localb = new b();
      localb.bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.axR());
      this.ubZ.finish();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(245438);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(245440);
      Object localObject = new b();
      ((b)localObject).bm(paramView);
      a.b("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).axR());
      paramView = z.aUg();
      if (Util.isNullOrNil(paramView))
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245440);
        return;
      }
      localObject = FinderOriginalRequestUI.a(this.ubZ);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        kotlin.g.b.p.g(paramView, "username");
        paramView = new by(paramView, (byte)0);
        g.azz().b((q)paramView);
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(245440);
        return;
        localObject = this.ubZ;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(2131755998);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)h.a(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(2131756029), false, (DialogInterface.OnCancelListener)a.uca));
      }
    }
    
    @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a uca;
      
      static
      {
        AppMethodBeat.i(245439);
        uca = new a();
        AppMethodBeat.o(245439);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */