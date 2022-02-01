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
import com.tencent.mm.plugin.finder.utils.r;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.ae;
import com.tencent.mm.sdk.platformtools.bu;
import com.tencent.mm.storage.aj;
import com.tencent.mm.storage.am.a;
import com.tencent.mm.ui.s.b;
import com.tencent.mm.ui.widget.MMEditText;
import d.g.b.p;
import d.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"})
public final class FinderEditTextUI
  extends MMFinderUI
{
  final String TAG = "Finder.FinderEditTextUI";
  private HashMap _$_findViewCache;
  private FinderEditTextView sNo;
  private FinderEditFooter sNp;
  
  private final void FY(int paramInt)
  {
    AppMethodBeat.i(167232);
    Object localObject = FinderEditFooter.tpi;
    if (paramInt == FinderEditFooter.cRi())
    {
      localObject = this.sNo;
      if (localObject == null) {
        p.bdF("editView");
      }
      ((FinderEditTextView)localObject).setTextGravity(8388611);
    }
    for (;;)
    {
      getIntent().putExtra("saveAlign", paramInt);
      AppMethodBeat.o(167232);
      return;
      localObject = FinderEditFooter.tpi;
      if (paramInt == FinderEditFooter.cRj())
      {
        localObject = this.sNo;
        if (localObject == null) {
          p.bdF("editView");
        }
        ((FinderEditTextView)localObject).setTextGravity(1);
      }
    }
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167231);
    FinderEditTextView localFinderEditTextView = this.sNo;
    if (localFinderEditTextView == null) {
      p.bdF("editView");
    }
    if (bu.isNullOrNil(localFinderEditTextView.getText().toString()))
    {
      finish();
      AppMethodBeat.o(167231);
      return;
    }
    com.tencent.mm.ui.base.h.a((Context)this, 2131759390, 0, 2131759392, 2131759391, true, (DialogInterface.OnClickListener)new a(this), (DialogInterface.OnClickListener)new b(this), 2131099903);
    AppMethodBeat.o(167231);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(204551);
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
    AppMethodBeat.o(204551);
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
    addTextOptionMenu(1, getString(2131755830), (MenuItem.OnMenuItemClickListener)new c(this), null, s.b.JwA);
    Object localObject1 = findViewById(2131299268);
    p.g(localObject1, "findViewById(R.id.edit_view)");
    this.sNo = ((FinderEditTextView)localObject1);
    localObject1 = findViewById(2131299256);
    p.g(localObject1, "findViewById(R.id.edit_footer)");
    this.sNp = ((FinderEditFooter)localObject1);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    ((FinderEditTextView)localObject1).setTextMaxLines(10);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    ((FinderEditTextView)localObject1).setTextCursorDrawable(2131232606);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    ((FinderEditTextView)localObject1).setTextGravity(8388611);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    ((FinderEditTextView)localObject1).setTextInputType(147457);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    Object localObject2 = getString(2131759303);
    p.g(localObject2, "getString(R.string.finder_post_text_hint)");
    ((FinderEditTextView)localObject1).setTextHint((String)localObject2);
    localObject1 = this.sNo;
    if (localObject1 == null) {
      p.bdF("editView");
    }
    localObject1 = ((FinderEditTextView)localObject1).tei;
    if (localObject1 == null) {
      p.bdF("editText");
    }
    ((MMEditText)localObject1).requestFocus();
    localObject1 = getIntent().getStringExtra("saveText");
    if (!bu.isNullOrNil((String)localObject1))
    {
      localObject2 = this.sNo;
      if (localObject2 == null) {
        p.bdF("editView");
      }
      p.g(localObject1, "textStr");
      ((FinderEditTextView)localObject2).akn((String)localObject1);
    }
    int i = getIntent().getIntExtra("saveAlign", -1);
    if (i > 0) {
      FY(i);
    }
    showVKB();
    localObject1 = this.sNp;
    if (localObject1 == null) {
      p.bdF("editFooter");
    }
    ((FinderEditFooter)localObject1).setAlignModeChangeListener((FinderEditFooter.a)new d(this));
    localObject1 = this.sNp;
    if (localObject1 == null) {
      p.bdF("editFooter");
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
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167221);
      paramDialogInterface = Parcel.obtain();
      FinderEditTextUI.c(this.sNq);
      this.sNq.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      com.tencent.mm.kernel.e locale = g.ajR();
      p.g(locale, "MMKernel.storage()");
      locale.ajA().set(am.a.Jcv, com.tencent.d.f.e.bytesToHexString(paramDialogInterface));
      this.sNq.finish();
      AppMethodBeat.o(167221);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167222);
      paramDialogInterface = g.ajR();
      p.g(paramDialogInterface, "MMKernel.storage()");
      paramDialogInterface.ajA().set(am.a.Jcv, "");
      this.sNq.finish();
      AppMethodBeat.o(167222);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167223);
      FinderEditTextUI.a(this.sNq).setTextCursorVisible(false);
      paramMenuItem = com.tencent.mm.sdk.platformtools.h.fZ((View)FinderEditTextUI.a(this.sNq));
      if (paramMenuItem != null)
      {
        Object localObject = r.sYn;
        localObject = r.cOx() + "text_" + System.nanoTime() + ".tmp";
        com.tencent.mm.sdk.platformtools.h.a(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
        paramMenuItem = new ArrayList();
        paramMenuItem.add(localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("postType", 7);
        ((Intent)localObject).putExtra("hideDescEdit", true);
        ((Intent)localObject).putExtra("postMediaList", (Serializable)paramMenuItem);
        paramMenuItem = a.sVQ;
        a.enterFinderPostUI((Context)this.sNq, (Intent)localObject);
        this.sNq.finish();
      }
      AppMethodBeat.o(167223);
      return true;
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static final class d
    implements FinderEditFooter.a
  {
    public final void FZ(int paramInt)
    {
      AppMethodBeat.i(167224);
      ae.i(this.sNq.TAG, "alignMode changed to ".concat(String.valueOf(paramInt)));
      FinderEditTextUI.a(this.sNq, paramInt);
      AppMethodBeat.o(167224);
    }
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class e
    implements ChatFooterPanel.a
  {
    public final void apc()
    {
      AppMethodBeat.i(167226);
      Object localObject = FinderEditTextUI.a(this.sNq).tei;
      if (localObject == null) {
        p.bdF("editText");
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
    
    public final void apd() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(167225);
      if (!bu.isNullOrNil(paramString))
      {
        FinderEditTextView localFinderEditTextView = FinderEditTextUI.a(this.sNq);
        if (paramString == null) {
          p.gkB();
        }
        localFinderEditTextView.akn(paramString);
      }
      AppMethodBeat.o(167225);
    }
    
    public final void dW(boolean paramBoolean) {}
  }
  
  @l(gjZ={1, 1, 16}, gka={""}, gkb={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167227);
      FinderEditTextUI.b(this.sNq);
      AppMethodBeat.o(167227);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderEditTextUI
 * JD-Core Version:    0.7.0.1
 */