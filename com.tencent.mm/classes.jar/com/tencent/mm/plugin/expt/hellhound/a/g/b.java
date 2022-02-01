package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.e;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public final Map<String, List<Pair<String, String>>> qPk;
  public final Map<String, Map<String, List<Pair<String, String>>>> qSa;
  public final List<Pair<String, String>> qUi;
  public e qUj;
  public a qZD;
  public final Map<String, List<Pair<String, String>>> qZE;
  public c qZF;
  public com.tencent.mm.hellhoundlib.a.b qZG;
  
  b()
  {
    AppMethodBeat.i(177410);
    this.qZF = new c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184393);
        if (("onScrollStateChanged".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;I)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 2) && (b.this.qUj != null))
          {
            b.this.qUj.l((ViewGroup)paramAnonymousArrayOfObject[0], ((Integer)paramAnonymousArrayOfObject[1]).intValue());
            AppMethodBeat.o(184393);
          }
        }
        else if (("onScroll".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;III)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 4) && (b.this.qUj != null))
          {
            paramAnonymousString1 = b.this.qUj;
            paramAnonymousString2 = (ViewGroup)paramAnonymousArrayOfObject[0];
            int i = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            paramAnonymousString1.a(paramAnonymousString2, i, j, 0);
            AppMethodBeat.o(184393);
          }
        }
        else if (("resetStoryHeader".equals(paramAnonymousString2)) && ("()V".equals(paramAnonymousString3)) && (b.this.qZD != null)) {
          b.this.qZD.cqJ();
        }
        AppMethodBeat.o(184393);
      }
    };
    this.qZG = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(210500);
        if (paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI"))
        {
          if (b.this.qZD == null)
          {
            AppMethodBeat.o(210500);
            return;
          }
          if (paramAnonymousString4.equals("smoothScrollToPosition"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0))
            {
              b.this.qZD.smoothScrollToPosition(((Integer)paramAnonymousArrayOfObject[0]).intValue());
              AppMethodBeat.o(210500);
            }
          }
          else if (paramAnonymousString4.equals("smoothScrollToPositionFromTop"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length >= 2))
            {
              paramAnonymousString1 = b.this.qZD;
              int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
              ((Integer)paramAnonymousArrayOfObject[1]).intValue();
              paramAnonymousString1.Dr(i);
              AppMethodBeat.o(210500);
            }
          }
          else if ((paramAnonymousString4.equals("scrollToTop")) && (paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0)) {
            b.this.qZD.cqI();
          }
        }
        AppMethodBeat.o(210500);
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/widget/AbsListView;I)V"));
    localArrayList.add(Pair.create("onScroll", "(Landroid/widget/AbsListView;III)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("android/widget/AbsListView$OnScrollListener", localArrayList);
    this.qSa = new HashMap();
    this.qSa.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", localHashMap);
    this.qZE = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("resetStoryHeader", "()V"));
    this.qZE.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", localArrayList);
    this.qUi = new ArrayList();
    this.qUi.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.qUi.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
    this.qPk = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
    this.qPk.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", localArrayList);
    AppMethodBeat.o(177410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.b
 * JD-Core Version:    0.7.0.1
 */