package com.tencent.mm.accessibility.core.provider;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.accessibility.base.MMBaseAccessibilityConfig;
import com.tencent.mm.accessibility.uitl.IdUtil;
import com.tencent.mm.sdk.platformtools.Log;
import com.tencent.mm.sdk.platformtools.MMApplicationContext;
import com.tencent.neattextview.textview.view.NeatTextView;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.a.k;
import kotlin.a.p;
import kotlin.g.a.b;
import kotlin.g.a.m;
import kotlin.g.b.ah.d;
import kotlin.g.b.ah.f;
import kotlin.g.b.am;
import kotlin.g.b.s;
import kotlin.g.b.u;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/accessibility/core/provider/ContentDescProvider;", "Lcom/tencent/mm/accessibility/core/provider/Provider;", "()V", "TAG", "", "curConfigName", "dealNodeInfo", "", "view", "Landroid/view/View;", "nodeInfo", "Landroid/view/accessibility/AccessibilityNodeInfo;", "findDescList", "", "outRootView", "", "(Landroid/view/View;[Landroid/view/View;)Ljava/lang/Object;", "getAuthority", "", "getContentDesc", "plugin-autoaccessibility_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class ContentDescProvider
  extends Provider
{
  public static final ContentDescProvider INSTANCE;
  public static final String TAG = "MicroMsg.Acc.ContentDescProvider";
  private static String curConfigName;
  
  static
  {
    AppMethodBeat.i(234289);
    INSTANCE = new ContentDescProvider();
    curConfigName = "";
    INSTANCE.addRootIdMapper$plugin_autoaccessibility_release((m)1.INSTANCE);
    AppMethodBeat.o(234289);
  }
  
  public final void dealNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
  {
    AppMethodBeat.i(234297);
    s.u(paramView, "view");
    s.u(paramAccessibilityNodeInfo, "nodeInfo");
    paramView = getContentDesc(paramView);
    if (paramView != null) {
      paramAccessibilityNodeInfo.setContentDescription((CharSequence)paramView);
    }
    AppMethodBeat.o(234297);
  }
  
  public final Object findDescList(View paramView, final View[] paramArrayOfView)
  {
    AppMethodBeat.i(234327);
    s.u(paramView, "view");
    s.u(paramArrayOfView, "outRootView");
    final ah.f localf = new ah.f();
    getConfig(paramView, (b)new u(paramView)
    {
      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
      {
        AppMethodBeat.i(234246);
        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
        Map localMap = (Map)paramAnonymousMMBaseAccessibilityConfig.getViewRootDescMap$plugin_autoaccessibility_release().get(Integer.valueOf(this.$view.getId()));
        if (localMap == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234246);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        View localView = paramAnonymousMMBaseAccessibilityConfig.findRoot$plugin_autoaccessibility_release(this.$view, p.p((Iterable)localMap.keySet()));
        if (localView == null)
        {
          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
          AppMethodBeat.o(234246);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
        paramArrayOfView[0] = localView;
        ah.f localf = localf;
        Object localObject = localMap.get(Integer.valueOf(localView.getId()));
        if (localObject == null) {
          localObject = localMap.get(ContentDescProvider.INSTANCE.getLayoutId(localView));
        }
        for (;;)
        {
          localf.aqH = localObject;
          localObject = ContentDescProvider.INSTANCE;
          paramAnonymousMMBaseAccessibilityConfig = paramAnonymousMMBaseAccessibilityConfig.getClass().getName();
          s.s(paramAnonymousMMBaseAccessibilityConfig, "it::class.java.name");
          ContentDescProvider.access$setCurConfigName$p(paramAnonymousMMBaseAccessibilityConfig);
          paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
          AppMethodBeat.o(234246);
          return paramAnonymousMMBaseAccessibilityConfig;
        }
      }
    });
    paramView = localf.aqH;
    AppMethodBeat.o(234327);
    return paramView;
  }
  
  public final int getAuthority()
  {
    return 1;
  }
  
  public final String getContentDesc(View paramView)
  {
    AppMethodBeat.i(234320);
    s.u(paramView, "view");
    final Object localObject1 = new View[1];
    for (int i = 0; i <= 0; i = 1) {
      localObject1[0] = null;
    }
    Object localObject6 = findDescList(paramView, (View[])localObject1);
    Object localObject5 = localObject1[0];
    Object localObject4;
    Object localObject2;
    label398:
    label411:
    label456:
    label594:
    label726:
    if (((localObject6 instanceof List)) && (((List)localObject6).size() > 2))
    {
      final ah.d locald = new ah.d();
      locald.aixb = 1;
      int j = ((List)localObject6).size() / 2;
      localObject4 = new String[j];
      i = 0;
      while (i < j)
      {
        localObject4[i] = "";
        i += 1;
      }
      j = 0;
      i = 0;
      if (locald.aixb >= ((List)localObject6).size()) {
        break label1402;
      }
      localObject2 = ((List)localObject6).get(j);
      localObject1 = ((List)localObject6).get(locald.aixb);
      if (s.p(localObject2, "normal_string_type")) {
        if ((localObject1 instanceof String)) {
          localObject4[(locald.aixb / 2)] = ((String)localObject1);
        }
      }
      label342:
      Object localObject7;
      do
      {
        do
        {
          for (;;)
          {
            i += 2;
            locald.aixb = (i + 1);
            j = i;
            break;
            if (s.p(localObject2, "param_method_type"))
            {
              if ((localObject1 instanceof String))
              {
                localObject4[(locald.aixb / 2)] = "";
                getConfig(paramView, (b)new u((String[])localObject4)
                {
                  public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
                  {
                    AppMethodBeat.i(234191);
                    s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
                    String[] arrayOfString = this.$params;
                    int i = locald.aixb / 2;
                    paramAnonymousMMBaseAccessibilityConfig = (String)paramAnonymousMMBaseAccessibilityConfig.getParamMap$plugin_autoaccessibility_release().get(localObject1);
                    if (paramAnonymousMMBaseAccessibilityConfig == null)
                    {
                      paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
                      AppMethodBeat.o(234191);
                      return paramAnonymousMMBaseAccessibilityConfig;
                    }
                    arrayOfString[i] = paramAnonymousMMBaseAccessibilityConfig;
                    paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
                    AppMethodBeat.o(234191);
                    return paramAnonymousMMBaseAccessibilityConfig;
                  }
                });
              }
            }
            else
            {
              if (!s.p(localObject2, "string_resource_type")) {
                break label342;
              }
              if ((localObject1 instanceof Integer))
              {
                j = locald.aixb / 2;
                localObject1 = MMApplicationContext.getContext().getResources().getString(((Number)localObject1).intValue());
                s.s(localObject1, "getContext().resources.getString(content)");
                localObject4[j] = localObject1;
              }
            }
          }
          if (!s.p(localObject2, "id_resource_type")) {
            break label752;
          }
        } while ((!(localObject1 instanceof Integer)) || (localObject5 == null));
        localObject7 = localObject5.findViewById(((Number)localObject1).intValue());
      } while (localObject7 == null);
      j = paramView.getId();
      if (!(localObject1 instanceof Integer))
      {
        j = paramView.getId();
        if ((localObject1 instanceof Integer)) {
          break label648;
        }
        j = locald.aixb / 2;
        localObject1 = INSTANCE.getContentDesc((View)localObject7);
        if (localObject1 != null) {
          break label749;
        }
        localObject7 = ((View)localObject7).createAccessibilityNodeInfo();
        localObject1 = ((AccessibilityNodeInfo)localObject7).getContentDescription();
        if (localObject1 != null) {
          break label716;
        }
        localObject2 = null;
        localObject1 = localObject2;
        if (localObject2 == null)
        {
          localObject1 = ((AccessibilityNodeInfo)localObject7).getText();
          if (localObject1 != null) {
            break label726;
          }
          localObject1 = "";
        }
      }
      label617:
      label749:
      for (;;)
      {
        localObject4[j] = localObject1;
        break;
        if ((j != ((Number)localObject1).intValue()) || ((!(paramView instanceof TextView)) && (!(paramView instanceof NeatTextView)))) {
          break label398;
        }
        j = locald.aixb / 2;
        localObject1 = ((View)localObject7).getContentDescription();
        if (localObject1 == null)
        {
          localObject2 = null;
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            if (!(localObject7 instanceof TextView)) {
              break label617;
            }
            localObject1 = ((TextView)localObject7).getText();
            if (localObject1 != null) {
              break label594;
            }
            localObject1 = "";
          }
        }
        for (;;)
        {
          localObject4[j] = localObject1;
          break;
          localObject2 = localObject1.toString();
          break label539;
          localObject2 = localObject1.toString();
          localObject1 = localObject2;
          if (localObject2 == null)
          {
            localObject1 = "";
            continue;
            if ((localObject7 instanceof NeatTextView)) {
              localObject1 = ((NeatTextView)localObject7).jPy().toString();
            } else {
              localObject1 = "";
            }
          }
        }
        if (j != ((Number)localObject1).intValue()) {
          break label411;
        }
        j = locald.aixb / 2;
        localObject1 = ((View)localObject7).getContentDescription();
        if (localObject1 == null) {
          localObject1 = "";
        }
        for (;;)
        {
          localObject4[j] = localObject1;
          break;
          localObject2 = localObject1.toString();
          localObject1 = localObject2;
          if (localObject2 == null) {
            localObject1 = "";
          }
        }
        localObject2 = localObject1.toString();
        break label456;
        localObject2 = localObject1.toString();
        localObject1 = localObject2;
        if (localObject2 == null) {
          localObject1 = "";
        }
      }
    }
    label539:
    label716:
    label752:
    label1392:
    label1395:
    label1402:
    for (i = 1;; i = 0)
    {
      if (i == 0)
      {
        try
        {
          localObject1 = am.aixg;
          localObject1 = localObject4[0];
          localObject2 = (String[])k.e((Object[])localObject4, 1, localObject4.length);
          localObject2 = Arrays.copyOf((Object[])localObject2, localObject2.length);
          localObject1 = String.format((String)localObject1, Arrays.copyOf((Object[])localObject2, localObject2.length));
          s.s(localObject1, "java.lang.String.format(format, *args)");
          paramView = (View)localObject1;
        }
        finally
        {
          for (;;)
          {
            localObject1 = "";
            Log.printErrStackTrace("MicroMsg.Acc.ContentDescProvider", localThrowable, "String Format Error in [%s] in for view(%s) in config(%s)", new Object[] { localObject4[0], IdUtil.INSTANCE.getName(paramView.getId()), curConfigName });
            paramView = (View)localObject1;
          }
        }
        AppMethodBeat.o(234320);
        return paramView;
        if ((localObject6 instanceof List))
        {
          Object localObject3 = ((List)localObject6).get(0);
          localObject1 = ((List)localObject6).get(1);
          localObject4 = new ah.f();
          if (s.p(localObject3, "normal_string_type")) {
            if ((localObject1 instanceof String)) {
              paramView = (View)localObject1;
            }
          }
          for (;;)
          {
            ((ah.f)localObject4).aqH = paramView;
            break label1101;
            do
            {
              do
              {
                for (;;)
                {
                  if (((ah.f)localObject4).aqH == null) {
                    break label1395;
                  }
                  paramView = (String)((ah.f)localObject4).aqH;
                  AppMethodBeat.o(234320);
                  return paramView;
                  if (!s.p(localObject3, "param_method_type")) {
                    break;
                  }
                  if ((localObject1 instanceof String))
                  {
                    ((ah.f)localObject4).aqH = "";
                    getConfig(paramView, (b)new u((ah.f)localObject4)
                    {
                      public final Boolean invoke(MMBaseAccessibilityConfig paramAnonymousMMBaseAccessibilityConfig)
                      {
                        AppMethodBeat.i(234202);
                        s.u(paramAnonymousMMBaseAccessibilityConfig, "it");
                        ah.f localf = this.$contentDesc;
                        paramAnonymousMMBaseAccessibilityConfig = (String)paramAnonymousMMBaseAccessibilityConfig.getParamMap$plugin_autoaccessibility_release().get(localObject1);
                        if (paramAnonymousMMBaseAccessibilityConfig == null)
                        {
                          paramAnonymousMMBaseAccessibilityConfig = Boolean.FALSE;
                          AppMethodBeat.o(234202);
                          return paramAnonymousMMBaseAccessibilityConfig;
                        }
                        localf.aqH = paramAnonymousMMBaseAccessibilityConfig;
                        paramAnonymousMMBaseAccessibilityConfig = Boolean.TRUE;
                        AppMethodBeat.o(234202);
                        return paramAnonymousMMBaseAccessibilityConfig;
                      }
                    });
                  }
                }
                if (!s.p(localObject3, "string_resource_type")) {
                  break;
                }
              } while (!(localObject1 instanceof Integer));
              paramView = MMApplicationContext.getContext().getResources().getString(((Number)localObject1).intValue());
              break;
            } while ((!s.p(localObject3, "id_resource_type")) || (!(localObject1 instanceof Integer)));
            i = paramView.getId();
            if (!(localObject1 instanceof Integer)) {}
            for (;;)
            {
              i = paramView.getId();
              if (!(localObject1 instanceof Integer))
              {
                if (localObject5 == null) {
                  break label946;
                }
                localObject1 = localObject5.findViewById(((Number)localObject1).intValue());
                if (localObject1 == null) {
                  break label946;
                }
                paramView = INSTANCE.getContentDesc((View)localObject1);
                if (paramView != null) {
                  break label1392;
                }
                localObject3 = ((View)localObject1).createAccessibilityNodeInfo();
                paramView = ((AccessibilityNodeInfo)localObject3).getContentDescription();
                if (paramView != null) {
                  break label1363;
                }
                localObject1 = null;
                paramView = (View)localObject1;
                if (localObject1 == null)
                {
                  paramView = ((AccessibilityNodeInfo)localObject3).getText();
                  if (paramView != null) {
                    break label1372;
                  }
                  paramView = "";
                }
              }
              for (;;)
              {
                break;
                if ((i != ((Number)localObject1).intValue()) || ((!(paramView instanceof TextView)) && (!(paramView instanceof NeatTextView)))) {
                  break label1390;
                }
                localObject1 = paramView.getContentDescription();
                if (localObject1 == null)
                {
                  localObject3 = null;
                  localObject1 = localObject3;
                  if (localObject3 == null)
                  {
                    if (!(paramView instanceof TextView)) {
                      break label1294;
                    }
                    paramView = ((TextView)paramView).getText();
                    if (paramView != null) {
                      break label1275;
                    }
                    localObject1 = "";
                  }
                }
                for (;;)
                {
                  ((ah.f)localObject4).aqH = localObject1;
                  break;
                  localObject3 = localObject1.toString();
                  break label1223;
                  label1275:
                  paramView = paramView.toString();
                  localObject1 = paramView;
                  if (paramView == null)
                  {
                    localObject1 = "";
                    continue;
                    if ((paramView instanceof NeatTextView)) {
                      localObject1 = ((NeatTextView)paramView).jPy().toString();
                    } else {
                      localObject1 = "";
                    }
                  }
                }
                if (i != ((Number)localObject1).intValue()) {
                  break label945;
                }
                paramView = paramView.getContentDescription();
                if (paramView == null) {}
                for (paramView = null;; paramView = paramView.toString())
                {
                  ((ah.f)localObject4).aqH = paramView;
                  break;
                }
                localObject1 = paramView.toString();
                break label1159;
                localObject1 = paramView.toString();
                paramView = (View)localObject1;
                if (localObject1 == null) {
                  paramView = "";
                }
              }
            }
          }
        }
      }
      AppMethodBeat.o(234320);
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.accessibility.core.provider.ContentDescProvider
 * JD-Core Version:    0.7.0.1
 */