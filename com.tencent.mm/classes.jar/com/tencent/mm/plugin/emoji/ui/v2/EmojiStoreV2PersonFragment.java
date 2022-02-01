package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.w;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ac;

public class EmojiStoreV2PersonFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean pjG = false;
  private com.tencent.mm.plugin.emoji.a.h pjI;
  
  protected final void b(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(109231);
    super.b(paramInt1, paramInt2, paramn);
    if (this.piI != null) {
      this.piI.updateTitle();
    }
    AppMethodBeat.o(109231);
  }
  
  public final a ccS()
  {
    AppMethodBeat.i(109232);
    this.pjI = new com.tencent.mm.plugin.emoji.a.h(getContext());
    com.tencent.mm.plugin.emoji.a.h localh = this.pjI;
    AppMethodBeat.o(109232);
    return localh;
  }
  
  public final int ccZ()
  {
    return 9;
  }
  
  protected final void cea()
  {
    int j = 1;
    AppMethodBeat.i(109223);
    int k;
    int i;
    int n;
    int m;
    try
    {
      k = this.mListView.getFirstVisiblePosition();
      i = k;
      if (k <= 0) {
        i = 1;
      }
      n = this.mListView.getLastVisiblePosition();
      if (n - i <= 0)
      {
        AppMethodBeat.o(109223);
        return;
      }
      localStringBuilder1 = new StringBuilder();
      localStringBuilder2 = new StringBuilder();
      localStringBuilder3 = new StringBuilder();
      i -= 1;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder1;
      StringBuilder localStringBuilder2;
      StringBuilder localStringBuilder3;
      int i1;
      Object localObject;
      ac.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2PersonFragment", localException, "", new Object[0]);
      AppMethodBeat.o(109223);
      return;
    }
    if (k < 3)
    {
      i1 = this.pjI.Bl(i) + k;
      localObject = this.pjI.Bk(i1);
      m = j;
      if (localObject != null)
      {
        localObject = ((f)localObject).oYl;
        m = j;
        if (localObject != null)
        {
          if (j == 0)
          {
            localStringBuilder1.append("#");
            localStringBuilder2.append("#");
            localStringBuilder3.append("#");
          }
          localStringBuilder1.append(((EmotionSummary)localObject).ProductID);
          localStringBuilder2.append(((EmotionSummary)localObject).PackName);
          localStringBuilder3.append(i1 + 1);
          m = 0;
        }
      }
    }
    label306:
    for (;;)
    {
      this.pbh.dHA = 1;
      this.pbh.fS(localStringBuilder1.toString());
      this.pbh.fT(localStringBuilder2.toString());
      this.pbh.fU(localStringBuilder3.toString());
      this.pbh.aHZ();
      AppMethodBeat.o(109223);
      return;
      for (;;)
      {
        if (i >= n - 1) {
          break label306;
        }
        k = 0;
        break;
        k += 1;
        j = m;
        break;
        i += 1;
      }
    }
  }
  
  public final boolean cef()
  {
    return false;
  }
  
  public int getLayoutId()
  {
    return 2131493813;
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(109220);
    super.onAttach(paramActivity);
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    AppMethodBeat.o(109220);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109221);
    super.onCreate(paramBundle);
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    this.pbh.dHz = 2;
    AppMethodBeat.o(109221);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(109222);
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(109222);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109229);
    super.onDestroy();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109229);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(109228);
    super.onDestroyView();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    AppMethodBeat.o(109228);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(109230);
    super.onDetach();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109230);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109226);
    super.onPause();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    AppMethodBeat.o(109226);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109225);
    super.onResume();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    if (this.piI != null) {
      this.piI.cei();
    }
    AppMethodBeat.o(109225);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109224);
    super.onStart();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    AppMethodBeat.o(109224);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109227);
    super.onStop();
    ac.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    AppMethodBeat.o(109227);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109233);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.pjG) && (paramBoolean))
    {
      this.pjG = true;
      com.tencent.mm.plugin.report.service.h.wUl.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2) });
    }
    AppMethodBeat.o(109233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2PersonFragment
 * JD-Core Version:    0.7.0.1
 */