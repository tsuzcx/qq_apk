package com.tencent.mm.app;

import androidx.lifecycle.q;
import kotlin.Metadata;
import kotlin.g.a.a;
import kotlin.g.b.u;
import kotlin.k;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/app/ApplicationModelOwner;", "Landroidx/lifecycle/LifecycleOwner;", "()V", "lifecycle", "Lcom/tencent/mm/app/ApplicationLifecycleRegistry;", "getLifecycle$wechat_internal_support_release", "()Lcom/tencent/mm/app/ApplicationLifecycleRegistry;", "lifecycle$delegate", "Lkotlin/Lazy;", "getLifecycle", "Landroidx/lifecycle/Lifecycle;", "wechat-internal-support_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class f
  implements q
{
  public static final f hfK = new f();
  private static final kotlin.j hfL = k.cm((a)a.hfM);
  
  public final androidx.lifecycle.j getLifecycle()
  {
    return (androidx.lifecycle.j)hfL.getValue();
  }
  
  @Metadata(d1={""}, d2={"<anonymous>", "Lcom/tencent/mm/app/ApplicationLifecycleRegistry;"}, k=3, mv={1, 5, 1}, xi=48)
  static final class a
    extends u
    implements a<d>
  {
    public static final a hfM = new a();
    
    a()
    {
      super();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.app.f
 * JD-Core Version:    0.7.0.1
 */