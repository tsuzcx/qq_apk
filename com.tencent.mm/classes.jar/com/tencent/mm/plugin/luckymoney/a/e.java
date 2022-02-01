package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ai.k.b;
import com.tencent.mm.g.c.bi;

public final class e
{
  public static void a(StringBuilder paramStringBuilder, bi parambi, int paramInt)
  {
    AppMethodBeat.i(130931);
    if (parambi == null)
    {
      AppMethodBeat.o(130931);
      return;
    }
    paramStringBuilder.append("<emoji>");
    paramStringBuilder.append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
    paramStringBuilder.append("<md5>").append(k.b.ys(parambi.field_md5)).append("</md5>");
    paramStringBuilder.append("<type>").append(parambi.field_type).append("</type>");
    paramStringBuilder.append("<width>").append(parambi.field_width).append("</width>");
    paramStringBuilder.append("<height>").append(parambi.field_height).append("</height>");
    paramStringBuilder.append("<len>").append(parambi.field_size).append("</len>");
    paramStringBuilder.append("<aeskey>").append(k.b.ys(parambi.field_aeskey)).append("</aeskey>");
    paramStringBuilder.append("<cdnurl>").append(k.b.ys(parambi.field_cdnUrl)).append("</cdnurl>");
    paramStringBuilder.append("<encrypturl>").append(k.b.ys(parambi.field_encrypturl)).append("</encrypturl>");
    paramStringBuilder.append("<externurl>").append(k.b.ys(parambi.field_externUrl)).append("</externurl>");
    paramStringBuilder.append("<externmd5>").append(k.b.ys(parambi.field_externMd5)).append("</externmd5>");
    paramStringBuilder.append("<productid>").append(k.b.ys(parambi.field_groupId)).append("</productid>");
    paramStringBuilder.append("<designerid>").append(k.b.ys(parambi.field_designerID)).append("</designerid>");
    paramStringBuilder.append("<attachedtext>").append(k.b.ys(parambi.field_attachedText)).append("</attachedtext>");
    paramStringBuilder.append("</emoji>");
    AppMethodBeat.o(130931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.e
 * JD-Core Version:    0.7.0.1
 */