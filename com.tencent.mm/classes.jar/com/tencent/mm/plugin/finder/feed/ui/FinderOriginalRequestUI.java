package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
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
import com.tencent.mm.ak.n;
import com.tencent.mm.ak.q;
import com.tencent.mm.model.u;
import com.tencent.mm.plugin.finder.cgi.an;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.j;
import com.tencent.mm.sdk.platformtools.bs;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.base.t;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import d.g.b.k;
import d.l;
import java.util.HashMap;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements com.tencent.mm.ak.g
{
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView gAI;
  public Button nyO;
  public WeImageView rqs;
  public LinearLayout rqt;
  public CheckBox rqu;
  public TextView rqv;
  private int rqw;
  private Dialog tipDialog;
  public TextView titleTv;
  
  private final void refreshView()
  {
    AppMethodBeat.i(202440);
    if (this.rqw == 1)
    {
      localObject1 = this.rqs;
      if (localObject1 == null) {
        k.aVY("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131690392);
      localObject1 = this.rqs;
      if (localObject1 == null) {
        k.aVY("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099699));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        k.aVY("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766473));
      localObject1 = this.gAI;
      if (localObject1 == null) {
        k.aVY("descTv");
      }
      ((TextView)localObject1).setText(2131766472);
      localObject1 = this.rqt;
      if (localObject1 == null) {
        k.aVY("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setText(2131755779);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(202440);
      return;
    }
    Object localObject3;
    TextView localTextView;
    if (this.rqw == 0)
    {
      localObject1 = this.rqs;
      if (localObject1 == null) {
        k.aVY("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(2131691487);
      localObject1 = this.rqs;
      if (localObject1 == null) {
        k.aVY("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        k.aVY("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766465));
      localObject1 = this.gAI;
      if (localObject1 == null) {
        k.aVY("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(2131766462));
      localObject1 = getString(2131766459);
      localObject2 = getString(2131766458, new Object[] { localObject1 });
      localObject3 = j.rOX;
      localObject3 = getContext();
      k.g(localObject3, "context");
      localObject3 = (Context)localObject3;
      k.g(localObject2, "agreeText");
      k.g(localObject1, "readingText");
      localTextView = this.rqv;
      if (localTextView == null) {
        k.aVY("readContentTv");
      }
      j.a((Context)localObject3, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.rqt;
      if (localObject1 == null) {
        k.aVY("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setText(2131766460);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(202440);
      return;
    }
    Object localObject1 = this.rqs;
    if (localObject1 == null) {
      k.aVY("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(2131690397);
    localObject1 = this.rqs;
    if (localObject1 == null) {
      k.aVY("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(2131099778));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      k.aVY("titleTv");
    }
    ((TextView)localObject1).setText(2131766478);
    localObject1 = getString(2131766459);
    Object localObject2 = j.rOX;
    if (j.cCY())
    {
      localObject2 = j.rOX;
      localObject2 = getContext();
      k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = getString(2131766477, new Object[] { localObject1 });
      k.g(localObject3, "getString(R.string.finde…nal_spam_desc2, linkText)");
      k.g(localObject1, "linkText");
      localTextView = this.gAI;
      if (localTextView == null) {
        k.aVY("descTv");
      }
      j.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.rqt;
      if (localObject1 == null) {
        k.aVY("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.nyO;
      if (localObject1 == null) {
        k.aVY("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(202440);
      return;
      localObject2 = j.rOX;
      localObject2 = getContext();
      k.g(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = j.rOX;
      localObject3 = getString(2131766476, new Object[] { localObject1, String.valueOf(j.cCZ()) });
      k.g(localObject3, "getString(R.string.finde….getSpamDay().toString())");
      k.g(localObject1, "linkText");
      localTextView = this.gAI;
      if (localTextView == null) {
        k.aVY("descTv");
      }
      j.a((Context)localObject2, "https://weixin.qq.com/cgi-bin/readtemplate?t=finder_appeal", (String)localObject3, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(202442);
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
    AppMethodBeat.o(202442);
    return localView1;
  }
  
  public final Button cvY()
  {
    AppMethodBeat.i(202437);
    Button localButton = this.nyO;
    if (localButton == null) {
      k.aVY("button");
    }
    AppMethodBeat.o(202437);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return 2131496239;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(202438);
    super.onCreate(paramBundle);
    paramBundle = j.rOX;
    if (j.cCX() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.rqw = 2;
      }
      setActionbarColor(getResources().getColor(2131101179));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(2131307894);
      k.g(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.rqs = ((WeImageView)paramBundle);
      paramBundle = findViewById(2131307900);
      k.g(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(2131307893);
      k.g(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.gAI = ((TextView)paramBundle);
      paramBundle = findViewById(2131307892);
      k.g(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.rqt = ((LinearLayout)paramBundle);
      paramBundle = findViewById(2131307891);
      k.g(paramBundle, "findViewById(R.id.original_checkbox)");
      this.rqu = ((CheckBox)paramBundle);
      paramBundle = findViewById(2131307897);
      k.g(paramBundle, "findViewById(R.id.original_read_tv)");
      this.rqv = ((TextView)paramBundle);
      paramBundle = findViewById(2131297690);
      k.g(paramBundle, "findViewById(R.id.cancel_btn)");
      this.nyO = ((Button)paramBundle);
      paramBundle = this.rqu;
      if (paramBundle == null) {
        k.aVY("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.rqt;
      if (paramBundle == null) {
        k.aVY("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      com.tencent.mm.kernel.g.agi().a(3785, (com.tencent.mm.ak.g)this);
      AppMethodBeat.o(202438);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(202439);
    super.onDestroy();
    com.tencent.mm.kernel.g.agi().b(3785, (com.tencent.mm.ak.g)this);
    AppMethodBeat.o(202439);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, n paramn)
  {
    AppMethodBeat.i(202441);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.rqw = 1;
      refreshView();
      AppMethodBeat.o(202441);
      return;
    }
    t.makeText((Context)this, 2131759279, 0).show();
    AppMethodBeat.o(202441);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(202431);
      this.rqx.cvY().setClickable(paramBoolean);
      this.rqx.cvY().setEnabled(paramBoolean);
      AppMethodBeat.o(202431);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202432);
      paramView = this.rqx.rqu;
      if (paramView == null) {
        k.aVY("readCheckBox");
      }
      paramView.toggle();
      AppMethodBeat.o(202432);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(202433);
      this.rqx.finish();
      AppMethodBeat.o(202433);
      return true;
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202434);
      this.rqx.finish();
      AppMethodBeat.o(202434);
    }
  }
  
  @l(fNY={1, 1, 16}, fNZ={""}, fOa={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(202436);
      paramView = u.axE();
      if (bs.isNullOrNil(paramView))
      {
        AppMethodBeat.o(202436);
        return;
      }
      Object localObject = FinderOriginalRequestUI.a(this.rqx);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        k.g(paramView, "username");
        paramView = new an(paramView, (byte)0);
        com.tencent.mm.kernel.g.agi().b((n)paramView);
        AppMethodBeat.o(202436);
        return;
        localObject = this.rqx;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(2131755906);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)h.b(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(2131755936), false, (DialogInterface.OnCancelListener)FinderOriginalRequestUI.e.a.rqy));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */