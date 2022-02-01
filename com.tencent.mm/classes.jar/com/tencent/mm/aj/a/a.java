package com.tencent.mm.aj.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.aj.f;
import com.tencent.mm.aj.k.b;
import com.tencent.mm.i.d;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.l;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/message/piece/AppContentSecretMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "isSecretMsg", "", "()Z", "setSecretMsg", "(Z)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "Companion", "plugin-comm_release"})
public final class a
  extends f
{
  public static final a lqA;
  public boolean lqz;
  
  static
  {
    AppMethodBeat.i(217249);
    lqA = new a((byte)0);
    AppMethodBeat.o(217249);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(217246);
    if (paramStringBuilder != null)
    {
      paramStringBuilder = paramStringBuilder.append("<secretmsg>");
      if (paramStringBuilder != null)
      {
        paramStringBuilder = paramStringBuilder.append("<issecretmsg>");
        if (paramStringBuilder != null)
        {
          if (this.lqz) {}
          for (paramInt1 = 1;; paramInt1 = 0)
          {
            paramStringBuilder = paramStringBuilder.append(paramInt1);
            if (paramStringBuilder == null) {
              break;
            }
            paramStringBuilder = paramStringBuilder.append("</issecretmsg>");
            if (paramStringBuilder == null) {
              break;
            }
            paramStringBuilder.append("</secretmsg>");
            AppMethodBeat.o(217246);
            return;
          }
        }
      }
    }
    AppMethodBeat.o(217246);
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(217248);
    if (paramMap != null)
    {
      paramMap = (String)paramMap.get(".msg.appmsg.secretmsg.issecretmsg");
      if (Util.getInt(paramMap, 0) != 1) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      this.lqz = bool;
      AppMethodBeat.o(217248);
      return;
      paramMap = null;
      break;
    }
  }
  
  public final f aPj()
  {
    AppMethodBeat.i(217242);
    Object localObject = new a();
    ((a)localObject).lqz = this.lqz;
    localObject = (f)localObject;
    AppMethodBeat.o(217242);
    return localObject;
  }
  
  @l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/message/piece/AppContentSecretMsgPiece$Companion;", "", "()V", "TAG", "", "plugin-comm_release"})
  public static final class a {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.aj.a.a
 * JD-Core Version:    0.7.0.1
 */