package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ah.k.b;
import com.tencent.mm.g.c.bh;

public final class e
{
  public static void a(StringBuilder paramStringBuilder, bh parambh, int paramInt)
  {
    AppMethodBeat.i(130931);
    if (parambh == null)
    {
      AppMethodBeat.o(130931);
      return;
    }
    paramStringBuilder.append("<emoji>");
    paramStringBuilder.append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
    paramStringBuilder.append("<md5>").append(k.b.vB(parambh.field_md5)).append("</md5>");
    paramStringBuilder.append("<type>").append(parambh.field_type).append("</type>");
    paramStringBuilder.append("<width>").append(parambh.field_width).append("</width>");
    paramStringBuilder.append("<height>").append(parambh.field_height).append("</height>");
    paramStringBuilder.append("<len>").append(parambh.field_size).append("</len>");
    paramStringBuilder.append("<aeskey>").append(k.b.vB(parambh.field_aeskey)).append("</aeskey>");
    paramStringBuilder.append("<cdnurl>").append(k.b.vB(parambh.field_cdnUrl)).append("</cdnurl>");
    paramStringBuilder.append("<encrypturl>").append(k.b.vB(parambh.field_encrypturl)).append("</encrypturl>");
    paramStringBuilder.append("<externurl>").append(k.b.vB(parambh.field_externUrl)).append("</externurl>");
    paramStringBuilder.append("<externmd5>").append(k.b.vB(parambh.field_externMd5)).append("</externmd5>");
    paramStringBuilder.append("<productid>").append(k.b.vB(parambh.field_groupId)).append("</productid>");
    paramStringBuilder.append("<designerid>").append(k.b.vB(parambh.field_designerID)).append("</designerid>");
    paramStringBuilder.append("<attachedtext>").append(k.b.vB(parambh.field_attachedText)).append("</attachedtext>");
    paramStringBuilder.append("</emoji>");
    AppMethodBeat.o(130931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.e
 * JD-Core Version:    0.7.0.1
 */