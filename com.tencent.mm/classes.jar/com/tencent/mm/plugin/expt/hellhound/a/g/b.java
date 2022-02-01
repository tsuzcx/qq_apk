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
  public final Map<String, List<Pair<String, String>>> qXf;
  public final Map<String, Map<String, List<Pair<String, String>>>> qZY;
  public final List<Pair<String, String>> rcg;
  public e rch;
  public a rhJ;
  public final Map<String, List<Pair<String, String>>> rhK;
  public c rhL;
  public com.tencent.mm.hellhoundlib.a.b rhM;
  
  b()
  {
    AppMethodBeat.i(177410);
    this.rhL = new c()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject1, Object paramAnonymousObject2) {}
      
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184393);
        if (("onScrollStateChanged".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;I)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 2) && (b.this.rch != null))
          {
            b.this.rch.l((ViewGroup)paramAnonymousArrayOfObject[0], ((Integer)paramAnonymousArrayOfObject[1]).intValue());
            AppMethodBeat.o(184393);
          }
        }
        else if (("onScroll".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;III)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 4) && (b.this.rch != null))
          {
            paramAnonymousString1 = b.this.rch;
            paramAnonymousString2 = (ViewGroup)paramAnonymousArrayOfObject[0];
            int i = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            paramAnonymousString1.a(paramAnonymousString2, i, j, 0);
            AppMethodBeat.o(184393);
          }
        }
        else if (("resetStoryHeader".equals(paramAnonymousString2)) && ("()V".equals(paramAnonymousString3)) && (b.this.rhJ != null)) {
          b.this.rhJ.csl();
        }
        AppMethodBeat.o(184393);
      }
    };
    this.rhM = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject) {}
      
      public final void c(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(196167);
        if (paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI"))
        {
          if (b.this.rhJ == null)
          {
            AppMethodBeat.o(196167);
            return;
          }
          if (paramAnonymousString4.equals("smoothScrollToPosition"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0))
            {
              b.this.rhJ.smoothScrollToPosition(((Integer)paramAnonymousArrayOfObject[0]).intValue());
              AppMethodBeat.o(196167);
            }
          }
          else if (paramAnonymousString4.equals("smoothScrollToPositionFromTop"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length >= 2))
            {
              paramAnonymousString1 = b.this.rhJ;
              int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
              ((Integer)paramAnonymousArrayOfObject[1]).intValue();
              paramAnonymousString1.DE(i);
              AppMethodBeat.o(196167);
            }
          }
          else if ((paramAnonymousString4.equals("scrollToTop")) && (paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0)) {
            b.this.rhJ.csk();
          }
        }
        AppMethodBeat.o(196167);
      }
    };
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(Pair.create("onScrollStateChanged", "(Landroid/widget/AbsListView;I)V"));
    localArrayList.add(Pair.create("onScroll", "(Landroid/widget/AbsListView;III)V"));
    HashMap localHashMap = new HashMap();
    localHashMap.put("android/widget/AbsListView$OnScrollListener", localArrayList);
    this.qZY = new HashMap();
    this.qZY.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", localHashMap);
    this.rhK = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("resetStoryHeader", "()V"));
    this.rhK.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", localArrayList);
    this.rcg = new ArrayList();
    this.rcg.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.rcg.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
    this.qXf = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
    this.qXf.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", localArrayList);
    AppMethodBeat.o(177410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes7.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.b
 * JD-Core Version:    0.7.0.1
 */