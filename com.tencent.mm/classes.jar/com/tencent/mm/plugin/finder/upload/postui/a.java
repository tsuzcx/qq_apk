package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import com.tencent.mm.sdk.platformtools.Log;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activityView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "(Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;)V", "canPost", "", "getCanPost", "()Z", "setCanPost", "(Z)V", "intent", "Landroid/content/Intent;", "getActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "onCreate", "", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "restore", "save", "shouldInterceptBackPress", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a vUG;
  public Intent intent;
  public final FinderExtendActivityView vUF;
  
  static
  {
    AppMethodBeat.i(253237);
    vUG = new a((byte)0);
    AppMethodBeat.o(253237);
  }
  
  public a(FinderExtendActivityView paramFinderExtendActivityView)
  {
    AppMethodBeat.i(253236);
    this.vUF = paramFinderExtendActivityView;
    AppMethodBeat.o(253236);
  }
  
  public final void aq(Intent paramIntent)
  {
    AppMethodBeat.i(253235);
    p.h(paramIntent, "intent");
    int i = paramIntent.getIntExtra("key_activity_type", 100);
    if (i != 102)
    {
      Log.i("Finder.FinderActivityWidget", "save block activityType:".concat(String.valueOf(i)));
      AppMethodBeat.o(253235);
      return;
    }
    Intent localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    localIntent.putExtra("saveActivity", true);
    this.vUF.b(paramIntent, i);
    paramIntent = this.vUF;
    localIntent = this.intent;
    if (localIntent == null) {
      p.btv("intent");
    }
    paramIntent.setIntentParam(localIntent);
    AppMethodBeat.o(253235);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget$Companion;", "", "()V", "IS_SHOW_CREATE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes9.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.a
 * JD-Core Version:    0.7.0.1
 */