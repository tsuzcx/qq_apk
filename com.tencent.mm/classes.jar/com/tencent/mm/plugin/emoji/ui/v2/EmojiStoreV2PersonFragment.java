package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.al.n;
import com.tencent.mm.g.b.a.u;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ad;

public class EmojiStoreV2PersonFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean oGg = false;
  private com.tencent.mm.plugin.emoji.a.h oGi;
  
  protected final void b(int paramInt1, int paramInt2, n paramn)
  {
    AppMethodBeat.i(109231);
    super.b(paramInt1, paramInt2, paramn);
    if (this.oFh != null) {
      this.oFh.updateTitle();
    }
    AppMethodBeat.o(109231);
  }
  
  public final a bVF()
  {
    AppMethodBeat.i(109232);
    this.oGi = new com.tencent.mm.plugin.emoji.a.h(getContext());
    com.tencent.mm.plugin.emoji.a.h localh = this.oGi;
    AppMethodBeat.o(109232);
    return localh;
  }
  
  public final int bVM()
  {
    return 9;
  }
  
  protected final void bWN()
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
      ad.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2PersonFragment", localException, "", new Object[0]);
      AppMethodBeat.o(109223);
      return;
    }
    if (k < 3)
    {
      i1 = this.oGi.At(i) + k;
      localObject = this.oGi.As(i1);
      m = j;
      if (localObject != null)
      {
        localObject = ((f)localObject).ouL;
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
      this.oxH.dJy = 1;
      this.oxH.gb(localStringBuilder1.toString());
      this.oxH.gc(localStringBuilder2.toString());
      this.oxH.gd(localStringBuilder3.toString());
      this.oxH.aBj();
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
  
  public final boolean bWS()
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
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
    AppMethodBeat.o(109220);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109221);
    super.onCreate(paramBundle);
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
    this.oxH.dJx = 2;
    AppMethodBeat.o(109221);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(109222);
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(109222);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109229);
    super.onDestroy();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109229);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(109228);
    super.onDestroyView();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    AppMethodBeat.o(109228);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(109230);
    super.onDetach();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
    AppMethodBeat.o(109230);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109226);
    super.onPause();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
    AppMethodBeat.o(109226);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109225);
    super.onResume();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    if (this.oFh != null) {
      this.oFh.bWV();
    }
    AppMethodBeat.o(109225);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109224);
    super.onStart();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
    AppMethodBeat.o(109224);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109227);
    super.onStop();
    ad.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
    AppMethodBeat.o(109227);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109233);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.oGg) && (paramBoolean))
    {
      this.oGg = true;
      com.tencent.mm.plugin.report.service.h.vKh.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2) });
    }
    AppMethodBeat.o(109233);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2PersonFragment
 * JD-Core Version:    0.7.0.1
 */