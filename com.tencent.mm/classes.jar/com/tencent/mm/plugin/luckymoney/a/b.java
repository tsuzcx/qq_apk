package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.af.j.b;
import com.tencent.mm.g.c.bb;

public final class b
{
  public static void a(StringBuilder paramStringBuilder, bb parambb, int paramInt)
  {
    AppMethodBeat.i(146040);
    if (parambb == null)
    {
      AppMethodBeat.o(146040);
      return;
    }
    paramStringBuilder.append("<emoji>");
    paramStringBuilder.append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
    paramStringBuilder.append("<md5>").append(j.b.mZ(parambb.field_md5)).append("</md5>");
    paramStringBuilder.append("<type>").append(parambb.field_type).append("</type>");
    paramStringBuilder.append("<width>").append(parambb.field_width).append("</width>");
    paramStringBuilder.append("<height>").append(parambb.field_height).append("</height>");
    paramStringBuilder.append("<len>").append(parambb.field_size).append("</len>");
    paramStringBuilder.append("<aeskey>").append(j.b.mZ(parambb.field_aeskey)).append("</aeskey>");
    paramStringBuilder.append("<cdnurl>").append(j.b.mZ(parambb.field_cdnUrl)).append("</cdnurl>");
    paramStringBuilder.append("<encrypturl>").append(j.b.mZ(parambb.field_encrypturl)).append("</encrypturl>");
    paramStringBuilder.append("<externurl>").append(j.b.mZ(parambb.field_externUrl)).append("</externurl>");
    paramStringBuilder.append("<externmd5>").append(j.b.mZ(parambb.field_externMd5)).append("</externmd5>");
    paramStringBuilder.append("<productid>").append(j.b.mZ(parambb.field_groupId)).append("</productid>");
    paramStringBuilder.append("<designerid>").append(j.b.mZ(parambb.field_designerID)).append("</designerid>");
    paramStringBuilder.append("<attachedtext>").append(j.b.mZ(parambb.field_attachedText)).append("</attachedtext>");
    paramStringBuilder.append("</emoji>");
    AppMethodBeat.o(146040);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.b
 * JD-Core Version:    0.7.0.1
 */