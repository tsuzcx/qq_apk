package com.tencent.mm.plugin.finder.ui;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.support.v4.app.FragmentActivity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.g;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.bt;
import com.tencent.mm.sdk.platformtools.f;
import com.tencent.mm.storage.ab;
import com.tencent.mm.storage.ae.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.r.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"})
public final class FinderEditTextUI
  extends MMFinderUI
{
  final String TAG = "Finder.FinderEditTextUI";
  private HashMap _$_findViewCache;
  private FinderEditTextView qMf;
  private FinderEditFooter qMg;
  
  private final void CY(int paramInt)
  {
    AppMethodBeat.i(167232);
    Object localObject = FinderEditFooter.qZP;
    if (paramInt == FinderEditFooter.ctm())
    {
      localObject = this.qMf;
      if (localObject == null) {
        d.g.b.k.aPZ("editView");
      }
      ((FinderEditTextView)localObject).setTextGravity(8388611);
    }
    for (;;)
    {
      getIntent().putExtra("saveAlign", paramInt);
      AppMethodBeat.o(167232);
      return;
      localObject = FinderEditFooter.qZP;
      if (paramInt == FinderEditFooter.ctn())
      {
        localObject = this.qMf;
        if (localObject == null) {
          d.g.b.k.aPZ("editView");
        }
        ((FinderEditTextView)localObject).setTextGravity(1);
      }
    }
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167231);
    FinderEditTextView localFinderEditTextView = this.qMf;
    if (localFinderEditTextView == null) {
      d.g.b.k.aPZ("editView");
    }
    if (bt.isNullOrNil(localFinderEditTextView.getText().toString()))
    {
      finish();
      AppMethodBeat.o(167231);
      return;
    }
    h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new a(this), (DialogInterface.OnClickListener)new b(this), 2131099903);
    AppMethodBeat.o(167231);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(199200);
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
    AppMethodBeat.o(199200);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494028;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167229);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101179));
    addTextOptionMenu(1, getString(2131755830), (MenuItem.OnMenuItemClickListener)new c(this), null, r.b.FOB);
    Object localObject1 = findViewById(2131299268);
    d.g.b.k.g(localObject1, "findViewById(R.id.edit_view)");
    this.qMf = ((FinderEditTextView)localObject1);
    localObject1 = findViewById(2131299256);
    d.g.b.k.g(localObject1, "findViewById(R.id.edit_footer)");
    this.qMg = ((FinderEditFooter)localObject1);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    ((FinderEditTextView)localObject1).setTextMaxLines(10);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    ((FinderEditTextView)localObject1).setTextCursorDrawable(2131232606);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    ((FinderEditTextView)localObject1).setTextGravity(8388611);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    ((FinderEditTextView)localObject1).setTextInputType(147457);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    Object localObject2 = getString(2131759303);
    d.g.b.k.g(localObject2, "getString(R.string.finder_post_text_hint)");
    ((FinderEditTextView)localObject1).setTextHint((String)localObject2);
    localObject1 = this.qMf;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editView");
    }
    localObject1 = ((FinderEditTextView)localObject1).qVV;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editText");
    }
    ((MMEditText)localObject1).requestFocus();
    localObject1 = getIntent().getStringExtra("saveText");
    if (!bt.isNullOrNil((String)localObject1))
    {
      localObject2 = this.qMf;
      if (localObject2 == null) {
        d.g.b.k.aPZ("editView");
      }
      d.g.b.k.g(localObject1, "textStr");
      ((FinderEditTextView)localObject2).aab((String)localObject1);
    }
    int i = getIntent().getIntExtra("saveAlign", -1);
    if (i > 0) {
      CY(i);
    }
    showVKB();
    localObject1 = this.qMg;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editFooter");
    }
    ((FinderEditFooter)localObject1).setAlignModeChangeListener((FinderEditFooter.a)new d(this));
    localObject1 = this.qMg;
    if (localObject1 == null) {
      d.g.b.k.aPZ("editFooter");
    }
    ((FinderEditFooter)localObject1).setSmileyTextOperationListener((ChatFooterPanel.a)new e(this));
    setBackBtn((MenuItem.OnMenuItemClickListener)new f(this));
    AppMethodBeat.o(167229);
  }
  
  public final void onBackPressed()
  {
    AppMethodBeat.i(167230);
    goBack();
    AppMethodBeat.o(167230);
  }
  
  public final void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(167228);
    super.onCreate(paramBundle);
    initView();
    AppMethodBeat.o(167228);
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167221);
      paramDialogInterface = Parcel.obtain();
      FinderEditTextUI.c(this.qMh);
      this.qMh.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      com.tencent.mm.kernel.e locale = g.afB();
      d.g.b.k.g(locale, "MMKernel.storage()");
      locale.afk().set(ae.a.FwU, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      this.qMh.finish();
      AppMethodBeat.o(167221);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167222);
      paramDialogInterface = g.afB();
      d.g.b.k.g(paramDialogInterface, "MMKernel.storage()");
      paramDialogInterface.afk().set(ae.a.FwU, "");
      this.qMh.finish();
      AppMethodBeat.o(167222);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167223);
      FinderEditTextUI.a(this.qMh).setTextCursorVisible(false);
      paramMenuItem = f.fy((View)FinderEditTextUI.a(this.qMh));
      if (paramMenuItem != null)
      {
        Object localObject = com.tencent.mm.plugin.finder.utils.k.qTp;
        localObject = com.tencent.mm.plugin.finder.utils.k.csc() + "text_" + System.nanoTime() + ".tmp";
        f.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
        paramMenuItem = new ArrayList();
        paramMenuItem.add(localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("postType", 7);
        ((Intent)localObject).putExtra("hideDescEdit", true);
        ((Intent)localObject).putExtra("postMediaList", (Serializable)paramMenuItem);
        paramMenuItem = a.qSb;
        a.enterFinderPostUI((Context)this.qMh, (Intent)localObject);
        this.qMh.finish();
      }
      AppMethodBeat.o(167223);
      return true;
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static final class d
    implements FinderEditFooter.a
  {
    public final void CZ(int paramInt)
    {
      AppMethodBeat.i(167224);
      ad.i(this.qMh.TAG, "alignMode changed to ".concat(String.valueOf(paramInt)));
      FinderEditTextUI.a(this.qMh, paramInt);
      AppMethodBeat.o(167224);
    }
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class e
    implements ChatFooterPanel.a
  {
    public final void append(String paramString)
    {
      AppMethodBeat.i(167225);
      if (!bt.isNullOrNil(paramString))
      {
        FinderEditTextView localFinderEditTextView = FinderEditTextUI.a(this.qMh);
        if (paramString == null) {
          d.g.b.k.fvU();
        }
        localFinderEditTextView.aab(paramString);
      }
      AppMethodBeat.o(167225);
    }
    
    public final void btF()
    {
      AppMethodBeat.i(167226);
      Object localObject = FinderEditTextUI.a(this.qMh).qVV;
      if (localObject == null) {
        d.g.b.k.aPZ("editText");
      }
      localObject = ((MMEditText)localObject).getInputConnection();
      if (localObject != null)
      {
        ((InputConnection)localObject).sendKeyEvent(new KeyEvent(0, 67));
        ((InputConnection)localObject).sendKeyEvent(new KeyEvent(1, 67));
        AppMethodBeat.o(167226);
        return;
      }
      AppMethodBeat.o(167226);
    }
    
    public final void cqY() {}
    
    public final void lf(boolean paramBoolean) {}
  }
  
  @l(fvt={1, 1, 16}, fvu={""}, fvv={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167227);
      FinderEditTextUI.b(this.qMh);
      AppMethodBeat.o(167227);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderEditTextUI
 * JD-Core Version:    0.7.0.1
 */