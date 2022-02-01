package com.tencent.mm.plugin.finder.upload.action;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/upload/action/FinderFeedCleaner$RecorderStore;", "", "username", "", "followRecorder", "Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "noSeeAuthorRecorder", "noSeeFriendRecorder", "(Ljava/lang/String;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;)V", "getFollowRecorder", "()Lcom/tencent/mm/plugin/finder/upload/action/FinderRecorder;", "getNoSeeAuthorRecorder", "getNoSeeFriendRecorder", "getUsername", "()Ljava/lang/String;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f$a
{
  public final g GcS;
  public final g GcT;
  public final g GcX;
  private final String username;
  
  public f$a(String paramString, g paramg1, g paramg2, g paramg3)
  {
    AppMethodBeat.i(343300);
    this.username = paramString;
    this.GcS = paramg1;
    this.GcT = paramg2;
    this.GcX = paramg3;
    AppMethodBeat.o(343300);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(343319);
    if (this == paramObject)
    {
      AppMethodBeat.o(343319);
      return true;
    }
    if (!(paramObject instanceof a))
    {
      AppMethodBeat.o(343319);
      return false;
    }
    paramObject = (a)paramObject;
    if (!s.p(this.username, paramObject.username))
    {
      AppMethodBeat.o(343319);
      return false;
    }
    if (!s.p(this.GcS, paramObject.GcS))
    {
      AppMethodBeat.o(343319);
      return false;
    }
    if (!s.p(this.GcT, paramObject.GcT))
    {
      AppMethodBeat.o(343319);
      return false;
    }
    if (!s.p(this.GcX, paramObject.GcX))
    {
      AppMethodBeat.o(343319);
      return false;
    }
    AppMethodBeat.o(343319);
    return true;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(343312);
    int i = this.username.hashCode();
    int j = this.GcS.hashCode();
    int k = this.GcT.hashCode();
    int m = this.GcX.hashCode();
    AppMethodBeat.o(343312);
    return ((i * 31 + j) * 31 + k) * 31 + m;
  }
  
  public final String toString()
  {
    AppMethodBeat.i(343306);
    String str = "RecorderStore(username=" + this.username + ", followRecorder=" + this.GcS + ", noSeeAuthorRecorder=" + this.GcT + ", noSeeFriendRecorder=" + this.GcX + ')';
    AppMethodBeat.o(343306);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes12.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.upload.action.f.a
 * JD-Core Version:    0.7.0.1
 */