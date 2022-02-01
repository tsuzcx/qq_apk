package androidx.compose.runtime.e;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.a;

@Metadata(d1={""}, d2={"Landroidx/compose/runtime/saveable/SaveableStateRegistry;", "", "canBeSaved", "", "value", "consumeRestored", "key", "", "performSave", "", "", "registerProvider", "Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "valueProvider", "Lkotlin/Function0;", "Entry", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface f
{
  public abstract a a(String paramString, a<? extends Object> parama);
  
  public abstract boolean ah(Object paramObject);
  
  public abstract Object aj(String paramString);
  
  public abstract Map<String, List<Object>> rc();
  
  @Metadata(d1={""}, d2={"Landroidx/compose/runtime/saveable/SaveableStateRegistry$Entry;", "", "unregister", "", "runtime-saveable_release"}, k=1, mv={1, 5, 1}, xi=48)
  public static abstract interface a
  {
    public abstract void unregister();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.runtime.e.f
 * JD-Core Version:    0.7.0.1
 */