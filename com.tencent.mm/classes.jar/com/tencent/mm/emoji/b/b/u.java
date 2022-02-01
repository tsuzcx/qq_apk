package com.tencent.mm.emoji.b.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.protocal.protobuf.PersonalDesigner;
import com.tencent.mm.storage.emotion.EmojiGroupInfo;
import kotlin.g.b.p;
import kotlin.l;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/emoji/model/panel/GroupTitleItem;", "Lcom/tencent/mm/emoji/model/panel/PanelItem;", "groupInfo", "Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "(Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;)V", "designer", "Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "getDesigner", "()Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;", "setDesigner", "(Lcom/tencent/mm/protocal/protobuf/PersonalDesigner;)V", "getGroupInfo", "()Lcom/tencent/mm/storage/emotion/EmojiGroupInfo;", "hasNew", "", "getHasNew", "()Z", "setHasNew", "(Z)V", "contentEquals", "other", "", "equals", "plugin-emojisdk_release"})
public final class u
  extends ac
{
  public final EmojiGroupInfo gVA;
  public PersonalDesigner gYM;
  public boolean gYN;
  
  public u(EmojiGroupInfo paramEmojiGroupInfo)
  {
    super(2);
    AppMethodBeat.i(105562);
    this.gVA = paramEmojiGroupInfo;
    AppMethodBeat.o(105562);
  }
  
  public final boolean aZ(Object paramObject)
  {
    Object localObject3 = null;
    AppMethodBeat.i(183956);
    if ((super.aZ(paramObject)) && ((paramObject instanceof u)))
    {
      Object localObject1 = ((u)paramObject).gYM;
      Object localObject2;
      if (localObject1 != null)
      {
        localObject1 = Integer.valueOf(((PersonalDesigner)localObject1).DesignerUin);
        localObject2 = this.gYM;
        if (localObject2 == null) {
          break label178;
        }
        localObject2 = Integer.valueOf(((PersonalDesigner)localObject2).DesignerUin);
        label60:
        if (!p.j(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((u)paramObject).gYM;
        if (localObject1 == null) {
          break label183;
        }
        localObject1 = ((PersonalDesigner)localObject1).Name;
        label85:
        localObject2 = this.gYM;
        if (localObject2 == null) {
          break label188;
        }
        localObject2 = ((PersonalDesigner)localObject2).Name;
        label99:
        if (!p.j(localObject1, localObject2)) {
          break label198;
        }
        localObject1 = ((u)paramObject).gYM;
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
        PersonalDesigner localPersonalDesigner = this.gYM;
        localObject2 = localObject3;
        if (localPersonalDesigner != null) {
          localObject2 = localPersonalDesigner.HeadUrl;
        }
        if ((!p.j(localObject1, localObject2)) || (((u)paramObject).gYN != this.gYN)) {
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
    if ((super.equals(paramObject)) && ((paramObject instanceof u)) && (p.j(((u)paramObject).gVA.hRu(), this.gVA.hRu())))
    {
      AppMethodBeat.o(105561);
      return true;
    }
    AppMethodBeat.o(105561);
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.emoji.b.b.u
 * JD-Core Version:    0.7.0.1
 */