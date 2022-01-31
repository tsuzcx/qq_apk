package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.emoji.a.g;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.plugin.report.service.h;
import com.tencent.mm.sdk.platformtools.y;

public class b
  extends a
{
  private boolean jgX = false;
  
  public final int aIE()
  {
    return 5;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.a aIx()
  {
    return new g(getContext());
  }
  
  public final boolean aJy()
  {
    return true;
  }
  
  protected int getLayoutId()
  {
    return f.f.emoji_store_v2_main_fm;
  }
  
  public void onActivityCreated(Bundle paramBundle)
  {
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onActivityCreated");
    super.onActivityCreated(paramBundle);
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onAttach");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onCreateView");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onDestroy");
  }
  
  public void onPause()
  {
    super.onPause();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onResume");
  }
  
  public void onStart()
  {
    super.onStart();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    y.d("MicroMsg.emoji.EmojiStoreV2MainFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((!this.jgX) && (paramBoolean))
    {
      this.jgX = true;
      h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(1), Integer.valueOf(1) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes2.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.b
 * JD-Core Version:    0.7.0.1
 */