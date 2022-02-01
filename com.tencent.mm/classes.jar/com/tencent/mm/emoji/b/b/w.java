package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.dkv;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "designer", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "getDesigner", "()Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "setDesigner", "(Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class w
  extends ae
{
  public final EmojiGroupInfo jGw;
  public dkv jJM;
  public boolean jJN;
  
  public w(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(2);
    AppMethodBeat.i(105562);
    this.jGw = paramEmojiGroupInfo;
    AppMethodBeat.o(105562);
  }
  
  public final boolean ba(Object paramObject)
  {
    Object localObject3 = null;
    AppMethodBeat.i(183956);
    if ((super.ba(paramObject)) && ((paramObject instanceof w)))
    {
      Object localObject1 = ((w)paramObject).jJM;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((dkv)localObject1).TdG);
        localObject2 = this.jJM;
        if (localObject2 == null) {
          break label178;
        }
        localObject2 = Integer.valueOf(((dkv)localObject2).TdG);
        label60:
        if (!p.h(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((w)paramObject).jJM;
        if (localObject1 == null) {
          break label183;
        }
        localObject1 = ((dkv)localObject1).CMP;
        label85:
        localObject2 = this.jJM;
        if (localObject2 == null) {
          break label188;
        }
        localObject2 = ((dkv)localObject2).CMP;
        label99:
        if (!p.h(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((w)paramObject).jJM;
        if (localObject1 == null) {
          break label193;
        }
      }
      label178:
      label183:
      label188:
      label193:
      for (localObject1 = ((dkv)localObject1).SuR;; localObject1 = null)
      {
        dkv localdkv = this.jJM;
        localObject2 = localObject3;
        if (localdkv != null) {
          localObject2 = localdkv.SuR;
        }
        if ((!p.h(localObject1, localObject2)) || (((w)paramObject).jJN != this.jJN)) {
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
    if ((super.equals(paramObject)) && ((paramObject instanceof w)) && (p.h(((w)paramObject).jGw.hBl(), this.jGw.hBl())))
    {
      AppMethodBeat.o(105561);
      return true;
    }
    AppMethodBeat.o(105561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.w
 * JD-Core Version:    0.7.0.1
 */