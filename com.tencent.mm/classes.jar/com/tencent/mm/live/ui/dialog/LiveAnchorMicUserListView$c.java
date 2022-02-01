package com.tencent.mm.live.ui.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.model.b.a.a;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class LiveAnchorMicUserListView$c
{
  a.a nmd;
  String title;
  int type;
  
  private LiveAnchorMicUserListView$c(int paramInt, a.a parama, String paramString)
  {
    this.type = paramInt;
    this.nmd = parama;
    this.title = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(246387);
    if (this == paramObject)
    {
      AppMethodBeat.o(246387);
      return true;
    }
    if (!(paramObject instanceof c))
    {
      AppMethodBeat.o(246387);
      return false;
    }
    paramObject = (c)paramObject;
    if (this.type != paramObject.type)
    {
      AppMethodBeat.o(246387);
      return false;
    }
    if (!s.p(this.nmd, paramObject.nmd))
    {
      AppMethodBeat.o(246387);
      return false;
    }
    if (!s.p(this.title, paramObject.title))
    {
      AppMethodBeat.o(246387);
      return false;
    }
    AppMethodBeat.o(246387);
    return true;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(246382);
    int k = this.type;
    int i;
    if (this.nmd == null)
    {
      i = 0;
      if (this.title != null) {
        break label56;
      }
    }
    for (;;)
    {
      AppMethodBeat.o(246382);
      return (i + k * 31) * 31 + j;
      i = this.nmd.hashCode();
      break;
      label56:
      j = this.title.hashCode();
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(246374);
    String str = "LiveMicListItem(type=" + this.type + ", user=" + this.nmd + ", title=" + this.title + ')';
    AppMethodBeat.o(246374);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c
 * JD-Core Version:    0.7.0.1
 */