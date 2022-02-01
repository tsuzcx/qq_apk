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
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.view.inputmethod.InputConnection;
import androidx.fragment.app.FragmentActivity;
import com.tencent.d.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.plugin.finder.b.c;
import com.tencent.mm.plugin.finder.b.e;
import com.tencent.mm.plugin.finder.b.f;
import com.tencent.mm.plugin.finder.b.g;
import com.tencent.mm.plugin.finder.b.j;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.av;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.ao;
import com.tencent.mm.storage.ar.a;
import com.tencent.mm.ui.w.b;
import com.tencent.mm.ui.widget.MMEditText;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"})
public final class FinderEditTextUI
  extends MMFinderUI
{
  private FinderEditTextView AqB;
  private FinderEditFooter AqC;
  final String TAG = "Finder.FinderEditTextUI";
  private HashMap _$_findViewCache;
  
  private final void Qv(int paramInt)
  {
    AppMethodBeat.i(167232);
    Object localObject = FinderEditFooter.BsH;
    if (paramInt == FinderEditFooter.emk())
    {
      localObject = this.AqB;
      if (localObject == null) {
        p.bGy("editView");
      }
      ((FinderEditTextView)localObject).setTextGravity(8388611);
    }
    for (;;)
    {
      getIntent().putExtra("saveAlign", paramInt);
      AppMethodBeat.o(167232);
      return;
      localObject = FinderEditFooter.BsH;
      if (paramInt == FinderEditFooter.eml())
      {
        localObject = this.AqB;
        if (localObject == null) {
          p.bGy("editView");
        }
        ((FinderEditTextView)localObject).setTextGravity(1);
      }
    }
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167231);
    FinderEditTextView localFinderEditTextView = this.AqB;
    if (localFinderEditTextView == null) {
      p.bGy("editView");
    }
    if (Util.isNullOrNil(localFinderEditTextView.getText().toString()))
    {
      finish();
      AppMethodBeat.o(167231);
      return;
    }
    com.tencent.mm.ui.base.h.a((Context)this, b.j.finder_upload_exit_and_save_tips, 0, b.j.finder_upload_exit_save, b.j.finder_upload_exit_not_save, true, (DialogInterface.OnClickListener)new a(this), (DialogInterface.OnClickListener)new b(this), b.c.alert_btn_color_no);
    AppMethodBeat.o(167231);
  }
  
  public final void _$_clearFindViewByIdCache()
  {
    AppMethodBeat.i(275873);
    if (this._$_findViewCache != null) {
      this._$_findViewCache.clear();
    }
    AppMethodBeat.o(275873);
  }
  
  public final View _$_findCachedViewById(int paramInt)
  {
    AppMethodBeat.i(275872);
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
    AppMethodBeat.o(275872);
    return localView1;
  }
  
  public final int getLayoutId()
  {
    return b.g.finder_edit_text_ui;
  }
  
  public final void initView()
  {
    AppMethodBeat.i(167229);
    setMMTitle("");
    setActionbarColor(getResources().getColor(b.c.white));
    addTextOptionMenu(1, getString(b.j.app_nextstep), (MenuItem.OnMenuItemClickListener)new c(this), null, w.b.Wao);
    Object localObject1 = findViewById(b.f.edit_view);
    p.j(localObject1, "findViewById(R.id.edit_view)");
    this.AqB = ((FinderEditTextView)localObject1);
    localObject1 = findViewById(b.f.edit_footer);
    p.j(localObject1, "findViewById(R.id.edit_footer)");
    this.AqC = ((FinderEditFooter)localObject1);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    ((FinderEditTextView)localObject1).setTextMaxLines(10);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    ((FinderEditTextView)localObject1).setTextCursorDrawable(b.e.green_cursor);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    ((FinderEditTextView)localObject1).setTextGravity(8388611);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    ((FinderEditTextView)localObject1).setTextInputType(147457);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    Object localObject2 = getString(b.j.finder_post_text_hint);
    p.j(localObject2, "getString(R.string.finder_post_text_hint)");
    ((FinderEditTextView)localObject1).setTextHint((String)localObject2);
    localObject1 = this.AqB;
    if (localObject1 == null) {
      p.bGy("editView");
    }
    localObject1 = ((FinderEditTextView)localObject1).AVN;
    if (localObject1 == null) {
      p.bGy("editText");
    }
    ((MMEditText)localObject1).requestFocus();
    localObject1 = getIntent().getStringExtra("saveText");
    if (!Util.isNullOrNil((String)localObject1))
    {
      localObject2 = this.AqB;
      if (localObject2 == null) {
        p.bGy("editView");
      }
      p.j(localObject1, "textStr");
      ((FinderEditTextView)localObject2).aGG((String)localObject1);
    }
    int i = getIntent().getIntExtra("saveAlign", -1);
    if (i > 0) {
      Qv(i);
    }
    showVKB();
    localObject1 = this.AqC;
    if (localObject1 == null) {
      p.bGy("editFooter");
    }
    ((FinderEditFooter)localObject1).setAlignModeChangeListener((FinderEditFooter.a)new d(this));
    localObject1 = this.AqC;
    if (localObject1 == null) {
      p.bGy("editFooter");
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
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class a
    implements DialogInterface.OnClickListener
  {
    a(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167221);
      paramDialogInterface = Parcel.obtain();
      p.j(paramDialogInterface, "Parcel.obtain()");
      FinderEditTextUI.c(this.AqD);
      this.AqD.getIntent().writeToParcel(paramDialogInterface, 0);
      paramDialogInterface = paramDialogInterface.marshall();
      f localf = com.tencent.mm.kernel.h.aHG();
      p.j(localf, "MMKernel.storage()");
      localf.aHp().set(ar.a.VAt, e.aC(paramDialogInterface));
      this.AqD.finish();
      AppMethodBeat.o(167221);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "dialog", "Landroid/content/DialogInterface;", "kotlin.jvm.PlatformType", "which", "", "onClick"})
  static final class b
    implements DialogInterface.OnClickListener
  {
    b(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void onClick(DialogInterface paramDialogInterface, int paramInt)
    {
      AppMethodBeat.i(167222);
      paramDialogInterface = com.tencent.mm.kernel.h.aHG();
      p.j(paramDialogInterface, "MMKernel.storage()");
      paramDialogInterface.aHp().set(ar.a.VAt, "");
      this.AqD.finish();
      AppMethodBeat.o(167222);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class c
    implements MenuItem.OnMenuItemClickListener
  {
    c(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167223);
      FinderEditTextUI.a(this.AqD).setTextCursorVisible(false);
      paramMenuItem = BitmapUtil.getBitmapFromView((View)FinderEditTextUI.a(this.AqD));
      if (paramMenuItem != null)
      {
        Object localObject = av.AJz;
        localObject = av.egt() + "text_" + System.nanoTime() + ".tmp";
        BitmapUtil.saveBitmapToImage(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
        paramMenuItem = new ArrayList();
        paramMenuItem.add(localObject);
        localObject = new Intent();
        ((Intent)localObject).putExtra("postType", 7);
        ((Intent)localObject).putExtra("hideDescEdit", true);
        ((Intent)localObject).putExtra("postMediaList", (Serializable)paramMenuItem);
        paramMenuItem = a.ACH;
        a.enterFinderPostUI((Context)this.AqD, (Intent)localObject);
        this.AqD.finish();
      }
      AppMethodBeat.o(167223);
      return true;
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"})
  public static final class d
    implements FinderEditFooter.a
  {
    public final void Qw(int paramInt)
    {
      AppMethodBeat.i(167224);
      Log.i(this.AqD.TAG, "alignMode changed to ".concat(String.valueOf(paramInt)));
      FinderEditTextUI.a(this.AqD, paramInt);
      AppMethodBeat.o(167224);
    }
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"})
  public static final class e
    implements ChatFooterPanel.a
  {
    public final void aDN() {}
    
    public final void aDO()
    {
      AppMethodBeat.i(167226);
      Object localObject = FinderEditTextUI.a(this.AqD).AVN;
      if (localObject == null) {
        p.bGy("editText");
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
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(167225);
      if (!Util.isNullOrNil(paramString))
      {
        FinderEditTextView localFinderEditTextView = FinderEditTextUI.a(this.AqD);
        if (paramString == null) {
          p.iCn();
        }
        localFinderEditTextView.aGG(paramString);
      }
      AppMethodBeat.o(167225);
    }
    
    public final void eE(boolean paramBoolean) {}
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class f
    implements MenuItem.OnMenuItemClickListener
  {
    f(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(167227);
      FinderEditTextUI.b(this.AqD);
      AppMethodBeat.o(167227);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderEditTextUI
 * JD-Core Version:    0.7.0.1
 */