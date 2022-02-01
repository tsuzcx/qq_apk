package androidx.compose.a;

import kotlin.Metadata;
import kotlin.g.b.s;

@Metadata(d1={""}, d2={"Landroidx/compose/animation/ExitTransition;", "", "()V", "data", "Landroidx/compose/animation/TransitionData;", "getData$animation_release", "()Landroidx/compose/animation/TransitionData;", "equals", "", "other", "hashCode", "", "plus", "exit", "Companion", "Landroidx/compose/animation/ExitTransitionImpl;", "animation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract class m
{
  public static final m.a Tn = new m.a((byte)0);
  private static final m To = (m)new n(new w(null, null, null, 7));
  
  public boolean equals(Object paramObject)
  {
    return ((paramObject instanceof m)) && (s.p(((m)paramObject).lx(), lx()));
  }
  
  public int hashCode()
  {
    return lx().hashCode();
  }
  
  public abstract w lx();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.a.m
 * JD-Core Version:    0.7.0.1
 */