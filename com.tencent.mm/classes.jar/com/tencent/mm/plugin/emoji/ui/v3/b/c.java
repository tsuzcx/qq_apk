package com.tencent.mm.plugin.emoji.ui.v3.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.Map;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/emoji/ui/v3/report/EmotionListExpose18662Data;", "", "emotionPidListStingMap", "", "", "Ljava/lang/StringBuilder;", "emotionInfoListStingMap", "emotionIndexListStingMap", "(Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", "getEmotionIndexListStingMap", "()Ljava/util/Map;", "getEmotionInfoListStingMap", "getEmotionPidListStingMap", "plugin-emoji_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class c
{
  public final Map<Integer, StringBuilder> ycX;
  public final Map<Integer, StringBuilder> ycY;
  public final Map<Integer, StringBuilder> ycZ;
  
  public c(Map<Integer, StringBuilder> paramMap1, Map<Integer, StringBuilder> paramMap2, Map<Integer, StringBuilder> paramMap3)
  {
    AppMethodBeat.i(270587);
    this.ycX = paramMap1;
    this.ycY = paramMap2;
    this.ycZ = paramMap3;
    AppMethodBeat.o(270587);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v3.b.c
 * JD-Core Version:    0.7.0.1
 */