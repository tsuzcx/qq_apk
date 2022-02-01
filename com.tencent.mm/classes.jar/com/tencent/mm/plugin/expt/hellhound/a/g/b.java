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
  public Map<String, Map<String, List<Pair<String, String>>>> qjT;
  public List<Pair<String, String>> qll;
  public e qlm;
  public Map<String, List<Pair<String, String>>> qqA;
  public c qqB;
  public com.tencent.mm.hellhoundlib.a.b qqC;
  public a qqy;
  public Map<String, List<Pair<String, String>>> qqz;
  
  b()
  {
    AppMethodBeat.i(177410);
    this.qqB = new c()
    {
      public final void b(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184393);
        if (("onScrollStateChanged".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;I)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 2) && (b.this.qlm != null))
          {
            b.this.qlm.k((ViewGroup)paramAnonymousArrayOfObject[0], ((Integer)paramAnonymousArrayOfObject[1]).intValue());
            AppMethodBeat.o(184393);
          }
        }
        else if (("onScroll".equals(paramAnonymousString2)) && ("(Landroid/widget/AbsListView;III)V".equals(paramAnonymousString3)))
        {
          if ((paramAnonymousArrayOfObject.length >= 4) && (b.this.qlm != null))
          {
            paramAnonymousString1 = b.this.qlm;
            paramAnonymousString2 = (ViewGroup)paramAnonymousArrayOfObject[0];
            int i = ((Integer)paramAnonymousArrayOfObject[1]).intValue();
            int j = ((Integer)paramAnonymousArrayOfObject[2]).intValue();
            ((Integer)paramAnonymousArrayOfObject[3]).intValue();
            paramAnonymousString1.a(paramAnonymousString2, i, j, 0);
            AppMethodBeat.o(184393);
          }
        }
        else if (("resetStoryHeader".equals(paramAnonymousString2)) && ("()V".equals(paramAnonymousString3)) && (b.this.qqy != null)) {
          b.this.qqy.clu();
        }
        AppMethodBeat.o(184393);
      }
      
      public final void f(String paramAnonymousString, Object paramAnonymousObject) {}
    };
    this.qqC = new com.tencent.mm.hellhoundlib.a.b()
    {
      public final void a(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, Object paramAnonymousObject, Object[] paramAnonymousArrayOfObject)
      {
        AppMethodBeat.i(184394);
        if (paramAnonymousString1.startsWith("com/tencent/mm/plugin/sns/ui/SnsTimeLineUI"))
        {
          if (b.this.qqy == null)
          {
            AppMethodBeat.o(184394);
            return;
          }
          if (paramAnonymousString3.equals("smoothScrollToPosition"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0))
            {
              b.this.qqy.smoothScrollToPosition(((Integer)paramAnonymousArrayOfObject[0]).intValue());
              AppMethodBeat.o(184394);
            }
          }
          else if (paramAnonymousString3.equals("smoothScrollToPositionFromTop"))
          {
            if ((paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length >= 2))
            {
              paramAnonymousString1 = b.this.qqy;
              int i = ((Integer)paramAnonymousArrayOfObject[0]).intValue();
              ((Integer)paramAnonymousArrayOfObject[1]).intValue();
              paramAnonymousString1.CE(i);
              AppMethodBeat.o(184394);
            }
          }
          else if ((paramAnonymousString3.equals("scrollToTop")) && (paramAnonymousArrayOfObject != null) && (paramAnonymousArrayOfObject.length > 0)) {
            b.this.qqy.clt();
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
    this.qjT = new HashMap();
    this.qjT.put("com/tencent/mm/plugin/sns/ui/SnsUIAction$", localHashMap);
    this.qqA = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("resetStoryHeader", "()V"));
    this.qqA.put("com/tencent/mm/plugin/sns/ui/SnsUIAction", localArrayList);
    this.qll = new ArrayList();
    this.qll.add(Pair.create("smoothScrollToPosition", "(I)V"));
    this.qll.add(Pair.create("smoothScrollToPositionFromTop", "(II)V"));
    this.qqz = new HashMap();
    localArrayList = new ArrayList();
    localArrayList.add(Pair.create("scrollToTop", "(Landroid/widget/ListView;)V"));
    this.qqz.put("com/tencent/mm/sdk/platformtools/BackwardSupportUtil$SmoothScrollFactory", localArrayList);
    AppMethodBeat.o(177410);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.expt.hellhound.a.g.b
 * JD-Core Version:    0.7.0.1
 */