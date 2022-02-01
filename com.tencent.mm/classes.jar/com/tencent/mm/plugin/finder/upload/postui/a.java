package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "Lcom/tencent/mm/plugin/finder/upload/postui/IFinderPostWidget;", "activityView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "(Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;)V", "canPost", "", "getCanPost", "()Z", "setCanPost", "(Z)V", "intent", "Landroid/content/Intent;", "getActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "onCreate", "", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "restore", "save", "shouldInterceptBackPress", "Companion", "plugin-finder_release"})
public final class a
{
  public static final a ACt;
  public final FinderExtendActivityView ACs;
  public Intent intent;
  
  static
  {
    AppMethodBeat.i(289577);
    ACt = new a((byte)0);
    AppMethodBeat.o(289577);
  }
  
  public a(FinderExtendActivityView paramFinderExtendActivityView)
  {
    AppMethodBeat.i(289576);
    this.ACs = paramFinderExtendActivityView;
    AppMethodBeat.o(289576);
  }
  
  public final void aw(Intent paramIntent)
  {
    AppMethodBeat.i(289575);
    p.k(paramIntent, "intent");
    int i = paramIntent.getIntExtra("key_activity_type", 100);
    Intent localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    localIntent.putExtra("saveActivity", true);
    this.ACs.c(paramIntent, i);
    paramIntent = this.ACs;
    localIntent = this.intent;
    if (localIntent == null) {
      p.bGy("intent");
    }
    paramIntent.setIntentParam(localIntent);
    AppMethodBeat.o(289575);
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget$Companion;", "", "()V", "IS_SHOW_CREATE", "", "TAG", "", "plugin-finder_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes10.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.a
 * JD-Core Version:    0.7.0.1
 */