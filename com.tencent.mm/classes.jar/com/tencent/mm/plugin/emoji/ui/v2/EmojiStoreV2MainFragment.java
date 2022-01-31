package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.plugin.emoji.a.a.a;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.ab;

public class EmojiStoreV2MainFragment
  extends EmojiStoreV2BaseFragment
{
  private boolean lpQ = false;
  
  public final a blU()
  {
    AppMethodBeat.i(53651);
    g localg = new g(getContext());
    AppMethodBeat.o(53651);
    return localg;
  }
  
  public final int bmb()
  {
    return 5;
  }
  
  public final boolean bnh()
  {
    return true;
  }
  
  public int getLayoutId()
  {
    return 2130969399;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    AppMethodBeat.i(53643);
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
    AppMethodBeat.o(53643);
  }
  
  public void onAttach(Activity paramActivity)
  {
    AppMethodBeat.i(53640);
    super.onAttach(paramActivity);
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
    AppMethodBeat.o(53640);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    AppMethodBeat.i(53641);
    super.onCreate(paramBundle);
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
    AppMethodBeat.o(53641);
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(53642);
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
    paramLayoutInflater = super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    AppMethodBeat.o(53642);
    return paramLayoutInflater;
  }
  
  public void onDestroy()
  {
    AppMethodBeat.i(53649);
    super.onDestroy();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(53649);
  }
  
  public void onDestroyView()
  {
    AppMethodBeat.i(53648);
    super.onDestroyView();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(53648);
  }
  
  public void onDetach()
  {
    AppMethodBeat.i(53650);
    super.onDetach();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
    AppMethodBeat.o(53650);
  }
  
  public void onPause()
  {
    AppMethodBeat.i(53646);
    super.onPause();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
    AppMethodBeat.o(53646);
  }
  
  public void onResume()
  {
    AppMethodBeat.i(53645);
    super.onResume();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
    AppMethodBeat.o(53645);
  }
  
  public void onStart()
  {
    AppMethodBeat.i(53644);
    super.onStart();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
    AppMethodBeat.o(53644);
  }
  
  public void onStop()
  {
    AppMethodBeat.i(53647);
    super.onStop();
    ab.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
    AppMethodBeat.o(53647);
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    AppMethodBeat.i(53652);
    super.setUserVisibleHint(paramBoolean);
    if ((!this.lpQ) && (paramBoolean))
    {
      this.lpQ = true;
      h.qsU.e(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1) });
    }
    AppMethodBeat.o(53652);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes4.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.EmojiStoreV2MainFragment
 * JD-Core Version:    0.7.0.1
 */