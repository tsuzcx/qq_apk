package androidx.compose.a;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/EnterTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "enter", "Companion", "Landroidx/compose/animation/EnterTransitionImpl;", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class k
{
  public static final k.a Tk = new k.a((byte)0);
  private static final k Tl = (k)new l(new w(null, null, null, 7));
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof k)) && (s.p(((k)paramObject).lx(), lx()));
  }
  
  public int hashCode()
  {
    return lx().hashCode();
  }
  
  public abstract w lx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.k
 * JD-Core Version:    0.7.0.1
 */