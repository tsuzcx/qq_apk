package com.tencent.mm.plugin.finder.feed.ui;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources;
import android.os.Bundle;
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
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.an.i;
import com.tencent.mm.an.q;
import com.tencent.mm.an.t;
import com.tencent.mm.hellhoundlib.a.a;
import com.tencent.mm.hellhoundlib.b.b;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.i;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.cgi.cb;
import com.tencent.mm.plugin.finder.ui.MMFinderUI;
import com.tencent.mm.plugin.finder.utils.v;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.ui.base.w;
import com.tencent.mm.ui.widget.imageview.WeImageView;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "Lcom/tencent/mm/modelbase/IOnSceneEnd;", "()V", "TAG", "", "button", "Landroid/widget/Button;", "getButton", "()Landroid/widget/Button;", "setButton", "(Landroid/widget/Button;)V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "iconIv", "Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "getIconIv", "()Lcom/tencent/mm/ui/widget/imageview/WeImageView;", "setIconIv", "(Lcom/tencent/mm/ui/widget/imageview/WeImageView;)V", "pageState", "", "readCheckBox", "Landroid/widget/CheckBox;", "getReadCheckBox", "()Landroid/widget/CheckBox;", "setReadCheckBox", "(Landroid/widget/CheckBox;)V", "readContentTv", "getReadContentTv", "setReadContentTv", "readLayout", "Landroid/widget/LinearLayout;", "getReadLayout", "()Landroid/widget/LinearLayout;", "setReadLayout", "(Landroid/widget/LinearLayout;)V", "tipDialog", "Landroid/app/Dialog;", "titleTv", "getTitleTv", "setTitleTv", "getLayoutId", "initViews", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onSceneEnd", "errType", "errCode", "errMsg", "scene", "Lcom/tencent/mm/modelbase/NetSceneBase;", "refreshView", "plugin-finder_release"})
public final class FinderOriginalRequestUI
  extends MMFinderUI
  implements i
{
  private final String TAG = "Finder.FinderOriginalRequestUI";
  private HashMap _$_findViewCache;
  public TextView kEs;
  private Dialog tipDialog;
  public TextView titleTv;
  public WeImageView xQM;
  public LinearLayout xQN;
  public CheckBox xQO;
  public TextView xQP;
  public Button xQQ;
  private int xQR;
  
  private final void refreshView()
  {
    AppMethodBeat.i(291134);
    if (this.xQR == 1)
    {
      localObject1 = this.xQM;
      if (localObject1 == null) {
        p.bGy("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(b.i.icons_filled_done2);
      localObject1 = this.xQM;
      if (localObject1 == null) {
        p.bGy("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(b.c.Brand));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bGy("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(b.j.finder_original_has_apply_title));
      localObject1 = this.kEs;
      if (localObject1 == null) {
        p.bGy("descTv");
      }
      ((TextView)localObject1).setText(b.j.finder_original_has_apply_desc);
      localObject1 = this.xQN;
      if (localObject1 == null) {
        p.bGy("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setClickable(true);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setEnabled(true);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setText(b.j.app_finish);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new d(this));
      AppMethodBeat.o(291134);
      return;
    }
    Object localObject3;
    Object localObject4;
    TextView localTextView;
    if (this.xQR == 0)
    {
      localObject1 = this.xQM;
      if (localObject1 == null) {
        p.bGy("iconIv");
      }
      ((WeImageView)localObject1).setImageResource(b.i.finder_original);
      localObject1 = this.xQM;
      if (localObject1 == null) {
        p.bGy("iconIv");
      }
      ((WeImageView)localObject1).setIconColor(getResources().getColor(b.c.Orange_100));
      localObject1 = this.titleTv;
      if (localObject1 == null) {
        p.bGy("titleTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(b.j.finder_original_apply_title));
      localObject1 = this.kEs;
      if (localObject1 == null) {
        p.bGy("descTv");
      }
      ((TextView)localObject1).setText((CharSequence)getString(b.j.finder_original_apply_desc));
      localObject1 = getString(b.j.finder_original_agree_tips_link);
      p.j(localObject1, "getString(R.string.finde…original_agree_tips_link)");
      localObject2 = getString(b.j.finder_original_agree_tips, new Object[] { localObject1 });
      p.j(localObject2, "getString(R.string.finde…_agree_tips, readingText)");
      localObject3 = v.ADV;
      localObject3 = getContext();
      p.j(localObject3, "context");
      localObject3 = (Context)localObject3;
      localObject4 = v.ADV;
      localObject4 = v.edh();
      localTextView = this.xQP;
      if (localTextView == null) {
        p.bGy("readContentTv");
      }
      v.a((Context)localObject3, (String)localObject4, (String)localObject2, (String)localObject1, localTextView, this.TAG);
      localObject1 = this.xQN;
      if (localObject1 == null) {
        p.bGy("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(0);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setVisibility(0);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setText(b.j.finder_original_apply);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setOnClickListener((View.OnClickListener)new e(this));
      AppMethodBeat.o(291134);
      return;
    }
    Object localObject1 = this.xQM;
    if (localObject1 == null) {
      p.bGy("iconIv");
    }
    ((WeImageView)localObject1).setImageResource(b.i.icons_filled_error);
    localObject1 = this.xQM;
    if (localObject1 == null) {
      p.bGy("iconIv");
    }
    ((WeImageView)localObject1).setIconColor(getResources().getColor(b.c.Orange_100));
    localObject1 = this.titleTv;
    if (localObject1 == null) {
      p.bGy("titleTv");
    }
    ((TextView)localObject1).setText(b.j.finder_original_spam_title);
    localObject1 = getString(b.j.finder_original_agree_tips_link);
    p.j(localObject1, "getString(R.string.finde…original_agree_tips_link)");
    Object localObject2 = v.ADV;
    if (v.edl())
    {
      localObject2 = v.ADV;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = v.ADV;
      localObject3 = v.edh();
      localObject4 = getString(b.j.finder_original_spam_desc2, new Object[] { localObject1 });
      p.j(localObject4, "getString(R.string.finde…nal_spam_desc2, linkText)");
      localTextView = this.kEs;
      if (localTextView == null) {
        p.bGy("descTv");
      }
      v.a((Context)localObject2, (String)localObject3, (String)localObject4, (String)localObject1, localTextView, this.TAG);
    }
    for (;;)
    {
      localObject1 = this.xQN;
      if (localObject1 == null) {
        p.bGy("readLayout");
      }
      ((LinearLayout)localObject1).setVisibility(8);
      localObject1 = this.xQQ;
      if (localObject1 == null) {
        p.bGy("button");
      }
      ((Button)localObject1).setVisibility(8);
      AppMethodBeat.o(291134);
      return;
      localObject2 = v.ADV;
      localObject2 = getContext();
      p.j(localObject2, "context");
      localObject2 = (Context)localObject2;
      localObject3 = v.ADV;
      localObject3 = v.edh();
      int i = b.j.finder_original_spam_desc1;
      localObject4 = v.ADV;
      localObject4 = getString(i, new Object[] { localObject1, String.valueOf(v.edm()) });
      p.j(localObject4, "getString(R.string.finde….getSpamDay().toString())");
      localTextView = this.kEs;
      if (localTextView == null) {
        p.bGy("descTv");
      }
      v.a((Context)localObject2, (String)localObject3, (String)localObject4, (String)localObject1, localTextView, this.TAG);
    }
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(291137);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(291137);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(291136);
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
    AppMethodBeat.o(291136);
    return localView1;
  }
  
  public final Button dvI()
  {
    AppMethodBeat.i(291131);
    Button localButton = this.xQQ;
    if (localButton == null) {
      p.bGy("button");
    }
    AppMethodBeat.o(291131);
    return localButton;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_original_request_ui;
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(291132);
    super.onCreate(paramBundle);
    paramBundle = v.ADV;
    if (v.edk() == 3) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.xQR = 2;
      }
      setActionbarColor(getResources().getColor(b.c.white));
      setMMTitle("");
      setBackBtn((MenuItem.OnMenuItemClickListener)new c(this));
      paramBundle = findViewById(b.f.original_icon_iv);
      p.j(paramBundle, "findViewById(R.id.original_icon_iv)");
      this.xQM = ((WeImageView)paramBundle);
      paramBundle = findViewById(b.f.original_title_tv);
      p.j(paramBundle, "findViewById(R.id.original_title_tv)");
      this.titleTv = ((TextView)paramBundle);
      paramBundle = findViewById(b.f.original_desc_tv);
      p.j(paramBundle, "findViewById(R.id.original_desc_tv)");
      this.kEs = ((TextView)paramBundle);
      paramBundle = findViewById(b.f.original_checkbox_layout);
      p.j(paramBundle, "findViewById(R.id.original_checkbox_layout)");
      this.xQN = ((LinearLayout)paramBundle);
      paramBundle = findViewById(b.f.original_checkbox);
      p.j(paramBundle, "findViewById(R.id.original_checkbox)");
      this.xQO = ((CheckBox)paramBundle);
      paramBundle = findViewById(b.f.original_read_tv);
      p.j(paramBundle, "findViewById(R.id.original_read_tv)");
      this.xQP = ((TextView)paramBundle);
      paramBundle = findViewById(b.f.cancel_btn);
      p.j(paramBundle, "findViewById(R.id.cancel_btn)");
      this.xQQ = ((Button)paramBundle);
      paramBundle = this.xQO;
      if (paramBundle == null) {
        p.bGy("readCheckBox");
      }
      paramBundle.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener)new a(this));
      paramBundle = this.xQN;
      if (paramBundle == null) {
        p.bGy("readLayout");
      }
      paramBundle.setOnClickListener((View.OnClickListener)new b(this));
      refreshView();
      com.tencent.mm.kernel.h.aGY().a(3785, (i)this);
      AppMethodBeat.o(291132);
      return;
    }
  }
  
  public final void onDestroy()
  {
    AppMethodBeat.i(291133);
    super.onDestroy();
    com.tencent.mm.kernel.h.aGY().b(3785, (i)this);
    AppMethodBeat.o(291133);
  }
  
  public final void onSceneEnd(int paramInt1, int paramInt2, String paramString, q paramq)
  {
    AppMethodBeat.i(291135);
    paramString = this.tipDialog;
    if (paramString != null) {
      paramString.dismiss();
    }
    if ((paramInt1 == 0) && (paramInt2 == 0))
    {
      this.xQR = 1;
      refreshView();
      AppMethodBeat.o(291135);
      return;
    }
    w.makeText((Context)this, b.j.finder_network_failed, 0).show();
    AppMethodBeat.o(291135);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "buttonView", "Landroid/widget/CompoundButton;", "kotlin.jvm.PlatformType", "isChecked", "", "onCheckedChanged"})
  static final class a
    implements CompoundButton.OnCheckedChangeListener
  {
    a(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onCheckedChanged(CompoundButton paramCompoundButton, boolean paramBoolean)
    {
      AppMethodBeat.i(277830);
      this.xQS.dvI().setClickable(paramBoolean);
      this.xQS.dvI().setEnabled(paramBoolean);
      AppMethodBeat.o(277830);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class b
    implements View.OnClickListener
  {
    b(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(285858);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      paramView = this.xQS.xQO;
      if (paramView == null) {
        p.bGy("readCheckBox");
      }
      paramView.toggle();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$initViews$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(285858);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(277569);
      this.xQS.finish();
      AppMethodBeat.o(277569);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class d
    implements View.OnClickListener
  {
    d(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(265461);
      b localb = new b();
      localb.bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, localb.aFi());
      this.xQS.finish();
      a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$1", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
      AppMethodBeat.o(265461);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onClick"})
  static final class e
    implements View.OnClickListener
  {
    e(FinderOriginalRequestUI paramFinderOriginalRequestUI) {}
    
    public final void onClick(View paramView)
    {
      AppMethodBeat.i(288139);
      Object localObject = new b();
      ((b)localObject).bn(paramView);
      a.c("com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V", this, ((b)localObject).aFi());
      paramView = z.bdh();
      if (Util.isNullOrNil(paramView))
      {
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288139);
        return;
      }
      localObject = FinderOriginalRequestUI.a(this.xQS);
      if (localObject != null) {
        ((Dialog)localObject).show();
      }
      for (;;)
      {
        p.j(paramView, "username");
        paramView = new cb(paramView, (byte)0);
        com.tencent.mm.kernel.h.aGY().b((q)paramView);
        a.a(this, "com/tencent/mm/plugin/finder/feed/ui/FinderOriginalRequestUI$refreshView$2", "android/view/View$OnClickListener", "onClick", "(Landroid/view/View;)V");
        AppMethodBeat.o(288139);
        return;
        localObject = this.xQS;
        Context localContext = (Context)((FinderOriginalRequestUI)localObject).getContext();
        ((FinderOriginalRequestUI)localObject).getContext().getString(b.j.app_tip);
        FinderOriginalRequestUI.a((FinderOriginalRequestUI)localObject, (Dialog)com.tencent.mm.ui.base.h.a(localContext, ((FinderOriginalRequestUI)localObject).getContext().getString(b.j.app_waiting), false, (DialogInterface.OnCancelListener)a.xQT));
      }
    }
    
    @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "onCancel"})
    static final class a
      implements DialogInterface.OnCancelListener
    {
      public static final a xQT;
      
      static
      {
        AppMethodBeat.i(225270);
        xQT = new a();
        AppMethodBeat.o(225270);
      }
      
      public final void onCancel(DialogInterface paramDialogInterface) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderOriginalRequestUI
 * JD-Core Version:    0.7.0.1
 */