package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import com.tencent.e.f.h;
import com.tencent.matrix.trace.core.AppMethodBeat;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore;", "", "()V", "Companion", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a Atw;
  private static Intent Atx;
  
  static
  {
    AppMethodBeat.i(347956);
    Atw = new a((byte)0);
    AppMethodBeat.o(347956);
  }
  
  @Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore$Companion;", "", "()V", "TAG", "", "storeIntent", "Landroid/content/Intent;", "getStoreIntent", "()Landroid/content/Intent;", "setStoreIntent", "(Landroid/content/Intent;)V", "getJumpInfo", "", "Lcom/tencent/mm/protocal/protobuf/FinderJumpInfo;", "getPostWording", "reset", "", "restore", "intent", "save", "setActivityParam", "srcIntent", "dstIntent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static final class a
  {
    public static void a(Intent paramIntent1, Intent paramIntent2)
    {
      AppMethodBeat.i(347987);
      int i = paramIntent1.getIntExtra("key_activity_type", 0);
      boolean bool = paramIntent1.getBooleanExtra("saveActivity", false);
      if ((i == 102) && (bool))
      {
        paramIntent2.putExtra("saveActivity", true);
        paramIntent2.putExtra("key_activity_type", 102);
        String str = paramIntent1.getStringExtra("key_user_name");
        Object localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_user_name", (String)localObject);
        str = paramIntent1.getStringExtra("key_nick_name");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_nick_name", (String)localObject);
        str = paramIntent1.getStringExtra("key_cover_url");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_cover_url", (String)localObject);
        str = paramIntent1.getStringExtra("key_avatar_url");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_avatar_url", (String)localObject);
        paramIntent2.putExtra("key_topic_id", paramIntent1.getLongExtra("key_topic_id", 0L));
        str = paramIntent1.getStringExtra("key_activity_name");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_activity_name", (String)localObject);
        str = paramIntent1.getStringExtra("key_activity_desc");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_activity_desc", (String)localObject);
        str = paramIntent1.getStringExtra("key_activity_post_wording");
        localObject = str;
        if (str == null) {
          localObject = "";
        }
        paramIntent2.putExtra("key_activity_post_wording", (String)localObject);
        paramIntent2.putExtra("key_activity_end_time", paramIntent1.getLongExtra("key_activity_end_time", 0L));
        paramIntent2.putExtra("key_activity_src_type", "key_scene_from_profile");
        localObject = paramIntent1.getSerializableExtra("key_activity_jump_info_list");
        if (localObject != null) {
          paramIntent2.putExtra("key_activity_jump_info_list", (Serializable)localObject);
        }
        paramIntent2.putExtra("key_activity_display_mask", paramIntent1.getLongExtra("key_activity_display_mask", 0L));
        paramIntent1 = paramIntent1.getByteArrayExtra("key_wording_info");
        if (paramIntent1 != null) {
          paramIntent2.putExtra("key_wording_info", paramIntent1);
        }
      }
      AppMethodBeat.o(347987);
    }
    
    public static void ap(Intent paramIntent)
    {
      AppMethodBeat.i(347971);
      s.u(paramIntent, "intent");
      h.jXD();
      if (a.dTp() == null) {
        a.ao(new Intent());
      }
      Intent localIntent = a.dTp();
      if (localIntent != null)
      {
        a locala = a.Atw;
        a(paramIntent, localIntent);
      }
      AppMethodBeat.o(347971);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.a
 * JD-Core Version:    0.7.0.1
 */