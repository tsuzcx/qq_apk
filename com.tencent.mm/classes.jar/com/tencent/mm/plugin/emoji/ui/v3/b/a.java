package com.tencent.mm.plugin.emoji.ui.v3.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.autogen.mmdata.rpt.bc;
import com.tencent.mm.protocal.protobuf.amn;
import com.tencent.mm.storage.emotion.EmojiInfo;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/report/EmojiStoreReportTool;", "", "()V", "enterEmojiStoreTimeStamp", "", "getEnterEmojiStoreTimeStamp", "()J", "setEnterEmojiStoreTimeStamp", "(J)V", "getEmojiStoreReportEnterScene", "", "id", "reportSingleProductAction12787", "", "emojiInfo", "Lcom/tencent/mm/protocal/protobuf/EmojiInfo;", "actionValue", "sceneValue", "searchId", "entranceScene", "Lcom/tencent/mm/storage/emotion/EmojiInfo;", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ycU;
  private static long ycV;
  
  static
  {
    AppMethodBeat.i(270627);
    ycU = new a();
    ycV = -1L;
    AppMethodBeat.o(270627);
  }
  
  public static final int KJ(int paramInt)
  {
    return paramInt + 10000;
  }
  
  public static final void a(amn paramamn, int paramInt)
  {
    AppMethodBeat.i(270618);
    if (paramamn == null)
    {
      AppMethodBeat.o(270618);
      return;
    }
    bc localbc = new bc();
    localbc.iqr = 3L;
    localbc.ikE = 0L;
    localbc.kR(paramamn.Md5.toString());
    localbc.kS("0");
    localbc.kT(paramamn.DesignerID);
    localbc.kU(paramamn.ProductID);
    localbc.iqC = paramInt;
    localbc.kV(String.valueOf(ycV));
    localbc.bMH();
    AppMethodBeat.o(270618);
  }
  
  public static final void a(EmojiInfo paramEmojiInfo, int paramInt1, int paramInt2, long paramLong, int paramInt3)
  {
    AppMethodBeat.i(270612);
    if (paramEmojiInfo == null)
    {
      AppMethodBeat.o(270612);
      return;
    }
    bc localbc = new bc();
    localbc.iqr = paramInt2;
    localbc.ikE = paramInt1;
    localbc.kR(paramEmojiInfo.field_md5.toString());
    localbc.kS(String.valueOf(paramLong));
    localbc.kT(paramEmojiInfo.field_designerID);
    localbc.kU(paramEmojiInfo.field_groupId);
    localbc.iqC = paramInt3;
    localbc.kV(String.valueOf(ycV));
    localbc.bMH();
    AppMethodBeat.o(270612);
  }
  
  public static long dDm()
  {
    return ycV;
  }
  
  public static void lq(long paramLong)
  {
    ycV = paramLong;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.b.a
 * JD-Core Version:    0.7.0.1
 */