package com.tencent.mm.plugin.expt.hellhound.a.g;

import android.util.Pair;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.expt.hellhound.a.a.f;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class c
{
  public final Map<String, Map<String, List<Pair<String, String>>>> sAp;
  public final List<Pair<String, String>> sCM;
  public f sCN;
  public b sJf;
  public final Map<String, List<Pair<String, String>>> sJg;
  public final com.tencent.mm.hellhoundlib.a.c sJh;
  public com.tencent.mm.hellhoundlib.a.b sJi;
  public final Map<String, List<Pair<String, String>>> sxm;
  
  c()
  {
    AppMethodBeat.i(177410);
    this.sJh = new com.tencent.mm.hellhoundlib.a.c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184393);
        if (("onScrollStateChanged".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;I)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 2) && (c.this.sCN != null))
          {
            c.this.sCN.k((ViewGroup)paramAnonymousArrayOfObject[0], ((Integer)paramAnonymousArrayOfObject[1]).intValue());
            AppMethodBeat.o(184393);
          }
        }
        else if (("onScroll".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;III)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 4) && (c.this.sCN != null))
          {
            paramAnonymousString1 = c.this.sCN;
            paramAnonymousString2 = (ViewGroup)paramAnonymousArrayOfObject[0];
            int i = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            paramAnonymousString1.a(paramAnonymousString2, i, j, 0);
            AppMethodBeat.o(184393);
          }
        }
        else if (("resetStoryHeader".equals(paramAnonymousString2)) && ("()V".equals(paramAnonymousString3)) && (c.this.sJf != null)) {
          c.this.sJf.cQT();
        }
        AppMethodBeat.o(184393);
      }
    };
    this.sJi = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(220600);
        if (paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI"))
        {
          if (c.this.sJf == null)
          {
            AppMethodBeat.o(220600);
            return;
          }
          if (paramAnonymousString4.equals("smoothScrollToPosition"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0))
            {
              c.this.sJf.smoothScrollToPosition(((Integer)paramAnonymousArrayOfObject[0]).intValue());
              AppMethodBeat.o(220600);
            }
          }
          else if (paramAnonymousString4.equals("smoothScrollToPositionFromTop"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length >= 2))
            {
              paramAnonymousString1 = c.this.sJf;
              int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
              ((Integer)paramAnonymousArrayOfObject[1]).intValue();
              paramAnonymousString1.Hr(i);
              AppMethodBeat.o(220600);
            }
          }
          else if ((paramAnonymousString4.equals("scrollToTop")) && (paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0)) {
            c.this.sJf.cQS();
          }
        }
        AppMethodBeat.o(220600);
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/widget/AbsListView;I)V"));
    localArrayList.add(Pair.create("onScroll", "(Landroid/widget/AbsListView;III)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("android/widget/AbsListView$OnScrollListener", localArrayList);
    this.sAp = new HashMap();
    this.sAp.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", localHashMap);
    this.sJg = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("resetStoryHeader", "()V"));
    this.sJg.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", localArrayList);
    this.sCM = new ArrayList();
    this.sCM.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.sCM.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
    this.sxm = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
    this.sxm.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", localArrayList);
    AppMethodBeat.o(177410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.c
 * JD-Core Version:    0.7.0.1
 */