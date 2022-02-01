package com.tencent.mm.plugin.game.media;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.matrix.trace.core.AppMethodBeat;
import com.tencent.mm.sdk.platformtools.Log;

public class GameGalleryFragment
  extends Fragment
{
  View mView;
  private int xzP;
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    AppMethodBeat.i(40905);
    Log.i("MicroMsg.GameGalleryFragment", "onCreateView");
    if (this.mView != null)
    {
      paramLayoutInflater = this.mView;
      AppMethodBeat.o(40905);
      return paramLayoutInflater;
    }
    paramLayoutInflater = paramLayoutInflater.inflate(this.xzP, paramViewGroup);
    AppMethodBeat.o(40905);
    return paramLayoutInflater;
  }
  
  public void onViewCreated(View paramView, Bundle paramBundle)
  {
    AppMethodBeat.i(40906);
    Log.i("MicroMsg.GameGalleryFragment", "onViewCreated");
    AppMethodBeat.o(40906);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mm\classes3.jar
 * Qualified Name:     com.tencent.mm.plugin.game.media.GameGalleryFragment
 * JD-Core Version:    0.7.0.1
 */