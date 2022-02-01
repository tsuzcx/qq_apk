package com.tencent.mm.plugin.luckymoney.a;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.b.bm;
import com.tencent.mm.message.k.b;

public final class e
{
  public static void a(StringBuilder paramStringBuilder, bm parambm, int paramInt)
  {
    AppMethodBeat.i(130931);
    if (parambm == null)
    {
      AppMethodBeat.o(130931);
      return;
    }
    paramStringBuilder.append("<emoji>");
    paramStringBuilder.append("<localreceivestatus>").append(paramInt).append("</localreceivestatus>");
    paramStringBuilder.append("<md5>").append(k.b.Hg(parambm.field_md5)).append("</md5>");
    paramStringBuilder.append("<type>").append(parambm.field_type).append("</type>");
    paramStringBuilder.append("<width>").append(parambm.field_width).append("</width>");
    paramStringBuilder.append("<height>").append(parambm.field_height).append("</height>");
    paramStringBuilder.append("<len>").append(parambm.field_size).append("</len>");
    paramStringBuilder.append("<aeskey>").append(k.b.Hg(parambm.field_aeskey)).append("</aeskey>");
    paramStringBuilder.append("<cdnurl>").append(k.b.Hg(parambm.field_cdnUrl)).append("</cdnurl>");
    paramStringBuilder.append("<encrypturl>").append(k.b.Hg(parambm.field_encrypturl)).append("</encrypturl>");
    paramStringBuilder.append("<externurl>").append(k.b.Hg(parambm.field_externUrl)).append("</externurl>");
    paramStringBuilder.append("<externmd5>").append(k.b.Hg(parambm.field_externMd5)).append("</externmd5>");
    paramStringBuilder.append("<productid>").append(k.b.Hg(parambm.field_groupId)).append("</productid>");
    paramStringBuilder.append("<designerid>").append(k.b.Hg(parambm.field_designerID)).append("</designerid>");
    paramStringBuilder.append("<attachedtext>").append(k.b.Hg(parambm.field_attachedText)).append("</attachedtext>");
    paramStringBuilder.append("</emoji>");
    AppMethodBeat.o(130931);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.luckymoney.a.e
 * JD-Core Version:    0.7.0.1
 */