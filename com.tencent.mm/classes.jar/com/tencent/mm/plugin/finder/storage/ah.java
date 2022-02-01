package com.tencent.mm.plugin.finder.storage;

import android.content.Intent;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.kernel.f;
import com.tencent.mm.kernel.h;
import com.tencent.mm.protocal.protobuf.FinderContact;
import com.tencent.mm.protocal.protobuf.awt;
import com.tencent.mm.protocal.protobuf.djj;
import com.tencent.mm.storage.aq;
import com.tencent.mm.storage.at.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/storage/FinderPostUtil2;", "", "()V", "genFeedPostInfo", "Lcom/tencent/mm/protocal/protobuf/LocalFinderPostInfo;", "getEventInfoFromIntent", "", "eventInfo", "Lcom/tencent/mm/protocal/protobuf/FinderEventInfo;", "intent", "Landroid/content/Intent;", "getNextLocalId", "", "getNickNameAndEventNameTogether", "", "nickName", "eventName", "putEventInfoToIntent", "resetEventInfoToIntent", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ah
{
  public static final ah FMh;
  
  static
  {
    AppMethodBeat.i(339487);
    FMh = new ah();
    AppMethodBeat.o(339487);
  }
  
  public static void a(awt paramawt, Intent paramIntent)
  {
    AppMethodBeat.i(339459);
    s.u(paramawt, "eventInfo");
    s.u(paramIntent, "intent");
    Object localObject = paramawt.contact;
    if (localObject == null)
    {
      localObject = "";
      paramIntent.putExtra("key_user_name", (String)localObject);
      localObject = paramawt.contact;
      if (localObject != null) {
        break label154;
      }
      localObject = null;
      label48:
      paramIntent.putExtra("key_nick_name", (String)localObject);
      paramIntent.putExtra("key_cover_url", paramawt.coverImgUrl);
      localObject = paramawt.contact;
      if (localObject != null) {
        break label162;
      }
      localObject = "";
    }
    for (;;)
    {
      paramIntent.putExtra("key_avatar_url", (String)localObject);
      paramIntent.putExtra("key_topic_id", paramawt.ocD);
      paramIntent.putExtra("key_activity_name", paramawt.eventName);
      paramIntent.putExtra("key_activity_desc", paramawt.description);
      paramIntent.putExtra("key_activity_end_time", paramawt.endTime);
      AppMethodBeat.o(339459);
      return;
      String str = ((FinderContact)localObject).username;
      localObject = str;
      if (str != null) {
        break;
      }
      localObject = "";
      break;
      label154:
      localObject = ((FinderContact)localObject).nickname;
      break label48;
      label162:
      str = ((FinderContact)localObject).headUrl;
      localObject = str;
      if (str == null) {
        localObject = "";
      }
    }
  }
  
  public static void aI(Intent paramIntent)
  {
    AppMethodBeat.i(339469);
    s.u(paramIntent, "intent");
    paramIntent.removeExtra("key_user_name");
    paramIntent.removeExtra("key_nick_name");
    paramIntent.removeExtra("key_cover_url");
    paramIntent.removeExtra("key_avatar_url");
    paramIntent.removeExtra("key_topic_id");
    paramIntent.removeExtra("key_activity_name");
    paramIntent.removeExtra("key_activity_desc");
    paramIntent.removeExtra("key_activity_end_time");
    AppMethodBeat.o(339469);
  }
  
  public static djj eZB()
  {
    AppMethodBeat.i(339429);
    djj localdjj = new djj();
    localdjj.clientId = s.X("FinderLocal_", Long.valueOf(System.nanoTime()));
    AppMethodBeat.o(339429);
    return localdjj;
  }
  
  public static long eZC()
  {
    AppMethodBeat.i(339445);
    ??? = n.FKF;
    synchronized (n.eZk())
    {
      long l = h.baE().ban().a(at.a.acZO, 1L);
      h.baE().ban().set(at.a.acZO, Long.valueOf(1L + l));
      kotlin.ah localah = kotlin.ah.aiuX;
      AppMethodBeat.o(339445);
      return l;
    }
  }
  
  public static String jdMethod_if(String paramString1, String paramString2)
  {
    AppMethodBeat.i(339479);
    paramString1 = paramString1 + ": " + paramString2;
    AppMethodBeat.o(339479);
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.storage.ah
 * JD-Core Version:    0.7.0.1
 */