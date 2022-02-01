package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.f.b.a.ba;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.a.f;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.plugin.emoji.i.f;
import com.tencent.mm.plugin.emoji.model.j;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.protocal.protobuf.akh;
import com.tencent.mm.sdk.platformtools.Log;

public class EmojiStoreV2MainFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean uNX = false;
  private g uNY;
  
  public final int cVA()
  {
    return 5;
  }
  
  public final a cVt()
  {
    AppMethodBeat.i(109218);
    this.uNY = new g(getContext());
    g localg = this.uNY;
    AppMethodBeat.o(109218);
    return localg;
  }
  
  protected final void cWB()
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
        if (!j.cUG().uEr) {
          break label289;
        }
        i = 1;
        StringBuilder localStringBuilder1 = new StringBuilder();
        StringBuilder localStringBuilder2 = new StringBuilder();
        StringBuilder localStringBuilder3 = new StringBuilder();
        if (j < n)
        {
          Object localObject = this.uNY.Jv(j);
          m = k;
          if (localObject != null)
          {
            localObject = ((f)localObject).uBa;
            m = k;
            if (localObject != null)
            {
              if (k == 0)
              {
                localStringBuilder1.append("#");
                localStringBuilder2.append("#");
                localStringBuilder3.append("#");
              }
              localStringBuilder1.append(((akh)localObject).ProductID);
              if (i != 0)
              {
                localObject = ((akh)localObject).VHR;
                localStringBuilder2.append((String)localObject);
                localStringBuilder3.append(j + 1);
                m = 0;
              }
              else
              {
                localObject = ((akh)localObject).VHP;
                continue;
              }
            }
          }
        }
        else
        {
          this.uES.gly = 1;
          this.uES.jy(localStringBuilder1.toString());
          this.uES.jz(localStringBuilder2.toString());
          this.uES.jA(localStringBuilder3.toString());
          this.uES.bpa();
          AppMethodBeat.o(109210);
          return;
        }
      }
      catch (Exception localException)
      {
        Log.printErrStackTrace("MicroMsg.emoji.EmojiStoreV2MainFragment", localException, "", new Object[0]);
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
  
  public final boolean cWG()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return i.f.emoji_store_v2_main_fm;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(109209);
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    AppMethodBeat.o(109209);
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(109206);
    super.onAttach(paramActivity);
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    AppMethodBeat.o(109206);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(109207);
    super.onCreate(paramBundle);
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    this.uES.glx = 1;
    AppMethodBeat.o(109207);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(109208);
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(109208);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(109216);
    super.onDestroy();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(109216);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(109215);
    super.onDestroyView();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(109215);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(109217);
    super.onDetach();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(109217);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(109213);
    super.onPause();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    AppMethodBeat.o(109213);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(109212);
    super.onResume();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(109212);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(109211);
    super.onStart();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    AppMethodBeat.o(109211);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(109214);
    super.onStop();
    Log.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    AppMethodBeat.o(109214);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(109219);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.uNX) && (paramBoolean))
    {
      this.uNX = true;
      h.IzE.a(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1) });
    }
    AppMethodBeat.o(109219);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes6.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2MainFragment
 * JD-Core Version:    0.7.0.1
 */