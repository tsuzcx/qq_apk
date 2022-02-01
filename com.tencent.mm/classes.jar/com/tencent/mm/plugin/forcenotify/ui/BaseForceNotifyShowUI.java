package com.tencent.mm.plugin.forcenotify.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.Window;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.forcenotify.b.c;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.ui.MMActivity;
import java.util.concurrent.ConcurrentLinkedQueue;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;

@com.tencent.mm.ui.base.a(3)
@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/forcenotify/ui/BaseForceNotifyShowUI;", "Lcom/tencent/mm/ui/MMActivity;", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "username", "getUsername", "setUsername", "(Ljava/lang/String;)V", "onBackPressed", "", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "plugin-force-notify_release"})
public abstract class BaseForceNotifyShowUI
  extends MMActivity
{
  final String TAG = "MicroMsg.ForceNotifyShowUI";
  String username;
  
  public void onBackPressed()
  {
    super.onBackPressed();
    finish();
    overridePendingTransition(0, 2130772130);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    overridePendingTransition(2130772132, 2130772124);
    getWindow().addFlags(6815872);
    super.onCreate(paramBundle);
    fullScreenNoTitleBar(true);
    setBackBtn((MenuItem.OnMenuItemClickListener)new a(this));
    this.username = ((String)j.f((Iterable)c.wLS.wLF));
    if (TextUtils.isEmpty((CharSequence)this.username))
    {
      this.username = getIntent().getStringExtra("userName");
      Log.w(this.TAG, "fallback to get username! username=" + this.username);
    }
    if (TextUtils.isEmpty((CharSequence)this.username))
    {
      Log.w(this.TAG, "fallback to get username! username=" + this.username);
      this.username = getIntent().getStringExtra("userName");
    }
    if (TextUtils.isEmpty((CharSequence)this.username))
    {
      Log.e(this.TAG, "username is null");
      this.username = "";
      finish();
    }
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    c.wLS.wLF.remove(this.username);
    if (!c.wLS.wLF.isEmpty())
    {
      c localc = c.wLS;
      Object localObject = j.e((Iterable)localc.wLF);
      p.g(localObject, "ForceNotifyService.getNotifyShowList().first()");
      localc.axE((String)localObject);
      Log.i(this.TAG, "continue to startActivity for username=" + (String)j.e((Iterable)c.wLS.wLF));
    }
    Log.i(this.TAG, "[onDestroy]");
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    AppMethodBeat.at(this, paramBoolean);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"<anonymous>", "", "it", "Landroid/view/MenuItem;", "kotlin.jvm.PlatformType", "onMenuItemClick"})
  static final class a
    implements MenuItem.OnMenuItemClickListener
  {
    a(BaseForceNotifyShowUI paramBaseForceNotifyShowUI) {}
    
    public final boolean onMenuItemClick(MenuItem paramMenuItem)
    {
      AppMethodBeat.i(149194);
      this.wLV.onBackPressed();
      AppMethodBeat.o(149194);
      return true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.forcenotify.ui.BaseForceNotifyShowUI
 * JD-Core Version:    0.7.0.1
 */