package com.tencent.mm.msgsubscription.util;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.msgsubscription.a.b;
import com.tencent.mm.msgsubscription.a.d;
import com.tencent.mm.msgsubscription.a.e;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.a.p;
import kotlin.g.b.s;
import kotlin.r;

@Metadata(d1={""}, d2={"Lcom/tencent/mm/msgsubscription/util/SubscribeMsgTemplateViewHelper;", "", "()V", "createTemplateItemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "index", "", "size", "key", "", "value", "topMargin", "createTemplateView", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "wxbiz-msgsubscription-sdk_release"}, k=1, mv={1, 5, 1}, xi=48)
public final class b
{
  public static final b pmS;
  
  static
  {
    AppMethodBeat.i(149818);
    pmS = new b();
    AppMethodBeat.o(149818);
  }
  
  public static View a(Context paramContext, ArrayList<r<String, String>> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(149816);
    s.u(paramContext, "context");
    s.u(paramArrayList, "keyWordList");
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        p.kkW();
      }
      Object localObject2 = (r)localObject1;
      localObject1 = (String)((r)localObject2).bsC;
      String str = (String)((r)localObject2).bsD;
      int j = paramArrayList.size();
      localObject2 = LayoutInflater.from(paramContext).inflate(a.e.subscribe_msg_template_item, null, false);
      ((View)localObject2).setContentDescription((CharSequence)((String)localObject1 + ' ' + str));
      ((TextView)((View)localObject2).findViewById(a.d.key)).setText((CharSequence)localObject1);
      ((TextView)((View)localObject2).findViewById(a.d.value)).setText((CharSequence)str);
      localObject1 = new LinearLayout.LayoutParams(-1, -2);
      if (i != j - 1) {
        ((LinearLayout.LayoutParams)localObject1).bottomMargin = paramContext.getResources().getDimensionPixelSize(a.b.LargePadding);
      }
      if (i == 0) {
        ((LinearLayout.LayoutParams)localObject1).topMargin = paramInt;
      }
      ((View)localObject2).setLayoutParams((ViewGroup.LayoutParams)localObject1);
      s.s(localObject2, "templateItem");
      localLinearLayout.addView((View)localObject2);
      i += 1;
    }
    paramContext = (View)localLinearLayout;
    AppMethodBeat.o(149816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes5.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.b
 * JD-Core Version:    0.7.0.1
 */