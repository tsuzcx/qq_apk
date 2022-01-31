package com.tencent.mm.plugin.emoji.ui.v2;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.emoji.f.f;
import com.tencent.mm.sdk.platformtools.y;

public class c
  extends a
{
  private boolean jgX = false;
  
  public final int aIE()
  {
    return 9;
  }
  
  public final com.tencent.mm.plugin.emoji.a.a.a aIx()
  {
    return new com.tencent.mm.plugin.emoji.a.h(getContext());
  }
  
  public final boolean aJy()
  {
    return false;
  }
  
  protected int getLayoutId()
  {
    return f.f.emoji_store_v2_person_fm;
  }
  
  public void onAttach(Activity paramActivity)
  {
    super.onAttach(paramActivity);
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onAttach");
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreate");
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onCreateView");
    return super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
  }
  
  public void onDestroyView()
  {
    super.onDestroyView();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
  }
  
  public void onDetach()
  {
    super.onDetach();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onDestroy");
  }
  
  public void onPause()
  {
    super.onPause();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onPause");
  }
  
  public void onResume()
  {
    super.onResume();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onResume");
    if (this.jga != null) {
      this.jga.aJA();
    }
  }
  
  public void onStart()
  {
    super.onStart();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStart");
  }
  
  public void onStop()
  {
    super.onStop();
    y.d("MicroMsg.emoji.EmojiStoreV2PersonFragment", "onStop");
  }
  
  public void setUserVisibleHint(boolean paramBoolean)
  {
    super.setUserVisibleHint(paramBoolean);
    if ((!this.jgX) && (paramBoolean))
    {
      this.jgX = true;
      com.tencent.mm.plugin.report.service.h.nFQ.f(12740, new Object[] { Integer.valueOf(4), "", "", "", Integer.valueOf(2), Integer.valueOf(2) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.emoji.ui.v2.c
 * JD-Core Version:    0.7.0.1
 */