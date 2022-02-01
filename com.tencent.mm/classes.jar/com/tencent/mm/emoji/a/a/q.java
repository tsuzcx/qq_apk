package com.tencent.mm.emoji.a.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import d.g.b.k;
import d.l;

@l(fvt={1, 1, 16}, fvu={""}, fvv={"Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "designer", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "getDesigner", "()Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "setDesigner", "(Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class q
  extends y
{
  public final EmojiGroupInfo fLb;
  public PersonalDesigner fOh;
  public boolean fOi;
  
  public q(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(2);
    AppMethodBeat.i(105562);
    this.fLb = paramEmojiGroupInfo;
    AppMethodBeat.o(105562);
  }
  
  public final boolean aT(Object paramObject)
  {
    Object localObject3 = null;
    AppMethodBeat.i(183956);
    if ((super.aT(paramObject)) && ((paramObject instanceof q)))
    {
      Object localObject1 = ((q)paramObject).fOh;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((PersonalDesigner)localObject1).DesignerUin);
        localObject2 = this.fOh;
        if (localObject2 == null) {
          break label178;
        }
        localObject2 = Integer.valueOf(((PersonalDesigner)localObject2).DesignerUin);
        label60:
        if (!k.g(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((q)paramObject).fOh;
        if (localObject1 == null) {
          break label183;
        }
        localObject1 = ((PersonalDesigner)localObject1).Name;
        label85:
        localObject2 = this.fOh;
        if (localObject2 == null) {
          break label188;
        }
        localObject2 = ((PersonalDesigner)localObject2).Name;
        label99:
        if (!k.g(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((q)paramObject).fOh;
        if (localObject1 == null) {
          break label193;
        }
      }
      label178:
      label183:
      label188:
      label193:
      for (localObject1 = ((PersonalDesigner)localObject1).HeadUrl;; localObject1 = null)
      {
        PersonalDesigner localPersonalDesigner = this.fOh;
        localObject2 = localObject3;
        if (localPersonalDesigner != null) {
          localObject2 = localPersonalDesigner.HeadUrl;
        }
        if ((!k.g(localObject1, localObject2)) || (((q)paramObject).fOi != this.fOi)) {
          break label198;
        }
        AppMethodBeat.o(183956);
        return true;
        localObject1 = null;
        break;
        localObject2 = null;
        break label60;
        localObject1 = null;
        break label85;
        localObject2 = null;
        break label99;
      }
    }
    label198:
    AppMethodBeat.o(183956);
    return false;
  }
  
  public final boolean equals(Object paramObject)
  {
    AppMethodBeat.i(105561);
    if ((super.equals(paramObject)) && ((paramObject instanceof q)) && (k.g(((q)paramObject).fLb.fZJ(), this.fLb.fZJ())))
    {
      AppMethodBeat.o(105561);
      return true;
    }
    AppMethodBeat.o(105561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.a.a.q
 * JD-Core Version:    0.7.0.1
 */