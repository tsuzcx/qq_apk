package com.tencent.mm.plugin.finder.upload.postui;

import android.content.Intent;
import android.os.Bundle;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.model.z;
import com.tencent.mm.plugin.finder.api.i;
import com.tencent.mm.plugin.finder.view.FinderExtendActivityView;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget;", "Lcom/tencent/mm/plugin/finder/api/IFinderPostWidget;", "activityView", "Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;", "(Lcom/tencent/mm/plugin/finder/view/FinderExtendActivityView;)V", "canPost", "", "getCanPost", "()Z", "setCanPost", "(Z)V", "intent", "Landroid/content/Intent;", "getActivityEvent", "Lcom/tencent/mm/protocal/protobuf/FinderObjectEventDesc;", "getActivityEventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "onCreate", "", "postData", "Landroid/os/Bundle;", "onDestroy", "onPause", "onResume", "restore", "save", "shouldInterceptBackPress", "Companion", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  implements i
{
  public static final a Gfi;
  public final FinderExtendActivityView Gfj;
  private Intent intent;
  
  static
  {
    AppMethodBeat.i(342853);
    Gfi = new a((byte)0);
    AppMethodBeat.o(342853);
  }
  
  public a(FinderExtendActivityView paramFinderExtendActivityView)
  {
    AppMethodBeat.i(342845);
    this.Gfj = paramFinderExtendActivityView;
    AppMethodBeat.o(342845);
  }
  
  public static void onDestroy()
  {
    AppMethodBeat.i(342849);
    com.tencent.mm.plugin.finder.activity.a.a locala = com.tencent.mm.plugin.finder.activity.a.Atw;
    h.jXD();
    com.tencent.mm.plugin.finder.activity.a.ao(null);
    AppMethodBeat.o(342849);
  }
  
  public final void ap(Intent paramIntent)
  {
    Object localObject2 = null;
    AppMethodBeat.i(342886);
    s.u(paramIntent, "intent");
    int i = paramIntent.getIntExtra("key_activity_type", 100);
    Intent localIntent = this.intent;
    Object localObject1 = localIntent;
    if (localIntent == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    ((Intent)localObject1).putExtra("saveActivity", true);
    this.Gfj.b(paramIntent, i);
    localObject1 = this.Gfj;
    paramIntent = this.intent;
    if (paramIntent == null)
    {
      s.bIx("intent");
      paramIntent = localObject2;
    }
    for (;;)
    {
      ((FinderExtendActivityView)localObject1).setIntentParam(paramIntent);
      AppMethodBeat.o(342886);
      return;
    }
  }
  
  public final void c(Intent paramIntent, Bundle paramBundle)
  {
    AppMethodBeat.i(342864);
    s.u(paramIntent, "intent");
    s.u(paramBundle, "postData");
    this.intent = paramIntent;
    s.u(paramIntent, "intent");
    paramBundle = com.tencent.mm.plugin.finder.activity.a.Atw;
    s.u(paramIntent, "intent");
    paramBundle = com.tencent.mm.plugin.finder.activity.a.dTp();
    if (paramBundle != null)
    {
      h.jXD();
      com.tencent.mm.plugin.finder.activity.a.a locala = com.tencent.mm.plugin.finder.activity.a.Atw;
      com.tencent.mm.plugin.finder.activity.a.a.a(paramBundle, paramIntent);
    }
    int i = paramIntent.getIntExtra("key_activity_type", 100);
    this.Gfj.b(paramIntent, i);
    AppMethodBeat.o(342864);
  }
  
  public final awt feC()
  {
    Object localObject2 = null;
    AppMethodBeat.i(342878);
    Object localObject3 = this.intent;
    Object localObject1 = localObject3;
    if (localObject3 == null)
    {
      s.bIx("intent");
      localObject1 = null;
    }
    if (((Intent)localObject1).getBooleanExtra("saveActivity", false))
    {
      awt localawt = new awt();
      localObject3 = this.intent;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("intent");
        localObject1 = null;
      }
      localawt.ocD = ((Intent)localObject1).getLongExtra("key_topic_id", 0L);
      localObject3 = this.intent;
      localObject1 = localObject3;
      if (localObject3 == null)
      {
        s.bIx("intent");
        localObject1 = null;
      }
      int i;
      if (((Intent)localObject1).getIntExtra("key_activity_type", 0) == 101)
      {
        i = 0;
        localawt.ZHL = i;
        FinderContact localFinderContact = new FinderContact();
        if (localawt.ZHL != 0) {
          break label463;
        }
        localObject1 = z.bAW();
        label142:
        localFinderContact.username = ((String)localObject1);
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject3 = ((Intent)localObject1).getStringExtra("key_nick_name");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localFinderContact.nickname = ((String)localObject1);
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject3 = ((Intent)localObject1).getStringExtra("key_avatar_url");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localFinderContact.headUrl = ((String)localObject1);
        localObject1 = ah.aiuX;
        localawt.contact = localFinderContact;
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject3 = ((Intent)localObject1).getStringExtra("key_cover_url");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localawt.coverImgUrl = ((String)localObject1);
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject3 = ((Intent)localObject1).getStringExtra("key_activity_name");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localawt.eventName = ((String)localObject1);
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject3 = ((Intent)localObject1).getStringExtra("key_activity_desc");
        localObject1 = localObject3;
        if (localObject3 == null) {
          localObject1 = "";
        }
        localawt.description = ((String)localObject1);
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localawt.endTime = ((Intent)localObject1).getLongExtra("key_activity_end_time", 0L);
        localObject1 = this.intent;
        if (localObject1 != null) {
          break label504;
        }
        s.bIx("intent");
        localObject1 = localObject2;
      }
      label463:
      label504:
      for (;;)
      {
        localawt.FOi = ((Intent)localObject1).getLongExtra("key_activity_display_mask", 0L);
        AppMethodBeat.o(342878);
        return localawt;
        i = 1;
        break;
        localObject3 = this.intent;
        localObject1 = localObject3;
        if (localObject3 == null)
        {
          s.bIx("intent");
          localObject1 = null;
        }
        localObject1 = ((Intent)localObject1).getStringExtra("key_user_name");
        if (localObject1 == null)
        {
          localObject1 = "";
          break label142;
        }
        break label142;
      }
    }
    AppMethodBeat.o(342878);
    return null;
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/postui/FinderActivityWidget$Companion;", "", "()V", "IS_SHOW_CREATE", "", "TAG", "", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.postui.a
 * JD-Core Version:    0.7.0.1
 */