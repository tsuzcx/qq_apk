package com.tencent.mm.plugin.forcenotify.ui;

import a.a.j;
import a.l;
import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.sdk.platformtools.ab;
import com.tencent.mm.ui.MMActivity;
import java.util.concurrent.ConcurrentLinkedQueue;

@l(eaO={1, 1, 13}, eaP={""}, eaQ={"Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "username", "getUsername", "setUsername", "(Ljava/lang/String;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
@com.tencent.mm.ui.base.a(3)
public abstract class BaseForceNotifyShowUI
  extends MMActivity
{
  final String TAG = "MicroMsg.ForceNotifyShowUI";
  String username;
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
    overridePendingTransition(0, 2131034228);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(2131034230, 2131034222);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new BaseForceNotifyShowUI.a(this));
    if (!c.mHu.mHh.isEmpty()) {
      this.username = ((String)j.e((Iterable)c.mHu.mHh));
    }
    if (TextUtils.isEmpty((CharSequence)this.username))
    {
      ab.e(this.TAG, "username is null");
      this.username = "";
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.mHu.mHh.remove(this.username);
    if (!c.mHu.mHh.isEmpty()) {
      startActivity(getIntent());
    }
    ab.i(this.TAG, "[onDestroy]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */