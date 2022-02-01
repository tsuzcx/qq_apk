package androidx.compose.foundation.lazy;

import java.util.List;
import kotlin.Metadata;
import kotlin.ah;
import kotlin.g.a.m;

@Metadata(d1={""}, d2={"Landroidx/compose/foundation/lazy/LazyListItemsProvider;", "", "headerIndexes", "", "", "getHeaderIndexes", "()Ljava/util/List;", "itemsCount", "getItemsCount", "()I", "getContent", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "index", "scope", "Landroidx/compose/foundation/lazy/LazyItemScope;", "(ILandroidx/compose/foundation/lazy/LazyItemScope;)Lkotlin/jvm/functions/Function2;", "getKey", "foundation_release"}, k=1, mv={1, 5, 1}, xi=48)
public abstract interface n
{
  public abstract m<androidx.compose.runtime.h, Integer, ah> a(int paramInt, h paramh);
  
  public abstract Object bu(int paramInt);
  
  public abstract int getItemsCount();
  
  public abstract List<Integer> mI();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.compose.foundation.lazy.n
 * JD-Core Version:    0.7.0.1
 */