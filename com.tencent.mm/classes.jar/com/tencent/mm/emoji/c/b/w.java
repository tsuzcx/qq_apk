package com.tencent.mm.emoji.c.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.gok;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "designer", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "getDesigner", "()Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "setDesigner", "(Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class w
  extends ae
{
  public final EmojiGroupInfo mgd;
  public gok mje;
  public boolean mjf;
  
  public w(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(2);
    AppMethodBeat.i(105562);
    this.mgd = paramEmojiGroupInfo;
    AppMethodBeat.o(105562);
  }
  
  public final boolean cv(Object paramObject)
  {
    Object localObject3 = null;
    AppMethodBeat.i(183956);
    if ((super.cv(paramObject)) && ((paramObject instanceof w)))
    {
      Object localObject1 = ((w)paramObject).mje;
      if (localObject1 == null)
      {
        localObject1 = null;
        localObject2 = this.mje;
        if (localObject2 != null) {
          break label155;
        }
        localObject2 = null;
        label48:
        if (!s.p(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((w)paramObject).mje;
        if (localObject1 != null) {
          break label166;
        }
        localObject1 = null;
        label70:
        localObject2 = this.mje;
        if (localObject2 != null) {
          break label174;
        }
        localObject2 = null;
        label81:
        if (!s.p(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((w)paramObject).mje;
        if (localObject1 != null) {
          break label182;
        }
        localObject1 = null;
        label103:
        localObject2 = this.mje;
        if (localObject2 != null) {
          break label190;
        }
      }
      label155:
      label166:
      label174:
      label182:
      label190:
      for (Object localObject2 = localObject3;; localObject2 = ((gok)localObject2).ZuK)
      {
        if ((!s.p(localObject1, localObject2)) || (((w)paramObject).mjf != this.mjf)) {
          break label198;
        }
        AppMethodBeat.o(183956);
        return true;
        localObject1 = Integer.valueOf(((gok)localObject1).ZtX);
        break;
        localObject2 = Integer.valueOf(((gok)localObject2).ZtX);
        break label48;
        localObject1 = ((gok)localObject1).IGU;
        break label70;
        localObject2 = ((gok)localObject2).IGU;
        break label81;
        localObject1 = ((gok)localObject1).ZuK;
        break label103;
      }
    }
    label198:
    AppMethodBeat.o(183956);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105561);
    if ((super.equals(paramObject)) && ((paramObject instanceof w)) && (s.p(((w)paramObject).mgd.field_productID, this.mgd.field_productID)))
    {
      AppMethodBeat.o(105561);
      return true;
    }
    AppMethodBeat.o(105561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.emoji.c.b.w
 * JD-Core Version:    0.7.0.1
 */