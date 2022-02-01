package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.hellhoundlib.a.c;
import com.tencent.mm.plugin.expt.hellhound.a.a.d;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class b
{
  public Map<String, Map<String, List<Pair<String, String>>>> pFf;
  public List<Pair<String, String>> pGi;
  public d pGj;
  public a pHR;
  public Map<String, List<Pair<String, String>>> pHS;
  public Map<String, List<Pair<String, String>>> pHT;
  public c pHU;
  public com.tencent.mm.hellhoundlib.a.b pHV;
  
  b()
  {
    AppMethodBeat.i(177410);
    this.pHU = new c()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184393);
        if (("onScrollStateChanged".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;I)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 2) && (b.this.pGj != null))
          {
            b.this.pGj.k((ViewGroup)paramAnonymousArrayOfObject[0], ((Integer)paramAnonymousArrayOfObject[1]).intValue());
            AppMethodBeat.o(184393);
          }
        }
        else if (("onScroll".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;III)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 4) && (b.this.pGj != null))
          {
            paramAnonymousString1 = b.this.pGj;
            paramAnonymousString2 = (ViewGroup)paramAnonymousArrayOfObject[0];
            int i = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            paramAnonymousString1.a(paramAnonymousString2, i, j, 0);
            AppMethodBeat.o(184393);
          }
        }
        else if (("resetStoryHeader".equals(paramAnonymousString2)) && ("()V".equals(paramAnonymousString3)) && (b.this.pHR != null)) {
          b.this.pHR.cdN();
        }
        AppMethodBeat.o(184393);
      }
      
      public final void g(String paramAnonymousString, Object paramAnonymousObject) {}
    };
    this.pHV = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184394);
        if (paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI"))
        {
          if (b.this.pHR == null)
          {
            AppMethodBeat.o(184394);
            return;
          }
          if (paramAnonymousString3.equals("smoothScrollToPosition"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0))
            {
              b.this.pHR.smoothScrollToPosition(((Integer)paramAnonymousArrayOfObject[0]).intValue());
              AppMethodBeat.o(184394);
            }
          }
          else if (paramAnonymousString3.equals("smoothScrollToPositionFromTop"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length >= 2))
            {
              paramAnonymousString1 = b.this.pHR;
              int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
              ((Integer)paramAnonymousArrayOfObject[1]).intValue();
              paramAnonymousString1.BJ(i);
              AppMethodBeat.o(184394);
            }
          }
          else if ((paramAnonymousString3.equals("scrollToTop")) && (paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0)) {
            b.this.pHR.cdM();
          }
        }
        AppMethodBeat.o(184394);
      }
      
      public final void l(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3) {}
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/widget/AbsListView;I)V"));
    localArrayList.add(Pair.create("onScroll", "(Landroid/widget/AbsListView;III)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("android/widget/AbsListView$OnScrollListener", localArrayList);
    this.pFf = new HashMap();
    this.pFf.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", localHashMap);
    this.pHT = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("resetStoryHeader", "()V"));
    this.pHT.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", localArrayList);
    this.pGi = new ArrayList();
    this.pGi.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.pGi.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
    this.pHS = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
    this.pHS.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", localArrayList);
    AppMethodBeat.o(177410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.b
 * JD-Core Version:    0.7.0.1
 */