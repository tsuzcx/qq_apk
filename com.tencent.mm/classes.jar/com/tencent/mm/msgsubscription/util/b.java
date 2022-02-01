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
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(iBK={1, 1, 16}, iBL={""}, iBM={"Lcom/tencent/mm/msgsubscription/util/SubscribeMsgTemplateViewHelper;", "", "()V", "createTemplateItemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "index", "", "size", "key", "", "value", "topMargin", "createTemplateView", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "wxbiz-msgsubscription-sdk_release"})
public final class b
{
  public static final b mtx;
  
  static
  {
    AppMethodBeat.i(149818);
    mtx = new b();
    AppMethodBeat.o(149818);
  }
  
  public static View a(Context paramContext, ArrayList<o<String, String>> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(149816);
    p.k(paramContext, "context");
    p.k(paramArrayList, "keyWordList");
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        j.iBO();
      }
      localObject1 = (o)localObject1;
      Object localObject2 = (String)((o)localObject1).Mx;
      String str = (String)((o)localObject1).My;
      int j = paramArrayList.size();
      localObject1 = LayoutInflater.from(paramContext).inflate(a.e.subscribe_msg_template_item, null, false);
      View localView = ((View)localObject1).findViewById(a.d.key);
      p.j(localView, "templateItem.findViewById<TextView>(R.id.key)");
      ((TextView)localView).setText((CharSequence)localObject2);
      localObject2 = ((View)localObject1).findViewById(a.d.value);
      p.j(localObject2, "templateItem.findViewById<TextView>(R.id.value)");
      ((TextView)localObject2).setText((CharSequence)str);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      if (i != j - 1) {
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramContext.getResources().getDimensionPixelSize(a.b.LargePadding);
      }
      if (i == 0) {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt;
      }
      p.j(localObject1, "templateItem");
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localLinearLayout.addView((View)localObject1);
      i += 1;
    }
    paramContext = (View)localLinearLayout;
    AppMethodBeat.o(149816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.b
 * JD-Core Version:    0.7.0.1
 */