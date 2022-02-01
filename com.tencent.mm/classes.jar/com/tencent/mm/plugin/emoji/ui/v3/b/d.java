package com.tencent.mm.plugin.emoji.ui.v3.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/report/SingleProductExpose12875Data;", "", "setId", "", "setName", "", "entrance_scene", "", "scene", "md5String", "Ljava/lang/StringBuilder;", "indexString", "(JLjava/lang/String;IILjava/lang/StringBuilder;Ljava/lang/StringBuilder;)V", "getEntrance_scene", "()I", "setEntrance_scene", "(I)V", "getIndexString", "()Ljava/lang/StringBuilder;", "getMd5String", "getScene", "setScene", "getSetId", "()J", "setSetId", "(J)V", "getSetName", "()Ljava/lang/String;", "setSetName", "(Ljava/lang/String;)V", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class d
{
  private int scene;
  private int yaT;
  public long yda;
  public String ydb;
  public final StringBuilder ydc;
  public final StringBuilder ydd;
  
  public d()
  {
    this(0L, null, 0, 0, null, null, 63);
  }
  
  private d(long paramLong, String paramString, int paramInt1, int paramInt2, StringBuilder paramStringBuilder1, StringBuilder paramStringBuilder2)
  {
    AppMethodBeat.i(270597);
    this.yda = paramLong;
    this.ydb = paramString;
    this.yaT = paramInt1;
    this.scene = paramInt2;
    this.ydc = paramStringBuilder1;
    this.ydd = paramStringBuilder2;
    AppMethodBeat.o(270597);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.b.d
 * JD-Core Version:    0.7.0.1
 */