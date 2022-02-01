package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.ak.n;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.h;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;

public class EmojiStoreV2PersonFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean pTL = false;
  private h pTN;
  
  protected final void b(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(109231);
    super.b(paramInt1, paramInt2, paramn);
    if (this.pSN != null) {
      this.pSN.updateTitle();
    }
    AppMethodBeat.o(109231);
  }
  
  public final a ciL()
  {
    AppMethodBeat.i(109232);
    this.pTN = new h(getContext());
    h localh = this.pTN;
    AppMethodBeat.o(109232);
    return localh;
  }
  
  public final int ciS()
  {
    return 9;
  }
  
  protected final void cjT()
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
      ae.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2PersonFragment", localException, "", new Object[0]);
      AppMethodBeat.o(109223);
      return;
    }
    if (k < 3)
    {
      i1 = this.pTN.Cf(i) + k;
      localObject = this.pTN.Ce(i1);
      m = j;
      if (localObject != null)
      {
        localObject = ((f)localObject).pIz;
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
      this.pLv.dVT = 1;
      this.pLv.ha(localStringBuilder1.toString());
      this.pLv.hb(localStringBuilder2.toString());
      this.pLv.hc(localStringBuilder3.toString());
      this.pLv.aLH();
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
  
  public final boolean cjY()
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
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    AppMethodBeat.o(109220);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109221);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    this.pLv.dVS = 2;
    AppMethodBeat.o(109221);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(109222);
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(109222);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109229);
    super.onDestroy();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109229);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(109228);
    super.onDestroyView();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    AppMethodBeat.o(109228);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(109230);
    super.onDetach();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109230);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109226);
    super.onPause();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    AppMethodBeat.o(109226);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109225);
    super.onResume();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    if (this.pSN != null) {
      this.pSN.ckb();
    }
    AppMethodBeat.o(109225);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109224);
    super.onStart();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    AppMethodBeat.o(109224);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109227);
    super.onStop();
    ae.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    AppMethodBeat.o(109227);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109233);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.pTL) && (paramBoolean))
    {
      this.pTL = true;
      g.yxI.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2) });
    }
    AppMethodBeat.o(109233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2PersonFragment
 * JD-Core Version:    0.7.0.1
 */