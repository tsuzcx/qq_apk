package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ag.k.b;
import com.tencent.mm.g.c.bj;

public final class e
{
  public static void a(StringBuilder paramStringBuilder, bj parambj, int paramInt)
  {
    AppMethodBeat.i(130931);
    if (parambj == null)
    {
      AppMethodBeat.o(130931);
      return;
    }
    paramStringBuilder.append("<emoji>");
    paramStringBuilder.append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
    paramStringBuilder.append("<md5>").append(k.b.HE(parambj.field_md5)).append("</md5>");
    paramStringBuilder.append("<type>").append(parambj.field_type).append("</type>");
    paramStringBuilder.append("<width>").append(parambj.field_width).append("</width>");
    paramStringBuilder.append("<height>").append(parambj.field_height).append("</height>");
    paramStringBuilder.append("<len>").append(parambj.field_size).append("</len>");
    paramStringBuilder.append("<aeskey>").append(k.b.HE(parambj.field_aeskey)).append("</aeskey>");
    paramStringBuilder.append("<cdnurl>").append(k.b.HE(parambj.field_cdnUrl)).append("</cdnurl>");
    paramStringBuilder.append("<encrypturl>").append(k.b.HE(parambj.field_encrypturl)).append("</encrypturl>");
    paramStringBuilder.append("<externurl>").append(k.b.HE(parambj.field_externUrl)).append("</externurl>");
    paramStringBuilder.append("<externmd5>").append(k.b.HE(parambj.field_externMd5)).append("</externmd5>");
    paramStringBuilder.append("<productid>").append(k.b.HE(parambj.field_groupId)).append("</productid>");
    paramStringBuilder.append("<designerid>").append(k.b.HE(parambj.field_designerID)).append("</designerid>");
    paramStringBuilder.append("<attachedtext>").append(k.b.HE(parambj.field_attachedText)).append("</attachedtext>");
    paramStringBuilder.append("</emoji>");
    AppMethodBeat.o(130931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.e
 * JD-Core Version:    0.7.0.1
 */