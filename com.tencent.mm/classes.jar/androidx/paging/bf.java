package androidx.paging;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/RemoteMediatorConnection;", "Key", "", "Value", "requestLoad", "", "loadType", "Landroidx/paging/LoadType;", "pagingState", "Landroidx/paging/PagingState;", "retryFailed", "paging-common"}, k=1, mv={1, 4, 2})
public abstract interface bf<Key, Value>
{
  public abstract void a(ad paramad, ba<Key, Value> paramba);
  
  public abstract void b(ba<Key, Value> paramba);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.bf
 * JD-Core Version:    0.7.0.1
 */