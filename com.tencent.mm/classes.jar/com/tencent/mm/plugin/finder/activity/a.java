package com.tencent.mm.plugin.finder.activity;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore;", "", "()V", "Companion", "plugin-finder_release"})
public final class a
{
  private static Intent tqe;
  public static final a tqf;
  
  static
  {
    AppMethodBeat.i(241997);
    tqf = new a((byte)0);
    AppMethodBeat.o(241997);
  }
  
  @l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/plugin/finder/activity/ActivityParamStore$Companion;", "", "()V", "TAG", "", "storeIntent", "Landroid/content/Intent;", "getStoreIntent", "()Landroid/content/Intent;", "setStoreIntent", "(Landroid/content/Intent;)V", "reset", "", "restore", "intent", "save", "setActivityParam", "srcIntent", "dstIntent", "plugin-finder_release"})
  public static final class a
  {
    public static void a(Intent paramIntent1, Intent paramIntent2)
    {
      AppMethodBeat.i(241996);
      int i = paramIntent1.getIntExtra("key_activity_type", 0);
      boolean bool = paramIntent1.getBooleanExtra("saveActivity", false);
      if ((i == 102) && (bool))
      {
        paramIntent2.putExtra("saveActivity", true);
        paramIntent2.putExtra("key_activity_type", 102);
        String str2 = paramIntent1.getStringExtra("key_user_name");
        String str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramIntent2.putExtra("key_user_name", str1);
        str2 = paramIntent1.getStringExtra("key_nick_name");
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramIntent2.putExtra("key_nick_name", str1);
        str2 = paramIntent1.getStringExtra("key_cover_url");
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramIntent2.putExtra("key_cover_url", str1);
        str2 = paramIntent1.getStringExtra("key_avatar_url");
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramIntent2.putExtra("key_avatar_url", str1);
        paramIntent2.putExtra("key_topic_id", paramIntent1.getLongExtra("key_topic_id", 0L));
        str2 = paramIntent1.getStringExtra("key_activity_name");
        str1 = str2;
        if (str2 == null) {
          str1 = "";
        }
        paramIntent2.putExtra("key_activity_name", str1);
        str1 = paramIntent1.getStringExtra("key_activity_desc");
        paramIntent1 = str1;
        if (str1 == null) {
          paramIntent1 = "";
        }
        paramIntent2.putExtra("key_activity_desc", paramIntent1);
      }
      AppMethodBeat.o(241996);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.activity.a
 * JD-Core Version:    0.7.0.1
 */