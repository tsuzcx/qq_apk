package androidx.paging;

import com.tencent.matrix.trace.core.AppMethodBeat;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ActiveFlowTracker;", "", "onComplete", "", "flowType", "Landroidx/paging/ActiveFlowTracker$FlowType;", "(Landroidx/paging/ActiveFlowTracker$FlowType;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onStart", "FlowType", "paging-common"}, k=1, mv={1, 4, 2})
public abstract interface d
{
  public abstract Object HD();
  
  public abstract Object HE();
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Landroidx/paging/ActiveFlowTracker$FlowType;", "", "(Ljava/lang/String;I)V", "PAGED_DATA_FLOW", "PAGE_EVENT_FLOW", "paging-common"}, k=1, mv={1, 4, 2})
  public static enum a
  {
    static
    {
      AppMethodBeat.i(196872);
      a locala1 = new a("PAGED_DATA_FLOW", 0);
      bKI = locala1;
      a locala2 = new a("PAGE_EVENT_FLOW", 1);
      bKJ = locala2;
      bKK = new a[] { locala1, locala2 };
      AppMethodBeat.o(196872);
    }
    
    private a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     androidx.paging.d
 * JD-Core Version:    0.7.0.1
 */