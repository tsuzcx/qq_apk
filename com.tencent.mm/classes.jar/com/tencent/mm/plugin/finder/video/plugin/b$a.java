package com.tencent.mm.plugin.finder.video.plugin;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ad.i;
import com.tencent.mm.sdk.platformtools.Log;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/video/plugin/FinderRecordBeautifyPlugin$Companion;", "", "()V", "KEY_BRIGHT_EYE", "", "KEY_BRIGHT_FACE", "KEY_CHEEK_BONE", "KEY_EYE_POUCH", "KEY_LOWER_JAWBONE", "KEY_MORPH_EYE", "KEY_MORPH_FACE", "KEY_ROSY", "KEY_SHARPEN", "KEY_SMALL_HEAD", "KEY_SMILE_FOLDS", "KEY_SMOOTH_FACE", "KEY_TEETH_BRIGHT", "KEY_WING_OF_NOSE", "TAG", "", "defaultJson", "defaultJson2", "defaultJson3", "defaultValueList", "Ljava/util/ArrayList;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Lkotlin/collections/ArrayList;", "selectedValueMap", "extractJsonToMap", "", "json", "map", "defaultVal", "initDefaultValue", "plugin-finder-publish_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b$a
{
  static void b(String paramString, HashMap<Integer, Integer> paramHashMap, int paramInt)
  {
    AppMethodBeat.i(335557);
    try
    {
      Log.i(b.access$getTAG$cp(), s.X("extractJsonToMap: ", paramString));
      paramString = new i(paramString);
      ((Map)paramHashMap).put(Integer.valueOf(0), Integer.valueOf(paramString.optInt("skin_smooth", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(1), Integer.valueOf(paramString.optInt("face_morph", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(4), Integer.valueOf(paramString.optInt("eye_morph", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(2), Integer.valueOf(paramString.optInt("skin_bright", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(5), Integer.valueOf(paramString.optInt("eye_bright", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(3), Integer.valueOf(paramString.optInt("rosy", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(6), Integer.valueOf(paramString.optInt("eye_pouch", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(7), Integer.valueOf(paramString.optInt("smile_folds", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(8), Integer.valueOf(paramString.optInt("sharpen", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(9), Integer.valueOf(paramString.optInt("teeth_bright", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(10), Integer.valueOf(paramString.optInt("small_head", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(11), Integer.valueOf(paramString.optInt("cheek_bone", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(12), Integer.valueOf(paramString.optInt("lower_jawbone", paramInt)));
      ((Map)paramHashMap).put(Integer.valueOf(13), Integer.valueOf(paramString.optInt("wing_of_nose", paramInt)));
      AppMethodBeat.o(335557);
      return;
    }
    catch (Exception paramString)
    {
      Log.printErrStackTrace(b.access$getTAG$cp(), (Throwable)paramString, "json error: ", new Object[0]);
      AppMethodBeat.o(335557);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.video.plugin.b.a
 * JD-Core Version:    0.7.0.1
 */