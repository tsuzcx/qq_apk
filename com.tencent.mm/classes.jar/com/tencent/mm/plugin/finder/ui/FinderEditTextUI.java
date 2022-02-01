package com.tencent.mm.plugin.finder.ui;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap.CompressFormat;
import android.os.Bundle;
import android.os.Parcel;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputConnection;
import com.tencent.e.f.e;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.plugin.finder.e.b;
import com.tencent.mm.plugin.finder.e.d;
import com.tencent.mm.plugin.finder.e.e;
import com.tencent.mm.plugin.finder.e.f;
import com.tencent.mm.plugin.finder.e.h;
import com.tencent.mm.plugin.finder.utils.a;
import com.tencent.mm.plugin.finder.utils.bm;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.a;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditFooter.b;
import com.tencent.mm.plugin.finder.widget.edit.FinderEditTextView;
import com.tencent.mm.pluginsdk.ui.ChatFooterPanel.a;
import com.tencent.mm.sdk.platformtools.BitmapUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.Util;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.widget.MMEditText;
import com.tencent.mm.ui.y.b;
import java.io.Serializable;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/ui/FinderEditTextUI;", "Lcom/tencent/mm/plugin/finder/ui/MMFinderUI;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "editFooter", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter;", "editView", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditTextView;", "getLayoutId", "", "goBack", "", "initView", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "restore", "saveTextData", "switchAlignMode", "alignMode", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class FinderEditTextUI
  extends MMFinderUI
{
  private FinderEditTextView FQr;
  private FinderEditFooter FQs;
  final String TAG = "Finder.FinderEditTextUI";
  
  private final void TD(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    AppMethodBeat.i(167232);
    FinderEditFooter.b localb = FinderEditFooter.GZq;
    if (paramInt == FinderEditFooter.fqv())
    {
      localObject1 = this.FQr;
      if (localObject1 == null)
      {
        s.bIx("editView");
        localObject1 = localObject2;
        ((FinderEditTextView)localObject1).setTextGravity(8388611);
      }
    }
    do
    {
      getIntent().putExtra("saveAlign", paramInt);
      AppMethodBeat.o(167232);
      return;
      break;
      localObject2 = FinderEditFooter.GZq;
    } while (paramInt != FinderEditFooter.fqw());
    localObject2 = this.FQr;
    if (localObject2 == null) {
      s.bIx("editView");
    }
    for (;;)
    {
      ((FinderEditTextView)localObject1).setTextGravity(1);
      break;
      localObject1 = localObject2;
    }
  }
  
  private static final void a(FinderEditTextUI paramFinderEditTextUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(346845);
    s.u(paramFinderEditTextUI, "this$0");
    Parcel localParcel = Parcel.obtain();
    s.s(localParcel, "obtain()");
    Intent localIntent = paramFinderEditTextUI.getIntent();
    FinderEditTextView localFinderEditTextView = paramFinderEditTextUI.FQr;
    paramDialogInterface = localFinderEditTextView;
    if (localFinderEditTextView == null)
    {
      s.bIx("editView");
      paramDialogInterface = null;
    }
    localIntent.putExtra("saveText", paramDialogInterface.getText());
    paramFinderEditTextUI.getIntent().writeToParcel(localParcel, 0);
    paramDialogInterface = localParcel.marshall();
    h.baE().ban().set(at.a.adcL, e.aC(paramDialogInterface));
    paramFinderEditTextUI.finish();
    AppMethodBeat.o(346845);
  }
  
  private static final boolean a(FinderEditTextUI paramFinderEditTextUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346832);
    s.u(paramFinderEditTextUI, "this$0");
    Object localObject = paramFinderEditTextUI.FQr;
    paramMenuItem = (MenuItem)localObject;
    if (localObject == null)
    {
      s.bIx("editView");
      paramMenuItem = null;
    }
    paramMenuItem.setTextCursorVisible(false);
    localObject = paramFinderEditTextUI.FQr;
    paramMenuItem = (MenuItem)localObject;
    if (localObject == null)
    {
      s.bIx("editView");
      paramMenuItem = null;
    }
    paramMenuItem = BitmapUtil.getBitmapFromView((View)paramMenuItem);
    if (paramMenuItem != null)
    {
      localObject = bm.GlZ;
      localObject = bm.fit() + "text_" + System.nanoTime() + ".tmp";
      BitmapUtil.saveBitmapToImage(paramMenuItem, 80, Bitmap.CompressFormat.JPEG, (String)localObject, true);
      paramMenuItem = new ArrayList();
      paramMenuItem.add(localObject);
      localObject = new Intent();
      ((Intent)localObject).putExtra("postType", 7);
      ((Intent)localObject).putExtra("hideDescEdit", true);
      ((Intent)localObject).putExtra("postMediaList", (Serializable)paramMenuItem);
      paramMenuItem = a.GfO;
      a.enterFinderPostUI((Context)paramFinderEditTextUI, (Intent)localObject);
      paramFinderEditTextUI.finish();
    }
    AppMethodBeat.o(346832);
    return true;
  }
  
  private static final void b(FinderEditTextUI paramFinderEditTextUI, DialogInterface paramDialogInterface, int paramInt)
  {
    AppMethodBeat.i(346854);
    s.u(paramFinderEditTextUI, "this$0");
    h.baE().ban().set(at.a.adcL, "");
    paramFinderEditTextUI.finish();
    AppMethodBeat.o(346854);
  }
  
  private static final boolean b(FinderEditTextUI paramFinderEditTextUI, MenuItem paramMenuItem)
  {
    AppMethodBeat.i(346841);
    s.u(paramFinderEditTextUI, "this$0");
    paramFinderEditTextUI.goBack();
    AppMethodBeat.o(346841);
    return true;
  }
  
  private final void goBack()
  {
    AppMethodBeat.i(167231);
    FinderEditTextView localFinderEditTextView2 = this.FQr;
    FinderEditTextView localFinderEditTextView1 = localFinderEditTextView2;
    if (localFinderEditTextView2 == null)
    {
      s.bIx("editView");
      localFinderEditTextView1 = null;
    }
    if (Util.isNullOrNil(localFinderEditTextView1.getText().toString()))
    {
      finish();
      AppMethodBeat.o(167231);
      return;
    }
    k.a((Context)this, e.h.finder_upload_exit_and_save_tips, 0, e.h.finder_upload_exit_save, e.h.finder_upload_exit_not_save, true, new FinderEditTextUI..ExternalSyntheticLambda0(this), new FinderEditTextUI..ExternalSyntheticLambda1(this), e.b.alert_btn_color_no);
    AppMethodBeat.o(167231);
  }
  
  public final void _$_clearFindViewByIdCache() {}
  
  public final int getLayoutId()
  {
    return e.f.finder_edit_text_ui;
  }
  
  public final void initView()
  {
    Object localObject2 = null;
    AppMethodBeat.i(167229);
    setMMTitle("");
    setActionbarColor(getResources().getColor(e.b.white));
    addTextOptionMenu(1, getString(e.h.app_nextstep), new FinderEditTextUI..ExternalSyntheticLambda2(this), null, y.b.adEJ);
    Object localObject1 = findViewById(e.e.edit_view);
    s.s(localObject1, "findViewById(R.id.edit_view)");
    this.FQr = ((FinderEditTextView)localObject1);
    localObject1 = findViewById(e.e.edit_footer);
    s.s(localObject1, "findViewById(R.id.edit_footer)");
    this.FQs = ((FinderEditFooter)localObject1);
    Object localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    ((FinderEditTextView)localObject1).setTextMaxLines(10);
    localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    ((FinderEditTextView)localObject1).setTextCursorDrawable(e.d.green_cursor);
    localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    ((FinderEditTextView)localObject1).setTextGravity(8388611);
    localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    ((FinderEditTextView)localObject1).setTextInputType(147457);
    localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    localObject3 = getString(e.h.finder_post_text_hint);
    s.s(localObject3, "getString(R.string.finder_post_text_hint)");
    ((FinderEditTextView)localObject1).setTextHint((String)localObject3);
    localObject3 = this.FQr;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editView");
      localObject1 = null;
    }
    localObject3 = ((FinderEditTextView)localObject1).GBE;
    localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("editText");
      localObject1 = null;
    }
    ((MMEditText)localObject1).requestFocus();
    String str = getIntent().getStringExtra("saveText");
    if (!Util.isNullOrNil(str))
    {
      localObject3 = this.FQr;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("editView");
        localObject1 = null;
      }
      s.checkNotNull(str);
      ((FinderEditTextView)localObject1).aCV(str);
    }
    int i = getIntent().getIntExtra("saveAlign", -1);
    if (i > 0) {
      TD(i);
    }
    showVKB();
    localObject1 = this.FQs;
    if (localObject1 == null)
    {
      s.bIx("editFooter");
      localObject1 = null;
      ((FinderEditFooter)localObject1).setAlignModeChangeListener((FinderEditFooter.a)new a(this));
      localObject1 = this.FQs;
      if (localObject1 != null) {
        break label462;
      }
      s.bIx("editFooter");
      localObject1 = localObject2;
    }
    label462:
    for (;;)
    {
      ((FinderEditFooter)localObject1).setSmileyTextOperationListener((ChatFooterPanel.a)new b(this));
      setBackBtn(new FinderEditTextUI..ExternalSyntheticLambda3(this));
      AppMethodBeat.o(167229);
      return;
      break;
    }
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
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$2", "Lcom/tencent/mm/plugin/finder/widget/edit/FinderEditFooter$AlignModeChangeListener;", "onAlignModeChange", "", "alignMode", "", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
    implements FinderEditFooter.a
  {
    a(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void TE(int paramInt)
    {
      AppMethodBeat.i(167224);
      Log.i(this.FQt.TAG, s.X("alignMode changed to ", Integer.valueOf(paramInt)));
      FinderEditTextUI.a(this.FQt, paramInt);
      AppMethodBeat.o(167224);
    }
  }
  
  @Metadata(d1={""}, d2={"com/tencent/mm/plugin/finder/ui/FinderEditTextUI$initView$3", "Lcom/tencent/mm/pluginsdk/ui/ChatFooterPanel$OnTextOperationListener;", "append", "", "text", "", "del", "onToSendTextEnable", "enable", "", "performSend", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class b
    implements ChatFooterPanel.a
  {
    b(FinderEditTextUI paramFinderEditTextUI) {}
    
    public final void aWL() {}
    
    public final void aWM()
    {
      Object localObject2 = null;
      AppMethodBeat.i(167226);
      FinderEditTextView localFinderEditTextView = FinderEditTextUI.a(this.FQt);
      Object localObject1 = localFinderEditTextView;
      if (localFinderEditTextView == null)
      {
        s.bIx("editView");
        localObject1 = null;
      }
      localObject1 = ((FinderEditTextView)localObject1).GBE;
      if (localObject1 == null)
      {
        s.bIx("editText");
        localObject1 = localObject2;
      }
      for (;;)
      {
        localObject1 = ((MMEditText)localObject1).getInputConnection();
        if (localObject1 != null)
        {
          ((InputConnection)localObject1).sendKeyEvent(new KeyEvent(0, 67));
          ((InputConnection)localObject1).sendKeyEvent(new KeyEvent(1, 67));
        }
        AppMethodBeat.o(167226);
        return;
      }
    }
    
    public final void append(String paramString)
    {
      AppMethodBeat.i(167225);
      if (!Util.isNullOrNil(paramString))
      {
        FinderEditTextView localFinderEditTextView2 = FinderEditTextUI.a(this.FQt);
        FinderEditTextView localFinderEditTextView1 = localFinderEditTextView2;
        if (localFinderEditTextView2 == null)
        {
          s.bIx("editView");
          localFinderEditTextView1 = null;
        }
        s.checkNotNull(paramString);
        localFinderEditTextView1.aCV(paramString);
      }
      AppMethodBeat.o(167225);
    }
    
    public final void fp(boolean paramBoolean) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.ui.FinderEditTextUI
 * JD-Core Version:    0.7.0.1
 */