package com.tencent.mm.live.ui.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.a.a;
import d.g.b.p;
import d.l;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class LiveAnchorMicUserListView$c
{
  a.a hcp;
  String title;
  int type;
  
  private LiveAnchorMicUserListView$c(int paramInt, a.a parama, String paramString)
  {
    this.type = paramInt;
    this.hcp = parama;
    this.title = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(216481);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.type != paramObject.type) || (!p.i(this.hcp, paramObject.hcp)) || (!p.i(this.title, paramObject.title))) {}
      }
    }
    else
    {
      AppMethodBeat.o(216481);
      return true;
    }
    AppMethodBeat.o(216481);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(216480);
    int k = this.type;
    Object localObject = this.hcp;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.title;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(216480);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(216479);
    String str = "LiveMicListItem(type=" + this.type + ", user=" + this.hcp + ", title=" + this.title + ")";
    AppMethodBeat.o(216479);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c
 * JD-Core Version:    0.7.0.1
 */