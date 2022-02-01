package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.g.b.a.z;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.model.d;
import com.tencent.mm.protocal.protobuf.EmotionSummary;
import com.tencent.mm.sdk.platformtools.ae;

public class EmojiStoreV2MainFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean pTL = false;
  private com.tencent.mm.plugin.emoji.a.g pTM;
  
  public final a ciL()
  {
    AppMethodBeat.i(109218);
    this.pTM = new com.tencent.mm.plugin.emoji.a.g(getContext());
    com.tencent.mm.plugin.emoji.a.g localg = this.pTM;
    AppMethodBeat.o(109218);
    return localg;
  }
  
  public final int ciS()
  {
    return 5;
  }
  
  protected final void cjT()
  {
    int k = 1;
    AppMethodBeat.i(109210);
    for (;;)
    {
      int j;
      int m;
      try
      {
        j = this.mListView.getFirstVisiblePosition();
        int n = this.mListView.getLastVisiblePosition();
        if (n - j <= 0)
        {
          AppMethodBeat.o(109210);
          return;
        }
        if (!d.chY().pKH) {
          break label289;
        }
        i = 1;
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        StringBuilder localStringBuilder3 = new StringBuilder();
        if (j < n)
        {
          Object localObject = this.pTM.Ce(j);
          m = k;
          if (localObject != null)
          {
            localObject = ((f)localObject).pIz;
            m = k;
            if (localObject != null)
            {
              if (k == 0)
              {
                localStringBuilder1.append("#");
                localStringBuilder2.append("#");
                localStringBuilder3.append("#");
              }
              localStringBuilder1.append(((EmotionSummary)localObject).ProductID);
              if (i != 0)
              {
                localObject = ((EmotionSummary)localObject).ExptDesc;
                localStringBuilder2.append((String)localObject);
                localStringBuilder3.append(j + 1);
                m = 0;
              }
              else
              {
                localObject = ((EmotionSummary)localObject).Introduce;
                continue;
              }
            }
          }
        }
        else
        {
          this.pLv.dVT = 1;
          this.pLv.ha(localStringBuilder1.toString());
          this.pLv.hb(localStringBuilder2.toString());
          this.pLv.hc(localStringBuilder3.toString());
          this.pLv.aLH();
          AppMethodBeat.o(109210);
          return;
        }
      }
      catch (Exception localException)
      {
        ae.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2MainFragment", localException, "", new Object[0]);
        AppMethodBeat.o(109210);
        return;
      }
      j += 1;
      k = m;
      continue;
      label289:
      int i = 0;
    }
  }
  
  public final boolean cjY()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2131493811;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(109209);
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    AppMethodBeat.o(109209);
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(109206);
    super.onAttach(paramActivity);
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    AppMethodBeat.o(109206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109207);
    super.onCreate(paramBundle);
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    this.pLv.dVS = 1;
    AppMethodBeat.o(109207);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(109208);
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(109208);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109216);
    super.onDestroy();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(109216);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(109215);
    super.onDestroyView();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(109215);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(109217);
    super.onDetach();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(109217);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109213);
    super.onPause();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    AppMethodBeat.o(109213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109212);
    super.onResume();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(109212);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109211);
    super.onStart();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    AppMethodBeat.o(109211);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109214);
    super.onStop();
    ae.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    AppMethodBeat.o(109214);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109219);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.pTL) && (paramBoolean))
    {
      this.pTL = true;
      com.tencent.mm.plugin.report.service.g.yxI.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1) });
    }
    AppMethodBeat.o(109219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2MainFragment
 * JD-Core Version:    0.7.0.1
 */