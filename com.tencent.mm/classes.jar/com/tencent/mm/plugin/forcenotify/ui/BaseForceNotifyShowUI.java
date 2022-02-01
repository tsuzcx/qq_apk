package com.tencent.mm.plugin.forcenotify.ui;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.a.a;
import com.tencent.mm.plugin.forcenotify.c.i;
import com.tencent.mm.plugin.forcenotify.c.i.a;
import com.tencent.mm.plugin.forcenotify.core.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import kotlin.Metadata;
import kotlin.g.b.s;

@com.tencent.mm.ui.base.a(3)
@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "notifyItem", "Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "getNotifyItem", "()Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;", "setNotifyItem", "(Lcom/tencent/mm/plugin/forcenotify/model/BaseMsgItem;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class BaseForceNotifyShowUI
  extends MMActivity
{
  com.tencent.mm.plugin.forcenotify.c.a HoB;
  private final String TAG = "MicroMsg.ForceNotifyShowUI";
  
  private static final boolean a(BaseForceNotifyShowUI paramBaseForceNotifyShowUI, MenuItem paramMenuItem)
  {
    s.u(paramBaseForceNotifyShowUI, "this$0");
    paramBaseForceNotifyShowUI.onBackPressed();
    return true;
  }
  
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
    setBackBtn(new BaseForceNotifyShowUI..ExternalSyntheticLambda0(this));
    paramBundle = i.Hos;
    if (i.a.fwN().hasNext())
    {
      paramBundle = i.Hos;
      this.HoB = i.a.fwN().fwM();
      return;
    }
    Log.e(this.TAG, "forceNotify dataList is empty");
    finish();
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    Object localObject = this.HoB;
    if (localObject != null)
    {
      i.a locala = i.Hos;
      i.a.fwN().aDR(((com.tencent.mm.plugin.forcenotify.c.a)localObject).id);
    }
    localObject = i.Hos;
    if (i.a.fwN().hasNext())
    {
      Log.i(this.TAG, "continue to showNotifyActivity");
      c.Hoc.vL(true);
    }
    Log.i(this.TAG, "[onDestroy]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */