package com.tencent.mm.live.ui.dialog;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.live.b.b.a.a;
import d.g.b.k;
import d.l;

@l(fNY={1, 1, 16}, fNZ={""}, fOa={"Lcom/tencent/mm/live/ui/dialog/LiveAnchorMicUserListView$LiveMicListItem;", "", "type", "", "user", "Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "title", "", "(ILcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "setTitle", "(Ljava/lang/String;)V", "getType", "()I", "setType", "(I)V", "getUser", "()Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;", "setUser", "(Lcom/tencent/mm/live/model/linkmic/LiveSysMsgManager$LiveMicUser;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-logic_release"})
public final class LiveAnchorMicUserListView$c
{
  a.a gFS;
  String title;
  int type;
  
  private LiveAnchorMicUserListView$c(int paramInt, a.a parama, String paramString)
  {
    this.type = paramInt;
    this.gFS = parama;
    this.title = paramString;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(190563);
    if (this != paramObject)
    {
      if ((paramObject instanceof c))
      {
        paramObject = (c)paramObject;
        if ((this.type != paramObject.type) || (!k.g(this.gFS, paramObject.gFS)) || (!k.g(this.title, paramObject.title))) {}
      }
    }
    else
    {
      AppMethodBeat.o(190563);
      return true;
    }
    AppMethodBeat.o(190563);
    return false;
  }
  
  public final int hashCode()
  {
    int j = 0;
    AppMethodBeat.i(190562);
    int k = this.type;
    Object localObject = this.gFS;
    if (localObject != null) {}
    for (int i = localObject.hashCode();; i = 0)
    {
      localObject = this.title;
      if (localObject != null) {
        j = localObject.hashCode();
      }
      AppMethodBeat.o(190562);
      return (i + k * 31) * 31 + j;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(190561);
    String str = "LiveMicListItem(type=" + this.type + ", user=" + this.gFS + ", title=" + this.title + ")";
    AppMethodBeat.o(190561);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.live.ui.dialog.LiveAnchorMicUserListView.c
 * JD-Core Version:    0.7.0.1
 */