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
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.a.j;
import kotlin.g.b.p;
import kotlin.l;
import kotlin.o;

@l(hxD={1, 1, 16}, hxE={""}, hxF={"Lcom/tencent/mm/msgsubscription/util/SubscribeMsgTemplateViewHelper;", "", "()V", "createTemplateItemView", "Landroid/view/View;", "context", "Landroid/content/Context;", "index", "", "size", "key", "", "value", "topMargin", "createTemplateView", "keyWordList", "Ljava/util/ArrayList;", "Lkotlin/Pair;", "Lkotlin/collections/ArrayList;", "wxbiz-msgsubscription-sdk_release"})
public final class b
{
  public static final b jDg;
  
  static
  {
    AppMethodBeat.i(149818);
    jDg = new b();
    AppMethodBeat.o(149818);
  }
  
  public static View a(Context paramContext, ArrayList<o<String, String>> paramArrayList, int paramInt)
  {
    AppMethodBeat.i(149816);
    p.h(paramContext, "context");
    p.h(paramArrayList, "keyWordList");
    LinearLayout localLinearLayout = new LinearLayout(paramContext);
    localLinearLayout.setOrientation(1);
    localLinearLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    Iterator localIterator = ((Iterable)paramArrayList).iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      if (i < 0) {
        j.hxH();
      }
      localObject1 = (o)localObject1;
      Object localObject2 = (String)((o)localObject1).first;
      String str = (String)((o)localObject1).second;
      int j = paramArrayList.size();
      localObject1 = LayoutInflater.from(paramContext).inflate(2131496635, null, false);
      View localView = ((View)localObject1).findViewById(2131302942);
      p.g(localView, "templateItem.findViewById<TextView>(R.id.key)");
      ((TextView)localView).setText((CharSequence)localObject2);
      localObject2 = ((View)localObject1).findViewById(2131309673);
      p.g(localObject2, "templateItem.findViewById<TextView>(R.id.value)");
      ((TextView)localObject2).setText((CharSequence)str);
      localObject2 = new LinearLayout.LayoutParams(-1, -2);
      if (i != j - 1) {
        ((LinearLayout.LayoutParams)localObject2).bottomMargin = paramContext.getResources().getDimensionPixelSize(2131165498);
      }
      if (i == 0) {
        ((LinearLayout.LayoutParams)localObject2).topMargin = paramInt;
      }
      p.g(localObject1, "templateItem");
      ((View)localObject1).setLayoutParams((ViewGroup.LayoutParams)localObject2);
      localLinearLayout.addView((View)localObject1);
      i += 1;
    }
    paramContext = (View)localLinearLayout;
    AppMethodBeat.o(149816);
    return paramContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes.jar
 * Qualified Name:     com.tencent.mm.msgsubscription.util.b
 * JD-Core Version:    0.7.0.1
 */