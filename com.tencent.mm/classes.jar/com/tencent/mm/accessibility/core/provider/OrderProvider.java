package com.tencent.mm.accessibility.core.provider;

import android.os.Build.VERSION;
import android.view.View;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.IdUtil;
import java.util.Map;
import kotlin.Metadata;
import kotlin.g.a.b;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/OrderProvider;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "dealOnViewInflateAsync", "", "view", "Landroid/view/View;", "getAuthority", "", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class OrderProvider
  extends Provider
{
  public static final OrderProvider INSTANCE;
  public static final String TAG = "MicroMsg.Acc.OrderProvider";
  
  static
  {
    AppMethodBeat.i(234208);
    INSTANCE = new OrderProvider();
    AppMethodBeat.o(234208);
  }
  
  public final void dealOnViewInflateAsync(View paramView)
  {
    AppMethodBeat.i(234222);
    s.u(paramView, "view");
    if (Build.VERSION.SDK_INT >= 22) {
      getConfig(paramView, (b)new u(paramView)
      {
        public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
        {
          AppMethodBeat.i(234183);
          s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
          Object localObject = (int[])paramAnonymousMMBaseAccessibilityConfig.getGlobalTraversalMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
          if (localObject != null)
          {
            View localView = this.$view;
            localView.setAccessibilityTraversalBefore(localObject[0]);
            localView.setAccessibilityTraversalAfter(localObject[1]);
            OrderProvider.INSTANCE.logMsg("MicroMsg.Acc.OrderProvider", localView, "success set globalTraversal, before:" + IdUtil.INSTANCE.getName(localObject[0]) + " after:" + IdUtil.INSTANCE.getName(localObject[1]));
          }
          for (boolean bool1 = true;; bool1 = false)
          {
            paramAnonymousMMBaseAccessibilityConfig = (Map)paramAnonymousMMBaseAccessibilityConfig.getLocalTraversalMap$plugin_autoaccessibility_release().get(OrderProvider.INSTANCE.getLayoutId(this.$view));
            boolean bool2 = bool1;
            if (paramAnonymousMMBaseAccessibilityConfig != null)
            {
              paramAnonymousMMBaseAccessibilityConfig = (int[])paramAnonymousMMBaseAccessibilityConfig.get(Integer.valueOf(this.$view.getId()));
              bool2 = bool1;
              if (paramAnonymousMMBaseAccessibilityConfig != null)
              {
                localObject = this.$view;
                ((View)localObject).setAccessibilityTraversalBefore(paramAnonymousMMBaseAccessibilityConfig[0]);
                ((View)localObject).setAccessibilityTraversalAfter(paramAnonymousMMBaseAccessibilityConfig[1]);
                OrderProvider.INSTANCE.logMsg("MicroMsg.Acc.OrderProvider", (View)localObject, "success set localTraversal, before:" + IdUtil.INSTANCE.getName(paramAnonymousMMBaseAccessibilityConfig[0]) + " after:" + IdUtil.INSTANCE.getName(paramAnonymousMMBaseAccessibilityConfig[1]));
                bool2 = true;
              }
            }
            AppMethodBeat.o(234183);
            return Boolean.valueOf(bool2);
          }
        }
      });
    }
    AppMethodBeat.o(234222);
  }
  
  public final int getAuthority()
  {
    return 2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.OrderProvider
 * JD-Core Version:    0.7.0.1
 */