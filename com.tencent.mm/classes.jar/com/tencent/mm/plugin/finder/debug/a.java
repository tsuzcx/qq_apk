package com.tencent.mm.plugin.finder.debug;

import com.tencent.matrix.trace.core.AppMethodBeat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import kotlin.Metadata;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/debug/FinderStreamInfoHolder;", "", "()V", "calendar", "Ljava/util/Calendar;", "kotlin.jvm.PlatformType", "infoList", "", "", "getInfoList", "()Ljava/util/List;", "addInfo", "", "info", "getTimeString", "plugin-finder_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class a
{
  public static final a ANe;
  public static final List<String> aYV;
  private static final Calendar lxD;
  
  static
  {
    AppMethodBeat.i(329903);
    ANe = new a();
    lxD = Calendar.getInstance();
    aYV = (List)new ArrayList();
    AppMethodBeat.o(329903);
  }
  
  public static List<String> dYg()
  {
    return aYV;
  }
  
  public static String dYh()
  {
    AppMethodBeat.i(329897);
    int i = lxD.get(2);
    int j = lxD.get(5);
    int k = lxD.get(11);
    int m = lxD.get(12);
    int n = lxD.get(13);
    String str = i + 1 + '-' + j + ' ' + k + ':' + m + ':' + n;
    AppMethodBeat.o(329897);
    return str;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes13.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.debug.a
 * JD-Core Version:    0.7.0.1
 */