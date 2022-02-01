package com.tencent.mm.plugin.finder.live.b;

import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.view.recyclerview.g;
import java.util.List;
import kotlin.Metadata;
import kotlin.a.p;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/plugin/finder/live/comment/BoxCommentConfig;", "", "()V", "BoxCommentComplaintType", "", "", "getBoxCommentComplaintType", "()Ljava/util/List;", "BoxCommentType", "getBoxCommentType", "itemConvertFactory", "Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "getItemConvertFactory", "()Lcom/tencent/mm/view/recyclerview/ItemConvertFactory;", "plugin-finder-live_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  private static final g AKf;
  public static final b Zuu;
  private static final List<Integer> Zuv;
  private static final List<Integer> Zux;
  
  static
  {
    AppMethodBeat.i(370947);
    Zuu = new b();
    Zuv = p.listOf(new Integer[] { Integer.valueOf(20057), Integer.valueOf(20034), Integer.valueOf(20032), Integer.valueOf(20035), Integer.valueOf(20002) });
    Zux = p.listOf(new Integer[] { Integer.valueOf(20057), Integer.valueOf(20035) });
    AKf = (g)new b.a();
    AppMethodBeat.o(370947);
  }
  
  public static List<Integer> eFU()
  {
    return Zuv;
  }
  
  public static List<Integer> eGK()
  {
    return Zux;
  }
  
  public static g ech()
  {
    return AKf;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.finder.live.b.b
 * JD-Core Version:    0.7.0.1
 */