package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.c.c;
import com.tencent.mm.plugin.forcenotify.d.e;
import com.tencent.mm.plugin.forcenotify.d.f;
import com.tencent.mm.plugin.forcenotify.d.f.a;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.base.a;
import kotlin.l;

@a(3)
@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "notifyItem", "Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "getNotifyItem", "()Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;", "setNotifyItem", "(Lcom/tencent/mm/plugin/forcenotify/model/ForceNotifyItem;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public abstract class BaseForceNotifyShowUI
  extends MMActivity
{
  e BEb;
  private final String TAG = "MicroMsg.ForceNotifyShowUI";
  
  protected final String getTAG()
  {
    return this.TAG;
  }
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
    overridePendingTransition(0, a.a.push_down_out);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(a.a.push_up_in, a.a.pop_out);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    paramBundle = f.BDU;
    if (f.a.eql().hasNext())
    {
      paramBundle = f.BDU;
      this.BEb = f.a.eql().eqk();
      return;
    }
    Log.e(this.TAG, "forceNotify dataList is empty");
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.BEb;
    if (localObject != null)
    {
      f.a locala = f.BDU;
      f.a.eql().aHv(((e)localObject).BDR);
    }
    localObject = f.BDU;
    if (f.a.eql().hasNext())
    {
      Log.i(this.TAG, "continue to showNotifyActivity");
      c.BDQ.rN(true);
    }
    Log.i(this.TAG, "[onDestroy]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(BaseForceNotifyShowUI paramBaseForceNotifyShowUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149194);
      this.BEc.onBackPressed();
      AppMethodBeat.o(149194);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes8.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */