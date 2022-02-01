package com.tencent.mm.message.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.d;
import com.tencent.mm.message.f;
import com.tencent.mm.message.k.b;
import com.tencent.mm.sdk.platformtools.Util;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/message/piece/AppContentSecretMsgPiece;", "Lcom/tencent/mm/message/AppContentPiece;", "()V", "isSecretMsg", "", "()Z", "setSecretMsg", "(Z)V", "cloneContent", "makeContent", "", "sb", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "content", "Lcom/tencent/mm/message/AppMessage$Content;", "cdnAttachId", "", "cdnResult", "Lcom/tencent/mm/cdn/keep_SceneResult;", "thumbWidth", "", "thumbHeight", "parseContent", "values", "", "Companion", "plugin-comm_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
  extends f
{
  public static final a.a nVA;
  public boolean nVB;
  
  static
  {
    AppMethodBeat.i(233943);
    nVA = new a.a((byte)0);
    AppMethodBeat.o(233943);
  }
  
  public final void a(StringBuilder paramStringBuilder, k.b paramb, String paramString, d paramd, int paramInt1, int paramInt2)
  {
    AppMethodBeat.i(233950);
    if (paramStringBuilder != null)
    {
      paramStringBuilder = paramStringBuilder.append("<secretmsg>");
      if (paramStringBuilder != null)
      {
        paramStringBuilder = paramStringBuilder.append("<issecretmsg>");
        if (paramStringBuilder != null) {
          if (!this.nVB) {
            break label76;
          }
        }
      }
    }
    label76:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramStringBuilder = paramStringBuilder.append(paramInt1);
      if (paramStringBuilder != null)
      {
        paramStringBuilder = paramStringBuilder.append("</issecretmsg>");
        if (paramStringBuilder != null) {
          paramStringBuilder.append("</secretmsg>");
        }
      }
      AppMethodBeat.o(233950);
      return;
    }
  }
  
  public final void a(Map<String, String> paramMap, k.b paramb)
  {
    AppMethodBeat.i(233955);
    if (paramMap == null)
    {
      paramMap = null;
      if (Util.getInt(paramMap, 0) != 1) {
        break label48;
      }
    }
    label48:
    for (boolean bool = true;; bool = false)
    {
      this.nVB = bool;
      AppMethodBeat.o(233955);
      return;
      paramMap = (String)paramMap.get(".msg.appmsg.secretmsg.issecretmsg");
      break;
    }
  }
  
  public final f biW()
  {
    AppMethodBeat.i(233947);
    Object localObject = new a();
    ((a)localObject).nVB = this.nVB;
    localObject = (f)localObject;
    AppMethodBeat.o(233947);
    return localObject;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.message.a.a
 * JD-Core Version:    0.7.0.1
 */