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
import com.tencent.mm.plugin.finder.utils.al;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.base.h;
import com.tencent.mm.ui.t.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"})
public final class FinderEditTextUI
  extends MMFinderUI
{
  final String TAG = "Finder.FinderEditTextUI";
  private HashMap _$_findViewCache;
  private FinderEditTextView vJJ;
  private FinderEditFooter vJK;
  
  private final void Ll(int paramInt)
  {
    AppMethodBeat.i(167232);
    Object localObject = FinderEditFooter.wBZ;
    if (paramInt == FinderEditFooter.dIT())
    {
      localObject = this.vJJ;
      if (localObject == null) {
        p.btv("editView");
      }
      ((FinderEditTextView)localObject).setTextGravity(8388611);
    }
    for (;;)
    {
      getIntent().putExtra("saveAlign", paramInt);
      AppMethodBeat.o(167232);
      return;
      localObject = FinderEditFooter.wBZ;
      if (paramInt == FinderEditFooter.dIU())
      {
        localObject = this.vJJ;
        if (localObject == null) {
          p.btv("editView");
        }
        ((FinderEditTextView)localObject).setTextGravity(1);
      }
    }
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167231);
    FinderEditTextView localFinderEditTextView = this.vJJ;
    if (localFinderEditTextView == null) {
      p.btv("editView");
    }
    if (Util.isNullOrNil(localFinderEditTextView.getText().toString()))
    {
      finish();
      AppMethodBeat.o(167231);
      return;
    }
    h.a((Context)this, 2131760661, 0, 2131760665, 2131760664, true, (DialogInterface.OnClickListener)new a(this), (DialogInterface.OnClickListener)new b(this), 2131099921);
    AppMethodBeat.o(167231);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(252310);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(252310);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(252309);
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
    AppMethodBeat.o(252309);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return 2131494237;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167229);
    setMMTitle("");
    setActionbarColor(getResources().getColor(2131101424));
    addTextOptionMenu(1, getString(2131755916), (MenuItem.OnMenuItemClickListener)new c(this), null, t.b.OGU);
    Object localObject1 = findViewById(2131299849);
    p.g(localObject1, "findViewById(R.id.edit_view)");
    this.vJJ = ((FinderEditTextView)localObject1);
    localObject1 = findViewById(2131299828);
    p.g(localObject1, "findViewById(R.id.edit_footer)");
    this.vJK = ((FinderEditFooter)localObject1);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    ((FinderEditTextView)localObject1).setTextMaxLines(10);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    ((FinderEditTextView)localObject1).setTextCursorDrawable(2131233002);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    ((FinderEditTextView)localObject1).setTextGravity(8388611);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    ((FinderEditTextView)localObject1).setTextInputType(147457);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    Object localObject2 = getString(2131760418);
    p.g(localObject2, "getString(R.string.finder_post_text_hint)");
    ((FinderEditTextView)localObject1).setTextHint((String)localObject2);
    localObject1 = this.vJJ;
    if (localObject1 == null) {
      p.btv("editView");
    }
    localObject1 = ((FinderEditTextView)localObject1).wkS;
    if (localObject1 == null) {
      p.btv("editText");
    }
    ((MMEditText)localObject1).requestFocus();
    localObject1 = getIntent().getStringExtra("saveText");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = this.vJJ;
      if (localObject2 == null) {
        p.btv("editView");
      }
      p.g(localObject1, "textStr");
      ((FinderEditTextView)localObject2).awW((String)localObject1);
    }
    int i = getIntent().getIntExtra("saveAlign", -1);
    if (i > 0) {
      Ll(i);
    }
    showVKB();
    localObject1 = this.vJK;
    if (localObject1 == null) {
      p.btv("editFooter");
    }
    ((FinderEditFooter)localObject1).setAlignModeChangeListener((FinderEditFooter.a)new d(this));
    localObject1 = this.vJK;
    if (localObject1 == null) {
      p.btv("editFooter");
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
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167221);
      paramDialogInterface = Parcel.obtain();
      p.g(paramDialogInterface, "Parcel.obtain()");
      FinderEditTextUI.c(this.vJL);
      this.vJL.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      com.tencent.mm.kernel.e locale = g.aAh();
      p.g(locale, "MMKernel.storage()");
      locale.azQ().set(ar.a.Oly, com.tencent.e.f.e.bytesToHexString(paramDialogInterface));
      this.vJL.finish();
      AppMethodBeat.o(167221);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167222);
      paramDialogInterface = g.aAh();
      p.g(paramDialogInterface, "MMKernel.storage()");
      paramDialogInterface.azQ().set(ar.a.Oly, "");
      this.vJL.finish();
      AppMethodBeat.o(167222);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167223);
      FinderEditTextUI.a(this.vJL).setTextCursorVisible(false);
      paramMenuItem = BitmapUtil.getBitmapFromView((View)FinderEditTextUI.a(this.vJL));
      if (paramMenuItem != null)
      {
        Object localObject = al.waC;
        localObject = al.dEG() + "text_" + System.nanoTime() + ".tmp";
        BitmapUtil.saveBitmapToImage(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
        paramMenuItem = new ArrayList();
        paramMenuItem.add(localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("postType", 7);
        ((Intent)localObject).putExtra("hideDescEdit", true);
        ((Intent)localObject).putExtra("postMediaList", (Serializable)paramMenuItem);
        paramMenuItem = a.vUU;
        a.enterFinderPostUI((Context)this.vJL, (Intent)localObject);
        this.vJL.finish();
      }
      AppMethodBeat.o(167223);
      return true;
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static final class d
    implements FinderEditFooter.a
  {
    public final void Lm(int paramInt)
    {
      AppMethodBeat.i(167224);
      Log.i(this.vJL.TAG, "alignMode changed to ".concat(String.valueOf(paramInt)));
      FinderEditTextUI.a(this.vJL, paramInt);
      AppMethodBeat.o(167224);
    }
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class e
    implements ChatFooterPanel.a
  {
    public final void aHC()
    {
      AppMethodBeat.i(167226);
      Object localObject = FinderEditTextUI.a(this.vJL).wkS;
      if (localObject == null) {
        p.btv("editText");
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
    
    public final void aHD() {}
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(167225);
      if (!Util.isNullOrNil(paramString))
      {
        FinderEditTextView localFinderEditTextView = FinderEditTextUI.a(this.vJL);
        if (paramString == null) {
          p.hyc();
        }
        localFinderEditTextView.awW(paramString);
      }
      AppMethodBeat.o(167225);
    }
    
    public final void eP(boolean paramBoolean) {}
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167227);
      FinderEditTextUI.b(this.vJL);
      AppMethodBeat.o(167227);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderEditTextUI
 * JD-Core Version:    0.7.0.1
 */