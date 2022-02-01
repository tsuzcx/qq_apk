package com.tencent.mm.plugin.finder.feed.ui;

import com.tencent.matrix.trace.core.AppMethodBeat;
import d.g.b.p;
import d.l;
import java.util.LinkedList;

@l(gjZ={1, 1, 16}, gka={""}, gkb={"Lcom/tencent/mm/plugin/finder/feed/ui/FinderProfileUI$UserExtInfo;", "", "friendFollowCount", "", "fansCount", "userTags", "Ljava/util/LinkedList;", "", "(IILjava/util/LinkedList;)V", "getFansCount", "()I", "setFansCount", "(I)V", "getFriendFollowCount", "setFriendFollowCount", "getUserTags", "()Ljava/util/LinkedList;", "setUserTags", "(Ljava/util/LinkedList;)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "toString", "plugin-finder_release"})
public final class FinderProfileUI$b
{
  int fansCount;
  int friendFollowCount;
  LinkedList<String> userTags;
  
  public FinderProfileUI$b(LinkedList<String> paramLinkedList)
  {
    AppMethodBeat.i(166154);
    this.friendFollowCount = -1;
    this.fansCount = -1;
    this.userTags = paramLinkedList;
    AppMethodBeat.o(166154);
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(166157);
    if (this != paramObject)
    {
      if ((paramObject instanceof b))
      {
        paramObject = (b)paramObject;
        if ((this.friendFollowCount != paramObject.friendFollowCount) || (this.fansCount != paramObject.fansCount) || (!p.i(this.userTags, paramObject.userTags))) {}
      }
    }
    else
    {
      AppMethodBeat.o(166157);
      return true;
    }
    AppMethodBeat.o(166157);
    return false;
  }
  
  public final int hashCode()
  {
    AppMethodBeat.i(166156);
    int j = this.friendFollowCount;
    int k = this.fansCount;
    LinkedList localLinkedList = this.userTags;
    if (localLinkedList != null) {}
    for (int i = localLinkedList.hashCode();; i = 0)
    {
      AppMethodBeat.o(166156);
      return i + (j * 31 + k) * 31;
    }
  }
  
  public final String toString()
  {
    AppMethodBeat.i(166155);
    String str = "UserExtInfo(friendFollowCount=" + this.friendFollowCount + ", fansCount=" + this.fansCount + ", userTags=" + this.userTags + ")";
    AppMethodBeat.o(166155);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.feed.ui.FinderProfileUI.b
 * JD-Core Version:    0.7.0.1
 */